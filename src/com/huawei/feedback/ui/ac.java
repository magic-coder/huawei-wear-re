package com.huawei.feedback.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.huawei.feedback.bean.C4410d;
import com.huawei.feedback.logic.f;
import com.huawei.phoneserviceuni.common.d.c;
import java.io.File;

/* compiled from: FeedbackRecordActivity */
class ac implements OnClickListener {
    final /* synthetic */ FeedbackRecordActivity f16561a;

    ac(FeedbackRecordActivity feedbackRecordActivity) {
        this.f16561a = feedbackRecordActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C4410d c4410d = null;
        if (this.f16561a.f16540f != null) {
            c4410d = (C4410d) this.f16561a.f16540f.get(this.f16561a.f16556w);
        }
        if (c4410d != null) {
            f.c(c4410d.m21229r());
            if (TextUtils.isEmpty(c4410d.m21210h())) {
                c.a("FeedbackRecordActivity", "file path is empty or null");
            } else {
                File file = new File(c4410d.m21210h());
                if (file.exists() && file.delete()) {
                    c.a("FeedbackRecordActivity", "deleteItemDialog package file delete sccess!");
                } else {
                    c.a("FeedbackRecordActivity", "deleteItemDialog package file not exist or error! file delete fail!");
                }
            }
            if (this.f16561a.f16540f != null) {
                this.f16561a.f16540f.remove(c4410d);
            }
        }
        if (this.f16561a.f16540f != null && this.f16561a.f16540f.size() == 0) {
            this.f16561a.m21442l();
            this.f16561a.f16539e.setVisibility(8);
            if (!(this.f16561a.f16555v == null || this.f16561a.f16555v.getItem(0) == null)) {
                this.f16561a.f16555v.setGroupEnabled(0, false);
                this.f16561a.f16555v.setGroupVisible(0, false);
            }
        }
        if (this.f16561a.f16548n != null) {
            this.f16561a.f16548n.notifyDataSetChanged();
        }
    }
}
