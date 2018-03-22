package com.huawei.membercenter.sdk.membersdklibrary.api;

import android.content.Context;
import android.os.Bundle;
import com.huawei.membercenter.sdk.membersdklibrary.api.model.MemberStatus;
import com.huawei.membercenter.sdk.membersdklibrary.p094b.C5493a;

public class MemberServiceAPI {

    public interface IActiveMemberCallback {
        void callback(String str, String str2, int i);
    }

    public interface IQueryMemberStatusCallback {
        void callback(String str, String str2, MemberStatus memberStatus);
    }

    public static void queryMemberStatus(Bundle bundle, Context context, IQueryMemberStatusCallback iQueryMemberStatusCallback) {
        C5493a.m26228a().m26233a(bundle, context, iQueryMemberStatusCallback);
    }

    public static void activeMember(Bundle bundle, Context context, IActiveMemberCallback iActiveMemberCallback) {
        C5493a.m26228a().m26232a(bundle, context, iActiveMemberCallback);
    }

    public static void enterPhoneServiceApk(Context context) {
        C5493a.m26228a().m26231a(context);
    }
}
