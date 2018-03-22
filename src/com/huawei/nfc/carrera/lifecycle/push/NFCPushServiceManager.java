package com.huawei.nfc.carrera.lifecycle.push;

import android.app.Activity;
import android.content.Context;
import android.os.HandlerThread;
import com.huawei.android.pushagent.PushReceiver;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.lifecycle.cupoperate.CUPOperateServiceManager;
import com.huawei.nfc.carrera.lifecycle.lostservice.LostServiceManager;
import com.huawei.nfc.carrera.lifecycle.nullifyservice.NullifyServiceManager;
import com.huawei.nfc.carrera.lifecycle.push.data.PushCUPOperateMessage;
import com.huawei.nfc.carrera.lifecycle.push.data.PushCUPPersonalizedMessage;
import com.huawei.nfc.carrera.lifecycle.push.data.PushConsumeMessage;
import com.huawei.nfc.carrera.lifecycle.push.data.PushDevicesLostMessage;
import com.huawei.nfc.carrera.lifecycle.push.data.PushLostMessage;
import com.huawei.nfc.carrera.lifecycle.push.data.PushMessageParser;
import com.huawei.nfc.carrera.lifecycle.push.data.PushNullifyAccountMessage;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.PushInfoReportRequest;
import com.huawei.nfc.carrera.server.card.response.CardServerBaseResponse;
import com.huawei.nfc.carrera.util.LogX;

public class NFCPushServiceManager {
    private static final int RECEIVE_PUSH_MESSAGE = 2;
    private static final int RECEIVE_PUSH_TOKEN_INFO = 1;
    private static final byte[] SYNC_LOCK = new byte[0];
    private static volatile NFCPushServiceManager instance;
    private static final Object listenerLock = new Object();
    private Context mContext;
    private PushTransactionInfoListener mPushTransactionInfoListener;
    private final PushServiceHandler pushServiceHandler;

    public static NFCPushServiceManager getInstance(Context context) {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                if (instance == null) {
                    instance = new NFCPushServiceManager(context);
                }
            }
        }
        return instance;
    }

    private NFCPushServiceManager(Context context) {
        if (context instanceof Activity) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        HandlerThread handlerThread = new HandlerThread("pushServiceHandlerThread");
        handlerThread.start();
        this.pushServiceHandler = new PushServiceHandler(this, handlerThread.getLooper());
    }

    public void getPushToken() {
        LogX.m5475i("getPushToken");
        PushReceiver.getToken(this.mContext);
    }

    public void setPushTransactionMsgListener(PushTransactionInfoListener pushTransactionInfoListener) {
        synchronized (listenerLock) {
            this.mPushTransactionInfoListener = pushTransactionInfoListener;
        }
    }

    void receivePushToken(String str) {
        this.pushServiceHandler.sendMessage(this.pushServiceHandler.obtainMessage(1, str));
    }

    void receivePushMessage(String str) {
        this.pushServiceHandler.sendMessage(this.pushServiceHandler.obtainMessage(2, str));
    }

    private void checkAndUploadPushToken(String str) {
        uploadNewPushToken(str);
    }

    private boolean uploadNewPushToken(String str) {
        LogX.m5475i("enter uploadNewPushToken ");
        PushInfoReportRequest pushInfoReportRequest = new PushInfoReportRequest();
        pushInfoReportRequest.setCplc(ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc());
        pushInfoReportRequest.setReportType(PushInfoReportRequest.REPORT_TYPE_PUSH_TOKEN);
        pushInfoReportRequest.setDeviceInfo(str);
        pushInfoReportRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        pushInfoReportRequest.setRsaKeyIndex(-1);
        pushInfoReportRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        CardServerBaseResponse reportPushInfo = ServerServiceFactory.createCardServerApi(this.mContext).reportPushInfo(pushInfoReportRequest);
        if (reportPushInfo == null || reportPushInfo.returnCode != 0) {
            LogX.m5478w("uploadNewPushToken failed");
            return false;
        }
        LogX.m5475i("uploadNewPushToken success");
        return true;
    }

    private void handlePushMessage(String str) {
        Object parsePushMessage = new PushMessageParser().parsePushMessage(str);
        if (parsePushMessage == null) {
            LogX.m5465d("handlePushMessage, push msg is null.");
        } else if (parsePushMessage instanceof PushLostMessage) {
            PushLostMessage pushLostMessage = (PushLostMessage) parsePushMessage;
            LostServiceManager.startCardLostManageService(this.mContext, pushLostMessage.getAid(), pushLostMessage.getStatus(), pushLostMessage.getCplc(), pushLostMessage.getDpanid());
        } else if (parsePushMessage instanceof PushConsumeMessage) {
            handleConsumeMessage((PushConsumeMessage) parsePushMessage);
        } else if (parsePushMessage instanceof PushCUPOperateMessage) {
            handleCUPTsmlibPushMessage((PushCUPOperateMessage) parsePushMessage);
        } else if (parsePushMessage instanceof PushCUPPersonalizedMessage) {
            handelCUPPersonalizedMessage((PushCUPPersonalizedMessage) parsePushMessage);
        } else if (parsePushMessage instanceof PushNullifyAccountMessage) {
            handelNullifyAccountMessage((PushNullifyAccountMessage) parsePushMessage);
        } else if (parsePushMessage instanceof PushDevicesLostMessage) {
            PushDevicesLostMessage pushDevicesLostMessage = (PushDevicesLostMessage) parsePushMessage;
            LostServiceManager.startDevicesLostManageService(this.mContext, pushDevicesLostMessage.cplc, pushDevicesLostMessage.sign);
        } else {
            LogX.m5469e("handlePushMessage, unknown msg");
        }
    }

    private void handleConsumeMessage(PushConsumeMessage pushConsumeMessage) {
        LogX.m5467d("cosume msg cplc: " + pushConsumeMessage.getCplc(), true);
        LogX.m5465d("push msg currency: " + pushConsumeMessage.getCurrency() + " ,merchantName: " + pushConsumeMessage.getMerchantName() + " ,productName: " + pushConsumeMessage.getProductName());
        synchronized (listenerLock) {
            if (this.mPushTransactionInfoListener != null) {
                this.mPushTransactionInfoListener.transactionResult(pushConsumeMessage);
            }
        }
    }

    private void handelCUPPersonalizedMessage(PushCUPPersonalizedMessage pushCUPPersonalizedMessage) {
        CUPOperateServiceManager.startCUPPersonalService(this.mContext, pushCUPPersonalizedMessage.getCplc(), pushCUPPersonalizedMessage.getVirtualCardRefID(), pushCUPPersonalizedMessage.getAid());
    }

    private void handleCUPTsmlibPushMessage(PushCUPOperateMessage pushCUPOperateMessage) {
        LogX.m5467d("handleCUPTsmlibPushMessage,cup operate cplc: " + pushCUPOperateMessage.getCplc(), true);
        CUPOperateServiceManager.startCUPOperateService(this.mContext, pushCUPOperateMessage.getEvent(), pushCUPOperateMessage.getSsid(), pushCUPOperateMessage.getSign(), pushCUPOperateMessage.getVirtualCards());
    }

    private void handelNullifyAccountMessage(PushNullifyAccountMessage pushNullifyAccountMessage) {
        LogX.m5465d("handelNullifyAccountMessage");
        NullifyServiceManager.startNullifyAccountManageService(this.mContext, pushNullifyAccountMessage.getUser(), pushNullifyAccountMessage.getCplc(), pushNullifyAccountMessage.getSign());
    }
}
