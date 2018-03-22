package com.huawei.pluginkidwatch.common.entity.model;

import com.huawei.p190v.C2538c;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlarmItem {
    public String cycle = "";
    public String endTime = "";
    public String isActive = "";
    public String label = "";
    public String startTime = "";
    public int type = 0;

    final class C14631 implements Comparator<AlarmItem> {
        C14631() {
        }

        public int compare(AlarmItem alarmItem, AlarmItem alarmItem2) {
            if (alarmItem.startTime == null) {
                return 0;
            }
            return alarmItem.startTime.compareTo(alarmItem2.startTime);
        }
    }

    public interface alarmItemSAI10 {
    }

    public interface alarmItemSAI112 {
    }

    public interface alarmItemSAI113 {
    }

    public interface alarmItemSAI114 {
    }

    public interface alarmItemSAI115 {
    }

    public interface alarmItemSAI116 {
    }

    public interface alarmItemSAI11 {
    }

    public interface alarmItemSAI12 {
    }

    public interface alarmItemSAI13 {
    }

    public interface alarmItemSAI14 {
    }

    public interface alarmItemSAI15 {
    }

    public interface alarmItemSAI16 {
    }

    public interface alarmItemSAI17 {
    }

    public interface alarmItemSAI18 {
    }

    public interface alarmItemSAI19 {
    }

    public interface alarmItemSAI1 {
    }

    public interface alarmItemSAI2 {
    }

    public interface alarmItemSAI3 {
    }

    public interface alarmItemSAI4 {
    }

    public interface alarmItemSAI5 {
    }

    public interface alarmItemSAI6 {
    }

    public interface alarmItemSAI7 {
    }

    public interface alarmItemSAI8 {
    }

    public interface alarmItemSAI9 {
    }

    public static void sort(List<AlarmItem> list) {
        if (list != null && list.size() != 0 && 1 != list.size()) {
            C2538c.m12674b("Alarm sort start", list.toString());
            Collections.sort(list, new C14631());
            C2538c.m12674b("Alarm sort end", list.toString());
        }
    }

    public String toString() {
        return "AlarmItem [startTime=" + this.startTime + ", endTime=" + this.endTime + ", cycle=" + this.cycle + ", label=" + this.label + ", isActive=" + this.isActive + ", type=" + this.type + "]";
    }

    public String displayActiveLabel() {
        String str = "";
        if (this.isActive == null || this.isActive.isEmpty()) {
            return str;
        }
        if (this.isActive.compareTo("true") == 0) {
            return this.label;
        }
        if (1 == this.type) {
            return "heshui";
        }
        if (2 == this.type) {
            return "yundong";
        }
        return "other";
    }

    public String getTitleByCycle() {
        String str = "qichaung";
        if (this.cycle == null || this.cycle.compareTo("-1") != 0) {
            return str;
        }
        return this.label;
    }

    public void getAlarmDataName() {
    }

    public void requestAlarmDataHeadUrl() {
    }

    public void downloadAlarmDataNameUrl() {
    }

    public void judgeAlarmDataWeightBySomeInfo() {
    }

    public void setAlarmDataSwitchUpload() {
    }

    public void updataAlarmDataLocalTable() {
    }

    public void dealWithAlarmDataResetFactory() {
    }

    public void refreshAlarmDataInitData() {
    }

    public void queryAlarmDataProcessData() {
    }

    public void contrustAlarmDataHeadImage() {
    }

    public void changeAlarmDataDeviceInfo() {
    }
}
