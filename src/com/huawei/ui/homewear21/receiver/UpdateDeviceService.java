package com.huawei.ui.homewear21.receiver;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import com.huawei.bone.C6753R;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.ui.device.p170a.C1990r;
import com.huawei.ui.device.p170a.ah;
import com.huawei.ui.main.stories.messagecenter.interactors.C2422e;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UpdateDeviceService extends Service {
    private Context f8260a = null;
    private ExecutorService f8261b = Executors.newFixedThreadPool(1);
    private String f8262c = "";
    private int f8263d = 0;
    private String f8264e = "";
    private final BroadcastReceiver f8265f = new C2275a(this);

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        C2538c.m12677c("UpdateDeviceService", "enter_onCreate");
        this.f8260a = getApplicationContext();
        m11710a(this.f8260a);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        C2538c.m12677c("UpdateDeviceService", "onStartCommand = " + intent);
        m11711a(intent);
        return 2;
    }

    private void m11711a(Intent intent) {
        if (intent != null) {
            C2538c.m12677c("UpdateDeviceService", "handleIntent: action = " + intent.getAction());
            if ("com.huawei.update.device.version".equals(intent.getAction()) && C1990r.m10400a(this.f8260a).m10411a() != null && C1990r.m10400a(this.f8260a).m10411a().isOta_update()) {
                C2538c.m12677c("UpdateDeviceService", "enter_autoCheckBandNewVersionService");
                ah.m10316a(this.f8260a).m10334c();
            }
        }
    }

    private void m11710a(Context context) {
        C2538c.m12677c("UpdateDeviceService", "registerAutoCheckBroadcast()");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_band_auto_check_new_version_result");
        context.getApplicationContext().registerReceiver(this.f8265f, intentFilter, C0976c.f1642a, null);
    }

    public void m11717a() {
        C2538c.m12677c("UpdateDeviceService", "start_makeMessage");
        MessageObject messageObject = new MessageObject();
        messageObject.setModule("device");
        String string = this.f8260a.getString(C6753R.string.IDS_messagecenter_device_need_upgrade_title);
        String str = "";
        DeviceInfo c = C1204c.m5370a(this.f8260a).m5447c();
        if (c != null) {
            C2538c.m12677c("UpdateDeviceService", "getCurrentDeviceInfo() mDeviceName = " + c.getDeviceName());
        }
        C2538c.m12677c("UpdateDeviceService", "mstTitle === " + String.format(string, new Object[]{str}));
        messageObject.setMsgTitle(str);
        messageObject.setMsgContent("");
        messageObject.setMsgId("D201710261048");
        messageObject.setWeight(1);
        messageObject.setCreateTime(System.currentTimeMillis());
        messageObject.setDetailUri("messagecenter://device_ota");
        C2538c.m12677c("UpdateDeviceService", "end_to_set_message");
        C2422e c2422e = new C2422e(this.f8260a, messageObject);
        C2538c.m12677c("UpdateDeviceService", "mcNotificationManager =  " + c2422e);
        c2422e.m12174a(20171027);
        c2422e.m12175a(20171027);
        C2538c.m12677c("UpdateDeviceService", "end_makeMessage");
    }

    public void onDestroy() {
        C2538c.m12677c("UpdateDeviceService", "onDestroy");
        super.onDestroy();
        if (this.f8265f != null) {
            unregisterReceiver(this.f8265f);
        }
    }

    public static void m11712a(String str, Context context) {
        C2538c.m12677c("UpdateDeviceService", "setAppRestartCheckTime,time-----------" + str);
        Editor edit = context.getSharedPreferences("deviceUpdateSharedPreferences", 0).edit();
        edit.putString("deviceUpdateCheckTime", str);
        edit.commit();
    }

    public static String m11714b() {
        C2538c.m12677c("TAG", "getCurrentTime: strCurTime");
        try {
            C2538c.m12677c("TAG", "getCurrentTime: strCurTime = " + new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Calendar.getInstance().getTime()));
            return new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Calendar.getInstance().getTime());
        } catch (Exception e) {
            C2538c.m12677c("TAG", "Exception e = " + e.getMessage());
            return null;
        }
    }
}
