package com.huawei.hwappdfxmgr.p398c;

import com.huawei.feedback.FeedbackApi;
import com.huawei.hwappdfxmgr.p056f.C4594e;
import com.huawei.p190v.C2538c;

import java.io.File;
import java.util.List;

/* compiled from: HWFeedbackApi */
class C4587b implements Runnable {
    final /* synthetic */ List f16797a;
    final /* synthetic */ File f16798b;
    final /* synthetic */ String f16799c;
    final /* synthetic */ C4586a f16800d;

    C4587b(C4586a c4586a, List list, File file, String str) {
        this.f16800d = c4586a;
        this.f16797a = list;
        this.f16798b = file;
        this.f16799c = str;
    }

    public void run() {
        try {
            C4594e.m21888a(this.f16797a, this.f16798b, "", "");
        } catch (Exception e) {
            C2538c.e("HWFeedbackApi", new Object[]{e.getMessage()});
        }
        FeedbackApi.aesEncryptFile(this.f16798b, this.f16799c, this.f16800d.f16795a);
        if (this.f16798b.exists()) {
            try {
                if (this.f16798b.delete()) {
                    C2538c.b("HWFeedbackApi", new Object[]{"文件删除成功"});
                }
            } catch (Exception e2) {
                C2538c.b("HWFeedbackApi", new Object[]{e2.getMessage()});
            }
        }
    }
}
