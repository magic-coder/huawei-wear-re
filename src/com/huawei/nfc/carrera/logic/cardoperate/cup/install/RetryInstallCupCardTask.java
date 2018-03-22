package com.huawei.nfc.carrera.logic.cardoperate.cup.install;

import android.content.Context;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.lifecycle.cupoperate.CUPOperateServiceManager;
import com.huawei.nfc.carrera.logic.cardoperate.citic.install.HandleInstallCardResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.cup.CUPCardOperator;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.json.JsonUtil;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class RetryInstallCupCardTask extends DownloadObserver implements Runnable {
    private final String mProductID;
    private final String mRefID;

    public RetryInstallCupCardTask(Context context, String str, String str2, CardServerApi cardServerApi, HandleInstallCardResultTask handleInstallCardResultTask, CUPCardOperator cUPCardOperator) {
        super(context, handleInstallCardResultTask, cUPCardOperator, cardServerApi);
        this.mRefID = str;
        this.mProductID = str2;
    }

    public void run() {
        if (isCardDownload(this.mRefID)) {
            LogX.i("The card already download, return success.");
            handleResult(0, this.mProductID, this.mRefID);
            return;
        }
        String string = NFCPreferences.getInstance(this.mContext).getString(this.mRefID, null);
        if (string != null) {
            LogX.i("get tsmlibData from shareperference, retry download.");
            redownload(string);
            observeDownloadResult(this.mRefID, this.mProductID);
        } else if (getTsmLibData(this.mRefID)) {
            LogX.i("get tsmlibData from service, retry download.");
            observeDownloadResult(this.mRefID, this.mProductID);
        } else {
            handleResult(-19, this.mProductID, this.mRefID);
            deleteCard(this.mRefID);
        }
    }

    private void redownload(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String stringValue = JsonUtil.getStringValue(jSONObject, Constant.KEY_DOWNLOAD_INFO_SSID);
            String stringValue2 = JsonUtil.getStringValue(jSONObject, "sign");
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mRefID);
            CUPOperateServiceManager.startCUPOperateService(this.mContext, CUPCardOperator.OPERATE_EVENT_DOWNLOAD, stringValue, stringValue2, arrayList);
        } catch (JSONException e) {
            LogX.d("parsPushConsumeMsg, get json exception.");
        }
    }

    void cleanUnstartedData(String str) {
    }
}
