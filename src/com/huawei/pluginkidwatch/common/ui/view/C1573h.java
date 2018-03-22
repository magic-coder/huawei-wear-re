package com.huawei.pluginkidwatch.common.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import com.huawei.pluginkidwatch.common.lib.utils.C1486f;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;

/* compiled from: AsyncImageLoader */
final class C1573h extends AsyncTask<String, Void, Bitmap> {
    final /* synthetic */ String f3878a;
    final /* synthetic */ Context f3879b;
    final /* synthetic */ C1574j f3880c;

    C1573h(String str, Context context, C1574j c1574j) {
        this.f3878a = str;
        this.f3879b = context;
        this.f3880c = c1574j;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m7257a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m7258a((Bitmap) obj);
    }

    protected Bitmap m7257a(String... strArr) {
        C2538c.m12674b("AsyncImageLoader", "==ww== downloadAsyncTask download url == " + this.f3878a);
        return C1486f.m6871a(this.f3879b, this.f3878a);
    }

    protected void m7258a(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (!(bitmap == null || this.f3880c == null || bitmap.isRecycled())) {
            C2538c.m12674b("AsyncImageLoader", " ==ww=== downloadAsyncTask callback.change!!");
            this.f3880c.mo2597a(C1492l.m6903a(bitmap));
        }
        if (bitmap != null) {
            C2538c.m12674b("AsyncImageLoader", " ==ww=== downloadAsyncTask put  Bitmap to mBitmapCache!!");
            C1465a.m6770a().m6775a(this.f3878a, bitmap);
            ac.m7223a(this.f3879b, this.f3878a, bitmap);
        }
    }
}
