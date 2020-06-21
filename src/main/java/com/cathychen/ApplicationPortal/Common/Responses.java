package com.cathychen.ApplicationPortal.Common;

public class Responses {
    public static <T> Response<T> of (T data) {
        Response<T> response = new Response<T>();
        response.setCode(1);
        response.setMsg("success");
        response.setData(data);
        return response;
    }

    public static <T> Response<T> of(T data, String msg){
        Response<T> response = of(data);
        response.setMsg(msg);
        return response;
    }

    public static <T> Response<T> fail(int code, String msg) {
        if (code == 1) throw new IllegalArgumentException("Invalid code.");
        if (msg != null && "success".equals(msg)) throw new IllegalArgumentException("Invalid msg.");
        Response<T> response = new Response<T>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
