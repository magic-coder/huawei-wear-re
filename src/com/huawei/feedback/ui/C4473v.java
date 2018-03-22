package com.huawei.feedback.ui;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.huawei.feedback.a.b.a;
import com.huawei.feedback.d;
import com.huawei.phoneserviceuni.common.d.c;

/* compiled from: FeedbackEditActivity */
class C4473v extends Handler {
    final /* synthetic */ FeedbackEditActivity f16605a;

    C4473v(FeedbackEditActivity feedbackEditActivity) {
        this.f16605a = feedbackEditActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f16605a.f16520w.m21166c(1);
                if (this.f16605a.f16491T != null) {
                    a.a().a(this.f16605a.f16491T.toString());
                }
                if (!this.f16605a.isFinishing()) {
                    this.f16605a.m21369e();
                    this.f16605a.f16478F = null;
                    this.f16605a.m21374g();
                    this.f16605a.m21341a(1);
                    if (com.huawei.phoneserviceuni.common.d.a.a(this.f16605a)) {
                        if (!this.f16605a.isFinishing()) {
                            this.f16605a.m21382k();
                            break;
                        }
                    }
                    Toast.makeText(this.f16605a, this.f16605a.getResources().getString(d.b(this.f16605a.f16500c, "feedback_no_network_connection_prompt")), 0).show();
                    break;
                }
                this.f16605a.m21374g();
                this.f16605a.m21341a(1);
                c.a("FeedbackEditActivity", "FeedbackEditActivity.this.isFinishing().ZIP_SUCCESS");
                return;
                break;
            case 2:
                if (!this.f16605a.isFinishing()) {
                    this.f16605a.m21369e();
                    this.f16605a.m21341a(2);
                    this.f16605a.m21385m();
                    break;
                }
                this.f16605a.m21341a(2);
                c.a("FeedbackEditActivity", "FeedbackEditActivity.this.isFinishing().ZIP_FAIL");
                return;
            case 3:
                this.f16605a.m21361c();
                break;
            case 4:
                this.f16605a.m21372f();
                break;
            case 1000:
                this.f16605a.m21345a(message.obj);
                break;
            case 1001:
                this.f16605a.m21365d();
                break;
        }
        super.handleMessage(message);
    }
}
