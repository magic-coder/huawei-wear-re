package com.fenda.hwbracelet.connection;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelUuid;
import android.util.Log;

/* compiled from: BluetoothLeService */
class C3591h extends BluetoothGattCallback {
    final /* synthetic */ BluetoothLeService f13761a;

    C3591h(BluetoothLeService bluetoothLeService) {
        this.f13761a = bluetoothLeService;
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (i2 == 2 && this.f13761a.f13710g != null) {
            this.f13761a.f13710g.discoverServices();
        } else if (i2 == 0) {
            this.f13761a.m17987a(this.f13761a.f13707d, 4);
        }
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        if (i == 0) {
            this.f13761a.m17987a(this.f13761a.f13707d, 2);
        }
    }

    @SuppressLint({"NewApi"})
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Handler b = this.f13761a.f13713j.m18050b(bluetoothGattCharacteristic.getService().getUuid(), bluetoothGattCharacteristic.getUuid());
        if (b != null) {
            Bundle bundle = new Bundle();
            Message obtain = Message.obtain(b, 3);
            bundle.putByteArray("CVALUE", bluetoothGattCharacteristic.getValue());
            bundle.putParcelable("SERVUUID", new ParcelUuid(bluetoothGattCharacteristic.getService().getUuid()));
            bundle.putParcelable("CHARUUID", new ParcelUuid(bluetoothGattCharacteristic.getUuid()));
            obtain.setData(bundle);
            obtain.sendToTarget();
        }
    }

    @SuppressLint({"NewApi"})
    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        BluetoothGattCharacteristic characteristic = bluetoothGattDescriptor.getCharacteristic();
        if (this.f13761a.f13705b.f13747a == C3590g.CHARACTERISTIC_NOTIFICATION) {
            if (i != 0) {
                this.f13761a.m17988a(this.f13761a.f13705b.f13751e, this.f13761a.f13705b.f13753g, 5);
                this.f13761a.f13713j.m18048a(characteristic.getService().getUuid(), characteristic.getUuid());
            }
            if (characteristic.getService().getUuid() == this.f13761a.f13714k.getService().getUuid() && characteristic.getUuid() == this.f13761a.f13714k.getUuid()) {
                this.f13761a.f13713j.m18049a(characteristic.getService().getUuid(), characteristic.getUuid(), this.f13761a.f13705b.f13751e);
                if (!this.f13761a.m17992a(true, characteristic)) {
                    this.f13761a.m17988a(this.f13761a.f13705b.f13751e, this.f13761a.f13705b.f13753g, 5);
                    this.f13761a.f13713j.m18048a(characteristic.getService().getUuid(), characteristic.getUuid());
                }
            }
        } else if (this.f13761a.f13705b.f13747a == C3590g.READ_DESCRIPTOR) {
            if (i == 0) {
                Bundle bundle = new Bundle();
                Message obtain = Message.obtain(this.f13761a.f13705b.f13751e, 10);
                bundle.putByteArray("CVALUE", characteristic.getValue());
                bundle.putParcelable("SERVUUID", new ParcelUuid(characteristic.getService().getUuid()));
                bundle.putParcelable("CHARUUID", new ParcelUuid(characteristic.getUuid()));
                bundle.putParcelable("DESCUUID", new ParcelUuid(bluetoothGattDescriptor.getUuid()));
                obtain.setData(bundle);
                obtain.sendToTarget();
            } else {
                this.f13761a.m17988a(this.f13761a.f13705b.f13751e, this.f13761a.f13705b.f13753g, 5);
            }
            this.f13761a.m17994b();
        }
    }

    @SuppressLint({"NewApi"})
    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        BluetoothGattCharacteristic characteristic = bluetoothGattDescriptor.getCharacteristic();
        if (this.f13761a.f13705b.f13747a == C3590g.CHARACTERISTIC_NOTIFICATION) {
            if (i != 0) {
                this.f13761a.m17988a(this.f13761a.f13705b.f13751e, this.f13761a.f13705b.f13753g, 5);
                this.f13761a.f13713j.m18048a(characteristic.getService().getUuid(), characteristic.getUuid());
            }
        } else if (this.f13761a.f13705b.f13747a == C3590g.WRITE_DESCRIPTOR) {
        }
        this.f13761a.m17994b();
    }

    @SuppressLint({"NewApi"})
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (this.f13761a.f13705b.f13747a == C3590g.READ_CHARACTERISTIC) {
            if (this.f13761a.f13705b.f13751e != null) {
                if (i == 0) {
                    Bundle bundle = new Bundle();
                    Message obtain = Message.obtain(this.f13761a.f13705b.f13751e, 3);
                    bundle.putByteArray("CVALUE", bluetoothGattCharacteristic.getValue());
                    bundle.putParcelable("SERVUUID", new ParcelUuid(bluetoothGattCharacteristic.getService().getUuid()));
                    bundle.putParcelable("CHARUUID", new ParcelUuid(bluetoothGattCharacteristic.getUuid()));
                    obtain.setData(bundle);
                    obtain.sendToTarget();
                } else {
                    this.f13761a.m17988a(this.f13761a.f13705b.f13751e, this.f13761a.f13705b.f13753g, 5);
                }
            }
            this.f13761a.m17994b();
        }
    }

    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (i2 == 0) {
            Message obtain = Message.obtain(this.f13761a.f13707d, 11);
            Bundle bundle = new Bundle();
            bundle.putInt("RSSI", i);
            obtain.setData(bundle);
            obtain.sendToTarget();
            return;
        }
        Log.i("xBracelet bLe Service", "Read Rssi failure.");
    }
}
