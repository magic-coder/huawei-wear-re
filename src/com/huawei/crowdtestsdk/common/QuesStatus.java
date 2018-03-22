package com.huawei.crowdtestsdk.common;

public class QuesStatus {
    private static final String QUES_STATUS_CLOSE = "问题单关闭";
    private static final String QUES_STATUS_CLOSE_ENG = "question Close";
    private static final String QUES_STATUS_RESUBMIT = "问题单重新申请";
    private static final String QUES_STATUS_RESUBMIT_ENG = "reject question";
    private static final String QUES_STATUS_USER_HANDLER = "提单人处理";
    private static final String QUES_STATUS_USER_HANDLER_ENG = "bill of Lading Person Handling";

    public static boolean isResubmitStatus(String str) {
        if (str == null || (!str.equals(QUES_STATUS_RESUBMIT) && !str.equals(QUES_STATUS_RESUBMIT_ENG))) {
            return false;
        }
        return true;
    }

    public static boolean isUserHandleStatus(String str) {
        if (str == null || (!str.equals(QUES_STATUS_USER_HANDLER) && !str.equals(QUES_STATUS_USER_HANDLER_ENG))) {
            return false;
        }
        return true;
    }

    public static boolean isCloseStatus(String str) {
        if (str == null || (!str.equals(QUES_STATUS_CLOSE) && !str.equals(QUES_STATUS_CLOSE_ENG))) {
            return false;
        }
        return true;
    }
}
