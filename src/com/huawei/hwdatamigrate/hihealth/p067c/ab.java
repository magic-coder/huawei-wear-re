package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiGoalInfo;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4825p;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4837b;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4843h;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: GoalInfoManager */
public class ab {
    private static Context f17811b;
    private C4825p f17812a;
    private final Object f17813c;

    private ab() {
        this.f17813c = new Object();
        this.f17812a = C4825p.m23255a(f17811b);
    }

    public static ab m23422a(@NonNull Context context) {
        f17811b = context.getApplicationContext();
        return ad.f17814a;
    }

    private Cursor m23425c(int i, int i2) {
        C2538c.b("Debug_GoalInfoManager", new Object[]{"queryGoalInfoCursor"});
        if (i <= 0) {
            C2538c.d("Debug_GoalInfoManager", new Object[]{"no such userId"});
            return null;
        }
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(i2)};
        return this.f17812a.mo4568a("user_id =? and goal_type=?", strArr, null, null, null);
    }

    public List<HiGoalInfo> m23427a(int i, int i2) {
        C2538c.b("Debug_GoalInfoManager", new Object[]{"queryGoalInfoCursor"});
        if (i <= 0) {
            C2538c.d("Debug_GoalInfoManager", new Object[]{"no such userId"});
            return null;
        }
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(i2)};
        return C4837b.m23329c(this.f17812a.mo4568a("user_id =? and sync_status =? ", strArr, null, null, null));
    }

    public boolean m23429b(int i, int i2) {
        C2538c.b("Debug_GoalInfoManager", new Object[]{"queryGoalInfoExist"});
        return C4841f.m23368f(m23425c(i, i2));
    }

    private int m23423b(HiGoalInfo hiGoalInfo, int i) {
        C2538c.b("Debug_GoalInfoManager", new Object[]{"updateGoalInfo"});
        if (hiGoalInfo == null) {
            C2538c.d("Debug_GoalInfoManager", new Object[]{"updateGoalInfo goalInfo is null"});
            return 0;
        }
        int ownerId = hiGoalInfo.getOwnerId();
        String[] strArr = new String[]{Integer.toString(ownerId), Integer.toString(hiGoalInfo.getGoalType())};
        return this.f17812a.mo4565a(C4836a.m23305a(hiGoalInfo, i), "user_id =? and goal_type = ?", strArr);
    }

    public int m23426a(int i, int i2, int i3) {
        C2538c.b("Debug_GoalInfoManager", new Object[]{"updateSyncGoalInfo"});
        if (i <= 0) {
            C2538c.d("Debug_GoalInfoManager", new Object[]{"updateSyncGoalInfo userID is ", Integer.valueOf(i)});
            return 0;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("sync_status", Integer.valueOf(i3));
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(i2)};
        return this.f17812a.mo4565a(contentValues, "user_id =? and goal_type = ?", strArr);
    }

    private long m23424c(HiGoalInfo hiGoalInfo, int i) {
        C2538c.b("Debug_GoalInfoManager", new Object[]{"insertGoalInfo"});
        if (hiGoalInfo == null) {
            C2538c.d("Debug_GoalInfoManager", new Object[]{"insertGoalInfo goalInfo is null"});
            return 0;
        }
        return this.f17812a.mo4566a(C4836a.m23305a(hiGoalInfo, i));
    }

    public boolean m23428a(HiGoalInfo hiGoalInfo, int i) {
        boolean z = false;
        synchronized (this.f17813c) {
            C2538c.b("Debug_GoalInfoManager", new Object[]{"insertOrUpdateGoalInfo"});
            if (hiGoalInfo == null) {
                C2538c.d("Debug_GoalInfoManager", new Object[]{"insertOrUpdateGoalInfo goalInfo is null"});
            } else {
                long b;
                if (m23429b(hiGoalInfo.getOwnerId(), hiGoalInfo.getGoalType())) {
                    b = (long) m23423b(hiGoalInfo, i);
                } else {
                    b = m23424c(hiGoalInfo, i);
                }
                z = C4843h.m23395a(b);
            }
        }
        return z;
    }
}
