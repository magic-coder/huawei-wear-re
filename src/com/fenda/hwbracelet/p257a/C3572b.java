package com.fenda.hwbracelet.p257a;

import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.android.volley.DefaultRetryPolicy;
import com.fenda.hwbracelet.mode.C3629l;
import com.huawei.p032e.p264a.p265a.p385a.C4383a;
import com.huawei.p032e.p264a.p265a.p385a.C4384b;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: SyncDataParser */
public class C3572b {
    private static boolean f13672a = false;
    private static long f13673b = 0;
    private static int f13674c = 0;

    public static ArrayList<C4384b> m17927a(ArrayList<C3629l> arrayList, int i, int i2) {
        f13673b = 0;
        if (arrayList == null) {
            C2538c.e("SyncDataParser", new Object[]{"syncDataList is null"});
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            C3629l c3629l = (C3629l) arrayList.get(i3);
            C2538c.c("SyncDataParser", new Object[]{"step: " + c3629l.m18199b() + "time: " + c3629l.m18198a()});
            if (c3629l.m18200c() == 0 && c3629l.m18199b() > 0) {
                C4384b c4384b = new C4384b();
                c4384b.m21055a((c3629l.m18198a() / FileWatchdog.DEFAULT_DELAY) * FileWatchdog.DEFAULT_DELAY);
                c4384b.m21054a(c3629l.m18199b());
                c4384b.m21057b(C3572b.m17925a(c3629l.m18199b(), 60000, i, i2));
                c4384b.m21053a(C3572b.m17929b(c3629l.m18199b(), 60000, i, i2));
                arrayList2.add(c4384b);
            }
        }
        return C3572b.m17930b(arrayList2);
    }

