package com.huawei.membercenter.sdk.membersdklibrary.p092a.p093c;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.membercenter.sdk.membersdklibrary.a.d.a;
import com.huawei.membercenter.sdk.membersdklibrary.a.d.h;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.BundleKey;

/* compiled from: MemberStatusRequest */
public class C1113b {
    @SerializedName("uid")
    private String f2334a;
    @SerializedName("channel")
    private String f2335b;
    @SerializedName("cVer")
    private int f2336c = 20100300;
    @SerializedName("local")
    private String f2337d = h.d();
    @SerializedName("st")
    private String f2338e;
    @SerializedName("packageName")
    private String f2339f;
    @SerializedName("deviceID")
    private String f2340g;
    @SerializedName("deviceType")
    private String f2341h;
    @SerializedName("model")
    private String f2342i;
    @SerializedName("systemid")
    private String f2343j;
    @SerializedName("brand")
    private String f2344k;
    @SerializedName("ts")
    private long f2345l;
    @SerializedName("imeiEnc")
    private String f2346m;
    @SerializedName("eMMCID")
    private String f2347n;
    @SerializedName("deviceLevel")
    private String f2348o;
    @SerializedName("deviceID2")
    private String f2349p;
    @SerializedName("dataVersion")
    private int f2350q;
    @SerializedName("siteId")
    private String f2351r;

    public C1113b(Bundle bundle, Context context) {
        this.f2334a = bundle.getString("userID");
        this.f2335b = a.a(context);
        this.f2338e = bundle.getString(BundleKey.KEY_ST);
        String string = bundle.getString("packageName");
        if (TextUtils.isEmpty(string)) {
            string = context.getPackageName();
        }
        this.f2339f = string;
        this.f2340g = bundle.getString("deviceID");
        this.f2341h = bundle.getString("deviceType");
        this.f2342i = Build.MODEL;
        this.f2343j = h.b();
        this.f2344k = h.c();
        this.f2345l = System.currentTimeMillis() / 1000;
        this.f2346m = bundle.getString(BundleKey.KEY_IMEI);
        this.f2347n = bundle.getString(BundleKey.KEY_EMMCID);
        this.f2348o = bundle.getString(BundleKey.KEY_DEVICE_LEVEL);
        this.f2351r = bundle.getString("siteID");
        this.f2350q = 1;
        if (TextUtils.isEmpty(this.f2346m)) {
            this.f2346m = com.huawei.membercenter.sdk.membersdklibrary.a.b.a.a(context);
        }
        if (TextUtils.isEmpty(this.f2346m)) {
            this.f2346m = "000000000000000";
        }
        if (!h.b(this.f2339f)) {
            string = bundle.getString("deviceID2");
            if (string == null || "".equals(string.trim())) {
                string = com.huawei.membercenter.sdk.membersdklibrary.a.b.a.a(com.huawei.membercenter.sdk.membersdklibrary.a.b.a.a(context), context);
            }
            this.f2349p = string;
        }
    }
}
