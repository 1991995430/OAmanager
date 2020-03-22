package com.offcn.pojo.pojopv;

import java.util.List;

/**
 * @author songmu
 * @create 2019-06-19-16:03
 */
public class Msg<T> {
    public Msg() {
        msgCode=200;
        msg="操作正确";
    }
    //返回编码
    private int msgCode;
    //信息
    private String msg;
    //数据
    private List<T> list;

    public void setMsgCode(int msgCode) {
        this.msgCode = msgCode;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getMsgCode() {
        return msgCode;
    }

    public String getMsg() {
        return msg;
    }

    public List<T> getList() {
        return list;
    }
}
