package com.huawei.sim.multisim;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.sim.e;

/* compiled from: MultiSimConfigActivity */
class C5960k extends ClickableSpan {
    final /* synthetic */ MultiSimConfigActivity f20533a;

    C5960k(MultiSimConfigActivity multiSimConfigActivity) {
        this.f20533a = multiSimConfigActivity;
    }

    public void onClick(View view) {
        this.f20533a.m27273G();
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        textPaint.setColor(this.f20533a.getResources().getColor(e.IDS_plugin_sim_next_back_color));
    }
}
