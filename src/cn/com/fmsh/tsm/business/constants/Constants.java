package cn.com.fmsh.tsm.business.constants;

public interface Constants {
    public static final String CODE_PROPERTIES_FILE = "/code.properties";
    public static final String DEFAULT_APP_NO = "00000000000000000000";
    public static final String DEFAULT_STATION_VERSION = "0";
    public static final String PROTOCOL_CONFIG_FILE = "/message.xml";
    public static final String SYSTEM_CONFIG_FILE = "/business.xml";
    public static final int TERMIANL_NUMBER_LENGTH = 32;

    public interface AppLock4Consume {
        public static final int lock = 1;
        public static final int unlock = 0;
    }

    public interface AppLock4Load {
        public static final int lock = 1;
        public static final int unlock = 0;
    }

    public interface AppManagerType {
        public static final byte CLEAN = (byte) 15;
        public static final byte INSTALL = (byte) 3;
        public static final byte ISSUER = (byte) 1;
        public static final byte PERSONLIZATION = (byte) 2;
        public static final byte QUERY_STATUS = (byte) 4;
    }

    public interface BillType {
        public static final int ALL = 0;
        public static final int CONFIRM_DOUBT = 2;
        public static final int DOUBT = 1;
    }

    public interface CardForm {
        public static final int IN_CARD = 2;
        public static final int OUT_CARD = 1;
    }

    public interface CardType {
        public static final byte CARD_SH = (byte) 1;
    }

    public interface Command {
        public static final byte[] LOAD_HEAD = new byte[]{Byte.MIN_VALUE, TagName.TERMINAL_BACK_QUESTION_FLAG};
        public static final byte[] LOAD_INITIALIZE_HEAD = new byte[]{Byte.MIN_VALUE, TagName.ORDER_BRIEF_INFO_LIST};
        public static final byte[] SELECT_0015;
        public static final byte[] SELECT_3F01;
        public static final byte[] UPDATE_VALID_DATE = new byte[]{(byte) 4, (byte) -42, TagName.PREDEPOSIT_TYPE, TagName.ORDER_INVOICE_STATUS, (byte) 8};

        static {
            r0 = new byte[7];
            SELECT_3F01 = r0;
            r0 = new byte[5];
            r0[1] = (byte) -80;
            r0[2] = TagName.PREDEPOSIT_TYPE;
            SELECT_0015 = r0;
        }
    }

    public interface Config {
        public static final String CONFIG_NAME_PREFIC = "business";
    }

    public interface LoginCode {
        public static final byte[] CANCEL_CONTRACT = new byte[]{(byte) 16, (byte) 16};
        public static final byte[] CONTRACTING = new byte[]{(byte) 16, (byte) 3};
        public static final byte[] CONTRACT_FAIL = new byte[]{(byte) 16, (byte) 4};
        public static final byte[] CONTRACT_OK = new byte[]{(byte) 16, (byte) 5};
        public static final byte[] FROZEN = new byte[]{(byte) 16, TagName.THIRD_PAY_NUMBER};
        public static final byte[] INFO_INCOMPLETE = new byte[]{(byte) 16, TagName.ORDER_TIME};
        public static final byte[] INVALID_PWD = new byte[]{(byte) 16, (byte) 1};
        public static final byte[] LOCKED = new byte[]{(byte) 16, (byte) 17};
        public static final byte[] LOGOUT = new byte[]{(byte) 16, (byte) 6};
        public static final byte[] PWD_OVERRUN = new byte[]{(byte) 16, TagName.ORDER_DATE};
        public static final byte[] REGISTER = new byte[]{(byte) 16, (byte) 7};
        public static final byte[] UNCONTRACT = new byte[]{(byte) 16, (byte) 8};
        public static final byte[] UNCONTRACT_USER = new byte[]{(byte) 16, (byte) 2};
        public static final byte[] UNREGISTER;

        static {
            byte[] bArr = new byte[2];
            bArr[0] = (byte) 16;
            UNREGISTER = bArr;
        }
    }

