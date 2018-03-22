package com.huawei.hwid.vermanager;

import android.content.Context;
import com.huawei.hwid.core.p435d.C5181l;
import org.apache.http.client.HttpClient;

/* compiled from: IHwVersionManager */
public abstract class C5310d {
    String f18993A = "";
    String f18994a = "";
    String f18995b = "";
    String f18996c = "";
    String f18997d = "";
    String f18998e = "";
    String f18999f = "";
    String f19000g = "";
    String f19001h = "";
    String f19002i = "";
    String f19003j = "";
    String f19004k = "";
    String f19005l = "";
    String f19006m = "";
    String f19007n = "";
    String f19008o = "";
    String f19009p = "";
    String f19010q = "";
    String f19011r = "";
    String f19012s = "";
    String f19013t = "";
    String f19014u = "";
    String f19015v = "";
    String f19016w = "";
    String f19017x = "";
    String f19018y = "";
    String f19019z = "";

    public abstract String mo4680a();

    public abstract String mo4681a(int i);

    public abstract HttpClient mo4682a(Context context, int i, int i2);

    public abstract String mo4683b();

    public abstract String mo4684b(int i);

    public abstract String mo4685c();

    public abstract String mo4686c(int i);

    public abstract String mo4687d();

    public String m25675a(int i, String str) {
        String str2 = "";
        if (i >= 1 && i <= 999) {
            str2 = String.valueOf(i);
        }
        return C5181l.m25036a(str, new String[]{"\\{0\\}", str2});
    }
}
