package com.huawei.hwdatamigrate.hihealth.sync;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.huawei.hihealth.HiSyncOption;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hwdatamigrate.hihealth.p066a.C1001a;
import com.huawei.hwdatamigrate.hihealth.p068d.C1002g;
import com.huawei.hwdatamigrate.hihealth.p069e.C1003a;
import com.huawei.hwdatamigrate.hihealth.sync.p070a.C1004h;
import com.huawei.hwdatamigrate.hihealth.sync.p071c.C1005a;
import com.huawei.hwdatamigrate.hihealth.sync.p071c.C1006d;
import com.huawei.hwdatamigrate.hihealth.sync.p071c.C1007e;
import com.huawei.hwdatamigrate.hihealth.sync.p071c.C1008f;
import com.huawei.hwdatamigrate.hihealth.sync.p071c.C1009h;
import com.huawei.hwdatamigrate.hihealth.sync.p071c.C1010i;
import com.huawei.hwdatamigrate.hihealth.sync.p071c.C1011m;
import com.huawei.hwdatamigrate.hihealth.sync.p071c.C1012n;
import com.huawei.hwdatamigrate.hihealth.sync.p071c.C1013p;
import com.huawei.hwdatamigrate.hihealth.sync.p071c.C1014q;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1015e;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1016h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1017i;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1018m;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import java.util.ArrayList;
import java.util.List;

public class HiSyncService extends IntentService {
    private Context f1700a;

    public HiSyncService() {
        super("HiH_HiSyncService");
    }

