package cn.com.fmsh.tsm.business.bean;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private static final /* synthetic */ long serialVersionUID = 1;
    /* synthetic */ String f9676a = null;
    /* synthetic */ String f9677b = null;
    /* synthetic */ int f9678c = -1;
    /* synthetic */ String f9679d = null;
    /* synthetic */ String f9680e = null;
    /* synthetic */ String f9681f = null;
    /* synthetic */ int f9682g = -1;
    /* synthetic */ String f9683h = null;
    /* synthetic */ byte[] f9684i = null;
    /* synthetic */ String f9685j = null;

    public String getCertNo() {
        return this.f9683h;
    }

    public int getCertType() {
        return this.f9682g;
    }

    public String getMail() {
        return this.f9679d;
    }

    public String getPassword() {
        return this.f9677b;
    }

    public String getPhone() {
        return this.f9680e;
    }

    public String getRealName() {
        return this.f9681f;
    }

    public String getUserName() {
        return this.f9676a;
    }

    public int getUserType() {
        return this.f9678c;
    }

    public String getVerificationCode() {
        return this.f9685j;
    }

    public byte[] getVerificationCodeNo() {
        return this.f9684i;
    }

    public void setCertNo(String str) {
        this.f9683h = str;
    }

    public void setCertType(int i) {
        this.f9682g = i;
    }

    public void setMail(String str) {
        this.f9679d = str;
    }

    public void setPassword(String str) {
        this.f9677b = str;
    }

    public void setPhone(String str) {
        this.f9680e = str;
    }

    public void setRealName(String str) {
        this.f9681f = str;
    }

    public void setUserName(String str) {
        this.f9676a = str;
    }

    public void setUserType(int i) {
        this.f9678c = i;
    }

    public void setVerificationCode(String str) {
        this.f9685j = str;
    }

    public void setVerificationCodeNo(byte[] bArr) {
        this.f9684i = bArr;
    }
}
