package com.tencent.stat.p545b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

class C6464n {
    C6464n() {
    }

    static int m29485a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C6465o()).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    static int m29486b() {
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
        } catch (Exception e) {
            C6463m.f22435f.m29406b(e);
        }
        return i * 1000;
    }

    static int m29487c() {
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
        } catch (Exception e) {
            C6463m.f22435f.m29406b(e);
        }
        return i * 1000;
    }

    static String m29488d() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            String[] split = bufferedReader.readLine().split(":\\s+", 2);
            for (int i = 0; i < split.length; i++) {
            }
            bufferedReader.close();
            return split[1];
        } catch (Throwable th) {
            C6463m.f22435f.m29411f(th);
            return "";
        }
    }
}
