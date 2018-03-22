package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1489i;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1620b;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1689g;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1690h;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1691i;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

@SuppressLint({"NewApi"})
@TargetApi(18)
/* compiled from: BluetoothLEConnectService */
public class C1705k extends C1700i {
    private static boolean f4527B = false;
    private static final UUID f4528C = UUID.fromString("00002a06-0000-1000-8000-00805f9b34fb");
    private static final UUID f4529D = UUID.fromString("00002a07-0000-1000-8000-00805f9b34fb");
    private static final UUID f4530E = UUID.fromString("00002a06-0000-1000-8000-00805f9b34fb");
    private static final UUID f4531F = UUID.fromString("0000ff12-0000-1000-8000-00805f9b34fb");
    private static final UUID f4532G = UUID.fromString("0000ff11-0000-1000-8000-00805f9b34fb");
    private static C1705k f4533H;
    private static BluetoothGatt f4534K;
    public static final UUID f4535a = UUID.fromString("00001802-0000-1000-8000-00805f9b34fb");
    public static final UUID f4536e = UUID.fromString("00001804-0000-1000-8000-00805f9b34fb");
    public static final UUID f4537f = UUID.fromString("00001803-0000-1000-8000-00805f9b34fb");
    public static final UUID f4538g = UUID.fromString("0000ff01-0000-1000-8000-00805f9b34fb");
    private static int f4539l = 0;
    private static boolean f4540o = false;
    private int f4541A = 0;
    private C1716v f4542I;
    private C1715u f4543J;
    private BluetoothGattService f4544L;
    private BluetoothGattService f4545M;
    private BluetoothGattService f4546N;
    private BluetoothGattService f4547O;
    private BluetoothGattCharacteristic f4548P = null;
    private BluetoothGattCharacteristic f4549Q = null;
    private BluetoothGattCharacteristic f4550R = null;
    private BluetoothGattCharacteristic f4551S = null;
    private BluetoothGattCharacteristic f4552T = null;
    private C1689g f4553U;
    private C1620b f4554V;
    private HandlerThread f4555W = null;
    private Handler f4556X = null;
    private C1691i f4557Y = null;
    private boolean f4558Z = false;
    private final BluetoothGattCallback aa = new C1709o(this);
    Runnable f4559h = new C1713s(this);
    private String f4560i;
    private long f4561j = 0;
    private long f4562k = 0;
    private BluetoothDevice f4563m = null;
    private int f4564n = 0;
    private int f4565p = 0;
    private boolean f4566q = false;
    private boolean f4567r = true;
    private boolean f4568s = true;
    private boolean f4569t = true;
    private int f4570u = 0;
    private boolean f4571v = true;
    private boolean f4572w = true;
    private int f4573x = 0;
    private boolean f4574y = true;
    private int f4575z = 0;

    private C1705k(Context context) {
        super(context);
    }

    public static BluetoothGatt m8094c() {
        return f4534K;
    }

    public static C1705k m8079a(Context context, C1690h c1690h, int i) {
        if (f4533H == null) {
            f4533H = new C1705k(context);
        }
        f4539l = i;
        f4533H.d = c1690h;
        return f4533H;
    }

    public void mo2588a(BluetoothDevice bluetoothDevice, boolean z, int i, C1691i c1691i) {
        C2538c.m12674b("BluetoothLEConnectService", " BTConnectService Enter connect() mState = " + C1700i.m8041a() + " connectNum = " + this.f4565p);
        this.f4557Y = c1691i;
        if (2 == C1700i.m8041a() || this.f4565p > 1) {
            m8106d(false);
            return;
        }
        C2538c.m12674b("BluetoothLEConnectService", " BTConnectService call connect() to BLE dev: " + bluetoothDevice.getName());
        this.f4563m = bluetoothDevice;
        C1705k.m8104d(i);
        if (this.f4555W == null) {
            this.f4555W = new HandlerThread("BluetoothLEConnectService");
            this.f4555W.start();
            this.f4556X = new Handler(this.f4555W.getLooper());
        }
        C2538c.m12674b("BluetoothLEConnectService", " BTConnectService mBluetoothDeviceAddress = " + this.f4560i + " device.getAddress() = " + bluetoothDevice.getAddress() + " mBluetoothGatt = " + f4534K + " secure = " + z);
        if (this.f4560i == null || !bluetoothDevice.getAddress().equals(this.f4560i) || f4534K == null || !z) {
            this.f4565p++;
            this.f4556X.post(new C1706l(this, bluetoothDevice));
            C2538c.m12680e("BluetoothLEConnectService", "Trying to create a new connection.");
            this.f4560i = bluetoothDevice.getAddress();
            if (1 != C1700i.m8041a()) {
                m8044a(1);
            }
            if (this.f4542I != null && this.f4567r) {
                this.f4542I.m8153a();
            }
            this.f4572w = true;
            this.f4543J = new C1715u();
            this.f4543J.start();
            C2538c.m12674b("BluetoothLEConnectService", "开启连接超时");
            return;
        }
        C2538c.m12680e("BluetoothLEConnectService", "Trying to use an existing mBluetoothGatt for connection.");
        if (f4534K.connect()) {
            this.f4572w = true;
            this.f4543J = new C1715u();
            this.f4543J.start();
            C2538c.m12674b("BluetoothLEConnectService", "开启连接超时");
            if (1 != C1700i.m8041a()) {
                m8044a(1);
                return;
            }
            return;
        }
        m8106d(false);
    }

