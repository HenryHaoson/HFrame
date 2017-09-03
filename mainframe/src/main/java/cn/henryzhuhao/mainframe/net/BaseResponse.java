package cn.henryzhuhao.mainframe.net;

/**
 * Author : zhuhao
 * Date : 15/8/2017
 *
 * @Last Modified Time :15/8/2017
 * Description :
 */

public class BaseResponse <T>{
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static class DataBean {
    }
}
