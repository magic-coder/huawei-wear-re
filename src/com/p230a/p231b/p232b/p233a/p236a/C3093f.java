package com.p230a.p231b.p232b.p233a.p236a;

import com.p230a.p231b.p232b.p233a.C3104c;
import com.p230a.p231b.p232b.p233a.C3112j;
import com.snowballtech.common.code.WSBaseMessageCode;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class C3093f {
    public static long m13829a(String str) {
        try {
            return DateUtils.parseDate(str).getTime();
        } catch (DateParseException e) {
            return 0;
        }
    }

    public static C3104c m13830a(C3112j c3112j) {
        long j = 0;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = c3112j.f10434c;
        String str = (String) map.get(WSBaseMessageCode.HEADER_DATE);
        long a = str != null ? C3093f.m13829a(str) : 0;
        str = (String) map.get("Expires");
        long a2 = str != null ? C3093f.m13829a(str) : 0;
        str = (String) map.get("ETag");
        if (a > 0 && a2 >= a) {
            j = (a2 - a) + currentTimeMillis;
        }
        C3104c c3104c = new C3104c();
        c3104c.f10410a = c3112j.f10433b;
        c3104c.f10411b = str;
        c3104c.f10414e = j;
        c3104c.f10413d = c3104c.f10414e;
        c3104c.f10412c = a;
        c3104c.f10415f = map;
        return c3104c;
    }
}
