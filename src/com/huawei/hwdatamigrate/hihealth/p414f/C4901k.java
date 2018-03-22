package com.huawei.hwdatamigrate.hihealth.p414f;

import android.content.Context;
import android.util.SparseArray;
import com.huawei.hihealth.HiDataInsertOption;
import com.huawei.hihealth.HiDeviceInfo;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.a.a;
import com.huawei.hihealth.a.b;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hwdatamigrate.hihealth.p067c.C4850g;
import com.huawei.hwdatamigrate.hihealth.p067c.C4859p;
import com.huawei.hwdatamigrate.hihealth.p067c.C4862s;
import com.huawei.hwdatamigrate.hihealth.p067c.C4865v;
import com.huawei.hwdatamigrate.hihealth.p067c.C4868y;
import com.huawei.hwdatamigrate.hihealth.p067c.an;
import com.huawei.hwdatamigrate.hihealth.p067c.aq;
import com.huawei.hwdatamigrate.hihealth.p067c.aw;
import com.huawei.hwdatamigrate.hihealth.p067c.az;
import com.huawei.hwdatamigrate.hihealth.p067c.bj;
import com.huawei.hwdatamigrate.hihealth.p067c.bs;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: MigrateWearByHuid */
public class C4901k implements C4891a {
    private static boolean f17941h;
    private static String f17942i;
    private SparseArray<String> f17943a;
    private Context f17944b;
    private a f17945c;
    private C4850g f17946d;
    private bj f17947e;
    private C4868y f17948f;
    private boolean f17949g;
    private int f17950j;
    private int f17951k;
    private List<Integer> f17952l;

    private C4901k(Context context) {
        this.f17944b = context;
    }

    public static C4901k m23704a(Context context, String str, Boolean bool) {
        f17942i = str;
        f17941h = bool.booleanValue();
        return C4904n.f17959a;
    }

