package com.huawei.pluginkidwatch.plugin.feature.track.activity;

import android.os.AsyncTask;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1408x;

/* compiled from: TrackActivity */
class C1819a extends AsyncTask<String, Object, Void> {
    final /* synthetic */ TrackActivity f5126a;

    C1819a(TrackActivity trackActivity) {
        this.f5126a = trackActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m8789a((String[]) objArr);
    }

    protected Void m8789a(String... strArr) {
        C1408x a = C1392h.m6270a(this.f5126a.f5101b, C1492l.m6920d(C1462f.m6746j()));
        if (a != null) {
            C2538c.m12674b("KIDWATCH_TrackActivity", "=======数据库中存在历史轨迹数据=====");
            int a2 = C1485e.m6845a(this.f5126a.f5114o, a.f3187a);
            C2538c.m12674b("KIDWATCH_TrackActivity", "=========beginDate=========" + r0);
            C2538c.m12674b("KIDWATCH_TrackActivity", "=========days=========" + a2);
            if (a2 > 0 && a2 < 6) {
                this.f5126a.m8698a(a2);
            } else if (a2 >= 6) {
                this.f5126a.m8698a(6);
            }
        } else {
            C2538c.m12674b("KIDWATCH_TrackActivity", "=======数据库中无历史轨迹数据=====");
            this.f5126a.m8698a(6);
        }
        return null;
    }
}
