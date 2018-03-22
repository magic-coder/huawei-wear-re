package com.huawei.hwcloudmodel.model.userprofile;

import com.huawei.hihealth.HiUserInfo;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import java.io.Serializable;

public class UserProfile implements Serializable {
    private static final long serialVersionUID = -3185409940237567052L;
    private String birthday;
    private Integer clientSet;
    private String createTime;
    private String descroption;
    private String email;
    private String favorite;
    private Integer gender = Integer.valueOf(-1);
    private Integer height = Integer.valueOf(HiUserInfo.HEIGHT_DEFAULT);
    private Long huid;
    private String languageCode = PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH;
    private Integer lastUpdateVersion = Integer.valueOf(0);
    private String name;
    private String phoneNum;
    private String portraitData;
    private String portraitFileName;
    private String portraitUrl;
    private Integer privacy;
    private String sleepEndTime;
    private String sleepStartTime;
    private String updateTime;
    private Integer weight = Integer.valueOf(60);

    public Long getHuid() {
        return this.huid;
    }

    public void setHuid(Long l) {
        this.huid = l;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(Integer num) {
        this.weight = num;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(Integer num) {
        this.height = num;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPortraitData() {
        return this.portraitData;
    }

    public void setPortraitData(String str) {
        this.portraitData = str;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String str) {
        this.createTime = str;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public String getFavorite() {
        return this.favorite;
    }

    public void setFavorite(String str) {
        this.favorite = str;
    }

    public String getPortraitUrl() {
        return this.portraitUrl;
    }

    public void setPortraitUrl(String str) {
        this.portraitUrl = str;
    }

    public String getPortraitFileName() {
        return this.portraitFileName;
    }

    public void setPortraitFileName(String str) {
        this.portraitFileName = str;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void setLanguageCode(String str) {
        this.languageCode = str;
    }

    public String getSleepStartTime() {
        return this.sleepStartTime;
    }

    public void setSleepStartTime(String str) {
        this.sleepStartTime = str;
    }

    public String getSleepEndTime() {
        return this.sleepEndTime;
    }

    public void setSleepEndTime(String str) {
        this.sleepEndTime = str;
    }

    public Integer getClientSet() {
        return this.clientSet;
    }

    public void setClientSet(Integer num) {
        this.clientSet = num;
    }

    public String getDescroption() {
        return this.descroption;
    }

    public void setDescroption(String str) {
        this.descroption = str;
    }

    public Integer getPrivacy() {
        return this.privacy;
    }

    public void setPrivacy(Integer num) {
        this.privacy = num;
    }

    public Integer getGender() {
        return this.gender;
    }

    public void setGender(Integer num) {
        this.gender = num;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UserProfile [huid=");
        stringBuilder.append(this.huid);
        stringBuilder.append(", birthday=");
        stringBuilder.append(this.birthday);
        stringBuilder.append(", gender=");
        stringBuilder.append(this.gender);
        stringBuilder.append(", weight=");
        stringBuilder.append(this.weight);
        stringBuilder.append(", height=");
        stringBuilder.append(this.height);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", languageCode=");
        stringBuilder.append(this.languageCode);
        stringBuilder.append(", portraitFileName=");
        stringBuilder.append(this.portraitFileName);
        stringBuilder.append(", portraitUrl=");
        stringBuilder.append(this.portraitUrl);
        stringBuilder.append(", favorite=");
        stringBuilder.append(this.favorite);
        stringBuilder.append(", sleepStartTime=");
        stringBuilder.append(this.sleepStartTime);
        stringBuilder.append(", sleepEndTime=");
        stringBuilder.append(this.sleepEndTime);
        stringBuilder.append(", createTime=");
        stringBuilder.append(this.createTime);
        stringBuilder.append(", updateTime=");
        stringBuilder.append(this.updateTime);
        stringBuilder.append(", clientSet=");
        stringBuilder.append(this.clientSet);
        stringBuilder.append(", descroption=");
        stringBuilder.append(this.descroption);
        stringBuilder.append(", privacy=");
        stringBuilder.append(this.privacy);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String str) {
        this.phoneNum = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public Integer getLastUpdateVersion() {
        return this.lastUpdateVersion;
    }

    public void setLastUpdateVersion(Integer num) {
        this.lastUpdateVersion = num;
    }
}
