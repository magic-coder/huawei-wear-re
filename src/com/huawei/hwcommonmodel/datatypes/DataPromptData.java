package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hwcommonmodel.p064d.C0978h;
import java.util.Arrays;

public class DataPromptData implements Parcelable {
    public static final Creator<DataPromptData> CREATOR = new e();
    private int dot_metrix_color;
    private byte[] dot_metrix_data;
    private int dot_metrix_height;
    private int dot_metrix_width;
    private int motor_enable;
    private int prompt_type;
    private String text_content;
    private int text_format;

    public int getPrompt_type() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.prompt_type))).intValue();
    }

    public void setPrompt_type(int i) {
        this.prompt_type = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int getMotor_enable() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.motor_enable))).intValue();
    }

    public void setMotor_enable(int i) {
        this.motor_enable = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int getDot_metrix_height() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.dot_metrix_height))).intValue();
    }

    public void setDot_metrix_height(int i) {
        this.dot_metrix_height = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int getDot_metrix_width() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.dot_metrix_width))).intValue();
    }

    public void setDot_metrix_width(int i) {
        this.dot_metrix_width = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public byte[] getDot_metrix_data() {
        if (this.dot_metrix_data != null) {
            return (byte[]) C0978h.m3579a(Arrays.copyOf(this.dot_metrix_data, this.dot_metrix_data.length));
        }
        return null;
    }

    public void setDot_metrix_data(byte[] bArr) {
        this.dot_metrix_data = (byte[]) C0978h.m3579a(Arrays.copyOf(bArr, bArr.length));
    }

    public int getText_format() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.text_format))).intValue();
    }

    public void setText_format(int i) {
        this.text_format = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public String getText_content() {
        return (String) C0978h.m3579a(this.text_content);
    }

    public void setText_content(String str) {
        this.text_content = (String) C0978h.m3579a(str);
    }

    public int getDot_metrix_color() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.dot_metrix_color))).intValue();
    }

    public void setDot_metrix_color(int i) {
        this.dot_metrix_color = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.prompt_type);
        parcel.writeInt(this.motor_enable);
        parcel.writeInt(this.dot_metrix_height);
        parcel.writeInt(this.dot_metrix_width);
        parcel.writeInt(this.dot_metrix_color);
        parcel.writeByteArray(this.dot_metrix_data);
        parcel.writeInt(this.text_format);
        parcel.writeString(this.text_content);
    }

    protected DataPromptData(Parcel parcel) {
        this.prompt_type = parcel.readInt();
        this.motor_enable = parcel.readInt();
        this.dot_metrix_height = parcel.readInt();
        this.dot_metrix_width = parcel.readInt();
        this.dot_metrix_color = parcel.readInt();
        this.dot_metrix_data = parcel.createByteArray();
        this.text_format = parcel.readInt();
        this.text_content = parcel.readString();
    }
}
