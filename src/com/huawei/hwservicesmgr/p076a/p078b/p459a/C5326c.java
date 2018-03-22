package com.huawei.hwservicesmgr.p076a.p078b.p459a;

import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.C5006j;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.p190v.C2538c;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FileServiceConsultUtil */
public class C5326c {
    private static String f19056a = "";
    private static int f19057b;
    private static int f19058c;
    private static long f19059d;
    private static int f19060e;
    private static int f19061f;
    private static int f19062g;
    private static int f19063h;
    private static int f19064i;
    private static int f19065j = 0;
    private static List<byte[]> f19066k = new ArrayList();
    private static List<Integer> f19067l = new ArrayList();

    public static void m25761a(String str, int i, int i2, long j, int i3, int i4) {
        C2538c.b("FileServiceConsultUtil", new Object[]{"respfileManagerConsult "});
        C5326c.m25756a(i2);
        C5326c.m25757a(j);
        C5326c.m25763b(i3);
        C5326c.m25766c(i4);
        C5326c.m25768d((int) (j / ((long) i2)));
        C2538c.b("FileServiceConsultUtil", new Object[]{"respfileManagerConsult fileType赋值 = " + i4 + " sendNum = " + f19057b});
        f19056a = str;
        if (str != null && i4 == 0) {
            C5326c.m25778i(100000);
        } else if (1 == i4) {
            C5326c.m25780j(100000);
        } else {
            C2538c.c("FileServiceConsultUtil", new Object[]{"respfileManagerConsult fileType is unknown "});
        }
    }

    public static String m25755a() {
        return f19056a;
    }

    public static void m25756a(int i) {
        f19058c = i;
    }

    public static int m25762b() {
        return f19058c;
    }

    public static void m25757a(long j) {
        f19059d = j;
    }

    public static long m25765c() {
        return f19059d;
    }

    public static void m25763b(int i) {
        f19060e = i;
    }

    public static int m25767d() {
        return f19060e;
    }

    public static void m25766c(int i) {
        f19061f = i;
    }

    public static int m25769e() {
        return f19061f;
    }

    public static void m25768d(int i) {
        f19057b = i;
    }

    public static int m25771f() {
        return f19057b;
    }

    public static void m25770e(int i) {
        f19062g = i;
    }

    public static int m25773g() {
        return f19062g;
    }

    public static void m25772f(int i) {
        f19063h = i;
    }

    public static int m25775h() {
        return f19063h;
    }

    public static void m25774g(int i) {
        f19064i = i;
    }

    public static int m25777i() {
        return f19064i;
    }

    public static void m25776h(int i) {
        f19065j = i;
    }

    public static int m25779j() {
        return f19065j;
    }

    public static List<byte[]> m25781k() {
        return f19066k;
    }

    public static List<Integer> m25783l() {
        return f19067l;
    }

