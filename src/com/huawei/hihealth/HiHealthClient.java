package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class HiHealthClient implements Parcelable {
    public static final Creator<HiHealthClient> CREATOR = new C4567j();
    private HiAppInfo hiAppInfo;
    private HiDeviceInfo hiDeviceInfo;
    private HiUserInfo hiUserInfo;

    protected HiHealthClient(Parcel parcel) {
        this.hiAppInfo = (HiAppInfo) parcel.readParcelable(HiAppInfo.class.getClassLoader());
        this.hiUserInfo = (HiUserInfo) parcel.readParcelable(HiUserInfo.class.getClassLoader());
        this.hiDeviceInfo = (HiDeviceInfo) parcel.readParcelable(HiDeviceInfo.class.getClassLoader());
    }

    public String getDeviceUUID() {
        if (this.hiDeviceInfo != null) {
            return this.hiDeviceInfo.getDeviceUniqueCode();
        }
        return null;
    }

    public void setDeviceUUID(String str) {
        if (this.hiDeviceInfo == null) {
            this.hiDeviceInfo = new HiDeviceInfo();
        }
        this.hiDeviceInfo.setDeviceUniqueCode(str);
    }

    public int getOwnerID() {
        if (this.hiUserInfo != null) {
            return this.hiUserInfo.getOwerID();
        }
        return 0;
    }

    public void setOwnerID(int i) {
        if (this.hiUserInfo == null) {
            this.hiUserInfo = new HiUserInfo();
        }
        this.hiUserInfo.setOwerID(i);
    }

    public void setPackageName(String str) {
        if (this.hiAppInfo == null) {
            this.hiAppInfo = new HiAppInfo();
        }
        this.hiAppInfo.setPackageName(str);
    }

    public String getPackageName() {
        if (this.hiAppInfo != null) {
            return this.hiAppInfo.getPackageName();
        }
        return null;
    }

    public void setAppID(int i) {
        if (this.hiAppInfo == null) {
            this.hiAppInfo = new HiAppInfo();
        }
        this.hiAppInfo.setAppID(i);
    }

    public int getAppID() {
        if (this.hiAppInfo != null) {
            return this.hiAppInfo.getAppID();
        }
        return 0;
    }

    public void setHuid(String str) {
        if (this.hiUserInfo == null) {
            this.hiUserInfo = new HiUserInfo();
        }
        this.hiUserInfo.setHuid(str);
    }

    public String getHuid() {
        if (this.hiUserInfo != null) {
            return this.hiUserInfo.getHuid();
        }
        return null;
    }

    public HiAppInfo getHiAppInfo() {
        return this.hiAppInfo;
    }

    public void setHiAppInfo(HiAppInfo hiAppInfo) {
        this.hiAppInfo = hiAppInfo;
    }

    public HiUserInfo getHiUserInfo() {
        return this.hiUserInfo;
    }

    public void setHiUserInfo(HiUserInfo hiUserInfo) {
        this.hiUserInfo = hiUserInfo;
    }

    public HiDeviceInfo getHiDeviceInfo() {
        return this.hiDeviceInfo;
    }

    public void setHiDeviceInfo(HiDeviceInfo hiDeviceInfo) {
        this.hiDeviceInfo = hiDeviceInfo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.hiAppInfo, i);
        parcel.writeParcelable(this.hiUserInfo, i);
        parcel.writeParcelable(this.hiDeviceInfo, i);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiHealthClient{");
        stringBuffer.append("hiAppInfo=").append(this.hiAppInfo);
        stringBuffer.append(", hiDeviceInfo=").append(this.hiDeviceInfo);
        stringBuffer.append(", hiUserInfo=").append(this.hiUserInfo);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
