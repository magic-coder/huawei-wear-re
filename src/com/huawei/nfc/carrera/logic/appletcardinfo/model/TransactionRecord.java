package com.huawei.nfc.carrera.logic.appletcardinfo.model;

import com.huawei.nfc.carrera.util.MoneyUtil;

public class TransactionRecord {
    public static final String RECORD_TYPE_CONSUME = "2";
    public static final String RECORD_TYPE_RECHARGE = "1";
    private int recordAmount;
    private String recordTime;
    private String recordType;

    public String getRecordTime() {
        return this.recordTime;
    }

    public void setRecordTime(String str) {
        this.recordTime = str;
    }

    public void setRecordAmount(int i) {
        this.recordAmount = i;
    }

    public int getRecordAmount() {
        return this.recordAmount;
    }

    public String getRecordType() {
        return this.recordType;
    }

    public void setRecordType(String str) {
        this.recordType = str;
    }

    public String getAmountByYuanUint() {
        return MoneyUtil.convertFenToYuan((long) this.recordAmount);
    }
}
