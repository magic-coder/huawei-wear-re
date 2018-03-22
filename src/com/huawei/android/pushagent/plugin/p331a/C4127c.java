package com.huawei.android.pushagent.plugin.p331a;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.tools.p334a.C4140a;
import com.huawei.android.pushagent.plugin.tools.p334a.C4141b;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.storage.db.DataModel.IssuerInfoColumns;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONException;
import org.json.JSONObject;

public class C4127c {
    private JSONObject f15522a = new JSONObject();

    public C4127c(String str, int i, String str2, String str3, Context context) {
        try {
            e.a("PushLogSC2712", "cmd is:" + i);
            this.f15522a.put(SNBConstant.FIELD_TOKEN, str);
            this.f15522a.put("cmd", i);
            this.f15522a.put("saltHash", str2);
            this.f15522a.put("content", str3);
            this.f15522a.put(Constant.KEY_APP_VERSION, C4127c.m20182b(context));
        } catch (JSONException e) {
            e.b("PushLogSC2712", "init ReportReq error:" + e.getMessage());
        }
    }

    private static String m20182b(Context context) {
        String str = "0.0";
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            e.a("PushLogSC2712", "package not exist", e);
            return str;
        } catch (Throwable e2) {
            e.c("PushLogSC2712", "getApkVersionName error", e2);
            return str;
        }
    }

    public String m20183a() {
        return this.f15522a.optString(SNBConstant.FIELD_TOKEN, "");
    }

    public String m20184a(Context context) {
        byte[] a = C4141b.m20224a(new C4125a(context).m20171a().toCharArray());
        if (a.length == 0) {
            return "";
        }
        try {
            String a2 = C4140a.m20218a(a).m20220a(m20187d());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(SNBConstant.FIELD_TOKEN).append("=").append(m20183a()).append(SNBConstant.FILTER).append("cmd").append("=").append(m20185b()).append(SNBConstant.FILTER).append("saltHash").append("=").append(m20186c()).append(SNBConstant.FILTER).append(IssuerInfoColumns.COLUMN_NAME_MODE).append("=").append(0).append(SNBConstant.FILTER).append(Constant.KEY_APP_VERSION).append("=").append(m20188e()).append(SNBConstant.FILTER).append("content").append("=").append(a2);
            return stringBuffer.toString();
        } catch (Throwable e) {
            e.c("PushLogSC2712", "encrypt request content InvalidKeyException:" + e.getMessage(), e);
            return "";
        } catch (Throwable e2) {
            e.c("PushLogSC2712", "encrypt request content NoSuchAlgorithmException:" + e2.getMessage(), e2);
            return "";
        } catch (Throwable e22) {
            e.c("PushLogSC2712", "encrypt request content NoSuchPaddingException:" + e22.getMessage(), e22);
            return "";
        } catch (Throwable e222) {
            e.c("PushLogSC2712", "encrypt request content IllegalBlockSizeException:" + e222.getMessage(), e222);
            return "";
        } catch (Throwable e2222) {
            e.c("PushLogSC2712", "encrypt request content BadPaddingException:" + e2222.getMessage(), e2222);
            return "";
        } catch (Throwable e22222) {
            e.c("PushLogSC2712", "encrypt request content UnsupportedEncodingException:" + e22222.getMessage(), e22222);
            return "";
        } catch (Throwable e222222) {
            e.c("PushLogSC2712", "encrypt request content InvalidAlgorithmParameterException:" + e222222.getMessage(), e222222);
            return "";
        } catch (Throwable e2222222) {
            e.c("PushLogSC2712", "encrypt request content Exception:" + e2222222.getMessage(), e2222222);
            return "";
        }
    }

    public int m20185b() {
        return this.f15522a.optInt("cmd", -1);
    }

    public String m20186c() {
        return this.f15522a.optString("saltHash", "");
    }

    public String m20187d() {
        return this.f15522a.optString("content", "");
    }

    public String m20188e() {
        return this.f15522a.optString(Constant.KEY_APP_VERSION, "");
    }
}
