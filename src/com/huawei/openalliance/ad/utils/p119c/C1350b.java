package com.huawei.openalliance.ad.utils.p119c;

import android.os.Build.VERSION;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class C1350b extends SSLSocketFactory {
    SSLContext f2937a = SSLContext.getInstance(SSLSocketFactory.TLS);

    public C1350b(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.f2937a.init(null, null, new SecureRandom());
    }

    public static void m5968a(SSLSocket sSLSocket) {
        int i = 0;
        if (sSLSocket == null) {
            C1336d.m5888c("SNSSSL", "socket param is null.");
            return;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        List arrayList = new ArrayList();
        int length = enabledCipherSuites.length;
        while (i < length) {
            String str = enabledCipherSuites[i];
            if (!(str.contains("aNull") || str.contains("eNull") || str.contains("LOW") || str.contains("MD5") || str.contains("EXP") || str.contains("SRP") || str.contains("DSS") || str.contains("PSK") || str.contains("RC4") || str.contains("DES"))) {
                arrayList.add(str);
            }
            i++;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    static void m5969b(SSLSocket sSLSocket) {
        if (sSLSocket != null && VERSION.SDK_INT >= 16) {
            sSLSocket.setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
        }
    }

    public Socket createSocket() throws IOException {
        Socket createSocket = this.f2937a.getSocketFactory().createSocket();
        createSocket = createSocket instanceof SSLSocket ? (SSLSocket) createSocket : null;
        C1350b.m5968a(createSocket);
        C1350b.m5969b(createSocket);
        return createSocket;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        Socket createSocket = this.f2937a.getSocketFactory().createSocket(socket, str, i, z);
        createSocket = createSocket instanceof SSLSocket ? (SSLSocket) createSocket : null;
        C1350b.m5968a(createSocket);
        C1350b.m5969b(createSocket);
        return createSocket;
    }
}
