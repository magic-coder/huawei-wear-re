package com.tencent.connect.avatar;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
class C6248b implements OnClickListener {
    final /* synthetic */ ImageActivity f21756a;

    C6248b(ImageActivity imageActivity) {
        this.f21756a = imageActivity;
    }

    public void onClick(View view) {
        this.f21756a.f21741j.setVisibility(0);
        this.f21756a.f21738g.setEnabled(false);
        this.f21756a.f21738g.setTextColor(Color.rgb(21, 21, 21));
        this.f21756a.f21737f.setEnabled(false);
        this.f21756a.f21737f.setTextColor(Color.rgb(36, 94, 134));
        new Thread(new C6249c(this)).start();
        if (this.f21756a.f21743l) {
            this.f21756a.m28752a("10657", 0);
            return;
        }
        this.f21756a.m28752a("10655", System.currentTimeMillis() - this.f21756a.f21744m);
        if (this.f21756a.f21736e.f21771b) {
            this.f21756a.m28752a("10654", 0);
        }
    }
}
