package com.huawei.ad.p314b;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.huawei.ab.m;
import com.huawei.ad.p313a.C3984a;
import com.huawei.af.C3991a;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcloudmodel.p061c.C4688c;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdevicemgr.dmsdatatype.datatype.DeviceCommand;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

/* compiled from: HWWeatherMgr */
public class C3985a extends a {
    private static C3985a f15231c = null;
    private static final Object f15232f = new Object();
    boolean f15233a = true;
    private Context f15234b;
    private c f15235d;
    private C4688c f15236e = null;
    private IBaseResponseCallback f15237g = new C3987c(this);

    protected Integer getModuleId() {
        return Integer.valueOf(15);
    }

    private C3985a(Context context) {
        super(context);
        this.f15234b = context;
        this.f15235d = c.a(context);
        if (this.f15235d == null) {
            C2538c.e("HWWeatherMgr", new Object[]{"mHWDeviceConfigManager is null"});
            return;
        }
        this.f15235d.a(15, this.f15237g);
    }

    public static C3985a m19730a(Context context) {
        C3985a c3985a;
        synchronized (f15232f) {
            if (f15231c == null) {
                f15231c = new C3985a(BaseApplication.b());
            }
            c3985a = f15231c;
        }
        return c3985a;
    }

    public boolean m19741a() {
        Object a = m.a(this.f15234b).a(5);
        C2538c.c("HWWeatherMgr", new Object[]{"getWeatherSwitchStatus,switchStatus-----------" + a});
        if (TextUtils.isEmpty(a)) {
            this.f15233a = true;
        } else {
            this.f15233a = Boolean.parseBoolean(a);
            C2538c.c("HWWeatherMgr", new Object[]{"getWeatherSwitchStatus,mWeatherSwitch-----------" + this.f15233a});
        }
        return this.f15233a;
    }

    public void m19740a(boolean z) {
        C2538c.c("HWWeatherMgr", new Object[]{"setWeatherSwitchStatus,enable-----------" + z});
        this.f15233a = z;
        new com.huawei.hwdataaccessmodel.a.c().a = 0;
        m a = m.a(this.f15234b);
        if (a != null) {
            a.a(5, z, "", new C3986b(this));
            C3991a a2 = C3991a.m19745a(this.f15234b);
            if (a2 == null) {
                C2538c.e("HWWeatherMgr", new Object[]{"hWCombineMigrateMgr is null"});
                return;
            }
            a2.m19766d(String.valueOf(z), false);
        }
    }

    public void m19739a(C4688c c4688c) {
        C2538c.c("HWWeatherMgr", new Object[]{"setWeatherData,mWeatherSwitch-----------" + this.f15233a});
        if (C0973a.a.a() == null) {
            C2538c.e("HWWeatherMgr", new Object[]{"setWeatherData---mHWDeviceConfigManager.capabilityNegotiation() is null!!"});
        } else if (!C0973a.a.a().isWeather_push()) {
            C2538c.e("HWWeatherMgr", new Object[]{"setWeatherData---this device not support weather push!!"});
        } else if (!this.f15233a) {
        } else {
            if (c4688c == null) {
                C2538c.e("HWWeatherMgr", new Object[]{"setWeatherData----dataWeather is null!"});
                return;
            }
            this.f15236e = c4688c;
            C2538c.c("HWWeatherMgr", new Object[]{"setWeatherData-----------", this.f15236e.toString()});
            m19738b();
        }
    }

    private void m19738b() {
        String str = C0973a.a(1) + C0973a.a(0);
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(15);
        deviceCommand.setCommandID(2);
        deviceCommand.setNeedEncrypt(false);
        deviceCommand.setDataContent(C0973a.b(str));
        deviceCommand.setDataLen(C0973a.b(str).length);
        C2538c.c("HWWeatherMgr", new Object[]{"getWeatherConstraintMsg, deviceCommand----", deviceCommand.toString()});
        this.f15235d.a(deviceCommand);
    }

