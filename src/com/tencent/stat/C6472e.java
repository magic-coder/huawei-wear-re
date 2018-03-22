package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.p545b.C6452b;
import com.tencent.stat.p545b.C6463m;
import com.tencent.stat.p545b.C6468r;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashSet;

public class C6472e {
    static C6472e f22480a = new C6472e();
    private static C6452b f22481b = C6463m.m29449b();
    private static boolean f22482d;
    private static boolean f22483e = false;
    private static String f22484f = null;
    private volatile boolean f22485c = false;

    static {
        f22482d = false;
        try {
            System.loadLibrary("MtaNativeCrash");
        } catch (Throwable th) {
            f22482d = false;
            f22481b.m29409d(th);
        }
    }

    public static String m29546a(Context context) {
        if (f22484f == null) {
            f22484f = C6468r.m29493a(context, "__mta_tombstone__", "");
        }
        return f22484f;
    }

    static String m29547a(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
                stringBuilder.append('\n');
            }
            bufferedReader.close();
        } catch (Exception e) {
            f22481b.m29406b(e);
        }
        return stringBuilder.toString();
    }

    static long m29548b(File file) {
        long j = 0;
        try {
            j = Long.valueOf(file.getName().replace("tombstone_", "")).longValue();
        } catch (Exception e) {
            f22481b.m29406b(e);
        }
        return j;
    }

    static LinkedHashSet<File> m29549b(Context context) {
        LinkedHashSet<File> linkedHashSet = new LinkedHashSet();
        String a = C6472e.m29546a(context);
        if (a != null) {
            File file = new File(a);
            if (file != null && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.getName().startsWith("tombstone_") && file2.isFile()) {
                            f22481b.m29413h("get tombstone file:" + file2.getAbsolutePath().toString());
                            linkedHashSet.add(file2.getAbsoluteFile());
                        }
                    }
                }
            }
        }
        return linkedHashSet;
    }
}
