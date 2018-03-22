package com.huawei.bone.root;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: ProtocolAndClauseActivity */
class C6801t extends ClickableSpan {
    final /* synthetic */ ProtocolAndClauseActivity f23343a;

    C6801t(ProtocolAndClauseActivity protocolAndClauseActivity) {
        this.f23343a = protocolAndClauseActivity;
    }

    public void onClick(View view) {
        this.f23343a.m30148d();
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        textPaint.setColor(Color.parseColor("#0D9FFB"));
    }
}
