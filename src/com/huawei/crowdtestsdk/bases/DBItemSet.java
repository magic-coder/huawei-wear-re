package com.huawei.crowdtestsdk.bases;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.crowdtestsdk.devices.DeviceHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DBItemSet implements Parcelable {
    public static final Creator<DBItemSet> CREATOR = new C06751();
    public String activityID;
    public String activityName;
    public Set<String> attachList;
    public String audioString;
    public Set<String> cameraAttachList;
    public int createType;
    public DeviceHelper deviceHelper;
    public String issueDescription;
    public int issueLevelIndex;
    public long issueMakerId;
    public int issueProbabilityIndex;
    public long logId;
    public String logPath;
    public String mCompressdLogPath;
    public long occurrenceTime;
    public Set<String> otherAttachList;
    public int sendType;
    public String tbdtsNo;
    public int typeId;

    final class C06751 implements Creator<DBItemSet> {
        C06751() {
        }

        public DBItemSet createFromParcel(Parcel parcel) {
            return new DBItemSet(parcel);
        }

        public DBItemSet[] newArray(int i) {
            return new DBItemSet[i];
        }
    }

    public DBItemSet(long j, int i, String str, int i2, int i3, long j2, String str2, String str3, List<String> list, String str4, String str5, String str6, int i4, int i5) {
        this.logId = j;
        this.typeId = i;
        this.issueProbabilityIndex = i2;
        this.issueLevelIndex = i3;
        this.occurrenceTime = j2;
        this.issueDescription = str;
        this.mCompressdLogPath = str2;
        this.logPath = str3;
        this.attachList = new HashSet(list);
        this.activityID = str4;
        this.activityName = str5;
        this.tbdtsNo = str6;
        this.createType = i4;
        this.sendType = i5;
    }

    public DBItemSet(long j, int i, String str, int i2, long j2, String str2, String str3, String str4, List<String> list, List<String> list2, String str5, String str6, DeviceHelper deviceHelper, String str7, int i3, int i4, long j3) {
        this.logId = j;
        this.typeId = i;
        this.issueProbabilityIndex = i2;
        this.occurrenceTime = j2;
        this.issueDescription = str;
        this.mCompressdLogPath = str2;
        this.logPath = str3;
        this.audioString = str4;
        if (list != null) {
            this.cameraAttachList = new LinkedHashSet(list);
        }
        if (list2 != null) {
            this.otherAttachList = new LinkedHashSet(list2);
        }
        this.activityID = str5;
        this.activityName = str6;
        this.deviceHelper = deviceHelper;
        this.tbdtsNo = str7;
        this.createType = i3;
        this.sendType = i4;
        this.issueMakerId = j3;
    }

    public DBItemSet(Parcel parcel) {
        this.logId = parcel.readLong();
        this.typeId = parcel.readInt();
        this.issueProbabilityIndex = parcel.readInt();
        this.occurrenceTime = parcel.readLong();
        this.issueDescription = parcel.readString();
        this.mCompressdLogPath = parcel.readString();
        this.logPath = parcel.readString();
        Collection arrayList = new ArrayList();
        this.issueLevelIndex = parcel.readInt();
        this.audioString = parcel.readString();
        parcel.readStringList(arrayList);
        this.cameraAttachList = new LinkedHashSet(arrayList);
        this.otherAttachList = new LinkedHashSet(arrayList);
        this.attachList = new HashSet(arrayList);
        this.activityID = parcel.readString();
        this.activityName = parcel.readString();
        this.deviceHelper = (DeviceHelper) parcel.readSerializable();
        this.tbdtsNo = parcel.readString();
        this.createType = parcel.readInt();
        this.sendType = parcel.readInt();
        this.issueMakerId = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.logId);
        parcel.writeInt(this.typeId);
        parcel.writeInt(this.issueProbabilityIndex);
        parcel.writeLong(this.occurrenceTime);
        parcel.writeString(this.issueDescription);
        parcel.writeString(this.mCompressdLogPath);
        parcel.writeString(this.logPath);
        parcel.writeString(this.audioString);
        List arrayList = new ArrayList();
        if (this.cameraAttachList != null) {
            arrayList.addAll(this.cameraAttachList);
        }
        parcel.writeStringList(arrayList);
        arrayList = new ArrayList();
        if (this.otherAttachList != null) {
            arrayList.addAll(this.otherAttachList);
        }
        parcel.writeStringList(arrayList);
        parcel.writeString(this.activityID);
        parcel.writeString(this.activityName);
        parcel.writeSerializable(this.deviceHelper);
        parcel.writeString(this.tbdtsNo);
        parcel.writeInt(this.createType);
        parcel.writeInt(this.sendType);
        parcel.writeLong(this.issueMakerId);
        arrayList = new ArrayList();
        if (this.attachList != null) {
            arrayList.addAll(this.attachList);
        }
        parcel.writeStringList(arrayList);
        parcel.writeInt(this.issueLevelIndex);
    }
}
