package com.huawei.nfc.carrera.logic.cardoperate.bus.model;

public class RecordInfo {
    public static final int STATUS_OTHER = 3;
    public static final int STATUS_REFUND = 2;
    public static final int STATUS_REFUNDING = 1;
    public static final int STATUS_SUCCESS = 0;
    public static final int TYPE_CONSUME = 11;
    public static final int TYPE_RECHARGE = 10;
    private String recordAmount;
    private int recordStatus;
    private String recordTime;
    private int recordType;

    public interface RecordInfoSSAI1 {
    }

    public interface RecordInfoSSAI2 {
    }

    public interface RecordInfoSSAI3 {
    }

    public interface RecordInfoSSAI4 {
    }

    public RecordInfo(int i, int i2, String str, String str2) {
        this.recordType = i;
        this.recordStatus = i2;
        this.recordTime = str;
        this.recordAmount = str2;
    }

    public int getRecordType() {
        return this.recordType;
    }

    public int getRecordStatus() {
        return this.recordStatus;
    }

    public String getRecordTime() {
        return this.recordTime;
    }

    public String getRecordAmount() {
        return this.recordAmount;
    }

    public void setRecordType(int i) {
        this.recordType = i;
    }

    public void setRecordStatus(int i) {
        this.recordStatus = i;
    }

    public void setRecordTime(String str) {
        this.recordTime = str;
    }

    public void setRecordAmount(String str) {
        this.recordAmount = str;
    }
}
