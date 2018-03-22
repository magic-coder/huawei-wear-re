package com.huawei.android.pushagent.p020b.p021a.p327b;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p018c.C4122f.C4121a;
import com.huawei.android.pushagent.p018c.p019a.C4104d;
import com.huawei.android.pushagent.p018c.p019a.p026a.C4100f;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class C4082d implements C4078b {
    private Context f15454a;
    private SSLSocket f15455b = null;
    private InputStream f15456c;
    private OutputStream f15457d;

    public C4082d(Context context) {
        this.f15454a = context;
    }

    public synchronized void mo4369a() {
        e.a("PushLogAC2712", "enter SSLPushChannel:close()");
        try {
            if (this.f15456c != null) {
                this.f15456c.close();
            }
            this.f15456c = null;
        } catch (Throwable e) {
            e.c("PushLogAC2712", "close dis error: " + e.toString(), e);
            this.f15456c = null;
        } catch (Throwable th) {
            this.f15456c = null;
        }
        try {
            if (this.f15457d != null) {
                this.f15457d.close();
            }
            this.f15457d = null;
        } catch (Throwable e2) {
            e.c("PushLogAC2712", "close dos error: " + e2.toString(), e2);
            this.f15457d = null;
        } catch (Throwable th2) {
            this.f15457d = null;
        }
        try {
            if (!(this.f15455b == null || this.f15455b.isClosed())) {
                this.f15455b.close();
            }
            this.f15455b = null;
        } catch (Throwable e22) {
            e.c("PushLogAC2712", "close socket error: " + e22.toString(), e22);
            this.f15455b = null;
        } catch (Throwable th3) {
            this.f15455b = null;
        }
    }

    public boolean mo4370a(Socket socket) throws Exception {
        if (socket == null || !socket.isConnected()) {
            e.d("PushLogAC2712", "when init SSL Channel, socket is not ready:" + socket);
            return false;
        }
        e.a("PushLogAC2712", "enter SSLChannel:init(" + socket.getRemoteSocketAddress() + ")");
        SSLContext instance = SSLContext.getInstance(SSLSocketFactory.TLS);
        TrustManagerFactory instance2 = TrustManagerFactory.getInstance("X509");
        KeyStore instance3 = KeyStore.getInstance("BKS");
        InputStream open = this.f15454a.getAssets().open("rootca_0727.bks");
        try {
            open.reset();
            instance3.load(open, C4100f.m20116b(null, C4104d.m20128b()).toCharArray());
            if (open != null) {
                open.close();
            }
            instance2.init(instance3);
            instance.init(null, instance2.getTrustManagers(), null);
            InetAddress inetAddress = socket.getInetAddress();
            if (inetAddress == null) {
                return false;
            }
            InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, socket.getPort());
            Socket createSocket = instance.getSocketFactory().createSocket(socket, inetAddress.getHostAddress(), socket.getPort(), true);
            if (createSocket instanceof SSLSocket) {
                this.f15455b = (SSLSocket) createSocket;
            }
            if (this.f15455b == null) {
                return false;
            }
            this.f15455b.setEnabledCipherSuites(C4121a.m20164a());
            e.a("PushLogAC2712", "server ip:" + inetSocketAddress.getAddress().getHostAddress() + ",server port:" + inetSocketAddress.getPort() + ",socket ip:" + this.f15455b.getLocalAddress().getHostAddress() + ",socket port:" + this.f15455b.getLocalPort() + ",pkgName:" + this.f15454a.getPackageName());
            this.f15456c = this.f15455b.getInputStream();
            this.f15457d = this.f15455b.getOutputStream();
            this.f15455b.setSoTimeout(0);
            return true;
        } catch (Exception e) {
            throw e;
        } catch (Throwable th) {
            if (open != null) {
                open.close();
            }
        }
    }

    public boolean mo4371a(byte[] bArr) throws Exception {
        try {
            if (this.f15457d == null || bArr == null) {
                e.d("PushLogAC2712", "when send msg:" + Arrays.toString(bArr) + " dos is null, or msg is null");
                return false;
            }
            this.f15457d.write(bArr);
            this.f15457d.flush();
            return true;
        } catch (Throwable e) {
            e.c("PushLogAC2712", "call send cause:" + e.toString(), e);
            mo4369a();
        }
    }

    public boolean mo4372b() {
        return (this.f15455b == null || !this.f15455b.isConnected() || this.f15456c == null || this.f15457d == null) ? false : true;
    }

    public Socket mo4373c() {
        return this.f15455b;
    }

    public InputStream mo4374d() {
        return this.f15456c;
    }
}
