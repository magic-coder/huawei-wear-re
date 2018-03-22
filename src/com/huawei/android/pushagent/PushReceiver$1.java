package com.huawei.android.pushagent;

import com.huawei.android.pushagent.PushReceiver.ReceiveType;

/* synthetic */ class PushReceiver$1 {
    static final /* synthetic */ int[] f15334a = new int[ReceiveType.values().length];

    static {
        try {
            f15334a[ReceiveType.ReceiveType_Token.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f15334a[ReceiveType.ReceiveType_Msg.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f15334a[ReceiveType.ReceiveType_PushState.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f15334a[ReceiveType.ReceiveType_NotifyClick.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f15334a[ReceiveType.ReceiveType_ClickBtn.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f15334a[ReceiveType.ReceiveType_PluginRsp.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
