package com.huawei.hwcommonmodel.fitnessdatatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class MotionGoal {
    public static final int HW_FITNESS_CALORIE_GOAL = 2;
    public static final int HW_FITNESS_DISTANCE_GOAL = 4;
    public static final int HW_FITNESS_DURATION_GOAL = 8;
    public static final int HW_FITNESS_GOAL_DAY = 1;
    public static final int HW_FITNESS_GOAL_SINGLE = 3;
    public static final int HW_FITNESS_GOAL_WEEK = 2;
    public static final int HW_FITNESS_STEPS_GOAL = 1;
    private int calorieGoal = 0;
    private int dataType = 1;
    private int distanceGoal = 0;
    private int dutationGoal = 0;
    private int goalType = 1;
    private int motionType = 0;
    private int stepGoal = 10000;

    public int getGoalType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.goalType))).intValue();
    }

    public void setGoalType(int i) {
        this.goalType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getMotionType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.motionType))).intValue();
    }

    public void setMotionType(int i) {
        this.motionType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void setDataType(int i) {
        this.dataType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getDataType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.dataType))).intValue();
    }

    public int getStepGoal() {
        return ((Integer) C0978h.a(Integer.valueOf(this.stepGoal))).intValue();
    }

    public void setStepGoal(int i) {
        this.stepGoal = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getCalorieGoal() {
        return ((Integer) C0978h.a(Integer.valueOf(this.calorieGoal))).intValue();
    }

    public void setCalorieGoal(int i) {
        this.calorieGoal = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getDistanceGoal() {
        return ((Integer) C0978h.a(Integer.valueOf(this.distanceGoal))).intValue();
    }

    public void setDistanceGoal(int i) {
        this.distanceGoal = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getDutationGoal() {
        return ((Integer) C0978h.a(Integer.valueOf(this.dutationGoal))).intValue();
    }

    public void setDutationGoal(int i) {
        this.dutationGoal = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getCurrValue() {
        switch (this.dataType) {
            case 1:
                return this.stepGoal;
            case 2:
                return this.calorieGoal;
            case 4:
                return this.distanceGoal;
            case 8:
                return this.dutationGoal;
            default:
                return this.stepGoal;
        }
    }

    public String toString() {
        return "MotionGoal{goalType=" + this.goalType + ", motionType=" + this.motionType + ", dataType=" + this.dataType + ", stepGoal=" + this.stepGoal + ", calorieGoal=" + this.calorieGoal + ", distanceGoal=" + this.distanceGoal + ", dutationGoal=" + this.dutationGoal + '}';
    }
}
