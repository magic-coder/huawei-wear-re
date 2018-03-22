package com.huawei.nfc.carrera.util;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CipherUtil {
    private static final String SIGN_ALGORITHMS = "SHA256WithRSA";
    private static String TAG = "CipherUtil";

    public static boolean doCheck(String str, String str2, String str3) {
        boolean z = false;
        if (TextUtils.isEmpty(str3)) {
            C2538c.e(TAG, new Object[]{"publicKey is null"});
        } else {
            try {
                PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str3, 0)));
                Signature instance = Signature.getInstance(SIGN_ALGORITHMS);
                instance.initVerify(generatePublic);
                instance.update(str.getBytes("utf-8"));
                z = instance.verify(Base64.decode(str2, 0));
            } catch (NoSuchAlgorithmException e) {
                C2538c.e(TAG, new Object[]{"doCheck NoSuchAlgorithmException" + e.getMessage()});
            } catch (InvalidKeySpecException e2) {
                C2538c.e(TAG, new Object[]{"doCheck InvalidKeySpecException" + e2.getMessage()});
            } catch (InvalidKeyException e3) {
                C2538c.e(TAG, new Object[]{"doCheck InvalidKeyException" + e3.getMessage()});
            } catch (SignatureException e4) {
                C2538c.e(TAG, new Object[]{"doCheck SignatureException" + e4.getMessage()});
            } catch (UnsupportedEncodingException e5) {
                C2538c.e(TAG, new Object[]{"doCheck UnsupportedEncodingException" + e5.getMessage()});
            }
        }
        return z;
    }

    public static String getSignData(Map<String, Object> map) {
        StringBuffer stringBuffer = new StringBuffer();
        List arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            String str;
            String str2 = (String) arrayList.get(i);
            Object obj = map.get(str2);
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = String.valueOf(obj);
            }
            if (str != null) {
                String str3;
                StringBuilder stringBuilder = new StringBuilder();
                if (i == 0) {
                    str3 = "";
                } else {
                    str3 = SNBConstant.FILTER;
                }
                stringBuffer.append(stringBuilder.append(str3).append(str2).append("=").append(str).toString());
            }
        }
        return stringBuffer.toString();
    }
}
