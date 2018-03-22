package com.huawei.hwdatamigrate.hihealth.sync.p420b;

import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwcloudmodel.model.samplepoint.SamplePoint;
import com.huawei.hwcloudmodel.model.unite.MotionPathDetail;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p068d.C4886r;
import com.huawei.hwdatamigrate.hihealth.sync.a.h;
import com.huawei.hwdatamigrate.hihealth.sync.d.m;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: MMotionPathDataSwitch */
public class C4951c {
    private C4886r f18029a = C4886r.m23660a(this.f18031c);
    private C4955g f18030b = new C4955g(this.f18031c);
    private Context f18031c;

    public C4951c(@NonNull Context context) {
        this.f18031c = context.getApplicationContext();
    }

    public HiHealthData m23823a(MotionPathDetail motionPathDetail, int i, int i2) throws h {
        switch (i2) {
            case 2:
                return m23822a(motionPathDetail, i);
            case 3:
                return m23824b(motionPathDetail, i);
            default:
                try {
                    C2538c.d("Debug_MotionPathDataSwitch", new Object[]{"oneCloudTrackToLocal no such hiSyncModel"});
                    return null;
                } catch (h e) {
                    throw e;
                } catch (Exception e2) {
                    C2538c.e("Debug_MotionPathDataSwitch", new Object[]{"oneCloudTrackToLocal e is ", e2.getMessage(), " error track is ", motionPathDetail});
                    return null;
                }
        }
    }

    public HiHealthData m23822a(MotionPathDetail motionPathDetail, int i) throws h {
        if (motionPathDetail == null) {
            return null;
        }
        g a = this.f18029a.m23663a(m.a(this.f18031c), i, motionPathDetail.getDeviceCode().longValue());
        if (a == null) {
            return null;
        }
        a.a(1);
        HiHealthData hiHealthData = new HiHealthData();
        g.a(hiHealthData, a);
        hiHealthData.setType(PayStatusCodes.PAY_STATE_PARAM_ERROR);
        hiHealthData.setTimeZone(motionPathDetail.getTimeZone());
        hiHealthData.setStartTime(motionPathDetail.getStartTime().longValue());
        hiHealthData.setEndTime(motionPathDetail.getEndTime().longValue());
        String attribute = motionPathDetail.getAttribute();
        if (attribute == null || attribute.isEmpty() || attribute.equals("(null)")) {
            this.f18030b.m23838a(motionPathDetail, hiHealthData);
        } else {
            String str;
            String[] split = attribute.split("&&");
            if (split.length > 1) {
                String[] split2 = split[0].split("@is");
                if (split2.length > 1) {
                    attribute = split2[1];
                    hiHealthData.setSequenceData(attribute);
                } else {
                    attribute = null;
                }
                split = split[1].split("@is");
                if (split.length > 1) {
                    str = split[1];
                    hiHealthData.setMetaData(str);
                    String str2 = str;
                    str = attribute;
                    attribute = str2;
                } else {
                    str = attribute;
                    attribute = null;
                }
            } else {
                attribute = null;
                str = null;
            }
            if (C4539a.m21748a(str) || C4539a.m21748a(r0)) {
                C2538c.e("Debug_MotionPathDataSwitch", new Object[]{"oneCloudTrackToLocalByUnite sequenceData or metaData is null , cloudTrack is ", motionPathDetail.getRecordId()});
                return null;
            }
        }
        return hiHealthData;
    }

    public HiHealthData m23824b(MotionPathDetail motionPathDetail, int i) throws h {
        g a = this.f18029a.m23663a(m.a(this.f18031c), i, motionPathDetail.getDeviceCode().longValue());
        if (a == null) {
            return null;
        }
        a.a(1);
        HiHealthData hiHealthData = new HiHealthData();
        g.a(hiHealthData, a);
        hiHealthData.setType(PayStatusCodes.PAY_STATE_PARAM_ERROR);
        hiHealthData.setTimeZone(motionPathDetail.getTimeZone());
        hiHealthData.setStartTime(motionPathDetail.getStartTime().longValue());
        hiHealthData.setEndTime(motionPathDetail.getEndTime().longValue());
        List samplePoints = motionPathDetail.getSamplePoints();
        if (samplePoints == null || samplePoints.size() != 2) {
            return null;
        }
        int i2 = 0;
        String str = null;
        String str2 = null;
        while (i2 < 2) {
            String key = ((SamplePoint) samplePoints.get(i2)).getKey();
            if (key == null) {
                return null;
            }
            if (key.equals("TRACK_METADATA")) {
                String str3 = str;
                str = ((SamplePoint) samplePoints.get(i2)).getValue();
                key = str3;
            } else if (key.equals("TRACK_SEQUENCE_DATA")) {
                key = ((SamplePoint) samplePoints.get(i2)).getValue();
                str = str2;
            } else {
                key = str;
                str = str2;
            }
            i2++;
            str2 = str;
            str = key;
        }
        if (str2 == null || str == null) {
            return null;
        }
        hiHealthData.setMetaData(str2);
        hiHealthData.setSequenceData(str);
        return hiHealthData;
    }
}
