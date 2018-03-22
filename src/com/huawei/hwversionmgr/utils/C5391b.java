package com.huawei.hwversionmgr.utils;

import com.huawei.p190v.C2538c;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.log4j.helpers.DateLayout;

/* compiled from: HwOucSSLSocketFactory */
public class C5391b extends SSLSocketFactory {
    private SSLSocketFactory f19182a;

    public C5391b(SSLSocketFactory sSLSocketFactory) {
        this.f19182a = sSLSocketFactory;
    }

    public Socket createSocket() throws IOException {
        Socket createSocket = this.f19182a.createSocket();
        m25946a(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return null;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.f19182a.createSocket(socket, str, i, z);
        m25946a(createSocket);
        return createSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return null;
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        Socket createSocket = this.f19182a.createSocket(str, i);
        m25946a(createSocket);
        return createSocket;
    }

    private void m25946a(Socket socket) {
        C2538c.c("HwOucSSLSocketFactory", new Object[]{"enter setEnableSafeCipherSuites"});
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            if (enabledCipherSuites == null || enabledCipherSuites.length == 0) {
                C2538c.c("HwOucSSLSocketFactory", new Object[]{"Current enabled cipherSuites is invalid!"});
                return;
            }
            List arrayList = new ArrayList();
            for (String str : enabledCipherSuites) {
                String toUpperCase = str.toUpperCase(Locale.US);
                if (!(toUpperCase.contains("RC4") || toUpperCase.contains("DES") || toUpperCase.contains("MD5") || toUpperCase.contains(DateLayout.NULL_DATE_FORMAT) || toUpperCase.contains("ANON"))) {
                    arrayList.add(str);
                }
            }
            sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
            sSLSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
            return;
        }
        C2538c.c("HwOucSSLSocketFactory", new Object[]{"socket is not instanceof SSLSocket"});
    }

    public String[] getDefaultCipherSuites() {
        return this.f19182a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f19182a.getSupportedCipherSuites();
    }
}
