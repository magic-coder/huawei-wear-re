package com.huawei.hwid.core.helper.handler;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hwid.core.encrypt.C5203g;

public class ErrorStatus implements Parcelable {
    public static final int ACCOUNT_NON_LOGIN = 31;
    public static final int ACCOUNT_NOT_EXIST = 13;
    public static final int AREA_NOT_ALLOW = 23;
    public static final int BIND_SERVICE_SYSTEM_ERROR = 40;
    public static final Creator<ErrorStatus> CREATOR = new C52051();
    public static final int ERRORSTATUS_NULL = 32;
    public static final int ERROR_ACCESS = 15;
    public static final int ERROR_AUTH_EXCEPTION = 3003;
    public static final int ERROR_CHANGE_HOME_COUNTRY = 45;
    public static final int ERROR_HWID_IS_LOW_VERSION = 35;
    public static final int ERROR_HWID_IS_NOT_EXIT = 34;
    public static final int ERROR_HWID_UPLOAD_HEADPIC = 37;
    public static final int ERROR_IO_EXCEPTION = 3004;
    public static final int ERROR_LOGOUT_FAILED = 19;
    public static final int ERROR_NETWORK_UNAVIABLE = 5;
    public static final int ERROR_NOT_USE_APK = 33;
    public static final int ERROR_NO_SEND_SMS_PERMISSION = 17;
    public static final int ERROR_NO_SIM = 6;
    public static final int ERROR_OPER_CANCEL = 3002;
    public static final int ERROR_PARAM_INVALID = 12;
    public static final int ERROR_PARMS = 44;
    public static final int ERROR_PHONE_NOT_EXIST = 46;
    public static final int ERROR_PKG_NOT_IN_HWIDLIST = 43;
    public static final int ERROR_SAVE_LOGOUT_INTENT = 38;
    public static final int ERROR_UNACTIVE_ACCOUNT = 41;
    public static final int ERROR_USERID_NOT_MATCH_SYSTEM = 42;
    public static final int HWID_NOT_ALLOW = 24;
    public static final int HWID_NOT_SUPPORT = 20;
    public static final int ILLEGAL_ARGUMENT_EXCEPTION = 1002;
    public static final int LOGIN_TIMEOUT = 39;
    public static final int PERMISSION_NOT_ALLOW = 27;
    public static final int QUICKLOGIN_NOT_SUPPORT = 21;
    public static final int READ_PHONE_STATE_NOT_ALLOW = 28;
    public static final int REQUEST_NOT_ALLOW = 25;
    public static final int SDK_NOT_SUPPORT_THIRD = 22;
    public static final int SERVICETOKEN_INVALID = 30;
    public static final int SIGNATURE_INVALID = 29;
    public static final String ST_STATUS_INVALID = "1";
    public static final String ST_STATUS_VALID = "0";
    public static final int THIRD_ACCOUNT_NOT_ALLOW = 26;
    private int f18795a;
    private String f18796b;

    final class C52051 implements Creator<ErrorStatus> {
        C52051() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m25324a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m25325a(i);
        }

        public ErrorStatus m25324a(Parcel parcel) {
            ErrorStatus errorStatus = new ErrorStatus();
            errorStatus.f18795a = parcel.readInt();
            errorStatus.f18796b = parcel.readString();
            return errorStatus;
        }

        public ErrorStatus[] m25325a(int i) {
            return new ErrorStatus[i];
        }
    }

    public ErrorStatus(int i, String str) {
        this.f18795a = i;
        this.f18796b = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f18795a);
        parcel.writeString(this.f18796b);
    }

    public int getErrorCode() {
        return this.f18795a;
    }

    public String getErrorReason() {
        return this.f18796b;
    }

    public String toString() {
        return "[ErrorCode]:" + this.f18795a + ", [ErrorReason:]" + C5203g.m25316a(this.f18796b);
    }
}
