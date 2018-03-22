package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1690h;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1691i;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1692j;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p159b.C1693a;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p159b.C1694b;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p158b.C1682a;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p158b.C1683b;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"UseSparseArrays", "HandlerLeak", "NewApi"})
/* compiled from: DataTransferStateMachine */
public class C1719y {
    private static int f4596F = 512;
    public static final C1694b f4597a = new C1694b();
    private static byte f4598c;
    private static Object f4599v = new Object();
    private static final Object f4600w = new Object();
    private static final byte[] f4601x = new byte[0];
    private static boolean f4602y = false;
    private int f4603A = 0;
    private C1682a f4604B;
    private int f4605C = 0;
    private List<byte[]> f4606D = new ArrayList();
    private C1692j f4607E;
    private int f4608G = 10;
    private int f4609H = 0;
    private int f4610I = 0;
    public C1691i f4611b = new ab(this);
    private int f4612d = 3000;
    private int f4613e = 2;
    private boolean f4614f = false;
    private boolean f4615g = true;
    private int f4616h = 20;
    private int f4617i = 0;
    private int f4618j = 0;
    private int f4619k = 0;
    private HashMap<Integer, af> f4620l = new HashMap();
    private ArrayList<C1717w> f4621m = new ArrayList();
    private ArrayList<C1717w> f4622n = new ArrayList();
    private af f4623o = null;
    private HandlerThread f4624p = null;
    private ad f4625q = null;
    private C1700i f4626r = null;
    private C1690h f4627s = null;
    private ae f4628t = null;
    private Context f4629u = null;
    private byte[] f4630z = null;

    public C1719y(Context context, int i) {
        C2538c.m12674b("DataTransferStateMachine", " DataTransferStateMachine initial context = " + context + ",deviceType=" + i);
        this.f4629u = context;
        this.f4605C = i;
        this.f4620l.put(Integer.valueOf(0), new ag());
        this.f4620l.put(Integer.valueOf(1), new ac());
        this.f4620l.put(Integer.valueOf(2), new aj());
        this.f4620l.put(Integer.valueOf(3), new ai());
        this.f4620l.put(Integer.valueOf(4), new ah());
        m8185b(2);
        this.f4604B = null;
        this.f4604B = m8196c(i);
        this.f4612d = 2000;
        this.f4613e = 0;
        this.f4628t = new ae();
    }

    public void m8226a() {
        if (this.f4625q == null) {
            this.f4624p = new HandlerThread("DataTransferStateMachine");
            this.f4624p.start();
            this.f4625q = new ad(this, this.f4624p.getLooper());
            C2538c.m12674b("DataTransferStateMachine", "mHandlerThread restart.");
        }
    }

    public void m8227a(int i) {
        C2538c.m12674b("DataTransferStateMachine", "setPacketMax,mSliceSize= " + i);
        this.f4616h = i;
    }

    public void m8229a(BluetoothDevice bluetoothDevice, C1690h c1690h, int i) {
        C2538c.m12674b("DataTransferStateMachine", "connect enter.  connect start here  deviceType = " + i);
        this.f4605C = i;
        int a = C1700i.m8041a();
        if (!(a == 0 || 3 == a)) {
            C1705k.m8090b(true);
            m8231b();
            C2538c.m12674b("DataTransferStateMachine", "old connect closed ");
        }
        this.f4627s = c1690h;
        this.f4612d = 10000;
        this.f4613e = 0;
        this.f4626r = C1704j.m8070a(this.f4629u, bluetoothDevice, this.f4628t, i);
        if (this.f4626r != null) {
            if (this.f4625q == null) {
                this.f4624p = new HandlerThread("DataTransferStateMachine");
                this.f4624p.start();
                this.f4625q = new ad(this, this.f4624p.getLooper());
                C2538c.m12674b("DataTransferStateMachine", "mHandlerThread restart.");
            }
            this.f4625q.postDelayed(new C1720z(this, bluetoothDevice, i), 1000);
            return;
        }
        C2538c.m12674b("DataTransferStateMachine", "mConnectService is null.");
        c1690h.mo2569a(11, "mConnectService is null.");
    }

    public void m8231b() {
        C2538c.m12674b("DataTransferStateMachine", "disconnect enter.");
        if (this.f4626r != null) {
            this.f4626r.mo2589a(true);
        } else {
            C2538c.m12674b("DataTransferStateMachine", "disconnect() mConnectService is null");
        }
        if (!(this.f4624p == null || this.f4625q == null)) {
            this.f4625q.removeCallbacksAndMessages(null);
            this.f4625q = null;
            this.f4624p.getLooper().quit();
            this.f4624p = null;
            C2538c.m12674b("DataTransferStateMachine", "mHandlerThread close.");
        }
        f4597a.m7886a(10);
        m8215l();
        C2538c.m12674b("DataTransferStateMachine", "disconnect finsh.");
    }