    public interface NetworkStatus {
        public static final int CONNECT_FAILURE = 2;
        public static final int NONE = 1;
        public static final int SUCCESS = 99;
    }

    public interface OrderSource {
        public static final int CHANNEL_MI = 32;
        public static final int CHANNEL_MOBILE = 21;
    }

    public interface PayChannel {
        public static final byte ONEKEY = (byte) 1;
        public static final byte SECURITY = (byte) 2;
        public static final byte UNIONPAY = (byte) 3;
    }

    public interface RechargeStatus {
        public static final int DOUBT = 2;
        public static final int FAILURE = 0;
        public static final int SUCCESS = 1;
    }

    public interface RespCodeonse4Platform {
        public static final byte[] CARD_REQUEST = new byte[]{TagName.SYSTEM_VERSION, (byte) 1};
        public static final byte[] SUCESS;

        static {
            byte[] bArr = new byte[2];
            bArr[0] = TagName.SYSTEM_VERSION;
            SUCESS = bArr;
        }
    }

    public interface Result4BusinessHandle {
        public static final int FAILURE = -1;
        public static final int SUCESS = 0;
    }

    public interface TagName {
        public static final byte ACTIVITIES = Byte.MIN_VALUE;
        public static final byte ACTIVITY = (byte) -127;
        public static final byte ACTIVITY_CODE = (byte) -125;
        public static final byte ACTIVITY_CODE_LIST = (byte) 51;
        public static final byte ACTIVITY_DEFINITION = (byte) -120;
        public static final byte ACTIVITY_END = (byte) -123;
        public static final byte ACTIVITY_INFO = (byte) 71;
        public static final byte ACTIVITY_NAME = (byte) -126;
        public static final byte ACTIVITY_REMAINDER = (byte) -121;
        public static final byte ACTIVITY_START = (byte) -124;
        public static final byte ACTIVITY_STATUS = (byte) -115;
        public static final byte ACTIVITY_TOTAL = (byte) -122;
        public static final byte APK_DOWNLOAD_URL = (byte) 28;
        public static final byte APK_SIZE = (byte) 48;
        public static final byte APK_UPDATE_FLAG = (byte) 45;
        public static final byte APP_AID = (byte) -77;
        public static final byte APP_MANAGE_OPEATE_TYPE = (byte) -69;
        public static final byte APP_TYPE = (byte) -78;
        public static final byte BUSINESS_HANDLE_RESULT = (byte) -75;
        public static final byte BUSINESS_ORDER = (byte) 26;
        public static final byte BUSINESS_ORDER_ID = (byte) 17;
        public static final byte BUSINESS_ORDER_LIST = (byte) 27;
        public static final byte BUSINESS_ORDER_LOAD_TYPE = (byte) -55;
        public static final byte BUSINESS_ORDER_OP_TYPE = (byte) 58;
        public static final byte BUSINESS_ORDER_TYPE = (byte) 72;
        public static final byte CARD_APP_ACTIVATION_STATUS = (byte) 63;
        public static final byte CARD_APP_BLANCE = (byte) 40;
        public static final byte CARD_APP_RAMDOM = (byte) 59;
        public static final byte CARD_APP_VERSION = (byte) 61;
        public static final byte CARD_BUSINESS_OP_RECOMMENED = (byte) 88;
        public static final byte CARD_BUSINESS_ORDER_STATUS = (byte) 62;
        public static final byte CARD_FORM = (byte) 47;
        public static final byte CARD_NO = (byte) 15;
        public static final byte CARD_TYPE = (byte) 14;
        public static final byte CITY_CODE = (byte) -101;
        public static final byte COMPANY_CODE = (byte) -119;
        public static final byte CPLC = (byte) -74;
        public static final byte CP_NO = (byte) 79;
        public static final byte DEVICE_MODEL = (byte) 104;
        public static final byte ELECTRONIC = (byte) 107;
        public static final byte ELECTRONIC_APP_TYPE = (byte) 120;
        public static final byte ELECTRONIC_END_TIME = (byte) 111;
        public static final byte ELECTRONIC_FROZEN_FLAG = (byte) 118;
        public static final byte ELECTRONIC_ID = (byte) 112;
        public static final byte ELECTRONIC_LIST = (byte) 108;
        public static final byte ELECTRONIC_NUMBER = (byte) 114;
        public static final byte ELECTRONIC_OUT_SERIAL = (byte) 126;
        public static final byte ELECTRONIC_OUT_STATE = (byte) 122;
        public static final byte ELECTRONIC_PRICE_FAVOURABLE = (byte) 125;
        public static final byte ELECTRONIC_PUBLISH_START_TIME = Byte.MAX_VALUE;
        public static final byte ELECTRONIC_STARTTIME = (byte) 110;
        public static final byte ELECTRONIC_STATE = (byte) 121;
        public static final byte ELECTRONIC_TRANSFER_FLAG = (byte) 117;
        public static final byte ELECTRONIC_TYPE = (byte) 115;
        public static final byte ELECTRONIC_TYPE_ID = (byte) 113;
        public static final int ELECTRONIC_USE_COUNT = 119;
        public static final byte ELECTRONIC_USE_TIME = (byte) 123;
        public static final byte ELECTRONIC_USE_TYPE = (byte) 116;
        public static final byte EUID = (byte) -72;
        public static final byte IDENTIFYING_CODE = (byte) 12;
        public static final byte IDENTIFYING_SERIAL = (byte) 64;
        public static final byte IDENTIFYING_TYPE = (byte) 11;
        public static final byte IMEI = (byte) -70;
        public static final byte INVOICE_TOKEN = (byte) 66;
        public static final byte INVOICE_TOKEN_OBJECT = (byte) -99;
        public static final byte INVOICE_TOKEN_OBJECT_LIST = (byte) -98;
        public static final byte MAIN_ORDER = (byte) 96;
        public static final byte MAIN_ORDER_ID = (byte) 105;
        public static final byte MAIN_ORDER_LIST = (byte) 97;
        public static final byte MOC = (byte) 95;
        public static final byte NOTICE_BODY = (byte) 52;
        public static final byte NOTICE_END_TIME = (byte) 55;
        public static final byte NOTICE_ID = (byte) 49;
        public static final byte NOTICE_START_TIME = (byte) 54;
        public static final byte NOTICE_TITLE = (byte) 50;
        public static final byte OPERATE_TIMING = (byte) 98;
        public static final byte OPERATION_ID = (byte) -90;
        public static final byte OPERATION_STEP = (byte) -89;
        public static final byte ORDER_AMOUNT = (byte) 16;
        public static final byte ORDER_BRIEF_INFO = (byte) 73;
        public static final byte ORDER_BRIEF_INFO_LIST = (byte) 80;
        public static final byte ORDER_CHANNEL = (byte) 30;
        public static final byte ORDER_DATE = (byte) 19;
        public static final byte ORDER_INVOICE_STATUS = (byte) 24;
        public static final byte ORDER_QUERY_PARAM = (byte) 25;
        public static final byte ORDER_RANGE_TYPE = (byte) 37;
        public static final byte ORDER_TAC = (byte) 32;
        public static final byte ORDER_TERMINAL = (byte) 23;
        public static final byte ORDER_TIME = (byte) 20;
        public static final byte ORDER_TRADE_NO = (byte) 22;
        public static final byte ORDER_TRADE_STATUS = (byte) 21;
        public static final byte ORDER_TRADE_STATUSES = (byte) 92;
        public static final byte ORDER_TYPE = (byte) 101;
        public static final byte PASSWORD_MODIFY = (byte) 9;
        public static final byte PASSWORD_PROMPT = (byte) 10;
        public static final byte PATCH_DATA = (byte) -76;
        public static final byte PAY_CHANNEL = (byte) 13;
        public static final byte PAY_CHANNEL_MIN = (byte) -117;
        public static final byte PAY_CHANNEL_NAME = (byte) -118;
        public static final byte PAY_ORDER = (byte) 99;
        public static final byte PAY_ORDER_ID = (byte) 106;
        public static final byte PAY_ORDER_LIST = (byte) 100;
        public static final byte PLATFORM_NOTICES = (byte) -109;
        public static final byte PREDEPOSIT_BLANCE = (byte) 91;
        public static final byte PREDEPOSIT_INFO = (byte) -106;
        public static final byte PREDEPOSIT_LIST = (byte) -105;
        public static final byte PREDEPOSIT_STATUS = (byte) -116;
        public static final byte PREDEPOSIT_TOTAL = (byte) 90;
        public static final byte PREDEPOSIT_TYPE = (byte) -107;
        public static final byte PRICE = (byte) 124;
        public static final byte PRODUCT_CODE = (byte) -103;
        public static final byte PRODUCT_ID = (byte) 103;
        public static final byte PRODUCT_INFO = (byte) -104;
        public static final byte PRODUCT_LIST = (byte) -100;
        public static final byte PRODUCT_NAME = (byte) -102;
        public static final byte PROMOTION_MESSAGE = (byte) -58;
        public static final byte PROMOTION_MESSAGE_DATA = (byte) -56;
        public static final byte PROMOTION_MESSAGE_LIST = (byte) -57;
        public static final byte PUBLISH_END_TIME = (byte) 109;
        public static final byte QUERY_DATA_SORT_TYPE = (byte) 86;
        public static final byte QUERY_RECORD_COUNT = (byte) 38;
        public static final byte RENT_HANDLE_DATD = (byte) -61;
        public static final byte RENT_HANDLE_TYPE = (byte) -62;
        public static final byte SEID = (byte) -79;
        public static final byte SIM_SEID = (byte) 46;
        public static final byte SIR = (byte) -71;
        public static final byte STATION_CONFIG_VERSION = (byte) -68;
        public static final byte STATION_ENAME = (byte) -64;
        public static final byte STATION_ID = (byte) -65;
        public static final byte STATION_INFO = (byte) -67;
        public static final byte STATION_INFO_LIST = (byte) -66;
        public static final byte STATION_NAME = (byte) -63;
        public static final byte SYSTEM_NEW_VERSION = (byte) 44;
        public static final byte SYSTEM_VERSION = (byte) -112;
        public static final byte TERMINAL_BACK_CHILDREN_ID = (byte) 85;
        public static final byte TERMINAL_BACK_CONTENT = (byte) 65;
        public static final byte TERMINAL_BACK_INFO = (byte) 83;
        public static final byte TERMINAL_BACK_INFO_LIST = (byte) 84;
        public static final byte TERMINAL_BACK_INFO_TYPE = (byte) 67;
        public static final byte TERMINAL_BACK_MAIN_ID = (byte) 81;
        public static final byte TERMINAL_BACK_QUESTION_FLAG = (byte) 82;
        public static final byte TERMINAL_BASEBAND_VERSION = (byte) 70;
        public static final byte TERMINAL_INFO_TYPE = (byte) 93;
        public static final byte TERMINAL_MODEL_NUMBER = (byte) 69;
        public static final byte TERMINAL_OP_TYPE = (byte) 76;
        public static final byte TERMINAL_OS_VERSION = (byte) 68;
        public static final byte TEXT_NOTICE = (byte) -110;
        public static final byte THIRD_PAY_NUMBER = (byte) 18;
        public static final byte TRADE_STATUS = (byte) 31;
        public static final byte UNSOLVED_NOTICES = (byte) -108;
        public static final byte URL_LIST = (byte) -113;
        public static final byte URL_TYPE = (byte) -114;
        public static final byte USER_ACCOUNT = (byte) 2;
        public static final byte USER_CERT_NO = (byte) 8;
        public static final byte USER_CERT_TYPE = (byte) 7;
        public static final byte USER_EMAIL = (byte) 4;
        public static final byte USER_LOCK_TIME = (byte) 43;
        public static final byte USER_LOGIN_FAIL_COUNT = (byte) 36;
        public static final byte USER_MOBILE = (byte) 5;
        public static final byte USER_NAME = (byte) 6;
        public static final byte USER_PASS = (byte) 3;
        public static final byte USER_PLATFORM_ID = (byte) -59;
        public static final byte USER_PLATFORM_TYPE = (byte) -60;
        public static final byte USER_TYPE = (byte) 1;

