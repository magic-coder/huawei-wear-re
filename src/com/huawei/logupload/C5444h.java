package com.huawei.logupload;

import com.huawei.logupload.c.f;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.log4j.helpers.DateLayout;

/* compiled from: SecureNetSSLSocketFactory */
public class C5444h extends SSLSocketFactory {
    SSLContext f19277a = null;

    public C5444h() {
        try {
            this.f19277a = SSLContext.getInstance(org.apache.http.conn.ssl.SSLSocketFactory.TLS);
            this.f19277a.init(null, null, new SecureRandom());
        } catch (GeneralSecurityException e) {
            f.e("SecureNetSSLSocketFactory", "SSLContext init exception");
        }
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        SSLSocket sSLSocket = (SSLSocket) this.f19277a.getSocketFactory().createSocket(socket, str, i, z);
        C5444h.m26100a(sSLSocket);
        return sSLSocket;
    }

    public static void m26100a(SSLSocket sSLSocket) {
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        List arrayList = new ArrayList();
        String str = "";
        for (String str2 : enabledCipherSuites) {
            if (!(str2.toUpperCase(Locale.getDefault()).contains("RC2") || str2.toUpperCase(Locale.getDefault()).contains("RC4") || str2.toUpperCase(Locale.getDefault()).contains("DES") || str2.toUpperCase(Locale.getDefault()).contains("MD2") || str2.toUpperCase(Locale.getDefault()).contains("MD4") || str2.toUpperCase(Locale.getDefault()).contains("MD5") || str2.toUpperCase(Locale.getDefault()).contains("ANON") || str2.toUpperCase(Locale.getDefault()).contains(DateLayout.NULL_DATE_FORMAT) || str2.toUpperCase(Locale.getDefault()).contains("SKIPJACK") || str2.toUpperCase(Locale.getDefault()).contains("SHA1"))) {
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

    public Socket createSocket(String str, int i) {
        SSLSocket sSLSocket = (SSLSocket) this.f19277a.getSocketFactory().createSocket(str, i);
        C5444h.m26100a(sSLSocket);
        return sSLSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        SSLSocket sSLSocket = (SSLSocket) this.f19277a.getSocketFactory().createSocket(inetAddress, i);
        C5444h.m26100a(sSLSocket);
        return sSLSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        SSLSocket sSLSocket = (SSLSocket) this.f19277a.getSocketFactory().createSocket(str, i, inetAddress, i2);
        C5444h.m26100a(sSLSocket);
        return sSLSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        SSLSocket sSLSocket = (SSLSocket) this.f19277a.getSocketFactory().createSocket(inetAddress, i, inetAddress2, i2);
        C5444h.m26100a(sSLSocket);
        return sSLSocket;
    }
}