    public void m8228a(int i, byte[] bArr) {
        ArrayList arrayList;
        if (5 == this.f4605C) {
            arrayList = new ArrayList();
            arrayList.add(bArr);
        } else {
            arrayList = this.f4604B.mo2564a(i, bArr, this.f4616h);
        }
        if (arrayList != null) {
            C1717w c1717w = new C1717w(arrayList, false);
            synchronized (this.f4621m) {
                this.f4621m.add(c1717w);
            }
            if (this.f4625q != null) {
                this.f4625q.sendEmptyMessage(0);
            }
        }
    }

    public void m8230a(byte[] bArr, C1620b c1620b) {
        C2538c.m12674b("DataTransferStateMachine", "Enter writeDataToLinkLossCharacteristic()");
        if (this.f4626r != null) {
            this.f4626r.mo2592a(bArr, c1620b);
            return;
        }
        C2538c.m12674b("DataTransferStateMachine", "mConnectService is null");
    }

    public C1694b m8225a(int i, byte[] bArr, int i2) {
        C1694b c1694b;
        synchronized (f4601x) {
            C1719y.m8169a(bArr[0]);
            C2538c.m12674b("DataTransferStateMachine", "Enter sendCommandSyc(),packet=" + al.m7917a(bArr) + ",checkFlag=" + f4598c);
            if (this.f4604B != null) {
                int i3 = this.f4616h;
                if (2 == m8217m()) {
                    i3 = 128;
                }
                ArrayList a = this.f4604B.mo2564a(i, bArr, i3);
                if (a != null) {
                    C2538c.m12674b("DataTransferStateMachine", "sendCommandSyc(),Command=" + new C1717w(a, true).m8157b().size());
                    synchronized (this.f4621m) {
                        this.f4621m.add(r2);
                    }
                    synchronized (f4599v) {
                        C2538c.m12664a("DataTransferStateMachine", " Enter Lock1 of Bluetooth SDK ");
                        this.f4603A = i2;
                        f4597a.m7886a(1);
                        C2538c.m12664a("DataTransferStateMachine", " Set result null  ");
                        this.f4630z = null;
                        if (this.f4625q != null) {
                            boolean sendEmptyMessage = this.f4625q.sendEmptyMessage(0);
                            C2538c.m12664a("DataTransferStateMachine", " mDataHandler is not null, mDataHandler.sendEmptyMessage = " + sendEmptyMessage + " 状态机状态：" + this.f4623o);
                        } else {
                            C2538c.m12664a("DataTransferStateMachine", " mDataHandler is null  ");
                        }
                        synchronized (f4600w) {
                            C2538c.m12664a("DataTransferStateMachine", " Enter Lock2 of Bluetooth SDK ");
                            try {
                                C2538c.m12664a("DataTransferStateMachine", " Lock 40s ");
                                C1719y.m8174a(true);
                                f4600w.wait(40000);
                            } catch (InterruptedException e) {
                                C2538c.m12680e("DataTransferStateMachine", "Exception e = " + e.getMessage());
                            }
                        }
                        C1719y.m8174a(false);
                        f4597a.m7887a(this.f4630z);
                        C2538c.m12664a("DataTransferStateMachine", " Unlock Lock1 of Bluetooth SDK");
                    }
                }
            } else {
                f4597a.m7886a(11);
                C2538c.m12664a("DataTransferStateMachine", " bluetoothDataWrpperBase is null");
            }
            c1694b = f4597a;
        }
        return c1694b;
    }

    public static int m8194c() {
        return C1700i.m8041a();
    }

    public static int m8199d() {
        return C1700i.m8042b();
    }

    private void m8185b(int i) {
        this.f4623o = (af) this.f4620l.get(Integer.valueOf(i));
        C2538c.m12680e("DataTransferStateMachine", "修改状态机状态为：" + i + " ||SM_STATE_SENDING = 2 SM_STATE_RECEIVING = 3 SM_STATE_RECEIVING_SLICED_CMD_CONFIRM = 4||");
    }

