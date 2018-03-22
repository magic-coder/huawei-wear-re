package com.huawei.feedback.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.huawei.feedback.c;
import com.huawei.feedback.d;

/* compiled from: FeedbackEditActivity */
class C4462k implements OnClickListener {
    final /* synthetic */ FeedbackEditActivity f16594a;

    C4462k(FeedbackEditActivity feedbackEditActivity) {
        this.f16594a = feedbackEditActivity;
    }

    public void onClick(View view) {
        if (!c.b(this.f16594a, "com.tencent.mobileqq")) {
            com.huawei.phoneserviceuni.common.d.c.b("FeedbackEditActivity", "unQqInstalled -----------");
            Toast.makeText(this.f16594a, this.f16594a.getResources().getString(d.b(this.f16594a.f16500c, "feedback_qq_install")), 0).show();
        } else if (this.f16594a.f16479G != null) {
            com.huawei.phoneserviceuni.common.d.c.b("FeedbackEditActivity", "isQqInstalled -----------");
            try {
                this.f16594a.startActivity(Intent.getIntent("mqqwpa://im/chat?chat_type=crm&uin=" + this.f16594a.f16479G.m21128b() + "&version=1&src_type=web&web_src=http:://wpa.b.qq.com"));
            } catch (Exception e) {
                com.huawei.phoneserviceuni.common.d.c.d("FeedbackEditActivity", "qqEnterListener Exception");
            }
        }
    }
}
