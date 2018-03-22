package com.huawei.openalliance.ad.p112a.p121e;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1231q;
import com.huawei.openalliance.ad.p112a.p113a.p115b.C1232r;
import com.huawei.openalliance.ad.p112a.p122h.C1287e;
import com.huawei.openalliance.ad.p112a.p122h.C1289h;
import com.huawei.openalliance.ad.utils.db.C1357a;
import com.huawei.openalliance.ad.utils.db.bean.UserCloseRecord;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

public class C1254f {
    public static boolean m5556a(Context context) {
        if (context == null) {
            return false;
        }
        C1289h a = C1289h.m5695a(context);
        String a2 = C1287e.m5681a("yyyy-MM-dd");
        int h = a.m5717h();
        if (!a2.equals(a.m5721j()) || h <= 0 || a.m5719i() < h) {
            C1336d.m5886b("DisturbManager", "not trigger app fc control");
            return false;
        }
        C1336d.m5886b("DisturbManager", "trigger app fc control");
        return true;
    }

    private static boolean m5557a(C1232r c1232r) {
        return c1232r != null && c1232r.getTimeScope__() <= 30 && c1232r.getTimeScope__() >= 1 && c1232r.getSkippedAdMinTimes__() >= 1 && c1232r.getSkippedAdMaxTimes__() >= 1 && c1232r.getNoShowTime__() >= 1;
    }

    public static void m5558b(Context context) {
        if (context != null) {
            C1357a a = C1357a.m5982a(context);
            UserCloseRecord userCloseRecord = new UserCloseRecord();
            userCloseRecord.m6061a(C1287e.m5689d());
            userCloseRecord.mo2463a(C1287e.m5681a("yyyy-MM-dd HH:mm:ss"));
            try {
                a.m5988a(UserCloseRecord.class.getSimpleName(), userCloseRecord.m6004u());
                long time = C1287e.m5682a(new Date(), 30).getTime();
                C1336d.m5884a("DisturbManager", "expire time is: " + String.valueOf(time));
                a.m5987a(UserCloseRecord.class.getSimpleName(), "timeStamp < ?", new String[]{String.valueOf(time)});
            } catch (Exception e) {
                C1336d.m5888c("DisturbManager", "insert userclose event fail");
            } finally {
                a.close();
            }
            C1254f.m5559c(context);
        }
    }

    public static void m5559c(Context context) {
        if (context != null) {
            C1289h a = C1289h.m5695a(context);
            Object k = a.m5723k();
            if (!TextUtils.isEmpty(k)) {
                C1231q c1231q = new C1231q();
                try {
                    c1231q.fromJson(new JSONObject(k));
                } catch (Throwable e) {
                    C1336d.m5883a("DisturbManager", "convert reduceDisturbRule error", e);
                }
                List<C1232r> ruleList__ = c1231q.getRuleList__();
                if (ruleList__ != null) {
                    C1357a a2 = C1357a.m5982a(context);
                    String simpleName = UserCloseRecord.class.getSimpleName();
                    long j = 0;
                    long d = C1287e.m5689d();
                    try {
                        for (C1232r c1232r : ruleList__) {
                            if (C1254f.m5557a(c1232r)) {
                                Cursor a3 = a2.m5989a(simpleName, null, "timeStamp >= ? and timeStamp < ?", new String[]{String.valueOf(C1287e.m5682a(new Date(), c1232r.getTimeScope__()).getTime()), String.valueOf(d)}, null);
                                if (a3 != null) {
                                    int count = a3.getCount();
                                    if (count >= c1232r.getSkippedAdMinTimes__() && count <= c1232r.getSkippedAdMaxTimes__()) {
                                        j = j > c1232r.getNoShowTime__() ? j : c1232r.getNoShowTime__();
                                    }
                                    a3.close();
                                } else {
                                    continue;
                                }
                            }
                        }
                        a.m5707c(j + d);
                    } catch (Exception e2) {
                        C1336d.m5888c("DisturbManager", "calculate disturb user failed");
                    } finally {
                        a2.close();
                    }
                }
            }
        }
    }

    public static void m5560d(Context context) {
        if (context != null) {
            C1289h a = C1289h.m5695a(context);
            String a2 = C1287e.m5681a("yyyy-MM-dd");
            if (!a2.equals(a.m5721j())) {
                a.m5699a(a2);
                a.m5716g(0);
            }
            a.m5716g(a.m5719i() + 1);
        }
    }
}
