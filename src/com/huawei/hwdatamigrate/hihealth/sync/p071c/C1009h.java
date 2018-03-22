package com.huawei.hwdatamigrate.hihealth.sync.p071c;

import android.content.Context;
import android.support.annotation.NonNull;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import com.amap.api.maps.model.WeightedLatLng;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.HiSyncOption;
import com.huawei.hwcloudmodel.mgr.a;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.hwcloudmodel.model.unite.AddHealthDataReq;
import com.huawei.hwcloudmodel.model.unite.GetHealthDataByTimeReq;
import com.huawei.hwcloudmodel.model.unite.GetHealthDataByVersionReq;
import com.huawei.hwcloudmodel.model.unite.HealthDetail;
import com.huawei.hwcloudmodel.model.unite.SyncKey;
import com.huawei.hwdatamigrate.hihealth.c.ae;
import com.huawei.hwdatamigrate.hihealth.c.an;
import com.huawei.hwdatamigrate.hihealth.c.bj;
import com.huawei.hwdatamigrate.hihealth.c.bm;
import com.huawei.hwdatamigrate.hihealth.sync.a.g;
import com.huawei.hwdatamigrate.hihealth.sync.b.b;
import com.huawei.hwdatamigrate.hihealth.sync.d.c;
import com.huawei.hwdatamigrate.hihealth.sync.p070a.C1004h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1015e;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1016h;
import com.huawei.hwdatamigrate.hihealth.sync.p072d.C1017i;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.p190v.C2538c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: HiSyncHealthDataByUntie */
public class C1009h implements C1006d {
    private a f1721a;
    private Context f1722b;
    private HiSyncOption f1723c;
    private int f1724d;
    private bm f1725e;
    private ae f1726f;
    private an f1727g;
    private bj f1728h;
    private com.huawei.hwdatamigrate.hihealth.h.a f1729i;
    private b f1730j;
    private double f1731k;
    private List<SyncKey> f1732l;
    private List<Integer> f1733m;
    private int f1734n;
    private int f1735o;

    public C1009h(@NonNull Context context, @NonNull HiSyncOption hiSyncOption, int i, int i2) throws C1004h {
        C2538c.m12674b("Debug_HiSyncHealthDataByUntie", "HiSyncHealthDataByUntie create");
        this.f1722b = context.getApplicationContext();
        this.f1723c = hiSyncOption;
        this.f1724d = i;
        m3758c();
    }

    private void m3758c() throws C1004h {
        this.f1721a = a.a(this.f1722b);
        this.f1725e = bm.a(this.f1722b);
        this.f1726f = ae.a(this.f1722b);
        this.f1729i = com.huawei.hwdatamigrate.hihealth.h.a.a(this.f1722b);
        this.f1728h = bj.a(this.f1722b);
        this.f1727g = an.a(this.f1722b);
        this.f1730j = new b(this.f1722b);
        this.f1733m = m3760d();
        this.f1732l = C1017i.m3898a(this.f1722b, this.f1723c.getSyncMethod(), this.f1733m);
    }

