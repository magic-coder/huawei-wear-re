package com.huawei.pluginkidwatch.plugin.feature.newsport;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1413d;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.HealthData;
import com.huawei.pluginkidwatch.common.entity.model.HealthDataIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.MovePointData;
import com.huawei.pluginkidwatch.common.entity.model.SegmentMoveData;
import com.huawei.pluginkidwatch.common.lib.utils.C1485e;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1399o;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: AsyncGetCloudNewData */
public abstract class C1806a extends AsyncTask<String, Object, Void> {
    private String f4988a = "AsyncGetCloudNewData";
    private boolean f4989b = false;
    private Context f4990c;
    private C1413d f4991d;
    private Date f4992e;
    private int f4993f = 6;
    private int[] f4994g = new int[1440];
    private int[] f4995h = new int[1440];

    public abstract void mo2604a();

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m8643a((String[]) objArr);
    }

    public C1806a(Context context, C1413d c1413d, Date date) {
        this.f4990c = context;
        this.f4991d = c1413d;
        this.f4992e = new Date(date.getTime());
    }

    protected Void m8643a(String... strArr) {
        m8641b();
        return null;
    }

    protected void onProgressUpdate(Object... objArr) {
        C1497q.m6943a(this.f4990c, "sharedpreferences_sport_isfirst_show", C1485e.m6861c());
        if (this.f4989b) {
            mo2604a();
        }
    }

    private void m8641b() {
        HealthDataIOEntityModel healthDataIOEntityModel = new HealthDataIOEntityModel();
        String j = C1462f.m6746j();
        if ("".equals(j)) {
            j = C1497q.m6945b(this.f4990c, "sharedpreferences_watch_device_code", "");
            C1462f.m6731d(j);
            C2538c.m12674b(this.f4988a, "===www123=====SharedPreferencesUtil getDeviceInfo null======" + j);
        }
        C2538c.m12674b(this.f4988a, "===www123=====getDeviceCode======" + j);
        C2538c.m12674b(this.f4988a, "========getCloudData======");
        String a = C1485e.m6849a(this.f4992e, "yyyyMMdd");
        String c = C1392h.m6299c(this.f4990c, j, a);
        if (c == null || "".equals(c)) {
            this.f4993f = 6;
        } else {
            this.f4993f = C1485e.m6845a(a, c) + 1;
            if (this.f4993f > 6) {
                this.f4993f = 6;
            }
        }
        C2538c.m12674b(this.f4988a, "========getCloudData=====daysCount:" + this.f4993f);
        C2538c.m12674b(this.f4988a, "===www123=====getCloudData=====deviceCode:" + j);
        healthDataIOEntityModel.deviceCode = j;
        healthDataIOEntityModel.daysCount = String.valueOf(this.f4993f);
        healthDataIOEntityModel.daysEnd = a;
        this.f4991d.mo2489a(healthDataIOEntityModel, new C1807b(this, j, a));
    }

    private void m8639a(List<C1399o> list, String str) {
        C2538c.m12674b(this.f4988a, "=========intoDB========");
        this.f4989b = false;
        for (C1399o c1399o : list) {
            if (c1399o.m6363b().equals(str)) {
                this.f4989b = true;
            }
            C1392h.m6293b(this.f4990c, c1399o);
        }
    }

    private List<C1399o> m8640b(List<HealthData> list, String str) {
        List<C1399o> arrayList = new ArrayList();
        for (HealthData healthData : list) {
            C2538c.m12674b(this.f4988a, "=======CloudDayData  for Day:" + healthData.toString());
            C1399o c1399o = new C1399o();
            C1399o c1399o2 = new C1399o();
            c1399o.m6361a(C1492l.m6920d(str));
            c1399o2.m6361a(C1492l.m6920d(str));
            c1399o.m6362a(healthData.logDate);
            c1399o2.m6362a(healthData.logDate);
            c1399o.m6364b(1);
            c1399o2.m6364b(2);
            for (SegmentMoveData segmentMoveData : healthData.segmentMoveDatas) {
                String str2 = segmentMoveData.startTime;
                int f = C1485e.m6869f(str2) + (C1485e.m6868e(str2) * 60);
                if (f >= 360 && f <= 1320) {
                    for (MovePointData movePointData : segmentMoveData.movePointDatas) {
                        int i;
                        int i2;
                        int i3;
                        int i4;
                        if (1 == movePointData.move_type) {
                            i2 = 0;
                            i3 = f;
                            while (i2 < movePointData.move_points.size()) {
                                if (i2 < 10) {
                                    c1399o.m6367c(((Integer) movePointData.move_points.get(i2)).intValue() + c1399o.m6372e());
                                    i4 = i3 + 1;
                                    this.f4994g[i3] = ((Integer) movePointData.move_points.get(i2)).intValue();
                                    if (((Integer) movePointData.move_points.get(i2)).intValue() != 0) {
                                        c1399o.m6373e(c1399o.m6378g() + 1);
                                        i3 = i4;
                                    } else {
                                        i3 = i4;
                                    }
                                } else if (i2 >= 20 || i2 < 10) {
                                    c1399o.m6370d(((Integer) movePointData.move_points.get(i2)).intValue() + c1399o.m6375f());
                                } else {
                                    c1399o.m6376f(((Integer) movePointData.move_points.get(i2)).intValue() + c1399o.m6380h());
                                }
                                i2++;
                            }
                            i = i3;
                        } else if (2 == movePointData.move_type) {
                            i2 = 0;
                            i3 = f;
                            while (i2 < movePointData.move_points.size()) {
                                if (i2 < 10) {
                                    c1399o2.m6367c(((Integer) movePointData.move_points.get(i2)).intValue() + c1399o2.m6372e());
                                    i4 = i3 + 1;
                                    this.f4995h[i3] = ((Integer) movePointData.move_points.get(i2)).intValue();
                                    if (((Integer) movePointData.move_points.get(i2)).intValue() != 0) {
                                        c1399o2.m6373e(c1399o2.m6378g() + 1);
                                        i3 = i4;
                                    } else {
                                        i3 = i4;
                                    }
                                } else if (i2 >= 20 || i2 < 10) {
                                    c1399o2.m6370d(((Integer) movePointData.move_points.get(i2)).intValue() + c1399o2.m6375f());
                                } else {
                                    c1399o2.m6376f(((Integer) movePointData.move_points.get(i2)).intValue() + c1399o2.m6380h());
                                }
                                i2++;
                            }
                            i = i3;
                        } else {
                            i = f;
                        }
                        f = i;
                    }
                }
            }
            c1399o.m6365b(m8636a(this.f4994g));
            c1399o2.m6365b(m8636a(this.f4995h));
            arrayList.add(c1399o);
            arrayList.add(c1399o2);
            this.f4994g = new int[1440];
            this.f4995h = new int[1440];
        }
        return arrayList;
    }

    private String m8636a(int[] iArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iArr.length; i++) {
            stringBuffer.append(iArr[i]);
            if (i != iArr.length - 1) {
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }
}
