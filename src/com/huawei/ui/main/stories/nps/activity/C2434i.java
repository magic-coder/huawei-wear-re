package com.huawei.ui.main.stories.nps.activity;

import android.os.AsyncTask;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.nps.interactors.mode.CommitResponse;
import com.huawei.ui.main.stories.nps.interactors.mode.Records;

/* compiled from: QuestionMainActivity */
class C2434i extends AsyncTask<Object, Object, Object> {
    final /* synthetic */ String f8765a;
    final /* synthetic */ C2433h f8766b;

    C2434i(C2433h c2433h, String str) {
        this.f8766b = c2433h;
        this.f8765a = str;
    }

    protected Object doInBackground(Object... objArr) {
        try {
            this.f8766b.f8764a.f8733n = (CommitResponse) new Gson().fromJson(this.f8765a, this.f8766b.f8764a.f8734o);
        } catch (JsonSyntaxException e) {
            C2538c.m12677c(this.f8766b.f8764a.f8720a, "======nps json error!!!");
        }
        return null;
    }

    protected void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        Records.clearAllResult();
        if (this.f8766b.f8764a.f8733n == null || this.f8766b.f8764a.f8733n.getResCode() != 0) {
            C2538c.m12677c(this.f8766b.f8764a.f8720a, "nps upload answers fail");
            return;
        }
        C2538c.m12677c(this.f8766b.f8764a.f8720a, "nps upload answers successful");
        this.f8766b.f8764a.m12198i();
        this.f8766b.f8764a.m12196h();
    }
}
