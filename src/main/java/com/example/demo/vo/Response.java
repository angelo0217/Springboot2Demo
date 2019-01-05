package com.example.demo.vo;

import com.example.demo.domain.UserInfo;

/**
 * Created on 2019/1/5
 *
 * @author dean
 * @email loveangelo0217@gmail.com
 * @since 1.0
 */
public class Response<T> {
    public Response(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    private String msg = "success";
    private int code = 0;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
