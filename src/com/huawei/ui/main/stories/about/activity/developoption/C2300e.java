package com.huawei.ui.main.stories.about.activity.developoption;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: DevelopOptionActivity */
class C2300e implements IBaseResponseCallback {
    final /* synthetic */ DevelopOptionActivity f8360a;

    C2300e(DevelopOptionActivity developOptionActivity) {
        this.f8360a = developOptionActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12674b("DevelopOptionActivity", "copyLog err_code " + i);
        this.f8360a.f8352e.post(new C2301f(this, i));
    }
}
