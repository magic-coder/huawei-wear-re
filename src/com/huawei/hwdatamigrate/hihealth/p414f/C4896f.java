package com.huawei.hwdatamigrate.hihealth.p414f;

import android.content.Context;
import android.util.SparseArray;
import com.huawei.hihealth.HiAccountInfo;
import com.huawei.hihealth.HiDataInsertOption;
import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.a.a;
import com.huawei.hihealth.a.b;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hwcloudmodel.c.w;
import com.huawei.hwdatamigrate.hihealth.p067c.C4844a;
import com.huawei.hwdatamigrate.hihealth.p067c.C4847d;
import com.huawei.hwdatamigrate.hihealth.p067c.C4850g;
import com.huawei.hwdatamigrate.hihealth.p067c.C4853j;
import com.huawei.hwdatamigrate.hihealth.p067c.C4859p;
import com.huawei.hwdatamigrate.hihealth.p067c.C4862s;
import com.huawei.hwdatamigrate.hihealth.p067c.C4865v;
import com.huawei.hwdatamigrate.hihealth.p067c.C4868y;
import com.huawei.hwdatamigrate.hihealth.p067c.an;
import com.huawei.hwdatamigrate.hihealth.p067c.aq;
import com.huawei.hwdatamigrate.hihealth.p067c.at;
import com.huawei.hwdatamigrate.hihealth.p067c.aw;
import com.huawei.hwdatamigrate.hihealth.p067c.az;
import com.huawei.hwdatamigrate.hihealth.p067c.bj;
import com.huawei.hwdatamigrate.hihealth.p067c.bs;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: MigrateWear */
public class C4896f implements C4891a {
    private SparseArray<String> f17918a;
    private Context f17919b;
    private a f17920c;
    private C4847d f17921d;
    private C4844a f17922e;
    private C4850g f17923f;
    private bj f17924g;
    private C4868y f17925h;
    private int f17926i;
    private boolean f17927j;
    private String f17928k;
    private int f17929l;
    private int f17930m;
    private List<Integer> f17931n;

    private C4896f(Context context) {
        this.f17919b = context;
    }

    public static C4896f m23673a(Context context) {
        return C4900j.f17940a;
    }

    private int m23682e() {
        this.f17918a = new SparseArray();
        this.f17923f = C4850g.m23559a(this.f17919b);
        this.f17925h = C4868y.m23620a(this.f17919b);
        this.f17924g = bj.m23507a(this.f17919b);
        this.f17929l = bs.m23535a(this.f17919b).m23537a(this.f17928k, 0);
        this.f17930m = this.f17923f.m23561a(this.f17929l, 0, 0);
        this.f17931n = this.f17923f.m23565c(this.f17929l);
        C2538c.c("HiH_MigrateWear", new Object[]{"user = ", Integer.valueOf(this.f17929l), ",statClient = ", Integer.valueOf(this.f17930m), ",userClients = ", this.f17931n});
        C2538c.b("HiH_MigrateWear", new Object[]{"initManager huid = ", this.f17928k});
        return 0;
    }

    public boolean m23699c() {
        return this.f17919b.getDatabasePath("hihealth_003.db").exists();
    }

    public boolean m23700d() {
        this.f17921d = C4847d.m23553a(this.f17919b);
        this.f17922e = C4844a.m23413a(this.f17919b);
        this.f17926i = this.f17921d.m23556a(this.f17919b.getPackageName());
        C2538c.c("HiH_MigrateWear", new Object[]{"isLogin app = ", Integer.valueOf(this.f17926i)});
        if (this.f17926i <= 0) {
            C2538c.d("HiH_MigrateWear", new Object[]{"isLogin app <= 0  packageName = " + this.f17919b.getPackageName()});
            return false;
        }
        this.f17928k = this.f17922e.m23420b(this.f17926i);
        C2538c.b("HiH_MigrateWear", new Object[]{"isLogin huid = ", this.f17928k});
        if (this.f17928k == null) {
            C2538c.d("HiH_MigrateWear", new Object[]{"isLogin who = NULL  app = " + this.f17926i});
            return false;
        }
        this.f17920c = b.a(this.f17919b);
        return w.a(this.f17928k);
    }

