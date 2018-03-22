package com.huawei.pluginkidwatch.plugin.setting.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1404t;
import com.huawei.pluginkidwatch.plugin.setting.p167b.C1941f;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: RewardActivity */
class bt implements Runnable {
    final /* synthetic */ RewardActivity f6645a;

    bt(RewardActivity rewardActivity) {
        this.f6645a = rewardActivity;
    }

    public void run() {
        ArrayList c = C1392h.m6301c(this.f6645a.f6487n, this.f6645a.ai);
        if (this.f6645a.f6496w != null) {
            this.f6645a.f6496w.clear();
        } else {
            this.f6645a.f6496w = new ArrayList();
        }
        if (c != null) {
            C2538c.m12674b("RewardActivity", "==================item tableList:", c.size() + "");
            Iterator it = c.iterator();
            while (it.hasNext()) {
                C1404t c1404t = (C1404t) it.next();
                C2538c.m12674b("RewardActivity", "=================item.arr():", c1404t.toString() + "");
                C1941f c1941f = new C1941f();
                c1941f.m10160b(String.format(this.f6645a.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_reward_reached_the_goal), new Object[]{c1404t.m6408c()}));
                c1941f.m10162c(String.format(this.f6645a.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_reward), new Object[]{c1404t.m6406b()}));
                String str = "";
                try {
                    str = new SimpleDateFormat("MM/dd", Locale.US).format(new Date(Long.parseLong(c1404t.m6412e())));
                } catch (NumberFormatException e) {
                    NumberFormatException numberFormatException = e;
                    str = "";
                    C2538c.m12680e("RewardActivity", "Exception e = " + numberFormatException.getMessage());
                }
                c1941f.m10164d(str);
                c1941f.m10158a(c1404t.m6408c() + "");
                C2538c.m12674b("RewardActivity", "=================item.toString()", c1941f.toString() + "");
                this.f6645a.f6496w.add(c1941f);
            }
        }
        this.f6645a.am.sendEmptyMessage(8);
    }
}
