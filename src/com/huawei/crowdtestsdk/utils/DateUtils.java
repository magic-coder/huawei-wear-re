package com.huawei.crowdtestsdk.utils;

import com.huawei.uploadlog.p188c.C2511g;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class DateUtils {
    private static final Object lockObj = new Object();
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap();

    final class C07951 extends ThreadLocal<SimpleDateFormat> {
        final /* synthetic */ String val$pattern;

        C07951(String str) {
            this.val$pattern = str;
        }

        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(this.val$pattern);
        }
    }

    public static SimpleDateFormat getSimpleDateFormat(String str) {
        ThreadLocal threadLocal = (ThreadLocal) sdfMap.get(str);
        if (threadLocal == null) {
            synchronized (lockObj) {
                threadLocal = (ThreadLocal) sdfMap.get(str);
                if (threadLocal == null) {
                    C2511g.m12481b("BETACLUB_SDK", "[DateUtils.getSimpleDateFormat]put new sdf of pattern " + str + " to map");
                    threadLocal = new C07951(str);
                    sdfMap.put(str, threadLocal);
                }
            }
        }
        return (SimpleDateFormat) threadLocal.get();
    }
}
