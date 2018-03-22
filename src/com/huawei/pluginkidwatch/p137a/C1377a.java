package com.huawei.pluginkidwatch.p137a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcloudmodel.model.kidsdevice.GetManagerNumRsp;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.p063b.C0976c;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.entity.C1417a;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.entity.model.BindDeviceInfosIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.model.DeviceProfile;
import com.huawei.pluginkidwatch.common.entity.model.PhoneNumIOEntityModel;
import com.huawei.pluginkidwatch.common.entity.p139a.C1414c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1395k;
import com.huawei.pluginkidwatch.plugin.setting.activity.KidWatchProtocolAndClauseActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;

/* compiled from: KidWatchUtil */
public class C1377a {
    private static C1377a f2968b;
    private Context f2969a;

    private C1377a(Context context) {
        this.f2969a = context;
    }

    public static C1377a m6165a(Context context) {
        if (f2968b == null) {
            f2968b = new C1377a(context);
        }
        return f2968b;
    }

    public void m6176a() {
        String f = C1093a.m4739a(this.f2969a).m4753f();
        String c = C1093a.m4739a(this.f2969a).m4750c();
        C2538c.m12674b("KidWatchUtil", "============Enter loadDeviceInfos token = " + f + ", huid = " + c);
        if (!TextUtils.isEmpty(c)) {
            C1497q.m6942a(this.f2969a, "sharedpreferences_watch_kid_isbinded", Boolean.valueOf(false));
            C1497q.m6942a(this.f2969a, "sharedpreferences_watch_kid2_isbinded", Boolean.valueOf(false));
            C1462f.m6719a(f);
            C1497q.m6943a(this.f2969a, "cloud_access_token", f);
            C1497q.m6943a(this.f2969a, "huawei_huid", c);
            C1414c c1414c = (C1414c) C1417a.m6594a(this.f2969a);
            C2538c.m12674b("KidWatchUtil", "============getBindDeviceInfos = " + new BindDeviceInfosIOEntityModel().toString());
            c1414c.mo2472a(r3, new C1379b(this, c));
            C1395k a = C1392h.m6269a(this.f2969a, C1462f.m6744i(), C1462f.m6746j());
            C2538c.m12674b("KidWatchUtil", "===www===login get bindDeviceInfos===" + a);
            C2538c.m12674b("KidWatchUtil", "===www===KWCache.getHuaweiHuid()===" + C1462f.m6744i());
            C2538c.m12674b("KidWatchUtil", "===www===KWCache.getDeviceCode()===" + C1462f.m6746j());
            C1377a.m6171b(this.f2969a);
            if ("".equals(C1497q.m6945b(this.f2969a, "push_access_token", ""))) {
                C2538c.m12674b("KidWatchUtil", "pushToken error,rigth it again");
                C1497q.m6943a(this.f2969a, "cloud_access_token", f);
            }
        }
    }

    private void m6169a(BindDeviceInfosIOEntityModel bindDeviceInfosIOEntityModel, String str) {
        List<DeviceProfile> list = bindDeviceInfosIOEntityModel.deviceProfiles;
        if (list != null) {
            if (list.size() == 0) {
                C1392h.m6298b(this.f2969a, str);
                return;
            }
            C1392h.m6280a(this.f2969a, str, (List) list);
            for (DeviceProfile deviceProfile : list) {
                if (deviceProfile != null) {
                    C2538c.m12674b("KidWatchUtil", "============getBindDeviceInfos deviceInfo==" + deviceProfile.toString());
                    C1377a.m6166a(this.f2969a, deviceProfile, str);
                    C2538c.m12674b("KidWatchUtil", "============getBindDeviceInfos deviceInfo.data1==" + deviceProfile.deviceType);
                    if (1 == deviceProfile.deviceType) {
                        C1497q.m6942a(this.f2969a, "sharedpreferences_watch_kid2_isbinded", Boolean.valueOf(true));
                    } else {
                        C1497q.m6942a(this.f2969a, "sharedpreferences_watch_kid_isbinded", Boolean.valueOf(true));
                    }
                }
            }
        }
        BaseApplication.m2632b().sendBroadcast(new Intent("com.huawei.bone.action.ACTION_GET_KIDWATCH_SUCCESS"), C0976c.f1642a);
    }

    private static void m6171b(Context context) {
        C1497q.m6942a(context, "sharedpreferences_exist_phone_number", Boolean.valueOf(false));
        C1414c c1414c = (C1414c) C1417a.m6594a(context);
        c1414c.mo2509b(new PhoneNumIOEntityModel(), new C1380c(c1414c, context));
    }

    private static void m6172b(C1414c c1414c, Context context) {
        c1414c.m6548a(new C1381d(context));
    }

