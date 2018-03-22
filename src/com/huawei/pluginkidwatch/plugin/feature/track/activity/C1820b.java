package com.huawei.pluginkidwatch.plugin.feature.track.activity;

import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.MotionPathsIOEntityModel;

/* compiled from: TrackActivity */
class C1820b implements C1378e {
    final /* synthetic */ TrackActivity f5127a;

    C1820b(TrackActivity trackActivity) {
        this.f5127a = trackActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        if (baseEntityModel != null && baseEntityModel.retCode == 0) {
            MotionPathsIOEntityModel motionPathsIOEntityModel = (MotionPathsIOEntityModel) baseEntityModel;
            C2538c.m12674b("KIDWATCH_TrackActivity", "============getCountDaysTrackDataFromCloud success");
            new C1821c(this, motionPathsIOEntityModel).execute(new String[0]);
        } else if (baseEntityModel != null) {
            C2538c.m12674b("KIDWATCH_TrackActivity", "==========getCountDaysTrackDataFromCloud=======response.retCode=" + baseEntityModel.retCode);
        }
    }
}
