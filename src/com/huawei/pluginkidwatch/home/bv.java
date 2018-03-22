package com.huawei.pluginkidwatch.home;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.huawei.p190v.C2538c;

/* compiled from: SettingFragment */
class bv implements OnTouchListener {
    final /* synthetic */ bu f4341a;

    bv(bu buVar) {
        this.f4341a = buVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (1 == motionEvent.getAction()) {
            C2538c.m12674b("KIDWATCH_SettingFragment", "========MotionEvent.ACTION_UP");
            this.f4341a.f4330d.setVisibility(8);
        } else if (motionEvent.getAction() == 0) {
            C2538c.m12674b("KIDWATCH_SettingFragment", "========MotionEvent.ACTION_DOWN");
            this.f4341a.f4330d.setVisibility(0);
        } else if (3 == motionEvent.getAction()) {
            C2538c.m12674b("KIDWATCH_SettingFragment", "========MotionEvent.ACTION_CANCEL");
            this.f4341a.f4330d.setVisibility(8);
        }
        C2538c.m12674b("KIDWATCH_SettingFragment", "===========onTouch=" + motionEvent.getAction() + "");
        return false;
    }
}
