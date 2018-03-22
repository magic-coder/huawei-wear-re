package com.huawei.hihealth;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.sina.weibo.sdk.constant.WBConstants;

public class HiHealthData implements Parcelable, Comparable<HiHealthData> {
    public static final Creator<HiHealthData> CREATOR = new C4568k();
    private String deviceUUID;
    private int ownerID;
    private int type;
    private ContentValues valueHolder;

    public HiHealthData() {
        this.valueHolder = new ContentValues();
    }

    public HiHealthData(int i) {
        this.valueHolder = new ContentValues();
        this.type = i;
    }

    public HiHealthData(Parcel parcel) {
        this.deviceUUID = parcel.readString();
        this.ownerID = parcel.readInt();
        this.type = parcel.readInt();
        this.valueHolder = (ContentValues) parcel.readParcelable(ContentValues.class.getClassLoader());
    }

    public String getDeviceUUID() {
        return this.deviceUUID;
    }

    public void setDeviceUUID(String str) {
        this.deviceUUID = str;
    }

    public int getOwnerID() {
        return this.ownerID;
    }

    public void setOwnerID(int i) {
        this.ownerID = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    private void setValueHolder(ContentValues contentValues) {
        this.valueHolder = contentValues;
    }

    public void setTimeInterval(long j, long j2) {
        this.valueHolder.put("start_time", Long.valueOf(j));
        this.valueHolder.put("end_time", Long.valueOf(j2));
    }

    public void setStartTime(long j) {
        this.valueHolder.put("start_time", Long.valueOf(j));
    }

    public long getStartTime() {
        Long asLong = this.valueHolder.getAsLong("start_time");
        if (asLong == null) {
            return 0;
        }
        return asLong.longValue();
    }

    public long getDay() {
        Long asLong = this.valueHolder.getAsLong("start_time");
        if (asLong == null) {
            return 0;
        }
        return (long) C4540b.m21750a(asLong.longValue());
    }

    public void setEndTime(long j) {
        this.valueHolder.put("end_time", Long.valueOf(j));
    }

    public long getEndTime() {
        Long asLong = this.valueHolder.getAsLong("end_time");
        if (asLong == null) {
            return 0;
        }
        return asLong.longValue();
    }

    public void setCreateTime(long j) {
        this.valueHolder.put("create_time", Long.valueOf(j));
    }

    public long getCreateTime() {
        Long asLong = this.valueHolder.getAsLong("create_time");
        if (asLong == null) {
            return System.currentTimeMillis();
        }
        return asLong.longValue();
    }

    public void setModifiedTime(long j) {
        this.valueHolder.put("modified_time", Long.valueOf(j));
    }

    public long getModifiedTime() {
        Long asLong = this.valueHolder.getAsLong("modified_time");
        if (asLong == null) {
            return System.currentTimeMillis();
        }
        return asLong.longValue();
    }

    public void setValue(double d) {
        this.valueHolder.put("point_value", Double.valueOf(d));
    }

    public void setValue(int i) {
        this.valueHolder.put("point_value", Integer.valueOf(i));
    }

    public void setValue(float f) {
        this.valueHolder.put("point_value", Float.valueOf(f));
    }

    public double getValue() {
        Double asDouble = this.valueHolder.getAsDouble("point_value");
        if (asDouble == null) {
            return 0.0d;
        }
        return asDouble.doubleValue();
    }

    public int getIntValue() {
        Integer asInteger = this.valueHolder.getAsInteger("point_value");
        if (asInteger == null) {
            return 0;
        }
        return asInteger.intValue();
    }

    public float getFloatValue() {
        Float asFloat = this.valueHolder.getAsFloat("point_value");
        if (asFloat == null) {
            return 0.0f;
        }
        return asFloat.floatValue();
    }

    public void setPointUnit(int i) {
        this.valueHolder.put(" point_unit", Integer.valueOf(i));
    }

    public int getPointUnit() {
        Integer asInteger = this.valueHolder.getAsInteger(" point_unit");
        if (asInteger == null) {
            return 0;
        }
        return asInteger.intValue();
    }

    public void setSequenceData(String str) {
        this.valueHolder.put("sequence_data", str);
    }

    public String getSequenceData() {
        return this.valueHolder.getAsString("sequence_data");
    }

    public void setSequenceFileUrl(String str) {
        this.valueHolder.put("sequence_file_url", str);
    }

    public String getSequenceFileUrl() {
        return this.valueHolder.getAsString("sequence_file_url");
    }

    public void setMetaData(String str) {
        this.valueHolder.put("metadata", str);
    }

    public String getMetaData() {
        return this.valueHolder.getAsString("metadata");
    }

    public void setTimeZone(String str) {
        this.valueHolder.put("time_zone", str);
    }

    public String getTimeZone() {
        return this.valueHolder.getAsString("time_zone");
    }

    public void setSyncStatus(int i) {
        this.valueHolder.put("sync_status", Integer.valueOf(i));
    }

    public int getSyncStatus() {
        Integer asInteger = this.valueHolder.getAsInteger("sync_status");
        if (asInteger == null) {
            return 0;
        }
        return asInteger.intValue();
    }

    public void setDataID(long j) {
        this.valueHolder.put("data_id", Long.valueOf(j));
    }

    public long getDataID() {
        Long asLong = this.valueHolder.getAsLong("data_id");
        if (asLong == null) {
            return 0;
        }
        return asLong.longValue();
    }

    public void setClientID(int i) {
        this.valueHolder.put(WBConstants.AUTH_PARAMS_CLIENT_ID, Integer.valueOf(i));
    }

    public int getClientID() {
        Integer asInteger = this.valueHolder.getAsInteger(WBConstants.AUTH_PARAMS_CLIENT_ID);
        if (asInteger == null) {
            return 0;
        }
        return asInteger.intValue();
    }

    public void setDeviceID(int i) {
        this.valueHolder.put(SNBConstant.FIELD_DEVICE_ID, Integer.valueOf(i));
    }

    public int getDeviceID() {
        Integer asInteger = this.valueHolder.getAsInteger(SNBConstant.FIELD_DEVICE_ID);
        if (asInteger == null) {
            return 0;
        }
        return asInteger.intValue();
    }

    public void setUserID(int i) {
        this.valueHolder.put(ReportCardInfo.COLUMN_NAME_CARD_USERID, Integer.valueOf(i));
    }

    public int getUserID() {
        Integer asInteger = this.valueHolder.getAsInteger(ReportCardInfo.COLUMN_NAME_CARD_USERID);
        if (asInteger == null) {
            return 0;
        }
        return asInteger.intValue();
    }

    public void setAppID(int i) {
        this.valueHolder.put("app_id", Integer.valueOf(i));
    }

    public int getAppID() {
        Integer asInteger = this.valueHolder.getAsInteger("app_id");
        if (asInteger == null) {
            return 0;
        }
        return asInteger.intValue();
    }

    public final void putString(String str, String str2) {
        this.valueHolder.put(str, str2);
    }

    public String getString(String str) {
        return this.valueHolder.getAsString(str);
    }

    public void putDouble(String str, double d) {
        this.valueHolder.put(str, Double.valueOf(d));
    }

    public double getDouble(String str) {
        Double asDouble = this.valueHolder.getAsDouble(str);
        if (asDouble == null) {
            return 0.0d;
        }
        return asDouble.doubleValue();
    }

    public final void putFloat(String str, float f) {
        this.valueHolder.put(str, Float.valueOf(f));
    }

    public float getFloat(String str) {
        Float asFloat = this.valueHolder.getAsFloat(str);
        if (asFloat == null) {
            return 0.0f;
        }
        return asFloat.floatValue();
    }

    public void putInt(String str, int i) {
        this.valueHolder.put(str, Integer.valueOf(i));
    }

    public int getInt(String str) {
        Integer asInteger = this.valueHolder.getAsInteger(str);
        if (asInteger == null) {
            return 0;
        }
        return asInteger.intValue();
    }

    public void putShort(String str, short s) {
        this.valueHolder.put(str, Short.valueOf(s));
    }

    public short getShort(String str) {
        Short asShort = this.valueHolder.getAsShort(str);
        if (asShort == null) {
            return (short) 0;
        }
        return asShort.shortValue();
    }

    public void putLong(String str, long j) {
        this.valueHolder.put(str, Long.valueOf(j));
    }

    public long getLong(String str) {
        Long asLong = this.valueHolder.getAsLong(str);
        if (asLong == null) {
            return 0;
        }
        return asLong.longValue();
    }

    public void putBoolean(String str, boolean z) {
        this.valueHolder.put(str, Boolean.valueOf(z));
    }

    public boolean getBoolean(String str) {
        Boolean asBoolean = this.valueHolder.getAsBoolean(str);
        if (asBoolean == null) {
            return false;
        }
        return asBoolean.booleanValue();
    }

    public void putNull(String str) {
        this.valueHolder.putNull(str);
    }

    public final Object get(String str) {
        return this.valueHolder.get(str);
    }

    public void remove(String str) {
        this.valueHolder.remove(str);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deviceUUID);
        parcel.writeInt(this.ownerID);
        parcel.writeInt(this.type);
        parcel.writeParcelable(this.valueHolder, i);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiHealthData{");
        stringBuffer.append("type=").append(this.type);
        stringBuffer.append(", day = ").append(C4540b.m21764l(getStartTime()));
        if (this.type == PayStatusCodes.PAY_STATE_PARAM_ERROR) {
            stringBuffer.append(", startTime = ").append(getStartTime());
            stringBuffer.append(", endTime = ").append(getEndTime());
            stringBuffer.append(", meteData = ").append(getMetaData());
            stringBuffer.append(", sequenceFileUrl = ").append(getSequenceFileUrl());
        } else {
            stringBuffer.append(", values = ").append(this.valueHolder);
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public int compareTo(HiHealthData hiHealthData) {
        return Long.compare(hiHealthData.getStartTime(), getStartTime());
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public HiHealthData copyData() {
        HiHealthData hiHealthData = new HiHealthData();
        hiHealthData.setDeviceUUID(this.deviceUUID);
        hiHealthData.setOwnerID(this.ownerID);
        hiHealthData.setType(this.type);
        hiHealthData.setValueHolder(new ContentValues(this.valueHolder));
        return hiHealthData;
    }
}
