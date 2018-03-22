package com.huawei.hwservicesmgr.remote;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.huawei.hwservicesmgr.remote.utils.RemoteUtils;
import com.huawei.p190v.C2538c;

import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class RemoteServiceMgr$MgrHandler extends Handler {
    WeakReference<RemoteServiceMgr> remoteServiceMgr;

    RemoteServiceMgr$MgrHandler(RemoteServiceMgr remoteServiceMgr) {
        this.remoteServiceMgr = new WeakReference(remoteServiceMgr);
    }

    public void handleMessage(Message message) {
        Exception e;
        super.handleMessage(message);
        if (((RemoteServiceMgr) this.remoteServiceMgr.get()) != null) {
            C2538c.c("RemoteServiceMgr", new Object[]{"handleMessage msg = " + message.what});
            switch (message.what) {
                case 1:
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("state", RemoteServiceMgr.DEVICE_DISCONNECTED);
                        if (RemoteServiceMgr.access$100() != null) {
                            RemoteServiceMgr.access$100().mo4455a(RemoteUtils.generateRetMap(jSONObject.toString(), "notificationStateConnectionStateChanged"));
                        }
                        C2538c.c("RemoteServiceMgr", new Object[]{"set isDisconnectedReported ======> true"});
                        RemoteServiceMgr.access$1102(true);
                        return;
                    } catch (JSONException e2) {
                        e = e2;
                        C2538c.e("RemoteServiceMgr", new Object[]{e.getMessage()});
                        return;
                    } catch (RemoteException e3) {
                        e = e3;
                        C2538c.e("RemoteServiceMgr", new Object[]{e.getMessage()});
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
