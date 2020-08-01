package cn.maxcj.bean;

import cn.maxcj.bean.base.BaseModel;

import java.util.Date;

/**
 * @author maxcj
 */
public class Role extends BaseModel {

    private Integer roleCode;

    private String roleName;

    private String desc;

    public Integer getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Integer roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
