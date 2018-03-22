package com.huawei.hwid.openapi.p441b;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hwid.openapi.out.OutReturn;
import com.huawei.hwid.openapi.out.OutReturn.ParamStr;
import com.huawei.hwid.openapi.out.ResReqHandler;
import com.huawei.hwid.openapi.p440a.C5213b;
import com.huawei.hwid.openapi.p443d.C5236a;
import com.huawei.hwid.openapi.p445e.C5248c;
import com.huawei.hwid.openapi.p445e.p446a.C5243e;
import com.huawei.hwid.openapi.p445e.p447b.C5245a;

class C5228b extends Thread {
    private static String f18851d = C5213b.f18818a;
    Context f18852a = null;
    C5236a f18853b = null;
    ResReqHandler f18854c = null;

    C5228b(Context context, C5236a c5236a, ResReqHandler resReqHandler) {
        this.f18852a = context;
        this.f18853b = c5236a;
        this.f18854c = resReqHandler;
    }

    public void run() {
        try {
            Bundle a = this.f18853b.m25399a(C5245a.m25430a(this.f18852a, this.f18853b.m25405d()));
            if (this.f18853b.m25401a(a)) {
                a.putInt(ParamStr.RET_CODE, 1);
            } else {
                a.putInt(ParamStr.RET_CODE, 1000);
            }
            C5248c.m25445a(f18851d, "return info:" + C5243e.m25424a(a.getString(ParamStr.RET_RES_CONTENT), true));
            this.f18854c.finish(a);
        } catch (Throwable e) {
            Bundle bundle = new Bundle();
            C5248c.m25448b(f18851d, e.toString(), e);
            this.f18854c.finish(OutReturn.creatRunTimeErrRet(e.toString()));
        }
    }
}
