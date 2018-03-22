package com.huawei.hwbtsdk.btmanager.btdeviceservice;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.*;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbtsdk.p057b.p058a.C0958f;
import com.huawei.hwbtsdk.p399a.C4600d;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

import java.lang.reflect.Method;
import java.util.UUID;

@SuppressLint({"NewApi"})
@TargetApi(18)
/* compiled from: BTDeviceBLEService */
public class C4635i implements C0959q {
    public static final Object f16934a = new Object();
    public static final Object f16935b = new Object();
    private Context f16936c = null;
    private BluetoothDevice f16937d = null;
    private DeviceInfo f16938e = new DeviceInfo();
    private C0958f f16939f = null;
    private int f16940g = 0;
    private int f16941h;
    private HandlerThread f16942i = new HandlerThread("BTDeviceBLEService");
    private C4637k f16943j = null;
    private BluetoothGatt f16944k;
    private boolean f16945l = false;
    private int f16946m = 0;
    private BluetoothGattCharacteristic f16947n;
    private BluetoothGattCharacteristic f16948o;
    private boolean f16949p = false;
    private HandlerThread f16950q = null;
    private Handler f16951r = null;
    private String f16952s = "";
    private Boolean f16953t = Boolean.valueOf(false);
    private boolean f16954u = false;
    private int f16955v = 0;
    private final BluetoothGattCallback f16956w = new C4636j(this);

    public C4635i(Context context, BluetoothDevice bluetoothDevice, C0958f fVar) {
        this.f16936c = context;
        this.f16937d = bluetoothDevice;
        if (bluetoothDevice != null) {
            this.f16952s = bluetoothDevice.getName();
            C2538c.a("01", 1, "BTDeviceBLEService", "Device name = " + this.f16952s);
        }
        this.f16939f = fVar;
        this.f16938e.setDeviceBTType(2);
        m22190a();
    }

    private void m22190a() {
        this.f16942i.start();
        this.f16943j = new C4637k(this, this.f16942i.getLooper());
        this.f16950q = new HandlerThread("BTDeviceBLEService");
        this.f16950q.start();
        this.f16951r = new C4638l(this, this.f16950q.getLooper());
    }

    public void mo2291a(BluetoothDevice bluetoothDevice) {
        C2538c.a("01", 1, "BTDeviceBLEService", "Enter connectBTDevice() with device state = " + this.f16941h);
        if (bluetoothDevice == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceBLEService", "bt Device is null");
            return;
        }
        int i = this.f16941h;
        m22215a(1);
        if (2 == i) {
            C2538c.a("01", 1, "BTDeviceBLEService", "Device has connected.");
            m22215a(2);
            return;
        }
        C2538c.a("01", 1, "BTDeviceBLEService", "Start to connect ble device with name = " + bluetoothDevice.getName());
        this.f16955v = 0;
        this.f16937d = bluetoothDevice;
        this.f16949p = false;
        this.f16943j.sendEmptyMessage(1);
    }

    public void mo2295b() {
        C2538c.a("01", 1, "BTDeviceBLEService", " Enter disconnectBTDevice().");
        this.f16949p = true;
        if (this.f16944k == null) {
            C2538c.a("01", 1, "BTDeviceBLEService", "BluetoothGatt not initialized.");
            this.f16943j.sendEmptyMessage(3);
            return;
        }
        this.f16943j.sendEmptyMessageDelayed(3, 5000);
        C2538c.b("01", 1, "BTDeviceBLEService", "start to execute gatt disconnect.");
        if (this.f16944k != null) {
            this.f16944k.disconnect();
        }
        C2538c.a("01", 1, "BTDeviceBLEService", "End disconnectBTDevice().");
    }

