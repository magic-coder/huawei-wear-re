package com.huawei.nfc.carrera.logic.spi.fm.impl;

import android.content.Context;
import cn.com.fmsh.nfcos.client.libs.NfcosClientManager;
import cn.com.fmsh.nfcos.client.libs.NfcosClientManagerFactory;
import cn.com.fmsh.nfcos.client.service.huawei.NfcosBusinessOrder;
import cn.com.fmsh.nfcos.client.service.huawei.NfcosMainOrder;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.tsm.business.bean.BusinessOrder;
import cn.com.fmsh.tsm.business.bean.CardAppInfo;
import cn.com.fmsh.tsm.business.bean.MainOrder;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderType;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import cn.com.fmsh.util.FM_Bytes;
import com.huawei.aj.p315a.p318c.C4026a;
import com.huawei.login.ui.login.a;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.cardoperate.opencardlogupload.LogUploadOperator;
import com.huawei.nfc.carrera.logic.spi.fm.FMService;
import com.huawei.nfc.carrera.logic.spi.fm.request.ApplyIssueOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.ApplyRechargeOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.DoIssueRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.MoveOrDeleteAppRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.QueryBusinessOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.QueryBusinessOrdersRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.QueryProductsRequest;
import com.huawei.nfc.carrera.logic.spi.fm.request.RechargeOrDoUnsolvedOrderRequest;
import com.huawei.nfc.carrera.logic.spi.fm.response.FMBaseResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.MainOrderResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryBusinessOrderResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryBusinessOrdersResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryProductsResponse;
import com.huawei.nfc.carrera.logic.spi.fm.response.QueryTradeResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public final class FMServiceImpl implements FMService {
    private static final int APDU_EXCUTE_EXCEPTION = 9053;
    private static final int EXIST_ISSUE_ORDER = 1103;
    private static final int INVALID_SESSION = 9022;
    private static final Object LOCK = new Object();
    private static final String PWORD = "abcd1234";
    private static final int REPORT_ERROR = 2;
    private static final int SUCCESS = 0;
    private static final int SYSTEM_INNER_ERROR = 99;
    private static final int SYSTEM_RETRY = 1021;
    private static final int TERMINALS_LINK_FAILURE = 9010;
    private static final int USER_NOT_LOGIN = 1009;
    private static final int USER_NOT_REGISTER = 1000;
    private static FMServiceImpl instance = null;
    private boolean isLogin = false;
    private ApduHandler mApduHandler;
    private Context mContext = null;
    private NfcosClientManager mNfcosClientManager;

    public static FMService getInstance(Context context) {
        FMService fMService;
        synchronized (LOCK) {
            if (instance == null) {
                instance = new FMServiceImpl(context);
            }
            fMService = instance;
        }
        return fMService;
    }

    private FMServiceImpl(Context context) {
        this.mContext = context.getApplicationContext();
        this.mNfcosClientManager = NfcosClientManagerFactory.getNfcosClientManager();
        this.mApduHandler = new FMApduHandlerImpl(this.mContext);
        this.mNfcosClientManager.registerLogHandle(new FMLog4Android());
        this.mNfcosClientManager.registerApduHandler(this.mApduHandler);
    }

    private void bindNfcosService() {
        if (this.mApduHandler == null) {
            this.mApduHandler = new FMApduHandlerImpl(this.mContext);
        }
        if (this.mNfcosClientManager == null) {
            this.mNfcosClientManager = NfcosClientManagerFactory.getNfcosClientManager();
        }
        this.mNfcosClientManager.registerApduHandler(this.mApduHandler);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean login(com.huawei.nfc.carrera.logic.spi.fm.response.FMBaseResponse r9) {
        /*
        r8 = this;
        r7 = 9022; // 0x233e float:1.2643E-41 double:4.4575E-320;
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = 1;
        r1 = "FMServiceImpl, login enter";
        com.huawei.nfc.carrera.util.LogX.i(r1);
        r1 = r8.mContext;
        r1 = com.huawei.login.ui.login.a.a(r1);
        r3 = r1.c();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "FMServiceImpl, login userName = ";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r1 = r1.toString();
        com.huawei.nfc.carrera.util.LogX.i(r1);
        r1 = 0;
        r2 = r8.mNfcosClientManager;	 Catch:{ BusinessException -> 0x008d }
        r4 = "abcd1234";
        r2 = r2.login(r3, r4);	 Catch:{ BusinessException -> 0x008d }
        r2 = r2.getResult();	 Catch:{ BusinessException -> 0x008d }
        r9.FMCode = r2;	 Catch:{ BusinessException -> 0x008d }
        r9.resultCode = r2;	 Catch:{ BusinessException -> 0x008d }
        r4 = new java.lang.StringBuilder;	 Catch:{ BusinessException -> 0x008d }
        r4.<init>();	 Catch:{ BusinessException -> 0x008d }
        r5 = "FMServiceImpl, login info  -getResult ";
        r4 = r4.append(r5);	 Catch:{ BusinessException -> 0x008d }
        r4 = r4.append(r2);	 Catch:{ BusinessException -> 0x008d }
        r4 = r4.toString();	 Catch:{ BusinessException -> 0x008d }
        com.huawei.nfc.carrera.util.LogX.i(r4);	 Catch:{ BusinessException -> 0x008d }
        if (r2 != 0) goto L_0x0055;
    L_0x0053:
        r1 = r0;
    L_0x0054:
        return r1;
    L_0x0055:
        if (r2 != r6) goto L_0x0087;
    L_0x0057:
        r2 = r8.register(r9);	 Catch:{ BusinessException -> 0x008d }
        if (r2 == 0) goto L_0x0085;
    L_0x005d:
        r2 = r8.mNfcosClientManager;	 Catch:{ BusinessException -> 0x008d }
        r4 = "abcd1234";
        r2 = r2.login(r3, r4);	 Catch:{ BusinessException -> 0x008d }
        r2 = r2.getResult();	 Catch:{ BusinessException -> 0x008d }
        r9.FMCode = r2;	 Catch:{ BusinessException -> 0x008d }
        r9.resultCode = r2;	 Catch:{ BusinessException -> 0x008d }
        r4 = new java.lang.StringBuilder;	 Catch:{ BusinessException -> 0x008d }
        r4.<init>();	 Catch:{ BusinessException -> 0x008d }
        r5 = "FMServiceImpl, login returnCode=";
        r4 = r4.append(r5);	 Catch:{ BusinessException -> 0x008d }
        r4 = r4.append(r2);	 Catch:{ BusinessException -> 0x008d }
        r4 = r4.toString();	 Catch:{ BusinessException -> 0x008d }
        com.huawei.nfc.carrera.util.LogX.i(r4);	 Catch:{ BusinessException -> 0x008d }
        if (r2 == 0) goto L_0x0053;
    L_0x0085:
        r0 = r1;
        goto L_0x0053;
    L_0x0087:
        if (r2 != r7) goto L_0x0085;
    L_0x0089:
        r2 = -2;
        r9.resultCode = r2;	 Catch:{ BusinessException -> 0x008d }
        goto L_0x0085;
    L_0x008d:
        r2 = move-exception;
        r4 = "login";
        r2 = r8.changeException2ErrorId(r4, r2);
        r9.FMCode = r2;
        r9.resultCode = r2;
        if (r2 != r6) goto L_0x00d9;
    L_0x009a:
        r2 = r8.register(r9);	 Catch:{ BusinessException -> 0x00e0 }
        if (r2 == 0) goto L_0x0054;
    L_0x00a0:
        r2 = r8.mNfcosClientManager;	 Catch:{ BusinessException -> 0x00e0 }
        r4 = "abcd1234";
        r2 = r2.login(r3, r4);	 Catch:{ BusinessException -> 0x00e0 }
        r3 = r2.getResult();	 Catch:{ BusinessException -> 0x00e0 }
        r9.FMCode = r3;	 Catch:{ BusinessException -> 0x00e0 }
        r9.resultCode = r3;	 Catch:{ BusinessException -> 0x00e0 }
        r4 = new java.lang.StringBuilder;	 Catch:{ BusinessException -> 0x00e0 }
        r4.<init>();	 Catch:{ BusinessException -> 0x00e0 }
        r5 = "FMServiceImpl, login returnCode=";
        r4 = r4.append(r5);	 Catch:{ BusinessException -> 0x00e0 }
        r4 = r4.append(r3);	 Catch:{ BusinessException -> 0x00e0 }
        r5 = ",loginCode=";
        r4 = r4.append(r5);	 Catch:{ BusinessException -> 0x00e0 }
        r2 = r2.getResult();	 Catch:{ BusinessException -> 0x00e0 }
        r2 = r4.append(r2);	 Catch:{ BusinessException -> 0x00e0 }
        r2 = r2.toString();	 Catch:{ BusinessException -> 0x00e0 }
        com.huawei.nfc.carrera.util.LogX.i(r2);	 Catch:{ BusinessException -> 0x00e0 }
        if (r3 != 0) goto L_0x0054;
    L_0x00d6:
        r1 = r0;
        goto L_0x0054;
    L_0x00d9:
        if (r2 != r7) goto L_0x0054;
    L_0x00db:
        r0 = -2;
        r9.resultCode = r0;	 Catch:{ BusinessException -> 0x00e0 }
        goto L_0x0054;
    L_0x00e0:
        r0 = move-exception;
        r2 = "loginAgain";
        r8.changeException2ErrorId(r2, r0);
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.nfc.carrera.logic.spi.fm.impl.FMServiceImpl.login(com.huawei.nfc.carrera.logic.spi.fm.response.FMBaseResponse):boolean");
    }

    private boolean register(FMBaseResponse fMBaseResponse) {
        LogX.i("FMServiceImpl, register enter");
        try {
            int register = this.mNfcosClientManager.register(a.a(this.mContext).c(), PWORD);
            fMBaseResponse.FMCode = register;
            LogX.i("FMServiceImpl, register returnCode=" + register);
            if (register == 0) {
                return true;
            }
            if (register != INVALID_SESSION) {
                return false;
            }
            fMBaseResponse.resultCode = -2;
            return false;
        } catch (Throwable e) {
            LogX.e("FMServiceImpl, register IllegalStateException", e);
            return false;
        } catch (BusinessException e2) {
            if (changeException2ErrorId("register", e2) != INVALID_SESSION) {
                return false;
            }
            fMBaseResponse.resultCode = -2;
            return false;
        }
    }

    private byte[] getAppNo(String str) {
        LogX.i("FMServiceImpl, getAppNo enter");
        CardAppInfo cardAppInfo = new CardAppInfo();
        try {
            cardAppInfo = this.mNfcosClientManager.getCardAppInfo(1, getCardAppType(str));
        } catch (BusinessException e) {
            changeException2ErrorId("getAppNo", e);
        }
        LogX.w("FMServiceImpl, getAppNo is " + FM_Bytes.bytesToHexString(cardAppInfo.getCardAppNo()));
        return cardAppInfo.getCardAppNo();
    }

    private boolean judgeApplyIssueOrderRequestValid(ApplyIssueOrderRequest applyIssueOrderRequest) {
        if (applyIssueOrderRequest == null || StringUtil.isEmpty(applyIssueOrderRequest.getModule(), true) || applyIssueOrderRequest.getSeid() == null || applyIssueOrderRequest.getSeid().length == 0 || applyIssueOrderRequest.getActCode() == null || applyIssueOrderRequest.getActCode().length == 0) {
            return false;
        }
        return true;
    }

    public MainOrderResponse applyIssueOrder(ApplyIssueOrderRequest applyIssueOrderRequest, int i) {
        MainOrder applyIssue;
        LogX.i("FMServiceImpl, applyIssueOrder enter");
        FMBaseResponse mainOrderResponse = new MainOrderResponse();
        if (!judgeApplyIssueOrderRequestValid(applyIssueOrderRequest)) {
            LogX.e("FMServiceImpl, applyIssueOrder illegal params");
            return mainOrderResponse;
        } else if (!checkNetAndIslogin(mainOrderResponse)) {
            return mainOrderResponse;
        } else {
            int amount = applyIssueOrderRequest.getAmount();
            String module = applyIssueOrderRequest.getModule();
            byte[] seid = applyIssueOrderRequest.getSeid();
            byte[] actCode = applyIssueOrderRequest.getActCode();
            EnumCardAppType cardAppType = getCardAppType(applyIssueOrderRequest.getAid());
            try {
                LogX.i("FMServiceImpl, applyIssueOrder module=" + module + " amount " + amount + " seid " + FM_Bytes.bytesToHexString(seid) + " actCode.length " + actCode.length + " ; mode : " + i + " ; Aid : " + applyIssueOrderRequest.getAid());
                applyIssue = this.mNfcosClientManager.applyIssue(cardAppType, amount, i, seid, module, actCode);
                mainOrderResponse.FMCode = 0;
                mainOrderResponse.resultCode = 0;
                mainOrderResponse.order = NfcParserUtil.parseMainOrder2NfcType(applyIssue);
            } catch (BusinessException e) {
                int changeException2ErrorId = changeException2ErrorId("applyIssueOrder", e);
                if (changeException2ErrorId == 1103) {
                    mainOrderResponse.resultCode = 1;
                } else if (changeException2ErrorId == 1009 || changeException2ErrorId == INVALID_SESSION || changeException2ErrorId == TERMINALS_LINK_FAILURE) {
                    this.isLogin = false;
                    if (!login(mainOrderResponse)) {
                        return mainOrderResponse;
                    }
                    this.isLogin = true;
                    try {
                        applyIssue = this.mNfcosClientManager.applyIssue(cardAppType, amount, i, seid, module, actCode);
                        mainOrderResponse.FMCode = 0;
                        mainOrderResponse.resultCode = 0;
                        mainOrderResponse.order = NfcParserUtil.parseMainOrder2NfcType(applyIssue);
                    } catch (BusinessException e2) {
                        changeException2ErrorId = changeException2ErrorId("applyIssueOrder_BusinessException", e2);
                        if (changeException2ErrorId == 1103) {
                            mainOrderResponse.resultCode = 1;
                        } else if (changeException2ErrorId == INVALID_SESSION) {
                            mainOrderResponse.resultCode = -2;
                        }
                    }
                }
            }
            return mainOrderResponse;
        }
    }

    public FMBaseResponse downloadCAP(DoIssueRequest doIssueRequest) {
        LogX.i("FMServiceImpl, downloadCAP enter");
        FMBaseResponse fMBaseResponse = new FMBaseResponse();
        if (doIssueRequest == null || doIssueRequest.order == null || doIssueRequest.order.length == 0 || doIssueRequest.seid == null || doIssueRequest.seid.length == 0) {
            LogX.e("FMServiceImpl, downloadCAP illegal params");
        } else if (checkNetAndIslogin(fMBaseResponse)) {
            byte[] bArr = doIssueRequest.order;
            byte[] bArr2 = doIssueRequest.seid;
            try {
                int doIssue = this.mNfcosClientManager.doIssue(bArr, 81, bArr2, null);
                fMBaseResponse.FMCode = doIssue;
                LogX.i("FMServiceImpl, downloadCAP returnCode=" + doIssue);
                if (doIssue == 0) {
                    fMBaseResponse.resultCode = 0;
                } else if (doIssue == 1009 || doIssue == INVALID_SESSION) {
                    this.isLogin = false;
                    if (login(fMBaseResponse)) {
                        this.isLogin = true;
                        int doIssue2 = this.mNfcosClientManager.doIssue(bArr, 81, bArr2, null);
                        fMBaseResponse.FMCode = doIssue2;
                        LogX.i("FMServiceImpl, downloadCAP returnCode=" + doIssue2);
                        if (doIssue2 == 0) {
                            fMBaseResponse.resultCode = 0;
                        } else if (doIssue2 == INVALID_SESSION) {
                            fMBaseResponse.resultCode = -2;
                        }
                    }
                }
            } catch (BusinessException e) {
                changeException2ErrorId("downloadCAP", e);
            }
        }
        return fMBaseResponse;
    }

    public FMBaseResponse installAndPersonalizeApplet(DoIssueRequest doIssueRequest) {
        LogX.i("FMServiceImpl, installAndPersonalizeApplet enter");
        FMBaseResponse fMBaseResponse = new FMBaseResponse();
        if (doIssueRequest == null || doIssueRequest.order == null || doIssueRequest.order.length == 0 || doIssueRequest.seid == null || doIssueRequest.seid.length == 0) {
            LogX.e("FMServiceImpl, installAndPersonalizeApplet illegal params");
            return fMBaseResponse;
        } else if (!checkNetAndIslogin(fMBaseResponse)) {
            return fMBaseResponse;
        } else {
            byte[] bArr = doIssueRequest.order;
            byte[] bArr2 = doIssueRequest.seid;
            LogX.i("FMServiceImpl, installAndPersonalizeApplet order=" + FM_Bytes.bytesToHexString(bArr) + " seid=" + FM_Bytes.bytesToHexString(bArr2));
            int doIssue;
            try {
                doIssue = this.mNfcosClientManager.doIssue(bArr, 1, bArr2, null);
                fMBaseResponse.FMCode = doIssue;
                LogX.i("FMServiceImpl, installAndPersonalizeApplet returnCode=" + doIssue);
                if (doIssue == 0) {
                    fMBaseResponse.resultCode = 0;
                } else if (doIssue == 1009 || doIssue == INVALID_SESSION) {
                    this.isLogin = false;
                    if (login(fMBaseResponse)) {
                        this.isLogin = true;
                        doIssue = this.mNfcosClientManager.doIssue(bArr, 1, bArr2, null);
                        fMBaseResponse.FMCode = doIssue;
                        LogX.i("FMServiceImpl, installAndPersonalizeApplet returnCode=" + doIssue);
                        if (doIssue == 0) {
                            fMBaseResponse.resultCode = 0;
                        } else if (doIssue == INVALID_SESSION) {
                            fMBaseResponse.resultCode = -2;
                        }
                    }
                }
                return fMBaseResponse;
            } catch (BusinessException e) {
                doIssue = changeException2ErrorId("installAndPersonalizeApplet", e);
                fMBaseResponse.resultCode = doIssue;
                LogX.i("FMServiceImpl, BusinessException returnCode=" + doIssue);
                if (doIssue == 1009 || doIssue == INVALID_SESSION) {
                    try {
                        this.isLogin = false;
                        if (login(fMBaseResponse)) {
                            this.isLogin = true;
                            if (!((FMApduHandlerImpl) this.mApduHandler).isBTConnect()) {
                                return fMBaseResponse;
                            }
                            doIssue = this.mNfcosClientManager.doIssue(bArr, 1, bArr2, null);
                            fMBaseResponse.FMCode = doIssue;
                            LogX.i("FMServiceImpl, retry installAndPersonalizeApplet returnCode=" + doIssue);
                            if (doIssue == 0) {
                                fMBaseResponse.resultCode = 0;
                            } else if (doIssue == INVALID_SESSION) {
                                fMBaseResponse.resultCode = -2;
                            }
                        }
                    } catch (BusinessException e2) {
                        return getFmBaseResponse(fMBaseResponse, e2);
                    }
                } else if (doIssue == 1021 || doIssue == 2 || doIssue == 99 || doIssue == TERMINALS_LINK_FAILURE) {
                    if (!((FMApduHandlerImpl) this.mApduHandler).isBTConnect()) {
                        return fMBaseResponse;
                    }
                    doIssue = this.mNfcosClientManager.doIssue(bArr, 1, bArr2, null);
                    fMBaseResponse.FMCode = doIssue;
                    LogX.i("FMServiceImpl, retry installAndPersonalizeApplet returnCode=" + doIssue);
                    if (doIssue == 0) {
                        fMBaseResponse.resultCode = 0;
                    } else if (doIssue == INVALID_SESSION) {
                        fMBaseResponse.resultCode = -2;
                    }
                }
                return fMBaseResponse;
            }
        }
    }

    private FMBaseResponse getFmBaseResponse(FMBaseResponse fMBaseResponse, BusinessException businessException) {
        int changeException2ErrorId = changeException2ErrorId("retry installAndPersonalizeApplet", businessException);
        fMBaseResponse.resultCode = changeException2ErrorId;
        if (changeException2ErrorId == 0) {
            fMBaseResponse.resultCode = 0;
        } else if (changeException2ErrorId == INVALID_SESSION) {
            fMBaseResponse.resultCode = -2;
        }
        return fMBaseResponse;
    }

    public FMBaseResponse retryInstallApplet(DoIssueRequest doIssueRequest) {
        LogX.i("FMServiceImpl, retryInstallApplet enter");
        FMBaseResponse fMBaseResponse = new FMBaseResponse();
        if (!judgeDoIssueRequestValid(doIssueRequest)) {
            LogX.e("FMServiceImpl, retryInstallApplet illegal params");
        } else if (checkNetAndIslogin(fMBaseResponse)) {
            byte[] bArr = doIssueRequest.order;
            byte[] bArr2 = doIssueRequest.seid;
            try {
                int doIssue = this.mNfcosClientManager.doIssue(bArr, 1, bArr2, null);
                fMBaseResponse.FMCode = doIssue;
                LogX.i("FMServiceImpl, retryInstallApplet returnCode=" + doIssue);
                if (doIssue == 0) {
                    fMBaseResponse.resultCode = 0;
                } else if (doIssue == 1009 || doIssue == INVALID_SESSION) {
                    this.isLogin = false;
                    if (login(fMBaseResponse)) {
                        this.isLogin = true;
                        int doIssue2 = this.mNfcosClientManager.doIssue(bArr, 1, bArr2, null);
                        fMBaseResponse.FMCode = doIssue2;
                        LogX.i("FMServiceImpl, retryInstallApplet returnCode=" + doIssue2);
                        if (doIssue2 == 0) {
                            fMBaseResponse.resultCode = 0;
                        } else if (doIssue2 == INVALID_SESSION) {
                            fMBaseResponse.resultCode = -2;
                        }
                    }
                }
            } catch (BusinessException e) {
                changeException2ErrorId("retryInstallApplet", e);
            }
        }
        return fMBaseResponse;
    }

    private boolean judgeDoIssueRequestValid(DoIssueRequest doIssueRequest) {
        if (doIssueRequest == null || doIssueRequest.order == null || doIssueRequest.order.length == 0 || doIssueRequest.seid == null || doIssueRequest.seid.length == 0) {
            return false;
        }
        return true;
    }

    public MainOrderResponse applyRechargeOrder(ApplyRechargeOrderRequest applyRechargeOrderRequest, int i) {
        LogX.i("FMServiceImpl, applyRechargeOrder enter");
        FMBaseResponse mainOrderResponse = new MainOrderResponse();
        if (applyRechargeOrderRequest == null || applyRechargeOrderRequest.getActCode() == null || applyRechargeOrderRequest.getActCode().length == 0) {
            LogX.e("FMServiceImpl, applyRechargeOrder illegal params");
            return mainOrderResponse;
        } else if (!checkNetAndIslogin(mainOrderResponse)) {
            return mainOrderResponse;
        } else {
            String aid = applyRechargeOrderRequest.getAid();
            NfcosMainOrder nfcosMainOrder = new NfcosMainOrder();
            int amount = applyRechargeOrderRequest.getAmount();
            byte[] appNo = getAppNo(aid);
            byte[] actCode = applyRechargeOrderRequest.getActCode();
            EnumCardAppType cardAppType = getCardAppType(aid);
            try {
                mainOrderResponse.order = NfcParserUtil.parseMainOrder2NfcType(this.mNfcosClientManager.apply4PayEx(cardAppType, amount, i, appNo, actCode));
                mainOrderResponse.FMCode = 0;
                mainOrderResponse.resultCode = 0;
            } catch (BusinessException e) {
                int changeException2ErrorId = changeException2ErrorId("applyRechargeOrder", e);
                if (changeException2ErrorId == 1009 || changeException2ErrorId == INVALID_SESSION || changeException2ErrorId == TERMINALS_LINK_FAILURE) {
                    this.isLogin = false;
                    if (!login(mainOrderResponse)) {
                        return mainOrderResponse;
                    }
                    this.isLogin = true;
                    try {
                        mainOrderResponse.order = NfcParserUtil.parseMainOrder2NfcType(this.mNfcosClientManager.apply4PayEx(cardAppType, amount, i, appNo, actCode));
                        mainOrderResponse.FMCode = 0;
                        mainOrderResponse.resultCode = 0;
                    } catch (BusinessException e2) {
                        int changeException2ErrorId2 = changeException2ErrorId("applyRechargeOrder", e2);
                        if (changeException2ErrorId2 == 0) {
                            mainOrderResponse.resultCode = 0;
                            mainOrderResponse.order = nfcosMainOrder;
                        } else if (changeException2ErrorId2 == INVALID_SESSION) {
                            mainOrderResponse.resultCode = -2;
                        }
                    }
                    LogX.i("FMServiceImpl, applyRechargeOrder returnCode=" + changeException2ErrorId);
                }
            }
            return mainOrderResponse;
        }
    }

    public FMBaseResponse recharge(RechargeOrDoUnsolvedOrderRequest rechargeOrDoUnsolvedOrderRequest) {
        LogX.i("FMServiceImpl, recharge enter");
        FMBaseResponse fMBaseResponse = new FMBaseResponse();
        if (rechargeOrDoUnsolvedOrderRequest == null || rechargeOrDoUnsolvedOrderRequest.getOrder() == null || rechargeOrDoUnsolvedOrderRequest.getOrder().length == 0) {
            LogX.e("FMServiceImpl, recharge illegal params");
        } else if (checkNetAndIslogin(fMBaseResponse)) {
            byte[] order = rechargeOrDoUnsolvedOrderRequest.getOrder();
            byte[] appNo = getAppNo(rechargeOrDoUnsolvedOrderRequest.getAid());
            int recharge;
            try {
                recharge = this.mNfcosClientManager.recharge(order, appNo);
                fMBaseResponse.FMCode = recharge;
                LogX.i("FMServiceImpl, recharge returnCode=" + recharge);
                if (recharge == 0) {
                    fMBaseResponse.resultCode = 0;
                } else if (recharge == 1009 || recharge == INVALID_SESSION) {
                    this.isLogin = false;
                    if (login(fMBaseResponse)) {
                        this.isLogin = true;
                        recharge = this.mNfcosClientManager.recharge(order, appNo);
                        fMBaseResponse.FMCode = recharge;
                        LogX.i("FMServiceImpl, recharge returnCode=" + recharge);
                        if (recharge == 0) {
                            fMBaseResponse.resultCode = 0;
                        } else if (recharge == INVALID_SESSION) {
                            fMBaseResponse.resultCode = -2;
                        }
                    }
                }
            } catch (BusinessException e) {
                recharge = changeException2ErrorId(LogUploadOperator.RESULT_CODE_RECHARGE_DES, e);
                if (recharge == 1009 || recharge == INVALID_SESSION) {
                    this.isLogin = false;
                    if (login(fMBaseResponse)) {
                        this.isLogin = true;
                        try {
                            recharge = this.mNfcosClientManager.recharge(order, appNo);
                            fMBaseResponse.FMCode = recharge;
                            LogX.i("FMServiceImpl, recharge returnCode=" + recharge);
                            if (recharge == 0) {
                                fMBaseResponse.resultCode = 0;
                            } else if (recharge == INVALID_SESSION) {
                                fMBaseResponse.resultCode = -2;
                            }
                        } catch (BusinessException e2) {
                            if (changeException2ErrorId(LogUploadOperator.RESULT_CODE_RECHARGE_DES, e2) == INVALID_SESSION) {
                                fMBaseResponse.resultCode = -2;
                            }
                        }
                    }
                }
            }
        }
        return fMBaseResponse;
    }

    public FMBaseResponse moveApp(MoveOrDeleteAppRequest moveOrDeleteAppRequest) {
        LogX.i("FMServiceImpl, moveApp enter");
        return new FMBaseResponse();
    }

    public FMBaseResponse deleteApp(MoveOrDeleteAppRequest moveOrDeleteAppRequest) {
        LogX.i("FMServiceImpl, deleteApp enter");
        return new FMBaseResponse();
    }

    public QueryBusinessOrdersResponse queryBusinessOrders(QueryBusinessOrdersRequest queryBusinessOrdersRequest) {
        LogX.i("FMServiceImpl, queryBusinessOrders enter");
        FMBaseResponse queryBusinessOrdersResponse = new QueryBusinessOrdersResponse();
        if (!judgeQueryBusinessOrdersRequestValid(queryBusinessOrdersRequest)) {
            LogX.e("FMServiceImpl, queryBusinessOrders illegal params");
            return queryBusinessOrdersResponse;
        } else if (!checkNetAndIslogin(queryBusinessOrdersResponse)) {
            return queryBusinessOrdersResponse;
        } else {
            ArrayList arrayList = new ArrayList();
            int start = queryBusinessOrdersRequest.getStart();
            int businessOrderType = queryBusinessOrdersRequest.getBusinessOrderType();
            int[] orderStatuses = queryBusinessOrdersRequest.getOrderStatuses();
            String aid = queryBusinessOrdersRequest.getAid();
            EnumCardAppType cardAppType = getCardAppType(aid);
            byte[] seid;
            if (businessOrderType == 2) {
                seid = queryBusinessOrdersRequest.getSeid();
            } else {
                seid = getAppNo(aid);
                if (seid == null) {
                    LogX.e("FMServiceImpl, queryBusinessOrders appNoOrSeid == null");
                    return queryBusinessOrdersResponse;
                }
            }
            EnumBusinessOrderType enumBusinessOrderType = NfcParserUtil.getEnumBusinessOrderType(businessOrderType);
            List enumOrderStatuses = NfcParserUtil.getEnumOrderStatuses(orderStatuses);
            try {
                for (BusinessOrder businessOrder : this.mNfcosClientManager.queryBusinessOrders(start, 10, cardAppType, enumBusinessOrderType, enumOrderStatuses, r6)) {
                    LogX.i("FMServiceImpl, queryBusinessOrder businessOrder getOrder ", FM_Bytes.bytesToHexString(businessOrder.getOrder()));
                    arrayList.add(NfcParserUtil.parseBusinessOrder2NfcosType(businessOrder));
                }
                queryBusinessOrdersResponse.orderList = arrayList;
                queryBusinessOrdersResponse.resultCode = 0;
            } catch (BusinessException e) {
                businessOrderType = changeException2ErrorId("queryBusinessOrders", e);
                if (businessOrderType == 1009 || businessOrderType == INVALID_SESSION) {
                    this.isLogin = false;
                    if (!login(queryBusinessOrdersResponse)) {
                        return queryBusinessOrdersResponse;
                    }
                    this.isLogin = true;
                    try {
                        for (BusinessOrder businessOrder2 : this.mNfcosClientManager.queryBusinessOrders(start, 10, cardAppType, enumBusinessOrderType, enumOrderStatuses, r6)) {
                            arrayList.add(NfcParserUtil.parseBusinessOrder2NfcosType(businessOrder2));
                        }
                        queryBusinessOrdersResponse.orderList = arrayList;
                        queryBusinessOrdersResponse.resultCode = 0;
                    } catch (BusinessException e2) {
                        changeException2ErrorId("queryBusinessOrders", e2);
                    }
                }
            }
            return queryBusinessOrdersResponse;
        }
    }

    private boolean judgeQueryBusinessOrdersRequestValid(QueryBusinessOrdersRequest queryBusinessOrdersRequest) {
        if (queryBusinessOrdersRequest == null || queryBusinessOrdersRequest.getOrderStatuses() == null || (queryBusinessOrdersRequest.getBusinessOrderType() == 2 && (queryBusinessOrdersRequest.getSeid() == null || queryBusinessOrdersRequest.getSeid().length == 0))) {
            return false;
        }
        return true;
    }

    public QueryCardInfoResponse queryCardInfo(int i, String str) {
        LogX.i("FMServiceImpl, queryCardInfo enter");
        bindNfcosService();
        QueryCardInfoResponse queryCardInfoResponse = new QueryCardInfoResponse();
        EnumCardAppType cardAppType = getCardAppType(str);
        cn.com.fmsh.nfcos.client.service.huawei.CardAppInfo cardAppInfo = new cn.com.fmsh.nfcos.client.service.huawei.CardAppInfo();
        try {
            CardAppInfo cardAppInfo2 = this.mNfcosClientManager.getCardAppInfo(i, cardAppType);
            cn.com.fmsh.nfcos.client.service.huawei.CardAppInfo parseCardAppInfo2NfcosType = NfcParserUtil.parseCardAppInfo2NfcosType(cardAppInfo2);
            queryCardInfoResponse.resultCode = 0;
            queryCardInfoResponse.setCardNo(parseCardAppInfo2NfcosType.cardFaceNo);
            queryCardInfoResponse.setBalance(parseCardAppInfo2NfcosType.balance);
            queryCardInfoResponse.setTime4Validity(parseCardAppInfo2NfcosType.time4Validity);
            LogX.w("FMServiceImpl, getAppNo is " + FM_Bytes.bytesToHexString(cardAppInfo2.getCardAppNo()) + " time4Validity " + cardAppInfo2.getTime4Validity());
        } catch (BusinessException e) {
            LogX.w("FMServiceImpl, queryCardInfo Error Id", e.getErrorMsg().getId());
            if (changeException2ErrorId("queryCardInfo", e) == APDU_EXCUTE_EXCEPTION) {
                try {
                    cardAppInfo = NfcParserUtil.parseCardAppInfo2NfcosType(this.mNfcosClientManager.getCardAppInfo(i, cardAppType));
                    queryCardInfoResponse.resultCode = 0;
                    queryCardInfoResponse.setCardNo(cardAppInfo.cardFaceNo);
                    queryCardInfoResponse.setBalance(cardAppInfo.balance);
                    queryCardInfoResponse.setTime4Validity(cardAppInfo.time4Validity);
                } catch (BusinessException e2) {
                    changeException2ErrorId("queryCardInfoAgain", e2);
                }
            }
        }
        return queryCardInfoResponse;
    }

    public QueryTradeResponse queryTrade(String str) {
        LogX.i("FMServiceImpl, queryTrade enter");
        bindNfcosService();
        EnumCardAppType cardAppType = getCardAppType(str);
        QueryTradeResponse queryTradeResponse = new QueryTradeResponse();
        cn.com.fmsh.nfcos.client.service.huawei.CardAppInfo cardAppInfo = new cn.com.fmsh.nfcos.client.service.huawei.CardAppInfo();
        try {
            cn.com.fmsh.nfcos.client.service.huawei.CardAppInfo parseCardAppInfo2NfcosType = NfcParserUtil.parseCardAppInfo2NfcosType(this.mNfcosClientManager.getCardAppInfo(4, cardAppType));
            queryTradeResponse.resultCode = 0;
            queryTradeResponse.tradeRecords = parseCardAppInfo2NfcosType.records;
        } catch (BusinessException e) {
            changeException2ErrorId("queryTrade", e);
        }
        return queryTradeResponse;
    }

    public FMBaseResponse doUnsolvedOrder(RechargeOrDoUnsolvedOrderRequest rechargeOrDoUnsolvedOrderRequest) {
        LogX.i("FMServiceImpl, doUnsolvedOrder enter");
        FMBaseResponse fMBaseResponse = new FMBaseResponse();
        if (rechargeOrDoUnsolvedOrderRequest == null || rechargeOrDoUnsolvedOrderRequest.getOrder() == null || rechargeOrDoUnsolvedOrderRequest.getOrder().length == 0) {
            LogX.e("FMServiceImpl, doUnsolvedOrder illegal params");
        } else if (checkNetAndIslogin(fMBaseResponse)) {
            byte[] order = rechargeOrDoUnsolvedOrderRequest.getOrder();
            int doUnsolvedOrder;
            try {
                doUnsolvedOrder = this.mNfcosClientManager.doUnsolvedOrder(order, order);
                fMBaseResponse.FMCode = doUnsolvedOrder;
                LogX.i("FMServiceImpl, doUnsolvedOrder returnCode=" + doUnsolvedOrder);
                if (doUnsolvedOrder == 0) {
                    fMBaseResponse.resultCode = 0;
                } else if (doUnsolvedOrder == 1009 || doUnsolvedOrder == INVALID_SESSION) {
                    this.isLogin = false;
                    if (login(fMBaseResponse)) {
                        this.isLogin = true;
                        doUnsolvedOrder = this.mNfcosClientManager.doUnsolvedOrder(order, order);
                        fMBaseResponse.FMCode = doUnsolvedOrder;
                        LogX.i("FMServiceImpl, doUnsolvedOrder returnCode=" + doUnsolvedOrder);
                        if (doUnsolvedOrder == 0) {
                            fMBaseResponse.resultCode = 0;
                        } else if (doUnsolvedOrder == INVALID_SESSION) {
                            fMBaseResponse.resultCode = -2;
                        }
                    }
                }
            } catch (BusinessException e) {
                doUnsolvedOrder = changeException2ErrorId("doUnsolvedOrder", e);
                if (doUnsolvedOrder == 1009 || doUnsolvedOrder == INVALID_SESSION) {
                    this.isLogin = false;
                    if (login(fMBaseResponse)) {
                        this.isLogin = true;
                        try {
                            doUnsolvedOrder = this.mNfcosClientManager.doUnsolvedOrder(order, order);
                            fMBaseResponse.FMCode = doUnsolvedOrder;
                            LogX.i("FMServiceImpl, doUnsolvedOrder returnCode=" + doUnsolvedOrder);
                            if (doUnsolvedOrder == 0) {
                                fMBaseResponse.resultCode = 0;
                            } else if (doUnsolvedOrder == INVALID_SESSION) {
                                fMBaseResponse.resultCode = -2;
                            }
                        } catch (BusinessException e2) {
                            if (changeException2ErrorId("doUnsolvedOrder", e2) == INVALID_SESSION) {
                                fMBaseResponse.resultCode = -2;
                            }
                        }
                    }
                }
            }
        }
        return fMBaseResponse;
    }

    public QueryBusinessOrderResponse queryBusinessOrder(QueryBusinessOrderRequest queryBusinessOrderRequest) {
        LogX.i("FMServiceImpl, queryBusinessOrder enter");
        FMBaseResponse queryBusinessOrderResponse = new QueryBusinessOrderResponse();
        if (queryBusinessOrderRequest == null || queryBusinessOrderRequest.order == null || queryBusinessOrderRequest.order.length == 0) {
            LogX.e("FMServiceImpl, queryBusinessOrder illegal params");
        } else if (checkNetAndIslogin(queryBusinessOrderResponse)) {
            NfcosBusinessOrder nfcosBusinessOrder = new NfcosBusinessOrder();
            byte[] bArr = queryBusinessOrderRequest.order;
            BusinessOrder queryBusinessOrder;
            try {
                queryBusinessOrder = this.mNfcosClientManager.queryBusinessOrder(bArr);
                queryBusinessOrderResponse.FMCode = 0;
                queryBusinessOrderResponse.resultCode = 0;
                queryBusinessOrderResponse.order = NfcParserUtil.parseBusinessOrder2NfcosType(queryBusinessOrder);
            } catch (BusinessException e) {
                int changeException2ErrorId = changeException2ErrorId("queryBusinessOrder", e);
                if (changeException2ErrorId == 1009 || changeException2ErrorId == INVALID_SESSION) {
                    this.isLogin = false;
                    if (login(queryBusinessOrderResponse)) {
                        try {
                            queryBusinessOrder = this.mNfcosClientManager.queryBusinessOrder(bArr);
                            queryBusinessOrderResponse.FMCode = 0;
                            queryBusinessOrderResponse.resultCode = 0;
                            queryBusinessOrderResponse.order = NfcParserUtil.parseBusinessOrder2NfcosType(queryBusinessOrder);
                        } catch (BusinessException e2) {
                            if (changeException2ErrorId("queryBusinessOrder", e2) == INVALID_SESSION) {
                                queryBusinessOrderResponse.resultCode = -2;
                            }
                        }
                    }
                }
            }
        }
        return queryBusinessOrderResponse;
    }

    private boolean checkNetAndIslogin(FMBaseResponse fMBaseResponse) {
        LogX.i("FMServiceImpl, checkNetAndIslogin enter");
        if (C4026a.m19819a(this.mContext)) {
            bindNfcosService();
            if (this.isLogin) {
                return true;
            }
            if (!login(fMBaseResponse)) {
                return false;
            }
            this.isLogin = true;
            return true;
        }
        LogX.w("FMServiceImpl, checkNetAndIslogin no network");
        fMBaseResponse.resultCode = -2;
        return false;
    }

    private int changeException2ErrorId(String str, BusinessException businessException) {
        LogX.i("==========================================");
        LogX.i("| FMServiceImpl, methodName =" + str + " getErrorMsg = " + businessException.getErrorMsg() + " getDesc " + businessException.getErrorMsg().getDesc() + " getId " + businessException.getErrorMsg().getId() + "|");
        LogX.i("==========================================");
        try {
            return Integer.parseInt(businessException.getErrorMsg().getId());
        } catch (NumberFormatException e) {
            LogX.e("| FMServiceImpl, NumberFormatException |");
            LogX.i("==========================================");
            return -1;
        }
    }

    private EnumCardAppType getCardAppType(String str) {
        if (str == null || str.equals("")) {
            LogX.i("getCardAppType enter aid is null ");
            return null;
        }
        LogX.i("getCardAppType aid : " + str);
        if (str.equals(Constant.SH_CARD_AID)) {
            return EnumCardAppType.CARD_APP_TYPE_SH;
        }
        if (str.equals(Constant.LNT_CARD_AID)) {
            return EnumCardAppType.CARD_APP_TYPE_LNT;
        }
        return null;
    }

    public QueryProductsResponse queryProducts(QueryProductsRequest queryProductsRequest) {
        LogX.i("FMServiceImpl, queryProducts enter");
        FMBaseResponse queryProductsResponse = new QueryProductsResponse();
        if (!judgeQueryProductsRequestValid(queryProductsRequest)) {
            LogX.e("FMServiceImpl, queryProducts illegal params");
        } else if (checkNetAndIslogin(queryProductsResponse)) {
            String deviceModel = queryProductsRequest.getDeviceModel();
            String aid = queryProductsRequest.getAid();
            String city4Current = queryProductsRequest.getCity4Current();
            EnumCardAppType cardAppType = getCardAppType(aid);
            LogX.i("FMServiceImpl, queryProducts deviceModel : " + deviceModel + " ; aid : " + aid + " ; cityCode : " + city4Current);
            List queryProducts;
            try {
                queryProducts = this.mNfcosClientManager.queryProducts(deviceModel, cardAppType, city4Current, city4Current);
                if (queryProducts != null) {
                    queryProductsResponse.resultCode = 0;
                    queryProductsResponse.setList(queryProducts);
                } else {
                    queryProductsResponse.resultCode = -1;
                }
            } catch (BusinessException e) {
                LogX.e("FMServiceImpl, BusinessException : " + e.getMessage());
                int changeException2ErrorId = changeException2ErrorId("queryBusinessOrder", e);
                if (changeException2ErrorId == 1009 || changeException2ErrorId == INVALID_SESSION) {
                    this.isLogin = false;
                    if (login(queryProductsResponse)) {
                        try {
                            queryProducts = this.mNfcosClientManager.queryProducts(deviceModel, cardAppType, city4Current, city4Current);
                            if (queryProducts != null) {
                                queryProductsResponse.resultCode = 0;
                                queryProductsResponse.setList(queryProducts);
                            } else {
                                queryProductsResponse.resultCode = -1;
                            }
                        } catch (BusinessException e2) {
                            if (changeException2ErrorId("queryBusinessOrder", e2) == INVALID_SESSION) {
                                queryProductsResponse.resultCode = -2;
                            }
                        }
                    }
                }
            }
        }
        return queryProductsResponse;
    }

    private boolean judgeQueryProductsRequestValid(QueryProductsRequest queryProductsRequest) {
        if (queryProductsRequest == null || queryProductsRequest.getAid() == null || queryProductsRequest.getDeviceModel() == null) {
            return false;
        }
        return true;
    }

    public MainOrderResponse applyIssueOrderByproduct(ApplyIssueOrderRequest applyIssueOrderRequest, int i) {
        LogX.i("FMServiceImpl, applyIssueOrderByproduct enter");
        FMBaseResponse mainOrderResponse = new MainOrderResponse();
        if (!judgeApplyIssueOrderRequestValid(applyIssueOrderRequest)) {
            LogX.e("FMServiceImpl, applyIssueOrderByproduct illegal params");
            return mainOrderResponse;
        } else if (!checkNetAndIslogin(mainOrderResponse)) {
            return mainOrderResponse;
        } else {
            String productCode = applyIssueOrderRequest.getProductCode();
            String module = applyIssueOrderRequest.getModule();
            byte[] seid = applyIssueOrderRequest.getSeid();
            byte[] actCode = applyIssueOrderRequest.getActCode();
            EnumCardAppType cardAppType = getCardAppType(applyIssueOrderRequest.getAid());
            MainOrder applyIssueByProduct;
            try {
                LogX.i("FMServiceImpl, applyIssueOrderByproduct module=" + module + " product " + productCode + " ; actCode : " + applyIssueOrderRequest.getActCode() + " seid " + applyIssueOrderRequest.getSeid());
                applyIssueByProduct = this.mNfcosClientManager.applyIssueByProduct(cardAppType, productCode, i, seid, module, actCode);
                mainOrderResponse.FMCode = 0;
                mainOrderResponse.resultCode = 0;
                mainOrderResponse.order = NfcParserUtil.parseMainOrder2NfcType(applyIssueByProduct);
            } catch (BusinessException e) {
                int changeException2ErrorId = changeException2ErrorId("applyIssueOrderByproduct", e);
                if (changeException2ErrorId == 1103) {
                    mainOrderResponse.resultCode = 1;
                } else if (changeException2ErrorId == 1009 || changeException2ErrorId == INVALID_SESSION || changeException2ErrorId == TERMINALS_LINK_FAILURE) {
                    this.isLogin = false;
                    if (!login(mainOrderResponse)) {
                        return mainOrderResponse;
                    }
                    this.isLogin = true;
                    try {
                        applyIssueByProduct = this.mNfcosClientManager.applyIssueByProduct(cardAppType, productCode, i, seid, module, actCode);
                        mainOrderResponse.FMCode = 0;
                        mainOrderResponse.resultCode = 0;
                        mainOrderResponse.order = NfcParserUtil.parseMainOrder2NfcType(applyIssueByProduct);
                    } catch (BusinessException e2) {
                        changeException2ErrorId = changeException2ErrorId("applyIssueOrderByproduct", e2);
                        if (changeException2ErrorId == 1103) {
                            mainOrderResponse.resultCode = 1;
                        } else if (changeException2ErrorId == INVALID_SESSION) {
                            mainOrderResponse.resultCode = -2;
                        }
                    }
                }
            }
            return mainOrderResponse;
        }
    }
}
