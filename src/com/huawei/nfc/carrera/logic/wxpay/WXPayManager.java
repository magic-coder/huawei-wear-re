package com.huawei.nfc.carrera.logic.wxpay;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;
import com.huawei.wallet.logic.event.EventDispatchManager;
import com.huawei.wallet.logic.event.IEventListener;
import com.huawei.wallet.logic.event.IEventType;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public class WXPayManager implements IEventListener {
    public static final String EVENT_ID = ("WXPayManager_" + System.currentTimeMillis());
    private static final byte[] SYNC_LOCK = new byte[0];
    private static final String TAG = "WXPayManager";
    private static volatile WXPayManager instance;
    private boolean isRequest = false;
    private String mAppId;
    private WXPayCallback mCallback;

    private WXPayManager() {
        EventDispatchManager.m28051a().m28055a(EVENT_ID, (IEventListener) this);
    }

    public static WXPayManager getInstance() {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                if (instance == null) {
                    instance = new WXPayManager();
                }
            }
        }
        return instance;
    }

    public boolean pay(WXPayInfo wXPayInfo, WXPayCallback wXPayCallback) {
        if (wXPayInfo == null) {
            return false;
        }
        this.mAppId = wXPayInfo.getAppId();
        this.mCallback = wXPayCallback;
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(BaseApplication.b(), wXPayInfo.getAppId(), false);
        createWXAPI.registerApp(wXPayInfo.getAppId());
        BaseReq payReq = new PayReq();
        payReq.appId = wXPayInfo.getAppId();
        payReq.partnerId = wXPayInfo.getPartnerId();
        payReq.prepayId = wXPayInfo.getPrepayId();
        payReq.packageValue = wXPayInfo.getPackageValue();
        payReq.nonceStr = wXPayInfo.getNonceStr();
        payReq.timeStamp = wXPayInfo.getTimeStamp();
        payReq.sign = wXPayInfo.getSign();
        this.isRequest = true;
        boolean sendReq = createWXAPI.sendReq(payReq);
        C2538c.c(TAG, new Object[]{"wechat sendReq : " + sendReq + " request check : " + payReq.checkArgs()});
        return sendReq;
    }

    public void onEventCallBack(IEventType iEventType, Object obj) {
        C2538c.c(TAG, new Object[]{"onEventCallBack type " + iEventType});
        if (iEventType == IEventType.TYPE_WEIXIN_PAY_RESULT && obj != null && this.mCallback != null && (obj instanceof BaseResp)) {
            BaseResp baseResp = (BaseResp) obj;
            if (baseResp.errCode == 0) {
                this.mCallback.onWXPaySuccess();
            } else if (baseResp.errCode == -2) {
                this.mCallback.onWXPayCancel();
            } else {
                this.mCallback.onWXPayFail(baseResp.errCode);
            }
        }
    }

    public String getAppId() {
        return this.mAppId;
    }

    public boolean isRequest() {
        return this.isRequest;
    }

    public void setRequest(boolean z) {
        this.isRequest = z;
    }
}
