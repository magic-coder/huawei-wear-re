package com.huawei.nfc.carrera.logic.cardoperate.bus.task.serveraccess;

import android.content.Context;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.CreateSSDTsmOperator;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.serveraccess.request.DownloadAndInstallAppletRequest;
import com.huawei.nfc.carrera.logic.spi.serveraccess.response.DownloadAndInstallAppletResponse;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.Map;

public class InitDmsdAndDownloadAppletOperator {
    private static final String TAG = "InitDmsdAndDownloadAppletOperator";
    private String mAid;
    private Context mContext;
    private String mIssuerID;

    public InitDmsdAndDownloadAppletOperator(Context context, String str, String str2, boolean z) {
        this.mAid = str;
        this.mContext = context;
        this.mIssuerID = str2;
    }

    public int excute() {
        CreateSSDTsmOperator createSSDTsmOperator = new CreateSSDTsmOperator(this.mContext, this.mAid, this.mIssuerID);
        C2538c.b(TAG, new Object[]{" CardEvent CREATESSD bus cardEvent START_LOCK"});
        WalletTaManager.getInstance(this.mContext).lockCardEvent(this.mAid);
        int excute = createSSDTsmOperator.excute();
        C2538c.b(TAG, new Object[]{" CardEvent CREATESSD bus cardEvent END_LOCK"});
        WalletTaManager.getInstance(this.mContext).unLockCardEvent(this.mAid);
        LogX.i("IssueTrafficCardFMOperator createDMSD result=" + excute);
        if (excute != 0) {
            String str = "tsm PreIssueTrafficCardSNBTask installSSD, create ssd failed response = " + excute;
            Map hashMap = new HashMap();
            hashMap.put("aid", this.mAid);
            hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(excute));
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_DMSD_INSTALL_FAIL, hashMap, str, false, false);
            return -99;
        }
        LogX.i("create SSD successfully");
        excute = installApplet();
        if (excute == 0) {
            return excute;
        }
        LogX.e("installApplet failed. aid : " + this.mAid);
        return excute;
    }

    private int installApplet() {
        ESEInfoManager instance = ESEInfoManager.getInstance(this.mContext);
        String queryCplc = instance.queryCplc();
        String deviceSN = instance.getDeviceSN();
        String deviceModel = instance.getDeviceModel();
        String busChipManu = instance.getBusChipManu();
        LogX.i("installApplet cplc" + queryCplc + "; imei : " + deviceSN + " ; model : " + deviceModel + " ; chipManu : " + busChipManu);
        DownloadAndInstallAppletRequest downloadAndInstallAppletRequest = new DownloadAndInstallAppletRequest(this.mIssuerID, queryCplc, this.mAid, deviceModel, busChipManu);
        PluginPayAdapter pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(this.mContext).getAdapter();
        LogX.i("installApplet pluginPayAdapter.getUserID()" + pluginPayAdapter.getUserID());
        downloadAndInstallAppletRequest.setAccountUserId(pluginPayAdapter.getUserID());
        downloadAndInstallAppletRequest.setImei(deviceSN);
        DownloadAndInstallAppletResponse downloadAndInstallApplet = SPIServiceFactory.createServerAccessService(this.mContext).downloadAndInstallApplet(downloadAndInstallAppletRequest);
        if (downloadAndInstallApplet != null) {
            switch (downloadAndInstallApplet.getResultCode()) {
                case 0:
                    LogX.i("InitDmsdAndDownloadAppletOperator createSD success!");
                    return 0;
                case 2:
                    return 11;
                case 3:
                    return 11;
                default:
                    reportErr("1102", downloadAndInstallApplet.getResultCode(), "installApplet err : " + downloadAndInstallApplet.getResultDesc());
                    break;
            }
        }
        return 99;
    }

    private void reportErr(String str, int i, String str2) {
        CloudEyeLogger.build(AutoReportErrorCode.ERROR_EVENT_TRAFFIC_CARD_OPEN, str, this.mIssuerID).setResultCode(i).setResultDesc("InitDmsdAndDownloadAppletOperator err : " + str2).appendExtraInfo("aid", this.mAid).upload();
    }
}
