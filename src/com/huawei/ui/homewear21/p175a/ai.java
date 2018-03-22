package com.huawei.ui.homewear21.p175a;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.p190v.C2538c;

/* compiled from: HomeFragment */
class ai extends ClickableSpan {
    final /* synthetic */ C2217a f8050a;

    ai(C2217a c2217a) {
        this.f8050a = c2217a;
    }

    public void onClick(View view) {
        C2538c.m12661a("MainUI", 0, "HomeFragment", "SpannableString onclick");
        this.f8050a.aF();
        this.f8050a.m11446a(0);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(Color.parseColor("#0d9ffb"));
        textPaint.setUnderlineText(false);
    }
}
