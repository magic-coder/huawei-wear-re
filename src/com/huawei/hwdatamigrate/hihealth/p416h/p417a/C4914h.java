package com.huawei.hwdatamigrate.hihealth.p416h.p417a;

import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.data.model.HiTrackMetaData;
import com.huawei.hihealth.p394c.C4543e;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import java.io.Serializable;
import java.util.Comparator;

/* compiled from: HiDataSequenceMerge */
class C4914h implements Serializable, Comparator<HiHealthData> {
    private int f17971a;

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m23736a((HiHealthData) obj, (HiHealthData) obj2);
    }

    public C4914h(int i) {
        this.f17971a = i;
    }

    public int m23736a(HiHealthData hiHealthData, HiHealthData hiHealthData2) {
        int totalDistance;
        int i = 0;
        switch (this.f17971a) {
            case PayStatusCodes.PAY_STATE_PARAM_ERROR /*30001*/:
                HiTrackMetaData hiTrackMetaData = (HiTrackMetaData) C4543e.m21777a(hiHealthData.getMetaData(), HiTrackMetaData.class);
                totalDistance = hiTrackMetaData == null ? 0 : hiTrackMetaData.getTotalDistance();
                hiTrackMetaData = (HiTrackMetaData) C4543e.m21777a(hiHealthData2.getMetaData(), HiTrackMetaData.class);
                if (hiTrackMetaData != null) {
                    i = hiTrackMetaData.getTotalDistance();
                    break;
                }
                break;
            default:
                totalDistance = 0;
                break;
        }
        return i - totalDistance;
    }
}
