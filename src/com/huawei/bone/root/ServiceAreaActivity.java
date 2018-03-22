package com.huawei.bone.root;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.bone.C6753R;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwdatamigrate.a.h;
import com.huawei.hwdatamigrate.common.b;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.base.BaseActivity;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class ServiceAreaActivity extends BaseActivity {
    private TextView f23267a = null;
    private LinearLayout f23268b = null;
    private Context f23269c;
    private boolean f23270d = false;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2538c.b("ServiceAreaActivity", new Object[]{"onCreate()"});
        this.f23269c = this;
        if (getIntent() != null) {
            this.f23270d = getIntent().getBooleanExtra("splash_start_mode", false);
            C2538c.b("ServiceAreaActivity", new Object[]{"onCreate() mStartMode = " + this.f23270d});
        }
        setContentView(C6753R.layout.service_area_layout);
        m30166c();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i && i2 == 0) {
            if (intent != null) {
                Bundle extras = intent.getExtras();
                String str = "";
                str = "";
                if (!(extras == null || this.f23267a == null)) {
                    String string = extras.getString("service_area_country");
                    this.f23267a.setText(string);
                    str = b.h(string);
                    C2538c.c("ServiceAreaActivity", new Object[]{"onActivityResult, mCountryText = " + string + "  strCountry = " + str});
                }
            } else {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    private String m30165b() {
        String g = b.g(h.d(this));
        if (g == null || g.isEmpty()) {
            List<String> a = m30163a();
            if (a != null && a.size() > 0) {
                String str = (String) a.get(0);
                String displayCountry = getResources().getConfiguration().locale.getDisplayCountry();
                for (String g2 : a) {
                    if (g2.equalsIgnoreCase(displayCountry)) {
                        break;
                    }
                }
                g2 = str;
                C2538c.c("ServiceAreaActivity", new Object[]{"initServiceAreaView(), strCountryCode=" + r2 + ", strDisplayCountry=" + g2});
            }
        }
        return g2;
    }

    private void m30166c() {
        this.f23267a = (TextView) findViewById(C6753R.id.service_area_country);
        CharSequence g = b.g(d.c(this));
        if (TextUtils.isEmpty(g)) {
            g = m30165b();
        }
        this.f23267a.setText(g);
        this.f23268b = (LinearLayout) findViewById(C6753R.id.service_area_country_layout);
        this.f23268b.setOnClickListener(new ac(this));
        ((Button) findViewById(C6753R.id.service_area_cancel_bottom)).setOnClickListener(new ad(this));
        ((Button) findViewById(C6753R.id.service_area_agree_bottom)).setOnClickListener(new ae(this));
    }

    public static List<String> m30163a() {
        Collection hashSet = new HashSet();
        Locale[] availableLocales = Locale.getAvailableLocales();
        int i = 0;
        while (i < availableLocales.length) {
            String country = availableLocales[i].getCountry();
            if (!(country == null || country.trim().isEmpty() || !country.matches("[a-zA-Z]+") || availableLocales[i].getDisplayCountry() == null || availableLocales[i].getDisplayCountry().trim().isEmpty())) {
                hashSet.add(availableLocales[i].getDisplayCountry());
            }
            i++;
        }
        List<String> arrayList = new ArrayList();
        arrayList.addAll(hashSet);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        return arrayList;
    }
}
