package com.huawei.pluginkidwatch.common.p138a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.model.DeviceProfile;
import com.huawei.pluginkidwatch.common.entity.model.UserInfo;
import com.huawei.pluginkidwatch.common.lib.utils.C1482b;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DBUtil */
public class C1392h {
    private static final byte[] f3070a = new byte[0];

    public static C1395k m6269a(Context context, String str, String str2) {
        C1395k c1395k;
        C2538c.m12674b("DBUtil", "==============Enter getDeviceInfoTable");
        C2538c.m12674b("DBUtil", "==============deviceCode:", str2);
        synchronized (f3070a) {
            if ("".equals(str2) || !C1492l.m6919c(str2)) {
                c1395k = new C1395k();
            } else {
                c1395k = new C1394j(context).m6331a(str, C1492l.m6920d(str2));
                if (c1395k == null) {
                    C2538c.m12680e("DBUtil", "getDeviceInfoTable() DB do not contain, so we return default");
                    c1395k = new C1395k();
                }
                C2538c.m12674b("DBUtil", "getDeviceInfoTable() leave");
            }
        }
        return c1395k;
    }

    public static ArrayList<C1395k> m6272a(Context context, String str) {
        C2538c.m12674b("DBUtil", "==============Enter getAllDeviceInfo ");
        C2538c.m12674b("DBUtil", "==============huid", str);
        if ("".equals(str)) {
            C2538c.m12680e("DBUtil", "huid is iellgel, so return null");
            return null;
        }
        ArrayList<C1395k> a;
        synchronized (f3070a) {
            a = new C1394j(context).m6332a(str);
        }
        return a;
    }

    public static void m6280a(Context context, String str, List<DeviceProfile> list) {
        C2538c.m12674b("DBUtil", "============Enter deleteUselessInfo");
        if (!"".equals(str) && list != null && list.size() >= 1) {
            synchronized (f3070a) {
                new C1394j(context).m6334a(str, (List) list);
            }
        }
    }

    public static boolean m6298b(Context context, String str) {
        if ("".equals(str)) {
            C2538c.m12680e("DBUtil", "huid is null or ''");
            return false;
        }
        synchronized (f3070a) {
            new C1394j(context).m6337b(str);
        }
        return true;
    }

    public static boolean m6283a(Context context, C1395k c1395k) {
        if (c1395k == null) {
            C2538c.m12680e("DBUtil", "deleteDeviceInfoById() return with table=null!");
            return false;
        }
        synchronized (f3070a) {
            new C1394j(context).m6338b(c1395k.m6343c(), c1395k.m6342b());
        }
        return true;
    }

    public static boolean m6287a(Context context, String str, C1395k c1395k, boolean z) {
        if (c1395k == null) {
            C2538c.m12680e("DBUtil", "setDeviceInfoTable() return with table=null!");
            return false;
        }
        C2538c.m12674b("DBUtil", "========huid：", str);
        C2538c.m12674b("DBUtil", "========DeviceCode：", c1395k.m6342b() + "");
        synchronized (f3070a) {
            C1394j c1394j = new C1394j(context);
            if (c1395k.m6342b() > 0) {
                C1395k a = c1394j.m6331a(str, c1395k.m6342b());
                if (a == null) {
                    C2538c.m12674b("DBUtil", "=========插入数据库");
                    c1394j.m6330a(c1395k);
                } else {
                    C2538c.m12674b("DBUtil", "=========更新数据库");
                    if (!z) {
                        c1395k.m6341a(a.m6344d());
                    }
                    c1394j.m6335b(c1395k);
                }
            }
        }
        return true;
    }

    public static boolean m6297b(Context context, C1395k c1395k) {
        if (c1395k == null) {
            C2538c.m12680e("DBUtil", "updateDeviceInfoTable() return with table=null!");
            return false;
        }
        new C1394j(context).m6335b(c1395k);
        return true;
    }

