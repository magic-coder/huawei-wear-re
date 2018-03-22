package com.huawei.android.pushselfshow.p338c;

import android.content.Context;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushselfshow.p337b.C4149a;
import com.huawei.android.pushselfshow.richpush.p344d.C4195c;
import com.huawei.android.pushselfshow.richpush.p344d.C4197e;
import com.huawei.android.pushselfshow.utils.C4203a;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;

public class C4156e extends Thread {
    private Context f15620a;
    private C4149a f15621b;

    public C4156e(Context context, C4149a c4149a) {
        this.f15620a = context;
        this.f15621b = c4149a;
    }

    public boolean m20286a(Context context) {
        return "cosa".equals(this.f15621b.f15593o) ? m20287b(context) : "email".equals(this.f15621b.f15593o) ? m20288c(context) : "rp".equals(this.f15621b.f15593o) ? m20289d(context) : true;
    }

    public boolean m20287b(Context context) {
        if (C4203a.m20432b(context, this.f15621b.f15604z)) {
            return true;
        }
        C4203a.m20424a(context, "4", this.f15621b);
        return false;
    }

    public boolean m20288c(Context context) {
        if (C4203a.m20435c(context)) {
            return true;
        }
        C4203a.m20424a(context, "15", this.f15621b);
        return false;
    }

    public boolean m20289d(Context context) {
        if (this.f15621b.f15562C == null || this.f15621b.f15562C.length() == 0) {
            C4203a.m20424a(context, "6", this.f15621b);
            e.a("PushSelfShowLog", "ilegle richpush param ,rpl is null");
            return false;
        }
        e.a("PushSelfShowLog", "rpl is " + this.f15621b.f15562C);
        if ("application/zip".equals(this.f15621b.f15564E) || this.f15621b.f15562C.endsWith(LightCloudConstants.ZIP_POSTFIX)) {
            this.f15621b.f15564E = "application/zip";
            if (this.f15621b.f15587i == 1) {
                String a = new C4197e().m20387a(context, this.f15621b.f15562C, this.f15621b.f15588j, C4195c.m20382a("application/zip"));
                if (a != null && a.length() > 0) {
                    this.f15621b.f15562C = a;
                    this.f15621b.f15564E = "application/zip_local";
                }
                e.a("PushSelfShowLog", "Download first ,the localfile" + a);
            }
            return true;
        } else if ("text/html".equals(this.f15621b.f15564E) || this.f15621b.f15562C.endsWith(".html")) {
            this.f15621b.f15564E = "text/html";
            return true;
        } else {
            e.a("PushSelfShowLog", "unknow rpl type");
            C4203a.m20424a(context, "6", this.f15621b);
            return false;
        }
    }

    public void run() {
        e.a("PushSelfShowLog", "enter run()");
        try {
            if (m20286a(this.f15620a)) {
                C4153b.m20270a(this.f15620a, this.f15621b);
            }
        } catch (Exception e) {
        }
        super.run();
    }
}
