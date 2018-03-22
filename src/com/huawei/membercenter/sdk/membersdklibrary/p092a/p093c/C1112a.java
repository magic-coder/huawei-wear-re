package com.huawei.membercenter.sdk.membersdklibrary.p092a.p093c;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.annotations.SerializedName;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.membercenter.sdk.membersdklibrary.a.b.a;
import com.huawei.membercenter.sdk.membersdklibrary.a.d.b;
import com.huawei.membercenter.sdk.membersdklibrary.a.d.d;
import com.huawei.membercenter.sdk.membersdklibrary.a.d.f;
import com.huawei.membercenter.sdk.membersdklibrary.a.d.h;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.BundleKey;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* compiled from: ActiveMemberRequest */
public class C1112a {
    @SerializedName("accountId")
    private String f2314a;
    @SerializedName("emmcId")
    private String f2315b;
    @SerializedName("imei1")
    private String f2316c;
    @SerializedName("imei2")
    private String f2317d;
    @SerializedName("sn")
    private String f2318e = b.a();
    @SerializedName("secretDigest")
    private String f2319f;
    @SerializedName("salt")
    private String f2320g;
    @SerializedName("countryCode")
    private String f2321h = PayManagerSettingSwitchDialog.COUNTRY_CODE_CN;
    @SerializedName("offeringCode")
    private String f2322i;
    @SerializedName("apkName")
    private String f2323j;
    @SerializedName("version")
    private String f2324k;
    @SerializedName("type")
    private String f2325l;
    @SerializedName("cerChain")
    private String f2326m;
    @SerializedName("key")
    private String f2327n;
    @SerializedName("sign")
    private String f2328o;
    @SerializedName("appID")
    private String f2329p;
    @SerializedName("deviceID")
    private String f2330q;
    @SerializedName("deviceType")
    private String f2331r;
    @SerializedName("serviceToken")
    private String f2332s;
    @SerializedName("terminalType")
    private String f2333t;

    public C1112a(Bundle bundle, Context context) {
        this.f2314a = bundle.getString("userID");
        this.f2316c = bundle.getString(BundleKey.KEY_IMEI);
        this.f2315b = bundle.getString(BundleKey.KEY_EMMCID);
        this.f2323j = "";
        String string = bundle.getString("packageName");
        if (TextUtils.isEmpty(string)) {
            string = context.getPackageName();
        }
        this.f2329p = string;
        this.f2320g = h.a();
        if (TextUtils.isEmpty(this.f2316c)) {
            this.f2316c = a.a(context);
        }
        if (TextUtils.isEmpty(this.f2316c)) {
            this.f2316c = "000000000000000";
        }
        if (!h.b(this.f2329p)) {
            this.f2319f = h.a(this.f2320g);
            string = bundle.getString("deviceID2");
            if (string == null || "".equals(string.trim())) {
                string = a.a(a.a(context), context);
            }
            this.f2317d = string;
        }
        this.f2332s = bundle.getString(BundleKey.KEY_ST);
        this.f2330q = bundle.getString("deviceID");
        this.f2331r = bundle.getString("deviceType");
        this.f2333t = Build.MODEL;
        if (h.b(this.f2329p)) {
            this.f2318e = bundle.getString(BundleKey.KEY_IMEI);
            this.f2316c = "";
            this.f2325l = "1";
        } else if (f.a(context) == null) {
            this.f2325l = "1";
        } else {
            Object a = f.a();
            if (a == null) {
                this.f2325l = "1";
                return;
            }
            String a2 = f.a(m4974a(this.f2318e, this.f2316c, this.f2317d, this.f2315b));
            if (a2 == null) {
                this.f2325l = "1";
                return;
            }
            d.b("ContentValues", "keyPairCallBack: 新的加密方式");
            this.f2325l = "2";
            if (a.length > 0) {
                this.f2327n = m4973a(a[0]);
            }
            this.f2328o = a2;
            this.f2326m = m4973a(a);
        }
    }

    public String toString() {
        return "ActiveMemberRequest{accountId='" + this.f2314a + '\'' + ", emmcId='" + this.f2315b + '\'' + ", imei1='" + this.f2316c + '\'' + ", imei2='" + this.f2317d + '\'' + ", sn='" + this.f2318e + '\'' + ", secretDigest='" + this.f2319f + '\'' + ", salt='" + this.f2320g + '\'' + ", countryCode='" + this.f2321h + '\'' + ", " + "offeringCode='" + this.f2322i + '\'' + ", apkName='" + this.f2323j + '\'' + ", version='" + this.f2324k + '\'' + ", type='" + this.f2325l + '\'' + ", cerChain='" + this.f2326m + '\'' + ", key='" + this.f2327n + '\'' + ", " + "sign='" + this.f2328o + '\'' + ", appID='" + this.f2329p + '\'' + ", deviceID='" + this.f2330q + '\'' + ", " + "deviceType='" + this.f2331r + '\'' + ", serviceToken='" + this.f2332s + '\'' + ", terminalType='" + this.f2333t + '\'' + '}';
    }

    private String m4974a(String str, String str2, String str3, String str4) {
        return str + HwAccountConstants.SPLIIT_UNDERLINE + str2 + HwAccountConstants.SPLIIT_UNDERLINE + str3 + HwAccountConstants.SPLIIT_UNDERLINE + str4;
    }

    private String m4973a(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        String str = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                try {
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    if (objectOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                } catch (IOException e) {
                    d.c("ContentValues", "objectToBase64 finally IOException...");
                }
            } catch (IOException e2) {
                try {
                    d.c("ContentValues", "objectToBase64 IOException...");
                    try {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        if (objectOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    } catch (IOException e3) {
                        d.c("ContentValues", "objectToBase64 finally IOException...");
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        if (objectOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    } catch (IOException e4) {
                        d.c("ContentValues", "objectToBase64 finally IOException...");
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            objectOutputStream = str;
            d.c("ContentValues", "objectToBase64 IOException...");
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            if (objectOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return str;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = str;
            th = th4;
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            if (objectOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
        return str;
    }
}
