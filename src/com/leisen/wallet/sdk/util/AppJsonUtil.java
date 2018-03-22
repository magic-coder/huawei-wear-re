package com.leisen.wallet.sdk.util;

import com.google.gson.Gson;
import com.leisen.wallet.sdk.AppConfig;
import com.leisen.wallet.sdk.bean.CommonRequestParams;
import com.leisen.wallet.sdk.bean.OperAppletReqParams;
import com.leisen.wallet.sdk.business.ActivateAppletBusinessForReq;
import com.leisen.wallet.sdk.business.ApduResBean;
import com.leisen.wallet.sdk.business.AppletOperBusinessForReq;
import com.leisen.wallet.sdk.business.BaseBusinessForReq;
import com.leisen.wallet.sdk.business.BaseBusinessForReqNext;
import com.leisen.wallet.sdk.business.BaseRequest;
import com.leisen.wallet.sdk.business.Business;
import com.leisen.wallet.sdk.business.GPACOperBusinessForReq;
import com.leisen.wallet.sdk.business.SSDOperBusinessForReq;

public class AppJsonUtil {
    public static String getOperSSDJsonResult(CommonRequestParams commonRequestParams, int i, int i2, String str, int i3) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest, commonRequestParams);
        Business sSDOperBusinessForReq = new SSDOperBusinessForReq();
        sSDOperBusinessForReq.setType(i);
        sSDOperBusinessForReq.setSsdAid(str);
        sSDOperBusinessForReq.setOperType(i2);
        sSDOperBusinessForReq.setTaskIndex(i3);
        baseRequest.setBusiness(sSDOperBusinessForReq);
        return new Gson().toJson(baseRequest);
    }

    public static String getOperAppletJsonResult(CommonRequestParams commonRequestParams, int i, int i2, OperAppletReqParams operAppletReqParams, int i3) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest, commonRequestParams);
        Business appletOperBusinessForReq = new AppletOperBusinessForReq();
        appletOperBusinessForReq.setType(i);
        appletOperBusinessForReq.setAppAid(operAppletReqParams.getAppletAid());
        appletOperBusinessForReq.setAppletVersion(operAppletReqParams.getAppletVersion());
        appletOperBusinessForReq.setOperType(i2);
        appletOperBusinessForReq.setTaskIndex(i3);
        baseRequest.setBusiness(appletOperBusinessForReq);
        return new Gson().toJson(baseRequest);
    }

    public static String getOperGPACJsonResult(CommonRequestParams commonRequestParams, int i, int i2, String str, int i3) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest, commonRequestParams);
        Business gPACOperBusinessForReq = new GPACOperBusinessForReq();
        gPACOperBusinessForReq.setType(i);
        gPACOperBusinessForReq.setAppAid(str);
        gPACOperBusinessForReq.setOperType(i2);
        gPACOperBusinessForReq.setTaskIndex(i3);
        baseRequest.setBusiness(gPACOperBusinessForReq);
        return new Gson().toJson(baseRequest);
    }

    public static String getActivateAppletJsonResult(CommonRequestParams commonRequestParams, int i, String str, int i2) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest, commonRequestParams);
        Business activateAppletBusinessForReq = new ActivateAppletBusinessForReq();
        activateAppletBusinessForReq.setType(i);
        activateAppletBusinessForReq.setAppAid(str);
        activateAppletBusinessForReq.setTaskIndex(i2);
        baseRequest.setBusiness(activateAppletBusinessForReq);
        return new Gson().toJson(baseRequest);
    }

    public static String getReqNextJsonResult(CommonRequestParams commonRequestParams, int i, ApduResBean apduResBean, int i2, int i3) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest, commonRequestParams);
        Business baseBusinessForReqNext = new BaseBusinessForReqNext();
        baseBusinessForReqNext.setType(i);
        baseBusinessForReqNext.setRapduList(apduResBean);
        baseBusinessForReqNext.setResult(i2);
        baseBusinessForReqNext.setTaskIndex(i3);
        baseRequest.setBusiness(baseBusinessForReqNext);
        return new Gson().toJson(baseRequest);
    }

    public static String getBaseReqJsonResult(CommonRequestParams commonRequestParams, int i, int i2) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest, commonRequestParams);
        Business baseBusinessForReq = new BaseBusinessForReq();
        baseBusinessForReq.setType(i);
        baseBusinessForReq.setTaskIndex(i2);
        baseRequest.setBusiness(baseBusinessForReq);
        return new Gson().toJson(baseRequest);
    }

    private static void fillBaseData(BaseRequest<?> baseRequest, CommonRequestParams commonRequestParams) {
        baseRequest.setClientVersion(AppConfig.CLIENTVERSION);
        baseRequest.setImei(AppConfig.getImei());
        baseRequest.setMobileType(AppConfig.getMobileType());
        baseRequest.setVersion("1.0");
        baseRequest.setServiceId(commonRequestParams.getServiceId());
        baseRequest.setFunctionCallId(commonRequestParams.getFunCallId());
        baseRequest.setSeid(commonRequestParams.getSeid());
    }
}
