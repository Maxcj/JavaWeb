package cn.maxcj.bean;

import cn.maxcj.bean.base.BaseModel;

import java.util.Date;

/**
 * @author maxcj
 */
public class UserRole extends BaseModel {

    private Integer roleId;

    private Integer UserId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
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
