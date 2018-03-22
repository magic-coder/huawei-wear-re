package com.huawei.pluginkidwatch.plugin.setting.qrcode.decoding;

import com.google.zxing.a;
import java.util.Vector;
import java.util.regex.Pattern;

/* compiled from: DecodeFormatManager */
public final class C1963j {
    public static final Vector<a> f6814a = new Vector(5);
    public static final Vector<a> f6815b = new Vector(f6814a.size() + 4);
    public static final Vector<a> f6816c = new Vector(1);
    public static final Vector<a> f6817d = new Vector(1);
    private static final Pattern f6818e = Pattern.compile(",");

    static {
        f6814a.add(a.o);
        f6814a.add(a.p);
        f6814a.add(a.h);
        f6814a.add(a.g);
        f6814a.add(a.m);
        f6815b.addAll(f6814a);
        f6815b.add(a.c);
        f6815b.add(a.d);
        f6815b.add(a.e);
        f6815b.add(a.i);
        f6816c.add(a.l);
        f6817d.add(a.f);
    }
}
