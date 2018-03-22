package com.huawei.pluginkidwatch.common.entity.p144d;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.hwcloudmodel.c.p;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.p140b.C1418a;
import com.huawei.pluginkidwatch.common.lib.p145d.C1469a;
import com.huawei.pluginkidwatch.common.lib.p145d.C1477j;
import java.util.Locale;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: RestfulService */
public final class C1457c {
    private Context f3348a;
    private Handler f3349b;
    private Handler f3350c = new Handler(Looper.getMainLooper());
    private ThreadPoolExecutor f3351d = C1477j.m6804a();
    private C1469a f3352e = new C1469a(this.f3348a);

    public C1457c(Context context) {
        this.f3348a = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("HwCloudManager");
        handlerThread.start();
        this.f3349b = new C1461g(this, handlerThread.getLooper());
    }

    public static String m6701a() {
        return "https://api.vmall.com";
    }

    public void m6709a(C1418a c1418a, C1378e c1378e) {
        C2538c.m12674b("RestfulService", "Enter post");
        String str = C1457c.m6701a() + c1418a.f3234a;
        String a = c1418a.mo2512a();
        Message obtainMessage = this.f3349b.obtainMessage();
        obtainMessage.what = 500002;
        obtainMessage.obj = c1378e;
        Bundle bundle = new Bundle();
        bundle.putSerializable("builder", c1418a);
        bundle.putString("url", str);
        bundle.putString("params", a);
        obtainMessage.setData(bundle);
        C2538c.m12674b("RestfulService", "send to target");
        obtainMessage.sendToTarget();
    }

    private void m6706a(BaseEntityModel baseEntityModel, String str, C1378e c1378e, C1418a c1418a) {
        if (baseEntityModel != null) {
            C2538c.m12674b("RestfulService", "post, normally result.retCode:" + baseEntityModel.retCode);
            m6705a(c1378e, baseEntityModel);
        }
    }

    private void m6707a(String str, String str2, C1378e c1378e, C1418a c1418a) {
        C2538c.m12680e("RestfulService", "Enter sendPost");
        this.f3352e.m6795a(str, str2, c1418a.f3235b, new C1458d(this, str, str2, c1418a, c1378e));
    }

    private void m6705a(C1378e c1378e, BaseEntityModel baseEntityModel) {
        this.f3350c.post(new C1460f(this, c1378e, baseEntityModel));
        if (baseEntityModel.retCode == -1 && baseEntityModel.error != null && baseEntityModel.error.toLowerCase(Locale.ENGLISH).indexOf("session") > -1) {
            String f = C1093a.m4739a(BaseApplication.m2632b()).m4753f();
            C2538c.m12674b("RestfulService", "session expire,mContext=" + this.f3348a + ",tokenBefore=" + f);
            new p(this.f3348a).c();
            f = C1093a.m4739a(BaseApplication.m2632b()).m4753f();
            C2538c.m12674b("RestfulService", "session fresh,tokenAfter=" + f);
        }
    }
}
