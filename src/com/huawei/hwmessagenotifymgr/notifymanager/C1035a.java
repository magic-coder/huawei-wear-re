package com.huawei.hwmessagenotifymgr.notifymanager;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ResolveInfo.DisplayNameComparator;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.huawei.hwbasemgr.C0628a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import java.util.Collections;
import java.util.List;

/* compiled from: HWNotificationMgr */
public class C1035a extends C0628a {
    private static C1035a f1928b = null;
    private Context f1929a = null;
    private boolean f1930c = false;

    private C1035a(Context context) {
        super(context);
        this.f1929a = context;
    }

    public boolean m4182a() {
        return this.f1930c;
    }

    public void m4179a(boolean z) {
        this.f1930c = z;
    }

    public void m4185b(boolean z) {
        Intent intent = new Intent("midware_phone_flag");
        intent.putExtra("phone_flag", z);
        this.f1929a.sendBroadcast(intent, C0976c.f1642a);
        C2538c.m12677c("HWNotificationMgr", "setForbiddenPhone : " + z);
    }

    public void m4186c(boolean z) {
        Intent intent = new Intent("com.huawei.midware_prompt_flag");
        intent.putExtra("prompt_flag", z);
        this.f1929a.sendBroadcast(intent, C0976c.f1642a);
        C2538c.m12677c("HWNotificationMgr", "setForbiddenPrompt : " + z);
    }

    protected Integer getModuleId() {
        return Integer.valueOf(2);
    }

    public static C1035a m4176b() {
        if (f1928b == null) {
            f1928b = new C1035a(BaseApplication.m2632b());
        }
        return f1928b;
    }

