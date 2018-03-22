package com.huawei.feedback.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.huawei.feedback.c;

/* compiled from: FeedbackEditActivity */
class C4471t implements OnItemClickListener {
    final /* synthetic */ FeedbackEditActivity f16603a;

    C4471t(FeedbackEditActivity feedbackEditActivity) {
        this.f16603a = feedbackEditActivity;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!this.f16603a.f16477E) {
            if (c.a(this.f16603a) || !c.a(this.f16603a, "android.permission.WRITE_EXTERNAL_STORAGE", 4096)) {
                int size = this.f16603a.f16504g.size() - 1;
                if (i == size && size < 6 && this.f16603a.f16504g.get(i) == null) {
                    this.f16603a.f16477E = true;
                    c.a(this.f16603a, TradeCode.DEAL_WITH_DOUBT);
                }
            }
        }
    }
}
