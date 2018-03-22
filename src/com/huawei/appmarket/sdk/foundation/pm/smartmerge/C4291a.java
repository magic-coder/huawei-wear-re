package com.huawei.appmarket.sdk.foundation.pm.smartmerge;

import com.huawei.appmarket.sdk.foundation.p367e.C4282b;
import com.huawei.appmarket.sdk.foundation.pm.smartmerge.jni.AppPatch;
import java.io.File;

public class C4291a {
    private String f15972a;
    private String f15973b;
    private String f15974c;
    private int f15975d = 0;
    private String f15976e;
    private String f15977f;

    public C4291a(String str, String str2, String str3) {
        this.f15972a = str;
        this.f15973b = str2;
        this.f15974c = str3;
    }

    public int m20699a() {
        return this.f15975d;
    }

    public int m20700a(String str, String str2) {
        this.f15976e = C4282b.m20661a(this.f15972a);
        if (this.f15976e == null || !this.f15976e.equals(this.f15973b)) {
            return 2;
        }
        this.f15975d = AppPatch.m20703a().m20707a(str, str2, this.f15972a);
        if (this.f15975d != 0) {
            return 1;
        }
        this.f15977f = C4282b.m20660a(new File(str2));
        return (this.f15977f == null || !this.f15977f.equals(this.f15974c)) ? 3 : 0;
    }

    public String m20701b() {
        return this.f15976e;
    }

    public String m20702c() {
        return this.f15977f;
    }
}
