package cn.com.fmsh.nfcos.client.service.huawei;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class VersionInfo implements Parcelable {
    public static final Creator<VersionInfo> CREATOR = new C28941();
    public boolean isUpdate;
    public String url;
    public String version;

    class C28941 implements Creator<VersionInfo> {
        C28941() {
        }

        public VersionInfo createFromParcel(Parcel parcel) {
            boolean z = true;
            VersionInfo versionInfo = new VersionInfo();
            versionInfo.version = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            versionInfo.isUpdate = z;
            versionInfo.url = parcel.readString();
            return versionInfo;
        }

        public VersionInfo[] newArray(int i) {
            return new VersionInfo[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.version);
        parcel.writeInt(this.isUpdate ? 1 : 0);
        parcel.writeString(this.url);
    }

    public void readFromParcel(Parcel parcel) {
        boolean z = true;
        this.version = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.isUpdate = z;
        this.url = parcel.readString();
    }
}