    private void m8206g() {
        C1717w c1717w;
        synchronized (this.f4621m) {
            C2538c.m12664a("DataTransferStateMachine", "mCmdBuffer.size() = " + this.f4621m.size());
            if (this.f4621m.size() > 0) {
                c1717w = (C1717w) this.f4621m.get(0);
            } else {
                c1717w = null;
            }
        }
        if (c1717w == null) {
            C2538c.m12664a("DataTransferStateMachine", " Exception 2: Unlock Lock2 of Bluetooth SDK  ");
            f4597a.m7886a(16);
            m8215l();
        } else if (!c1717w.m8161e()) {
            if (this.f4626r != null) {
                this.f4626r.mo2590a((byte[]) c1717w.m8157b().get(c1717w.m8154a()));
            }
            synchronized (this.f4621m) {
                if (this.f4621m.size() > 0) {
                    this.f4621m.remove(0);
                }
            }
        } else if (!m8191b(c1717w)) {
            C2538c.m12664a("DataTransferStateMachine", " cmd.packets.get(cmd.sequence).length " + ((byte[]) c1717w.m8157b().get(c1717w.m8154a())).length);
            if (((byte[]) c1717w.m8157b().get(c1717w.m8154a())).length >= 8) {
                m8171a(c1717w);
            } else if (this.f4625q != null) {
                this.f4625q.sendEmptyMessageDelayed(2, (long) this.f4612d);
            }
            C2538c.m12674b("DataTransferStateMachine", " The Command to Send Is： HEX=" + C1719y.m8168a((byte[]) c1717w.m8157b().get(c1717w.m8154a())));
            if (c1717w.m8157b().size() > 1) {
                C2538c.m12674b("DataTransferStateMachine", "send slice idx:" + c1717w.m8154a() + "data send:" + al.m7917a((byte[]) c1717w.m8157b().get(c1717w.m8154a())));
            } else {
                C2538c.m12674b("DataTransferStateMachine", "send not slice data send:" + al.m7917a((byte[]) c1717w.m8157b().get(c1717w.m8154a())));
            }
            if (this.f4626r != null) {
                this.f4626r.mo2591a((byte[]) c1717w.m8157b().get(c1717w.m8154a()), ((byte[]) c1717w.m8157b().get(c1717w.m8154a())).length);
            }
            if (c1717w.m8157b().size() == 1) {
                m8185b(3);
            } else {
                m8185b(4);
            }
        }
    }

    private void m8171a(C1717w c1717w) {
        if (((byte[]) c1717w.m8157b().get(c1717w.m8154a()))[6] == (byte) 6 && ((byte[]) c1717w.m8157b().get(c1717w.m8154a()))[8] == (byte) 5 && 4 == this.f4605C) {
            if (this.f4625q != null) {
                this.f4625q.sendEmptyMessageDelayed(2, StatisticConfig.MIN_UPLOAD_INTERVAL);
            }
            this.f4613e = 0;
        } else if (((byte[]) c1717w.m8157b().get(c1717w.m8154a()))[6] == (byte) 4 && ((byte[]) c1717w.m8157b().get(c1717w.m8154a()))[8] == (byte) 7 && 2 == this.f4605C) {
            if (this.f4625q != null) {
                this.f4625q.sendEmptyMessageDelayed(2, 5000);
                C2538c.m12674b("DataTransferStateMachine", "N1 Start_file_transfer setting time out 5s");
            }
            this.f4613e = 2;
        } else if (((byte[]) c1717w.m8157b().get(c1717w.m8154a()))[6] == (byte) 6 && ((byte[]) c1717w.m8157b().get(c1717w.m8154a()))[8] == (byte) 9 && 4 == this.f4605C) {
            if (this.f4625q != null) {
                this.f4625q.sendEmptyMessageDelayed(2, 3000);
            }
            this.f4613e = 2;
        } else if (6 == this.f4605C && ((byte[]) c1717w.m8157b().get(c1717w.m8154a()))[4] == (byte) 10 && ((byte[]) c1717w.m8157b().get(c1717w.m8154a()))[5] == (byte) 4) {
            if (this.f4625q != null) {
                this.f4625q.sendEmptyMessageDelayed(2, 3000);
            }
            this.f4613e = 0;
        } else if (this.f4625q != null) {
            this.f4625q.sendEmptyMessageDelayed(2, (long) this.f4612d);
        }
    }

    private boolean m8191b(C1717w c1717w) {
        if (c1717w.m8157b().size() > c1717w.m8154a()) {
            return false;
        }
        synchronized (this.f4621m) {
            this.f4621m.remove(0);
        }
        C2538c.m12664a("DataTransferStateMachine", " Exception 1: Unlock Lock2 of Bluetooth SDK  ");
        f4597a.m7886a(16);
        m8215l();
        return true;
    }

