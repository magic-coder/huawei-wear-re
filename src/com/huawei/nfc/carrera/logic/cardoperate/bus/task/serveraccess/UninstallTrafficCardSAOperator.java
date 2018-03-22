package com.huawei.nfc.carrera.logic.cardoperate.bus.task.serveraccess;

import android.content.Context;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.appletcardinfo.AppletInfoApiFactory;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.CardInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.UninstallTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.DeleteAppletRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.DeleteAppletResponse;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.Map;

public class UninstallTrafficCardSAOperator {
    private static final String TAG = "UninstallTrafficCardSAOperator";
    private Context mContext;
    private IssuerInfoItem mInfo;
    private UninstallTrafficCardResultHandler mResultHandler;

    public UninstallTrafficCardSAOperator(Context context, IssuerInfoItem issuerInfoItem, UninstallTrafficCardResultHandler uninstallTrafficCardResultHandler) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
        this.mResultHandler = uninstallTrafficCardResultHandler;
    }

    public boolean uninstall() {
        C2538c.c(TAG, new Object[]{" deleteApplet "});
        String aid = this.mInfo.getAid();
        if (StringUtil.isEmpty(aid, true)) {
            C2538c.c(TAG, new Object[]{"UninstallTrafficCardSAOperator uninstall failed. aid is illegal."});
            handleResult(10);
            return false;
        }
        ESEInfoManager instance = ESEInfoManager.getInstance(this.mContext);
        String queryCplc = instance.queryCplc();
        String deviceSN = instance.getDeviceSN();
        String busChipManu = instance.getBusChipManu();
        String deviceModel = instance.getDeviceModel();
        C2538c.c(TAG, new Object[]{" cplc : " + queryCplc + " ; imei : " + deviceSN + " ; chipManu : " + busChipManu + " ; model : " + deviceModel});
        DeleteAppletRequest deleteAppletRequest = new DeleteAppletRequest(this.mInfo.getIssuerId(), queryCplc, aid, deviceModel, busChipManu);
        String userID = ((PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter()).getUserID();
        C2538c.c(TAG, new Object[]{" userID : " + userID});
        deleteAppletRequest.setAccountUserId(userID);
        deleteAppletRequest.setImei(deviceSN);
        setRequestInfo(aid, deleteAppletRequest);
        C2538c.c(TAG, new Object[]{" deleteApplet setRequestInfo"});
        DeleteAppletResponse deleteApplet = SPIServiceFactory.createServerAccessService(this.mContext).deleteApplet(deleteAppletRequest);
        if (deleteApplet.getResultCode() == 0 || deleteApplet.getResultCode() == 5002) {
            C2538c.c(TAG, new Object[]{"UninstallTrafficCardSAOperator uninstall success!"});
            CardInfoManager.getInstance(this.mContext).refreshCardList();
            if (updateTaAndReport(aid)) {
                CardLostManager.getInstance(this.mContext).reportCardDeletedStatus(aid, null);
                handleResult(0);
                return true;
            }
        }
        handleErr(deleteApplet.getResultCode(), deleteApplet.getResultDesc());
        return false;
    }

    private void handleErr(int i, String str) {
        int i2;
        switch (i) {
            case 1:
                i2 = 10;
                break;
            case 2:
                i2 = 11;
                break;
            case 3:
                i2 = 25;
                break;
            default:
                i2 = 99;
                reportErr(i, str);
                break;
        }
        handleResult(i2);
    }

    private void setRequestInfo(String str, DeleteAppletRequest deleteAppletRequest) {
        AppletCardResult readTrafficCardInfo = AppletInfoApiFactory.createAppletCardInfoReader(this.mContext).readTrafficCardInfo(str, this.mInfo.getProductId(), 1);
        if (readTrafficCardInfo.getResultCode() == 0) {
            C2538c.c(TAG, new Object[]{"UninstallTrafficCardSAOperator, readTrafficCardInfo successs."});
            deleteAppletRequest.setTrafficCardId(((CardInfo) readTrafficCardInfo.getData()).getCardNum());
            return;
        }
        C2538c.c(TAG, new Object[]{"UninstallTrafficCardSAOperator, readTrafficCardInfo err. Code : " + readTrafficCardInfo.getResultCode()});
    }

    private void handleResult(int i) {
        if (this.mResultHandler != null) {
            this.mResultHandler.handleResult(i);
        }
    }

    private boolean updateTaAndReport(String str) {
        try {
            WalletTaManager.getInstance(this.mContext).removeCardByAid(str);
            return true;
        } catch (WalletTaCardNotExistException e) {
            C2538c.c(TAG, new Object[]{"UninstallTrafficCardTask updateTaAndReport WalletTaCardNotExistException, ta removeCard failed", e});
            return false;
        } catch (WalletTaSystemErrorException e2) {
            C2538c.c(TAG, new Object[]{"UninstallTrafficCardTask updateTaAndReport WalletTaSystemErrorException, ta removeCard failed", e2});
            return false;
        }
    }

    private void reportErr(int i, String str) {
        Map hashMap = new HashMap();
        hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, str);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(i));
        hashMap.put("issuerID", String.valueOf(this.mInfo.getIssuerId()));
        C2538c.e(TAG, new Object[]{Integer.valueOf(AutoReportErrorCode.ERROR_EVENT_ID_SA_UNINSTALL_FAILED), hashMap, "UninstallTrafficCardSAOperator err : " + str, Boolean.valueOf(false), Boolean.valueOf(false)});
    }
}
