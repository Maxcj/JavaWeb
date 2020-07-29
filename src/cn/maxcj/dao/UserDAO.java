package cn.maxcj.dao;

import cn.maxcj.bean.User;
import cn.maxcj.util.DataBaseUtil;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author maxcj
 */
public class UserDAO {

    public boolean isExistEmail(String email) {
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from tb_user where email = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.closeJDBC(conn, pstmt, rs);
        }
        return false;
    }

    public void save(String email, String password) {
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql = "insert into tb_user(email, password)"
                + "values(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.closeJDBC(conn, pstmt, null);
        }

    }


    public int login(String email, String password) {
        int id = -1;
        String currentPassword = "";
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select id, password from tb_user where email = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);

            rs = pstmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
                currentPassword = rs.getString("password");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.closeJDBC(conn, pstmt, rs);
        }

        if (Objects.equals(id, -1)) {

        }


        return id;
    }

    public int isExistResume(int applicantID) {
        int resumeID = 0;
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select basicinfo_id from tb_resume_basicinfo where applicant_id = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, applicantID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                resumeID = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.closeJDBC(conn, pstmt, rs);
        }
        return resumeID;
    }

    public List<User> selectAll() {
        List<User> list = new ArrayList<User>();
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * "
                + "from tb_user,tb_resume_basicinfo where tb_resume_basicinfo.applicant_id = tb_user.applicant_id";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                //user.setId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setName(rs.getString("name"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.closeJDBC(conn, pstmt, rs);
        }
        return null;
    }

    public List<User> selectById(int applicantID) {
        List<User> list = new ArrayList<User>();
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from tb_user,tb_resume_basicinfo where tb_resume_basicinfo.applicant_id = tb_user.applicant_id and tb_user.applicant_id=?";
        try {
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, applicantID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                //user.setId(rs.getInt(1));
                user.setEmail(rs.getString(2));
                user.setName(rs.getString("name"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.closeJDBC(conn, pstmt, null);
        }
        return null;
    }

    public int delete(int applicantID) {
        Connection conn = DataBaseUtil.getConnection();
        PreparedStatement pstmt = null;
        int rs = 0;
        String sql = "delete from tb_user where applicant_id=?";
        try {
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, applicantID);
            rs = pstmt.executeUpdate();
            conn.commit();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.closeJDBC(conn, pstmt, null);
        }
        return 0;
    }

}
