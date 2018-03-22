package com.huawei.membercenter.sdk.membersdklibrary.p094b.p095a;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.Gson;
import com.huawei.membercenter.sdk.membersdklibrary.a.c.a;
import com.huawei.membercenter.sdk.membersdklibrary.b.a.d;

/* compiled from: ActiveMemberHttpProcessor */
public class C5491b extends C5490a {
    private Bundle f19356c;

    public C5491b(Context context, Bundle bundle) {
        super("https://ccpc-cn.consumer.huawei.com/ccpcmd/services/dispatch/anonymous/CCPC/EN/ccpcme/activateLeaguerForSdk/1", context);
        this.f19356c = bundle;
    }

    protected Object mo4700a(Context context) {
        return new a(this.f19356c, context);
    }

    protected d mo4699a(String str) {
        return (d) new Gson().fromJson(str, d.class);
    }

    protected boolean mo4701b() {
        return true;
    }
}
