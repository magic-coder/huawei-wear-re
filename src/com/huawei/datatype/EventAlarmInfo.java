package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.hwcommonmodel.p064d.C4734m;

import java.util.Calendar;
import java.util.Date;

public class EventAlarmInfo {
    private static final String TAG = "EventAlarmInfo";
    private int eventAlarmEnable = 0;
    private int eventAlarmIndex = 1;
    private String eventAlarmName = "闹钟";
    private int eventAlarmRepeat = 0;
    private int eventAlarmStartTime_hour = 7;
    private int eventAlarmStartTime_mins = 0;
    private long eventAlarmTime = 0;

    public int getEventAlarmIndex() {
        return ((Integer) C0978h.a(Integer.valueOf(this.eventAlarmIndex))).intValue();
    }

    public void setEventAlarmIndex(int i) {
        this.eventAlarmIndex = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getEventAlarmEnable() {
        return ((Integer) C0978h.a(Integer.valueOf(this.eventAlarmEnable))).intValue();
    }

    public void setEventAlarmEnable(int i) {
        this.eventAlarmEnable = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getEventAlarmStartTime_hour() {
        return ((Integer) C0978h.a(Integer.valueOf(this.eventAlarmStartTime_hour))).intValue();
    }

    public void setEventAlarmStartTime_hour(int i) {
        this.eventAlarmStartTime_hour = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getEventAlarmStartTime_mins() {
        return ((Integer) C0978h.a(Integer.valueOf(this.eventAlarmStartTime_mins))).intValue();
    }

    public void setEventAlarmStartTime_mins(int i) {
        this.eventAlarmStartTime_mins = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getEventAlarmRepeat() {
        return ((Integer) C0978h.a(Integer.valueOf(this.eventAlarmRepeat))).intValue();
    }

    public void setEventAlarmRepeat(int i) {
        this.eventAlarmRepeat = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String getEventAlarmName() {
        return (String) C0978h.a(this.eventAlarmName);
    }

    public void setEventAlarmName(String str) {
        this.eventAlarmName = (String) C0978h.a(str);
    }

    public long getEventAlarmTime() {
        return ((Long) C0978h.a(Long.valueOf(this.eventAlarmTime))).longValue();
    }

    public void setEventAlarmTime(long j) {
        this.eventAlarmTime = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public EventAlarmInfo resetAlarm(EventAlarmInfo eventAlarmInfo, int i) {
        Date c;
        Date a = C4734m.m22640a();
        Calendar instance = Calendar.getInstance();
        instance.setTime(a);
        c.c(TAG, new Object[]{"==once== eventAlarm StartTime_hour = " + eventAlarmInfo.getEventAlarmStartTime_hour() + ", StartTime_mins = " + eventAlarmInfo.getEventAlarmStartTime_mins()});
        instance.set(instance.get(1), instance.get(2), instance.get(5), eventAlarmInfo.getEventAlarmStartTime_hour(), eventAlarmInfo.getEventAlarmStartTime_mins(), 0);
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
        eventAlarmInfo.setEventAlarmTime(C4734m.m22647d(c));
        eventAlarmInfo.setEventAlarmIndex(i + 1);
        return eventAlarmInfo;
    }
}
