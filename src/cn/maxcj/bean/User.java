package cn.maxcj.bean;

import cn.maxcj.bean.base.BaseModel;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author maxcj
 */
public class User extends BaseModel {

    private String name;

    private Integer sex;

    private Integer age;

    private String phone;

    private String email;

    private String password;

    private Integer status;

    private List<Integer> roleList = Collections.emptyList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Integer> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Integer> roleList) {
        this.roleList = roleList;
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @Override
    public Date getCreateTime() {
        return super.getCreateTime();
    }

    @Override
    public void setCreateTime(Date createTime) {
        super.setCreateTime(createTime);
    }

    @Override
    public String getCreateBy() {
        return super.getCreateBy();
    }

    @Override
    public void setCreateBy(String createBy) {
        super.setCreateBy(createBy);
    }

    @Override
    public Date getUpdateTime() {
        return super.getUpdateTime();
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        super.setUpdateTime(updateTime);
    }

    @Override
    public String getUpdateBy() {
        return super.getUpdateBy();
    }

    @Override
    public void setUpdateBy(String updateBy) {
        super.setUpdateBy(updateBy);
    }

    @Override
    public Integer getDeleted() {
        return super.getDeleted();
    }

    @Override
    public void setDeleted(Integer deleted) {
        super.setDeleted(deleted);
    }
}
