package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hihealth.c.b;

public class HiUserInfo implements Parcelable {
    public static final int BIRTHDAY_DEFAULT = 19900801;
    public static final int CREATE_TIME_DEFAULT = 1;
    public static final Creator<HiUserInfo> CREATOR = new p();
    public static final int GENDER_DEFAULT = 1;
    public static final int GENDER_FEMALE = 0;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = -1;
    public static final int HEIGHT_DEFAULT = 170;
    public static final int UNIT_CM_KG = 0;
    public static final int UNIT_DEFAULT = 0;
    public static final int UNIT_FT_LB = 1;
    public static final int UNIT_UNKNOWN = -1;
    public static final float WEIGHT_DEFAULT = 60.0f;
    private int age;
    private int birthday = BIRTHDAY_DEFAULT;
    private long createTime = System.currentTimeMillis();
    private String email;
    private int gender = 1;
    private String headImgUrl;
    private int height = HEIGHT_DEFAULT;
    private String huid;
    private String mobile;
    private String name;
    private int owerID;
    private int relateType;
    private int unitType = 0;
    private float weight = 60.0f;

    protected HiUserInfo(Parcel parcel) {
        this.owerID = parcel.readInt();
        this.huid = parcel.readString();
        this.name = parcel.readString();
        this.gender = parcel.readInt();
        this.birthday = parcel.readInt();
        this.height = parcel.readInt();
        this.weight = parcel.readFloat();
        this.age = parcel.readInt();
        this.email = parcel.readString();
        this.mobile = parcel.readString();
        this.headImgUrl = parcel.readString();
        this.unitType = parcel.readInt();
        this.relateType = parcel.readInt();
        this.createTime = parcel.readLong();
    }

    public String getHuid() {
        return this.huid;
    }

    public void setHuid(String str) {
        this.huid = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public int getBirthday() {
        return this.birthday;
    }

    public void setBirthday(int i) {
        this.birthday = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public float getWeight() {
        return this.weight;
    }

    public void setWeight(float f) {
        this.weight = f;
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

    public String getHeadImgUrl() {
        return this.headImgUrl;
    }

    public void setHeadImgUrl(String str) {
        this.headImgUrl = str;
    }

    public int getUnitType() {
        return this.unitType;
    }

    public void setUnitType(int i) {
        this.unitType = i;
    }

    public int getRelateType() {
        return this.relateType;
    }

    public void setRelateType(int i) {
        this.relateType = i;
    }

    public int getOwerID() {
        return this.owerID;
    }

    public void setOwerID(int i) {
        this.owerID = i;
    }

    public int getAge() {
        return this.age > 0 ? this.age : (b.a(System.currentTimeMillis()) / 10000) - (this.birthday / 10000);
    }

    public void setAge(int i) {
        this.age = i;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        if (j > 0) {
            this.createTime = j;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.owerID);
        parcel.writeString(this.huid);
        parcel.writeString(this.name);
        parcel.writeInt(this.gender);
        parcel.writeInt(this.birthday);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.weight);
        parcel.writeInt(this.age);
        parcel.writeString(this.email);
        parcel.writeString(this.mobile);
        parcel.writeString(this.headImgUrl);
        parcel.writeInt(this.unitType);
        parcel.writeInt(this.relateType);
        parcel.writeLong(this.createTime);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiUserInfo{");
        stringBuffer.append(", owerID=").append(this.owerID);
        stringBuffer.append(", relateType=").append(this.relateType);
        stringBuffer.append(", createTime=").append(this.createTime);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
