package com.huawei.hwservicesmgr.p076a.p078b.p459a;

import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.hwdevicemgr.p073a.C1023c;
import com.huawei.p190v.C2538c;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FileServiceUtil */
public class C5328e {
    public static final String f19068a = (BaseApplication.b().getFilesDir() + "/fileShare/");
    public static final String f19069b = (BaseApplication.b().getFilesDir() + File.separator);

    public static List<String> m25794a(File file, String str) {
        if (file == null || str == null) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        if (!file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return null;
        }
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].getName().contains(str)) {
                arrayList.add(listFiles[i].getName());
            }
        }
        return arrayList;
    }

    public static void m25797a(int i, int i2, String str, String str2) {
        C2538c.b("FileServiceUtil", new Object[]{"repSendFilelist "});
        List a = C5328e.m25794a(new File(f19068a), str);
        if (a != null && i == 0) {
            C5328e.m25799a(a);
        } else if (1 == i) {
            C5328e.m25795a();
        } else {
            C5328e.m25796a(1, 100001);
        }
    }

    public static void m25799a(List<String> list) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(28);
        deviceCommand.setCommandID(1);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append((String) list.get(i)).append(";");
        }
        String e = C0973a.e(stringBuffer.substring(0, stringBuffer.length() - 1));
        String e2 = C0973a.e(e.length() / 2);
        String a = a.a(1);
        ByteBuffer allocate = ByteBuffer.allocate(((a.length() / 2) + (e2.length() / 2)) + (e.length() / 2));
        allocate.put(a.b(a));
        allocate.put(a.b(e2));
        allocate.put(a.b(e));
        C5328e.m25798a(deviceCommand, allocate);
    }

    public static void m25795a() {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(28);
        deviceCommand.setCommandID(1);
        String e = C0973a.e("gpslocation.dat");
        String e2 = C0973a.e(e.length() / 2);
        String a = a.a(1);
        ByteBuffer allocate = ByteBuffer.allocate(((a.length() / 2) + (e2.length() / 2)) + (e.length() / 2));
        allocate.put(a.b(a));
        allocate.put(a.b(e2));
        allocate.put(a.b(e));
        C5328e.m25798a(deviceCommand, allocate);
    }

    public static void m25796a(int i, int i2) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(28);
        deviceCommand.setCommandID(i);
        String a = a.a((long) i2);
        String a2 = a.a(4);
        String a3 = a.a(127);
        ByteBuffer allocate = ByteBuffer.allocate(((a3.length() / 2) + (a2.length() / 2)) + (a.length() / 2));
        allocate.put(a.b(a3));
        allocate.put(a.b(a2));
        allocate.put(a.b(a));
        C5328e.m25798a(deviceCommand, allocate);
    }

    public static void m25798a(DeviceCommand deviceCommand, ByteBuffer byteBuffer) {
        deviceCommand.setDataLen(byteBuffer.array().length);
        deviceCommand.setDataContent(byteBuffer.array());
        C1023c.a(BaseApplication.b()).b(deviceCommand);
    }
}