        public interface TerminalInfoTag {
            public static final byte BUSINESS_VERSION = (byte) 5;
            public static final byte SKD_VERSION = (byte) 4;
            public static final byte TERMINAL_MODEL = (byte) 1;
            public static final byte TERMINAL_OS_VERSION = (byte) 2;
            public static final byte TERMINAL_VERSION = (byte) 3;
        }
    }

    public interface TagValue {
        public static final byte BUSINESS_HANDLE_RESULT_FAIL = (byte) -1;
        public static final byte BUSINESS_HANDLE_RESULT_SUCESS = (byte) 0;
    }

    public interface TagValueLength {
        public static final int NOTICE_ID = 8;
    }

    public interface TicketOperateType {
        public static final int APPLY_BUSINESS = 91;
        public static final int QUERY_LAST_OPERATE = 94;
        public static final int RETURN_TICKET = 92;
        public static final int WRITE_TICKET = 93;
    }

    public interface TradeCode {
        public static final int ALIPAY_ONE_KEY = 2111;
        public static final int ALIPAY_ONE_KEY_CANCEL = 2031;
        public static final int ALIPAY_ONE_KEY_QUERY = 2021;
        public static final int ALIPAY_ONE_KEY_SIGN = 2011;
        public static final int APPLET_DOWNLOAD = 8851;
        public static final int APPLET_DOWNLOAD_VER2 = 8852;
        public static final int APPLY_FOR_ELECTRONIC_TAKEUP = 4611;
        public static final int APPLY_ORDER = 1111;
        public static final int APPLY_ORDER_EX = 1141;
        public static final int APPLY_ORDER_EX_VER2 = 1142;
        public static final int APPLY_ORDER_VER2 = 1112;
        public static final int APP_ISSUER = 8811;
        public static final int APP_ISSUER_PREPARE = 8821;
        public static final int APP_ISSUER_PREPARE_RESULT = 8831;
        public static final int APP_ISSUER_VER2 = 8812;
        public static final int APP_MANAGER = 8841;
        public static final int APP_MANAGER_VER2 = 8842;
        public static final int BUSINESS_ORDER_SETTING = 3041;
        public static final int BUSINESS_ORDER_SETTING_VER2 = 3042;
        public static final int CHECK_SERVER = 1221;
        public static final int DEAL_WITH_DOUBT = 3021;
        public static final int DELETE_TERMINAL_BACK = 4021;
        public static final int GET_CODE = 1061;
        public static final int GET_INVOICE = 3061;
        public static final int GET_INVOICE_VER2 = 3062;
        public static final int GET_INVOICE_VER3 = 3063;
        public static final int LOGIN = 1021;
        public static final int LOGIN_VER2 = 1022;
        public static final int LOGIN_VER3 = 1023;
        public static final int MAIN_ORDER_EXEC = 3091;
        public static final int PERSONLIZATION = 3071;
        public static final int PROMOTION_APPLY_ORDER = 1201;
        public static final int PWD_MODIFY = 1031;
        public static final int QUERY_ACTIVITIES = 1151;
        public static final int QUERY_BUSINESS_ORDER_STATUS = 3051;
        public static final int QUERY_ELECTRONIC_ACTIVITY = 1181;
        public static final int QUERY_ELECTRONIC_TAKEUP = 4631;
        public static final int QUERY_ELECTRONIC_TAKEUP_LIST = 4641;
        public static final int QUERY_ELECTRONIC_TAKEUP_LIST_VER2 = 4642;
        public static final int QUERY_IDENTIFYING = 1061;
        public static final int QUERY_NOTICE = 1311;
        public static final int QUERY_ORDER = 1121;
        public static final int QUERY_ORDERS = 1131;
        public static final int QUERY_ORDERS_VER2 = 1132;
        public static final int QUERY_ORDERS_VER3 = 1133;
        public static final int QUERY_ORDERS_VER4 = 1134;
        public static final int QUERY_ORDER_VER2 = 1122;
        public static final int QUERY_PREDEPOSIT = 1161;
        public static final int QUERY_PREDEPOSIT_VER2 = 1162;
        public static final int QUERY_PRODUCT_INFO = 5021;
        public static final int QUERY_PRODUCT_LIST = 5011;
        public static final int QUERY_PROMOTION_MESSAGE_LIST = 1191;
        public static final int QUERY_TERMINAL_BACK = 4011;
        public static final int QUERY_USER_INFO = 1051;
        public static final int QUERY_USER_INFO_VER2 = 1052;
        public static final int QUERY_VERSION = 1211;
        public static final int REFUND = 2121;
        public static final int REFUND_VER2 = 2122;
        public static final int REMOTE_RECHARGE = 3011;
        public static final int RENT_BUSINESS_HANDLE = 3101;
        public static final int REPORT_TO_PLATFORM = 9001;
        public static final int RETRIVE_PWD = 1041;
        public static final int RETRIVE_PWD_VER3 = 1043;
        public static final int SET_ORDER_STATUS = 1171;
        public static final int STATION_INFO_UPDATE = 3081;
        public static final int SUCESS_4_PLATFORM = 9000;
        public static final int TERMINAL_BACK = 4001;
        public static final int TERMINAL_INFO_REPORT = 4031;
        public static final int TICKET_MANAGER = 8861;
        public static final int USER_REGISTER = 1001;
        public static final int USER_REGISTER_VER2 = 1002;
        public static final int USER_REGISTER_VER3 = 1003;
        public static final int USER_UPDATE = 1011;
        public static final int USER_UPDATE_VER2 = 1012;
        public static final int USE_ELECTRONIC_TAKEUP = 4621;
        public static final int VERIFY_CODE = 1071;
    }

