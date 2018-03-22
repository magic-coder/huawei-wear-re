package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.hwcommonmodel.p064d.C4734m;

import java.util.Calendar;
import java.util.Date;

public class SmartAlarmInfo {
    private static final String TAG = "SmartAlarmInfo";
    private int smartAlarmAheadTime = 0;
    private int smartAlarmEnable = 0;
    private int smartAlarmIndex = 1;
    private int smartAlarmRepeat = 31;
    private int smartAlarmStartTime_hour = 7;
    private int smartAlarmStartTime_mins = 0;
    private long smartAlarmTime = 0;

    public int getSmartAlarmIndex() {
        return ((Integer) C0978h.a(Integer.valueOf(this.smartAlarmIndex))).intValue();
    }

    public void setSmartAlarmIndex(int i) {
        this.smartAlarmIndex = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSmartAlarmEnable() {
        return ((Integer) C0978h.a(Integer.valueOf(this.smartAlarmEnable))).intValue();
    }

    public void setSmartAlarmEnable(int i) {
        this.smartAlarmEnable = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSmartAlarmStartTime_hour() {
        return ((Integer) C0978h.a(Integer.valueOf(this.smartAlarmStartTime_hour))).intValue();
    }

    public void setSmartAlarmStartTime_hour(int i) {
        this.smartAlarmStartTime_hour = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSmartAlarmStartTime_mins() {
        return ((Integer) C0978h.a(Integer.valueOf(this.smartAlarmStartTime_mins))).intValue();
    }

    public void setSmartAlarmStartTime_mins(int i) {
        this.smartAlarmStartTime_mins = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSmartAlarmRepeat() {
        return ((Integer) C0978h.a(Integer.valueOf(this.smartAlarmRepeat))).intValue();
    }

    public void setSmartAlarmRepeat(int i) {
        this.smartAlarmRepeat = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSmartAlarmAheadTime() {
        return ((Integer) C0978h.a(Integer.valueOf(this.smartAlarmAheadTime))).intValue();
    }

    public void setSmartAlarmAheadTime(int i) {
        this.smartAlarmAheadTime = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getSmartAlarmTime() {
        return ((Long) C0978h.a(Long.valueOf(this.smartAlarmTime))).longValue();
    }

    public void setSmartAlarmTime(long j) {
        this.smartAlarmTime = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public SmartAlarmInfo resetSmartAlarm(SmartAlarmInfo smartAlarmInfo, int i) {
        Date c;
        Date a = C4734m.m22640a();
        Calendar instance = Calendar.getInstance();
        instance.setTime(a);
        c.c(TAG, new Object[]{"==once== saveOnceSmartAlarm StartTime_hour = " + smartAlarmInfo.getSmartAlarmStartTime_hour() + ", StartTime_mins = " + smartAlarmInfo.getSmartAlarmStartTime_mins()});
        instance.set(instance.get(1), instance.get(2), instance.get(5), smartAlarmInfo.getSmartAlarmStartTime_hour(), smartAlarmInfo.getSmartAlarmStartTime_mins(), 0);
        a = instance.getTime();
        c.c(TAG, new Object[]{"==once== today alarm = " + C4734m.m22638a(instance.getTime()) + ", today long = " + instance.getTime().getTime()});
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        c.c(TAG, new Object[]{"==once== CurTime = " + currentTimeMillis});
        if (currentTimeMillis > C4734m.m22647d(instance.getTime())) {
            c = C4734m.m22646c(instance.getTime());
        } else {
            c = a;
        }
        c.c(TAG, new Object[]{"==once== alarmDate = " + C4734m.m22638a(c)});
        c.c(TAG, new Object[]{"==once== alarmDate long = " + C4734m.m22647d(c)});
        smartAlarmInfo.setSmartAlarmTime(C4734m.m22647d(c));
        smartAlarmInfo.setSmartAlarmIndex(i + 1);
        return smartAlarmInfo;
    }
}
