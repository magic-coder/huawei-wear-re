package com.huawei.nfc.carrera.logic.cardoperate.citic.install;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.lifecycle.push.NFCPushServiceManager;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.model.OpenCardInfo;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.citic.request.ApplyCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.PersonalizedRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ApplyCardResponse;
import com.huawei.nfc.carrera.logic.spi.citic.response.PersonalizedResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.logic.util.VerifyTokenUtil;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.CardServerBaseRequest;
import com.huawei.nfc.carrera.server.card.response.SignDataResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.wallet.utils.SHA_256;
import java.util.HashMap;
import java.util.Map;

public abstract class InstallCardBaseTask implements InstallPrepareTaskListener, Runnable {
    private static final int PREPARE_TASK_STATUS_EXECUTING = 3;
    private static final int PREPARE_TASK_STATUS_FINISHED = 4;
    private static final int PREPARE_TASK_STATUS_NOT_START = 1;
    private static final int PREPARE_TASK_STATUS_QUEUING = 2;
    private static final byte[] SYNC_LOCK = new byte[0];
    private String curTaskAid;
    private OpenCardInfo curTaskInputInfo;
    private final String mCardNum;
    private final Context mContext;
    private HandleInstallCardResultTask mResultTask;
    protected InstallCardPrepareBaseTask prepareTask;
    private int prepareTaskResult = -99;
    private int prepareTaskStatus = 1;

    protected abstract ApplyCardResponse applyCard(ApplyCardRequest applyCardRequest);

    protected abstract boolean checkInputInfoValid(OpenCardInfo openCardInfo);

    protected abstract void fillInApplyCardInfo(ApplyCardRequest applyCardRequest, OpenCardInfo openCardInfo);

    protected abstract String getBankVerifyTokenKey();

    protected abstract String getCardDpan(Context context, String str);

    protected abstract String getDpanid(String str);

    protected abstract String getProductId();

    protected abstract boolean isNeedGetVerifySign();

    protected abstract PersonalizedResponse personalize(PersonalizedRequest personalizedRequest);

    protected InstallCardBaseTask(Context context, String str, InstallCardPrepareBaseTask installCardPrepareBaseTask) {
        this.mContext = context;
        this.mCardNum = str;
        this.prepareTask = installCardPrepareBaseTask;
    }

    public void doPrepareTask(Handler handler) {
        synchronized (SYNC_LOCK) {
            this.prepareTask.doPrepareTask(handler, this);
        }
    }

    public boolean doInstallTask(Handler handler, OpenCardInfo openCardInfo, HandleInstallCardResultTask handleInstallCardResultTask) {
        if (this.curTaskInputInfo != null) {
            LogX.e("The task is invalid.");
            return false;
        } else if (!checkInputInfoValid(openCardInfo)) {
            LogX.e("intput info is invalid.");
            return false;
        } else if (this.mCardNum.equals(openCardInfo.getCardNum())) {
            this.curTaskInputInfo = openCardInfo;
            this.mResultTask = handleInstallCardResultTask;
            handler.post(this);
            return true;
        } else {
            LogX.e("doInstallTask, card num not fits the task.");
            return false;
        }
    }

