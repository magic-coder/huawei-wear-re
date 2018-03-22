package com.huawei.feedback.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.feedback.bean.C4409c;
import com.huawei.feedback.bean.C4409c.C4408a;
import com.huawei.feedback.bean.C4410d;
import com.huawei.feedback.c;
import com.huawei.feedback.logic.C4418i;
import com.huawei.feedback.ui.FeedbackRecordActivity.C4445b;
import com.huawei.phoneserviceuni.common.p132d.p496b.C5766a;
import java.io.File;

/* compiled from: FeedbackRecordActivity */
class ad implements OnClickListener {
    final /* synthetic */ int f16562a;
    final /* synthetic */ C4445b f16563b;

    ad(C4445b c4445b, int i) {
        this.f16563b = c4445b;
        this.f16562a = i;
    }

    public void onClick(View view) {
        if (!c.c()) {
            int j = ((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21214j();
            if (1 == j) {
                ((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21193b(4);
                C4409c a = new C4408a(0).m21155a();
                if (!TextUtils.isEmpty(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21233v())) {
                    a.m21169d(Integer.parseInt(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21233v()));
                }
                a.m21177h(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21220m());
                if (!TextUtils.isEmpty(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21220m())) {
                    a.m21162b(Integer.parseInt(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21220m()));
                }
                a.m21160a(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21198c());
                a.m21179i(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21216k());
                a.m21164b(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21201d());
                a.m21172e(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21228q());
                a.m21174f(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21232u());
                a.m21182j(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21210h());
                a.m21170d(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21226p());
                a.m21176g(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21202e());
                a.m21157a(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21231t());
                com.huawei.phoneserviceuni.common.d.c.a("FeedbackRecordActivity", "bf.getFeedbackRecordId()" + a.m21165c() + "");
                String b = ((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21192b();
                String str = "";
                if (a.m21186n() != null) {
                    str = a.m21186n();
                }
                if (str != null) {
                    C5766a.m26469a().m26470a(new C4418i(a, 0, this.f16563b.f16531a.f16535a, null, this.f16563b.f16533c, a.m21178h() ? "1" : "0", a.m21185m(), new File(str).getName(), str, null, b));
                } else {
                    com.huawei.phoneserviceuni.common.d.c.d("FeedbackRecordActivity", "FeedbackSubmitTask Exception--> zipfilepath is null");
                }
            } else if (2 == j) {
                Intent intent = new Intent();
                intent.setAction("com.example.logupload.progress.start");
                intent.putExtra("strID", Long.parseLong(((C4410d) this.f16563b.f16531a.f16540f.get(this.f16562a)).m21212i()));
                this.f16563b.f16531a.sendBroadcast(intent);
            }
        }
    }
}
