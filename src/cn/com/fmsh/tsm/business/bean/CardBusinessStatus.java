package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.tsm.business.enums.EnumAppActivationStatus;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderStatus;

public class CardBusinessStatus {
    private /* synthetic */ EnumAppActivationStatus f9575a;
    private /* synthetic */ EnumBusinessOrderStatus f9576b;

    public EnumAppActivationStatus getActivationStatus() {
        return this.f9575a;
    }

    public EnumBusinessOrderStatus getBusinessOrderStatus() {
        return this.f9576b;
    }

    public void setActivationStatus(EnumAppActivationStatus enumAppActivationStatus) {
        this.f9575a = enumAppActivationStatus;
    }

    public void setBusinessOrderStatus(EnumBusinessOrderStatus enumBusinessOrderStatus) {
        this.f9576b = enumBusinessOrderStatus;
    }
}
