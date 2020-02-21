package com.catdemo.demo.util;


public class RestResponse<T> {
    private Boolean success;
    private String message;
    private T datas;

    public RestResponse() {
    }

    public RestResponse(Boolean success, String message, T datas) {
        this.success = success;
        this.message = message;
        this.datas = datas;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }
}
