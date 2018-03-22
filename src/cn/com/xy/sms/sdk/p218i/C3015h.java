package cn.com.xy.sms.sdk.p218i;

import java.util.HashMap;
import java.util.Map;

public class C3015h {
    int f10176a;
    HashMap<String, String> f10177b;
    private Map f10178c;

    public C3015h(int i, String... strArr) {
        this.f10177b = null;
        this.f10178c = null;
        this.f10176a = i;
        if (strArr.length % 2 == 0 && strArr.length > 0) {
            this.f10177b = new HashMap();
            int length = strArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (!(strArr[i2 + 1] == null || strArr[i2 + 1].equals(""))) {
                    this.f10177b.put(strArr[i2], strArr[i2 + 1]);
                }
                i2 += 2;
            }
        }
    }

    public final Map m13540a() {
        return this.f10178c;
    }

    public final void m13541a(Map map) {
        this.f10178c = map;
    }
}
