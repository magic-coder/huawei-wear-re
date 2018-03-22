package com.huawei.bone.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.nfc.carrera.logic.wxpay.WXPayManager;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.logic.event.EventDispatchManager;
import com.huawei.wallet.logic.event.IEventType;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    private IWXAPI f16132a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C2538c.c("WXPayEntryActivity", new Object[]{"onCreate onCreate()"});
        String appId = WXPayManager.getInstance().getAppId();
        if (TextUtils.isEmpty(appId)) {
            finish();
            return;
        }
        C2538c.c("WXPayEntryActivity", new Object[]{"WXPayEntryActivity onPayFinish, appId = " + appId});
        this.f16132a = WXAPIFactory.createWXAPI(this, appId);
        this.f16132a.handleIntent(getIntent(), this);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f16132a.handleIntent(intent, this);
    }

    public void onReq(BaseReq baseReq) {
    }

    public void onResp(BaseResp baseResp) {
        C2538c.c("WXPayEntryActivity", new Object[]{"WXPayEntryActivity onPayFinish, errCode = " + baseResp.errCode + " ; resp.errStr" + baseResp.errStr + " ; resp.checkArgs()" + baseResp.checkArgs() + " ; transaction " + baseResp.transaction + " ; openId :" + baseResp.openId});
        if (baseResp.getType() == 5) {
            if (WXPayManager.getInstance().isRequest()) {
                C2538c.c("WXPayEntryActivity", new Object[]{"WXPayEntryActivity onPayFinish, set isRequest false"});
                WXPayManager.getInstance().setRequest(false);
            }
            EventDispatchManager.m28051a().m28056a(WXPayManager.EVENT_ID, IEventType.TYPE_WEIXIN_PAY_RESULT, baseResp);
        }
        if (this.f16132a != null) {
            this.f16132a.unregisterApp();
        }
        finish();
    }
}
