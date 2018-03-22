package com.huawei.nfc.carrera.lifecycle.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;

public class NFCPushReceiver extends BroadcastReceiver {
    public static final String ACTION_RECEIVE_PUSH_MSG = "com.huawei.wallet.push.action.PUSH_MSG";
    public static final String ACTION_RECEIVE_PUSH_TOKEN = "com.huawei.wallet.push.action.PUSH_TOKEN";
    public static final String EXTRA_PUSH_MSG = "com.huawei.wallet.push.extra.PUSH_MSG";
    public static final String EXTRA_PUSH_TOKEN = "com.huawei.wallet.push.extra.PUSH_TOKEN";
    private static final String TAG = NFCPushReceiver.class.getSimpleName();

    public void onReceive(Context context, Intent intent) {
        String action;
        String str = null;
        if (intent != null) {
            action = intent.getAction();
        } else {
            action = null;
        }
        C2538c.m12677c(TAG, "== wallet push onReceive  action==" + action);
        if (intent == null || !(ACTION_RECEIVE_PUSH_TOKEN.equals(action) || ACTION_RECEIVE_PUSH_MSG.equals(action))) {
            C2538c.m12679d(TAG, "== wallet push onReceive  action is not valid");
        } else if (ACTION_RECEIVE_PUSH_TOKEN.equals(action)) {
            action = intent.getStringExtra(EXTRA_PUSH_TOKEN);
            if (StringUtil.isEmpty(action, true)) {
                C2538c.m12680e(TAG, "== wallet push recevier PushToken : token is Empty !");
                return;
            }
            C2538c.m12677c(TAG, "== wallet push receive pushtoken");
            NFCPushServiceManager.getInstance(context).receivePushToken(action);
        } else if (ACTION_RECEIVE_PUSH_MSG.equals(action)) {
            try {
                byte[] byteArrayExtra = intent.getByteArrayExtra(EXTRA_PUSH_MSG);
                if (byteArrayExtra != null) {
                    str = new String(byteArrayExtra, GameManager.DEFAULT_CHARSET);
                }
            } catch (UnsupportedEncodingException e) {
                C2538c.m12674b(TAG, "== wallet push onPushMsg, encoding exception.");
            }
            C2538c.m12677c(TAG, "== wallet push receive pushmsg, content: " + str, Boolean.valueOf(true));
            if (!StringUtil.isEmpty(str, true)) {
                NFCPushServiceManager.getInstance(context).receivePushMessage(str);
            }
        }
    }
}
