package com.huawei.pluginkidwatch.home.push.bean;

public class SOSMessageBean extends KOnePushBeanBase {
    public SOS data = new SOS();

    public class SOS {
        public String elev = "";
        public String hacc = "";
        public String lat = "";
        public String lon = "";
        public String name = "";
        public String radius = "";
        public String time = "";
        public String type = "";

        public void initLonAndLat() {
        }

        public void initHaccElev() {
        }

        public void selectRadiusDrawLine() {
        }

        public void getSOSTypeByLonLat() {
        }

        public void quereElevByMessage() {
        }

        public void clickSoSDataProcess() {
        }
    }

    public String toString() {
        return "SOS.time:" + this.data.time + "SOS.lon:" + this.data.lon + "SOS.lat:" + this.data.lat + "SOS.elev:" + this.data.elev + "SOS.hacc:" + this.data.hacc + "SOS.name:" + this.data.name + "SOS.radius:" + this.data.radius + "SOS.type:" + this.data.type;
    }
}
