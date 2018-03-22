package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;
import java.nio.charset.Charset;

/* compiled from: BluetoothLEConnectService */
class C1709o extends BluetoothGattCallback {
    final /* synthetic */ C1705k f4580a;

    C1709o(C1705k c1705k) {
        this.f4580a = c1705k;
    }

    public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
        if (C1705k.f4534K != null && this.f4580a.f4553U != null) {
            this.f4580a.f4553U.m7871a(bluetoothGatt.getDevice().getAddress(), i, i2);
        }
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        C2538c.m12674b("BluetoothLEConnectService", "onConnectionStateChange() status = " + i + " newState = " + i2 + " connectRetry = " + this.f4580a.f4574y + " discoverServicesRetry = " + this.f4580a.f4571v + " mBluetoothGatt = " + C1705k.f4534K + " gatt = " + bluetoothGatt);
        if (C1705k.f4534K == null) {
            C1705k.f4534K = bluetoothGatt;
        }
        if (i2 == 2) {
            C2538c.m12674b("BluetoothLEConnectService", "Connected to GATT server.");
            this.f4580a.f4556X.postDelayed(new C1710p(this), 1000);
        } else if (i2 == 0) {
            C2538c.m12674b("BluetoothLEConnectService", "Disconnected from GATT server.");
            this.f4580a.f4556X.removeCallbacksAndMessages(null);
            if (this.f4580a.f4566q) {
                this.f4580a.f4556X.post(new C1711q(this));
                return;
            }
            C2538c.m12674b("BluetoothLEConnectService", "connectRetry = " + this.f4580a.f4574y + ", discoverServicesRetry = " + this.f4580a.f4571v + ", mState = " + C1700i.m8041a() + ", disConnectFlag = " + C1705k.f4527B);
            this.f4580a.f4556X.postDelayed(new C1712r(this), 1000);
        }
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        C2538c.m12674b("BluetoothLEConnectService", "onServicesDiscovered() status = " + i + " mBluetoothGatt = " + C1705k.f4534K);
        if (C1705k.f4534K != null) {
            if (i == 0) {
                this.f4580a.f4544L = C1705k.f4534K.getService(C1705k.f4535a);
                this.f4580a.f4545M = C1705k.f4534K.getService(C1705k.f4536e);
                this.f4580a.f4546N = C1705k.f4534K.getService(C1705k.f4537f);
                this.f4580a.f4547O = C1705k.f4534K.getService(C1705k.f4538g);
                if (this.f4580a.f4544L != null) {
                    this.f4580a.f4548P = this.f4580a.f4544L.getCharacteristic(C1705k.f4528C);
                    C2538c.m12674b("BluetoothLEConnectService", "mImmediateAlertService UUID is " + C1705k.f4535a.toString() + " writeImmediateAlertCharacteristic = " + this.f4580a.f4548P);
                } else {
                    C2538c.m12680e("BluetoothLEConnectService", "K1 mImmediateAlertService is null.");
                    this.f4580a.m8082a(C1705k.f4534K, 4);
                }
                if (this.f4580a.f4545M != null) {
                    this.f4580a.f4549Q = this.f4580a.f4545M.getCharacteristic(C1705k.f4529D);
                    C2538c.m12674b("BluetoothLEConnectService", "mTxPowerService UUID is " + C1705k.f4536e.toString() + "readTxPowerCharacteristic = " + this.f4580a.f4549Q);
                } else {
                    C2538c.m12680e("BluetoothLEConnectService", "K1 mTxPowerService is null.");
                    this.f4580a.m8082a(C1705k.f4534K, 4);
                }
                if (this.f4580a.f4546N != null) {
                    this.f4580a.f4550R = this.f4580a.f4546N.getCharacteristic(C1705k.f4530E);
                    C2538c.m12674b("BluetoothLEConnectService", "mLinkLossService UUID is " + C1705k.f4537f.toString() + "writeLinkLossCharacteristic = " + this.f4580a.f4550R);
                } else {
                    C2538c.m12680e("BluetoothLEConnectService", "K1 mLinkLossService is null.");
                    this.f4580a.m8082a(C1705k.f4534K, 4);
                }
                if (this.f4580a.f4547O != null) {
                    this.f4580a.f4551S = this.f4580a.f4547O.getCharacteristic(C1705k.f4531F);
                    this.f4580a.f4552T = this.f4580a.f4547O.getCharacteristic(C1705k.f4532G);
                    C2538c.m12674b("BluetoothLEConnectService", "mAuthenticationService UUID is" + C1705k.f4538g.toString() + "writeAuthenticationCharacteristic = " + this.f4580a.f4551S + "readAuthenticationCharacteristic = " + this.f4580a.f4552T);
                } else {
                    C2538c.m12680e("BluetoothLEConnectService", "K1 mAuthenticationService is null.");
                    this.f4580a.m8082a(C1705k.f4534K, 4);
                }
                if (this.f4580a.f4548P == null || this.f4580a.f4549Q == null || this.f4580a.f4550R == null || this.f4580a.f4551S == null || this.f4580a.f4552T == null) {
                    C2538c.m12680e("BluetoothLEConnectService", "K1 Characteristic is null.");
                    this.f4580a.m8082a(C1705k.f4534K, 3);
                    return;
                }
                if (this.f4580a.f4542I != null) {
                    this.f4580a.f4542I.m8153a();
                }
                this.f4580a.f4569t = false;
                this.f4580a.f4564n = 0;
                C1705k.m8090b(false);
                this.f4580a.f4565p = 0;
                this.f4580a.f4561j = 0;
                this.f4580a.f4562k = 0;
                this.f4580a.f4541A = 0;
                this.f4580a.m8044a(2);
                return;
            }
            C2538c.m12680e("BluetoothLEConnectService", "onServicesDiscovered return GATT_FAIED, status:" + i);
            this.f4580a.m8106d(false);
        }
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (i == 0) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            if (value != null) {
                C2538c.m12674b("BluetoothLEConnectService", "K1 --> SDK Characteristic has been read. " + new String(value, Charset.defaultCharset()));
                this.f4580a.d.mo2570a(value.length, value);
                return;
            }
            C2538c.m12674b("BluetoothLEConnectService", "K1 --> SDK onCharacteristicRead data == null");
            return;
        }
        C2538c.m12674b("BluetoothLEConnectService", "K1 --> SDK onCharacteristicRead error status = " + i);
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        if (i == 0) {
            if (this.f4580a.f4551S == bluetoothGattCharacteristic) {
                try {
                    Thread.sleep(100);
                    C2538c.m12674b("BluetoothLEConnectService", "延时100毫秒后读取char1");
                } catch (InterruptedException e) {
                    C2538c.m12680e("BluetoothLEConnectService", "Exception e = " + e.getMessage());
                }
                this.f4580a.m8135o();
            } else if (this.f4580a.f4550R == bluetoothGattCharacteristic) {
                this.f4580a.f4554V.mo2555a(Integer.valueOf(Integer.parseInt(C0973a.m3509a(bluetoothGattCharacteristic.getValue()), 16)));
                this.f4580a.f4556X.removeCallbacks(this.f4580a.f4559h);
            }
            C2538c.m12674b("BluetoothLEConnectService", "SDK --> K1 onCharacteristicWrite(),status == success,wrote:" + C0973a.m3509a(bluetoothGattCharacteristic.getValue()));
        } else if (this.f4580a.f4550R == bluetoothGattCharacteristic) {
            C2538c.m12674b("BluetoothLEConnectService", "SDK --> K1 onCharacteristicWrite error status = " + i);
            this.f4580a.f4554V.mo2554a(2, "Write LinkLoss Error");
            this.f4580a.f4556X.removeCallbacks(this.f4580a.f4559h);
        } else {
            C2538c.m12674b("BluetoothLEConnectService", "SDK --> B0 onCharacteristicWrite error status = " + i);
        }
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] value = bluetoothGattCharacteristic.getValue();
        C2538c.m12674b("BluetoothLEConnectService", "K1 --> SDK onCharacteristicChanged, value = " + C0973a.m3509a(value));
        this.f4580a.d.mo2570a(value.length, value);
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
    }
}
