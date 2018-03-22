package com.huawei.up.p520e;

import com.huawei.hwid.core.constants.HwAccountConstants;

/* compiled from: NSPException */
public class C6133g extends Exception {
    private int f21189a;

    public C6133g(int i, String str) {
        super(i + HwAccountConstants.BLANK + str);
        this.f21189a = i;
    }

    public C6133g(int i, String str, Exception exception) {
        super(i + HwAccountConstants.BLANK + str, exception);
        this.f21189a = i;
    }

    public int m27917a() {
        return this.f21189a;
    }
}
