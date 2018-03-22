package com.huawei.ui.main.stories.nps.interactors;

import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.nps.interactors.mode.QstnSurveyDetailResponse;

/* compiled from: HWNPSManager */
class C2455k extends AsyncTask<Object, Object, Object> {
    final /* synthetic */ String f8821a;
    final /* synthetic */ C2454j f8822b;

    C2455k(C2454j c2454j, String str) {
        this.f8822b = c2454j;
        this.f8821a = str;
    }

    protected Object doInBackground(Object... objArr) {
        Gson gson = new Gson();
        C2538c.m12677c(this.f8822b.f8820a.f8785a, "======nps executeAsyncTask responseListener -> response:" + this.f8821a);
        try {
            this.f8822b.f8820a.f8794j = (QstnSurveyDetailResponse) gson.fromJson(this.f8821a, this.f8822b.f8820a.f8796l);
            this.f8822b.f8820a.m12266a(this.f8821a);
            C2538c.m12677c(this.f8822b.f8820a.f8785a, "======nps executeAsyncTask mDetailResponse:" + this.f8822b.f8820a.f8794j.toString());
            return this.f8822b.f8820a.f8794j;
        } catch (JsonSyntaxException e) {
            C2538c.m12674b(this.f8822b.f8820a.f8785a, "======nps executeAsyncTask json error!!!" + e.getMessage());
            this.f8822b.f8820a.f8794j = new QstnSurveyDetailResponse();
            return null;
        }
    }

    protected void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        this.f8822b.f8820a.m12261o();
    }
}
