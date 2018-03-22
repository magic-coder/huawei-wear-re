package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hwcommonmodel.p064d.C0978h;

public class MsgText implements Parcelable {
    public static final Creator<MsgText> CREATOR = new q();
    private String TextContent;
    private int TextType;

    public int getTextType() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.TextType))).intValue();
    }

    public void setTextType(int i) {
        this.TextType = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public String getTextContent() {
        return (String) C0978h.m3579a(this.TextContent);
    }

    public void setTextContent(String str) {
        this.TextContent = (String) C0978h.m3579a(str);
    }

    public MsgText(int i, String str) {
        this.TextType = i;
        this.TextContent = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.TextType);
        parcel.writeString(this.TextContent);
    }

    protected MsgText(Parcel parcel) {
        this.TextType = parcel.readInt();
        this.TextContent = parcel.readString();
    }
}
