package com.huawei.ui.main.stories.about.p179a;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.n.a;
import com.huawei.n.b;
import com.huawei.nfc.carrera.ui.dialog.PayManagerSettingSwitchDialog;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.j;

/* compiled from: HelpInteractor */
public class C2286h {
    private static volatile C2286h f8291a = null;
    private DeviceInfo f8292b;
    private final Object f8293c = new Object();

    private C2286h() {
    }

    public static C2286h m11749a() {
        if (f8291a == null) {
            synchronized (C2286h.class) {
                if (f8291a == null) {
                    f8291a = new C2286h();
                }
            }
        }
        return f8291a;
    }

    public String m11754a(Context context) {
        String string = context.getString(j.IDS_app_help_b2_url_temp);
        this.f8292b = C1204c.m5370a(context).m5447c();
        if (this.f8292b == null) {
            C2538c.m12674b("HelpInteractor", "adaptUrl() -> null == mCurrentDeviceInfo");
        } else {
            Configuration configuration = context.getResources().getConfiguration();
            String language = configuration.locale.getLanguage();
            String str = language + "-" + configuration.locale.getCountry();
            switch (this.f8292b.getProductType()) {
                case 1:
                    string = m11751a(str, context, language);
                    C2538c.m12674b("HelpInteractor", "===www==aboutHelp b2 url = " + string);
                    break;
                case 3:
                    string = m11752b(str, context);
                    C2538c.m12674b("HelpInteractor", "===www===aboutHelp W1 url = " + string);
                    break;
                case 5:
                    string = m11752b(str, context);
                    C2538c.m12674b("HelpInteractor", "===www===aboutHelp b0 url = " + string);
                    break;
                case 7:
                    string = m11750a(str, context);
                    C2538c.m12674b("HelpInteractor", "===www===aboutHelp b3 url = " + string);
                    break;
                case 8:
                    string = m11750a(str, context);
                    C2538c.m12674b("HelpInteractor", "===www===aboutHelp Metis url = " + string);
                    break;
                case 10:
                    string = m11752b(str, context);
                    C2538c.m12674b("HelpInteractor", "===www===aboutHelp LEO url = " + string);
                    break;
                case 11:
                    string = m11750a(str, context);
                    C2538c.m12674b("HelpInteractor", "===www===aboutHelp AM-R1 url = " + string);
                    break;
                case 12:
                    string = m11750a(str, context);
                    C2538c.m12674b("HelpInteractor", "===www===aboutHelp A1 url = " + string);
                    break;
                case 13:
                    string = m11750a(str, context);
                    C2538c.m12674b("HelpInteractor", "===www===aboutHelp NYX url = " + string);
                    break;
                case 14:
                    string = m11750a(str, context);
                    C2538c.m12674b("HelpInteractor", "===www===aboutHelp grus url = " + string);
                    break;
                case 15:
                    string = m11750a(str, context);
                    C2538c.m12674b("HelpInteractor", "===www===aboutHelp Eris url = " + string);
                    break;
            }
            C2538c.m12674b("HelpInteractor", "===www===adaptUrl() -> url = " + string);
        }
        return string;
    }

    public String m11756b(Context context) {
        String str;
        synchronized (this.f8293c) {
            str = "";
            String country = context.getResources().getConfiguration().locale.getCountry();
            switch (this.f8292b.getProductType()) {
                case 1:
                    str = "b2";
                    break;
                case 3:
                    str = "huawei-watch";
                    break;
                case 5:
                    if (!"RU".equals(country) && !"FR".equals(country) && !"IN".equals(country)) {
                        str = "b0";
                        break;
                    }
                    str = "b0-honor";
                    break;
                    break;
                case 7:
                    str = "b3";
                    break;
                case 8:
                    str = "Metis";
                    break;
                case 10:
                    str = "huawei-watch2";
                    break;
                case 11:
                    str = "AM-R1";
                    break;
                case 12:
                    str = "AW61";
                    break;
                case 13:
                    str = "band3";
                    break;
                case 14:
                    str = "grus";
                    break;
                case 15:
                    str = "band2";
                    break;
            }
        }
        return str;
    }

