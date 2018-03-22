package com.huawei.p192w;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.multisimservice.model.C1120a;
import com.huawei.multisimservice.model.C1200d;
import com.huawei.multisimservice.model.MultiSimDeviceInfo;
import com.huawei.multisimservice.model.SimInfo;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.w.a;
import com.huawei.w.b;
import com.huawei.w.d;
import com.huawei.w.e;
import com.huawei.w.f;
import com.huawei.w.g;
import com.huawei.w.h;
import com.huawei.w.i;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: HWMultiSimMgr */
public class C2546c extends C0628a {
    private static C2546c f9065e;
    private static Map<Integer, List<IBaseResponseCallback>> f9066i = new HashMap();
    MultiSimDeviceInfo f9067a;
    boolean f9068b = false;
    IBaseResponseCallback f9069c = new d(this);
    Message f9070d = null;
    private C1204c f9071f;
    private C1120a f9072g = null;
    private C1200d f9073h = null;
    private List<IBaseResponseCallback> f9074j = new ArrayList();
    private String f9075k = "";
    private Handler f9076l = new h(this, Looper.getMainLooper());
    private BroadcastReceiver f9077m = new i(this);

    private C2546c(Context context) {
        super(context);
        C2538c.m12677c("HWMultiSimMgr", "HWMultiSimMgr Constructor context = " + context);
        this.f9071f = C1204c.m5370a(context);
        if (this.f9071f == null) {
            C2538c.m12680e("HWMultiSimMgr", "mHWDeviceConfigManager is null");
            return;
        }
        this.f9071f.m5423a(29, this.f9069c);
        BaseApplication.m2632b().registerReceiver(this.f9077m, new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED"), C0976c.f1642a, null);
        new a().a(this);
        new b().a(this);
        this.f9067a = new MultiSimDeviceInfo();
        this.f9067a.setDeviceType(0);
        if (m12753e() && m12755g()) {
            m12731r();
        }
    }

    public static C2546c m12702a() {
        C2538c.m12677c("HWMultiSimMgr", "getInstance() ");
        synchronized (C2546c.class) {
            if (f9065e == null) {
                f9065e = new C2546c(BaseApplication.m2632b());
            }
        }
        return f9065e;
    }

    protected void onDestroy() {
        C2538c.m12677c("HWMultiSimMgr", "onDestroy()");
        super.onDestroy();
        BaseApplication.m2632b().unregisterReceiver(this.f9077m);
        this.f9071f.m5422a(29);
        synchronized (C2546c.m12729p()) {
            f9066i.clear();
        }
        synchronized (this.f9074j) {
            this.f9074j.clear();
        }
        f9065e = null;
        C2538c.m12677c("HWMultiSimMgr", "onDestroy() complete");
    }

    protected Integer getModuleId() {
        return Integer.valueOf(29);
    }

    private static Object m12729p() {
        return f9066i;
    }

    private void m12705a(int i, IBaseResponseCallback iBaseResponseCallback) {
        synchronized (C2546c.m12729p()) {
            if (iBaseResponseCallback != null) {
                List list = (List) f9066i.get(Integer.valueOf(i));
                if (list == null) {
                    list = new ArrayList();
                    f9066i.put(Integer.valueOf(i), list);
                }
                list.add(iBaseResponseCallback);
            }
        }
    }

    private void m12704a(int i, int i2, Object obj) {
        C2538c.m12677c("HWMultiSimMgr", "procCallback callback");
        synchronized (C2546c.m12729p()) {
            List list = (List) f9066i.get(Integer.valueOf(i));
            if (list != null) {
                int i3 = 0;
                while (list.size() > 0) {
                    IBaseResponseCallback iBaseResponseCallback = (IBaseResponseCallback) list.get(i3);
                    if (iBaseResponseCallback != null) {
                        iBaseResponseCallback.onResponse(i2, obj);
                        list.remove(i3);
                        break;
                    }
                    list.remove(i3);
                    i3++;
                }
            }
        }
    }

    public void m12735a(C1120a c1120a) {
        C2538c.m12677c("HWMultiSimMgr", "registerAttachedDeviceMultiSimCallback");
        if (c1120a == null) {
            C2538c.m12680e("HWMultiSimMgr", "callback is null.");
            return;
        }
        this.f9072g = c1120a;
    }

    public void m12746b(C1120a c1120a) {
        C2538c.m12677c("HWMultiSimMgr", "unRegisterAttachedDeviceMultiSimCallback");
        if (c1120a != this.f9072g) {
            C2538c.m12680e("HWMultiSimMgr", "IAttachedDeviceMultiSimCallback not equal");
        }
        this.f9072g = null;
    }

    public void m12736a(C1200d c1200d) {
        C2538c.m12677c("HWMultiSimMgr", "registeIOpenMultiSimCalbcak");
        if (c1200d == null) {
            C2538c.m12680e("HWMultiSimMgr", "callback is null.");
            return;
        }
        this.f9073h = c1200d;
    }

    public void m12747b(C1200d c1200d) {
        C2538c.m12677c("HWMultiSimMgr", "unRegisterIOpenMultiSimCalbcak");
        if (c1200d != this.f9073h) {
            C2538c.m12680e("HWMultiSimMgr", "mIOpenMultiSimCalbcak not equal");
        }
        this.f9073h = null;
    }

    private void m12712a(byte[] bArr, int i) {
        int i2 = 201000;
        C2538c.m12677c("HWMultiSimMgr", "procSetCmdResult Complete cmd=" + i);
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                C2538c.m12677c("HWMultiSimMgr", "procSetCmdResult return err:" + com.huawei.w.a.b.a(bArr));
            }
        } catch (Exception e) {
            C2538c.m12680e("HWMultiSimMgr", " Exception :" + e.getMessage());
        }
        C2538c.m12677c("HWMultiSimMgr", "procSetCmdResult return err:" + i2);
    }

    private void m12711a(byte[] bArr) {
        Exception exception;
        Object obj;
        Exception exception2;
        Object obj2 = 100006;
        C2538c.m12677c("HWMultiSimMgr", "procSimInfoQuery");
        Object multiSimDeviceInfo = new MultiSimDeviceInfo();
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                int a = com.huawei.w.a.b.a(bArr);
                C2538c.m12680e("HWMultiSimMgr", "procSimInfoQuery return err:" + a);
            } else {
                multiSimDeviceInfo = com.huawei.w.a.b.b(bArr);
                try {
                    C2538c.m12677c("HWMultiSimMgr", "procSimInfoQuery simInfo :" + multiSimDeviceInfo);
                    int i = 100000;
                } catch (Exception e) {
                    exception = e;
                    obj = multiSimDeviceInfo;
                    exception2 = exception;
                    C2538c.m12677c("HWMultiSimMgr", " Exception :" + exception2.getMessage());
                    multiSimDeviceInfo = obj;
                    if (obj2 == 100000) {
                        multiSimDeviceInfo.setResultCode(1);
                    } else {
                        multiSimDeviceInfo.setResultCode(0);
                    }
                    m12704a(6, 0, multiSimDeviceInfo);
                }
            }
        } catch (Exception e2) {
            exception = e2;
            obj = multiSimDeviceInfo;
            exception2 = exception;
            C2538c.m12677c("HWMultiSimMgr", " Exception :" + exception2.getMessage());
            multiSimDeviceInfo = obj;
            if (obj2 == 100000) {
                multiSimDeviceInfo.setResultCode(0);
            } else {
                multiSimDeviceInfo.setResultCode(1);
            }
            m12704a(6, 0, multiSimDeviceInfo);
        }
        if (obj2 == 100000) {
            multiSimDeviceInfo.setResultCode(1);
        } else {
            multiSimDeviceInfo.setResultCode(0);
        }
        m12704a(6, 0, multiSimDeviceInfo);
    }

    private void m12716b(byte[] bArr) {
        int a;
        int i = 100006;
        C2538c.m12677c("HWMultiSimMgr", "procRemoveProfileRet");
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                a = com.huawei.w.a.b.a(bArr);
                C2538c.m12680e("HWMultiSimMgr", "procRemoveProfileRet return err:" + a);
                a = 1;
            } else {
                a = com.huawei.w.a.b.c(bArr);
                i = 100000;
            }
        } catch (Exception e) {
            C2538c.m12677c("HWMultiSimMgr", " Exception :" + e.getMessage());
            a = 1;
        }
        C2538c.m12680e("HWMultiSimMgr", "procRemoveProfileRet errCode:" + i + "delProfileRet:" + a);
        com.huawei.w.a.a.a(9, i);
        if (this.f9072g != null) {
            try {
                this.f9072g.mo2357a(a);
            } catch (RemoteException e2) {
                C2538c.m12680e("HWMultiSimMgr", "procRemoveReportRet excption" + e2);
            }
        }
    }

    public void m12737a(String str) {
        m12738a(str, 1, new e(this), null);
    }

    private void m12714b(MultiSimDeviceInfo multiSimDeviceInfo) {
        if (multiSimDeviceInfo == null) {
            C2538c.m12677c("HWMultiSimMgr", "inpurt devInfo is null");
            return;
        }
        try {
            if (this.f9072g != null) {
                this.f9072g.mo2359a(multiSimDeviceInfo);
            } else if (this.f9073h != null) {
                this.f9073h.m5344a(multiSimDeviceInfo);
            }
        } catch (RemoteException e) {
            C2538c.m12677c("HWMultiSimMgr", "reportDeviceInfo excption" + e);
        }
    }

    private void m12703a(int i) {
        MultiSimDeviceInfo multiSimDeviceInfo = new MultiSimDeviceInfo();
        multiSimDeviceInfo.setResultCode(i);
        m12714b(multiSimDeviceInfo);
    }

    public void m12744b() {
        C2538c.m12677c("HWMultiSimMgr", " simInfoQuery ");
        if (m12753e()) {
            m12750c();
            return;
        }
        this.f9076l.sendEmptyMessageDelayed(4, 3000);
        C2538c.m12677c("HWMultiSimMgr", "simInfoQuery device not connect wait");
    }

    public void m12750c() {
        C2538c.m12677c("HWMultiSimMgr", " simInfoQueryFromDev ");
        if (!m12753e()) {
            C2538c.m12677c("HWMultiSimMgr", "simInfoQuery device not connect report not connect");
            m12703a(-2);
        } else if (!m12755g()) {
            C2538c.m12677c("HWMultiSimMgr", "simInfoQuery device not support multisim");
            m12703a(-3);
        } else if (TextUtils.isEmpty(this.f9075k)) {
            C2538c.m12677c("HWMultiSimMgr", "mCurCallingApp is empty");
            m12703a(0);
        } else if (this.f9075k.equals("com.huawei.hwmultisim") || m12749b(this.f9075k)) {
            this.f9076l.sendEmptyMessageDelayed(5, StatisticConfig.MIN_UPLOAD_INTERVAL);
            m12717c(new f(this));
        } else {
            C2538c.m12680e("HWMultiSimMgr", "simInfoQueryFromDev app not auth");
            Intent intent = new Intent();
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setClassName(BaseApplication.m2632b(), "com.huawei.bone.root.SplashActivity");
            intent.setPackage(BaseApplication.m2632b().getPackageName());
            intent.putExtra("need_multi_sim_auth", true);
            BaseApplication.m2632b().startActivity(intent);
        }
    }

    private void m12730q() {
        if (m12753e()) {
            C2538c.m12677c("HWMultiSimMgr", "simInfoQueryTimeout device timeout unknow error");
            m12703a(0);
            return;
        }
        C2538c.m12677c("HWMultiSimMgr", "simInfoQueryTimeout device not connect report not connect");
        m12703a(-2);
    }

    private void m12731r() {
        C2538c.m12677c("HWMultiSimMgr", " getLocalDeviceInfo");
        m12717c(new g(this));
    }

    private void m12717c(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("HWMultiSimMgr", " sendSimInfoQueryCmd");
        m12705a(6, iBaseResponseCallback);
        com.huawei.w.a.a.a();
    }

    public void m12741a(List<SimInfo> list) {
        C2538c.m12677c("HWMultiSimMgr", " removeESimProfile");
        com.huawei.w.a.a.a(list);
    }

    public void m12732a(int i, String str) {
        C2538c.m12677c("HWMultiSimMgr", " eSimStatusNotify");
        com.huawei.w.a.a.a(i, str);
    }

    public boolean m12749b(String str) {
        C2538c.m12677c("HWMultiSimMgr", " getAppAuthStatus :", str);
        return new a().b(this, str, m12756h());
    }

    public void m12742a(boolean z) {
        C2538c.m12677c("HWMultiSimMgr", " setAppAuthStatus");
        a aVar = new a();
        if (z) {
            aVar.a(this, this.f9075k, m12756h());
            m12744b();
            return;
        }
        m12703a(-1);
    }

    public void m12751c(String str) {
        this.f9075k = str;
    }

    public String m12752d() {
        return this.f9075k;
    }

    public boolean m12753e() {
        DeviceInfo c = this.f9071f.m5447c();
        C2538c.m12674b("HWMultiSimMgr", " isDeviceConnect");
        if (c == null || c.getDeviceConnectState() != 2) {
            return false;
        }
        C2538c.m12677c("HWMultiSimMgr", " getAttachedDeviceMultiSimInfo deviceInfo is connect");
        return true;
    }

    public boolean m12754f() {
        boolean z = true;
        DeviceCapability a = C0972a.m3499a();
        if (a == null) {
            C2538c.m12680e("HWMultiSimMgr", "isSupportESIM deviceCapability is null");
            return false;
        }
        if (a.isSupportEsim()) {
            C2538c.m12677c("HWMultiSimMgr", "device support esim");
        } else {
            z = false;
        }
        return z;
    }

    public void m12733a(Message message) {
        this.f9070d = message;
    }

    public boolean m12755g() {
        boolean z = true;
        DeviceCapability a = C0972a.m3499a();
        if (a == null) {
            C2538c.m12680e("HWMultiSimMgr", "isSupportMultiSim deviceCapability is null");
            return false;
        }
        if (a.isSupportMultiSim()) {
            C2538c.m12677c("HWMultiSimMgr", "device support multiSim");
        } else {
            z = false;
        }
        return z;
    }

    public String m12756h() {
        String str = "";
        DeviceInfo c = this.f9071f.m5447c();
        if (c != null) {
            return c.getDeviceIdentify();
        }
        return str;
    }

    public void m12739a(String str, IBaseResponseCallback iBaseResponseCallback, IBaseResponseCallback iBaseResponseCallback2) {
        C2538c.m12677c("HWMultiSimMgr", "Now it is openning Esim" + str);
        m12705a(1, iBaseResponseCallback);
        m12705a(2, iBaseResponseCallback2);
        com.huawei.w.a.a.a(str, 0);
        this.f9076l.sendEmptyMessageDelayed(0, 45000);
    }

    public void m12738a(String str, int i, IBaseResponseCallback iBaseResponseCallback, IBaseResponseCallback iBaseResponseCallback2) {
        C2538c.m12677c("HWMultiSimMgr", "Now it is openning Esim" + str);
        m12705a(1, iBaseResponseCallback);
        m12705a(2, iBaseResponseCallback2);
        com.huawei.w.a.a.a(str, i);
        this.f9076l.sendEmptyMessageDelayed(0, 45000);
    }

    public void m12734a(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (this.f9074j) {
            if (iBaseResponseCallback != null) {
                this.f9074j.add(iBaseResponseCallback);
            }
        }
    }

    public void m12745b(IBaseResponseCallback iBaseResponseCallback) {
        synchronized (this.f9074j) {
            if (iBaseResponseCallback != null) {
                this.f9074j.remove(iBaseResponseCallback);
            }
        }
    }

    private void m12720c(byte[] bArr) {
        C2538c.m12677c("HWMultiSimMgr", "procMateDataAuth");
        this.f9076l.removeMessages(1);
        try {
            Object e = com.huawei.w.a.b.e(bArr);
            C2538c.m12677c("HWMultiSimMgr", "procMateDataAuth :" + e.c());
            if (e.c() == 0) {
                m12704a(2, 0, e);
                com.huawei.w.a.a.a(2, true);
                return;
            }
            m12704a(2, e.c(), null);
            if (-1 == e.c()) {
                com.huawei.w.a.a.a(2, false);
            } else {
                com.huawei.w.a.a.a(2, true);
            }
        } catch (Exception e2) {
            C2538c.m12680e("HWMultiSimMgr", " Exception :" + e2.getMessage());
            m12704a(2, -1, null);
            com.huawei.w.a.a.a(2, false);
        }
    }

    private void m12723d(byte[] bArr) {
        C2538c.m12677c("HWMultiSimMgr", "procOpenEsim");
        this.f9076l.removeMessages(0);
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                int a = com.huawei.w.a.b.a(bArr);
                C2538c.m12680e("HWMultiSimMgr", "procOpenEsim return err:" + a);
                m12704a(1, a, null);
                if (a == 0) {
                    this.f9076l.sendEmptyMessageDelayed(1, 150000);
                    return;
                } else if (100005 == a) {
                    m12704a(2, 1000, null);
                    return;
                } else {
                    m12704a(2, -1, null);
                    return;
                }
            }
            m12704a(1, 100001, null);
            m12704a(2, -1, null);
        } catch (Exception e) {
            C2538c.m12677c("HWMultiSimMgr", " Exception :" + e.getMessage());
            m12704a(1, 100001, null);
            m12704a(2, -1, null);
        }
    }

    private void m12726e(byte[] bArr) {
        C2538c.m12677c("HWMultiSimMgr", "procConformCode");
        this.f9076l.removeMessages(2);
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                int a = com.huawei.w.a.b.a(bArr);
                C2538c.m12680e("HWMultiSimMgr", "procRemoveProfileRet return err:" + a);
                m12704a(3, a, null);
                if (a == 0) {
                    this.f9076l.sendEmptyMessageDelayed(3, 150000);
                    return;
                } else if (100005 == a) {
                    m12704a(4, 1000, null);
                    return;
                } else {
                    m12704a(4, -1, null);
                    return;
                }
            }
            m12704a(3, 100001, null);
            m12704a(4, -1, null);
        } catch (Exception e) {
            C2538c.m12677c("HWMultiSimMgr", " Exception :" + e.getMessage());
            m12704a(3, 100001, null);
            m12704a(4, -1, null);
        }
    }

    private void m12728f(byte[] bArr) {
        C2538c.m12677c("HWMultiSimMgr", "procConformCodeAuth");
        this.f9076l.removeMessages(3);
        try {
            int d = com.huawei.w.a.b.d(bArr);
            C2538c.m12680e("HWMultiSimMgr", "procRemoveProfileRet return err:" + d);
            m12704a(4, d, null);
            if (-1 == d) {
                com.huawei.w.a.a.a(4, false);
            } else {
                com.huawei.w.a.a.a(4, true);
            }
        } catch (Exception e) {
            C2538c.m12677c("HWMultiSimMgr", " Exception :" + e.getMessage());
            m12704a(4, -1, null);
            com.huawei.w.a.a.a(4, false);
        }
    }

    public int m12757i() {
        DeviceInfo c = this.f9071f.m5447c();
        if (c != null) {
            return c.getDeviceConnectState();
        }
        C2538c.m12680e("HWMultiSimMgr", "syncFitnessTodayData get device info error");
        return 3;
    }

    public void m12748b(String str, int i, IBaseResponseCallback iBaseResponseCallback, IBaseResponseCallback iBaseResponseCallback2) {
        m12705a(3, iBaseResponseCallback);
        m12705a(4, iBaseResponseCallback2);
        com.huawei.w.a.a.b(str, i);
        this.f9076l.sendEmptyMessageDelayed(2, 45000);
    }

    public String m12758j() {
        String str = "";
        if (this.f9071f == null) {
            C2538c.m12680e("HWMultiSimMgr", "mHWDeviceConfigManager is null");
            return str;
        }
        DeviceInfo c = this.f9071f.m5447c();
        if (c == null || c.getDeviceConnectState() != 2) {
            return str;
        }
        return c.getDeviceName();
    }

    public MultiSimDeviceInfo m12759k() {
        C2538c.m12677c("HWMultiSimMgr", "enter getMultiSimDevicInfo()");
        return this.f9067a;
    }

    public int m12760l() {
        C2538c.m12677c("HWMultiSimMgr", "enter getDevicBindStatus()");
        if (this.f9068b) {
            return new b().a(this, this.f9067a);
        }
        this.f9068b = true;
        return 2;
    }

    public String m12761m() {
        C2538c.m12677c("HWMultiSimMgr", "enter getDevicBindPhoneNum()");
        return new b().b(this, this.f9067a);
    }

    public String m12762n() {
        String str = "";
        if (m12743a(this.f9067a)) {
            return this.f9067a.getActiveSimProfileInfo().getIMSI();
        }
        return str;
    }

    public boolean m12743a(MultiSimDeviceInfo multiSimDeviceInfo) {
        C2538c.m12677c("HWMultiSimMgr", "isValidDevice");
        if (multiSimDeviceInfo == null) {
            C2538c.m12679d("HWMultiSimMgr", "devceInfo is null");
            return false;
        } else if (this.f9067a.getDeviceType() != 1 && this.f9067a.getDeviceType() != 2) {
            C2538c.m12679d("HWMultiSimMgr", "invalid device type");
            return false;
        } else if (this.f9067a.getDeviceIMEI().isEmpty() || this.f9067a.getDeviceSerialNumber().isEmpty()) {
            C2538c.m12679d("HWMultiSimMgr", "device id invalide");
            return false;
        } else {
            SimInfo activeSimProfileInfo = this.f9067a.getActiveSimProfileInfo();
            if (activeSimProfileInfo != null && !activeSimProfileInfo.getIMSI().isEmpty()) {
                return true;
            }
            C2538c.m12679d("HWMultiSimMgr", "simInfo invalide");
            return false;
        }
    }

    public void m12740a(String str, String str2, int i) {
        C2538c.m12677c("HWMultiSimMgr", "enter setDeviceBindStatus() phoneNum=", str, " bindStatus=", Integer.valueOf(i));
        if (m12743a(this.f9067a)) {
            new b().a(this, str, i, str2, this.f9067a);
            return;
        }
        C2538c.m12679d("HWMultiSimMgr", "invalid device");
    }

    public String m12763o() {
        C2538c.m12677c("HWMultiSimMgr", "enter getPairedNum()");
        return new b().c(this, this.f9067a);
    }
}
