package cn.maxcj.common;


/**
 * @author maxcj
 */

public enum UserStatusEnum {

    NORMAL(1, "normal"),
    DELETED(2, "deleted");

    private Integer id;
    private String text;

    UserStatusEnum(Integer id, String text) {
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
