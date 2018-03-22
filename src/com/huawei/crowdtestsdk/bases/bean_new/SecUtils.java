package com.huawei.crowdtestsdk.bases.bean_new;

import android.content.Context;
import android.security.KeyPairGeneratorSpec.Builder;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.androidcommon.utils.IOUtils;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.uploadlog.p188c.C2511g;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

public class SecUtils {
    private static final String STRING = "lu_aliases";
    private static KeyStore ks;

    private static void init() {
        try {
            ks = KeyStore.getInstance("AndroidKeyStore");
            ks.load(null);
        } catch (KeyStoreException e) {
            C2511g.m12484d("BETACLUB_SDK", "init:" + e.getMessage());
        } catch (IOException e2) {
            C2511g.m12484d("BETACLUB_SDK", "init:" + e2.getMessage());
        } catch (NoSuchAlgorithmException e3) {
            C2511g.m12484d("BETACLUB_SDK", "init:" + e3.getMessage());
        } catch (CertificateException e4) {
            C2511g.m12484d("BETACLUB_SDK", "init:" + e4.getMessage());
        }
    }

    public static SecretKeySpec getAwsSks() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(128);
            return new SecretKeySpec(instance.generateKey().getEncoded(), "AES");
        } catch (NoSuchAlgorithmException e) {
            C2511g.m12484d("BETACLUB_SDK", "getSKS:" + e.getMessage());
            return null;
        }
    }

    private static void createString() {
        if (ks == null) {
            init();
        }
        if (ks != null) {
            try {
                Context applicationContext = AppContext.getInstance().getApplicationContext();
                if (!ks.containsAlias(STRING)) {
                    Calendar instance = Calendar.getInstance();
                    Calendar instance2 = Calendar.getInstance();
                    instance2.add(1, 1);
                    AlgorithmParameterSpec build = new Builder(applicationContext).setAlias(STRING).setSubject(new X500Principal("CN=Sample Name, O=Android Authority")).setSerialNumber(BigInteger.ONE).setStartDate(instance.getTime()).setEndDate(instance2.getTime()).build();
                    KeyPairGenerator instance3 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    instance3.initialize(build);
                    instance3.generateKeyPair();
                }
            } catch (Exception e) {
                C2511g.m12484d("BETACLUB_SDK", "createString:" + e.getMessage());
            }
        }
    }

    private static PublicKey getString1() {
        if (ks == null) {
            init();
        }
        if (ks == null) {
            return null;
        }
        try {
            if (!ks.containsAlias(STRING)) {
                createString();
            }
            return ((PrivateKeyEntry) ks.getEntry(STRING, null)).getCertificate().getPublicKey();
        } catch (NoSuchAlgorithmException e) {
            C2511g.m12484d("BETACLUB_SDK", "getString1:" + e.getMessage());
            return null;
        } catch (UnrecoverableEntryException e2) {
            C2511g.m12484d("BETACLUB_SDK", "getString1:" + e2.getMessage());
            return null;
        } catch (KeyStoreException e3) {
            C2511g.m12484d("BETACLUB_SDK", "getString1:" + e3.getMessage());
            return null;
        } catch (Exception e4) {
            C2511g.m12484d("BETACLUB_SDK", "getString1:" + e4.getMessage());
            return null;
        }
    }

    private static PrivateKey getString2() {
        if (ks == null) {
            init();
        }
        if (ks == null) {
            return null;
        }
        try {
            return ((PrivateKeyEntry) ks.getEntry(STRING, null)).getPrivateKey();
        } catch (NoSuchAlgorithmException e) {
            C2511g.m12484d("BETACLUB_SDK", "getString2:" + e.getMessage());
            return null;
        } catch (UnrecoverableEntryException e2) {
            C2511g.m12484d("BETACLUB_SDK", "getString2:" + e2.getMessage());
            return null;
        } catch (KeyStoreException e3) {
            C2511g.m12484d("BETACLUB_SDK", "getString2:" + e3.getMessage());
            return null;
        } catch (Exception e4) {
            C2511g.m12484d("BETACLUB_SDK", "getString2:" + e4.getMessage());
            return null;
        }
    }

    public static String getString1(String str) {
        Closeable byteArrayOutputStream;
        Closeable cipherOutputStream;
        InvalidKeyException e;
        Object obj;
        Throwable th;
        NoSuchAlgorithmException e2;
        NoSuchPaddingException e3;
        IOException e4;
        Exception e5;
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            Key string1 = getString1();
            if (string1 != null) {
                try {
                    Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    instance.init(1, string1);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, instance);
                    } catch (InvalidKeyException e6) {
                        e = e6;
                        obj = str2;
                        try {
                            C2511g.m12484d("BETACLUB_SDK", "getString1:" + e.getMessage());
                            IOUtils.close(cipherOutputStream);
                            IOUtils.close(byteArrayOutputStream);
                            return str2;
                        } catch (Throwable th2) {
                            th = th2;
                            IOUtils.close(cipherOutputStream);
                            IOUtils.close(byteArrayOutputStream);
                            throw th;
                        }
                    } catch (NoSuchAlgorithmException e7) {
                        e2 = e7;
                        obj = str2;
                        C2511g.m12484d("BETACLUB_SDK", "getString1:" + e2.getMessage());
                        IOUtils.close(cipherOutputStream);
                        IOUtils.close(byteArrayOutputStream);
                        return str2;
                    } catch (NoSuchPaddingException e8) {
                        e3 = e8;
                        obj = str2;
                        C2511g.m12484d("BETACLUB_SDK", "getString1:" + e3.getMessage());
                        IOUtils.close(cipherOutputStream);
                        IOUtils.close(byteArrayOutputStream);
                        return str2;
                    } catch (IOException e9) {
                        e4 = e9;
                        obj = str2;
                        C2511g.m12484d("BETACLUB_SDK", "getString1:" + e4.getMessage());
                        IOUtils.close(cipherOutputStream);
                        IOUtils.close(byteArrayOutputStream);
                        return str2;
                    } catch (Exception e10) {
                        e5 = e10;
                        obj = str2;
                        C2511g.m12484d("BETACLUB_SDK", "getString1:" + e5.getMessage());
                        IOUtils.close(cipherOutputStream);
                        IOUtils.close(byteArrayOutputStream);
                        return str2;
                    } catch (Throwable th3) {
                        obj = str2;
                        th = th3;
                        IOUtils.close(cipherOutputStream);
                        IOUtils.close(byteArrayOutputStream);
                        throw th;
                    }
                    try {
                        cipherOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                        cipherOutputStream.flush();
                        cipherOutputStream.close();
                        str2 = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                        IOUtils.close(cipherOutputStream);
                        IOUtils.close(byteArrayOutputStream);
                    } catch (InvalidKeyException e11) {
                        e = e11;
                        C2511g.m12484d("BETACLUB_SDK", "getString1:" + e.getMessage());
                        IOUtils.close(cipherOutputStream);
                        IOUtils.close(byteArrayOutputStream);
                        return str2;
                    } catch (NoSuchAlgorithmException e12) {
                        e2 = e12;
                        C2511g.m12484d("BETACLUB_SDK", "getString1:" + e2.getMessage());
                        IOUtils.close(cipherOutputStream);
                        IOUtils.close(byteArrayOutputStream);
                        return str2;
                    } catch (NoSuchPaddingException e13) {
                        e3 = e13;
                        C2511g.m12484d("BETACLUB_SDK", "getString1:" + e3.getMessage());
                        IOUtils.close(cipherOutputStream);
                        IOUtils.close(byteArrayOutputStream);
                        return str2;
                    } catch (IOException e14) {
                        e4 = e14;
                        C2511g.m12484d("BETACLUB_SDK", "getString1:" + e4.getMessage());
                        IOUtils.close(cipherOutputStream);
                        IOUtils.close(byteArrayOutputStream);
                        return str2;
                    } catch (Exception e15) {
                        e5 = e15;
                        C2511g.m12484d("BETACLUB_SDK", "getString1:" + e5.getMessage());
                        IOUtils.close(cipherOutputStream);
                        IOUtils.close(byteArrayOutputStream);
                        return str2;
                    }
                } catch (InvalidKeyException e16) {
                    e = e16;
                    cipherOutputStream = str2;
                    byteArrayOutputStream = str2;
                    C2511g.m12484d("BETACLUB_SDK", "getString1:" + e.getMessage());
                    IOUtils.close(cipherOutputStream);
                    IOUtils.close(byteArrayOutputStream);
                    return str2;
                } catch (NoSuchAlgorithmException e17) {
                    e2 = e17;
                    cipherOutputStream = str2;
                    byteArrayOutputStream = str2;
                    C2511g.m12484d("BETACLUB_SDK", "getString1:" + e2.getMessage());
                    IOUtils.close(cipherOutputStream);
                    IOUtils.close(byteArrayOutputStream);
                    return str2;
                } catch (NoSuchPaddingException e18) {
                    e3 = e18;
                    cipherOutputStream = str2;
                    byteArrayOutputStream = str2;
                    C2511g.m12484d("BETACLUB_SDK", "getString1:" + e3.getMessage());
                    IOUtils.close(cipherOutputStream);
                    IOUtils.close(byteArrayOutputStream);
                    return str2;
                } catch (IOException e19) {
                    e4 = e19;
                    cipherOutputStream = str2;
                    byteArrayOutputStream = str2;
                    C2511g.m12484d("BETACLUB_SDK", "getString1:" + e4.getMessage());
                    IOUtils.close(cipherOutputStream);
                    IOUtils.close(byteArrayOutputStream);
                    return str2;
                } catch (Exception e20) {
                    e5 = e20;
                    cipherOutputStream = str2;
                    byteArrayOutputStream = str2;
                    C2511g.m12484d("BETACLUB_SDK", "getString1:" + e5.getMessage());
                    IOUtils.close(cipherOutputStream);
                    IOUtils.close(byteArrayOutputStream);
                    return str2;
                } catch (Throwable th32) {
                    cipherOutputStream = str2;
                    byteArrayOutputStream = str2;
                    th = th32;
                    IOUtils.close(cipherOutputStream);
                    IOUtils.close(byteArrayOutputStream);
                    throw th;
                }
            }
        }
        return str2;
    }

    public static String getString2(String str) {
        Closeable byteArrayInputStream;
        InvalidKeyException e;
        Throwable th;
        NoSuchAlgorithmException e2;
        NoSuchPaddingException e3;
        IOException e4;
        Exception e5;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Key string2 = getString2();
        if (string2 == null) {
            return null;
        }
        Closeable cipherInputStream;
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, string2);
            byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str, 0));
            try {
                cipherInputStream = new CipherInputStream(byteArrayInputStream, instance);
            } catch (InvalidKeyException e6) {
                e = e6;
                cipherInputStream = null;
                try {
                    C2511g.m12484d("BETACLUB_SDK", "getString2:" + e.getMessage());
                    IOUtils.close(byteArrayInputStream);
                    IOUtils.close(cipherInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.close(byteArrayInputStream);
                    IOUtils.close(cipherInputStream);
                    throw th;
                }
            } catch (NoSuchAlgorithmException e7) {
                e2 = e7;
                cipherInputStream = null;
                C2511g.m12484d("BETACLUB_SDK", "getString2:" + e2.getMessage());
                IOUtils.close(byteArrayInputStream);
                IOUtils.close(cipherInputStream);
                return null;
            } catch (NoSuchPaddingException e8) {
                e3 = e8;
                cipherInputStream = null;
                C2511g.m12484d("BETACLUB_SDK", "getString2:" + e3.getMessage());
                IOUtils.close(byteArrayInputStream);
                IOUtils.close(cipherInputStream);
                return null;
            } catch (IOException e9) {
                e4 = e9;
                cipherInputStream = null;
                C2511g.m12484d("BETACLUB_SDK", "getString2:" + e4.getMessage());
                IOUtils.close(byteArrayInputStream);
                IOUtils.close(cipherInputStream);
                return null;
            } catch (Exception e10) {
                e5 = e10;
                cipherInputStream = null;
                C2511g.m12484d("BETACLUB_SDK", "getString2:" + e5.getMessage());
                IOUtils.close(byteArrayInputStream);
                IOUtils.close(cipherInputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                cipherInputStream = null;
                IOUtils.close(byteArrayInputStream);
                IOUtils.close(cipherInputStream);
                throw th;
            }
            try {
                int read;
                List arrayList = new ArrayList();
                while (true) {
                    read = cipherInputStream.read();
                    if (read == -1) {
                        break;
                    }
                    arrayList.add(Byte.valueOf((byte) read));
                }
                byte[] bArr = new byte[arrayList.size()];
                for (read = 0; read < bArr.length; read++) {
                    bArr[read] = ((Byte) arrayList.get(read)).byteValue();
                }
                String str2 = new String(bArr, 0, bArr.length, GameManager.DEFAULT_CHARSET);
                IOUtils.close(byteArrayInputStream);
                IOUtils.close(cipherInputStream);
                return str2;
            } catch (InvalidKeyException e11) {
                e = e11;
                C2511g.m12484d("BETACLUB_SDK", "getString2:" + e.getMessage());
                IOUtils.close(byteArrayInputStream);
                IOUtils.close(cipherInputStream);
                return null;
            } catch (NoSuchAlgorithmException e12) {
                e2 = e12;
                C2511g.m12484d("BETACLUB_SDK", "getString2:" + e2.getMessage());
                IOUtils.close(byteArrayInputStream);
                IOUtils.close(cipherInputStream);
                return null;
            } catch (NoSuchPaddingException e13) {
                e3 = e13;
                C2511g.m12484d("BETACLUB_SDK", "getString2:" + e3.getMessage());
                IOUtils.close(byteArrayInputStream);
                IOUtils.close(cipherInputStream);
                return null;
            } catch (IOException e14) {
                e4 = e14;
                C2511g.m12484d("BETACLUB_SDK", "getString2:" + e4.getMessage());
                IOUtils.close(byteArrayInputStream);
                IOUtils.close(cipherInputStream);
                return null;
            } catch (Exception e15) {
                e5 = e15;
                C2511g.m12484d("BETACLUB_SDK", "getString2:" + e5.getMessage());
                IOUtils.close(byteArrayInputStream);
                IOUtils.close(cipherInputStream);
                return null;
            }
        } catch (InvalidKeyException e16) {
            e = e16;
            byteArrayInputStream = null;
            cipherInputStream = null;
            C2511g.m12484d("BETACLUB_SDK", "getString2:" + e.getMessage());
            IOUtils.close(byteArrayInputStream);
            IOUtils.close(cipherInputStream);
            return null;
        } catch (NoSuchAlgorithmException e17) {
            e2 = e17;
            byteArrayInputStream = null;
            cipherInputStream = null;
            C2511g.m12484d("BETACLUB_SDK", "getString2:" + e2.getMessage());
            IOUtils.close(byteArrayInputStream);
            IOUtils.close(cipherInputStream);
            return null;
        } catch (NoSuchPaddingException e18) {
            e3 = e18;
            byteArrayInputStream = null;
            cipherInputStream = null;
            C2511g.m12484d("BETACLUB_SDK", "getString2:" + e3.getMessage());
            IOUtils.close(byteArrayInputStream);
            IOUtils.close(cipherInputStream);
            return null;
        } catch (IOException e19) {
            e4 = e19;
            byteArrayInputStream = null;
            cipherInputStream = null;
            C2511g.m12484d("BETACLUB_SDK", "getString2:" + e4.getMessage());
            IOUtils.close(byteArrayInputStream);
            IOUtils.close(cipherInputStream);
            return null;
        } catch (Exception e20) {
            e5 = e20;
            byteArrayInputStream = null;
            cipherInputStream = null;
            C2511g.m12484d("BETACLUB_SDK", "getString2:" + e5.getMessage());
            IOUtils.close(byteArrayInputStream);
            IOUtils.close(cipherInputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayInputStream = null;
            cipherInputStream = null;
            IOUtils.close(byteArrayInputStream);
            IOUtils.close(cipherInputStream);
            throw th;
        }
    }
}
