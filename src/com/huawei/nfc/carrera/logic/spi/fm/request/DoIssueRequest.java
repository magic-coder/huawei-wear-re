package com.huawei.nfc.carrera.logic.spi.fm.request;

public class DoIssueRequest extends FMBaseRequest {
    public byte[] order;
    public byte[] seid;

    public static DoIssueRequest build(byte[] bArr, byte[] bArr2) {
        DoIssueRequest doIssueRequest = new DoIssueRequest();
        doIssueRequest.order = bArr;
        doIssueRequest.seid = bArr2;
        return doIssueRequest;
    }
}