    public void run() {
        if (this.curTaskInputInfo == null) {
            doResult(-99, null, null);
            return;
        }
        String aid = getAid();
        if (aid == null) {
            LogX.d("install card task, getAid failed.");
        } else if (!processApplyCard(aid)) {
            LogX.d("install card task, processApplyCard failed.");
        } else if (!waitPrepareTask()) {
            LogX.d("install card task, prepareTask failed.");
        } else if (personalizeCard(getCardDpan(this.mContext, aid), aid)) {
            LogX.i("install task, personalize success.");
            String cardDpan = getCardDpan(this.mContext, aid);
            if (StringUtil.isEmpty(cardDpan, true)) {
                LogX.d("personalizeResponse success, but dpan is illegal.");
                doResult(-99, null, null);
                return;
            }
            String dpanid = getDpanid(cardDpan);
            TACardInfo tACardInfo = new TACardInfo();
            tACardInfo.aid = aid;
            tACardInfo.cardGroupType = 1;
            tACardInfo.cardStatus = 1;
            tACardInfo.fpanDigest = SHA_256.m28475a(this.mCardNum, null);
            tACardInfo.fpanFour = getCardNumEndFour(this.mCardNum);
            tACardInfo.dpanDigest = dpanid;
            tACardInfo.dpanFour = getCardNumEndFour(cardDpan);
            tACardInfo.cardType = this.curTaskInputInfo.getCardType();
            tACardInfo.issuerId = this.curTaskInputInfo.getIssuerId();
            tACardInfo.productId = getProductId();
            LogX.d("===123===InstallCardBaseTask  ");
            int addCardInfoToTA = addCardInfoToTA(tACardInfo);
            if (addCardInfoToTA == 0) {
                CardInfoManager.getInstance(this.mContext).refreshCardList();
                CardLostManager.getInstance(this.mContext).reportCardOpenedNotActiveStatus(aid, dpanid, getCurCardName(this.curTaskInputInfo.getIssuerId()), getCardNumEndFour(this.mCardNum));
                NFCPushServiceManager.getInstance(this.mContext).getPushToken();
            }
            doResult(addCardInfoToTA, getProductId(), dpanid);
        } else {
            LogX.d("install card task, personalizeCard failed.");
        }
    }

    private String getCurCardName(String str) {
        IssuerInfoItem queryIssuerInfoById = new CardInfoDBManager(this.mContext).queryIssuerInfoById(str);
        if (queryIssuerInfoById != null) {
            return queryIssuerInfoById.getName();
        }
        return null;
    }

    private String getAid() {
        String str = null;
        LogX.i("install card task, wait and get aid.");
        synchronized (SYNC_LOCK) {
            if (this.curTaskAid == null) {
                if (1 == this.prepareTaskStatus || (4 == this.prepareTaskStatus && this.prepareTaskResult != 0)) {
                    LogX.d("aid is empty, but the prepare task is not running.");
                    HandlerThread handlerThread = new HandlerThread("card_redo_prepare_thread");
                    handlerThread.start();
                    this.prepareTask.doPrepareTask(new Handler(handlerThread.getLooper()), this);
                }
                while (this.curTaskAid == null && (2 == this.prepareTaskStatus || 3 == this.prepareTaskStatus)) {
                    try {
                        LogX.d("wait aid to finish the install task.");
                        wait();
                    } catch (InterruptedException e) {
                        LogX.e("wait aid, but interrupted.");
                    }
                }
                if (this.curTaskAid == null) {
                    LogX.d("wait the aid, but failed.");
                    doResult(this.prepareTaskResult, null, null);
                } else {
                    LogX.d("wait the aid, and got it.");
                    str = this.curTaskAid;
                }
            } else {
                str = this.curTaskAid;
            }
        }
        return str;
    }

    private boolean waitPrepareTask() {
        LogX.i("install card task, wait install prepare task.");
        synchronized (SYNC_LOCK) {
            if (1 == this.prepareTaskStatus || (4 == this.prepareTaskStatus && this.prepareTaskResult != 0)) {
                LogX.d("prepare task is not started or failed.");
                this.prepareTask.run();
            }
            while (4 != this.prepareTaskStatus) {
                try {
                    LogX.i("wait prepare task, before personalized.");
                    wait();
                } catch (InterruptedException e) {
                    LogX.e("wait prepare task before personal, but interrupted.");
                    return false;
                }
            }
            if (this.prepareTaskResult != 0) {
                LogX.d("wait the aid, but failed.");
                int i = -99;
                if (-3 == this.prepareTaskResult) {
                    i = -3;
                } else if (-4 == this.prepareTaskResult) {
                    i = -4;
                }
                doResult(i, null, null);
                return false;
            }
            return true;
        }
    }

