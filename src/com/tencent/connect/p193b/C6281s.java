package com.tencent.connect.p193b;

import com.huawei.nfc.carrera.logic.spi.serveraccess.response.BaseResponse;
import com.tencent.open.p541a.C6367n;
import com.tencent.tauth.C6494d;

/* compiled from: ProGuard */
class C6281s implements Runnable {
    String f21847a = "";
    final /* synthetic */ C6273k f21848b;

    public C6281s(C6273k c6273k, String str) {
        this.f21848b = c6273k;
        this.f21847a = str;
    }

    public void run() {
        C6367n.m29107b("openSDK_LOG.authDlg", "-->timeoutUrl: " + this.f21847a + " | mRetryUrl: " + this.f21848b.f21830o);
        if (this.f21847a.equals(this.f21848b.f21830o)) {
            this.f21848b.f21817b.mo5287a(new C6494d(BaseResponse.RESULT_CODE_QUERY_AMOUNT_UNSUPPORTED_DEVICE, "请求页面超时，请稍后重试！", this.f21848b.f21830o));
            this.f21848b.dismiss();
        }
    }
}