    private void m8170a(Message message) {
        C1717w c1717w;
        int i = message.arg1;
        synchronized (this.f4621m) {
            if (this.f4621m.size() > 0) {
                C2538c.m12674b("DataTransferStateMachine", "ReceivingState msg.cmd: " + ((C1717w) this.f4621m.get(0)));
                c1717w = r0;
            } else {
                c1717w = null;
            }
        }
        C2538c.m12674b("DataTransferStateMachine", "ReceivingState msg  size : " + i);
        if (i > 0) {
            byte[] bArr = (byte[]) message.obj;
            if (!m8180a(c1717w, bArr)) {
                this.f4618j = 0;
                C1693a b = this.f4604B.mo2565b(i, bArr, f4596F);
                if (!b.m7880a()) {
                    C2538c.m12674b("DataTransferStateMachine", "not slice respond data receive:" + al.m7917a(bArr));
                    if (m8175a(i, bArr, b)) {
                        return;
                    }
                } else if (b.m7884e()) {
                    C2538c.m12674b("DataTransferStateMachine", "ReceivingState: piece idx:" + b.m7881b() + "data receive:" + al.m7917a(bArr));
                    if (b.m7882c() == 1 || b.m7882c() == 2) {
                        this.f4617i = 0;
                    }
                    if (m8179a(c1717w, b)) {
                        return;
                    }
                } else {
                    C2538c.m12680e("DataTransferStateMachine", "Slice received is broken or not expected, remote device need to resend this packet.");
                    this.f4626r.mo2590a(bArr);
                    return;
                }
            }
            return;
        }
        m8185b(2);
        synchronized (this.f4621m) {
            if (this.f4621m.size() > 0 && this.f4625q != null) {
                this.f4625q.sendEmptyMessage(0);
            }
        }
    }

    private boolean m8175a(int i, byte[] bArr, C1693a c1693a) {
        if (this.f4605C == 0) {
            if (this.f4603A != (bArr[1] & 255)) {
                C2538c.m12664a("DataTransferStateMachine", " Receiving data Is Not Match The Sending Command  data[]：" + (bArr[1] & 255) + "   identification：" + this.f4603A);
                return true;
            }
            this.f4630z = Arrays.copyOfRange(bArr, 0, i);
        } else {
            this.f4630z = Arrays.copyOfRange(c1693a.m7883d(), 0, c1693a.m7883d().length);
            if (this.f4630z != null && this.f4630z.length > 0 && 6 != this.f4605C && !m8189b(this.f4630z[0])) {
                C2538c.m12680e("DataTransferStateMachine", "requestID check error,wait time out");
                return true;
            } else if (this.f4605C == 6) {
                C2538c.m12674b("DataTransferStateMachine", "response data serviceid=" + c1693a.m7883d()[0] + ",commandid=" + c1693a.m7883d()[1]);
                if (!(this.f4609H == c1693a.m7883d()[0] && this.f4610I == c1693a.m7883d()[1])) {
                    C2538c.m12674b("DataTransferStateMachine", "response data serviceid=" + c1693a.m7883d()[0] + ",commandid=" + c1693a.m7883d()[1] + " is not same with send");
                    return true;
                }
            }
        }
        if (this.f4630z != null) {
            C2538c.m12674b("DataTransferStateMachine", " ReceivingState result is not null ，ReceivingState command： HEX=" + C1719y.m8168a(this.f4630z));
        }
        this.f4617i = 0;
        f4597a.m7886a(0);
        if (!(this.f4605C == 0 || 3 == this.f4605C || 5 == this.f4605C || 6 == this.f4605C || 2 != C1719y.m8199d())) {
            this.f4626r.mo2590a(al.m7918a("AA0101594D"));
        }
        if (this.f4625q != null) {
            this.f4625q.removeMessages(2);
        }
        synchronized (this.f4621m) {
            if (this.f4621m.size() > 0) {
                this.f4621m.remove(0);
            }
        }
        m8215l();
        return false;
    }

