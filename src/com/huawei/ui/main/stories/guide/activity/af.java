package com.huawei.ui.main.stories.guide.activity;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: UserExperienceImprovementActivity */
class af extends ClickableSpan {
    final /* synthetic */ UserExperienceImprovementActivity f8641a;

    af(UserExperienceImprovementActivity userExperienceImprovementActivity) {
        this.f8641a = userExperienceImprovementActivity;
    }

    public void onClick(View view) {
        this.f8641a.m12119c();
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        textPaint.setColor(Color.parseColor("#0D9FFB"));
    }
}
