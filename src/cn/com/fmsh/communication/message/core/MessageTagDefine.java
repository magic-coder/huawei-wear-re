package cn.com.fmsh.communication.message.core;

public class MessageTagDefine {
    private /* synthetic */ byte f9449a;
    private /* synthetic */ int f9450b;
    private /* synthetic */ int f9451c;
    private /* synthetic */ int f9452d;

    public int getExist() {
        return this.f9452d;
    }

    public int getMultiple() {
        return this.f9451c;
    }

    public int getOrder() {
        return this.f9450b;
    }

    public byte getTag() {
        return this.f9449a;
    }

    public void setExist(int i) {
        this.f9452d = i;
    }

    public void setMultiple(int i) {
        this.f9451c = i;
    }

    public void setOrder(int i) {
        this.f9450b = i;
    }

    public void setTag(byte b) {
        this.f9449a = b;
    }
}