    private boolean m8180a(C1717w c1717w, byte[] bArr) {
        if (this.f4605C != 0) {
            String a = al.m7917a(bArr);
            if ((a.equals("AA0100496C") || a.equals("AA01000049") || a.equals("AA0C010000")) && 4 == this.f4605C) {
                if (c1717w != null && ((byte[]) c1717w.m8157b().get(c1717w.m8154a())).length >= 8 && ((byte[]) c1717w.m8157b().get(c1717w.m8154a()))[6] == (byte) 6 && ((byte[]) c1717w.m8157b().get(c1717w.m8154a()))[8] == (byte) 5) {
                    C2538c.m12674b("DataTransferStateMachine", "SDK收到请求配对的ACK回复");
                    this.f4628t.mo2568a(4);
                }
                return true;
            } else if (a.equals("AA0102692E")) {
                this.f4618j++;
                if (this.f4618j <= 1) {
                    if (this.f4625q != null) {
                        this.f4625q.removeMessages(2);
                    }
                    m8185b(2);
                    synchronized (this.f4621m) {
                        if (this.f4621m.size() > 0 && this.f4625q != null) {
                            this.f4625q.sendEmptyMessage(0);
                        }
                    }
                    C2538c.m12680e("DataTransferStateMachine", "Slice received is broken,crc error, request slice resend reach 2 times limit.");
                }
                return true;
            }
        }
        return false;
    }

