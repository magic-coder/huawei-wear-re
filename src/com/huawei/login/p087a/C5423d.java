package com.huawei.login.p087a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.login.a.a;
import com.huawei.p190v.C2538c;

import java.util.concurrent.CountDownLatch;

/* compiled from: HuaweiLoginManager */
final class C5423d implements Runnable {
    final /* synthetic */ Context f19240a;
    final /* synthetic */ CountDownLatch f19241b;

    C5423d(Context context, CountDownLatch countDownLatch) {
        this.f19240a = context;
        this.f19241b = countDownLatch;
    }

    public void run() {
        Exception e;
        Throwable th;
        Cursor query;
        try {
            query = this.f19240a.getContentResolver().query(Uri.parse(HwAccountConstants.CONTENT_HASLOGIN_URL), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"result = " + query.getInt(query.getColumnIndex("hasLogin"))});
                        if (1 == query.getInt(query.getColumnIndex("hasLogin"))) {
                            a.a(true);
                        } else {
                            a.a(false);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C2538c.e("PLGLOGIN_HuaweiLoginManager", new Object[]{"e = " + e.getMessage()});
                        a.a(false);
                        if (query != null) {
                            query.close();
                        }
                        try {
                            this.f19241b.countDown();
                        } catch (Exception e3) {
                            this.f19241b.countDown();
                            return;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        try {
                            this.f19241b.countDown();
                        } catch (Exception e4) {
                            this.f19241b.countDown();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
            try {
                this.f19241b.countDown();
            } catch (Exception e5) {
                this.f19241b.countDown();
            }
        } catch (Exception e6) {
            e = e6;
            query = null;
            C2538c.e("PLGLOGIN_HuaweiLoginManager", new Object[]{"e = " + e.getMessage()});
            a.a(false);
            if (query != null) {
                query.close();
            }
            this.f19241b.countDown();
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            this.f19241b.countDown();
            throw th;
        }
    }
}
