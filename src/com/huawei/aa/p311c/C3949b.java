package com.huawei.aa.p311c;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.p190v.C2538c;

/* compiled from: StressSendCommandUtil */
public class C3949b {
    public static void m19630a(int i, int i2) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(32);
        deviceCommand.setCommandID(1);
        String a = a.a((long) i);
        a = a.a(3) + a.a(a.length() / 2) + a;
        String a2 = a.a((long) i2);
        a2 = a.a(4) + a.a(a2.length() / 2) + a2;
        String a3 = a.a(129);
        a = a3 + a.a((a.length() / 2) + (a2.length() / 2)) + a + a2;
        deviceCommand.setDataLen(a.b(a).length);
        deviceCommand.setDataContent(a.b(a));
        deviceCommand.setNeedAck(true);
        C2538c.c("StressSendCommandUtil", new Object[]{"getStressRecordFrameListIndex deviceCommand: " + a.a(deviceCommand.getServiceID()) + a.a(deviceCommand.getCommandID()) + a.a(deviceCommand.getDataContent())});
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m19629a(int i) {
        C2538c.c("StressSendCommandUtil", new Object[]{"getStressRecordDetail index: " + i});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(32);
        deviceCommand.setCommandID(2);
        String a = a.a(129);
        String e = a.e(4);
        String a2 = a.a(2);
        String b = a.b(i);
        String e2 = a.e(b.length() / 2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(e);
        stringBuilder.append(a2);
        stringBuilder.append(e2);
        stringBuilder.append(b);
        deviceCommand.setDataLen(stringBuilder.length() / 2);
        deviceCommand.setDataContent(a.b(stringBuilder.toString()));
        deviceCommand.setNeedAck(true);
        C2538c.c("StressSendCommandUtil", new Object[]{"getStressRecordDetail deviceCommand: " + a.a(deviceCommand.getServiceID()) + a.a(deviceCommand.getCommandID()) + a.a(deviceCommand.getDataContent())});
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m19632b(int i, int i2) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(32);
        deviceCommand.setCommandID(3);
        String a = a.a((long) i);
        a = a.a(3) + a.a(a.length() / 2) + a;
        String a2 = a.a((long) i2);
        a2 = a.a(4) + a.a(a2.length() / 2) + a2;
        String a3 = a.a(129);
        a = a3 + a.a((a.length() / 2) + (a2.length() / 2)) + a + a2;
        deviceCommand.setDataLen(a.b(a).length);
        deviceCommand.setDataContent(a.b(a));
        deviceCommand.setNeedAck(true);
        C2538c.c("StressSendCommandUtil", new Object[]{"getRelaxRecordFrameListIndex deviceCommand: " + a.a(deviceCommand.getServiceID()) + a.a(deviceCommand.getCommandID()) + a.a(deviceCommand.getDataContent())});
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m19631b(int i) {
        C2538c.c("StressSendCommandUtil", new Object[]{"getRelaxRecordDetail index: " + i});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(32);
        deviceCommand.setCommandID(4);
        String a = a.a(129);
        String e = a.e(4);
        String a2 = a.a(2);
        String b = a.b(i);
        String e2 = a.e(b.length() / 2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(e);
        stringBuilder.append(a2);
        stringBuilder.append(e2);
        stringBuilder.append(b);
        deviceCommand.setDataLen(stringBuilder.length() / 2);
        deviceCommand.setDataContent(a.b(stringBuilder.toString()));
        deviceCommand.setNeedAck(true);
        C2538c.c("StressSendCommandUtil", new Object[]{"getRelaxRecordDetail deviceCommand: " + a.a(deviceCommand.getServiceID()) + a.a(deviceCommand.getCommandID()) + a.a(deviceCommand.getDataContent())});
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }
}
