package com.huawei.android.pushagent.p020b.p021a.p324a.p326b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.a.a;
import com.huawei.android.pushagent.b.b.c;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.C4036b;
import com.huawei.android.pushagent.p017a.C4060c;
import com.huawei.android.pushagent.p017a.C4061d;
import com.huawei.android.pushagent.p017a.p322b.C4047f;
import com.huawei.android.pushagent.p017a.p322b.C4052k;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import com.huawei.android.pushagent.p020b.p021a.a$a;
import com.huawei.android.pushagent.p020b.p021a.p324a.C4065a;
import com.huawei.android.pushagent.p020b.p021a.p324a.C4069c.C4076a;
import com.huawei.android.pushagent.p020b.p328d.C4086a;
import com.huawei.android.pushagent.p020b.p328d.C4090b;
import com.huawei.android.pushagent.p020b.p328d.C4090b.C4089b;
import java.net.InetSocketAddress;

public class C4072a extends C4065a {
    boolean f15424g = false;

    public C4072a(C4061d c4061d, Context context) {
        super(c4061d, context, new C4073b(context), C4072a.class.getSimpleName());
        m19984f();
    }

    public void mo4357a(C4076a c4076a, Bundle bundle) {
        int a = c.a(this.d, "tryConnectPushSevTimes", 0);
        int a2 = c.a(this.d, "lastConnectPushSrvMethodIdx", 0);
        e.a("PushLogAC2712", "enter PushConnectEntity. notifyEvent is " + c4076a + ", " + " tryConnectPushSevTimes:" + a + " lastConnctIdx:" + a2);
        switch (c4076a) {
            case SocketEvent_CONNECTING:
                PushService.a(new Intent("com.huawei.android.push.intent.CONNECTING"));
                return;
            case SocketEvent_CONNECTED:
                this.e.m19955a();
                this.e.m19957a(System.currentTimeMillis());
                C4090b.m20068a(this.d).m20079a(this.d, C4089b.SOCKET_CONNECTED, new Bundle());
                c.a(this.d, new a("lastcontectsucc_time", Long.class, Long.valueOf(System.currentTimeMillis())));
                Intent intent = new Intent("com.huawei.android.push.intent.CONNECTED");
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                PushService.a(intent);
                return;
            case SocketEvent_CLOSE:
                bundle.putInt("connect_mode", mo4360e().ordinal());
                PushService.a(new Intent("com.huawei.android.push.intent.CHANNEL_CLOSED").putExtras(bundle));
                if (com.huawei.android.pushagent.b.a.a.c() == mo4360e()) {
                    com.huawei.android.pushagent.c.a.a.a(this.d, "com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT");
                    C4090b.m20068a(this.d).m20079a(this.d, C4089b.SOCKET_CLOSE, bundle);
                }
                if (!this.f15424g) {
                    int i = a + 1;
                    e.b("PushLogAC2712", "channel is not Regist, tryConnectPushSevTimes add to " + i);
                    c.a(this.d, new a("tryConnectPushSevTimes", Integer.class, Integer.valueOf(i)));
                    c.a(this.d, new a("lastConnectPushSrvMethodIdx", Integer.class, Integer.valueOf(a2)));
                    return;
                }
                return;
            case SocketEvent_MSG_RECEIVED:
                C4036b c4036b = (C4036b) bundle.getSerializable("push_msg");
                if (c4036b == null) {
                    e.b("PushLogAC2712", "push_msg is null");
                    return;
                }
                e.a("PushLogAC2712", "received pushSrv Msg:" + com.huawei.android.pushagent.c.a.a(c4036b.mo4353a()));
                if (c4036b.mo4353a() == (byte) -45 || c4036b.mo4353a() == (byte) -33) {
                    this.f15424g = true;
                    c.a(this.d, new a("lastConnectPushSrvMethodIdx", Integer.class, Integer.valueOf(m19945b(a, a2))));
                    c.a(this.d, new a("tryConnectPushSevTimes", Integer.class, Integer.valueOf(0)));
                } else if ((c4036b instanceof C4047f) || (c4036b instanceof C4052k)) {
                    com.huawei.android.pushagent.c.a.a.a(this.d, "com.huawei.android.push.intent.HEARTBEAT_RSP_TIMEOUT");
                    this.e.mo4364c(false);
                }
                this.e.m19955a();
                Intent intent2 = new Intent("com.huawei.android.push.intent.MSG_RECEIVED");
                intent2.putExtra("push_msg", c4036b);
                PushService.a(intent2);
                return;
            default:
                return;
        }
    }

