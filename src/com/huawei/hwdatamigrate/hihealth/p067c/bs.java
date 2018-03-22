package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hihealth.p394c.C4539a;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.bb;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4837b;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4840e;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4842g;
import com.huawei.p190v.C2538c;

/* compiled from: UserInfoManager */
public class bs {
    private static Context f17855b;
    private bb f17856a;
    private final Object f17857c;

    private bs() {
        this.f17857c = new Object();
        this.f17856a = bb.m23185a(f17855b);
    }

    public static bs m23535a(@NonNull Context context) {
        f17855b = context.getApplicationContext();
        return bu.f17858a;
    }

    public long m23538a(HiUserInfo hiUserInfo, int i) {
        C2538c.b("Debug_userInfoManager", new Object[]{"insertUserInfo()"});
        if (hiUserInfo == null) {
            C2538c.b("Debug_userInfoManager", new Object[]{"insertUserInfo() userInfo is null"});
            return 0;
        }
        return this.f17856a.mo4566a(C4836a.m23308a(hiUserInfo, i));
    }

    public int m23536a(HiUserInfo hiUserInfo, int i, int i2) {
        C2538c.b("Debug_userInfoManager", new Object[]{"updateUserInfo"});
        if (hiUserInfo == null || i <= 0) {
            C2538c.e("Debug_userInfoManager", new Object[]{"updateUserInfo values is null"});
            return 0;
        } else if (hiUserInfo.getCreateTime() < m23541b(i)) {
            C2538c.c("Debug_userInfoManager", new Object[]{"updateUserInfo do not need update userInfo , createTime is not new"});
            return 0;
        } else {
            ContentValues a = C4836a.m23308a(hiUserInfo, i2);
            a.remove("huid");
            a.remove("relate_type");
            String[] strArr = new String[]{Integer.toString(i)};
            return this.f17856a.mo4565a(a, "_id =? ", strArr);
        }
    }

    public HiUserInfo m23539a(int i, int i2) {
        if (i <= 0) {
            C2538c.b("Debug_userInfoManager", new Object[]{"queryUserInfo id <=0"});
            return null;
        }
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(i2)};
        return C4837b.m23325a(this.f17856a.mo4568a("_id =? and sync_status =? ", strArr, null, null, null));
    }

    public String m23540a(int i) {
        C2538c.b("Debug_userInfoManager", new Object[]{"queryHuidById"});
        if (i <= 0) {
            C2538c.b("Debug_userInfoManager", new Object[]{"queryHuidById id <=0"});
            return null;
        }
        String[] strArr = new String[]{Integer.toString(i)};
        return C4840e.m23344a(this.f17856a.mo4568a("_id =? ", strArr, null, null, null), "huid");
    }

    public long m23541b(int i) {
        if (i <= 0) {
            return 0;
        }
        String[] strArr = new String[]{Integer.toString(i)};
        return C4840e.m23345b(this.f17856a.mo4568a("_id =? ", strArr, null, null, null), "create_time");
    }

    public int m23537a(String str, int i) {
        C2538c.b("Debug_userInfoManager", new Object[]{"queryUserInfoForUserId"});
        if (C4539a.m21748a(str)) {
            C2538c.d("Debug_userInfoManager", new Object[]{"queryUserInfoForUserId() huid = null"});
            return 0;
        }
        String[] strArr = new String[]{str, Integer.toString(i)};
        return C4842g.m23372b(this.f17856a.mo4568a("huid =? and relate_type =?", strArr, null, null, null), "_id");
    }
}
