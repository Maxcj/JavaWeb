package cn.maxcj.common;

/**
 * @author maxcj
 */
public enum RoleEnum {

    common(1,"common user"),
    admin(99, "admin");

    private Integer id;
    private String text;

    RoleEnum(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
