package com.huawei.hwservicesmgr.p076a.p078b.p459a;

import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.p190v.C2538c;

import java.nio.ByteBuffer;

/* compiled from: FileApplicationUtil */
public class C5324a {
    private static Handler f19055a = null;

    public static void m25743a() {
        HandlerThread handlerThread = new HandlerThread("HWFileServicesManager");
        handlerThread.start();
        f19055a = new C5325b(handlerThread.getLooper());
    }

    private static void m25751b(byte[] bArr, int i) {
        C2538c.c("FileApplicationUtil", new Object[]{"sendStarFileData sendIndex  = " + i + " offset = " + C5326c.m25775h()});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(28);
        deviceCommand.setCommandID(5);
        String a = a.a(i - C5326c.m25775h());
        String a2 = a.a(bArr);
        ByteBuffer allocate = ByteBuffer.allocate((a.length() / 2) + (a2.length() / 2));
        allocate.put(a.b(a));
        allocate.put(a.b(a2));
        C5328e.m25798a(deviceCommand, allocate);
    }

    private static byte[] m25754c() {
        C2538c.c("FileApplicationUtil", new Object[]{" getCutData fileInfoList size:" + C5326c.m25781k().size() + " ; indexList.size = " + C5326c.m25783l().size()});
        if (C5326c.m25779j() >= C5326c.m25783l().size()) {
            return new byte[0];
        }
        int intValue = ((Integer) C5326c.m25783l().get(C5326c.m25779j())).intValue();
        if (intValue < C5326c.m25781k().size()) {
            return (byte[]) C5326c.m25781k().get(intValue);
        }
        return new byte[0];
    }

    public static void m25747a(String str, String str2, int i, long j) {
        C2538c.c("FileApplicationUtil", new Object[]{"respApplicationData fileName = " + str + " fileBitmap = " + str2 + " offset = " + i + " transSize = " + C5326c.m25762b()});
        if (i == 0) {
            C5326c.m25772f(0);
            C5324a.m25744a(C5326c.m25777i());
        } else if (C5326c.m25762b() == 0) {
            C5326c.m25772f(0);
        } else {
            C5326c.m25772f(Math.abs(i / C5326c.m25762b()));
        }
        String str3 = "";
        if (C5326c.m25769e() == 0) {
            str3 = C5328e.f19068a;
        } else if (1 == C5326c.m25769e()) {
            str3 = C5328e.f19069b;
        }
        if (C5329f.m25801a(str3 + str)) {
            C2538c.c("FileApplicationUtil", new Object[]{"respApplicationData fileType = " + C5326c.m25769e()});
            if (C5326c.m25769e() == 0) {
                C5324a.m25746a(str, (long) i);
                C5324a.m25745a(C5328e.f19068a + str);
                return;
            } else if (1 == C5326c.m25769e()) {
                C5324a.m25750b(str, (long) i);
                C2538c.c("FileApplicationUtil", new Object[]{"respApplicationData fileBitmap = " + str2});
                if ("".equals(str2) || "FF".equals(str2)) {
                    C2538c.c("FileApplicationUtil", new Object[]{"respApplicationData index = " + C5326c.m25777i()});
                    if (i != 0) {
                        int b = (i / C5326c.m25762b()) / C5326c.m25771f();
                        C2538c.c("FileApplicationUtil", new Object[]{"respApplicationData index_change = " + b});
                        C5326c.m25774g(b);
                        C5324a.m25744a(b);
                    }
                } else {
                    C5324a.m25749b(str2);
                    f19055a.removeMessages(1);
                }
                f19055a.sendEmptyMessageDelayed(1, (long) C5326c.m25767d());
                return;
            } else {
                return;
            }
        }
        C5328e.m25796a(4, 100001);
    }

    private static void m25744a(int i) {
        int i2;
        int g;
        C2538c.c("FileApplicationUtil", new Object[]{"initIndexList nums = " + i + " maxDataSize = " + C5326c.m25765c() + " transSize = " + C5326c.m25762b() + " offset = " + C5326c.m25775h() + " allSize = " + C5326c.m25773g() + " sendNum = " + C5326c.m25771f()});
        C5326c.m25783l().clear();
        if (0 == C5326c.m25765c() || C5326c.m25762b() == 0) {
            i2 = 1;
        } else {
            g = C5326c.m25773g() - (C5326c.m25762b() * C5326c.m25775h());
            C2538c.c("FileApplicationUtil", new Object[]{"initIndexList numLess = " + g});
            C2538c.c("FileApplicationUtil", new Object[]{"initIndexList (transSize * sendNum) = " + (C5326c.m25762b() * C5326c.m25771f())});
            if (g >= C5326c.m25762b() * C5326c.m25771f()) {
                i2 = (int) (C5326c.m25765c() / ((long) C5326c.m25762b()));
            } else {
                i2 = g / C5326c.m25762b();
                if (g % C5326c.m25762b() != 0) {
                    i2++;
                }
            }
        }
        C2538c.c("FileApplicationUtil", new Object[]{"initIndexList num = " + i2});
        for (g = 0; g < i2; g++) {
            C5326c.m25783l().add(Integer.valueOf((C5326c.m25771f() * i) + g));
        }
        C2538c.c("FileApplicationUtil", new Object[]{"initIndexList indexList.size() = " + C5326c.m25783l().size()});
    }

