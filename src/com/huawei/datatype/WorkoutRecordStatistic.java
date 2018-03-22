package com.huawei.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class WorkoutRecordStatistic {
    private int swim_avg_swolf = -1;
    private int swim_pool_length = -1;
    private int swim_pull_rate = -1;
    private int swim_pull_times = -1;
    private int swim_trip_times = -1;
    private int swim_type = -1;
    private int workout_Epoc;
    private int workout_HrABS_peak_max;
    private int workout_HrABS_peak_min;
    private long workout_climb;
    private long workout_date_Info;
    private int workout_etraining_effect;
    private long workout_exercise_duration;
    private int workout_load_peak;
    private int workout_maxMET;
    private int workout_record_calorie;
    private int workout_record_distance;
    private long workout_record_end_time;
    private int workout_record_id;
    private int workout_record_speed;
    private long workout_record_start_time;
    private int workout_record_status;
    private long workout_record_step;
    private long workout_record_total_time;
    private int workout_recovery_time;
    private int workout_type;

    public int getSwim_avg_swolf() {
        return ((Integer) C0978h.a(Integer.valueOf(this.swim_avg_swolf))).intValue();
    }

    public void setSwim_avg_swolf(int i) {
        this.swim_avg_swolf = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSwim_pool_length() {
        return ((Integer) C0978h.a(Integer.valueOf(this.swim_pool_length))).intValue();
    }

    public void setSwim_pool_length(int i) {
        this.swim_pool_length = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSwim_pull_rate() {
        return ((Integer) C0978h.a(Integer.valueOf(this.swim_pull_rate))).intValue();
    }

    public void setSwim_pull_rate(int i) {
        this.swim_pull_rate = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSwim_pull_times() {
        return ((Integer) C0978h.a(Integer.valueOf(this.swim_pull_times))).intValue();
    }

    public void setSwim_pull_times(int i) {
        this.swim_pull_times = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSwim_trip_times() {
        return ((Integer) C0978h.a(Integer.valueOf(this.swim_trip_times))).intValue();
    }

    public void setSwim_trip_times(int i) {
        this.swim_trip_times = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getSwim_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.swim_type))).intValue();
    }

    public void setSwim_type(int i) {
        this.swim_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_record_id() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_record_id))).intValue();
    }

    public void setWorkout_record_id(int i) {
        this.workout_record_id = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_record_status() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_record_status))).intValue();
    }

    public void setWorkout_record_status(int i) {
        this.workout_record_status = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getWorkout_record_start_time() {
        return ((Long) C0978h.a(Long.valueOf(this.workout_record_start_time))).longValue();
    }

    public void setWorkout_record_start_time(long j) {
        this.workout_record_start_time = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long getWorkout_record_end_time() {
        return ((Long) C0978h.a(Long.valueOf(this.workout_record_end_time))).longValue();
    }

    public void setWorkout_record_end_time(long j) {
        this.workout_record_end_time = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int getWorkout_record_calorie() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_record_calorie))).intValue();
    }

    public void setWorkout_record_calorie(int i) {
        this.workout_record_calorie = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_record_distance() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_record_distance))).intValue();
    }

    public void setWorkout_record_distance(int i) {
        this.workout_record_distance = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getWorkout_record_step() {
        return ((Long) C0978h.a(Long.valueOf(this.workout_record_step))).longValue();
    }

    public void setWorkout_record_step(long j) {
        this.workout_record_step = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long getWorkout_record_total_time() {
        return ((Long) C0978h.a(Long.valueOf(this.workout_record_total_time))).longValue();
    }

    public void setWorkout_record_total_time(long j) {
        this.workout_record_total_time = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int getWorkout_record_speed() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_record_speed))).intValue();
    }

    public void setWorkout_record_speed(int i) {
        this.workout_record_speed = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getWorkout_climb() {
        return ((Long) C0978h.a(Long.valueOf(this.workout_climb))).longValue();
    }

    public void setWorkout_climb(long j) {
        this.workout_climb = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int getWorkout_HrABS_peak_max() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_HrABS_peak_max))).intValue();
    }

    public void setWorkout_HrABS_peak_max(int i) {
        this.workout_HrABS_peak_max = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_HrABS_peak_min() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_HrABS_peak_min))).intValue();
    }

    public void setWorkout_HrABS_peak_min(int i) {
        this.workout_HrABS_peak_min = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_load_peak() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_load_peak))).intValue();
    }

    public void setWorkout_load_peak(int i) {
        this.workout_load_peak = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_etraining_effect() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_etraining_effect))).intValue();
    }

    public void setWorkout_etraining_effect(int i) {
        this.workout_etraining_effect = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_Epoc() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_Epoc))).intValue();
    }

    public void setWorkout_Epoc(int i) {
        this.workout_Epoc = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_maxMET() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_maxMET))).intValue();
    }

    public void setWorkout_maxMET(int i) {
        this.workout_maxMET = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_recovery_time() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_recovery_time))).intValue();
    }

    public void setWorkout_recovery_time(int i) {
        this.workout_recovery_time = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long getWorkout_exercise_duration() {
        return ((Long) C0978h.a(Long.valueOf(this.workout_exercise_duration))).longValue();
    }

    public void setWorkout_exercise_duration(long j) {
        this.workout_exercise_duration = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long getWorkout_date_Info() {
        return ((Long) C0978h.a(Long.valueOf(this.workout_date_Info))).longValue();
    }

    public void setWorkout_date_Info(long j) {
        this.workout_date_Info = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public void setWorkout_type(int i) {
        this.workout_type = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getWorkout_type() {
        return ((Integer) C0978h.a(Integer.valueOf(this.workout_type))).intValue();
    }
}
