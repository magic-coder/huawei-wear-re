package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TransferFileInfo */
final class C4758y implements Creator<TransferFileInfo> {
    C4758y() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m22747a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m22748a(i);
    }

    public TransferFileInfo m22747a(Parcel parcel) {
        int readInt = parcel.readInt();
        int[] createIntArray = parcel.createIntArray();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        int readInt6 = parcel.readInt();
        int readInt7 = parcel.readInt();
        TransferFileInfo transferFileInfo = new TransferFileInfo();
        transferFileInfo.setType(readInt);
        List arrayList = new ArrayList();
        for (int valueOf : createIntArray) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        transferFileInfo.setRecordId(arrayList);
        transferFileInfo.setGpsType(readInt2);
        transferFileInfo.setStartTime(readInt3);
        transferFileInfo.setEndTime(readInt4);
        transferFileInfo.setLevel(readInt5);
        transferFileInfo.setDeviceMac(readString);
        transferFileInfo.setDeviceVersion(readString2);
        transferFileInfo.setDeviceType(readInt6);
        transferFileInfo.setDfxLogType(readInt7);
        return transferFileInfo;
    }

    public TransferFileInfo[] m22748a(int i) {
        return new TransferFileInfo[0];
    }
}
