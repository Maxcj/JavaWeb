package cn.maxcj.bean.system;

import java.util.Collections;
import java.util.List;

/**
 * @author maxcj
 */
public class RuntimeUser {

    private Integer id;

    private String email;

    private List<Integer> roleList;

    public RuntimeUser() {
        roleList = Collections.emptyList();
    }

    public RuntimeUser(Integer id, String email, List<Integer> roleList) {
        this.id = id;
        this.email = email;
        this.roleList = roleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Integer> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Integer> roleList) {
        this.roleList = roleList;
    }
}
