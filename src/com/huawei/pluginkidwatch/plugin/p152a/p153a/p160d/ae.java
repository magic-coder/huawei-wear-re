package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1690h;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p159b.C1693a;

/* compiled from: DataTransferStateMachine */
class ae implements C1690h {
    final /* synthetic */ C1719y f4445a;

    private ae(C1719y c1719y) {
        this.f4445a = c1719y;
    }

    public void mo2568a(int i) {
        switch (i) {
            case 0:
                C1719y.f4597a.m7886a(10);
                C2538c.m12664a("DataTransferStateMachine", " STATE_UNKNOWN,clear command");
                synchronized (this.f4445a.f4621m) {
                    this.f4445a.f4621m.clear();
                }
                synchronized (this.f4445a.f4622n) {
                    this.f4445a.f4622n.clear();
                }
                if (this.f4445a.f4606D != null) {
                    this.f4445a.f4606D.clear();
                }
                this.f4445a.m8185b(0);
                break;
            case 1:
                this.f4445a.m8185b(1);
                break;
            case 2:
                this.f4445a.m8185b(2);
                synchronized (this.f4445a.f4621m) {
                    if (this.f4445a.f4621m.size() > 0 && this.f4445a.f4625q != null) {
                        this.f4445a.f4625q.sendEmptyMessage(0);
                    }
                }
                break;
            case 3:
                if (this.f4445a.f4606D != null) {
                    this.f4445a.f4606D.clear();
                }
                C2538c.m12674b("DataTransferStateMachine", "ConnectionState.DEVICE_DISCONNECTED,ISARcallback =" + this.f4445a.f4607E);
                this.f4445a.m8215l();
                break;
            case 4:
                break;
            default:
                C1719y.f4597a.m7886a(16);
                break;
        }
        if (this.f4445a.f4627s != null) {
            this.f4445a.f4627s.mo2568a(i);
        }
    }

    public void mo2570a(int i, byte[] bArr) {
        m7898b(i, bArr);
    }

    private void m7898b(int i, byte[] bArr) {
        byte[] a;
        String a2 = al.m7917a(bArr);
        C2538c.m12674b("DataTransferStateMachine", " onDataReceived() Get Data From Device " + a2);
        if (a2.indexOf("AA0100496C") != -1) {
            a2 = a2.replace("AA0100496C", "");
            a = a2.length() != 0 ? al.m7918a(a2) : bArr;
        } else {
            a = bArr;
        }
        String a3 = al.m7917a(a);
        if (this.f4445a.f4607E != null && (a3.startsWith("cc") || a3.startsWith("CC"))) {
            synchronized (this.f4445a.f4621m) {
                if (!this.f4445a.f4614f || this.f4445a.f4625q == null) {
                    C2538c.m12680e("DataTransferStateMachine", "waitting ack is time out,return");
                    return;
                }
                this.f4445a.f4614f = false;
                this.f4445a.f4625q.removeMessages(3);
                C2538c.m12680e("DataTransferStateMachine", "need ACK_DFU : " + a3);
                this.f4445a.f4622n.clear();
                this.f4445a.m8185b(2);
                this.f4445a.f4607E.m7877a(a);
            }
        } else if (!this.f4445a.m8193b(bArr) && 3 != this.f4445a.f4605C && 5 != this.f4445a.f4605C && (6 != this.f4445a.f4605C || !this.f4445a.m8198c(bArr))) {
            C2538c.m12674b("DataTransferStateMachine", "链路层校验失败：" + al.m7917a(bArr));
            this.f4445a.f4606D.clear();
            C1717w c1717w = null;
            synchronized (this.f4445a.f4621m) {
                if (this.f4445a.f4621m.size() > 0) {
                    c1717w = (C1717w) this.f4445a.f4621m.get(0);
                }
            }
            if (c1717w != null) {
                c1717w.m8156a(null);
            }
            this.f4445a.f4618j = this.f4445a.f4618j + 1;
            if (this.f4445a.f4618j <= 1) {
                this.f4445a.m8185b(2);
                synchronized (this.f4445a.f4621m) {
                    if (this.f4445a.f4621m.size() > 0 && this.f4445a.f4625q != null) {
                        this.f4445a.f4625q.removeMessages(2);
                        if (6 == this.f4445a.f4605C && c1717w != null) {
                            c1717w.m8155a(0);
                        }
                        this.f4445a.f4625q.sendEmptyMessage(0);
                    }
                }
                C2538c.m12680e("DataTransferStateMachine", "链路层校验失败，resend");
            }
        } else if ((a3.equals("AA0100496C") || a3.equals("AA0102692E") || a3.equals("AA01000049") || a3.equals("AA0C010000") || i <= 8 || !m7897a(i, (byte) 0, a)) && this.f4445a.f4625q != null) {
            this.f4445a.f4625q.obtainMessage(1, a.length, -1, a).sendToTarget();
        }
    }

    private boolean m7897a(int i, byte b, byte[] bArr) {
        C1693a b2 = this.f4445a.f4604B.mo2565b(i, bArr, C1719y.f4596F);
        byte[] d = b2.m7883d();
        if (6 == this.f4445a.f4605C || 1 != b2.m7882c() || b != d[2]) {
            return false;
        }
        C2538c.m12674b("DataTransferStateMachine", "onDataReceived,notifation,data=" + al.m7917a(d));
        if ((byte) 8 == d[3] && 6 == d.length && this.f4445a.f4607E != null) {
            this.f4445a.f4607E.m7876a(Byte.valueOf(d[5]));
            this.f4445a.f4607E = null;
            return true;
        } else if (this.f4445a.f4627s == null) {
            return true;
        } else {
            this.f4445a.f4627s.mo2570a(d.length, d);
            return true;
        }
    }

    public void mo2569a(int i, String str) {
        C2538c.m12674b("DataTransferStateMachine", "errorCode:" + i + str);
    }
}
