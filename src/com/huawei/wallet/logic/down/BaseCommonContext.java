package com.huawei.wallet.logic.down;

import android.content.Context;
import com.huawei.wallet.utils.log.LogC;

public final class BaseCommonContext {
    private static BaseCommonContext f21222b;
    private Context f21223a = null;

    private BaseCommonContext() {
    }

    public static BaseCommonContext m28012a() {
        if (f21222b == null) {
            f21222b = new BaseCommonContext();
        }
        return f21222b;
    }

    public void m28013a(Context context) {
        if (this.f21223a != null) {
            LogC.m28527a("initBackGround applicationContext init not null!", false);
        } else if (context != null) {
            this.f21223a = context.getApplicationContext();
        } else {
            LogC.m28534d("initBackGround applicationContext init failed! context==null", false);
        }
    }
}
