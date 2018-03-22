package com.huawei.crowdtestsdk.history;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class IssueStatusConstants {
    public static final Map<String, String> issueCurrentStatusType = Collections.unmodifiableMap(issueCurrentStatusTypeMap);
    private static final Map<String, String> issueCurrentStatusTypeMap = new HashMap();
    public static final Map<String, String> issueStatueType = Collections.unmodifiableMap(issueStatueTypeMap);
    private static final Map<String, String> issueStatueTypeMap = new HashMap();

    static {
        issueStatueTypeMap.put("jalor.workflow.label.startStep", "创建问题单");
        issueStatueTypeMap.put("jalor.tbdts.label.organizersCompletionQuestion", "组织者补全问题单");
        issueStatueTypeMap.put("jalor.tbdts.label.testManagerApproval", "测试经理审核");
        issueStatueTypeMap.put("jalor.tbdts.label.manage.status.ok", "提单人确认");
        issueStatueTypeMap.put("jalor.tbdts.label.organizersReview", "组织者复审");
        issueStatueTypeMap.put("jalor.tbdts.label.re.question", "问题单重新申请");
        issueStatueTypeMap.put("jalor.tbdts.label.billOfLadingPersonHandling", "提单人处理");
        issueStatueTypeMap.put("jalor.common.label.close", "问题单关闭");
        issueCurrentStatusTypeMap.put("1", "创建问题单");
        issueCurrentStatusTypeMap.put("2", "组织者补全问题单");
        issueCurrentStatusTypeMap.put("3", "测试经理审核");
        issueCurrentStatusTypeMap.put("4", "提单人确认");
        issueCurrentStatusTypeMap.put("5", "提单人处理");
        issueCurrentStatusTypeMap.put("6", "问题单关闭");
    }
}
