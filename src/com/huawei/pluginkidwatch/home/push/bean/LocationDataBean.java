package com.huawei.pluginkidwatch.home.push.bean;

public class LocationDataBean extends KOnePushBeanBase {
    public LocationData data = new LocationData();

    public class LocationData {
        public String elev = "";
        public String hacc = "";
        public String lat = "";
        public String lon = "";
        public String name = "";
        public String radius = "";
        public String time = "";

        public void selectLocationLonPrc() {
        }

        public void selectLocationLatPrc() {
        }

        public void mobileLocationHacc() {
        }

        public void initLocationHaccAndName() {
        }

        public void initRadiusByLonLat() {
        }

        public void processReceiveLonTime() {
        }
    }

    public String toString() {
        return "time=" + this.data.time + " lon=" + this.data.lon + " lat=" + this.data.lat + " elev=" + this.data.elev + " hacc=" + this.data.hacc + " name=" + this.data.name + " radius=" + this.data.radius;
    }
}
