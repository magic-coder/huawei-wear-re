package com.huawei.hwid.core.datatype;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;

public class HwAccount implements Parcelable {
    public static final Creator<HwAccount> CREATOR = new C51871();
    private String f18675a;
    private String f18676b;
    private String f18677c;
    private String f18678d;
    private int f18679e = 0;
    private String f18680f;
    private String f18681g;
    private String f18682h;
    private String f18683i;
    private String f18684j;
    private String f18685k = "";
    private String f18686l;
    private String f18687m;
    private String f18688n;

    final class C51871 implements Creator<HwAccount> {
        C51871() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m25100a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m25101a(i);
        }

        public HwAccount m25100a(Parcel parcel) {
            HwAccount hwAccount = new HwAccount();
            hwAccount.f18675a = parcel.readString();
            hwAccount.f18676b = parcel.readString();
            hwAccount.f18677c = parcel.readString();
            hwAccount.f18678d = parcel.readString();
            hwAccount.f18679e = parcel.readInt();
            hwAccount.f18680f = parcel.readString();
            hwAccount.f18681g = parcel.readString();
            hwAccount.f18682h = parcel.readString();
            hwAccount.f18683i = parcel.readString();
            hwAccount.f18684j = parcel.readString();
            hwAccount.f18685k = parcel.readString();
            hwAccount.f18686l = parcel.readString();
            hwAccount.f18687m = parcel.readString();
            hwAccount.f18688n = parcel.readString();
            return hwAccount;
        }

        public HwAccount[] m25101a(int i) {
            return new HwAccount[i];
        }
    }

    public String m25117a() {
        return this.f18686l;
    }

    public void m25119a(String str) {
        this.f18686l = str;
    }

    public String m25120b() {
        return this.f18677c;
    }

    public void m25121b(String str) {
        this.f18677c = str;
    }

    public String m25122c() {
        return this.f18675a;
    }

    public void m25123c(String str) {
        this.f18675a = str;
    }

    public String m25124d() {
        return this.f18678d;
    }

    public void m25125d(String str) {
        this.f18678d = str;
    }

    public int m25126e() {
        return this.f18679e;
    }

    public void m25118a(int i) {
        this.f18679e = i;
    }

    public String m25128f() {
        return this.f18680f;
    }

    public void m25127e(String str) {
        this.f18680f = str;
    }

    public String m25130g() {
        return this.f18676b;
    }

    public void m25129f(String str) {
        this.f18676b = str;
    }

    public String m25132h() {
        return this.f18684j;
    }

    public void m25131g(String str) {
        this.f18684j = str;
    }

    public String m25134i() {
        return this.f18681g;
    }

    public void m25133h(String str) {
        this.f18681g = str;
    }

    public String m25136j() {
        return this.f18682h;
    }

    public void m25135i(String str) {
        this.f18682h = str;
    }

    public String m25138k() {
        return this.f18683i;
    }

    public void m25137j(String str) {
        this.f18683i = str;
    }

    public String m25140l() {
        return this.f18685k;
    }

    public void m25139k(String str) {
        this.f18685k = str;
    }

    public String m25142m() {
        if (TextUtils.isEmpty(this.f18687m)) {
            this.f18687m = "0";
        }
        return this.f18687m;
    }

    public void m25141l(String str) {
        this.f18687m = str;
    }

    public String m25144n() {
        if (TextUtils.isEmpty(this.f18688n)) {
            return "";
        }
        return this.f18688n;
    }

    public void m25143m(String str) {
        this.f18688n = str;
    }

    public String toString() {
        Bundle bundle = new Bundle();
        bundle.putString("accountName", C5203g.m25322d(this.f18677c));
        bundle.putString(SNBConstant.FIELD_TOKEN, C5203g.m25318a("serviceToken", this.f18676b));
        bundle.putString(HwAccountConstants.TOKEN_TYPE, this.f18675a);
        bundle.putString("userId", C5203g.m25318a("userId", this.f18678d));
        bundle.putString("siteId", String.valueOf(this.f18679e));
        bundle.putString("deviceId", C5203g.m25316a(this.f18681g));
        bundle.putString("subDeviceId", C5203g.m25316a(this.f18682h));
        bundle.putString("deviceType", this.f18683i);
        bundle.putString("accountType", this.f18684j);
        bundle.putString("loginUserName", this.f18685k);
        bundle.putString("isoCountryCode", this.f18686l);
        bundle.putString("STValidStatus", this.f18687m);
        bundle.putString("serviceCountryCode", this.f18688n);
        return C5203g.m25314a(bundle);
    }

    public Bundle m25145o() {
        Bundle bundle = new Bundle();
        bundle.putString("requestTokenType", m25122c());
        bundle.putString("serviceToken", m25130g());
        bundle.putString("accountName", m25120b());
        bundle.putString("userId", m25124d());
        bundle.putInt("siteId", m25126e());
        bundle.putString("Cookie", m25128f());
        bundle.putString("deviceId", m25134i());
        bundle.putString("subDeviceId", m25136j());
        bundle.putString("deviceType", m25138k());
        bundle.putString("accountType", m25132h());
        this.f18685k = m25140l();
        if (TextUtils.isEmpty(this.f18685k)) {
            this.f18685k = m25120b();
        }
        bundle.putString("loginUserName", this.f18685k);
        bundle.putString("countryIsoCode", m25117a());
        bundle.putString("STValidStatus", m25142m());
        bundle.putString("serviceCountryCode", m25144n());
        return bundle;
    }

    public Bundle m25146p() {
        Bundle o = m25145o();
        o.remove("Cookie");
        return o;
    }

    public HwAccount m25116a(Bundle bundle) {
        m25123c(bundle.getString("requestTokenType"));
        m25129f(bundle.getString("serviceToken"));
        m25121b(bundle.getString("accountName"));
        m25125d(bundle.getString("userId"));
        m25118a(bundle.getInt("siteId"));
        m25127e(bundle.getString("Cookie"));
        m25133h(bundle.getString("deviceId"));
        m25135i(bundle.getString("subDeviceId"));
        m25137j(bundle.getString("deviceType"));
        m25131g(bundle.getString("accountType"));
        m25139k(bundle.getString("loginUserName"));
        m25119a(bundle.getString("countryIsoCode"));
        m25141l(bundle.getString("STValidStatus"));
        m25143m(bundle.getString("serviceCountryCode"));
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18675a);
        parcel.writeString(this.f18676b);
        parcel.writeString(this.f18677c);
        parcel.writeString(this.f18678d);
        parcel.writeInt(this.f18679e);
        parcel.writeString(this.f18680f);
        parcel.writeString(this.f18681g);
        parcel.writeString(this.f18682h);
        parcel.writeString(this.f18683i);
        parcel.writeString(this.f18684j);
        parcel.writeString(this.f18685k);
        parcel.writeString(this.f18686l);
        parcel.writeString(this.f18687m);
        parcel.writeString(this.f18688n);
    }
}
