package com.huawei.p508t;

import android.content.Context;
import com.huawei.hihealth.HiAggregateOption;
import com.huawei.hihealth.a.b;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.fitnessdatatype.MotionGoal;
import com.huawei.hwdatamigrate.p407a.C4775h;
import com.huawei.hwdatamigrate.p407a.ap;
import com.huawei.p508t.p509a.C5970a;
import com.huawei.p508t.p509a.C5971b;
import com.huawei.p508t.p509a.C5972c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HWHealthDataManager */
public class C5973a {
    private static String f20553a = C5973a.class.getSimpleName();
    private static final Object f20554b = new Object();
    private static Context f20555c;
    private static C5973a f20556d;
    private static byte[] f20557e = new byte[1];

    private C5973a() {
        f20555c = BaseApplication.b();
    }

    public static C5973a m27390a() {
        C5973a c5973a;
        synchronized (f20557e) {
            if (f20556d == null) {
                f20556d = new C5973a();
            }
            c5973a = f20556d;
        }
        return c5973a;
    }

    public void m27391a(long j, int i, int i2, int i3, IBaseResponseCallback iBaseResponseCallback) {
        int i4;
        int[] iArr;
        String[] strArr;
        int i5 = i2 / 1440;
        long j2 = ((1000 * j) + (((((long) i2) * ((long) i3)) * 60) * 1000)) - 1;
        HiAggregateOption hiAggregateOption = new HiAggregateOption();
        hiAggregateOption.setStartTime(1000 * j);
        hiAggregateOption.setEndTime(j2);
        hiAggregateOption.setAggregateType(1);
        if (i5 < 1) {
            i4 = 1;
            iArr = new int[]{2, 4, 3, 5};
            strArr = new String[]{C5970a.m27382a(2), C5970a.m27382a(4), C5970a.m27382a(3), C5970a.m27382a(5)};
        } else if (i5 == 1) {
            i4 = 3;
            iArr = C5972c.m27388a(i);
            strArr = C5972c.m27389b(i);
        } else {
            i4 = 5;
            iArr = C5972c.m27388a(i);
            strArr = C5972c.m27389b(i);
            hiAggregateOption.setAggregateType(3);
        }
        if (strArr != null) {
            hiAggregateOption.setConstantsKey(strArr);
        }
        if (iArr != null) {
            hiAggregateOption.setType(iArr);
        }
        hiAggregateOption.setGroupUnitSize(i2);
        hiAggregateOption.setGroupUnitType(i4);
        hiAggregateOption.setReadType(0);
        b.a(f20555c).a(hiAggregateOption, new C5977e(this, iBaseResponseCallback, i3, j, i2, i4, iArr, i, strArr));
    }

    public void m27392a(MotionGoal motionGoal, IBaseResponseCallback iBaseResponseCallback) {
        List arrayList = new ArrayList();
        arrayList.addAll(C5971b.m27386a(motionGoal));
        b.a(f20555c).a(0, arrayList, new C5974b(this, iBaseResponseCallback));
    }

    public void m27393b(MotionGoal motionGoal, IBaseResponseCallback iBaseResponseCallback) {
        b.a(f20555c).a(0, 0, new C5975c(this, motionGoal, iBaseResponseCallback));
    }

    public boolean m27394b() {
        ap b = C4775h.m22862b(f20555c, C4775h.m22859a(f20555c));
        MotionGoal motionGoal = new MotionGoal();
        motionGoal.setStepGoal(b.f17478d);
        m27392a(motionGoal, new C5976d(this));
        return true;
    }
}
