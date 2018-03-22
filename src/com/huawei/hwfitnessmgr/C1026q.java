package com.huawei.hwfitnessmgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.MotionEventCompat;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.google.gson.Gson;
import com.huawei.ab.C0630m;
import com.huawei.hihealth.HiAccountInfo;
import com.huawei.hihealth.HiUserPreference;
import com.huawei.hihealth.p036a.C0824b;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcloudmodel.p061c.C0970w;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.datatypes.m;
import com.huawei.hwcommonmodel.datatypes.t;
import com.huawei.hwcommonmodel.fitnessdatatype.ActivityReminder;
import com.huawei.hwcommonmodel.fitnessdatatype.DataTotalMotion;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSportType;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateZoneThroshold;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartZoneConf;
import com.huawei.hwcommonmodel.fitnessdatatype.MotionGoal;
import com.huawei.hwcommonmodel.fitnessdatatype.SleepTotalData;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwcommonservice.model.C0990d;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.a;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.b;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.c;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.d;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.e;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.f;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.g;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.h;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.i;
import com.huawei.hwfitnessmgr.deviceadapter.datatype.k;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p091m.C1111d;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import com.huawei.up.model.UserInfomation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: HWFitnessMgr */
public class C1026q extends C0628a {
    private static Map<Integer, List<IBaseResponseCallback>> f1857G = new HashMap();
    private static final Object f1858L = new Object();
    private static Object f1859M = new Object();
    private static Object f1860S = new Object();
    static String f1861m = "";
    private static C1026q f1862o;
    private static Object f1863r = new Object();
    private int f1864A = 0;
    private int f1865B = 0;
    private int f1866C = 0;
    private int f1867D = -1;
    private List<String> f1868E = new ArrayList();
    private a f1869F = new a();
    private boolean f1870H = false;
    private Handler f1871I = null;
    private HandlerThread f1872J = null;
    private com.huawei.af.a f1873K;
    private BroadcastReceiver f1874N = new ae(this);
    private BroadcastReceiver f1875O = new ah(this);
    private BroadcastReceiver f1876P = new ai(this);
    private BroadcastReceiver f1877Q = new ak(this);
    private BroadcastReceiver f1878R = new am(this);
    private int f1879T = 0;
    private int f1880U = 0;
    private int f1881V = 0;
    private int f1882W = 0;
    private int f1883X = 0;
    private int f1884Y = 0;
    private long f1885Z = 0;
    ExecutorService f1886a;
    private long aa = 0;
    private C0990d ab = null;
    public int f1887b = 0;
    int f1888c = 0;
    List<h> f1889d;
    IBaseResponseCallback f1890e = new an(this);
    List<i> f1891f = new ArrayList();
    List<k> f1892g = new ArrayList();
    List<Integer> f1893h;
    e f1894i;
    List<b> f1895j = new ArrayList();
    List<a> f1896k = new ArrayList();
    ay f1897l = null;
    private Context f1898n;
    private C1204c f1899p;
    private g f1900q;
    private ap f1901s;
    private boolean f1902t = false;
    private boolean f1903u = false;
    private int f1904v = -1;
    private int f1905w = -1;
    private int f1906x = -1;
    private int f1907y = 0;
    private int f1908z = 0;

    protected com.huawei.af.a m4117a() {
        return this.f1873K;
    }

    private C1026q(Context context) {
        super(context);
        C2538c.m12661a("05", 1, "HWFitnessMgr", "HWFitnessMgr Constructor");
        this.f1898n = context;
        this.f1899p = C1204c.m5370a(context);
        if (this.f1899p == null) {
            C2538c.m12672b("05", 1, "HWFitnessMgr", "mHWDeviceConfigManager is null");
            return;
        }
        this.f1899p.m5423a(7, this.f1890e);
        this.f1900q = g.a();
        this.f1886a = Executors.newFixedThreadPool(5);
        this.f1900q.a(this);
        m4115z();
        this.f1901s = new ap(this, BaseApplication.m2632b().getMainLooper());
        registerBroadcast(this.f1875O, "com.huawei.plugin.account.login");
        registerBroadcast(this.f1875O, "com.huawei.bone.action.FITNESS_USERINFO_UPDATED");
        m4109t();
        this.f1872J = new HandlerThread("HWFitnessMgr");
        this.f1872J.start();
        this.f1871I = new ar(this, this.f1872J.getLooper());
        this.f1873K = com.huawei.af.a.a(context);
        if (this.f1873K == null) {
            C2538c.m12680e("HWFitnessMgr", "mHWCombineMigrateMgr is null");
        }
    }

    public static C1026q m4018a(Context context) {
        C1026q c1026q;
        synchronized (f1858L) {
            C2538c.m12677c("HWFitnessMgr", "getInstance() context = " + context);
            if (f1862o == null) {
                f1862o = new C1026q(BaseApplication.m2632b());
            }
            c1026q = f1862o;
        }
        return c1026q;
    }

    public Integer getModuleId() {
        return Integer.valueOf(7);
    }

    private static synchronized Object m4107r() {
        Map map;
        synchronized (C1026q.class) {
            map = f1857G;
        }
        return map;
    }

    private void m4021a(int i, IBaseResponseCallback iBaseResponseCallback) {
        synchronized (C1026q.m4107r()) {
            if (iBaseResponseCallback != null) {
                List list = (List) f1857G.get(Integer.valueOf(i));
                if (list == null) {
                    list = new ArrayList();
                    f1857G.put(Integer.valueOf(i), list);
                }
                list.add(iBaseResponseCallback);
            }
        }
    }