    private static void m6174c(String str) {
        try {
            GetManagerNumRsp getManagerNumRsp = (GetManagerNumRsp) new Gson().fromJson(str, GetManagerNumRsp.class);
            int i = -1;
            if (getManagerNumRsp != null) {
                i = getManagerNumRsp.getResultCode();
            }
            switch (i) {
                case 0:
                    String managerPhoneNum = getManagerNumRsp.getManagerPhoneNum();
                    C2538c.m12677c("KidWatchUtil", "matb requestPhoneNumber sucess is false!!! phoneNum = " + managerPhoneNum);
                    return;
                case 13234:
                    C2538c.m12677c("KidWatchUtil", "matb resetManager sucess is false contacts non existent!!!");
                    return;
                default:
                    C2538c.m12677c("KidWatchUtil", "matb resetManager sucess is false unknow error!!!  resultCode = " + i);
                    return;
            }
        } catch (JsonSyntaxException e) {
            C2538c.m12677c("KidWatchUtil", "matb resetManager sucess is false json exception :" + e.getMessage());
        }
        C2538c.m12677c("KidWatchUtil", "matb resetManager sucess is false json exception :" + e.getMessage());
    }

    private static void m6175d(String str) {
        try {
            GetManagerNumRsp getManagerNumRsp = (GetManagerNumRsp) new Gson().fromJson(str, GetManagerNumRsp.class);
            int i = -1;
            if (getManagerNumRsp != null) {
                i = getManagerNumRsp.getResultCode();
            }
            switch (i) {
                case 0:
                    String managerPhoneNum = getManagerNumRsp.getManagerPhoneNum();
                    C2538c.m12677c("KidWatchUtil", "matb requestPhoneNumber sucess!!! phoneNum = " + managerPhoneNum);
                    return;
                default:
                    C2538c.m12677c("KidWatchUtil", "matb resetManager sucess unknow error!!!  resultCode = " + i);
                    return;
            }
        } catch (JsonSyntaxException e) {
            C2538c.m12677c("KidWatchUtil", "matb resetManager sucess  json exception :" + e.getMessage());
        }
    }

    private static void m6166a(Context context, DeviceProfile deviceProfile, String str) {
        C2538c.m12674b("KidWatchUtil", "============saveProfileToDB");
        if (!TextUtils.isEmpty(str) && deviceProfile != null) {
            C1395k c1395k = new C1395k();
            c1395k.f3081a = str;
            c1395k.f3097q = deviceProfile.primaryHuid;
            c1395k.f3082b = deviceProfile.deviceCode;
            c1395k.f3083c = deviceProfile.name;
            c1395k.f3088h = deviceProfile.birthday;
            c1395k.f3089i = deviceProfile.height;
            c1395k.f3090j = deviceProfile.weight;
            c1395k.f3091k = deviceProfile.sex;
            c1395k.f3093m = deviceProfile.simCardNum;
            c1395k.f3099s = deviceProfile.deviceType + "";
            C1392h.m6287a(context, str, c1395k, false);
        }
    }

    public boolean m6178b() {
        ArrayList a = C1392h.m6272a(this.f2969a, C1093a.m4739a(this.f2969a).m4750c());
        if (a == null) {
            return false;
        }
        Iterator it = a.iterator();
        while (it.hasNext()) {
            C1395k c1395k = (C1395k) it.next();
            if (c1395k != null) {
                int parseInt;
                C2538c.m12674b("KidWatchUtil", "isExistK1  deviceInfoTable = " + c1395k.toString());
                try {
                    parseInt = Integer.parseInt(c1395k.f3099s);
                } catch (NumberFormatException e) {
                    C2538c.m12674b("KidWatchUtil", "isExistK1... NumberFormatException e = " + e.getMessage());
                    parseInt = 0;
                }
                C2538c.m12674b("KidWatchUtil", "isExistK1 type:" + parseInt);
                if (parseInt == 0 || -1 == parseInt) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean m6179c() {
        ArrayList a = C1392h.m6272a(this.f2969a, C1093a.m4739a(this.f2969a).m4750c());
        if (a == null) {
            return false;
        }
        Iterator it = a.iterator();
        while (it.hasNext()) {
            C1395k c1395k = (C1395k) it.next();
            if (c1395k != null) {
                int parseInt;
                C2538c.m12674b("KidWatchUtil", " isExistK2 deviceInfoTable = " + c1395k.toString());
                try {
                    parseInt = Integer.parseInt(c1395k.f3099s);
                } catch (NumberFormatException e) {
                    C2538c.m12674b("KidWatchUtil", "isExistK2... NumberFormatException e = " + e.getMessage());
                    parseInt = 0;
                }
                C2538c.m12674b("KidWatchUtil", "isExistK2 type:" + parseInt);
                if (1 == parseInt) {
                    return true;
                }
            }
        }
        return false;
    }

    public void m6180d() {
        C2538c.m12674b("KidWatchUtil", "==============startPushService");
        C1497q.m6942a(this.f2969a, "k1pushtokenflag", Boolean.valueOf(false));
        new Thread(new C1382e(this)).start();
    }

    public void m6177a(int i) {
        C2538c.m12674b("KidWatchUtil", "点击设备列表选择小K，直接跳转到HomeActivity");
        m6180d();
        Intent intent = new Intent();
        intent.setClassName(this.f2969a, "com.huawei.pluginkidwatch.home.HomeActivity");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("intent_kidwatch_device_type", i);
        this.f2969a.startActivity(intent);
    }

    public void m6181e() {
        m6180d();
        Intent intent = new Intent();
        intent.setClass(this.f2969a.getApplicationContext(), KidWatchProtocolAndClauseActivity.class);
        intent.setPackage(this.f2969a.getPackageName());
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        this.f2969a.startActivity(intent);
    }
}
