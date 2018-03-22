package com.huawei.android.pushselfshow;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.utils.C4203a;
import com.huawei.android.pushselfshow.utils.p345a.C4199a;
import com.huawei.android.pushselfshow.utils.p346b.C4205b;
import java.io.File;
import java.util.ArrayList;

class C4151b extends Thread {
    Context f15606a;
    String f15607b;

    public C4151b(Context context, String str) {
        this.f15606a = context;
        this.f15607b = str;
    }

    public void run() {
        ArrayList a = C4199a.m20394a(this.f15606a, this.f15607b);
        int size = a.size();
        e.e("PushSelfShowLog", "receive package add ,arrSize " + size);
        for (int i = 0; i < size; i++) {
            C4203a.m20425a(this.f15606a, "16", (String) a.get(i), "app");
        }
        if (size > 0) {
            C4199a.m20396b(this.f15606a, this.f15607b);
        }
        C4203a.m20430b(new File(C4205b.m20446a(this.f15606a)));
    }
}
