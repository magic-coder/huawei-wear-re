package com.huawei.nfc.carrera.logic.filedownload.unionpay.handler;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.filedownload.unionpay.listener.UnionpayInfoCallback;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.QueryDicsRequset;
import com.huawei.nfc.carrera.server.card.response.DicItem;
import com.huawei.nfc.carrera.server.card.response.QueryDicsResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestUnionpayInfoHandler extends Handler {
    private static final String DIC_NAME = "Huawei_Watch_LEO";
    private static final int UNIONPAYINFO_FAILED = 101;
    private static final int UNIONPAYINFO_REQUEST = 0;
    private static final int UNIONPAYINFO_SUCCESS = 100;
    private UnionpayInfoCallback infoCallBack;
    private final Context mContext;

    class C55471 extends Thread {
        C55471() {
        }

        public void run() {
            QueryDicsRequset queryDicsRequset = new QueryDicsRequset();
            queryDicsRequset.dicName = RequestUnionpayInfoHandler.DIC_NAME;
            queryDicsRequset.itemName = Constant.UNIONPAY_PACKAGENAME;
            QueryDicsResponse queryDics = ServerServiceFactory.createCardServerApi(RequestUnionpayInfoHandler.this.mContext).queryDics(queryDicsRequset);
            if (queryDics == null || queryDics.returnCode != 0) {
                Map hashMap = new HashMap();
                hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "getUnionpayAPKInfo failed. query server failed. " + (queryDics == null ? "response is null" : "retCode = " + queryDics.returnCode));
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_QUERY_UNIONPAY_SIGN_ERR, hashMap, null, false, false);
                RequestUnionpayInfoHandler.this.sendFailedMessage("Response is null object");
            } else if (queryDics.dicItems.size() > 0) {
                RequestUnionpayInfoHandler.this.sendSuccessMessage(((DicItem) queryDics.dicItems.get(0)).getValue());
            } else {
                RequestUnionpayInfoHandler.this.sendFailedMessage("The size of result's dictory is zero");
            }
        }
    }

    public RequestUnionpayInfoHandler(Context context, UnionpayInfoCallback unionpayInfoCallback) {
        this.infoCallBack = unionpayInfoCallback;
        this.mContext = context;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (this.infoCallBack == null) {
            LogX.e("requestUnionpayInfo callback is null ，you need excute registeListeners()  method  before download() method");
            return;
        }
        switch (message.what) {
            case 0:
                getUnionpayAPKInfo();
                return;
            case 100:
                Map analysisResult = analysisResult((String) message.obj);
                this.infoCallBack.success((String) analysisResult.get("url"), (String) analysisResult.get(com.unionpay.tsmservice.data.Constant.KEY_SIGNATURE));
                return;
            case 101:
                this.infoCallBack.failed(message.arg1, (String) message.obj);
                return;
            default:
                return;
        }
    }

    private Map<String, String> analysisResult(String str) {
        Map<String, String> hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(LightCloudConstants.DOWNLOAD_URL);
            String string2 = jSONObject.getString(com.unionpay.tsmservice.data.Constant.KEY_SIGNATURE);
            hashMap.put("url", string);
            hashMap.put(com.unionpay.tsmservice.data.Constant.KEY_SIGNATURE, string2);
        } catch (JSONException e) {
            this.infoCallBack.failed(101, "result is not a JSON value \n" + str);
        }
        return hashMap;
    }

    private void sendSuccessMessage(String str) {
        Message obtainMessage = obtainMessage(100);
        obtainMessage.obj = str;
        sendMessage(obtainMessage);
    }

    private void sendFailedMessage(String str) {
        Message obtainMessage = obtainMessage(101);
        obtainMessage.obj = str;
        obtainMessage.arg1 = 101;
        sendMessage(obtainMessage);
    }

    public void requestUnionpayInfo() {
        sendEmptyMessage(0);
    }

    private void getUnionpayAPKInfo() {
        new C55471().start();
    }

    public void unregisterListener() {
        this.infoCallBack = null;
    }
}
