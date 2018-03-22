package com.huawei.bone.wxapi;

import android.content.Intent;
import android.os.AsyncTask;
import com.huawei.hwcommonmodel.d.a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;

/* compiled from: WXEntryActivity */
class C6694b extends AsyncTask<String, Integer, String> {
    final /* synthetic */ WXEntryActivity f22919a;

    private C6694b(WXEntryActivity wXEntryActivity) {
        this.f22919a = wXEntryActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m30019a((String[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m30020a((String) obj);
    }

    protected String m30019a(String... strArr) {
        C2538c.b("WXEntryActivity", new Object[]{" doInBackground() params[0]=", strArr[0]});
        return this.f22919a.m30018a(strArr[0]);
    }

    protected void m30020a(String str) {
        super.onPostExecute(str);
        C2538c.b("WXEntryActivity", new Object[]{" onPostExecute() result=", str});
        try {
            Intent intent = new Intent(WeChat.ACTION);
            intent.putExtra(WeChat.RESULT_ACCESS_TOKEN, str);
            a.a(this.f22919a.getApplicationContext(), intent);
            this.f22919a.finish();
        } catch (Exception e) {
            C2538c.e("WXEntryActivity", new Object[]{"onPostExecute MyAsynctask->onPostExecute() Exception:", e.getMessage()});
        }
    }
}
