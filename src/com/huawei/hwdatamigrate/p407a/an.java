package com.huawei.hwdatamigrate.p407a;

/* compiled from: SportDatasTable */
public class an extends al {
    public int f17463I;
    public String f17464J;
    public boolean f17465K;
    public String f17466L;
    public String f17467M;
    public int f17468N;
    StringBuilder f17469O = new StringBuilder();

    public String m22814a() {
        return "SportDatasTable [id=" + this.f17463I + ", curDate=" + this.f17466L + ", mac=" + this.f17467M + ", isUpload=" + this.f17465K + ", totalSteps=" + this.t + ", totalDistance=" + this.u + ", totalCalories=" + this.v + ", sportDuration=" + this.w + ", totalWalkTime=" + this.p + ", totalRunTime=" + this.m + ", totalRideTime=" + this.n + ", totalClimbTime=" + this.o + ", steps=" + this.q + "]";
    }

    public String toString() {
        this.f17469O.append("SportDatasTable [ID=");
        this.f17469O.append(this.f17463I);
        this.f17469O.append(", userID=");
        this.f17469O.append(this.f17464J);
        this.f17469O.append(", isUpload=");
        this.f17469O.append(this.f17465K);
        this.f17469O.append(", curDate=");
        this.f17469O.append(this.f17466L);
        this.f17469O.append(", mac=");
        this.f17469O.append(this.f17467M);
        this.f17469O.append(", steps=");
        this.f17469O.append(this.q);
        this.f17469O.append(", meters=");
        this.f17469O.append(this.r);
        this.f17469O.append(", calories=");
        this.f17469O.append(this.s);
        this.f17469O.append(", totalSteps=");
        this.f17469O.append(this.t);
        this.f17469O.append(", totalDistance=");
        this.f17469O.append(this.u);
        this.f17469O.append(", totalCalories=");
        this.f17469O.append(this.v);
        this.f17469O.append(", sportDuration=");
        this.f17469O.append(this.w);
        this.f17469O.append(", totalWalkSteps=");
        this.f17469O.append(this.F);
        this.f17469O.append(", totalWalkDistance=");
        this.f17469O.append(this.G);
        this.f17469O.append(", totalWalkCalories=");
        this.f17469O.append(this.H);
        this.f17469O.append(", totalWalkTime=");
        this.f17469O.append(this.p);
        this.f17469O.append(", totalRunSteps=");
        this.f17469O.append(this.x);
        this.f17469O.append(", totalRunDistance =");
        this.f17469O.append(this.y);
        this.f17469O.append(", totalRunCalories=");
        this.f17469O.append(this.z);
        this.f17469O.append(", totalRunTime=");
        this.f17469O.append(this.m);
        this.f17469O.append(", totalRideDistance=");
        this.f17469O.append(this.A);
        this.f17469O.append(", totalRideCalories =");
        this.f17469O.append(this.B);
        this.f17469O.append(", totalRideTime=");
        this.f17469O.append(this.n);
        this.f17469O.append(", totalClimbSteps=");
        this.f17469O.append(this.C);
        this.f17469O.append(", totalClimbHeight=");
        this.f17469O.append(this.D);
        this.f17469O.append(", totalClimbCalories=");
        this.f17469O.append(this.E);
        this.f17469O.append(", totalClimbTime=");
        this.f17469O.append(this.o);
        this.f17469O.append(", stepsDataDetailInMin=");
        this.f17469O.append(this.a);
        this.f17469O.append(", metersDataDetailInMin=");
        this.f17469O.append(this.b);
        this.f17469O.append(", caloriesDataDetailInMin=");
        this.f17469O.append(this.c);
        this.f17469O.append(", runStepsDataDetailInMin=");
        this.f17469O.append(this.d);
        this.f17469O.append(", runMetersDataDetailInMin=");
        this.f17469O.append(this.e);
        this.f17469O.append(", runCaloriesDataDetailInMin=");
        this.f17469O.append(this.f);
        this.f17469O.append(", rideStepsDataDetailInMin=");
        this.f17469O.append(this.g);
        this.f17469O.append(", rideMetersDataDetailInMin=");
        this.f17469O.append(this.h);
        this.f17469O.append(", rideCaloriesDataDetailInMin=");
        this.f17469O.append(this.i);
        this.f17469O.append(", climbStepsDataDetailInMin=");
        this.f17469O.append(this.j);
        this.f17469O.append(", climbMetersDataDetailInMin=");
        this.f17469O.append(this.k);
        this.f17469O.append(", climbCaloriesDataDetailInMin=");
        this.f17469O.append(this.l);
        this.f17469O.append("]");
        String stringBuilder = this.f17469O.toString();
        this.f17469O.delete(0, this.f17469O.length());
        return stringBuilder;
    }
}
