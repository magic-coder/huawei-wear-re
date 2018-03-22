package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.AsyncTask;

/* compiled from: ImportContactActivity */
class fc extends AsyncTask<String, Void, Void> {
    final /* synthetic */ ImportContactActivity f6113a;

    fc(ImportContactActivity importContactActivity) {
        this.f6113a = importContactActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9615a((String[]) objArr);
    }

    protected Void m9615a(String... strArr) {
        this.f6113a.f5766i = this.f6113a.m9450a(this.f6113a);
        this.f6113a.f5770m.sendEmptyMessage(4);
        return null;
    }
}
