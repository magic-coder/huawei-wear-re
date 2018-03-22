package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4818i;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import java.util.List;

/* compiled from: NDataClientManager */
public class bg {
    private static Context f17840b;
    private C4818i f17841a;

    private bg() {
        this.f17841a = C4818i.m23225a(f17840b);
    }

    public static bg m23504a(@NonNull Context context) {
        f17840b = context.getApplicationContext();
        return bi.f17842a;
    }

    public List<Integer> m23506a(int i, int i2) {
        return C4841f.m23365e(this.f17841a.mo4568a("user_id =? and device_id >=? and app_id =? ", ak.m23455a(f17840b).m23464a(i, 0, i2), null, null, null));
    }

    public long m23505a(g gVar) {
        if (gVar == null) {
            return 0;
        }
        return (long) this.f17841a.mo4565a(C4836a.m23318b(gVar), ak.m23455a(f17840b).m23462a(), ak.m23455a(f17840b).m23464a(gVar.f(), gVar.e(), gVar.d()));
    }
}
