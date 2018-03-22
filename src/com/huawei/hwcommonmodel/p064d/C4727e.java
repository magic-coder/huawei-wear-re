package com.huawei.hwcommonmodel.p064d;

/* compiled from: EnglishMetricConversionUtil */
public class C4727e {
    public static int m22621a(int i, int i2) {
        return (i * 12) + i2;
    }

    public static int m22620a(int i) {
        return C4727e.m22622b(C4727e.m22626e(i));
    }

    public static int m22622b(int i) {
        return i / 12;
    }

    public static int m22624c(int i) {
        return i - (C4727e.m22622b(i) * 12);
    }

    public static int m22625d(int i) {
        return C4727e.m22624c(C4727e.m22626e(i));
    }

    public static int m22623b(int i, int i2) {
        return (int) ((((double) i) * 30.48d) + (((double) i2) * 2.54d));
    }

    public static int m22626e(int i) {
        return (int) Math.round(((double) i) / 2.54d);
    }

    public static int m22627f(int i) {
        return (int) Math.round(((double) i) * 0.45359d);
    }

    public static int m22628g(int i) {
        return (int) Math.round(((double) i) / 0.45359d);
    }
}
