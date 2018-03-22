package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.da;
import com.google.android.gms.p014a.C0340a;
import com.google.android.gms.p014a.C0343d;

@DynamiteApi
public class FlagProviderImpl extends da {
    private boolean f490a = false;
    private SharedPreferences f491b;

    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.f490a ? z : C0478b.m835a(this.f491b, str, Boolean.valueOf(z)).booleanValue();
    }

    public int getIntFlagValue(String str, int i, int i2) {
        return !this.f490a ? i : C0480d.m837a(this.f491b, str, Integer.valueOf(i)).intValue();
    }

    public long getLongFlagValue(String str, long j, int i) {
        return !this.f490a ? j : C0482f.m839a(this.f491b, str, Long.valueOf(j)).longValue();
    }

    public String getStringFlagValue(String str, String str2, int i) {
        return !this.f490a ? str2 : C0484h.m841a(this.f491b, str, str2);
    }

    public void init(C0340a c0340a) {
        Context context = (Context) C0343d.m277a(c0340a);
        if (!this.f490a) {
            try {
                this.f491b = C0486j.m843a(context.createPackageContext("com.google.android.gms", 0));
                this.f490a = true;
            } catch (NameNotFoundException e) {
            }
        }
    }
}
