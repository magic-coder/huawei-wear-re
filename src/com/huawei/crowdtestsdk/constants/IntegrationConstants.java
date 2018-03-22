package com.huawei.crowdtestsdk.constants;

public class IntegrationConstants {
    public static final String ACTIVITY_ID = "ActivityId";
    public static final String BUG_TYPE = "BugType";
    public static final String BUILD_NUMBER = "BuildNumber";
    public static final String CONFIG_STRING = "ConfigString";
    public static final String DELETE_TYPE = "DeleteType";
    public static final String DEVICE_ID = "DeviceID";
    public static final String DEVICE_ID_ARRAY = "DeviceIDArray";
    public static final String FAKE_LOG_LIST = "FakeLogList";
    public static final String FEEDBACK_DESCRIPTION_DETAIL = "FeedbackDescriptionDetail";
    public static final String FEEDBACK_DESCRIPTION_SUMMERY = "FeedbackDescriptionSummery";
    public static final String FEEDBACK_PROBABILITY = "FeedbackProbability";
    public static final String FILE_MD5 = "FileMd5";
    public static final String FILE_PATH = "FilePath";
    public static final String FILE_PROGRESS = "Progress";
    public static final String FILE_STATUS = "FileStatus";
    public static final String HARDWARE_BUILD_NUMBER = "HardwareBuildNumber";
    public static final String IS_BACKGROUND_FEEDBACK = "IsBackgroundFeedback";
    public static final String MAC_ADDRESS = "MacAddress";
    public static final String MODEL_NUMBER = "ModelNumber";
    public static final int NONE = -1;
    public static final String OCCURRENCE_TIME = "OccurrenceTime";
    public static final String PRODUCT_TYPE = "ProductType";
    public static final String REAL_TIME_LOG_TYPE = "RealTimeLog";
    public static final String REQUEST_TYPE = "RequestType";
    public static final String RESPONSE_CODE = "ResponseCode";
    public static final String RESPONSE_STATUS_DESCRIPTION = "ResponseStatusDescription";
    public static final String TARGET_ID = "TargetID";
    public static final String TARGET_ID_ARRAY = "TargetIdArray";
    public static final String TBOX_BUILD_NUMBER = "TboxBuildNumber";
    public static final String TBOX_HARDWARE_BUILD_NUMBER = "TboxHardwareBuildNumber";
    public static final String UNIQUE_ID = "UniqueID";
    public static final String UPLOAD_NET_TYPE = "UploadNetType";

    public class ACTIONS {
        public static final String ACTION_COMMIT_DEVICE_INFO = "com.huawei.crowdtest.action.GET_BETA_INFO";
        public static final String ACTION_GET_DEVICE_INFO = "com.huawei.bone.action.GET_BETA_INFO";
        public static final String ACTION_GET_LOGRESPONSE = "com.huawei.crowdtest.GET_BETA_LOG";
        public static final String ACTION_GET_REALTIME_LOG_CONFIG = "com.huawei.crowdtest.GET_REALTIME_LOG_CONFIG";
        public static final String ACTION_START_ONEKEY_FEEDBACK = "com.huawei.crowdtest.START_ONEKEY_FEEDBACK";
        public static final String ACTION_START_REALTIME_LOG = "com.huawei.crowdtest.START_REALTIME_LOG";
        public static final String ACTION_STOP_REALTIME_LOG = "com.huawei.crowdtest.STOP_REALTIME_LOG";
        public static final String ACTION_SUBMIT_DEVICE_LOG = "com.huawei.bone.action.GET_BETA_LOG";
        public static final String BETA_PREMISSION = "com.huawei.bone.permission.BETA";
    }

    public class DELETE_TYPES {
        public static final int DELETE_TYPE_ALL = 0;
        public static final int DELETE_TYPE_MD5 = 1;
        public static final int DELETE_TYPE_UNIQUE_ID = 2;
    }

    public class FILE_STATUSES {
        public static final int ERROR = 2;
        public static final int IN_PROGRESS = 1;
        public static final int OK = 0;
    }

    public class NET_TYPES {
        public static final int UPLOAD_ON_2G_FLAGS = 4;
        public static final int UPLOAD_ON_3G_FLAGS = 2;
        public static final int UPLOAD_ON_ANY = 3;
        public static final int WIFI_UPLOAD_FLAGS = 1;
    }

    public class REAL_TIME_LOG_TYPES {
        public static final int CANCEL_REAL_TIME_LOG = 2;
        public static final int START_REAL_TIME_LOG = 0;
        public static final int STOP_REAL_TIME_LOG = 1;
    }

    public class REQUEST_TYPES {
        public static final int REQUEST_APR_LOG = 7;
        public static final int REQUEST_CANCEL_LOG = 6;
        public static final int REQUEST_DELETE_LOG = 5;
        public static final int REQUEST_EXCEPTION_LOG = 3;
        public static final int REQUEST_LOG_INFO = 1;
        public static final int REQUEST_PRODUCT_INFO = 0;
        public static final int REQUEST_REGISTER_PRODUCT = 4;
        public static final int REQUEST_UX_LOG = 2;
    }

    public class RESPONSE_CODES {
        public static final int CONFLICT = 409;
        public static final int ERROR = -1;
        public static final int NOT_AVAILABLE = 503;
        public static final int OK = 200;
        public static final int TIME_OUT = 408;
    }
}
