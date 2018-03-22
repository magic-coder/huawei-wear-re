package com.huawei.p508t;

import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.data.p312b.C4549a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSportType;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessTotalData;
import com.huawei.hwcommonmodel.p064d.C4734m;
import com.huawei.p508t.p509a.C5970a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWHealthDataManager */
class C5977e implements C4549a {
    final /* synthetic */ IBaseResponseCallback f20564a;
    final /* synthetic */ int f20565b;
    final /* synthetic */ long f20566c;
    final /* synthetic */ int f20567d;
    final /* synthetic */ int f20568e;
    final /* synthetic */ int[] f20569f;
    final /* synthetic */ int f20570g;
    final /* synthetic */ String[] f20571h;
    final /* synthetic */ C5973a f20572i;

    C5977e(C5973a c5973a, IBaseResponseCallback iBaseResponseCallback, int i, long j, int i2, int i3, int[] iArr, int i4, String[] strArr) {
        this.f20572i = c5973a;
        this.f20564a = iBaseResponseCallback;
        this.f20565b = i;
        this.f20566c = j;
        this.f20567d = i2;
        this.f20568e = i3;
        this.f20569f = iArr;
        this.f20570g = i4;
        this.f20571h = strArr;
    }

    public void mo5128a(List<HiHealthData> list, int i, int i2) {
        if (list == null || list.isEmpty()) {
            this.f20564a.onResponse(0, null);
            return;
        }
        List arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f20565b; i3++) {
            FitnessTotalData fitnessTotalData = new FitnessTotalData();
            for (HiHealthData hiHealthData : list) {
                long startTime = hiHealthData.getStartTime();
                int i4 = (int) ((((startTime / 1000) - this.f20566c) / 60) / ((long) this.f20567d));
                if (this.f20568e == 5) {
                    i4 = C4734m.m22643b(C4734m.m22641a(this.f20566c));
                    int b = C4734m.m22643b(C4734m.m22641a(startTime / 1000));
                    if (b < i4) {
                        i4 = (b + 12) - i4;
                    } else {
                        i4 = b - i4;
                    }
                }
                if (i4 == i3) {
                    if (this.f20569f[0] != 2) {
                        switch (this.f20570g) {
                            case 1:
                                fitnessTotalData.setSteps(hiHealthData.getInt(this.f20571h[0]));
                                fitnessTotalData.setCalorie(hiHealthData.getInt(this.f20571h[1]));
                                fitnessTotalData.setDistance(hiHealthData.getInt(this.f20571h[2]));
                                fitnessTotalData.setSportType(this.f20570g);
                                fitnessTotalData.setDuration(hiHealthData.getInt(this.f20571h[3]));
                                break;
                            case 2:
                                fitnessTotalData.setSteps(hiHealthData.getInt(this.f20571h[0]));
                                fitnessTotalData.setCalorie(hiHealthData.getInt(this.f20571h[1]));
                                fitnessTotalData.setDistance(hiHealthData.getInt(this.f20571h[2]));
                                fitnessTotalData.setSportType(this.f20570g);
                                fitnessTotalData.setDuration(hiHealthData.getInt(this.f20571h[3]));
                                break;
                            case 3:
                                fitnessTotalData.setSteps(hiHealthData.getInt(this.f20571h[0]));
                                fitnessTotalData.setCalorie(hiHealthData.getInt(this.f20571h[1]));
                                fitnessTotalData.setDistance(hiHealthData.getInt(this.f20571h[2]));
                                fitnessTotalData.setHeight(Math.round(hiHealthData.getFloat(this.f20571h[3])));
                                fitnessTotalData.setSportType(this.f20570g);
                                fitnessTotalData.setDuration(hiHealthData.getInt(this.f20571h[4]));
                                break;
                            case 4:
                                fitnessTotalData.setSteps(0);
                                fitnessTotalData.setCalorie(hiHealthData.getInt(this.f20571h[0]));
                                fitnessTotalData.setDistance(hiHealthData.getInt(this.f20571h[1]));
                                fitnessTotalData.setSportType(this.f20570g);
                                fitnessTotalData.setDuration(hiHealthData.getInt(this.f20571h[3]));
                                break;
                            case FitnessSportType.HW_FITNESS_SPORT_ALL /*221*/:
                                fitnessTotalData.setSteps(hiHealthData.getInt(this.f20571h[0]));
                                fitnessTotalData.setCalorie(hiHealthData.getInt(this.f20571h[1]));
                                fitnessTotalData.setDistance(hiHealthData.getInt(this.f20571h[2]));
                                fitnessTotalData.setHeight(Math.round(hiHealthData.getFloat(this.f20571h[3])));
                                fitnessTotalData.setSportType(this.f20570g);
                                fitnessTotalData.setDuration(hiHealthData.getInt(this.f20571h[4]));
                                break;
                            default:
                                break;
                        }
                    }
                    fitnessTotalData.setSteps(hiHealthData.getInt(C5970a.m27382a(2)));
                    fitnessTotalData.setCalorie(hiHealthData.getInt(C5970a.m27382a(4)));
                    fitnessTotalData.setDistance(hiHealthData.getInt(C5970a.m27382a(3)));
                    fitnessTotalData.setHeight(hiHealthData.getInt(C5970a.m27382a(5)));
                    fitnessTotalData.setSportType(this.f20570g);
                    fitnessTotalData.setDuration(0);
                    arrayList.add(fitnessTotalData);
                }
            }
            arrayList.add(fitnessTotalData);
        }
        this.f20564a.onResponse(0, arrayList);
    }
}
