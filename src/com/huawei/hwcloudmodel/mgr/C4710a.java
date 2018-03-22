package com.huawei.hwcloudmodel.mgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.huawei.hwbasemgr.a;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.model.CustomStringRequest;
import com.huawei.hwcloudmodel.model.RequestManager;
import com.huawei.hwcloudmodel.model.unite.AddHealthDataReq;
import com.huawei.hwcloudmodel.model.unite.AddHealthDataRsp;
import com.huawei.hwcloudmodel.model.unite.AddHealthStatReq;
import com.huawei.hwcloudmodel.model.unite.AddHealthStatRsp;
import com.huawei.hwcloudmodel.model.unite.AddMotionPathReq;
import com.huawei.hwcloudmodel.model.unite.AddMotionPathRsp;
import com.huawei.hwcloudmodel.model.unite.AddSleepStatReq;
import com.huawei.hwcloudmodel.model.unite.AddSleepStatRsp;
import com.huawei.hwcloudmodel.model.unite.AddSportDataReq;
import com.huawei.hwcloudmodel.model.unite.AddSportDataRsp;
import com.huawei.hwcloudmodel.model.unite.AddSportTotalReq;
import com.huawei.hwcloudmodel.model.unite.AddSportTotalRsp;
import com.huawei.hwcloudmodel.model.unite.DelHealthDataReq;
import com.huawei.hwcloudmodel.model.unite.DelHealthDataRsp;
import com.huawei.hwcloudmodel.model.unite.GetHealthDataByTimeReq;
import com.huawei.hwcloudmodel.model.unite.GetHealthDataByTimeRsp;
import com.huawei.hwcloudmodel.model.unite.GetHealthDataByVersionReq;
import com.huawei.hwcloudmodel.model.unite.GetHealthDataByVersionRsp;
import com.huawei.hwcloudmodel.model.unite.GetMotionPathByVersionReq;
import com.huawei.hwcloudmodel.model.unite.GetMotionPathByVersionRsp;
import com.huawei.hwcloudmodel.model.unite.GetSleepStatReq;
import com.huawei.hwcloudmodel.model.unite.GetSleepStatRsp;
import com.huawei.hwcloudmodel.model.unite.GetSportDataByTimeReq;
import com.huawei.hwcloudmodel.model.unite.GetSportDataByTimeRsp;
import com.huawei.hwcloudmodel.model.unite.GetSportDataByVersionReq;
import com.huawei.hwcloudmodel.model.unite.GetSportDataByVersionRsp;
import com.huawei.hwcloudmodel.model.unite.GetSportDimenStatReq;
import com.huawei.hwcloudmodel.model.unite.GetSportDimenStatRsp;
import com.huawei.hwcloudmodel.model.unite.GetSportStatReq;
import com.huawei.hwcloudmodel.model.unite.GetSportStatRsp;
import com.huawei.hwcloudmodel.model.unite.GetSyncVersionsReq;
import com.huawei.hwcloudmodel.model.unite.GetSyncVersionsRsp;
import com.huawei.hwcloudmodel.model.userprofile.BindDeviceReq;
import com.huawei.hwcloudmodel.model.userprofile.BindDeviceRsp;
import com.huawei.hwcloudmodel.model.userprofile.GetBindDeviceReq;
import com.huawei.hwcloudmodel.model.userprofile.GetBindDeviceRsp;
import com.huawei.hwcloudmodel.model.userprofile.GetUserMergeInfoReq;
import com.huawei.hwcloudmodel.model.userprofile.GetUserMergeInfoRsp;
import com.huawei.hwcloudmodel.model.userprofile.GetUserProfileReq;
import com.huawei.hwcloudmodel.model.userprofile.GetUserProfileRsp;
import com.huawei.hwcloudmodel.model.userprofile.MergeUserAllDataReq;
import com.huawei.hwcloudmodel.model.userprofile.MergeUserAllDataRsp;
import com.huawei.hwcloudmodel.model.userprofile.SetUserProfileReq;
import com.huawei.hwcloudmodel.model.userprofile.SetUserProfileRsp;
import com.huawei.hwcloudmodel.p061c.C4688c;
import com.huawei.hwcloudmodel.p061c.C4689d;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.membercenter.sdk.membersdklibrary.api.MemberServiceAPI;
import com.huawei.membercenter.sdk.membersdklibrary.api.MemberServiceAPI.IActiveMemberCallback;
import com.huawei.membercenter.sdk.membersdklibrary.api.MemberServiceAPI.IQueryMemberStatusCallback;
import com.huawei.p190v.C2538c;

import java.util.Map;

/* compiled from: HWCloudMgr */
public class C4710a extends a {
    private static C4710a f17161b = null;
    private Context f17162a = null;
    private C4689d f17163c = null;
    private BroadcastReceiver f17164d = new C4711b(this);

    protected Integer getModuleId() {
        return Integer.valueOf(1002);
    }

    public static C4710a m22540a(Context context) {
        if (f17161b == null) {
            f17161b = new C4710a(BaseApplication.b());
        }
        return f17161b;
    }

