package com.huawei.hwbtsdk.btmanager;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbtsdk.btmanager.btdeviceservice.*;
import com.huawei.hwbtsdk.p057b.p058a.C0958f;
import com.huawei.hwbtsdk.btmanager.btdeviceservice.C0960a;
import com.huawei.hwbtsdk.btmanager.btdeviceservice.C0959q;
import com.huawei.hwbtsdk.btmanager.p401a.C4629a;
import com.huawei.hwbtsdk.btmanager.p401a.C4630b;
import com.huawei.hwbtsdk.btmanager.p401a.C4631c;
import com.huawei.hwbtsdk.btmanager.p401a.C4632d;
import com.huawei.hwbtsdk.p057b.p400b.C4625b;
import com.huawei.hwbtsdk.p057b.p400b.C4626c;
import com.huawei.hwbtsdk.p057b.p400b.C4627d;
import com.huawei.hwbtsdk.p057b.p400b.C4628e;
import com.huawei.hwbtsdk.p399a.C4600d;
import com.huawei.hwbtsdk.p399a.C4610m;
import com.huawei.hwbtsdk.p399a.C4613p;
import com.huawei.hwbtsdk.p399a.C4618u;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p111o.C5704b;
import com.huawei.p190v.C2538c;

import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: BTDeviceSendCommandUtil */
public class C4648h {
    private static final Object f16993X = new Object();
    public static final Object f16994a = new Object();
    public static final Object f16995b = new Object();
    private int f16996A = -1;
    private int f16997B = -1;
    private int f16998C = -1;
    private int f16999D = -1;
    private boolean f17000E = false;
    private boolean f17001F = false;
    private boolean f17002G = false;
    private C4600d f17003H = C4600d.m21899a();
    private C4633a f17004I;
    private boolean f17005J = false;
    private boolean f17006K = false;
    private boolean f17007L = true;
    private int f17008M = 1;
    private HandlerThread f17009N = null;
    private Handler f17010O = null;
    private int f17011P = 0;
    private int f17012Q = 0;
    private boolean f17013R = false;
    private boolean f17014S = true;
    private boolean f17015T = true;
    private boolean f17016U = false;
    private boolean f17017V = true;
    private ExecutorService f17018W = Executors.newFixedThreadPool(2);
    private ServiceConnection f17019Y = new C4652l(this);
    public C0958f f17020c = new C4649i(this);
    private Context f17021d = null;
    private int f17022e = -1;
    private BluetoothDevice f17023f = null;
    private C0959q f17024g = null;
    private C0958f f17025h = null;
    private int f17026i = -1;
    private int f17027j = -1;
    private int f17028k = -1;
    private int f17029l = -1;
    private int f17030m = 0;
    private String f17031n = "";
    private String f17032o = "";
    private String f17033p = "0110";
    private String f17034q = "0100";
    private C4629a f17035r = null;
    private C4628e f17036s = new C4628e();
    private int f17037t = 0;
    private int f17038u = 0;
    private List<C4625b> f17039v = new ArrayList();
    private boolean f17040w = false;
    private C4625b f17041x = new C4625b();
    private int f17042y = -1;
    private int f17043z = -1;

