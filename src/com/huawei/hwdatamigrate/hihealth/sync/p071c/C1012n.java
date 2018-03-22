package com.huawei.hwdatamigrate.hihealth.sync.p071c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.HiSyncOption;
import com.huawei.hihealth.c.b;
import com.huawei.hihealth.c.e;
import com.huawei.hms.support.api.entity.pay.PayStatusCodes;
import com.huawei.hwcloudmodel.mgr.a;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwcloudmodel.model.SportTotalData;
import com.huawei.hwcloudmodel.model.unite.AddSportTotalReq;
import com.huawei.hwcloudmodel.model.unite.GetSportStatReq;
import com.huawei.hwcloudmodel.model.unite.SportTotal;
import com.huawei.hwdatamigrate.hihealth.c.bm;
import com.huawei.hwdatamigrate.hihealth.c.g;
import com.huawei.hwdatamigrate.hihealth.p066a.C1001a;
import com.huawei.hwdatamigrate.hihealth.p069e.C1003a;
import com.huawei.hwdatamigrate.hihealth.sync.b.k;
import com.huawei.hwdatamigrate.hihealth.sync.c.o;
import com.huawei.hwdatamigrate.hihealth.sync.p070a.C1004h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1015e;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1016h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1017i;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1018m;
import com.huawei.p190v.C2538c;
import java.util.List;

/* compiled from: HiSyncTotalSportStat */
public class C1012n implements C1006d {
    private a f1773a;
    private Context f1774b;
    private HiSyncOption f1775c;
    private int f1776d;
    private int f1777e = 0;
    private g f1778f;
    private bm f1779g;
    private k f1780h;
    private int f1781i;
    private int f1782j = 0;
    private final int[] f1783k = new int[]{PayStatusCodes.PRODUCT_AUTHENTICATION_FAILED, PayStatusCodes.PRODUCT_SOME_NOT_EXIST, PayStatusCodes.PRODUCT_SERVER_INTERNAL_EXCEPTION, 40006, 40005};
    private final String[] f1784l = new String[]{"sport_step_sum", "sport_distance_sum", "sport_calorie_sum", "sport_duration_sum", "sport_altitude_offset_sum"};

    public C1012n(@NonNull Context context, @NonNull HiSyncOption hiSyncOption, int i, int i2) {
        C2538c.m12674b("Debug_HiSyncTotalSportStat", "HiSyncSportStat create");
        this.f1774b = context.getApplicationContext();
        this.f1775c = hiSyncOption;
        this.f1776d = i;
        m3818c();
    }

    private void m3812a(SparseArray<Integer> sparseArray, boolean z) throws C1004h {
        if (z) {
            C2538c.m12677c("Debug_HiSyncTotalSportStat", "downloadAllStat too much need to download ,start a thread ! downloadDaysMap is ", sparseArray);
            m3811a((SparseArray) sparseArray);
            return;
        }
        C2538c.m12677c("Debug_HiSyncTotalSportStat", "downloadAllStat do not need to start a thread ! downloadDaysMap is ", sparseArray);
        m3816b((SparseArray) sparseArray);
        C1001a.m3640a(this.f1774b, 1);
        C1001a.m3647e(this.f1774b);
        C1003a.m3690a().m3692a(1, "HiSyncTotalSportStat", null);
    }

    private void m3818c() {
        this.f1773a = a.a(this.f1774b);
        this.f1780h = new k(this.f1774b);
        this.f1778f = g.a(this.f1774b);
        this.f1779g = bm.a(this.f1774b);
        this.f1781i = b.a(System.currentTimeMillis());
    }

    private void m3811a(SparseArray<Integer> sparseArray) {
        if (sparseArray == null || sparseArray.size() <= 0) {
            C2538c.m12679d("Debug_HiSyncTotalSportStat", "downloadAllStatByTime() downloadDaysMap is null,stop pullDataByVersion");
            return;
        }
        new Thread(new o(this, sparseArray)).start();
    }

    private void m3816b(SparseArray<Integer> sparseArray) throws C1004h {
        C2538c.m12677c("Debug_HiSyncTotalSportStat", "downloadAllStatByTimeSync downloadDaysMap is ", sparseArray);
        if (sparseArray == null || sparseArray.size() <= 0) {
            C2538c.m12679d("Debug_HiSyncTotalSportStat", "downloadAllStatByTimeSync() downloadDaysMap is null,stop pullStat");
            return;
        }
        m3819c(sparseArray);
    }