    public boolean mo2294a(byte[] bArr) {
        boolean z = false;
        if (bArr == null) {
            C2538c.a("0xA0200008", "01", 1, "BTDeviceBLEService", "Parameter is incorrect.");
        } else {
            synchronized (f16935b) {
                if (this.f16947n == null) {
                    C2538c.b("01", 1, "BTDeviceBLEService", "mWritePoint is incorrect.");
                } else if (this.f16944k == null) {
                    C2538c.b("01", 1, "BTDeviceBLEService", "mBluetoothGatt is incorrect.");
                } else {
                    this.f16947n.setValue(bArr);
                    this.f16953t = Boolean.valueOf(false);
                    C2538c.a("01", 0, "BTDeviceBLEService", "SDK-->Device : " + C0973a.a(bArr));
                    boolean writeCharacteristic = this.f16944k.writeCharacteristic(this.f16947n);
                    C2538c.a("01", 1, "BTDeviceBLEService", "BLE Service data send flag = " + writeCharacteristic);
                    if (writeCharacteristic) {
                        z = writeCharacteristic;
                    } else {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            C2538c.a("0xA0200006", "01", 1, "BTDeviceBLEService", "InterruptedException = " + e.getMessage());
                        }
                        synchronized (f16935b) {
                            if (this.f16944k == null || this.f16947n == null) {
                                z = writeCharacteristic;
                            } else {
                                writeCharacteristic = this.f16944k.writeCharacteristic(this.f16947n);
                                C2538c.a("01", 1, "BTDeviceBLEService", "Service data send for retry ,dataSendResult = " + writeCharacteristic);
                                z = writeCharacteristic;
                            }
                        }
                    }
                    if (!this.f16953t.booleanValue()) {
                        synchronized (f16934a) {
                            this.f16954u = true;
                            try {
                                f16934a.wait(300);
                            } catch (InterruptedException e2) {
                                C2538c.a("01", 1, "BTDeviceBLEService", "InterruptedException = " + e2.getMessage());
                            }
                            if (this.f16954u) {
                                C2538c.a("01", 1, "BTDeviceBLEService", "Wait onCharacteristicWrite() back, timeout = 300");
                                if (!writeCharacteristic) {
                                    synchronized (f16935b) {
                                        if (!(this.f16944k == null || this.f16947n == null)) {
                                            z = this.f16944k.writeCharacteristic(this.f16947n);
                                            C2538c.a("01", 1, "BTDeviceBLEService", "Service data send for timeout ,dataTempSendResult = " + z);
                                        }
                                    }
                                }
                                this.f16954u = false;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    private void m22199c() {
        synchronized (f16934a) {
            C2538c.a("01", 1, "BTDeviceBLEService", "unLock, lockFlag = " + this.f16954u);
            if (this.f16954u) {
                f16934a.notifyAll();
                this.f16954u = false;
            }
        }
    }

    private void m22192a(boolean z) {
        C2538c.a("01", 1, "BTDeviceBLEService", "Enter reConnect() with reConnectFlag = " + z);
        m22206i();
    }

    private void m22205h() {
        C2538c.a("01", 1, "BTDeviceBLEService", "Enter setCharacteristicMessage().");
        this.f16945l = true;
        if (this.f16948o == null) {
            C2538c.a("0xA0200004", "01", 1, "BTDeviceBLEService", "mNotifyPoint is null.");
            m22193a(this.f16944k, 2);
        } else if ((this.f16948o.getProperties() | 16) > 0) {
            this.f16944k.setCharacteristicNotification(this.f16948o, true);
            BluetoothGattDescriptor descriptor = this.f16948o.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
            if (descriptor != null) {
                C2538c.a("01", 1, "BTDeviceBLEService", "Start to set Notification.");
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                boolean writeDescriptor = this.f16944k.writeDescriptor(descriptor);
                C2538c.a("01", 1, "BTDeviceBLEService", "writeDescriptorResult = " + writeDescriptor);
            }
        }
    }

    private boolean m22193a(BluetoothGatt bluetoothGatt, int i) {
        C2538c.a("01", 1, "BTDeviceBLEService", "Enter refreshDeviceCache().");
        if (bluetoothGatt == null) {
            C2538c.a("0xA0200003", "01", 1, "BTDeviceBLEService", "BluetoothGatt parameter is null.");
            return false;
        }
        try {
            if (!(this.f16940g == i || this.f16940g == 0)) {
                this.f16946m = 0;
            }
            if (this.f16946m <= 1) {
                this.f16946m++;
                this.f16940g = i;
                Method method = bluetoothGatt.getClass().getMethod(UploadFile.REFRESH_LABEL);
                this.f16943j.sendEmptyMessageDelayed(2, 1000);
                C2538c.a("01", 1, "BTDeviceBLEService", "Start to refresh Device Cache.");
                if (method != null) {
                    C2538c.a("01", 1, "BTDeviceBLEService", "refresh Device Cache invoke result :" + ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue());
                    return ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                }
            }
            C2538c.a("0xA0200003", "01", 1, "BTDeviceBLEService", "id =" + i + " call over times");
            m22192a(false);
        } catch (NoSuchMethodException e) {
            C2538c.a("0xA0200003", "01", 1, "BTDeviceBLEService", "An exception occur while refreshing device:NoSuchMethodException");
        } catch (IllegalAccessException e2) {
            C2538c.a("0xA0200003", "01", 1, "BTDeviceBLEService", "An exception occur while refreshing device:IllegalAccessException");
        } catch (Exception e3) {
            C2538c.a("0xA0200003", "01", 1, "BTDeviceBLEService", "An exception occur while refreshing device:Other Exception");
        }
        return false;
    }

    private void m22206i() {
        C2538c.a("01", 1, "BTDeviceBLEService", "Enter release() with state = " + this.f16941h);
        synchronized (f16935b) {
            if (this.f16944k != null) {
                C2538c.a("01", 1, "BTDeviceBLEService", "Start to close gatt.");
                this.f16944k.close();
                this.f16944k = null;
            }
            this.f16947n = null;
        }
        if (this.f16943j != null) {
            this.f16943j.removeCallbacksAndMessages(null);
        } else {
            C2538c.a("01", 1, "BTDeviceBLEService", "mMsgHandler = null so can not remove all message.");
        }
        this.f16940g = 0;
        this.f16946m = 0;
        this.f16945l = false;
        this.f16948o = null;
        if (this.f16955v < 3 && 2 != this.f16941h) {
            this.f16955v++;
            C2538c.a("01", 1, "BTDeviceBLEService", "Try connect with BT switch state = " + m22208j());
            int r0 = -1; // unknown r0
            if (this.f16949p || 3 != r0) {
                if (1 == this.f16941h) {
                    m22215a(4);
                } else {
                    m22215a(3);
                }
            } else if (this.f16943j != null) {
                this.f16943j.sendEmptyMessageDelayed(5, 1000);
            } else {
                C2538c.a("01", 1, "BTDeviceBLEService", "mMsgHandler = null.");
            }
        } else if (1 == this.f16941h) {
            m22215a(4);
        } else {
            m22215a(3);
        }
    }

    protected void m22215a(int i) {
        this.f16941h = i;
        if (this.f16939f != null) {
            C2538c.a("01", 1, "BTDeviceBLEService", "Report BLE connect state = " + i);
            if (this.f16938e != null) {
                String name = this.f16937d.getName();
                if (TextUtils.isEmpty(name)) {
                    name = this.f16952s;
                }
                this.f16938e.setDeviceName(name);
                this.f16938e.setDeviceIdentify(this.f16937d.getAddress());
                this.f16939f.m3353a(this.f16938e, this.f16941h);
                return;
            }
            return;
        }
        C2538c.a("01", 1, "BTDeviceBLEService", "Client callback is null. ");
    }

    public DeviceInfo mo2298d() {
        return this.f16938e;
    }

    private int m22208j() {
        return C4600d.m21899a().m21944c();
    }

    public void mo2296b(int i) {
        C2538c.a("01", 1, "BTDeviceBLEService", "Enter btSwitchChangeInfo() with status = " + i);
        if (1 != i) {
            return;
        }
        if (this.f16943j != null) {
            this.f16943j.sendEmptyMessageDelayed(7, 1000);
            return;
        }
        C2538c.a("01", 1, "BTDeviceBLEService", "mMsgHandler = null.");
    }

    public void mo2293a(String str) {
        C2538c.a("01", 1, "BTDeviceBLEService", "Enter sendBTFilePath in ble.");
    }

    public void mo2292a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.a("01", 1, "BTDeviceBLEService", "Enter setFileCallback in ble.");
    }

    public void mo2299e() {
        C2538c.a("01", 1, "BTDeviceBLEService", "start to disconnectGMS in ble.");
    }

    public void mo2300f() {
        C2538c.a("01", 1, "BTDeviceBLEService", "start to removeV1CheckCommand in ble.");
    }

    public void mo2297c(int i) {
        C2538c.a("01", 1, "BTDeviceBLEService", "Enter setPathExtendNum in ble with pathExtendNum = " + i);
    }

    public int mo2301g() {
        return this.f16941h;
    }

    /* compiled from: BTDeviceBLEService */
    static class C4636j extends BluetoothGattCallback {
        final /* synthetic */ C4635i f16957a;

        C4636j(C4635i c4635i) {
            this.f16957a = c4635i;
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            C2538c.b("01", 1, "BTDeviceBLEService", "onConnectionStateChange() status = " + i + " newState = " + i2);
            if (this.f16957a.f16944k == null) {
                C2538c.b("01", 1, "BTDeviceBLEService", "mBluetoothGatt is null");
                this.f16957a.f16944k = bluetoothGatt;
            }
            if (2 == i2) {
                C2538c.a("01", 1, "BTDeviceBLEService", "Connected to GATT server.");
                this.f16957a.f16943j.removeMessages(4);
                this.f16957a.f16943j.sendEmptyMessageDelayed(2, 1000);
            } else if (i2 == 0) {
                C2538c.a("01", 1, "BTDeviceBLEService", "Disconnected from GATT server.");
                this.f16957a.f16943j.removeCallbacksAndMessages(null);
                C2538c.a("01", 1, "BTDeviceBLEService", "BT switch state = " + this.f16957a.m22208j());
                if (this.f16957a.f16949p || 3 != r0) {
                    C2538c.b("01", 1, "BTDeviceBLEService", "Wanted disconnect or bt switch is not on occur, so release.");
                    this.f16957a.m22206i();
                } else if (this.f16957a.f16945l) {
                    C2538c.a("01", 1, "BTDeviceBLEService", "setNotificationFlag is true.");
                    this.f16957a.m22192a(true);
                } else {
                    C2538c.a("01", 1, "BTDeviceBLEService", "setNotificationFlag is false.");
                    this.f16957a.m22192a(false);
                }
            }
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            C2538c.a("01", 1, "BTDeviceBLEService", "onServicesDiscovered() status = " + i);
            if (this.f16957a.f16944k == null) {
                C2538c.a("01", 1, "BTDeviceBLEService", "mBluetoothGatt is null");
                this.f16957a.m22192a(false);
            } else if (i == 0) {
                C2538c.a("01", 1, "BTDeviceBLEService", "Service discover success.");
                this.f16957a.f16943j.removeMessages(4);
                BluetoothGattService service = this.f16957a.f16944k.getService(UUID.fromString("0000fe86-0000-1000-8000-00805f9b34fb"));
                if (service != null) {
                    C2538c.a("01", 1, "BTDeviceBLEService", "BLE GATT Service UUID find success.");
                    synchronized (f16935b) {
                        this.f16957a.f16947n = service.getCharacteristic(UUID.fromString("0000fe01-0000-1000-8000-00805f9b34fb"));
                    }
                    this.f16957a.f16948o = service.getCharacteristic(UUID.fromString("0000fe02-0000-1000-8000-00805f9b34fb"));
                    this.f16957a.m22205h();
                    return;
                }
                service = this.f16957a.f16944k.getService(UUID.fromString("00000200-0000-1000-8000-00805F9B34FB"));
                if (service != null) {
                    C2538c.a("01", 1, "BTDeviceBLEService", "B0 GATT Service UUID find success.");
                    synchronized (f16935b) {
                        this.f16957a.f16947n = service.getCharacteristic(UUID.fromString("00000203-0000-1000-8000-00805F9B34FB"));
                    }
                    this.f16957a.f16948o = service.getCharacteristic(UUID.fromString("00000202-0000-1000-8000-00805F9B34FB"));
                    this.f16957a.m22205h();
                    return;
                }
                C2538c.b("01", 1, "BTDeviceBLEService", "Do not match any Service UUID.");
                this.f16957a.m22193a(this.f16957a.f16944k, 1);
            } else {
                C2538c.b("01", 1, "BTDeviceBLEService", "Service discover fail.");
                this.f16957a.m22193a(this.f16957a.f16944k, 3);
            }
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                C2538c.a("01", 0, "BTDeviceBLEService", "Device-->SDK Characteristic has been read. ");
                return;
            }
            C2538c.a("01", 0, "BTDeviceBLEService", "Device-->SDK onCharacteristicRead error status = " + i);
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            this.f16957a.f16953t = Boolean.TRUE;
            if (i == 0) {
                C2538c.a("01", 0, "BTDeviceBLEService", "SDK-->Device write success with :" + C0973a.a(bluetoothGattCharacteristic.getValue()));
            } else {
                C2538c.a("01", 1, "BTDeviceBLEService", "SDK-->Device onCharacteristicWrite error status = " + i);
            }
            this.f16957a.m22199c();
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            Object value = bluetoothGattCharacteristic.getValue();
            Message message = new Message();
            message.what = 1;
            message.obj = value;
            this.f16957a.f16951r.sendMessage(message);
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            C2538c.a("01", 1, "BTDeviceBLEService", "Enter onDescriptorWrite with status =" + i);
            if (i == 0) {
                C2538c.a("01", 1, "BTDeviceBLEService", "Notification set success.");
                this.f16957a.m22215a(2);
                this.f16957a.f16940g = 0;
                return;
            }
            boolean a = this.f16957a.m22193a(this.f16957a.f16944k, 4);
            C2538c.a("01", 1, "BTDeviceBLEService", "refreshResult = " + a);
        }
    }

    /* compiled from: BTDeviceBLEService */
    static class C4637k extends Handler {
        final /* synthetic */ C4635i f16958a;

        public C4637k(C4635i c4635i, Looper looper) {
            super(looper);
            this.f16958a = c4635i;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            C2538c.a("01", 1, "BTDeviceBLEService", "receive msg:" + message.what);
            switch (message.what) {
                case 1:
                    removeMessages(1);
                    if (this.f16958a.f16944k == null) {
                        sendEmptyMessage(5);
                        break;
                    }
                    this.f16958a.f16944k.disconnect();
                    sendEmptyMessageDelayed(6, 5000);
                    break;
                case 2:
                    if (this.f16958a.f16944k != null) {
                        sendEmptyMessageDelayed(4, 20000);
                        boolean discoverServices = this.f16958a.f16944k.discoverServices();
                        C2538c.a("01", 1, "BTDeviceBLEService", "Attempting to start service discovery:" + discoverServices);
                        break;
                    }
                    break;
                case 3:
                    this.f16958a.m22206i();
                    break;
                case 4:
                    removeMessages(4);
                    this.f16958a.m22192a(true);
                    break;
                case 5:
                    sendEmptyMessageDelayed(4, 20000);
                    this.f16958a.f16944k = this.f16958a.f16937d.connectGatt(this.f16958a.f16936c, false, this.f16958a.f16956w);
                    C2538c.a("01", 1, "BTDeviceBLEService", "connectGatt() mBluetoothGatt = " + this.f16958a.f16944k);
                    break;
                case 6:
                    if (this.f16958a.f16944k != null) {
                        this.f16958a.f16944k.close();
                        sendEmptyMessageDelayed(5, 1000);
                        break;
                    }
                    break;
                case 7:
                    if (2 == this.f16958a.f16941h) {
                        C2538c.a("01", 1, "BTDeviceBLEService", "BT Switch off and bt connect state is connected so start to release.");
                        this.f16958a.f16949p = true;
                        this.f16958a.m22206i();
                        break;
                    }
                    break;
            }
            super.handleMessage(message);
        }
    }

    /* compiled from: BTDeviceBLEService */
    static class C4638l extends Handler {
        final /* synthetic */ C4635i f16959a;

        public C4638l(C4635i c4635i, Looper looper) {
            super(looper);
            this.f16959a = c4635i;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1:
                    byte[] bArr = (byte[]) message.obj;
                    if (bArr != null && this.f16959a.f16939f != null) {
                        C2538c.a("01", 0, "BTDeviceBLEService", "Device-->SDK: " + C0973a.a(bArr));
                        this.f16959a.f16939f.a(this.f16959a.f16938e, bArr.length, bArr);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
