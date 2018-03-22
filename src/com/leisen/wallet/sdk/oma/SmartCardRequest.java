package com.leisen.wallet.sdk.oma;

import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.p190v.C2538c;

import java.io.IOException;

class SmartCardRequest implements Runnable {
    public static final int MAIN_CHANNEL = 0;
    private static final String TAG = "SmartCardRequest";
    private SmartCardCallback mCallback;
    private int mFlag = -1;
    private SmartCardBean mSmartCardBean;

    protected SmartCardRequest() {
    }

    public void setSmartCartBean(SmartCardBean smartCardBean) {
        this.mSmartCardBean = smartCardBean;
    }

    public void setSmartCardCallback(SmartCardCallback smartCardCallback) {
        this.mCallback = smartCardCallback;
    }

    public void setFlag(int i) {
        this.mFlag = i;
    }

    public void run() {
        String openCurrentAvailableChannel = openCurrentAvailableChannel(this.mSmartCardBean.getAid(), 0);
        C2538c.c(TAG, new Object[]{" run openResult : " + openCurrentAvailableChannel});
        if (openCurrentAvailableChannel != null && !"".equals(openCurrentAvailableChannel)) {
            try {
                executeApduCmd(openCurrentAvailableChannel);
            } catch (IOException e) {
                closeChannelAndSession();
                operFailure(this.mFlag, "execute apdu error：" + e.getMessage());
            }
        }
    }

    private void executeApduCmd(String str) throws IOException {
        String command = this.mSmartCardBean.getCommand();
        C2538c.c(TAG, new Object[]{" executeApduCmd channelTypeStr : " + str + "，command ：" + command});
        if (command == null || "".equals(command)) {
            operFailure(this.mFlag, "executeApduCmd param is null ");
            return;
        }
        PluginPayAdapter pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(BaseApplication.b()).getAdapter();
        if (pluginPayAdapter == null) {
            operFailure(this.mFlag, "executeApduCmd param is null ");
            return;
        }
        String sendApdu = pluginPayAdapter.sendApdu(str, command);
        C2538c.c(TAG, new Object[]{"执行APDU:" + command + "，返回的RAPDU为：" + sendApdu});
        operSuccess(this.mFlag, sendApdu);
    }

    private String openCurrentAvailableChannel(String str, int i) {
        C2538c.b(TAG, new Object[]{"openCurrentAvailableChannel aid : " + str + " , channelType : " + i});
        String str2 = "";
        PluginPayAdapter pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(BaseApplication.b()).getAdapter();
        if (pluginPayAdapter == null) {
            operFailure(this.mFlag, "openCurrentAvailableChannel param is null ");
            return str2;
        }
        String str3 = (String) pluginPayAdapter.openChannel(str, i).get(PluginPayAdapter.KEY_OPEN_CHANNEL_ID);
        C2538c.c(TAG, new Object[]{"打开通道channel ：" + str3});
        return str3;
    }

    public void closeChannelAndSession() {
        C2538c.c(TAG, new Object[]{"closeChannelAndSession"});
        PluginPayAdapter pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(BaseApplication.b()).getAdapter();
        if (pluginPayAdapter == null) {
            operFailure(this.mFlag, "closeChannelAndSession param is null ");
        } else {
            pluginPayAdapter.closeChannel();
        }
    }

    private void operSuccess(int i, String str) {
        if (this.mCallback != null) {
            this.mCallback.onOperSuccess(i, str);
        }
    }

    private void operFailure(int i, String str) {
        C2538c.e(TAG, new Object[]{" operFailure :" + str});
        if (this.mCallback != null) {
            this.mCallback.onOperFailure(i, new Error(str));
        }
    }
}
