package com.huawei.pluginkidwatch.home.push.bean;

public class UpdataBean extends KOnePushBeanBase {
    public Updata data = new Updata();

    public class Updata {
        public int deviceCode = -1;
        public int eventId = -1;
        public String eventStr = "";
        public int subeventId = -1;

        public String toString() {
            return "Updata{deviceCode=" + this.deviceCode + ", eventId=" + this.eventId + ", subeventId=" + this.subeventId + ", eventStr='" + this.eventStr + '\'' + '}';
        }

        public void getUpdataName() {
        }

        public void requestUpdataHeadUrl() {
        }

        public void downloadUpdataNameUrl() {
        }

        public void judgeUpdataWeightBySomeInfo() {
        }

        public void setUpdataSwitchUpload() {
        }

        public void updataUpdataLocalTable() {
        }

        public void dealWithUpdataResetFactory() {
        }

        public void refreshUpdataInitData() {
        }

        public void queryUpdataProcessData() {
        }

        public void contrustUpdataHeadImage() {
        }

        public void changeUpdataDeviceInfo() {
        }
    }

    public String toString() {
        return "UpdataBean{data=" + this.data + '}';
    }

    public void updateDevcieCode() {
    }

    public void initEventIDAddEvent() {
    }

    public void buildSubEventID() {
    }

    public void addEventAddSum() {
    }

    public void updataBeanLocalTable() {
    }

    public void dealWithBeanResetFactory() {
    }

    public void refreshBeanInitData() {
    }

    public void queryBeanProcessData() {
    }

    public void contrustBeanHeadImage() {
    }

    public void changeBeanDeviceInfo() {
    }
}
