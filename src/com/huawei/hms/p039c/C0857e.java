package com.huawei.hms.p039c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import com.huawei.hms.support.log.C0887a;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* compiled from: PackageManagerHelper */
public class C0857e {
    private final PackageManager f1356a;

    /* compiled from: PackageManagerHelper */
    public enum C0856a {
        ENABLED,
        DISABLED,
        NOT_INSTALLED
    }

    public C0857e(Context context) {
        this.f1356a = context.getPackageManager();
    }

    public C0856a m3015a(String str) {
        try {
            if (this.f1356a.getApplicationInfo(str, 0).enabled) {
                return C0856a.ENABLED;
            }
            return C0856a.DISABLED;
        } catch (NameNotFoundException e) {
            return C0856a.NOT_INSTALLED;
        }
    }

    public int m3018b(String str) {
        try {
            PackageInfo packageInfo = this.f1356a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (NameNotFoundException e) {
            return 0;
        }
    }

    public String m3019c(String str) {
        try {
            PackageInfo packageInfo = this.f1356a.getPackageInfo(str, 16);
            if (packageInfo == null || packageInfo.versionName == null) {
                return "";
            }
            return packageInfo.versionName;
        } catch (NameNotFoundException e) {
            return "";
        }
    }

    public String m3020d(String str) {
        byte[] e = m3014e(str);
        if (e == null || e.length == 0) {
            return null;
        }
        return C0853b.m3006b(C0858f.m3022a(e), true);
    }

    private byte[] m3014e(String str) {
        Exception e;
        try {
            PackageInfo packageInfo = this.f1356a.getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures.length <= 0) {
                C0854c.m3009a(null);
                C0887a.m3098d("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
                return new byte[0];
            }
            InputStream a = C0854c.m3007a(packageInfo.signatures[0].toByteArray());
            byte[] encoded = CertificateFactory.getInstance("X.509").generateCertificate(a).getEncoded();
            C0854c.m3009a(a);
            return encoded;
        } catch (NameNotFoundException e2) {
            e = e2;
            try {
                C0887a.m3098d("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
                C0887a.m3098d("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
                return new byte[0];
            } finally {
                C0854c.m3009a(null);
            }
        } catch (IOException e3) {
            e = e3;
            C0887a.m3098d("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
            C0887a.m3098d("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
            return new byte[0];
        } catch (CertificateException e4) {
            e = e4;
            C0887a.m3098d("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
            C0887a.m3098d("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
            return new byte[0];
        }
    }

    public boolean m3016a(String str, String str2) {
        try {
            PackageInfo packageInfo = this.f1356a.getPackageInfo(str, 8);
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

    public boolean m3017a(String str, String str2, String str3) {
        Exception e;
        boolean z = false;
        PackageInfo packageArchiveInfo = this.f1356a.getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo != null && packageArchiveInfo.signatures.length > 0 && str2.equals(packageArchiveInfo.packageName)) {
            InputStream inputStream = null;
            try {
                inputStream = C0854c.m3007a(packageArchiveInfo.signatures[0].toByteArray());
                z = str3.equalsIgnoreCase(C0853b.m3006b(C0858f.m3022a(CertificateFactory.getInstance("X.509").generateCertificate(inputStream).getEncoded()), true));
                C0854c.m3009a(inputStream);
            } catch (IOException e2) {
                e = e2;
                try {
                    C0887a.m3098d("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
                    return z;
                } finally {
                    C0854c.m3009a(inputStream);
                }
            } catch (CertificateException e3) {
                e = e3;
                C0887a.m3098d("PackageManagerHelper", "Failed to get application signature certificate fingerprint." + e.getMessage());
                return z;
            }
        }
        return z;
    }
}
