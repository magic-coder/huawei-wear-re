package com.huawei.ui.homewear21.card.p176a;

import android.content.Context;
import android.os.Handler;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceCapability;
import com.huawei.p108n.C1204c;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import com.huawei.pluginmessagecenter.provider.data.MessageObject;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import com.huawei.ui.commonui.base.b;
import com.huawei.ui.device.p170a.C1990r;
import com.huawei.ui.main.stories.messagecenter.interactors.C2422e;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.lang.ref.WeakReference;

/* compiled from: NotificationCardInteractors */
public class C2254l {
    private static C2254l f8191a = null;
    private static WeakReference<b> f8192e = null;
    private Context f8193b;
    private C1971j f8194c;
    private Handler f8195d;
    private C1990r f8196f;
    private DeviceCapability f8197g;
    private C2243a f8198h;
    private boolean f8199i;
    private boolean f8200j;
    private MessageObserver f8201k;
    private Runnable f8202l;

    private C2254l() {
        this.f8194c = null;
        this.f8195d = null;
        this.f8197g = null;
        this.f8199i = false;
        this.f8200j = false;
        this.f8201k = new C2255m(this);
        this.f8202l = new C2258p(this);
        this.f8199i = false;
        this.f8200j = false;
        this.f8193b = BaseApplication.m2632b();
        this.f8194c = C1971j.m10236a(this.f8193b);
        this.f8196f = C1990r.m10400a(this.f8193b);
        this.f8197g = this.f8196f.m10411a();
        this.f8198h = C2243a.m11601a();
    }

    public static C2254l m11647a() {
        if (f8191a == null) {
            f8191a = new C2254l();
        }
        return f8191a;
    }

    public void m11654a(Handler handler) {
        this.f8195d = handler;
        if (this.f8194c != null && this.f8201k != null) {
            C2538c.m12677c("NotificationCardInteractors", "openMessageObserver registerMessageObserver");
            this.f8194c.m10245a(this.f8201k);
        }
    }

    public void m11657b() {
        if (this.f8194c != null && this.f8201k != null) {
            this.f8194c.m10251b(this.f8201k);
        }
    }

    private void m11651b(MessageObject messageObject) {
        new C2422e(this.f8193b, messageObject).m12173a();
    }

    public void m11655a(IBaseResponseCallback iBaseResponseCallback) {
        if (this.f8194c != null) {
            this.f8194c.m10242a(iBaseResponseCallback);
        }
    }

    public void m11658c() {
        if (this.f8194c != null) {
            this.f8194c.m10241a();
        }
    }

    public void m11659d() {
        if (this.f8199i || this.f8200j) {
            C2538c.m12677c("NotificationCardInteractors", "getFAQMessageProcess mGetFaqMessgeState is true return!!!");
            return;
        }
        this.f8199i = true;
        this.f8194c.m10256c(new C2257o(this));
    }

    public void m11656a(MessageObject messageObject) {
        if (messageObject == null || this.f8198h == null) {
            C2538c.m12677c("FAQ", "return MessageObject is null !!!");
            return;
        }
        C2538c.m12677c("FAQ", "Enter pushMessageToDevice !!!!! mDeviceStateInteractors.getCurrentDeviceType() = " + this.f8198h.m11615d());
        if (this.f8197g == null || !this.f8197g.isSupportMessageCenterPushDevice()) {
            C2538c.m12677c("FAQ", "return deviceCapability notSupport pushMessageToDevice !!!!! msgObj = " + messageObject.toString());
            if (this.f8198h.m11615d() != 10) {
                C2538c.m12677c("FAQ", "return deviceCapability notSupport pushMessageToDevice && not Leo!!!");
                return;
            }
        }
        C2538c.m12677c("FAQ", "pushMessageToDevice  MessageObject = " + messageObject.toString());
        if (!this.f8200j) {
            long expireTime = messageObject.getExpireTime() / 1000;
            String msgId = messageObject.getMsgId();
            C2538c.m12677c("FAQ", "pushMessageToDevice !!!!! exprTime = " + expireTime);
            C1204c a = C1204c.m5370a(BaseApplication.m2632b());
            if (a == null || 2 != this.f8198h.m11612b()) {
                this.f8200j = false;
                return;
            }
            this.f8200j = true;
            if (this.f8195d != null) {
                this.f8195d.removeCallbacks(this.f8202l);
                this.f8195d.postDelayed(this.f8202l, StatisticConfig.MIN_UPLOAD_INTERVAL);
            }
            a.m5429a(messageObject.getMsgId(), messageObject.getMsgType(), expireTime, 1, messageObject.getMsgTitle(), messageObject.getMsgContent(), null, new C2259q(this, msgId));
        }
    }
}