    public static ad m6289b(Context context, String str, String str2) {
        ad adVar;
        C2538c.m12674b("DBUtil", "==============Enter getLastDeViceStatusTable");
        C2538c.m12674b("DBUtil", "==============huid", str);
        C2538c.m12674b("DBUtil", "==============strDeviceID:", str2);
        synchronized (f3070a) {
            if ("".equals(str2) || !C1492l.m6919c(str2)) {
                adVar = null;
            } else {
                adVar = new ac(context).m6220a(str, C1492l.m6920d(str2));
                if (adVar == null) {
                    C2538c.m12680e("DBUtil", "getLastDeViceStatusTable() DB do not contain, so we return null");
                }
                C2538c.m12674b("DBUtil", "getLastDeViceStatusTable() leave");
            }
        }
        return adVar;
    }

    public static boolean m6286a(Context context, String str, ad adVar) {
        if (adVar == null) {
            C2538c.m12680e("DBUtil", "setDeviceInfoTable() return with table=null!");
            return false;
        }
        C2538c.m12674b("DBUtil", "========huid：", str);
        C2538c.m12674b("DBUtil", "========DeviceCode：", adVar.m6225a() + "");
        synchronized (f3070a) {
            ac acVar = new ac(context);
            if (adVar.m6225a() > 0) {
                if (acVar.m6220a(str, adVar.m6225a()) == null) {
                    C2538c.m12680e("DBUtil", "=========插入数据库");
                    acVar.m6219a(adVar);
                } else {
                    C2538c.m12680e("DBUtil", "=========更新数据库");
                    acVar.m6223b(adVar);
                }
            }
        }
        return true;
    }

    public static ArrayList<C1401q> m6271a(Context context, C1401q c1401q) {
        ArrayList<C1401q> a = new C1400p(context).m6388a(c1401q.f3146b);
        if (a == null) {
            C2538c.m12680e("DBUtil", "getAllNotificationHistoryTable() DB do not contain, so we use default value");
            a = new ArrayList();
        }
        C2538c.m12674b("DBUtil", "getAllNotificationHistoryTable() leave=" + a.toString());
        return a;
    }

    public static int m6288b(Context context, C1401q c1401q) {
        int i = -1;
        if (c1401q == null) {
            C2538c.m12680e("DBUtil", "setNotificationHistoryTable() return with table=null!");
        } else {
            synchronized (f3070a) {
                C1400p c1400p = new C1400p(context);
                C1401q c1401q2 = new C1401q();
                c1401q2.f3147c = c1401q.f3147c;
                c1401q2.f3150f = c1401q.f3150f;
                c1401q2.f3149e = c1401q.f3149e;
                c1400p.m6394c(c1401q2);
                C2538c.m12674b("DBUtil", "setNotificationHistoryTable() noticeTable.ID=  " + c1401q2.f3145a);
                if (-1 == c1401q2.f3145a) {
                    c1400p.m6387a(c1401q);
                    c1400p.m6394c(c1401q);
                    C2538c.m12674b("DBUtil", "setNotificationHistoryTable() return ID" + c1401q.f3145a);
                    i = c1401q.f3145a;
                } else {
                    C2538c.m12674b("DBUtil", "setNotificationHistoryTable() data is exist!");
                }
            }
        }
        return i;
    }

    public static void m6303c(Context context, C1401q c1401q) {
        if (c1401q == null) {
            C2538c.m12680e("DBUtil", "getNotificationHistory() return with table=null!");
            return;
        }
        new C1400p(context).m6391b(c1401q);
    }

    public static boolean m6307d(Context context, C1401q c1401q) {
        if (c1401q == null) {
            C2538c.m12680e("DBUtil", "updateNotificationHistoryTable() return with table=null!");
            return false;
        }
        new C1400p(context).m6395d(c1401q);
        return true;
    }

    public static C1408x m6270a(Context context, int i) {
        C1408x a = new C1407w(context).m6434a(i);
        if (a == null) {
            return null;
        }
        C2538c.m12674b("DBUtil", "getLastTrackInfoTable() leave=" + a.toString());
        return a;
    }

