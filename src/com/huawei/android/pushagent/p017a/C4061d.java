package com.huawei.android.pushagent.p017a;

import com.huawei.android.pushagent.p020b.p021a.p327b.C4078b.C4080a;

public class C4061d {
    public String f15391a;
    public int f15392b;
    public C4080a f15393c;
    public boolean f15394d;

    public C4061d(String str, int i, boolean z, C4080a c4080a) {
        this.f15391a = str;
        this.f15392b = i;
        this.f15394d = z;
        this.f15393c = c4080a;
    }

    public String toString() {
        return new StringBuffer().append("ip:").append(this.f15391a).append(" port:").append(this.f15392b).append(" useProxy:").append(this.f15394d).append(" conType").append(this.f15393c).toString();
    }
}