    private void m4019a(int i, int i2, Object obj) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procCallback callback cmd=", Integer.valueOf(i), " error=", Integer.valueOf(i2));
        synchronized (C1026q.m4107r()) {
            List list = (List) f1857G.get(Integer.valueOf(i));
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4025a(int r9, java.util.List<com.huawei.hwcommonmodel.fitnessdatatype.FitnessTotalData> r10) {
        /*
        r8 = this;
        r7 = 7;
        r6 = 1;
        r0 = 0;
        r1 = "05";
        r2 = "HWFitnessMgr";
        r3 = 4;
        r3 = new java.lang.Object[r3];
        r4 = "getReveseSyncData onChange type=";
        r3[r0] = r4;
        r4 = java.lang.Integer.valueOf(r9);
        r3[r6] = r4;
        r4 = 2;
        r5 = " listsize=";
        r3[r4] = r5;
        r4 = 3;
        r3[r4] = r10;
        com.huawei.p190v.C2538c.m12661a(r1, r6, r2, r3);
        r3 = f1859M;
        monitor-enter(r3);
        r1 = r8.f1889d;	 Catch:{ all -> 0x00dd }
        r1 = r1.size();	 Catch:{ all -> 0x00dd }
        if (r1 == r7) goto L_0x0039;
    L_0x002a:
        r0 = "HWFitnessMgr";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x00dd }
        r2 = 0;
        r4 = "getReveseSyncData is not 7";
        r1[r2] = r4;	 Catch:{ all -> 0x00dd }
        com.huawei.p190v.C2538c.m12677c(r0, r1);	 Catch:{ all -> 0x00dd }
        monitor-exit(r3);	 Catch:{ all -> 0x00dd }
    L_0x0038:
        return;
    L_0x0039:
        r2 = r0;
    L_0x003a:
        if (r2 >= r7) goto L_0x00e0;
    L_0x003c:
        if (r10 == 0) goto L_0x0082;
    L_0x003e:
        r0 = r10.size();	 Catch:{ all -> 0x00dd }
        if (r0 != r7) goto L_0x0082;
    L_0x0044:
        r0 = 6 - r2;
        r0 = r10.get(r0);	 Catch:{ all -> 0x00dd }
        r0 = (com.huawei.hwcommonmodel.fitnessdatatype.FitnessTotalData) r0;	 Catch:{ all -> 0x00dd }
        r1 = r0;
    L_0x004d:
        r0 = 221; // 0xdd float:3.1E-43 double:1.09E-321;
        if (r9 != r0) goto L_0x0089;
    L_0x0051:
        r0 = r8.f1889d;	 Catch:{ all -> 0x00dd }
        r0 = r0.get(r2);	 Catch:{ all -> 0x00dd }
        r0 = (com.huawei.hwfitnessmgr.deviceadapter.datatype.h) r0;	 Catch:{ all -> 0x00dd }
        r4 = r1.getSteps();	 Catch:{ all -> 0x00dd }
        r0.a(r4);	 Catch:{ all -> 0x00dd }
        r0 = r8.f1889d;	 Catch:{ all -> 0x00dd }
        r0 = r0.get(r2);	 Catch:{ all -> 0x00dd }
        r0 = (com.huawei.hwfitnessmgr.deviceadapter.datatype.h) r0;	 Catch:{ all -> 0x00dd }
        r4 = r1.getCalorie();	 Catch:{ all -> 0x00dd }
        r0.b(r4);	 Catch:{ all -> 0x00dd }
        r0 = r8.f1889d;	 Catch:{ all -> 0x00dd }
        r0 = r0.get(r2);	 Catch:{ all -> 0x00dd }
        r0 = (com.huawei.hwfitnessmgr.deviceadapter.datatype.h) r0;	 Catch:{ all -> 0x00dd }
        r1 = r1.getDistance();	 Catch:{ all -> 0x00dd }
        r0.c(r1);	 Catch:{ all -> 0x00dd }
    L_0x007e:
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x003a;
    L_0x0082:
        r0 = new com.huawei.hwcommonmodel.fitnessdatatype.FitnessTotalData;	 Catch:{ all -> 0x00dd }
        r0.<init>();	 Catch:{ all -> 0x00dd }
        r1 = r0;
        goto L_0x004d;
    L_0x0089:
        r4 = new com.huawei.hwcommonmodel.fitnessdatatype.FitnessTotalData;	 Catch:{ all -> 0x00dd }
        r4.<init>();	 Catch:{ all -> 0x00dd }
        r0 = r1.getSportType();	 Catch:{ all -> 0x00dd }
        r4.setSportType(r0);	 Catch:{ all -> 0x00dd }
        r0 = r1.getSteps();	 Catch:{ all -> 0x00dd }
        r4.setSteps(r0);	 Catch:{ all -> 0x00dd }
        r0 = r1.getCalorie();	 Catch:{ all -> 0x00dd }
        r4.setCalorie(r0);	 Catch:{ all -> 0x00dd }
        r0 = r1.getDistance();	 Catch:{ all -> 0x00dd }
        r4.setDistance(r0);	 Catch:{ all -> 0x00dd }
        r0 = r1.getDuration();	 Catch:{ all -> 0x00dd }
        r4.setDuration(r0);	 Catch:{ all -> 0x00dd }
        r0 = r1.getLowIntensiveTime();	 Catch:{ all -> 0x00dd }
        r4.setLowIntensiveTime(r0);	 Catch:{ all -> 0x00dd }
        r0 = r1.getMidIntensiveTime();	 Catch:{ all -> 0x00dd }
        r4.setMidIntensiveTime(r0);	 Catch:{ all -> 0x00dd }
        r0 = r1.getHighIntensiveTime();	 Catch:{ all -> 0x00dd }
        r4.setHighIntensiveTime(r0);	 Catch:{ all -> 0x00dd }
        r0 = r1.getStandTimes();	 Catch:{ all -> 0x00dd }
        r4.setStandTimes(r0);	 Catch:{ all -> 0x00dd }
        r0 = r8.f1889d;	 Catch:{ all -> 0x00dd }
        r0 = r0.get(r2);	 Catch:{ all -> 0x00dd }
        r0 = (com.huawei.hwfitnessmgr.deviceadapter.datatype.h) r0;	 Catch:{ all -> 0x00dd }
        r0 = r0.d();	 Catch:{ all -> 0x00dd }
        r0.add(r4);	 Catch:{ all -> 0x00dd }
        goto L_0x007e;
    L_0x00dd:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00dd }
        throw r0;
    L_0x00e0:
        r0 = r8.f1888c;	 Catch:{ all -> 0x00dd }
        r1 = 5;
        if (r0 != r1) goto L_0x00ea;
    L_0x00e5:
        r0 = r8.f1889d;	 Catch:{ all -> 0x00dd }
        com.huawei.hwfitnessmgr.deviceadapter.d.c(r0);	 Catch:{ all -> 0x00dd }
    L_0x00ea:
        monitor-exit(r3);	 Catch:{ all -> 0x00dd }
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwfitnessmgr.q.a(int, java.util.List):void");
    }

    private void m4108s() {
        int i = 0;
        C2538c.m12661a("05", 1, "HWFitnessMgr", "reverseDataSync onChange");
        if (this.f1870H) {
            C2538c.m12677c("HWFitnessMgr", "reverseDataSync isDatalogin:" + C0970w.m3488a(C1093a.m4739a(this.f1898n).m4750c()));
            if (C0970w.m3488a(C1093a.m4739a(this.f1898n).m4750c())) {
                DeviceCapability a = C0972a.m3499a();
                if (a == null) {
                    C2538c.m12680e("HWFitnessMgr", "reverseDataSync deviceCapability is null");
                    return;
                } else if (!a.isReserveSync()) {
                    C2538c.m12677c("HWFitnessMgr", "reverseDataSync is not support");
                    return;
                } else if (m4136d()) {
                    synchronized (f1859M) {
                        this.f1889d = new ArrayList();
                        this.f1888c = 0;
                        for (int i2 = 0; i2 < 7; i2++) {
                            this.f1889d.add(new h());
                        }
                    }
                    int[] iArr = new int[]{FitnessSportType.HW_FITNESS_SPORT_ALL, 1, 2, 4, 3};
                    while (i < iArr.length) {
                        int i3 = iArr[i];
                        com.huawei.t.a.a().a(m4051b(System.currentTimeMillis() / 1000) - 518400, i3, 1440, 7, new r(this, i3));
                        i++;
                    }
                    return;
                } else {
                    C2538c.m12677c("HWFitnessMgr", "reverseDataSync not enable");
                    return;
                }
            }
            return;
        }
        C2538c.m12677c("HWFitnessMgr", "reverseDataSync onChange isSupportReverse is false,return ");
    }

    private void m4109t() {
        this.f1898n.registerReceiver(this.f1874N, new IntentFilter("com.huawei.bone.action.CONNECTION_STATE_CHANGED"));
        this.f1898n.registerReceiver(this.f1874N, new IntentFilter("com.huawei.bone.action.DEVICE_LIST_CHANGED"));
        IntentFilter intentFilter = new IntentFilter("com.huawei.hihealth.action_user_goal_change");
        intentFilter.addAction("com.huawei.hihealth.action_receive_push");
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.f1898n);
        if (instance != null) {
            instance.registerReceiver(this.f1877Q, intentFilter);
        }
        com.huawei.hwcommonmodel.d.a.a(this.f1898n, this.f1876P, new IntentFilter("action_change_core_sleep_button"));
    }

    private void m4110u() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "sendDetailSyncSuccBroadcast.");
        this.f1898n.sendBroadcast(new Intent("com.huawei.bone.action.FITNESS_DATA_DETAIL_SYNC"), C0976c.f1642a);
        this.f1898n.sendBroadcast(new Intent("com.huawei.health.fitness_detail_sync_success"));
    }

    private void m4111v() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "sendTodaySyncSuccBroadcast.");
        this.f1898n.sendBroadcast(new Intent("com.huawei.bone.action.FITNESS_DATA_TODAY_SYNC"), C0976c.f1642a);
        this.f1898n.sendBroadcast(new Intent("com.huawei.health.fitness_summary_sync_success"));
    }

    private void m4112w() {
        C2538c.m12677c("HWFitnessMgr", "saveFitnessDate.mHWWearCommonCallback=" + this.ab);
        if (this.ab != null) {
            C2538c.m12661a("05", 1, "HWFitnessMgr", "saveFitnessDate isExistHiHealthService = " + C0824b.m2914a(this.f1898n).m2910a());
        } else {
            C2538c.m12661a("05", 1, "HWFitnessMgr", "saveFitnessDate isExistHiHealthService = " + C0824b.m2914a(this.f1898n).m2910a());
        }
        if (C0824b.m2914a(this.f1898n).m2910a()) {
            m4020a(5, 120000);
            int i = m4141i();
            this.f1903u = true;
            m4132c();
            if (4 == i) {
                this.f1900q.b(this, this.f1896k);
                this.f1896k.clear();
                return;
            } else if (1 == i) {
                this.f1900q.a(this, this.f1895j);
                this.f1895j.clear();
                return;
            } else if (3 == i) {
                this.f1900q.a(this, this.f1891f, this.f1892g);
                this.f1891f.clear();
                this.f1892g.clear();
                return;
            } else {
                this.f1900q.b(this, this.f1896k);
                this.f1896k.clear();
                return;
            }
        }
        m4129b(300001);
    }

    public void m4128b() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "setDeviceFitnessGoal enter");
        com.huawei.t.a.a().b(new MotionGoal(), new aj(this));
    }

    public void m4118a(int i) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "doDetailSyncComplete errCode=" + i);
        m4129b(i);
    }

    public void m4129b(int i) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procDetailSyncComplete errCode=" + i);
        m4092j(5);
        this.f1902t = false;
        this.f1903u = false;
        this.f1886a.execute(new aw(this, i));
        if (this.ab == null) {
        }
    }

    public void m4133c(int i) {
        synchronized (f1860S) {
            m4019a(10009, i, null);
            m4065c("false");
            m4013I();
            m4110u();
            if (i == 0) {
                LocalBroadcastManager instance = LocalBroadcastManager.getInstance(this.f1898n);
                if (instance != null) {
                    C2538c.m12677c("HWFitnessMgr", "lbm.registerReceiver ");
                    instance.registerReceiver(this.f1878R, new IntentFilter("com.huawei.hihealth.action_sync"));
                }
            } else {
                f1862o.m4015K();
            }
            if (this.f1873K != null) {
                this.f1873K.b(this.f1898n);
            }
        }
    }

    private void m4076f(int i) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "notifyDetailSyncComplete errCode=" + i);
        m4092j(0);
        if (i == 0) {
            m4112w();
            return;
        }
        this.f1902t = false;
        m4065c("false");
        m4013I();
        m4019a(10009, i, null);
    }

    private void m4022a(int i, m mVar) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "commandId = " + mVar.a());
        switch (mVar.a()) {
            case 3:
                m4053b(i, mVar.b(), mVar.c());
                return;
            case 1000:
                m4081g(mVar.d());
                return;
            case 1001:
                m4023a(i, mVar.b(), mVar.c());
                return;
            default:
                return;
        }
    }

    private void m4081g(int i) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "AF500 sync code " + i);
    }

    private void m4023a(int i, String str, String str2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (str == null) {
            C2538c.m12680e("HWFitnessMgr", "sportData  = nul");
            arrayList = null;
        } else {
            C2538c.m12680e("HWFitnessMgr", "sportDataList " + ((ArrayList) new Gson().fromJson(str, new ao(this).getType())).toString());
            arrayList = arrayList2;
        }
        if (str2 == null) {
            C2538c.m12680e("HWFitnessMgr", "sleepData  = nul");
            arrayList2 = null;
        } else {
            arrayList2 = (ArrayList) new Gson().fromJson(str2, new s(this).getType());
            C2538c.m12680e("HWFitnessMgr", "sportDataList " + arrayList2.toString());
        }
        m4024a(i, arrayList, arrayList2);
    }

    private void m4053b(int i, String str, String str2) {
        int[] iArr;
        int[] iArr2;
        m4092j(4);
        if (str == null) {
            C2538c.m12680e("HWFitnessMgr", " procaf500GetTodayFitnessData sportData  = nul");
            iArr = null;
        } else {
            iArr = (int[]) new Gson().fromJson(str, new t(this).getType());
        }
        if (str2 == null) {
            C2538c.m12680e("HWFitnessMgr", " procaf500GetTodayFitnessData sleepData  = nul");
            iArr2 = null;
        } else {
            iArr2 = (int[]) new Gson().fromJson(str2, new u(this).getType());
        }
        m4027a(i, iArr, iArr2);
    }

    private void m4027a(int i, int[] iArr, int[] iArr2) {
        try {
            f fVar = new f();
            DataTotalMotion dataTotalMotion = new DataTotalMotion();
            List arrayList = new ArrayList();
            if (iArr == null || 3 != iArr.length) {
                C2538c.m12680e("HWFitnessMgr", "totalSportData = null ");
            } else {
                dataTotalMotion.setMotion_type(1);
                dataTotalMotion.setStep(iArr[0]);
                C2538c.m12661a("05", 1, "HWFitnessMgr", "af500ProcSyncTotalFitnessData setStep = " + iArr[0]);
                dataTotalMotion.setCalorie(iArr[1]);
                C2538c.m12661a("05", 1, "HWFitnessMgr", "af500ProcSyncTotalFitnessData setCalorie = " + iArr[1]);
                fVar.a(iArr[1]);
                C2538c.m12661a("05", 1, "HWFitnessMgr", "af500ProcSyncTotalFitnessData Distance = " + iArr[2]);
                dataTotalMotion.setDistance(iArr[2]);
                arrayList.add(dataTotalMotion);
            }
            if (iArr2 == null || 3 != iArr2.length) {
                C2538c.m12680e("HWFitnessMgr", "totalSleepData = null ");
                if (this.f1900q.a(e.a(this), System.currentTimeMillis() / 1000)) {
                    SleepTotalData c = this.f1900q.c(this);
                    DataTotalMotion dataTotalMotion2 = new DataTotalMotion();
                    dataTotalMotion2.setMotion_type(6);
                    C2538c.m12680e("HWFitnessMgr", "setSleep_time = " + c.getShallowSleepTime());
                    dataTotalMotion2.setSleep_time(c.getShallowSleepTime());
                    arrayList.add(dataTotalMotion2);
                    dataTotalMotion2 = new DataTotalMotion();
                    dataTotalMotion2.setMotion_type(7);
                    C2538c.m12680e("HWFitnessMgr", "setSleep_time = " + c.getDeepSleepTime());
                    dataTotalMotion2.setSleep_time(c.getDeepSleepTime());
                    arrayList.add(dataTotalMotion2);
                }
            } else {
                dataTotalMotion = new DataTotalMotion();
                dataTotalMotion.setMotion_type(6);
                dataTotalMotion.setSleep_time(iArr2[1]);
                C2538c.m12680e("HWFitnessMgr", "setSleep_time = " + iArr2[1]);
                arrayList.add(dataTotalMotion);
                dataTotalMotion = new DataTotalMotion();
                dataTotalMotion.setMotion_type(7);
                dataTotalMotion.setSleep_time(iArr2[0]);
                C2538c.m12680e("HWFitnessMgr", "setSleep_time = " + iArr2[0]);
                arrayList.add(dataTotalMotion);
            }
            fVar.a(arrayList);
            this.f1900q.a(this, fVar);
            m4084h(0);
            C2538c.m12677c("HWFitnessMgr", "procGetTodayFitnessData Complete");
        } catch (Exception e) {
            C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
            m4084h(201000);
        }
    }

    private void m4024a(int i, ArrayList<com.huawei.e.a.a.a.b> arrayList, ArrayList<com.huawei.e.a.a.a.a> arrayList2) {
        a aVar = new a();
        ArrayList arrayList3 = new ArrayList();
        C2538c.m12661a("05", 1, "HWFitnessMgr", "af500ProcSyncDetailFitnessData");
        if (arrayList2 != null) {
            m4046a(arrayList3, (ArrayList) arrayList2);
            C2538c.m12680e("HWFitnessMgr", "sleep data " + arrayList3.toString());
            aVar.a(arrayList3);
        } else {
            C2538c.m12680e("HWFitnessMgr", "sleep data is null ");
        }
        List arrayList4 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.huawei.e.a.a.a.b bVar = (com.huawei.e.a.a.a.b) it.next();
                d dVar = new d();
                dVar.a(bVar.a() / 1000);
                dVar.a(1);
                dVar.b(bVar.b());
                dVar.c((int) (bVar.d() * 1000.0f));
                dVar.d(bVar.c());
                arrayList4.add(dVar);
            }
            aVar.b(arrayList4);
        }
        this.f1896k.add(aVar);
        m4076f(i);
    }

    private void m4046a(ArrayList<c> arrayList, ArrayList<com.huawei.e.a.a.a.a> arrayList2) {
        if (arrayList != null && arrayList2 != null && arrayList2.size() != 0) {
            C2538c.m12661a("05", 1, "HWFitnessMgr", "sleep total data " + this.f1900q.f(this).toString());
            com.huawei.e.a.a.a.a aVar = null;
            for (int i = 0; i < arrayList2.size(); i++) {
                aVar = (com.huawei.e.a.a.a.a) arrayList2.get(i);
                if (aVar.a() <= r5.a()) {
                    C2538c.m12680e("HWFitnessMgr", "duplicate entry");
                } else {
                    C2538c.m12680e("HWFitnessMgr", "sleep  data starttime " + m4116a(new Date(aVar.a())) + " sleeptime" + (aVar.a() / 1000));
                    int i2;
                    if ((((aVar.a() / 1000) / 60) - (m4116a(new Date(aVar.a())) / 60)) % 10 < 6) {
                        for (i2 = 0; i2 < 3; i2++) {
                            m4045a((ArrayList) arrayList, aVar, i2);
                        }
                    } else {
                        for (i2 = 0; i2 < 4; i2++) {
                            m4045a((ArrayList) arrayList, aVar, i2);
                        }
                    }
                }
            }
            if (aVar != null) {
                this.f1900q.a(this, aVar);
                return;
            }
            C2538c.m12680e("HWFitnessMgr", "data is null.");
        }
    }

    private void m4045a(ArrayList<c> arrayList, com.huawei.e.a.a.a.a aVar, int i) {
        if (arrayList == null || aVar == null) {
            C2538c.m12680e("HWFitnessMgr", "setSleepData input params is null");
            return;
        }
        c cVar = new c();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        C2538c.m12661a("05", 1, "HWFitnessMgr", "curr " + currentTimeMillis + "datatiem " + (aVar.a() / 1000));
        int k = m4096k(aVar.b());
        if (6 == k) {
            currentTimeMillis = (((aVar.a() / 1000) / 60) + ((long) i)) * 60;
            cVar.b(k);
            cVar.a(currentTimeMillis);
            C2538c.m12680e("HWFitnessMgr", "sleepType " + k);
            arrayList.add(cVar);
        } else if (7 == k) {
            cVar.a((((aVar.a() / 1000) / 60) + ((long) i)) * 60);
            cVar.b(k);
            C2538c.m12680e("HWFitnessMgr", "sleepType " + k);
            arrayList.add(cVar);
        }
        C2538c.m12680e("HWFitnessMgr", "setSleepData " + cVar.toString());
    }

    private void m4049a(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = 201000;
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procSetCmdResult Complete cmd=" + i);
        try {
            if (m4139f() == 0) {
                if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                    C2538c.m12680e("HWFitnessMgr", "Set V0 Userinfo command timeout.");
                    i2 = com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr);
                }
                m4019a(i, i2, null);
            }
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                i3 = com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr);
                C2538c.m12680e("HWFitnessMgr", "procSetCmdResult return err:" + i3);
            }
            i2 = i3;
            m4019a(i, i2, null);
        } catch (Exception e) {
            C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
        }
    }

    private void m4048a(byte[] bArr) {
        int j;
        C2538c.m12677c("HWFitnessMgr", "procDeviceDataReport");
        try {
            j = com.huawei.hwfitnessmgr.deviceadapter.e.j(bArr);
        } catch (Exception e) {
            C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
            j = 0;
        }
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procDeviceDataReport action =", Integer.valueOf(j));
        if (j == 1) {
            m4121a(new v(this));
        } else if (j == 2) {
            m4130b(new w(this));
        } else if (j == 3) {
            m4121a(new x(this));
        } else if (j == 4) {
            C2538c.m12677c("HWFitnessMgr", "action == DeviceReportThroshold.ACTION_SYNC_CORE_SLEEP_MASK");
            DeviceInfo c = this.f1899p.m5447c();
            if (c != null && c.getDeviceConnectState() == 2) {
                C2538c.m12677c("HWFitnessMgr", "enter reverse core sleep data");
                C1111d.m4931a(this.f1898n).m4967a(new z(this));
            }
        } else if (j == 8) {
            C2538c.m12677c("HWFitnessMgr", "action == DeviceReportThroshold.ACTION_SYNC_WORKOUT_MASK");
            if (this.f1899p.m5447c() != null) {
                C2538c.m12677c("HWFitnessMgr", "5.7.15 notify to sync workout data.");
                m4015K();
            }
        }
    }

    private void m4113x() {
        this.f1886a.execute(new as(this));
    }

    private void m4061b(byte[] bArr) {
        this.f1879T = 0;
        this.f1880U = 0;
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procGetSamplePointFrameCount");
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                int a = com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr);
                C2538c.m12680e("HWFitnessMgr", "procGetSamplePointFrameCount return err:" + a);
                m4129b(300007);
                return;
            }
            this.f1879T = com.huawei.hwfitnessmgr.deviceadapter.e.f(bArr);
            C2538c.m12677c("HWFitnessMgr", "procGetSamplePointFrameCount get sample frame count :" + this.f1879T);
            if (this.f1879T > 0) {
                C2538c.m12661a("05", 1, "HWFitnessMgr", "procGetSamplePointFrameCount get sample frame index :" + this.f1880U);
                com.huawei.hwfitnessmgr.deviceadapter.d.c(this.f1880U);
                this.f1880U++;
                return;
            }
            m4114y();
        } catch (Exception e) {
            C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
        }
    }

    private void m4066c(byte[] bArr) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procGetSamplePointFrame");
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                int a = com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr);
                C2538c.m12680e("HWFitnessMgr", "procGetSamplePointFrame return err:" + a);
                m4129b(300007);
                return;
            }
            this.f1891f.add(com.huawei.hwfitnessmgr.deviceadapter.e.g(bArr));
            if (this.f1880U < this.f1879T) {
                com.huawei.hwfitnessmgr.deviceadapter.d.c(this.f1880U);
                this.f1880U++;
                return;
            }
            m4114y();
        } catch (Exception e) {
            C2538c.m12677c("HWFitnessMgr", "procGetSamplePointFrame Exception :" + e.getMessage());
        }
    }

    private void m4114y() {
        long b = e.b(this);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        C2538c.m12661a("05", 1, "syncStatusPoint", new Object[0]);
        if (b - currentTimeMillis > 604800 || b == 0) {
            b = m4051b(currentTimeMillis - 604800);
            e.a(this, b);
        } else if (b >= currentTimeMillis && b - currentTimeMillis <= 300) {
            C2538c.m12680e("HWFitnessMgr", "syncStatusPoint lastStatusTime is not correct. ");
            b = currentTimeMillis - 61;
        } else if (b - currentTimeMillis > 300) {
            C2538c.m12680e("HWFitnessMgr", "syncStatusPoint lastStatusTime is not correct and need writeback. ");
            b = currentTimeMillis - 61;
            e.a(this, b);
        }
        com.huawei.hwfitnessmgr.deviceadapter.d.c(b, currentTimeMillis);
    }

    private void m4070d(byte[] bArr) {
        this.f1881V = 0;
        this.f1882W = 0;
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procGetStatusFrameCount Complete");
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                int a = com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr);
                C2538c.m12680e("HWFitnessMgr", "procGetStatusFrameCount return err:" + a);
                m4129b(300007);
                return;
            }
            this.f1881V = com.huawei.hwfitnessmgr.deviceadapter.e.h(bArr);
            if (this.f1881V > 0) {
                com.huawei.hwfitnessmgr.deviceadapter.d.d(this.f1882W);
                this.f1882W++;
                return;
            }
            m4076f(0);
        } catch (Exception e) {
            C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
        }
    }

    private void m4074e(byte[] bArr) {
        int i = 0;
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procGetStatusFrame Complete");
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                int a = com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr);
                C2538c.m12680e("HWFitnessMgr", "procGetStatusFrame return err:" + a);
                m4129b(300007);
                return;
            }
            this.f1892g.add(com.huawei.hwfitnessmgr.deviceadapter.e.i(bArr));
            if (this.f1882W < this.f1881V) {
                com.huawei.hwfitnessmgr.deviceadapter.d.d(this.f1882W);
                this.f1882W++;
                return;
            }
            m4076f(i);
        } catch (Exception e) {
            C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
            i = 201000;
        }
    }

    private void m4084h(int i) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "doSyncTodayComplete errCode", Integer.valueOf(i));
        this.f1902t = false;
        m4019a((int) MessageObserver.RET_CHECK_PARAM_ERROR, i, null);
        m4111v();
    }

    private void m4078f(byte[] bArr) {
        int a;
        Exception e;
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procGetTodayFitnessData Complete");
        m4092j(4);
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                a = com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr);
                try {
                    C2538c.m12672b("05", 1, "HWFitnessMgr", "procGetTodayFitnessData return err:" + a);
                } catch (Exception e2) {
                    e = e2;
                    C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
                    m4084h(a);
                }
            }
            this.f1900q.a(this, com.huawei.hwfitnessmgr.deviceadapter.e.b(bArr));
            a = 0;
        } catch (Exception e3) {
            Exception exception = e3;
            a = 201000;
            e = exception;
            C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
            m4084h(a);
        }
        m4084h(a);
    }

    private void m4083g(byte[] bArr) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", " procGetRealTimeCompressedData");
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                int a = com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr);
                C2538c.m12680e("HWFitnessMgr", "procGetTodayFitnessData return err:" + a);
                m4129b(300007);
            } else {
                m4030a(com.huawei.hwfitnessmgr.deviceadapter.e.d(bArr));
            }
        } catch (Exception e) {
            C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
        }
        this.f1884Y++;
        if (this.f1884Y < this.f1883X) {
            com.huawei.hwfitnessmgr.deviceadapter.d.a(((Integer) this.f1893h.get(this.f1884Y)).intValue());
        } else {
            m4076f(0);
        }
    }

    private void m4088i(int i) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "getHealthDataByFrame ", Integer.valueOf(i));
        if (m4141i() == 0) {
            com.huawei.hwfitnessmgr.deviceadapter.d.a(i);
        } else if (1 == m4141i()) {
            com.huawei.hwfitnessmgr.deviceadapter.d.b(i);
        }
    }

    private void m4020a(int i, long j) {
        if (this.f1901s != null) {
            this.f1901s.sendEmptyMessageDelayed(i, j);
            return;
        }
        C2538c.m12672b("05", 1, "HWFitnessMgr", "fitnessMgrSendMSGDelay mHWFitnessMgrHandler is null");
    }

    private void m4092j(int i) {
        if (this.f1901s == null) {
            C2538c.m12672b("05", 1, "HWFitnessMgr", "fitnessMgrRemoveMSG mHWFitnessMgrHandler is null");
        } else if (this.f1901s.hasMessages(i)) {
            this.f1901s.removeMessages(i);
        }
    }

    private void m4031a(e eVar) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "getRealtimeDataByFrame Enter");
        this.f1893h = eVar.b();
        this.f1883X = eVar.a();
        this.f1884Y = 0;
        if (this.f1884Y < this.f1883X) {
            C2538c.m12664a("HWFitnessMgr", "getRealtimeDataByFrame get frame idx = " + this.f1893h.get(this.f1884Y));
            m4088i(((Integer) this.f1893h.get(this.f1884Y)).intValue());
            return;
        }
        m4076f(0);
    }

    private void m4087h(byte[] bArr) {
        Exception exception;
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procGetRealTimeFrameCount ");
        int i = 201000;
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                try {
                    C2538c.m12680e("HWFitnessMgr", "procGetRealTimeFrameCount return err:" + com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr));
                    m4129b(300007);
                } catch (Exception e) {
                    Exception exception2 = e;
                    i = r1;
                    exception = exception2;
                }
            } else {
                this.f1894i = com.huawei.hwfitnessmgr.deviceadapter.e.c(bArr);
                if (this.f1894i == null) {
                    C2538c.m12677c("HWFitnessMgr", "procGetRealTimeFrameCount realtimeFramePageList is not null");
                    m4031a(this.f1894i);
                }
                m4076f(i);
            }
        } catch (Exception e2) {
            exception = e2;
            C2538c.m12677c("HWFitnessMgr", " Exception :" + exception.getMessage());
            if (this.f1894i == null) {
                m4076f(i);
            }
            C2538c.m12677c("HWFitnessMgr", "procGetRealTimeFrameCount realtimeFramePageList is not null");
            m4031a(this.f1894i);
        }
    }

    private void m4091i(byte[] bArr) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procGetActivityReminder do not porcess");
    }

    private void m4094j(byte[] bArr) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procGetRealTimeData enter index=" + this.f1884Y);
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                int a = com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr);
                C2538c.m12680e("HWFitnessMgr", "procGetRealTimeFrameCount return err:" + a);
                m4129b(300007);
                return;
            }
            m4047a(com.huawei.hwfitnessmgr.deviceadapter.e.e(bArr));
            this.f1884Y++;
            if (this.f1884Y < this.f1883X) {
                com.huawei.hwfitnessmgr.deviceadapter.d.b(((Integer) this.f1893h.get(this.f1884Y)).intValue());
            } else {
                m4076f(0);
            }
        } catch (Exception e) {
            C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4068d(com.huawei.hwbasemgr.IBaseResponseCallback r10) {
        /*
        r9 = this;
        r8 = 4;
        r7 = 1;
        r1 = f1863r;
        monitor-enter(r1);
        r0 = "05";
        r2 = 1;
        r3 = "HWFitnessMgr";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0057 }
        r5 = 0;
        r6 = "syncFitnessTodayDatarun enter";
        r4[r5] = r6;	 Catch:{ all -> 0x0057 }
        com.huawei.p190v.C2538c.m12661a(r0, r2, r3, r4);	 Catch:{ all -> 0x0057 }
        r0 = r9.f1899p;	 Catch:{ all -> 0x0057 }
        r0 = r0.m5447c();	 Catch:{ all -> 0x0057 }
        if (r0 == 0) goto L_0x0024;
    L_0x001d:
        r0 = r0.getDeviceConnectState();	 Catch:{ all -> 0x0057 }
        r2 = 2;
        if (r0 == r2) goto L_0x003a;
    L_0x0024:
        r0 = "HWFitnessMgr";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0057 }
        r3 = 0;
        r4 = "syncFitnessTodayDatarun get device info error";
        r2[r3] = r4;	 Catch:{ all -> 0x0057 }
        com.huawei.p190v.C2538c.m12680e(r0, r2);	 Catch:{ all -> 0x0057 }
        r0 = 300004; // 0x493e4 float:4.20395E-40 double:1.482217E-318;
        r2 = 0;
        r10.onResponse(r0, r2);	 Catch:{ all -> 0x0057 }
        monitor-exit(r1);	 Catch:{ all -> 0x0057 }
    L_0x0039:
        return;
    L_0x003a:
        r0 = r9.f1902t;	 Catch:{ all -> 0x0057 }
        if (r7 != r0) goto L_0x005a;
    L_0x003e:
        r0 = "05";
        r2 = 1;
        r3 = "HWFitnessMgr";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0057 }
        r5 = 0;
        r6 = "syncFitnessTodayData data syncing";
        r4[r5] = r6;	 Catch:{ all -> 0x0057 }
        com.huawei.p190v.C2538c.m12661a(r0, r2, r3, r4);	 Catch:{ all -> 0x0057 }
        r0 = 300002; // 0x493e2 float:4.20392E-40 double:1.482207E-318;
        r2 = 0;
        r10.onResponse(r0, r2);	 Catch:{ all -> 0x0057 }
        monitor-exit(r1);	 Catch:{ all -> 0x0057 }
        goto L_0x0039;
    L_0x0057:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0057 }
        throw r0;
    L_0x005a:
        r0 = r9.m4141i();	 Catch:{ all -> 0x0057 }
        if (r8 != r0) goto L_0x0074;
    L_0x0060:
        r0 = "HWFitnessMgr";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0057 }
        r3 = 0;
        r4 = " af500 need to get total with detail";
        r2[r3] = r4;	 Catch:{ all -> 0x0057 }
        com.huawei.p190v.C2538c.m12677c(r0, r2);	 Catch:{ all -> 0x0057 }
        r0 = 0;
        r2 = 0;
        r10.onResponse(r0, r2);	 Catch:{ all -> 0x0057 }
        monitor-exit(r1);	 Catch:{ all -> 0x0057 }
        goto L_0x0039;
    L_0x0074:
        r0 = 1;
        r9.f1902t = r0;	 Catch:{ all -> 0x0057 }
        r0 = 4;
        r2 = 40000; // 0x9c40 float:5.6052E-41 double:1.97626E-319;
        r9.m4020a(r0, r2);	 Catch:{ all -> 0x0057 }
        r0 = 10008; // 0x2718 float:1.4024E-41 double:4.9446E-320;
        r9.m4021a(r0, r10);	 Catch:{ all -> 0x0057 }
        r0 = "05";
        r2 = 1;
        r3 = "HWFitnessMgr";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0057 }
        r5 = 0;
        r6 = "syncFitnessTodayData enter thread";
        r4[r5] = r6;	 Catch:{ all -> 0x0057 }
        com.huawei.p190v.C2538c.m12661a(r0, r2, r3, r4);	 Catch:{ all -> 0x0057 }
        r0 = r9.m4139f();	 Catch:{ all -> 0x0057 }
        if (r0 != 0) goto L_0x009f;
    L_0x0099:
        r0 = 3;
        com.huawei.hwfitnessmgr.deviceadapter.d.h(r0);	 Catch:{ all -> 0x0057 }
    L_0x009d:
        monitor-exit(r1);	 Catch:{ all -> 0x0057 }
        goto L_0x0039;
    L_0x009f:
        com.huawei.hwfitnessmgr.deviceadapter.d.a();	 Catch:{ all -> 0x0057 }
        goto L_0x009d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwfitnessmgr.q.d(com.huawei.hwbasemgr.IBaseResponseCallback):void");
    }

    public void m4121a(IBaseResponseCallback iBaseResponseCallback) {
        this.f1886a.execute(new az(this, iBaseResponseCallback));
    }

    private void m4115z() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "handleUserLogin enter");
        this.f1900q.b(this);
        HiAccountInfo hiAccountInfo = new HiAccountInfo();
        String c = C1093a.m4739a(this.f1898n).m4750c();
        String g = C1093a.m4739a(this.f1898n).m4754g();
        if (c != null && c.equals("0")) {
            c = null;
        }
        hiAccountInfo.setHuid(c);
        hiAccountInfo.setServiceToken(g);
        hiAccountInfo.setAccessToken("");
        C0824b.m2914a(this.f1898n).m2901a(hiAccountInfo, null);
    }

    private void m4005A() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "handleUserInfoChange enter");
        m4044a(m4140h());
    }

    public void m4132c() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "hwfitnessmgr registerDeviceToHiHealth");
        if (this.f1899p != null) {
            DeviceInfo c = this.f1899p.m5447c();
            if (c != null) {
                com.huawei.al.a.a(c);
                return;
            }
            C2538c.m12680e("HWFitnessMgr", "hwfitnessmgr registerDeviceToHiHealth deviceInfo is null");
            return;
        }
        C2538c.m12680e("HWFitnessMgr", "hwfitnessmgr registerDeviceToHiHealth enter mHWDeviceConfigManager is null");
    }

    private void m4029a(DeviceInfo deviceInfo) {
        int deviceConnectState = deviceInfo.getDeviceConnectState();
        C2538c.m12661a("05", 1, "HWFitnessMgr", "handleDeviceConnection device Connect state = " + deviceConnectState);
        if (deviceConnectState == 2) {
            C2538c.m12677c("HWFitnessMgr", "handleDeviceConnection");
            com.huawei.al.a.a(deviceInfo);
            UserInfomation h = m4140h();
            ActivityReminder b = new a().b(this);
            if (deviceInfo.getDeviceProtocol() == 0) {
                com.huawei.i.a a = com.huawei.i.a.a(this.f1898n);
                if (a != null) {
                    a.b(new aa(this, b));
                } else {
                    C2538c.m12680e("HWFitnessMgr", "Set UserInfo2 fail for alarmManager is incorrect.");
                }
            } else {
                C2538c.m12677c("HWFitnessMgr", "send other device configuration.");
                com.huawei.hwfitnessmgr.deviceadapter.d.a(b);
                this.f1886a.execute(new au(this, null));
                m4008D();
                m4009E();
                m4011G();
                m4145m();
            }
            m4125a(h, new ab(this));
            m4128b();
            m4011G();
            m4145m();
            m4012H();
        } else if (deviceConnectState == 3) {
            synchronized (C1026q.m4107r()) {
                f1857G.clear();
            }
            if (!this.f1903u) {
                C2538c.m12661a("05", 1, "HWFitnessMgr", "Data sync bt bt disconnect.");
                this.f1902t = false;
                m4065c("false");
                m4013I();
                m4129b(300004);
                this.f1898n.sendBroadcast(new Intent("com.huawei.health.fitness_detail_sync_fail"), C0976c.f1642a);
            }
        }
    }

    private void m4030a(a aVar) {
        C2538c.m12677c("HWFitnessMgr", "saveRealtimeDataFrame enter");
        this.f1896k.add(aVar);
    }

    private void m4047a(List<b> list) {
        C2538c.m12677c("HWFitnessMgr", "saveRealtimeDataCommonFrame enter count=" + list.size());
        this.f1895j.addAll(list);
    }

    private long m4051b(long j) {
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date(1000 * j));
        try {
            return new SimpleDateFormat("yyyyMMddhhmm").parse(format + "0000").getTime() / 1000;
        } catch (ParseException e) {
            C2538c.m12680e("HWFitnessMgr", "getBeginOfDate enter" + e);
            return j;
        }
    }

    private void m4006B() {
        this.f1896k.clear();
        this.f1891f.clear();
        this.f1892g.clear();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4072e(com.huawei.hwbasemgr.IBaseResponseCallback r13) {
        /*
        r12 = this;
        r10 = 61;
        r8 = 4;
        r7 = 1;
        r1 = f1863r;
        monitor-enter(r1);
        r0 = "05";
        r2 = 1;
        r3 = "HWFitnessMgr";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x005c }
        r5 = 0;
        r6 = "syncFitnessDetailDataRun enter thread";
        r4[r5] = r6;	 Catch:{ all -> 0x005c }
        com.huawei.p190v.C2538c.m12661a(r0, r2, r3, r4);	 Catch:{ all -> 0x005c }
        r0 = r12.f1899p;	 Catch:{ all -> 0x005c }
        r0 = r0.m5447c();	 Catch:{ all -> 0x005c }
        if (r0 == 0) goto L_0x0026;
    L_0x001f:
        r0 = r0.getDeviceConnectState();	 Catch:{ all -> 0x005c }
        r2 = 2;
        if (r0 == r2) goto L_0x003f;
    L_0x0026:
        r0 = "05";
        r2 = 1;
        r3 = "HWFitnessMgr";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x005c }
        r5 = 0;
        r6 = "syncFitnessDetailDataRun get device info error";
        r4[r5] = r6;	 Catch:{ all -> 0x005c }
        com.huawei.p190v.C2538c.m12672b(r0, r2, r3, r4);	 Catch:{ all -> 0x005c }
        r0 = 300004; // 0x493e4 float:4.20395E-40 double:1.482217E-318;
        r2 = 0;
        r13.onResponse(r0, r2);	 Catch:{ all -> 0x005c }
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
    L_0x003e:
        return;
    L_0x003f:
        r0 = r12.f1902t;	 Catch:{ all -> 0x005c }
        if (r7 != r0) goto L_0x005f;
    L_0x0043:
        r0 = "05";
        r2 = 1;
        r3 = "HWFitnessMgr";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x005c }
        r5 = 0;
        r6 = "syncFitnessDetailData data syncing";
        r4[r5] = r6;	 Catch:{ all -> 0x005c }
        com.huawei.p190v.C2538c.m12661a(r0, r2, r3, r4);	 Catch:{ all -> 0x005c }
        r0 = 300002; // 0x493e2 float:4.20392E-40 double:1.482207E-318;
        r2 = 0;
        r13.onResponse(r0, r2);	 Catch:{ all -> 0x005c }
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        goto L_0x003e;
    L_0x005c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        throw r0;
    L_0x005f:
        r0 = 1;
        r12.f1902t = r0;	 Catch:{ all -> 0x005c }
        r0 = "true";
        r12.m4065c(r0);	 Catch:{ all -> 0x005c }
        r0 = 0;
        r2 = 240000; // 0x3a980 float:3.36312E-40 double:1.18576E-318;
        r12.m4020a(r0, r2);	 Catch:{ all -> 0x005c }
        r0 = 10009; // 0x2719 float:1.4026E-41 double:4.945E-320;
        r12.m4021a(r0, r13);	 Catch:{ all -> 0x005c }
        r12.m4006B();	 Catch:{ all -> 0x005c }
        r0 = r12.m4141i();	 Catch:{ all -> 0x005c }
        if (r8 != r0) goto L_0x0081;
    L_0x007c:
        com.huawei.hwfitnessmgr.deviceadapter.d.e();	 Catch:{ all -> 0x005c }
    L_0x007f:
        monitor-exit(r1);	 Catch:{ all -> 0x005c }
        goto L_0x003e;
    L_0x0081:
        r0 = r12.m4139f();	 Catch:{ all -> 0x005c }
        if (r0 != 0) goto L_0x008c;
    L_0x0087:
        r0 = 4;
        com.huawei.hwfitnessmgr.deviceadapter.d.h(r0);	 Catch:{ all -> 0x005c }
        goto L_0x007f;
    L_0x008c:
        r2 = r12.m4007C();	 Catch:{ all -> 0x005c }
        r12.f1885Z = r2;	 Catch:{ all -> 0x005c }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x005c }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r4;
        r0 = (int) r2;	 Catch:{ all -> 0x005c }
        r2 = (long) r0;	 Catch:{ all -> 0x005c }
        r12.aa = r2;	 Catch:{ all -> 0x005c }
        r2 = r12.aa;	 Catch:{ all -> 0x005c }
        r4 = r12.f1885Z;	 Catch:{ all -> 0x005c }
        r2 = r2 - r4;
        r4 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 > 0) goto L_0x00b1;
    L_0x00a9:
        r2 = r12.f1885Z;	 Catch:{ all -> 0x005c }
        r4 = 0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 != 0) goto L_0x00d1;
    L_0x00b1:
        r2 = r12.aa;	 Catch:{ all -> 0x005c }
        r4 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r2 = r2 - r4;
        r2 = r12.m4051b(r2);	 Catch:{ all -> 0x005c }
        r12.f1885Z = r2;	 Catch:{ all -> 0x005c }
        r2 = r12.f1885Z;	 Catch:{ all -> 0x005c }
        r12.m4119a(r2);	 Catch:{ all -> 0x005c }
    L_0x00c2:
        r0 = r12.m4141i();	 Catch:{ all -> 0x005c }
        r2 = 3;
        if (r0 == r2) goto L_0x0120;
    L_0x00c9:
        r2 = r12.f1885Z;	 Catch:{ all -> 0x005c }
        r4 = r12.aa;	 Catch:{ all -> 0x005c }
        com.huawei.hwfitnessmgr.deviceadapter.d.a(r2, r4);	 Catch:{ all -> 0x005c }
        goto L_0x007f;
    L_0x00d1:
        r2 = r12.f1885Z;	 Catch:{ all -> 0x005c }
        r4 = r12.aa;	 Catch:{ all -> 0x005c }
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 < 0) goto L_0x00fa;
    L_0x00d9:
        r2 = r12.f1885Z;	 Catch:{ all -> 0x005c }
        r4 = r12.aa;	 Catch:{ all -> 0x005c }
        r2 = r2 - r4;
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 > 0) goto L_0x00fa;
    L_0x00e4:
        r0 = "05";
        r2 = 1;
        r3 = "HWFitnessMgr";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x005c }
        r5 = 0;
        r6 = "syncFitnessDetailData lastSync time is not correct. ";
        r4[r5] = r6;	 Catch:{ all -> 0x005c }
        com.huawei.p190v.C2538c.m12661a(r0, r2, r3, r4);	 Catch:{ all -> 0x005c }
        r2 = r12.aa;	 Catch:{ all -> 0x005c }
        r2 = r2 - r10;
        r12.f1885Z = r2;	 Catch:{ all -> 0x005c }
        goto L_0x00c2;
    L_0x00fa:
        r2 = r12.f1885Z;	 Catch:{ all -> 0x005c }
        r4 = r12.aa;	 Catch:{ all -> 0x005c }
        r2 = r2 - r4;
        r4 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 <= 0) goto L_0x00c2;
    L_0x0105:
        r0 = "05";
        r2 = 1;
        r3 = "HWFitnessMgr";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x005c }
        r5 = 0;
        r6 = "syncFitnessDetailData lastSync time is not correct and need writeback. ";
        r4[r5] = r6;	 Catch:{ all -> 0x005c }
        com.huawei.p190v.C2538c.m12661a(r0, r2, r3, r4);	 Catch:{ all -> 0x005c }
        r2 = r12.aa;	 Catch:{ all -> 0x005c }
        r2 = r2 - r10;
        r12.f1885Z = r2;	 Catch:{ all -> 0x005c }
        r2 = r12.f1885Z;	 Catch:{ all -> 0x005c }
        r12.m4119a(r2);	 Catch:{ all -> 0x005c }
        goto L_0x00c2;
    L_0x0120:
        r2 = r12.f1885Z;	 Catch:{ all -> 0x005c }
        r4 = r12.aa;	 Catch:{ all -> 0x005c }
        com.huawei.hwfitnessmgr.deviceadapter.d.b(r2, r4);	 Catch:{ all -> 0x005c }
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwfitnessmgr.q.e(com.huawei.hwbasemgr.IBaseResponseCallback):void");
    }

    private void m4054b(long j, long j2, C0990d c0990d) throws RemoteException {
        synchronized (f1863r) {
            C2538c.m12661a("05", 1, "HWFitnessMgr", "syncFitnessDetailDataRunThirdPart enter thread");
            DeviceInfo c = this.f1899p.m5447c();
            if (c == null || c.getDeviceConnectState() != 2) {
                C2538c.m12672b("05", 1, "HWFitnessMgr", "syncFitnessDetailDataRunThirdPart get device info error");
                c0990d.m3602a(30004, null);
            } else if (true == this.f1902t) {
                C2538c.m12661a("05", 1, "HWFitnessMgr", "syncFitnessDetailData data syncing");
                c0990d.m3602a(PayStatusCodes.PAY_STATE_TIME_OUT, null);
            } else {
                this.f1902t = true;
                m4065c("true");
                m4020a(0, 240000);
                m4021a(10009, null);
                m4006B();
                com.huawei.hwfitnessmgr.deviceadapter.d.b(j, j2);
            }
        }
    }

    public void m4130b(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "syncFitnessDetailData enter");
        m4121a(new ad(this, iBaseResponseCallback));
    }

    public void m4120a(long j, long j2, C0990d c0990d) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "syncFitnessDetailData enter");
        this.ab = c0990d;
        this.f1897l = new ay(j, j2, c0990d);
        this.f1886a.execute(this.f1897l);
    }

    private long m4007C() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "getLastSyncTime enter");
        return new ba().c(this);
    }

    public void m4119a(long j) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "setLastSyncTime time=" + j);
        ba baVar = new ba();
        com.huawei.hwfitnessmgr.a.a.a aVar = new com.huawei.hwfitnessmgr.a.a.a();
        aVar.a(j);
        baVar.a(this, aVar);
    }

    private void m4044a(UserInfomation userInfomation) {
        C2538c.m12661a("05", 1, "setDeviceUserInfo", new Object[0]);
        int height;
        if (4 == m4141i()) {
            height = userInfomation.getHeight();
            int weight = userInfomation.getWeight();
            C2538c.m12661a("05", 1, "HWFitnessMgr", "Start to set AF500 UserInfo.");
            com.huawei.hwfitnessmgr.deviceadapter.d.a(2, height, weight);
        } else if (m4139f() == 0) {
            height = m4016a(new p());
            C2538c.m12661a("05", 1, "HWFitnessMgr", "Start to set V0 UserInfo.");
            com.huawei.hwfitnessmgr.deviceadapter.d.a(2, userInfomation, height);
        } else {
            com.huawei.hwfitnessmgr.deviceadapter.d.a(userInfomation);
        }
    }

    private void m4008D() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "setDefaultDeviceReportThroshold.");
        DeviceCapability a = C0972a.m3499a();
        if (a == null) {
            C2538c.m12680e("HWFitnessMgr", "setDefaultDeviceReportThroshold deviceCapability is null");
        } else if (a.isSupportThreshold()) {
            com.huawei.hwfitnessmgr.deviceadapter.d.b(g.e());
        } else {
            C2538c.m12677c("HWFitnessMgr", "setDefaultDeviceReportThroshold is not support");
        }
    }

    public void m4125a(UserInfomation userInfomation, IBaseResponseCallback iBaseResponseCallback) {
        DeviceCapability a = C0972a.m3499a();
        if (a == null) {
            C2538c.m12672b("05", 1, "HWFitnessMgr", "getUserInfo deviceCapability is null");
        } else if (a.isSupportGetUserInfo()) {
            C2538c.m12672b("05", 1, "HWFitnessMgr", "getUserInfo support get user info");
            m4021a(21, iBaseResponseCallback);
            com.huawei.hwfitnessmgr.deviceadapter.d.c();
        } else {
            C2538c.m12672b("05", 1, "HWFitnessMgr", "getUserInfo not support get user info");
            m4044a(userInfomation);
        }
    }

    private void m4098k(byte[] bArr) {
        int a;
        t e;
        int i = 0;
        Object obj = null;
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procGetUserInfoData Complete cmd=21");
        try {
            if (m4139f() == 0) {
                if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                    C2538c.m12680e("HWFitnessMgr", "Get Userinfo command timeout.");
                    i = com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr);
                }
            } else if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                a = com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr);
                try {
                    C2538c.m12680e("HWFitnessMgr", "procSetCmdResult return err:" + a);
                    i = a;
                } catch (t e2) {
                    e = e2;
                    C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
                    i = a;
                    m4019a(21, i, obj);
                }
            } else {
                try {
                    obj = com.huawei.hwfitnessmgr.deviceadapter.e.k(bArr);
                } catch (t e3) {
                    e = e3;
                    a = 0;
                    C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
                    i = a;
                    m4019a(21, i, obj);
                }
            }
        } catch (t e32) {
            t tVar = e32;
            a = 201000;
            e = tVar;
            C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
            i = a;
            m4019a(21, i, obj);
        }
        m4019a(21, i, obj);
    }

    private void m4100l(byte[] bArr) {
        int i = 201000;
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procQueryCoreSleepSwitchData Complete cmd=27");
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                i = com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr);
                C2538c.m12674b("HWFitnessMgr", "procQueryCoreSleepSwitchData return err:" + i);
                if (i == 0) {
                    C2538c.m12674b("HWFitnessMgr", "procQueryCoreSleepSwitchData  sucess!");
                } else {
                    C2538c.m12674b("HWFitnessMgr", "procQueryCoreSleepSwitchData  fail!");
                }
            }
        } catch (t e) {
            C2538c.m12674b("HWFitnessMgr", "procQueryCoreSleepSwitchData Exception :" + e.getMessage());
        }
        m4019a(27, i, null);
    }

    public boolean m4136d() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "getReverseDataSyncEnable enter ");
        return e.c(this);
    }

    private void m4009E() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "setDeviceReversDataSync enter ");
        DeviceCapability a = C0972a.m3499a();
        if (a == null) {
            C2538c.m12680e("HWFitnessMgr", "setDeviceReversDataSync deviceCapability is null");
        } else if (a.isReserveSync()) {
            com.huawei.hwfitnessmgr.deviceadapter.d.a(e.c(this));
        } else {
            C2538c.m12677c("HWFitnessMgr", "setDeviceReversDataSync is not support");
        }
    }

    public void m4123a(ActivityReminder activityReminder, IBaseResponseCallback iBaseResponseCallback) {
        m4124a(activityReminder, iBaseResponseCallback, false);
        if (this.f1873K != null) {
            this.f1873K.a(activityReminder, false);
        }
    }

    public void m4124a(ActivityReminder activityReminder, IBaseResponseCallback iBaseResponseCallback, boolean z) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "setActivityReminder enter");
        C2538c.m12677c("HWFitnessMgr", "saveActivityReminder enable " + activityReminder);
        new a().a(this, 0, activityReminder);
        if (z) {
            m4021a(7, iBaseResponseCallback);
        } else {
            iBaseResponseCallback.onResponse(0, null);
        }
        if (m4139f() == 0) {
            com.huawei.i.a a = com.huawei.i.a.a(this.f1898n);
            if (a != null) {
                a.b(new af(this, activityReminder));
                return;
            }
            C2538c.m12680e("HWFitnessMgr", "Start to set smartAlarm fail for alarmManager is incorrect.");
            return;
        }
        com.huawei.hwfitnessmgr.deviceadapter.d.a(activityReminder);
    }

    public boolean m4138e() {
        C2538c.m12677c("HWFitnessMgr", "getActivityReminder enter");
        return new a().b(this).isEnabled();
    }

    private void m4026a(int i, byte[] bArr) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procV0GetFrameCount enter.");
        if (bArr == null) {
            C2538c.m12680e("HWFitnessMgr", "dataContent is null.");
        } else if (5 == bArr.length) {
            this.f1904v = Integer.parseInt(C0973a.m3509a(bArr).substring(6, 10), 16);
            if (this.f1904v % 2 == 0) {
                this.f1905w = this.f1904v;
            } else {
                this.f1905w = this.f1904v - 1;
            }
            if (3 == i) {
                this.f1906x = 0;
                com.huawei.hwfitnessmgr.deviceadapter.d.i(this.f1906x);
            } else if (4 == i) {
                this.f1867D = 0;
                com.huawei.hwfitnessmgr.deviceadapter.d.i(this.f1867D);
            }
        }
    }

    private void m4102m(byte[] bArr) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procV0TodayFitnessData Enter");
        String substring = C0973a.m3509a(bArr).substring(0, 7);
        if (this.f1906x <= 8) {
            switch (this.f1906x) {
                case 2:
                    if (!substring.equals("0705FBFB") && !substring.equals("0705FCFC") && !substring.equals("0705FDFD") && !substring.equals("0705FEFE")) {
                        this.f1907y = (((((bArr[4] < (byte) 0 ? bArr[4] + 256 : bArr[4]) * 256) + (bArr[5] < (byte) 0 ? bArr[5] + 256 : bArr[5])) * 256) + ((bArr[6] < (byte) 0 ? bArr[6] + 256 : bArr[6]) * 256)) + (bArr[7] < (byte) 0 ? bArr[7] + 256 : bArr[7]);
                        this.f1908z = (((((bArr[10] < (byte) 0 ? bArr[10] + 256 : bArr[10]) * 256) + (bArr[11] < (byte) 0 ? bArr[11] + 256 : bArr[11])) * 256) + ((bArr[12] < (byte) 0 ? bArr[12] + 256 : bArr[12]) * 256)) + (bArr[13] < (byte) 0 ? bArr[13] + 256 : bArr[13]);
                        break;
                    }
                    C2538c.m12677c("HWFitnessMgr", "procV0TodayFitnessData  invalid data");
                    this.f1907y = 0;
                    this.f1908z = 0;
                    break;
                    break;
                case 4:
                    if (!substring.equals("0705FBFB") && !substring.equals("0705FCFC") && !substring.equals("0705FDFD") && !substring.equals("0705FEFE")) {
                        this.f1864A = (((((bArr[4] < (byte) 0 ? bArr[4] + 256 : bArr[4]) * 256) + (bArr[5] < (byte) 0 ? bArr[5] + 256 : bArr[5])) * 256) + ((bArr[6] < (byte) 0 ? bArr[6] + 256 : bArr[6]) * 256)) + (bArr[7] < (byte) 0 ? bArr[7] + 256 : bArr[7]);
                        break;
                    }
                    C2538c.m12661a("05", 1, "HWFitnessMgr", "procV0TodayFitnessData  invalid data");
                    this.f1864A = 0;
                    break;
                case 8:
                    this.f1865B = ((((bArr[2] < (byte) 0 ? bArr[2] + 256 : bArr[2]) * 16) + (bArr[3] < (byte) 0 ? bArr[3] + 256 : bArr[3])) * 200) / 60;
                    this.f1866C = ((((bArr[4] < (byte) 0 ? bArr[4] + 256 : bArr[4]) * 16) + (bArr[5] < (byte) 0 ? bArr[5] + 256 : bArr[5])) * 200) / 60;
                    break;
            }
            if (this.f1906x == 8) {
                C2538c.m12661a("05", 1, "HWFitnessMgr", "procV0TodayFitnessData Complete");
                m4092j(4);
                try {
                    this.f1900q.a(this, com.huawei.hwfitnessmgr.deviceadapter.e.a(this.f1907y, this.f1908z, this.f1864A, this.f1865B, this.f1866C));
                    this.f1906x = -1;
                    m4084h(0);
                    return;
                } catch (Exception e) {
                    C2538c.m12677c("HWFitnessMgr", " Exception :" + e.getMessage());
                    this.f1906x = -1;
                    return;
                }
            }
            this.f1906x += 2;
            com.huawei.hwfitnessmgr.deviceadapter.d.i(this.f1906x);
        }
    }

    private int m4017a(String str) {
        if (str.toUpperCase(Locale.US).contains("FEFEFEFEFEFE")) {
            return 1;
        }
        if (str.toUpperCase(Locale.US).contains("FDFDFDFDFDFD")) {
            return 2;
        }
        return 0;
    }

    private long m4052b(String str) {
        int parseInt = Integer.parseInt(str.substring(0, 4));
        int parseInt2 = Integer.parseInt(str.substring(4, 6));
        int parseInt3 = Integer.parseInt(str.substring(6, 8));
        int parseInt4 = Integer.parseInt(str.substring(8, 10));
        int parseInt5 = Integer.parseInt(str.substring(10, 12));
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(TimeZone.getDefault());
        instance.set(parseInt, parseInt2 - 1, parseInt3, parseInt4, parseInt5, 0);
        return instance.getTimeInMillis() / 1000;
    }

    private int m4050b(int i, long j) {
        List c;
        int i2;
        if (1 == i) {
            c = this.f1869F.c();
            for (i2 = 0; i2 < c.size(); i2++) {
                if (((d) c.get(i2)).a() == j) {
                    return i2;
                }
            }
        } else if (2 == i) {
            c = this.f1869F.b();
            for (i2 = 0; i2 < c.size(); i2++) {
                if (((c) c.get(i2)).a() == j) {
                    return i2;
                }
            }
        } else {
            C2538c.m12680e("HWFitnessMgr", "checkSameTimeData with error type.");
        }
        return -1;
    }

    private void m4028a(long j, String str, int i) {
        int parseInt = ((Integer.parseInt(str.substring(0, 2), 16) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + Integer.parseInt(str.substring(2, 4), 16);
        if (parseInt == 0) {
            C2538c.m12680e("HWFitnessMgr", "V0 Detail step = 0, so return.");
            return;
        }
        int parseInt2 = ((Integer.parseInt(str.substring(4, 6), 16) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + Integer.parseInt(str.substring(6, 8), 16);
        int parseInt3 = ((Integer.parseInt(str.substring(8, 10), 16) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + Integer.parseInt(str.substring(10, 12), 16);
        C2538c.m12680e("HWFitnessMgr", "V0 Detail step = " + parseInt + ", calorie = " + parseInt2 + ", distance = " + parseInt3);
        if (parseInt > 6000 || parseInt2 > 3000 || parseInt3 > 8000) {
            C2538c.m12680e("HWFitnessMgr", "V0 Sport data is incorrect with startTime = " + j + "index =" + i);
            return;
        }
        int i2 = parseInt / 10;
        int i3 = parseInt % 10;
        int i4 = (parseInt2 * 1000) / 10;
        parseInt2 = (parseInt2 * 1000) % 10;
        int i5 = parseInt3 / 10;
        parseInt3 %= 10;
        for (parseInt = 0; parseInt < 10; parseInt++) {
            d dVar = new d();
            dVar.a(1);
            long j2 = (((long) ((i * 10) + parseInt)) * 60) + j;
            dVar.a(j2);
            C2538c.m12677c("HWFitnessMgr", "Set last start time = " + j2);
            if (9 != parseInt) {
                dVar.b(i2);
                dVar.c(i4);
                dVar.d(i5);
            } else {
                dVar.b(i2 + i3);
                dVar.c(i4 + parseInt2);
                dVar.d(i5 + parseInt3);
            }
            int b = m4050b(1, j2);
            if (-1 != b) {
                C2538c.m12680e("HWFitnessMgr", "Has same time so cover old data.");
                this.f1869F.c().set(b, dVar);
            } else {
                this.f1869F.c().add(dVar);
            }
        }
    }

    private int m4096k(int i) {
        if (i >= 1 && i < 10) {
            return 7;
        }
        if (i < 10 || i >= 50) {
            return 255;
        }
        return 6;
    }

    private void m4055b(long j, String str, int i) {
        int k = m4096k(((Integer.parseInt(str.substring(0, 2), 16) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + Integer.parseInt(str.substring(2, 4), 16));
        int k2 = m4096k(((Integer.parseInt(str.substring(4, 6), 16) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + Integer.parseInt(str.substring(6, 8), 16));
        int k3 = m4096k(((Integer.parseInt(str.substring(8, 10), 16) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) + Integer.parseInt(str.substring(10, 12), 16));
        int i2 = 0;
        while (i2 < 10) {
            int i3;
            if (i2 >= 0 && i2 < 3) {
                i3 = k;
            } else if (i2 < 3 || i2 >= 6) {
                i3 = k3;
            } else {
                i3 = k2;
            }
            if (i3 != 255) {
                c cVar = new c();
                long j2 = (((long) ((i * 10) + i2)) * 60) + j;
                cVar.a(j2);
                cVar.b(i3);
                i3 = m4050b(2, j2);
                if (-1 != i3) {
                    this.f1869F.b().set(i3, cVar);
                } else {
                    this.f1869F.b().add(cVar);
                }
            }
            i2++;
        }
    }

    private void m4010F() {
        C2538c.m12677c("HWFitnessMgr", "Enter convertV0DetailDataInfo().");
        long j = 0;
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        while (i < this.f1868E.size()) {
            int i4;
            String str = (String) this.f1868E.get(i);
            switch (m4017a(str)) {
                case 1:
                    if (i == this.f1868E.size() - 1) {
                        i4 = i;
                        i = i2;
                        i2 = 1;
                        break;
                    }
                    j = m4052b((String) this.f1868E.get(i + 1));
                    i4 = i + 1;
                    i2 = 1;
                    i = -1;
                    break;
                case 2:
                    if (i == this.f1868E.size() - 1) {
                        i4 = i;
                        i = i2;
                        i2 = 2;
                        break;
                    }
                    j = m4052b((String) this.f1868E.get(i + 1));
                    i4 = i + 1;
                    i2 = 2;
                    i = -1;
                    break;
                default:
                    i2++;
                    if (1 != i3) {
                        if (2 == i3) {
                            m4055b(j, str, i2);
                        }
                        i4 = i;
                        i = i2;
                        i2 = i3;
                        break;
                    }
                    m4028a(j, str, i2);
                    i4 = i;
                    i = i2;
                    i2 = i3;
                    break;
            }
            i3 = i2;
            i2 = i;
            i = i4 + 1;
        }
    }

    private void m4104n(byte[] bArr) {
        if (this.f1867D <= this.f1905w) {
            String a = C0973a.m3509a(Arrays.copyOfRange(bArr, 2, bArr.length));
            if (this.f1867D <= 8) {
                C2538c.m12677c("HWFitnessMgr", "get V0 detail data but today info with index = " + this.f1867D);
            } else {
                C2538c.m12677c("HWFitnessMgr", "get V0 real detail data with index = " + this.f1867D);
                this.f1868E.add(a.substring(0, a.length() / 2));
                this.f1868E.add(a.substring(a.length() / 2, a.length()));
            }
            C2538c.m12677c("HWFitnessMgr", "Detail data = " + a);
            this.f1867D += 2;
            com.huawei.hwfitnessmgr.deviceadapter.d.i(this.f1867D);
        } else if (this.f1867D == this.f1905w + 2) {
            C2538c.m12677c("HWFitnessMgr", "get V0 real detail success with index = " + this.f1867D);
            m4010F();
            List arrayList = new ArrayList();
            arrayList.add(this.f1869F);
            this.f1900q.b(this, arrayList);
            C2538c.m12677c("HWFitnessMgr", "Start to clear V0 temp Detail Data.");
            arrayList.clear();
            this.f1869F.c().clear();
            this.f1869F.b().clear();
            this.f1867D = -1;
            this.f1868E.clear();
            m4092j(0);
            C2538c.m12677c("HWFitnessMgr", "Start to clear V0 Device Detail Data.");
            com.huawei.hwfitnessmgr.deviceadapter.d.d();
        } else {
            C2538c.m12680e("HWFitnessMgr", "get V0 detail data but index out of range");
            m4076f(201000);
        }
    }

    private int m4016a(p pVar) {
        MotionGoal motionGoal = new MotionGoal();
        motionGoal.setGoalType(1);
        motionGoal.setMotionType(0);
        motionGoal = pVar.a(this, motionGoal);
        if ((motionGoal.getDataType() & 1) != 0) {
            return motionGoal.getStepGoal();
        }
        return 0;
    }

    public int m4139f() {
        if (this.f1899p == null) {
            return -1;
        }
        DeviceInfo c = this.f1899p.m5447c();
        if (c != null) {
            return c.getDeviceProtocol();
        }
        return -1;
    }

    public static String m4080g() {
        f1861m = C1093a.m4739a(BaseApplication.m2632b()).m4750c();
        if (f1861m == null) {
            f1861m = "";
        }
        return f1861m;
    }

    public UserInfomation m4140h() {
        UserInfomation userInfomation = null;
        C0630m a = C0630m.m2297a(BaseApplication.m2632b());
        if (a != null) {
            userInfomation = a.m2301a();
            C2538c.m12661a("05", 1, "HWFitnessMgr", "getLocalUserinfo return  userInfomation");
        } else {
            C2538c.m12680e("HWFitnessMgr", "hwUserProfileMgr is null");
        }
        if (userInfomation == null) {
            return new UserInfomation();
        }
        return userInfomation;
    }

    public int m4141i() {
        int i = -1;
        DeviceCapability a = C0972a.m3499a();
        if (a != null) {
            i = a.getFitness_frame_type();
        } else {
            C2538c.m12677c("HWFitnessMgr", "getDeviceDataType deviceCapability is null");
        }
        C2538c.m12674b("HWFitnessMgr", "getDeviceDataType type=" + i);
        return i;
    }

    public boolean m4142j() {
        if (this.f1899p == null) {
            return false;
        }
        DeviceInfo c = this.f1899p.m5447c();
        if (c == null || 7 != c.getProductType()) {
            return false;
        }
        return true;
    }

    public long m4116a(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(instance.get(1), instance.get(2), instance.get(5), 0, 0, 0);
        return instance.getTime().getTime() / 1000;
    }

    public boolean m4134c(IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "onDataMigrate enter");
        b a = b.a();
        if (a != null) {
            if (iBaseResponseCallback == null) {
                a.a(this);
            } else {
                a.a(iBaseResponseCallback);
            }
        }
        C2538c.m12677c("HWFitnessMgr", "onDataMigrate leave");
        return true;
    }

    public boolean m4127a(String str, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "onDataMigrateToCurrentbyHuid enter");
        b a = b.a();
        if (a != null) {
            a.a(str, iBaseResponseCallback);
        }
        C2538c.m12677c("HWFitnessMgr", "onDataMigrate leave");
        return true;
    }

    public HeartZoneConf m4143k() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "getHeartZoneConfig enter ");
        UserInfomation h = m4140h();
        HeartZoneConf heartZoneConf = new HeartZoneConf(h.getAge());
        HeartRateZoneThroshold heartZoneConf2 = new HeartZoneConf(h.getAge());
        HiUserPreference a = C0824b.m2914a(BaseApplication.m2632b()).m2898a("custom.UserPreference_HeartZone_Config");
        if (a != null) {
            C2538c.m12674b("HWFitnessMgr", "getHeartZoneConfig value = " + a.getValue());
            String[] split = a.getValue().split(",");
            C2538c.m12674b("HWFitnessMgr", "getHeartZoneConfig heartConf0 = " + split[0]);
            C2538c.m12674b("HWFitnessMgr", "getHeartZoneConfig heartConf1 = " + split[1]);
            if (2 == split.length) {
                heartZoneConf.setHRZoneConf(split[0]);
                heartZoneConf2.setThreshold(split[1]);
                heartZoneConf.setThroshold(heartZoneConf2);
            }
        }
        C2538c.m12674b("HWFitnessMgr", "getHeartZoneConfig hrZoneConf = " + heartZoneConf);
        return heartZoneConf;
    }

    public void m4122a(IBaseResponseCallback iBaseResponseCallback, boolean z) {
        this.f1886a.execute(new av(this, iBaseResponseCallback, z));
    }

    private void m4011G() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "enter syncCoreSleepButtonEnable()");
        DeviceCapability a = C0972a.m3499a();
        if (a == null) {
            C2538c.m12677c("HWFitnessMgr", "syncCoreSleepButtonEnable deviceCapability is null");
        } else if (a.isSupportCoreSleep()) {
            C2538c.m12677c("HWFitnessMgr", "syncCoreSleepButtonEnable btValue:" + m4144l());
            m4020a(100, 180000);
            com.huawei.hwfitnessmgr.deviceadapter.d.e(r0);
        } else {
            C2538c.m12677c("HWFitnessMgr", "syncCoreSleepButtonEnable is not support");
        }
    }

    public void m4135d(int i) {
        C2538c.m12677c("HWFitnessMgr", "saveCoreSleepButton enable = " + i);
        e.a(this.f1898n, i);
    }

    public int m4144l() {
        C2538c.m12677c("HWFitnessMgr", "getCoreSleepButton enable = " + e.a(this.f1898n));
        return e.a(this.f1898n);
    }

    private void m4012H() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "enter queryCoreSleepSwitchEnable()");
        DeviceCapability a = C0972a.m3499a();
        if (a == null) {
            C2538c.m12677c("HWFitnessMgr", "queryCoreSleepSwitchEnable deviceCapability is null");
        } else if (a.isSupportQueryDeviceCoreSleepSwitch()) {
            m4021a(27, new ag(this));
            com.huawei.hwfitnessmgr.deviceadapter.d.b();
        } else {
            C2538c.m12677c("HWFitnessMgr", "isSupportQueryDeviceCoreSleepSwitch is not support");
        }
    }

    public void m4126a(boolean z) {
        int i;
        C2538c.m12661a("05", 1, "HWFitnessMgr", "enter changeHeartRateBtValue = ", Boolean.valueOf(z));
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        m4137e(i);
        m4145m();
        C2538c.m12674b("HWFitnessMgr", "leave changeHeartRateBtValue ");
    }

    public void m4145m() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "enter syncHeartRateButtonEnable()");
        DeviceCapability a = C0972a.m3499a();
        if (a == null) {
            C2538c.m12677c("HWFitnessMgr", "syncHeartRateButtonEnable deviceCapability is null");
        } else if (a.isSupportHeartRateEnable()) {
            C2538c.m12661a("05", 1, "HWFitnessMgr", "syncHeartRateButtonEnable btValue:" + m4146n());
            com.huawei.hwfitnessmgr.deviceadapter.d.f(r0);
        } else {
            C2538c.m12677c("HWFitnessMgr", "syncHeartRateButtonEnable is not support");
        }
    }

    public void m4137e(int i) {
        C2538c.m12677c("HWFitnessMgr", "saveHeartRateButton enable = " + i);
        e.b(this.f1898n, i);
    }

    public int m4146n() {
        C2538c.m12677c("HWFitnessMgr", "getHeartRateButton enable = " + e.b(this.f1898n));
        return e.b(this.f1898n);
    }

    private void m4062b(byte[] bArr, int i) {
        m4092j(100);
        C2538c.m12661a("05", 1, "HWFitnessMgr", "procSetCoreCmdResult Complete cmd=" + i);
        try {
            if (bArr[2] == TagName.ELECTRONIC_PUBLISH_START_TIME) {
                C2538c.m12674b("HWFitnessMgr", "procSetCoreCmdResult return err:" + com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr));
                if (com.huawei.hwfitnessmgr.deviceadapter.e.a(bArr) == 0) {
                    this.f1887b = 1;
                    C2538c.m12674b("HWFitnessMgr", "procSetCoreCmdResult  button state:" + this.f1887b);
                    return;
                }
                this.f1887b = 0;
                C2538c.m12674b("HWFitnessMgr", "procSetCoreCmdResult  button state:" + this.f1887b);
            }
        } catch (t e) {
            C2538c.m12674b("HWFitnessMgr", " Exception :" + e.getMessage());
        }
    }

    public void m4131b(boolean z) {
        int i;
        C2538c.m12661a("05", 1, "HWFitnessMgr", "enter changeCoreSleepBtValue = ", Boolean.valueOf(z));
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        m4135d(i);
        m4011G();
        C2538c.m12674b("HWFitnessMgr", "leave changeCoreSleepBtValue ");
    }

    private void m4065c(String str) {
        C0996a.m3611a(this.f1898n, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_SYNCHRONIZING_DATA_FLAG", str, null);
    }

    private void m4013I() {
        C2538c.m12677c("HWFitnessMgr", "sendDialogDismisssBroadcast.");
        this.f1898n.sendBroadcast(new Intent("com.huawei.bone.action.ACTION_DIALOG_DISMISS"), C0976c.f1642a);
    }

    public void m4147o() {
        C2538c.m12661a("05", 1, "HWFitnessMgr", "start migrateSettingtoHealth");
        this.f1886a.execute(new aq(this, null));
    }

    private boolean m4014J() {
        C2538c.m12677c("HWFitnessMgr", "getMigrateSettingtoHealthStatus enter");
        String sharedPreference = getSharedPreference("kStorage_FitnessMgr_migrate_setting_to_health_status");
        if (sharedPreference == null || "".equals(sharedPreference)) {
            return false;
        }
        C2538c.m12677c("HWFitnessMgr", "getMigrateSettingtoHealthStatus,isMigrateFlag = " + Boolean.parseBoolean(sharedPreference));
        return Boolean.parseBoolean(sharedPreference);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.f1872J.quit();
        this.f1872J = null;
    }

    private void m4015K() {
        C2538c.m12677c("HWFitnessMgr", "sending broadcast to sync workout data.");
        Intent intent = new Intent("com.huawei.phoneservice.sync_workout_broadcast_action");
        intent.setPackage("com.huawei.bone");
        this.f1898n.sendBroadcast(intent, C0976c.f1642a);
    }
}
