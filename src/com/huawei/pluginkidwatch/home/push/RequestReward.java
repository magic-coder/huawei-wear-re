package com.huawei.pluginkidwatch.home.push;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.home.HomeActivity;
import com.huawei.pluginkidwatch.home.push.bean.KOnePushBeanBase;

public class RequestReward implements IPushProcess {
    private static final String TAG = "RewardReached";
    private Gson gson = new Gson();
    private Context mContext;
    private KOnePushBeanBase mPushBeanBase = new KOnePushBeanBase();

    public void processPushMsg(Context context, String str, boolean z) {
        C2538c.m12674b(TAG, "============Enter RewardReached");
        this.mContext = context;
        if (str == null || str.length() <= 0) {
            C2538c.m12674b("======strMsg is null======", new Object[0]);
            return;
        }
        try {
            this.mPushBeanBase = (KOnePushBeanBase) this.gson.fromJson(str, KOnePushBeanBase.class);
            String format = String.format(this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_feature_reward_request_reward), new Object[]{this.mPushBeanBase.name});
            if (!"".equals(this.mPushBeanBase.deviceCode) && this.mPushBeanBase.deviceCode.equals(C1462f.m6746j())) {
                C1495o.m6930a(this.mContext, HomeActivity.class, format, this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 10, new int[0]);
                try {
                    C1497q.m6943a(this.mContext, "notification_current_request_devicecode", this.mPushBeanBase.deviceCode);
                } catch (Exception e) {
                    C2538c.m12680e(TAG, "Exception e = " + e.getMessage());
                }
            } else if (C1492l.m6919c(this.mPushBeanBase.deviceCode)) {
                C1495o.m6930a(this.mContext, HomeActivity.class, format, this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 10, C1492l.m6920d(this.mPushBeanBase.deviceCode));
            } else {
                C2538c.m12674b("================ Receive wrong push", new Object[0]);
            }
        } catch (JsonSyntaxException e2) {
            C2538c.m12680e(TAG, "============解析申请奖励通知发生异常");
        }
    }
}
