package com.huawei.multisimsdk.multidevicemanager.p105e;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: TlsAdapterSocketFactory */
public class C1184j extends SSLSocketFactory {
    private static final String[] f2600a = new String[]{"TLSv1.1", "TLSv1.2"};
    private final SSLSocketFactory f2601b;

    public C1184j(SSLSocketFactory sSLSocketFactory) {
        this.f2601b = sSLSocketFactory;
    }

    public String[] getDefaultCipherSuites() {
        if (this.f2601b != null) {
            return this.f2601b.getDefaultCipherSuites();
        }
        return null;
    }

    public String[] getSupportedCipherSuites() {
        if (this.f2601b != null) {
            return this.f2601b.getSupportedCipherSuites();
        }
        return null;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        if (this.f2601b != null) {
            return m5289a(this.f2601b.createSocket(socket, str, i, z));
        }
        return null;
    }

    public Socket createSocket(String str, int i) throws IOException {
        if (this.f2601b != null) {
            return m5289a(this.f2601b.createSocket(str, i));
        }
        return null;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        if (this.f2601b != null) {
            return m5289a(this.f2601b.createSocket(str, i, inetAddress, i2));
        }
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        if (this.f2601b != null) {
            return m5289a(this.f2601b.createSocket(inetAddress, i));
        }
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        if (this.f2601b != null) {
            return m5289a(this.f2601b.createSocket(inetAddress, i, inetAddress2, i2));
        }
        return null;
    }

    private Socket m5289a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(f2600a);
        }
        return socket;
    }
}
