package com.huawei.nfc.carrera.logic.spi.fm.request;

public class MoveOrDeleteAppRequest extends FMBaseRequest {
    private byte[] manageCode;
    private String module;
    private byte[] seid;

    public interface MoveOrDeleteAppRequestSAI1 {
    }

    public interface MoveOrDeleteAppRequestSAI2 {
    }

    public interface MoveOrDeleteAppRequestSAI3 {
    }

    public interface MoveOrDeleteAppRequestSAI4 {
    }

    public interface MoveOrDeleteAppRequestSAI5 {
    }

    public void setManageCode(byte[] bArr) {
        this.manageCode = bArr;
    }

    public void setSeid(byte[] bArr) {
        this.seid = bArr;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public byte[] getManageCode() {
        return this.manageCode;
    }

    public byte[] getSeid() {
        return this.seid;
    }

    public String getModule() {
        return this.module;
    }

    public static MoveOrDeleteAppRequest build(byte[] bArr, byte[] bArr2, String str) {
        MoveOrDeleteAppRequest moveOrDeleteAppRequest = new MoveOrDeleteAppRequest();
        moveOrDeleteAppRequest.manageCode = bArr;
        moveOrDeleteAppRequest.seid = bArr2;
        moveOrDeleteAppRequest.module = str;
        return moveOrDeleteAppRequest;
    }
}