    public C4648h(Context context, int i, BluetoothDevice bluetoothDevice, C0958f fVar, int i2) {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter BTDeviceSendCommandUtil().");
        this.f17025h = fVar;
        this.f17022e = i;
        this.f17023f = bluetoothDevice;
        this.f17021d = context;
        this.f17024g = m22294a(bluetoothDevice, this.f17020c, i2);
        if (this.f17024g == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "initBTDeviceService with return null.");
        }
        m22297a(bluetoothDevice, i2);
        m22333n();
    }

    private void m22333n() {
        this.f17009N = new HandlerThread("BTDeviceSendCommandUtil");
        this.f17009N.start();
        this.f17010O = new C4653m(this, this.f17009N.getLooper());
    }

    private C0959q m22294a(BluetoothDevice bluetoothDevice, C0958f fVar, int i) {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "initBTDeviceService with btType = " + this.f17022e);
        if (-1 == this.f17022e) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "initBTDeviceService with btType is unknown");
            return null;
        }
        switch (this.f17022e) {
            case 0:
                return C0960a.a(this.f17021d, null, fVar);
            case 1:
                return new C4639m(this.f17021d, bluetoothDevice, fVar, i);
            case 2:
                C0959q c4635i = new C4635i(this.f17021d, bluetoothDevice, fVar);
                this.f17004I = new C4633a(this, this.f17021d, this.f17023f, this.f17025h);
                return c4635i;
            default:
                return null;
        }
    }

    private void m22297a(BluetoothDevice bluetoothDevice, int i) {
        if (this.f17022e == 0) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter initBTDeviceLinkLayerBaseInfo() with BT_AW.");
            this.f17027j = SupportMenu.USER_MASK;
            this.f17028k = SupportMenu.USER_MASK;
            this.f17029l = 0;
            this.f17026i = 2;
            if (this.f17035r == null) {
                this.f17035r = new C4632d(this.f17021d, this.f17027j);
                return;
            }
            return;
        }
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter initBTDeviceLinkLayerBaseInfo() with not BT_AW.");
        if (bluetoothDevice != null) {
            int d = this.f17003H.m21949d(bluetoothDevice);
            if (-1 == d && TextUtils.isEmpty(bluetoothDevice.getName()) && i != -1) {
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Use the product Type.");
            } else {
                i = d;
            }
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Device product type = " + i);
            switch (i) {
                case 0:
                    this.f17026i = 0;
                    this.f17027j = 128;
                    this.f17028k = 128;
                    this.f17029l = 0;
                    break;
                case 1:
                    this.f17026i = 1;
                    this.f17027j = 128;
                    this.f17028k = 128;
                    this.f17029l = 0;
                    break;
                case 5:
                    this.f17026i = 1;
                    this.f17027j = 20;
                    this.f17028k = 20;
                    this.f17029l = 10;
                    break;
                default:
                    this.f17026i = 2;
                    this.f17027j = 255;
                    this.f17028k = 255;
                    this.f17029l = 10;
                    break;
            }
            if (this.f17035r == null) {
                switch (this.f17026i) {
                    case 0:
                        this.f17035r = new C4630b(this.f17021d, this.f17027j);
                        return;
                    case 1:
                        this.f17035r = new C4631c(this.f17021d, this.f17027j);
                        return;
                    case 2:
                        this.f17035r = new C4632d(this.f17021d, this.f17027j);
                        return;
                    default:
                        return;
                }
            }
            return;
        }
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "btDevice is null.");
    }

    public void m22358a(int i) {
        this.f17027j = i;
    }

    public int m22357a() {
        return this.f17037t;
    }

    public void m22366b(int i) {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter setBTDeviceActiveState() with activeState = " + i);
        this.f17037t = i;
    }

    public int m22365b() {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "getBTDeviceConnectState with state = " + this.f17038u);
        return this.f17038u;
    }

    public void m22368c() {
        if (this.f17024g != null) {
            this.f17015T = true;
            this.f17024g.mo2291a(this.f17023f);
            return;
        }
        C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "connectBTDevice: mBTDeviceServiceBase is null.");
    }

    public void m22371d() {
        if (this.f17024g != null) {
            this.f17024g.mo2295b();
            return;
        }
        C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "disconnectBTDevice: mBTDeviceServiceBase is null.");
    }

    private String m22306b(String str) {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter getAuthenticTokenValue().");
        if (16 == this.f17031n.length() / 2 && 16 == this.f17032o.length() / 2) {
            Object b = C0973a.b(this.f17031n);
            Object b2 = C0973a.b(this.f17032o);
            Object obj = new byte[32];
            System.arraycopy(b, 0, obj, 0, 16);
            System.arraycopy(b2, 0, obj, 16, 16);
            String a = C5704b.m26317a(this.f17021d).m26326a(2 == this.f17030m ? "154CB790FD6FA8AEF0F5389454703E94LgzawBpNLWm9LvJlDf61Vvqjricn/SlN4YzA/IQqmjalRCxcegUciVxXk6hXq+Vq" : "154CB790FD6FA8AEF0F5389454703E94bZX+pDwJX2DyXdVgaCVmsY53Xz+9Rmby11P8qQ2xz3PaNCi0mBPQD0LIxahAL/Ft");
            try {
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Start to create encode info.");
                return C0973a.a(C4618u.m22034a(C4618u.m22034a(C0973a.b(a + str), obj), obj));
            } catch (Exception e) {
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "HMac256 occur exception with info = " + e.getMessage());
                return null;
            }
        }
        C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "Authentic Random parameter is incorrect.");
        return null;
    }

    private boolean m22335o() {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter startAuthenticBTDevice().");
        if (32 != this.f17031n.length()) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "RandA parameter is incorrect so stop authentic.");
            return false;
        }
        try {
            byte[] a = C4618u.m22031a(16);
            if (a == null) {
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "generateRandomBytes fail.");
                return false;
            }
            this.f17032o = C0973a.a(a);
            String b = m22306b(this.f17034q);
            if (b == null) {
                return false;
            }
            C4625b a2 = C4610m.m21964a(this.f17021d, this.f17030m, b, this.f17032o);
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Start to request authentic.");
            m22360a(a2);
            return true;
        } catch (NoSuchAlgorithmException e) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "generateRandomBytes exception with info = " + e.getMessage());
            return false;
        }
    }

    private boolean m22314c(String str) {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter checkAuthenticBTDevice().");
        if (16 == this.f17031n.length() / 2 && 16 == this.f17032o.length() / 2) {
            String b = m22306b(this.f17033p);
            if (b != null) {
                return str.equalsIgnoreCase(b);
            }
            C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "Authentic codeInfoHex is incorrect.");
            return false;
        }
        C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "Authentic Random parameter is incorrect.");
        return false;
    }

    private void m22296a(int i, int i2) {
        if (this.f16998C == i && this.f16999D == i2) {
            this.f17012Q = 0;
            m22339q();
        }
    }

    private void m22299a(DeviceInfo deviceInfo, int i, byte[] bArr) {
        if (this.f17025h == null || deviceInfo == null || bArr == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "parameter is incorrect.");
        } else if ((byte) 1 == bArr[0] && (byte) 1 == bArr[1]) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Capture V2 link connect parameter.");
            m22296a(1, 1);
            if (this.f17022e == 0) {
                this.f17016U = true;
                if (this.f17024g != null) {
                    this.f17024g.mo2300f();
                }
            }
            C4627d c = C4610m.m21988c(this.f17021d, bArr);
            this.f17038u = 4;
            if (c != null) {
                this.f17026i = c.m22127a();
                this.f17027j = c.m22130b();
                if (this.f17035r != null) {
                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Device max frame size = " + this.f17027j});
                    this.f17035r.mo4545a(this.f17027j);
                }
                this.f17028k = c.m22132c();
                this.f17029l = c.m22134d();
                this.f17030m = c.m22136e();
                this.f17031n = c.m22138f();
                if (this.f17022e == 0) {
                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Path extend number = " + c.m22140g()});
                    if (this.f17024g != null) {
                        this.f17024g.mo2297c(c.m22140g());
                    }
                }
                if (2 == this.f17022e) {
                    m22350v();
                    if (this.f17030m != 0) {
                        c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Device need authentic Application."});
                        if (!m22335o()) {
                            c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Send Authentic command fail."});
                            this.f17038u = 4;
                            this.f17005J = false;
                            this.f17025h.a(deviceInfo, 4);
                            return;
                        }
                        return;
                    }
                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Device do not need authentic."});
                    this.f17038u = 2;
                    this.f17005J = false;
                    this.f17025h.a(deviceInfo, 2);
                    return;
                }
                C4625b e = C4610m.m21991e();
                c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Start to get device available status."});
                m22360a(e);
                return;
            }
            c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Device Link parameter resolve fail."});
            this.f17038u = 4;
            this.f17005J = false;
            this.f17025h.a(deviceInfo, 4);
        } else if ((byte) 1 == bArr[0] && TagName.ORDER_DATE == bArr[1]) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Capture V2 Authentic parameter.");
            m22296a(1, 19);
            if (m22314c(C4610m.m21968a(bArr))) {
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Authentic success.");
                if (2 == this.f17022e) {
                    m22360a(C4610m.m21962a(2));
                    return;
                }
                this.f17038u = 2;
                this.f17005J = false;
                this.f17025h.a(deviceInfo, 2);
                return;
            }
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Authentic fail so disconnect.");
            m22371d();
            this.f17038u = 4;
            this.f17005J = false;
            this.f17025h.a(deviceInfo, 4);
        } else if ((byte) 1 == bArr[0] && (byte) 15 == bArr[1]) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Capture V2 receive bond status response.");
            m22296a(1, 15);
            if (2 == this.f17022e) {
                m22352w();
            }
            if (this.f17004I != null && !this.f17004I.m22184b(deviceInfo, bArr)) {
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "receive bond status incorrect response.");
                this.f17038u = 4;
                this.f17005J = false;
                this.f17025h.a(deviceInfo, 4);
            }
        } else if ((byte) 1 == bArr[0] && (byte) 14 == bArr[1]) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Capture V2 bond request response.");
            m22296a(1, 14);
            if (this.f17004I != null && !this.f17004I.m22183a(deviceInfo, bArr)) {
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "receive pair status incorrect response.");
                this.f17038u = 4;
                this.f17005J = false;
                this.f17025h.a(deviceInfo, 4);
            }
        } else if ((byte) 1 == bArr[0] && TagName.ORDER_TRADE_NO == bArr[1]) {
            m22296a(1, 22);
            int h = C4610m.m21997h(this.f17021d, bArr);
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Device available status ：" + h);
            if (-1 == h || h == 0 || 1 == h) {
                if (this.f17030m != 0) {
                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Device need authentic Application after check device available.");
                    if (!m22335o()) {
                        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Send Authentic command fail after check device available.");
                        this.f17038u = 4;
                        this.f17005J = false;
                        this.f17025h.a(deviceInfo, 4);
                    }
                } else {
                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Device do not need authentic after check device available.");
                    this.f17038u = 2;
                    this.f17005J = false;
                    this.f17025h.a(deviceInfo, 2);
                }
                this.f17014S = true;
            } else if (2 == h) {
                this.f17038u = 5;
                this.f17005J = false;
                this.f17025h.a(deviceInfo, 5);
                this.f17014S = false;
            }
        } else {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "handshake report data with V2.");
            this.f17025h.a(deviceInfo, i, bArr);
        }
    }

    private void m22308b(byte[] bArr) {
        if (bArr == null || bArr.length < 5) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "not 5.1.17 data, return");
        } else if ((byte) 1 == bArr[0] && (byte) 17 == bArr[1]) {
            try {
                String a = C0973a.a(bArr);
                this.f17029l = Integer.parseInt(a.substring(8, a.length()), 16);
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "getMTSInterval mInterval = " + this.f17029l);
            } catch (Exception e) {
                C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "Error e = " + e.getMessage());
            }
        }
    }

    private void m22307b(DeviceInfo deviceInfo, int i, byte[] bArr) {
        try {
            if (this.f17025h == null || deviceInfo == null || bArr == null) {
                C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "reportReceivedData: parameter is not correct.");
                return;
            }
            deviceInfo.setDeviceProtocol(this.f17026i);
            if (2 == this.f17026i) {
                if (this.f17005J) {
                    m22299a(deviceInfo, i, bArr);
                    return;
                }
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "not handshake report data with V2.");
                m22296a(bArr[0], bArr[1]);
                byte[] b = C4610m.m21985b(this.f17021d, bArr, deviceInfo.getDeviceIdentify());
                if (b == null) {
                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", "checkedContent is null.");
                } else {
                    bArr = b;
                }
                this.f17025h.a(deviceInfo, bArr.length, bArr);
                m22308b(bArr);
            } else if (1 == this.f17026i) {
                if (bArr.length <= 3 || bArr[2] != (byte) 0) {
                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", "reportReceivedData, mCommandType = " + this.f17008M);
                    if (1 == this.f17008M) {
                        r0 = bArr[0];
                        C2538c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"before requestID = " + r0});
                        if (r0 < 0) {
                            r0 += 256;
                        }
                        if (r0 != this.f17042y) {
                            C2538c.b("01", 1, "BTDeviceSendCommandUtil", new Object[]{"error report data, requestID = " + r0 + " mRequestID = " + this.f17042y});
                            return;
                        }
                        bArr = C4613p.m22020a(this.f17043z, this.f16996A, this.f16997B, bArr);
                    } else if (2 == this.f17008M) {
                        bArr[0] = (byte) this.f16998C;
                        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "reportReceivedData, OTA report business cmd, need add Service id, mServiceID = " + this.f16998C);
                    } else if (3 == this.f17008M) {
                        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "reportReceivedData, OTA report file data, do nothing...");
                    }
                    C2538c.a("01", 1, "BTDeviceSendCommandUtil", "reportReceivedData, receive data finish so need to reset resend timer and unLockBT.");
                    this.f17012Q = 0;
                    m22339q();
                    if (bArr == null) {
                        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "btV2Command is null.");
                        return;
                    } else if (!this.f17005J) {
                        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "not handshake report data with V1.");
                        if (7 == this.f16998C && 9 == this.f16999D) {
                            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Take wanted message so need change command ID for set userInfo.");
                            bArr[1] = (byte) 2;
                        } else if (2 == this.f16998C && 3 == this.f16999D) {
                            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Take wanted message so need change command ID for send message.");
                            bArr[1] = (byte) 1;
                        }
                        this.f17025h.a(deviceInfo, bArr.length, bArr);
                        return;
                    } else if (2 != this.f17022e) {
                        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "handshake report data with V1 and not BLE.");
                        this.f17025h.a(deviceInfo, bArr.length, bArr);
                        return;
                    } else if ((byte) 1 == bArr[0] && (byte) 15 == bArr[1]) {
                        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "receive bond status response.");
                        if (this.f17004I != null && !this.f17004I.m22184b(deviceInfo, bArr)) {
                            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "receive bond status incorrect response.");
                            return;
                        }
                        return;
                    } else if ((byte) 1 == bArr[0] && (byte) 14 == bArr[1]) {
                        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "receive request bond response.");
                        if (this.f17004I != null && !this.f17004I.m22183a(deviceInfo, bArr)) {
                            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "receive pair status incorrect response.");
                            return;
                        }
                        return;
                    } else {
                        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "handshake report data with V1.");
                        this.f17025h.a(deviceInfo, bArr.length, bArr);
                        return;
                    }
                }
                C2538c.a("01", 0, "BTDeviceSendCommandUtil", "Notification info-------------------" + C0973a.a(bArr));
                if (m22319d(bArr)) {
                    bArr = C4613p.m22020a(bArr[1], bArr[2], bArr[3], C0973a.b(r0));
                    C2538c.a("01", 0, "BTDeviceSendCommandUtil", "after V1--->V2 Notification info----" + C0973a.a(bArr));
                }
                if (bArr != null) {
                    this.f17025h.a(deviceInfo, bArr.length, bArr);
                    return;
                }
                C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "notificationData is null.");
            } else if (this.f17026i == 0) {
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "receive V0 data info.");
                this.f17012Q = 0;
                m22339q();
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "not handshake report data with V1.");
                int length = bArr.length;
                byte[] bArr2 = new byte[(length + 2)];
                bArr2[0] = (byte) this.f16998C;
                bArr2[1] = (byte) this.f16999D;
                for (r0 = 0; r0 < length; r0++) {
                    bArr2[r0 + 2] = bArr[r0];
                }
                this.f17025h.a(deviceInfo, bArr2.length, bArr2);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "ArrayIndexOutOfBoundsException ERROR :" + e.getMessage());
        }
    }

    private void m22338p() {
        synchronized (f16995b) {
            if (this.f17001F) {
                f16995b.notifyAll();
                this.f17001F = false;
            }
            this.f17040w = false;
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", " unLockAW, mSendingV1Command set false.");
        }
    }

    private void m22339q() {
        synchronized (f16994a) {
            if (this.f17000E) {
                f16994a.notifyAll();
                this.f17000E = false;
            }
            this.f17040w = false;
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", " unLockBT, mSendingV1Command set false.");
        }
    }

    private boolean m22315c(byte[] bArr) {
        int length = bArr.length;
        ArrayList arrayList = new ArrayList();
        if (length <= this.f17028k) {
            arrayList.add(bArr);
        } else {
            int i;
            if (length % this.f17028k > 0) {
                i = (length / this.f17028k) + 1;
            } else {
                i = length / this.f17028k;
            }
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = this.f17028k;
                if (i2 == i - 1) {
                    i3 = length - (this.f17028k * i2);
                }
                int i4 = this.f17028k * i2;
                arrayList.add(Arrays.copyOfRange(bArr, i4, i3 + i4));
            }
        }
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "sendLinkDataCommand, mInterval = " + this.f17029l);
        Iterator it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            boolean z2;
            if (this.f17024g.mo2294a((byte[]) it.next())) {
                z2 = z;
            } else {
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "sendLinkDataCommond has write false");
                z2 = false;
            }
            if (1 == this.f17026i) {
                try {
                    if (this.f17029l > 0) {
                        Thread.sleep((long) this.f17029l);
                    }
                } catch (InterruptedException e) {
                    C2538c.a("0xA0200006", "01", 1, "BTDeviceSendCommandUtil", "InterruptedException = " + e.getMessage());
                }
            }
            z = z2;
        }
        if (2 == this.f17026i) {
            try {
                if (this.f17029l > 0) {
                    Thread.sleep((long) this.f17029l);
                }
            } catch (InterruptedException e2) {
                C2538c.a("0xA0200006", "01", 1, "BTDeviceSendCommandUtil", "InterruptedException = " + e2.getMessage());
            }
        }
        return z;
    }

    private void m22341r() {
        this.f17042y++;
        if (256 == this.f17042y) {
            this.f17042y = 0;
        }
    }

    protected byte[] m22364a(byte[] bArr) {
        if (bArr == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "transferV2ToV1Protocol with parameter is null.");
            return new byte[0];
        }
        byte[] a = C4613p.m22021a(bArr);
        if (a == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "transferV2ToV1Protocol with commandData is null.");
            return new byte[0];
        }
        m22341r();
        if (a.length <= 4) {
            return a;
        }
        a[0] = (byte) this.f17042y;
        this.f17043z = a[1];
        this.f16996A = a[2];
        this.f16997B = a[3];
        if (this.f16997B >= 0) {
            return a;
        }
        this.f16997B += 128;
        return a;
    }

    private int m22343s() {
        int i;
        int i2;
        Exception e;
        int i3 = -1;
        if (this.f17039v != null) {
            for (C4625b c4625b : this.f17039v) {
                try {
                    i = i3 + 1;
                    try {
                        if (c4625b != null && 2 == c4625b.m22117d()) {
                            i3 = 1;
                            i2 = i;
                            break;
                        }
                        i3 = i;
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    Exception exception = e3;
                    i = i3;
                    e = exception;
                }
            }
            i2 = i3;
            i3 = 0;
            int i4 = i3;
            i3 = i2;
            i2 = i4;
            if (i2 == 0) {
                return 0;
            }
        }
        return i3;
        C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "getDeviceCommand Exception with exception = " + e.getMessage());
        i2 = 0;
        i3 = i;
        if (i2 == 0) {
            return 0;
        }
        return i3;
    }

    private void m22345t() {
        C2538c.b("01", 1, "BTDeviceSendCommandUtil", "Enter reportTimeoutInfo() with ServiceID = " + this.f16998C + " CommandID = " + this.f16999D);
        String a = C4610m.m21967a(this.f17021d, this.f16998C, this.f16999D, this.f17026i, this.f17042y, this.f17043z);
        if (a.length() != 0) {
            byte[] b = C0973a.b(a);
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Timeout Info = " + a);
            m22307b(m22376h(), b.length, b);
        }
    }

    private boolean m22309b(C4625b c4625b) {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter sendBTDeviceWrapData(). mLinkLayerVersion = " + this.f17026i);
        if (2 != m22353x()) {
            if (this.f17005J) {
                this.f17005J = false;
                m22348u();
            }
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "base Service connect state is not connected so return.");
            return false;
        } else if (this.f17039v.size() == 0) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "mBTDeviceCommandList size = 0, so cancel send wrap data.");
            return false;
        } else {
            if (c4625b != null) {
                byte[] c = c4625b.m22116c();
                if (c4625b.m22121f() == 0 && 1 == this.f17026i) {
                    if (!(this.f17024g == null || f16995b == null)) {
                        try {
                            this.f17024g.mo2294a(c);
                            synchronized (f16995b) {
                                this.f17001F = true;
                                if (this.f17005J) {
                                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"BTDeviceAWService Enter Lock of sendBTDeviceWrapData Handshake, timeout = 30000"});
                                    this.f17011P = 1;
                                    if (2 != m22353x()) {
                                        this.f17001F = false;
                                        return false;
                                    }
                                    f16995b.wait(StatisticConfig.MIN_UPLOAD_INTERVAL);
                                } else {
                                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"BTDeviceAWService Enter Lock of sendBTDeviceWrapData, timeout = 10000"});
                                    if (2 != m22353x()) {
                                        this.f17001F = false;
                                        return false;
                                    }
                                    f16995b.wait(10000);
                                }
                                if (this.f17001F) {
                                    this.f17012Q++;
                                    if (this.f17011P == this.f17012Q) {
                                        if (this.f17005J) {
                                            this.f17005J = false;
                                            DeviceInfo deviceInfo = null;
                                            if (this.f17024g != null) {
                                                deviceInfo = this.f17024g.mo2298d();
                                            }
                                            if (deviceInfo == null) {
                                                deviceInfo = new DeviceInfo();
                                                deviceInfo.setDeviceIdentify("AndroidWear");
                                                deviceInfo.setDeviceName("HUAWEI WATCH");
                                            }
                                            deviceInfo.setDeviceConnectState(4);
                                            this.f17038u = 4;
                                            if (this.f17025h != null) {
                                                c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Start to report aw v1 protocol connect fail."});
                                                this.f17025h.a(deviceInfo, 4);
                                            }
                                        } else if (c4625b.m22120e()) {
                                            m22345t();
                                        }
                                        this.f17040w = false;
                                        c.b("01", 1, "BTDeviceSendCommandUtil", new Object[]{"BTDeviceAWService Set Sending flag false for AW timeout."});
                                    } else {
                                        c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"BTDeviceAWService Command send timeout but counter not arrived = " + this.f17012Q});
                                    }
                                    this.f17001F = false;
                                }
                            }
                        } catch (InterruptedException e) {
                            c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", new Object[]{"InterruptedException is：" + e.getMessage()});
                        }
                    }
                } else if (this.f17035r != null) {
                    ArrayList a;
                    int b = c4625b.m22112b();
                    if (3 == c4625b.m22124h()) {
                        c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"OTA send bytes of file data."});
                        a = m22295a(b, c);
                    } else {
                        a = this.f17035r.mo4542a(b, c);
                    }
                    if (a != null) {
                        C4626c c4626c = new C4626c(a, c4625b.m22120e());
                        if (this.f17024g != null) {
                            this.f17002G = false;
                            b = 0;
                            while (b < c4626c.f16898a.size()) {
                                c = c4626c.f16898a.get(b);
                                c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"sendBTDeviceWrapData, i = " + b + ", command size = " + c4626c.f16898a.size()});
                                if (b == c4626c.f16898a.size() - 1) {
                                    this.f17002G = true;
                                }
                                try {
                                    if (3 == c4625b.m22124h()) {
                                        this.f17017V = this.f17024g.mo2294a(c);
                                        try {
                                            Thread.sleep((long) this.f17029l);
                                        } catch (InterruptedException e2) {
                                            c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", new Object[]{"Sleep InterruptedException with exception = " + e2.getMessage()});
                                        }
                                        this.f17040w = false;
                                        c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Set Sending flag false for OTA transfer file..."});
                                        b++;
                                    } else if (1 == this.f17026i || this.f17026i == 0 || (2 == this.f17026i && this.f17002G && c4625b.m22120e())) {
                                        if (f16994a != null) {
                                            synchronized (f16994a) {
                                                this.f17000E = true;
                                                this.f17017V = m22315c(c);
                                                c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"sendLinkDataCommand result:" + this.f17017V});
                                                if (1 == c4625b.m22125i() && 14 == c4625b.m22126j()) {
                                                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Enter Lock of sendBTDeviceWrapData with device pair. timeout = 30000"});
                                                    this.f17011P = 1;
                                                    if (2 != m22353x()) {
                                                        this.f17000E = false;
                                                        return false;
                                                    }
                                                    f16994a.wait(StatisticConfig.MIN_UPLOAD_INTERVAL);
                                                } else if (this.f17022e == 0 && 1 == c4625b.m22125i() && 1 == c4625b.m22126j()) {
                                                    this.f17011P = 1;
                                                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"BTDeviceAWService Enter Lock of sendBTDeviceWrapData. timeout = 30000"});
                                                    if (2 != m22353x()) {
                                                        this.f17000E = false;
                                                        return false;
                                                    }
                                                    f16994a.wait(StatisticConfig.MIN_UPLOAD_INTERVAL);
                                                } else {
                                                    c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Enter Lock of sendBTDeviceWrapData. timeout = 10000"});
                                                    if (2 != m22353x()) {
                                                        this.f17000E = false;
                                                        return false;
                                                    }
                                                    f16994a.wait(10000);
                                                }
                                                if (this.f17000E) {
                                                    this.f17012Q++;
                                                    if (this.f17011P == this.f17012Q) {
                                                        c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Command send timeout and counter arrived."});
                                                        if (this.f17005J) {
                                                            if (this.f17025h != null) {
                                                                this.f17005J = false;
                                                                m22348u();
                                                            }
                                                        } else if (c4625b.m22120e()) {
                                                            m22345t();
                                                        }
                                                        this.f17040w = false;
                                                        c.b("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Set Sending flag false for BT timeout."});
                                                    } else {
                                                        c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"Command send timeout but counter not arrived = " + this.f17012Q});
                                                    }
                                                    this.f17000E = false;
                                                }
                                            }
                                        } else {
                                            continue;
                                        }
                                        b++;
                                    } else {
                                        this.f17017V = m22315c(c);
                                        c.a("01", 1, "BTDeviceSendCommandUtil", new Object[]{"sendLinkDataCommand else result:" + this.f17017V});
                                        b++;
                                    }
                                } catch (InterruptedException e22) {
                                    c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", new Object[]{"InterruptedException is：" + e22.getMessage()});
                                }
                            }
                        }
                    }
                } else {
                    c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", new Object[]{"disconnectBTDevice: mBTDeviceServiceBase is null."});
                }
            }
            return this.f17017V;
        }
    }

    private void m22348u() {
        DeviceInfo deviceInfo = null;
        if (this.f17024g != null) {
            deviceInfo = this.f17024g.mo2298d();
        }
        if (deviceInfo == null) {
            deviceInfo = new DeviceInfo();
            if (this.f17022e == 0) {
                deviceInfo.setDeviceIdentify("AndroidWear");
                deviceInfo.setDeviceName("HUAWEI WATCH");
            } else if (this.f17023f != null) {
                deviceInfo.setDeviceIdentify(this.f17023f.getAddress());
                deviceInfo.setDeviceName(this.f17023f.getName());
            } else {
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "mBTDevice is null");
            }
        }
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Start to report connect fail state with device type = " + deviceInfo.getProductType());
        deviceInfo.setDeviceConnectState(4);
        this.f17038u = 4;
        this.f17025h.a(deviceInfo, 4);
    }

    private ArrayList<byte[]> m22295a(int i, byte[] bArr) {
        if (i <= 0 || bArr == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "wrapOTAFilePackets error, dataContent is null.");
            return null;
        }
        ArrayList<byte[]> arrayList = new ArrayList();
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
        allocate.put(bArr);
        allocate.flip();
        arrayList.add(allocate.array());
        return arrayList;
    }

    private byte[] m22303a(byte[] bArr, int i) {
        if (bArr == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "otaCmdForDeviceCommand with parameter deviceData is null.");
            return new byte[0];
        }
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "otaCmdForDeviceCommand , type = " + i);
        if (3 == i) {
            return bArr;
        }
        Object obj = new byte[(bArr.length + 1)];
        m22341r();
        obj[0] = (byte) this.f17042y;
        System.arraycopy(bArr, 0, obj, 1, bArr.length);
        return obj;
    }

    public void m22360a(C4625b c4625b) {
        if (c4625b == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "btDeviceCommand is null.");
        } else if (this.f17039v != null) {
            synchronized (f16993X) {
                C2538c.a("01", 1, "BTDeviceSendCommandUtil", "sendBTDeviceData insert queue.");
                this.f17039v.add(c4625b);
                Message message = new Message();
                message.what = 1;
                this.f17010O.sendMessage(message);
            }
        } else {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "mBTDeviceCommandList is null.");
        }
    }

    public void m22361a(String str) {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "sendAssetData");
        if (str == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "filePath is null.");
            return;
        }
        C2538c.a("01", 0, "BTDeviceSendCommandUtil", "sendBTDeviceAssetData filePath : " + str);
        this.f17024g.mo2293a(str);
    }

    public void m22359a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "setFileCallback");
        if (iBaseResponseCallback == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "callback is null.");
            return;
        }
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "setFileCallback callback : " + iBaseResponseCallback);
        this.f17024g.mo2292a(iBaseResponseCallback);
    }

    public C0959q m22373e() {
        return this.f17024g;
    }

    public void m22363a(boolean z, int i) {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter setBLEHandshakeStatus() with needHandshake = " + z);
        this.f17005J = z;
        this.f17038u = i;
    }

    public void m22362a(boolean z) {
        this.f17006K = z;
    }

    public boolean m22374f() {
        return this.f17006K;
    }

    public void m22367b(boolean z) {
        this.f17007L = z;
    }

    public boolean m22375g() {
        return this.f17007L;
    }

    public DeviceInfo m22376h() {
        if (this.f17024g != null) {
            return this.f17024g.mo2298d();
        }
        C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "getDeviceInfo: mBTDeviceServiceBase is null.");
        return null;
    }

    private boolean m22319d(byte[] bArr) {
        return (byte) 4 != bArr[1] || bArr[2] != (byte) 0 || (byte) 8 != bArr[3];
    }

    public void m22370c(boolean z) {
        this.f17013R = z;
    }

    public boolean m22377i() {
        return this.f17013R;
    }

    public boolean m22378j() {
        return this.f17014S;
    }

    public void m22369c(int i) {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter btSwitchChangeInfo() with status = " + i);
        if (this.f17024g != null) {
            this.f17024g.mo2296b(i);
            return;
        }
        C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "mBTDeviceServiceBase is null.");
    }

    public void m22372d(boolean z) {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter setBLEReconnectEnableFlag() with status = " + z);
        this.f17015T = z;
    }

    public boolean m22379k() {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter getBLEReconnectEnableFlag() with status = " + this.f17015T);
        return this.f17015T;
    }

    public void m22380l() {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter disconnectGMS()");
        if (this.f17024g != null) {
            this.f17024g.mo2299e();
            return;
        }
        C2538c.a("0xA0200008", "01", 1, "BTDeviceSendCommandUtil", "mBTDeviceServiceBase is null.");
    }

    private void m22350v() {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter bindIConnectService.");
        if (!C4610m.m21996g() || !C4610m.m21998h()) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "iconnect do not exist or do not have iconnect action.");
        } else if (this.f17021d != null) {
            Intent intent = new Intent("com.huawei.iconnect.action.WEAR_CONNECT_SERVICE");
            intent.setPackage("com.huawei.iconnect");
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "start to bind iconnect service.");
            if (!this.f17021d.getApplicationContext().bindService(intent, this.f17019Y, 1)) {
                C2538c.b("01", 1, "BTDeviceSendCommandUtil", "bind iconnect fail so set service handle is null.");
                C4610m.m21971a(null);
            }
        } else {
            C2538c.b("01", 1, "BTDeviceSendCommandUtil", "mContext is null so set service handle is null.");
            C4610m.m21971a(null);
        }
    }

    private void m22352w() {
        C2538c.a("01", 1, "BTDeviceSendCommandUtil", "Enter unBindIConnectService.");
        if (!C4610m.m21996g() || !C4610m.m21998h()) {
            C2538c.a("01", 1, "BTDeviceSendCommandUtil", "iconnect do not exist or do not have iconnect action.");
        } else if (this.f17021d != null) {
            try {
                C4610m.m21971a(null);
                this.f17021d.getApplicationContext().unbindService(this.f17019Y);
            } catch (IllegalArgumentException e) {
                C2538c.b("01", 1, "BTDeviceSendCommandUtil", "unBindIConnectService with IllegalArgumentException.");
            }
        } else {
            C2538c.b("01", 1, "BTDeviceSendCommandUtil", "mContext is null.");
        }
    }

    private int m22353x() {
        if (this.f17024g != null) {
            return this.f17024g.mo2301g();
        }
        return 3;
    }
}
