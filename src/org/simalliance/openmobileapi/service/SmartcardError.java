package org.simalliance.openmobileapi.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SmartcardError implements Parcelable {
    public static final Creator<SmartcardError> CREATOR = new C6671q();
    private String mClazz;
    private String mMessage;

    public SmartcardError() {
        this.mClazz = "";
        this.mMessage = "";
    }

    private SmartcardError(Parcel parcel) {
        this.mClazz = parcel.readString();
        this.mMessage = parcel.readString();
    }

    public SmartcardError(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.mClazz = str;
        if (str2 == null) {
            str2 = "";
        }
        this.mMessage = str2;
    }

    public void clear() {
        this.mClazz = "";
        this.mMessage = "";
    }

    public Exception createException() {
        try {
            if (this.mClazz.length() == 0) {
                return null;
            }
            if (this.mMessage.length() == 0) {
                return (Exception) Class.forName(this.mClazz).newInstance();
            }
            return (Exception) Class.forName(this.mClazz).getConstructor(new Class[]{String.class}).newInstance(new Object[]{this.mMessage});
        } catch (Exception e) {
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.mClazz = parcel.readString();
        this.mMessage = parcel.readString();
    }

    public void setError(Class cls, String str) {
        this.mClazz = cls == null ? "" : cls.getName();
        if (str == null) {
            str = "";
        }
        this.mMessage = str;
    }

    public void throwException() throws C6657a {
        Throwable createException = createException();
        if (createException != null) {
            if (createException instanceof C6657a) {
                throw ((C6657a) createException);
            } else if (createException instanceof RuntimeException) {
                throw ((RuntimeException) createException);
            } else {
                throw new RuntimeException(createException);
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mClazz);
        parcel.writeString(this.mMessage);
    }
}
