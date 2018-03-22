package com.tencent.open.p541a;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: ProGuard */
public class C6355b {
    private static SimpleDateFormat f22111a = C6365l.m29101a("yyyy-MM-dd");
    private static FileFilter f22112b = new C6356c();
    private String f22113c = "Tracer.File";
    private int f22114d = Integer.MAX_VALUE;
    private int f22115e = Integer.MAX_VALUE;
    private int f22116f = 4096;
    private long f22117g = 10000;
    private File f22118h;
    private int f22119i = 10;
    private String f22120j = ".log";
    private long f22121k = Long.MAX_VALUE;
    private FileFilter f22122l = new C6357d(this);
    private Comparator<? super File> f22123m = new C6358e(this);

    public static long m29062a(File file) {
        try {
            return f22111a.parse(file.getName()).getTime();
        } catch (Exception e) {
            return -1;
        }
    }

    public C6355b(File file, int i, int i2, int i3, String str, long j, int i4, String str2, long j2) {
        m29080c(file);
        m29073b(i);
        m29069a(i2);
        m29078c(i3);
        m29070a(str);
        m29074b(j);
        m29082d(i4);
        m29075b(str2);
        m29079c(j2);
    }

    public File m29067a() {
        return m29064d(System.currentTimeMillis());
    }

    private File m29064d(long j) {
        return m29065e(m29068a(j));
    }

    public File m29068a(long j) {
        File file = new File(m29085g(), f22111a.format(Long.valueOf(j)));
        file.mkdirs();
        return file;
    }

    private File m29065e(File file) {
        File[] b = m29076b(file);
        if (b == null || b.length == 0) {
            return new File(file, "1" + m29087i());
        }
        m29071a(b);
        File file2 = b[b.length - 1];
        int length = b.length - m29083e();
        if (((int) file2.length()) > m29081d()) {
            file2 = new File(file, (C6355b.m29066f(file2) + 1) + m29087i());
            length++;
        }
        for (int i = 0; i < length; i++) {
            b[i].delete();
        }
        return file2;
    }

    public File[] m29076b(File file) {
        return file.listFiles(this.f22122l);
    }

    public void m29072b() {
        if (m29085g() != null) {
            File[] listFiles = m29085g().listFiles(f22112b);
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (System.currentTimeMillis() - C6355b.m29062a(file) > m29088j()) {
                        C6362i.m29091a(file);
                    }
                }
            }
        }
    }

    public File[] m29071a(File[] fileArr) {
        Arrays.sort(fileArr, this.f22123m);
        return fileArr;
    }

    private static int m29066f(File file) {
        try {
            String name = file.getName();
            return Integer.parseInt(name.substring(0, name.indexOf(46)));
        } catch (Exception e) {
            return -1;
        }
    }

    public String m29077c() {
        return this.f22113c;
    }

    public void m29070a(String str) {
        this.f22113c = str;
    }

    public int m29081d() {
        return this.f22114d;
    }

    public void m29069a(int i) {
        this.f22114d = i;
    }

    public int m29083e() {
        return this.f22115e;
    }

    public void m29073b(int i) {
        this.f22115e = i;
    }

    public int m29084f() {
        return this.f22116f;
    }

    public void m29078c(int i) {
        this.f22116f = i;
    }

    public void m29074b(long j) {
        this.f22117g = j;
    }

    public File m29085g() {
        return this.f22118h;
    }

    public void m29080c(File file) {
        this.f22118h = file;
    }

    public int m29086h() {
        return this.f22119i;
    }

    public void m29082d(int i) {
        this.f22119i = i;
    }

    public String m29087i() {
        return this.f22120j;
    }

    public void m29075b(String str) {
        this.f22120j = str;
    }

    public long m29088j() {
        return this.f22121k;
    }

    public void m29079c(long j) {
        this.f22121k = j;
    }
}
