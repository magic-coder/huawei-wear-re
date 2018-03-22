package com.huawei.crowdtestsdk.db;

import android.net.Uri;
import android.provider.BaseColumns;

public class FeedbackIssueConstants implements BaseColumns {
    public static final String COLUMN_NAME_CREATE_TIME = "create_time";
    public static final int COLUMN_NAME_CREATE_TIME_INDEX = 6;
    public static final String COLUMN_NAME_CURRENT_HANDLER = "current_handler";
    public static final int COLUMN_NAME_CURRENT_HANDLER_INDEX = 7;
    public static final String COLUMN_NAME_CURRENT_STATE = "issue_state";
    public static final int COLUMN_NAME_CURRENT_STATE_INDEX = 4;
    public static final String COLUMN_NAME_ISSUE_CREATER = "issue_creater";
    public static final int COLUMN_NAME_ISSUE_CREATER_INDEX = 8;
    public static final String COLUMN_NAME_ISSUE_DESC = "issue_description";
    public static final int COLUMN_NAME_ISSUE_DESC_INDEX = 5;
    public static final String COLUMN_NAME_ISSUE_ID = "issue_id";
    public static final int COLUMN_NAME_ISSUE_ID_INDEX = 2;
    public static final String COLUMN_NAME_PROJECT_ID = "project_id";
    public static final int COLUMN_NAME_PROJECT_ID_INDEX = 1;
    public static final String COLUMN_NAME_QUES_ID = "ques_id";
    public static final int COLUMN_NAME_QUES_ID_INDEX = 3;
    public static final String COLUMN_NAME_RESERVE1 = "reserve1";
    public static final int COLUMN_NAME_RESERVE1_INDEX = 9;
    public static final String COLUMN_NAME_RESERVE2 = "reserve2";
    public static final int COLUMN_NAME_RESERVE2_INDEX = 10;
    public static final String COLUMN_NAME_RESERVE3 = "reserve3";
    public static final int COLUMN_NAME_RESERVE3_INDEX = 10;
    public static final Uri CONTENT_ID_URI_BASE = Uri.parse("content://com.huawei.crowdtestsdk/issues/");
    public static final Uri CONTENT_URI_ISSUES = Uri.parse("content://com.huawei.crowdtestsdk/issues");
    public static final String DEFAULT_SORT_ORDER = "_id ASC";
    public static final int LOG_ID_PATH_POSITION = 1;
    private static final String PATH_PROJECT_RECORD = "/issues";
    private static final String PATH_PROJECT_RECORD_ID = "/issues/";
    public static final String TABLE_NAME = "feedback_issue";
    public static final Object lock = new Object();

    private FeedbackIssueConstants() {
    }
}
