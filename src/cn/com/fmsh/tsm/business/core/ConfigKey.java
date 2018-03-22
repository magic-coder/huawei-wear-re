package cn.com.fmsh.tsm.business.core;

public class ConfigKey {
    private /* synthetic */ int f9756a = 0;
    private /* synthetic */ byte[] f9757b;
    private /* synthetic */ byte[] f9758c;

    public int getIndex() {
        return this.f9756a;
    }

    public byte[] getPrivateKey() {
        return this.f9758c;
    }

    public byte[] getPublicKey() {
        return this.f9757b;
    }

    public void setIndex(int i) {
        this.f9756a = i;
    }

    public void setPrivateKey(byte[] bArr) {
        this.f9758c = bArr;
    }

    public void setPublicKey(byte[] bArr) {
        this.f9757b = bArr;
    }
}
