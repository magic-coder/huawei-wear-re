package com.huawei.hwcloudmodel.p061c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.com.fmsh.tsm.business.constants.Constants.XMLNode;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcloudmodel.b.i;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.model.RequestResult;
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
import com.huawei.hwcloudmodel.model.unite.DelAllHealthDataReq;
import com.huawei.hwcloudmodel.model.unite.DelAllMotionPathReq;
import com.huawei.hwcloudmodel.model.unite.DelAllSportDataReq;
import com.huawei.hwcloudmodel.model.unite.DelHealthDataReq;
import com.huawei.hwcloudmodel.model.unite.DelHealthDataRsp;
import com.huawei.hwcloudmodel.model.unite.DelMotionPathReq;
import com.huawei.hwcloudmodel.model.unite.DelSportDataReq;
import com.huawei.hwcloudmodel.model.unite.GetHealthDataByTimeReq;
import com.huawei.hwcloudmodel.model.unite.GetHealthDataByTimeRsp;
import com.huawei.hwcloudmodel.model.unite.GetHealthDataByVersionReq;
import com.huawei.hwcloudmodel.model.unite.GetHealthDataByVersionRsp;
import com.huawei.hwcloudmodel.model.unite.GetHealthStatReq;
import com.huawei.hwcloudmodel.model.unite.GetMotionPathByTimeReq;
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
import com.huawei.hwcloudmodel.model.userprofile.AddPrivacyRecordReq;
import com.huawei.hwcloudmodel.model.userprofile.AddPrivacyRecordRsp;
import com.huawei.hwcloudmodel.model.userprofile.BindDeviceReq;
import com.huawei.hwcloudmodel.model.userprofile.BindDeviceRsp;
import com.huawei.hwcloudmodel.model.userprofile.DelAuthorizeReq;
import com.huawei.hwcloudmodel.model.userprofile.DeleteUserProfileReq;
import com.huawei.hwcloudmodel.model.userprofile.DeleteUserProfileRsp;
import com.huawei.hwcloudmodel.model.userprofile.GetAuthorizeReq;
import com.huawei.hwcloudmodel.model.userprofile.GetBindDeviceReq;
import com.huawei.hwcloudmodel.model.userprofile.GetBindDeviceRsp;
import com.huawei.hwcloudmodel.model.userprofile.GetPrivacyRecordReq;
import com.huawei.hwcloudmodel.model.userprofile.GetPrivacyRecordRsp;
import com.huawei.hwcloudmodel.model.userprofile.GetUserMergeInfoReq;
import com.huawei.hwcloudmodel.model.userprofile.GetUserMergeInfoRsp;
import com.huawei.hwcloudmodel.model.userprofile.GetUserProfileReq;
import com.huawei.hwcloudmodel.model.userprofile.GetUserProfileRsp;
import com.huawei.hwcloudmodel.model.userprofile.MergeUserAllDataReq;
import com.huawei.hwcloudmodel.model.userprofile.MergeUserAllDataRsp;
import com.huawei.hwcloudmodel.model.userprofile.SetAuthorizeReq;
import com.huawei.hwcloudmodel.model.userprofile.SetUserProfileReq;
import com.huawei.hwcloudmodel.model.userprofile.SetUserProfileRsp;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.login.ui.login.a;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;
import com.huawei.up.model.UserInfomation;
import com.huawei.up.p517a.C6108a;
import com.huawei.up.p520e.C6133g;
import com.sina.weibo.sdk.component.GameManager;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.client.methods.HttpGet;

/* compiled from: HWCloudUtils */
public class C4689d {
    public static final String f17112a = (TextUtils.isEmpty(Build.MODEL) ? "G510" : Build.MODEL);
    public static final HostnameVerifier f17113b = new C4699l();
    private static C4689d f17114c = null;
    private static String f17115e = "https://health.vmall.com/v2/rest";
    private Context f17116d;
    private C4703p f17117f;
    private ExecutorService f17118g;
    private a f17119h;
    private String f17120i;

    private C4689d() {
        this.f17116d = null;
        this.f17117f = null;
        this.f17118g = Executors.newFixedThreadPool(5);
        this.f17119h = null;
        this.f17120i = "7";
        this.f17116d = BaseApplication.b();
        this.f17119h = a.a(this.f17116d);
        this.f17117f = new C4703p(this.f17116d);
        this.f17117f.m22516b();
    }

    public static C4689d m22457a(Context context) {
        if (f17114c == null) {
            f17114c = new C4689d();
        }
        return f17114c;
    }

    private String m22462b(Object obj) {
        if (obj instanceof SetUserProfileReq) {
            return "/profile/user/setUserProfile";
        }
        if (obj instanceof GetUserProfileReq) {
            return "/profile/user/getUserProfile";
        }
        if (obj instanceof DeleteUserProfileReq) {
            return "/profile/user/deleteUserProfile";
        }
        if (obj instanceof BindDeviceReq) {
            return "/profile/device/bindDevice";
        }
        if (obj instanceof GetBindDeviceReq) {
            return "/profile/device/getBindDevice";
        }
        if (obj instanceof AddPrivacyRecordReq) {
            return "/profile/privacy/addPrivacyRecord";
        }
        if (obj instanceof GetPrivacyRecordReq) {
            return "/profile/privacy/getPrivacyRecord";
        }
        if (obj instanceof GetSyncVersionsReq) {
            return "/dataQuery/common/getSyncVersions";
        }
        if (obj instanceof AddSportDataReq) {
            return "/dataSync/sport/addSportsData";
        }
        if (obj instanceof GetSportDataByTimeReq) {
            return "/dataQuery/sport/getSportsDataByTime";
        }
        if (obj instanceof GetSportDataByVersionReq) {
            return "/dataQuery/sport/getSportsDataByVersion";
        }
        if (obj instanceof DelSportDataReq) {
            return "/dataSync/sport/deleteSportsData";
        }
        if (obj instanceof DelAllSportDataReq) {
            return "/dataSync/sport/deleteAllSportsData";
        }
        if (obj instanceof AddSportTotalReq) {
            return "/dataSync/sport/addTotalSportsData";
        }
        if (obj instanceof GetSportStatReq) {
            return "/dataQuery/sport/getSportsStat";
        }
        if (obj instanceof GetSportDimenStatReq) {
            return "/dataQuery/sport/getSportsDimenStat";
        }
        if (obj instanceof AddSleepStatReq) {
            return "/dataSync/sport/addSleepStat";
        }
        if (obj instanceof GetSleepStatReq) {
            return "/dataQuery/sport/getSleepStat";
        }
        if (obj instanceof AddHealthDataReq) {
            return "/dataSync/health/addHealthData";
        }
        if (obj instanceof GetHealthDataByTimeReq) {
            return "/dataQuery/health/getHealthData";
        }
        if (obj instanceof GetHealthDataByVersionReq) {
            return "/dataQuery/health/getHealthDataByVersion";
        }
        if (obj instanceof DelHealthDataReq) {
            return "/dataSync/health/deleteHealthData";
        }
        if (obj instanceof DelAllHealthDataReq) {
            return "/dataSync/health/deleteAllHealthData";
        }
        if (obj instanceof AddHealthStatReq) {
            return "/dataSync/health/addHealthStat";
        }
        if (obj instanceof GetHealthStatReq) {
            return "/dataQuery/health/getHealthStat";
        }
        if (obj instanceof AddMotionPathReq) {
            return "/dataSync/path/addMotionPathData";
        }
        if (obj instanceof GetMotionPathByTimeReq) {
            return "/dataQuery/path/getMotionPathData";
        }
        if (obj instanceof GetMotionPathByVersionReq) {
            return "/dataQuery/path/getMotionPathByVersion";
        }
        if (obj instanceof DelMotionPathReq) {
            return "/dataSync/path/deleteMotionPathData";
        }
        if (obj instanceof DelAllMotionPathReq) {
            return "/dataSync/path/deleteAllMotionPathData";
        }
        if (obj instanceof GetUserMergeInfoReq) {
            return "/profile/merge/getUserMergeInfo";
        }
        if (obj instanceof SetAuthorizeReq) {
            return "/profile/third/authorize";
        }
        if (obj instanceof GetAuthorizeReq) {
            return "/profile/third/getAuthorizeToken";
        }
        if (obj instanceof DelAuthorizeReq) {
            return "/profile/third/cancelAuthorize";
        }
        if (obj instanceof MergeUserAllDataReq) {
            return "/profile/merge/mergeUserAllData";
        }
        return null;
    }

