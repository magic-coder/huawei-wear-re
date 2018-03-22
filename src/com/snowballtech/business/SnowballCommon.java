package com.snowballtech.business;

import android.content.Context;
import com.snowballtech.business.config.ParseConfig;
import com.snowballtech.business.constant.RequestKey;
import com.snowballtech.business.user.task.IWalletServiceTask;
import com.snowballtech.business.user.task.WTaskAppletManage;
import com.snowballtech.business.user.task.WTaskCardDelete;
import com.snowballtech.business.user.task.WTaskCardTopup;
import com.snowballtech.business.user.task.WTaskIssueCard;
import com.snowballtech.business.user.task.WTaskPostService;
import com.snowballtech.business.user.task.WTaskSetDevice;
import com.snowballtech.business.user.task.WTaskSwitchLog;

public class SnowballCommon {
    private Context context;
    IBusinessProcess iBusinessProcess = new BusinessProcess();

    public String switchLog(String str) {
        return this.iBusinessProcess.process(new WTaskSwitchLog(), getContext(), null, str);
    }

    public String appletManage(String str) {
        return this.iBusinessProcess.processSynchronized(new WTaskAppletManage(), getContext(), null, str);
    }

    public String cardTopup(String str) {
        return this.iBusinessProcess.processSynchronized(new WTaskCardTopup(), getContext(), null, str);
    }

    @Deprecated
    public String issueCard(String str) {
        return this.iBusinessProcess.processSynchronized(new WTaskIssueCard(), getContext(), null, str);
    }

    public String cardDelete(String str) {
        return this.iBusinessProcess.processSynchronized(new WTaskCardDelete(), getContext(), null, str);
    }

    public String getVersion() {
        return "{\"result_code\":\"0\",\"result_msg\":\"" + ParseConfig.getInstance().fetchConfig(ParseConfig.CFG_SDK_VERSION_CODE) + "\"}";
    }

    public String setDevice(String str) {
        return this.iBusinessProcess.process(new WTaskSetDevice(), getContext(), null, str);
    }

    public String service(String str, String str2) {
        IWalletServiceTask iWalletServiceTask;
        if (RequestKey.TASKMAP.containsKey(str)) {
            try {
                iWalletServiceTask = (IWalletServiceTask) SnowballCommon.class.getClassLoader().loadClass((String) RequestKey.TASKMAP.get(str)).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                iWalletServiceTask = null;
            }
            return this.iBusinessProcess.processSynchronized(iWalletServiceTask, getContext(), str, str2);
        } else if (!RequestKey.NONSYNCTASKMAP.containsKey(str)) {
            return this.iBusinessProcess.process(new WTaskPostService(), getContext(), str, str2);
        } else {
            try {
                iWalletServiceTask = (IWalletServiceTask) SnowballCommon.class.getClassLoader().loadClass((String) RequestKey.NONSYNCTASKMAP.get(str)).newInstance();
            } catch (Exception e2) {
                e2.printStackTrace();
                iWalletServiceTask = null;
            }
            return this.iBusinessProcess.process(iWalletServiceTask, getContext(), str, str2);
        }
    }

    public IBusinessProcess getiBusinessProcess() {
        return this.iBusinessProcess;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return this.context;
    }
}
