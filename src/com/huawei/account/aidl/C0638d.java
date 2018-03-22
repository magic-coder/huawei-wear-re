package com.huawei.account.aidl;

import android.content.Intent;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: AccountAidlService */
class C0638d extends C0637f {
    final /* synthetic */ AccountAidlService f1137a;

    C0638d(AccountAidlService accountAidlService) {
        this.f1137a = accountAidlService;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String str = null;
        String[] packagesForUid = this.f1137a.getPackageManager().getPackagesForUid(C0638d.getCallingUid());
        if (packagesForUid != null && packagesForUid.length > 0) {
            str = packagesForUid[0];
        }
        if (str == null || str.startsWith(WeChat.HEALTH_PACKAGE_NAME)) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        C2538c.m12677c(this.f1137a.f1128a, "onTransact packagename auth failed!");
        return false;
    }

    public AccountAidlInfo mo2111a() throws RemoteException {
        C2538c.m12677c(this.f1137a.f1128a, "getRemoteAccountInfo() enter!");
        if (this.f1137a.f1130c != null) {
            C2538c.m12677c(this.f1137a.f1128a, "getRemoteAccountInfo() countDownLatch not null");
            this.f1137a.f1130c.countDown();
            this.f1137a.f1130c = null;
        }
        String a = C0996a.m3612a(this.f1137a.f1129b, String.valueOf(20007), "migrate_provide_login_infomation");
        C2538c.m12677c(this.f1137a.f1128a, "getRemoteAccountInfo() not support! 2 local:" + a);
        if (!"migrate_support".equals(a)) {
            return null;
        }
        boolean await;
        Intent intent = new Intent();
        intent.setAction("com.huawei.bone.health.GET_USER_INFO");
        intent.setPackage(this.f1137a.f1129b.getPackageName());
        C2538c.m12674b(this.f1137a.f1128a, "getPackageName:" + this.f1137a.f1129b.getPackageName());
        this.f1137a.f1129b.getApplicationContext().sendBroadcast(intent, C0976c.f1642a);
        this.f1137a.f1130c = new CountDownLatch(1);
        try {
            await = this.f1137a.f1130c.await(6, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            C2538c.m12677c(this.f1137a.f1128a, "getRemoteAccountInfo countdo timeout");
            await = false;
        }
        C2538c.m12677c(this.f1137a.f1128a, "getRemoteAccountInfo countDownLatch.await result:" + await);
        C2538c.m12674b(this.f1137a.f1128a, "getRemoteAccountInfo userinfo:" + this.f1137a.f1131d);
        if (!await || TextUtils.isEmpty(this.f1137a.f1131d)) {
            C2538c.m12677c(this.f1137a.f1128a, "getRemoteAccountInfo() not support! local:" + a);
            return null;
        }
        AccountAidlInfo accountAidlInfo = (AccountAidlInfo) new Gson().fromJson(this.f1137a.f1131d, AccountAidlInfo.class);
        if (accountAidlInfo != null) {
            C2538c.m12674b(this.f1137a.f1128a, "getRemoteAccountInfo():" + accountAidlInfo.toString());
            return accountAidlInfo;
        }
        C2538c.m12680e(this.f1137a.f1128a, "getRemoteAccountInfo() json is null");
        return accountAidlInfo;
    }

    public void mo2112b() throws RemoteException {
        C2538c.m12677c(this.f1137a.f1128a, "getRemoteAccountInfo() enter!");
        C1093a.m4739a(this.f1137a.f1129b).m4756i();
    }
}
