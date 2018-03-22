package com.huawei.pluginkidwatch.home.push;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.google.gson.Gson;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1680l;
import com.huawei.pluginkidwatch.common.entity.C1462f;
import com.huawei.pluginkidwatch.common.lib.utils.C1492l;
import com.huawei.pluginkidwatch.common.lib.utils.C1495o;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;
import com.huawei.pluginkidwatch.common.p138a.C1392h;
import com.huawei.pluginkidwatch.common.p138a.C1404t;
import com.huawei.pluginkidwatch.home.HomeActivity;
import com.huawei.pluginkidwatch.home.push.bean.RewardReachedBean;
import com.huawei.pluginkidwatch.plugin.setting.activity.RewardActivity;

public class RewardReached implements IPushProcess {
    private static final String TAG = "RewardReached";
    private Gson gson = new Gson();
    private Context mContext;
    private RewardReachedBean mRewardReachedBean = new RewardReachedBean();

    public void processPushMsg(Context context, String str, boolean z) {
        C2538c.m12674b(TAG, "============Enter RewardReached");
        this.mContext = context;
        if (str == null || str.length() <= 0) {
            C2538c.m12674b(TAG, "======strMsg is null======");
            return;
        }
        this.mRewardReachedBean = (RewardReachedBean) this.gson.fromJson(str, RewardReachedBean.class);
        saveToDB(this.mRewardReachedBean, z);
    }

    private void saveToDB(RewardReachedBean rewardReachedBean, boolean z) {
        C2538c.m12674b(TAG, "============Enter saveToDB");
        if (rewardReachedBean == null) {
            C2538c.m12680e(TAG, "============bean is null");
            return;
        }
        C2538c.m12674b(TAG, "============bean:", rewardReachedBean.toString());
        String str = "";
        str = rewardReachedBean.data.rewardInfo;
        C1404t c1404t = new C1404t();
        c1404t.m6409c(rewardReachedBean.data.count);
        c1404t.m6405a(rewardReachedBean.deviceCode);
        c1404t.m6411d(rewardReachedBean.name);
        c1404t.m6415f(rewardReachedBean.time);
        c1404t.m6407b(str);
        String format = String.format(this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_push_notification_reward_goal_reached), new Object[]{rewardReachedBean.name, rewardReachedBean.data.count});
        C1497q.m6943a(this.mContext, "notification_reward_total", rewardReachedBean.data.count);
        C1497q.m6943a(this.mContext, "notification_reward_hope", str);
        C1497q.m6943a(this.mContext, "notification_reward_devicecode", rewardReachedBean.deviceCode);
        C2538c.m12674b(TAG, "============bean.data.rewardInfo:", str);
        C2538c.m12674b(TAG, "============bean bean.data.count:", rewardReachedBean.data.count);
        C1392h.m6284a(this.mContext, c1404t);
        Intent intent = new Intent();
        intent.setAction("com.huawei.pluginkidwatch.feature.reward.reached.goal");
        C2538c.m12674b(TAG, "============bean.deviceCode:", rewardReachedBean.deviceCode);
        C2538c.m12674b(TAG, "============KWCache.getDeviceCode():", C1462f.m6746j());
        if (z) {
            if (rewardReachedBean.deviceCode.equals(C1462f.m6746j())) {
                C2538c.m12674b(TAG, "============和当前devicecode相同");
                C1495o.m6930a(this.mContext, RewardActivity.class, format, this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 8, new int[0]);
            } else if (C1492l.m6919c(rewardReachedBean.deviceCode)) {
                C2538c.m12674b(TAG, "============和当前devicecode不相同，进home");
                C1495o.m6930a(this.mContext, HomeActivity.class, format, this.mContext.getResources().getString(C1680l.IDS_plugin_kidwatch_common_title), format, 8, C1492l.m6920d(rewardReachedBean.deviceCode));
            } else {
                C2538c.m12674b(TAG, "================ Receive wrong push");
            }
        }
        LocalBroadcastManager.getInstance(this.mContext).sendBroadcast(intent);
    }
}
