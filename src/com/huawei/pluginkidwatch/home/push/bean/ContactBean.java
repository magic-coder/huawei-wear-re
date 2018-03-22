package com.huawei.pluginkidwatch.home.push.bean;

public class ContactBean extends KOnePushBeanBase {
    public Contact data = new Contact();

    public class Contact {
        public int contactId = -1;
        public String headIcon = "";
        public String name = "";
        public String phoneNum = "";
        public String type = "";

        public void getContactsBeanName() {
        }

        public void requestContactsBeanHeadUrl() {
        }

        public void downloadContactsBeanNameUrl() {
        }

        public void judgeContactsBeanWeightBySomeInfo() {
        }

        public void setContactsBeanSwitchUpload() {
        }

        public void updataContactsBeanLocalTable() {
        }

        public void dealWithContactsBeanResetFactory() {
        }

        public void refreshContactsBeanInitData() {
        }

        public void queryContactsBeanProcessData() {
        }

        public void contrustContactsBeanHeadImage() {
        }

        public void changeContactsBeanDeviceInfo() {
        }
    }

    public String toString() {
        return "contactId:" + this.data.contactId + "  phoneNum:" + this.data.phoneNum + "  name:" + this.data.name + " type:" + this.data.type + " headIcon:" + this.data.headIcon + " deviceCode:" + this.deviceCode + " time:" + this.time + " type:" + this.type;
    }
}
