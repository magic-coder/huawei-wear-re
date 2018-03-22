package com.fenda.hwbracelet.connection;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServerCallback;
import android.bluetooth.BluetoothGattService;
import com.huawei.p190v.C2538c;

/* compiled from: BleConnectionManager */
class C3587d extends BluetoothGattServerCallback {
    final /* synthetic */ C3584a f13745a;

    C3587d(C3584a c3584a) {
        this.f13745a = c3584a;
    }

    public void onCharacteristicReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        C2538c.e("BluetoothGatt", new Object[]{"onCharacteristicReadRequest"});
    }

    public void onCharacteristicWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, boolean z2, int i2, byte[] bArr) {
        C2538c.e("BluetoothGatt", new Object[]{"onCharacteristicWriteRequest"});
    }

    public void onConnectionStateChange(BluetoothDevice bluetoothDevice, int i, int i2) {
        C2538c.e("BluetoothGatt", new Object[]{"onConnectionStateChange"});
    }

    public void onDescriptorReadRequest(BluetoothDevice bluetoothDevice, int i, int i2, BluetoothGattDescriptor bluetoothGattDescriptor) {
        C2538c.e("BluetoothGatt", new Object[]{"onDescriptorReadRequest"});
    }

    public void onDescriptorWriteRequest(BluetoothDevice bluetoothDevice, int i, BluetoothGattDescriptor bluetoothGattDescriptor, boolean z, boolean z2, int i2, byte[] bArr) {
        C2538c.e("BluetoothGatt", new Object[]{"onDescriptorWriteRequest"});
    }

    public void onExecuteWrite(BluetoothDevice bluetoothDevice, int i, boolean z) {
        C2538c.e("BluetoothGatt", new Object[]{"onExecuteWrite"});
    }

    public void onServiceAdded(int i, BluetoothGattService bluetoothGattService) {
        C2538c.e("BluetoothGatt", new Object[]{"onServiceAdded"});
    }
}
