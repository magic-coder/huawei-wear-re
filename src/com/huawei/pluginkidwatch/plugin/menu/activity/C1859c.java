package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.AlarmItem;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchSettingIOModel;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AddAlarmActivity */
class C1859c implements OnClickListener {
    final /* synthetic */ AddAlarmActivity f5988a;

    C1859c(AddAlarmActivity addAlarmActivity) {
        this.f5988a = addAlarmActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("AddAlarmActivity", "==========Delete one alarm ");
        this.f5988a.f5361f.setClickable(false);
        SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
        Map hashMap = new HashMap();
        setWatchSettingIOModel.deviceCode = C1462f.m6746j();
        AlarmItem alarmItem = (AlarmItem) this.f5988a.f5379y.get(this.f5988a.f5343C);
        this.f5988a.f5379y.remove(this.f5988a.f5343C);
        hashMap.put("alarmList", this.f5988a.f5379y);
        setWatchSettingIOModel.settingMap = hashMap;
        this.f5988a.m8939a(setWatchSettingIOModel, true, alarmItem);
        this.f5988a.m8940a(this.f5988a.f5357b);
    }
}
