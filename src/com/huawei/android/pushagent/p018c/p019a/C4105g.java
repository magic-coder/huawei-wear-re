package com.huawei.android.pushagent.p018c.p019a;

import com.huawei.android.pushagent.c.a.e;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class C4105g extends SSLSocketFactory {
    private SSLSocketFactory f15494a;

    public C4105g(SSLSocketFactory sSLSocketFactory) {
        this.f15494a = sSLSocketFactory;
    }

    private void m20129a(Socket socket) {
        e.a("PushLogSC2712", "enter setEnableSafeCipherSuites");
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            if (enabledCipherSuites == null || enabledCipherSuites.length == 0) {
                e.c("PushLogSC2712", "Current enabled cipherSuites is invalid!");
                return;
            }
            List arrayList = new ArrayList();
            for (String str : enabledCipherSuites) {
                if (!str.contains("RC4")) {
                    arrayList.add(str);
                }
            }
            sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
            return;
        }
        e.d("PushLogSC2712", "socket is not instanceof SSLSocket");
    }

    public Socket createSocket() throws IOException {
        Socket createSocket = this.f15494a.createSocket();
        m20129a(createSocket);
        return createSocket;
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        Socket createSocket = this.f15494a.createSocket(str, i);
        m20129a(createSocket);
        return createSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        Socket createSocket = this.f15494a.createSocket(str, i, inetAddress, i2);
        m20129a(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = this.f15494a.createSocket(inetAddress, i);
        m20129a(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = this.f15494a.createSocket(inetAddress, i, inetAddress2, i2);
        m20129a(createSocket);
        return createSocket;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.f15494a.createSocket(socket, str, i, z);
        m20129a(createSocket);
        return createSocket;
    }

    public String[] getDefaultCipherSuites() {
        return this.f15494a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f15494a.getSupportedCipherSuites();
    }
}
