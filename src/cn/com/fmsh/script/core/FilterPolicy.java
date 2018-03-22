package cn.com.fmsh.script.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FilterPolicy {
    private /* synthetic */ byte f9510a;
    private /* synthetic */ byte f9511b;
    private /* synthetic */ List<byte[]> f9512c = new ArrayList();

    public void addFilterData(byte[] bArr) {
        this.f9512c.add(bArr);
    }

    public byte getCla() {
        return this.f9510a;
    }

    public byte[][] getFilterDatas() {
        return (byte[][]) this.f9512c.toArray((byte[][]) Array.newInstance(Byte.TYPE, new int[]{0, 0}));
    }

    public byte getIns() {
        return this.f9511b;
    }

    public void setCla(byte b) {
        this.f9510a = b;
    }

    public void setIns(byte b) {
        this.f9511b = b;
    }
}
