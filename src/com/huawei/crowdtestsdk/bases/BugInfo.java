package com.huawei.crowdtestsdk.bases;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BugInfo implements Parcelable {
    public static final Creator<BugInfo> CREATOR = new C06741();
    private Context context;
    private String mBugType = "";
    private String mDescription = "";
    private String mProbability = "";
    private String quesNo = "";

    final class C06741 implements Creator<BugInfo> {
        C06741() {
        }

        public BugInfo createFromParcel(Parcel parcel) {
            return new BugInfo(parcel);
        }

        public BugInfo[] newArray(int i) {
            return new BugInfo[i];
        }
    }

    protected BugInfo(Parcel parcel) {
        this.mBugType = parcel.readString();
        this.mProbability = parcel.readString();
        this.mDescription = parcel.readString();
        this.quesNo = parcel.readString();
    }

    public BugInfo setContext(Context context) {
        this.context = context;
        return this;
    }

    public Context getContext() {
        return this.context;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mBugType);
        parcel.writeString(this.mProbability);
        parcel.writeString(this.mDescription);
        parcel.writeString(this.quesNo);
    }

    public String getmBugType() {
        return this.mBugType;
    }

    public void setmBugType(String str) {
        this.mBugType = str;
    }

    public String getmProbability() {
        return this.mProbability;
    }

    public void setmProbability(String str) {
        this.mProbability = str;
    }

    public String getmDescription() {
        return this.mDescription;
    }

    public void setmDescription(String str) {
        this.mDescription = str;
    }

    public String getQuesNo() {
        return this.quesNo;
    }

    public void setQuesNo(String str) {
        this.quesNo = str;
    }
}
