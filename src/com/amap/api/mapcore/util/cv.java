package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;

/* compiled from: LogDBOperation */
public class cv {
    private co f11644a;

    public cv(Context context) {
        this.f11644a = new co(context, cu.m15942a());
    }

    private cw m15947a(int i) {
        switch (i) {
            case 0:
                return new cr();
            case 1:
                return new ct();
            case 2:
                return new cq();
            default:
                return null;
        }
    }

    public void m15953a(String str, int i) {
        try {
            m15950c(str, i);
        } catch (Throwable th) {
            ca.m15831a(th, "LogDB", "delLog");
            th.printStackTrace();
        }
    }

    public void m15955b(String str, int i) {
        try {
            m15950c(str, i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void m15950c(String str, int i) {
        this.f11644a.m15922a(cw.m15933a(str), m15947a(i));
    }

    public void m15952a(cx cxVar, int i) {
        try {
            cp a = m15947a(i);
            a.mo4031a(cxVar);
            this.f11644a.m15926b(cw.m15933a(cxVar.m15959b()), a);
        } catch (Throwable th) {
            ca.m15831a(th, "LogDB", "updateLogInfo");
            th.printStackTrace();
        }
    }

    public List<cx> m15951a(int i, int i2) {
        List<cx> list = null;
        try {
            cp a = m15947a(i2);
            list = this.f11644a.m15927c(cw.m15932a(i), a);
        } catch (Throwable th) {
            ca.m15831a(th, "LogDB", "ByState");
            th.printStackTrace();
        }
        return list;
    }

    public void m15954b(cx cxVar, int i) {
        try {
            cw a = m15947a(i);
            switch (i) {
                case 0:
                    m15948a(cxVar, a);
                    return;
                case 1:
                    m15949b(cxVar, a);
                    return;
                case 2:
                    m15949b(cxVar, a);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        th.printStackTrace();
    }

    private void m15948a(cx cxVar, cw cwVar) {
        cwVar.m15936a(cxVar);
        this.f11644a.m15919a((cp) cwVar);
    }

    private void m15949b(cx cxVar, cw cwVar) {
        String a = cw.m15933a(cxVar.m15959b());
        List b = this.f11644a.m15925b(a, cwVar, true);
        if (b == null || b.size() == 0) {
            cwVar.m15936a(cxVar);
            this.f11644a.m15921a((cp) cwVar, true);
            return;
        }
        cx cxVar2 = (cx) b.get(0);
        if (cxVar.m15956a() == 0) {
            cxVar2.m15960b(cxVar2.m15963d() + 1);
        } else {
            cxVar2.m15960b(0);
        }
        cwVar.m15936a(cxVar2);
        this.f11644a.m15926b(a, cwVar);
    }
}
