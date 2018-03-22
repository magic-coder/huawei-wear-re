package com.huawei.nfc.openapi.impl;

import android.content.Context;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.CreateOrDeleteOpenSSDTsmOperator;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.QueryDicsRequset;
import com.huawei.nfc.carrera.server.card.response.DicItem;
import com.huawei.nfc.carrera.server.card.response.QueryDicsResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.PackageSignatureUtil;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.openapi.HwNFCOpenApi;
import java.security.AccessControlException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class HwNFCOpenApiImpl implements HwNFCOpenApi {
    private static final String DIC_NAME = "apk.signature";
    private static final byte[] SYNC_CLS_LOCK = new byte[0];
    private static HwNFCOpenApiImpl sInstance;
    private final byte[] SYNC_OBJ_LOCK = new byte[0];
    private final ArrayList<String> mAuthorizedCallers = new ArrayList();
    private final Context mContext;

    private HwNFCOpenApiImpl(Context context) {
        this.mContext = context;
    }

    public static HwNFCOpenApiImpl getInstance(Context context) {
        HwNFCOpenApiImpl hwNFCOpenApiImpl;
        synchronized (SYNC_CLS_LOCK) {
            if (sInstance == null) {
                sInstance = new HwNFCOpenApiImpl(context);
            }
            hwNFCOpenApiImpl = sInstance;
        }
        return hwNFCOpenApiImpl;
    }

    public int createSSD(String str, String str2, String str3, String str4, String str5) {
        return handleOperations(str, str2, str3, str4, str5, HwNFCOpenApi.OPERATOR_TYPE_CREATE_SSD);
    }

    public int deleteSSD(String str, String str2, String str3, String str4, String str5) {
        return handleOperations(str, str2, str3, str4, str5, HwNFCOpenApi.OPERATOR_TYPE_DELETE_SSD);
    }

    public String getCplc(String str) {
        if (StringUtil.isEmpty(str, true) || !checkCaller(str)) {
            LogX.w("getCplc checkCaller failed.");
            return null;
        }
        String queryCplc;
        synchronized (this.SYNC_OBJ_LOCK) {
            queryCplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
        }
        return queryCplc;
    }

    private int handleOperations(String str, String str2, String str3, String str4, String str5, String str6) {
        if (StringUtil.isEmpty(str, true) || StringUtil.isEmpty(str2, true) || StringUtil.isEmpty(str3, true) || StringUtil.isEmpty(str4, true) || StringUtil.isEmpty(str5, true)) {
            LogX.w("createSSD failed. params is empty.[pkg,spID,ssdaid,sign,timeStamp] = [ " + str + "," + str2 + "," + str3 + "," + str4 + "," + str5 + "]");
            return 1;
        } else if (checkCaller(str)) {
            int handleOperatorResult;
            synchronized (this.SYNC_OBJ_LOCK) {
                handleOperatorResult = handleOperatorResult(new CreateOrDeleteOpenSSDTsmOperator(this.mContext, str3, str2, str4, str5, str6).excute());
            }
            return handleOperatorResult;
        } else {
            LogX.w("operateSSD checkCaller  failed");
            return 2;
        }
    }

    private int handleOperatorResult(int i) {
        switch (i) {
            case -99:
                return -99;
            case -2:
                return 4;
            case -1:
                return 3;
            case 0:
                return 0;
            default:
                LogX.w("HwNFCOpenApiImpl operate ssd failed. tsm error. result : " + i);
                return 5;
        }
    }

    private boolean checkCaller(String str) {
        if (this.mAuthorizedCallers.contains(str)) {
            LogX.d("operateSSD checkCaller success end");
            return true;
        }
        QueryDicsRequset queryDicsRequset = new QueryDicsRequset();
        queryDicsRequset.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        queryDicsRequset.setRsaKeyIndex(-1);
        queryDicsRequset.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        queryDicsRequset.setItemName(str);
        queryDicsRequset.setDicName(DIC_NAME);
        QueryDicsResponse queryDics = ServerServiceFactory.createCardServerApi(this.mContext).queryDics(queryDicsRequset);
        if (queryDics == null || queryDics.returnCode != 0) {
            Object obj;
            StringBuilder append = new StringBuilder().append("operateSSD checkCaller failed. query server failed. retCode = ");
            if (queryDics == null) {
                obj = "response is null";
            } else {
                obj = Integer.valueOf(queryDics.returnCode);
            }
            LogX.w(append.append(obj).toString());
            return false;
        } else if (queryDics.dicItems.size() <= 0) {
            LogX.w("operateSSD checkCaller failed. dicItems size <= 0.");
            return false;
        } else {
            try {
                List<String> installedAppHashList = PackageSignatureUtil.getInstalledAppHashList(this.mContext, str);
                if (installedAppHashList != null && installedAppHashList.size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String append2 : installedAppHashList) {
                        stringBuilder.append(append2);
                    }
                    String stringBuilder2 = stringBuilder.toString();
                    Iterator it = queryDics.dicItems.iterator();
                    while (it.hasNext()) {
                        DicItem dicItem = (DicItem) it.next();
                        if (str.equals(dicItem.getParent()) && stringBuilder2.equals(dicItem.getValue())) {
                            this.mAuthorizedCallers.add(str);
                            LogX.d("operateSSD checkCaller success end");
                            return true;
                        }
                    }
                }
                LogX.w("checkCaller failed. The caller pkg is not allowed. pkg = " + str);
                return false;
            } catch (AccessControlException e) {
                LogX.w("HwNFCOpenApiImpl checkCaller failed. get app hash AccessControlException. pkg : " + str);
                return false;
            } catch (CertificateException e2) {
                LogX.w("HwNFCOpenApiImpl checkCaller failed. get app hash CertificateException. pkg : " + str);
                return false;
            } catch (NoSuchAlgorithmException e3) {
                LogX.w("HwNFCOpenApiImpl checkCaller failed. get app hash NoSuchAlgorithmException. pkg : " + str);
                return false;
            }
        }
    }

    public String issueCard(String str, Map<String, String> map) {
        return null;
    }

    public int eSEInfoSync(String str, String str2, String str3, String str4) {
        return 0;
    }

    public String getCplcForTransit(String str) {
        return null;
    }
}
