package com.huawei.wallet.utils;

import com.huawei.wallet.utils.log.LogC;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.log4j.helpers.DateLayout;

public class WalletSSLSocketFactory extends SSLSocketFactory {
    private static String[] f21606a = null;
    private SSLContext f21607b = null;

    public WalletSSLSocketFactory(X509TrustManager x509TrustManager) {
        try {
            this.f21607b = SSLContext.getInstance(org.apache.http.conn.ssl.SSLSocketFactory.TLS);
            this.f21607b.init(null, new X509TrustManager[]{x509TrustManager}, new SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            LogC.m28534d("SSLContext init exception", false);
        } catch (KeyManagementException e2) {
            LogC.m28534d("SSLContext init exception", false);
        }
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.f21607b.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket == null || !(createSocket instanceof SSLSocket)) {
            return createSocket;
        }
        SSLSocket sSLSocket = (SSLSocket) createSocket;
        m28491a(sSLSocket);
        return sSLSocket;
    }

    private static void m28491a(SSLSocket sSLSocket) {
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        List arrayList = new ArrayList();
        String str = "";
        for (String str2 : enabledCipherSuites) {
            String toUpperCase = str2.toUpperCase(Locale.ENGLISH);
            if (!(toUpperCase.contains("RC4") || toUpperCase.contains("DES") || toUpperCase.contains("MD5") || toUpperCase.contains("ANON") || toUpperCase.contains(DateLayout.NULL_DATE_FORMAT) || toUpperCase.contains("TLS_EMPTY_RENEGOTIATION_INFO_SCSV"))) {
                arrayList.add(str2);
            }
        }
        f21606a = (String[]) arrayList.toArray(new String[arrayList.size()]);
        sSLSocket.setEnabledCipherSuites(f21606a);
    }

    public String[] getDefaultCipherSuites() {
        if (f21606a != null) {
            return (String[]) f21606a.clone();
        }
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    public Socket createSocket(String str, int i) throws IOException {
        Socket createSocket = this.f21607b.getSocketFactory().createSocket(str, i);
        if (createSocket == null || !(createSocket instanceof SSLSocket)) {
            return createSocket;
        }
        SSLSocket sSLSocket = (SSLSocket) createSocket;
        m28491a(sSLSocket);
        return sSLSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = this.f21607b.getSocketFactory().createSocket(inetAddress, i);
        if (createSocket == null || !(createSocket instanceof SSLSocket)) {
            return createSocket;
        }
        SSLSocket sSLSocket = (SSLSocket) createSocket;
        m28491a(sSLSocket);
        return sSLSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket createSocket = this.f21607b.getSocketFactory().createSocket(str, i, inetAddress, i2);
        if (createSocket == null || !(createSocket instanceof SSLSocket)) {
            return createSocket;
        }
        SSLSocket sSLSocket = (SSLSocket) createSocket;
        m28491a(sSLSocket);
        return sSLSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = this.f21607b.getSocketFactory().createSocket(inetAddress, i, inetAddress2, i2);
        if (createSocket == null || !(createSocket instanceof SSLSocket)) {
            return createSocket;
        }
        SSLSocket sSLSocket = (SSLSocket) createSocket;
        m28491a(sSLSocket);
        return sSLSocket;
    }
}
