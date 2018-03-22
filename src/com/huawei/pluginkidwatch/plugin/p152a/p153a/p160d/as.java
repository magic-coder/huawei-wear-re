package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1489i;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1685c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1686d;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1690h;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"HandlerLeak"})
/* compiled from: SendCommandUtil */
public class as {
    private static BluetoothDevice f4473b;
    private static ar f4474c;
    private static as f4475j;
    private static int f4476p = 0;
    public C1690h f4477a = new at(this);
    private List<C1685c> f4478d = new ArrayList();
    private List<C1685c> f4479e = new ArrayList();
    private C1620b f4480f = null;
    private aw f4481g = null;
    private HandlerThread f4482h = null;
    private Handler f4483i = null;
    private C1718x f4484k;
    private boolean f4485l = false;
    private int f4486m = -1;
    private boolean f4487n = false;
    private boolean f4488o = false;

    public static int m7980a() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(f4476p))).intValue();
    }

    public static void m7986a(int i) {
        f4476p = ((Integer) C1489i.m6887a(Integer.valueOf(i))).intValue();
    }

    private as(Context context, int i) {
        as.m7992a(new ar(context, i));
        C2538c.m12664a("SendCommandUtil", "SendCommandUtil() 重新构造  deviceType = " + i + " mWearableManager + " + f4474c);
        this.f4484k = C1718x.m8162a();
        this.f4481g = new aw();
        this.f4481g.start();
        this.f4482h = new HandlerThread("SendCommandUtil");
        this.f4482h.start();
        this.f4483i = new av(this, this.f4482h.getLooper());
    }

    public static as m7983a(Context context, int i) {
        as asVar;
        synchronized (as.class) {
            if (f4475j == null && context != null) {
                f4475j = new as(context, i);
            }
            asVar = f4475j;
        }
        return asVar;
    }

    public void m8009a(byte[] bArr, C1620b c1620b) {
        C2538c.m12674b("SendCommandUtil", " The Command Is：=" + C0973a.m3509a(bArr));
        Message message = new Message();
        message.what = 1;
        Bundle bundle = new Bundle();
        bundle.putByteArray("command", bArr);
        bundle.putInt("version", 0);
        message.setData(bundle);
        message.obj = c1620b;
        this.f4483i.sendMessage(message);
    }

    public void m8005a(int i, byte[] bArr) {
        C2538c.m12674b("SendCommandUtil", " The Command Is：=" + C0973a.m3509a(bArr));
        f4474c.m7974a(i, bArr);
    }

    public void m8006a(BluetoothDevice bluetoothDevice, int i) {
        int a = C1700i.m8041a();
        if (2 == a || 1 == a) {
            C2538c.m12664a("SendCommandUtil", "device is connect or connnecting");
            synchronized (this.f4478d) {
                this.f4486m = 17;
            }
            m7987a(5, false);
        } else if (f4474c != null) {
            as.m7990a(bluetoothDevice);
            f4474c.m7975a(bluetoothDevice, this.f4477a, i);
        } else {
            C2538c.m12674b("connect(), mWearableManager is null", new Object[0]);
            synchronized (this.f4478d) {
                this.f4486m = 0;
            }
            m7987a(5, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7987a(int r11, boolean r12) {
        /*
        r10 = this;
        r0 = "SendCommandUtil";
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Enter reportConnectStatus() status = ";
        r3 = r3.append(r4);
        r3 = r3.append(r11);
        r4 = " flag = ";
        r3 = r3.append(r4);
        r3 = r3.append(r12);
        r3 = r3.toString();
        r1[r2] = r3;
        com.huawei.p190v.C2538c.m12674b(r0, r1);
        r0 = 0;
        r1 = f4473b;
        if (r1 == 0) goto L_0x01d3;
    L_0x002d:
        r0 = f4473b;
        r0 = r0.getAddress();
        r3 = r0;
    L_0x0034:
        r0 = 2;
        if (r0 != r11) goto L_0x0044;
    L_0x0037:
        if (r12 == 0) goto L_0x0044;
    L_0x0039:
        r0 = r10.f4483i;
        r1 = new com.huawei.pluginkidwatch.plugin.a.a.d.au;
        r1.<init>(r10);
        r0.post(r1);
    L_0x0043:
        return;
    L_0x0044:
        r4 = r10.f4478d;
        monitor-enter(r4);
        r0 = 3;
        if (r0 == r11) goto L_0x0050;
    L_0x004a:
        if (r11 != 0) goto L_0x0084;
    L_0x004c:
        r0 = r10.f4483i;	 Catch:{ all -> 0x0081 }
        if (r0 == 0) goto L_0x0084;
    L_0x0050:
        r0 = "SendCommandUtil";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0081 }
        r2 = 0;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0081 }
        r5.<init>();	 Catch:{ all -> 0x0081 }
        r6 = "unPairFlag=";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0081 }
        r6 = r10.f4487n;	 Catch:{ all -> 0x0081 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x0081 }
        r6 = ",status=";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0081 }
        r5 = r5.append(r11);	 Catch:{ all -> 0x0081 }
        r5 = r5.toString();	 Catch:{ all -> 0x0081 }
        r1[r2] = r5;	 Catch:{ all -> 0x0081 }
        com.huawei.p190v.C2538c.m12664a(r0, r1);	 Catch:{ all -> 0x0081 }
        r0 = r10.f4487n;	 Catch:{ all -> 0x0081 }
        if (r0 == 0) goto L_0x00b5;
    L_0x007f:
        monitor-exit(r4);	 Catch:{ all -> 0x0081 }
        goto L_0x0043;
    L_0x0081:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0081 }
        throw r0;
    L_0x0084:
        r0 = 1;
        if (r0 != r11) goto L_0x009b;
    L_0x0087:
        r0 = r10.f4487n;	 Catch:{ all -> 0x0081 }
        if (r0 == 0) goto L_0x009b;
    L_0x008b:
        r0 = "SendCommandUtil";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0081 }
        r2 = 0;
        r3 = "解绑重连上报正在连接";
        r1[r2] = r3;	 Catch:{ all -> 0x0081 }
        com.huawei.p190v.C2538c.m12680e(r0, r1);	 Catch:{ all -> 0x0081 }
        monitor-exit(r4);	 Catch:{ all -> 0x0081 }
        goto L_0x0043;
    L_0x009b:
        r0 = 4;
        if (r0 != r11) goto L_0x00b5;
    L_0x009e:
        r0 = r10.f4488o;	 Catch:{ all -> 0x0081 }
        if (r0 == 0) goto L_0x00b5;
    L_0x00a2:
        r0 = "SendCommandUtil";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0081 }
        r2 = 0;
        r3 = "不上报配对状态";
        r1[r2] = r3;	 Catch:{ all -> 0x0081 }
        com.huawei.p190v.C2538c.m12680e(r0, r1);	 Catch:{ all -> 0x0081 }
        r0 = 0;
        r10.f4488o = r0;	 Catch:{ all -> 0x0081 }
        monitor-exit(r4);	 Catch:{ all -> 0x0081 }
        goto L_0x0043;
    L_0x00b5:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0081 }
        r0.<init>();	 Catch:{ all -> 0x0081 }
        r1 = "mCallbackList.size()=";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0081 }
        r1 = r10.f4478d;	 Catch:{ all -> 0x0081 }
        r1 = r1.size();	 Catch:{ all -> 0x0081 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0081 }
        r0 = r0.toString();	 Catch:{ all -> 0x0081 }
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0081 }
        com.huawei.p190v.C2538c.m12664a(r0, r1);	 Catch:{ all -> 0x0081 }
        r0 = 0;
        r2 = r0;
    L_0x00d6:
        r0 = r10.f4478d;	 Catch:{ all -> 0x0081 }
        r0 = r0.size();	 Catch:{ all -> 0x0081 }
        if (r2 >= r0) goto L_0x017f;
    L_0x00de:
        r0 = r10.f4478d;	 Catch:{ all -> 0x0081 }
        r0 = r0.get(r2);	 Catch:{ all -> 0x0081 }
        r0 = (com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1685c) r0;	 Catch:{ all -> 0x0081 }
        r1 = "SendCommandUtil";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0081 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0081 }
        r7.<init>();	 Catch:{ all -> 0x0081 }
        r8 = " reportConnectStatus The Current Thread ID Is";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0081 }
        r8 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0081 }
        r8 = r8.getId();	 Catch:{ all -> 0x0081 }
        r7 = r7.append(r8);	 Catch:{ all -> 0x0081 }
        r8 = ", status = ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0081 }
        r7 = r7.append(r11);	 Catch:{ all -> 0x0081 }
        r8 = ", callback = ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0081 }
        r7 = r7.append(r0);	 Catch:{ all -> 0x0081 }
        r8 = ", errorCode = ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0081 }
        r8 = r10.f4486m;	 Catch:{ all -> 0x0081 }
        r7 = r7.append(r8);	 Catch:{ all -> 0x0081 }
        r7 = r7.toString();	 Catch:{ all -> 0x0081 }
        r5[r6] = r7;	 Catch:{ all -> 0x0081 }
        com.huawei.p190v.C2538c.m12664a(r1, r5);	 Catch:{ all -> 0x0081 }
        r1 = 3;
        if (r1 != r11) goto L_0x0144;
    L_0x012f:
        r1 = -1;
        r5 = r10.f4486m;	 Catch:{ Exception -> 0x014a }
        if (r1 != r5) goto L_0x0137;
    L_0x0134:
        r1 = 1;
        r10.f4486m = r1;	 Catch:{ Exception -> 0x014a }
    L_0x0137:
        r1 = 5;
        r5 = r10.f4486m;	 Catch:{ Exception -> 0x014a }
        r0.mo2593a(r1, r3, r11, r5);	 Catch:{ Exception -> 0x014a }
    L_0x013d:
        r0 = -1;
        r10.f4486m = r0;	 Catch:{ all -> 0x0081 }
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x00d6;
    L_0x0144:
        r1 = 5;
        r5 = 0;
        r0.mo2593a(r1, r3, r11, r5);	 Catch:{ Exception -> 0x014a }
        goto L_0x013d;
    L_0x014a:
        r1 = move-exception;
        r5 = "android.os.DeadObjectException";
        r6 = r1.toString();	 Catch:{ all -> 0x0081 }
        r5 = r5.equals(r6);	 Catch:{ all -> 0x0081 }
        if (r5 == 0) goto L_0x015c;
    L_0x0157:
        r5 = r10.f4479e;	 Catch:{ all -> 0x0081 }
        r5.add(r0);	 Catch:{ all -> 0x0081 }
    L_0x015c:
        r0 = "SendCommandUtil";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0081 }
        r6 = 0;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0081 }
        r7.<init>();	 Catch:{ all -> 0x0081 }
        r8 = "reportConnectStatus() ";
        r7 = r7.append(r8);	 Catch:{ all -> 0x0081 }
        r1 = r1.getMessage();	 Catch:{ all -> 0x0081 }
        r1 = r7.append(r1);	 Catch:{ all -> 0x0081 }
        r1 = r1.toString();	 Catch:{ all -> 0x0081 }
        r5[r6] = r1;	 Catch:{ all -> 0x0081 }
        com.huawei.p190v.C2538c.m12664a(r0, r5);	 Catch:{ all -> 0x0081 }
        goto L_0x013d;
    L_0x017f:
        r0 = 0;
        r1 = r0;
    L_0x0181:
        r0 = r10.f4479e;	 Catch:{ all -> 0x0081 }
        r0 = r0.size();	 Catch:{ all -> 0x0081 }
        if (r1 >= r0) goto L_0x01ac;
    L_0x0189:
        r0 = 0;
    L_0x018a:
        r2 = r10.f4478d;	 Catch:{ all -> 0x0081 }
        r2 = r2.size();	 Catch:{ all -> 0x0081 }
        if (r0 >= r2) goto L_0x01a5;
    L_0x0192:
        r2 = r10.f4478d;	 Catch:{ all -> 0x0081 }
        r2 = r2.get(r0);	 Catch:{ all -> 0x0081 }
        r3 = r10.f4479e;	 Catch:{ all -> 0x0081 }
        r3 = r3.get(r1);	 Catch:{ all -> 0x0081 }
        if (r2 != r3) goto L_0x01a9;
    L_0x01a0:
        r2 = r10.f4478d;	 Catch:{ all -> 0x0081 }
        r2.remove(r0);	 Catch:{ all -> 0x0081 }
    L_0x01a5:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0181;
    L_0x01a9:
        r0 = r0 + 1;
        goto L_0x018a;
    L_0x01ac:
        r0 = r10.f4479e;	 Catch:{ all -> 0x0081 }
        r0.clear();	 Catch:{ all -> 0x0081 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0081 }
        r0.<init>();	 Catch:{ all -> 0x0081 }
        r1 = "mRemoveCallbackList.size()=";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0081 }
        r1 = r10.f4479e;	 Catch:{ all -> 0x0081 }
        r1 = r1.size();	 Catch:{ all -> 0x0081 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0081 }
        r0 = r0.toString();	 Catch:{ all -> 0x0081 }
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0081 }
        com.huawei.p190v.C2538c.m12664a(r0, r1);	 Catch:{ all -> 0x0081 }
        monitor-exit(r4);	 Catch:{ all -> 0x0081 }
        goto L_0x0043;
    L_0x01d3:
        r3 = r0;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginkidwatch.plugin.a.a.d.as.a(int, boolean):void");
    }

    public void m8010b() {
        if (f4474c != null) {
            f4474c.m7978b();
        }
        as.m7986a(0);
        C2538c.m12664a("SendCommandUtil", "set bt_version_info 0 , bt_version_info=" + as.m7980a());
        this.f4483i.removeCallbacksAndMessages(null);
    }

    public static int m7999c() {
        C2538c.m12674b("SendCommandUtil", "Enter getConnectStatus()");
        return ar.m7970c();
    }

    public void m8007a(C1685c c1685c) {
        synchronized (this.f4478d) {
            if (c1685c != null) {
                if (!this.f4478d.contains(c1685c)) {
                    synchronized (this.f4478d) {
                        C2538c.m12674b("SendCommandUtil", "Enter registerconnectstatuscallback() callback = " + c1685c);
                        this.f4478d.add(c1685c);
                    }
                }
            }
            if (c1685c == null) {
                C2538c.m12674b("SendCommandUtil", "Enter registerconnectstatuscallback() callback is null");
            } else {
                C2538c.m12674b("SendCommandUtil", "Enter registerconnectstatuscallback() callback is in mCallbackList " + c1685c);
            }
        }
    }

    public void m8011b(C1685c c1685c) {
        synchronized (this.f4478d) {
            if (c1685c != null) {
                if (this.f4478d.contains(c1685c)) {
                    synchronized (this.f4478d) {
                        C2538c.m12674b("SendCommandUtil", "Enter unregisterconnectstatuscallback() callback = " + c1685c);
                        this.f4478d.remove(c1685c);
                    }
                }
            }
            if (c1685c == null) {
                C2538c.m12674b("SendCommandUtil", "Enter unregisterconnectstatuscallback() callback is null");
            } else {
                C2538c.m12674b("SendCommandUtil", "Enter unregisterconnectstatuscallback() callback is not in mCallbackList " + c1685c);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7989a(int r10, byte[] r11, com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b r12) {
        /*
        r9 = this;
        r3 = 0;
        r8 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r6 = 1;
        r7 = 0;
        r1 = "SendCommandUtil";
        r2 = new java.lang.Object[r6];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = " The Received Data Is：";
        r4 = r4.append(r5);
        r5 = com.huawei.hwcommonmodel.C0973a.m3509a(r11);
        r4 = r4.append(r5);
        r4 = r4.toString();
        r2[r7] = r4;
        com.huawei.p190v.C2538c.m12674b(r1, r2);
        if (r12 == 0) goto L_0x0052;
    L_0x0028:
        r1 = 0;
        r1 = r11[r1];	 Catch:{ Exception -> 0x005c }
        switch(r1) {
            case 16: goto L_0x0053;
            default: goto L_0x002e;
        };	 Catch:{ Exception -> 0x005c }
    L_0x002e:
        r2 = r3;
    L_0x002f:
        r1 = r9.f4485l;	 Catch:{ Exception -> 0x005c }
        if (r1 == 0) goto L_0x0090;
    L_0x0033:
        r1 = 0;
        r9.f4485l = r1;	 Catch:{ Exception -> 0x005c }
        if (r2 == 0) goto L_0x0050;
    L_0x0038:
        r0 = r2;
        r0 = (int[]) r0;	 Catch:{ Exception -> 0x005c }
        r1 = r0;
        r1 = (int[]) r1;	 Catch:{ Exception -> 0x005c }
        r4 = 0;
        r4 = r1[r4];	 Catch:{ Exception -> 0x005c }
        if (r8 != r4) goto L_0x007e;
    L_0x0043:
        r2 = r1.length;	 Catch:{ Exception -> 0x005c }
        if (r6 != r2) goto L_0x0058;
    L_0x0046:
        r1 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r1 = r9.m7997b(r1);	 Catch:{ Exception -> 0x005c }
        r12.mo2555a(r1);	 Catch:{ Exception -> 0x005c }
    L_0x0050:
        r9.f4480f = r3;
    L_0x0052:
        return;
    L_0x0053:
        r2 = r9.m7984a(r11);	 Catch:{ Exception -> 0x005c }
        goto L_0x002f;
    L_0x0058:
        r12.mo2555a(r1);	 Catch:{ Exception -> 0x005c }
        goto L_0x0050;
    L_0x005c:
        r1 = move-exception;
        r2 = "SendCommandUtil";
        r4 = new java.lang.Object[r6];
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Exception e = ";
        r5 = r5.append(r6);
        r1 = r1.getMessage();
        r1 = r5.append(r1);
        r1 = r1.toString();
        r4[r7] = r1;
        com.huawei.p190v.C2538c.m12680e(r2, r4);
        goto L_0x0050;
    L_0x007e:
        r2 = (int[]) r2;	 Catch:{ Exception -> 0x005c }
        r2 = (int[]) r2;	 Catch:{ Exception -> 0x005c }
        r4 = 0;
        r2 = r2[r4];	 Catch:{ Exception -> 0x005c }
        r4 = 0;
        r1 = r1[r4];	 Catch:{ Exception -> 0x005c }
        r1 = r9.m7997b(r1);	 Catch:{ Exception -> 0x005c }
        r12.mo2554a(r2, r1);	 Catch:{ Exception -> 0x005c }
        goto L_0x0050;
    L_0x0090:
        if (r2 != 0) goto L_0x009b;
    L_0x0092:
        r1 = 100001; // 0x186a1 float:1.40131E-40 double:4.9407E-319;
        r2 = "UNKNOW ERROR";
        r12.mo2554a(r1, r2);	 Catch:{ Exception -> 0x005c }
        goto L_0x0050;
    L_0x009b:
        r12.mo2555a(r2);	 Catch:{ Exception -> 0x005c }
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginkidwatch.plugin.a.a.d.as.a(int, byte[], com.huawei.pluginkidwatch.plugin.a.a.c.a.b):void");
    }

    private void m7988a(int i, byte[] bArr, int i2, C1620b c1620b) {
        m7989a(i, bArr, c1620b);
    }

    private String m7997b(int i) {
        String str = "";
        switch (i) {
            case 100000:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_OK;
            case 100001:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_UNKNOW;
            case 100002:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_REQUEST_UNSUPPORT;
            case 100003:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_NO_PERMISSION;
            case 100004:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_SYSTEM_BUSY;
            case 100005:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_REQUEST_FORMAT_ERROR;
            case 100006:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_REQUEST_PARAMETER_ERROR;
            case 100007:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_SYSTEM_MEMORY_INADEQUATE;
            case 100008:
                return HWDeviceDFXConstants.ERROR_CODE_INFO_RESPONSE_TIMEOUT;
            default:
                return str;
        }
    }

    private String m8000c(int i) {
        String str = "";
        switch (i) {
            case 1:
                return "ERR_COMMAND_TIMEOOUT";
            case 2:
                return "ERR_CODE_COMMAND_RESEND_TOO_MORE";
            case 10:
                return "ERR_INVALID_DEVICE";
            case 16:
                return "ERR_DEVICE_UNKNOWN";
            default:
                return "ERR_DEVICE_UNKNOWN";
        }
    }

    private void m7991a(C1620b c1620b, int i, String str) {
        if (c1620b != null) {
            if (3 != i) {
                c1620b.mo2554a(i, str);
            }
            this.f4480f = null;
            return;
        }
        C2538c.m12674b("SendCommandUtil", " callBack(IBaseResponseCallback) is null ,so don't need to report error");
    }

    public void m8008a(C1686d c1686d, int i) {
        if (f4474c != null) {
            C2538c.m12664a("SendCommandUtil", "Enter searchBluetoothDevice()");
            f4474c.m7976a(c1686d, i);
            return;
        }
        C2538c.m12664a("SendCommandUtil", "searchBluetoothDevice(), mWearableManager is null");
    }

    public void m8013d() {
        if (f4474c != null) {
            f4474c.m7972a();
            return;
        }
        C2538c.m12664a("SendCommandUtil", "cancelSearchBluetoothDevice(), mWearableManager is null");
    }

    public void m8012b(byte[] bArr, C1620b c1620b) {
        C2538c.m12674b("SendCommandUtil", " Enter writeDataToLinkLossCharacteristic() The Command Is：=" + C0973a.m3509a(bArr));
        f4474c.m7977a(bArr, c1620b);
    }

    private Object m7984a(byte[] bArr) throws Exception {
        C2538c.m12664a("SendCommandUtil", "Enter switchDeviceManagementType(),data[1]=" + bArr[1]);
        int i = bArr[1] & 128;
        int i2 = bArr[1];
        C2538c.m12664a("SendCommandUtil", "(data[1] & 0x80) =" + i);
        if (i > 0) {
            i2 = bArr[1] - 128;
            if (i2 < 0) {
                i2 += 256;
            }
        }
        C2538c.m12664a("SendCommandUtil", "current command is:" + i2);
        switch (i2) {
            case 1:
                return this.f4484k.m8163a(bArr);
            case 2:
                return this.f4484k.m8164b(bArr);
            default:
                C2538c.m12664a("SendCommandUtil", "current command is: =" + i2);
                return null;
        }
    }

    public boolean m8014e() {
        C2538c.m12674b("SendCommandUtil", "Enter enableBluetooth()");
        return f4474c.m7979d();
    }

    public static void m7990a(BluetoothDevice bluetoothDevice) {
        f4473b = bluetoothDevice;
    }

    public static void m7992a(ar arVar) {
        f4474c = arVar;
    }
}
