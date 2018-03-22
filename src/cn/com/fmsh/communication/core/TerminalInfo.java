package cn.com.fmsh.communication.core;

public class TerminalInfo {
    private /* synthetic */ byte[] f9393a;
    private /* synthetic */ byte[] f9394b;
    private /* synthetic */ byte[] f9395c;
    private /* synthetic */ byte f9396d;
    private /* synthetic */ byte[] f9397e;
    private /* synthetic */ byte[] f9398f;
    private /* synthetic */ byte[] f9399g;

    public byte[] getAppend() {
        return this.f9395c;
    }

    public byte[] getExponent() {
        return this.f9398f;
    }

    public byte getKeyIndex() {
        return this.f9396d;
    }

    public byte[] getModulus() {
        return this.f9397e;
    }

    public byte[] getSecurityCode() {
        return this.f9394b;
    }

    public byte[] getTerminalNumber() {
        return this.f9399g;
    }

    public byte[] getTerminalType() {
        return this.f9393a;
    }

    public void setAppend(byte[] bArr) {
        this.f9395c = bArr;
    }

    public void setExponent(byte[] bArr) {
        this.f9398f = bArr;
    }

    public void setKeyIndex(byte b) {
        this.f9396d = b;
    }

    public void setModulus(byte[] bArr) {
        this.f9397e = bArr;
    }

    public void setSecurityCode(byte[] bArr) {
        this.f9394b = bArr;
    }

    public void setTerminalNumber(byte[] bArr) {
        this.f9399g = bArr;
    }

    public void setTerminalType(byte[] bArr) {
        this.f9393a = bArr;
    }
}
