package com.huawei.ui.main.stories.about.p179a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import java.io.IOException;
import java.util.Locale;

/* compiled from: LocalFileInteractor */
public class C2288j {
    private Context f8296a;

    public C2288j(Context context) {
        this.f8296a = context;
    }

    public String m11763a(String str) {
        String b = m11760b(str);
        if (!m11761c(str)) {
            b = m11762d(str);
        }
        C2538c.m12674b("LocalFileInteractor", "getLocalFileUrl " + b);
        return b;
    }

    private String m11760b(String str) {
        return "file:///android_asset/legalInformation/" + (m11759a() + "/") + str + ".html";
    }

    private boolean m11761c(String str) {
        String str2 = str + ".html";
        C2538c.m12674b("LocalFileInteractor", "checkFinalUrl  " + ("legalInformation/" + m11759a()));
        try {
            for (String str3 : this.f8296a.getResources().getAssets().list("legalInformation/" + m11759a())) {
                C2538c.m12674b("LocalFileInteractor", "checkFinalUrl  " + str3);
                if (str2.equals(r4[r2])) {
                    return true;
                }
            }
        } catch (IOException e) {
            C2538c.m12680e("LocalFileInteractor", "Exception e1 = " + e.getMessage());
        }
        return false;
    }

    private String m11762d(String str) {
        return "file:///android_asset/legalInformation/" + "en/" + str + ".html";
    }

    private String m11759a() {
        C2538c.m12674b("LocalFileInteractor", "location  " + (Locale.getDefault().getLanguage() + "-r" + Locale.getDefault().getCountry()));
        return Locale.getDefault().getLanguage() + "-r" + Locale.getDefault().getCountry();
    }
}
