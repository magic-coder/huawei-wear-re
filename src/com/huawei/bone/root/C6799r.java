package com.huawei.bone.root;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: ProtocolAndClauseActivity */
class C6799r extends ClickableSpan {
    final /* synthetic */ ProtocolAndClauseActivity f23341a;

    C6799r(ProtocolAndClauseActivity protocolAndClauseActivity) {
        this.f23341a = protocolAndClauseActivity;
    }

    public void onClick(View view) {
        this.f23341a.m30149e();
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(Color.parseColor("#0D9FFB"));
        textPaint.setUnderlineText(false);
    }
}