    private boolean m8179a(C1717w c1717w, C1693a c1693a) {
        if (c1717w == null || c1693a == null) {
            return false;
        }
        this.f4606D.add(c1693a.m7883d());
        if (c1693a.m7885f()) {
            if (this.f4605C != 0) {
                c1717w.m8158b(m8165a(this.f4606D));
                c1717w.m8156a(ByteBuffer.allocate(c1717w.m8160d()));
                for (int i = 0; i < this.f4606D.size(); i++) {
                    c1717w.m8159c().put((byte[]) this.f4606D.get(i));
                }
                c1717w.m8159c().flip();
                this.f4606D.clear();
            } else {
                c1717w.m8159c().flip();
            }
            C2538c.m12674b("DataTransferStateMachine", "all slice data receive:" + al.m7917a(c1717w.m8159c().array()));
            this.f4630z = Arrays.copyOfRange(c1717w.m8159c().array(), 0, c1717w.m8160d());
            if (this.f4630z == null || this.f4630z.length <= 0 || m8189b(this.f4630z[0])) {
                f4597a.m7886a(0);
                this.f4626r.mo2590a(al.m7918a("AA0101594D"));
                this.f4617i = 0;
                synchronized (this.f4621m) {
                    if (this.f4621m.size() > 0) {
                        this.f4621m.remove(0);
                    }
                }
                if (this.f4625q != null) {
                    this.f4625q.removeMessages(2);
                }
                C2538c.m12664a("DataTransferStateMachine", " 切片数据全部收到：  SDK解锁");
                m8215l();
                return false;
            }
            C2538c.m12680e("DataTransferStateMachine", "requestID check error,wait time out");
            return true;
        }
        if (2 == C1719y.m8199d()) {
            this.f4626r.mo2590a(al.m7918a("AA0101594D"));
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m8208h() {
        /*
        r7 = this;
        r6 = 8;
        r3 = 6;
        r5 = 1;
        r4 = 0;
        r0 = r7.f4606D;
        r0.clear();
        r1 = r7.f4621m;
        monitor-enter(r1);
        r0 = r7.f4621m;	 Catch:{ all -> 0x0068 }
        r0 = r0.size();	 Catch:{ all -> 0x0068 }
        if (r0 <= 0) goto L_0x0066;
    L_0x0015:
        r0 = r7.f4621m;	 Catch:{ all -> 0x0068 }
        r2 = 0;
        r0 = r0.get(r2);	 Catch:{ all -> 0x0068 }
        r0 = (com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d.C1717w) r0;	 Catch:{ all -> 0x0068 }
        r2 = r7.f4617i;	 Catch:{ all -> 0x0068 }
        r2 = r2 + 1;
        r7.f4617i = r2;	 Catch:{ all -> 0x0068 }
        monitor-exit(r1);	 Catch:{ all -> 0x0068 }
        r1 = r7.f4617i;
        r2 = r7.f4613e;
        if (r1 > r2) goto L_0x006e;
    L_0x002b:
        r1 = "DataTransferStateMachine";
        r2 = new java.lang.Object[r5];
        r3 = "command respond time out, try resend.";
        r2[r4] = r3;
        com.huawei.p190v.C2538c.m12674b(r1, r2);
        r1 = 2;
        r7.m8185b(r1);
        r1 = r7.f4621m;
        monitor-enter(r1);
        r2 = r7.f4621m;	 Catch:{ all -> 0x006b }
        r2 = r2.size();	 Catch:{ all -> 0x006b }
        if (r2 <= 0) goto L_0x0064;
    L_0x0045:
        r2 = "DataTransferStateMachine";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x006b }
        r4 = 0;
        r5 = "clean receiveBuffer and set sequence to zero.";
        r3[r4] = r5;	 Catch:{ all -> 0x006b }
        com.huawei.p190v.C2538c.m12674b(r2, r3);	 Catch:{ all -> 0x006b }
        r2 = 0;
        r0.m8156a(r2);	 Catch:{ all -> 0x006b }
        r2 = 0;
        r0.m8155a(r2);	 Catch:{ all -> 0x006b }
        r0 = r7.f4625q;	 Catch:{ all -> 0x006b }
        if (r0 == 0) goto L_0x0064;
    L_0x005e:
        r0 = r7.f4625q;	 Catch:{ all -> 0x006b }
        r2 = 0;
        r0.sendEmptyMessage(r2);	 Catch:{ all -> 0x006b }
    L_0x0064:
        monitor-exit(r1);	 Catch:{ all -> 0x006b }
    L_0x0065:
        return;
    L_0x0066:
        monitor-exit(r1);	 Catch:{ all -> 0x0068 }
        goto L_0x0065;
    L_0x0068:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0068 }
        throw r0;
    L_0x006b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x006b }
        throw r0;
    L_0x006e:
        r1 = r0.m8157b();
        r2 = r0.m8154a();
        r1 = r1.get(r2);
        r1 = (byte[]) r1;
        r1 = r1.length;
        if (r1 < r6) goto L_0x00b6;
    L_0x007f:
        r1 = r0.m8157b();
        r2 = r0.m8154a();
        r1 = r1.get(r2);
        r1 = (byte[]) r1;
        r1 = r1[r3];
        if (r1 != r3) goto L_0x00b6;
    L_0x0091:
        r1 = r0.m8157b();
        r0 = r0.m8154a();
        r0 = r1.get(r0);
        r0 = (byte[]) r0;
        r0 = r0[r6];
        r1 = 9;
        if (r0 != r1) goto L_0x00b6;
    L_0x00a5:
        r0 = 4;
        r1 = r7.f4605C;
        if (r0 != r1) goto L_0x00b6;
    L_0x00aa:
        r0 = r7.f4615g;
        if (r0 == 0) goto L_0x00b6;
    L_0x00ae:
        r0 = com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d.C1705k.m8094c();
        r7.m8176a(r0);
        goto L_0x0065;
    L_0x00b6:
        r0 = "DataTransferStateMachine";
        r1 = new java.lang.Object[r5];
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Wait respond timeout more than ";
        r2 = r2.append(r3);
        r3 = r7.f4613e;
        r2 = r2.append(r3);
        r3 = " times, drop this command.";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1[r4] = r2;
        com.huawei.p190v.C2538c.m12677c(r0, r1);
        r7.f4615g = r5;
        r7.f4617i = r4;
        r7.f4618j = r4;
        r0 = f4597a;
        r0.m7886a(r5);
        r7.m8215l();
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.pluginkidwatch.plugin.a.a.d.y.h():void");
    }

    private void m8186b(Message message) {
        int i = message.arg1;
        if (i > 0) {
            byte[] bArr = (byte[]) message.obj;
            String a = al.m7917a(bArr);
            if (a.equals("AA0100496C") || a.equals("AA01000049") || a.equals("AA0C010000")) {
                m8214k();
                return;
            } else if (a.equals("AA0102692E")) {
                m8212j();
                return;
            } else {
                C1693a b = this.f4604B.mo2565b(i, bArr, f4596F);
                if (!b.m7880a()) {
                    C2538c.m12674b("DataTransferStateMachine", "not slice respond data receive:" + al.m7917a(bArr));
                    if (m8190b(b)) {
                        return;
                    }
                } else if (m8183a(bArr, b)) {
                    return;
                }
            }
        }
        m8185b(2);
        synchronized (this.f4621m) {
            if (this.f4621m.size() > 0 && this.f4625q != null) {
                this.f4625q.sendEmptyMessage(0);
            }
        }
    }

    private boolean m8183a(byte[] bArr, C1693a c1693a) {
        if (c1693a.m7884e()) {
            C2538c.m12674b("DataTransferStateMachine", "ReceivingSlicedCommandConfirmState: piece idx:" + c1693a.m7881b() + "ACK data receive:" + al.m7917a(bArr));
            return m8177a(c1693a);
        }
        C2538c.m12680e("DataTransferStateMachine", "Slice received is broken or not expected, resend this command.");
        return m8210i();
    }

    private boolean m8177a(C1693a c1693a) {
        this.f4619k = 0;
        this.f4617i = 0;
        this.f4618j = 0;
        C1717w c1717w = null;
        synchronized (this.f4621m) {
            if (this.f4621m.size() > 0) {
                c1717w = (C1717w) this.f4621m.get(0);
            }
        }
        if (c1717w == null || !m8178a(c1693a, c1717w)) {
            return false;
        }
        return true;
    }

    private boolean m8178a(C1693a c1693a, C1717w c1717w) {
        if (c1693a.m7885f()) {
            if (this.f4605C != 0) {
                this.f4606D.add(c1693a.m7883d());
                c1717w.m8158b(m8165a(this.f4606D));
                if (c1717w.m8159c() == null) {
                    c1717w.m8156a(ByteBuffer.allocate(c1717w.m8160d()));
                }
                for (int i = 0; i < this.f4606D.size(); i++) {
                    c1717w.m8159c().put((byte[]) this.f4606D.get(i));
                }
                c1717w.m8159c().flip();
                this.f4606D.clear();
                C2538c.m12674b("DataTransferStateMachine", "all slice data receive:" + al.m7917a(c1717w.m8159c().array()));
                this.f4630z = Arrays.copyOfRange(c1717w.m8159c().array(), 0, c1717w.m8160d());
                if (this.f4630z == null || this.f4630z.length <= 0 || m8189b(this.f4630z[0])) {
                    f4597a.m7886a(0);
                    if (!(this.f4605C == 0 || 3 == this.f4605C || 5 == this.f4605C || 6 == this.f4605C)) {
                        this.f4626r.mo2590a(al.m7918a("AA0101594D"));
                    }
                    C2538c.m12664a("DataTransferStateMachine", " 切片数据全部收到：  SDK解锁");
                    m8215l();
                } else {
                    C2538c.m12680e("DataTransferStateMachine", "requestID check error,wait time out");
                    return true;
                }
            }
            if (this.f4625q == null) {
                return false;
            }
            this.f4625q.removeMessages(2);
            return false;
        }
        if (this.f4606D.size() != 0 && c1693a.m7881b() == (byte) 1) {
            this.f4606D.clear();
        }
        this.f4606D.add(c1693a.m7883d());
        return true;
    }

    private boolean m8210i() {
        this.f4619k++;
        if (this.f4619k <= this.f4613e) {
            return false;
        }
        C2538c.m12680e("DataTransferStateMachine", "Slice received is broken, request slice resend reach 3 times limit.");
        this.f4619k = 0;
        this.f4618j = 0;
        C2538c.m12680e("DataTransferStateMachine", "Slice send respond error, drop this command.");
        f4597a.m7886a(2);
        if (this.f4625q != null) {
            this.f4625q.removeMessages(2);
        }
        m8215l();
        return true;
    }

    private boolean m8190b(C1693a c1693a) {
        this.f4630z = Arrays.copyOfRange(c1693a.m7883d(), 0, c1693a.m7883d().length);
        C2538c.m12674b("DataTransferStateMachine", " ReceivingState command  HEX=" + C1719y.m8168a(this.f4630z));
        if (this.f4630z == null || this.f4630z.length <= 0 || m8189b(this.f4630z[0])) {
            f4597a.m7886a(0);
            if (!(this.f4605C == 0 || 3 == this.f4605C || 5 == this.f4605C || 6 == this.f4605C || 2 != C1719y.m8199d())) {
                this.f4626r.mo2590a(al.m7918a("AA0101594D"));
            }
            synchronized (this.f4621m) {
                if (this.f4621m.size() > 0) {
                    this.f4621m.remove(0);
                }
            }
            this.f4617i = 0;
            this.f4618j = 0;
            if (this.f4625q != null) {
                this.f4625q.removeMessages(2);
            }
            m8215l();
            return false;
        }
        C2538c.m12680e("DataTransferStateMachine", "requestID check error,wait time out");
        return true;
    }

    private void m8212j() {
        this.f4618j++;
        if (this.f4618j <= 1) {
            m8185b(2);
            synchronized (this.f4621m) {
                if (this.f4621m.size() > 0 && this.f4625q != null) {
                    this.f4625q.removeMessages(2);
                    this.f4625q.sendEmptyMessage(0);
                }
            }
            C2538c.m12680e("DataTransferStateMachine", "Slice received is broken,crc error, request slice resend reach 2 times limit.");
            return;
        }
        this.f4625q.sendEmptyMessage(2);
    }

    private void m8214k() {
        C1717w c1717w = null;
        synchronized (this.f4621m) {
            if (this.f4621m.size() > 0) {
                c1717w = (C1717w) this.f4621m.get(0);
            }
        }
        if (c1717w != null) {
            c1717w.m8155a(c1717w.m8154a() + 1);
            if (c1717w.m8154a() < c1717w.m8157b().size()) {
                m8185b(2);
                synchronized (this.f4621m) {
                    if (this.f4621m.size() > 0 && this.f4625q != null) {
                        this.f4625q.removeMessages(2);
                        this.f4625q.sendEmptyMessage(0);
                    }
                }
            }
        }
    }

    private void m8215l() {
        synchronized (f4600w) {
            C2538c.m12664a("DataTransferStateMachine", " unLockLock2");
            synchronized (this.f4621m) {
                if (this.f4621m.size() > 0) {
                    this.f4621m.clear();
                }
            }
            if (this.f4622n != null) {
                this.f4622n.clear();
            }
            if (C1719y.m8202e()) {
                f4600w.notifyAll();
            }
            m8185b(2);
        }
    }

    private boolean m8193b(byte[] bArr) {
        String a = al.m7917a(bArr);
        if (!a.substring(0, 2).equals("AA") || a.length() < 10) {
            return false;
        }
        String substring = a.substring(0, a.length() - 4);
        if (al.m7917a(C1682a.m7853a(al.m7918a(substring))).replace(HwAccountConstants.BLANK, "").equals(a.substring(a.length() - 4, a.length()))) {
            return true;
        }
        return false;
    }

    private boolean m8198c(byte[] bArr) {
        String a = al.m7917a(bArr);
        if (a.length() < 10) {
            return false;
        }
        C2538c.m12664a("DataTransferStateMachine", "package lenth=" + a.length());
        int i = 0;
        boolean z = false;
        while (i < a.length()) {
            if (!a.substring(i, i + 2).equals("5A")) {
                return false;
            }
            int parseInt = Integer.parseInt(a.substring(i + 2, i + 6), 16) + 3;
            if (((parseInt * 2) + i) + 4 > a.length()) {
                return false;
            }
            String substring = a.substring(i, (parseInt * 2) + i);
            if (!al.m7917a(C1682a.m7853a(al.m7918a(substring))).replace(HwAccountConstants.BLANK, "").equals(a.substring((parseInt * 2) + i, ((parseInt * 2) + i) + 4))) {
                z = false;
                break;
            }
            i += (parseInt * 2) + 4;
            z = true;
        }
        C2538c.m12680e("DataTransferStateMachine", "checkResponseV2 ,flag " + z);
        return z;
    }

    public static String m8168a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(bArr.length);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.format("%02X ", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuilder.toString();
    }

    private C1682a m8196c(int i) {
        C1682a c1683b = new C1683b(6);
        m8227a(128);
        C2538c.m12664a("DataTransferStateMachine", "getbluetoothDataWrpperBase() K1 ");
        return c1683b;
    }

    private int m8165a(List<byte[]> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            i += ((byte[]) list.get(i2)).length;
        }
        return i;
    }

    private boolean m8176a(BluetoothGatt bluetoothGatt) {
        try {
            C2538c.m12674b("DataTransferStateMachine", "=========refreshDeviceCache()=========");
            this.f4615g = false;
            boolean booleanValue = ((Boolean) bluetoothGatt.getClass().getMethod(UploadFile.REFRESH_LABEL, new Class[0]).invoke(bluetoothGatt, new Object[0])).booleanValue();
            if (this.f4625q == null) {
                return booleanValue;
            }
            this.f4625q.postDelayed(new aa(this, bluetoothGatt), 1000);
            return booleanValue;
        } catch (NoSuchMethodException e) {
            C2538c.m12680e("DataTransferStateMachine", "An NoSuchMethodException occured while refreshing device");
            return false;
        } catch (IllegalAccessException e2) {
            C2538c.m12680e("DataTransferStateMachine", "An IllegalAccessException occured while refreshing device");
            return false;
        } catch (InvocationTargetException e3) {
            C2538c.m12680e("DataTransferStateMachine", "An InvocationTargetException occured while refreshing device");
            return false;
        }
    }

    private int m8217m() {
        return as.m7980a();
    }

    private boolean m8189b(byte b) {
        C2538c.m12674b("DataTransferStateMachine", " Enter checkResponse()，checkFlag=" + f4598c + "  data[0]=" + b);
        if (f4598c == b) {
            return true;
        }
        return false;
    }

    public static void m8169a(byte b) {
        f4598c = b;
    }

    public static void m8174a(boolean z) {
        f4602y = z;
    }

    public static boolean m8202e() {
        return f4602y;
    }
}
