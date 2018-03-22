package com.huawei.ui.main.stories.account.interactor;

import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.RequestListener;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Sinaweibo */
class C2367r implements RequestListener {
    final /* synthetic */ C2364o f8554a;

    private C2367r(C2364o c2364o) {
        this.f8554a = c2364o;
    }

    public void onComplete(String str) {
        C2538c.m12674b(C2364o.f8545a, "onComplete() response=" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.isNull(HwAccountConstants.EXTRA_OPLOG_ERROR)) {
                    if ("true".equalsIgnoreCase(jSONObject.getString("result"))) {
                        this.f8554a.f8552h = null;
                        C2538c.m12677c(C2364o.f8545a, "WeiboRequestListener。onComplete()->logout success");
                        if (this.f8554a.f8547c != null) {
                            this.f8554a.f8547c.mo2653a(0, Boolean.valueOf(true));
                        }
                    }
                } else if (this.f8554a.f8547c != null) {
                    C2538c.m12677c(C2364o.f8545a, "WeiboRequestListener。onComplete()->logout failed");
                    this.f8554a.f8547c.mo2653a(1, Boolean.valueOf(false));
                }
            } catch (JSONException e) {
                C2538c.m12680e(C2364o.f8545a, "onComplete() Exception=" + e);
            }
        }
    }

    public void onWeiboException(WeiboException weiboException) {
        C2538c.m12680e(C2364o.f8545a, "onWeiboException()=" + weiboException);
    }
}
