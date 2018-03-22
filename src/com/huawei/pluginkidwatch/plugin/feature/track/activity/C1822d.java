package com.huawei.pluginkidwatch.plugin.feature.track.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.MotionPathsIOEntityModel;
import com.huawei.pluginkidwatch.common.lib.utils.C1483c;
import com.huawei.pluginkidwatch.common.ui.p150a.C1506g;

/* compiled from: TrackActivity */
class C1822d implements C1378e {
    final /* synthetic */ TrackActivity f5130a;

    C1822d(TrackActivity trackActivity) {
        this.f5130a = trackActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            if (baseEntityModel != null) {
                C2538c.m12674b("KIDWATCH_TrackActivity", "==========getDayTrackDataFromCloud=======response.retCode=" + baseEntityModel.retCode);
            }
            this.f5130a.m8700a(1, null);
            C1506g.m6979b();
            C1483c.m6832c(this.f5130a.f5101b, this.f5130a.f5101b.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_track_get_data_failed));
            return;
        }
        MotionPathsIOEntityModel motionPathsIOEntityModel = (MotionPathsIOEntityModel) baseEntityModel;
        C2538c.m12674b("KIDWATCH_TrackActivity", "============getDayTrackDataFromCloud success");
        new C1823e(this, motionPathsIOEntityModel).execute(new String[0]);
    }
}
