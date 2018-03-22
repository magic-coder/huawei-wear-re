package com.google.zxing.client.android;

import android.os.AsyncTask;
import android.util.Log;

/* compiled from: PictureFetcher */
class C3820q extends AsyncTask<Void, Void, String> {
    final /* synthetic */ C3818o f14831a;
    private final /* synthetic */ int f14832b;
    private final /* synthetic */ C3811r f14833c;

    C3820q(C3818o c3818o, int i, C3811r c3811r) {
        this.f14831a = c3818o;
        this.f14832b = i;
        this.f14833c = c3811r;
    }

    protected /* synthetic */ Object doInBackground(Object... objArr) {
        return m19071a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m19072a((String) obj);
    }

    protected String m19071a(Void... voidArr) {
        long currentTimeMillis = System.currentTimeMillis();
        String a = new C3823v().m19079a(this.f14831a.m19069a(this.f14832b));
        currentTimeMillis = Math.abs(System.currentTimeMillis() - currentTimeMillis);
        if (currentTimeMillis < 1000) {
            try {
                Thread.sleep(1000 - currentTimeMillis);
            } catch (InterruptedException e) {
            }
        }
        Log.i("PictureFecher", "checkQrCode qrcode is:" + a);
        return a;
    }

    protected void m19072a(String str) {
        if (this.f14833c != null) {
            this.f14833c.mo4315a(str);
        }
    }
}
