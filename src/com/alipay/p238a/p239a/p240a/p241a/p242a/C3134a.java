package com.alipay.p238a.p239a.p240a.p241a.p242a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Log;
import cn.com.fmsh.tsm.business.constants.Constants.XMLNode;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import net.sqlcipher.database.SQLiteDatabase;

public class C3134a {
    private static int f10487a = 98;

    public static C3135b m13957a(Context context) {
        C3136c a = C3134a.m13958a(context, "com.eg.android.AlipayGphone");
        if (a == null) {
            return C3135b.NOT_INSTALL;
        }
        CharSequence a2 = C3134a.m13959a(a.f10498a);
        return (TextUtils.isEmpty(a2) || !TextUtils.equals(a2, "b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d649")) ? C3135b.FAKE : a.f10499b < f10487a ? C3135b.SUCCESS_SCHEME : C3135b.SUCCESS_SERVICE;
    }

    private static C3136c m13958a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 64);
        } catch (Exception e) {
            Log.e("EasyBarcodeSDK", e.getMessage());
            packageInfo = null;
        }
        if (packageInfo == null) {
            return null;
        }
        C3136c c3136c = new C3136c();
        c3136c.f10498a = packageInfo.signatures[0].toByteArray();
        c3136c.f10499b = packageInfo.versionCode;
        return c3136c;
    }

    private static String m13959a(byte[] bArr) {
        try {
            String obj = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey().toString();
            if (obj.indexOf(XMLNode.KEY_MODULUS) != -1) {
                return obj.substring(obj.indexOf(XMLNode.KEY_MODULUS) + 8, obj.lastIndexOf(",")).trim();
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static void m13960a(int i) {
        if (i >= 98) {
            f10487a = i;
        }
    }

    public static void m13961b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.eg.android.AlipayGphone", "com.alipay.android.app.TransProcessPayActivity");
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            Thread.sleep(150);
        } catch (Throwable th) {
        }
    }
}
