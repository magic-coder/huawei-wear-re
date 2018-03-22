package com.huawei.nfc.carrera.logic.spi.tsm.laser;

import android.content.Context;
import com.huawei.nfc.carrera.logic.spi.tsm.LaserTSMService;
import com.huawei.nfc.carrera.logic.spi.tsm.request.CommandRequest;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.utils.PackageUtil;
import com.leisen.wallet.sdk.bean.CommonRequestParams;
import com.leisen.wallet.sdk.tsm.TSMOperator;

public final class LaserTSMServiceImpl implements LaserTSMService {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static LaserTSMServiceImpl instance;
    private final Context mContext;
    private final TSMOperator tsmOperator = TSMOperator.getInstance(this.mContext, getTsmRemoteUrl());

    private LaserTSMServiceImpl(Context context) {
        this.mContext = context;
    }

    private String getTsmRemoteUrl() {
        int b = PackageUtil.m28462b(this.mContext);
        LogX.i("====123========reportCardStatus ServiceConfig.HUAWEI_TSM_REMOTE_URL.https://tsm.hicloud.com:9001/TSMAPKP/HwTSMServer/applicationBusiness.action");
        return "https://tsm.hicloud.com:9001/TSMAPKP/HwTSMServer/applicationBusiness.action?version=" + b;
    }

    public static LaserTSMServiceImpl getInstance(Context context) {
        LaserTSMServiceImpl laserTSMServiceImpl;
        synchronized (SYNC_LOCK) {
            if (instance == null) {
                instance = new LaserTSMServiceImpl(context);
            }
            laserTSMServiceImpl = instance;
        }
        return laserTSMServiceImpl;
    }

    public int excuteTsmCommand(CommandRequest commandRequest) {
        LogX.i("tsm excuteTsmCommand now");
        if (commandRequest == null || StringUtil.isEmpty(commandRequest.serverID, true) || StringUtil.isEmpty(commandRequest.funcallID, true) || StringUtil.isEmpty(commandRequest.cplc, true)) {
            LogX.e("tsm excuteTsmCommand, params illegal.");
            return LaserTSMService.EXCUTE_OTA_RESULT_DEFAULT_ERROR;
        }
        LogX.d("tsm excuteTsmCommand, serviceId: " + commandRequest.serverID + ",functionId: " + commandRequest.funcallID);
        int commonExecute = this.tsmOperator.commonExecute(new CommonRequestParams(commandRequest.serverID, commandRequest.funcallID, commandRequest.cplc));
        LogX.i("tsm excuteTsmCommand, result: " + commonExecute);
        return commonExecute;
    }

    public int excuteTsmCommandByBasicChannel(CommandRequest commandRequest) {
        LogX.i("excuteTsmCommandByBasicChannel now");
        if (commandRequest == null || StringUtil.isEmpty(commandRequest.serverID, true) || StringUtil.isEmpty(commandRequest.funcallID, true) || StringUtil.isEmpty(commandRequest.cplc, true)) {
            LogX.e("excuteTsmCommandByBasicChannel, params illegal.");
            return LaserTSMService.EXCUTE_OTA_RESULT_DEFAULT_ERROR;
        }
        LogX.d("excuteTsmCommandByBasicChannel, serviceId: " + commandRequest.serverID + ",functionId: " + commandRequest.funcallID);
        int commonExecuteByBasicChannel = TSMOperatorByBasicChannel.getInstance(this.mContext, getTsmRemoteUrl()).commonExecuteByBasicChannel(new CommonRequestParams(commandRequest.serverID, commandRequest.funcallID, commandRequest.cplc));
        LogX.i("excuteTsmCommandByBasicChannel, result: " + commonExecuteByBasicChannel);
        return commonExecuteByBasicChannel;
    }
}