    public static long m6267a(Context context, C1408x c1408x) {
        if (c1408x != null) {
            return new C1407w(context).m6433a(c1408x);
        }
        C2538c.m12680e("DBUtil", "setTrackInfoTable() return with table=null!");
        return -1;
    }

    public static void m6294b(Context context, C1408x c1408x) {
        if (c1408x == null) {
            C2538c.m12680e("DBUtil", "getTrackInfo() return with table=null!");
            return;
        }
        new C1407w(context).m6438b(c1408x);
    }

    public static ArrayList<C1408x> m6300c(Context context, C1408x c1408x) {
        ArrayList<C1408x> c = new C1407w(context).m6439c(c1408x);
        if (c == null) {
            C2538c.m12680e("DBUtil", "getTrackInfoByDate() DB do not contain, so we use default value");
            c = new ArrayList();
        }
        C2538c.m12674b("DBUtil", "getTrackInfoByDate() leave=" + c.toString());
        return c;
    }

    public static boolean m6308d(Context context, C1408x c1408x) {
        if (c1408x == null) {
            C2538c.m12680e("DBUtil", "deleteTrackInfoByDate() return with mod=null!");
            return false;
        }
        synchronized (f3070a) {
            new C1407w(context).m6436a(c1408x.m6440a(), c1408x.m6441b());
        }
        return true;
    }

    public static List<C1399o> m6275a(Context context, C1399o c1399o) {
        if (c1399o == null || c1399o.m6360a() == 0 || "".equals(c1399o.m6363b())) {
            C2538c.m12680e("DBUtil", "getSportData() return with table=null!");
            return null;
        }
        C1398n c1398n = new C1398n(context);
        List<C1399o> arrayList = new ArrayList();
        arrayList.addAll(c1398n.m6357b(c1399o));
        C2538c.m12674b("DBUtil", "getSportData() listNewSportDatasTable = " + arrayList.toString());
        return arrayList;
    }

    public static String m6299c(Context context, String str, String str2) {
        return new C1398n(context).m6355a(str, str2);
    }

    public static void m6293b(Context context, C1399o c1399o) {
        if (c1399o == null || c1399o.m6360a() == 0 || "".equals(c1399o.m6363b())) {
            C2538c.m12680e("DBUtil", "setSportData() return with table=null!");
            return;
        }
        C1398n c1398n = new C1398n(context);
        C2538c.m12680e("DBUtil", "insert() " + c1398n.m6354a(c1399o));
        if (-1 == c1398n.m6354a(c1399o)) {
            c1398n.m6359c(c1399o);
        }
    }

    public static ArrayList<C1404t> m6301c(Context context, String str) {
        C2538c.m12674b("DBUtil", "==============Enter getRewardReachedHistory");
        C2538c.m12674b("DBUtil", "==============deviceCode:", str);
        if ("".equals(str) || !C1492l.m6919c(str)) {
            return null;
        }
        ArrayList<C1404t> a = new C1405u(context).m6427a(C1492l.m6920d(str));
        if (a == null) {
            C2538c.m12680e("DBUtil", "getRewardReachedHistory() DB do not contain, so we return default");
            a = new ArrayList();
        }
        C2538c.m12674b("DBUtil", "getRewardReachedHistory() leave");
        return a;
    }

    public static void m6306d(Context context, String str) {
        C2538c.m12674b("DBUtil", "=======Enter deleteAllRewardHistory");
        if (!"".equals(str) && C1492l.m6919c(str)) {
            C2538c.m12674b("DBUtil", "=======delete deviceCode:" + str);
            new C1405u(context).m6429a(str);
        }
    }

    public static void m6310e(Context context, String str) {
        C2538c.m12674b("DBUtil", "=======Enter deleteAllHistoryInfo");
        if (!"".equals(str) && C1492l.m6919c(str)) {
            C2538c.m12674b("DBUtil", "=======delete deviceCode:" + str);
            new C1400p(context).m6392b(str);
        }
    }

