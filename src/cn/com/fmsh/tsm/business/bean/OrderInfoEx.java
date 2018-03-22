package cn.com.fmsh.tsm.business.bean;

import java.util.ArrayList;
import java.util.List;

public class OrderInfoEx {
    private /* synthetic */ List<OrderChiefInfo> f9635a = new ArrayList();
    private /* synthetic */ String f9636b;

    public void AddOrderChiefInfo(OrderChiefInfo orderChiefInfo) {
        this.f9635a.add(orderChiefInfo);
    }

    public OrderChiefInfo[] getOrderChiefInfos() {
        return (OrderChiefInfo[]) this.f9635a.toArray(new OrderChiefInfo[0]);
    }

    public String getTn() {
        return this.f9636b;
    }

    public void setTn(String str) {
        this.f9636b = str;
    }
}
