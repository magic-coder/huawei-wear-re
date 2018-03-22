package com.huawei.hwdatamigrate.hihealth.p067c;

import android.content.Context;
import android.support.annotation.NonNull;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p068d.C4880l;
import com.huawei.hwdatamigrate.hihealth.p068d.C4883o;
import com.huawei.hwdatamigrate.hihealth.p409b.p412c.C4818i;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4836a;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4840e;
import com.huawei.hwdatamigrate.hihealth.p409b.p413d.C4842g;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: MDataClientManager */
public class ak {
    private static Context f17821a;
    private C4818i f17822b;

    private ak() {
        this.f17822b = C4818i.m23225a(f17821a);
    }

    public static ak m23455a(@NonNull Context context) {
        f17821a = context.getApplicationContext();
        return am.f17823a;
    }

    private long m23457b(C4818i c4818i, g gVar) {
        C2538c.b("Debug_ClientManager", new Object[]{"insertClientData()"});
        long a = c4818i.mo4566a(C4836a.m23313a(gVar));
        C2538c.b("Debug_ClientManager", new Object[]{"insertClientData() add  insert = ", Long.valueOf(a)});
        m23456a(a, gVar);
        return a;
    }

    private void m23456a(long j, g gVar) {
        if (j > 0) {
            C2538c.b("Debug_ClientManager", new Object[]{"insertClientData() addCache  clientID = ", Long.valueOf(j), ", hiHealthContext = ", gVar});
            gVar.b((int) j);
            int f = gVar.f();
            int e = gVar.e();
            int d = gVar.d();
            C4880l a = C4880l.m23643a(f17821a);
            a.m23648b(f);
            a.m23649b(d, f);
            a.m23647a(f, e);
            C4883o.m23650a(f17821a).m23655a(d, f, e, gVar);
        }
    }

    public synchronized int m23459a(C4818i c4818i, int i) {
        int b;
        C2538c.b("Debug_ClientManager", new Object[]{"getStatClientByUser userID = ", Integer.valueOf(i)});
        b = C4842g.m23372b(c4818i.mo4568a(m23462a(), m23464a(i, 0, 0), null, null, null), "_id");
        if (b <= 0) {
            g gVar = new g(i, 0, 0);
            gVar.a(0);
            b = (int) m23457b(c4818i, gVar);
        }
        C2538c.b("Debug_ClientManager", new Object[]{"getStatClientByUser userClient = ", Integer.valueOf(b)});
        return b;
    }

    public synchronized int m23460a(C4818i c4818i, int i, int i2, int i3) {
        int b;
        C2538c.b("Debug_ClientManager", new Object[]{"getStatClientByUser deviceID = ", Integer.valueOf(i2), ",userID = ", Integer.valueOf(i)});
        b = C4842g.m23372b(c4818i.mo4568a(m23462a(), m23464a(i, i2, i3), null, null, null), "_id");
        if (b <= 0) {
            g gVar = new g(i, i2, i3);
            gVar.a(0);
            b = (int) m23457b(c4818i, gVar);
        }
        C2538c.b("Debug_ClientManager", new Object[]{"getStatClientByDevice client = ", Integer.valueOf(b)});
        return b;
    }

    public synchronized int m23461a(C4818i c4818i, g gVar) {
        int b;
        C2538c.b("Debug_ClientManager", new Object[]{"getClientByAllSync hiHealthContext = ", gVar});
        b = C4842g.m23372b(c4818i.mo4568a(m23462a(), m23464a(gVar.f(), gVar.e(), gVar.d()), null, null, null), "_id");
        if (b <= 0) {
            b = (int) m23457b(c4818i, gVar);
        }
        C2538c.b("Debug_ClientManager", new Object[]{"getClientByAllSync client = ", Integer.valueOf(b)});
        return b;
    }

    public String m23462a() {
        return "user_id =? and device_id =? and app_id =? ";
    }

    public String[] m23464a(int i, int i2, int i3) {
        return new String[]{Integer.toString(i), Integer.toString(i2), Integer.toString(i3)};
    }

    public int m23458a(long j, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("cloud_device").append(" =? and ");
        stringBuffer.append("app_id").append(" =? ");
        return C4842g.m23372b(this.f17822b.mo4568a(stringBuffer.toString(), new String[]{Long.toString(j), Integer.toString(i)}, null, null, null), SNBConstant.FIELD_DEVICE_ID);
    }

    public List<g> m23463a(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ReportCardInfo.COLUMN_NAME_CARD_USERID).append(" =? and ").append(SNBConstant.FIELD_DEVICE_ID).append(" >? ").append(" and ").append("sync_status").append(" =? ");
        return C4840e.m23350f(this.f17822b.mo4568a(stringBuffer.toString(), new String[]{Integer.toString(i), Integer.toString(0), Integer.toString(i2)}, null, null, null));
    }
}
