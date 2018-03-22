package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1378e;
import com.huawei.pluginkidwatch.common.entity.model.BaseEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.GetWatchSettingModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: PeroidActivity */
class fi implements C1378e {
    final /* synthetic */ PeroidActivity f6119a;

    fi(PeroidActivity peroidActivity) {
        this.f6119a = peroidActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b("PeroidActivity", "========== entity.getWatchSetting-->onResponse");
        if (this.f6119a.isFinishing()) {
            C2538c.m12677c("PeroidActivity", "=============PeroidActivity is  finish. so return");
        } else if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12677c("PeroidActivity", "========== get watch alarm list error");
            this.f6119a.m9482a(true);
            this.f6119a.f5802h.setText(this.f6119a.getResources().getString(C1680l.IDS_plugin_kidwatch_network_error_load_failed));
        } else {
            this.f6119a.f5810p = true;
            this.f6119a.m9482a(false);
            Map map = ((GetWatchSettingModel) baseEntityModel).watchSettingMap;
            if (map != null) {
                Object obj = map.get("mutePeirodList");
                if (obj != null) {
                    String str = "";
                    try {
                        str = this.f6119a.f5809o.toJson(obj);
                    } catch (Exception e) {
                        C2538c.m12680e("PeroidActivity", "Exception e = " + e.getMessage());
                    }
                    C2538c.m12674b("PeroidActivity", "============object.toString():" + obj.toString());
                    try {
                        this.f6119a.f5801g = (List) this.f6119a.f5809o.fromJson(str, new fj(this).getType());
                    } catch (JsonSyntaxException e2) {
                        this.f6119a.f5801g = new ArrayList();
                        C2538c.m12680e("PeroidActivity", "Exception e = " + e2.getMessage());
                    }
                    if (this.f6119a.f5801g == null) {
                        this.f6119a.f5801g = new ArrayList();
                    }
                    this.f6119a.m9481a(this.f6119a.f5801g);
                }
            }
        }
    }
}
