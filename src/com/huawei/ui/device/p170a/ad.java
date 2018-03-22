package com.huawei.ui.device.p170a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import java.io.IOException;
import java.util.Locale;

/* compiled from: LocalFileInteractor */
public class ad {
    private Context f6859a;

    public ad(Context context) {
        this.f6859a = context;
    }

    public String m10299a(String str) {
        String b = m10296b(str);
        if (!m10297c(str)) {
            b = m10298d(str);
        }
        C2538c.m12677c("LocalFileInteractor", "getLocalFileUrl " + b);
        return b;
    }

    private String m10296b(String str) {
        return "file:///android_asset/legalInformation/" + (m10295a() + "/") + str + ".html";
    }

    private boolean m10297c(String str) {
        String str2 = str + ".html";
        C2538c.m12677c("LocalFileInteractor", "checkFinalUrl  " + ("legalInformation/" + m10295a()));
        try {
            for (String str3 : this.f6859a.getResources().getAssets().list("legalInformation/" + m10295a())) {
                C2538c.m12677c("LocalFileInteractor", "checkFinalUrl  " + str3);
                if (str2.equals(r4[r2])) {
                    return true;
                }
            }
        } catch (IOException e) {
            C2538c.m12680e("LocalFileInteractor", "Exception e1 = " + e.getMessage());
        }
        return false;
    }

    private String m10298d(String str) {
        return "file:///android_asset/legalInformation/" + "en/" + str + ".html";
    }

    private String m10295a() {
        C2538c.m12677c("LocalFileInteractor", "location  " + (Locale.getDefault().getLanguage() + "-r" + Locale.getDefault().getCountry()));
        return Locale.getDefault().getLanguage() + "-r" + Locale.getDefault().getCountry();
    }
}
