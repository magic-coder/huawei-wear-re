package com.huawei.hwappdfxmgr.p398c;

import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.huawei.common.applog.AppLogApi;
import com.huawei.feedback.FeedbackApi;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.util.appdown.AppOpenOrDownHelper;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.huawei.p190v.C2538c;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: HWFeedbackApi */
public class C4586a {
    private String f16795a = "";
    private ExecutorService f16796b;

    public int m21862a(Activity activity) {
        if (!d.a()) {
            AppLogApi.setAutoUploadFlag(activity, true);
        }
        Bundle bundle = new Bundle();
        String str = HwAccountConstants.TYPE_FACEBOOK;
        bundle.putString(AppOpenOrDownHelper.APP_ID_PARAM, str);
        bundle.putString("questionType", "bone");
        String b = m21861b();
        bundle.putString("aesSecret", b);
        String packageName = activity.getPackageName();
        bundle.putString("packageName", packageName);
        bundle.putString("packageVersion", d.f(activity));
        bundle.putString("logfilePath", m21859a(m21857a(activity, packageName, str), b));
        return FeedbackApi.gotoFeedback(activity, bundle);
    }

    private String m21859a(String str, String str2) {
        File file = new File(d.g());
        List arrayList = new ArrayList();
        arrayList.add(file);
        File file2 = new File(d.a + str);
        file = new File("sdcard/phoneservice/");
        if (!(file.exists() || file.mkdirs())) {
            C2538c.e("HWFeedbackApi", new Object[]{"create phoneService dir fail"});
        }
        this.f16795a = "sdcard/phoneservice/" + str;
        this.f16796b = Executors.newSingleThreadExecutor();
        this.f16796b.execute(new C4587b(this, arrayList, file2, str2));
        return this.f16795a;
    }

    private String m21857a(Activity activity, String str, String str2) {
        String str3;
        String str4 = Build.MODEL;
        String str5 = Build.DISPLAY;
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        String str6 = null;
        try {
            str3 = activity.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (NameNotFoundException e) {
            C2538c.e("HWFeedbackApi", new Object[]{e.getMessage()});
            str3 = str6;
        }
        TelephonyManager telephonyManager = (TelephonyManager) activity.getSystemService("phone");
        String h = d.h(activity);
        if ("".equals(h)) {
            str6 = telephonyManager.getSimSerialNumber();
            if (str6 == null || "".equals(str6)) {
                str6 = "000000000000000";
            }
        } else {
            str6 = h;
        }
        return str4 + HwAccountConstants.SPLIIT_UNDERLINE + str5 + HwAccountConstants.SPLIIT_UNDERLINE + AppLogApi.getEncryImei(str6) + HwAccountConstants.SPLIIT_UNDERLINE + format + "_app-" + str + HwAccountConstants.SPLIIT_UNDERLINE + str3 + HwAccountConstants.SPLIIT_UNDERLINE + str2 + LightCloudConstants.ZIP_POSTFIX;
    }

    private String m21861b() {
        byte[] bArr = new byte[11];
        C4586a.m21860a().nextBytes(bArr);
        return Base64.encodeToString(bArr, 2);
    }

    public static SecureRandom m21860a() {
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            C2538c.e("HWFeedbackApi", new Object[]{"NoSuchAlgorithmException"});
        }
        if (secureRandom == null) {
            secureRandom = new SecureRandom();
        }
        secureRandom.nextInt();
        return secureRandom;
    }
}