    public boolean m4187c() {
        C2538c.m12677c("HWNotificationMgr", "isEnabled pkgName : " + this.f1929a.getPackageName());
        Object string = Secure.getString(this.f1929a.getContentResolver(), "enabled_notification_listeners");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        String[] split = string.split(":");
        for (String unflattenFromString : split) {
            ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
            if (unflattenFromString2 != null) {
                C2538c.m12677c("HWNotificationMgr", "isEnabled cn.getPackageName : " + unflattenFromString2.getPackageName());
                if (TextUtils.equals(r3, unflattenFromString2.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int m4177a(String str) {
        Object a = C0996a.m3612a(this.f1929a, String.valueOf(10001), str);
        if (TextUtils.isEmpty(a)) {
            return 0;
        }
        return Integer.parseInt(a);
    }

    public void m4178a(String str, int i) {
        C0993c c0993c = new C0993c();
        c0993c.f1664a = 0;
        C0996a.m3611a(this.f1929a, String.valueOf(10001), str, String.valueOf(i), c0993c);
        if (m4187c()) {
            m4184b(str, i);
            return;
        }
        C2538c.m12674b("HWNotificationMgr", "not authorizeEnabled so return");
    }

    public void m4184b(String str, int i) {
        Uri parse = Uri.parse("content://com.huawei.HwNotificationContentProvider/NotificationList");
        ContentResolver contentResolver = this.f1929a.getContentResolver();
        if (m4175a(str, parse) && i == 0) {
            contentResolver.delete(parse, "name = ?", new String[]{str});
        } else if (!m4175a(str, parse) && i == 1) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentResolver.insert(parse, contentValues);
        }
    }

    private boolean m4175a(String str, Uri uri) {
        Cursor query = this.f1929a.getContentResolver().query(uri, null, null, null, null);
        if (query != null) {
            query.moveToFirst();
            while (query.moveToNext()) {
                if (TextUtils.equals(str, query.getString(query.getColumnIndex("name")))) {
                    query.close();
                    return true;
                }
            }
            query.close();
        }
        return false;
    }

    public void m4188d() {
        C2538c.m12674b("HWNotificationMgr", "enter deleteData");
        Uri parse = Uri.parse("content://com.huawei.HwNotificationContentProvider/NotificationList");
        ContentResolver contentResolver = this.f1929a.getContentResolver();
        Cursor query = contentResolver.query(parse, null, null, null, null);
        if (query != null) {
            query.moveToFirst();
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("name"));
                C2538c.m12674b("HWNotificationMgr", "deleteData has name:" + string);
                contentResolver.delete(parse, "name = ?", new String[]{string});
            }
            query.close();
        }
    }

    public int m4189e() {
        int i = -1;
        if (C1204c.m5370a(this.f1929a) == null) {
            C2538c.m12679d("HWNotificationMgr", "getProductType---HWDeviceConfigManager is null!!");
        } else if (C1204c.m5370a(this.f1929a).m5447c() != null) {
            i = C1204c.m5370a(this.f1929a).m5447c().getProductType();
        } else {
            C2538c.m12679d("HWNotificationMgr", "getProductType---getCurrentDeviceInfo is null!!");
        }
        C2538c.m12677c("HWNotificationMgr", "getProductType---ProductType is :" + i);
        return i;
    }

    public boolean m4190f() {
        if (C0972a.m3499a() != null) {
            return C0972a.m3499a().isMessage_alert();
        }
        C2538c.m12679d("HWNotificationMgr", "isSupportPush---CapabilityUtils.getDeviceCapability() is null!!");
        return true;
    }

    public boolean onDataMigrate() {
        C2538c.m12677c("HWNotificationMgr", "=====HWNotificationMgr====onDataMigrate=========================");
        SharedPreferences sharedPreferences = this.f1929a.getSharedPreferences("notification_setting_preferences", 0);
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        PackageManager packageManager = this.f1929a.getPackageManager();
        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        Collections.sort(queryIntentActivities, new DisplayNameComparator(packageManager));
        for (int i = 0; i < queryIntentActivities.size(); i++) {
            ActivityInfo activityInfo = ((ResolveInfo) queryIntentActivities.get(i)).activityInfo;
            String str = activityInfo.packageName;
            if (!TextUtils.equals(str, activityInfo.loadLabel(packageManager).toString())) {
                int i2 = sharedPreferences.getInt(str, 0);
                if (i2 == 1) {
                    C2538c.m12674b("HWNotificationMgr", "=====HWNotificationMgr====onDataMigrate=====" + r0 + "====" + str + "===" + i);
                    m4178a(str, i2);
                }
            }
        }
        return true;
    }

    public void m4181a(boolean z, boolean z2) {
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(33);
        deviceCommand.setCommandID(1);
        byte[] a = m4183a(Boolean.valueOf(z), z2);
        deviceCommand.setDataLen(a.length);
        deviceCommand.setDataContent(a);
        C1204c.m5370a(BaseApplication.m2632b()).m5427a(deviceCommand);
    }

    public byte[] m4183a(Boolean bool, boolean z) {
        int i;
        int i2;
        String str = "";
        StringBuffer stringBuffer = new StringBuffer();
        if (bool.booleanValue()) {
            i = 1;
        } else {
            i = 0;
        }
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        String str2 = C0973a.m3506a(2) + C0973a.m3506a(2) + C0973a.m3506a(1) + C0973a.m3506a(i);
        String str3 = C0973a.m3506a(2) + C0973a.m3506a(2) + C0973a.m3506a(2) + C0973a.m3506a(1);
        stringBuffer.append(str2).append(str3).append(C0973a.m3506a(2) + C0973a.m3506a(2) + C0973a.m3506a(3) + C0973a.m3506a(i2));
        C2538c.m12674b("HWNotificationMgr", "packageCommond:" + (C0973a.m3506a(129) + C0973a.m3506a(stringBuffer.toString().length() / 2) + stringBuffer.toString()));
        return C0973a.m3512b(C0973a.m3506a(129) + C0973a.m3506a(stringBuffer.toString().length() / 2) + stringBuffer.toString());
    }

    public boolean m4191g() {
        if (C1204c.m5370a(this.f1929a) != null) {
            return C1204c.m5370a(this.f1929a).m5450d();
        }
        return true;
    }

    public void m4180a(boolean z, IBaseResponseCallback iBaseResponseCallback) {
        C2538c.m12677c("HWNotificationMgr", "setRotateSwitchScreenSwitchStatus() Status " + z);
        if (C1204c.m5370a(this.f1929a) != null) {
            C1204c.m5370a(this.f1929a).m5437a(z, iBaseResponseCallback);
            return;
        }
        C2538c.m12679d("HWNotificationMgr", "setWearPushSwitchStatus()---HWDeviceConfigManager is null!!");
    }
}
