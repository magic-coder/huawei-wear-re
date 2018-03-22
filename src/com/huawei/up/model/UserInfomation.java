package com.huawei.up.model;

import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwcommonmodel.d.n;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.p190v.C2538c;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UserInfomation implements Serializable {
    public static final int DATA_NOT_CHANGED = -1000;
    public static final int GENDER_FEMALE = 1;
    public static final int GENDER_MALE = 0;
    public static final int GENDER_SECRET = 2;
    public static final int GENDER_UNKNOWN = -1;
    private static final int HEIGHT_DEFAULT_ENGLISH = 0;
    private static final int HEIGHT_DEFAULT_METRIC = 0;
    public static final String KEY_USER_INFO = "userinfo_key";
    public static final int UNIT_TYPE_ENGLISH = 1;
    public static final int UNIT_TYPE_METRIC = 0;
    private static final int WEIGHT_DEFAULT_ENGLISH = 0;
    private static final int WEIGHT_DEFAULT_METRIC = 0;
    private static final long serialVersionUID = -318540945237567052L;
    private String birthday = "19900801";
    private int clientSet;
    private int gender = -1;
    private int height = 0;
    private String languageCode = PayManagerSettingSwitchDialog.LANGUAGE_CODE_ZH;
    private String name;
    private String picPath;
    private String portraitUrl;
    private long setTime;
    private int weight = 0;

    public UserInfomation() {
        if (C0956c.m3349a()) {
            this.clientSet = 1;
            this.weight = 0;
            this.height = 0;
            return;
        }
        this.clientSet = 0;
        this.weight = 0;
        this.height = 0;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public int getAge() {
        int i = 0;
        try {
            return (Integer.parseInt(new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(new Date())) - Integer.parseInt(this.birthday)) / 10000;
        } catch (Exception e) {
            C2538c.m12674b("UserInfomation", "setDataUserInfo get brithday error:" + e);
            return i;
        }
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(Integer num) {
        if (num != null) {
            this.weight = num.intValue();
        }
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(Integer num) {
        if (num != null) {
            this.height = num.intValue();
        }
    }

    private int transHeightUnit(int i, int i2, int i3) {
        if (i2 == 1 && i3 == 0) {
            return n.a(i);
        }
        if (i2 == 0 && i3 == 1) {
            return n.b(i);
        }
        return 0;
    }

    private int transWeightUnit(int i, int i2, int i3) {
        if (i2 == 1 && i3 == 0) {
            return n.c(i);
        }
        if (i2 == 0 && i3 == 1) {
            return n.a((float) i);
        }
        return 0;
    }

    public int getMetricHeight() {
        if (this.clientSet == 0) {
            return this.height;
        }
        return transHeightUnit(this.height, this.clientSet, 0);
    }

    public int getMetricWeight() {
        if (this.clientSet == 0) {
            return this.weight;
        }
        return transWeightUnit(this.weight, this.clientSet, 0);
    }

    public int getWalkStepLen() {
        return Math.round(((float) getMetricHeight()) * 0.42f);
    }

    public int getRunStepLen() {
        return Math.round(((float) getMetricHeight()) * 0.83f);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPortraitUrl() {
        return this.portraitUrl;
    }

    public void setPortraitUrl(String str) {
        this.portraitUrl = str;
    }

    public String getLanguageCode() {
        return this.languageCode;
    }

    public void setLanguageCode(String str) {
        this.languageCode = str;
    }

    public int getClientSet() {
        return this.clientSet;
    }

    public void setClientSet(Integer num) {
        if (num != null) {
            this.clientSet = num.intValue();
        }
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(Integer num) {
        if (num != null) {
            this.gender = num.intValue();
        }
    }

    public String getPicPath() {
        return this.picPath;
    }

    public void setPicPath(String str) {
        this.picPath = str;
    }

    public long getSetTime() {
        return this.setTime;
    }

    public void setSetTime(long j) {
        this.setTime = j;
    }

    public String toString() {
        return "birthday:" + this.birthday + ";gender:" + this.gender + ";weight:" + this.weight + ";height:" + this.height + ";name:" + this.name + ";languageCode:" + this.languageCode + ";portraitUrl:" + this.portraitUrl + ";clientSet:" + this.clientSet + ";picPath:" + this.picPath + ";setTime:" + this.setTime;
    }
}
