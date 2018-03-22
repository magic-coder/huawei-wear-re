package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.os.Message;
import com.huawei.pluginkidwatch.common.ui.button.C1514c;
import com.huawei.pluginkidwatch.d;

/* compiled from: AlarmListAdapter */
class C1831b implements C1514c {
    final /* synthetic */ C1832c f5255a;
    final /* synthetic */ String f5256b;
    final /* synthetic */ C1830a f5257c;

    C1831b(C1830a c1830a, C1832c c1832c, String str) {
        this.f5257c = c1830a;
        this.f5255a = c1832c;
        this.f5256b = str;
    }

    public void mo2610a(boolean z) {
        if (z) {
            this.f5255a.f5262e.isActive = "1";
            this.f5257c.m8805a(this.f5255a.f5264g, true);
            this.f5255a.f5259b.setTextColor(this.f5257c.f5147c.getResources().getColor(d.alarm_item_title_text_color_select));
            this.f5255a.f5258a.setTextColor(this.f5257c.f5147c.getResources().getColor(d.item_tv_alarm_content_select));
        } else {
            this.f5255a.f5262e.isActive = "0";
            this.f5257c.m8805a(this.f5255a.f5264g, false);
            this.f5255a.f5259b.setTextColor(this.f5257c.f5147c.getResources().getColor(d.alarm_item_title_text_color_nomel));
            this.f5255a.f5258a.setTextColor(this.f5257c.f5147c.getResources().getColor(d.alarm_item_title_text_color_nomel));
        }
        this.f5255a.f5260c.setText(this.f5257c.m8800a(this.f5255a.f5262e.label, this.f5256b, this.f5255a.f5262e.isActive));
        Message message = new Message();
        message.obj = this.f5255a;
        message.what = 5;
        this.f5257c.f5148d.sendMessage(message);
    }
}
