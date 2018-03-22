package com.huawei.android.pushagent.p017a;

public class C4060c extends Exception {
    public C4059a f15390a;

    public enum C4059a {
        Err_unKnown,
        Err_Device,
        Err_Connect,
        Err_Read
    }

    public C4060c() {
        this.f15390a = C4059a.Err_unKnown;
    }

    public C4060c(String str) {
        super(str);
        this.f15390a = C4059a.Err_unKnown;
    }

    public C4060c(String str, C4059a c4059a) {
        this(str);
        this.f15390a = c4059a;
    }

    public C4060c(Throwable th) {
        super(th);
        this.f15390a = C4059a.Err_unKnown;
    }

    public C4060c(Throwable th, C4059a c4059a) {
        this(th);
        this.f15390a = c4059a;
    }
}
