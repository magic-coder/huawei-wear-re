package com.huawei.hwbtsdk.p399a;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.p190v.C2538c;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AesCbc */
public class C4597a extends C4596v {
    static final byte[] f16817a = new byte[]{(byte) 89, TagName.NOTICE_END_TIME, (byte) 87, TagName.ELECTRONIC, TagName.PUBLISH_END_TIME};
    private String f16818b;

    public C4597a(int i) {
        m21892a(i);
    }

    private void m21892a(int i) {
        switch (i) {
            case 1:
                this.f16818b = "AES/CBC/PKCS5Padding";
                return;
            default:
                this.f16818b = "AES/CBC/PKCS5Padding";
                return;
        }
    }

    public byte[] mo4537a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        try {
            Cipher instance = Cipher.getInstance(this.f16818b);
            instance.init(1, secretKeySpec, ivParameterSpec);
            return instance.doFinal(bArr);
        } catch (NoSuchAlgorithmException e) {
            C2538c.b("01", 1, "AesCbcPkCS5Padding", new Object[]{"encrypt NoSuchAlgorithmException =" + e.getMessage()});
            return null;
        } catch (NoSuchPaddingException e2) {
            C2538c.b("01", 1, "AesCbcPkCS5Padding", new Object[]{"encrypt NoSuchPaddingException =" + e2.getMessage()});
            return null;
        } catch (InvalidAlgorithmParameterException e3) {
            C2538c.b("01", 1, "AesCbcPkCS5Padding", new Object[]{"encrypt InvalidAlgorithmParameterException =" + e3.getMessage()});
            return null;
        } catch (InvalidKeyException e4) {
            C2538c.b("01", 1, "AesCbcPkCS5Padding", new Object[]{"encrypt InvalidKeyException =" + e4.getMessage()});
            return null;
        } catch (BadPaddingException e5) {
            C2538c.b("01", 1, "AesCbcPkCS5Padding", new Object[]{"encrypt BadPaddingException =" + e5.getMessage()});
            return null;
        } catch (IllegalBlockSizeException e6) {
            C2538c.b("01", 1, "AesCbcPkCS5Padding", new Object[]{"encrypt IllegalBlockSizeException =" + e6.getMessage()});
            return null;
        }
    }

    public byte[] mo4538b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            Cipher instance = Cipher.getInstance(this.f16818b);
            instance.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
            return instance.doFinal(bArr);
        } catch (InvalidKeyException e) {
            C2538c.b("01", 1, "AesCbcPkCS5Padding", new Object[]{"desEncrypt InvalidKeyException =" + e.getMessage()});
            return null;
        } catch (InvalidAlgorithmParameterException e2) {
            C2538c.b("01", 1, "AesCbcPkCS5Padding", new Object[]{"desEncrypt InvalidAlgorithmParameterException =" + e2.getMessage()});
            return null;
        } catch (BadPaddingException e3) {
            C2538c.b("01", 1, "AesCbcPkCS5Padding", new Object[]{"desEncrypt BadPaddingException =" + e3.getMessage()});
            return null;
        } catch (IllegalBlockSizeException e4) {
            C2538c.b("01", 1, "AesCbcPkCS5Padding", new Object[]{"desEncrypt IllegalBlockSizeException =" + e4.getMessage()});
            return null;
        } catch (NoSuchAlgorithmException e5) {
            C2538c.b("01", 1, "AesCbcPkCS5Padding", new Object[]{"desEncrypt NoSuchAlgorithmException =" + e5.getMessage()});
            return null;
        } catch (NoSuchPaddingException e6) {
            C2538c.b("01", 1, "AesCbcPkCS5Padding", new Object[]{"desEncrypt NoSuchPaddingException =" + e6.getMessage()});
            return null;
        }
    }
}
