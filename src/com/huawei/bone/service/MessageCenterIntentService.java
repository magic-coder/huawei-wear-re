package com.huawei.bone.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MessageCenterIntentService extends IntentService {
    private List<MessageObject> f1205a = new ArrayList();
    private Gson f1206b = new Gson();

    protected void onHandleIntent(Intent intent) {
        C2538c.m12677c("MessageCenterIntentService", "Enter onHandleIntent");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        if (intent != null) {
            int intExtra = intent.getIntExtra("commandType", 0);
            C2538c.m12677c("MessageCenterIntentService", "Enter onHandleIntent commandType:" + intExtra);
            switch (intExtra) {
                case 1:
                    C1971j.m10236a(BaseApplication.m2632b()).m10253b(C1093a.m4739a(BaseApplication.m2632b()).m4750c(), new C0666a(this, intExtra, countDownLatch));
                    try {
                        countDownLatch.await(20, TimeUnit.SECONDS);
                        return;
                    } catch (InterruptedException e) {
                        C2538c.m12677c("MessageCenterIntentService", "Enter InterruptedException:" + e.getMessage());
                        return;
                    }
                case 2:
                    String stringExtra = intent.getStringExtra("content");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        C2538c.m12677c("MessageCenterIntentService", "SAVE_HEALTH_SUPPORTED_DEVICE:" + stringExtra);
                        C0996a.m3611a(BaseApplication.m2632b(), String.valueOf(10000), "UNION_HEALTH_SUPPORT_LIST", stringExtra, new C0993c());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public String m2641a() {
        String str = "";
        C2538c.m12677c("MessageCenterIntentService", "nps getQuestionDetail question = " + C0996a.m3612a(BaseApplication.m2632b(), String.valueOf(10004), "nps_question_content_info"));
        return C0996a.m3612a(BaseApplication.m2632b(), String.valueOf(10004), "nps_question_content_info");
    }

    public void onCreate() {
        C2538c.m12677c("MessageCenterIntentService", "onCreate()");
        super.onCreate();
    }

    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public void onDestroy() {
        C2538c.m12677c("MessageCenterIntentService", "onDestroy()");
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    public MessageCenterIntentService(String str) {
        super(str);
    }

    public MessageCenterIntentService() {
        super("MigrateIntentService");
    }
}
