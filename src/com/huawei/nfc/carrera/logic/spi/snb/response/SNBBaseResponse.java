package com.huawei.nfc.carrera.logic.spi.snb.response;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class SNBBaseResponse {
    protected int returnCd;

    public interface SNBBaseResponseSAI1 {
    }

    public interface SNBBaseResponseSAI2 {
    }

    public interface SNBBaseResponseSAI3 {
    }

    public interface SNBBaseResponseSAI4 {
    }

    public interface SNBBaseResponseSAI5 {
    }

    public interface SNBBaseResponseSAI6 {
    }

    public interface SNBBaseResponseSAI7 {
    }

    public int getReturnCd() {
        return ((Integer) C0978h.a(Integer.valueOf(this.returnCd))).intValue();
    }

    public void setReturnCd(int i) {
        this.returnCd = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }
}
