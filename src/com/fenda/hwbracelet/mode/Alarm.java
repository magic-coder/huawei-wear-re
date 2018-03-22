package com.fenda.hwbracelet.mode;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Alarm implements Parcelable {
    public static final Creator<Alarm> CREATOR = new C3618a();
    private int fri;
    private int id;
    private int mon;
    private String name;
    private int onOff;
    private int sat;
    private int sun;
    private int thu;
    private String time;
    private int tue;
    private int wed;

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public int getSun() {
        return this.sun;
    }

    public void setSun(int i) {
        this.sun = i;
    }

    public int getMon() {
        return this.mon;
    }

    public void setMon(int i) {
        this.mon = i;
    }

    public int getTue() {
        return this.tue;
    }

    public void setTue(int i) {
        this.tue = i;
    }

    public int getWed() {
        return this.wed;
    }

    public void setWed(int i) {
        this.wed = i;
    }

    public int getThu() {
        return this.thu;
    }

    public void setThu(int i) {
        this.thu = i;
    }

    public int getFri() {
        return this.fri;
    }

    public void setFri(int i) {
        this.fri = i;
    }

    public int getSta() {
        return this.sat;
    }

    public void setSta(int i) {
        this.sat = i;
    }

    public int getOnOff() {
        return this.onOff;
    }

    public void setOnOff(int i) {
        this.onOff = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.time);
        parcel.writeInt(this.sun);
        parcel.writeInt(this.mon);
        parcel.writeInt(this.tue);
        parcel.writeInt(this.wed);
        parcel.writeInt(this.thu);
        parcel.writeInt(this.fri);
        parcel.writeInt(this.sat);
        parcel.writeInt(this.onOff);
    }
}
