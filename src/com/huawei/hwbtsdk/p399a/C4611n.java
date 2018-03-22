package com.huawei.hwbtsdk.p399a;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;

/* compiled from: BluetoothCtrl */
public class C4611n {
    public static boolean m22000a(BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) bluetoothDevice.getClass().getMethod("createBond", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    public static boolean m22003b(BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) bluetoothDevice.getClass().getMethod("removeBond", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    public static boolean m22001a(BluetoothHeadset bluetoothHeadset, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) bluetoothHeadset.getClass().getMethod("connect", new Class[]{BluetoothDevice.class}).invoke(bluetoothHeadset, new Object[]{bluetoothDevice})).booleanValue();
    }

    public static boolean m22002a(BluetoothHeadset bluetoothHeadset, BluetoothDevice bluetoothDevice, int i) throws Exception {
        return ((Boolean) bluetoothHeadset.getClass().getMethod("setPriority", new Class[]{BluetoothDevice.class, Integer.TYPE}).invoke(bluetoothHeadset, new Object[]{bluetoothDevice, Integer.valueOf(i)})).booleanValue();
    }
}
