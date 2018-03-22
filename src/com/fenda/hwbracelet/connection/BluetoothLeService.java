package com.fenda.hwbracelet.connection;

import android.annotation.SuppressLint;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import com.fenda.hwbracelet.p258b.p259a.C3579b;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

@SuppressLint({"NewApi"})
public class BluetoothLeService extends Service {
    private static int f13703l = 0;
    Queue<C3589f> f13704a = new LinkedList();
    C3589f f13705b = null;
    private final IBinder f13706c = new C3593j(this);
    private Handler f13707d = null;
    private BluetoothManager f13708e = null;
    private BluetoothAdapter f13709f = null;
    private BluetoothGatt f13710g = null;
    private BluetoothGattServer f13711h = null;
    private BluetoothDevice f13712i = null;
    private C3594k f13713j = new C3594k();
    private BluetoothGattCharacteristic f13714k = null;
    @SuppressLint({"NewApi"})
    private BluetoothGattCallback f13715m = new C3591h(this);

    public IBinder onBind(Intent intent) {
        return this.f13706c;
    }

    @SuppressLint({"NewApi"})
    public void onCreate() {
        super.onCreate();
        if (this.f13709f == null) {
            this.f13708e = (BluetoothManager) getSystemService("bluetooth");
            this.f13709f = this.f13708e.getAdapter();
        }
    }

    public void onDestroy() {
        Log.e("xBracelet bLe Service", "destory");
        if (this.f13710g != null) {
            m17999a();
        }
        super.onDestroy();
    }

    @SuppressLint({"NewApi"})
    public void m17999a() {
        if (this.f13710g != null) {
            this.f13710g.disconnect();
            this.f13710g.close();
            this.f13710g = null;
        }
    }

    private void m17987a(Handler handler, int i) {
        if (handler != null) {
            Message.obtain(handler, i).sendToTarget();
        }
    }

    private void m17988a(Handler handler, int i, int i2) {
        if (handler != null) {
            Bundle bundle = new Bundle();
            Message obtain = Message.obtain(handler, i2);
            bundle.putInt("CLIENTREQUESTID", i);
            obtain.setData(bundle);
            obtain.sendToTarget();
        }
    }

    private void m17994b() {
        Log.i("xBracelet bLe Service", "processNextRequest...");
        if (this.f13704a.isEmpty()) {
            this.f13705b = null;
            Log.i("xBracelet bLe Service", "currentRequest");
            return;
        }
        C3589f c3589f = (C3589f) this.f13704a.remove();
        switch (C3592i.f13762a[c3589f.f13747a.ordinal()]) {
            case 1:
                m17984a(c3589f.f13753g, c3589f.f13748b, c3589f.f13749c, c3589f.f13751e);
                return;
            case 2:
                m17995b(c3589f.f13753g, c3589f.f13748b, c3589f.f13749c, c3589f.f13751e);
                return;
            case 3:
                m17985a(c3589f.f13753g, c3589f.f13748b, c3589f.f13749c, c3589f.f13750d, c3589f.f13751e);
                return;
            case 4:
                m17986a(c3589f.f13753g, c3589f.f13748b, c3589f.f13749c, c3589f.f13752f, c3589f.f13751e);
                return;
            case 5:
                return;
            default:
                return;
        }
    }

    @SuppressLint({"NewApi"})
    private void m17984a(int i, UUID uuid, UUID uuid2, Handler handler) {
        this.f13705b = new C3589f(C3590g.CHARACTERISTIC_NOTIFICATION, i, uuid, uuid2, null, null, handler);
        BluetoothGattService service = this.f13710g.getService(uuid);
        if (service != null) {
            this.f13714k = service.getCharacteristic(uuid2);
            if (this.f13714k != null) {
                BluetoothGattDescriptor descriptor = this.f13714k.getDescriptor(C3579b.f13699a);
                Log.i("xBracelet bLe Service", "mGattClient.readDescriptor");
                if (descriptor == null || !this.f13710g.readDescriptor(descriptor)) {
                    Log.i("xBracelet bLe Service", "mGattClient.readDescriptor fail.");
                    m17988a(handler, this.f13705b.f13753g, 5);
                    m17994b();
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void m17995b(int i, UUID uuid, UUID uuid2, Handler handler) {
        this.f13705b = new C3589f(C3590g.READ_CHARACTERISTIC, i, uuid, uuid2, null, null, handler);
        BluetoothGattService service = this.f13710g.getService(uuid);
        if (service != null) {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
            if (characteristic != null && !this.f13710g.readCharacteristic(characteristic)) {
                m17988a(handler, this.f13705b.f13753g, 5);
                m17994b();
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void m17985a(int i, UUID uuid, UUID uuid2, UUID uuid3, Handler handler) {
        this.f13705b = new C3589f(C3590g.READ_DESCRIPTOR, i, uuid, uuid2, uuid3, null, handler);
        BluetoothGattService service = this.f13710g.getService(uuid);
        if (service != null) {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
            if (characteristic != null) {
                BluetoothGattDescriptor descriptor = characteristic.getDescriptor(uuid3);
                if (descriptor != null && !this.f13710g.readDescriptor(descriptor)) {
                    m17988a(handler, this.f13705b.f13753g, 5);
                    m17994b();
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void m17986a(int i, UUID uuid, UUID uuid2, byte[] bArr, Handler handler) {
        BluetoothGattService service = this.f13710g.getService(uuid);
        this.f13705b = new C3589f(C3590g.WRITE_CHARACTERISTIC, i, uuid, uuid2, null, bArr, handler);
        if (service != null) {
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(uuid2);
            if (characteristic != null && characteristic.setValue(bArr) && this.f13710g.writeCharacteristic(characteristic)) {
                m17988a(handler, this.f13705b.f13753g, 5);
                m17994b();
            }
        }
    }

    @SuppressLint({"NewApi"})
    private boolean m17992a(boolean z, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (this.f13710g == null) {
            throw new NullPointerException("GATT client not started.");
        } else if (!this.f13710g.setCharacteristicNotification(bluetoothGattCharacteristic, z)) {
            return false;
        } else {
            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(C3579b.f13699a);
            if (descriptor == null) {
                return false;
            }
            if (z) {
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            } else {
                descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
            }
            return this.f13710g.writeDescriptor(descriptor);
        }
    }
}