    protected void onHandleIntent(Intent intent) {
        if (this.f1700a == null) {
            this.f1700a = getApplicationContext();
        }
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.m12677c("HiH_HiSyncService", "onHandleIntent sync start !");
        HiSyncOption hiSyncOption = (HiSyncOption) intent.getParcelableExtra("sync_option");
        int intExtra = intent.getIntExtra("sync_appId", 0);
        int intExtra2 = intent.getIntExtra("sync_main_UserID", 0);
        C2538c.m12677c("HiH_HiSyncService", "onHandleIntent hiSyncOption = ", hiSyncOption);
        C2538c.m12677c("HiH_", "onHandleIntent hiSyncOption = ", hiSyncOption);
        if (C1015e.m3860a(hiSyncOption, intExtra, intExtra2)) {
            hiSyncOption.setSyncModel(C1015e.m3868f());
            try {
                m3693a(hiSyncOption, intExtra2, intExtra);
            } catch (Exception e) {
                C2538c.m12680e("HiH_HiSyncService", "onHandleIntent sync failed, e is ", e.getMessage());
                C2538c.m12680e("HiH_", "onHandleIntent sync failed, e is ", e.getMessage());
                C1016h.m3895e(this.f1700a);
            }
            C2538c.m12677c("HiH_HiSyncService", "onHandleIntent end ! totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            C2538c.m12677c("HiH_", "onHandleIntent end ! totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        C2538c.m12679d("HiH_HiSyncService", "onHandleIntent wrong para, sync end ");
    }

    private void m3693a(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        C2538c.m12677c("HiH_HiSyncService", "startSync syncDataType is ", Integer.valueOf(hiSyncOption.getSyncDataType()));
        m3694a(new C1007e(this.f1700a, hiSyncOption, i, i2));
        switch (hiSyncOption.getSyncDataType()) {
            case 1:
                m3702e(hiSyncOption, i, i2);
                break;
            case 2:
                m3705h(hiSyncOption, i, i2);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10001:
                m3706i(hiSyncOption, i, i2);
                break;
            case 10002:
                m3708k(hiSyncOption, i, i2);
                break;
            case HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE /*10003*/:
                m3703f(hiSyncOption, i, i2);
                break;
            case 10004:
                m3704g(hiSyncOption, i, i2);
                break;
            case MessageObserver.RET_AUTH_ERROR /*10005*/:
                m3710m(hiSyncOption, i, i2);
                break;
            case HwAccountConstants.MY_PERMISSIONS_REQUEST_lOCTION /*10006*/:
                m3709l(hiSyncOption, i, i2);
                break;
            case 10007:
                m3707j(hiSyncOption, i, i2);
                break;
            case MessageObserver.RET_CHECK_PARAM_ERROR /*10008*/:
                m3702e(hiSyncOption, i, i2);
                m3704g(hiSyncOption, i, i2);
                m3703f(hiSyncOption, i, i2);
                break;
            case 20000:
                C1016h.m3893c(this.f1700a);
                C1015e.m3858a(true);
                m3696b(hiSyncOption, i, i2);
                C1016h.m3894d(this.f1700a);
                break;
            default:
                C2538c.m12679d("HiH_HiSyncService", "startSync syncDataType is not right, syncDataType is ", Integer.valueOf(r0));
                break;
        }
        if (!C1015e.m3859a()) {
            C1015e.m3861b(true);
            new Thread(new C1005a(this.f1700a, i)).start();
        }
    }

    private void m3696b(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        if (C1018m.m3909a(this.f1700a, i, 1, 0)) {
            m3699c(hiSyncOption, i, i2);
        } else {
            m3701d(hiSyncOption, i, i2);
        }
    }

    private void m3699c(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        C2538c.m12677c("HiH_HiSyncService", "firstSync start");
        long currentTimeMillis = System.currentTimeMillis();
        C1017i.m3900a(true);
        m3708k(hiSyncOption, i, i2);
        C1011m n = m3711n(hiSyncOption, i, i2);
        C1013p o = m3712o(hiSyncOption, i, i2);
        C1012n p = m3713p(hiSyncOption, i, i2);
        C1008f s = m3716s(hiSyncOption, i, i2);
        C1006d r = m3715r(hiSyncOption, i, i2);
        C1010i q = m3714q(hiSyncOption, i, i2);
        long currentTimeMillis2 = System.currentTimeMillis();
        p.mo2312a(C1018m.m3904a(currentTimeMillis2, 1), currentTimeMillis2);
        n.m3807a(3.0d);
        n.mo2312a(C1018m.m3904a(currentTimeMillis2, 1), currentTimeMillis2);
        C1001a.m3647e(this.f1700a);
        C1001a.m3640a(this.f1700a, 1);
        C1003a.m3690a().m3692a(1, "firstSync sport", new C1002g(i2));
        r.mo2312a(C1018m.m3904a(currentTimeMillis2, 3), currentTimeMillis2);
        currentTimeMillis2 -= 172800000;
        n.m3807a(9.0d);
        n.mo2312a(C1018m.m3904a(currentTimeMillis2, 7), currentTimeMillis2);
        p.mo2311a();
        s.mo2311a();
        q.mo2311a();
        o.mo2311a();
        n.mo2311a();
        r.mo2311a();
        C1001a.m3640a(this.f1700a, 0);
        C1001a.m3643b(this.f1700a);
        C1003a.m3690a().m3692a(200, "firstSync all", new C1002g(i2));
        n.mo2313b();
        p.mo2313b();
        s.mo2313b();
        q.mo2313b();
        o.mo2313b();
        r.mo2313b();
        C1017i.m3900a(false);
        C2538c.m12677c("HiH_HiSyncService", "firstSync end ,totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private void m3701d(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        C2538c.m12677c("HiH_HiSyncService", "incrementalSync start");
        long currentTimeMillis = System.currentTimeMillis();
        List u = m3718u(hiSyncOption, i, i2);
        m3695a(u);
        m3708k(hiSyncOption, i, i2);
        C1001a.m3640a(this.f1700a, 0);
        C1001a.m3643b(this.f1700a);
        C1003a.m3690a().m3692a(200, "incrementalSync", new C1002g(i2));
        m3698b(u);
        C2538c.m12677c("HiH_HiSyncService", "incrementalSync end ,totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private void m3702e(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        m3694a(m3711n(hiSyncOption, i, i2));
        C1001a.m3643b(this.f1700a);
    }

    private void m3703f(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        m3694a(m3716s(hiSyncOption, i, i2));
    }

    private void m3704g(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        m3694a(m3713p(hiSyncOption, i, i2));
    }

    private void m3705h(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        m3694a(m3712o(hiSyncOption, i, i2));
    }

    private void m3706i(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        m3694a(m3715r(hiSyncOption, i, i2));
    }

    private void m3707j(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        m3694a(m3714q(hiSyncOption, i, i2));
    }

    private void m3708k(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        C1006d c1014q = new C1014q(this.f1700a, new HiSyncOption(hiSyncOption, 10002), i, i2);
        m3700c(c1014q);
        m3697b(c1014q);
    }

    private void m3709l(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        m3717t(hiSyncOption, i, i2).m3855c();
    }

    private void m3710m(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        C1014q t = m3717t(hiSyncOption, i, i2);
        HiUserInfo userInfo = hiSyncOption.getUserInfo();
        if (userInfo == null) {
            C2538c.m12680e("HiH_HiSyncService", "uploadUserBasic hiUserInfo error!");
            return;
        }
        t.m3853a(userInfo);
    }

    private C1011m m3711n(HiSyncOption hiSyncOption, int i, int i2) {
        return new C1011m(this.f1700a, new HiSyncOption(hiSyncOption, 1), i, i2);
    }

    private C1013p m3712o(HiSyncOption hiSyncOption, int i, int i2) {
        return new C1013p(this.f1700a, new HiSyncOption(hiSyncOption, 2), i, i2);
    }

    private C1012n m3713p(HiSyncOption hiSyncOption, int i, int i2) {
        return new C1012n(this.f1700a, new HiSyncOption(hiSyncOption, 10004), i, i2);
    }

    private C1010i m3714q(HiSyncOption hiSyncOption, int i, int i2) {
        return new C1010i(this.f1700a, new HiSyncOption(hiSyncOption, 10007), i, i2);
    }

    private C1006d m3715r(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        HiSyncOption hiSyncOption2 = new HiSyncOption(hiSyncOption, 10001);
        switch (hiSyncOption2.getSyncModel()) {
            case 2:
                return new C1009h(this.f1700a, hiSyncOption2, i, i2);
            default:
                return new C1009h(this.f1700a, hiSyncOption2, i, i2);
        }
    }

    private C1008f m3716s(HiSyncOption hiSyncOption, int i, int i2) {
        return new C1008f(this.f1700a, new HiSyncOption(hiSyncOption, HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE), i, i2);
    }

    private C1014q m3717t(HiSyncOption hiSyncOption, int i, int i2) {
        return new C1014q(this.f1700a, new HiSyncOption(hiSyncOption, 10002), i, i2);
    }

    private List<C1006d> m3718u(HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        List<C1006d> arrayList = new ArrayList();
        arrayList.add(m3711n(hiSyncOption, i, i2));
        arrayList.add(m3713p(hiSyncOption, i, i2));
        arrayList.add(m3716s(hiSyncOption, i, i2));
        arrayList.add(m3714q(hiSyncOption, i, i2));
        arrayList.add(m3712o(hiSyncOption, i, i2));
        arrayList.add(m3715r(hiSyncOption, i, i2));
        return arrayList;
    }

    private void m3694a(C1006d c1006d) throws C1004h {
        C2538c.m12677c("HiH_HiSyncService", "executeSync hiSyncBase is ", c1006d);
        long currentTimeMillis = System.currentTimeMillis();
        c1006d.mo2311a();
        long currentTimeMillis2 = System.currentTimeMillis();
        C2538c.m12677c("HiH_HiSyncService", "executeSync downLoad end", c1006d, " totalTime = ", Long.valueOf(currentTimeMillis2 - currentTimeMillis));
        c1006d.mo2313b();
        currentTimeMillis = System.currentTimeMillis();
        C2538c.m12677c("HiH_HiSyncService", "executeSync upLoad end", c1006d, " totalTime = ", Long.valueOf(currentTimeMillis - currentTimeMillis2));
    }

    private void m3695a(List<C1006d> list) throws C1004h {
        for (C1006d b : list) {
            m3697b(b);
        }
    }

    private void m3698b(List<C1006d> list) throws C1004h {
        for (C1006d c : list) {
            m3700c(c);
        }
    }

    private void m3697b(C1006d c1006d) throws C1004h {
        long currentTimeMillis = System.currentTimeMillis();
        c1006d.mo2311a();
        C2538c.m12677c("HiH_HiSyncService", "pullDataByVersion end", c1006d, " totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private void m3700c(C1006d c1006d) throws C1004h {
        long currentTimeMillis = System.currentTimeMillis();
        c1006d.mo2313b();
        C2538c.m12677c("HiH_HiSyncService", "pushData end", c1006d, " totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public void onDestroy() {
        super.onDestroy();
        C1015e.m3858a(false);
        C1017i.m3900a(false);
        C2538c.m12677c("HiH_HiSyncService", "onDestroy stop all tasks");
    }
}
