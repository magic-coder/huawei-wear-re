package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.internal.br;
import com.google.android.gms.internal.zzabh;
import com.google.android.gms.wearable.C0520b;
import com.google.android.gms.wearable.C0521h;
import com.google.android.gms.wearable.C0522l;
import com.google.android.gms.wearable.C0523u;
import com.google.android.gms.wearable.aa;
import java.util.List;

public class cl<T> extends aq {
    private zzabh<Object> f1002a;
    private zzabh<Object> f1003b;
    private zzabh<C0522l> f1004c;
    private zzabh<C0523u> f1005d;
    private zzabh<aa> f1006e;
    private zzabh<Object> f1007f;
    private zzabh<C0521h> f1008g;
    private zzabh<C0520b> f1009h;
    private final IntentFilter[] f1010i;
    private final String f1011j;

    private cl(IntentFilter[] intentFilterArr, String str) {
        this.f1010i = (IntentFilter[]) C0424f.m649a((Object) intentFilterArr);
        this.f1011j = str;
    }

    public static cl<C0521h> m2050a(zzabh<C0521h> com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_h, String str, IntentFilter[] intentFilterArr) {
        cl<C0521h> clVar = new cl(intentFilterArr, (String) C0424f.m649a((Object) str));
        clVar.f1008g = (zzabh) C0424f.m649a((Object) com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_h);
        return clVar;
    }

    public static cl<aa> m2051a(zzabh<aa> com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_aa, IntentFilter[] intentFilterArr) {
        cl<aa> clVar = new cl(intentFilterArr, null);
        clVar.f1006e = (zzabh) C0424f.m649a((Object) com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_aa);
        return clVar;
    }

    private static void m2052a(zzabh<?> com_google_android_gms_internal_zzabh_) {
        if (com_google_android_gms_internal_zzabh_ != null) {
            com_google_android_gms_internal_zzabh_.m1636a();
        }
    }

    private static br<C0522l> m2053b(DataHolder dataHolder) {
        return new cm(dataHolder);
    }

    private static br<C0523u> m2054b(zzbz com_google_android_gms_wearable_internal_zzbz) {
        return new cn(com_google_android_gms_wearable_internal_zzbz);
    }

    private static br<C0520b> m2055b(zzo com_google_android_gms_wearable_internal_zzo) {
        return new cr(com_google_android_gms_wearable_internal_zzo);
    }

    private static br<C0521h> m2056b(zzs com_google_android_gms_wearable_internal_zzs) {
        return new cq(com_google_android_gms_wearable_internal_zzs);
    }

    public static cl<C0521h> m2057b(zzabh<C0521h> com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_h, IntentFilter[] intentFilterArr) {
        cl<C0521h> clVar = new cl(intentFilterArr, null);
        clVar.f1008g = (zzabh) C0424f.m649a((Object) com_google_android_gms_internal_zzabh_com_google_android_gms_wearable_h);
        return clVar;
    }

    private static br<aa> m2058c(zzcc com_google_android_gms_wearable_internal_zzcc) {
        return new co(com_google_android_gms_wearable_internal_zzcc);
    }

    private static br<aa> m2059d(zzcc com_google_android_gms_wearable_internal_zzcc) {
        return new cp(com_google_android_gms_wearable_internal_zzcc);
    }

    public void m2060a() {
        m2052a(null);
        this.f1002a = null;
        m2052a(null);
        this.f1003b = null;
        m2052a(this.f1004c);
        this.f1004c = null;
        m2052a(this.f1005d);
        this.f1005d = null;
        m2052a(this.f1006e);
        this.f1006e = null;
        m2052a(null);
        this.f1007f = null;
        m2052a(this.f1008g);
        this.f1008g = null;
        m2052a(this.f1009h);
        this.f1009h = null;
    }

    public void mo1914a(DataHolder dataHolder) {
        if (this.f1004c != null) {
            this.f1004c.m1637a(m2053b(dataHolder));
        } else {
            dataHolder.close();
        }
    }

    public void mo1915a(zzbz com_google_android_gms_wearable_internal_zzbz) {
        if (this.f1005d != null) {
            this.f1005d.m1637a(m2054b(com_google_android_gms_wearable_internal_zzbz));
        }
    }

    public void mo1916a(zzcc com_google_android_gms_wearable_internal_zzcc) {
        if (this.f1006e != null) {
            this.f1006e.m1637a(m2058c(com_google_android_gms_wearable_internal_zzcc));
        }
    }

    public void mo1917a(zzh com_google_android_gms_wearable_internal_zzh) {
    }

    public void mo1918a(zzk com_google_android_gms_wearable_internal_zzk) {
    }

    public void mo1919a(zzo com_google_android_gms_wearable_internal_zzo) {
        if (this.f1009h != null) {
            this.f1009h.m1637a(m2055b(com_google_android_gms_wearable_internal_zzo));
        }
    }

    public void mo1920a(zzs com_google_android_gms_wearable_internal_zzs) {
        if (this.f1008g != null) {
            this.f1008g.m1637a(m2056b(com_google_android_gms_wearable_internal_zzs));
        }
    }

    public void mo1921a(List<zzcc> list) {
    }

    public void mo1922b(zzcc com_google_android_gms_wearable_internal_zzcc) {
        if (this.f1006e != null) {
            this.f1006e.m1637a(m2059d(com_google_android_gms_wearable_internal_zzcc));
        }
    }

    public IntentFilter[] m2070b() {
        return this.f1010i;
    }

    public String m2071c() {
        return this.f1011j;
    }
}
