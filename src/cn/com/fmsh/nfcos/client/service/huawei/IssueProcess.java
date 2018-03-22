package cn.com.fmsh.nfcos.client.service.huawei;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IssueProcess implements Parcelable {
    public static final Creator<IssueProcess> CREATOR = new C28841();
    public int process;

    class C28841 implements Creator<IssueProcess> {
        C28841() {
        }

        public IssueProcess createFromParcel(Parcel parcel) {
            IssueProcess issueProcess = new IssueProcess();
            issueProcess.process = parcel.readInt();
            return issueProcess;
        }

        public IssueProcess[] newArray(int i) {
            return new IssueProcess[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.process);
    }

    public void readFromParcel(Parcel parcel) {
        this.process = parcel.readInt();
    }
}
