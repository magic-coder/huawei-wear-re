package com.fenda.hwbracelet.mode;

import com.fenda.hwbracelet.p262e.C3600c;
import com.fenda.hwbracelet.p262e.C3601d;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;

/* compiled from: AlarmDataList */
public class C3620c {
    public ArrayList<C3619b> f13874a = null;

    public C3620c(ArrayList<C3619b> arrayList) {
        this.f13874a = arrayList;
    }

    public byte[] m18151a() {
        if (this.f13874a == null) {
            this.f13874a = new ArrayList();
        }
        if (this.f13874a.size() <= 3) {
            return ((C3600c) C3601d.m18065a().m18070a(this.f13874a)).mo4217b();
        }
        C2538c.e("AlarmDataList", new Object[]{"Alarm number is more than default."});
        return null;
    }
}
