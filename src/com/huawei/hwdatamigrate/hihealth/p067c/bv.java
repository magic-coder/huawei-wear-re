package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import com.huawei.hihealth.HiUserPreference;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.be;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4837b;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4839d;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: UserPreferenceManager */
public class bv {
    private static Context f17859b;
    private be f17860a;
    private final Object f17861c;

    private bv() {
        this.f17861c = new Object();
        this.f17860a = be.m23195a(f17859b);
    }

    public static bv m23542a(Context context) {
        f17859b = context.getApplicationContext();
        return bx.f17862a;
    }

    public HiUserPreference m23550a(int i, String str) {
        return C4839d.m23336a(this.f17860a.mo4568a(m23543a(), m23547b(i, str), null, null, null));
    }

    public List<HiUserPreference> m23551a(int i, int i2) {
        return C4837b.m23331e(this.f17860a.mo4568a(m23545b(), m23546b(i, i2), null, null, null));
    }

    private long m23544b(HiUserPreference hiUserPreference) {
        C2538c.b("Debug_UserPreferenceManager", new Object[]{"insertUserPreference()"});
        return this.f17860a.mo4566a(C4836a.m23309a(hiUserPreference));
    }

    private int m23548c(HiUserPreference hiUserPreference) {
        C2538c.b("Debug_UserPreferenceManager", new Object[]{"updateUserPreference() update  update = ", Integer.valueOf(this.f17860a.mo4565a(C4836a.m23316b(hiUserPreference), m23543a(), m23547b(hiUserPreference.getUserId(), hiUserPreference.getKey())))});
        return this.f17860a.mo4565a(C4836a.m23316b(hiUserPreference), m23543a(), m23547b(hiUserPreference.getUserId(), hiUserPreference.getKey()));
    }

    public int m23549a(HiUserPreference hiUserPreference, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(i));
        C2538c.b("Debug_UserPreferenceManager", new Object[]{"updateUserPreference() update  update = ", Integer.valueOf(this.f17860a.mo4565a(contentValues, m23543a(), m23547b(hiUserPreference.getUserId(), hiUserPreference.getKey())))});
        return this.f17860a.mo4565a(contentValues, m23543a(), m23547b(hiUserPreference.getUserId(), hiUserPreference.getKey()));
    }

    public boolean m23552a(HiUserPreference hiUserPreference) {
        boolean z = false;
        synchronized (this.f17861c) {
            C2538c.b("Debug_UserPreferenceManager", new Object[]{"insertOrUpdateUserPreference userPreference is", hiUserPreference});
            if (C4539a.m21748a(hiUserPreference.getKey()) || C4539a.m21748a(hiUserPreference.getValue())) {
            } else {
                long b;
                if (m23550a(hiUserPreference.getUserId(), hiUserPreference.getKey()) == null) {
                    b = m23544b(hiUserPreference);
                } else {
                    b = (long) m23548c(hiUserPreference);
                }
                z = C4843h.m23395a(b);
            }
        }
        return z;
    }

    private String m23543a() {
        return "user_id =? and key =? ";
    }

    private String m23545b() {
        return "user_id =? and sync_status =? ";
    }

    private String[] m23547b(int i, String str) {
        return new String[]{Integer.toString(i), str};
    }

    private String[] m23546b(int i, int i2) {
        return new String[]{Integer.toString(i), Integer.toString(i2)};
    }
}
