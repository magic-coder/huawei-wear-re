package com.snowballtech.data.interaction.net;

import com.snowballtech.common.log.LogUtil;
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
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient.Builder;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class SetHttpCertificate {
    Builder client;

    class C62351 implements X509TrustManager {
        C62351() {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public class DefaultTrustManager implements X509TrustManager {
        public DefaultTrustManager(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyStoreException {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public SetHttpCertificate(Builder builder) {
        this.client = builder;
    }

    public void setCertificates(InputStream... inputStreamArr) {
        setCertificates(inputStreamArr, null, null);
    }

    public void setEmptyCert() {
        try {
            LogUtil.log(" access_server  SetHttpCertificate setEmptyCert ");
            SSLContext instance = SSLContext.getInstance(SSLSocketFactory.SSL);
            instance.init(null, new TrustManager[]{new C62351()}, new SecureRandom());
            this.client.sslSocketFactory(instance.getSocketFactory());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
    }

    public TrustManager[] prepareTrustManager(InputStream... inputStreamArr) {
        int i = 0;
        TrustManager[] trustManagerArr = null;
        if (inputStreamArr != null && inputStreamArr.length > 0) {
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
                trustManagerArr = instance3.getTrustManagers();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            } catch (CertificateException e3) {
                e3.printStackTrace();
            } catch (KeyStoreException e4) {
                e4.printStackTrace();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return trustManagerArr;
    }

    public KeyManager[] prepareKeyManager(InputStream inputStream, String str) {
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

    public void setCertificates(InputStream[] inputStreamArr, InputStream inputStream, String str) {
        try {
            TrustManager[] prepareTrustManager = prepareTrustManager(inputStreamArr);
            KeyManager[] prepareKeyManager = prepareKeyManager(inputStream, str);
            SSLContext instance = SSLContext.getInstance(SSLSocketFactory.TLS);
            instance.init(prepareKeyManager, new TrustManager[]{new DefaultTrustManager(chooseTrustManager(prepareTrustManager))}, new SecureRandom());
            this.client.sslSocketFactory(instance.getSocketFactory());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e2) {
            e2.printStackTrace();
        } catch (KeyStoreException e3) {
            e3.printStackTrace();
        }
    }

    private X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }
}
