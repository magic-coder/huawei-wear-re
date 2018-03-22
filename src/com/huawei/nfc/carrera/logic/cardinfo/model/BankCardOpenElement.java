package com.huawei.nfc.carrera.logic.cardinfo.model;

public class BankCardOpenElement {
    private boolean mCVV2;
    private boolean mDate;
    private boolean mIDNum;
    private boolean mName;
    private boolean mPhone;
    private boolean mPwd;

    public BankCardOpenElement(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mName = z;
        this.mIDNum = z2;
        this.mPwd = z3;
        this.mDate = z4;
        this.mCVV2 = z5;
        this.mPhone = z6;
    }

    public boolean needName() {
        return this.mName;
    }

    public boolean needIDNum() {
        return this.mIDNum;
    }

    public boolean needPwd() {
        return this.mPwd;
    }

    public boolean needDate() {
        return this.mDate;
    }

    public boolean needCVV2() {
        return this.mCVV2;
    }

    public boolean needPhone() {
        return this.mPhone;
    }
}
