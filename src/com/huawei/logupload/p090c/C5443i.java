package com.huawei.logupload.p090c;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.huawei.logupload.LogUpload;
import com.huawei.logupload.c.f;
import com.huawei.logupload.c.h.a;

/* compiled from: Utils */
class C5443i extends Thread {
    private final /* synthetic */ LogUpload f19276a;

    C5443i(LogUpload logUpload) {
        this.f19276a = logUpload;
    }

    public void run() {
        try {
            f.b("feedback_upload_Utils", "延迟3S执行判断关闭线程的方法");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            f.b("feedback_upload_Utils", "task : " + e.getMessage());
        }
        a aVar = new a(Looper.getMainLooper());
        Message obtainMessage = aVar.obtainMessage(0);
        Bundle bundle = new Bundle();
        bundle.putString("packagename", this.f19276a.C());
        obtainMessage.setData(bundle);
        aVar.sendMessage(obtainMessage);
    }
}