    public static boolean m6284a(Context context, C1404t c1404t) {
        if (c1404t == null) {
            C2538c.m12680e("DBUtil", "setRewaedReachedTable() return with table=null!");
            return false;
        }
        C2538c.m12674b("DBUtil", "========DeviceCode：", c1404t.m6404a() + "");
        C1405u c1405u = new C1405u(context);
        if (!"".equals(c1404t.m6404a())) {
            c1405u.m6426a(c1404t);
        }
        return true;
    }

    public static boolean m6285a(Context context, C1410z c1410z) {
        if (c1410z == null) {
            C2538c.m12680e("DBUtil", "setUpdateTable() return with table=null!");
            return false;
        }
        C2538c.m12674b("DBUtil", "========DeviceCode：", c1410z.m6448a() + "");
        C2538c.m12674b("DBUtil", "========table：", c1410z.toString() + "");
        C1409y c1409y = new C1409y(context);
        if (c1410z.m6448a() > 0) {
            if (c1409y.m6443a(c1410z.m6449b(), c1410z.m6448a()) == null) {
                C2538c.m12674b("DBUtil", "=========setUpdateTable insert");
                c1409y.m6442a(c1410z);
            } else {
                C2538c.m12674b("DBUtil", "=========setUpdateTable update");
                c1409y.m6445b(c1410z);
            }
        }
        return true;
    }

    public static boolean m6282a(Context context, C1390f c1390f) {
        if (c1390f == null) {
            C2538c.m12680e("DBUtil", "setCheckVersionTable return with table=null!");
            return false;
        }
        C2538c.m12674b("DBUtil", "========setCheckVersionTable DeviceCode：", c1390f.m6257a() + "");
        C2538c.m12674b("DBUtil", "========setCheckVersionTable table：", c1390f.toString() + "");
        C1389e c1389e = new C1389e(context);
        if (c1390f.m6257a() > 0) {
            if (c1389e.m6253a(c1390f.m6258b(), c1390f.m6257a()) == null) {
                C2538c.m12674b("DBUtil", "=========setCheckVersionTable insert");
                c1389e.m6252a(c1390f);
            } else {
                C2538c.m12674b("DBUtil", "=========setCheckVersionTable update");
                c1389e.m6255b(c1390f);
            }
        }
        return true;
    }

    public static C1390f m6304d(Context context, String str, String str2) {
        C1390f a;
        C2538c.m12674b("DBUtil", "========Enter getCheckVersionTable");
        C2538c.m12674b("DBUtil", "========DeviceCode：", str2 + "");
        synchronized (f3070a) {
            a = new C1389e(context).m6253a(str, C1492l.m6920d(str2));
        }
        return a;
    }

    public static C1410z m6309e(Context context, String str, String str2) {
        C1410z a;
        C2538c.m12674b("DBUtil", "========Enter getUpdateTable");
        C2538c.m12674b("DBUtil", "========DeviceCode：", str2 + "");
        synchronized (f3070a) {
            a = new C1409y(context).m6443a(str, C1492l.m6920d(str2));
        }
        return a;
    }

    public static boolean m6312f(Context context, String str, String str2) {
        boolean b;
        C2538c.m12674b("DBUtil", "========Enter deleteUpdateTableById DeviceCode：", str2 + "");
        synchronized (f3070a) {
            b = new C1409y(context).m6447b(str, C1492l.m6920d(str2));
        }
        return b;
    }

    public static void m6278a(Context context, C1386b c1386b) {
        if (context != null && c1386b != null) {
            synchronized (f3070a) {
                new C1385a(context).m6202c(c1386b);
            }
        }
    }

    public static C1386b m6290b(Context context, int i) {
        if (context == null || i <= 0) {
            return null;
        }
        C1386b a;
        synchronized (f3070a) {
            a = new C1385a(context).m6198a(i);
        }
        return a;
    }

    public static void m6277a(Context context, ab abVar) {
        C2538c.m12674b("DBUtil", "=======Enter saveVoice");
        if (context == null || abVar == null) {
            C2538c.m12674b("DBUtil", "=======context or table is null,return");
        }
        synchronized (f3070a) {
            new aa(context).m6217c(abVar);
        }
    }

