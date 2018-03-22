package com.huawei.pluginkidwatch.common.entity.model;

public class SetDeviceProfileModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public String bigPortraitUrl = "";
    public String birthday = "";
    public int deviceCode = -1;
    public int grade = 0;
    public int height = 0;
    public String largePortraitUrl = "";
    public String middlePortraitUrl = "";
    public String name = "";
    public String portraitImg = "";
    public String portraitImgName = "";
    public String portraitUrl = "";
    public int sex = 0;
    public String simCardNum = "";
    public String smallPortraitUrl = "";
    public int weight = 0;

    public String getNameBySex() {
        String str = "";
        if (this.sex != 0) {
            return this.portraitImg;
        }
        return this.portraitImgName;
    }

    public String requestHeadUrl() {
        String str = this.smallPortraitUrl;
        if (this.height > 80 && this.height < 120) {
            return this.middlePortraitUrl;
        }
        if (this.height > 120) {
            return this.largePortraitUrl;
        }
        return str;
    }

    public String downloadNameUrl() {
        String str = "";
        if (this.name != null && !this.name.isEmpty()) {
            return str;
        }
        if (this.grade > 3) {
            return this.bigPortraitUrl;
        }
        return this.portraitUrl;
    }

    public boolean judgeWeightBySomeInfo() {
        if (this.birthday == null || this.birthday.isEmpty() || this.height <= 90 || this.weight <= 50) {
            return false;
        }
        return true;
    }

    public void smallPortraitImageProcess() {
    }

    public void addMiddlePortraitUrlInDB() {
    }

    public void judgeChildSex() {
    }

    public void isSafeSimCard() {
    }

    public void gradeWeightByDevice() {
    }

    public void configChildNameBirthday() {
    }

    public void usedBigPortraitImage() {
    }

    public void foundWeightSexName() {
    }

    public String toString() {
        return "  deviceCode = " + this.deviceCode + "  name = " + this.name + "  smallPortraitUrl = " + this.smallPortraitUrl + "  middlePortraitUrl = " + this.middlePortraitUrl + "  largePortraitUrl = " + this.largePortraitUrl + "  birthday = " + this.birthday + "  height = " + this.height + "  weight = " + this.weight + "  sex = " + this.sex + "  grade = " + this.grade + "  simCardNum = " + this.simCardNum + "  portraitImg = " + this.portraitImg + "  portraitImgName = " + this.portraitImgName + "bigPortraitUrl = " + this.bigPortraitUrl + "    portraitUrl = " + this.portraitUrl;
    }
}
