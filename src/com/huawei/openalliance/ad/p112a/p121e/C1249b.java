package com.huawei.openalliance.ad.p112a.p121e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.huawei.openalliance.ad.inter.constant.EventType;
import com.huawei.openalliance.ad.p112a.p113a.C1238e;
import com.huawei.openalliance.ad.p112a.p113a.C1240g;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1212b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1216b;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1221g;
import com.huawei.openalliance.ad.p112a.p116b.C1243a;
import com.huawei.openalliance.ad.p112a.p122h.C1285c;
import com.huawei.openalliance.ad.p112a.p122h.C1286d;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p125g.C1277a;
import com.huawei.openalliance.ad.p112a.p125g.C1279c;
import com.huawei.openalliance.ad.p112a.p125g.C1281e;
import com.huawei.openalliance.ad.utils.C1366j;
import com.huawei.openalliance.ad.utils.db.C1357a;
import com.huawei.openalliance.ad.utils.db.bean.AdEventRecord;
import com.huawei.openalliance.ad.utils.db.bean.ThirdPartyEventRecord;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C1249b {
    private static Map<Integer, C1277a> f2667a = new HashMap();

    static {
        f2667a.put(Integer.valueOf(1), new C1281e());
        f2667a.put(Integer.valueOf(2), new C1279c());
    }

    public static C1216b m5530a(String str, int i, int i2, C1221g c1221g) {
        if (c1221g == null) {
            return null;
        }
        return new C1216b(str, c1221g.getShowid__(), i, i2, c1221g.getParamfromserver__());
    }

    public static C1216b m5531a(String str, C1221g c1221g) {
        return C1249b.m5530a(str, 0, 0, c1221g);
    }

    public static void m5532a(Context context) {
        if (context != null) {
            C1249b.m5543d(context);
        }
    }

    public static void m5534a(Context context, int i, int i2, int i3, EventType eventType, C1221g c1221g) {
        if (c1221g == null || context == null) {
            C1336d.m5888c("AdEventManager", "content is null");
            return;
        }
        C1249b.m5535a(context, i, C1249b.m5530a(eventType.value(), i2, i3, c1221g));
        if ("click".equalsIgnoreCase(eventType.value())) {
            C1249b.m5538a(context, i, c1221g.getClickmonitorurl__());
        } else if ("imp".equalsIgnoreCase(eventType.value())) {
            C1249b.m5538a(context, i, c1221g.getImpmonitorurl__());
        }
    }

    public static void m5535a(Context context, int i, C1216b c1216b) {
        if (c1216b == null || context == null) {
            C1336d.m5888c("AdEventManager", "event is null");
            return;
        }
        C1336d.m5886b("AdEventManager", "eventType:", c1216b.getType__(), " | time:", String.valueOf(c1216b.getTime__()));
        C1249b.m5539b(context);
        C1249b.m5541b(context, i, c1216b);
        if (((C1277a) f2667a.get(Integer.valueOf(i))).m5634a(c1216b.getType__()) && C1287e.m5683a(context)) {
            C1249b.m5543d(context);
        }
    }

    public static void m5536a(Context context, int i, C1221g c1221g, C1216b c1216b, C1216b c1216b2) {
        if (1 == i) {
            c1216b.setParamfromserver__(c1221g.getParamfromserver__());
            C1249b.m5535a(context, 1, c1216b);
            c1216b2.setParamfromserver__(c1221g.getParamfromserver__());
            C1249b.m5535a(context, 1, c1216b2);
        }
    }

    public static void m5537a(Context context, int i, EventType eventType, C1221g c1221g) {
        C1249b.m5534a(context, i, 0, 0, eventType, c1221g);
    }

    private static void m5538a(Context context, int i, List<String> list) {
        if (context != null) {
            if (list == null || list.isEmpty()) {
                C1249b.m5540b(context, i);
                return;
            }
            for (String str : list) {
                try {
                    new C1285c(context, str, new C1240g(str), new C1251c(i)).executeOnExecutor(C1366j.f2950b, new Void[0]);
                } catch (Exception e) {
                    C1336d.m5888c("AdEventManager", "report third party event fail");
                }
            }
        }
    }

    public static void m5539b(Context context) {
        if (context != null) {
            for (C1277a a : f2667a.values()) {
                a.mo2441a(context);
            }
        }
    }

    private static void m5540b(Context context, int i) {
        Cursor a;
        Throwable th;
        Cursor cursor = null;
        C1357a a2 = C1357a.m5982a(context);
        try {
            a = a2.m5990a(ThirdPartyEventRecord.class.getSimpleName(), null, "(lockTime = 0 or lockTime < ?) and adType = ?", new String[]{String.valueOf(C1287e.m5689d() - 120000), String.valueOf(i)}, "time asc", String.valueOf(3));
            if (a != null) {
                try {
                    if (a.getCount() > 0) {
                        a.moveToFirst();
                        ContentValues contentValues = new ContentValues();
                        do {
                            String string = a.getString(a.getColumnIndex("url"));
                            contentValues.put("lockTime", Long.valueOf(r8));
                            a2.m5986a(ThirdPartyEventRecord.class.getSimpleName(), contentValues, "_id = ?", new String[]{a.getString(a.getColumnIndex("_id"))});
                            C1212b c1240g = new C1240g(string);
                            c1240g.set_id(a.getString(a.getColumnIndex("_id")));
                            new C1285c(context, string, c1240g, new C1252d()).executeOnExecutor(C1366j.f2950b, new Void[0]);
                            a.moveToNext();
                        } while (!a.isAfterLast());
                    }
                } catch (Exception e) {
                    try {
                        C1336d.m5888c("AdEventManager", "report third party cache fail");
                        if (a != null) {
                            a.close();
                        }
                        a2.close();
                    } catch (Throwable th2) {
                        cursor = a;
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        a2.close();
                        throw th;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
            a2.close();
        } catch (Exception e2) {
            a = null;
            C1336d.m5888c("AdEventManager", "report third party cache fail");
            if (a != null) {
                a.close();
            }
            a2.close();
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            a2.close();
            throw th;
        }
    }

    private static void m5541b(Context context, int i, C1216b c1216b) {
        if (c1216b != null) {
            C1357a a = C1357a.m5982a(context);
            AdEventRecord adEventRecord = new AdEventRecord(c1216b);
            adEventRecord.m6008a(i);
            try {
                a.m5988a(AdEventRecord.class.getSimpleName(), adEventRecord.m6004u());
            } catch (Exception e) {
                C1336d.m5888c("AdEventManager", "insert event fail");
            } finally {
                a.close();
            }
        }
    }

    private static List<C1216b> m5542c(Context context) {
        Throwable th;
        Cursor cursor = null;
        List<C1216b> arrayList = new ArrayList(4);
        C1357a a = C1357a.m5982a(context);
        Cursor a2;
        try {
            a2 = a.m5990a(AdEventRecord.class.getSimpleName(), null, "lockTime = 0 or lockTime < ?", new String[]{String.valueOf(C1287e.m5689d() - 120000)}, "_id desc", String.valueOf(50));
            if (a2 != null) {
                try {
                    if (a2.getCount() > 0) {
                        a2.moveToFirst();
                        List arrayList2 = new ArrayList(4);
                        do {
                            AdEventRecord adEventRecord = new AdEventRecord();
                            adEventRecord.m6001a(a2);
                            arrayList.add(adEventRecord.m6007a());
                            arrayList2.add(adEventRecord.m6009b());
                            a2.moveToNext();
                        } while (!a2.isAfterLast());
                        if (!arrayList2.isEmpty()) {
                            a.m5993a(AdEventRecord.class.getSimpleName(), arrayList2, r10);
                        }
                    }
                } catch (Exception e) {
                    try {
                        C1336d.m5888c("AdEventManager", "get event cache fail");
                        if (a2 != null) {
                            a2.close();
                        }
                        a.close();
                        return arrayList;
                    } catch (Throwable th2) {
                        cursor = a2;
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        a.close();
                        throw th;
                    }
                }
            }
            if (a2 != null) {
                a2.close();
            }
            a.close();
        } catch (Exception e2) {
            a2 = null;
            C1336d.m5888c("AdEventManager", "get event cache fail");
            if (a2 != null) {
                a2.close();
            }
            a.close();
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            a.close();
            throw th;
        }
        return arrayList;
    }

    private static void m5543d(Context context) {
        List c = C1249b.m5542c(context);
        if (!c.isEmpty()) {
            try {
                new C1286d(context, C1243a.f2656d, new C1238e(c), new C1253e(c)).executeOnExecutor(C1366j.f2950b, new Void[0]);
            } catch (Exception e) {
                C1336d.m5888c("AdEventManager", "report event cache fail");
            }
        }
    }
}