    private void m8106d(boolean z) {
        this.f4564n++;
        this.f4562k = System.currentTimeMillis();
        C2538c.m12674b("BluetoothLEConnectService", "Enter reConnect()  startTime = " + this.f4561j + " endTime = " + this.f4562k + " flag = " + z + " reConnectNum = " + this.f4564n);
        if (this.f4543J != null) {
            this.f4543J.m8152a();
        }
        if (!this.f4571v) {
            this.f4569t = false;
            this.f4542I = null;
            this.f4570u = 0;
        } else if (this.f4542I != null) {
            this.f4542I.m8153a();
        }
        if (((this.f4562k - this.f4561j > 5000 || this.f4561j == 0) && !z) || this.f4564n >= 2) {
            C2538c.m12674b("BluetoothLEConnectService", "Enter 释放");
            this.f4564n = 0;
            C1705k.m8090b(false);
            this.f4565p = 0;
            this.f4567r = true;
            C1705k.m8110e();
            m8111e(-3);
            C2538c.m12674b("BluetoothLEConnectService", "End 释放");
        } else {
            C2538c.m12674b("BluetoothLEConnectService", "Enter 重连");
            C1705k.m8090b(true);
            m8111e(-3);
            if (this.f4556X != null) {
                this.f4556X.removeCallbacksAndMessages(null);
            }
            if (this.f4555W == null) {
                this.f4555W = new HandlerThread("BluetoothLEConnectService");
                this.f4555W.start();
                this.f4556X = new Handler(this.f4555W.getLooper());
            }
            this.f4556X.postDelayed(new C1707m(this), 5000);
            if (C1719y.m8202e()) {
                C1719y.f4597a.f4435a = 3;
                if (this.f4557Y != null) {
                    C2538c.m12674b("BluetoothLEConnectService", "重连解锁");
                    this.f4557Y.mo2566a();
                } else {
                    C2538c.m12674b("BluetoothLEConnectService", "重连 mReConnectCallback is null");
                }
            }
            C2538c.m12674b("BluetoothLEConnectService", "End 重连");
        }
        this.f4561j = 0;
        this.f4562k = 0;
        C2538c.m12674b("BluetoothLEConnectService", "End reConnect() ");
    }

    public void mo2589a(boolean z) {
        C2538c.m12679d("BluetoothLEConnectService", " Enter stop()");
        C1705k.m8098c(z);
        this.f4568s = false;
        if (this.f4543J != null) {
            this.f4543J.m8152a();
        }
        if (this.f4542I != null) {
            this.f4542I.m8153a();
        }
        C1705k.m8090b(false);
        if (f4534K == null) {
            this.f4564n = 0;
            m8111e(-3);
            C2538c.m12679d("BluetoothLEConnectService", "BluetoothGatt not initialized");
            return;
        }
        f4534K.disconnect();
        synchronized (this) {
            if (this.f4556X != null) {
                this.f4556X.postDelayed(new C1708n(this), 5000);
            }
        }
        C2538c.m12679d("BluetoothLEConnectService", "End stop()");
    }

    private synchronized void m8111e(int i) {
        C2538c.m12674b("BluetoothLEConnectService", "Enter release()");
        if (this.f4543J != null) {
            this.f4543J.m8152a();
        }
        if (this.f4542I != null) {
            this.f4542I.m8153a();
        }
        if (f4534K != null) {
            f4534K.close();
        }
        f4534K = null;
        this.f4560i = null;
        if (this.f4555W != null) {
            synchronized (this) {
                if (this.f4556X != null) {
                    this.f4556X.removeCallbacksAndMessages(null);
                }
                this.f4556X = null;
                this.f4555W.getLooper().quit();
                this.f4555W = null;
            }
        }
        this.f4541A = 0;
        this.f4575z = 0;
        this.f4561j = 0;
        this.f4562k = 0;
        this.f4568s = true;
        this.f4570u = 0;
        this.f4573x = 0;
        this.f4566q = false;
        m8133n();
        f4527B = false;
        if (!(3 == C1700i.m8041a() || f4540o)) {
            m8044a(3);
        }
    }

