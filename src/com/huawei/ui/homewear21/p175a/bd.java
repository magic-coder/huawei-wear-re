package com.huawei.ui.homewear21.p175a;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.homewear21.i;

/* compiled from: HomeFragment */
class bd implements Runnable {
    final /* synthetic */ C2217a f8075a;

    bd(C2217a c2217a) {
        this.f8075a = c2217a;
    }

    public void run() {
        C0996a.m3611a(BaseApplication.m2632b(), String.valueOf(10000), "union_join_show_notice_time", (C0977d.m3551d(BaseApplication.m2632b(), C0996a.m3612a(BaseApplication.m2632b(), String.valueOf(10000), "union_join_show_notice_time")) + 1) + "", new C0993c());
        String b = C1988p.m10381a(this.f8075a.f7992A).m10391b(this.f8075a.ag.getProductType());
        if (11 == this.f8075a.ag.getProductType() && "HUAWEI CM-R1P".equals(this.f8075a.ag.getDeviceName())) {
            b = this.f8075a.f8041z.getString(i.IDS_huawei_r1_pro_content);
        }
        w b2 = new w(this.f8075a.f8041z).a(this.f8075a.f7992A.getResources().getString(i.IDS_service_area_notice_title)).b(String.format(this.f8075a.f7992A.getResources().getString(i.IDS_pair_union_note_goto_health_modify), new Object[]{b})).a(i.IDS_pair_union_note_sure, new bf(this)).b(i.IDS_pair_union_note_cancle, new be(this));
        if (this.f8075a.aL == null) {
            this.f8075a.aL = b2.a();
            this.f8075a.aL.setCanceledOnTouchOutside(false);
            this.f8075a.aL.show();
        }
    }
}
