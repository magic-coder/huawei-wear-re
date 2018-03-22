package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.AsyncTask;

/* compiled from: ImportContactActivity */
class ey extends AsyncTask<String, Void, Void> {
    final /* synthetic */ ex f6107a;

    ey(ex exVar) {
        this.f6107a = exVar;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m9613a((String[]) objArr);
    }

    protected Void m9613a(String... strArr) {
        this.f6107a.f6105a.f5767j = this.f6107a.f6105a.m9451a(this.f6107a.f6105a.f5771n, this.f6107a.f6106b);
        this.f6107a.f6105a.f5770m.sendEmptyMessage(6);
        return null;
    }
}