    private C4710a(Context context) {
        super(context);
        this.f17162a = context;
        if (this.f17163c == null) {
            this.f17163c = C4689d.m22457a(context);
        }
        registerBroadcast(this.f17164d, "com.huawei.plugin.account.login");
    }

    public AddHealthStatRsp m22542a(AddHealthStatReq addHealthStatReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22465a(addHealthStatReq);
        }
        return null;
    }

    public BindDeviceRsp m22557a(BindDeviceReq bindDeviceReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22480a(bindDeviceReq);
        }
        return null;
    }

    public GetBindDeviceRsp m22558a(GetBindDeviceReq getBindDeviceReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22481a(getBindDeviceReq);
        }
        return null;
    }

    public SetUserProfileRsp m22560a(SetUserProfileReq setUserProfileReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22483a(setUserProfileReq);
        }
        return null;
    }

    public GetUserProfileRsp m22559a(GetUserProfileReq getUserProfileReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22482a(getUserProfileReq);
        }
        return null;
    }

    public GetSyncVersionsRsp m22556a(GetSyncVersionsReq getSyncVersionsReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22479a(getSyncVersionsReq);
        }
        return null;
    }

    public AddSportDataRsp m22545a(AddSportDataReq addSportDataReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22468a(addSportDataReq);
        }
        return null;
    }

    public GetSportDataByTimeRsp m22552a(GetSportDataByTimeReq getSportDataByTimeReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22475a(getSportDataByTimeReq);
        }
        return null;
    }

    public GetSportDataByVersionRsp m22553a(GetSportDataByVersionReq getSportDataByVersionReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22476a(getSportDataByVersionReq);
        }
        return null;
    }

    public AddSportTotalRsp m22546a(AddSportTotalReq addSportTotalReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22469a(addSportTotalReq);
        }
        return null;
    }

    public GetSportStatRsp m22555a(GetSportStatReq getSportStatReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22478a(getSportStatReq);
        }
        return null;
    }

    public GetSportDimenStatRsp m22554a(GetSportDimenStatReq getSportDimenStatReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22477a(getSportDimenStatReq);
        }
        return null;
    }

    public AddSleepStatRsp m22544a(AddSleepStatReq addSleepStatReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22467a(addSleepStatReq);
        }
        return null;
    }

    public GetSleepStatRsp m22551a(GetSleepStatReq getSleepStatReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22474a(getSleepStatReq);
        }
        return null;
    }

    public AddHealthDataRsp m22541a(AddHealthDataReq addHealthDataReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22464a(addHealthDataReq);
        }
        return null;
    }

    public GetHealthDataByTimeRsp m22548a(GetHealthDataByTimeReq getHealthDataByTimeReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22471a(getHealthDataByTimeReq);
        }
        return null;
    }

    public GetHealthDataByVersionRsp m22549a(GetHealthDataByVersionReq getHealthDataByVersionReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22472a(getHealthDataByVersionReq);
        }
        return null;
    }

    public DelHealthDataRsp m22547a(DelHealthDataReq delHealthDataReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22470a(delHealthDataReq);
        }
        return null;
    }

    public AddMotionPathRsp m22543a(AddMotionPathReq addMotionPathReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22466a(addMotionPathReq);
        }
        return null;
    }

    public GetMotionPathByVersionRsp m22550a(GetMotionPathByVersionReq getMotionPathByVersionReq) {
        if (this.f17163c != null) {
            return this.f17163c.m22473a(getMotionPathByVersionReq);
        }
        return null;
    }

    public void m22561a(double d, double d2, C3957a<C4688c> c3957a) {
        if (this.f17163c != null) {
            this.f17163c.m22486a(d, d2, (C3957a) c3957a);
        }
    }

    public void m22564a(Bundle bundle, Context context, IQueryMemberStatusCallback iQueryMemberStatusCallback) {
        C2538c.b("HWCloudMgr", new Object[]{"enter queryMemberStatus():"});
        MemberServiceAPI.queryMemberStatus(bundle, context, iQueryMemberStatusCallback);
    }

    public void m22565a(GetUserMergeInfoReq getUserMergeInfoReq, C3957a<GetUserMergeInfoRsp> c3957a) {
        if (this.f17163c != null) {
            this.f17163c.m22492a(getUserMergeInfoReq, (C3957a) c3957a);
        }
    }

    public void m22563a(Bundle bundle, Context context, IActiveMemberCallback iActiveMemberCallback) {
        C2538c.b("HWCloudMgr", new Object[]{"enter activeMember():"});
        MemberServiceAPI.activeMember(bundle, context, iActiveMemberCallback);
    }

    public void m22562a(int i, String str, Listener<String> listener, ErrorListener errorListener, Map<String, String> map) {
        RequestManager.init(this.f17162a);
        RequestManager.addRequest(new CustomStringRequest(i, str, (Listener) listener, errorListener, (Map) map), this);
    }

    public void m22566a(MergeUserAllDataReq mergeUserAllDataReq, C3957a<MergeUserAllDataRsp> c3957a) {
        if (this.f17163c != null) {
            this.f17163c.m22493a(mergeUserAllDataReq, (C3957a) c3957a);
        }
    }
}
