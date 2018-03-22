package com.huawei.p192w.p521a;

import android.support.v4.media.TransportMediator;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.multisimservice.model.SimInfo;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: MultiSimSendCommandUtil */
public class C6136a {
    public static void m27933a(String str, int i) {
        C2538c.b("MultiSimSendCommandUtil", new Object[]{"the accode " + str});
        com.huawei.n.c a = com.huawei.n.c.a(BaseApplication.b());
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(29);
        deviceCommand.setCommandID(1);
        if (str != null) {
            String e = a.e(str);
            int length = e.length() / 2;
            if (127 >= length) {
                e = a.a(1) + a.a(length) + e;
            } else {
                e = a.a(1) + a.a((length / 127) + 128) + a.a(length % 127) + e;
            }
            e = e + a.a(2) + a.a(2) + a.b(i);
            deviceCommand.setDataLen(a.b(e).length);
            deviceCommand.setDataContent(a.b(e));
            C2538c.c("MultiSimSendCommandUtil", new Object[]{"sendOpenEsimCommand " + e});
            a.a(deviceCommand);
            return;
        }
        C2538c.e("MultiSimSendCommandUtil", new Object[]{"accode == null"});
    }

    public static void m27935b(String str, int i) {
        C2538c.b("MultiSimSendCommandUtil", new Object[]{"the conformcode " + str});
        com.huawei.n.c a = com.huawei.n.c.a(BaseApplication.b());
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(29);
        deviceCommand.setCommandID(3);
        String str2 = null;
        if (str != null) {
            str2 = a.e(str);
            int length = str2.length() / 2;
            if (length <= 127) {
                str2 = a.a(1) + a.a(length) + str2;
            } else {
                str2 = a.a(1) + a.a((length / 127) + 128) + a.a(length % 127) + str2;
            }
        }
        String a2 = a.a((long) i);
        a2 = a.a(2) + a.a(a2.length() / 2) + a2;
        if (str2 != null) {
            str2 = str2 + a2;
        } else {
            str2 = a2;
        }
        deviceCommand.setDataLen(a.b(str2).length);
        deviceCommand.setDataContent(a.b(str2));
        C2538c.c("MultiSimSendCommandUtil", new Object[]{"sendConformCode " + str2});
        a.a(deviceCommand);
    }

    public static void m27932a(int i, boolean z) {
        String a;
        com.huawei.n.c a2 = com.huawei.n.c.a(BaseApplication.b());
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(29);
        deviceCommand.setCommandID(i);
        if (z) {
            a = a.a(100000);
            a = a.a(127) + a.a(a.length() / 2) + a;
        } else {
            a = a.a(100001);
            a = a.a(127) + a.a(a.length() / 2) + a;
        }
        deviceCommand.setDataLen(a.b(a).length);
        deviceCommand.setDataContent(a.b(a));
        C2538c.c("MultiSimSendCommandUtil", new Object[]{"sendReslut " + a});
        a2.a(deviceCommand);
    }

    public static void m27929a() {
        C2538c.c("MultiSimSendCommandUtil", new Object[]{"sendSimInfoQuery enter"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(29);
        deviceCommand.setCommandID(6);
        byte[] b = C0973a.b(C0973a.a(1) + "00");
        deviceCommand.setDataLen(b.length);
        deviceCommand.setDataContent(b);
        deviceCommand.setNeedAck(true);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    private static byte[] m27936b(int i, String str) {
        String str2 = "" + C0973a.a(1) + C0973a.a(1) + C0973a.a(i);
        if (!(i == 0 || str == null || str.equals(""))) {
            str2 = str2 + C0973a.a(2) + C0973a.a(str.length()) + C0973a.e(str);
        }
        return C0973a.b(str2);
    }

    public static void m27931a(int i, String str) {
        C2538c.c("MultiSimSendCommandUtil", new Object[]{"sendMultiSimStatus enter"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(29);
        deviceCommand.setCommandID(7);
        byte[] b = C6136a.m27936b(i, str);
        deviceCommand.setDataLen(b.length);
        deviceCommand.setDataContent(b);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    private static byte[] m27937b(List<SimInfo> list) {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        for (SimInfo simInfo : list) {
            String str2 = "";
            str = ((C0973a.a(3) + C0973a.a(simInfo.getIMSI().length()) + C0973a.e(simInfo.getIMSI())) + C0973a.a(4) + C0973a.a(simInfo.getICCID().length()) + C0973a.e(simInfo.getICCID())) + C0973a.a(5) + C0973a.a(1) + C0973a.a(simInfo.isActive() ? 1 : 0);
            stringBuffer.append(C0973a.a(TransportMediator.KEYCODE_MEDIA_RECORD) + C0973a.e(str.length() / 2) + str);
        }
        str = stringBuffer.toString();
        return C0973a.b(C0973a.a(129) + C0973a.e(str.length() / 2) + str);
    }

    public static void m27934a(List<SimInfo> list) {
        C2538c.c("MultiSimSendCommandUtil", new Object[]{"sendESimProfileRemoveReq enter"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(29);
        deviceCommand.setCommandID(8);
        byte[] b = C6136a.m27937b(list);
        deviceCommand.setDataLen(b.length);
        deviceCommand.setDataContent(b);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }

    public static void m27930a(int i, int i2) {
        C2538c.c("MultiSimSendCommandUtil", new Object[]{"sendESimProfileRemoveReq enter"});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(29);
        deviceCommand.setCommandID(i);
        byte[] b = C0973a.b(C0973a.a(127) + C0973a.a(4) + C0973a.a((long) i2));
        deviceCommand.setDataLen(b.length);
        deviceCommand.setDataContent(b);
        com.huawei.n.c.a(BaseApplication.b()).a(deviceCommand);
    }
}