    public interface UserType {
        public static final int COMMON = 1;
        public static final int REAL_NAME = 2;
        public static final int REAL_NAME_AUTH = 3;
    }

    public interface XMLNode {
        public static final String AID = "Aid";
        public static final String AID_VALUE = "value";
        public static final String BUSINESS_AND_SERVER = "BusinessAndServer";
        public static final String BUSINESS_NAME = "businessName";
        public static final String CIPHER = "Cipher";
        public static final String COMPANY_CODE = "CompanyCode";
        public static final String COMPANY_CODE_VALUE = "value";
        public static final String KEY = "Key";
        public static final String KEY_CIPHER = "cipher";
        public static final String KEY_ENCRY_TYPE = "encryType";
        public static final String KEY_EXPONENT = "exponent";
        public static final String KEY_INDEX = "index";
        public static final String KEY_MODULUS = "modulus";
        public static final String LOG_LEVEL = "LogLevel";
        public static final String LOG_LEVEL_VALUE = "value";
        public static final String ORDER_SOURCE = "OrderSource";
        public static final String ORDER_SOURCE_VALUE = "value";
        public static final String SDK_VERSION = "sdkVersion";
        public static final String SERVER = "Server";
        public static final String SERVER_DOMAIN = "domain";
        public static final String SERVER_NAME = "serverName";
        public static final String SERVER_PORT = "port";
        public static final String SERVER_TOMEOUT = "socketTimeout";
        public static final String TERMINAL = "Termianl";
        public static final String TERMINAL_BUSINESS_VERSION = "businessVersion";
        public static final String TERMINAL_OS_VERSION = "osVersion";
        public static final String TERMINAL_TYPE = "type";
        public static final String TERMINAL_VERSION = "terminalVersion";
    }
}
