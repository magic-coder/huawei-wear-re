package com.huawei.appmarket.p348a.p352d;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.appmarket.p348a.p351c.C4215a;

public final class C4231n extends AsyncTask<Void, Void, Boolean> {
    private String f15870a;
    private C4220c f15871b;

    private C4231n(String str) {
        this.f15870a = str;
    }

    public static void m20511a(String str) {
        new C4231n(str).executeOnExecutor(C4230m.f15869b, new Void[0]);
    }

    private boolean m20512b(String str) {
        this.f15871b = C4230m.m20510b(str);
        if (this.f15871b == null || TextUtils.isEmpty(this.f15871b.f15843g)) {
            return false;
        }
        C4230m.f15868a.remove(C4224g.INSTALL);
        return C4215a.m20478a(this.f15871b.f15843g);
    }

    protected Boolean m20513a(Void... voidArr) {
        return Boolean.valueOf(m20512b(this.f15870a));
    }

    protected void m20514a(Boolean bool) {
        super.onPostExecute(bool);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m20513a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m20514a((Boolean) obj);
    }
}