    public synchronized void mo4358a(boolean z) throws C4060c {
        mo4359a(z, false);
    }

    public synchronized void mo4359a(boolean z, boolean z2) throws C4060c {
        try {
            e.a("PushLogAC2712", "enter PushConnectEntity:connect(isForceToConnPushSrv:" + z + ")");
            this.e.m19960b();
            if (com.huawei.android.pushagent.b.b.a.a(this.d).V()) {
                if (C4103b.m20122a(this.d) == -1) {
                    e.d("PushLogAC2712", "no network, so cannot connect");
                } else {
                    if (c.a(this.d, "cloudpush_isNoDelayConnect", false)) {
                        z = true;
                    }
                    if (!m19943a()) {
                        int a = c.a(this.d, "tryConnectPushSevTimes", 0);
                        long b = C4090b.m20068a(this.d).m20080b(this.d);
                        if (b <= 0) {
                            e.b("PushLogAC2712", "no limit to connect pushsvr");
                            if (this.b == null || !this.b.isAlive()) {
                                e.a("PushLogAC2712", "begin to create new socket, so close socket");
                                m19946b();
                                m19948d();
                                e.a("PushLogAC2712", "IS_NODELAY_CONNECT:" + c.a(this.d, "cloudpush_isNoDelayConnect", false) + " hasMsg:" + z2);
                                if (c.a(this.d, "cloudpush_isNoDelayConnect", false) || z2 || C4086a.m20045a(this.d, 1)) {
                                    this.f15424g = false;
                                    int a2 = c.a(this.d, "lastConnectPushSrvMethodIdx", 0);
                                    InetSocketAddress a3 = com.huawei.android.pushagent.b.b.a.a(this.d).a(z);
                                    if (a3 != null) {
                                        e.a("PushLogAC2712", "get pushSrvAddr:" + a3);
                                        this.a.f15391a = a3.getAddress().getHostAddress();
                                        this.a.f15392b = a3.getPort();
                                        this.a.f15393c = c.b(this.d);
                                        this.a = m19939a(a2, a);
                                        this.b = new C4074c(this);
                                        this.b.start();
                                    } else {
                                        e.a("PushLogAC2712", "no valid pushSrvAddr, just wait!!");
                                    }
                                } else {
                                    com.huawei.android.pushagent.b.a.a.a(this.d).a(a$a.ConnectEntity_Polling);
                                    com.huawei.android.pushagent.b.a.a.a(this.d).a(a$a.ConnectEntity_Polling, false);
                                }
                            } else {
                                e.b("PushLogAC2712", "It is in connecting...");
                            }
                        } else {
                            com.huawei.android.pushagent.b.a.a.a(this.d).a(b);
                        }
                    } else if (z) {
                        e.a("PushLogAC2712", "hasConnect, but isForceToConnPushSrv:" + z + ", so send heartBeat");
                        this.e.mo4366g();
                    } else {
                        e.a("PushLogAC2712", "aready connect, need not connect more");
                    }
                }
            }
        } catch (Throwable e) {
            throw new C4060c(e);
        }
    }

    public a$a mo4360e() {
        return a$a.ConnectEntity_Push;
    }

    public boolean m19984f() {
        if (this.a == null) {
            this.a = new C4061d("", -1, false, c.b(this.d));
        }
        return true;
    }
}
