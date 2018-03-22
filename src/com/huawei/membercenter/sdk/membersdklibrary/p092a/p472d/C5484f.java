package com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec.Builder;
import android.util.Base64;
import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.security.auth.x500.X500Principal;

/* compiled from: SaltDeal */
public class C5484f {
    @TargetApi(24)
    public static Certificate[] m26191a() {
        Certificate[] certificateArr = null;
        try {
            KeyPairGenerator.getInstance("RSA", "HwUniversalKeyStoreProvider").initialize(new Builder("key1", 4).setDigests(new String[]{"SHA-256", "SHA-384", "SHA-512"}).setUserAuthenticationRequired(true).setAttestationChallenge("hwkeystory".getBytes()).build());
            KeyStore instance = KeyStore.getInstance("HwKeyStore");
            instance.load(null);
            certificateArr = instance.getCertificateChain("HwKey");
        } catch (NoSuchAlgorithmException e) {
            C5482d.m26186d("SaltDeal", "getCertificate: NoSuchAlgorithmException");
        } catch (NoSuchProviderException e2) {
            C5482d.m26186d("SaltDeal", "getCertificate: NoSuchProviderException");
        } catch (InvalidAlgorithmParameterException e3) {
            C5482d.m26186d("SaltDeal", "getCertificate: InvalidAlgorithmParameterException");
        } catch (CertificateException e4) {
            C5482d.m26186d("SaltDeal", "getCertificate: CertificateException");
        } catch (KeyStoreException e5) {
            C5482d.m26186d("SaltDeal", "getCertificate: KeyStoreException");
        } catch (IOException e6) {
            C5482d.m26186d("SaltDeal", "getCertificate: IOException");
        }
        return certificateArr;
    }

    public static String m26189a(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }

    @TargetApi(24)
    public static KeyPair m26190a(Context context) {
        Calendar gregorianCalendar = new GregorianCalendar();
        Calendar gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.add(1, 1);
        try {
            AlgorithmParameterSpec build;
            KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "HwUniversalKeyStoreProvider");
            if (VERSION.SDK_INT < 23) {
                build = new KeyPairGeneratorSpec.Builder(context).setAlias("HwKey").setSubject(new X500Principal("CN=HwKey")).setSerialNumber(BigInteger.valueOf(1337)).setStartDate(gregorianCalendar.getTime()).setEndDate(gregorianCalendar2.getTime()).build();
            } else {
                build = new Builder("HwKey", 4).setCertificateSubject(new X500Principal("CN=HwKey")).setDigests(new String[]{"SHA-256"}).setSignaturePaddings(new String[]{"PKCS1"}).setCertificateSerialNumber(BigInteger.valueOf(1337)).setCertificateNotBefore(gregorianCalendar.getTime()).setCertificateNotAfter(gregorianCalendar2.getTime()).setAttestationChallenge("hwkeystory".getBytes()).build();
            }
            instance.initialize(build);
            return instance.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            C5482d.m26186d("SaltDeal", "createKeys: NoSuchAlgorithmException");
            return null;
        } catch (NoSuchProviderException e2) {
            C5482d.m26186d("SaltDeal", "createKeys: NoSuchProviderException");
            return null;
        } catch (InvalidAlgorithmParameterException e3) {
            C5482d.m26186d("SaltDeal", "createKeys: InvalidAlgorithmParameterException");
            return null;
        } catch (NoSuchMethodError e4) {
            C5482d.m26186d("SaltDeal", "createKeys: NoSuchMethodError");
            return null;
        } catch (Exception e5) {
            C5482d.m26186d("SaltDeal", "createKeys: Exception");
            return null;
        }
    }

    public static String m26188a(String str) {
        byte[] bytes;
        byte[] bArr = new byte[0];
        try {
            bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C5482d.m26186d("SaltDeal", "signData UnsupportedEncodingException...");
            bytes = bArr;
        }
        try {
            KeyStore instance = KeyStore.getInstance("HwKeyStore");
            instance.load(null);
            Entry entry = instance.getEntry("HwKey", null);
            if (entry == null) {
                C5482d.m26185c("SaltDeal", "No key found under alias: HwKey");
                C5482d.m26185c("SaltDeal", "Exiting signData()...");
                return null;
            } else if (entry instanceof PrivateKeyEntry) {
                Signature instance2 = Signature.getInstance("SHA256withRSA", "HwUniversalKeyStoreProvider");
                instance2.initSign(((PrivateKeyEntry) entry).getPrivateKey());
                instance2.update(bytes);
                return C5484f.m26189a(instance2.sign());
            } else {
                C5482d.m26185c("SaltDeal", "Not an instance of a PrivateKeyEntry");
                C5482d.m26185c("SaltDeal", "Exiting signData()...");
                return null;
            }
        } catch (KeyStoreException e2) {
            C5482d.m26186d("SaltDeal", "signData: ");
            return null;
        } catch (IOException e3) {
            C5482d.m26186d("SaltDeal", "signData: IOException");
            return null;
        } catch (CertificateException e4) {
            C5482d.m26186d("SaltDeal", "signData: CertificateException");
            return null;
        } catch (NoSuchAlgorithmException e5) {
            C5482d.m26186d("SaltDeal", "signData: NoSuchAlgorithmException");
            return null;
        } catch (InvalidKeyException e6) {
            C5482d.m26186d("SaltDeal", "signData: InvalidKeyException");
            return null;
        } catch (UnrecoverableEntryException e7) {
            C5482d.m26186d("SaltDeal", "signData: UnrecoverableEntryException ");
            return null;
        } catch (SignatureException e8) {
            C5482d.m26186d("SaltDeal", "signData: SignatureException");
            return null;
        } catch (Exception e9) {
            C5482d.m26186d("SaltDeal", "createKeys: RuntimeException");
            return null;
        }
    }
}