    private int m23707d() {
        this.f17943a = new SparseArray();
        this.f17946d = C4850g.m23559a(this.f17944b);
        this.f17948f = C4868y.m23620a(this.f17944b);
        this.f17947e = bj.m23507a(this.f17944b);
        this.f17950j = bs.m23535a(this.f17944b).m23537a(f17942i, 0);
        if (this.f17950j <= 0) {
            return 12;
        }
        this.f17945c = b.a(this.f17944b);
        this.f17951k = this.f17946d.m23561a(this.f17950j, 0, 0);
        this.f17952l = this.f17946d.m23565c(this.f17950j);
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"user = ", Integer.valueOf(this.f17950j), ",statClient = ", Integer.valueOf(this.f17951k), ",userClients = ", this.f17952l});
        C2538c.b("HiH_MigrateWearByHuid", new Object[]{"initManager huid = ", f17942i});
        return 0;
    }

    public boolean m23720c() {
        return this.f17944b.getDatabasePath("hihealth_003.db").exists();
    }

    public int mo4574b() {
        C2538c.b("HiH_MigrateWearByHuid", new Object[]{"startMigrateWearDataByHuid! isMigrating = ", Boolean.valueOf(this.f17949g)});
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (f17942i == null) {
            return 11;
        }
        if (m23720c()) {
            int i;
            try {
                this.f17949g = true;
                if (m23707d() != 0) {
                    i = 12;
                    return i;
                }
                m23708e();
                m23716m();
                m23709f();
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateWearData end time = ", Long.valueOf(System.currentTimeMillis() - valueOf.longValue())});
                this.f17949g = false;
                return 0;
            } catch (Exception e) {
                Object[] objArr = new Object[2];
                objArr[0] = "migrateWearDataByHuid Exception e = ";
                i = e.getMessage();
                objArr[1] = i;
                C2538c.e("HiH_MigrateWearByHuid", objArr);
            } finally {
                this.f17949g = false;
            }
        } else {
            C2538c.d("HiH_MigrateWearByHuid", new Object[]{"migrateWearDataByHuid DB ", "hihealth_003.db", " is not exist"});
            return 10;
        }
    }

    private void m23708e() throws C4895e {
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateStatData"});
        m23717n();
        long currentTimeMillis = System.currentTimeMillis();
        C4865v a = C4865v.m23609a(this.f17944b);
        int i = 0;
        while (true) {
            List a2;
            if (f17941h) {
                a2 = a.m23616a(this.f17951k, 1, i, 500);
            } else {
                a2 = a.m23619b(this.f17951k, 1, i, 500);
            }
            m23706a(a2);
            if (a2 == null || a2.size() < 500) {
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateStatData statDatas over anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"hiHealthDatas migrateStatData statDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            } else {
                i += 500;
            }
        }
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateStatData statDatas over anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"hiHealthDatas migrateStatData statDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private void m23709f() throws C4895e {
        m23714k();
        m23710g();
        m23711h();
        m23712i();
        m23713j();
        m23715l();
    }

    private void m23710g() throws C4895e {
        List a;
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migratePointData"});
        m23717n();
        if (f17941h) {
            a = this.f17947e.m23517a(this.f17952l, "sample_point");
        } else {
            a = this.f17947e.m23519b(this.f17952l, "sample_point");
        }
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migratePointData_ pointClient = ", a});
        if (!C4539a.m21749a((List) a)) {
            aq a2 = aq.m23476a(this.f17944b);
            for (Integer num : a) {
                String a3 = m23705a(num.intValue());
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{" migratePointData_ client = ", num});
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (f17941h) {
                        a = a2.m23478a(num.intValue(), 1, i, 500, a3);
                    } else {
                        a = a2.m23479b(num.intValue(), 1, i, 500, a3);
                    }
                    if (!m23706a(a)) {
                        C2538c.d("HiH_MigrateWearByHuid", new Object[]{"migratePointData pointDatas fail "});
                    }
                    if (a == null || a.size() < 500) {
                        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migratePointData pointDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migratePointData pointDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    } else {
                        i += 500;
                    }
                }
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migratePointData pointDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migratePointData pointDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        }
    }

    private void m23711h() throws C4895e {
        List a;
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionData"});
        m23717n();
        if (f17941h) {
            a = this.f17947e.m23517a(this.f17952l, "sample_session");
        } else {
            a = this.f17947e.m23519b(this.f17952l, "sample_session");
        }
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionData Client = ", a});
        if (!C4539a.m21749a((List) a)) {
            C4862s a2 = C4862s.m23598a(this.f17944b);
            for (Integer num : a) {
                String a3 = m23705a(num.intValue());
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"Enter migrateSessionData client = ", num});
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (f17941h) {
                        a = a2.m23605a(num.intValue(), 1, i, 500, a3);
                    } else {
                        a = a2.m23607b(num.intValue(), 1, i, 500, a3);
                    }
                    if (!m23706a(a)) {
                        C2538c.d("HiH_MigrateWearByHuid", new Object[]{"migrateSessionData sessionDatas fail "});
                    }
                    if (a == null || a.size() < 500) {
                        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionData sessionDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionData sessionDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    } else {
                        i += 500;
                    }
                }
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionData sessionDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionData sessionDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        }
    }

    private void m23712i() throws C4895e {
        List a;
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionHealthData"});
        m23717n();
        if (f17941h) {
            a = this.f17947e.m23517a(this.f17952l, "sample_session_health");
        } else {
            a = this.f17947e.m23519b(this.f17952l, "sample_session_health");
        }
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"TAG migrateSessionHealthData sessionHealthClient = ", a});
        if (!C4539a.m21749a((List) a)) {
            az a2 = az.m23488a(this.f17944b);
            for (Integer num : a) {
                String a3 = m23705a(num.intValue());
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"TAG migrateSessionHealthData client = ", num});
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (f17941h) {
                        a = a2.m23490a(num.intValue(), 1, i, 500, a3);
                    } else {
                        a = a2.m23491b(num.intValue(), 1, i, 500, a3);
                    }
                    if (!m23706a(a)) {
                        C2538c.d("HiH_MigrateWearByHuid", new Object[]{"migrateSessionHealthData sessionHealthDatas fail "});
                    }
                    if (a == null || a.size() < 500) {
                        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionHealthData sessionHealthDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionHealthData sessionHealthDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    } else {
                        i += 500;
                    }
                }
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionHealthData sessionHealthDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionHealthData sessionHealthDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        }
    }

    private void m23713j() throws C4895e {
        List a;
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionCoreData"});
        m23717n();
        if (f17941h) {
            a = this.f17947e.m23517a(this.f17952l, "sample_session_core");
        } else {
            a = this.f17947e.m23519b(this.f17952l, "sample_session_core");
        }
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionCoreData CoreClient = ", a});
        if (!C4539a.m21749a((List) a)) {
            an a2 = an.m23465a(this.f17944b);
            for (Integer num : a) {
                String a3 = m23705a(num.intValue());
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionCoreData_ client = ", num});
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (f17941h) {
                        a = a2.m23472a(num.intValue(), 1, i, 500, a3);
                    } else {
                        a = a2.m23474b(num.intValue(), 1, i, 500, a3);
                    }
                    if (!m23706a(a)) {
                        C2538c.d("HiH_MigrateWearByHuid", new Object[]{"migrateSessionCoreData sessionCoreDatas fail "});
                    }
                    if (a == null || a.size() < 500) {
                        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionCoreData sessionCoreDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionCoreData sessionCoreDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    } else {
                        i += 500;
                    }
                }
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionCoreData sessionCoreDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSessionCoreData sessionCoreDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        }
    }

    private void m23714k() throws C4895e {
        List a;
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSequenceData"});
        m23717n();
        if (f17941h) {
            a = this.f17947e.m23517a(this.f17952l, "sample_sequence");
        } else {
            a = this.f17947e.m23519b(this.f17952l, "sample_sequence");
        }
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSequenceData sequenceClient = ", a});
        if (!C4539a.m21749a((List) a)) {
            C4859p a2 = C4859p.m23582a(this.f17944b);
            for (Integer num : a) {
                String a3 = m23705a(num.intValue());
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSequenceData client = ", num});
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (f17941h) {
                        a = a2.m23590a(num.intValue(), 1, i, 1, a3);
                    } else {
                        a = a2.m23596b(num.intValue(), 1, i, 1, a3);
                    }
                    if (!m23706a(a)) {
                        C2538c.d("HiH_MigrateWearByHuid", new Object[]{"migrateSequenceData fail sequenceDatas ", a});
                    }
                    if (a == null || a.size() < 1) {
                        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSequenceData sequenceDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(1)});
                        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSequenceData sequenceDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    } else {
                        i++;
                    }
                }
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSequenceData sequenceDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(1)});
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateSequenceData sequenceDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        }
    }

    private void m23715l() throws C4895e {
        List a;
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"Enter migratePointHealthData"});
        m23717n();
        if (f17941h) {
            a = this.f17947e.m23517a(this.f17952l, "sample_point_health");
        } else {
            a = this.f17947e.m23519b(this.f17952l, "sample_point_health");
        }
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"enter pointHealthClient = ", a});
        if (!C4539a.m21749a((List) a)) {
            aw a2 = aw.m23483a(this.f17944b);
            for (Integer num : a) {
                String a3 = m23705a(num.intValue());
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"log. migratePointHealthData client = ", num});
                long currentTimeMillis = System.currentTimeMillis();
                int i = 0;
                while (true) {
                    if (f17941h) {
                        a = a2.m23485a(num.intValue(), 1, i, 500, a3);
                    } else {
                        a = a2.m23487b(num.intValue(), 1, i, 500, a3);
                    }
                    if (!m23706a(a)) {
                        C2538c.d("HiH_MigrateWearByHuid", new Object[]{"migratePointHealthData pointHealthDatas fail "});
                    }
                    if (a == null || a.size() < 500) {
                        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migratePointHealthData pointHealthDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migratePointHealthData pointHealthDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    } else {
                        i += 500;
                    }
                }
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migratePointHealthData pointHealthDatas is null anchor = ", Integer.valueOf(i), ",count = ", Integer.valueOf(500)});
                C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migratePointHealthData pointHealthDatas to hihealth end anchor = ", Integer.valueOf(i), ",time = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
        }
    }

    private boolean m23706a(List<HiHealthData> list) throws C4895e {
        if (C4539a.m21749a((List) list)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean[] zArr = new boolean[]{true};
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f17945c.a(new HiDataInsertOption((List) list), new C4902l(this, zArr, countDownLatch));
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            C2538c.e("HiH_MigrateWearByHuid", new Object[]{"migrateAccount InterruptedException e = ", e.getMessage()});
        }
        C2538c.c("HiH_MigrateWearByHuid", new Object[]{"migrateDataToHiHealth end datas size = ", Integer.valueOf(list.size()), ",result = ", Boolean.valueOf(zArr[0]), ",totalTime = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return zArr[0];
    }

    private void m23716m() throws C4895e {
        m23717n();
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(0));
        List<HiDeviceInfo> a = this.f17948f.m23628a();
        if (!C4539a.m21749a((List) a)) {
            for (HiDeviceInfo a2 : a) {
                b.a(this.f17944b).a(a2, arrayList, null);
            }
        }
    }

    private String m23705a(int i) {
        String str = (String) this.f17943a.get(i);
        if (!C4539a.m21748a(str)) {
            return str;
        }
        int b = this.f17946d.m23564b(i);
        if (this.f17948f.m23627a(b) == null) {
            return str;
        }
        str = this.f17948f.m23627a(b).getDeviceUniqueCode();
        this.f17943a.put(i, str);
        return str;
    }

    public boolean mo4573a() {
        return this.f17949g;
    }

    private void m23717n() throws C4895e {
        boolean[] zArr = new boolean[]{true};
        CountDownLatch countDownLatch = new CountDownLatch(1);
        b.a(this.f17944b).a(new C4903m(this, countDownLatch, zArr));
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            C2538c.e("HiH_MigrateWearByHuid", new Object[]{"migrateData InterruptedException e = ", e.getMessage()});
        }
        if (!zArr[0]) {
            throw new C4895e("migrateData unlogin! result = " + zArr[0]);
        }
    }
}
