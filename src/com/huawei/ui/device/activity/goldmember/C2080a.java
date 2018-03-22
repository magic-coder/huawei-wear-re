package com.huawei.ui.device.activity.goldmember;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huawei.ui.device.i;

/* compiled from: HuaweiMemberActivity */
class C2080a extends ClickableSpan {
    final /* synthetic */ HuaweiMemberActivity f7360a;

    C2080a(HuaweiMemberActivity huaweiMemberActivity) {
        this.f7360a = huaweiMemberActivity;
    }

    public void onClick(View view) {
        this.f7360a.m10764a(this.f7360a.f7285g, "userPermission", this.f7360a.f7285g.getResources().getString(i.IDS_main_sns_golden_member_user_agreement));
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        textPaint.setColor(Color.parseColor("#0D9FFB"));
    }
}
