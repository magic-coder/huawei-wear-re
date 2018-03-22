package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;

public class OrderInfo {
    private /* synthetic */ EnumOrderStatus f9632a;
    private /* synthetic */ byte[] f9633b;
    private /* synthetic */ String f9634c;

    public byte[] getOrder() {
        return this.f9633b;
    }

    public EnumOrderStatus getState() {
        return this.f9632a;
    }

    public String getTn() {
        return this.f9634c;
    }

    public void setOrder(byte[] bArr) {
        this.f9633b = bArr;
    }

    public void setState(EnumOrderStatus enumOrderStatus) {
        this.f9632a = enumOrderStatus;
    }

    public void setTn(String str) {
        this.f9634c = str;
    }
}
