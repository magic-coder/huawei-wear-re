package com.huawei.hwid.core.p429a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.huawei.hwid.api.common.C5106n;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.encrypt.AES128_ECB;
import com.huawei.hwid.core.encrypt.HEX;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5181l;
import com.huawei.hwid.core.p435d.C5182m;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p426b.C5114a;
import com.sina.weibo.sdk.component.GameManager;
import java.security.MessageDigest;

/* compiled from: OpLogItem */
public class C5117b {
    private String f18436a;
    private String f18437b;
    private String f18438c;
    private String f18439d;
    private String f18440e;
    private String f18441f;
    private String f18442g;
    private String f18443h;
    private String f18444i;
    private int f18445j;
    private int f18446k;
    private String f18447l;
    private String f18448m;
    private String f18449n;
    private String f18450o;
    private boolean f18451p;

    public C5117b(Context context, String str, String str2) {
        this(context, str);
    }

    public C5117b(Context context, String str) {
        this.f18445j = 0;
        this.f18451p = false;
        this.f18436a = str;
        this.f18437b = C5166b.m24915a();
        this.f18438c = "";
        this.f18439d = "";
        this.f18440e = C5182m.m25055b(context, HwAccountConstants.NO_SUBID);
        this.f18441f = m24658a(context);
        this.f18442g = "";
        this.f18443h = m24659b(context);
        this.f18444i = "";
        this.f18446k = 0;
        this.f18447l = C5182m.m25046a();
        this.f18448m = context.getPackageName();
        this.f18449n = C5166b.m24932b();
        if (C5166b.m24924a(context)) {
            this.f18439d = C5166b.m24933b(context);
        }
    }

    public C5117b(Bundle bundle, Context context) {
        this.f18445j = 0;
        this.f18451p = false;
        this.f18440e = C5182m.m25055b(context, HwAccountConstants.NO_SUBID);
        this.f18441f = m24658a(context);
        this.f18443h = m24659b(context);
        this.f18446k = 0;
        this.f18447l = C5182m.m25046a();
        this.f18448m = context.getPackageName();
        this.f18449n = C5166b.m24932b();
        if (C5166b.m24924a(context)) {
            this.f18439d = C5166b.m24933b(context);
        }
        this.f18436a = bundle.getString(HwAccountConstants.EXTRA_OPLOG_OPID);
        this.f18437b = bundle.getString(HwAccountConstants.EXTRA_OPLOG_REQTIME);
        this.f18438c = bundle.getString(HwAccountConstants.EXTRA_OPLOG_RSPTIME);
        this.f18444i = bundle.getString(HwAccountConstants.EXTRA_OPLOG_OPDETAIL);
        this.f18450o = bundle.getString("url");
        this.f18451p = bundle.getBoolean(HwAccountConstants.EXTRA_OPLOG_IS_REQUEST_EXCEPTION, false);
        this.f18442g = bundle.getString(HwAccountConstants.EXTRA_OPLOG_ERROR);
        this.f18445j = bundle.getInt("siteID", 0);
    }

    private String m24658a(Context context) {
        String l = C5166b.m24960l(context);
        HwAccount b = C5114a.m24640a(context).mo4623b(context, C5106n.m24583a(context), l);
        if (b != null) {
            return b.m25124d();
        }
        return "";
    }

    private String m24659b(Context context) {
        Throwable th;
        String str = "";
        str = C5182m.m25054b(context);
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData == null || applicationInfo.metaData.getInt("oplog_encrypt") != 1) {
                return str;
            }
            byte[] digest = MessageDigest.getInstance("SHA-256").digest((str + new StringBuffer().append(HwAccountConstants.ENCODE_KEY_STR).append(AES128_ECB.PART_KEY_CODE_KEY).append(HEX.PART_KEY_CODE).append(C5181l.m25044e("mgsI")).toString()).getBytes(GameManager.DEFAULT_CHARSET));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(toHexString);
            }
            return stringBuffer.toString();
        } catch (Throwable e) {
            th = e;
            str = "";
            C5165e.m24911d("OpLogItem", th.getMessage(), th);
            return str;
        } catch (Throwable e2) {
            th = e2;
            str = "";
            C5165e.m24911d("OpLogItem", th.getMessage(), th);
            return str;
        }
    }

    public void m24661a(String str) {
        this.f18438c = str;
    }

    public int m24660a() {
        return this.f18445j;
    }

    public void m24662b(String str) {
        this.f18444i = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(this.f18436a).append("|").append(this.f18437b).append("|").append(this.f18438c).append("|").append(this.f18439d).append("|").append(this.f18440e).append("|").append(C5181l.m25045f(this.f18441f)).append("|").append(this.f18442g).append("|").append(this.f18443h).append("|").append(this.f18444i).append("|").append(this.f18446k).append("|").append(this.f18447l).append("|").append(this.f18448m).append("|").append(this.f18450o).append("|").append(this.f18449n).append("|").append(this.f18445j).append("|");
        return stringBuilder.toString();
    }
}
