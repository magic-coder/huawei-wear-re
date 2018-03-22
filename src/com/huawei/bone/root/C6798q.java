package com.huawei.bone.root;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: ProtocolAndClauseActivity */
class C6798q extends ClickableSpan {
    final /* synthetic */ ProtocolAndClauseActivity f23340a;

    C6798q(ProtocolAndClauseActivity protocolAndClauseActivity) {
        this.f23340a = protocolAndClauseActivity;
    }

    public void onClick(View view) {
        this.f23340a.m30145c();
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(Color.parseColor("#0D9FFB"));
        textPaint.setUnderlineText(false);
    }
}
