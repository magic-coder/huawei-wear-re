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

/* compiled from: AlarmActivity */
class av implements C1378e {
    final /* synthetic */ AlarmActivity f5946a;

    av(AlarmActivity alarmActivity) {
        this.f5946a = alarmActivity;
    }

    public void mo2465a(BaseEntityModel baseEntityModel) {
        C2538c.m12674b("AlarmActivity", "========== entity.getWatchSetting-->onResponse");
        if (this.f5946a.isFinishing()) {
            C2538c.m12680e("AlarmActivity", "=============AlarmActivity is  finish. so return");
        }
        if (baseEntityModel == null || baseEntityModel.retCode != 0) {
            C2538c.m12680e("AlarmActivity", "========== get watch alarm list error");
            this.f5946a.m9122a(true);
            this.f5946a.f5521l.setText(C1680l.IDS_plugin_kidwatch_network_error_load_failed);
            return;
        }
        this.f5946a.f5524o = true;
        this.f5946a.m9122a(false);
        Map map = ((GetWatchSettingModel) baseEntityModel).watchSettingMap;
        if (map != null) {
            Object obj = map.get("alarmList");
            if (obj != null) {
                String str = "";
                try {
                    str = this.f5946a.f5520k.toJson(obj);
                } catch (Exception e) {
                    C2538c.m12680e("AlarmActivity", "Exception e = " + e.getMessage());
                }
                C2538c.m12674b("AlarmActivity", "============object.toString():" + obj.toString());
                try {
                    this.f5946a.f5516g = (List) this.f5946a.f5520k.fromJson(str, new aw(this).getType());
                } catch (JsonSyntaxException e2) {
                    this.f5946a.f5516g = new ArrayList();
                    C2538c.m12680e("AlarmActivity", "Exception e = " + e2.getMessage());
                }
                if (this.f5946a.f5516g == null) {
                    this.f5946a.f5516g = new ArrayList();
                }
                this.f5946a.m9121a(this.f5946a.f5516g);
            }
        }
    }
}