    private static void m25749b(String str) {
        C5326c.m25783l().clear();
        C2538c.c("FileApplicationUtil", new Object[]{"getBitmapInfo() num = " + (str.length() / 2)});
        for (int i = 0; i < r3; i++) {
            C2538c.c("FileApplicationUtil", new Object[]{"getBitmapInfo() info" + (i + 1) + " = " + Integer.toBinaryString(Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16))});
            C2538c.c("FileApplicationUtil", new Object[]{"getBitmapInfo() info" + (i + 1) + " = " + C5324a.m25753c(r0)});
            String stringBuffer = new StringBuffer(r0).reverse().toString();
            C2538c.c("FileApplicationUtil", new Object[]{" getBitmapInfo() bitmap" + (i + 1) + " = " + stringBuffer});
            int i2 = 0;
            while (i2 < stringBuffer.length()) {
                if ('0' == stringBuffer.charAt(i2) && i2 >= 0 && i2 <= 7) {
                    C5326c.m25783l().add(Integer.valueOf((C5326c.m25775h() + (C5326c.m25771f() * i)) + i2));
                }
                i2++;
            }
        }
    }

    private static String m25753c(String str) {
        String str2 = "";
        if (8 <= str.length()) {
            return str;
        }
        int length = 8 - str.length();
        for (int i = 0; i < length; i++) {
            str2 = '0' + str2;
        }
        return str2 + str;
    }

    public static void m25746a(String str, long j) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(28);
        deviceCommand.setCommandID(4);
        String e = C0973a.e(str);
        String a = a.a(e.length() / 2);
        String a2 = a.a(2);
        String a3 = a.a(j);
        String a4 = a.a(a3.length() / 2);
        String a5 = a.a(3);
        ByteBuffer allocate = ByteBuffer.allocate((((((a2.length() / 2) + (a.length() / 2)) + (e.length() / 2)) + (a5.length() / 2)) + (a4.length() / 2)) + (a3.length() / 2));
        allocate.put(a.b(a2));
        allocate.put(a.b(a));
        allocate.put(a.b(e));
        allocate.put(a.b(a5));
        allocate.put(a.b(a4));
        allocate.put(a.b(a3));
        C5328e.m25798a(deviceCommand, allocate);
    }

    public static void m25750b(String str, long j) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(28);
        deviceCommand.setCommandID(4);
        String a = a.a(100000);
        String a2 = a.a(4);
        String a3 = a.a(127);
        String e = a.e(str);
        String a4 = a.a(e.length() / 2);
        String a5 = a.a(2);
        String a6 = a.a(j);
        String a7 = a.a(a6.length() / 2);
        String a8 = a.a(3);
        ByteBuffer allocate = ByteBuffer.allocate(((((((((a3.length() / 2) + (a2.length() / 2)) + (a.length() / 2)) + (a5.length() / 2)) + (a4.length() / 2)) + (e.length() / 2)) + (a8.length() / 2)) + (a7.length() / 2)) + (a6.length() / 2));
        allocate.put(a.b(a3));
        allocate.put(a.b(a2));
        allocate.put(a.b(a));
        allocate.put(a.b(a5));
        allocate.put(a.b(a4));
        allocate.put(a.b(e));
        allocate.put(a.b(a8));
        allocate.put(a.b(a7));
        allocate.put(a.b(a6));
        C5328e.m25798a(deviceCommand, allocate);
    }

    public static void m25745a(String str) {
        C2538c.c("FileApplicationUtil", new Object[]{" enter sendAWFilePath"});
        C2538c.c("FileApplicationUtil", new Object[]{"sendFilePath path : " + str});
        if (!C5329f.m25801a(str)) {
            C2538c.c("FileApplicationUtil", new Object[]{"the file not exists !"});
        } else if ("ANDROID_WEAR".equals(C5326c.m25755a())) {
            C2538c.c("FileApplicationUtil", new Object[]{"start sendAWFilePath"});
            C1023c.a(BaseApplication.b()).a(str);
        }
    }
}
