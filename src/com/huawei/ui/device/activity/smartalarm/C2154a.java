package com.huawei.ui.device.activity.smartalarm;

import com.huawei.datatype.SmartAlarmInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: SmartAlarmClockActivity */
class C2154a implements IBaseResponseCallback {
    final /* synthetic */ SmartAlarmClockActivity f7646a;

    C2154a(SmartAlarmClockActivity smartAlarmClockActivity) {
        this.f7646a = smartAlarmClockActivity;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("SmartAlarmClockActivity", "getSmartAlarm() err_code = " + i + ",objData = " + obj);
        this.f7646a.f7624e = (List) obj;
        if (!(this.f7646a.f7624e == null || this.f7646a.f7624e.size() == 0)) {
            SmartAlarmInfo smartAlarmInfo = (SmartAlarmInfo) this.f7646a.f7624e.get(0);
            C2538c.m12677c("SmartAlarmClockActivity", "initView mSmartAlarmList.size()" + this.f7646a.f7624e.size());
            this.f7646a.f7635p = smartAlarmInfo.getSmartAlarmIndex();
            this.f7646a.f7636q = smartAlarmInfo.getSmartAlarmEnable();
            this.f7646a.f7637r = smartAlarmInfo.getSmartAlarmStartTime_hour();
            this.f7646a.f7638s = smartAlarmInfo.getSmartAlarmStartTime_mins();
            this.f7646a.f7639t = smartAlarmInfo.getSmartAlarmRepeat();
            this.f7646a.f7640u = smartAlarmInfo.getSmartAlarmAheadTime();
            C2538c.m12677c("SmartAlarmClockActivity", "initData smartAlarmIndex =" + this.f7646a.f7635p);
            C2538c.m12677c("SmartAlarmClockActivity", "initData smartAlarmEnable =" + this.f7646a.f7636q);
            C2538c.m12677c("SmartAlarmClockActivity", "initData smartAlarmStartHourTime = " + this.f7646a.f7637r);
            C2538c.m12677c("SmartAlarmClockActivity", "initData smartAlarmStartMinTime =" + this.f7646a.f7638s);
            C2538c.m12677c("SmartAlarmClockActivity", "initData smartAlarmRepeat =" + this.f7646a.f7639t);
            C2538c.m12677c("SmartAlarmClockActivity", "initData smartAlarmAheadTime =" + this.f7646a.f7640u);
            this.f7646a.m11047a(this.f7646a.f7640u);
            this.f7646a.f7632m = this.f7646a.f7639t;
        }
        this.f7646a.f7616B.sendEmptyMessage(1);
    }
}
