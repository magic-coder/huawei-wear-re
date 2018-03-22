package com.huawei.hwid.update.p451b;

import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.log4j.helpers.DateLayout;

/* compiled from: HttpsUtils */
final class C5275e extends SSLSocketFactory {
    private static final Object f18958a = new Object();
    private static SocketFactory f18959c;
    private final SSLContext f18960b = SSLContext.getInstance("TLSv1.2");

    private C5275e() throws NoSuchAlgorithmException, KeyManagementException {
        this.f18960b.init(null, null, null);
    }

    public static SocketFactory m25544a() {
        SocketFactory socketFactory;
        synchronized (f18958a) {
            try {
                if (f18959c == null) {
                    f18959c = new C5275e();
                }
                socketFactory = f18959c;
            } catch (KeyManagementException e) {
                GeneralSecurityException e2 = e;
                C5165e.m24910d("TLSSocketFactory", "Failed to new TLSSocketFactory instance." + e2.getMessage());
                socketFactory = SSLSocketFactory.getDefault();
                return socketFactory;
            } catch (NoSuchAlgorithmException e3) {
                e2 = e3;
                C5165e.m24910d("TLSSocketFactory", "Failed to new TLSSocketFactory instance." + e2.getMessage());
                socketFactory = SSLSocketFactory.getDefault();
                return socketFactory;
            }
        }
        return socketFactory;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.f18960b.getSocketFactory().createSocket(socket, str, i, z);
        m25545a(createSocket);
        return createSocket;
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        Socket createSocket = this.f18960b.getSocketFactory().createSocket(str, i);
        m25545a(createSocket);
        return createSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        Socket createSocket = this.f18960b.getSocketFactory().createSocket(str, i, inetAddress, i2);
        m25545a(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = this.f18960b.getSocketFactory().createSocket(inetAddress, i);
        m25545a(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = this.f18960b.getSocketFactory().createSocket(inetAddress, i, inetAddress2, i2);
        m25545a(createSocket);
        return createSocket;
    }

    private void m25545a(Socket socket) {
        if (socket instanceof SSLSocket) {
            m25547b((SSLSocket) socket);
            C5275e.m25546a((SSLSocket) socket);
        }
    }

    private void m25547b(SSLSocket sSLSocket) {
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
    }

    public static void m25546a(SSLSocket sSLSocket) {
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        if (enabledCipherSuites != null && enabledCipherSuites.length != 0) {
            List arrayList = new ArrayList();
            for (String str : enabledCipherSuites) {
                if (!(str.contains("RC2") || str.contains("RC4") || str.contains("DES") || str.contains("MD2") || str.contains("MD4") || str.contains("MD5") || str.contains("ANON") || str.contains(DateLayout.NULL_DATE_FORMAT) || str.contains("SKIPJACK") || str.contains("SHA1"))) {
                    arrayList.add(str);
                }
            }
            sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        }
    }
}
