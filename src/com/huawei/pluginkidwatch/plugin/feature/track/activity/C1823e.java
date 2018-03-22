package com.huawei.pluginkidwatch.plugin.feature.track.activity;

import android.os.AsyncTask;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.MotionPathsIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1408x;
import java.util.Map;

/* compiled from: TrackActivity */
class C1823e extends AsyncTask<String, Object, Void> {
    final /* synthetic */ MotionPathsIOEntityModel f5131a;
    final /* synthetic */ C1822d f5132b;

    C1823e(C1822d c1822d, MotionPathsIOEntityModel motionPathsIOEntityModel) {
        this.f5132b = c1822d;
        this.f5131a = motionPathsIOEntityModel;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m8793a((String[]) objArr);
    }

    protected Void m8793a(String... strArr) {
        Map map = this.f5131a.motionDatas;
        if (map == null || map.size() <= 0) {
            this.f5132b.f5130a.m8700a(2, null);
        } else {
            synchronized (map) {
                if (this.f5132b.f5130a.f5105f.getText().toString().trim().equals(C1485e.m6861c())) {
                    C2538c.m12674b("KIDWATCH_TrackActivity", "=====删除当天数据库数据=====");
                    C1408x c1408x = new C1408x();
                    c1408x.f3190d = C1492l.m6920d(C1462f.m6746j());
                    c1408x.f3187a = this.f5132b.f5130a.f5114o;
                    C1392h.m6308d(this.f5132b.f5130a.f5101b, c1408x);
                }
                this.f5132b.f5130a.f5109j = 1;
                this.f5132b.f5130a.m8714a(this.f5132b.f5130a.f5115p, map);
            }
        }
        this.f5132b.f5130a.m8700a(1, null);
        return null;
    }
}