    public static ArrayList<ab> m6314g(Context context, String str, String str2) {
        C2538c.m12674b("DBUtil", "=======Enter getAllVoice");
        ArrayList<ab> arrayList = new ArrayList();
        if (context == null) {
            C2538c.m12674b("DBUtil", "=======context is null,return");
            return arrayList;
        }
        arrayList = new aa(context).m6208a(str, str2);
        if (arrayList == null) {
            return new ArrayList();
        }
        return arrayList;
    }

    public static ArrayList<ab> m6274a(Context context, String str, String str2, int i) {
        C2538c.m12674b("DBUtil", "=======Enter getNewVoice");
        if (context == null) {
            C2538c.m12674b("DBUtil", "=======context is null,return");
        }
        ArrayList<ab> a = new aa(context).m6209a(str, str2, i);
        if (a == null) {
            return new ArrayList();
        }
        return a;
    }

    public static ab m6268a(Context context, String str, String str2, String str3) {
        C2538c.m12674b("DBUtil", "=======Enter getVoiceByurl:" + str3);
        if (context != null) {
            return new aa(context).m6207a(str, str2, "", str3);
        }
        C2538c.m12674b("DBUtil", "=======context is null,return");
        return null;
    }

    public static ArrayList<ab> m6273a(Context context, String str, int i) {
        C2538c.m12674b("DBUtil", "=======Enter getVoiceDateToDelete");
        ArrayList<ab> arrayList = new ArrayList();
        if (context == null) {
            C2538c.m12674b("DBUtil", "=======context is null,return");
        } else {
            arrayList = new aa(context).m6214b(str, i);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            C2538c.m12674b("DBUtil", "=======modList.size():" + arrayList.size());
        }
        return arrayList;
    }

    public static void m6295b(Context context, String str, int i) {
        C2538c.m12674b("DBUtil", "=======Enter deleteInvalableDatas huid:" + str + "  days:" + i);
        if (context == null) {
            C2538c.m12674b("DBUtil", "=======context is null,return");
        }
        synchronized (f3070a) {
            C2538c.m12674b("DBUtil", "=======deleteInvalableVoiceDatas list.size():" + C1392h.m6273a(context, str, i).size());
            Iterator it = r0.iterator();
            while (it.hasNext()) {
                ab abVar = (ab) it.next();
                C2538c.m12674b("DBUtil", "=======deleteInvalableVoiceDatas arr.toString:" + abVar.toString());
                if (!(abVar.m6218a() == null || "".equals(abVar.m6218a()))) {
                    if (abVar.m6218a().startsWith(C1492l.m6918c(context))) {
                        File file = new File(abVar.m6218a());
                        if (file.exists()) {
                            C2538c.m12674b("DBUtil", "=======deleteInvalableVoiceDatas delete:" + abVar.m6218a());
                            boolean delete = file.delete();
                            C2538c.m12674b("DBUtil", "=======deleteInvalableVoiceDatas res:" + delete);
                        }
                    } else {
                        C2538c.m12674b("DBUtil", "====continue====");
                    }
                }
            }
            new aa(context).m6212a(str, i);
        }
    }

    public static void m6296b(Context context, String str, String str2, String str3) {
        C2538c.m12674b("DBUtil", "=======deleteVoiceByUrl:" + str3);
        synchronized (f3070a) {
            if (str3 != null) {
                if (!"".equals(str3.trim())) {
                    File file = new File(str3);
                    if (file.exists()) {
                        C2538c.m12674b("DBUtil", "=======deleteVoiceByUrl delete:" + str3);
                        boolean delete = file.delete();
                        C2538c.m12674b("DBUtil", "=======deleteVoiceByUrl res:" + delete);
                    }
                    new aa(context).m6211a(str, str2, str3);
                }
            }
            C2538c.m12674b("DBUtil", "=======deleteVoiceByUrl error");
            new aa(context).m6211a(str, str2, str3);
        }
    }

