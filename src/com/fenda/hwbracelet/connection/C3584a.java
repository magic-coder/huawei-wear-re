package com.fenda.hwbracelet.connection;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.fenda.hwbracelet.p258b.p259a.C3578a;
import com.fenda.hwbracelet.p258b.p259a.C3579b;
import com.fenda.hwbracelet.p258b.p259a.C3580c;
import com.fenda.hwbracelet.p262e.C3598a;
import com.fenda.hwbracelet.p263f.C3608d;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.p190v.C2538c;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

/* compiled from: BleConnectionManager */
public class C3584a implements C3583l {
    private static final UUID f13716A = UUID.fromString("69D1D8F3-45E1-49A8-9821-9BBDFDAAD9D9");
    public static final UUID f13717c = UUID.fromString("7905F431-B5CE-4E99-A40F-4B1E122D00D0");
    private static int f13718k = 0;
    PendingIntent f13719a;
    PendingIntent f13720b;
    private Context f13721d;
    private Handler f13722e;
    private BluetoothGatt f13723f;
    private C3595m f13724g;
    private BluetoothManager f13725h;
    private BluetoothAdapter f13726i;
    private BluetoothDevice f13727j;
    private Queue<C3589f> f13728l = new LinkedList();
    private C3589f f13729m;
    private BluetoothGattCharacteristic f13730n = null;
    private int f13731o = 0;
    private AlarmManager f13732p;
    private boolean f13733q = false;
    private int f13734r = 0;
    private boolean f13735s = false;
    private boolean f13736t = false;
    private BroadcastReceiver f13737u = new C3585b(this);
    private BluetoothGattCallback f13738v = new C3586c(this);
    private int f13739w = 7;
    private int[] f13740x = new int[this.f13739w];
    private int f13741y = 0;
    private BluetoothGattServerCallback f13742z = new C3587d(this);

    @SuppressLint({"NewApi"})
    public C3584a(Context context) {
        if (context == null) {
            C2538c.e("BluetoothGatt", new Object[]{"null == context"});
            return;
        }
        this.f13721d = context;
        this.f13725h = (BluetoothManager) this.f13721d.getSystemService("bluetooth");
        if (this.f13725h == null) {
            C2538c.e("BluetoothGatt", new Object[]{"Unable to initialize BluetoothManager."});
            return;
        }
        this.f13726i = this.f13725h.getAdapter();
        if (this.f13726i == null) {
            C2538c.e("BluetoothGatt", new Object[]{"Unable to obtain BluetoothAdapter."});
            return;
        }
        this.f13732p = (AlarmManager) context.getSystemService("alarm");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.af500.ble_connect_timeout_action");
        intentFilter.addAction("com.af500.ble_reconnect_action");
        this.f13721d.registerReceiver(this.f13737u, intentFilter, "com.af500.permission.MYBRODCAST", null);
    }

    public boolean m18040a() {
        return C3596n.m18056b();
    }

    public void m18039a(C3595m c3595m) {
        synchronized (this) {
            this.f13724g = c3595m;
        }
    }

    public void m18044b() {
        this.f13729m = null;
        if (this.f13728l != null) {
            this.f13728l.clear();
        }
    }