    private void m8133n() {
        this.f4544L = null;
        this.f4545M = null;
        this.f4546N = null;
        this.f4547O = null;
        this.f4548P = null;
        this.f4549Q = null;
        this.f4550R = null;
        this.f4551S = null;
        this.f4552T = null;
        C2538c.m12674b("BluetoothLEConnectService", "Enter releaseAll()");
    }

    public void mo2590a(byte[] bArr) {
        C2538c.m12680e("BluetoothLEConnectService", "write() mDeviceType = " + f4539l);
        if (this.f4548P == null) {
            C2538c.m12680e("BluetoothLEConnectService", "Device not connected or write characteristic is not supported by the remote device.");
        } else if (f4534K != null) {
            this.f4548P.setValue(bArr);
            this.f4558Z = f4534K.writeCharacteristic(this.f4548P);
            C2538c.m12680e("BluetoothLEConnectService", "K1 write() " + this.f4558Z);
        } else {
            C2538c.m12680e("BluetoothLEConnectService", "K1 write() mBluetoothGatt is null");
            C2538c.m12680e("BluetoothLEConnectService", "K1 write() writeImmediateAlertCharacteristic is null");
        }
    }

    public void mo2591a(byte[] bArr, int i) {
        C2538c.m12674b("BluetoothLEConnectService", "write writeWithLen: " + C0973a.m3509a(bArr));
        m8091b(bArr);
    }

    public void mo2592a(byte[] bArr, C1620b c1620b) {
        if (f4534K != null && this.f4550R != null) {
            this.f4554V = c1620b;
            this.f4550R.setValue(bArr);
            f4534K.writeCharacteristic(this.f4550R);
            this.f4556X.postDelayed(this.f4559h, 2000);
        } else if (f4534K == null) {
            C2538c.m12680e("BluetoothLEConnectService", "SDK --> K1 writeDataToLinkLossCharacteristic() mBluetoothGatt is null");
        } else {
            C2538c.m12680e("BluetoothLEConnectService", "SDK --> K1 writeDataToLinkLossCharacteristic() writeLinkLossCharacteristic is null");
        }
    }

    private void m8135o() {
        if (f4534K != null && this.f4552T != null) {
            f4534K.readCharacteristic(this.f4552T);
        } else if (f4534K == null) {
            C2538c.m12680e("BluetoothLEConnectService", "SDK --> K1 readAuthenticationCharacteristic() mBluetoothGatt is null");
        } else {
            C2538c.m12680e("BluetoothLEConnectService", "SDK --> K1 readAuthenticationCharacteristic() readAuthenticationCharacteristic is null");
        }
    }

    private void m8091b(byte[] bArr) {
        if (f4534K != null && this.f4551S != null) {
            this.f4551S.setValue(bArr);
            f4534K.writeCharacteristic(this.f4551S);
            C2538c.m12674b("BluetoothLEConnectService", "write writeAuthenticationCharacteristic: " + C0973a.m3509a(bArr));
        } else if (f4534K == null) {
            C2538c.m12680e("BluetoothLEConnectService", "SDK --> K1 writeAuthenticationCharacteristic() mBluetoothGatt is null");
        } else {
            C2538c.m12680e("BluetoothLEConnectService", "SDK --> K1 writeAuthenticationCharacteristic() writeAuthenticationCharacteristic is null");
        }
    }

    private boolean m8082a(BluetoothGatt bluetoothGatt, int i) {
        if (!(this.f4541A == i || this.f4541A == 0)) {
            this.f4575z = 0;
        }
        if (this.f4575z <= 1) {
            this.f4575z++;
            this.f4541A = i;
            C2538c.m12679d("BluetoothLEConnectService", "=========refreshDeviceCache()=========");
            Method method = null;
            try {
                method = bluetoothGatt.getClass().getMethod(UploadFile.REFRESH_LABEL, new Class[0]);
            } catch (NoSuchMethodException e) {
                C2538c.m12680e("BluetoothLEConnectService", " e = " + e.getMessage());
            }
            this.f4556X.postDelayed(new C1714t(this, bluetoothGatt), 1000);
            if (method != null) {
                try {
                    return ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                } catch (IllegalAccessException e2) {
                    C2538c.m12680e("BluetoothLEConnectService", " e = " + e2.getMessage());
                } catch (InvocationTargetException e3) {
                    C2538c.m12680e("BluetoothLEConnectService", " e = " + e3.getMessage());
                }
            }
        } else {
            C2538c.m12680e("BluetoothLEConnectService", "id =" + i + " 调用超过2次");
        }
        return false;
    }

    public static boolean m8107d() {
        return f4540o;
    }

    public static void m8090b(boolean z) {
        f4540o = ((Boolean) C1489i.m6887a(Boolean.valueOf(z))).booleanValue();
    }

    public static void m8098c(boolean z) {
        f4527B = z;
    }

    public static void m8110e() {
        f4533H = null;
    }

    public static void m8104d(int i) {
        f4539l = i;
    }
}
