package com.huawei.pluginkidwatch.plugin.feature.newsport;

import android.content.Context;
import android.os.AsyncTask;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1399o;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: AsyncLoadNewData */
public abstract class C1808c extends AsyncTask<Long, Object, Void> {
    C1810e f4999a;
    private Context f5000b;
    private List<C1399o> f5001c = new ArrayList();

    public abstract void mo2605a(List<C1399o> list);

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m8647a((Long[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m8648a((Void) obj);
    }

    public C1808c(Context context, C1810e c1810e) {
        this.f4999a = c1810e;
        this.f5000b = context;
    }

    protected Void m8647a(Long... lArr) {
        String format = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(lArr[0]);
        switch (C1809d.f5002a[this.f4999a.ordinal()]) {
            case 1:
                m8646a(format);
                break;
        }
        return null;
    }

    protected void m8648a(Void voidR) {
    }

    protected void onProgressUpdate(Object... objArr) {
        switch (C1809d.f5002a[this.f4999a.ordinal()]) {
            case 1:
                mo2605a(this.f5001c);
                return;
            default:
                return;
        }
    }

    private void m8646a(String str) {
        C1399o c1399o;
        C2538c.m12674b("AsyncLoadNewData", "=======KWCache.getDeviceCode()======" + C1462f.m6746j());
        if ("".equals(C1462f.m6746j())) {
            c1399o = null;
        } else {
            c1399o = new C1399o();
            c1399o.m6361a(C1492l.m6920d(C1462f.m6746j()));
            c1399o.m6362a(str);
            if (C1392h.m6275a(this.f5000b, c1399o) != null) {
                this.f5001c.addAll(C1392h.m6275a(this.f5000b, c1399o));
            }
            C2538c.m12674b("AsyncLoadNewData", "=======getSportData for DB======" + c1399o.m6360a());
            C2538c.m12674b("AsyncLoadNewData", "=======listSportDatas ======" + this.f5001c.toString());
        }
        if (this.f5001c != null && this.f5001c.size() == 0) {
            this.f5001c = null;
        }
        publishProgress(new Object[]{c1399o});
    }
}
