package com.huawei.coresleepresult.p381a;

import java.util.ArrayList;

/* compiled from: HiCoreSleepData */
public class C4359a {
    public ArrayList<C4362d> f16200a = new ArrayList();
    public ArrayList<C4360b> f16201b = new ArrayList();
    public ArrayList<C4361c> f16202c = new ArrayList();

    public void m20949a(ArrayList<C4362d> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                this.f16200a.add(i, arrayList.get(i));
            }
        }
    }

    public void m20951b(ArrayList<C4360b> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                this.f16201b.add(i, arrayList.get(i));
            }
        }
    }

    public void m20953c(ArrayList<C4361c> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                this.f16202c.add(i, arrayList.get(i));
            }
        }
    }

    public ArrayList<C4362d> m20948a() {
        return this.f16200a;
    }

    public ArrayList<C4360b> m20950b() {
        return this.f16201b;
    }

    public ArrayList<C4361c> m20952c() {
        return this.f16202c;
    }
}
