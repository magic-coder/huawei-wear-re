package com.huawei.pluginkidwatch.home.push.bean;

public class BindMessageBean extends KOnePushBeanBase {
    public BindMessage data = new BindMessage();

    public class BindMessage {
        public String nickname = "";
        public String phoneNum = "";
        public String recordId = "";

        public void getBindMessageName() {
        }

        public void requestBindMessageHeadUrl() {
        }

        public void downloadBindMessageNameUrl() {
        }

        public void judgeBindMessageWeightBySomeInfo() {
        }

        public void setBindMessageSwitchUpload() {
        }

        public void updataBindMessageLocalTable() {
        }

        public void dealWithBindMessageResetFactory() {
        }

        public void refreshBindMessageInitData() {
        }

        public void queryBindMessageProcessData() {
        }

        public void contrustBindMessageHeadImage() {
        }

        public void changeBindMessageDeviceInfo() {
        }
    }

    public String toString() {
        return "recordId:" + this.data.recordId + "  phoneNum:" + this.data.phoneNum + "  nickname:" + this.data.nickname + " deviceCode:" + this.deviceCode + " time:" + this.time + " type:" + this.type;
    }
}
