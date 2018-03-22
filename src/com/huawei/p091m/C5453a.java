package com.huawei.p091m;

import com.android.volley.DefaultRetryPolicy;
import com.huawei.al.C4028a;
import com.huawei.coresleepresult.p381a.C4360b;
import com.huawei.coresleepresult.p381a.C4362d;
import com.huawei.hihealth.HiDataInsertOption;
import com.huawei.hihealth.HiHealthData;
import com.huawei.hihealth.a.b;
import com.huawei.hihealth.p394c.C4540b;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.m.d;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: CoreSleepMgrStorage */
public class C5453a {
    private static C5453a f19295c = null;
    List<HiHealthData> f19296a;
    List<HiHealthData> f19297b;

    public static C5453a m26129a() {
        C2538c.c("CoreSleepMgrStorage", new Object[]{"get instance"});
        if (f19295c == null) {
            f19295c = new C5453a();
        }
        return f19295c;
    }

    private C5453a() {
    }

    private void m26134b(d dVar, List<C4360b> list) {
        C2538c.c("CoreSleepMgrStorage", new Object[]{"saveTotalSleepCalcFrame"});
        if (list == null || list.size() == 0) {
            C2538c.c("CoreSleepMgrStorage", new Object[]{"currCalcFrameList size = 0"});
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            m26130a(dVar, (C4360b) list.get(i));
        }
    }

    private void m26130a(d dVar, C4360b c4360b) {
        C2538c.c("CoreSleepMgrStorage", new Object[]{"saveSleepCalcFrame"});
        if (c4360b.m20970g() == DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            m26136c(dVar, c4360b);
            m26142i(dVar, c4360b);
            m26141h(dVar, c4360b);
            return;
        }
        m26136c(dVar, c4360b);
        m26137d(dVar, c4360b);
        m26133b(dVar, c4360b);
        m26138e(dVar, c4360b);
        m26139f(dVar, c4360b);
        m26140g(dVar, c4360b);
        m26141h(dVar, c4360b);
        m26142i(dVar, c4360b);
        m26143j(dVar, c4360b);
    }

    private void m26133b(d dVar, C4360b c4360b) {
        HiHealthData hiHealthData = new HiHealthData();
        hiHealthData.setType(44207);
        hiHealthData.setDeviceUUID(C4028a.m19823a());
        hiHealthData.setStartTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setEndTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setValue(c4360b.m20971h());
        this.f19296a.add(hiHealthData);
    }

    private void m26136c(d dVar, C4360b c4360b) {
        HiHealthData hiHealthData = new HiHealthData();
        hiHealthData.setType(44201);
        hiHealthData.setDeviceUUID(C4028a.m19823a());
        hiHealthData.setStartTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setEndTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setValue((double) c4360b.m20958b());
        this.f19296a.add(hiHealthData);
    }

    private void m26137d(d dVar, C4360b c4360b) {
        HiHealthData hiHealthData = new HiHealthData();
        hiHealthData.setType(44205);
        hiHealthData.setDeviceUUID(C4028a.m19823a());
        hiHealthData.setStartTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setEndTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setValue((double) c4360b.m20969f());
        this.f19296a.add(hiHealthData);
    }

    private void m26138e(d dVar, C4360b c4360b) {
        HiHealthData hiHealthData = new HiHealthData();
        hiHealthData.setType(44204);
        hiHealthData.setDeviceUUID(C4028a.m19823a());
        hiHealthData.setStartTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setEndTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setValue(c4360b.m20967e());
        this.f19296a.add(hiHealthData);
    }

    private void m26139f(d dVar, C4360b c4360b) {
        HiHealthData hiHealthData = new HiHealthData();
        hiHealthData.setType(44203);
        hiHealthData.setDeviceUUID(C4028a.m19823a());
        hiHealthData.setStartTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setEndTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setValue(c4360b.m20964d());
        this.f19296a.add(hiHealthData);
    }

    private void m26140g(d dVar, C4360b c4360b) {
        HiHealthData hiHealthData = new HiHealthData();
        hiHealthData.setType(44208);
        hiHealthData.setDeviceUUID(C4028a.m19823a());
        hiHealthData.setStartTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setEndTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setValue(c4360b.m20973j());
        this.f19296a.add(hiHealthData);
    }

    private void m26141h(d dVar, C4360b c4360b) {
        HiHealthData hiHealthData = new HiHealthData();
        hiHealthData.setType(44206);
        hiHealthData.setDeviceUUID(C4028a.m19823a());
        hiHealthData.setStartTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setEndTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setValue(c4360b.m20970g());
        this.f19296a.add(hiHealthData);
    }

    private void m26142i(d dVar, C4360b c4360b) {
        HiHealthData hiHealthData = new HiHealthData();
        hiHealthData.setType(44202);
        hiHealthData.setDeviceUUID(C4028a.m19823a());
        hiHealthData.setStartTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setEndTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setValue((double) c4360b.m20961c());
        this.f19296a.add(hiHealthData);
    }