    private void m3819c(SparseArray<Integer> sparseArray) throws C1004h {
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            int keyAt = sparseArray.keyAt(size);
            m3822a(keyAt, ((Integer) sparseArray.get(keyAt)).intValue());
        }
    }

    public void m3822a(int i, int i2) throws C1004h {
        if (i > i2 || i <= 0) {
            C2538c.m12679d("Debug_HiSyncTotalSportStat", ". downloadOneStatByTime the time is not right");
            return;
        }
        C2538c.m12674b("Debug_HiSyncTotalSportStat", "downloadOneStatByTime startTime is ", Integer.valueOf(i), " , endTime is ", Integer.valueOf(i2));
        GetSportStatReq getSportStatReq = new GetSportStatReq();
        getSportStatReq.setStartTime(Integer.valueOf(i));
        getSportStatReq.setEndTime(Integer.valueOf(i2));
        getSportStatReq.setDataSource(Integer.valueOf(2));
        CloudCommonReponse a = this.f1773a.a(getSportStatReq);
        if (com.huawei.hwdatamigrate.hihealth.sync.a.g.a(a, false)) {
            this.f1779g.a(this.f1776d, this.f1775c.getSyncDataType(), i2, 0);
            List sportStat = a.getSportStat();
            if (sportStat == null || sportStat.isEmpty()) {
                C2538c.m12679d("Debug_HiSyncTotalSportStat", "downloadOneStatByTime sportsStat is null or empty");
                return;
            }
            m3815a(sportStat);
        }
    }

    private void m3815a(List<SportTotalData> list) {
        for (SportTotalData sportTotalData : list) {
            if (sportTotalData != null) {
                if (sportTotalData.getSportType().intValue() != 0) {
                    C2538c.m12679d("Debug_HiSyncTotalSportStat", "saveSportTotalToDB the sport stat type is not right ,type is ", sportTotalData.getSportType());
                } else {
                    m3813a(sportTotalData);
                }
            }
        }
    }

    private AddSportTotalReq m3810a(List<SportTotal> list, String str) {
        AddSportTotalReq addSportTotalReq = new AddSportTotalReq();
        addSportTotalReq.setTotalInfo(list);
        addSportTotalReq.setTimeZone(str);
        for (SportTotal recordDay : list) {
            if (recordDay.getRecordDay().intValue() == b.a(System.currentTimeMillis())) {
                C2538c.m12677c("Debug_HiSyncTotalSportStat", "getAddSportTotalReq upload today stat may let cloud do push ,pushAction is ", Integer.valueOf(this.f1775c.getPushAction()), " day is ", ((SportTotal) r2.next()).getRecordDay());
                addSportTotalReq.setIsForce(this.f1775c.getPushAction());
            }
        }
        return addSportTotalReq;
    }

    private void m3813a(SportTotalData sportTotalData) {
        C2538c.m12677c("Debug_HiSyncTotalSportStat", "saveStatToDB cloudSportTotalStat is ", e.a(sportTotalData));
        List a = this.f1780h.a(sportTotalData, this.f1776d);
        if (a != null && !a.isEmpty()) {
            com.huawei.hwdatamigrate.hihealth.h.a.a(this.f1774b).a(a);
        }
    }

    private boolean m3817b(List<HiHealthData> list) throws C1004h {
        int i = this.f1782j + 1;
        this.f1782j = i;
        C1017i.m3899a(i, this.f1775c.getSyncAction());
        List b = this.f1780h.b(list);
        if (b.isEmpty()) {
            this.f1777e++;
            C2538c.m12679d("Debug_HiSyncTotalSportStat", "addSportStatDataOne sportTotals is null or empty");
            return false;
        }
        AddSportTotalReq a = m3810a(b, ((HiHealthData) list.get(0)).getTimeZone());
        while (this.f1777e < 2) {
            if (com.huawei.hwdatamigrate.hihealth.sync.a.g.a(this.f1773a.a(a), false)) {
                C2538c.m12677c("Debug_HiSyncTotalSportStat", "addSportStat success ! uploadCount is ,", Integer.valueOf(this.f1782j), ",stat is ", e.a(b));
                C2538c.m12677c("HiH_", "addSportStat success ! uploadCount is ,", Integer.valueOf(this.f1782j));
                return true;
            }
            this.f1777e++;
        }
        C2538c.m12677c("Debug_HiSyncTotalSportStat", "addDataToCloud failed ! uploadCount is ", Integer.valueOf(this.f1782j));
        return false;
    }

    public void m3821a(int i) throws C1004h {
        while (this.f1777e < 2) {
            List a = C1018m.m3907a(this.f1774b, i, this.f1783k, this.f1784l, 50, 0);
            if (a == null || a.isEmpty()) {
                break;
            } else if (m3817b(a)) {
                C1018m.m3908a(this.f1774b, a, this.f1783k, i);
            }
        }
        this.f1777e = 0;
    }

    public void mo2311a() throws C1004h {
        SparseArray a;
        boolean z;
        C2538c.m12677c("Debug_HiSyncTotalSportStat", "pullDataByVersion() begin !");
        C1016h.m3888a(5.0d, "SYNC_SPORT_STAT_DOWNLOAD_PERCENT_MAX");
        long a2 = b.a(this.f1781i);
        if (C1017i.m3901a()) {
            C2538c.m12677c("Debug_HiSyncTotalSportStat", "pullDataByVersion() first sync pull all stat");
            a = C1017i.m3896a(1388509200000L, a2, 90);
            z = true;
        } else {
            C2538c.m12677c("Debug_HiSyncTotalSportStat", "pullDataByVersion() only pullDataByVersion recent stat");
            a = C1017i.m3896a(a2 - 864000000, a2, 90);
            z = false;
        }
        m3812a(a, z);
        C1016h.m3889a(this.f1774b);
        C2538c.m12677c("Debug_HiSyncTotalSportStat", "pullDataByVersion() end !");
    }

    public void mo2312a(long j, long j2) throws C1004h {
        m3812a(C1017i.m3896a(j, j2, 90), false);
    }

    public void mo2313b() throws C1004h {
        C2538c.m12677c("Debug_HiSyncTotalSportStat", "pushData() begin");
        if (C1015e.m3862b()) {
            C1016h.m3888a(10.0d, "SYNC_SPORT_STAT_DOWNLOAD_PERCENT_MAX");
            int a = this.f1778f.a(this.f1776d);
            if (a <= 0) {
                C2538c.m12679d("Debug_HiSyncTotalSportStat", "pushData() no statClient get, maybe no data need to pushData !");
            } else {
                m3821a(a);
            }
            C1016h.m3889a(this.f1774b);
            C2538c.m12677c("Debug_HiSyncTotalSportStat", "pushData() end !!");
            return;
        }
        C2538c.m12679d("Debug_HiSyncTotalSportStat", "pushData() dataPrivacy switch is closed .can not pushData right now ,push end !");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("--HiSyncTotalSportStat{");
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
