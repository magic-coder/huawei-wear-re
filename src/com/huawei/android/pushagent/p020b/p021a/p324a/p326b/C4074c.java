package com.huawei.android.pushagent.p020b.p021a.p324a.p326b;

import android.os.Bundle;
import com.huawei.android.pushagent.c.a;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p017a.C4060c;
import com.huawei.android.pushagent.p017a.C4060c.C4059a;
import com.huawei.android.pushagent.p017a.p322b.C4053l;
import com.huawei.android.pushagent.p017a.p322b.p323a.C4040a;
import com.huawei.android.pushagent.p020b.p021a.p324a.C4065a;
import com.huawei.android.pushagent.p020b.p021a.p324a.C4069c;
import com.huawei.android.pushagent.p020b.p021a.p324a.C4069c.C4076a;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketException;

public class C4074c extends C4069c {
    public C4074c(C4065a c4065a) {
        super(c4065a);
    }

    protected void mo4367b() throws Exception {
        int i;
        byte i2;
        Throwable e;
        InputStream inputStream = null;
        InputStream d;
        try {
            if (this.c.f15410c == null || this.c.f15410c.mo4373c() == null) {
                e.d("PushLogAC2712", "no socket when in readSSLSocket");
                if (inputStream != null) {
                    inputStream.close();
                }
                if (this.c.f15410c != null) {
                    this.c.f15410c.mo4369a();
                    return;
                }
                return;
            }
            Socket c = this.c.f15410c.mo4373c();
            if (c != null) {
                e.a("PushLogAC2712", "socket timeout is " + c.getSoTimeout());
            }
            d = this.c.f15410c.mo4374d();
            byte b = (byte) -1;
            int i3 = -1;
            while (!isInterrupted() && this.c.f15410c.mo4372b()) {
                try {
                    if (b != (byte) -1) {
                        i = b;
                        b = (byte) -1;
                    } else if (d != null) {
                        i = d.read();
                    } else {
                        e.a("PushLogAC2712", "inputstream is null, cannot get cmdId");
                        i = i3;
                    }
                    if (-1 == i) {
                        e.a("PushLogAC2712", "read -1 data, socket may be close");
                        break;
                    }
                    String a = a.a(new byte[]{(byte) i});
                    e.a("PushLogAC2712", "received a msg cmdId:" + a);
                    try {
                        Serializable a2;
                        if (C4053l.m19909c() == ((byte) i)) {
                            e.a("PushLogAC2712", "is PushDataReqMessage set read TimeOut 100");
                            if (c != null) {
                                c.setSoTimeout(100);
                            } else {
                                e.a("PushLogAC2712", "socket is null");
                            }
                            a2 = C4040a.m19863a(Byte.valueOf((byte) i), d);
                            if (a2 != null) {
                                C4053l c4053l = (C4053l) a2;
                                if (c4053l.m19917i() != (byte) -1) {
                                    e.a("PushLogAC2712", "is get next cmdId, so set it");
                                    i2 = c4053l.m19917i();
                                }
                            }
                            i2 = b;
                        } else {
                            a2 = C4040a.m19863a(Byte.valueOf((byte) i), d);
                            i2 = b;
                        }
                        if (a2 != null) {
                            try {
                                a.b();
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("push_msg", a2);
                                this.c.mo4357a(C4076a.SocketEvent_MSG_RECEIVED, bundle);
                            } catch (InstantiationException e2) {
                                e.d("PushLogAC2712", "call getEntityByCmdId(cmd:" + i + " cause InstantiationException");
                                if (c != null) {
                                    continue;
                                } else if (com.huawei.android.pushagent.b.a.a.c() != this.c.mo4360e()) {
                                    this.c.f15410c.mo4373c().setSoTimeout(0);
                                } else {
                                    this.c.f15410c.mo4373c().setSoTimeout((int) (this.c.f15412e.mo4361b(false) + com.huawei.android.pushagent.b.b.a.a(this.b).Q()));
                                }
                                b = i2;
                                i3 = i;
                            } catch (Exception e3) {
                                e.d("PushLogAC2712", "call getEntityByCmdId(cmd:" + i + " Exception");
                                if (c != null) {
                                    continue;
                                } else if (com.huawei.android.pushagent.b.a.a.c() != this.c.mo4360e()) {
                                    this.c.f15410c.mo4373c().setSoTimeout(0);
                                } else {
                                    this.c.f15410c.mo4373c().setSoTimeout((int) (this.c.f15412e.mo4361b(false) + com.huawei.android.pushagent.b.b.a.a(this.b).Q()));
                                }
                                b = i2;
                                i3 = i;
                            }
                        } else {
                            e.d("PushLogAC2712", "received invalid msg, cmdId" + a);
                        }
                        if (c == null) {
                            continue;
                        } else if (com.huawei.android.pushagent.b.a.a.c() == this.c.mo4360e()) {
                            this.c.f15410c.mo4373c().setSoTimeout(0);
                        } else {
                            this.c.f15410c.mo4373c().setSoTimeout((int) (this.c.f15412e.mo4361b(false) + com.huawei.android.pushagent.b.b.a.a(this.b).Q()));
                        }
                    } catch (InstantiationException e4) {
                        i2 = b;
                        e.d("PushLogAC2712", "call getEntityByCmdId(cmd:" + i + " cause InstantiationException");
                        if (c != null) {
                            continue;
                        } else if (com.huawei.android.pushagent.b.a.a.c() != this.c.mo4360e()) {
                            this.c.f15410c.mo4373c().setSoTimeout((int) (this.c.f15412e.mo4361b(false) + com.huawei.android.pushagent.b.b.a.a(this.b).Q()));
                        } else {
                            this.c.f15410c.mo4373c().setSoTimeout(0);
                        }
                        b = i2;
                        i3 = i;
                    } catch (Exception e5) {
                        i2 = b;
                        e.d("PushLogAC2712", "call getEntityByCmdId(cmd:" + i + " Exception");
                        if (c != null) {
                            continue;
                        } else if (com.huawei.android.pushagent.b.a.a.c() != this.c.mo4360e()) {
                            this.c.f15410c.mo4373c().setSoTimeout((int) (this.c.f15412e.mo4361b(false) + com.huawei.android.pushagent.b.b.a.a(this.b).Q()));
                        } else {
                            this.c.f15410c.mo4373c().setSoTimeout(0);
                        }
                        b = i2;
                        i3 = i;
                    }
                    b = i2;
                    i3 = i;
                } catch (SocketException e6) {
                    e = e6;
                    inputStream = d;
                } catch (IOException e7) {
                    e = e7;
                } catch (Exception e8) {
                    e = e8;
                } catch (Throwable th) {
                    if (c != null) {
                        if (com.huawei.android.pushagent.b.a.a.c() == this.c.mo4360e()) {
                            this.c.f15410c.mo4373c().setSoTimeout(0);
                        } else {
                            this.c.f15410c.mo4373c().setSoTimeout((int) (this.c.f15412e.mo4361b(false) + com.huawei.android.pushagent.b.b.a.a(this.b).Q()));
                        }
                    }
                }
            }
            if (d != null) {
                d.close();
            }
            if (this.c.f15410c != null) {
                this.c.f15410c.mo4369a();
            }
            throw new C4060c(" read normal Exit", C4059a.Err_Read);
        } catch (SocketException e9) {
            e = e9;
            try {
                throw new C4060c(e, C4059a.Err_Read);
            } catch (Throwable th2) {
                e = th2;
                d = inputStream;
                if (d != null) {
                    d.close();
                }
                if (this.c.f15410c != null) {
                    this.c.f15410c.mo4369a();
                }
                throw e;
            }
        } catch (IOException e10) {
            e = e10;
            d = inputStream;
            try {
                throw new C4060c(e, C4059a.Err_Read);
            } catch (Throwable th3) {
                e = th3;
                if (d != null) {
                    d.close();
                }
                if (this.c.f15410c != null) {
                    this.c.f15410c.mo4369a();
                }
                throw e;
            }
        } catch (Exception e11) {
            e = e11;
            d = inputStream;
            throw new C4060c(e, C4059a.Err_Read);
        } catch (Throwable th4) {
            e = th4;
            d = inputStream;
            if (d != null) {
                d.close();
            }
            if (this.c.f15410c != null) {
                this.c.f15410c.mo4369a();
            }
            throw e;
        }
    }
}
