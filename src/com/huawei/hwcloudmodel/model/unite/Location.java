package com.huawei.hwcloudmodel.model.unite;

import java.io.Serializable;

public class Location implements Serializable, Cloneable {
    private static final long serialVersionUID = -3816465305762918837L;
    private double altitude;
    private double latitude;
    private double longitude;
    private String name;
    private Long timestamp;

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long l) {
        this.timestamp = l;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public void setAltitude(double d) {
        this.altitude = d;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "Location [" + "timestamp=" + this.timestamp + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ", altitude=" + this.altitude + ", name=" + this.name + "]";
    }

    public Location clone() {
        try {
            return (Location) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
