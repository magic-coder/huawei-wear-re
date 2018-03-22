package com.huawei.p306a.p307a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.p075d.C5206b;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: VerifySignatureUtil */
public abstract class C3939a {
    public static boolean m19591a(String str, String str2, String str3) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            C5165e.m24910d("VerifySignatureUtil", "Failed to Verify the digital signature, Invalid parameter.");
        } else {
            try {
                z = C3939a.m19592a(str.getBytes(GameManager.DEFAULT_CHARSET), Base64.decode(str2.getBytes(GameManager.DEFAULT_CHARSET), 0), Base64.decode(str3.getBytes(GameManager.DEFAULT_CHARSET), 0));
            } catch (UnsupportedEncodingException e) {
                C5165e.m24910d("VerifySignatureUtil", "Failed to verify the digital signature, exception: " + e);
            } catch (GeneralSecurityException e2) {
                C5165e.m24910d("VerifySignatureUtil", "Failed to verify the digital signature, exception: " + e2);
            }
        }
        return z;
    }

    private static boolean m19592a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr3));
        Signature instance = Signature.getInstance("SHA256withRSA");
        instance.initVerify(generatePublic);
        instance.update(bArr);
        return instance.verify(bArr2);
    }

    @SuppressLint({"TrulyRandom"})
    public static String m19590a() {
        byte[] bArr = new byte[24];
        new SecureRandom().nextBytes(bArr);
        return C5206b.m25330b(bArr, false);
    }
}
