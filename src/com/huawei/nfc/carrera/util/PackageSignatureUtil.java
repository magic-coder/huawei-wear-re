package com.huawei.nfc.carrera.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PackageSignatureUtil {
    private static Certificate[] getInstalledAPPCerts(Context context, String str) throws CertificateException, NoSuchAlgorithmException, AccessControlException {
        if (str == null || str.length() == 0) {
            throw new AccessControlException("Package Name not defined");
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                throw new AccessControlException("Package does not exist");
            }
            ArrayList arrayList = new ArrayList();
            for (Signature toByteArray : packageInfo.signatures) {
                arrayList.add(decodeCertificate(toByteArray.toByteArray()));
            }
            return (Certificate[]) arrayList.toArray(new Certificate[arrayList.size()]);
        } catch (NameNotFoundException e) {
            throw new AccessControlException("Package does not exist");
        }
    }

    private static Certificate[] getUnInstalledAPPCerts(Context context, String str) throws CertificateException, NoSuchAlgorithmException, AccessControlException {
        if (str == null || str.length() == 0) {
            throw new AccessControlException("Package File not defined");
        }
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo == null) {
            throw new AccessControlException("Package does not exist");
        }
        ArrayList arrayList = new ArrayList();
        for (Signature toByteArray : packageArchiveInfo.signatures) {
            arrayList.add(decodeCertificate(toByteArray.toByteArray()));
        }
        return (Certificate[]) arrayList.toArray(new Certificate[arrayList.size()]);
    }

    private static byte[] getAppCertHash(Certificate certificate) throws CertificateEncodingException {
        MessageDigest instance;
        int i = 0;
        while (i < 10) {
            try {
                instance = MessageDigest.getInstance("SHA");
                break;
            } catch (Throwable e) {
                LogX.e("getAppCertHash NoSuchAlgorithmException : " + Log.getStackTraceString(e));
                i++;
            }
        }
        instance = null;
        if (instance == null) {
            throw new AccessControlException("Hash can not be computed");
        }
        LogX.i("Application Cert Hash Value: " + byteArrayToHex(instance.digest(certificate.getEncoded())));
        return instance.digest(certificate.getEncoded());
    }

    public static List<String> getInstalledAppHashList(Context context, String str) throws AccessControlException, CertificateException, NoSuchAlgorithmException {
        List<String> list = null;
        Certificate[] installedAPPCerts = getInstalledAPPCerts(context, str);
        if (installedAPPCerts != null && installedAPPCerts.length > 0) {
            LogX.d("travel:accessControl fetch certificates array of caller successful ");
            list = new ArrayList();
            for (Certificate appCertHash : installedAPPCerts) {
                list.add(byteArrayToHex(getAppCertHash(appCertHash)));
            }
        }
        return list;
    }

    public static List<String> getUnInstalledAppHashList(Context context, String str) throws AccessControlException, CertificateException, NoSuchAlgorithmException, IOException {
        List<String> list = null;
        Certificate[] unInstalledAPPCerts = getUnInstalledAPPCerts(context, str);
        if (unInstalledAPPCerts != null && unInstalledAPPCerts.length > 0) {
            LogX.d("travel:accessControl fetch certificates array of caller successful ");
            list = new ArrayList();
            for (Certificate appCertHash : unInstalledAPPCerts) {
                list.add(byteArrayToHex(getAppCertHash(appCertHash)));
            }
        }
        return list;
    }

    private static Certificate decodeCertificate(byte[] bArr) throws CertificateException {
        return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
    }

    private static String byteArrayToHex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if ((bArr[i] & 255) < 16) {
                stringBuffer.append("0" + Integer.toHexString(bArr[i] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(bArr[i] & 255));
            }
        }
        return stringBuffer.toString().toUpperCase(Locale.getDefault());
    }
}
