package com.huawei.pluginkidwatch.home.push.bean;

import java.util.ArrayList;
import java.util.List;

public class MissCallDataBean extends KOnePushBeanBase {
    public List<MissCallData> data = new ArrayList();

    public class MissCallData {
        public String duration = "";
        public String phoneNum = "";
        public String rejectReason = "";
        public String time = "";
        public String type = "";

        public void setTime(String str) {
            this.time = str;
        }

        public String getTime() {
            return this.time;
        }

        public void setPhoneNum(String str) {
            this.phoneNum = str;
        }

        public String getPhoneNum() {
            return this.phoneNum;
        }

        public void setDuration(String str) {
            this.duration = str;
        }

        public String getDuration() {
            return this.duration;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getType() {
            return this.type;
        }

        public String rejectReasonDuration() {
            String str = "";
            if (this.rejectReason == null || this.rejectReason.isEmpty()) {
                return str;
            }
            if (this.type == null || this.type.compareTo("18") <= 0 || this.duration == null) {
                return this.time;
            }
            return this.duration;
        }

        public void getMissCallDataName() {
        }

        public void requestMissCallDataHeadUrl() {
        }

        public void downloadMissCallDataNameUrl() {
        }

        public void judgeMissCallDataWeightBySomeInfo() {
        }

        public void setMissCallDataSwitchUpload() {
        }

        public void updataMissCallDataLocalTable() {
        }

        public void dealWithMissCallDataResetFactory() {
        }

        public void refreshMissCallDataInitData() {
        }

        public void queryMissCallDataProcessData() {
        }

        public void contrustMissCallDataHeadImage() {
        }

        public void changeMissCallDataDeviceInfo() {
        }

        public String toString() {
            return "MissCallData{time='" + this.time + '\'' + ", phoneNum='" + this.phoneNum + '\'' + ", duration='" + this.duration + '\'' + ", rejectReason='" + this.rejectReason + '\'' + ", type='" + this.type + '\'' + '}';
        }
    }

    public String toString() {
        return "MissCallDataBean{data=" + this.data + '}';
    }
}
