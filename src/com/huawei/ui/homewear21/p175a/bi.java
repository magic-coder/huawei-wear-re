package com.huawei.ui.homewear21.p175a;

import com.huawei.hihealth.HiAccountInfo;
import com.huawei.hwcloudmodel.callback.a;
import com.huawei.hwcloudmodel.model.userprofile.GetPrivacyRecordRsp;
import com.huawei.hwcloudmodel.model.userprofile.PrivacyRecord;
import com.huawei.hwdatamigrate.hihealth.f.b;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.dialog.w;
import com.huawei.ui.homewear21.i;
import java.util.List;

/* compiled from: HomeFragment */
class bi implements a<GetPrivacyRecordRsp> {
    final /* synthetic */ C2217a f8080a;

    bi(C2217a c2217a) {
        this.f8080a = c2217a;
    }

    public void m11569a(GetPrivacyRecordRsp getPrivacyRecordRsp, String str, boolean z) {
        if (getPrivacyRecordRsp != null) {
            C2538c.m12661a("MainUI", 0, "HomeFragment", "GetPrivacyRecord isSuccess is " + z);
            List privacyRecords = getPrivacyRecordRsp.getPrivacyRecords();
            HiAccountInfo ax = this.f8080a.bp();
            b a = b.a(this.f8080a.f8041z);
            a.a(ax);
            int b = a.b();
            if (privacyRecords != null) {
                C2538c.m12661a("MainUI", 0, "HomeFragment", "list size is  " + privacyRecords.size());
                if (privacyRecords.size() == 1) {
                    if (((PrivacyRecord) privacyRecords.get(0)).getOpinion().intValue() != 1) {
                        return;
                    }
                    if (b == 0 || b == 2) {
                        this.f8080a.m11453a(a);
                        return;
                    }
                    return;
                } else if (privacyRecords.size() == 0) {
                    this.f8080a.br();
                    if (b == 0 || b == 2) {
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "the first time to sync, popup notification dialog");
                        w wVar = new w(this.f8080a.f8041z);
                        wVar.a(i.IDS_service_area_notice_title);
                        wVar.b(this.f8080a.getResources().getString(i.IDS_oversea_migration_notification));
                        wVar.a(i.IDS_common_notification_know_tips, new bj(this, a));
                        wVar.a().show();
                        return;
                    } else if (b == 1) {
                        C2538c.m12661a("MainUI", 0, "HomeFragment", "migrate from cloud to local storage has been finished.");
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            C2538c.m12661a("MainUI", 0, "HomeFragment", "list is null!!");
            if (b != 1) {
                this.f8080a.m11453a(a);
            }
        }
    }
}
