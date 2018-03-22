package com.huawei.hwid.api.common.apkimpl;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.cloudservice.IntentResultHandler;
import com.huawei.cloudservice.LoginHandler;
import com.huawei.hwid.api.common.C5073a;
import com.huawei.hwid.api.common.C5088d;
import com.huawei.hwid.api.common.C5095g;
import com.huawei.hwid.api.common.C5098i;
import com.huawei.hwid.api.common.C5100j;
import com.huawei.hwid.api.common.C5102k;
import com.huawei.hwid.api.common.C5106n;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.HwAccount;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p429a.C5117b;
import com.huawei.hwid.core.p435d.C5154a;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.huawei.hwid.update.p452c.C5276a;

/* compiled from: APKCloudAccountImpl */
public class C5079a {
    public static void m24447a(Context context, String str, String str2, Bundle bundle, LoginHandler loginHandler, C5117b c5117b) {
        C5165e.m24912e("APKCloudAccountImpl", "getAccountsByType use the apk");
        boolean z = bundle.getBoolean(CloudAccount.KEY_NEEDAUTH, true);
        if (bundle.getBoolean("AIDL") && C5166b.m24939c(context, "com.huawei.hwid.ICloudService") && C5079a.m24454c(context, bundle)) {
            C5073a a = C5073a.m24398a(context);
            if (a == null) {
                C5165e.m24906b("APKCloudAccountImpl", "manager is null");
                return;
            }
            if (c5117b != null) {
                c5117b.m24662b(C5106n.m24584a(true, z));
            }
            a.m24415a(new C5102k(context, str, bundle, loginHandler));
            return;
        }
        if (c5117b != null) {
            c5117b.m24662b(C5106n.m24584a(false, z));
        }
        C5079a.m24446a(context, str, str2, bundle);
    }

    public static void m24442a(Context context, Intent intent, int i, CloudRequestHandler cloudRequestHandler) {
        if (C5166b.m24939c(context, "com.huawei.hwid.ICloudService")) {
            C5095g c5095g = new C5095g(context, intent, i);
            c5095g.m24547a(cloudRequestHandler);
            c5095g.m24546a();
            return;
        }
        ErrorStatus errorStatus = new ErrorStatus(38, "no remote interface call service");
        C5165e.m24906b("APKCloudAccountImpl", "error: " + errorStatus.toString());
        cloudRequestHandler.onError(errorStatus);
    }

    private static void m24446a(Context context, String str, String str2, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(context, DummyActivity.class);
        intent.putExtra("requestTokenType", str);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("accountName", str2);
        bundle.putBoolean("isFromApk", true);
        intent.putExtra(HwAccountConstants.EXTRA_BUNDLE, bundle);
        intent.setFlags(1048576);
        C5166b.m24920a(context, intent, 0);
    }

