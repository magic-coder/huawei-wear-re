package com.huawei.android.pushagent.p020b.p021a.p324a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.b.a.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.C4036b;
import com.huawei.android.pushagent.p017a.C4060c;
import com.huawei.android.pushagent.p017a.C4061d;
import com.huawei.android.pushagent.p020b.p021a.a$a;
import com.huawei.android.pushagent.p020b.p021a.p324a.C4069c.C4076a;
import com.huawei.android.pushagent.p020b.p021a.p327b.C4078b;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.net.Socket;

public abstract class C4065a {
    public C4061d f15408a;
    public C4069c f15409b;
    public C4078b f15410c;
    public Context f15411d;
    public C4067b f15412e;
    protected WakeLock f15413f = null;
    private PowerManager f15414g;

    enum C4063a {
        CONNECT_METHOD_DIRECT_TrsPort,
        CONNECT_METHOD_DIRECT_DefaultPort,
        CONNECT_METHOD_Proxy_TrsPort,
        CONNECT_METHOD_Proxy_DefaultPort
    }

    public C4065a(C4061d c4061d, Context context, C4067b c4067b, String str) {
        this.f15411d = context;
        this.f15408a = c4061d;
        this.f15412e = c4067b;
        this.f15414g = (PowerManager) context.getSystemService("power");
    }

    protected C4061d m19939a(int i, int i2) {
        switch (C4063a.values()[m19945b(i, i2)]) {
            case CONNECT_METHOD_DIRECT_TrsPort:
                return new C4061d(this.f15408a.f15391a, this.f15408a.f15392b, false, this.f15408a.f15393c);
            case CONNECT_METHOD_DIRECT_DefaultPort:
                return new C4061d(this.f15408a.f15391a, 443, false, this.f15408a.f15393c);
            case CONNECT_METHOD_Proxy_TrsPort:
                return new C4061d(this.f15408a.f15391a, 443, true, this.f15408a.f15393c);
            case CONNECT_METHOD_Proxy_DefaultPort:
                return new C4061d(this.f15408a.f15391a, this.f15408a.f15392b, true, this.f15408a.f15393c);
            default:
                return null;
        }
    }

    public abstract void mo4357a(C4076a c4076a, Bundle bundle);

    public abstract void mo4358a(boolean z) throws C4060c;

    public abstract void mo4359a(boolean z, boolean z2) throws C4060c;

    public boolean m19943a() {
        return this.f15410c != null && this.f15410c.mo4372b();
    }

    public synchronized boolean m19944a(C4036b c4036b) throws Exception {
        boolean z = false;
        synchronized (this) {
            if (this.f15410c == null || this.f15410c.mo4373c() == null) {
                e.d("PushLogAC2712", "when send pushMsg, channel is null， curCls:" + getClass().getSimpleName());
            } else {
                if (a.c() == mo4360e()) {
                    this.f15410c.mo4373c().setSoTimeout(0);
                } else {
                    this.f15410c.mo4373c().setSoTimeout((int) (this.f15412e.mo4361b(false) + com.huawei.android.pushagent.b.b.a.a(this.f15411d).Q()));
                }
                byte[] bArr = null;
                if (c4036b != null) {
                    bArr = c4036b.mo4355b();
                } else {
                    e.d("PushLogAC2712", "pushMsg = null, send fail");
                }
                if (bArr == null || bArr.length == 0) {
                    e.b("PushLogAC2712", "when send PushMsg, encode Len is null");
                } else {
                    e.b("PushLogAC2712", "read to Send:" + com.huawei.android.pushagent.c.a.a(c4036b.mo4353a()));
                    if (this.f15410c.mo4371a(bArr)) {
                        PushService.a(new Intent("com.huawei.android.push.intent.MSG_SENT").putExtra("push_msg", c4036b));
                        z = true;
                    } else {
                        e.d("PushLogAC2712", "call channel.send false!!");
                    }
                }
            }
        }
        return z;
    }

    protected int m19945b(int i, int i2) {
        return Math.abs(i + i2) % C4063a.values().length;
    }

    protected synchronized void m19946b() {
        this.f15413f = this.f15414g.newWakeLock(1, "mWakeLockForThread");
        this.f15413f.setReferenceCounted(false);
        this.f15413f.acquire(1000);
    }

    public Socket m19947c() {
        return this.f15410c != null ? this.f15410c.mo4373c() : null;
    }

    public void m19948d() {
        if (this.f15410c != null) {
            try {
                this.f15410c.mo4369a();
                this.f15410c = null;
            } catch (Throwable e) {
                e.c("PushLogAC2712", "call channel.close() cause:" + e.toString(), e);
            }
            if (this.f15409b != null) {
                this.f15409b.interrupt();
                this.f15409b = null;
            }
        }
    }

    public abstract a$a mo4360e();

    public String toString() {
        return this.f15408a.toString() + HwAccountConstants.BLANK + this.f15412e.toString();
    }
}
