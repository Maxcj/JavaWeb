package cn.maxcj.bean;

import cn.maxcj.bean.base.BaseModel;
import lombok.Data;

/**
 * @author maxcj
 */
@Data
public class User extends BaseModel {

    private String name;

    private Integer sex;

    private Integer age;

    private String phone;

    private String email;

    private String password;

    private Integer status;

}
