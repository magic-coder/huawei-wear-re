package com.huawei.hwfitnessmgr.deviceadapter.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.hwcommonmodel.fitnessdatatype.DataTotalMotion;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateDetectRet;

import java.util.ArrayList;
import java.util.List;

/* compiled from: DataTodayTotalMotion */
public class C5023f {
    private int f18211a;
    private HeartRateDetectRet f18212b = new HeartRateDetectRet();
    private List<DataTotalMotion> f18213c = new ArrayList();

    public int m24208a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18211a))).intValue();
    }

    public void m24209a(int i) {
        this.f18211a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public List<DataTotalMotion> m24212b() {
        return (List) C0978h.a(this.f18213c);
    }

    public void m24211a(List<DataTotalMotion> list) {
        this.f18213c = (List) C0978h.a(list);
    }

    public void m24210a(HeartRateDetectRet heartRateDetectRet) {
        this.f18212b = (HeartRateDetectRet) C0978h.a(heartRateDetectRet);
    }
}
