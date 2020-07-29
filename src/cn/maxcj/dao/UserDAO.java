package cn.maxcj.dao;

import cn.maxcj.bean.User;
import cn.maxcj.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author maxcj
 */
public class UserDAO {

    public boolean isExistEmail(String email) {
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from tb_applicant where applicant_email = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeJDBC(conn, pstmt, rs);
        }
        return false;
    }

    public void save(String email, String password) {
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into tb_applicant(applicant_email, applicant_pwd)"
                + "values(?,?)";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DataBaseUtil.closeJDBC(conn, pstmt, null);
        }

    }


    public int login(String email, String password) {
        int applicantID = 0;
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select applicant_id from tb_applicant where applicant_email = ? and applicant_pwd = ?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();
            if(rs.next()){
                applicantID = rs.getInt("applicant_id");
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DataBaseUtil.closeJDBC(conn, pstmt, rs);
        }

        if(applicantID == 0){
            Connection conn1 = DataBaseUtil.getConnection();
            PreparedStatement pstmt1 = null;
            ResultSet rs1 = null;
            String sql1 = "select applicant_id from tb_applicant where applicant_email = ?";
            try {
                pstmt1 = conn1.prepareStatement(sql1);
                pstmt1.setString(1, email);
                rs1 = pstmt1.executeQuery();

                if(rs1.next()){
                    applicantID = -1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DataBaseUtil.closeJDBC(conn1, pstmt1, rs1);
            }
        }
        //用户不存在 返回0 提示注册
        return applicantID;
    }

    public int isExistResume(int applicantID) {
        int resumeID = 0;
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select basicinfo_id from tb_resume_basicinfo where applicant_id = ?";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, applicantID);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                resumeID = rs.getInt(1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DataBaseUtil.closeJDBC(conn, pstmt, rs);
        }
        return resumeID;
    }

    public List<User> selectAll(){
        List<User> list = new ArrayList<User>();
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql="select * "
                + "from tb_applicant,tb_resume_basicinfo where tb_resume_basicinfo.applicant_id = tb_applicant.applicant_id";
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setName(rs.getString("name"));
                list.add(user);
            }
            return list;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DataBaseUtil.closeJDBC(conn, pstmt, rs);
        }
        return null;
    }

    public List<User> selectById(int applicantID) {
        List<User> list = new ArrayList<User>();
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        String sql="select * from tb_applicant,tb_resume_basicinfo where tb_resume_basicinfo.applicant_id = tb_applicant.applicant_id and tb_applicant.applicant_id=?";
        try{
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, applicantID);
            rs = pstmt.executeQuery();
            if(rs.next()){
                User user = new User();
                user.setId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setName(rs.getString("name"));
                list.add(user);
            }
            return list;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeJDBC(conn, pstmt, null);
        }
        return null;
    }

    public int delete(int applicantID){
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        int rs = 0;
        String sql="delete from tb_applicant where applicant_id=?";
        try{
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, applicantID);
            rs = pstmt.executeUpdate();
            conn.commit();
            return rs;
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DataBaseUtil.closeJDBC(conn, pstmt, null);
        }
        return 0;
    }
    
}
