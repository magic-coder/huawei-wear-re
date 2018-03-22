package com.huawei.phoneserviceuni.common.p493b;

import android.util.Log;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.log4j.helpers.DateLayout;

/* compiled from: HttpsSetting */
public class C5759a {

    /* compiled from: HttpsSetting */
    class C5758a extends SSLSocketFactory {
        SSLContext f19539a = null;
        private boolean f19540b = false;

        public C5758a(boolean z) {
            this.f19540b = z;
            try {
                this.f19539a = SSLContext.getInstance(org.apache.http.conn.ssl.SSLSocketFactory.TLS);
                this.f19539a.init(null, null, new SecureRandom());
            } catch (GeneralSecurityException e) {
                Log.e("SecureNetSSLSocketFactory", "SSLContext init exception");
            }
        }

        public static void m26444a(Socket socket) {
            if (socket != null && (socket instanceof SSLSocket)) {
                SSLSocket sSLSocket = (SSLSocket) socket;
                String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
                List arrayList = new ArrayList();
                for (String str : enabledCipherSuites) {
                    if (!(str.toUpperCase(Locale.getDefault()).contains("RC2") || str.toUpperCase(Locale.getDefault()).contains("RC4") || str.toUpperCase(Locale.getDefault()).contains("DES") || str.toUpperCase(Locale.getDefault()).contains("MD2") || str.toUpperCase(Locale.getDefault()).contains("MD4") || str.toUpperCase(Locale.getDefault()).contains("MD5") || str.toUpperCase(Locale.getDefault()).contains("ANON") || str.toUpperCase(Locale.getDefault()).contains(DateLayout.NULL_DATE_FORMAT) || str.toUpperCase(Locale.getDefault()).contains("SKIPJACK") || str.toUpperCase(Locale.getDefault()).contains("SHA1"))) {
                        arrayList.add(str);
                    }
                }
                sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
            }
        }

        private void m26445b(Socket socket) {
            if (this.f19540b && socket != null && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            }
        }

        public String[] getDefaultCipherSuites() {
            return new String[0];
        }

        public String[] getSupportedCipherSuites() {
            return new String[0];
        }

        public Socket createSocket(Socket socket, String str, int i, boolean z) {
            Socket createSocket = this.f19539a.getSocketFactory().createSocket(socket, str, i, z);
            m26445b(createSocket);
            C5758a.m26444a(createSocket);
            return createSocket;
        }

        public Socket createSocket(String str, int i) {
            Socket createSocket = this.f19539a.getSocketFactory().createSocket(str, i);
            m26445b(createSocket);
            C5758a.m26444a(createSocket);
            return createSocket;
        }

        public Socket createSocket(InetAddress inetAddress, int i) {
            Socket createSocket = this.f19539a.getSocketFactory().createSocket(inetAddress, i);
            m26445b(createSocket);
            C5758a.m26444a(createSocket);
            return createSocket;
        }

        public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
            Socket createSocket = this.f19539a.getSocketFactory().createSocket(str, i, inetAddress, i2);
            m26445b(createSocket);
            C5758a.m26444a(createSocket);
            return createSocket;
        }

        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
            Socket createSocket = this.f19539a.getSocketFactory().createSocket(inetAddress, i, inetAddress2, i2);
            m26445b(createSocket);
            C5758a.m26444a(createSocket);
            return createSocket;
        }
    }

    public static void m26446a() {
        SSLSocketFactory c5758a;
        try {
            c5758a = new C5758a(true);
        } catch (Exception e) {
            Log.e("HttpsSetting", "SecureNetSSLSocketFactory Exception");
            c5758a = null;
        }
        if (c5758a != null) {
            HttpsURLConnection.setDefaultSSLSocketFactory(c5758a);
        }
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        } catch (Exception e2) {
            Log.e("HttpsSetting", "Fail to set DefaultHostnameVerifier!");
        }
    }
}
