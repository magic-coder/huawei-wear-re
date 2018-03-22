package com.huawei.membercenter.sdk.membersdklibrary.p094b.p095a;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.Gson;
import com.huawei.membercenter.sdk.membersdklibrary.a.c.b;
import com.huawei.membercenter.sdk.membersdklibrary.b.a.d;

/* compiled from: QueryMemberStatusHttpProcessor */
public class C5492c extends C5490a {
    private Bundle f19357c;

    public C5492c(Context context, Bundle bundle) {
        super("https://ccpc-cn.consumer.huawei.com/ccpcmd/services/dispatch/anonymous/CCPC/EN/ccpcme/queryLeaguerStatusForApp/1", context);
        this.f19357c = bundle;
    }

    protected Object mo4700a(Context context) {
        return new b(this.f19357c, context);
    }

    protected d mo4699a(String str) {
        return (d) new Gson().fromJson(str, d.class);
    }

    protected boolean mo4701b() {
        return true;
    }
}
