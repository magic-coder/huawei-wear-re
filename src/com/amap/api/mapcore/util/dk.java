package com.amap.api.mapcore.util;

import java.net.Proxy;

/* compiled from: BaseNetManager */
public class dk {
    private static dk f11721a;

    public static dk m16059a() {
        if (f11721a == null) {
            f11721a = new dk();
        }
        return f11721a;
    }

    public byte[] m16061a(dp dpVar) throws bl {
        bl e;
        try {
            dr a = m16060a(dpVar, true);
            if (a != null) {
                return a.f11741a;
            }
            return null;
        } catch (bl e2) {
            throw e2;
        } catch (Throwable th) {
            e2 = new bl("未知的错误");
        }
    }

    public byte[] mo4043b(dp dpVar) throws bl {
        bl e;
        try {
            dr a = m16060a(dpVar, false);
            if (a != null) {
                return a.f11741a;
            }
            return null;
        } catch (bl e2) {
            throw e2;
        } catch (Throwable th) {
            cd.m15825a(th, "BaseNetManager", "makeSyncPostRequest");
            e2 = new bl("未知的错误");
        }
    }

    protected void m16063c(dp dpVar) throws bl {
        if (dpVar == null) {
            throw new bl("requeust is null");
        } else if (dpVar.mo4002a() == null || "".equals(dpVar.mo4002a())) {
            throw new bl("request url is empty");
        }
    }

    protected dr m16060a(dp dpVar, boolean z) throws bl {
        bl e;
        try {
            Proxy proxy;
            m16063c(dpVar);
            if (dpVar.f11413i == null) {
                proxy = null;
            } else {
                proxy = dpVar.f11413i;
            }
            return new dm(dpVar.f11411g, dpVar.f11412h, proxy, z).m16071a(dpVar.m15473f(), dpVar.mo4004c(), dpVar.m15474g());
        } catch (bl e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            e2 = new bl("未知的错误");
        }
    }
}
