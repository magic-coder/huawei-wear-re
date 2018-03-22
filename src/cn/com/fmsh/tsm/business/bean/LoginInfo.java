package cn.com.fmsh.tsm.business.bean;

public class LoginInfo {
    /* synthetic */ int f9609a;
    /* synthetic */ int f9610b;
    /* synthetic */ int f9611c;
    /* synthetic */ byte[] f9612d;

    public int getFailureNum() {
        return this.f9610b;
    }

    public byte[] getPatchData() {
        return this.f9612d;
    }

    public int getResult() {
        return this.f9609a;
    }

    public int getUserLockTime() {
        return this.f9611c;
    }

    public void setFailureNum(int i) {
        this.f9610b = i;
    }

    public void setPatchData(byte[] bArr) {
        this.f9612d = bArr;
    }

    public void setResult(int i) {
        this.f9609a = i;
    }

    public void setUserLockTime(int i) {
        this.f9611c = i;
    }
}
