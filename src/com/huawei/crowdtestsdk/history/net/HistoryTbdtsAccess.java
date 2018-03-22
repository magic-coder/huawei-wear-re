package com.huawei.crowdtestsdk.history.net;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huawei.crowdtestsdk.bases.BetaQuestionItem;
import com.huawei.crowdtestsdk.bases.IQuestionItem;
import com.huawei.crowdtestsdk.bases.IssueItem;
import com.huawei.crowdtestsdk.bases.IssueStatusFlow;
import com.huawei.crowdtestsdk.bases.WorkFlowItem;
import com.huawei.crowdtestsdk.common.AppContext;
import com.huawei.crowdtestsdk.constants.HttpCommonAPi;
import com.huawei.crowdtestsdk.constants.UrlConstants;
import com.huawei.crowdtestsdk.db.FeedbackIssueConstants;
import com.huawei.crowdtestsdk.history.IssueWorkFlowItem;
import com.huawei.crowdtestsdk.httpaccess.HttpClient;
import com.huawei.crowdtestsdk.httpaccess.HttpResult;
import com.huawei.crowdtestsdk.net.HttpBetaAccess;
import com.huawei.hwid.core.datatype.SMSKeyInfo;
import com.huawei.uploadlog.p188c.C2511g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class HistoryTbdtsAccess extends HttpBetaAccess {
    private static HistoryTbdtsAccess instance = null;
    public Context context;

    public HistoryTbdtsAccess(Context context) {
        super(context);
        this.context = context;
    }

    public static HistoryTbdtsAccess getInstance() {
        if (instance == null) {
            instance = new HistoryTbdtsAccess(AppContext.getInstance().getApplicationContext());
        }
        return instance;
    }

    public List<IssueItem> getIssueListByProjectIDFromWeb(String str, int i) {
        C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.getIssueListByProjectIDFromWeb]is called!");
        List<IssueItem> arrayList = new ArrayList();
        String issueListByProjIdUrlPreFormatUrl = HttpCommonAPi.getIssueListByProjIdUrlPreFormatUrl();
        issueListByProjIdUrlPreFormatUrl = UrlConstants.urlPre + String.format(issueListByProjIdUrlPreFormatUrl, new Object[]{Integer.valueOf(15), Integer.valueOf(i), Integer.valueOf(0), str});
        C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.getIssueListByProjectIDFromWeb]url:" + issueListByProjIdUrlPreFormatUrl);
        HttpResult dataWithRetry = HttpClient.getInstance().getDataWithRetry(issueListByProjIdUrlPreFormatUrl);
        if (isResultCorrect(dataWithRetry)) {
            try {
                JSONObject jSONObject = new JSONObject(dataWithRetry.content);
                JSONArray jSONArray = new JSONArray(jSONObject.getString("result"));
                this.projectTotalIssueFromWebCountMap.put(str, jSONObject.getJSONObject("pageVO").getString("totalRows"));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    IssueItem issueItem = (IssueItem) new Gson().fromJson(jSONArray.getJSONObject(i2).toString(), IssueItem.class);
                    issueItem.setCreatedDate(formatCreateTime(issueItem.getCreatedDate()));
                    arrayList.add(issueItem);
                }
                return arrayList;
            } catch (Throwable e) {
                C2511g.m12482b("BETACLUB_SDK", "[HistoryTbdtsAccess.getIssueListByProjectIDFromWeb]JSONException:", e);
                return null;
            }
        }
        C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.getIssueListByProjectIDFromWeb]HttpResult==is Correct");
        return arrayList;
    }

    public static String formatCreateTime(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            return str.substring(0, str.lastIndexOf("T"));
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HistoryTbdtsAccess.formatCreateTime]Exception:", e);
            return "";
        }
    }

    public void writeIssueListByProjectIdToLocal(String str, List<IssueItem> list) {
        C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.writeIssueListByProjectIdToLocal] is start ");
        C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.writeIssueListByProjectIdToLocal] projectId is " + str);
        try {
            Uri uri = FeedbackIssueConstants.CONTENT_URI_ISSUES;
            String[] strArr = new String[]{str};
            C2511g.m12484d("BETACLUB_SDK", "[HistoryTbdtsAccess.writeIssueListByProjectIdToLocal]delete:" + FeedbackIssueConstants.CONTENT_URI_ISSUES + ", url is:" + this.context.getContentResolver().delete(uri, "project_id=?", strArr));
            for (IssueItem issueItem : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("project_id", str);
                contentValues.put(FeedbackIssueConstants.COLUMN_NAME_ISSUE_ID, issueItem.getTbdtsQuesNo());
                contentValues.put(FeedbackIssueConstants.COLUMN_NAME_QUES_ID, issueItem.getQuesId());
                contentValues.put(FeedbackIssueConstants.COLUMN_NAME_ISSUE_DESC, issueItem.getBrief());
                contentValues.put(FeedbackIssueConstants.COLUMN_NAME_CURRENT_STATE, issueItem.getQuesStatus());
                contentValues.put("create_time", issueItem.getCreatedDate());
                contentValues.put(FeedbackIssueConstants.COLUMN_NAME_CURRENT_HANDLER, issueItem.getNextProccess());
                contentValues.put(FeedbackIssueConstants.COLUMN_NAME_ISSUE_CREATER, issueItem.getUserAccount());
                this.context.getContentResolver().insert(uri, contentValues);
            }
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HistoryTbdtsAccess.writeIssueListByProjectIdToLocal]Exception:", e);
        }
        C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.writeIssueListByProjectIdToLocal] is end ");
    }

    public BetaQuestionItem getBetaQuestionByIssueNoForResubmit(String str) {
        HttpResult dataWithRetry = HttpClient.getInstance().getDataWithRetry(UrlConstants.urlPre + String.format(UrlConstants.getQuestionDetailUrl, new Object[]{str}));
        if (!isResultCorrect(dataWithRetry)) {
            return null;
        }
        String str2 = dataWithRetry.content;
        C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.getBetaQuestionByIssueNoForResubmit]Content:" + str2);
        try {
            return (BetaQuestionItem) new Gson().fromJson(str2, BetaQuestionItem.class);
        } catch (Throwable e) {
            C2511g.m12479a("BETACLUB_SDK", "[HistoryTbdtsAccess.getBetaQuestionByIssueNoForResubmit]Exception:", e);
            return null;
        }
    }

    public IssueItem getBetaQuestionByIssueNo(String str) {
        HttpResult dataWithRetry = HttpClient.getInstance().getDataWithRetry(UrlConstants.urlPre + String.format(UrlConstants.findMyBetaQuestionUrl, new Object[]{str}));
        if (!isResultCorrect(dataWithRetry)) {
            return null;
        }
        String str2 = dataWithRetry.content;
        C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.getBetaQuestionByIssueNo]Content:" + str2);
        try {
            IssueItem issueItem = (IssueItem) new Gson().fromJson(str2, IssueItem.class);
            if (issueItem.getUserAccount() != null) {
                return issueItem;
            }
            C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.getBetaQuestionByIssueNo]UserAccount is null!");
            return issueItem;
        } catch (Throwable e) {
            C2511g.m12479a("BETACLUB_SDK", "[HistoryTbdtsAccess.getBetaQuestionByIssueNo]Exception:", e);
            return null;
        }
    }

    public List<IssueWorkFlowItem> getIssueHistoryWorkFlowStatus(String str) {
        List<IssueWorkFlowItem> arrayList = new ArrayList();
        HttpResult dataWithRetry = HttpClient.getInstance().getDataWithRetry(UrlConstants.urlPre + String.format(UrlConstants.issueWorkFlowUrlPreFormat, new Object[]{str}));
        if (!isResultCorrect(dataWithRetry)) {
            return arrayList;
        }
        String str2 = dataWithRetry.content;
        C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.getIssueHistoryWorkFlowStatus]result content is : " + str2);
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add((IssueWorkFlowItem) new Gson().fromJson(((JSONObject) jSONArray.get(i)).toString(), IssueWorkFlowItem.class));
            }
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HistoryTbdtsAccess.getIssueHistoryWorkFlowStatus]JSONException:", e);
        }
        return arrayList;
    }

    public IssueStatusFlow getIssueCurrentWorkFlowStatus(String str) {
        String str2 = UrlConstants.urlPre + String.format(HttpCommonAPi.getIssueSearchDetailUrl(), new Object[]{str});
        C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.getIssueCurrentWorkFlowStatus]url->" + str2);
        HttpResult dataWithRetry = HttpClient.getInstance().getDataWithRetry(str2);
        if (!isResultCorrect(dataWithRetry)) {
            return null;
        }
        str2 = dataWithRetry.content;
        C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.getIssueCurrentWorkFlowStatus]content is : " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            str2 = jSONObject.getString("result");
            C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.getIssueCurrentWorkFlowStatus]result is " + jSONObject.getString("result"));
            jSONObject = new JSONArray(str2).getJSONObject(0);
            IssueStatusFlow issueStatusFlow = new IssueStatusFlow();
            issueStatusFlow.setStatus(jSONObject.getString("flowStatus"));
            if ("5".equalsIgnoreCase(issueStatusFlow.getStatus())) {
                issueStatusFlow.setAssignee(jSONObject.getString("userAccount"));
                C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.getIssueCurrentWorkFlowStatus]Assignee is " + issueStatusFlow.getAssignee());
            } else {
                issueStatusFlow.setAssignee(jSONObject.getString("nextProccess"));
            }
            issueStatusFlow.setAssignee(jSONObject.getString("curProccess"));
            issueStatusFlow.setCurrentFlow(true);
            issueStatusFlow.setUpdateTime(jSONObject.getString("lastUpdatedDate"));
            return issueStatusFlow;
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HistoryTbdtsAccess.getIssueCurrentWorkFlowStatus]JSONException:", e);
            return null;
        }
    }

    public BetaQuestionItem getBetaQuestionDetail(String str) {
        HttpResult dataWithRetry = HttpClient.getInstance().getDataWithRetry(UrlConstants.urlPre + String.format(UrlConstants.issueSearchDetailUrlOld, new Object[]{str}));
        if (!isResultCorrect(dataWithRetry)) {
            return null;
        }
        try {
            return (BetaQuestionItem) new Gson().fromJson(dataWithRetry.content, BetaQuestionItem.class);
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HistoryTbdtsAccess.getBetaQuestionDetail]Exception:", e);
            return null;
        }
    }

    public String updateBetaDealQuestion(BetaQuestionItem betaQuestionItem, boolean z) {
        try {
            Object makeWorkFlowVO;
            C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.updateBetaDealQuestion]Body:" + new Gson().toJson((Object) betaQuestionItem));
            JsonObject asJsonObject = new JsonParser().parse(new Gson().toJson((Object) betaQuestionItem)).getAsJsonObject();
            if (z) {
                makeWorkFlowVO = makeWorkFlowVO(betaQuestionItem, 0);
            } else {
                makeWorkFlowVO = makeWorkFlowVO(betaQuestionItem, 1);
            }
            String toJson = new Gson().toJson(makeWorkFlowVO);
            asJsonObject.add("workflowVO", new JsonParser().parse(toJson));
            asJsonObject.addProperty("userFormPostUrl", "services/tbdtsbeta/betaquestion/updateBetaDealQuestsionByQuesID");
            String str = UrlConstants.urlPre + UrlConstants.updateBetaDealQuestionByQuesIDUrl;
            Map hashMap = new HashMap();
            hashMap.put("systemHeaderConstants", toJson);
            HttpResult postDataWithRetryWithHwAccount = HttpClient.getInstance().postDataWithRetryWithHwAccount(str, asJsonObject.toString(), hashMap);
            if (postDataWithRetryWithHwAccount == null || !postDataWithRetryWithHwAccount.isResponseOK()) {
                return null;
            }
            return postDataWithRetryWithHwAccount.content;
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HistoryTbdtsAccess.updateBetaDealQuestion]Exception:", e);
            return null;
        }
    }

    public WorkFlowItem makeWorkFlowVO(IQuestionItem iQuestionItem, int i) {
        try {
            HttpResult dataWithRetry = HttpClient.getInstance().getDataWithRetry(UrlConstants.urlPre + String.format(UrlConstants.findActRuTaskInfoUrl, new Object[]{iQuestionItem.getTbdtsQuesNo()}));
            if (dataWithRetry == null || !dataWithRetry.isResponseOK()) {
                return null;
            }
            String asString = new JsonParser().parse(dataWithRetry.content).getAsJsonObject().get("id").getAsString();
            HttpResult dataWithRetry2 = HttpClient.getInstance().getDataWithRetry(UrlConstants.urlPre + String.format(UrlConstants.apkGetQuesWorkFlowInfoUrl, new Object[]{asString}));
            if (dataWithRetry2 == null || !dataWithRetry2.isResponseOK()) {
                return null;
            }
            WorkFlowItem workFlowItem = new WorkFlowItem();
            JsonObject asJsonObject = new JsonParser().parse(dataWithRetry2.content).getAsJsonObject();
            workFlowItem.setProcessInstanceId(asJsonObject.get("processInstanceId").getAsString());
            workFlowItem.setWorkflowToken(asJsonObject.get("workflowToken").getAsString());
            workFlowItem.setTaskId(asString);
            JsonArray asJsonArray = asJsonObject.getAsJsonArray("transitions");
            asJsonObject = asJsonObject.getAsJsonObject("processDefinitionVO");
            workFlowItem.setProcessDefinitionId(asJsonObject.get("id").getAsString());
            workFlowItem.setProcessDefinitionKey(asJsonObject.get(SMSKeyInfo.TAG_KEY).getAsString());
            workFlowItem.setSequenceFlow(asJsonArray.get(i).getAsJsonObject().get("id").getAsString());
            workFlowItem.setInternalRemark(iQuestionItem.getUserDealUltimateness());
            return workFlowItem;
        } catch (Throwable e) {
            C2511g.m12482b("BETACLUB_SDK", "[HistoryTbdtsAccess.makeWorkFlowVO]Exception:", e);
            return null;
        }
    }

    public String resubmitBetaQuestion(IQuestionItem iQuestionItem, int i) {
        try {
            C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.resubmitBetaQuestsion]Body:" + new Gson().toJson((Object) iQuestionItem));
            JsonObject asJsonObject = new JsonParser().parse(new Gson().toJson((Object) iQuestionItem)).getAsJsonObject();
            String toJson = new Gson().toJson(makeWorkFlowVO(iQuestionItem, i));
            asJsonObject.add("workflowVO", new JsonParser().parse(toJson));
            asJsonObject.addProperty("userFormPostUrl", "services/tbdtsbeta/betaquestion/updateRegisterQuestsion");
            String str = UrlConstants.urlPre + UrlConstants.updateRegisterQuestionUrl;
            Map hashMap = new HashMap();
            hashMap.put("systemHeaderConstants", toJson);
            HttpResult postDataWithRetryWithHwAccount = HttpClient.getInstance().postDataWithRetryWithHwAccount(str, asJsonObject.toString(), hashMap);
            if (postDataWithRetryWithHwAccount == null || !postDataWithRetryWithHwAccount.isResponseOK()) {
                return null;
            }
            return postDataWithRetryWithHwAccount.content;
        } catch (Throwable e) {
            C2511g.m12479a("BETACLUB_SDK", "[HistoryTbdtsAccess.resubmitBetaQuestsion]Exception:", e);
            return null;
        }
    }

    public String updateBetaQuestion(IQuestionItem iQuestionItem) {
        try {
            HttpResult postDataWithRetryWithHwAccount = HttpClient.getInstance().postDataWithRetryWithHwAccount(HttpCommonAPi.getUpdateMyBetaQuestionUrl(), new Gson().toJson((Object) iQuestionItem), null);
            C2511g.m12481b("BETACLUB_SDK", "[HistoryTbdtsAccess.updateBetaQuestion]issueItem->" + new Gson().toJson((Object) iQuestionItem));
            if (postDataWithRetryWithHwAccount == null || !postDataWithRetryWithHwAccount.isResponseOK()) {
                return null;
            }
            return postDataWithRetryWithHwAccount.content;
        } catch (Exception e) {
            return null;
        }
    }
}
