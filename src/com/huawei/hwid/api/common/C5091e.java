package com.huawei.hwid.api.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.cloudservice.CloudAccount;
import com.huawei.cloudservice.CloudRequestHandler;
import com.huawei.cloudservice.LogoutHandler;
import com.huawei.hwid.api.common.apkimpl.C5079a;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.datatype.UserAccountInfo;
import com.huawei.hwid.core.helper.handler.ErrorStatus;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.unionpay.tsmservice.data.ResultCode;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"InlinedApi"})
/* compiled from: CloudAccountImpl2 */
public class C5091e {

    /* compiled from: CloudAccountImpl2 */
    final class C50891 implements CloudRequestHandler {
        final /* synthetic */ Bundle f18360a;
        final /* synthetic */ CloudRequestHandler f18361b;
        final /* synthetic */ Context f18362c;
        final /* synthetic */ String f18363d;

        C50891(Bundle bundle, CloudRequestHandler cloudRequestHandler, Context context, String str) {
            this.f18360a = bundle;
            this.f18361b = cloudRequestHandler;
            this.f18362c = context;
            this.f18363d = str;
        }

        public void onFinish(Bundle bundle) {
            C5165e.m24904a("CloudAccountImpl2", "getVerifiedPhone getUserInfo");
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("userAccountInfo");
            String str = "";
            str = "";
            boolean z = this.f18360a.getBoolean(HwAccountConstants.EXTRA_ONLY_QUERY, false);
            C5165e.m24906b("CloudAccountImpl2", "isOnlyQuery: " + z);
            if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
                Bundle bundle2 = new Bundle();
                CharSequence a = C5091e.m24532c(parcelableArrayList);
                CharSequence b = C5091e.m24534d(parcelableArrayList);
                if (!TextUtils.isEmpty(a)) {
                    bundle2.putString("secrityPhoneOrsecrityEmail", a);
                }
                if (!TextUtils.isEmpty(b)) {
                    bundle2.putString("accountName", b);
                }
                if (!TextUtils.isEmpty(a) || !TextUtils.isEmpty(b)) {
                    bundle2.putString("result", "1");
                    this.f18361b.onFinish(bundle2);
                } else if (z) {
                    C5165e.m24906b("CloudAccountImpl2", "phone is not exist");
                    this.f18361b.onError(new ErrorStatus(46, "phone number is not exist"));
                } else {
                    C5091e.m24533c(this.f18362c, this.f18363d, this.f18361b, this.f18360a);
                }
            } else if (z) {
                C5165e.m24906b("CloudAccountImpl2", "phone or email is not exist");
                this.f18361b.onError(new ErrorStatus(46, "phone number is not exist"));
            } else {
                C5091e.m24533c(this.f18362c, this.f18363d, this.f18361b, this.f18360a);
            }
        }

