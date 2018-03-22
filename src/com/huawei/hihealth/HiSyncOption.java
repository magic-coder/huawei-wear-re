package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hihealth.c.e;

public class HiSyncOption implements Parcelable {
    public static final Creator<HiSyncOption> CREATOR = new n();
    private String data;
    private int pushAction;
    private int syncAction;
    private int syncDataType;
    private int syncMethod;
    private int syncModel;
    private int syncScope;

    public int getSyncAction() {
        return this.syncAction;
    }

    public void setSyncAction(int i) {
        this.syncAction = i;
    }

    public int getSyncMethod() {
        return this.syncMethod;
    }

    public void setSyncMethod(int i) {
        this.syncMethod = i;
    }

    public int getSyncScope() {
        return this.syncScope;
    }

    public void setSyncScope(int i) {
        this.syncScope = i;
    }

    public int getSyncDataType() {
        return this.syncDataType;
    }

    public void setUserInfo(HiUserInfo hiUserInfo) {
        if (hiUserInfo != null) {
            this.data = e.a(hiUserInfo);
        }
    }

    public int getPushAction() {
        return this.pushAction;
    }

    public void setPushAction(int i) {
        this.pushAction = i;
    }

    public HiUserInfo getUserInfo() {
        if (this.data == null) {
            return null;
        }
        return (HiUserInfo) e.a(this.data, HiUserInfo.class);
    }

    public void setSyncDataType(int i) {
        this.syncDataType = i;
    }

    public int getSyncModel() {
        return this.syncModel;
    }

    public void setSyncModel(int i) {
        this.syncModel = i;
    }

    public HiSyncOption(HiSyncOption hiSyncOption, int i) {
        setSyncModel(hiSyncOption.getSyncModel());
        setSyncMethod(hiSyncOption.getSyncMethod());
        setSyncAction(hiSyncOption.getSyncAction());
        setSyncDataType(i);
        setSyncScope(hiSyncOption.getSyncScope());
        setPushAction(hiSyncOption.getPushAction());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.syncAction);
        parcel.writeInt(this.syncMethod);
        parcel.writeInt(this.syncScope);
        parcel.writeInt(this.syncDataType);
        parcel.writeInt(this.syncModel);
        parcel.writeInt(this.pushAction);
        parcel.writeString(this.data);
    }

    protected HiSyncOption(Parcel parcel) {
        this.syncAction = parcel.readInt();
        this.syncMethod = parcel.readInt();
        this.syncScope = parcel.readInt();
        this.syncDataType = parcel.readInt();
        this.syncModel = parcel.readInt();
        this.pushAction = parcel.readInt();
        this.data = parcel.readString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiSyncOption{");
        stringBuffer.append("syncAction=").append(this.syncAction);
        stringBuffer.append(", syncMethod=").append(this.syncMethod);
        stringBuffer.append(", syncScope=").append(this.syncScope);
        stringBuffer.append(", syncDataType=").append(this.syncDataType);
        stringBuffer.append(", syncModel=").append(this.syncModel);
        stringBuffer.append(", pushAction=").append(this.pushAction);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
