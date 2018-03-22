package com.snowballtech.business.inner;

import android.content.Context;
import com.snowballtech.business.bean.AppletStatus;
import com.snowballtech.business.bean.CardBaseSe;
import com.snowballtech.business.bean.ResponseCardsStatus;
import com.snowballtech.business.constant.CacheKey;
import com.snowballtech.business.constant.RequestKey;
import com.snowballtech.business.util.ApduUtil;
import com.snowballtech.business.util.CardStatuCacheUtils;
import com.snowballtech.business.util.CommonUtils;
import com.snowballtech.business.util.ConfigUtil;
import com.snowballtech.business.util.RequestSNBSeviceUtil;
import com.snowballtech.common.bean.TaskResult;
import com.snowballtech.common.code.WSBaseMessageCode;
import com.snowballtech.common.constant.CodeMessage;
import com.snowballtech.common.env.IEnv;
import com.snowballtech.common.exception.SnowballException;
import com.snowballtech.common.log.LogUtil;
import com.snowballtech.common.util.DeviceUtil;
import com.snowballtech.common.util.JsonUtil;
import com.snowballtech.common.util.PreferencesUtil;
import com.snowballtech.common.util.ValueUtil;
import com.snowballtech.data.interaction.RequesterParam;
import com.unionpay.tsmservice.request.GetTransElementsRequestParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class BusinessCardsStatus {
    private String TAG = RequestKey.KEY_CARDSSTATUS;
    ApduUtil apduUtil = ApduUtil.getInstance();
    private List<CardBaseSe> cardBaseSes;
    CommonUtils commonUtils = CommonUtils.getInstance();
    private Context mContext;
    private int mediaType;
    private RequestSNBSeviceUtil requestSNBSeviceUtil;

    public BusinessCardsStatus(int i) {
        this.mediaType = i;
    }

    private void appletStatusAnduploadServer(ResponseCardsStatus responseCardsStatus) throws SnowballException {
        if (responseCardsStatus != null) {
            String need_upload = responseCardsStatus.getNeed_upload();
            boolean mergeInstatusSeAndServer = mergeInstatusSeAndServer(responseCardsStatus);
            LogUtil.log(this.TAG, " CardInfo_  merge the data with server and se ");
            if ((ValueUtil.isEmpty(need_upload) || !need_upload.equals("1")) && !mergeInstatusSeAndServer) {
                LogUtil.log(this.TAG, " CardInfo_ no need upload local status to server,the flag is not equal with 1 ");
                return;
            }
            if (responseCardsStatus.getAid_list() == null || responseCardsStatus.getAid_list().size() <= 0) {
                LogUtil.loge(this.TAG, " CardInfo_  no any data to server,give up ");
            } else {
                uploadCardsStatusToServer(responseCardsStatus);
                LogUtil.log(this.TAG, " CardInfo_  upload se and server data to server successfully ");
            }
            LogUtil.log(this.TAG, " CardInfo_ need upload local status to server,finished it ");
            return;
        }
        LogUtil.log(this.TAG, " CardInfo_ responseCardsStatus  is null ");
    }

    public List<CardBaseSe> synchronizedCardsStatusFromServer(Context context, boolean z) throws SnowballException {
        ResponseCardsStatus responseCardsStatus;
        ResponseCardsStatus responseCardsStatus2;
        this.mContext = context;
        long currentTimeMillis = System.currentTimeMillis();
        LogUtil.log(this.TAG, " CardInfo_getDataFromServerForInstallStatus begin.");
        IEnv instanceEnv = ConfigUtil.getInstance().instanceEnv();
        if (instanceEnv != null) {
            Map fetchEnv = instanceEnv.fetchEnv();
            if (fetchEnv == null || fetchEnv.size() <= 0) {
                LogUtil.loge(this.TAG, " envMap is null or size is 0");
                responseCardsStatus = null;
            } else if (ValueUtil.isEmpty((String) fetchEnv.get(WSBaseMessageCode.HEADER_SNBPS_IMEI))) {
                LogUtil.loge(this.TAG, " has envMap but uuid is null");
                responseCardsStatus = null;
            } else {
                responseCardsStatus = CardStatuCacheUtils.getInstance().getCardCache((String) fetchEnv.get(WSBaseMessageCode.HEADER_SNBPS_IMEI), context);
            }
            responseCardsStatus2 = responseCardsStatus;
        } else {
            responseCardsStatus2 = (ResponseCardsStatus) PreferencesUtil.getInstance().getEntity(CacheKey.WS_SDK_CARDS_STATUS_WSPROVIDER_KEY, ResponseCardsStatus.class, context);
        }
        String ws_version_code = responseCardsStatus2 == null ? "" : responseCardsStatus2.getWs_version_code();
        String str = DeviceUtil.getInstance().getVersionCode(this.mContext) + "";
        Object obj = (responseCardsStatus2 == null || z || !ws_version_code.equals(str)) ? 1 : null;
        if (obj != null) {
            LogUtil.log(this.TAG, " CardInfo_  need fetchCardsStatusFrom server current version_code:" + str + ",cache version_code:" + ws_version_code);
            responseCardsStatus = requestServerForCardsStatus();
            if (responseCardsStatus == null) {
                LogUtil.loge(this.TAG, " CardInfo_   fetchCardsStatusFrom server ,the data is null ");
                if (responseCardsStatus2 != null) {
                    LogUtil.log(this.TAG, " CardInfo_  the data of cardstatus with cache and se is not null, set the value to  responseCardsStatus ");
                    responseCardsStatus = responseCardsStatus2;
                } else {
                    LogUtil.log(this.TAG, " CardInfo_  the data of cardstatus with cache and se is null, keep responseCardsStatus with null");
                }
            } else if (responseCardsStatus.getAid_list() == null || responseCardsStatus.getAid_list().size() == 0) {
                LogUtil.log(this.TAG, " CardInfo_  the data of cardstatus with server don't have any data, so need override the  cache data with current server data ");
            }
            appletStatusAnduploadServer(responseCardsStatus);
            saveCache(responseCardsStatus, context);
            LogUtil.log(this.TAG, " CardInfo_  override the  cache data about install_status successfully ");
        } else {
            LogUtil.log(this.TAG, " CardInfo_ no need fetchCardsStatusFrom server,have fetched,so no access server and se ");
            responseCardsStatus = responseCardsStatus2;
        }
        LogUtil.log(this.TAG, " CardInfo_getDataFromServerForInstallStatus end. costtime:" + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
        if (responseCardsStatus != null) {
            return responseCardsStatus.getAid_list();
        }
        return null;
    }

    private void saveCache(ResponseCardsStatus responseCardsStatus, Context context) throws SnowballException {
        if (responseCardsStatus != null) {
            responseCardsStatus.setWs_version_code(DeviceUtil.getInstance().getVersionCode(this.mContext) + "");
            IEnv instanceEnv = ConfigUtil.getInstance().instanceEnv();
            if (instanceEnv != null) {
                Map fetchEnv = instanceEnv.fetchEnv();
                if (fetchEnv == null || fetchEnv.size() <= 0) {
                    LogUtil.loge(this.TAG, " envMap is null or size is 0");
                    return;
                } else if (ValueUtil.isEmpty((String) fetchEnv.get(WSBaseMessageCode.HEADER_SNBPS_IMEI))) {
                    LogUtil.loge(this.TAG, " has envMap but uid is null");
                    return;
                } else {
                    responseCardsStatus.setDevice_uid((String) fetchEnv.get(WSBaseMessageCode.HEADER_SNBPS_IMEI));
                    CardStatuCacheUtils.getInstance().saveCache(responseCardsStatus, context);
                    return;
                }
            }
            PreferencesUtil.getInstance().keepEntity(CacheKey.WS_SDK_CARDS_STATUS_WSPROVIDER_KEY, responseCardsStatus, context);
            LogUtil.log(this.TAG, " CardInfo_ save the data to cache ");
            return;
        }
        LogUtil.log(this.TAG, "saveCpLcCache, responseCardsStatus is null");
    }

    private ResponseCardsStatus requestServerForCardsStatus() throws SnowballException {
        ResponseCardsStatus responseCardsStatus;
        long currentTimeMillis = System.currentTimeMillis();
        TaskResult requestServerNew = requestServerNew(null);
        LogUtil.log(this.TAG, " CardInfo_requestServerForCardsStatus result=" + requestServerNew.getResult_code());
        if (requestServerNew == null || !requestServerNew.getResult_code().equals("0")) {
            LogUtil.loge(this.TAG, " CardInfo_ resultTsm  is null ");
            responseCardsStatus = null;
        } else {
            int parseInt;
            try {
                parseInt = ValueUtil.parseInt(((ResponseCardsStatus) requestServerNew.getData()).getResp_code());
            } catch (Exception e) {
                e.printStackTrace();
                parseInt = CodeMessage.EXCEPTION_ERROR;
            }
            if (parseInt == 0) {
                LogUtil.log(this.TAG, " CardInfo_ request server successfully ");
                responseCardsStatus = (ResponseCardsStatus) requestServerNew.getData();
                LogUtil.log(this.TAG, " CardInfo_synchronizedCardsStatusFromServer success.");
            } else {
                LogUtil.loge(this.TAG, " CardInfo_ request server failure ");
                responseCardsStatus = null;
            }
        }
        LogUtil.log(this.TAG, " CardInfo_ requestServerForCardsStatus end costtime:" + (System.currentTimeMillis() - currentTimeMillis));
        return responseCardsStatus;
    }

    public TaskResult<ResponseCardsStatus> requestServer(ResponseCardsStatus responseCardsStatus, RequesterParam requesterParam) throws SnowballException {
        long currentTimeMillis = System.currentTimeMillis();
        RequesterParam requesterParam2 = new RequesterParam();
        requesterParam2.setContext(requesterParam.getContext());
        requesterParam2.setHeaderParam(this.commonUtils.getProviderRequestHeader(requesterParam.getContext(), this.mediaType));
        requesterParam2.setRequestMethod(1);
        requesterParam2.setResponseType(5);
        requesterParam2.setRequestType(3);
        if (responseCardsStatus != null) {
            requesterParam2.setRequestObj(responseCardsStatus);
        } else {
            requesterParam2.setRequestObj("{}");
        }
        requesterParam2.setServerUrl(null);
        TaskResult requestData = ConfigUtil.getInstance().instanceRequester().requestData(requesterParam2, ResponseCardsStatus.class);
        LogUtil.log(this.TAG, " CardInfo_requestServer result=" + requestData.getResult_code() + ",costtime:" + (System.currentTimeMillis() - currentTimeMillis));
        TaskResult<ResponseCardsStatus> taskResult = new TaskResult();
        taskResult.setResult_code(requestData.getResult_code());
        taskResult.setResult_msg(requestData.getResult_msg());
        taskResult.setData(requestData.getData());
        return taskResult;
    }

    public TaskResult<ResponseCardsStatus> requestServerNew(ResponseCardsStatus responseCardsStatus) throws SnowballException {
        long currentTimeMillis = System.currentTimeMillis();
        String str = "{}";
        if (this.requestSNBSeviceUtil == null) {
            this.requestSNBSeviceUtil = new RequestSNBSeviceUtil(this.mContext);
        }
        if (responseCardsStatus != null) {
            str = JsonUtil.getInstance().serializeObject(responseCardsStatus, new boolean[0]);
        }
        LogUtil.log("start to postSerive cardsatatus");
        TaskResult postService = this.requestSNBSeviceUtil.postService(RequestKey.KEY_CARDSSTATUS, str, ResponseCardsStatus.class);
        LogUtil.log(this.TAG, " CardInfo_requestServer result=" + postService.getResult_code() + ",costtime:" + (System.currentTimeMillis() - currentTimeMillis));
        TaskResult<ResponseCardsStatus> taskResult = new TaskResult();
        taskResult.setResult_code(postService.getResult_code());
        taskResult.setResult_msg(postService.getResult_msg());
        taskResult.setData(postService.getData());
        return taskResult;
    }

    private ResponseCardsStatus uploadCardsStatusToServer(ResponseCardsStatus responseCardsStatus) throws SnowballException {
        long currentTimeMillis = System.currentTimeMillis();
        TaskResult requestServerNew = requestServerNew(responseCardsStatus);
        LogUtil.log(this.TAG, " CardInfo_uploadCardsStatusToServer result=" + requestServerNew.getResult_code());
        if (requestServerNew != null && requestServerNew.getResult_code().equals("0")) {
            int parseInt;
            try {
                parseInt = ValueUtil.parseInt(((ResponseCardsStatus) requestServerNew.getData()).getResp_code());
            } catch (Exception e) {
                e.printStackTrace();
                parseInt = CodeMessage.EXCEPTION_ERROR;
            }
            if (parseInt == 0) {
                LogUtil.log(this.TAG, " CardInfo_ request server successfully ");
                ResponseCardsStatus responseCardsStatus2 = (ResponseCardsStatus) requestServerNew.getData();
                LogUtil.log(this.TAG, " CardInfo_synchronizedCardsStatusFromServer success.");
                responseCardsStatus = responseCardsStatus2;
            } else {
                LogUtil.loge(this.TAG, " CardInfo_ request server failure ");
            }
        }
        LogUtil.log(this.TAG, " CardInfo_ uploadCardsStatusToServer end costtime: " + (System.currentTimeMillis() - currentTimeMillis));
        return responseCardsStatus;
    }

    private List<CardBaseSe> fetchCardbaseSesFromSe() throws SnowballException {
        List<CardBaseSe> arrayList = new ArrayList();
        List<AppletStatus> appletStatusForse = this.apduUtil.appletStatusForse(this.mContext);
        if (appletStatusForse == null || appletStatusForse.size() <= 0) {
            LogUtil.log(this.TAG, " CardInfo_  sestatus, null,maybe no loadinstall through tsm1.x ");
        } else {
            LogUtil.log(this.TAG, " CardInfo_  exist sestatus, maybe need upload local status to server ");
            for (AppletStatus appletStatus : appletStatusForse) {
                CommonUtils commonUtils = this.commonUtils;
                if (!CommonUtils.isHiden(this.mContext, appletStatus.getAid())) {
                    CardBaseSe cardBaseSe = new CardBaseSe();
                    cardBaseSe.setInstall_status("0");
                    if (appletStatus.getStatus().equals("0100") || appletStatus.getStatus().equals(GetTransElementsRequestParams.TRANS_TYPE_DOWNLOAD_APPLY)) {
                        cardBaseSe.setInstall_status("1");
                    } else if (appletStatus.getStatus().equals("0200")) {
                        cardBaseSe.setInstall_status("2");
                    }
                    cardBaseSe.setInstance_id(appletStatus.getAid());
                    arrayList.add(cardBaseSe);
                    LogUtil.log(this.TAG, " CardInfo_ aid:" + cardBaseSe.getInstance_id() + ",install_status:" + cardBaseSe.getInstall_status());
                }
            }
        }
        return arrayList;
    }

    private boolean mergeInstatusSeAndServer(ResponseCardsStatus responseCardsStatus) {
        boolean z = false;
        if (this.cardBaseSes != null && this.cardBaseSes.size() > 0) {
            if (responseCardsStatus == null) {
                responseCardsStatus = new ResponseCardsStatus();
            }
            List<CardBaseSe> aid_list = responseCardsStatus.getAid_list();
            if (aid_list == null) {
                responseCardsStatus.setAid_list(new ArrayList());
            }
            Collection arrayList = new ArrayList();
            boolean z2 = false;
            for (CardBaseSe cardBaseSe : this.cardBaseSes) {
                boolean z3;
                boolean z4;
                LogUtil.log(this.TAG, " CardInfo_  instance in se,instance_id:" + cardBaseSe.getInstance_id() + ",se status:" + cardBaseSe.getInstall_status());
                for (CardBaseSe cardBaseSe2 : aid_list) {
                    if (cardBaseSe2.getInstance_id().equals(cardBaseSe.getInstance_id())) {
                        if (ValueUtil.parseInt(cardBaseSe.getInstall_status()) > ValueUtil.parseInt(cardBaseSe2.getInstall_status())) {
                            LogUtil.log(this.TAG, " CardInfo_  need update the install_status using the status of se,instance_id:" + cardBaseSe.getInstance_id() + ",current status:" + cardBaseSe2.getInstall_status() + ",se status:" + cardBaseSe.getInstall_status());
                            cardBaseSe2.setInstall_status(cardBaseSe.getInstall_status());
                            z2 = true;
                        } else {
                            LogUtil.log(this.TAG, " CardInfo_  no need update the install_status using the status of se,instance_id:" + cardBaseSe.getInstance_id() + ",current status:" + cardBaseSe2.getInstall_status() + ",se status:" + cardBaseSe.getInstall_status());
                        }
                        z3 = z2;
                        z2 = true;
                        if (z2) {
                            arrayList.add(cardBaseSe);
                            z4 = true;
                        } else {
                            z4 = z3;
                        }
                        z2 = z4;
                    }
                }
                z3 = z2;
                z2 = false;
                if (z2) {
                    z4 = z3;
                } else {
                    arrayList.add(cardBaseSe);
                    z4 = true;
                }
                z2 = z4;
            }
            responseCardsStatus.getAid_list().addAll(arrayList);
            z = z2;
        }
        LogUtil.log(this.TAG, " CardInfo_  merge the data cardsstatus between se and cache or server ");
        return z;
    }
}