    private C3984a m19728a(byte b) {
        C3984a c3984a = new C3984a();
        String b2 = m19737b(b);
        C2538c.c("HWWeatherMgr", new Object[]{"getWeatherSupport------------------" + b2});
        String str = b2.charAt(7) + "";
        String str2 = b2.charAt(6) + "";
        String str3 = b2.charAt(5) + "";
        b2 = b2.charAt(4) + "";
        C2538c.c("HWWeatherMgr", new Object[]{"bit0_weather------------------" + str});
        C2538c.c("HWWeatherMgr", new Object[]{"bit1_wind---------------------" + str2});
        C2538c.c("HWWeatherMgr", new Object[]{"bit2_pm2_5--------------------" + str3});
        C2538c.c("HWWeatherMgr", new Object[]{"bit3_temperature--------------" + b2});
        if (str.equals("1")) {
            c3984a.m19720a(true);
        }
        if (str2.equals("1")) {
            c3984a.m19722b(true);
        }
        if (str3.equals("1")) {
            c3984a.m19724c(true);
        }
        if (b2.equals("1")) {
            c3984a.m19726d(true);
        }
        return c3984a;
    }

    private String m19737b(byte b) {
        return "" + ((byte) ((b >> 7) & 1)) + ((byte) ((b >> 6) & 1)) + ((byte) ((b >> 5) & 1)) + ((byte) ((b >> 4) & 1)) + ((byte) ((b >> 3) & 1)) + ((byte) ((b >> 2) & 1)) + ((byte) ((b >> 1) & 1)) + ((byte) ((b >> 0) & 1));
    }

    private String m19734a(C4688c c4688c, C3984a c3984a) {
        if (c4688c == null || c3984a == null) {
            return null;
        }
        String str = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        if (c3984a.m19721a()) {
            C2538c.c("HWWeatherMgr", new Object[]{"Weather", "weather.getWeather() = " + c4688c.m22453e()});
            str2 = C0973a.a(2) + C0973a.a(1) + C0973a.a(c4688c.m22453e());
            C2538c.c("HWWeatherMgr", new Object[]{"Weather", "weatherTLVHex--------------" + str2});
        }
        if (c3984a.m19723b()) {
            str3 = C0973a.a(3) + C0973a.a(2) + C0973a.a(c4688c.m22455f()) + C0973a.a(c4688c.m22456g());
        }
        String a = m19732a((str2 + str3).length() / 2);
        if (a.length() != 0) {
            str = C0973a.a(129);
        }
        a = str + a;
        if (!c3984a.m19725c() || -1 == c4688c.m22447b()) {
            str = str4;
        } else {
            str = C0973a.a(4) + C0973a.a(2) + C0973a.b(c4688c.m22447b());
        }
        if (c3984a.m19727d()) {
            str6 = C0973a.a(133) + C0973a.a(6);
            str7 = C0973a.a(6) + C0973a.a(1) + C0973a.a(c4688c.m22449c());
            str4 = C0973a.a(7) + C0973a.a(1) + C0973a.a(c4688c.m22451d());
        } else {
            str4 = str7;
            str7 = str6;
            str6 = str5;
        }
        return a + str2 + str3 + str + str6 + str7 + str4;
    }

    private void m19736a(String str) {
        C2538c.c("HWWeatherMgr", new Object[]{"pushWeatherToDevice, cmd----", str});
        DeviceCommand deviceCommand = new DeviceCommand();
        deviceCommand.setServiceID(15);
        deviceCommand.setCommandID(1);
        deviceCommand.setNeedEncrypt(false);
        deviceCommand.setDataContent(C0973a.b(str));
        deviceCommand.setDataLen(C0973a.b(str).length);
        this.f15235d.a(deviceCommand);
    }

    private String m19732a(int i) {
        if (i <= 127) {
            return C0973a.a(i);
        }
        return C0973a.a((i >> 7) + 128) + C0973a.a(i & 127);
    }

    public boolean onDataMigrate() {
        C2538c.c("HWWeatherMgr", new Object[]{"=====HWWeatherMgr====onDataMigrate========================="});
        m19740a(Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this.f15234b).getBoolean("weather_push_flag", true)).booleanValue());
        return true;
    }
}
