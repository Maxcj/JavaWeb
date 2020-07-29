package cn.maxcj.common;


/**
 * @author maxcj
 */

public enum SexEnum {

    male(1,"male"),
    female(2, "female");

    private Integer id;
    private String text;

    SexEnum(Integer id, String text) {
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
