package com.tencent.connect;

import android.content.Context;
import com.tencent.connect.common.C6245a;
import com.tencent.connect.common.C6287c;
import com.tencent.connect.p193b.C6284w;
import com.tencent.open.p532d.C6395h;
import com.tencent.open.p532d.C6396i;
import com.tencent.tauth.C6252b;
import org.apache.http.client.methods.HttpGet;

/* compiled from: ProGuard */
public class C6246a extends C6245a {
    public C6246a(Context context, C6284w c6284w) {
        super(c6284w);
    }

    public void m28716a(C6252b c6252b) {
        C6396i.m29198a(this.c, C6395h.m29184a(), "user/get_simple_userinfo", m28713c(), HttpGet.METHOD_NAME, new C6287c(this, c6252b));
    }
}
