package com.tencent.wxop.stat.p547b;

import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

final class C6518m {
    static int m29771a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C6519n()).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    static int m29772b() {
        int i = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            str = str.trim();
            if (str.length() > 0) {
                i = Integer.valueOf(str).intValue();
            }
        } catch (Throwable e) {
            C6517l.f22721k.m29705b(e);
        }
        return i * 1000;
    }

    static int m29773c() {
        int i = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            str = str.trim();
            if (str.length() > 0) {
                i = Integer.valueOf(str).intValue();
            }
        } catch (Throwable th) {
            C6517l.f22721k.m29705b(th);
        }
        return i * 1000;
    }

    static String m29774d() {
        int i = 2;
        String[] strArr = new String[]{"", ""};
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            String[] split = bufferedReader.readLine().split("\\s+");
            while (i < split.length) {
                strArr[0] = strArr[0] + split[i] + HwAccountConstants.BLANK;
                i++;
            }
            bufferedReader.close();
        } catch (IOException e) {
        }
        return strArr[0];
    }
}