    public static ArrayList<C4383a> m17926a(ArrayList<C3629l> arrayList) {
        f13672a = false;
        f13674c = 0;
        f13673b = 0;
        if (arrayList == null) {
            C2538c.e("SyncDataParser", new Object[]{"syncDataList没数据"});
            return null;
        }
        int size;
        C4383a c4383a;
        Collections.sort(arrayList, new C3573c());
        List arrayList2 = new ArrayList();
        ArrayList<C4383a> arrayList3 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            C3629l c3629l = (C3629l) arrayList.get(i);
            if (c3629l.m18200c() == 1) {
                if (!f13672a) {
                    f13672a = true;
                    f13674c = arrayList2.size();
                    f13673b = c3629l.m18198a();
                }
                C3571a c3571a = new C3571a();
                c3571a.m17924a(f13673b, 0, c3629l.m18198a(), c3629l.m18199b());
                arrayList2.add(c3571a);
            } else if (c3629l.m18200c() == 0 && f13672a) {
                f13672a = false;
                C3572b.m17928a(arrayList2, (ArrayList) arrayList3, f13674c, c3629l.m18198a() - FileWatchdog.DEFAULT_DELAY);
            }
        }
        if (f13672a) {
            f13672a = false;
            C2538c.c("SyncDataParser", new Object[]{"endTime: " + ((Calendar.getInstance().getTimeInMillis() / FileWatchdog.DEFAULT_DELAY) * FileWatchdog.DEFAULT_DELAY)});
            C3572b.m17928a(arrayList2, (ArrayList) arrayList3, f13674c, r0);
        }
        for (size = arrayList3.size() - 1; size > 0; size--) {
            c4383a = (C4383a) arrayList3.get(size - 1);
            if (((C4383a) arrayList3.get(size)).m21048a() == c4383a.m21048a()) {
                c4383a.m21049a(((C4383a) arrayList3.get(size)).m21051b() + c4383a.m21051b());
                arrayList3.remove(size);
            }
        }
        for (size = 0; size < arrayList3.size(); size++) {
            ((C4383a) arrayList3.get(size)).m21049a(((C4383a) arrayList3.get(size)).m21051b() + 7);
        }
        C3572b.m17931c(arrayList3);
        C3572b.m17932d(arrayList3);
        c4383a = new C4383a();
        for (int i2 = 0; i2 < arrayList3.size(); i2++) {
            c4383a = (C4383a) arrayList3.get(i2);
        }
        return arrayList3;
    }

    private static void m17928a(List<C3571a> list, ArrayList<C4383a> arrayList, int i, long j) {
        if (list != null && list.size() - i > 0 && arrayList != null) {
            int size;
            for (size = list.size() - 1; size >= i; size--) {
                C3571a c3571a = (C3571a) list.get(size);
                if (j < c3571a.f13668a || j < c3571a.f13670c) {
                    C2538c.e("SyncDataParser", new Object[]{"eTime: " + j + ", sTime: " + c3571a.f13668a + ", mTime: " + c3571a.f13670c});
                    list.remove(size);
                } else {
                    c3571a.f13669b = j;
                }
            }
            if (list == null || list.size() - i <= 0) {
                C2538c.e("SyncDataParser", new Object[]{"error! list.size() == currentSize"});
                return;
            }
            int i2;
            int i3;
            int i4;
            long j2 = (((C3571a) list.get(i)).f13668a / 200000) * 200000;
            ArrayList arrayList2 = new ArrayList();
            if (list.size() > i && j > j2) {
                i2 = (int) ((((j / 200000) * 200000) - j2) / 200000);
                i3 = 0;
                while (i3 <= i2) {
                    C4383a c4383a = new C4383a(((long) (200000 * i3)) + j2, 0);
                    for (size = list.size() - 1; size >= i; size--) {
                        long j3 = ((C3571a) list.get(size)).f13670c;
                        if (j3 >= ((long) (200000 * i3)) + j2 && j3 < ((long) ((i3 + 1) * 200000)) + j2) {
                            c4383a.m21049a((((C3571a) list.get(size)).f13671d * 3) + c4383a.m21051b());
                        }
                    }
                    arrayList2.add(c4383a);
                    i3++;
                }
            }
            i2 = 0;
            i3 = 0;
            if (arrayList2.size() > 0) {
                if (arrayList2.size() <= 3) {
                    for (size = 0; size < arrayList2.size(); size++) {
                        ((C4383a) arrayList2.get(size)).m21049a(100);
                    }
                    i4 = 0;
                    if (i2 > 18) {
                        for (size = i4; size < arrayList2.size(); size++) {
                            ((C4383a) arrayList2.get(size)).m21049a(100);
                        }
                    }
                    i3 = 0;
                    for (size = 0; size < arrayList2.size(); size++) {
                        if (((C4383a) arrayList2.get(size)).m21051b() < 50) {
                            i3++;
                        }
                    }
                    for (size = 0; size < arrayList2.size(); size++) {
                        if (i3 <= 3) {
                            ((C4383a) arrayList2.get(size)).m21049a(100);
                        }
                        arrayList.add(arrayList2.get(size));
                    }
                } else if (arrayList2.size() >= 20) {
                    for (size = 0; size < arrayList2.size(); size++) {
                        C2538c.c("SyncDataParser", new Object[]{"i: " + size + ", frequency: " + ((C4383a) arrayList2.get(size)).m21051b()});
                        if (((C4383a) arrayList2.get(size)).m21051b() == 0) {
                            i2++;
                        } else {
                            if (i2 >= 20) {
                                while (i3 < size) {
                                    ((C4383a) arrayList2.get(i3)).m21049a(100);
                                    i3++;
                                }
                            }
                            i3 = size + 1;
                            i2 = 0;
                        }
                    }
                }
            }
            i4 = i3;
            if (i2 > 18) {
                for (size = i4; size < arrayList2.size(); size++) {
                    ((C4383a) arrayList2.get(size)).m21049a(100);
                }
            }
            i3 = 0;
            for (size = 0; size < arrayList2.size(); size++) {
                if (((C4383a) arrayList2.get(size)).m21051b() < 50) {
                    i3++;
                }
            }
            for (size = 0; size < arrayList2.size(); size++) {
                if (i3 <= 3) {
                    ((C4383a) arrayList2.get(size)).m21049a(100);
                }
                arrayList.add(arrayList2.get(size));
            }
        }
    }

    private static ArrayList<C4384b> m17930b(ArrayList<C4384b> arrayList) {
        if (arrayList.size() > 0) {
            for (int size = arrayList.size() - 1; size > 0; size--) {
                C4384b c4384b = (C4384b) arrayList.get(size - 1);
                if (((C4384b) arrayList.get(size)).m21052a() == c4384b.m21052a()) {
                    c4384b.m21054a(((C4384b) arrayList.get(size)).m21056b() + c4384b.m21056b());
                    c4384b.m21057b(((C4384b) arrayList.get(size)).m21058c() + c4384b.m21058c());
                    c4384b.m21053a(((C4384b) arrayList.get(size)).m21059d() + c4384b.m21059d());
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }

    public static int m17925a(int i, int i2, int i3, int i4) {
        float f = (((((float) i) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) * 1000.0f) * 60.0f) / ((float) i2);
        if (f < 60.0f) {
            f = (((float) i3) / 100.0f) / 5.0f;
        } else if (f < 90.0f) {
            f = (((float) i3) / 100.0f) / 4.0f;
        } else if (f < BitmapDescriptorFactory.HUE_GREEN) {
            f = (((float) i3) / 100.0f) / 3.0f;
        } else if (f < 150.0f) {
            f = (((float) i3) / 100.0f) / 2.0f;
        } else if (f < BitmapDescriptorFactory.HUE_CYAN) {
            f = (((float) i3) / 100.0f) / 1.2f;
        } else if (f < BitmapDescriptorFactory.HUE_BLUE) {
            f = ((float) i3) / 100.0f;
        } else {
            f = (1.1f * ((float) i3)) / 100.0f;
        }
        return (int) (f * ((float) i));
    }

    public static float m17929b(int i, int i2, int i3, int i4) {
        float f;
        float f2 = (((((float) i) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) * 1000.0f) * 60.0f) / ((float) i2);
        if (f2 < 60.0f) {
            f = (((float) i3) / 100.0f) / 5.0f;
        } else if (f2 < 90.0f) {
            f = (((float) i3) / 100.0f) / 4.0f;
        } else if (f2 < BitmapDescriptorFactory.HUE_GREEN) {
            f = (((float) i3) / 100.0f) / 3.0f;
        } else if (f2 < 150.0f) {
            f = (((float) i3) / 100.0f) / 2.0f;
        } else if (f2 < BitmapDescriptorFactory.HUE_CYAN) {
            f = (((float) i3) / 100.0f) / 1.2f;
        } else if (f2 < BitmapDescriptorFactory.HUE_BLUE) {
            f = ((float) i3) / 100.0f;
        } else {
            f = (1.1f * ((float) i3)) / 100.0f;
        }
        return ((f * (f2 * (4.5f * ((float) i4)))) * ((float) i2)) / 2.16E8f;
    }

    private static void m17931c(ArrayList<C4383a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (((C4383a) arrayList.get(i3)).m21051b() < 10) {
                    i++;
                } else {
                    C2538c.c("SyncDataParser", new Object[]{"size: " + i});
                    if (i < 4 && i > 0) {
                        while (i2 < i3) {
                            ((C4383a) arrayList.get(i2)).m21049a(((C4383a) arrayList.get(i2)).m21051b() + 20);
                            i2++;
                        }
                    }
                    i = 0;
                    i2 = i3;
                }
            }
        }
    }

    private static void m17932d(ArrayList<C4383a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (((C4383a) arrayList.get(i3)).m21051b() >= 50) {
                    i++;
                } else {
                    C2538c.c("SyncDataParser", new Object[]{"size: " + i});
                    if (i < 2 && i > 0) {
                        while (i2 < i3) {
                            ((C4383a) arrayList.get(i2)).m21049a(20);
                            i2++;
                        }
                    }
                    i = 0;
                    i2 = i3;
                }
            }
        }
    }
}
