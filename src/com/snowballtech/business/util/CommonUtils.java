package com.snowballtech.business.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.snowballtech.apdu.bean.SeConstants;
import com.snowballtech.business.bean.WSProviderBean;
import com.snowballtech.business.config.BusinessConfigs;
import com.snowballtech.business.constant.CacheKey;
import com.snowballtech.business.constant.CodeMessage;
import com.snowballtech.business.user.task.IWalletServiceTask;
import com.snowballtech.business.user.task.TaskParam;
import com.snowballtech.business.user.task.WTaskAppletManage;
import com.snowballtech.business.user.task.WTaskCardDelete;
import com.snowballtech.business.user.task.WTaskCardTopup;
import com.snowballtech.business.user.task.WTaskIssueCard;
import com.snowballtech.business.user.task.WTaskTansferRefund;
import com.snowballtech.common.code.WSBaseMessageCode;
import com.snowballtech.common.env.IEnv;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.DateTimeUtil;
import com.snowballtech.common.util.DeviceUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.PreferencesUtil;
import com.snowballtech.common.util.ValueUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonUtils {
    private static volatile CommonUtils singleton;
    private final String TAG = "CommonUtils";
    private ApduUtil apduUtil = ApduUtil.getInstance();

    private CommonUtils() {
    }

    public static CommonUtils getInstance() {
        if (singleton == null) {
            synchronized (CommonUtils.class) {
                if (singleton == null) {
                    singleton = new CommonUtils();
                }
            }
        }
        return singleton;
    }

    public int checkParam(TaskParam taskParam, IWalletServiceTask iWalletServiceTask, boolean z, boolean z2) throws SnowballException {
        if (ValueUtil.isEmpty(taskParam.getInputParam())) {
            throw new SnowballException(CodeMessage.BUSINESS_PARAM_SP_ID_NULL_MSG, (int) CodeMessage.BUSINESS_PARAM_SP_ID_NULL);
        }
        int validateEnvironment = getInstance().validateEnvironment(taskParam.getContext(), z2, z, taskParam.getInputParam());
        if (validateEnvironment == 0) {
            return getInstance().validateParam((WSProviderBean) JsonUtil.getInstance().deSerializeString(taskParam.getInputParam(), WSProviderBean.class), iWalletServiceTask);
        }
        switch (validateEnvironment) {
            case 400001:
                throw new SnowballException(com.snowballtech.common.constant.CodeMessage.ENVIRONMENT_NETWORK_DISABLED_MSG, 400001);
            case 400002:
                throw new SnowballException(CodeMessage.ENVIRONMENT_NFC_DISABLED_MSG, 400002);
            case CodeMessage.BUSINESS_PARAM_NULL /*410002*/:
                throw new SnowballException(CodeMessage.BUSINESS_PARAM_NULL_MSG, (int) CodeMessage.BUSINESS_PARAM_NULL);
            default:
                return validateEnvironment;
        }
    }

    public int validateEnvironment(Context context, boolean z, boolean z2, String str) {
        int validateEnvironment = validateEnvironment(context, z, z2);
        if (validateEnvironment == 0 && ValueUtil.isEmpty(str)) {
            return CodeMessage.BUSINESS_PARAM_NULL;
        }
        return validateEnvironment;
    }

    public int validateParam(WSProviderBean wSProviderBean, IWalletServiceTask iWalletServiceTask) throws SnowballException {
        if (wSProviderBean != null) {
            if (iWalletServiceTask instanceof WTaskAppletManage) {
                if (ValueUtil.isEmpty(wSProviderBean.getInstance_id())) {
                    throw new SnowballException(" appletManage instance_id参数为空", (int) CodeMessage.BUSINESS_PARAM_INSTANCEID_NULL);
                } else if (ValueUtil.isEmpty(wSProviderBean.getCategory()) && ValueUtil.isEmpty(wSProviderBean.getOperation())) {
                    throw new SnowballException(" appletManage category参数为空", (int) CodeMessage.BUSINESS_PARAM_OPERATION_NULL);
                }
            } else if (iWalletServiceTask instanceof WTaskCardDelete) {
                if (ValueUtil.isEmpty(wSProviderBean.getInstance_id())) {
                    throw new SnowballException(" appletManage instance_id参数为空", (int) CodeMessage.BUSINESS_PARAM_INSTANCEID_NULL);
                }
            } else if (iWalletServiceTask instanceof WTaskCardTopup) {
                if (ValueUtil.isEmpty(wSProviderBean.getInstance_id())) {
                    throw new SnowballException(" cardSwitch instance_id参数为空", (int) CodeMessage.BUSINESS_PARAM_INSTANCEID_NULL);
                } else if (ValueUtil.isEmpty(wSProviderBean.getToken())) {
                    throw new SnowballException(" cardTopup token参数为空", (int) CodeMessage.BUSINESS_PARAM_TOKEN_NULL);
                }
            } else if (iWalletServiceTask instanceof WTaskIssueCard) {
                if (ValueUtil.isEmpty(wSProviderBean.getInstance_id())) {
                    throw new SnowballException(" issueCard instance_id参数为空", (int) CodeMessage.BUSINESS_PARAM_INSTANCEID_NULL);
                } else if (ValueUtil.isEmpty(wSProviderBean.getCategory()) && ValueUtil.isEmpty(wSProviderBean.getOperation())) {
                    throw new SnowballException(" appletManage category参数为空", (int) CodeMessage.BUSINESS_PARAM_OPERATION_NULL);
                } else if (ValueUtil.isEmpty(wSProviderBean.getToken())) {
                    throw new SnowballException(" issueCard token参数为空", (int) CodeMessage.BUSINESS_PARAM_TOKEN_NULL);
                }
            } else if (!(iWalletServiceTask instanceof WTaskTansferRefund)) {
                LogUtil.log("CommonUtils", "validateParam  do NOT need check param for this API");
            } else if (ValueUtil.isEmpty(wSProviderBean.getInstance_id())) {
                throw new SnowballException(" consumeParse instance_id参数为空", (int) CodeMessage.BUSINESS_PARAM_INSTANCEID_NULL);
            } else if (ValueUtil.isEmpty(wSProviderBean.getSp_id())) {
                throw new SnowballException(" consumeParse sp_id  is null", (int) CodeMessage.BUSINESS_PARAM_SP_ID_NULL);
            }
            return 0;
        }
        throw new SnowballException(CodeMessage.BUSINESS_PARAM_VALID_MSG, (int) CodeMessage.BUSINESS_PARAM_VALID);
    }

    public int validateEnvironment(Context context, boolean z, boolean z2) {
        if (z && ConfigUtil.getInstance().isNeedCheckNfc() && DeviceUtil.getInstance().checkNFCDisable(context)) {
            LogUtil.loge("CommonUtils", " validateEnvironment Need network but network disabled");
            return 400002;
        } else if (!z2 || !ConfigUtil.getInstance().isNeedCheckNetwork() || !DeviceUtil.getInstance().checkNetWorkDisable(context)) {
            return 0;
        } else {
            LogUtil.loge("CommonUtils", " validateEnvironment Need Nfc but Nfc disabled");
            return 400001;
        }
    }

    public Map<String, String> getProviderRequestHeader(Context context, int i) throws SnowballException {
        Map<String, String> hashMap = new HashMap();
        hashMap.put(WSBaseMessageCode.HEADER_CPLC, this.apduUtil.getCPLC(context, i).getData());
        hashMap.put(WSBaseMessageCode.HEADER_DATE, DateTimeUtil.currentGMTTime());
        hashMap.put(WSBaseMessageCode.HEADER_SNBPS_APILEVEL, String.valueOf(VERSION.SDK_INT));
        IEnv instanceEnv = ConfigUtil.getInstance().instanceEnv();
        if (instanceEnv == null) {
            hashMap.put(WSBaseMessageCode.HEADER_SNBPS_IMEI, DeviceUtil.getInstance().getDeviceId(context));
            hashMap.put(WSBaseMessageCode.HEADER_SNBPS_MOBMOD, DeviceUtil.getInstance().getDeviceModel());
            hashMap.put(WSBaseMessageCode.HEADER_SNBPS_MOBVDR, DeviceUtil.getInstance().getDeviceVendor());
        } else {
            Map fetchEnv = instanceEnv.fetchEnv();
            if (fetchEnv != null && fetchEnv.size() > 0) {
                hashMap.putAll(fetchEnv);
            }
        }
        hashMap.put(WSBaseMessageCode.HEADER_SNBPS_ROMVSN, Build.DISPLAY);
        hashMap.put(WSBaseMessageCode.HEADER_SNBPS_MOBNUM, null);
        hashMap.put(WSBaseMessageCode.HEADER_SNBPS_WSVSN, BusinessConfigs.fetchSDKVersionCode() + "");
        hashMap.put("Content-Type", "application/json;charset=utf-8");
        return hashMap;
    }

    public static boolean isHiden(Context context, String str) {
        if (!ValueUtil.isEmpty(str)) {
            Object field = PreferencesUtil.getInstance().getField(CacheKey.WS_SDK_HIDE_AIDS, context);
            LogUtil.log("cardListQuery hide_aids result= " + field);
            List list = null;
            if (!TextUtils.isEmpty(field)) {
                list = Arrays.asList(field.split(","));
            }
            if (list == null) {
                list = new ArrayList();
            }
            if (r0.size() == 0) {
                r0.addAll(SeConstants.noNeedShowAids);
            }
            for (String equalsIgnoreCase : r0) {
                if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isNeedAccessServer(Context context, String str, long... jArr) {
        if (DeviceUtil.getInstance().checkNetWorkDisable(context)) {
            return false;
        }
        long parseLong = ValueUtil.parseLong(PreferencesUtil.getInstance().getField(str, context));
        if (parseLong == 0) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = 43200000;
        if (jArr != null && jArr.length > 0) {
            j = jArr[0];
        }
        if (currentTimeMillis - parseLong < j) {
            return false;
        }
        return true;
    }

    public boolean isCardBank(String str) {
        if (str.startsWith("A0000003330101")) {
            return true;
        }
        return false;
    }

    public boolean isMifare(String str) {
        if (str.equals(SeConstants.MF_AID) || str.equals(SeConstants.MF_AID1) || str.equals(SeConstants.MF_AID2) || str.equals(SeConstants.MF_AID3) || str.equals(SeConstants.MF_AID4)) {
            return true;
        }
        return false;
    }

    public boolean isNoBank(String str) {
        List arrayList = new ArrayList();
        arrayList.add(SeConstants.PSE_AID);
        arrayList.add(SeConstants.CQ_PSE_AID);
        arrayList.add(SeConstants.SZ_AID);
        arrayList.add(SeConstants.TF_AID);
        arrayList.add(SeConstants.WH_AID);
        arrayList.add(SeConstants.SZT_INSTANCE_AID);
        arrayList.add(SeConstants.WH_SUBWAY_AID);
        arrayList.add(SeConstants.BJ_AID);
        arrayList.add(SeConstants.MIFARE_VCM_INSTANCE_ID);
        arrayList.add(SeConstants.MIFARE_VSM_INSTANCE_ID);
        arrayList.add(SeConstants.LNT_AID);
        arrayList.add(SeConstants.CS_AID);
        arrayList.add(SeConstants.JL_AID);
        arrayList.add(SeConstants.XJ_AID);
        arrayList.add(SeConstants.HB_AID);
        arrayList.add(SeConstants.MF_AID);
        arrayList.add(SeConstants.MF_AID1);
        arrayList.add(SeConstants.MF_AID2);
        arrayList.add(SeConstants.MF_AID3);
        arrayList.add(SeConstants.MF_AID4);
        arrayList.add(SeConstants.ALI_HTC_MF_AID);
        arrayList.add(SeConstants.ALI_HTC_MF_AID1);
        arrayList.add(SeConstants.ALI_HTC_MF_AID2);
        arrayList.add(SeConstants.ALI_HTC_MF_AID3);
        arrayList.add(SeConstants.ALI_HTC_MF_AID4);
        arrayList.add(SeConstants.GREE_MF_AID);
        arrayList.add(SeConstants.GREE_MF_AID1);
        arrayList.add(SeConstants.GREE_MF_AID2);
        arrayList.add(SeConstants.GREE_MF_AID3);
        arrayList.add(SeConstants.GREE_MF_AID4);
        arrayList.add(SeConstants.GX_AID);
        if (arrayList.contains(str)) {
            return true;
        }
        return false;
    }

    public String getAmountFen(String str) {
        String str2 = "0";
        try {
            return Long.parseLong(str.replaceAll("^0*", ""), 16) + "";
        } catch (Exception e) {
            str2 = "0";
            LogUtil.loge("CommonUtils", " covert amount failure,because of  " + str + " is invalid ");
            return str2;
        }
    }

    public Map<String, String> parsetoken(String str) {
        Map<String, String> map = null;
        if (!ValueUtil.isEmpty(str) && str.length() > 0) {
            map = new HashMap();
            for (String split : str.split(SNBConstant.FILTER)) {
                String[] split2 = split.split("=");
                if (split2 != null && split2.length > 1) {
                    map.put(split2[0], split2[1]);
                }
            }
        }
        return map;
    }

    public String compositetoken(Map<String, String> map) {
        String str = null;
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                String str22;
                if (ValueUtil.isEmpty((String) map.get(str22))) {
                    str22 = str;
                } else if (str == null) {
                    str22 = str22 + "=" + ((String) map.get(str22)) + SNBConstant.FILTER;
                } else {
                    str22 = str + str22 + "=" + ((String) map.get(str22)) + SNBConstant.FILTER;
                }
                str = str22;
            }
        }
        if (ValueUtil.isEmpty(str) || str.length() <= 0) {
            return str;
        }
        return str.substring(0, str.length() - 1);
    }
}
