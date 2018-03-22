package com.huawei.p086k;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.p086k.p462a.C5406a;
import com.huawei.p086k.p462a.C5407b;
import com.huawei.p086k.p462a.C5408c;
import com.huawei.p086k.p462a.C5411f;
import com.huawei.p086k.p462a.C5412g;
import com.huawei.p086k.p462a.p463a.C5405a;
import com.huawei.p190v.C2538c;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* compiled from: HsfSignValidator */
public class C5414c {
    private final Context f19229a;

    public C5414c(Context context) {
        C5406a.m25991a((Object) context, "context must not be null.");
        this.f19229a = context;
    }

    public boolean m26009a(String str) {
        Throwable e;
        C5406a.m25992a(str, "packageName must not be empty.");
        String a = C5414c.m26005a(this.f19229a, str);
        C2538c.c("HsfSignValidator", new Object[]{"hsfSign = " + a});
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        if (new C5413b(this.f19229a).m26004a(a)) {
            return false;
        }
        Object b = C5414c.m26007b(this.f19229a, str);
        if (TextUtils.isEmpty(b)) {
            return false;
        }
        PublicKey a2 = C5414c.m26006a(this.f19229a);
        if (a2 == null) {
            return false;
        }
        try {
            Signature instance = Signature.getInstance("NONEwithRSA");
            instance.initVerify(a2);
            instance.update(str.getBytes(Charset.defaultCharset()));
            instance.update(b.getBytes(Charset.defaultCharset()));
            return instance.verify(Base64.decode(a, 0));
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            C5405a.m25990a("HsfSignValidator", "Failed to verify application HSF-signature.", e);
            C5405a.m25989a("HsfSignValidator", "Failed to verify application HSF-signature.");
            return false;
        } catch (InvalidKeyException e3) {
            e = e3;
            C5405a.m25990a("HsfSignValidator", "Failed to verify application HSF-signature.", e);
            C5405a.m25989a("HsfSignValidator", "Failed to verify application HSF-signature.");
            return false;
        } catch (SignatureException e4) {
            e = e4;
            C5405a.m25990a("HsfSignValidator", "Failed to verify application HSF-signature.", e);
            C5405a.m25989a("HsfSignValidator", "Failed to verify application HSF-signature.");
            return false;
        }
    }

    private static PublicKey m26006a(Context context) {
        return new C5411f().m26002a("publickey.txt");
    }

    private static String m26005a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                C2538c.c("HsfSignValidator", new Object[]{"appInfo className" + applicationInfo.className + " processName" + applicationInfo.processName});
                C2538c.c("HsfSignValidator", new Object[]{"appInfo.metaData " + applicationInfo.metaData});
                C2538c.c("HsfSignValidator", new Object[]{"ackageHsfSignature " + applicationInfo.metaData.getString("wear-signature")});
                return applicationInfo.metaData.getString("wear-signature");
            }
        } catch (Throwable e) {
            C5405a.m25990a("HsfSignValidator", "Failed to get the application HSF signature.", e);
        }
        return null;
    }

    private static String m26007b(Context context, String str) {
        Certificate c = C5414c.m26008c(context, str);
        if (c != null) {
            try {
                c.b("HsfSignValidator", new Object[]{"cert.getEncoded() " + C5407b.m25995b(C5412g.m26003a(c.getEncoded()), true)});
                return C5407b.m25995b(C5412g.m26003a(c.getEncoded()), true);
            } catch (Throwable e) {
                C5405a.m25990a("HsfSignValidator", "Failed to get application signature certificate fingerprint.", e);
            }
        }
        return null;
    }

    private static Certificate m26008c(Context context, String str) {
        Certificate generateCertificate;
        InputStream a;
        Throwable e;
        Throwable th;
        InputStream inputStream = null;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures.length <= 0) {
                C5408c.m25998a(inputStream);
                C5405a.m25989a("HsfSignValidator", "Failed to get application signature certificate.");
                return generateCertificate;
            }
            a = C5408c.m25996a(packageInfo.signatures[0].toByteArray());
            try {
                generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(a);
                C5408c.m25998a(a);
            } catch (NameNotFoundException e2) {
                e = e2;
                try {
                    C5405a.m25990a("HsfSignValidator", "Failed to get application signature certificate.", e);
                    C5408c.m25998a(a);
                    C5405a.m25989a("HsfSignValidator", "Failed to get application signature certificate.");
                    return generateCertificate;
                } catch (Throwable th2) {
                    th = th2;
                    C5408c.m25998a(a);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                C5405a.m25990a("HsfSignValidator", "Failed to get application signature certificate.", e);
                C5408c.m25998a(a);
                C5405a.m25989a("HsfSignValidator", "Failed to get application signature certificate.");
                return generateCertificate;
            } catch (CertificateException e4) {
                e = e4;
                C5405a.m25990a("HsfSignValidator", "Failed to get application signature certificate.", e);
                C5408c.m25998a(a);
                C5405a.m25989a("HsfSignValidator", "Failed to get application signature certificate.");
                return generateCertificate;
            }
            return generateCertificate;
        } catch (NameNotFoundException e5) {
            e = e5;
            a = inputStream;
            C5405a.m25990a("HsfSignValidator", "Failed to get application signature certificate.", e);
            C5408c.m25998a(a);
            C5405a.m25989a("HsfSignValidator", "Failed to get application signature certificate.");
            return generateCertificate;
        } catch (IOException e6) {
            e = e6;
            a = inputStream;
            C5405a.m25990a("HsfSignValidator", "Failed to get application signature certificate.", e);
            C5408c.m25998a(a);
            C5405a.m25989a("HsfSignValidator", "Failed to get application signature certificate.");
            return generateCertificate;
        } catch (CertificateException e7) {
            e = e7;
            a = inputStream;
            C5405a.m25990a("HsfSignValidator", "Failed to get application signature certificate.", e);
            C5408c.m25998a(a);
            C5405a.m25989a("HsfSignValidator", "Failed to get application signature certificate.");
            return generateCertificate;
        } catch (Throwable e8) {
            a = inputStream;
            th = e8;
            C5408c.m25998a(a);
            throw th;
        }
    }
}
