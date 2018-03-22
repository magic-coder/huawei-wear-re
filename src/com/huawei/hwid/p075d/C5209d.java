package com.huawei.hwid.p075d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* compiled from: PackageManagerHelper */
public class C5209d {
    private final PackageManager f18803a;

    /* compiled from: PackageManagerHelper */
    public enum C5208a {
        ENABLED,
        DISABLED,
        NOT_INSTALLED
    }

    public C5209d(Context context) {
        this.f18803a = context.getPackageManager();
    }

    public C5208a m25336a(String str) {
        try {
            if (this.f18803a.getApplicationInfo(str, 0).enabled) {
                return C5208a.ENABLED;
            }
            return C5208a.DISABLED;
        } catch (NameNotFoundException e) {
            return C5208a.NOT_INSTALLED;
        }
    }

    public int m25339b(String str) {
        try {
            PackageInfo packageInfo = this.f18803a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (NameNotFoundException e) {
            C5165e.m24906b("PackageManagerHelper", "NameNotFoundException");
            return 0;
        } catch (Exception e2) {
            C5165e.m24906b("PackageManagerHelper", "Exception e = " + e2.getMessage());
            return 0;
        }
    }

    public String m25340c(String str) {
        try {
            PackageInfo packageInfo = this.f18803a.getPackageInfo(str, 16);
            if (packageInfo == null || packageInfo.versionName == null) {
                return "";
            }
            return packageInfo.versionName;
        } catch (NameNotFoundException e) {
            return "";
        }
    }

    public String m25341d(String str) {
        byte[] e = m25335e(str);
        if (e == null || e.length == 0) {
            return null;
        }
        return C5206b.m25330b(C5210e.m25343a(e), true);
    }

    private byte[] m25335e(String str) {
        Exception e;
        try {
            PackageInfo packageInfo = this.f18803a.getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures.length <= 0) {
                C5207c.m25333a(null);
                C5165e.m24910d("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
                return new byte[0];
            }
            InputStream a = C5207c.m25331a(packageInfo.signatures[0].toByteArray());
            byte[] encoded = CertificateFactory.getInstance("X.509").generateCertificate(a).getEncoded();
            C5207c.m25333a(a);
            return encoded;
        } catch (NameNotFoundException e2) {
            e = e2;
            try {
                C5165e.m24910d("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
                C5165e.m24910d("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
                return new byte[0];
            } finally {
                C5207c.m25333a(null);
            }
        } catch (IOException e3) {
            e = e3;
            C5165e.m24910d("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
            C5165e.m24910d("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
            return new byte[0];
        } catch (CertificateException e4) {
            e = e4;
            C5165e.m24910d("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
            C5165e.m24910d("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
            return new byte[0];
        }
    }

    public boolean m25337a(String str, String str2) {
        try {
            PackageInfo packageInfo = this.f18803a.getPackageInfo(str, 8);
            if (packageInfo == null || packageInfo.providers == null) {
                return false;
            }
            for (ProviderInfo providerInfo : packageInfo.providers) {
                if (str2.equals(providerInfo.authority)) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public boolean m25338a(String str, String str2, String str3) {
        Exception e;
        boolean z = false;
        PackageInfo packageArchiveInfo = this.f18803a.getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo != null && packageArchiveInfo.signatures.length > 0 && str2.equals(packageArchiveInfo.packageName)) {
            InputStream inputStream = null;
            try {
                inputStream = C5207c.m25331a(packageArchiveInfo.signatures[0].toByteArray());
                z = str3.equalsIgnoreCase(C5206b.m25330b(C5210e.m25343a(CertificateFactory.getInstance("X.509").generateCertificate(inputStream).getEncoded()), true));
                C5207c.m25333a(inputStream);
            } catch (IOException e2) {
                e = e2;
                try {
                    C5165e.m24910d("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
                    return z;
                } finally {
                    C5207c.m25333a(inputStream);
                }
            } catch (CertificateException e3) {
                e = e3;
                C5165e.m24910d("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
                return z;
            }
        }
        return z;
    }
}
