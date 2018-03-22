package com.sina.weibo.sdk.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.openalliance.ad.p112a.p113a.p114a.C1211a;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBConstants.Base;
import com.sina.weibo.sdk.statistic.WBAgent;
import com.sina.weibo.sdk.utils.AidTask.AidInfo;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.sqlcipher.database.SQLiteDatabase;

public class Utility {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str);
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException e) {
            return new Bundle();
        }
    }

    public static Bundle parseUri(String str) {
        try {
            return decodeUrl(new URI(str).getQuery());
        } catch (Exception e) {
            return new Bundle();
        }
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split(SNBConstant.FILTER)) {
                String[] split2 = split.split("=");
                try {
                    bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static boolean isChineseLocale(Context context) {
        try {
            Locale locale = context.getResources().getConfiguration().locale;
            if (Locale.CHINA.equals(locale) || Locale.CHINESE.equals(locale) || Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TAIWAN.equals(locale)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static String generateGUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getSign(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            for (Signature toByteArray : packageInfo.signatures) {
                byte[] toByteArray2 = toByteArray.toByteArray();
                if (toByteArray2 != null) {
                    return MD5.hexdigest(toByteArray2);
                }
            }
            return null;
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static String safeString(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String getAid(Context context, String str) {
        AidInfo aidSync = AidTask.getInstance(context).getAidSync(str);
        if (aidSync != null) {
            return aidSync.getAid();
        }
        return "";
    }

    public static String generateUA(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER).append("-").append(Build.MODEL);
        stringBuilder.append(HwAccountConstants.SPLIIT_UNDERLINE);
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append(HwAccountConstants.SPLIIT_UNDERLINE);
        stringBuilder.append("weibosdk");
        stringBuilder.append(HwAccountConstants.SPLIIT_UNDERLINE);
        stringBuilder.append(WBConstants.WEIBO_SDK_VERSION_CODE);
        stringBuilder.append("_android");
        return stringBuilder.toString();
    }

    public static String generateUAAid(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Build.MANUFACTURER).append("-").append(Build.MODEL);
        stringBuilder.append(C1211a.END_FLAG);
        stringBuilder.append("weibosdk");
        stringBuilder.append(C1211a.END_FLAG);
        try {
            stringBuilder.append(WBConstants.WEIBO_SDK_VERSION_CODE.replaceAll("\\s+", HwAccountConstants.SPLIIT_UNDERLINE));
        } catch (Exception e) {
            stringBuilder.append("unknown");
        }
        stringBuilder.append(C1211a.END_FLAG).append("android").append("__android").append(VERSION.RELEASE);
        return stringBuilder.toString();
    }

    public static void shareMessagetoWeibo(Context context, String str, Bundle bundle) {
        try {
            Intent intent = new Intent();
            String valueOf = String.valueOf(System.currentTimeMillis());
            intent.putExtra(WBConstants.TRAN, valueOf);
            Map hashMap = new HashMap();
            hashMap.put(WBConstants.ACTION_START_TIME, valueOf);
            try {
                WBAgent.onEvent(context, WBConstants.ACTION_LOG_TYPE_MESSAGE, hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            intent.setAction("android.intent.action.VIEW");
            intent.putExtra(Base.APP_PKG, context.getPackageName());
            intent.setData(Uri.parse(str));
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtras(bundle);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
        }
    }

    public static void openWeiboActivity(Context context, String str, Bundle bundle) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.putExtra(Base.APP_PKG, context.getPackageName());
            intent.setData(Uri.parse(str));
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtras(bundle);
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
        }
    }

    public static Boolean isWeiBoVersionSupportNewPay(Context context) {
        boolean z = false;
        Intent intent = new Intent(WEIBO_IDENTITY_ACTION);
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return Boolean.valueOf(false);
        }
        boolean z2 = false;
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (!(resolveInfo.serviceInfo == null || resolveInfo.serviceInfo.applicationInfo == null || TextUtils.isEmpty(resolveInfo.serviceInfo.applicationInfo.packageName))) {
                try {
                    z2 = context.getPackageManager().getPackageInfo(resolveInfo.serviceInfo.applicationInfo.packageName, 0).versionCode;
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        if (z2 >= true) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
