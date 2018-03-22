package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Serializable;

public class DeviceProfile implements Serializable {
    private static final long serialVersionUID = 5227439736012091219L;
    public String bigPortraitUrl = "";
    public String birthday = "";
    public int deviceCode = -1;
    public int deviceType = -1;
    public int grade = 0;
    public int height = 0;
    public String largePortraitUrl = "";
    public String localUrl = "";
    public String mac = "";
    public String middlePortraitUrl = "";
    public String name = "";
    public String portraitImg = "";
    public String portraitImgName = "";
    public String portraitUrl = "";
    public String primaryHuid = "";
    public int sex = 0;
    public String simCardNum = "";
    public String smallPortraitUrl = "";
    public int weight = 0;

    public String toString() {
        String str = "  deviceCode = " + this.deviceCode + "  name = " + this.name + "  localUrl = " + this.localUrl + "  smallPortraitUrl = " + this.smallPortraitUrl + "  middlePortraitUrl = " + this.middlePortraitUrl + "  largePortraitUrl = " + this.largePortraitUrl + "  birthday = " + this.birthday + "  height = " + this.height + "  height = " + this.height + "  sex = " + this.sex + "  grade = " + this.grade + "  simCardNum = " + this.simCardNum + "  portraitImgName = " + this.portraitImgName + "  mac = " + this.mac + "  portraitUrl = " + this.portraitUrl + " primaryHuid=" + this.primaryHuid + "  deviceType= " + this.deviceType + "  bigPortraitUrl= " + this.bigPortraitUrl;
        if ("".equals(this.bigPortraitUrl)) {
            return str + " is null]";
        }
        return str + " is not null]";
    }

    public void addPersonProfileHeight() {
    }

    public void addPersonProfilebirthday() {
    }

    public void addPersonProfiledaviceType() {
    }

    public void combinProfileSmallUrl() {
    }

    public void foundDeviceType() {
    }

    public void foundPersonSex() {
    }

    public void processPrimaryHuid() {
    }

    public void addBigPortraitUrlByDeviceType() {
    }

    public void searchSimCardNumByDeviceType() {
    }

    public void searchDeviceCodeByName() {
    }

    public void searchPortraitImgName() {
    }

    public void jadgePersonAge() {
    }

    public void upadteDeviceCode() {
    }
}
