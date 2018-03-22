package com.huawei.hwdatamigrate;

import android.content.Context;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdatamigrate.common.h;
import com.huawei.hwdatamigrate.p407a.C4768a;
import com.huawei.hwdatamigrate.p407a.C4769b;
import com.huawei.hwdatamigrate.p407a.C4770c;
import com.huawei.hwdatamigrate.p407a.C4771d;
import com.huawei.hwdatamigrate.p407a.C4775h;
import com.huawei.hwdatamigrate.p407a.C4785r;
import com.huawei.hwdatamigrate.p407a.C4786s;
import com.huawei.hwdatamigrate.p407a.ac;
import com.huawei.hwdatamigrate.p407a.ad;
import com.huawei.hwdatamigrate.p407a.bh;
import com.huawei.hwdatamigrate.p407a.bi;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HWMigrateDataMgr */
public class C4794a extends a {
    private static C4794a f17719a = null;

    private C4794a(Context context) {
        super(context);
    }

    public static C4794a m22935a(Context context) {
        C4794a c4794a;
        synchronized (C4794a.class) {
            if (f17719a == null) {
                f17719a = new C4794a(BaseApplication.b());
            }
            c4794a = f17719a;
        }
        return c4794a;
    }

    protected Integer getModuleId() {
        return Integer.valueOf(1007);
    }

    public boolean m22937a() {
        C2538c.c("HWMigrateDataMgr", new Object[]{"getUserAgreeFlagJoinPlan enter"});
        String sharedPreference = getSharedPreference("migrate_data_status");
        if ("".equals(sharedPreference)) {
            return false;
        }
        C2538c.c("HWMigrateDataMgr", new Object[]{"getMigratedDataStatus,isMigrateFlag = " + Boolean.parseBoolean(sharedPreference)});
        return Boolean.parseBoolean(sharedPreference);
    }

    public boolean m22939b() {
        C2538c.c("HWMigrateDataMgr", new Object[]{"getHealthMigratedDataStatus getUserAgreeFlagJoinPlan enter"});
        String sharedPreference = getSharedPreference("migrate_health_data_status");
        if ("".equals(sharedPreference)) {
            return false;
        }
        C2538c.c("HWMigrateDataMgr", new Object[]{"getHealthMigratedDataStatus,isMigrateFlag = " + Boolean.parseBoolean(sharedPreference)});
        return Boolean.parseBoolean(sharedPreference);
    }

    public void m22936a(boolean z) {
        setSharedPreference("migrate_data_status", String.valueOf(z), null);
    }

    public void m22938b(boolean z) {
        setSharedPreference("migrate_health_data_status", String.valueOf(z), null);
    }

    public boolean m22940b(Context context) {
        if (context == null) {
            C2538c.e("HWMigrateDataMgr", new Object[]{"needMigrateData context is null"});
            return false;
        } else if (context.getDatabasePath("SportDatas.db").exists()) {
            C2538c.b("HWMigrateDataMgr", new Object[]{"userID is " + C4775h.m22859a(context)});
            if (C4775h.m22859a(context) != null) {
                return true;
            }
            C2538c.c("HWMigrateDataMgr", new Object[]{"userID is error"});
            return false;
        } else {
            C2538c.c("HWMigrateDataMgr", new Object[]{"SportDatas.db do not exist"});
            return false;
        }
    }

    public List<C4786s> m22941c(Context context) {
        if (context != null) {
            return new C4785r(context).m22902c();
        }
        C2538c.e("HWMigrateDataMgr", new Object[]{"geminiContactTableList context is null"});
        return null;
    }

    public C4771d m22942d(Context context) {
        if (context == null) {
            C2538c.e("HWMigrateDataMgr", new Object[]{"getAlarmClock context is null"});
            return null;
        }
        return new C4770c(context).m22849a(C4775h.m22859a(context));
    }

    public List<ad> m22943e(Context context) {
        if (context != null) {
            return new ac(context).m22784c();
        }
        C2538c.e("HWMigrateDataMgr", new Object[]{"getAlarmClock context is null"});
        return null;
    }

    public C4769b m22944f(Context context) {
        if (context == null) {
            C2538c.e("HWMigrateDataMgr", new Object[]{"getRemindTable context is null"});
            return null;
        }
        return new C4768a(context).m22779a(C4775h.m22859a(context));
    }

    public bi m22945g(Context context) {
        if (context != null) {
            return new bh(context).m22846a(0);
        }
        C2538c.c("HWMigrateDataMgr", new Object[]{"getVoidDisturb if (context == null)"});
        return null;
    }

    public String m22946h(Context context) {
        String str = "";
        if (context != null) {
            return C4775h.m22859a(context);
        }
        C2538c.e("HWMigrateDataMgr", new Object[]{"getRemindTable context is null"});
        return str;
    }

    public boolean m22947i(Context context) {
        C2538c.c("HWMigrateDataMgr", new Object[]{"getAutoScreenUpSwitchEnabled:", Boolean.valueOf(h.c(context))});
        return h.c(context);
    }

    public boolean m22948j(Context context) {
        return h.a(context);
    }

    public boolean m22949k(Context context) {
        return h.g(context);
    }

    public boolean m22950l(Context context) {
        return h.h(context);
    }
}
