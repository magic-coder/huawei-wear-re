package com.huawei.android.pushagent.p020b.p021a.p327b;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import java.io.InputStream;
import java.net.Socket;

public class C4081c implements C4078b {
    Socket f15453a;

    public C4081c(Context context) {
    }

    public void mo4369a() throws Exception {
        if (this.f15453a != null) {
            this.f15453a.close();
        }
    }

    public boolean mo4370a(Socket socket) {
        e.a("PushLogAC2712", "enter NormalChannel:init(" + socket.getRemoteSocketAddress() + ")");
        if (socket.isConnected()) {
            this.f15453a = socket;
            return true;
        }
        e.d("PushLogAC2712", "when init SSL Channel, socket is not ready:" + socket);
        return false;
    }

    public boolean mo4371a(byte[] bArr) throws Exception {
        if (this.f15453a == null || this.f15453a.getOutputStream() == null) {
            e.d("PushLogAC2712", "when call send, socket is not ready!!");
            return false;
        }
        this.f15453a.getOutputStream().write(bArr);
        this.f15453a.getOutputStream().flush();
        return true;
    }

    public boolean mo4372b() {
        return this.f15453a != null && this.f15453a.isConnected();
    }

    public Socket mo4373c() {
        return this.f15453a;
    }

    public InputStream mo4374d() {
        if (this.f15453a != null) {
            try {
                return this.f15453a.getInputStream();
            } catch (Throwable e) {
                e.c("PushLogAC2712", "call socket.getInputStream cause:" + e.toString(), e);
            }
        }
        return null;
    }
}
