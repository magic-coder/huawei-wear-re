package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.AlarmItem;
import com.huawei.pluginkidwatch.common.entity.model.SetWatchSettingIOModel;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AddPeroidActivity */
class ao implements OnClickListener {
    final /* synthetic */ AddPeroidActivity f5935a;

    ao(AddPeroidActivity addPeroidActivity) {
        this.f5935a = addPeroidActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("AddPeroidActivity", "==========删除一个时段");
        this.f5935a.f5489d.setClickable(false);
        SetWatchSettingIOModel setWatchSettingIOModel = new SetWatchSettingIOModel();
        Map hashMap = new HashMap();
        setWatchSettingIOModel.deviceCode = C1462f.m6746j();
        AlarmItem alarmItem = (AlarmItem) this.f5935a.f5493i.get(this.f5935a.f5509y);
        this.f5935a.f5493i.remove(this.f5935a.f5509y);
        hashMap.put("mutePeirodList", this.f5935a.f5493i);
        setWatchSettingIOModel.settingMap = hashMap;
        this.f5935a.m9079a(setWatchSettingIOModel, true, alarmItem);
        this.f5935a.m9080a(this.f5935a.f5487b);
    }
}
