package com.huawei.crowdtestsdk.devices;

public class UnknownDevice extends CommonDevice {
    public UnknownDevice(DeviceHelper deviceHelper) {
        super(deviceHelper);
    }

    public UnknownDevice() {
        super(DeviceHelper.getUnknownDeviceHelper());
    }
}