        public void onError(ErrorStatus errorStatus) {
            this.f18361b.onError(errorStatus);
        }
    }

    /* compiled from: CloudAccountImpl2 */
    final class C50902 implements CloudRequestHandler {
        C50902() {
        }

        public void onFinish(Bundle bundle) {
            C5165e.m24906b("CloudAccountImpl2", "onFinish for Pay, do nothing");
        }

        public void onError(ErrorStatus errorStatus) {
            C5165e.m24906b("CloudAccountImpl2", "onFinish for Pay, do nothing");
        }
    }

    public static void m24527a(Context context, String str, CloudRequestHandler cloudRequestHandler, Bundle bundle) {
        if (!C5106n.m24591a(context, cloudRequestHandler)) {
            C5165e.m24906b("CloudAccountImpl2", "checkHwIDPassword: context or cloudRequestHandler is null");
        } else if (TextUtils.isEmpty(str)) {
            cloudRequestHandler.onError(new ErrorStatus(12, "the param is invalid"));
            C5165e.m24906b("CloudAccountImpl2", "userId is empty");
        } else if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl2", "can not use hwid");
            cloudRequestHandler.onError(new ErrorStatus(33, "hwid is not exit"));
        } else if (C5106n.m24593b(context)) {
            CloudAccount b = C5088d.m24491b(context, str);
            if (b == null) {
                cloudRequestHandler.onError(new ErrorStatus(12, "the param is invalid"));
                C5165e.m24906b("CloudAccountImpl2", "userId is error");
                return;
            }
            C5091e.m24528a(context, str, cloudRequestHandler, bundle, b);
        } else {
            C5165e.m24906b("CloudAccountImpl2", "hwid is not exit");
            cloudRequestHandler.onError(new ErrorStatus(34, "hwid is not exit"));
        }
    }

    private static void m24528a(Context context, String str, CloudRequestHandler cloudRequestHandler, Bundle bundle, CloudAccount cloudAccount) {
        cloudAccount.getUserInfo(context, ResultCode.ERROR_DETAIL_NETWORK, new C50891(bundle, cloudRequestHandler, context, str));
    }

    private static String m24532c(ArrayList<UserAccountInfo> arrayList) {
        String str = "";
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String userAccount;
                UserAccountInfo userAccountInfo = (UserAccountInfo) it.next();
                if ("6".equals(userAccountInfo.getAccountType()) && "1".equals(userAccountInfo.getAccountState())) {
                    userAccount = userAccountInfo.getUserAccount();
                    C5165e.m24904a("CloudAccountImpl2", "VerifiedPhone ");
                } else {
                    userAccount = str;
                }
                str = userAccount;
            }
        }
        return str;
    }

    private static String m24534d(ArrayList<UserAccountInfo> arrayList) {
        String str = "";
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String userAccount;
                UserAccountInfo userAccountInfo = (UserAccountInfo) it.next();
                if ("2".equals(userAccountInfo.getAccountType())) {
                    userAccount = userAccountInfo.getUserAccount();
                    C5165e.m24904a("CloudAccountImpl2", "phoneAccountName ");
                } else {
                    userAccount = str;
                }
                str = userAccount;
            }
        }
        return str;
    }

    private static void m24533c(Context context, String str, CloudRequestHandler cloudRequestHandler, Bundle bundle) {
        if (C5166b.m24941d(context, str) == null) {
            ErrorStatus errorStatus = new ErrorStatus(13, "no account by userId");
            C5165e.m24906b("CloudAccountImpl2", "error: " + errorStatus.toString());
            cloudRequestHandler.onError(errorStatus);
            return;
        }
        bundle.putString("bindOperation", "1");
        C5088d.m24473a(context, cloudRequestHandler);
        C5088d.m24481a(context, str, false, new C50902(), bundle);
    }

    public static void m24529a(Context context, String str, String str2, Bundle bundle, LogoutHandler logoutHandler) throws RuntimeException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            C5165e.m24906b("CloudAccountImpl2", "hwid is not exit");
            throw new RuntimeException("this interface can not be called in main thread");
        } else if (logoutHandler == null || context == null) {
            C5165e.m24906b("CloudAccountImpl2", "getAccountsByType: context or handler is null");
            logoutHandler.onFail(new ErrorStatus(12, "context is null"));
        } else if (!C5166b.m24955h(context)) {
            C5165e.m24906b("CloudAccountImpl2", "can not use hwid");
            logoutHandler.onFail(new ErrorStatus(33, "can not use hwid"));
        } else if (!C5106n.m24593b(context)) {
            C5165e.m24906b("CloudAccountImpl2", "hwid is not exit");
            logoutHandler.onFail(new ErrorStatus(34, "hwid is not exit"));
        } else if (C5106n.m24596d(context) <= 20503000) {
            C5165e.m24910d("CloudAccountImpl2", "hwid verson not support logout interface");
            logoutHandler.onFail(new ErrorStatus(35, "hwid apk version not support logout interface"));
        } else {
            C5073a a = C5073a.m24398a(context);
            if (a == null) {
                logoutHandler.onFail(new ErrorStatus(40, "null == manager"));
                C5165e.m24910d("CloudAccountImpl2", "manager is null");
                return;
            }
            a.m24415a(new C5104l(context, str, str2, bundle, logoutHandler));
        }
    }

    public static long m24525a(Context context) {
        return C5079a.m24451b(context);
    }
}
