package com.huawei.pluginkidwatch.common.entity.p144d;

import android.os.Bundle;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/* compiled from: RestfulService */
class C1459e implements Runnable {
    final /* synthetic */ Object f3358a;
    final /* synthetic */ C1458d f3359b;

    C1459e(C1458d c1458d, Object obj) {
        this.f3359b = c1458d;
        this.f3358a = obj;
    }

    public void run() {
        String str;
        String str2 = "";
        try {
            str = new String((byte[]) this.f3358a, GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            C2538c.m12680e("RestfulService", "" + e.getMessage());
            str = str2;
        }
        C2538c.m12674b("RestfulService", "post return:  url:", this.f3359b.f3353a, "\n  strBody: ", this.f3359b.f3354b, "\n response:", str);
        try {
            Serializable a = this.f3359b.f3355c.mo2511a(str);
            Message obtainMessage = this.f3359b.f3357e.f3349b.obtainMessage();
            obtainMessage.what = 500001;
            obtainMessage.obj = this.f3359b.f3356d;
            Bundle bundle = new Bundle();
            bundle.putSerializable("entity", a);
            bundle.putSerializable("builder", this.f3359b.f3355c);
            bundle.putString("url", this.f3359b.f3353a);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        } catch (Exception e2) {
            C2538c.m12680e("RestfulService", "" + e2.getMessage());
        }
    }
}
