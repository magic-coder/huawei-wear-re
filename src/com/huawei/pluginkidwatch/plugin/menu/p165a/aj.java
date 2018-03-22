package com.huawei.pluginkidwatch.plugin.menu.p165a;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1488h;
import com.huawei.pluginkidwatch.common.p138a.C1401q;
import com.huawei.pluginkidwatch.plugin.menu.utils.C1889e;

/* compiled from: NotificationHistoryAdapter */
class aj implements OnClickListener {
    final /* synthetic */ ah f5189a;

    aj(ah ahVar) {
        this.f5189a = ahVar;
    }

    public void onClick(View view) {
        if (C1889e.m9656a()) {
            String str;
            C1889e.m9655a(false);
            at atVar = (at) view.getTag();
            C1401q c1401q = (C1401q) this.f5189a.f5180h.get(atVar.f5210D);
            String str2 = "";
            if (c1401q != null) {
                str = c1401q.f3152h;
            } else {
                str = str2;
            }
            if (TextUtils.isEmpty(str)) {
                C2538c.m12674b("NotificationHistoryAdapter", "file Url is null, download fail!");
                return;
            }
            C2538c.m12674b("NotificationHistoryAdapter", "file Url: " + str);
            C1488h.m6882a(str);
            this.f5189a.f5179g.set(atVar.f5210D, Integer.valueOf(1));
            this.f5189a.m8850b(1, atVar);
        }
    }
}
