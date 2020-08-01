package cn.maxcj.core;

import java.util.Objects;

/**
 * @author maxcj
 */
public class ResultData<T extends Object> {

    private Integer code;

    private String msg;

    private T data;

    public ResultData() {
    }

    public ResultData(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        if (Objects.nonNull(data)) {
            this.data = data;
        }
    }

    public ResultData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResultData success() {
        return ResultData.success("操作成功");
    }

    public static ResultData success(Object data) {
        return ResultData.success("操作成功", data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 返回内容
     * @return 成功消息
     */
    public static ResultData success(String msg) {
        return ResultData.success(msg, null);
    }

    /**
     * 返回成功消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 成功消息
     */
    public static ResultData success(String msg, Object data) {
        return new ResultData(Type.SUCCESS.value, msg, data);
    }

    public static ResultData error() {
        return ResultData.error("操作失败");
    }

    /**
     * 返回错误消息
     *
     * @param msg 返回内容
     * @return 警告消息
     */
    public static ResultData error(String msg) {
        return ResultData.error(msg, null);
    }

    /**
     * 返回错误消息
     *
     * @param msg  返回内容
     * @param data 数据对象
     * @return 警告消息
     */
    public static ResultData error(String msg, Object data) {
        return new ResultData(Type.ERROR.value, msg, data);
    }



    public enum Type {
        SUCCESS(000000),
        
        ERROR(999999);

        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }




}
