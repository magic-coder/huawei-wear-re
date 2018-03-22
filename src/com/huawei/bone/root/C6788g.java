package com.huawei.bone.root;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.a;

/* compiled from: MainActivity */
class C6788g implements OnClickListener {
    final /* synthetic */ a f23326a;
    final /* synthetic */ MainActivity f23327b;

    C6788g(MainActivity mainActivity, a aVar) {
        this.f23327b = mainActivity;
        this.f23326a = aVar;
    }

    public void onClick(View view) {
        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"showHandleMigrateDialog on click"});
        this.f23326a.dismiss();
    }
}
