package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4818i;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4840e;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4841f;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4842g;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import java.util.List;

/* compiled from: DataClientManager */
public class C4850g {
    private static Context f17867b;
    private C4818i f17868a;

    private C4850g() {
        this.f17868a = C4818i.m23225a(f17867b);
    }

    public static C4850g m23559a(@NonNull Context context) {
        f17867b = context.getApplicationContext();
        return C4852i.f17869a;
    }

    public int m23560a(int i) {
        return ak.m23455a(f17867b).m23459a(this.f17868a, i);
    }

    public int m23561a(int i, int i2, int i3) {
        return ak.m23455a(f17867b).m23460a(this.f17868a, i, i2, i3);
    }

    public int m23562a(g gVar) {
        return ak.m23455a(f17867b).m23461a(this.f17868a, gVar);
    }

    public int m23564b(int i) {
        return C4842g.m23372b(this.f17868a.mo4568a("_id =? ", new String[]{Integer.toString(i)}, null, null, null), SNBConstant.FIELD_DEVICE_ID);
    }

    public List<Integer> m23565c(int i) {
        return C4841f.m23365e(this.f17868a.mo4568a("user_id =? and device_id >?  and app_id >? ", ak.m23455a(f17867b).m23464a(i, 0, 0), null, null, null));
    }

    public List<Integer> m23563a(int i, int i2) {
        return C4841f.m23365e(this.f17868a.mo4568a("user_id =? and device_id =? and app_id >? ", ak.m23455a(f17867b).m23464a(i, i2, 0), null, null, null));
    }

    public List<Integer> m23566d(int i) {
        String[] strArr = new String[]{Integer.toString(i), Integer.toString(0), Integer.toString(0), Integer.toString(1)};
        return C4841f.m23365e(this.f17868a.mo4568a("user_id =? and device_id >?  and app_id >?  and sync_status =? ", strArr, null, null, null));
    }

    public g m23567e(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("_id").append(" =? ");
        return C4840e.m23351g(this.f17868a.mo4568a(stringBuffer.toString(), new String[]{Integer.toString(i)}, null, null, null));
    }
}
