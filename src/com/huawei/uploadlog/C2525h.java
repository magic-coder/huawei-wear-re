package com.huawei.uploadlog;

import com.huawei.uploadlog.p188c.C2511g;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.log4j.helpers.DateLayout;

/* compiled from: SecureNetSSLSocketFactory */
public class C2525h extends SSLSocketFactory {
    SSLContext f9010a = null;

    public C2525h() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        try {
            this.f9010a = SSLContext.getInstance(org.apache.http.conn.ssl.SSLSocketFactory.TLS);
            this.f9010a.init(null, new X509TrustManager[]{new C2526i(this)}, new SecureRandom());
        } catch (GeneralSecurityException e) {
            C2511g.m12484d("SecureNetSSLSocketFactory", "SSLContext init exception");
        }
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.f9010a.getSocketFactory().createSocket(socket, str, i, z);
        C2525h.m12600a(sSLSocket);
        return sSLSocket;
    }

    public static void m12600a(SSLSocket sSLSocket) {
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        List arrayList = new ArrayList();
        String str = "";
        for (String str2 : enabledCipherSuites) {
            String toUpperCase = str2.toUpperCase();
            if (!(toUpperCase.contains("RC4") || toUpperCase.contains("DES") || toUpperCase.contains("MD5") || toUpperCase.contains("ANON") || toUpperCase.contains(DateLayout.NULL_DATE_FORMAT))) {
                arrayList.add(str2);
            }
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public String[] getDefaultCipherSuites() {
        return null;
    }

    public String[] getSupportedCipherSuites() {
        return null;
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        SSLSocket sSLSocket = (SSLSocket) this.f9010a.getSocketFactory().createSocket(str, i);
        C2525h.m12600a(sSLSocket);
        return sSLSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.f9010a.getSocketFactory().createSocket(inetAddress, i);
        C2525h.m12600a(sSLSocket);
        return sSLSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        SSLSocket sSLSocket = (SSLSocket) this.f9010a.getSocketFactory().createSocket(str, i, inetAddress, i2);
        C2525h.m12600a(sSLSocket);
        return sSLSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.f9010a.getSocketFactory().createSocket(inetAddress, i, inetAddress2, i2);
        C2525h.m12600a(sSLSocket);
        return sSLSocket;
    }
}
