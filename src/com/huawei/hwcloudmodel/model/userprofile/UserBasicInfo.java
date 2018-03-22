package com.huawei.hwcloudmodel.model.userprofile;

import java.io.Serializable;

public class UserBasicInfo implements Serializable {
    private static final long serialVersionUID = -3185409940237567052L;
    private Integer birthday;
    private String email;
    private Integer gender;
    private Integer height;
    private String mobile;
    private Long modifyTime;
    private String name;
    private String portraitUrl;
    private Integer unitType;
    private Integer weight;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Integer getGender() {
        return this.gender;
    }

    public void setGender(Integer num) {
        this.gender = num;
    }

    public Integer getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Integer num) {
        this.birthday = num;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public String getPortraitUrl() {
        return this.portraitUrl;
    }

    public void setPortraitUrl(String str) {
        this.portraitUrl = str;
    }

    public Integer getUnitType() {
        return this.unitType;
    }

    public void setUnitType(Integer num) {
        this.unitType = num;
    }

    public Long getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(Long l) {
        this.modifyTime = l;
    }

    public String toString() {
        return "UserBasicInfo{name='" + this.name + '\'' + ", gender=" + this.gender + ", birthday=" + this.birthday + ", weight=" + this.weight + ", height=" + this.height + ", email='" + this.email + '\'' + ", mobile='" + this.mobile + '\'' + ", portraitUrl='" + this.portraitUrl + '\'' + ", unitType=" + this.unitType + ", modifyTime=" + this.modifyTime + '}';
    }
}
