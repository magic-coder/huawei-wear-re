package com.huawei.cp3.widget.custom.p384a;

import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.StyleSpan;

/* compiled from: HwProgressDialogCustom */
class C4378e extends Handler {
    final /* synthetic */ C4377d f16279a;

    C4378e(C4377d c4377d) {
        this.f16279a = c4377d;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        int progress = this.f16279a.f16263k.getProgress();
        int max = this.f16279a.f16263k.getMax();
        if (this.f16279a.f16268p != null) {
            String b = this.f16279a.f16268p;
            this.f16279a.f16267o.setText(String.format(b, new Object[]{Integer.valueOf(progress), Integer.valueOf(max)}));
        } else {
            this.f16279a.f16267o.setText("");
        }
        if (this.f16279a.f16270r != null) {
            CharSequence spannableString = new SpannableString(this.f16279a.f16270r.format(((double) progress) / ((double) max)));
            spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            this.f16279a.f16269q.setText(spannableString);
            return;
        }
        this.f16279a.f16269q.setText("");
    }
}
