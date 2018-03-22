package com.huawei.android.pushagent.p020b.p021a.p324a.p325a;

import android.os.Bundle;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.C4060c;
import com.huawei.android.pushagent.p017a.C4060c.C4059a;
import com.huawei.android.pushagent.p017a.p320a.p321a.C4037b;
import com.huawei.android.pushagent.p020b.p021a.p324a.C4065a;
import com.huawei.android.pushagent.p020b.p021a.p324a.C4069c;
import com.huawei.android.pushagent.p020b.p021a.p324a.C4069c.C4076a;
import com.huawei.android.pushagent.p020b.p021a.p327b.C4078b;
import java.io.InputStream;
import java.io.Serializable;
import java.net.SocketException;

public class C4070c extends C4069c {
    public C4070c(C4065a c4065a) {
        super(c4065a);
    }

    protected void mo4367b() throws Exception {
        Throwable e;
        Object obj;
        C4078b c4078b = null;
        InputStream d;
        try {
            if (this.c.f15410c == null || this.c.f15410c.mo4373c() == null) {
                e.d("PushLogAC2712", "no socket when in readSSLSocket");
                if (c4078b != null) {
                    c4078b.close();
                }
                if (this.c.f15410c != null) {
                    this.c.f15410c.mo4369a();
                    this.c.f15410c = c4078b;
                    return;
                }
                return;
            }
            e.a("PushLogAC2712", "socket timeout is " + this.c.f15410c.mo4373c().getSoTimeout());
            d = this.c.f15410c.mo4374d();
            while (!isInterrupted() && this.c.f15410c.mo4372b()) {
                try {
                    Serializable b;
                    if (d != null) {
                        b = C4037b.m19849b(d);
                    } else {
                        e.b("PushLogAC2712", "InputStream is null, get pollingMessage failed");
                        Object obj2 = c4078b;
                    }
                    if (b != null) {
                        a.b();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("push_msg", b);
                        this.c.mo4357a(C4076a.SocketEvent_MSG_RECEIVED, bundle);
                    }
                } catch (SocketException e2) {
                    e.a("PushLogAC2712", "SocketException:" + e2.toString());
                } catch (Throwable e3) {
                    e.c("PushLogAC2712", "call getEntityByCmdId cause:" + e3.toString(), e3);
                    throw e3;
                } catch (Exception e4) {
                    e3 = e4;
                }
            }
            if (d != null) {
                d.close();
            }
            if (this.c.f15410c != null) {
                this.c.f15410c.mo4369a();
                this.c.f15410c = c4078b;
            }
        } catch (Exception e5) {
            e3 = e5;
            obj = c4078b;
            try {
                throw new C4060c(e3, C4059a.Err_Read);
            } catch (Throwable th) {
                e3 = th;
                if (d != null) {
                    d.close();
                }
                if (this.c.f15410c != null) {
                    this.c.f15410c.mo4369a();
                    this.c.f15410c = c4078b;
                }
                throw e3;
            }
        } catch (Throwable th2) {
            e3 = th2;
            obj = c4078b;
            if (d != null) {
                d.close();
            }
            if (this.c.f15410c != null) {
                this.c.f15410c.mo4369a();
                this.c.f15410c = c4078b;
            }
            throw e3;
        }
    }
}
