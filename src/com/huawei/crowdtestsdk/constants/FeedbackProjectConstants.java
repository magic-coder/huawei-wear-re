package com.huawei.crowdtestsdk.constants;

import android.net.Uri;
import android.provider.BaseColumns;

public class FeedbackProjectConstants implements BaseColumns {
    public static final String COLUMN_NAME_DATE = "date";
    public static final int COLUMN_NAME_DATE_INDEX = 5;
    public static final String COLUMN_NAME_DEFAULT_VERSION = "version_default";
    public static final String COLUMN_NAME_DEVICE = "device";
    public static final int COLUMN_NAME_DEVICE_INDEX = 7;
    public static final String COLUMN_NAME_GROUP_ID = "group_id";
    public static final int COLUMN_NAME_GROUP_ID_INDEX = 8;
    public static final String COLUMN_NAME_GROUP_MEMBER = "group_member";
    public static final int COLUMN_NAME_GROUP_MEMBER_INDEX = 9;
    public static final String COLUMN_NAME_PRODUCT_TYPE = "product_type";
    public static final int COLUMN_NAME_PRODUCT_TYPE_INDEX = 10;
    public static final String COLUMN_NAME_PROJECT_COUNT = "total_issue_count";
    public static final int COLUMN_NAME_PROJECT_COUNT_INDEX = 3;
    public static final String COLUMN_NAME_PROJECT_ID = "project_id";
    public static final int COLUMN_NAME_PROJECT_ID_INDEX = 1;
    public static final String COLUMN_NAME_PROJECT_NAME = "project_name";
    public static final int COLUMN_NAME_PROJECT_NAME_INDEX = 2;
    public static final String COLUMN_NAME_PROJECT_UNHANDLE_COUNT = "total_unhandle_issue_count";
    public static final int COLUMN_NAME_PROJECT_UNHANDLE_COUNT_INDEX = 4;
    public static final String COLUMN_NAME_RESERVE1 = "reserve1";
    public static final int COLUMN_NAME_RESERVE1_INDEX = 11;
    public static final String COLUMN_NAME_RESERVE2 = "reserve2";
    public static final int COLUMN_NAME_RESERVE2_INDEX = 12;
    public static final String COLUMN_NAME_RESERVE3 = "reserve3";
    public static final int COLUMN_NAME_RESERVE3_INDEX = 13;
    public static final String COLUMN_NAME_VERSION_LIST = "version_list";
    public static final int COLUMN_NAME_VERSION_LIST_INDEX = 6;
    public static final Uri CONTENT_ID_URI_BASE = Uri.parse("content://com.huawei.crowdtestsdk/projects/");
    public static final Uri CONTENT_URI_PROJECT = Uri.parse("content://com.huawei.crowdtestsdk/projects");
    public static final String DEFAULT_SORT_ORDER = "_id ASC";
    public static final int LOG_ID_PATH_POSITION = 1;
    private static final String PATH_PROJECT_RECORD = "/projects";
    private static final String PATH_PROJECT_RECORD_ID = "/projects/";
    public static final String TABLE_NAME = "feedback_project";
    public static final Object lock = new Object();

    private FeedbackProjectConstants() {
    }
}
