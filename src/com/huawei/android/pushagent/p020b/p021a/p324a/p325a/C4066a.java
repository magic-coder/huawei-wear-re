package com.huawei.android.pushagent.p020b.p021a.p324a.p325a;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.pushagent.b.b.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.C4036b;
import com.huawei.android.pushagent.p017a.C4060c;
import com.huawei.android.pushagent.p017a.C4061d;
import com.huawei.android.pushagent.p017a.p320a.C4038a;
import com.huawei.android.pushagent.p017a.p320a.C4039b;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import com.huawei.android.pushagent.p020b.p021a.a$a;
import com.huawei.android.pushagent.p020b.p021a.p324a.C4065a;
import com.huawei.android.pushagent.p020b.p021a.p324a.C4069c.C4076a;
import com.huawei.android.pushagent.p020b.p021a.p327b.C4078b.C4080a;
import java.net.InetSocketAddress;
import java.util.Date;

public class C4066a extends C4065a {
    public C4066a(C4061d c4061d, Context context) {
        super(c4061d, context, new C4068b(context), C4066a.class.getSimpleName());
        m19954f();
    }

    public void mo4357a(C4076a c4076a, Bundle bundle) {
        e.a("PushLogAC2712", "enter PollingConnectEntity:notifyEvent(" + c4076a + ",bd:" + bundle + ")");
        switch (c4076a) {
            case SocketEvent_CONNECTED:
                this.e.m19955a();
                this.e.m19957a(System.currentTimeMillis());
                try {
                    m19944a(new C4038a(a.a(this.d).E()));
                    if (this.c != null) {
                        this.c.mo4373c().setSoTimeout((int) (a.a(this.d).v() * 1000));
                        return;
                    }
                    return;
                } catch (Throwable e) {
                    e.c("PushLogAC2712", "call send cause:" + e.toString(), e);
                    return;
                }
            case SocketEvent_MSG_RECEIVED:
                C4036b c4036b = (C4036b) bundle.getSerializable("push_msg");
                if (c4036b == null) {
                    e.b("PushLogAC2712", "push_msg is null");
                    return;
                }
                e.b("PushLogAC2712", "received polling Msg:" + c4036b.getClass().getSimpleName());
                if (c4036b instanceof C4039b) {
                    C4039b c4039b = (C4039b) c4036b;
                    if (c4039b.m19860d() < (byte) 0 || c4039b.m19860d() > a$a.values().length) {
                        e.d("PushLogAC2712", "received mode:" + c4039b.m19860d() + " cannot be recongnized");
                        return;
                    }
                    a$a com_huawei_android_pushagent_b_a_a_a = a$a.values()[c4039b.m19860d()];
                    com.huawei.android.pushagent.b.a.a.a(this.d).a(com_huawei_android_pushagent_b_a_a_a);
                    this.e.mo4362b(((long) c4039b.m19862f()) * 1000);
                    if (c4039b.m19861e() || com_huawei_android_pushagent_b_a_a_a == a$a.ConnectEntity_Push) {
                        try {
                            com.huawei.android.pushagent.b.a.a.e().mo4359a(true, c4039b.m19861e());
                        } catch (Throwable e2) {
                            e.c("PushLogAC2712", e2.toString(), e2);
                        }
                    }
                    if (this.c != null) {
                        try {
                            this.c.mo4369a();
                            return;
                        } catch (Throwable e22) {
                            e.c("PushLogAC2712", "call channel close cause:" + e22.toString(), e22);
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public synchronized void mo4358a(boolean z) throws C4060c {
        e.a("PushLogAC2712", "enter PollingConnectEntity:connect(forceCon:" + z + ")");
        this.e.m19960b();
        if (a.a(this.d).X()) {
            if (m19943a()) {
                e.b("PushLogAC2712", "Polling aready connect, just wait Rsp!");
            } else {
                if (!z) {
                    if (System.currentTimeMillis() < this.e.m19964d() + this.e.mo4361b(false) && System.currentTimeMillis() > this.e.m19964d()) {
                        e.b("PushLogAC2712", "cannot connect, heartBeatInterval:" + this.e.mo4361b(false) + " lastCntTime:" + new Date(this.e.m19964d()));
                    }
                }
                if (C4103b.m20122a(this.d) == -1) {
                    e.b("PushLogAC2712", "no network, so cannot connect Polling");
                } else if (this.b == null || !this.b.isAlive()) {
                    e.a("PushLogAC2712", "begin to create new socket, so close socket");
                    m19946b();
                    m19948d();
                    InetSocketAddress b = a.a(this.d).b(false);
                    if (b != null) {
                        e.a("PushLogAC2712", "get pollingSrvAddr:" + b);
                        this.a.f15391a = b.getAddress().getHostAddress();
                        this.a.f15392b = b.getPort();
                        this.b = new C4070c(this);
                        this.b.start();
                    } else {
                        e.d("PushLogAC2712", "no valid pollingSrvAddr, just wait!!");
                    }
                } else {
                    e.b("PushLogAC2712", "aready in connect, just wait!! srvSocket:" + this.b.toString());
                }
            }
        }
    }

    public synchronized void mo4359a(boolean z, boolean z2) throws C4060c {
        mo4358a(z);
    }

    public a$a mo4360e() {
        return a$a.ConnectEntity_Polling;
    }

    public boolean m19954f() {
        if (this.a == null) {
            this.a = new C4061d("", -1, false, C4080a.ChannelType_Normal);
        }
        return true;
    }
}
