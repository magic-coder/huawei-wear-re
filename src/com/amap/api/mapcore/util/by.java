package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: WrapperClientInfo */
public class by {
    public static String m15817a(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("\"key\":\"").append(bm.m15690f(context)).append("\",\"platform\":\"android\",\"diu\":\"").append(bq.m15739q(context)).append("\",\"pkg\":\"").append(bm.m15687c(context)).append("\",\"model\":\"").append(Build.MODEL).append("\",\"appname\":\"").append(bm.m15686b(context)).append("\",\"appversion\":\"").append(bm.m15688d(context)).append("\",\"sysversion\":\"").append(VERSION.RELEASE).append("\",");
        } catch (Throwable th) {
            cd.m15825a(th, "CInfo", "getPublicJSONInfo");
        }
        return stringBuilder.toString();
    }

    public static String m15818a(Context context, byte[] bArr) {
        try {
            return bo.m15703a(context, bArr);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return "";
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            return "";
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
            return "";
        } catch (InvalidKeySpecException e6) {
            e6.printStackTrace();
            return "";
        } catch (CertificateException e7) {
            e7.printStackTrace();
            return "";
        } catch (IOException e8) {
            e8.printStackTrace();
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