    public int mo4574b() {
        C2538c.b("HiH_MigrateWear", new Object[]{"startMigrateWearData! isMigrating = ", Boolean.valueOf(this.f17927j)});
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (m23696q()) {
            C2538c.b("HiH_MigrateWear", new Object[]{"not need to migratewear20"});
            return 0;
        } else if (!m23699c()) {
            C2538c.d("HiH_MigrateWear", new Object[]{"migrateWearData DB ", "hihealth_003.db", " is not exist"});
            return 10;
        } else if (m23700d()) {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            newSingleThreadExecutor.execute(new C4897g(this, valueOf, newSingleThreadExecutor));
            return 0;
        } else {
            C2538c.d("HiH_MigrateWear", new Object[]{"migrateWearData login error"});
            return 13;
        }
    }

    private void m23684f() throws C4895e {
        C2538c.c("HiH_MigrateWear", new Object[]{"migrateAccount app = ", Integer.valueOf(this.f17926i)});
        if (w.a(this.f17928k)) {
            HiAccountInfo a = this.f17922e.m23417a(this.f17926i);
            if (a == null) {
                C2538c.d("HiH_MigrateWear", new Object[]{"migrateAccount accountInfo is null,app = ", Integer.valueOf(this.f17926i)});
                return;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.f17920c.a(a, new C4898h(this, countDownLatch));
            try {
                countDownLatch.await(10, TimeUnit.SECONDS);
                return;
            } catch (InterruptedException e) {
                C2538c.e("HiH_MigrateWear", new Object[]{"migrateAccount InterruptedException e = ", e.getMessage()});
                return;
            }
        }
        throw new C4895e("migrateAccount fail isLogin is false ");
    }

    private void m23686g() throws C4895e {
        C2538c.c("HiH_MigrateWear", new Object[]{"migrateStatData"});
        if (w.a(this.f17928k)) {
            long currentTimeMillis = System.currentTimeMillis();
            C4865v a = C4865v.m23609a(this.f17919b);
            int i = 0;
            while (true) {
                List a2 = a.m23616a(this.f17930m, 1, i, 500);
                m23677a(a2);
                if (a2 == null || a2.size() < 500) {
                    C2538c.c("HiH_MigrateWear", new Object[]{" TAG migrateStatData statDatas over anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                    C2538c.c("HiH_MigrateWear", new Object[]{" TAG migrateStatData statDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                } else {
                    i += 500;
                }
            }
            C2538c.c("HiH_MigrateWear", new Object[]{" TAG migrateStatData statDatas over anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
            C2538c.c("HiH_MigrateWear", new Object[]{" TAG migrateStatData statDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            return;
        }
        throw new C4895e("migrateStatData fail isLogin is false ");
    }

    private void m23687h() throws C4895e {
        m23693n();
        m23689j();
        m23690k();
        m23691l();
        m23692m();
        m23694o();
    }

    private void m23688i() {
        this.f17922e.m23421c(this.f17926i);
        C2538c.c("HiH_MigrateWear", new Object[]{"logout app = ", Integer.valueOf(this.f17926i)});
    }

    private void m23689j() throws C4895e {
        C2538c.c("HiH_MigrateWear", new Object[]{"migratePointData"});
        if (w.a(this.f17928k)) {
            List<Integer> a = this.f17924g.m23517a(this.f17931n, "sample_point");
            C2538c.c("HiH_MigrateWear", new Object[]{"migratePointData pointClient = ", a});
            if (!C4539a.m21749a((List) a)) {
                aq a2 = aq.m23476a(this.f17919b);
                for (Integer num : a) {
                    Object obj;
                    String a3 = m23674a(num.intValue());
                    C2538c.c("HiH_MigrateWear", new Object[]{"migratePointData client = ", num});
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = 0;
                    Object obj2 = 1;
                    while (true) {
                        List a4 = a2.m23478a(num.intValue(), 1, i, 500, a3);
                        if (m23677a(a4)) {
                            obj = obj2;
                        } else {
                            C2538c.d("HiH_MigrateWear", new Object[]{"migratePointData pointDatas fail "});
                            obj = null;
                        }
                        if (a4 == null || a4.size() < 500) {
                            C2538c.c("HiH_MigrateWear", new Object[]{"migratePointData pointDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                            C2538c.c("HiH_MigrateWear", new Object[]{"migratePointData pointDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        } else {
                            i += 500;
                            obj2 = obj;
                        }
                    }
                    C2538c.c("HiH_MigrateWear", new Object[]{"migratePointData pointDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                    C2538c.c("HiH_MigrateWear", new Object[]{"migratePointData pointDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    if (obj != null) {
                        int a5 = a2.m23477a(num.intValue());
                        C2538c.c("HiH_MigrateWear", new Object[]{"migratePointData update end update = ", Integer.valueOf(a5), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    }
                }
                return;
            }
            return;
        }
        throw new C4895e("migratePointData fail isLogin is false ");
    }

    private void m23690k() throws C4895e {
        C2538c.c("HiH_MigrateWear", new Object[]{"Enter migrateSessionData"});
        if (w.a(this.f17928k)) {
            List<Integer> a = this.f17924g.m23517a(this.f17931n, "sample_session");
            C2538c.c("HiH_MigrateWear", new Object[]{"log migrateSessionData sessionClient = ", a});
            if (!C4539a.m21749a((List) a)) {
                C4862s a2 = C4862s.m23598a(this.f17919b);
                at a3 = at.m23480a(this.f17919b);
                for (Integer num : a) {
                    Object obj;
                    String a4 = m23674a(num.intValue());
                    C2538c.c("HiH_MigrateWear", new Object[]{"Log migrateSessionData client = ", num});
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = 0;
                    Object obj2 = 1;
                    while (true) {
                        List a5 = a2.m23605a(num.intValue(), 1, i, 500, a4);
                        if (m23677a(a5)) {
                            obj = obj2;
                        } else {
                            C2538c.d("HiH_MigrateWear", new Object[]{"migrateSessionData sessionDatas fail "});
                            obj = null;
                        }
                        if (a5 == null || a5.size() < 500) {
                            C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionData sessionDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                            C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionData sessionDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        } else {
                            i += 500;
                            obj2 = obj;
                        }
                    }
                    C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionData sessionDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                    C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionData sessionDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    if (obj != null) {
                        int a6 = a3.m23481a(num.intValue());
                        C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionData update end update = ", Integer.valueOf(a6), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    }
                }
                return;
            }
            return;
        }
        throw new C4895e("migrateSessionData fail isLogin is false ");
    }

    private void m23691l() throws C4895e {
        C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionHealthData"});
        if (w.a(this.f17928k)) {
            List<Integer> a = this.f17924g.m23517a(this.f17931n, "sample_session_health");
            C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionHealthData sessionHealthClient = ", a});
            if (!C4539a.m21749a((List) a)) {
                az a2 = az.m23488a(this.f17919b);
                for (Integer num : a) {
                    Object obj;
                    String a3 = m23674a(num.intValue());
                    C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionHealthData client = ", num});
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = 0;
                    Object obj2 = 1;
                    while (true) {
                        List a4 = a2.m23490a(num.intValue(), 1, i, 500, a3);
                        if (m23677a(a4)) {
                            obj = obj2;
                        } else {
                            C2538c.d("HiH_MigrateWear", new Object[]{"migrateSessionHealthData sessionHealthDatas fail "});
                            obj = null;
                        }
                        if (a4 == null || a4.size() < 500) {
                            C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionHealthData sessionHealthDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                            C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionHealthData sessionHealthDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        } else {
                            i += 500;
                            obj2 = obj;
                        }
                    }
                    C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionHealthData sessionHealthDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                    C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionHealthData sessionHealthDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    if (obj != null) {
                        int a5 = a2.m23489a(num.intValue());
                        C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionHealthData update end update = ", Integer.valueOf(a5), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    }
                }
                return;
            }
            return;
        }
        throw new C4895e("migrateSessionHealthData fail isLogin is false ");
    }

    private void m23692m() throws C4895e {
        C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionCoreData"});
        if (w.a(this.f17928k)) {
            List<Integer> a = this.f17924g.m23517a(this.f17931n, "sample_session_core");
            C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionCoreData sessionCoreClient = ", a});
            if (!C4539a.m21749a((List) a)) {
                C4853j a2 = C4853j.m23568a(this.f17919b);
                an a3 = an.m23465a(this.f17919b);
                for (Integer num : a) {
                    Object obj;
                    String a4 = m23674a(num.intValue());
                    C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionCoreData client = ", num});
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = 0;
                    Object obj2 = 1;
                    while (true) {
                        List a5 = a3.m23472a(num.intValue(), 1, i, 500, a4);
                        if (m23677a(a5)) {
                            obj = obj2;
                        } else {
                            C2538c.d("HiH_MigrateWear", new Object[]{"migrateSessionCoreData sessionCoreDatas fail "});
                            obj = null;
                        }
                        if (a5 == null || a5.size() < 500) {
                            C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionCoreData sessionCoreDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                            C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionCoreData sessionCoreDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        } else {
                            i += 500;
                            obj2 = obj;
                        }
                    }
                    C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionCoreData sessionCoreDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                    C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionCoreData sessionCoreDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    if (obj != null) {
                        int a6 = a2.m23569a(num.intValue());
                        C2538c.c("HiH_MigrateWear", new Object[]{"migrateSessionCoreData update end update = ", Integer.valueOf(a6), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    }
                }
                return;
            }
            return;
        }
        throw new C4895e("migrateSessionCoreData fail isLogin is false ");
    }

    private void m23693n() throws C4895e {
        C2538c.c("HiH_MigrateWear", new Object[]{"migrateSequenceData"});
        if (w.a(this.f17928k)) {
            List<Integer> a = this.f17924g.m23517a(this.f17931n, "sample_sequence");
            C2538c.c("HiH_MigrateWear", new Object[]{"migrateSequenceData sequenceClient == ", a});
            if (!C4539a.m21749a((List) a)) {
                C4859p a2 = C4859p.m23582a(this.f17919b);
                for (Integer num : a) {
                    Object obj;
                    String a3 = m23674a(num.intValue());
                    C2538c.c("HiH_MigrateWear", new Object[]{"migrateSequenceData client ==: ", num});
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = 0;
                    Object obj2 = 1;
                    while (true) {
                        List a4 = a2.m23590a(num.intValue(), 1, i, 1, a3);
                        if (m23677a(a4)) {
                            obj = obj2;
                        } else {
                            C2538c.d("HiH_MigrateWear", new Object[]{"migrateSequenceData fail sequenceDatas ", a4});
                            obj = null;
                        }
                        if (a4 == null || a4.size() < 1) {
                            C2538c.c("HiH_MigrateWear", new Object[]{"migrateSequenceData sequenceDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(1)});
                            C2538c.c("HiH_MigrateWear", new Object[]{"migrateSequenceData sequenceDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        } else {
                            i++;
                            obj2 = obj;
                        }
                    }
                    C2538c.c("HiH_MigrateWear", new Object[]{"migrateSequenceData sequenceDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(1)});
                    C2538c.c("HiH_MigrateWear", new Object[]{"migrateSequenceData sequenceDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    if (obj != null) {
                        int a5 = a2.m23587a(num.intValue());
                        C2538c.c("HiH_MigrateWear", new Object[]{"migrateSequenceData update end update = ", Integer.valueOf(a5), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    }
                }
                return;
            }
            return;
        }
        throw new C4895e("migrateSequenceData fail isLogin is false ");
    }

    private void m23694o() throws C4895e {
        C2538c.c("HiH_MigrateWear", new Object[]{"migratePointHealthData"});
        if (w.a(this.f17928k)) {
            List<Integer> a = this.f17924g.m23517a(this.f17931n, "sample_point_health");
            C2538c.c("HiH_MigrateWear", new Object[]{"migratePointHealthData pointHealthClient == ", a});
            if (!C4539a.m21749a((List) a)) {
                aw a2 = aw.m23483a(this.f17919b);
                for (Integer num : a) {
                    Object obj;
                    String a3 = m23674a(num.intValue());
                    C2538c.c("HiH_MigrateWear", new Object[]{"migratePointHealthData client == ", num});
                    long currentTimeMillis = System.currentTimeMillis();
                    int i = 0;
                    Object obj2 = 1;
                    while (true) {
                        List a4 = a2.m23485a(num.intValue(), 1, i, 500, a3);
                        if (m23677a(a4)) {
                            obj = obj2;
                        } else {
                            C2538c.d("HiH_MigrateWear", new Object[]{"migratePointHealthData pointHealthDatas fail "});
                            obj = null;
                        }
                        if (a4 == null || a4.size() < 500) {
                            C2538c.c("HiH_MigrateWear", new Object[]{"migratePointHealthData pointHealthDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                            C2538c.c("HiH_MigrateWear", new Object[]{"migratePointHealthData pointHealthDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        } else {
                            i += 500;
                            obj2 = obj;
                        }
                    }
                    C2538c.c("HiH_MigrateWear", new Object[]{"migratePointHealthData pointHealthDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                    C2538c.c("HiH_MigrateWear", new Object[]{"migratePointHealthData pointHealthDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    if (obj != null) {
                        int a5 = a2.m23484a(num.intValue());
                        C2538c.c("HiH_MigrateWear", new Object[]{"migratePointHealthData update end update = ", Integer.valueOf(a5), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    }
                }
                return;
            }
            return;
        }
        throw new C4895e("migratePointHealthData fail isLogin is false ");
    }

    private boolean m23677a(List<HiHealthData> list) {
        if (C4539a.m21749a((List) list)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean[] zArr = new boolean[]{true};
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f17920c.a(new HiDataInsertOption((List) list), new C4899i(this, zArr, countDownLatch));
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            C2538c.e("HiH_MigrateWear", new Object[]{"migrateAccount InterruptedException e = ", e.getMessage()});
        }
        C2538c.c("HiH_MigrateWear", new Object[]{"migrateDataToHiHealth end datas size = ", Integer.valueOf(list.size()), ",result = ", Boolean.valueOf(zArr[0]), ",totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return zArr[0];
    }

    private void m23695p() {
        if (w.a(this.f17928k)) {
            List arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(0));
            List<HiDeviceInfo> a = this.f17925h.m23628a();
            if (!C4539a.m21749a((List) a)) {
                for (HiDeviceInfo a2 : a) {
                    b.a(this.f17919b).a(a2, arrayList, null);
                }
                return;
            }
            return;
        }
        C2538c.d("HiH_MigrateWear", new Object[]{"registerDevice isLogin is false"});
    }

    private String m23674a(int i) {
        String str = (String) this.f17918a.get(i);
        if (!C4539a.m21748a(str)) {
            return str;
        }
        int b = this.f17923f.m23564b(i);
        if (this.f17925h == null || this.f17925h.m23627a(b) == null) {
            return str;
        }
        str = this.f17925h.m23627a(b).getDeviceUniqueCode();
        this.f17918a.put(i, str);
        return str;
    }

    private boolean m23696q() {
        C2538c.c("HiH_MigrateWear", new Object[]{"getMigratedWear20DataStatus "});
        String a = com.huawei.hwdataaccessmodel.sharedpreference.a.a(this.f17919b, null, "migrate_weardata2.0_status");
        if ("".equals(a)) {
            return false;
        }
        C2538c.c("HiH_MigrateWear", new Object[]{"getMigratedWear20DataStatus,isMigrateFlag = " + Boolean.parseBoolean(a)});
        return Boolean.parseBoolean(a);
    }

    private void m23675a(boolean z) {
        com.huawei.hwdataaccessmodel.sharedpreference.a.a(this.f17919b, null, "migrate_weardata2.0_status", String.valueOf(z), null);
    }

    public boolean mo4573a() {
        return this.f17927j;
    }
}
