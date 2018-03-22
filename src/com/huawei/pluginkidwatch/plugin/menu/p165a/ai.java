package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.common.p138a.C1401q;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1889e;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1898o;

/* compiled from: NotificationHistoryAdapter */
class ai implements OnClickListener {
    final /* synthetic */ ah f5188a;

    ai(ah ahVar) {
        this.f5188a = ahVar;
    }

    public void onClick(View view) {
        if (C1889e.m9656a()) {
            C1889e.m9655a(false);
            at atVar = (at) view.getTag();
            if (!(this.f5188a.f5178f == null || atVar == null || this.f5188a.f5178f.f5210D == atVar.f5210D)) {
                this.f5188a.f5178f.f5233v.setImageResource(C1617f.kw_pic_list_play);
                this.f5188a.f5178f.f5211E.setMax(0);
                this.f5188a.f5178f.f5211E.setProgress(0);
                this.f5188a.f5178f.f5208B.setText("00:00:00");
                this.f5188a.f5184l = 0;
                this.f5188a.f5183k = 0;
                this.f5188a.f5187o = "00:00:00";
                if (this.f5188a.f5181i != null) {
                    this.f5188a.f5181i.cancel();
                    this.f5188a.f5182j = null;
                    this.f5188a.f5181i = null;
                }
                this.f5188a.f5179g.set(this.f5188a.f5178f.f5210D, Integer.valueOf(2));
                C1898o.m9671b();
            }
            if (atVar != null) {
                try {
                    this.f5188a.f5178f = (at) atVar.clone();
                } catch (CloneNotSupportedException e) {
                    C2538c.m12680e("NotificationHistoryAdapter", "Exception e = " + e.getMessage());
                }
                int intValue = ((Integer) this.f5188a.f5179g.get(atVar.f5210D)).intValue();
                if (2 == intValue) {
                    C2538c.m12674b("NotificationHistoryAdapter", "start play");
                    Object obj = ((C1401q) this.f5188a.f5180h.get(atVar.f5210D)).f3154j;
                    C2538c.m12674b("NotificationHistoryAdapter", "play music path: " + obj);
                    if (!TextUtils.isEmpty(obj)) {
                        C1898o.m9670a(obj);
                        atVar.f5233v.setImageResource(C1617f.kw_pic_list_stop);
                        this.f5188a.f5179g.set(atVar.f5210D, Integer.valueOf(3));
                        this.f5188a.m8861d(atVar);
                    }
                } else if (3 == intValue) {
                    C2538c.m12674b("NotificationHistoryAdapter", "play stop");
                    atVar.f5233v.setImageResource(C1617f.kw_pic_list_play);
                    atVar.f5211E.setMax(0);
                    atVar.f5211E.setProgress(0);
                    atVar.f5208B.setText("00:00:00");
                    C1898o.m9668a();
                    this.f5188a.f5184l = 0;
                    this.f5188a.f5183k = 0;
                    this.f5188a.f5187o = "00:00:00";
                    if (this.f5188a.f5181i != null) {
                        this.f5188a.f5181i.cancel();
                        this.f5188a.f5182j = null;
                        this.f5188a.f5181i = null;
                    }
                    this.f5188a.f5179g.set(atVar.f5210D, Integer.valueOf(2));
                }
            }
        }
    }
}
