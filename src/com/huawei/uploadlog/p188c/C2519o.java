package com.huawei.uploadlog.p188c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.ui.main.stories.lightcloud.constants.JoinConstants;
import com.huawei.uploadlog.C2524g;
import com.huawei.uploadlog.C2529l;
import com.huawei.uploadlog.LogUpload;
import com.huawei.uploadlog.LogUploadReceive;
import com.huawei.uploadlog.LogUploadService;
import com.huawei.uploadlog.UploadReceiver;
import com.huawei.uploadlog.p187b.C2499a;

/* compiled from: Utils */
public class C2519o extends Handler {
    public C2519o(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        LogUpload logUpload;
        switch (message.what) {
            case 0:
                if (!C2529l.m12607a()) {
                    C2517m.m12585e();
                    C2511g.m12481b("BETACLUB_SDK", "收到子线程消息");
                    C2511g.m12481b("BETACLUB_SDK", "自杀进程 :myPid: " + Process.myPid());
                    Intent intent = new Intent();
                    intent.setAction("com.huawei.crowdtestsdk.UPLOAD_PROGRESS");
                    intent.putExtra("packageName", "com.huawei.crowdtestsdk");
                    intent.putExtra(JoinConstants.EXCEPTION, "1");
                    C2511g.m12477a(JoinConstants.EXCEPTION, "1");
                    AppContext.getInstance().getApplication().sendBroadcast(intent);
                    C2507c.m12462c().clear();
                    C2507c.m12457a(0);
                    C2507c.m12463c(-1);
                    C2507c.m12461b(0);
                    UploadReceiver.m12406a(-100);
                    AppContext.getInstance().getApplication().stopService(new Intent(AppContext.getInstance().getApplication(), LogUploadReceive.class));
                    AppContext.getInstance().getApplication().stopService(new Intent(AppContext.getInstance().getApplication(), LogUploadService.class));
                    Process.killProcess(Process.myPid());
                    return;
                }
                return;
            case 1:
                C2511g.m12481b("BETACLUB_SDK", "[Utils.MyHandler.handleMessage] service 启动");
                logUpload = (LogUpload) message.obj;
                if (logUpload != null) {
                    C2511g.m12484d("BETACLUB_SDK", "[Utils.MyHandler.handleMessage] taskId:" + logUpload.getTaskId());
                    LogUploadService.m12403a(logUpload);
                    return;
                }
                return;
            case 2:
                C2511g.m12481b("BETACLUB_SDK", "[Utils.MyHandler.handleMessage] 亮屏");
                C2499a.m12430a().m12431a(new C2524g((LogUpload) message.obj, message.arg1));
                return;
            case 3:
                C2511g.m12481b("BETACLUB_SDK", "[Utils.MyHandler.handleMessage] 网络变更");
                Context a = UploadReceiver.m12405a();
                logUpload = (LogUpload) message.obj;
                Intent intent2 = new Intent(a, LogUploadReceive.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("LogUpload", logUpload);
                intent2.putExtras(bundle);
                a.startService(intent2);
                return;
            default:
                return;
        }
    }
}
