package com.huawei.hwbtsdk.btmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hwbtsdk.p057b.p400b.C4625b;
import com.huawei.hwbtsdk.p399a.C4610m;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceSendCommandUtil */
class C4653m extends Handler {
    final /* synthetic */ C4648h f17048a;

    public C4653m(C4648h c4648h, Looper looper) {
        this.f17048a = c4648h;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Receive SEND_COMMAND Message and sendResult = " + this.f17048a.f17017V + " size:" + this.f17048a.f17039v.size()});
                if (this.f17048a.f17039v.size() != 0) {
                    int s = this.f17048a.m22343s();
                    C4625b c4625b = (C4625b) this.f17048a.f17039v.get(s);
                    if (c4625b == null) {
                        return;
                    }
                    byte[] bArr;
                    if (2 == this.f17048a.f17026i) {
                        if (!this.f17048a.f17040w) {
                            boolean z;
                            C4625b b;
                            this.f17048a.f16998C = c4625b.m22125i();
                            this.f17048a.f16999D = c4625b.m22126j();
                            C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"ServiceID = " + this.f17048a.f16998C + " CommandID = " + this.f17048a.f16999D});
                            if (c4625b.m22120e()) {
                                C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Command need ack."});
                                this.f17048a.f17040w = true;
                                this.f17048a.f17011P = 3;
                            }
                            if (this.f17048a.f17024g != null) {
                                DeviceInfo d = this.f17048a.f17024g.d();
                                if (d != null && 2 == d.getDeviceBTType()) {
                                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Current device type is ble."});
                                    if (!(9 == this.f17048a.f16998C || 10 == this.f17048a.f16998C)) {
                                        if (1 != this.f17048a.f16998C) {
                                            z = true;
                                        } else if (!(1 == this.f17048a.f16999D || 14 == this.f17048a.f16999D || 15 == this.f17048a.f16999D || 19 == this.f17048a.f16999D)) {
                                            z = true;
                                        }
                                        if (z) {
                                            bArr = null;
                                            if (this.f17048a.f17023f == null) {
                                                bArr = C4610m.m21977a(this.f17048a.f17021d, c4625b.m22116c(), this.f17048a.f17023f.getAddress(), this.f17048a.f17017V);
                                            } else {
                                                C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"mBTDevice is null"});
                                            }
                                            if (bArr == null) {
                                                C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Get encryptData info."});
                                                c4625b.m22108a(bArr.length);
                                                c4625b.m22111a(bArr);
                                            } else {
                                                C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Do not get encryptData info."});
                                                c4625b.m22108a(c4625b.m22116c().length);
                                                c4625b.m22111a(c4625b.m22116c());
                                            }
                                        }
                                        if (!c4625b.m22120e()) {
                                            C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Do not need ack."});
                                            this.f17048a.f17017V = this.f17048a.m22309b(c4625b);
                                        } else {
                                            this.f17048a.f17012Q = 0;
                                            do {
                                                C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Send V2 Command timeout with ReSendTime = " + this.f17048a.f17012Q});
                                                if (this.f17048a.f17012Q != 0 && 1 == this.f17048a.f16998C && 5 == this.f17048a.f16999D) {
                                                    b = C4610m.m21980b();
                                                    bArr = null;
                                                    if (this.f17048a.f17023f == null) {
                                                        bArr = C4610m.m21977a(this.f17048a.f17021d, b.m22116c(), this.f17048a.f17023f.getAddress(), this.f17048a.f17017V);
                                                    } else {
                                                        C2538c.a("0xA0200006", "01", 1, "BTDeviceSendCommandUtil", new Object[]{"mBTDevice is null"});
                                                    }
                                                    if (bArr == null) {
                                                        c4625b.m22111a(bArr);
                                                        c4625b.m22108a(bArr.length);
                                                    } else {
                                                        C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"encryptData is null."});
                                                    }
                                                }
                                                this.f17048a.f17017V = this.f17048a.m22309b(c4625b);
                                                if (this.f17048a.f17012Q == 0) {
                                                }
                                            } while (this.f17048a.f17011P > this.f17048a.f17012Q);
                                        }
                                        synchronized (C4648h.f16993X) {
                                            C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Remove V2 Command from list."});
                                            if (s < this.f17048a.f17039v.size() || s < 0) {
                                                C2538c.b("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Remove fail for index is not in rang, mBTDeviceCommandList.size() = " + this.f17048a.f17039v.size()});
                                            } else {
                                                this.f17048a.f17039v.remove(s);
                                            }
                                        }
                                        return;
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                                bArr = null;
                                if (this.f17048a.f17023f == null) {
                                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"mBTDevice is null"});
                                } else {
                                    bArr = C4610m.m21977a(this.f17048a.f17021d, c4625b.m22116c(), this.f17048a.f17023f.getAddress(), this.f17048a.f17017V);
                                }
                                if (bArr == null) {
                                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Do not get encryptData info."});
                                    c4625b.m22108a(c4625b.m22116c().length);
                                    c4625b.m22111a(c4625b.m22116c());
                                } else {
                                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Get encryptData info."});
                                    c4625b.m22108a(bArr.length);
                                    c4625b.m22111a(bArr);
                                }
                            }
                            if (!c4625b.m22120e()) {
                                this.f17048a.f17012Q = 0;
                                do {
                                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Send V2 Command timeout with ReSendTime = " + this.f17048a.f17012Q});
                                    b = C4610m.m21980b();
                                    bArr = null;
                                    if (this.f17048a.f17023f == null) {
                                        C2538c.a("0xA0200006", "01", 1, "BTDeviceSendCommandUtil", new Object[]{"mBTDevice is null"});
                                    } else {
                                        bArr = C4610m.m21977a(this.f17048a.f17021d, b.m22116c(), this.f17048a.f17023f.getAddress(), this.f17048a.f17017V);
                                    }
                                    if (bArr == null) {
                                        C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"encryptData is null."});
                                    } else {
                                        c4625b.m22111a(bArr);
                                        c4625b.m22108a(bArr.length);
                                    }
                                    this.f17048a.f17017V = this.f17048a.m22309b(c4625b);
                                    if (this.f17048a.f17012Q == 0) {
                                    }
                                    break;
                                } while (this.f17048a.f17011P > this.f17048a.f17012Q);
                            }
                            C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Do not need ack."});
                            this.f17048a.f17017V = this.f17048a.m22309b(c4625b);
                            synchronized (C4648h.f16993X) {
                                C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Remove V2 Command from list."});
                                if (s < this.f17048a.f17039v.size()) {
                                }
                                C2538c.b("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Remove fail for index is not in rang, mBTDeviceCommandList.size() = " + this.f17048a.f17039v.size()});
                            }
                            return;
                        }
                        return;
                    } else if (!this.f17048a.f17040w && this.f17048a.f17041x != null) {
                        this.f17048a.f17040w = true;
                        this.f17048a.f17011P = 3;
                        C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Set Sending flag true."});
                        byte[] c = c4625b.m22116c();
                        this.f17048a.f17008M = c4625b.m22124h();
                        if (1 == this.f17048a.f17026i) {
                            this.f17048a.f16998C = c4625b.m22125i();
                            this.f17048a.f16999D = c4625b.m22126j();
                            c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"SEND_COMMAND Msg with mServiceID = " + this.f17048a.f16998C + " mCommandID = " + this.f17048a.f16999D});
                            if (this.f17048a.f17008M != 1) {
                                bArr = this.f17048a.m22303a(c4625b.m22116c(), c4625b.m22124h());
                            } else {
                                if (c4625b.m22123g()) {
                                    if ((byte) 7 == c[0] && (byte) 2 == c[1]) {
                                        c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Need change command ID for set userInfo."});
                                        c[1] = (byte) 9;
                                        this.f17048a.f16999D = 9;
                                    } else if ((byte) 2 == c[0] && (byte) 1 == c[1]) {
                                        c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Need change command ID for send message."});
                                        c[1] = (byte) 3;
                                        this.f17048a.f16999D = 3;
                                    }
                                }
                                bArr = this.f17048a.m22364a(c);
                            }
                        } else {
                            try {
                                Thread.sleep(5);
                            } catch (Exception e) {
                                c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Exception is :" + e.getMessage()});
                            }
                            this.f17048a.f16998C = c[0];
                            this.f17048a.f16999D = c[1];
                            int b2 = c4625b.m22112b() - 2;
                            bArr = new byte[b2];
                            for (int i = 0; i < b2; i++) {
                                bArr[i] = c[i + 2];
                            }
                        }
                        if (bArr != null) {
                            c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Is command need encrypt ?: " + c4625b.m22123g()});
                            if (c4625b.m22123g()) {
                                if (this.f17048a.f17023f != null) {
                                    bArr = C4610m.m21976a(this.f17048a.f17021d, bArr, this.f17048a.f17023f.getAddress());
                                } else {
                                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"mBTDevice is null."});
                                }
                            }
                            c.a("01", 0, "BTDeviceSendCommandUtil", new Object[]{"After encryptTLVs & transferV2ToV1, btV1Command = " + C0973a.a(bArr)});
                            this.f17048a.f17041x.m22110a(c4625b.m22120e());
                            this.f17048a.f17041x.m22109a(c4625b.m22107a());
                            this.f17048a.f17041x.m22115c(c4625b.m22121f());
                            this.f17048a.f17041x.m22113b(c4625b.m22117d());
                            this.f17048a.f17041x.m22111a(bArr);
                            this.f17048a.f17041x.m22108a(bArr.length);
                            this.f17048a.f17041x.m22118d(c4625b.m22124h());
                            this.f17048a.f17041x.m22114b(c4625b.m22123g());
                            this.f17048a.f17041x.m22119e(c4625b.m22125i());
                            this.f17048a.f17041x.m22122f(c4625b.m22126j());
                            this.f17048a.f17012Q = 0;
                            do {
                                c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Send V1 Command timeout with ReSendTime = " + this.f17048a.f17012Q});
                                if (this.f17048a.f17012Q != 0 && 1 == this.f17048a.f16998C && 5 == this.f17048a.f16999D) {
                                    byte[] a = this.f17048a.m22364a(C4610m.m21980b().m22116c());
                                    if (a != null) {
                                        this.f17048a.f17041x.m22111a(a);
                                        this.f17048a.f17041x.m22108a(a.length);
                                    }
                                }
                                this.f17048a.m22309b(this.f17048a.f17041x);
                                if (this.f17048a.f17012Q != 0) {
                                }
                                synchronized (C4648h.f16993X) {
                                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Remove V1 Command from list, iCommandIndex = " + s});
                                    if (s < this.f17048a.f17039v.size() || s < 0) {
                                        c.b("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Remove fail for index is not in rang, mBTDeviceCommandList.size() = " + this.f17048a.f17039v.size()});
                                    } else {
                                        this.f17048a.f17039v.remove(s);
                                    }
                                }
                                return;
                            } while (this.f17048a.f17011P > this.f17048a.f17012Q);
                            synchronized (C4648h.f16993X) {
                                c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Remove V1 Command from list, iCommandIndex = " + s});
                                if (s < this.f17048a.f17039v.size()) {
                                }
                                c.b("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Remove fail for index is not in rang, mBTDeviceCommandList.size() = " + this.f17048a.f17039v.size()});
                            }
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                }
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"mBTDeviceCommandList has no command."});
                return;
            case 2:
                if (this.f17048a.f17024g != null) {
                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Receive CONNECT_TIMEOUT_COMMAND Message."});
                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Start to disconnect service."});
                    this.f17048a.f17024g.b();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
