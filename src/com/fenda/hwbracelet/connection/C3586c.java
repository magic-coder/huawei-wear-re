package com.fenda.hwbracelet.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Bundle;
import android.os.Message;
import android.os.ParcelUuid;
import com.fenda.hwbracelet.p258b.p259a.C3578a;
import com.fenda.hwbracelet.p258b.p259a.C3580c;
import com.fenda.hwbracelet.p263f.C3608d;
import com.huawei.p190v.C2538c;

/* compiled from: BleConnectionManager */
class C3586c extends BluetoothGattCallback {
    final /* synthetic */ C3584a f13744a;

    C3586c(C3584a c3584a) {
        this.f13744a = c3584a;
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        int a = this.f13744a.m18013b(bluetoothGatt);
        C2538c.e("BluetoothGatt", new Object[]{"-onConnectionStateChange--getStatusFromGatt-" + a + "-----status----" + i + "---newState----" + i2});
        if (i != 0) {
            this.f13744a.m18004a(0, true, 7);
            synchronized (this) {
                this.f13744a.m18023f();
            }
        } else if (2 == i2 && this.f13744a.f13723f != null) {
            C2538c.e("BluetoothGatt", new Object[]{"newState == BluetoothProfile.STATE_CONNECTED"});
            this.f13744a.f13723f.discoverServices();
        } else if (i2 == 0) {
            C2538c.e("BluetoothGatt", new Object[]{"newState == BluetoothProfile.STATE_DISCONNECTED"});
            this.f13744a.m18004a(0, true, 5);
            synchronized (this) {
                this.f13744a.m18023f();
            }
        } else {
            this.f13744a.m18004a(0, true, 6);
            C2538c.e("BluetoothGatt", new Object[]{"onConnectionStateChange faied in other status"});
            synchronized (this) {
                this.f13744a.m18023f();
            }
        }
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        C2538c.e("BluetoothGatt", new Object[]{"-onServicesDiscovered--getStatusFromGatt-" + this.f13744a.m18013b(bluetoothGatt)});
        if (i == 0) {
            this.f13744a.m18029i();
            this.f13744a.f13734r = 0;
            this.f13744a.f13733q = true;
            C2538c.e("BluetoothGatt", new Object[]{"GATT_SUCCESS"});
            this.f13744a.m18044b();
            this.f13744a.m18004a(3, true, 8);
            return;
        }
        C2538c.e("BluetoothGatt", new Object[]{"myOnServicesDiscovered failed status = " + i + " will obtain the close() to prevent the error connection"});
        this.f13744a.m18004a(0, true, 9);
        synchronized (this) {
            this.f13744a.m18023f();
        }
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] value = bluetoothGattCharacteristic.getValue();
        C2538c.b("BluetoothGatt", new Object[]{"Received a Ble message: " + C3608d.m18110a(value)});
        if (this.f13744a.f13722e != null) {
            Bundle bundle = new Bundle();
            Message obtain = Message.obtain(this.f13744a.f13722e, 3);
            bundle.putByteArray("CVALUE", bluetoothGattCharacteristic.getValue());
            bundle.putParcelable("SERVUUID", new ParcelUuid(bluetoothGattCharacteristic.getService().getUuid()));
            bundle.putParcelable("CHARUUID", new ParcelUuid(bluetoothGattCharacteristic.getUuid()));
            obtain.setData(bundle);
            obtain.sendToTarget();
        }
    }

    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        C2538c.e("BluetoothGatt", new Object[]{"onDescriptorRead" + i});
        if (this.f13744a.f13729m.f13747a != C3590g.CHARACTERISTIC_NOTIFICATION && this.f13744a.f13729m.f13747a == C3590g.READ_DESCRIPTOR) {
            this.f13744a.m18032j();
        }
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        C2538c.e("BluetoothGatt", new Object[]{"onDescriptorWrite" + i});
        this.f13744a.m18032j();
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (this.f13744a.f13729m.f13747a == C3590g.READ_CHARACTERISTIC) {
            if (this.f13744a.f13729m.f13751e != null) {
                if (i == 0) {
                    Bundle bundle = new Bundle();
                    Message obtain = Message.obtain(this.f13744a.f13729m.f13751e, 3);
                    bundle.putByteArray("CVALUE", bluetoothGattCharacteristic.getValue());
                    bundle.putParcelable("SERVUUID", new ParcelUuid(bluetoothGattCharacteristic.getService().getUuid()));
                    bundle.putParcelable("CHARUUID", new ParcelUuid(bluetoothGattCharacteristic.getUuid()));
                    obtain.setData(bundle);
                    obtain.sendToTarget();
                } else {
                    this.f13744a.m18006a(this.f13744a.f13729m.f13751e, this.f13744a.f13729m.f13753g, 5);
                }
            }
            this.f13744a.m18032j();
        }
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        byte[] value = bluetoothGattCharacteristic.getValue();
        C2538c.b("BluetoothGatt", new Object[]{"Send a message: " + C3608d.m18110a(value)});
        String str = "unkown";
        String a = C3580c.m17949a(bluetoothGattCharacteristic.getService().getUuid(), str);
        String a2 = C3608d.m18110a(C3578a.m17948a(bluetoothGattCharacteristic.getUuid(), str).getBytes());
        C2538c.b("BluetoothGatt", new Object[]{"onCharacteristicWrite: service@" + a + " characteristic@" + str + " hexDataString@" + a2 + " status@" + i});
        this.f13744a.m18032j();
    }

    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (i2 == 0 && this.f13744a.f13722e != null) {
            this.f13744a.m18003a(i);
        }
    }
}
