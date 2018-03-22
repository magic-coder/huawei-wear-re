package com.huawei.pluginkidwatch.plugin.feature.track.activity;

import android.os.AsyncTask;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.MotionPathsIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import java.util.Date;
import java.util.Map;

/* compiled from: TrackActivity */
class C1821c extends AsyncTask<String, Object, Void> {
    final /* synthetic */ MotionPathsIOEntityModel f5128a;
    final /* synthetic */ C1820b f5129b;

    C1821c(C1820b c1820b, MotionPathsIOEntityModel motionPathsIOEntityModel) {
        this.f5129b = c1820b;
        this.f5128a = motionPathsIOEntityModel;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m8791a((String[]) objArr);
    }

    protected Void m8791a(String... strArr) {
        Map map = this.f5128a.motionDatas;
        if (map != null && map.size() > 0) {
            synchronized (map) {
                for (int i = 0; i < this.f5129b.f5127a.f5116q; i++) {
                    C2538c.m12674b("KIDWATCH_TrackActivity", "======strDate====" + C1485e.m6867d(C1485e.m6853a(C1485e.m6852a(new Date()), i)));
                    this.f5129b.f5127a.f5109j = 2;
                    this.f5129b.f5127a.m8714a(r2, map);
                }
            }
        }
        return null;
    }
}