    private void m26143j(d dVar, C4360b c4360b) {
        C2538c.c("CoreSleepMgrStorage", new Object[]{"updateDeepPartCount:", Integer.valueOf(c4360b.m20972i())});
        HiHealthData hiHealthData = new HiHealthData();
        hiHealthData.setType(44106);
        hiHealthData.setDeviceUUID(C4028a.m19823a());
        hiHealthData.setStartTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setEndTime(C4540b.m21757e(c4360b.m20954a()));
        hiHealthData.setValue((double) c4360b.m20972i());
        this.f19296a.add(hiHealthData);
    }

    public void m26145a(d dVar, List<C4362d> list) {
        C2538c.c("CoreSleepMgrStorage", new Object[]{"saveSleepStatusFrameList"});
        if (list == null || list.size() == 0) {
            C2538c.c("CoreSleepMgrStorage", new Object[]{"sleepStatusFrameList size = 0"});
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            m26131a(dVar, (C4362d) list.get(i));
        }
    }

    private void m26131a(d dVar, C4362d c4362d) {
        C2538c.c("CoreSleepMgrStorage", new Object[]{"saveStatusFrame"});
        List c = c4362d.m20984c();
        c.c("CoreSleepMgrStorage", new Object[]{"list size = " + c.size()});
        long e = C4540b.m21757e(c4362d.m20979a());
        c.c("CoreSleepMgrStorage", new Object[]{"start time = " + e + "  ---end time = " + c4362d.m20982b()});
        for (int i = 0; i < c.size(); i++) {
            if (e < C4540b.m21757e(c4362d.m20982b())) {
                HiHealthData hiHealthData = new HiHealthData(m26128a(((Integer) c.get(i)).intValue()));
                hiHealthData.setTimeInterval(e, e + FileWatchdog.DEFAULT_DELAY);
                hiHealthData.setDeviceUUID(C4028a.m19823a());
                this.f19297b.add(hiHealthData);
                e += FileWatchdog.DEFAULT_DELAY;
            }
        }
    }

    private int m26128a(int i) {
        switch (i) {
            case 1:
                return 22101;
            case 2:
                return 22102;
            case 3:
                return 22103;
            case 4:
                return 22104;
            case 5:
                return 22105;
            default:
                return 0;
        }
    }

    public void m26146a(d dVar, List<C4360b> list, List<C4362d> list2) {
        if (list2 == null || list2.size() == 0) {
            C2538c.c("CoreSleepMgrStorage", new Object[]{"sleepStatusFrameList.size() = 0"});
            dVar.a();
            return;
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        int i;
        if (list != null && list.size() != 0) {
            for (i = 0; i < list.size(); i++) {
                arrayList2.add(i, list.get(i));
            }
            for (i = 0; i < list2.size(); i++) {
                arrayList.add(i, list2.get(i));
            }
            C2538c.c("CoreSleepMgrStorage", new Object[]{"sleepCalcFrameList size > 0, sleepStatusFrameList size > 0"});
        } else if (m26147a((List) list2)) {
            C2538c.c("CoreSleepMgrStorage", new Object[]{"mSleepCalcFramesList size = 0, Has Night Sleep, Can not save sleep data"});
            dVar.a();
            return;
        } else {
            for (i = 0; i < list2.size(); i++) {
                arrayList.add(list2.get(i));
            }
            C2538c.c("CoreSleepMgrStorage", new Object[]{"mSleepCalcFramesList size = 0, No Night Sleep, Only save  noon sleep data"});
        }
        m26148b();
        m26145a(dVar, arrayList);
        m26134b(dVar, arrayList2);
        m26144a(dVar);
    }

    void m26148b() {
        this.f19296a = new ArrayList();
        this.f19297b = new ArrayList();
    }

    public void m26144a(d dVar) {
        C2538c.c("CoreSleepMgrStorage", new Object[]{"saveCoreSleepDataToHiHealth enter calcFrameList.size:" + this.f19296a.size() + " statusFrameList.size:" + this.f19297b.size()});
        m26132b(dVar);
        m26135c(dVar);
    }

    private void m26132b(d dVar) {
        C2538c.c("CoreSleepMgrStorage", new Object[]{"saveCoreSleepDataToHiHealth enter statusFrameList" + this.f19297b});
        HiDataInsertOption hiDataInsertOption = new HiDataInsertOption();
        hiDataInsertOption.setDatas(this.f19297b);
        b.a(BaseApplication.b()).a(hiDataInsertOption, new C5454b(this, dVar));
    }

    private void m26135c(d dVar) {
        C2538c.c("CoreSleepMgrStorage", new Object[]{"saveCoreSleepDataToHiHealth enter calcFrameList" + this.f19296a});
        HiDataInsertOption hiDataInsertOption = new HiDataInsertOption();
        hiDataInsertOption.setDatas(this.f19296a);
        b.a(BaseApplication.b()).a(hiDataInsertOption, new C5455c(this, dVar));
    }

    public boolean m26147a(List<C4362d> list) {
        for (int i = 0; i < list.size(); i++) {
            if (((Integer) ((C4362d) list.get(i)).m20984c().get(0)).intValue() != 5) {
                return true;
            }
        }
        return false;
    }
}
