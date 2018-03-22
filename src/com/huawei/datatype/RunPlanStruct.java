package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.List;

public class RunPlanStruct {
    private long run_plan_date;
    private int run_plan_distance;
    private String run_plan_name;
    private int run_plan_repeats;
    private int run_plan_train_effect;
    private int run_plan_workout_id;
    private List<TrainingStruct> trainingStructList;

    public String getRun_plan_name() {
        return (String) C0978h.a(this.run_plan_name);
    }

    public void setRun_plan_name(String str) {
        this.run_plan_name = (String) C0978h.a(str);
    }

    public long getRun_plan_date() {
        return ((Long) C0978h.a(Long.valueOf(this.run_plan_date))).longValue();
    }

    public void setRun_plan_date(long j) {
        this.run_plan_date = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int getRun_plan_workout_id() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_workout_id))).intValue();
    }

    public void setRun_plan_workout_id(int i) {
        this.run_plan_workout_id = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getRun_plan_train_effect() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_train_effect))).intValue();
    }

    public void setRun_plan_train_effect(int i) {
        this.run_plan_train_effect = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getRun_plan_repeats() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_repeats))).intValue();
    }

    public void setRun_plan_repeats(int i) {
        this.run_plan_repeats = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getRun_plan_distance() {
        return ((Integer) C0978h.a(Integer.valueOf(this.run_plan_distance))).intValue();
    }

    public void setRun_plan_distance(int i) {
        this.run_plan_distance = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public List<TrainingStruct> getTrainingStructList() {
        return (List) C0978h.a(this.trainingStructList);
    }

    public void setTrainingStructList(List<TrainingStruct> list) {
        this.trainingStructList = (List) C0978h.a(list);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.run_plan_name);
        stringBuffer.append(this.run_plan_date);
        stringBuffer.append(this.run_plan_train_effect);
        stringBuffer.append(this.run_plan_repeats);
        stringBuffer.append(this.run_plan_distance);
        if (this.trainingStructList != null) {
            for (TrainingStruct trainingStruct : this.trainingStructList) {
                stringBuffer.append(trainingStruct.toString());
            }
        }
        return stringBuffer.toString();
    }
}
