package com.huawei.pluginaf500.ui;

import android.os.AsyncTask;
import android.widget.Toast;
import com.huawei.pluginaf500.h;

/* compiled from: RemoteTakePictureActivity */
class bc extends AsyncTask<bb, Void, Boolean> {
    final /* synthetic */ RemoteTakePictureActivity f19923a;

    private bc(RemoteTakePictureActivity remoteTakePictureActivity) {
        this.f19923a = remoteTakePictureActivity;
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m26882a((bb[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m26883a((Boolean) obj);
    }

    protected Boolean m26882a(bb... bbVarArr) {
        return Boolean.valueOf(this.f19923a.m26748a(bbVarArr[0].m26881a()));
    }

    protected void m26883a(Boolean bool) {
        if (!bool.booleanValue()) {
            Toast.makeText(this.f19923a, this.f19923a.getString(h.save_picture_fail), 0).show();
        } else if (!this.f19923a.f19803u) {
            Toast.makeText(this.f19923a.getApplicationContext(), this.f19923a.getString(h.file_saved) + this.f19923a.f19784Q, 1).show();
        }
        this.f19923a.f19802t = false;
        super.onPostExecute(bool);
    }
}
