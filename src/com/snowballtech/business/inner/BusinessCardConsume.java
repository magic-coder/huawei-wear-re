package com.snowballtech.business.inner;

import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.snowballtech.apdu.bean.SeConstants;
import com.snowballtech.business.bean.HciData;
import com.snowballtech.business.bean.Tlv;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;

public class BusinessCardConsume extends BusinessCommon {
    private String TAG = Constant.LOG_FLAG_CONSUME_PARSE;

    public BusinessCardConsume(int i) {
        super(i);
    }

    public TaskResult<String> consumeParse(String str, String str2) {
        TaskResult<String> taskResult = new TaskResult();
        try {
            LogUtil.log(this.TAG, " begin parse data from bottomLayer ");
            String str3 = "0";
            String str4 = "2";
            String str5 = "0";
            String str6 = "156";
            String substring = str2.substring(0, 2);
            if (substring.equals("E2")) {
                LogUtil.log(this.TAG, " the transaction is pboc");
                if (str2.substring(12, 14).equals("40")) {
                    LogUtil.loge(this.TAG, "  current transaction successful ");
                    substring = str2.substring(58);
                    Tlv fetchTlvFirst = fetchTlvFirst("9F02", substring);
                    Tlv fetchTlvFirst2 = fetchTlvFirst("5F2A", substring);
                    Tlv fetchTlvFirst3 = fetchTlvFirst("9F79", substring);
                    if (fetchTlvFirst == null || fetchTlvFirst2 == null || fetchTlvFirst3 == null) {
                        LogUtil.loge(this.TAG, "  any tlv object is null");
                    } else {
                        str3 = Long.parseLong(fetchTlvFirst.getValue()) + "";
                        str6 = fetchTlvFirst2.getValue().replaceFirst("^0*", "");
                        str5 = (Long.parseLong(Long.parseLong(fetchTlvFirst3.getValue()) + "") - Long.parseLong(str3)) + "";
                    }
                } else {
                    LogUtil.loge(this.TAG, "  current transaction failure ");
                }
                String str7 = str4;
                str4 = str3;
                str3 = str7;
            } else if (substring.equals("01")) {
                LogUtil.log(this.TAG, " the transaction is bus");
                str4 = CommonUtils.getInstance().getAmountFen(str2.substring(2, 10));
                str3 = str2.substring(10, 12);
                LogUtil.log(this.TAG, " tlvdata transtype:" + str3);
                if (str3.equals("02") || str3.equals("01")) {
                    str3 = "1";
                } else if (str3.equals("05") || str3.equals("06") || str3.equals("09") || str3.equals("11")) {
                    str3 = "2";
                }
                str5 = str2.substring(38, 46);
                if (str == null || !str.equals(SeConstants.SZT_INSTANCE_AID)) {
                    str5 = CommonUtils.getInstance().getAmountFen(str5);
                } else {
                    str5 = (Long.parseLong(str5, 16) - 2147483648L) + "";
                }
            } else if (substring.equals(WipeAllCUPCardRequest.WIPE_ALL_CUP_CARD)) {
                LogUtil.log(this.TAG, " the transaction is szt");
                str4 = CommonUtils.getInstance().getAmountFen(str2.substring(6, 14));
                str3 = str2.substring(4, 6);
                LogUtil.log(this.TAG, " tlvdata transtype:" + str3);
                if (str3.equals("02") || str3.equals("01")) {
                    str3 = "1";
                } else if (str3.equals("05") || str3.equals("06") || str3.equals("09") || str3.equals("11")) {
                    str3 = "2";
                }
                str5 = (Long.parseLong(str2.substring(14, 22).substring(0, 8), 16) - 2147483648L) + "";
            } else {
                LogUtil.loge(this.TAG, "  eventType:" + substring + " NOT handled");
                return taskResult;
            }
            HciData hciData = new HciData();
            hciData.setInstance_id(str);
            hciData.setAmount(str4);
            hciData.setBalance(str5);
            hciData.setCurrency(str6);
            hciData.setTrans_type(str3);
            taskResult.setResult_code("0");
            taskResult.setResult_msg(LightCloudConstants.RESPONSE_RESULT_SUCCESS);
            taskResult.setData(JsonUtil.getInstance().serializeObject(hciData, new boolean[0]));
        } catch (Exception e) {
            taskResult.setResult_code("499999");
            taskResult.setResult_msg(e.getMessage());
            taskResult.setData(null);
        }
        return taskResult;
    }
}
