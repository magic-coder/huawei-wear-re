package com.huawei.pluginkidwatch.plugin.chat;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.lib.p148c.C1466a;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;

/* compiled from: ChatActivity */
class C1762p implements OnTouchListener {
    final /* synthetic */ ChatActivity f4855a;

    C1762p(ChatActivity chatActivity) {
        this.f4855a = chatActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f4855a.al = motionEvent.getAction();
        C2538c.m12674b("ChatActivity", "currentMotionEvent=" + this.f4855a.al);
        switch (this.f4855a.al) {
            case 0:
                C2538c.m12674b("ChatActivity", "=====MotionEvent.ACTION_DOWN");
                if (!C1492l.m6913a(this.f4855a, C1466a.m6780d())) {
                    C1492l.m6910a(this.f4855a, C1466a.m6780d());
                    break;
                }
                this.f4855a.m8433k();
                this.f4855a.m8437m();
                this.f4855a.m8442p();
                this.f4855a.f4737u.setText(C1680l.IDS_plugin_kidwatch_chat_button_press_text);
                this.f4855a.ay.postDelayed(this.f4855a.aC, 0);
                this.f4855a.ay.post(new C1763q(this));
                break;
            case 1:
                C2538c.m12674b("ChatActivity", "=====MotionEvent.ACTION_UP");
                this.f4855a.f4737u.setText(C1680l.IDS_plugin_kidwatch_chat_button_text);
                this.f4855a.f4696D.clearAnimation();
                this.f4855a.m8368a(motionEvent);
                break;
            case 2:
                if (motionEvent.getY() >= 0.0f) {
                    this.f4855a.f4737u.setText(C1680l.IDS_plugin_kidwatch_chat_button_press_text);
                    this.f4855a.m8442p();
                    break;
                }
                this.f4855a.f4737u.setText(C1680l.IDS_plugin_kidwatch_chat_cancel_tips);
                this.f4855a.m8441o();
                break;
            default:
                C2538c.m12674b("ChatActivity", "=====default");
                break;
        }
        return false;
    }
}
