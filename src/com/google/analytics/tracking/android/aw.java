package com.google.analytics.tracking.android;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.crowdtestsdk.utils.ResUtil;

/* compiled from: ParameterLoaderImpl */
class aw implements av {
    private final Context f14145a;
    private String f14146b;

    public aw(Context context) {
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        this.f14145a = context.getApplicationContext();
    }

    private int m18286a(String str, String str2) {
        if (this.f14145a == null) {
            return 0;
        }
        return this.f14145a.getResources().getIdentifier(str, str2, this.f14146b != null ? this.f14146b : this.f14145a.getPackageName());
    }

    public String mo4240a(String str) {
        int a = m18286a(str, ResUtil.TYPE_STRING);
        if (a == 0) {
            return null;
        }
        return this.f14145a.getString(a);
    }

    public boolean mo4242c(String str) {
        int a = m18286a(str, "bool");
        if (a == 0) {
            return false;
        }
        return "true".equalsIgnoreCase(this.f14145a.getString(a));
    }

    public int mo4239a(String str, int i) {
        int a = m18286a(str, "integer");
        if (a != 0) {
            try {
                i = Integer.parseInt(this.f14145a.getString(a));
            } catch (NumberFormatException e) {
                ar.m18269d("NumberFormatException parsing " + this.f14145a.getString(a));
            }
        }
        return i;
    }

    public Double mo4241b(String str) {
        Double d = null;
        String a = mo4240a(str);
        if (!TextUtils.isEmpty(a)) {
            try {
                d = Double.valueOf(Double.parseDouble(a));
            } catch (NumberFormatException e) {
                ar.m18269d("NumberFormatException parsing " + a);
            }
        }
        return d;
    }

    public void mo4243d(String str) {
        this.f14146b = str;
    }
}
