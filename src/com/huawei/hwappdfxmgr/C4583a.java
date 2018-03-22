package com.huawei.hwappdfxmgr;

import android.content.Context;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: HWAppDFXMgr */
public class C4583a extends a {
    private static final Object f16787a = new Object();
    private static C4583a f16788d;
    private ExecutorService f16789b = Executors.newSingleThreadExecutor();
    private Context f16790c;

    private C4583a(Context context) {
        super(context);
        this.f16790c = context;
    }

    public static C4583a m21852a(Context context) {
        C4583a c4583a;
        synchronized (f16787a) {
            if (f16788d == null) {
                f16788d = new C4583a(BaseApplication.b());
            }
            c4583a = f16788d;
        }
        return c4583a;
    }

    protected Integer getModuleId() {
        return Integer.valueOf(1001);
    }

    public void m21854a(boolean z) {
        C2538c.b("HWAppDFXMgr", new Object[]{"startUploadLogFile"});
        this.f16789b.execute(new C4585b(this, z));
    }

    public boolean m21855a() {
        C2538c.c("HWAppDFXMgr", new Object[]{"getDevelopOptionInSharePreference enter " + getSharedPreference("KEY_LOG_UPDATE_ENABLE_FLAG")});
        if ("false".equals(getSharedPreference("KEY_LOG_UPDATE_ENABLE_FLAG"))) {
            return false;
        }
        return true;
    }

    public void m21856b(boolean z) {
        C2538c.c("HWAppDFXMgr", new Object[]{"setDevelopOptionInSharePreference enter flag " + z});
        setSharedPreference("KEY_LOG_UPDATE_ENABLE_FLAG", String.valueOf(z), null);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void m21853a(IBaseResponseCallback iBaseResponseCallback) {
        this.f16789b.execute(new C4588c(this, iBaseResponseCallback));
    }
}
