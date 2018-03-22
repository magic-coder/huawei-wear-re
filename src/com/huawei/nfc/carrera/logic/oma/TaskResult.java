package com.huawei.nfc.carrera.logic.oma;

import com.huawei.nfc.carrera.logic.oma.model.ApduCommand;

public class TaskResult<T> {
    private T data;
    private ApduCommand lastExcutedCommand;
    private String msg;
    private int resultCode = 0;

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public ApduCommand getLastExcutedCommand() {
        return this.lastExcutedCommand;
    }

    public void setLastExcutedCommand(ApduCommand apduCommand) {
        this.lastExcutedCommand = apduCommand;
    }

    public String getPrintMsg() {
        return " resultCode : " + this.resultCode + " msg : " + this.msg;
    }
}