    public static void m6311f(Context context, String str) {
        synchronized (f3070a) {
            new C1396l(context).m6350b(str);
        }
    }

    public static void m6279a(Context context, UserInfo userInfo, String str) {
        synchronized (f3070a) {
            new C1396l(context).m6349b(userInfo, str);
        }
    }

    public static C1397m m6313g(Context context, String str) {
        C1397m a;
        synchronized (f3070a) {
            a = new C1396l(context).m6346a(str);
        }
        return a;
    }

    public static ArrayList<C1397m> m6315h(Context context, String str) {
        ArrayList<C1397m> d;
        synchronized (f3070a) {
            d = new C1396l(context).m6352d(str);
            if (d == null) {
                d = new ArrayList();
            }
        }
        return d;
    }

    public static ArrayList<C1388d> m6316i(Context context, String str) {
        C2538c.m12674b("DBUtil", "=DBUtil checkBill= Enter getBillInfoTable");
        C2538c.m12674b("DBUtil", "=DBUtil checkBill= deviceCode:", str);
        if ("".equals(str) || !C1492l.m6919c(str)) {
            return null;
        }
        ArrayList<C1388d> a = new C1387c(context).m6247a(str);
        C2538c.m12674b("DBUtil", "=DBUtil checkBill= getAll ");
        if (a == null) {
            C2538c.m12680e("DBUtil", "=DBUtil checkBill= getBillInfoTable() DB do not contain, so we return default");
            a = new ArrayList();
        }
        C2538c.m12674b("DBUtil", "=DBUtil checkBill= getBillInfoTable() leave");
        return a;
    }

    public static boolean m6281a(Context context, C1388d c1388d) {
        C2538c.m12674b("DBUtil", "=DBUtil checkBill= enter setBillInfoTable");
        if (c1388d == null) {
            C2538c.m12680e("DBUtil", "=DBUtil checkBill= setBillInfoTable() return with table=null!");
            return false;
        }
        C2538c.m12674b("DBUtil", "=DBUtil checkBill= setBillInfoTable ");
        C1387c c1387c = new C1387c(context);
        if (!"".equals(c1388d.m6251a())) {
            C2538c.m12674b("DBUtil", "=DBUtil checkBill= billInfoDB.insert(table)");
            c1387c.m6245a(c1388d, c1388d.m6251a());
        }
        return true;
    }

    public static C1388d m6291b(Context context, C1388d c1388d) {
        C2538c.m12674b("DBUtil", "=DBUtil checkBill= enter getBillByTime");
        if (c1388d == null) {
            C2538c.m12680e("DBUtil", "=DBUtil checkBill= getBillByTime() return with table=null!");
            return null;
        }
        C1388d a = new C1387c(context).m6246a(c1388d);
        String str = "DBUtil";
        Object[] objArr = new Object[1];
        objArr[0] = "=DBUtil checkBill= getBillByTime billInfoTable = " + (a != null ? a.toString() : "null");
        C2538c.m12674b(str, objArr);
        return a;
    }

    public static void m6276a(Context context) {
        C2538c.m12674b("DBUtil", "=DBUtil truncateVoiceDB= enter truncateVoiceDB");
        new aa(context).m6216c();
    }

    public static void m6292b(Context context) {
        C2538c.m12674b("DBUtil", "=DBUtil truncateNotificationHistoryDB= enter truncateNotificationHistoryDB");
        new C1400p(context).m6393c();
    }

    public static void m6302c(Context context) {
        C2538c.m12674b("DBUtil", "=DBUtil truncateRewardReachedDB= enter truncateRewardReachedDB");
        new C1405u(context).m6431c();
    }

    public static void m6305d(Context context) {
        C2538c.m12674b("DBUtil", "=DBUtil truncateBillInfoDB= enter truncateBillInfoDB");
        new C1387c(context).m6250c();
    }

    public static String m6317j(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return C1482b.m6817a(context, str);
    }

    public static String m6318k(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return C1482b.m6818b(context, str);
    }
}
