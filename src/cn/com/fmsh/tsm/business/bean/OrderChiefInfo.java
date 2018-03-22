package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;

public class OrderChiefInfo {
    private /* synthetic */ EnumOrderStatus f9628a;
    private /* synthetic */ int f9629b;
    private /* synthetic */ byte[] f9630c;
    private /* synthetic */ EnumBusinessOrderType f9631d;

    public int getAmount() {
        return this.f9629b;
    }

    public byte[] getOrder() {
        return this.f9630c;
    }

    public EnumOrderStatus getState() {
        return this.f9628a;
    }

    public EnumBusinessOrderType getType() {
        return this.f9631d;
    }

    public void setAmount(int i) {
        this.f9629b = i;
    }

    public void setOrder(byte[] bArr) {
        this.f9630c = bArr;
    }

    public void setState(EnumOrderStatus enumOrderStatus) {
        this.f9628a = enumOrderStatus;
    }

    public void setType(EnumBusinessOrderType enumBusinessOrderType) {
        this.f9631d = enumBusinessOrderType;
    }
}
