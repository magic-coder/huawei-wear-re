package com.huawei.openalliance.ad.p112a.p113a.p115b;

import android.content.Context;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1211a;
import com.huawei.openalliance.ad.p112a.p122h.C1283a;
import com.huawei.openalliance.ad.p112a.p122h.C1289h;
import java.util.ArrayList;
import java.util.List;

public class C1228n extends C1211a {
    private List<C1220f> cellInfo__ = new ArrayList(4);
    private int type__ = 0;
    private List<C1234t> wifiInfo__ = new ArrayList(4);

    public C1228n(Context context) {
        this.type__ = C1283a.m5645a(context).m5658g();
        if (C1289h.m5695a(context).m5731p()) {
            C1220f h = C1283a.m5645a(context).m5659h();
            if (h != null) {
                this.cellInfo__.add(h);
            }
            C1234t i = C1283a.m5645a(context).m5660i();
            if (i != null) {
                this.wifiInfo__.add(i);
            }
        }
    }

    public List<C1220f> getCellInfo__() {
        return this.cellInfo__;
    }

    public int getType__() {
        return this.type__;
    }

    public List<C1234t> getWifiInfo__() {
        return this.wifiInfo__;
    }

    public void setCellInfo__(List<C1220f> list) {
        this.cellInfo__ = list;
    }

    public void setType__(int i) {
        this.type__ = i;
    }

    public void setWifiInfo__(List<C1234t> list) {
        this.wifiInfo__ = list;
    }
}
