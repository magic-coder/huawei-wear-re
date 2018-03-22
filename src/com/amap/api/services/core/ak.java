package com.amap.api.services.core;

import android.content.Context;
import java.util.List;

/* compiled from: LogDBOperation */
public class ak {
    private ai f12347a;

    public ak(Context context) {
        this.f12347a = new ai(context);
    }

    private al m16647a(int i) {
        switch (i) {
            case 0:
                return new ag();
            case 1:
                return new aj();
            case 2:
                return new af();
            default:
                return null;
        }
    }

    public void m16653a(String str, int i) {
        try {
            m16650c(str, i);
        } catch (Throwable th) {
            ay.m16709a(th, "LogDB", "delLog");
            th.printStackTrace();
        }
    }

    public void m16655b(String str, int i) {
        try {
            m16650c(str, i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void m16650c(String str, int i) {
        this.f12347a.m16643a(al.m16632a(str), m16647a(i));
    }

    public void m16652a(am amVar, int i) {
        try {
            ap a = m16647a(i);
            a.mo4104a(amVar);
            this.f12347a.m16644b(al.m16632a(amVar.m16659b()), a);
        } catch (Throwable th) {
            ay.m16709a(th, "LogDB", "updateLogInfo");
            th.printStackTrace();
        }
    }

    public List<am> m16651a(int i, int i2) {
        List<am> list = null;
        try {
            ap a = m16647a(i2);
            list = this.f12347a.m16645c(al.m16631a(i), a);
        } catch (Throwable th) {
            ay.m16709a(th, "LogDB", "ByState");
            th.printStackTrace();
        }
        return list;
    }

    public void m16654b(am amVar, int i) {
        try {
            al a = m16647a(i);
            switch (i) {
                case 0:
                    m16648a(amVar, a);
                    return;
                case 1:
                    m16649b(amVar, a);
                    return;
                case 2:
                    m16649b(amVar, a);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        th.printStackTrace();
    }

    private void m16648a(am amVar, al alVar) {
        alVar.m16634a(amVar);
        this.f12347a.m16642a(alVar);
    }

    private void m16649b(am amVar, al alVar) {
        String a = al.m16632a(amVar.m16659b());
        List c = this.f12347a.m16645c(a, alVar);
        if (c == null || c.size() == 0) {
            alVar.m16634a(amVar);
            this.f12347a.m16642a(alVar);
            return;
        }
        am amVar2 = (am) c.get(0);
        if (amVar.m16656a() == 0) {
            amVar2.m16660b(amVar2.m16663d() + 1);
        } else {
            amVar2.m16660b(0);
        }
        alVar.m16634a(amVar2);
        this.f12347a.m16644b(a, alVar);
    }
}