    private boolean processApplyCard(String str) {
        int i = -99;
        LogX.i("install card task, process apply card.");
        ApplyCardRequest applyCardRequest = new ApplyCardRequest();
        applyCardRequest.setAid(str);
        if (isNeedGetVerifySign()) {
            SignDataResponse applyCardVerifySign = getApplyCardVerifySign();
            Map hashMap;
            String str2;
            if (applyCardVerifySign == null) {
                hashMap = new HashMap();
                str2 = "processApplyCard response is null";
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_APPLY_CARD_ERR, hashMap, str2, false, false);
                doResult(-99, null, null);
                return false;
            } else if (applyCardVerifySign.returnCode != 0) {
                if (-1 == applyCardVerifySign.returnCode) {
                    i = -3;
                } else if (-2 == applyCardVerifySign.returnCode) {
                    i = -4;
                } else {
                    hashMap = new HashMap();
                    str2 = "processApplyCard response error : " + applyCardVerifySign.returnCode;
                    hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
                    LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_APPLY_CARD_ERR, hashMap, str2, false, false);
                }
                doResult(i, null, null);
                return false;
            } else if (StringUtil.isEmpty(applyCardVerifySign.sign, true) || StringUtil.isEmpty(applyCardVerifySign.time, true)) {
                hashMap = new HashMap();
                str2 = "processApplyCard response success, but params invalid";
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str2);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_APPLY_CARD_ERR, hashMap, str2, false, false);
                doResult(-99, null, null);
                return false;
            } else {
                applyCardRequest.setWalletSignature(applyCardVerifySign.sign);
                applyCardRequest.setTimeStamp(applyCardVerifySign.time);
            }
        }
        applyCardRequest.setVerifyToken(getVerifyToken());
        if (this.curTaskInputInfo == null) {
            doResult(-99, null, null);
            return false;
        }
        applyCardRequest.setCardNum(this.curTaskInputInfo.getCardNum());
        applyCardRequest.setCplc(ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc());
        fillInApplyCardInfo(applyCardRequest, this.curTaskInputInfo);
        ApplyCardResponse applyCard = applyCard(applyCardRequest);
        if (applyCard == null) {
            doResult(-99, null, null);
            return false;
        } else if (applyCard.getResultCode() != 0) {
            handleApplyCardErrorCode(applyCard.getResultCode());
            return false;
        } else {
            if (!StringUtil.isEmpty(applyCard.getToken(), true)) {
                setVerifyToken(applyCard.getToken());
            }
            return true;
        }
    }

    private void handleApplyCardErrorCode(int i) {
        int i2 = -3;
        LogX.i("===123===handleApplyCardErrorCode resultCode = " + i);
        switch (i) {
            case -20:
                i2 = -18;
                break;
            case -19:
                i2 = -17;
                break;
            case -18:
                i2 = -15;
                break;
            case -17:
                i2 = -13;
                break;
            case -16:
                i2 = -16;
                break;
            case -15:
                i2 = -11;
                break;
            case -14:
                i2 = -10;
                break;
            case -13:
                i2 = -9;
                break;
            case -12:
                i2 = -8;
                break;
            case -11:
                i2 = -7;
                break;
            case -8:
                i2 = -14;
                break;
            case -5:
            case -4:
                break;
            default:
                i2 = -99;
                break;
        }
        doResult(i2, null, null);
    }

    private boolean personalizeCard(String str, String str2) {
        int i = -4;
        LogX.i("install card task, personalize card.");
        PersonalizedRequest personalizedRequest = new PersonalizedRequest();
        if (isNeedGetVerifySign()) {
            SignDataResponse personalVerifySign = getPersonalVerifySign();
            if (personalVerifySign == null) {
                doResult(-99, null, null);
                return false;
            }
            LogX.d("getPersonalVerifySign, response code: " + personalVerifySign.returnCode);
            if (personalVerifySign.returnCode != 0) {
                Map hashMap = new HashMap();
                String str3 = "get personal sign fail, error code : " + personalVerifySign.returnCode;
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str3);
                hashMap.put(CloudEyeLogger.FAIL_CODE, "" + personalVerifySign.returnCode);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_GET_SIGN_ERR, hashMap, str3, false, false);
                if (-1 == personalVerifySign.returnCode) {
                    i = -3;
                } else if (-2 != personalVerifySign.returnCode) {
                    i = -99;
                }
                doResult(i, null, null);
                return false;
            } else if (StringUtil.isEmpty(personalVerifySign.sign, true) || StringUtil.isEmpty(personalVerifySign.time, true)) {
                Map hashMap2 = new HashMap();
                String str4 = "getPersonalVerifySign return ok, but sign and time are illegal.";
                hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str4);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_GET_SIGN_ERR, hashMap2, str4, false, false);
                doResult(-99, null, null);
                return false;
            } else {
                personalizedRequest.setWalletSignature(personalVerifySign.sign);
                personalizedRequest.setTimeStamp(personalVerifySign.time);
            }
        }
        personalizedRequest.setdPan(str);
        personalizedRequest.setAid(str2);
        personalizedRequest.setVerifyToken(getVerifyToken());
        personalizedRequest.setCplc(ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc());
        PersonalizedResponse personalize = personalize(personalizedRequest);
        if (personalize == null) {
            LogX.e("personalize response is not illegal.");
            doResult(-99, null, null);
            return false;
        } else if (personalize.getResultCode() == 0) {
            return true;
        } else {
            LogX.e("personalize failed");
            if (-5 == personalize.getResultCode()) {
                i = -3;
            } else if (-4 != personalize.getResultCode()) {
                if (-8 == personalize.getResultCode()) {
                    i = -14;
                } else {
                    i = -99;
                }
            }
            doResult(i, null, null);
            return false;
        }
    }

    protected String getVerifyToken() {
        return VerifyTokenUtil.getVerifyTokenString(this.mContext, getBankVerifyTokenKey());
    }

    private SignDataResponse getApplyCardVerifySign() {
        CardServerBaseRequest cardServerBaseRequest = new CardServerBaseRequest();
        cardServerBaseRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        cardServerBaseRequest.setRsaKeyIndex(-1);
        cardServerBaseRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        return ServerServiceFactory.createCardServerApi(this.mContext).querySignDataForApplyCard(cardServerBaseRequest);
    }

    private SignDataResponse getPersonalVerifySign() {
        CardServerBaseRequest cardServerBaseRequest = new CardServerBaseRequest();
        cardServerBaseRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        cardServerBaseRequest.setRsaKeyIndex(-1);
        cardServerBaseRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        return ServerServiceFactory.createCardServerApi(this.mContext).querySignDataForPersonal(cardServerBaseRequest);
    }

    private void doResult(int i, String str, String str2) {
        if (this.mResultTask != null) {
            this.mResultTask.notifyInstallResult(i, str, str2);
        }
    }

    private void setVerifyToken(String str) {
        VerifyTokenUtil.putVerifyTokenString(str, this.mContext, getBankVerifyTokenKey());
    }

    private String getCardNumEndFour(String str) {
        return str.substring(str.length() - 4);
    }

    private int addCardInfoToTA(TACardInfo tACardInfo) {
        try {
            WalletTaManager.getInstance(this.mContext).addCard(tACardInfo);
        } catch (Throwable e) {
            LogX.e("add card info to ta, WalletTaCardAlreadyExistException: " + Log.getStackTraceString(e));
            if (WalletTaManager.getInstance(this.mContext).getCard(tACardInfo.dpanDigest) == null) {
                return -99;
            }
            LogX.d("card existed in ta, clear and add again now.");
            try {
                WalletTaManager.getInstance(this.mContext).removeCard(tACardInfo.dpanDigest);
                WalletTaManager.getInstance(this.mContext).addCard(tACardInfo);
            } catch (Throwable e2) {
                LogX.e("add card to ta again, exception: " + Log.getStackTraceString(e2));
                return -99;
            }
        } catch (Throwable e3) {
            LogX.e("add card info to ta, WalletTaCardNumReachMaxException: " + Log.getStackTraceString(e3));
            return -6;
        } catch (Throwable e22) {
            LogX.e("add card info to ta, WalletTaBadParammeterException: " + Log.getStackTraceString(e22));
            return -99;
        } catch (Throwable e222) {
            LogX.e("add card info to ta, WalletTaSystemErrorException: " + Log.getStackTraceString(e222));
            return -99;
        }
        return 0;
    }

    public void prepareTaskQueqing() {
        synchronized (SYNC_LOCK) {
            this.prepareTaskStatus = 2;
        }
    }

    public void prepareTaskStart() {
        synchronized (SYNC_LOCK) {
            this.prepareTaskStatus = 3;
        }
    }

    public void prepareAidApplied(String str) {
        synchronized (SYNC_LOCK) {
            if (str != null) {
                this.curTaskAid = str;
                notifyAll();
            }
        }
    }

    public void prepareFaskFinished(int i) {
        synchronized (SYNC_LOCK) {
            this.prepareTaskResult = i;
            this.prepareTaskStatus = 4;
            notifyAll();
        }
    }
}
