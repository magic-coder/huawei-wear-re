package com.huawei.ui.device.p170a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import com.huawei.datatype.DataDeviceInfo;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.mgr.a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.login.ui.login.C1093a;
import com.huawei.membercenter.sdk.membersdklibrary.api.MemberServiceAPI.IActiveMemberCallback;
import com.huawei.membercenter.sdk.membersdklibrary.api.MemberServiceAPI.IQueryMemberStatusCallback;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.BundleKey;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.activity.goldmember.HuaweiMemberActivity;
import com.huawei.ui.device.activity.goldmember.VIPUserInfoActivity;
import com.unionpay.tsmservice.data.ResultCode;

/* compiled from: HuaweiGoldMemberInteractors */
public class C1998z {
    static String f6963e = "";
    private static String f6964f;
    private static String f6965g;
    private static String f6966j = "putExtraMemAdLevel";
    Context f6967a;
    C1204c f6968b = null;
    DataDeviceInfo f6969c = new DataDeviceInfo();
    a f6970d;
    private String f6971h;
    private String f6972i = ResultCode.ERROR_INTERFACE_GET_TRANS_ELEMENTS;
    private int f6973k;
    private Handler f6974l;
    private IBaseResponseCallback f6975m = new aa(this);

    private String m10468d() {
        C2538c.m12674b("HuaweiGoldMemberInteractors", " getEmmcId(): emmcId = " + f6965g);
        return f6965g;
    }

    private void m10465a(String str) {
        C2538c.m12674b("HuaweiGoldMemberInteractors", " setEmmcId(): emmcId1 = " + str);
        f6965g = str;
    }

    private String m10469e() {
        C2538c.m12674b("HuaweiGoldMemberInteractors", " getSn(): sn = " + f6964f);
        return f6964f;
    }

    private void m10467b(String str) {
        C2538c.m12674b("HuaweiGoldMemberInteractors", " setSn(): sn1 =" + str);
        f6964f = str;
    }

    public C1998z(Context context) {
        this.f6967a = context;
        this.f6968b = C1204c.m5370a(this.f6967a);
        this.f6970d = a.a(this.f6967a);
        m10463a(this.f6975m);
    }

    private void m10463a(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("HuaweiGoldMemberInteractors", "getFirmwareVersion()");
        this.f6968b.m5425a(iBaseResponseCallback);
    }

    private Bundle m10470f() {
        C2538c.m12677c("HuaweiGoldMemberInteractors", "enter getHuaweiMemberInfo()");
        Bundle bundle = new Bundle();
        bundle.putString("userID", C1998z.m10462a());
        bundle.putString(BundleKey.KEY_ST, C1093a.m4739a(this.f6967a).m4754g());
        TelephonyManager telephonyManager = (TelephonyManager) this.f6967a.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        try {
            bundle.putString("deviceType", String.valueOf(telephonyManager.getPhoneType()));
            bundle.putString("deviceID", telephonyManager.getDeviceId());
            this.f6971h = com.huawei.o.c.a.a(this.f6967a);
            bundle.putString("packageName", this.f6971h);
            bundle.putString(BundleKey.KEY_DEVICE_LEVEL, this.f6972i);
            bundle.putString(BundleKey.KEY_EMMCID, m10468d());
            bundle.putString(BundleKey.KEY_IMEI, m10469e());
            C2538c.m12677c("HuaweiGoldMemberInteractors", "userId = " + C1998z.m10462a() + ", st = " + C1093a.m4739a(this.f6967a).m4754g() + ", deviceType = " + telephonyManager.getPhoneType() + ",deviceId = " + telephonyManager.getDeviceId() + ",packageName = " + this.f6971h + ",KEY_EMMCID = " + m10468d() + ",KEY_IMEI = " + m10469e());
        } catch (SecurityException e) {
            C2538c.m12677c("HuaweiGoldMemberInteractors", "getIMEI() SecurityException ");
        } catch (Exception e2) {
            C2538c.m12677c("HuaweiGoldMemberInteractors", "getIMEI() Exception");
        }
        return bundle;
    }

    public void m10473a(Context context, IQueryMemberStatusCallback iQueryMemberStatusCallback) {
        C2538c.m12677c("HuaweiGoldMemberInteractors", "enter queryMemberStatus()");
        this.f6970d.a(m10470f(), context, iQueryMemberStatusCallback);
    }

    public void m10472a(Context context, IActiveMemberCallback iActiveMemberCallback) {
        C2538c.m12677c("HuaweiGoldMemberInteractors", " enter activeMember()");
        this.f6970d.a(m10470f(), context, iActiveMemberCallback);
    }

    public static String m10462a() {
        f6963e = C1093a.m4739a(BaseApplication.m2632b()).m4750c();
        if (f6963e == null) {
            f6963e = "";
        }
        return f6963e;
    }

    public void m10474a(Handler handler) {
        C2538c.m12677c("HuaweiGoldMemberInteractors", "enter getGoldCard():");
        this.f6974l = handler;
        if (C0977d.m3555e(this.f6967a)) {
            m10471g();
            return;
        }
        C2538c.m12677c("HuaweiGoldMemberInteractors", "Network is not Connected ");
        this.f6974l.sendEmptyMessage(13);
        this.f6974l.sendEmptyMessage(4);
    }

    private void m10471g() {
        C2538c.m12677c("HuaweiGoldMemberInteractors", "Enter queryMemberStatus()");
        new Thread(new ab(this)).start();
    }

    public void m10475b() {
        C2538c.m12677c("HuaweiGoldMemberInteractors", " enterGoldCardActivationActivity()");
        Intent intent = new Intent();
        intent.putExtra(f6966j, this.f6973k);
        intent.setClass(this.f6967a, HuaweiMemberActivity.class);
        this.f6967a.startActivity(intent);
    }

    public void m10476c() {
        C2538c.m12677c("HuaweiGoldMemberInteractors", " enterGoldCardActivationActivity()");
        Intent intent = new Intent();
        intent.setClass(this.f6967a, VIPUserInfoActivity.class);
        this.f6967a.startActivity(intent);
    }
}
