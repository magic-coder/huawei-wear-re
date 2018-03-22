package com.huawei.crowdtestsdk.db;

import android.net.Uri;
import android.provider.BaseColumns;

public class FeedbackHistoryConstants implements BaseColumns {
    public static final int COLUMN_INDEX_ACTIVITY_ID = 10;
    public static final int COLUMN_INDEX_ACTIVITY_NAME = 11;
    public static final int COLUMN_INDEX_AUDIO_ATTACH = 18;
    public static final int COLUMN_INDEX_CAMERA_ATTACH_LIST = 19;
    public static final int COLUMN_INDEX_CREATE_TYPE = 14;
    public static final int COLUMN_INDEX_DATE = 3;
    public static final int COLUMN_INDEX_DESCRIPTION = 2;
    public static final int COLUMN_INDEX_DEVICE = 12;
    public static final int COLUMN_INDEX_ID = 0;
    public static final int COLUMN_INDEX_ISDRAFT = 9;
    public static final int COLUMN_INDEX_ISSUE_MAKER_ID = 21;
    public static final int COLUMN_INDEX_LOG_PATH = 7;
    public static final int COLUMN_INDEX_LOG_PATH_ID = 6;
    public static final int COLUMN_INDEX_OCCURRENCE_TIME = 17;
    public static final int COLUMN_INDEX_ONLY_LOG_PATH = 8;
    public static final int COLUMN_INDEX_OTHER_ATTACH_LIST = 20;
    public static final int COLUMN_INDEX_PROBABILITY = 5;
    public static final int COLUMN_INDEX_RESERVE1 = 22;
    public static final int COLUMN_INDEX_RESERVE2 = 23;
    public static final int COLUMN_INDEX_RESERVE3 = 24;
    public static final int COLUMN_INDEX_SEND_STATUS = 16;
    public static final int COLUMN_INDEX_SEND_TYPE = 15;
    public static final int COLUMN_INDEX_STATE = 4;
    public static final int COLUMN_INDEX_TBDTS_NO = 13;
    public static final int COLUMN_INDEX_TYPE = 1;
    public static final String COLUMN_NAME_ACTIVITY_ID = "activity_id";
    public static final String COLUMN_NAME_ACTIVITY_NAME = "activity_name";
    public static final String COLUMN_NAME_AUDIO_ATTACH = "audio_attach";
    public static final String COLUMN_NAME_CAMERA_ATTACH_LIST = "camera_attach_list";
    public static final String COLUMN_NAME_CREATE_TYPE = "create_type";
    public static final String COLUMN_NAME_DATE = "date";
    public static final String COLUMN_NAME_DESCRIPTION = "description";
    public static final String COLUMN_NAME_DEVICE = "device";
    public static final String COLUMN_NAME_ISSUE_MAKER_ID = "issue_maker_id";
    public static final String COLUMN_NAME_IS_DRAFT = "is_draft";
    public static final String COLUMN_NAME_LOG_ID = "log_id";
    public static final String COLUMN_NAME_LOG_PATH = "log_path";
    public static final String COLUMN_NAME_OCCURRENCE_TIME = "occurrence_time";
    public static final String COLUMN_NAME_ONLY_LOG_PATH = "only_log_path";
    public static final String COLUMN_NAME_OTHER_ATTACH_LIST = "other_attach_list";
    public static final String COLUMN_NAME_PROBABILITY = "probability";
    public static final String COLUMN_NAME_RESERVE1 = "reserve1";
    public static final String COLUMN_NAME_RESERVE2 = "reserve2";
    public static final String COLUMN_NAME_RESERVE3 = "reserve3";
    public static final String COLUMN_NAME_SEND_STATUS = "send_status";
    public static final String COLUMN_NAME_SEND_TYPE = "send_type";
    public static final String COLUMN_NAME_STATE = "state";
    public static final String COLUMN_NAME_TBDTS_NO = "tbdts_no";
    public static final String COLUMN_NAME_TYPE = "type";
    public static final Uri CONTENT_ID_URI_BASE = Uri.parse("content://com.huawei.crowdtestsdk/logs/");
    public static final Uri CONTENT_URI_LOG = Uri.parse("content://com.huawei.crowdtestsdk/logs");
    public static final String DEFAULT_SORT_ORDER = "date DESC";
    public static final int LOG_ID_PATH_POSITION = 1;
    private static final String PATH_LOG_RECORD = "/logs";
    private static final String PATH_LOG_RECORD_ID = "/logs/";
    public static final String SENDING_STATUS_DONE = "done";
    public static final String SENDING_STATUS_PAUSED = "paused";
    public static final String SENDING_STATUS_SENDING = "sending";
    public static final String TABLE_NAME = "feedback_history";
    public static final Object lock = new Object();

    private FeedbackHistoryConstants() {
    }
}