    HashMap<String, Object> m22484a(Object obj) {
        HashMap<String, Object> hashMap = new HashMap();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            String name = field.getName();
            try {
                boolean isAccessible = field.isAccessible();
                if (!isAccessible) {
                    field.setAccessible(true);
                }
                Object obj2 = field.get(obj);
                if (!isAccessible) {
                    field.setAccessible(false);
                }
                if (obj2 != null) {
                    hashMap.put(name, obj2);
                }
                i++;
            } catch (Exception e) {
                C2538c.c("HWCloudUtils", new Object[]{" get obj" + name + "EXCEPTION E:" + e.getMessage()});
                return null;
            }
        }
        return hashMap;
    }

    public void m22487a(Context context, C3957a<UserInfomation> c3957a) {
        C2538c.c("HWCloudUtils", new Object[]{"Enter getUserInfoFromUP"});
        int b = a.a(BaseApplication.b()).b();
        boolean z = (b == 0 || b == -1) ? false : true;
        C2538c.c("HWCloudUtils", new Object[]{"isThirdLogin:" + z});
        if (z) {
            C2538c.c("HWCloudUtils", new Object[]{" no download return"});
            if (c3957a != null) {
                c3957a.mo4330a(null, null, false);
                return;
            }
            return;
        }
        new C6108a(this.f17116d).m27874a(context, new C4690e(this, c3957a));
    }

    public void m22488a(Context context, UserInfomation userInfomation, C3957a<Boolean> c3957a) {
        C2538c.c("HWCloudUtils", new Object[]{"Enter setUserInfoToUP"});
        C6108a c6108a = new C6108a(this.f17116d);
        c6108a.m27876a(context, userInfomation, new C4695h(this, userInfomation, c6108a, context, c3957a));
    }

    public void m22490a(DeleteUserProfileReq deleteUserProfileReq, C3957a<DeleteUserProfileRsp> c3957a) {
        C2538c.c("HWCloudUtils", new Object[]{"Enter deleteUserProfile"});
        HashMap hashMap = new HashMap();
        try {
            m22459a((Object) deleteUserProfileReq, hashMap);
        } catch (Exception e) {
            C2538c.c("HWCloudUtils", new Object[]{"deleteUserProfileEXCEPTION E:" + e.getMessage()});
        }
        String b = m22462b(deleteUserProfileReq);
        if (b == null) {
            C2538c.c("HWCloudUtils", new Object[]{"deleteUserProfile unknown url"});
            c3957a.mo4330a(null, "unknown url", false);
            return;
        }
        this.f17117f.m22515a(b, hashMap, new C4700m(this, c3957a));
    }

    public void m22489a(AddPrivacyRecordReq addPrivacyRecordReq, C3957a<AddPrivacyRecordRsp> c3957a) {
        C2538c.c("HWCloudUtils", new Object[]{"Enter addPrivacyRecord "});
        HashMap hashMap = new HashMap();
        try {
            m22459a((Object) addPrivacyRecordReq, hashMap);
        } catch (Exception e) {
            C2538c.c("HWCloudUtils", new Object[]{"addPrivacyRecord EXCEPTION E:" + e.getMessage()});
        }
        String b = m22462b(addPrivacyRecordReq);
        if (b == null) {
            C2538c.c("HWCloudUtils", new Object[]{"addPrivacyRecord  unknown url"});
            c3957a.mo4330a(null, "unknown url", false);
            return;
        }
        this.f17117f.m22515a(b, hashMap, new C4701n(this, c3957a));
    }

    public void m22491a(GetPrivacyRecordReq getPrivacyRecordReq, C3957a<GetPrivacyRecordRsp> c3957a) {
        C2538c.c("HWCloudUtils", new Object[]{"Enter getPrivacyRecord "});
        HashMap hashMap = new HashMap();
        try {
            m22459a((Object) getPrivacyRecordReq, hashMap);
        } catch (Exception e) {
            C2538c.c("HWCloudUtils", new Object[]{"getPrivacyRecord EXCEPTION E:" + e.getMessage()});
        }
        String b = m22462b(getPrivacyRecordReq);
        if (b == null) {
            C2538c.c("HWCloudUtils", new Object[]{"getPrivacyRecord  unknown url"});
            c3957a.mo4330a(null, "unknown url", false);
            return;
        }
        this.f17117f.m22515a(b, hashMap, new C4702o(this, c3957a));
    }

    public void m22493a(MergeUserAllDataReq mergeUserAllDataReq, C3957a<MergeUserAllDataRsp> c3957a) {
        C2538c.c("HWCloudUtils", new Object[]{"Enter mergeUserAllData "});
        C2538c.b("HWCloudUtils", new Object[]{"Enter mergeUserAllData req:" + mergeUserAllDataReq.toString()});
        if (i.a(57)) {
            HashMap hashMap = new HashMap();
            try {
                m22459a((Object) mergeUserAllDataReq, hashMap);
            } catch (Exception e) {
                C2538c.c("HWCloudUtils", new Object[]{"mergeUserAllData IllegalAccessException E:" + e.getMessage()});
            }
            String b = m22462b(mergeUserAllDataReq);
            if (b == null) {
                C2538c.c("HWCloudUtils", new Object[]{"mergeUserAllData  unknown url"});
                c3957a.mo4330a(null, "unknown url", false);
                return;
            }
            this.f17117f.m22515a(b, hashMap, new C4692f(this, c3957a));
            return;
        }
        C2538c.c("HWCloudUtils", new Object[]{"Enter mergeUserAllData no cloud version"});
        MergeUserAllDataRsp mergeUserAllDataRsp = new MergeUserAllDataRsp();
        mergeUserAllDataRsp.setResultCode(0);
        c3957a.mo4330a(mergeUserAllDataRsp, "no cloud version", true);
    }

    public void m22492a(GetUserMergeInfoReq getUserMergeInfoReq, C3957a<GetUserMergeInfoRsp> c3957a) {
        C2538c.c("HWCloudUtils", new Object[]{"Enter getUserMergeInfo"});
        if (i.a(57)) {
            HashMap hashMap = new HashMap();
            try {
                m22459a((Object) getUserMergeInfoReq, hashMap);
            } catch (Exception e) {
                C2538c.c("HWCloudUtils", new Object[]{"getUserMergeInfoIllegalAccessException E:" + e.getMessage()});
            }
            String b = m22462b(getUserMergeInfoReq);
            if (b == null) {
                C2538c.c("HWCloudUtils", new Object[]{"getUserMergeInfo unknown url"});
                c3957a.mo4330a(null, "unknown url", false);
                return;
            }
            this.f17117f.m22515a(b, hashMap, new C4693g(this, c3957a));
            return;
        }
        C2538c.c("HWCloudUtils", new Object[]{"Enter getUserMergeInfo no cloud version"});
        GetUserMergeInfoRsp getUserMergeInfoRsp = new GetUserMergeInfoRsp();
        getUserMergeInfoRsp.setResultCode(0);
        c3957a.mo4330a(getUserMergeInfoRsp, "no cloud version", true);
    }

    public BindDeviceRsp m22480a(BindDeviceReq bindDeviceReq) {
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EnterbindDeviceSync"});
        String b = m22462b(bindDeviceReq);
        HashMap a = m22484a((Object) bindDeviceReq);
        if (m22461a(b, a, "bindDeviceSync")) {
            BindDeviceRsp bindDeviceRsp = new BindDeviceRsp();
            BindDeviceRsp bindDeviceRsp2;
            try {
                try {
                    bindDeviceRsp2 = (BindDeviceRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), BindDeviceRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"bindDeviceSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return bindDeviceRsp2;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"bindDeviceSync fromJson exception :" + e.getMessage()});
                            bindDeviceRsp2.setResultCode(1);
                            bindDeviceRsp2.setResultDesc(e.getMessage());
                            return bindDeviceRsp2;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"bindDeviceSync nspClient exception :" + e2.getMessage()});
                            bindDeviceRsp2.setResultCode(1);
                            bindDeviceRsp2.setResultDesc(e2.getMessage());
                            return bindDeviceRsp2;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    bindDeviceRsp2 = bindDeviceRsp;
                    C2538c.c("HWCloudUtils", new Object[]{"bindDeviceSync fromJson exception :" + e.getMessage()});
                    bindDeviceRsp2.setResultCode(1);
                    bindDeviceRsp2.setResultDesc(e.getMessage());
                    return bindDeviceRsp2;
                }
            } catch (C6133g e6) {
                e2 = e6;
                bindDeviceRsp2 = bindDeviceRsp;
                C2538c.c("HWCloudUtils", new Object[]{"bindDeviceSync nspClient exception :" + e2.getMessage()});
                bindDeviceRsp2.setResultCode(1);
                bindDeviceRsp2.setResultDesc(e2.getMessage());
                return bindDeviceRsp2;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"bindDeviceSync url or params invalidate"});
        return null;
    }

    public GetBindDeviceRsp m22481a(GetBindDeviceReq getBindDeviceReq) {
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EntergetBindDeviceSync"});
        String b = m22462b(getBindDeviceReq);
        HashMap a = m22484a((Object) getBindDeviceReq);
        if (m22461a(b, a, "getBindDeviceSync")) {
            GetBindDeviceRsp getBindDeviceRsp = new GetBindDeviceRsp();
            GetBindDeviceRsp getBindDeviceRsp2;
            try {
                try {
                    getBindDeviceRsp2 = (GetBindDeviceRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), GetBindDeviceRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"getBindDeviceSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return getBindDeviceRsp2;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"getBindDeviceSync fromJson exception :" + e.getMessage()});
                            getBindDeviceRsp2.setResultCode(1);
                            getBindDeviceRsp2.setResultDesc(e.getMessage());
                            return getBindDeviceRsp2;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"getBindDeviceSync nspClient exception :" + e2.getMessage()});
                            getBindDeviceRsp2.setResultCode(1);
                            getBindDeviceRsp2.setResultDesc(e2.getMessage());
                            return getBindDeviceRsp2;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    getBindDeviceRsp2 = getBindDeviceRsp;
                    C2538c.c("HWCloudUtils", new Object[]{"getBindDeviceSync fromJson exception :" + e.getMessage()});
                    getBindDeviceRsp2.setResultCode(1);
                    getBindDeviceRsp2.setResultDesc(e.getMessage());
                    return getBindDeviceRsp2;
                }
            } catch (C6133g e6) {
                e2 = e6;
                getBindDeviceRsp2 = getBindDeviceRsp;
                C2538c.c("HWCloudUtils", new Object[]{"getBindDeviceSync nspClient exception :" + e2.getMessage()});
                getBindDeviceRsp2.setResultCode(1);
                getBindDeviceRsp2.setResultDesc(e2.getMessage());
                return getBindDeviceRsp2;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"getBindDeviceSync url or params invalidate"});
        return null;
    }

    public SetUserProfileRsp m22483a(SetUserProfileReq setUserProfileReq) {
        SetUserProfileRsp setUserProfileRsp;
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EntersetUserProfileSync"});
        String b = m22462b(setUserProfileReq);
        HashMap a = m22484a((Object) setUserProfileReq);
        if (m22461a(b, a, "setUserProfileSync")) {
            SetUserProfileRsp setUserProfileRsp2 = new SetUserProfileRsp();
            try {
                try {
                    setUserProfileRsp = (SetUserProfileRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 1), SetUserProfileRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"setUserProfileSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return setUserProfileRsp;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"setUserProfileSync fromJson exception :" + e.getMessage()});
                            setUserProfileRsp.setResultCode(1);
                            setUserProfileRsp.setResultDesc(e.getMessage());
                            return setUserProfileRsp;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"setUserProfileSync nspClient exception :" + e2.getMessage()});
                            setUserProfileRsp.setResultCode(1);
                            setUserProfileRsp.setResultDesc(e2.getMessage());
                            return setUserProfileRsp;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    setUserProfileRsp = setUserProfileRsp2;
                    C2538c.c("HWCloudUtils", new Object[]{"setUserProfileSync fromJson exception :" + e.getMessage()});
                    setUserProfileRsp.setResultCode(1);
                    setUserProfileRsp.setResultDesc(e.getMessage());
                    return setUserProfileRsp;
                }
            } catch (C6133g e6) {
                e2 = e6;
                setUserProfileRsp = setUserProfileRsp2;
                C2538c.c("HWCloudUtils", new Object[]{"setUserProfileSync nspClient exception :" + e2.getMessage()});
                setUserProfileRsp.setResultCode(1);
                setUserProfileRsp.setResultDesc(e2.getMessage());
                return setUserProfileRsp;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"setUserProfileSync url or params invalidate"});
        return null;
    }

    public GetUserProfileRsp m22482a(GetUserProfileReq getUserProfileReq) {
        GetUserProfileRsp getUserProfileRsp;
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EntergetUserProfileSync"});
        String b = m22462b(getUserProfileReq);
        HashMap a = m22484a((Object) getUserProfileReq);
        if (m22461a(b, a, "getUserProfileSync")) {
            GetUserProfileRsp getUserProfileRsp2 = new GetUserProfileRsp();
            try {
                try {
                    getUserProfileRsp = (GetUserProfileRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 1), GetUserProfileRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"getUserProfileSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return getUserProfileRsp;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"getUserProfileSync fromJson exception :" + e.getMessage()});
                            getUserProfileRsp.setResultCode(1);
                            getUserProfileRsp.setResultDesc(e.getMessage());
                            return getUserProfileRsp;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"getUserProfileSync nspClient exception :" + e2.getMessage()});
                            getUserProfileRsp.setResultCode(1);
                            getUserProfileRsp.setResultDesc(e2.getMessage());
                            return getUserProfileRsp;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    getUserProfileRsp = getUserProfileRsp2;
                    C2538c.c("HWCloudUtils", new Object[]{"getUserProfileSync fromJson exception :" + e.getMessage()});
                    getUserProfileRsp.setResultCode(1);
                    getUserProfileRsp.setResultDesc(e.getMessage());
                    return getUserProfileRsp;
                }
            } catch (C6133g e6) {
                e2 = e6;
                getUserProfileRsp = getUserProfileRsp2;
                C2538c.c("HWCloudUtils", new Object[]{"getUserProfileSync nspClient exception :" + e2.getMessage()});
                getUserProfileRsp.setResultCode(1);
                getUserProfileRsp.setResultDesc(e2.getMessage());
                return getUserProfileRsp;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"getUserProfileSync url or params invalidate"});
        return null;
    }

    public GetSyncVersionsRsp m22479a(GetSyncVersionsReq getSyncVersionsReq) {
        GetSyncVersionsRsp getSyncVersionsRsp;
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EntergetSyncVersionsSync"});
        String b = m22462b(getSyncVersionsReq);
        HashMap a = m22484a((Object) getSyncVersionsReq);
        if (m22461a(b, a, "getSyncVersionsSync")) {
            GetSyncVersionsRsp getSyncVersionsRsp2 = new GetSyncVersionsRsp();
            try {
                try {
                    getSyncVersionsRsp = (GetSyncVersionsRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), GetSyncVersionsRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"getSyncVersionsSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return getSyncVersionsRsp;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"getSyncVersionsSync fromJson exception :" + e.getMessage()});
                            getSyncVersionsRsp.setResultCode(1);
                            getSyncVersionsRsp.setResultDesc(e.getMessage());
                            return getSyncVersionsRsp;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"getSyncVersionsSync nspClient exception :" + e2.getMessage()});
                            getSyncVersionsRsp.setResultCode(1);
                            getSyncVersionsRsp.setResultDesc(e2.getMessage());
                            return getSyncVersionsRsp;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    getSyncVersionsRsp = getSyncVersionsRsp2;
                    C2538c.c("HWCloudUtils", new Object[]{"getSyncVersionsSync fromJson exception :" + e.getMessage()});
                    getSyncVersionsRsp.setResultCode(1);
                    getSyncVersionsRsp.setResultDesc(e.getMessage());
                    return getSyncVersionsRsp;
                }
            } catch (C6133g e6) {
                e2 = e6;
                getSyncVersionsRsp = getSyncVersionsRsp2;
                C2538c.c("HWCloudUtils", new Object[]{"getSyncVersionsSync nspClient exception :" + e2.getMessage()});
                getSyncVersionsRsp.setResultCode(1);
                getSyncVersionsRsp.setResultDesc(e2.getMessage());
                return getSyncVersionsRsp;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"getSyncVersionsSync url or params invalidate"});
        return null;
    }

    public AddSportDataRsp m22468a(AddSportDataReq addSportDataReq) {
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EnteraddSportDataSync"});
        String b = m22462b(addSportDataReq);
        HashMap a = m22484a((Object) addSportDataReq);
        if (m22461a(b, a, "addSportDataSync")) {
            AddSportDataRsp addSportDataRsp = new AddSportDataRsp();
            AddSportDataRsp addSportDataRsp2;
            try {
                try {
                    addSportDataRsp2 = (AddSportDataRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), AddSportDataRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"addSportDataSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return addSportDataRsp2;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"addSportDataSync fromJson exception :" + e.getMessage()});
                            addSportDataRsp2.setResultCode(1);
                            addSportDataRsp2.setResultDesc(e.getMessage());
                            return addSportDataRsp2;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"addSportDataSync nspClient exception :" + e2.getMessage()});
                            addSportDataRsp2.setResultCode(1);
                            addSportDataRsp2.setResultDesc(e2.getMessage());
                            return addSportDataRsp2;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    addSportDataRsp2 = addSportDataRsp;
                    C2538c.c("HWCloudUtils", new Object[]{"addSportDataSync fromJson exception :" + e.getMessage()});
                    addSportDataRsp2.setResultCode(1);
                    addSportDataRsp2.setResultDesc(e.getMessage());
                    return addSportDataRsp2;
                }
            } catch (C6133g e6) {
                e2 = e6;
                addSportDataRsp2 = addSportDataRsp;
                C2538c.c("HWCloudUtils", new Object[]{"addSportDataSync nspClient exception :" + e2.getMessage()});
                addSportDataRsp2.setResultCode(1);
                addSportDataRsp2.setResultDesc(e2.getMessage());
                return addSportDataRsp2;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"addSportDataSync url or params invalidate"});
        return null;
    }

    public GetSportDataByTimeRsp m22475a(GetSportDataByTimeReq getSportDataByTimeReq) {
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EntergetSportDataByTimeSync"});
        String b = m22462b(getSportDataByTimeReq);
        HashMap a = m22484a((Object) getSportDataByTimeReq);
        if (m22461a(b, a, "getSportDataByTimeSync")) {
            GetSportDataByTimeRsp getSportDataByTimeRsp = new GetSportDataByTimeRsp();
            GetSportDataByTimeRsp getSportDataByTimeRsp2;
            try {
                try {
                    getSportDataByTimeRsp2 = (GetSportDataByTimeRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), GetSportDataByTimeRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"getSportDataByTimeSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return getSportDataByTimeRsp2;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"getSportDataByTimeSync fromJson exception :" + e.getMessage()});
                            getSportDataByTimeRsp2.setResultCode(1);
                            getSportDataByTimeRsp2.setResultDesc(e.getMessage());
                            return getSportDataByTimeRsp2;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"getSportDataByTimeSync nspClient exception :" + e2.getMessage()});
                            getSportDataByTimeRsp2.setResultCode(1);
                            getSportDataByTimeRsp2.setResultDesc(e2.getMessage());
                            return getSportDataByTimeRsp2;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    getSportDataByTimeRsp2 = getSportDataByTimeRsp;
                    C2538c.c("HWCloudUtils", new Object[]{"getSportDataByTimeSync fromJson exception :" + e.getMessage()});
                    getSportDataByTimeRsp2.setResultCode(1);
                    getSportDataByTimeRsp2.setResultDesc(e.getMessage());
                    return getSportDataByTimeRsp2;
                }
            } catch (C6133g e6) {
                e2 = e6;
                getSportDataByTimeRsp2 = getSportDataByTimeRsp;
                C2538c.c("HWCloudUtils", new Object[]{"getSportDataByTimeSync nspClient exception :" + e2.getMessage()});
                getSportDataByTimeRsp2.setResultCode(1);
                getSportDataByTimeRsp2.setResultDesc(e2.getMessage());
                return getSportDataByTimeRsp2;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"getSportDataByTimeSync url or params invalidate"});
        return null;
    }

    public GetSportDataByVersionRsp m22476a(GetSportDataByVersionReq getSportDataByVersionReq) {
        GetSportDataByVersionRsp getSportDataByVersionRsp;
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EntergetSportDataByVersionSync"});
        String b = m22462b(getSportDataByVersionReq);
        HashMap a = m22484a((Object) getSportDataByVersionReq);
        if (m22461a(b, a, "getSportDataByVersionSync")) {
            GetSportDataByVersionRsp getSportDataByVersionRsp2 = new GetSportDataByVersionRsp();
            try {
                try {
                    getSportDataByVersionRsp = (GetSportDataByVersionRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), GetSportDataByVersionRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"getSportDataByVersionSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return getSportDataByVersionRsp;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"getSportDataByVersionSync fromJson exception :" + e.getMessage()});
                            getSportDataByVersionRsp.setResultCode(1);
                            getSportDataByVersionRsp.setResultDesc(e.getMessage());
                            return getSportDataByVersionRsp;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"getSportDataByVersionSync nspClient exception :" + e2.getMessage()});
                            getSportDataByVersionRsp.setResultCode(1);
                            getSportDataByVersionRsp.setResultDesc(e2.getMessage());
                            return getSportDataByVersionRsp;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    getSportDataByVersionRsp = getSportDataByVersionRsp2;
                    C2538c.c("HWCloudUtils", new Object[]{"getSportDataByVersionSync fromJson exception :" + e.getMessage()});
                    getSportDataByVersionRsp.setResultCode(1);
                    getSportDataByVersionRsp.setResultDesc(e.getMessage());
                    return getSportDataByVersionRsp;
                }
            } catch (C6133g e6) {
                e2 = e6;
                getSportDataByVersionRsp = getSportDataByVersionRsp2;
                C2538c.c("HWCloudUtils", new Object[]{"getSportDataByVersionSync nspClient exception :" + e2.getMessage()});
                getSportDataByVersionRsp.setResultCode(1);
                getSportDataByVersionRsp.setResultDesc(e2.getMessage());
                return getSportDataByVersionRsp;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"getSportDataByVersionSync url or params invalidate"});
        return null;
    }

    public AddSportTotalRsp m22469a(AddSportTotalReq addSportTotalReq) {
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EnteraddSportTotalSync"});
        String b = m22462b(addSportTotalReq);
        HashMap a = m22484a((Object) addSportTotalReq);
        if (m22461a(b, a, "addSportTotalSync")) {
            AddSportTotalRsp addSportTotalRsp = new AddSportTotalRsp();
            AddSportTotalRsp addSportTotalRsp2;
            try {
                try {
                    addSportTotalRsp2 = (AddSportTotalRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), AddSportTotalRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"addSportTotalSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return addSportTotalRsp2;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"addSportTotalSync fromJson exception :" + e.getMessage()});
                            addSportTotalRsp2.setResultCode(1);
                            addSportTotalRsp2.setResultDesc(e.getMessage());
                            return addSportTotalRsp2;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"addSportTotalSync nspClient exception :" + e2.getMessage()});
                            addSportTotalRsp2.setResultCode(1);
                            addSportTotalRsp2.setResultDesc(e2.getMessage());
                            return addSportTotalRsp2;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    addSportTotalRsp2 = addSportTotalRsp;
                    C2538c.c("HWCloudUtils", new Object[]{"addSportTotalSync fromJson exception :" + e.getMessage()});
                    addSportTotalRsp2.setResultCode(1);
                    addSportTotalRsp2.setResultDesc(e.getMessage());
                    return addSportTotalRsp2;
                }
            } catch (C6133g e6) {
                e2 = e6;
                addSportTotalRsp2 = addSportTotalRsp;
                C2538c.c("HWCloudUtils", new Object[]{"addSportTotalSync nspClient exception :" + e2.getMessage()});
                addSportTotalRsp2.setResultCode(1);
                addSportTotalRsp2.setResultDesc(e2.getMessage());
                return addSportTotalRsp2;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"addSportTotalSync url or params invalidate"});
        return null;
    }

    public GetSportStatRsp m22478a(GetSportStatReq getSportStatReq) {
        GetSportStatRsp getSportStatRsp;
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EntergetSportStatSync"});
        String b = m22462b(getSportStatReq);
        HashMap a = m22484a((Object) getSportStatReq);
        if (m22461a(b, a, "getSportStatSync")) {
            GetSportStatRsp getSportStatRsp2 = new GetSportStatRsp();
            try {
                try {
                    getSportStatRsp = (GetSportStatRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), GetSportStatRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"getSportStatSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return getSportStatRsp;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"getSportStatSync fromJson exception :" + e.getMessage()});
                            getSportStatRsp.setResultCode(1);
                            getSportStatRsp.setResultDesc(e.getMessage());
                            return getSportStatRsp;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"getSportStatSync nspClient exception :" + e2.getMessage()});
                            getSportStatRsp.setResultCode(1);
                            getSportStatRsp.setResultDesc(e2.getMessage());
                            return getSportStatRsp;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    getSportStatRsp = getSportStatRsp2;
                    C2538c.c("HWCloudUtils", new Object[]{"getSportStatSync fromJson exception :" + e.getMessage()});
                    getSportStatRsp.setResultCode(1);
                    getSportStatRsp.setResultDesc(e.getMessage());
                    return getSportStatRsp;
                }
            } catch (C6133g e6) {
                e2 = e6;
                getSportStatRsp = getSportStatRsp2;
                C2538c.c("HWCloudUtils", new Object[]{"getSportStatSync nspClient exception :" + e2.getMessage()});
                getSportStatRsp.setResultCode(1);
                getSportStatRsp.setResultDesc(e2.getMessage());
                return getSportStatRsp;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"getSportStatSync url or params invalidate"});
        return null;
    }

    public GetSportDimenStatRsp m22477a(GetSportDimenStatReq getSportDimenStatReq) {
        GetSportDimenStatRsp getSportDimenStatRsp;
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EntergetSportDimenStatSync"});
        String b = m22462b(getSportDimenStatReq);
        HashMap a = m22484a((Object) getSportDimenStatReq);
        if (m22461a(b, a, "getSportDimenStatSync")) {
            GetSportDimenStatRsp getSportDimenStatRsp2 = new GetSportDimenStatRsp();
            try {
                try {
                    getSportDimenStatRsp = (GetSportDimenStatRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), GetSportDimenStatRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"getSportDimenStatSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return getSportDimenStatRsp;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"getSportDimenStatSync fromJson exception :" + e.getMessage()});
                            getSportDimenStatRsp.setResultCode(1);
                            getSportDimenStatRsp.setResultDesc(e.getMessage());
                            return getSportDimenStatRsp;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"getSportDimenStatSync nspClient exception :" + e2.getMessage()});
                            getSportDimenStatRsp.setResultCode(1);
                            getSportDimenStatRsp.setResultDesc(e2.getMessage());
                            return getSportDimenStatRsp;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    getSportDimenStatRsp = getSportDimenStatRsp2;
                    C2538c.c("HWCloudUtils", new Object[]{"getSportDimenStatSync fromJson exception :" + e.getMessage()});
                    getSportDimenStatRsp.setResultCode(1);
                    getSportDimenStatRsp.setResultDesc(e.getMessage());
                    return getSportDimenStatRsp;
                }
            } catch (C6133g e6) {
                e2 = e6;
                getSportDimenStatRsp = getSportDimenStatRsp2;
                C2538c.c("HWCloudUtils", new Object[]{"getSportDimenStatSync nspClient exception :" + e2.getMessage()});
                getSportDimenStatRsp.setResultCode(1);
                getSportDimenStatRsp.setResultDesc(e2.getMessage());
                return getSportDimenStatRsp;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"getSportDimenStatSync url or params invalidate"});
        return null;
    }

    public AddSleepStatRsp m22467a(AddSleepStatReq addSleepStatReq) {
        AddSleepStatRsp addSleepStatRsp;
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EnteraddSleepStatSync"});
        String b = m22462b(addSleepStatReq);
        HashMap a = m22484a((Object) addSleepStatReq);
        if (m22461a(b, a, "addSleepStatSync")) {
            AddSleepStatRsp addSleepStatRsp2 = new AddSleepStatRsp();
            try {
                try {
                    addSleepStatRsp = (AddSleepStatRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), AddSleepStatRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"addSleepStatSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return addSleepStatRsp;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"addSleepStatSync fromJson exception :" + e.getMessage()});
                            addSleepStatRsp.setResultCode(1);
                            addSleepStatRsp.setResultDesc(e.getMessage());
                            return addSleepStatRsp;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"addSleepStatSync nspClient exception :" + e2.getMessage()});
                            addSleepStatRsp.setResultCode(1);
                            addSleepStatRsp.setResultDesc(e2.getMessage());
                            return addSleepStatRsp;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    addSleepStatRsp = addSleepStatRsp2;
                    C2538c.c("HWCloudUtils", new Object[]{"addSleepStatSync fromJson exception :" + e.getMessage()});
                    addSleepStatRsp.setResultCode(1);
                    addSleepStatRsp.setResultDesc(e.getMessage());
                    return addSleepStatRsp;
                }
            } catch (C6133g e6) {
                e2 = e6;
                addSleepStatRsp = addSleepStatRsp2;
                C2538c.c("HWCloudUtils", new Object[]{"addSleepStatSync nspClient exception :" + e2.getMessage()});
                addSleepStatRsp.setResultCode(1);
                addSleepStatRsp.setResultDesc(e2.getMessage());
                return addSleepStatRsp;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"addSleepStatSync url or params invalidate"});
        return null;
    }

    public GetSleepStatRsp m22474a(GetSleepStatReq getSleepStatReq) {
        GetSleepStatRsp getSleepStatRsp;
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EntergetSleepStatSync"});
        String b = m22462b(getSleepStatReq);
        HashMap a = m22484a((Object) getSleepStatReq);
        if (m22461a(b, a, "getSleepStatSync")) {
            GetSleepStatRsp getSleepStatRsp2 = new GetSleepStatRsp();
            try {
                try {
                    getSleepStatRsp = (GetSleepStatRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), GetSleepStatRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"getSleepStatSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return getSleepStatRsp;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"getSleepStatSync fromJson exception :" + e.getMessage()});
                            getSleepStatRsp.setResultCode(1);
                            getSleepStatRsp.setResultDesc(e.getMessage());
                            return getSleepStatRsp;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"getSleepStatSync nspClient exception :" + e2.getMessage()});
                            getSleepStatRsp.setResultCode(1);
                            getSleepStatRsp.setResultDesc(e2.getMessage());
                            return getSleepStatRsp;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    getSleepStatRsp = getSleepStatRsp2;
                    C2538c.c("HWCloudUtils", new Object[]{"getSleepStatSync fromJson exception :" + e.getMessage()});
                    getSleepStatRsp.setResultCode(1);
                    getSleepStatRsp.setResultDesc(e.getMessage());
                    return getSleepStatRsp;
                }
            } catch (C6133g e6) {
                e2 = e6;
                getSleepStatRsp = getSleepStatRsp2;
                C2538c.c("HWCloudUtils", new Object[]{"getSleepStatSync nspClient exception :" + e2.getMessage()});
                getSleepStatRsp.setResultCode(1);
                getSleepStatRsp.setResultDesc(e2.getMessage());
                return getSleepStatRsp;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"getSleepStatSync url or params invalidate"});
        return null;
    }

    public AddHealthDataRsp m22464a(AddHealthDataReq addHealthDataReq) {
        AddHealthDataRsp addHealthDataRsp;
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EnteraddHealthDataSync"});
        String b = m22462b(addHealthDataReq);
        HashMap a = m22484a((Object) addHealthDataReq);
        if (m22461a(b, a, "addHealthDataSync")) {
            AddHealthDataRsp addHealthDataRsp2 = new AddHealthDataRsp();
            try {
                try {
                    addHealthDataRsp = (AddHealthDataRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), AddHealthDataRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"addHealthDataSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return addHealthDataRsp;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"addHealthDataSync fromJson exception :" + e.getMessage()});
                            addHealthDataRsp.setResultCode(1);
                            addHealthDataRsp.setResultDesc(e.getMessage());
                            return addHealthDataRsp;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"addHealthDataSync nspClient exception :" + e2.getMessage()});
                            addHealthDataRsp.setResultCode(1);
                            addHealthDataRsp.setResultDesc(e2.getMessage());
                            return addHealthDataRsp;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    addHealthDataRsp = addHealthDataRsp2;
                    C2538c.c("HWCloudUtils", new Object[]{"addHealthDataSync fromJson exception :" + e.getMessage()});
                    addHealthDataRsp.setResultCode(1);
                    addHealthDataRsp.setResultDesc(e.getMessage());
                    return addHealthDataRsp;
                }
            } catch (C6133g e6) {
                e2 = e6;
                addHealthDataRsp = addHealthDataRsp2;
                C2538c.c("HWCloudUtils", new Object[]{"addHealthDataSync nspClient exception :" + e2.getMessage()});
                addHealthDataRsp.setResultCode(1);
                addHealthDataRsp.setResultDesc(e2.getMessage());
                return addHealthDataRsp;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"addHealthDataSync url or params invalidate"});
        return null;
    }

    public GetHealthDataByTimeRsp m22471a(GetHealthDataByTimeReq getHealthDataByTimeReq) {
        GetHealthDataByTimeRsp getHealthDataByTimeRsp;
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EntergetHealthDataByTimeSync"});
        String b = m22462b(getHealthDataByTimeReq);
        HashMap a = m22484a((Object) getHealthDataByTimeReq);
        if (m22461a(b, a, "getHealthDataByTimeSync")) {
            GetHealthDataByTimeRsp getHealthDataByTimeRsp2 = new GetHealthDataByTimeRsp();
            try {
                try {
                    getHealthDataByTimeRsp = (GetHealthDataByTimeRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), GetHealthDataByTimeRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"getHealthDataByTimeSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return getHealthDataByTimeRsp;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"getHealthDataByTimeSync fromJson exception :" + e.getMessage()});
                            getHealthDataByTimeRsp.setResultCode(1);
                            getHealthDataByTimeRsp.setResultDesc(e.getMessage());
                            return getHealthDataByTimeRsp;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"getHealthDataByTimeSync nspClient exception :" + e2.getMessage()});
                            getHealthDataByTimeRsp.setResultCode(1);
                            getHealthDataByTimeRsp.setResultDesc(e2.getMessage());
                            return getHealthDataByTimeRsp;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    getHealthDataByTimeRsp = getHealthDataByTimeRsp2;
                    C2538c.c("HWCloudUtils", new Object[]{"getHealthDataByTimeSync fromJson exception :" + e.getMessage()});
                    getHealthDataByTimeRsp.setResultCode(1);
                    getHealthDataByTimeRsp.setResultDesc(e.getMessage());
                    return getHealthDataByTimeRsp;
                }
            } catch (C6133g e6) {
                e2 = e6;
                getHealthDataByTimeRsp = getHealthDataByTimeRsp2;
                C2538c.c("HWCloudUtils", new Object[]{"getHealthDataByTimeSync nspClient exception :" + e2.getMessage()});
                getHealthDataByTimeRsp.setResultCode(1);
                getHealthDataByTimeRsp.setResultDesc(e2.getMessage());
                return getHealthDataByTimeRsp;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"getHealthDataByTimeSync url or parms invalidate"});
        return null;
    }

    public GetHealthDataByVersionRsp m22472a(GetHealthDataByVersionReq getHealthDataByVersionReq) {
        GetHealthDataByVersionRsp getHealthDataByVersionRsp;
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EntergetHealthDataByVersionSync"});
        String b = m22462b(getHealthDataByVersionReq);
        HashMap a = m22484a((Object) getHealthDataByVersionReq);
        if (m22461a(b, a, "getHealthDataByVersionSync")) {
            GetHealthDataByVersionRsp getHealthDataByVersionRsp2 = new GetHealthDataByVersionRsp();
            try {
                try {
                    getHealthDataByVersionRsp = (GetHealthDataByVersionRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), GetHealthDataByVersionRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"getHealthDataByVersionSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return getHealthDataByVersionRsp;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"getHealthDataByVersionSync fromJson exception :" + e.getMessage()});
                            getHealthDataByVersionRsp.setResultCode(1);
                            getHealthDataByVersionRsp.setResultDesc(e.getMessage());
                            return getHealthDataByVersionRsp;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"getHealthDataByVersionSync nspClient exception :" + e2.getMessage()});
                            getHealthDataByVersionRsp.setResultCode(1);
                            getHealthDataByVersionRsp.setResultDesc(e2.getMessage());
                            return getHealthDataByVersionRsp;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    getHealthDataByVersionRsp = getHealthDataByVersionRsp2;
                    C2538c.c("HWCloudUtils", new Object[]{"getHealthDataByVersionSync fromJson exception :" + e.getMessage()});
                    getHealthDataByVersionRsp.setResultCode(1);
                    getHealthDataByVersionRsp.setResultDesc(e.getMessage());
                    return getHealthDataByVersionRsp;
                }
            } catch (C6133g e6) {
                e2 = e6;
                getHealthDataByVersionRsp = getHealthDataByVersionRsp2;
                C2538c.c("HWCloudUtils", new Object[]{"getHealthDataByVersionSync nspClient exception :" + e2.getMessage()});
                getHealthDataByVersionRsp.setResultCode(1);
                getHealthDataByVersionRsp.setResultDesc(e2.getMessage());
                return getHealthDataByVersionRsp;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"getHealthDataByVersionSync url or params invalidate"});
        return null;
    }

    public DelHealthDataRsp m22470a(DelHealthDataReq delHealthDataReq) {
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EnterdelHealthDataSync"});
        String b = m22462b(delHealthDataReq);
        HashMap a = m22484a((Object) delHealthDataReq);
        if (m22461a(b, a, "delHealthDataSync")) {
            DelHealthDataRsp delHealthDataRsp = new DelHealthDataRsp();
            DelHealthDataRsp delHealthDataRsp2;
            try {
                try {
                    delHealthDataRsp2 = (DelHealthDataRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), DelHealthDataRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"delHealthDataSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return delHealthDataRsp2;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"delHealthDataSync fromJson exception :" + e.getMessage()});
                            delHealthDataRsp2.setResultCode(1);
                            delHealthDataRsp2.setResultDesc(e.getMessage());
                            return delHealthDataRsp2;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"delHealthDataSync nspClient exception :" + e2.getMessage()});
                            delHealthDataRsp2.setResultCode(1);
                            delHealthDataRsp2.setResultDesc(e2.getMessage());
                            return delHealthDataRsp2;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    delHealthDataRsp2 = delHealthDataRsp;
                    C2538c.c("HWCloudUtils", new Object[]{"delHealthDataSync fromJson exception :" + e.getMessage()});
                    delHealthDataRsp2.setResultCode(1);
                    delHealthDataRsp2.setResultDesc(e.getMessage());
                    return delHealthDataRsp2;
                }
            } catch (C6133g e6) {
                e2 = e6;
                delHealthDataRsp2 = delHealthDataRsp;
                C2538c.c("HWCloudUtils", new Object[]{"delHealthDataSync nspClient exception :" + e2.getMessage()});
                delHealthDataRsp2.setResultCode(1);
                delHealthDataRsp2.setResultDesc(e2.getMessage());
                return delHealthDataRsp2;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"delHealthDataSync url or parms invalidate"});
        return null;
    }

    public AddMotionPathRsp m22466a(AddMotionPathReq addMotionPathReq) {
        AddMotionPathRsp addMotionPathRsp;
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EnteraddMotionPathSync"});
        String b = m22462b(addMotionPathReq);
        HashMap a = m22484a((Object) addMotionPathReq);
        if (m22461a(b, a, "addMotionPathSync")) {
            AddMotionPathRsp addMotionPathRsp2 = new AddMotionPathRsp();
            try {
                try {
                    addMotionPathRsp = (AddMotionPathRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), AddMotionPathRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"addMotionPathSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return addMotionPathRsp;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"addMotionPathSync fromJson exception :" + e.getMessage()});
                            addMotionPathRsp.setResultCode(1);
                            addMotionPathRsp.setResultDesc(e.getMessage());
                            return addMotionPathRsp;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"addMotionPathSync nspClient exception :" + e2.getMessage()});
                            addMotionPathRsp.setResultCode(1);
                            addMotionPathRsp.setResultDesc(e2.getMessage());
                            return addMotionPathRsp;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    addMotionPathRsp = addMotionPathRsp2;
                    C2538c.c("HWCloudUtils", new Object[]{"addMotionPathSync fromJson exception :" + e.getMessage()});
                    addMotionPathRsp.setResultCode(1);
                    addMotionPathRsp.setResultDesc(e.getMessage());
                    return addMotionPathRsp;
                }
            } catch (C6133g e6) {
                e2 = e6;
                addMotionPathRsp = addMotionPathRsp2;
                C2538c.c("HWCloudUtils", new Object[]{"addMotionPathSync nspClient exception :" + e2.getMessage()});
                addMotionPathRsp.setResultCode(1);
                addMotionPathRsp.setResultDesc(e2.getMessage());
                return addMotionPathRsp;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"addMotionPathSync url or params invalidate"});
        return null;
    }

    public GetMotionPathByVersionRsp m22473a(GetMotionPathByVersionReq getMotionPathByVersionReq) {
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EntergetMotionPathByVersionSync"});
        String b = m22462b(getMotionPathByVersionReq);
        HashMap a = m22484a((Object) getMotionPathByVersionReq);
        if (m22461a(b, a, "getMotionPathByVersionSync")) {
            GetMotionPathByVersionRsp getMotionPathByVersionRsp = new GetMotionPathByVersionRsp();
            GetMotionPathByVersionRsp getMotionPathByVersionRsp2;
            try {
                try {
                    getMotionPathByVersionRsp2 = (GetMotionPathByVersionRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), GetMotionPathByVersionRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"getMotionPathByVersionSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return getMotionPathByVersionRsp2;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"getMotionPathByVersionSync fromJson exception :" + e.getMessage()});
                            getMotionPathByVersionRsp2.setResultCode(1);
                            getMotionPathByVersionRsp2.setResultDesc(e.getMessage());
                            return getMotionPathByVersionRsp2;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"getMotionPathByVersionSync nspClient exception :" + e2.getMessage()});
                            getMotionPathByVersionRsp2.setResultCode(1);
                            getMotionPathByVersionRsp2.setResultDesc(e2.getMessage());
                            return getMotionPathByVersionRsp2;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    getMotionPathByVersionRsp2 = getMotionPathByVersionRsp;
                    C2538c.c("HWCloudUtils", new Object[]{"getMotionPathByVersionSync fromJson exception :" + e.getMessage()});
                    getMotionPathByVersionRsp2.setResultCode(1);
                    getMotionPathByVersionRsp2.setResultDesc(e.getMessage());
                    return getMotionPathByVersionRsp2;
                }
            } catch (C6133g e6) {
                e2 = e6;
                getMotionPathByVersionRsp2 = getMotionPathByVersionRsp;
                C2538c.c("HWCloudUtils", new Object[]{"getMotionPathByVersionSync nspClient exception :" + e2.getMessage()});
                getMotionPathByVersionRsp2.setResultCode(1);
                getMotionPathByVersionRsp2.setResultDesc(e2.getMessage());
                return getMotionPathByVersionRsp2;
            }
        }
        C2538c.e("HWCloudUtils", new Object[]{"getMotionPathByVersionSync, url or params invalidate"});
        return null;
    }

    public void m22485a() {
        if (d.c()) {
            C2538c.c("HWCloudUtils", new Object[]{"changeSTToAT isGreenVersion return"});
            return;
        }
        if (this.f17119h == null) {
            this.f17119h = a.a(BaseApplication.b());
        }
        new C6108a(this.f17116d).m27878a(this.f17119h.g(), true);
    }

    public void m22486a(double d, double d2, C3957a<C4688c> c3957a) {
        this.f17118g.submit(new C4697j(this, d, d2, c3957a));
    }

    public C4688c m22463a(double d, double d2) {
        C4688c c4688c = new C4688c();
        c4688c.m22446a(-99);
        c4688c.m22450c(-99);
        c4688c.m22452d(-99);
        C2538c.c("HWCloudUtils", new Object[]{"-----getWeatherInfo------ Enter latitude = " + d + "longitude = " + d2});
        C2538c.c("HWCloudUtils", new Object[]{"cityKeyUrl :" + ("https://api.accuweather.com" + "/locations/v1/cities/geoposition/search.json?q=" + d + "," + d2 + SNBConstant.FILTER + "apikey=7f8c4da3ce9849ffb2134f075201c45a")});
        int a = C4709v.m22535a(m22458a(r0), XMLNode.KEY);
        C2538c.c("HWCloudUtils", new Object[]{"cityKeyID :" + a});
        if (a == -1) {
            C2538c.c("HWCloudUtils", new Object[]{"get cityKeyID error"});
            return c4688c;
        }
        C2538c.c("HWCloudUtils", new Object[]{"temUrl :" + ("https://api.accuweather.com" + "/currentconditions/v1/" + a + ".json?" + "apikey=7f8c4da3ce9849ffb2134f075201c45a" + "&language=es")});
        String a2 = m22458a(a2);
        if (TextUtils.isEmpty(a2)) {
            C2538c.c("HWCloudUtils", new Object[]{"weatherjson is empty!"});
            return c4688c;
        }
        int b = C4709v.m22536b(a2);
        C2538c.c("HWCloudUtils", new Object[]{"WeatherIcon :" + b});
        if (b == -99) {
            C2538c.c("HWCloudUtils", new Object[]{"WeatherIcon parse error"});
            return c4688c;
        }
        C2538c.c("HWCloudUtils", new Object[]{"temp :" + C4709v.m22534a(a2)});
        String str = "https://api.accuweather.com" + "/forecasts/v1/daily/1day/" + a + ".json?" + "apikey=7f8c4da3ce9849ffb2134f075201c45a" + "&language=es";
        C2538c.c("HWCloudUtils", new Object[]{"lowHighURL :" + str});
        int b2 = C4709v.m22537b(m22458a(str), "Maximum");
        C2538c.c("HWCloudUtils", new Object[]{"High :" + b2 + "Low:" + C4709v.m22537b(m22458a(str), "Minimum")});
        C2538c.c("HWCloudUtils", new Object[]{"pm25URL :" + ("https://api.accuweather.com" + "/airquality/v1/global/observations/" + a + ".json?" + "apikey=7f8c4da3ce9849ffb2134f075201c45a" + "&language=es")});
        int a3 = C4709v.m22535a(m22458a(r0), "ParticulateMatter2_5");
        C2538c.c("HWCloudUtils", new Object[]{"pm25 :" + a3});
        c4688c.m22448b(a3);
        c4688c.m22446a(r2);
        c4688c.m22452d(b2);
        c4688c.m22450c(r4);
        if (C4687b.m22444a().containsKey(String.valueOf(b))) {
            C2538c.c("HWCloudUtils", new Object[]{"WeatherIcon(to device) :" + C4687b.m22444a().get(String.valueOf(b))});
            c4688c.m22454e(((Integer) C4687b.m22444a().get(String.valueOf(b))).intValue());
        } else {
            c4688c.m22454e(99);
        }
        if (a3 > 200) {
            c4688c.m22454e(53);
        }
        C2538c.c("HWCloudUtils", new Object[]{"weatherInfo :" + c4688c.toString()});
        return c4688c;
    }

    private String m22458a(String str) {
        String str2 = "";
        try {
            String asString;
            C2538c.c("HWCloudUtils", new Object[]{"url = " + new URL(str)});
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) r0.openConnection();
            C4689d.m22460a(httpsURLConnection);
            httpsURLConnection.setHostnameVerifier(f17113b);
            httpsURLConnection.setRequestProperty("Charset", GameManager.DEFAULT_CHARSET);
            httpsURLConnection.setConnectTimeout(30000);
            httpsURLConnection.setReadTimeout(30000);
            httpsURLConnection.setRequestMethod(HttpGet.METHOD_NAME);
            httpsURLConnection.connect();
            RequestResult requestResult = new RequestResult(httpsURLConnection);
            C2538c.c("HWCloudUtils", new Object[]{"result.Code = " + requestResult.asString()});
            if (requestResult.getStatusCode() == 200) {
                C2538c.c("HWCloudUtils", new Object[]{"-----getWeatherInfo---- result"});
                asString = requestResult.asString();
            } else {
                asString = str2;
            }
            str2 = asString;
        } catch (MalformedURLException e) {
            C2538c.e("HWCloudUtils", new Object[]{"MalformedURLException = " + e.getMessage()});
        } catch (IOException e2) {
            C2538c.e("HWCloudUtils", new Object[]{"IOException = " + e2.getMessage()});
        } catch (Exception e3) {
            C2538c.e("HWCloudUtils", new Object[]{"Exception = " + e3.getMessage()});
        }
        C2538c.c("HWCloudUtils", new Object[]{"JSON weather is :" + str2});
        return str2;
    }

    public AddHealthStatRsp m22465a(AddHealthStatReq addHealthStatReq) {
        JsonSyntaxException e;
        C6133g e2;
        long currentTimeMillis = System.currentTimeMillis();
        C2538c.c("HWCloudUtils", new Object[]{"EnteraddHealthStatSync"});
        String b = m22462b(addHealthStatReq);
        HashMap a = m22484a((Object) addHealthStatReq);
        if (m22461a(b, a, "addHealthStatSync")) {
            AddHealthStatRsp addHealthStatRsp = new AddHealthStatRsp();
            AddHealthStatRsp addHealthStatRsp2;
            try {
                try {
                    addHealthStatRsp2 = (AddHealthStatRsp) new Gson().fromJson(new C4706s(this.f17116d).m22441a(b, a, 30, 30, 2), AddHealthStatRsp.class);
                    try {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        C2538c.c("HWCloudUtils", new Object[]{"addHealthStatSync totalTime: " + String.valueOf(currentTimeMillis2 - currentTimeMillis)});
                        return addHealthStatRsp2;
                    } catch (JsonSyntaxException e3) {
                        e = e3;
                        try {
                            C2538c.c("HWCloudUtils", new Object[]{"addHealthStatSync fromJson exception :" + e.getMessage()});
                            addHealthStatRsp2.setResultCode(1);
                            addHealthStatRsp2.setResultDesc(e.getMessage());
                            return addHealthStatRsp2;
                        } catch (C6133g e4) {
                            e2 = e4;
                            C2538c.c("HWCloudUtils", new Object[]{"addHealthStatSync nspClient exception :" + e2.getMessage()});
                            addHealthStatRsp2.setResultCode(1);
                            addHealthStatRsp2.setResultDesc(e2.getMessage());
                            return addHealthStatRsp2;
                        }
                    }
                } catch (JsonSyntaxException e5) {
                    e = e5;
                    addHealthStatRsp2 = addHealthStatRsp;
                    C2538c.c("HWCloudUtils", new Object[]{"addHealthStatSync fromJson exception :" + e.getMessage()});
                    addHealthStatRsp2.setResultCode(1);
                    addHealthStatRsp2.setResultDesc(e.getMessage());
                    return addHealthStatRsp2;
                }
            } catch (C6133g e6) {
                e2 = e6;
                addHealthStatRsp2 = addHealthStatRsp;
                C2538c.c("HWCloudUtils", new Object[]{"addHealthStatSync nspClient exception :" + e2.getMessage()});
                addHealthStatRsp2.setResultCode(1);
                addHealthStatRsp2.setResultDesc(e2.getMessage());
                return addHealthStatRsp2;
            }
        }
        C2538c.c("HWCloudUtils", new Object[]{"addHealthStatSync url or params invalidate"});
        return null;
    }

    public static void m22460a(HttpsURLConnection httpsURLConnection) {
        TrustManager[] trustManagerArr = new TrustManager[]{new C4698k()};
        try {
            SSLContext instance = SSLContext.getInstance("TLSv1.2");
            instance.init(null, trustManagerArr, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
        } catch (Exception e) {
            C2538c.e("HWCloudUtils", new Object[]{" trustAllHosts exception :" + e.getMessage()});
        }
    }

    private boolean m22461a(String str, HashMap<String, Object> hashMap, String str2) {
        if (str == null) {
            C2538c.c("HWCloudUtils", new Object[]{str2 + " unknown url"});
            return false;
        } else if (hashMap != null) {
            return true;
        } else {
            C2538c.c("HWCloudUtils", new Object[]{str2 + " invalidate param"});
            return false;
        }
    }

    private void m22459a(Object obj, HashMap<String, Object> hashMap) throws Exception {
        for (Field field : obj.getClass().getDeclaredFields()) {
            String name = field.getName();
            boolean isAccessible = field.isAccessible();
            if (!isAccessible) {
                field.setAccessible(true);
            }
            Object obj2 = field.get(obj);
            if (!isAccessible) {
                field.setAccessible(false);
            }
            if (obj2 != null) {
                hashMap.put(name, obj2);
            }
        }
    }
}
