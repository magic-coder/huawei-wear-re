package cn.com.fmsh.tsm.business.bean;

import java.util.ArrayList;
import java.util.List;

public class ElectronicAndActivity {
    private /* synthetic */ List<Object4Url> f9579a = new ArrayList();
    private /* synthetic */ List<Object4Activity> f9580b = new ArrayList();

    public class Object4Activity {
        final /* synthetic */ ElectronicAndActivity f9577a;
        public byte[] activity;
        public byte[] ticketType;

        public Object4Activity(ElectronicAndActivity electronicAndActivity, byte[] bArr, byte[] bArr2) {
            this.f9577a = electronicAndActivity;
            this.ticketType = bArr;
            this.activity = bArr2;
        }
    }

    public class Object4Url {
        final /* synthetic */ ElectronicAndActivity f9578a;
        public byte[] url;
        public byte[] urlType;

        public Object4Url(ElectronicAndActivity electronicAndActivity, byte[] bArr, byte[] bArr2) {
            this.f9578a = electronicAndActivity;
            this.url = bArr;
            this.urlType = bArr2;
        }
    }

    public void addActivity(byte[] bArr, byte[] bArr2) {
        this.f9580b.add(new Object4Activity(this, bArr, bArr2));
    }

    public void addUrl(byte[] bArr, byte[] bArr2) {
        this.f9579a.add(new Object4Url(this, bArr, bArr2));
    }

    public Object4Activity[] getActivity() {
        return (Object4Activity[]) this.f9580b.toArray(new Object4Activity[0]);
    }

    public Object4Url[] getUrls() {
        return (Object4Url[]) this.f9579a.toArray(new Object4Url[0]);
    }
}