    public static boolean m24449a(Context context) {
        Cursor query;
        boolean z;
        Account[] accountsByType;
        Throwable th;
        try {
            query = context.getContentResolver().query(Uri.parse(HwAccountConstants.CONTENT_HASLOGIN_URL), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        if (1 == query.getInt(query.getColumnIndex("hasLogin"))) {
                            z = true;
                        } else {
                            z = false;
                        }
                        C5165e.m24906b("APKCloudAccountImpl", "Account has Login: " + z);
                        if (query != null) {
                            query.close();
                        }
                        return z;
                    }
                } catch (RuntimeException e) {
                    try {
                        accountsByType = AccountManager.get(context).getAccountsByType("com.huawei.hwid");
                        if (accountsByType != null || accountsByType.length <= 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (query != null) {
                            query.close();
                        }
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                } catch (Exception e2) {
                    accountsByType = AccountManager.get(context).getAccountsByType("com.huawei.hwid");
                    if (accountsByType != null || accountsByType.length <= 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (query != null) {
                        query.close();
                    }
                    return z;
                }
            }
            accountsByType = AccountManager.get(context).getAccountsByType("com.huawei.hwid");
            if (accountsByType == null || accountsByType.length <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (query != null) {
                query.close();
            }
        } catch (RuntimeException e3) {
            query = null;
            accountsByType = AccountManager.get(context).getAccountsByType("com.huawei.hwid");
            if (accountsByType != null) {
            }
            z = false;
            if (query != null) {
                query.close();
            }
            return z;
        } catch (Exception e4) {
            query = null;
            accountsByType = AccountManager.get(context).getAccountsByType("com.huawei.hwid");
            if (accountsByType != null) {
            }
            z = false;
            if (query != null) {
                query.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return z;
    }

    public static long m24451b(Context context) {
        long j;
        C5165e.m24906b("APKCloudAccountImpl", "getLoginCount");
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.huawei.hwid.api.provider/LOGIN_COUNT"), null, null, null, null);
        if (query == null || !query.moveToFirst()) {
            j = -1;
        } else {
            j = query.getLong(query.getColumnIndex("LOGIN_COUNT"));
        }
        if (query != null) {
            query.close();
        }
        return j;
    }

    public static void m24445a(Context context, String str, LoginHandler loginHandler) {
        C5165e.m24912e("APKCloudAccountImpl", "apk---quickLogin()");
        Intent intent;
        if (C5166b.m24934b(context, HwAccountConstants.ACTION_QUICK_REGISTER)) {
            C5088d.m24474a(context, loginHandler, null);
            intent = new Intent(HwAccountConstants.ACTION_QUICK_REGISTER);
            intent.setPackage("com.huawei.hwid");
            intent.putExtra("requestTokenType", str);
            C5166b.m24920a(context, intent, 0);
        } else if (!C5166b.m24934b(context, "com.huawei.hwid.opensdk.ACTION_QUICKLOGIN_SMS")) {
            C5165e.m24906b("APKCloudAccountImpl", "There is no quick login in APK");
            loginHandler.onError(new ErrorStatus(21, "hwid not support quick login"));
        } else if (C5079a.m24449a(context)) {
            Bundle bundle = new Bundle();
            bundle.putInt(CloudAccount.KEY_LOGIN_CHANNEL, Integer.parseInt(C5154a.m24846a(context, str)));
            C5088d.m24476a(context, str, bundle, loginHandler);
        } else {
            C5088d.m24475a(context, loginHandler, "com.huawei.hwid");
            intent = new Intent("com.huawei.hwid.opensdk.ACTION_QUICKLOGIN_SMS");
            intent.setPackage("com.huawei.hwid");
            intent.putExtra("packname", str);
            C5166b.m24920a(context, intent, 0);
        }
    }

    public static void m24443a(Context context, HwAccount hwAccount) {
        AccountManager.get(context).invalidateAuthToken("com.huawei.hwid", hwAccount.m25130g());
    }

    public static boolean m24450a(Context context, Bundle bundle) {
        Cursor cursor;
        Exception exception;
        boolean z;
        Throwable th;
        boolean z2 = false;
        if (context == null) {
            C5165e.m24906b("APKCloudAccountImpl", "context is null");
            return false;
        }
        Cursor query;
        try {
            query = context.getContentResolver().query(Uri.parse("content://com.huawei.hwid.api.provider/is_support_fingerprint/1"), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        if (1 == query.getInt(query.getColumnIndex("isSupport"))) {
                            z2 = true;
                        }
                        C5165e.m24906b("APKCloudAccountImpl", "support fingerprint: " + z2);
                    }
                } catch (Exception e) {
                    cursor = query;
                    exception = e;
                    z = false;
                    try {
                        C5165e.m24910d("APKCloudAccountImpl", exception.getMessage());
                        if (cursor != null) {
                            return z;
                        }
                        cursor.close();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        query = cursor;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            z = z2;
            if (query == null) {
                return z;
            }
            query.close();
            return z;
        } catch (Exception e2) {
            exception = e2;
            cursor = null;
            z = false;
            C5165e.m24910d("APKCloudAccountImpl", exception.getMessage());
            if (cursor != null) {
                return z;
            }
            cursor.close();
            return z;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static String m24453c(Context context) {
        Exception e;
        Throwable th;
        if (context == null) {
            C5165e.m24906b("APKCloudAccountImpl", "context is null");
            return "";
        }
        Cursor query;
        try {
            query = context.getContentResolver().query(Uri.parse("content://com.huawei.hwid.api.provider/hwid_account_status"), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndex("accountstatus"));
                        C5165e.m24906b("APKCloudAccountImpl", "accountStatus: " + string);
                        if (query == null) {
                            return string;
                        }
                        query.close();
                        return string;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C5165e.m24910d("APKCloudAccountImpl", e.getMessage());
                        if (query != null) {
                            query.close();
                        }
                        return "";
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            C5165e.m24910d("APKCloudAccountImpl", e.getMessage());
            if (query != null) {
                query.close();
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return "";
    }

    private static boolean m24454c(Context context, Bundle bundle) {
        if (bundle != null && bundle.getBoolean("check_sim_status") && "blocked".equals(C5079a.m24453c(context))) {
            return false;
        }
        return true;
    }

    public static void m24452b(Context context, Bundle bundle) {
        C5165e.m24906b("APKCloudAccountImpl", "downloadHwIDAPK");
        int i = 0;
        if (bundle != null) {
            i = bundle.getInt(CloudAccount.KEY_REQUESTCODE);
        }
        C5276a.m25548a(context, i);
    }

    public static void m24448a(Context context, String str, String str2, IntentResultHandler intentResultHandler) {
        C5073a a = C5073a.m24398a(context);
        if (a == null) {
            C5165e.m24906b("APKCloudAccountImpl", "manager is null");
        } else {
            a.m24415a(new C5098i(context, str, str2, intentResultHandler));
        }
    }

    public static void m24444a(Context context, String str, CloudRequestHandler cloudRequestHandler) {
        C5073a a = C5073a.m24398a(context);
        if (a == null) {
            C5165e.m24906b("APKCloudAccountImpl", "manager is null");
        } else {
            a.m24415a(new C5100j(context, str, cloudRequestHandler));
        }
    }
}
