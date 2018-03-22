package com.huawei.hms.update.p047b;

import com.huawei.hms.support.log.C0887a;
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
final class C0913e extends SSLSocketFactory {
    private static final Object f1504a = new Object();
    private static SocketFactory f1505c;
    private final SSLContext f1506b = SSLContext.getInstance("TLSv1.2");

    private C0913e() throws NoSuchAlgorithmException, KeyManagementException {
        this.f1506b.init(null, null, null);
    }

    public static SocketFactory m3190a() {
        SocketFactory socketFactory;
        synchronized (f1504a) {
            try {
                if (f1505c == null) {
                    f1505c = new C0913e();
                }
                socketFactory = f1505c;
            } catch (KeyManagementException e) {
                GeneralSecurityException e2 = e;
                C0887a.m3098d("TLSSocketFactory", "Failed to new TLSSocketFactory instance." + e2.getMessage());
                socketFactory = SSLSocketFactory.getDefault();
                return socketFactory;
            } catch (NoSuchAlgorithmException e3) {
                e2 = e3;
                C0887a.m3098d("TLSSocketFactory", "Failed to new TLSSocketFactory instance." + e2.getMessage());
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
        Socket createSocket = this.f1506b.getSocketFactory().createSocket(socket, str, i, z);
        m3191a(createSocket);
        return createSocket;
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        Socket createSocket = this.f1506b.getSocketFactory().createSocket(str, i);
        m3191a(createSocket);
        return createSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        Socket createSocket = this.f1506b.getSocketFactory().createSocket(str, i, inetAddress, i2);
        m3191a(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = this.f1506b.getSocketFactory().createSocket(inetAddress, i);
        m3191a(createSocket);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = this.f1506b.getSocketFactory().createSocket(inetAddress, i, inetAddress2, i2);
        m3191a(createSocket);
        return createSocket;
    }

    private void m3191a(Socket socket) {
        if (socket instanceof SSLSocket) {
            m3193b((SSLSocket) socket);
            C0913e.m3192a((SSLSocket) socket);
        }
    }

    private void m3193b(SSLSocket sSLSocket) {
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
    }

    public static void m3192a(SSLSocket sSLSocket) {
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
