package cn.com.fmsh.tsm.business;

import cn.com.fmsh.tsm.business.core.BusinessManagerImpl;

public class BusinessManagerFactory {
    private static /* synthetic */ BusinessManager f9525a;

    private static synchronized /* synthetic */ void m13021a() {
        synchronized (BusinessManagerFactory.class) {
            if (f9525a == null) {
                f9525a = new BusinessManagerImpl();
            }
        }
    }

    public static BusinessManager getBusinessManager() {
        if (f9525a == null) {
            m13021a();
        }
        return f9525a;
    }
}
