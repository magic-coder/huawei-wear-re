package com.huawei.aj.p315a.p318c.p319a;

import android.text.TextUtils;
import com.huawei.wallet.utils.crypto.Base64;
import com.huawei.wallet.utils.log.LogC;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: Rsa */
public final class C4025a {
    public static boolean m19817a(String str, String str2, String str3) {
        return C4025a.m19818a(str, str2, str3, "RSA256");
    }

    public static boolean m19818a(String str, String str2, String str3, String str4) {
        boolean z = false;
        if (TextUtils.isEmpty(str3)) {
            LogC.m28534d("publicKey is null or empty.", z);
        } else {
            String str5 = "SHA256WithRSA";
            if (!"RSA256".equals(str4)) {
                str5 = "SHA1WithRSA";
            }
            try {
                PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.m28512a(str3)));
                Signature instance = Signature.getInstance(str5);
                instance.initVerify(generatePublic);
                instance.update(str.getBytes("utf-8"));
                z = instance.verify(Base64.m28512a(str2));
            } catch (NoSuchAlgorithmException e) {
                LogC.m28534d("NoSuchAlgorithmException", z);
            } catch (InvalidKeySpecException e2) {
                LogC.m28534d("InvalidKeySpecException", z);
            } catch (InvalidKeyException e3) {
                LogC.m28534d("InvalidKeyException", z);
            } catch (SignatureException e4) {
                LogC.m28534d("SignatureException", z);
            } catch (UnsupportedEncodingException e5) {
                LogC.m28534d("UnsupportedEncodingException", z);
            }
        }
        return z;
    }
}
