package cn.com.fmsh.nfcos.client.service.huawei;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserInfo implements Parcelable {
    public static final Creator<UserInfo> CREATOR = new C28931();
    public String password;
    public String username;

    class C28931 implements Creator<UserInfo> {
        C28931() {
        }

        public UserInfo createFromParcel(Parcel parcel) {
            UserInfo userInfo = new UserInfo();
            userInfo.username = parcel.readString();
            userInfo.password = parcel.readString();
            return userInfo;
        }

        public UserInfo[] newArray(int i) {
            return new UserInfo[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.password);
    }

    public void readFromParcel(Parcel parcel) {
        this.username = parcel.readString();
        this.password = parcel.readString();
    }
}
