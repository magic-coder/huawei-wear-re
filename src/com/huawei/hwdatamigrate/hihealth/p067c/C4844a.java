package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.huawei.hihealth.HiAccountInfo;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4811a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4837b;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4840e;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.huawei.p190v.C2538c;

/* compiled from: AccountInfoManager */
public class C4844a {
    private static Context f17807a;
    private C4811a f17808b;
    private final Object f17809c;

    private C4844a() {
        this.f17809c = new Object();
        this.f17808b = C4811a.m23073a(f17807a);
    }

    public static C4844a m23413a(Context context) {
        f17807a = context.getApplicationContext();
        return C4846c.f17863a;
    }

    public boolean m23419a(HiAccountInfo hiAccountInfo) {
        boolean a;
        C2538c.b("Debug_AccountInfoManager", new Object[]{"insertAccountInfo"});
        synchronized (this.f17809c) {
            long b;
            if (m23418a(hiAccountInfo.getAppId(), hiAccountInfo.getHuid())) {
                b = (long) m23414b(hiAccountInfo);
            } else {
                C2538c.b("Debug_AccountInfoManager", new Object[]{"insertAccountInfo insert new accountInfo"});
                b = m23416c(hiAccountInfo);
            }
            a = C4843h.m23395a(b);
        }
        return a;
    }

    public boolean m23418a(int i, String str) {
        C2538c.b("Debug_AccountInfoManager", new Object[]{"queryAccountInfoExist"});
        if (!C4539a.m21748a(str) && i > 0) {
            return C4841f.m23368f(m23415b(i, str));
        }
        C2538c.d("Debug_AccountInfoManager", new Object[]{"queryAccountInfoExist parameter is wrong"});
        return false;
    }

    private Cursor m23415b(int i, String str) {
        C2538c.b("Debug_AccountInfoManager", new Object[]{"queryAccountInfo"});
        if (C4539a.m21748a(str) || i <= 0) {
            C2538c.d("Debug_AccountInfoManager", new Object[]{"queryAccountInfo parameter is wrong!"});
            return null;
        }
        String[] strArr = new String[]{String.valueOf(i), str};
        return this.f17808b.mo4568a("app_id =? and huid =?", strArr, null, null, null);
    }

    private int m23414b(HiAccountInfo hiAccountInfo) {
        C2538c.b("Debug_AccountInfoManager", new Object[]{"updateAccountInfo"});
        if (hiAccountInfo == null || C4539a.m21748a(hiAccountInfo.getHuid())) {
            C2538c.d("Debug_AccountInfoManager", new Object[]{"updateAccountInfo accountInfo is null!"});
            return 0;
        }
        int appId = hiAccountInfo.getAppId();
        ContentValues a = C4836a.m23302a(hiAccountInfo);
        a.remove("create_time");
        String[] strArr = new String[]{String.valueOf(appId), hiAccountInfo.getHuid()};
        return this.f17808b.mo4565a(a, "app_id =? and huid =?", strArr);
    }

    private long m23416c(HiAccountInfo hiAccountInfo) {
        C2538c.b("Debug_AccountInfoManager", new Object[]{"insertAccountInfo"});
        if (hiAccountInfo == null) {
            C2538c.d("Debug_AccountInfoManager", new Object[]{"insertAccountInfo accountInfo is null!"});
            return 0;
        }
        return this.f17808b.mo4566a(C4836a.m23302a(hiAccountInfo));
    }

    public HiAccountInfo m23417a(int i) {
        C2538c.b("Debug_AccountInfoManager", new Object[]{"getAccountInfoByAppId"});
        if (i < 0) {
            C2538c.d("Debug_AccountInfoManager", new Object[]{"getAccountInfoByAppId appId is not right!"});
            return null;
        }
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(1)};
        return C4837b.m23328b(this.f17808b.mo4568a("app_id =? and is_login =? ", strArr, null, null, null));
    }

    public String m23420b(int i) {
        C2538c.b("Debug_AccountInfoManager", new Object[]{"getHuidByAppId"});
        if (i <= 0) {
            C2538c.d("Debug_AccountInfoManager", new Object[]{"getHuidByAppId appId is not right!"});
            return null;
        }
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(1)};
        return C4840e.m23344a(this.f17808b.mo4568a("app_id =? and is_login =? ", strArr, null, null, null), "huid");
    }

    public int m23421c(int i) {
        int i2;
        synchronized (this.f17809c) {
            C2538c.b("Debug_AccountInfoManager", new Object[]{"logoutByAppId"});
            HiAccountInfo a = m23417a(i);
            if (a == null) {
                C2538c.d("Debug_AccountInfoManager", new Object[]{"logoutByAppId the account is not exist"});
                i2 = -1;
            } else {
                a.setLogin(0);
                i2 = m23414b(a);
            }
        }
        return i2;
    }
}
