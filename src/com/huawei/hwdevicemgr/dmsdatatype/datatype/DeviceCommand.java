package com.huawei.hwdevicemgr.dmsdatatype.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hwcommonmodel.p064d.C0978h;
import java.util.Arrays;

public class DeviceCommand implements Parcelable {
    public static final Creator<DeviceCommand> CREATOR = new C5004g();
    private int mCommandID;
    private byte[] mDataContent;
    private int mDataLen;
    private boolean mNeedAck = false;
    private boolean mNeedEncrypt = false;
    private int mPriority = 1;
    private int mServiceID;

    public void setServiceID(int i) {
        this.mServiceID = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int getServiceID() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.mServiceID))).intValue();
    }

    public void setCommandID(int i) {
        this.mCommandID = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int getCommandID() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.mCommandID))).intValue();
    }

    public void setDataLen(int i) {
        this.mDataLen = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int getDataLen() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.mDataLen))).intValue();
    }

    public void setDataContent(byte[] bArr) {
        if (bArr != null) {
            this.mDataContent = (byte[]) C0978h.m3579a(Arrays.copyOf(bArr, bArr.length));
        }
    }

    public byte[] getDataContent() {
        if (this.mDataContent != null) {
            return (byte[]) C0978h.m3579a(Arrays.copyOf(this.mDataContent, this.mDataContent.length));
        }
        return null;
    }

    public void setPriority(int i) {
        this.mPriority = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int getPriority() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.mPriority))).intValue();
    }

    public void setNeedAck(boolean z) {
        this.mNeedAck = ((Boolean) C0978h.m3579a(Boolean.valueOf(z))).booleanValue();
    }

    public boolean getNeedAck() {
        return ((Boolean) C0978h.m3579a(Boolean.valueOf(this.mNeedAck))).booleanValue();
    }

    public void setNeedEncrypt(boolean z) {
        this.mNeedEncrypt = ((Boolean) C0978h.m3579a(Boolean.valueOf(z))).booleanValue();
    }

    public boolean getNeedEncrypt() {
        return ((Boolean) C0978h.m3579a(Boolean.valueOf(this.mNeedEncrypt))).booleanValue();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.mServiceID);
        parcel.writeInt(this.mCommandID);
        parcel.writeInt(this.mDataLen);
        if (this.mDataContent == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.mDataContent.length);
        }
        if (this.mDataContent != null) {
            parcel.writeByteArray(this.mDataContent);
        }
        parcel.writeInt(this.mPriority);
        if (this.mNeedAck) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.mNeedEncrypt) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }

    public void procDeviceCommand1() {
    }

    public void procDeviceCommand2() {
    }

    public void procDeviceCommand3() {
    }

    public void procDeviceCommand4() {
    }

    public void procDeviceCommand5() {
    }

    public void procDeviceCommand6() {
    }

    public void procDeviceCommand7() {
    }

    public void procDeviceCommand8() {
    }

    public void procDeviceCommand9() {
    }

    /* compiled from: DeviceCommand */
    static final class C5004g implements Creator<DeviceCommand> {
        C5004g() {
        }

        public /* synthetic */ DeviceCommand createFromParcel(Parcel parcel) {
            return m24040a(parcel);
        }

        public /* synthetic */ DeviceCommand[] newArray(int i) {
            return m24041a(i);
        }

        public DeviceCommand[] m24041a(int i) {
            return new DeviceCommand[i];
        }

        public DeviceCommand m24040a(Parcel parcel) {
            boolean z = true;
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            byte[] bArr = null;
            int readInt4 = parcel.readInt();
            if (readInt4 > 0) {
                bArr = new byte[readInt4];
                parcel.readByteArray(bArr);
            }
            int readInt5 = parcel.readInt();
            boolean z2 = parcel.readByte() != (byte) 0;
            if (parcel.readByte() == (byte) 0) {
                z = false;
            }
            DeviceCommand deviceCommand = new DeviceCommand();
            deviceCommand.setServiceID(readInt);
            deviceCommand.setCommandID(readInt2);
            deviceCommand.setDataLen(readInt3);
            deviceCommand.setDataContent(bArr);
            deviceCommand.setPriority(readInt5);
            deviceCommand.setNeedAck(z2);
            deviceCommand.setNeedEncrypt(z);
            return deviceCommand;
        }
    }
}
