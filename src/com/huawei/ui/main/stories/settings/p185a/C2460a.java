package com.huawei.ui.main.stories.settings.p185a;

import android.content.Context;
import com.huawei.ab.C0630m;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.ui.main.j;

/* compiled from: PersonalPrivacySettingsInteractors */
public class C2460a {
    private static final String f8834a = C2460a.class.getSimpleName();
    private static C2460a f8835b;
    private Context f8836c;
    private C1971j f8837d = C1971j.m10236a(this.f8836c);
    private C0630m f8838e = C0630m.m2297a(this.f8836c);

    private C2460a(Context context) {
        this.f8836c = context;
    }

    public static C2460a m12288a(Context context) {
        if (f8835b == null) {
            f8835b = new C2460a(context);
        }
        return f8835b;
    }

    public void m12299a(String str, boolean z) {
        if (z) {
            m12294c(str);
        } else {
            m12292b(str);
        }
    }

    private String m12290a(String str) {
        String str2 = "";
        if ("special_type_fitness_data".equals(str)) {
            str2 = this.f8836c.getString(j.IDS_messagecenter_sport_health_data_sync_title);
        }
        C2538c.m12677c(f8834a, "title = " + str2);
        return str2;
    }

    private void m12292b(String str) {
        if (!"special_type_profile_data".equals(str)) {
            C2538c.m12677c(f8834a, "Enter generatePersonalPrivacyMessage !!!");
            this.f8837d.m10247a("special", str, new C2461b(this, str));
        }
    }

    private void m12294c(String str) {
        this.f8837d.m10247a("special", str, new C2463d(this, str));
    }

    public String m12295a(int i) {
        return this.f8838e.m2302a(i);
    }

    public void m12298a(int i, boolean z) {
        C2538c.m12677c(f8834a, "setPersonalPrivacySettingValue... privacyId = " + i + ", isOpen = " + z);
        this.f8838e.m2304a(i, z, f8834a, new C2464e(this));
    }

    public void m12297a(int i, IBaseResponseCallback iBaseResponseCallback) {
        this.f8838e.m2304a(i, true, f8834a, iBaseResponseCallback);
    }

    public void m12296a() {
        this.f8838e.m2313b();
    }

    public void m12300b() {
        C2538c.m12677c(f8834a, "checkPersonalPrivacySettingMessageCenter... Enter");
        m12299a("special_type_profile_data", true);
        m12299a("special_type_fitness_data", true);
        if (this.f8838e.m2319d()) {
            String a = m12295a(4);
            String a2 = m12295a(2);
            String a3 = m12295a(3);
            C2538c.m12677c(f8834a, "checkPersonalPrivacySettingMessageCenter... privacyBluetooth = " + a + ", privacyBaseInfo = " + a2 + ", privacySportData = " + a3);
            if ("false".equals(a)) {
                m12299a("special_type_device_data", false);
            } else if ("true".equals(a)) {
                m12299a("special_type_device_data", true);
            }
            this.f8838e.m2310a(false);
            return;
        }
        C2538c.m12677c(f8834a, "checkPersonalPrivacySettingMessageCenter... upgraded = false");
    }
}
