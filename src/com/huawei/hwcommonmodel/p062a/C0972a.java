package com.huawei.hwcommonmodel.p062a;

import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;

/* compiled from: CapabilityUtils */
public class C0972a {
    private static DeviceCapability f1633a;
    private static DeviceInfo f1634b;
    private static Object f1635c = new Object();
    private static Object f1636d = new Object();

    public static DeviceCapability m3499a() {
        DeviceCapability deviceCapability;
        synchronized (C0972a.m3503c()) {
            deviceCapability = f1633a;
        }
        return deviceCapability;
    }

    public static void m3500a(DeviceCapability deviceCapability) {
        synchronized (C0972a.m3503c()) {
            if (deviceCapability != null) {
                f1633a = deviceCapability;
            }
        }
    }

    public static DeviceInfo m3502b() {
        DeviceInfo deviceInfo;
        synchronized (C0972a.m3504d()) {
            deviceInfo = f1634b;
        }
        return deviceInfo;
    }

    public static void m3501a(DeviceInfo deviceInfo) {
        synchronized (C0972a.m3504d()) {
            if (deviceInfo != null) {
                f1634b = deviceInfo;
            }
        }
    }

    private static synchronized Object m3503c() {
        Object obj;
        synchronized (C0972a.class) {
            obj = f1635c;
        }
        return obj;
    }

    private static synchronized Object m3504d() {
        Object obj;
        synchronized (C0972a.class) {
            obj = f1636d;
        }
        return obj;
    }
}