    @SuppressLint({"NewApi"})
    private boolean m18009a(BluetoothDevice bluetoothDevice, int i) {
        if (bluetoothDevice == null) {
            C2538c.e("BluetoothGatt", new Object[]{"Device not found.  Unable to connect."});
            return false;
        } else if (this.f13726i.isEnabled()) {
            try {
                this.f13723f = bluetoothDevice.connectGatt(this.f13721d, false, this.f13738v);
                this.f13727j = bluetoothDevice;
                m18004a(2, true, 0);
                m18027h();
                C2538c.e("BluetoothGatt", new Object[]{"Trying to create a new connection.where=" + i});
                return true;
            } catch (IllegalArgumentException e) {
                C2538c.e("BluetoothGatt", new Object[]{"Trying to create a new connection but failed.where" + i});
                C2538c.c("BluetoothGatt", new Object[]{"Connect IllegalArgumentException: " + e.getMessage()});
                return false;
            }
        } else {
            C2538c.e("BluetoothGatt", new Object[]{"the bluetooth is Disable"});
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public boolean m18041a(BluetoothDevice bluetoothDevice) {
        if (m18009a(bluetoothDevice, 0)) {
            return true;
        }
        this.f13733q = false;
        m18004a(0, true, 1);
        return false;
    }

    private synchronized void m18023f() {
        C2538c.e("BluetoothGatt", new Object[]{"gattClinet close()"});
        if (this.f13723f == null) {
            C2538c.e("BluetoothGatt", new Object[]{"close() -> mGattClient == null"});
        } else {
            try {
                m18005a(this.f13723f);
                this.f13723f.close();
                this.f13723f = null;
                m18004a(0, true, 2);
                if (this.f13733q) {
                    m18026g();
                }
            } catch (RuntimeException e) {
                C2538c.e("BluetoothGatt", new Object[]{"close Exception: " + e.getMessage()});
                m18004a(0, true, 2);
                if (this.f13733q) {
                    m18026g();
                }
            } catch (Throwable th) {
                m18004a(0, true, 2);
                if (this.f13733q) {
                    m18026g();
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void m18045c() {
        C2538c.e("BluetoothGatt", new Object[]{"disconnect"});
        this.f13733q = false;
        m18029i();
        if (this.f13723f != null) {
            try {
                this.f13723f.disconnect();
                m18005a(this.f13723f);
                this.f13723f.close();
                this.f13723f = null;
            } catch (RuntimeException e) {
                C2538c.e("BluetoothGatt", new Object[]{"disconnect Exception: " + e.getMessage()});
            }
        }
        m18004a(0, true, 3);
        C2538c.c("BluetoothGatt", new Object[]{"disconnect"});
    }

    public void m18046d() {
        C2538c.e("BluetoothGatt", new Object[]{"autoDisconnect"});
        this.f13733q = true;
        if (this.f13723f != null) {
            try {
                this.f13723f.disconnect();
            } catch (RuntimeException e) {
                C2538c.c("BluetoothGatt", new Object[]{"autoDisconnect RuntimeException: " + e.getMessage()});
                C2538c.e("BluetoothGatt", new Object[]{"if the mGattClient is null ,the mean the close() has been handler, so we no need to handler the close in autoDisconnect;"});
                return;
            }
        }
        m18004a(0, true, 4);
        synchronized (this) {
            C2538c.c("BluetoothGatt", new Object[]{"close by autoDisconnect"});
            m18023f();
        }
    }

    public void m18047e() {
        C2538c.c("BluetoothGatt", new Object[]{"preventReconnect"});
        this.f13733q = false;
        m18029i();
    }

    private void m18026g() {
        if (this.f13721d == null || this.f13732p == null) {
            C2538c.e("BluetoothGatt", new Object[]{"sendReconnectAlarmBroadcast null == mContext || null == mAlarmManager"});
            return;
        }
        m18029i();
        this.f13734r++;
        int min = Math.min(this.f13734r * 5000, 300000);
        Intent intent = new Intent("com.af500.ble_reconnect_action");
        intent.setPackage(this.f13721d.getPackageName());
        this.f13720b = PendingIntent.getBroadcast(this.f13721d, 0, intent, 0);
        this.f13732p.set(1, System.currentTimeMillis() + ((long) min), this.f13720b);
        this.f13736t = true;
        C2538c.e("BluetoothGatt", new Object[]{"sendReconnectAlarmBroadcast"});
    }

    private void m18027h() {
        if (this.f13721d == null || this.f13732p == null) {
            C2538c.e("BluetoothGatt", new Object[]{"sendConnectTimeoutAlarmBroadcast null == mContext || null == mAlarmManager"});
            return;
        }
        m18029i();
        Intent intent = new Intent("com.af500.ble_connect_timeout_action");
        intent.setPackage(this.f13721d.getPackageName());
        this.f13719a = PendingIntent.getBroadcast(this.f13721d, 0, intent, 0);
        this.f13732p.set(1, System.currentTimeMillis() + 20000, this.f13719a);
        this.f13735s = true;
        C2538c.e("BluetoothGatt", new Object[]{"sendTimeoutAlarmBroadcast"});
    }

    private void m18029i() {
        if (this.f13732p != null) {
            if (this.f13719a != null) {
                C2538c.b("BluetoothGatt", new Object[]{"close the timeout alarm"});
                this.f13732p.cancel(this.f13719a);
                this.f13719a = null;
                this.f13735s = false;
            }
            if (this.f13720b != null) {
                C2538c.b("BluetoothGatt", new Object[]{"close the reconnect alarm"});
                this.f13732p.cancel(this.f13720b);
                this.f13720b = null;
                this.f13736t = false;
            }
        }
    }

    public boolean m18042a(C3598a c3598a) {
        if (!m18040a() || this.f13723f == null) {
            C2538c.e("BluetoothGatt", new Object[]{"send message to bracelet failed with null gatt client"});
            return false;
        }
        int i = f13718k;
        f13718k = i + 1;
        m18037a(i, C3580c.f13701a, C3578a.f13697b, c3598a.mo4217b(), null);
        C2538c.b("BluetoothGatt", new Object[]{"send ble message: " + c3598a.toString()});
        return true;
    }

    public boolean m18043a(byte[] bArr) {
        if (!m18040a() || this.f13723f == null) {
            C2538c.e("BluetoothGatt", new Object[]{"send message to bracelet failed with null gatt client"});
            return false;
        }
        int i = f13718k;
        f13718k = i + 1;
        m18037a(i, C3580c.f13701a, C3578a.f13697b, bArr, null);
        C2538c.b("BluetoothGatt", new Object[]{"send ble message: " + C3608d.m18110a(bArr)});
        return true;
    }

    public void m18038a(Handler handler) {
        this.f13722e = handler;
        m18036a(0, C3580c.f13701a, C3578a.f13696a, handler);
    }

    public void m18036a(int i, UUID uuid, UUID uuid2, Handler handler) {
        if (this.f13729m == null) {
            m18014b(i, uuid, uuid2, handler);
        } else {
            this.f13728l.add(new C3589f(C3590g.CHARACTERISTIC_NOTIFICATION, i, uuid, uuid2, null, null, handler));
        }
    }

    public void m18037a(int i, UUID uuid, UUID uuid2, byte[] bArr, Handler handler) {
        if (this.f13729m == null) {
            m18015b(i, uuid, uuid2, bArr, handler);
        } else {
            this.f13728l.add(new C3589f(C3590g.WRITE_CHARACTERISTIC, i, uuid, uuid2, null, bArr, handler));
        }
    }

    private void m18006a(Handler handler, int i, int i2) {
        if (handler != null) {
            Bundle bundle = new Bundle();
            Message obtain = Message.obtain(handler, i2);
            bundle.putInt("CLIENTREQUESTID", i);
            obtain.setData(bundle);
            obtain.sendToTarget();
        }
    }

    private void m18032j() {
        if (this.f13728l.isEmpty()) {
            this.f13729m = null;
            return;
        }
        C3589f c3589f = (C3589f) this.f13728l.remove();
        switch (C3588e.f13746a[c3589f.f13747a.ordinal()]) {
            case 1:
                m18014b(c3589f.f13753g, c3589f.f13748b, c3589f.f13749c, c3589f.f13751e);
                return;
            case 2:
            case 3:
            case 5:
                return;
            case 4:
                m18015b(c3589f.f13753g, c3589f.f13748b, c3589f.f13749c, c3589f.f13752f, c3589f.f13751e);
                return;
            default:
                return;
        }
    }

    @SuppressLint({"NewApi"})
    private void m18014b(int i, UUID uuid, UUID uuid2, Handler handler) {
        this.f13729m = new C3589f(C3590g.CHARACTERISTIC_NOTIFICATION, i, uuid, uuid2, null, null, handler);
        BluetoothGattService service = this.f13723f.getService(uuid);
        if (service != null) {
            this.f13730n = service.getCharacteristic(uuid2);
            if (this.f13730n != null) {
                BluetoothGattCharacteristic bluetoothGattCharacteristic = this.f13730n;
                C2538c.c("BluetoothGatt", new Object[]{"mGattClient enable"});
                if (!m18012a(true, bluetoothGattCharacteristic)) {
                    C2538c.e("BluetoothGatt", new Object[]{"mGattClient.enable fail."});
                    m18032j();
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void m18015b(int i, UUID uuid, UUID uuid2, byte[] bArr, Handler handler) {
        BluetoothGattService service = this.f13723f.getService(uuid);
        this.f13729m = new C3589f(C3590g.WRITE_CHARACTERISTIC, i, uuid, uuid2, null, bArr, handler);
        if (service != null) {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
            if (characteristic == null) {
                return;
            }
            if (!characteristic.setValue(bArr) || !this.f13723f.writeCharacteristic(characteristic)) {
                m18006a(handler, this.f13729m.f13753g, 5);
                m18032j();
            }
        }
    }

    @SuppressLint({"NewApi"})
    private boolean m18012a(boolean z, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.f13723f == null) {
            throw new NullPointerException("GATT client not started.");
        } else if (this.f13723f.setCharacteristicNotification(bluetoothGattCharacteristic, z)) {
            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(C3579b.f13699a);
            if (descriptor == null) {
                C2538c.e("BluetoothGatt", new Object[]{"clientConfig == null."});
                return false;
            }
            if (z) {
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            } else {
                descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            }
            return this.f13723f.writeDescriptor(descriptor);
        } else {
            C2538c.e("BluetoothGatt", new Object[]{"setNotification failed."});
            return false;
        }
    }

    private void m18003a(int i) {
        this.f13740x[this.f13741y] = i;
        if (this.f13741y >= this.f13739w - 1) {
            m18034k();
            this.f13741y = 0;
            return;
        }
        this.f13741y++;
    }

    private void m18034k() {
        int i;
        int i2 = 0;
        for (i = 0; i < this.f13739w - 1; i++) {
            for (int i3 = 0; i3 < (this.f13739w - 1) - i; i3++) {
                if (this.f13740x[i3] > this.f13740x[i3 + 1]) {
                    int i4 = this.f13740x[i3];
                    this.f13740x[i3] = this.f13740x[i3 + 1];
                    this.f13740x[i3 + 1] = i4;
                }
            }
        }
        for (i = 1; i < this.f13739w - 1; i++) {
            i2 += this.f13740x[i];
        }
        i = i2 / (this.f13739w - 2);
        i = this.f13740x[this.f13739w / 2];
        Message obtain = Message.obtain(this.f13722e, 11);
        Bundle bundle = new Bundle();
        bundle.putInt("RSSI", i);
        obtain.setData(bundle);
        obtain.sendToTarget();
    }

    private void m18005a(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt != null) {
            try {
                Method method = bluetoothGatt.getClass().getMethod(UploadFile.REFRESH_LABEL, new Class[0]);
                if (method != null) {
                    boolean booleanValue = ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                    C2538c.e("BluetoothGatt", new Object[]{"Refreshing result: " + booleanValue});
                    return;
                }
                C2538c.e("BluetoothGatt", new Object[]{"refresh failed"});
                return;
            } catch (Exception e) {
                C2538c.e("BluetoothGatt", new Object[]{"An exception occured while refreshing device" + e.getMessage()});
                return;
            }
        }
        C2538c.e("BluetoothGatt", new Object[]{"refresh failed because gatt == null"});
    }

    private int m18013b(BluetoothGatt bluetoothGatt) {
        int i = 0;
        if (bluetoothGatt == null) {
            C2538c.e("BluetoothGatt", new Object[]{"getStatusWhileUnhandledExceptionInCallback is failed because gatt == null "});
        } else {
            try {
                Field declaredField = bluetoothGatt.getClass().getDeclaredField("mConnState");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    i = declaredField.getInt(bluetoothGatt);
                }
            } catch (Exception e) {
                C2538c.e("BluetoothGatt", new Object[]{"An exception occured while getStatusWhileUnhandledExceptionInCallback" + e.getMessage()});
            }
        }
        return i;
    }

    private synchronized void m18004a(int i, boolean z, int i2) {
        C3596n.m18055a(i);
        if (z) {
            switch (i) {
                case 0:
                    if (this.f13731o == 0) {
                        C2538c.b("BluetoothGatt", new Object[]{" mBlueStatus == XwConnection.STATE_NONE status = " + i + "  oldstatus = " + this.f13731o + "  where = " + i2});
                        break;
                    }
                    this.f13721d.sendBroadcast(new Intent("com.af500.disconnect"), "com.af500.permission.MYBRODCAST");
                    if (this.f13724g != null) {
                        this.f13724g.mo4230b(this);
                    }
                    C2538c.b("BluetoothGatt", new Object[]{" mBlueStatus != XwConnection.STATE_NONE status = " + i + "  oldstatus = " + this.f13731o + "  where = " + i2});
                    break;
                case 2:
                    if (this.f13731o == 2) {
                        C2538c.b("BluetoothGatt", new Object[]{" mBlueStatus == XwConnection.STATE_CONNECTING status = " + i + "  oldstatus = " + this.f13731o + "  where = " + i2});
                        break;
                    }
                    if (this.f13724g != null) {
                        this.f13724g.mo4231c(this);
                    }
                    C2538c.b("BluetoothGatt", new Object[]{" mBlueStatus != XwConnection.STATE_CONNECTING status = " + i + "  oldstatus = " + this.f13731o + "  where = " + i2});
                    break;
                case 3:
                    if (this.f13731o == 3) {
                        C2538c.b("BluetoothGatt", new Object[]{" mBlueStatus == XwConnection.STATE_CONNECTED status = " + i + "  oldstatus = " + this.f13731o + "  where = " + i2});
                        break;
                    }
                    if (this.f13724g != null) {
                        this.f13724g.mo4229a(this);
                    }
                    C2538c.b("BluetoothGatt", new Object[]{" mBlueStatus != XwConnection.STATE_CONNECTED status = " + i + "  oldstatus = " + this.f13731o + "  where = " + i2});
                    break;
            }
        }
        this.f13731o = i;
        C2538c.b("BluetoothGatt", new Object[]{"setConnectionState(int status)= " + this.f13731o});
    }
}