    private List<Integer> m3760d() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(3));
        arrayList.add(Integer.valueOf(4));
        arrayList.add(Integer.valueOf(5));
        arrayList.add(Integer.valueOf(6));
        arrayList.add(Integer.valueOf(7));
        arrayList.add(Integer.valueOf(8));
        return arrayList;
    }

    private void m3747a(int i, long j, long j2) throws C1004h {
        C2538c.m12677c("Debug_HiSyncHealthDataByUntie", "downloadEachTypeByTime type is", Integer.valueOf(i), " startTime is ", Long.valueOf(j), " endTime is ", Long.valueOf(j2));
        CloudCommonReponse a = this.f1721a.a(m3754b(i, j, j2));
        if (g.a(a, false)) {
            List detailInfos = a.getDetailInfos();
            if (detailInfos == null || detailInfos.isEmpty()) {
                C2538c.m12679d("Debug_HiSyncHealthDataByUntie", "downloadEachTypeByTime data error type is ", Integer.valueOf(i));
                return;
            }
            m3752a(detailInfos, i, true);
            return;
        }
        C2538c.m12679d("Debug_HiSyncHealthDataByUntie", "downloadEachTypeByTime error type is ", Integer.valueOf(i));
    }

    private GetHealthDataByTimeReq m3754b(int i, long j, long j2) {
        GetHealthDataByTimeReq getHealthDataByTimeReq = new GetHealthDataByTimeReq();
        getHealthDataByTimeReq.setQueryType(Integer.valueOf(2));
        getHealthDataByTimeReq.setDataType(Integer.valueOf(2));
        getHealthDataByTimeReq.setStartTime(Long.valueOf(j));
        getHealthDataByTimeReq.setEndTime(Long.valueOf(j2));
        getHealthDataByTimeReq.setType(Integer.valueOf(i));
        return getHealthDataByTimeReq;
    }

    private void m3763e() throws C1004h {
        this.f1731k = WeightedLatLng.DEFAULT_INTENSITY / ((double) this.f1732l.size());
        for (SyncKey a : this.f1732l) {
            m3749a(a);
        }
    }

    private void m3765f() throws C1004h {
        C2538c.m12677c("Debug_HiSyncHealthDataByUntie", "start downloadTwice()");
        this.f1731k = 0.0d;
        this.f1732l = C1017i.m3898a(this.f1722b, this.f1723c.getSyncMethod(), this.f1733m);
        if (this.f1732l == null || this.f1732l.isEmpty()) {
            C2538c.m12679d("Debug_HiSyncHealthDataByUntie", "downloadTwice error keys");
            return;
        }
        for (SyncKey a : this.f1732l) {
            m3749a(a);
        }
    }

    private void m3749a(SyncKey syncKey) throws C1004h {
        if (syncKey != null) {
            int intValue = syncKey.getType().intValue();
            long longValue = syncKey.getVersion().longValue();
            C2538c.m12677c("Debug_HiSyncHealthDataByUntie", "downloadOneTypeDataByVersion type is ", Integer.valueOf(intValue), " maxVersion is ", Long.valueOf(longValue));
            if (longValue <= 0) {
                C2538c.m12679d("Debug_HiSyncHealthDataByUntie", "downloadOneTypeDataByVersion cloud has no such data ,type is ", Integer.valueOf(intValue));
                return;
            }
            GetHealthDataByVersionReq getHealthDataByVersionReq = new GetHealthDataByVersionReq();
            getHealthDataByVersionReq.setDataType(Integer.valueOf(this.f1723c.getSyncMethod()));
            getHealthDataByVersionReq.setType(Integer.valueOf(intValue));
            com.huawei.hwdatamigrate.hihealth.b.b.b b = this.f1725e.b(this.f1724d, 0, intValue);
            if (b == null) {
                getHealthDataByVersionReq.setVersion(Long.valueOf(0));
                m3748a(getHealthDataByVersionReq, longValue);
            } else if (b.c() < longValue) {
                getHealthDataByVersionReq.setVersion(Long.valueOf(b.c()));
                m3748a(getHealthDataByVersionReq, longValue);
            } else {
                C2538c.m12677c("Debug_HiSyncHealthDataByUntie", "do not need downloadOneTypeDataByVersion data,type is ", Integer.valueOf(intValue), " DBversion is ", Long.valueOf(b.c()), " maxVersion is ", Long.valueOf(longValue));
            }
        }
    }

    private void m3748a(GetHealthDataByVersionReq getHealthDataByVersionReq, long j) throws C1004h {
        C2538c.m12677c("Debug_HiSyncHealthDataByUntie", "downloadOneTypeDataWithMaxVersion rep = ", getHealthDataByVersionReq, " maxVersion = ", Long.valueOf(j));
        int i = 0;
        long b;
        do {
            b = m3753b(getHealthDataByVersionReq, j);
            C2538c.m12677c("Debug_HiSyncHealthDataByUntie", "downloadOneTypeDataWithMaxVersion downCurrentVersion = ", Long.valueOf(b), " maxVersion = ", Long.valueOf(j));
            i++;
            if (b > -1) {
                if (this.f1725e.a(this.f1724d, getHealthDataByVersionReq.getType().intValue(), b, 0)) {
                    getHealthDataByVersionReq.setVersion(Long.valueOf(b));
                    if (i >= 20) {
                        C2538c.m12679d("Debug_HiSyncHealthDataByUntie", "downloadOneTypeDataWithMaxVersion pullDataByVersion too many times.");
                        return;
                    }
                } else {
                    C2538c.m12679d("Debug_HiSyncHealthDataByUntie", "downloadOneTypeDataWithMaxVersion saveVersionToDB failed ");
                    return;
                }
            }
            return;
        } while (b < j);
    }

    private long m3753b(GetHealthDataByVersionReq getHealthDataByVersionReq, long j) throws C1004h {
        CloudCommonReponse a = this.f1721a.a(getHealthDataByVersionReq);
        if (!g.a(a, false)) {
            return -1;
        }
        List detailInfos = a.getDetailInfos();
        if (detailInfos == null || detailInfos.isEmpty()) {
            C2538c.m12679d("Debug_HiSyncHealthDataByUntie", "downOneTypeDataOnce detailInfos is null or empty");
            return -1;
        }
        long longValue = a.getCurrentVersion().longValue();
        if (m3752a(detailInfos, getHealthDataByVersionReq.getType().intValue(), false)) {
            return longValue;
        }
        return -1;
    }

    private boolean m3752a(@NonNull List<HealthDetail> list, int i, boolean z) throws C1004h {
        double size = (double) list.size();
        List arrayList = new ArrayList();
        for (HealthDetail healthDetail : list) {
            if (healthDetail != null) {
                Collection a = this.f1730j.a(healthDetail, this.f1724d);
                if (!(a == null || a.isEmpty())) {
                    C1016h.m3890a(this.f1722b, WeightedLatLng.DEFAULT_INTENSITY / size, this.f1731k, 10.0d);
                    if (C1017i.m3901a() && !z && m3768i(i)) {
                        C1005a.m3720a(this.f1722b, a, 10001, this.f1724d);
                    } else {
                        this.f1729i.a(a, this.f1724d);
                        if (i == 7 || i == 3 || i == 9) {
                            arrayList.addAll(a);
                        }
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.f1729i.c(arrayList);
            this.f1729i.b();
        }
        return true;
    }

    private void m3750a(List<HiHealthData> list) {
        if (list != null && !list.isEmpty()) {
            for (HiHealthData hiHealthData : list) {
                this.f1726f.a(hiHealthData.getDataID(), hiHealthData.getLong("modified_time"), 1);
            }
        }
    }

    private void m3756b(List<HiHealthData> list) {
        if (list != null && !list.isEmpty()) {
            for (HiHealthData hiHealthData : list) {
                long startTime = hiHealthData.getStartTime();
                long endTime = hiHealthData.getEndTime();
                int clientID = hiHealthData.getClientID();
                this.f1726f.a(clientID, startTime, endTime, IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION, 1);
                this.f1726f.a(clientID, startTime, endTime, IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_NULLPOINTEREXCEPTION, 1);
            }
        }
    }

    private void m3759c(List<HiHealthData> list) {
        if (list != null && !list.isEmpty()) {
            for (HiHealthData hiHealthData : list) {
                this.f1727g.a(hiHealthData.getDataID(), hiHealthData.getLong("modified_time"), 1);
            }
        }
    }

    private boolean m3751a(List<HiHealthData> list, int i, int i2) throws C1004h {
        int i3 = this.f1734n + 1;
        this.f1734n = i3;
        C1017i.m3899a(i3, this.f1723c.getSyncAction());
        List a = this.f1730j.a(list, i, i2);
        if (a == null || a.isEmpty()) {
            C2538c.m12679d("Debug_HiSyncHealthDataByUntie", "addHealthData healthDetails is null or empty cloudType is ", Integer.valueOf(i2), " clientId is ", Integer.valueOf(i));
            return false;
        }
        AddHealthDataReq addHealthDataReq = new AddHealthDataReq();
        addHealthDataReq.setDetailInfo(a);
        addHealthDataReq.setTimeZone(((HiHealthData) list.get(0)).getTimeZone());
        while (this.f1735o < 2) {
            if (g.a(this.f1721a.a(addHealthDataReq), false)) {
                C2538c.m12677c("Debug_HiSyncHealthDataByUntie", "addDataToCloud OK ! uploadCount is ", Integer.valueOf(this.f1734n), " type is ", Integer.valueOf(i2));
                return true;
            }
            this.f1735o++;
        }
        C2538c.m12677c("Debug_HiSyncHealthDataByUntie", "addDataToCloud failed ! uploadCount is ", Integer.valueOf(this.f1734n), " type is ", Integer.valueOf(i2));
        return false;
    }

    private void m3746a(int i) throws C1004h {
        while (this.f1735o < 2) {
            List f = m3764f(i);
            if (f == null || f.isEmpty() || !m3751a(f, i, 0)) {
                break;
            }
            m3750a(f);
        }
        this.f1735o = 0;
    }

    private void m3755b(int i) throws C1004h {
        while (this.f1735o < 2) {
            List c = m3757c(i);
            if (c == null || c.isEmpty() || !m3751a(c, i, 9)) {
                break;
            }
            m3759c(c);
        }
        this.f1735o = 0;
    }

    private List<HiHealthData> m3757c(int i) {
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(22101));
        arrayList.add(Integer.valueOf(22102));
        arrayList.add(Integer.valueOf(22103));
        arrayList.add(Integer.valueOf(22104));
        arrayList.add(Integer.valueOf(22105));
        return this.f1727g.a(i, arrayList, 200);
    }

    private void m3761d(int i) throws C1004h {
        while (this.f1735o < 2) {
            List e = m3762e(i);
            if (e == null || e.isEmpty() || !m3751a(e, i, 7)) {
                break;
            }
            m3750a(e);
        }
        this.f1735o = 0;
    }

    private List<HiHealthData> m3762e(int i) {
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(2002));
        arrayList.add(Integer.valueOf(2018));
        return this.f1726f.a(i, arrayList, 200);
    }

    private List<HiHealthData> m3764f(int i) {
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(2001));
        arrayList.add(Integer.valueOf(2004));
        arrayList.add(Integer.valueOf(2015));
        arrayList.add(Integer.valueOf(IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_EXCEPTION));
        arrayList.add(Integer.valueOf(2009));
        arrayList.add(Integer.valueOf(2010));
        arrayList.add(Integer.valueOf(TradeCode.ALIPAY_ONE_KEY_SIGN));
        arrayList.add(Integer.valueOf(2012));
        arrayList.add(Integer.valueOf(2013));
        arrayList.add(Integer.valueOf(2014));
        return this.f1726f.a(i, arrayList, 50);
    }

    private void m3766g(int i) throws C1004h {
        while (this.f1735o < 2) {
            List h = m3767h(i);
            if (h == null || h.isEmpty() || !m3751a(h, i, 5)) {
                break;
            }
            m3756b(h);
        }
        this.f1735o = 0;
    }

    private List<HiHealthData> m3767h(int i) {
        return this.f1728h.a(i, 50, new int[]{IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION, IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_NULLPOINTEREXCEPTION}, new String[]{"bloodpressure_diastolic", "bloodpressure_systolic"}, 1);
    }

    private boolean m3768i(int i) {
        switch (i) {
            case 7:
                return true;
            default:
                return false;
        }
    }

    public void mo2311a() throws C1004h {
        C2538c.m12677c("Debug_HiSyncHealthDataByUntie", "pullDataByVersion() begin !");
        C1016h.m3888a(10.0d, "SYNC_HEALTH_DATA_DOWNLOAD_PERCENT_MAX_ALL");
        C2538c.m12677c("Debug_HiSyncHealthDataByUntie", "pullDataByVersion() keys is ", this.f1732l);
        if (this.f1732l == null || this.f1732l.isEmpty()) {
            C2538c.m12679d("Debug_HiSyncHealthDataByUntie", "pullDataByVersion() keys is null,stop pullDataByVersion");
        } else {
            m3763e();
        }
        C1016h.m3889a(this.f1722b);
        C2538c.m12677c("Debug_HiSyncHealthDataByUntie", "pullDataByVersion() end !");
    }

    public void mo2312a(long j, long j2) throws C1004h {
        if (this.f1732l == null || this.f1732l.isEmpty()) {
            C2538c.m12679d("Debug_HiSyncHealthDataByUntie", "pullDataByTime() keys is null,stop pullDataByVersion");
            return;
        }
        for (SyncKey syncKey : this.f1732l) {
            int intValue = syncKey.getType().intValue();
            C2538c.m12677c("Debug_HiSyncHealthDataByUntie", "pullDataByTime type is ", Integer.valueOf(intValue), " maxVersion is ", Long.valueOf(syncKey.getVersion().longValue()));
            if (syncKey.getVersion().longValue() <= 0) {
                C2538c.m12679d("Debug_HiSyncHealthDataByUntie", "pullDataByTime cloud has no such data ,type is ", Integer.valueOf(intValue));
            } else if (intValue == 7) {
                this.f1731k = WeightedLatLng.DEFAULT_INTENSITY;
                m3747a(intValue, j, j2);
            }
        }
    }

    public void mo2313b() throws C1004h {
        C2538c.m12674b("Debug_HiSyncHealthDataByUntie", "pushData() begin !");
        if (C1015e.m3862b()) {
            C1016h.m3888a(5.0d, "SYNC_HEALTH_DATA_UPLOAD_PERCENT_MAX");
            List<Integer> d = com.huawei.hwdatamigrate.hihealth.c.g.a(this.f1722b).d(this.f1724d);
            if (d == null || d.isEmpty()) {
                C2538c.m12679d("Debug_HiSyncHealthDataByUntie", "pushData() end ! no client get, maybe no data need to pushData");
                return;
            }
            int size = d.size();
            for (Integer num : d) {
                m3746a(num.intValue());
                m3755b(num.intValue());
                m3766g(num.intValue());
                m3761d(num.intValue());
            }
            m3765f();
            c.a(this.f1722b, this.f1724d);
            C1016h.m3890a(this.f1722b, WeightedLatLng.DEFAULT_INTENSITY, WeightedLatLng.DEFAULT_INTENSITY / ((double) size), 5.0d);
            C1016h.m3889a(this.f1722b);
            C2538c.m12677c("Debug_HiSyncHealthDataByUntie", "pushData() end !");
            return;
        }
        C2538c.m12679d("Debug_HiSyncHealthDataByUntie", "pushData() dataPrivacy switch is closed ,can not pushData right now ,push end !");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("--HiSyncHealthDataByUntie{");
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
