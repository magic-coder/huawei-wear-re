package com.huawei.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RunPlanSuggestStruct implements Parcelable {
    public static final Creator<RunPlanSuggestStruct> CREATOR = new C43821();
    private int run_plan_suggest_distance;
    private int run_plan_suggest_heart_rate;
    private int run_plan_suggest_heart_state;
    private int run_plan_suggest_rate_reminder;
    private int run_plan_suggest_time;
    private int run_plan_suggest_type;

    final class C43821 implements Creator<RunPlanSuggestStruct> {
        C43821() {
        }

        public RunPlanSuggestStruct createFromParcel(Parcel parcel) {
            RunPlanSuggestStruct runPlanSuggestStruct = new RunPlanSuggestStruct();
            runPlanSuggestStruct.setRun_plan_suggest_type(parcel.readInt());
            runPlanSuggestStruct.setRun_plan_suggest_rate_reminder(parcel.readInt());
            runPlanSuggestStruct.setRun_plan_suggest_distance(parcel.readInt());
            runPlanSuggestStruct.setRun_plan_suggest_time(parcel.readInt());
            runPlanSuggestStruct.setRun_plan_suggest_heart_rate(parcel.readInt());
            runPlanSuggestStruct.setRun_plan_suggest_heart_state(parcel.readInt());
            return runPlanSuggestStruct;
        }

        public RunPlanSuggestStruct[] newArray(int i) {
            return new RunPlanSuggestStruct[i];
        }
    }

    public int getRun_plan_suggest_type() {
        return this.run_plan_suggest_type;
    }

    public void setRun_plan_suggest_type(int i) {
        this.run_plan_suggest_type = i;
    }

    public int getRun_plan_suggest_rate_reminder() {
        return this.run_plan_suggest_rate_reminder;
    }

    public void setRun_plan_suggest_rate_reminder(int i) {
        this.run_plan_suggest_rate_reminder = i;
    }

    public int getRun_plan_suggest_distance() {
        return this.run_plan_suggest_distance;
    }

    public void setRun_plan_suggest_distance(int i) {
        this.run_plan_suggest_distance = i;
    }

    public int getRun_plan_suggest_time() {
        return this.run_plan_suggest_time;
    }

    public void setRun_plan_suggest_time(int i) {
        this.run_plan_suggest_time = i;
    }

    public int getRun_plan_suggest_heart_rate() {
        return this.run_plan_suggest_heart_rate;
    }

    public void setRun_plan_suggest_heart_rate(int i) {
        this.run_plan_suggest_heart_rate = i;
    }

    public int getRun_plan_suggest_heart_state() {
        return this.run_plan_suggest_heart_state;
    }

    public void setRun_plan_suggest_heart_state(int i) {
        this.run_plan_suggest_heart_state = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.run_plan_suggest_type);
        parcel.writeInt(this.run_plan_suggest_rate_reminder);
        parcel.writeInt(this.run_plan_suggest_distance);
        parcel.writeInt(this.run_plan_suggest_time);
        parcel.writeInt(this.run_plan_suggest_heart_rate);
        parcel.writeInt(this.run_plan_suggest_heart_state);
    }
}
