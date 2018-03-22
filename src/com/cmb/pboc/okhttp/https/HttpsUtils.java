package com.cmb.pboc.okhttp.https;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class HttpsUtils {

    class MyTrustManager implements X509TrustManager {
        private X509TrustManager f13454a;
        private X509TrustManager f13455b;

        public MyTrustManager(X509TrustManager x509TrustManager) {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(null);
            this.f13454a = HttpsUtils.m17756b(instance.getTrustManagers());
            this.f13455b = x509TrustManager;
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            try {
                this.f13454a.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException e) {
                this.f13455b.checkServerTrusted(x509CertificateArr, str);
            }
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    class UnSafeTrustManager implements X509TrustManager {
        private UnSafeTrustManager() {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static SSLSocketFactory m17752a(InputStream[] inputStreamArr, InputStream inputStream, String str) {
        try {
            TrustManager[] a = m17755a(inputStreamArr);
            KeyManager[] a2 = m17754a(null, null);
            SSLContext instance = SSLContext.getInstance(org.apache.http.conn.ssl.SSLSocketFactory.TLS);
            MyTrustManager myTrustManager = a != null ? new MyTrustManager(m17756b(a)) : new UnSafeTrustManager();
            instance.init(a2, new TrustManager[]{myTrustManager}, new SecureRandom());
            return instance.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        } catch (KeyManagementException e2) {
            throw new AssertionError(e2);
        } catch (KeyStoreException e3) {
            throw new AssertionError(e3);
        }
    }

    private static KeyManager[] m17754a(InputStream inputStream, String str) {
        KeyManager[] keyManagerArr = null;
        if (!(inputStream == null || str == null)) {
            try {
                KeyStore instance = KeyStore.getInstance("BKS");
                instance.load(inputStream, str.toCharArray());
                KeyManagerFactory instance2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                instance2.init(instance, str.toCharArray());
                keyManagerArr = instance2.getKeyManagers();
            } catch (KeyStoreException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (UnrecoverableKeyException e3) {
                e3.printStackTrace();
            } catch (CertificateException e4) {
                e4.printStackTrace();
            } catch (IOException e5) {
                e5.printStackTrace();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return keyManagerArr;
    }

    private static TrustManager[] m17755a(InputStream... inputStreamArr) {
        int i = 0;
        if (inputStreamArr == null || inputStreamArr.length <= 0) {
            return null;
        }
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
            instance2.load(null);
            int length = inputStreamArr.length;
            int i2 = 0;
            while (i < length) {
                InputStream inputStream = inputStreamArr[i];
                int i3 = i2 + 1;
                instance2.setCertificateEntry(Integer.toString(i2), instance.generateCertificate(inputStream));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
                i++;
                i2 = i3;
            }
            TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance3.init(instance2);
            return instance3.getTrustManagers();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (CertificateException e3) {
            e3.printStackTrace();
            return null;
        } catch (KeyStoreException e4) {
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private static X509TrustManager m17756b(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }
}
