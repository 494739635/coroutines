package com.sample.jetpack.retrofit.enity;

import com.alibaba.fastjson.annotation.JSONField;

public class CommonResult<T> {

    @JSONField(name = "msg")
    private String msg;

    @JSONField(name = "code")
    private int code;

    @JSONField(name = "data")
    private T data;

    /**
     * 扩展字段,不参与json解析
     */
    private transient ExtraInfo extraInfo;

    public ExtraInfo getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(ExtraInfo extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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

}
