package com.huawei.bone.root;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.ui.commonui.dialog.a;

/* compiled from: SplashActivity */
class ao implements OnClickListener {
    final /* synthetic */ IBaseResponseCallback f23313a;
    final /* synthetic */ a f23314b;
    final /* synthetic */ SplashActivity f23315c;

    ao(SplashActivity splashActivity, IBaseResponseCallback iBaseResponseCallback, a aVar) {
        this.f23315c = splashActivity;
        this.f23313a = iBaseResponseCallback;
        this.f23314b = aVar;
    }

    public void onClick(View view) {
        this.f23313a.onResponse(1, "");
        this.f23314b.dismiss();
    }
}
