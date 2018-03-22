package cn.com.fmsh.nfcos.client.service.huawei;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LoginInfo implements Parcelable {
    public static final Creator<LoginInfo> CREATOR = new C28861();
    public int loginFailureCount;
    public int loginResult;
    public int userLockTime;

    class C28861 implements Creator<LoginInfo> {
        C28861() {
        }

        public LoginInfo createFromParcel(Parcel parcel) {
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.loginResult = parcel.readInt();
            loginInfo.loginFailureCount = parcel.readInt();
            loginInfo.userLockTime = parcel.readInt();
            return loginInfo;
        }

        public LoginInfo[] newArray(int i) {
            return new LoginInfo[i];
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.loginResult);
        parcel.writeInt(this.loginFailureCount);
        parcel.writeInt(this.userLockTime);
    }

    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.loginResult = parcel.readInt();
        this.loginFailureCount = parcel.readInt();
        this.userLockTime = parcel.readInt();
    }
}
