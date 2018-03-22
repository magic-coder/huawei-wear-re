package com.huawei.membercenter.sdk.membersdklibrary.p094b;

import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.crowdtestsdk.utils.ResUtil;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.membercenter.sdk.membersdklibrary.api.MemberServiceAPI.IActiveMemberCallback;
import com.huawei.membercenter.sdk.membersdklibrary.api.MemberServiceAPI.IQueryMemberStatusCallback;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.ActiveMemberResponse;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.BundleKey;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.MemberInfoResponse;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.MemberStatus;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.RetCode;
import com.huawei.membercenter.sdk.membersdklibrary.b.a.d;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5482d;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5483e;
import com.huawei.membercenter.sdk.membersdklibrary.p092a.p472d.C5485g;
import com.huawei.membercenter.sdk.membersdklibrary.p094b.p095a.C5491b;
import com.huawei.membercenter.sdk.membersdklibrary.p094b.p095a.C5492c;

/* compiled from: MemberServiceManager */
public final class C5493a {
    private static final C5493a f19358a = new C5493a();

    /* compiled from: MemberServiceManager */
    class C5487a implements Runnable {
        private Context f19346a;
        private IActiveMemberCallback f19347b;
        private Bundle f19348c;

        public C5487a(Context context, Bundle bundle, IActiveMemberCallback iActiveMemberCallback) {
            this.f19346a = context;
            this.f19348c = bundle;
            this.f19347b = iActiveMemberCallback;
        }

        public void run() {
            d a = new C5491b(this.f19346a, this.f19348c).m26218a();
            if (!"200".equals(a.a()) || a.c() == null) {
                this.f19347b.callback(a.a(), a.b(), -1);
                return;
            }
            ActiveMemberResponse activeMemberResponse = (ActiveMemberResponse) new Gson().fromJson(a.c(), ActiveMemberResponse.class);
            if (activeMemberResponse != null) {
                this.f19347b.callback(a.a(), a.b(), activeMemberResponse.getGradeId());
            } else {
                this.f19347b.callback(a.a(), a.b(), -1);
            }
        }
    }

    /* compiled from: MemberServiceManager */
    class C5488b implements OnClickListener {
        private String f19349a = "";
        private Context f19350b = null;

        public C5488b(Context context, String str) {
            this.f19349a = str;
            this.f19350b = context;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C5482d.m26183a("MemberServiceManager", "MyDialogInterface  onClick-->which=" + i);
            if (this.f19349a == null || "".equals(this.f19349a)) {
                dialogInterface.dismiss();
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(this.f19349a));
            try {
                this.f19350b.startActivity(intent);
            } catch (Exception e) {
                C5482d.m26186d("MemberServiceManager", e.getMessage());
            }
        }
    }

    /* compiled from: MemberServiceManager */
    class C5489c implements Runnable {
        private Context f19351a;
        private IQueryMemberStatusCallback f19352b;
        private Bundle f19353c;

        public C5489c(Context context, Bundle bundle, IQueryMemberStatusCallback iQueryMemberStatusCallback) {
            this.f19351a = context;
            this.f19353c = bundle;
            this.f19352b = iQueryMemberStatusCallback;
        }

        public void run() {
            d a = new C5492c(this.f19351a, this.f19353c).m26218a();
            if (TextUtils.isEmpty(a.a())) {
                this.f19352b.callback("-1", a.b(), null);
                return;
            }
            Gson gson = new Gson();
            String a2 = a.a();
            Object obj = -1;
            switch (a2.hashCode()) {
                case 48:
                    if (a2.equals("0")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 1505893342:
                    if (a2.equals(RetCode.SUC_300001)) {
                        obj = null;
                        break;
                    }
                    break;
                case 1505893343:
                    if (a2.equals(RetCode.SUC_300002)) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                case 1:
                case 2:
                    MemberStatus memberStatus = (MemberStatus) gson.fromJson(a.c(), MemberStatus.class);
                    if (memberStatus != null && memberStatus.getMemLevel() < memberStatus.getIntentLevel() && RetCode.SUC_300001.equals(a2)) {
                        a2 = RetCode.SUC_CAN_BE_UPGRADED;
                    }
                    this.f19352b.callback(a2, a.b(), memberStatus);
                    return;
                default:
                    String reason;
                    MemberInfoResponse memberInfoResponse = (MemberInfoResponse) gson.fromJson(a.c(), MemberInfoResponse.class);
                    String str = "";
                    if (memberInfoResponse != null) {
                        reason = memberInfoResponse.getReason();
                    } else {
                        reason = str;
                    }
                    this.f19352b.callback(a2, reason, null);
                    return;
            }
        }
    }

    private C5493a() {
    }

    public static C5493a m26228a() {
        return f19358a;
    }

    public void m26233a(Bundle bundle, Context context, IQueryMemberStatusCallback iQueryMemberStatusCallback) {
        if (!m26230a(context, (Object) iQueryMemberStatusCallback, bundle)) {
            C5485g.f19345a.execute(new C5489c(context, bundle, iQueryMemberStatusCallback));
        }
    }

    public void m26232a(Bundle bundle, Context context, IActiveMemberCallback iActiveMemberCallback) {
        if (!m26230a(context, (Object) iActiveMemberCallback, bundle)) {
            C5485g.f19345a.execute(new C5487a(context, bundle, iActiveMemberCallback));
        }
    }

    private boolean m26230a(Context context, Object obj, Bundle bundle) {
        if (context == null) {
            C5482d.m26186d("MemberServiceManager", "[isParamInvalid] context is NULL, return.");
            return true;
        } else if (obj == null) {
            C5482d.m26186d("MemberServiceManager", "[isParamInvalid] callback is NULL, return.");
            return true;
        } else if (bundle == null) {
            C5482d.m26186d("MemberServiceManager", "[isParamInvalid] bundle is NULL, return.");
            return true;
        } else {
            if (!(bundle.containsKey("userID") && bundle.containsKey(BundleKey.KEY_ST) && bundle.containsKey("deviceType") && bundle.containsKey("deviceID"))) {
                C5482d.m26185c("MemberServiceManager", "[paramInvalid] bundle without the required parameters(userID?st?deviceType?deviceID?), but we continue to execute.");
            }
            return false;
        }
    }

    public void m26231a(Context context) {
        if (context == null) {
            C5482d.m26186d("MemberServiceManager", "[enterPhoneServiceApk] context is NULL, return.");
            return;
        }
        Intent intent = new Intent();
        intent.setPackage("com.huawei.phoneservice");
        intent.setAction("com.huawei.phoneservice.action.ENTER_MEMBER");
        intent.setFlags(HwAccountConstants.FLAG_TRANSLUCENT_STATUS);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            C5482d.m26186d("MemberServiceManager", "phoneservice is not exist");
            m26229a(context, "http://huiyuan.dbankcloud.com/VIP/HwPhoneService.apk", "membersdk_oem_name");
        }
    }

    private void m26229a(Context context, String str, String str2) {
        Builder builder = new Builder(context);
        builder.setMessage(String.format(context.getString(C5483e.m26187a(context, ResUtil.TYPE_STRING, "membersdk_update_tip")), new Object[]{context.getString(C5483e.m26187a(context, ResUtil.TYPE_STRING, str2))})).setPositiveButton(context.getString(C5483e.m26187a(context, ResUtil.TYPE_STRING, "membersdk_download_file_download")), new C5488b(context, str));
        builder.setNegativeButton(context.getString(C5483e.m26187a(context, ResUtil.TYPE_STRING, "membersdk_download_file_download_cancel")), new C5488b(context, ""));
        builder.create().show();
    }
}