    public static void m25778i(int i) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(28);
        deviceCommand.setCommandID(2);
        String a = a.a((long) i);
        String a2 = a.a(4);
        String a3 = a.a(127);
        ByteBuffer allocate = ByteBuffer.allocate(((a3.length() / 2) + (a2.length() / 2)) + (a.length() / 2));
        allocate.put(a.b(a3));
        allocate.put(a.b(a2));
        allocate.put(a.b(a));
        C5328e.m25798a(deviceCommand, allocate);
    }

    public static void m25780j(int i) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(28);
        deviceCommand.setCommandID(2);
        String a = a.a((long) i);
        String a2 = a.a(4);
        String a3 = a.a(127);
        ByteBuffer allocate = ByteBuffer.allocate(((a3.length() / 2) + (a2.length() / 2)) + (a.length() / 2));
        allocate.put(a.b(a3));
        allocate.put(a.b(a2));
        allocate.put(a.b(a));
        C5328e.m25798a(deviceCommand, allocate);
    }

    public static void m25760a(String str) {
        C2538c.b("FileServiceConsultUtil", new Object[]{"rsepSingleFile "});
        if (!C5329f.m25801a(C5328e.f19068a + str) || 0 == C5329f.m25800a(new File(C5328e.f19068a, str), (long) f19062g, f19058c)) {
            C5328e.m25796a(3, 100001);
            return;
        }
        C2538c.b("FileServiceConsultUtil", new Object[]{"rsepSingleFile size : " + C5329f.m25800a(new File(C5328e.f19068a, str), (long) f19062g, f19058c)});
        C5326c.m25758a(r0, 0);
    }

    public static void m25758a(long j, long j2) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(28);
        deviceCommand.setCommandID(3);
        String a = a.a(j);
        String a2 = a.a(a.length() / 2);
        String a3 = a.a(2);
        String a4 = a.a(j2);
        String a5 = a.a(a4.length() / 2);
        String a6 = a.a(3);
        ByteBuffer allocate = ByteBuffer.allocate((((((a3.length() / 2) + (a2.length() / 2)) + (a.length() / 2)) + (a6.length() / 2)) + (a5.length() / 2)) + (a4.length() / 2));
        allocate.put(a.b(a3));
        allocate.put(a.b(a2));
        allocate.put(a.b(a));
        allocate.put(a.b(a6));
        allocate.put(a.b(a5));
        allocate.put(a.b(a4));
        C5328e.m25798a(deviceCommand, allocate);
    }

    public static void m25764b(String str) {
        C2538c.c("FileServiceConsultUtil", new Object[]{"respStarSingleFile "});
        long a = C5329f.m25800a(new File(C5328e.f19069b, str), (long) f19062g, f19058c);
        if (!C5329f.m25801a(C5328e.f19069b + str) || 0 == a) {
            C5328e.m25796a(3, 100001);
            return;
        }
        C2538c.c("FileServiceConsultUtil", new Object[]{"respStarSingleFile size : " + a});
        C2538c.c("FileServiceConsultUtil", new Object[]{"respStarSingleFile allSize : " + f19062g});
        ByteBuffer allocate = ByteBuffer.allocate(f19062g);
        for (int i = 0; i < f19066k.size(); i++) {
            byte[] bArr = (byte[]) f19066k.get(i);
            C2538c.c("FileServiceConsultUtil", new Object[]{"respStarSingleFile 第" + (i + 1) + "包"});
            C2538c.c("FileServiceConsultUtil", new Object[]{"respStarSingleFile data.size : " + bArr.length});
            C2538c.c("FileServiceConsultUtil", new Object[]{"respStarSingleFile data : " + a.a(bArr)});
            allocate.put(bArr);
        }
        C5326c.m25759a(a, C5006j.m24045a(allocate.array()));
    }

    public static void m25759a(long j, byte[] bArr) {
        C2538c.c("FileServiceConsultUtil", new Object[]{"sendStarSingleFileInfor() filesize = " + j + " crc = " + C0973a.a(bArr)});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(28);
        deviceCommand.setCommandID(3);
        String a = a.a(j);
        String a2 = a.a(a.length() / 2);
        String a3 = a.a(2);
        String a4 = a.a(bArr);
        String a5 = a.a(a4.length() / 2);
        String a6 = a.a(3);
        ByteBuffer allocate = ByteBuffer.allocate((((((a3.length() / 2) + (a2.length() / 2)) + (a.length() / 2)) + (a6.length() / 2)) + (a5.length() / 2)) + (a4.length() / 2));
        allocate.put(a.b(a3));
        allocate.put(a.b(a2));
        allocate.put(a.b(a));
        allocate.put(a.b(a6));
        allocate.put(a.b(a5));
        allocate.put(a.b(a4));
        C5328e.m25798a(deviceCommand, allocate);
    }

    public static void m25782k(int i) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(28);
        deviceCommand.setCommandID(6);
        String a = a.a((long) i);
        String a2 = a.a(4);
        String a3 = a.a(127);
        ByteBuffer allocate = ByteBuffer.allocate(((a3.length() / 2) + (a2.length() / 2)) + (a.length() / 2));
        allocate.put(a.b(a3));
        allocate.put(a.b(a2));
        allocate.put(a.b(a));
        C5328e.m25798a(deviceCommand, allocate);
    }

    public static void m25784l(int i) {
        C2538c.b("FileServiceConsultUtil", new Object[]{"respResultNotification validity ： " + i});
        C5326c.m25782k(100000);
    }

    public static void m25785m() {
        C2538c.c("FileServiceConsultUtil", new Object[]{"initData()"});
        f19067l.clear();
        f19066k.clear();
        C5326c.m25756a(0);
        C5326c.m25757a(0);
        C5326c.m25763b(0);
        C5326c.m25766c(0);
        C5326c.m25768d(0);
        C5326c.m25770e(0);
        C5326c.m25772f(0);
        C5326c.m25774g(0);
        C5326c.m25776h(0);
    }
}
