package com.huawei.ui.main.stories.about.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.hwappdfxmgr.f.c;
import com.huawei.p190v.C2538c;
import java.io.File;

/* compiled from: AboutActivity */
class C2312l extends BroadcastReceiver {
    final /* synthetic */ AboutActivity f8373a;

    C2312l(AboutActivity aboutActivity) {
        this.f8373a = aboutActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f8373a.f8332y || this.f8373a.f8302C == null || !this.f8373a.f8302C.isShowing()) {
            C2538c.m12674b("AboutActivity", "log采集还没有手动上传log");
        } else if (intent != null) {
            if (SdkConstants.ACTION_LOG_UPLOAD_RESULT.equals(intent.getAction())) {
                this.f8373a.f8303D.removeMessages(0);
                C2538c.m12674b("AboutActivity", "上传结果：" + intent.getIntExtra(SdkConstants.LOG_UPLOAD_RESULT, 1));
                if (16 != intent.getIntExtra(SdkConstants.LOG_UPLOAD_RESULT, 1)) {
                    String stringExtra = intent.getStringExtra("LogUploadFilePath");
                    C2538c.m12674b("AboutActivity", "file： " + stringExtra);
                    if (stringExtra == null || !new File(c.b + stringExtra).exists()) {
                        this.f8373a.f8303D.sendEmptyMessageDelayed(2, 1000);
                        return;
                    }
                    C2538c.m12674b("AboutActivity", "mUploadLogResultBroadcastReceiver: log upload failed");
                    this.f8373a.f8303D.post(new C2323m(this));
                    return;
                }
                this.f8373a.f8303D.sendEmptyMessageDelayed(2, 1000);
            }
        }
    }
}
