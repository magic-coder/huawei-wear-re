package com.alipay.p238a.p239a.p240a.p241a;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.p238a.p239a.p240a.C3140b;
import com.alipay.p238a.p239a.p240a.p241a.p242a.C3134a;
import com.alipay.p238a.p239a.p240a.p241a.p242a.C3135b;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONException;
import org.json.JSONObject;

public class C3137a {
    private static C3137a f10500a = new C3137a();
    private Object f10501b = C3137a.class;
    private C3140b f10502c;
    private ServiceConnection f10503d = new C3138b(this);

    private C3137a() {
    }

    public static C3137a m13964a() {
        return f10500a;
    }

    private static String m13967a(Throwable th) {
        try {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            while (th != null) {
                th.printStackTrace(printWriter);
                th = th.getCause();
            }
            printWriter.close();
            return stringWriter.toString();
        } catch (Throwable th2) {
            return "";
        }
    }

    public static void m13968a(int i) {
        C3134a.m13960a(i);
    }

    private synchronized void m13969a(Context context) {
        Log.v("EasyBarcodeSDK", "initialize");
        Intent intent = new Intent();
        intent.setClassName("com.eg.android.AlipayGphone", "com.alipay.android.phone.easybarcode.EasyBarcodeService");
        intent.setAction("com.alipay.android.phone.easybarcode.IAlipayEasyBarcode");
        if (this.f10502c == null) {
            Log.v("EasyBarcodeSDK", "bindService");
            C3134a.m13961b(context);
            context.getApplicationContext().bindService(intent, this.f10503d, 1);
        }
        try {
            synchronized (this.f10501b) {
                if (this.f10502c == null) {
                    this.f10501b.wait(5000);
                }
            }
        } catch (Exception e) {
            Log.v("BarcodeSDK", "wait 异常" + e.getMessage());
        }
    }

    private C3135b m13970b(Context context, String str) {
        m13969a(context);
        if (this.f10502c == null) {
            return C3135b.SYS_ERROR;
        }
        String packageName = context.getPackageName();
        Map hashMap = new HashMap();
        hashMap.put(SNBConstant.FIELD_PKG, packageName);
        hashMap.put("ext_info", str);
        try {
            packageName = this.f10502c.mo3667a(0, hashMap);
        } catch (RemoteException e) {
            e.printStackTrace();
            packageName = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(packageName);
            if (TextUtils.equals(jSONObject.getString("result"), LightCloudConstants.RESPONSE_RESULT_SUCCESS)) {
                return C3135b.SUCCESS_SERVICE;
            }
            if (TextUtils.equals(jSONObject.getString("result"), "unsupport_app")) {
                return C3135b.UNSUPPORT_APP;
            }
            return C3135b.SYS_ERROR;
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public final synchronized C3135b m13971a(Context context, String str) {
        C3135b c3135b;
        Object obj = 1;
        synchronized (this) {
            try {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    obj = null;
                }
                if (obj != null) {
                    c3135b = C3135b.UNSUPPORT_MAIN_THREAD;
                } else {
                    c3135b = C3134a.m13957a(context);
                    if (c3135b == C3135b.SUCCESS_SCHEME) {
                        Log.v("EasyBarcodeSDK", "currentWalletNotSupport");
                        Intent intent = new Intent();
                        intent.setPackage("com.eg.android.AlipayGphone");
                        intent.setData(Uri.parse("alipays://platformapi/startapp?appId=20000056&source=outfield"));
                        intent.setAction("android.intent.action.VIEW");
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        intent.putExtra("directly", true);
                        context.startActivity(intent);
                        c3135b = C3135b.SUCCESS_SCHEME;
                    } else if (c3135b == C3135b.SUCCESS_SERVICE) {
                        c3135b = m13970b(context, str);
                    }
                }
            } catch (Throwable th) {
                Log.e("EasyBarcodeSDK", "===unknown===" + C3137a.m13967a(th));
                c3135b = C3135b.SYS_ERROR;
            }
        }
        return c3135b;
    }
}
