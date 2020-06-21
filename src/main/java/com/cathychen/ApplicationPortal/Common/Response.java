package com.cathychen.ApplicationPortal.Common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {
    private static final long responseID = 1L;
    /*
    1 -> success;
    0 -> fail;
     */
    private int code;
    private String msg;
    private T data;

    public boolean isSuccess(){return this.getCode() == 1;}

}
