package cn.maxcj.bean.base;

import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {

    private Integer id;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private Integer deleted;

}