    public String m11753a(int i) {
        String str = "Unknown";
        b a = a.a(i);
        if (!TextUtils.isEmpty(a.j())) {
            str = a.j();
        }
        C2538c.m12674b("HelpInteractor", "transDeviceProductTypeIntToStr: mDeviceProductType = " + str);
        return str;
    }

    public DeviceInfo m11755b() {
        return C0972a.m3502b();
    }

    private String m11751a(String str, Context context, String str2) {
        String b = m11756b(context);
        C2538c.m12674b("HelpInteractor", "enter getHelpURLForB2 :" + str + "devicename:" + b + "location:" + str2);
        if (TextUtils.equals(str, PayManagerSettingSwitchDialog.LOCALE_ABROAD) || TextUtils.equals(str, "zh-CN")) {
            C2538c.m12674b("HelpInteractor", "getHelpUrlForB2 url :" + String.format("http://health.vmall.com/help/%s/app2.1/%s/index.html", new Object[]{b, str2}));
            return String.format("http://health.vmall.com/help/%s/app2.1/%s/index.html", new Object[]{b, str2});
        }
        C2538c.m12674b("HelpInteractor", "getHelpUrlForB2 else url :" + String.format("http://health.vmall.com/help/%s/app2.1/%s/index.html", new Object[]{b, "en"}));
        return String.format("http://health.vmall.com/help/%s/app2.1/%s/index.html", new Object[]{b, "en"});
    }

    private String m11750a(String str, Context context) {
        String b = m11756b(context);
        C2538c.m12674b("HelpInteractor", "enter getHelpUrl :" + str + "devicename:" + b);
        if (TextUtils.equals(str, PayManagerSettingSwitchDialog.LOCALE_ABROAD) || TextUtils.equals(str, "zh-CN") || TextUtils.equals(str, "zh-rCN")) {
            C2538c.m12674b("HelpInteractor", "getHelpUrl url :" + String.format("http://health.vmall.com/help/%s/app2.1/%s/index.html", new Object[]{b, str}));
            return String.format("http://health.vmall.com/help/%s/app2.1/%s/index.html", new Object[]{b, str});
        }
        C2538c.m12674b("HelpInteractor", "getHelpUrl else url :" + String.format("http://health.vmall.com/help/%s/app2.1/%s/index.html", new Object[]{b, PayManagerSettingSwitchDialog.LOCALE_ABROAD}));
        return String.format("http://health.vmall.com/help/%s/app2.1/%s/index.html", new Object[]{b, PayManagerSettingSwitchDialog.LOCALE_ABROAD});
    }

    private String m11752b(String str, Context context) {
        String b = m11756b(context);
        C2538c.m12674b("HelpInteractor", "enter getHelpUrlNew :" + str + "devicename:" + b);
        if (TextUtils.equals(str, PayManagerSettingSwitchDialog.LOCALE_ABROAD) || TextUtils.equals(str, "zh-CN")) {
            C2538c.m12674b("HelpInteractor", "getHelpUrlNew url :" + String.format("http://health.vmall.com/help/%s/app2.1/%s/index.html", new Object[]{b, str}));
            return String.format("http://health.vmall.com/help/%s/app2.1/%s/index.html", new Object[]{b, str});
        }
        C2538c.m12674b("HelpInteractor", "getHelpUrlNew else url :" + String.format("http://health.vmall.com/help/%s/app2.1/%s/index.html", new Object[]{b, PayManagerSettingSwitchDialog.LOCALE_ABROAD}));
        return String.format("http://health.vmall.com/help/%s/app2.1/%s/index.html", new Object[]{b, PayManagerSettingSwitchDialog.LOCALE_ABROAD});
    }
}
