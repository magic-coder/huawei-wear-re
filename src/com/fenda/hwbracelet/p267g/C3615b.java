package com.fenda.hwbracelet.p267g;

import com.fenda.hwbracelet.connection.C3596n;
import com.fenda.hwbracelet.p257a.C3574d;
import com.fenda.p255a.p256a.C3569e;
import com.huawei.p190v.C2538c;

/* compiled from: HandleMessageUtils */
class C3615b implements Runnable {
    final /* synthetic */ C3614a f13865a;

    C3615b(C3614a c3614a) {
        this.f13865a = c3614a;
    }

    public void run() {
        if (C3596n.m18054a() != 3) {
            C2538c.e("HandleMessageUtils", new Object[]{"Because of having disconnected the bracelet,not send the sync_data to app!"});
            return;
        }
        try {
            if (this.f13865a.f13864l == null) {
                C2538c.e("HandleMessageUtils", new Object[]{"the database is NULL"});
                return;
            }
            C2538c.b("HandleMessageUtils", new Object[]{"sendSyncDataToApp ready to  parseDatabaseRecord"});
            C3569e.m17917a(null).m17919a();
            C3574d.m17934a().m17941a(this.f13865a.f13864l, this.f13865a.f13863k, this.f13865a.f13859f, this.f13865a.f13860g);
            C2538c.b("HandleMessageUtils", new Object[]{"sendSyncDataToApp ready to  parseDatabaseRecord done"});
            if (this.f13865a.f13863k == null) {
                C2538c.e("HandleMessageUtils", new Object[]{"OnSyncDataListener == null"});
            } else {
                this.f13865a.f13863k.mo4600b(100);
                this.f13865a.f13863k.mo4597a(0);
            }
            this.f13865a.f13862j = C3617d.STATE_NONE;
        } catch (Exception e) {
            C2538c.c("HandleMessageUtils", new Object[]{"sendSyncDataToApp Exception: " + e.getMessage()});
        } finally {
            this.f13865a.f13862j = C3617d.STATE_NONE;
        }
    }
}
