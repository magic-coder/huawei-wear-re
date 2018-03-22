package com.snowballtech.business.user.task;

import android.content.Context;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.snowballtech.business.bean.CardAids;
import com.snowballtech.business.bean.CardBaseContainerSe;
import com.snowballtech.business.bean.CardBaseSe;
import com.snowballtech.business.constant.CacheKey;
import com.snowballtech.business.constant.Constant;
import com.snowballtech.business.constant.RequestKey;
import com.snowballtech.business.inner.BusinessCardActivation;
import com.snowballtech.business.inner.BusinessCardsStatus;
import com.snowballtech.business.util.CardStatuCacheUtils;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.business.util.RequestSNBSeviceUtil;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.PreferencesUtil;
import com.snowballtech.common.util.ValueUtil;
import java.util.List;

public class WTaskCardListQuery implements IWalletServiceTask {
    private String TAG = Constant.LOG_FLAG_CARD_LIST_QUERY;
    private BusinessCardActivation businessCardActivation = new BusinessCardActivation(0);
    private CommonUtils commonUtils = CommonUtils.getInstance();
    private RequestSNBSeviceUtil requestSNBSeviceUtil;

    public String executeTask(TaskParam taskParam) throws SnowballException {
        LogUtil.log(this.TAG, "executeTask  start");
        long currentTimeMillis = System.currentTimeMillis();
        TaskResult taskResult = new TaskResult();
        LogUtil.log(this.TAG, this.TAG + " executeTask  " + LogUtil.CARD_INFO + " CardsListQuery start");
        taskResult.setResult_code("0");
        taskResult.setResult_msg(LightCloudConstants.RESPONSE_RESULT_SUCCESS);
        if (this.commonUtils.isNeedAccessServer(taskParam.getContext(), CacheKey.WS_SDK_CARD_LIST_QUERY_WSPROVIDER_SYN_TIME, new long[0])) {
            getDataFromServer(taskParam);
        }
        CardBaseContainerSe cardBaseContainerSe = new CardBaseContainerSe();
        List fetchAppletsFromSeAndServer = fetchAppletsFromSeAndServer(taskParam.getContext());
        if (fetchAppletsFromSeAndServer == null || fetchAppletsFromSeAndServer.size() <= 0) {
            taskResult.setResult_msg("没有数据");
            LogUtil.log(this.TAG, this.TAG + HwAccountConstants.BLANK + LogUtil.CARD_INFO + "  se no exist apps ");
        } else {
            cardBaseContainerSe.setCard_list(fetchAppletsFromSeAndServer);
            taskResult.setData(JsonUtil.getInstance().serializeObject(cardBaseContainerSe, new boolean[0]));
        }
        String serializeObject = JsonUtil.getInstance().serializeObject(taskResult, new boolean[0]);
        LogUtil.log(this.TAG, this.TAG + " executeTask  end  " + LogUtil.RESPONSE_RESULT + "  result =" + serializeObject + " costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
        return serializeObject;
    }

    public void getDataFromServer(TaskParam taskParam) throws SnowballException {
        try {
            LogUtil.log(this.TAG, " CardInfo_getDataFromServer begin.");
            if (this.requestSNBSeviceUtil == null) {
                this.requestSNBSeviceUtil = new RequestSNBSeviceUtil(taskParam.getContext());
            }
            TaskResult postService = this.requestSNBSeviceUtil.postService(RequestKey.KEY_CARDLISTQUERY, taskParam.getInputParam(), CardAids.class);
            LogUtil.log(this.TAG, " CardInfo_getDataFromServer end. result=" + postService.getResult_code());
            if (postService != null && postService.getResult_code().equals("0") && ValueUtil.parseInt(((CardAids) postService.getData()).getResp_code()) == 0) {
                PreferencesUtil.getInstance().keepField(CacheKey.WS_SDK_CARD_LIST_QUERY_WSPROVIDER_SYN_TIME, System.currentTimeMillis() + "", taskParam.getContext());
                CardAids cardAids = (CardAids) postService.getData();
                LogUtil.log(this.TAG, " CardInfo_getDataFromServer success,use server hideAids and proxyAids.");
                if (!ValueUtil.isEmpty(cardAids.getHide_aids())) {
                    PreferencesUtil.getInstance().keepField(CacheKey.WS_SDK_HIDE_AIDS, cardAids.getHide_aids(), taskParam.getContext());
                }
                if (!ValueUtil.isEmpty(cardAids.getProxy_aids())) {
                    PreferencesUtil.getInstance().keepField(CacheKey.WS_SDK_PROXY_AIDS, cardAids.getProxy_aids(), taskParam.getContext());
                }
            }
        } catch (Throwable e) {
            throw new SnowballException(e);
        }
    }

    private List<CardBaseSe> fetchAppletsFromSeAndServer(Context context) throws SnowballException {
        try {
            LogUtil.log(this.TAG, " CardInfo_cardListQuery fetchAppletsFromSeAndServer start");
            long currentTimeMillis = System.currentTimeMillis();
            List<CardBaseSe> synchronizedCardsStatusFromServer = new BusinessCardsStatus(0).synchronizedCardsStatusFromServer(context, false);
            if (synchronizedCardsStatusFromServer == null || synchronizedCardsStatusFromServer.size() <= 0) {
                LogUtil.log(this.TAG, " CardInfo_cardListQuery fetchAppletsFromSe no apps from se and server ");
            } else {
                for (CardBaseSe cardBaseSe : synchronizedCardsStatusFromServer) {
                    int parseInt;
                    if (ValueUtil.parseInt(cardBaseSe.getInstall_status()) == 2) {
                        parseInt = Integer.parseInt(this.businessCardActivation.fetchActivation(context, cardBaseSe.getInstance_id()));
                    } else {
                        parseInt = 0;
                    }
                    cardBaseSe.setActivation_status(parseInt + "");
                    LogUtil.log(this.TAG, " CardInfo_cardListQuery fetchAppletsFromSe " + JsonUtil.getInstance().serializeObject(cardBaseSe, new boolean[0]));
                }
            }
            LogUtil.log(this.TAG, " CardInfo_cardListQuery fetchAppletsFromSe end,costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
            return synchronizedCardsStatusFromServer;
        } catch (Throwable e) {
            throw new SnowballException(e);
        }
    }

    public boolean isNeedNetWork(Context context) throws SnowballException {
        if (ValueUtil.isEmpty(CardStatuCacheUtils.getInstance().getCardCacheByString(context))) {
            return true;
        }
        return false;
    }
}
