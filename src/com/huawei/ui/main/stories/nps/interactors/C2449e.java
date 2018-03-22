package com.huawei.ui.main.stories.nps.interactors;

import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnDestSiteResponse;

/* compiled from: HWNPSManager */
class C2449e extends AsyncTask<Object, Object, Object> {
    final /* synthetic */ String f8814a;
    final /* synthetic */ C2447d f8815b;

    C2449e(C2447d c2447d, String str) {
        this.f8815b = c2447d;
        this.f8814a = str;
    }

    protected Object doInBackground(Object... objArr) {
        C2538c.m12677c(this.f8815b.f8810a.f8785a, "nps responseDestSiteListener executeAsyncTask doInBackground response:" + this.f8814a);
        try {
            return (QstnDestSiteResponse) new Gson().fromJson(this.f8814a, this.f8815b.f8810a.f8797m);
        } catch (JsonSyntaxException e) {
            C2538c.m12677c(this.f8815b.f8810a.f8785a, "nps responseDestSiteListener executeAsyncTask doInBackground ======json error!!!" + e.getMessage());
            return null;
        }
    }

    protected void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        C2538c.m12677c(this.f8815b.f8810a.f8785a, "nps responseDestSiteListener executeAsyncTask onPostExecute !");
        if (obj != null) {
            QstnDestSiteResponse qstnDestSiteResponse = (QstnDestSiteResponse) obj;
            if (this.f8815b.f8810a.f8802s) {
                this.f8815b.f8810a.m12236b(qstnDestSiteResponse);
            } else {
                this.f8815b.f8810a.m12230a(qstnDestSiteResponse);
            }
        }
    }
}
