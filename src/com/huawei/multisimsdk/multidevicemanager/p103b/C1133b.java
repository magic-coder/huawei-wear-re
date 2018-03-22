package com.huawei.multisimsdk.multidevicemanager.p103b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.TransportMediator;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.multisimsdk.multidevicemanager.common.InProgressData;
import com.huawei.multisimsdk.multidevicemanager.p104c.C1143i;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;

/* compiled from: HandleControl */
public class C1133b extends Handler {
    final /* synthetic */ C1132a f2397a;

    public C1133b(C1132a c1132a, Looper looper) {
        this.f2397a = c1132a;
        super(looper);
    }

    public void handleMessage(Message message) {
        C1183h.m5282b(C1132a.f2390a, "msg.what in this = " + message.what);
        switch (message.what) {
            case 100:
            case 101:
            case 102:
                this.f2397a.m5042b(message);
                return;
            case 106:
            case 8888:
                this.f2397a.m5046d(message);
                return;
            case 107:
                this.f2397a.m5038a(message);
                return;
            case 113:
            case 117:
                this.f2397a.m5037a(this.f2397a.f2395b, message);
                return;
            case 114:
            case ReportInfoUtils.FEEDBACK_FAILED /*124*/:
                InProgressData inProgressData = null;
                if (message.obj instanceof InProgressData) {
                    inProgressData = (InProgressData) message.obj;
                }
                C1143i c1143i = new C1143i(this.f2397a.f2395b);
                c1143i.m5102a(inProgressData);
                c1143i.m5101a();
                return;
            case 115:
            case TagName.ELECTRONIC_USE_COUNT /*119*/:
            case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
            case 8889:
                this.f2397a.m5046d(message);
                return;
            case 125:
                this.f2397a.m5046d(message);
                return;
            default:
                return;
        }
    }
}
