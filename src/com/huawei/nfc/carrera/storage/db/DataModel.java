package com.huawei.nfc.carrera.storage.db;

import android.net.Uri;
import android.provider.BaseColumns;

public final class DataModel {
    public static final String AUTHORITY = "com.huawei.bone";

    public final class CardOrderColumns implements BaseColumns {
        public static final String COLUMN_NAME_REFENCE_ID = "reference_id";
        public static final String COLUMN_NAME_TIMESTAMP = "timestamp";
        public static final Uri CONTENT_URI = Uri.parse("content://com.huawei.bone/card_order_info");
        public static final String TABLE_NAME = "card_order_info";
    }

    public final class CardProductInfoColumns implements BaseColumns {
        public static final String COLUMN_NAME_CARD_TYPE = "card_type";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_FONT_COLOR = "font_color";
        public static final String COLUMN_NAME_ISSUER_ID = "issuer_id";
        public static final String COLUMN_NAME_MKT_INFO = "mkt_info";
        public static final String COLUMN_NAME_PIC_URL = "pic_url";
        public static final String COLUMN_NAME_PRODUCT_ID = "product_id";
        public static final String COLUMN_NAME_PRODUCT_NAME = "name";
        public static final String COLUMN_NAME_RESERVDINFO = "reserved_info";
        public static final String COLUMN_NAME_RESERVD_1 = "reserved_1";
        public static final String COLUMN_NAME_RESERVD_2 = "reserved_2";
        public static final String COLUMN_NAME_RESERVD_3 = "reserved_3";
        public static final String COLUMN_NAME_RESERVD_4 = "reserved_4";
        public static final String COLUMN_NAME_RESERVD_5 = "reserved_5";
        public static final String COLUMN_NAME_RESERVD_6 = "reserved_6";
        public static final String COLUMN_NAME_TIMESTAMP = "timestamp";
        public static final String COLUMN_NAME_VERSION = "version";
        public static final Uri CONTENT_URI = Uri.parse("content://com.huawei.bone/card_product_info");
        public static final String TABLE_NAME = "card_product_info";
    }

    public final class IssuerInfoColumns implements BaseColumns {
        public static final String COLUMN_NAME_APK_VERSION = "wallet_version";
        public static final String COLUMN_NAME_APPINFO = "app_info";
        public static final String COLUMN_NAME_CONTACT_NUM = "contact_num";
        public static final String COLUMN_NAME_CREDITTC_URL = "credit_tcurl";
        public static final String COLUMN_NAME_CREDIT_CALL_NUM = "credit_call_center_num";
        public static final String COLUMN_NAME_CREDIT_WEBSITE_URL = "credit_website_url";
        public static final String COLUMN_NAME_DEBITTC_URL = "debit_tcurl";
        public static final String COLUMN_NAME_DEBIT_CALL_NUM = "debit_callcenter_num";
        public static final String COLUMN_NAME_DEBIT_WEBSITE_URL = "debit_website_url";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_ISSUERID = "issuer_id";
        public static final String COLUMN_NAME_ISSUER_NAME = "name";
        public static final String COLUMN_NAME_ISSUER_TYPE = "issuer_type";
        public static final String COLUMN_NAME_LOGO_URL = "logo_url";
        public static final String COLUMN_NAME_MODE = "mode";
        public static final String COLUMN_NAME_RESERVDINFO = "reserved_info";
        public static final String COLUMN_NAME_SN = "sn";
        public static final String COLUMN_NAME_SUPPORT_CARD_TYPE = "support_card_type";
        public static final String COLUMN_NAME_TIMESTAMP = "timestamp";
        public static final Uri CONTENT_URI = Uri.parse("content://com.huawei.bone/issuer_info");
        public static final String TABLE_NAME = "issuer_info";
    }

    public final class RFConfInfoColumns implements BaseColumns {
        public static final String COLUMN_NAME_ISSUER_ID = "issuer_id";
        public static final String COLUMN_NAME_MODEL = "model";
        public static final String COLUMN_NAME_RFCONF_URL = "rf_conf_url";
        public static final String COLUMN_NAME_ROM_VERSION = "rom_version";
        public static final String COLUMN_NAME_TIMESTAMP = "timestamp";
        public static final Uri CONTENT_URI = Uri.parse("content://com.huawei.bone/rf_conf_info");
        public static final String TABLE_NAME = "rf_conf_info";
    }

    public final class ReportCardInfo implements BaseColumns {
        public static final String COLUMN_NAME_AID = "aid";
        public static final String COLUMN_NAME_CARD_NAME = "card_name";
        public static final String COLUMN_NAME_CARD_NUMBER = "card_number";
        public static final String COLUMN_NAME_CARD_STATUS = "status";
        public static final String COLUMN_NAME_CARD_TYPE = "card_type";
        public static final String COLUMN_NAME_CARD_USERID = "user_id";
        public static final String COLUMN_NAME_DPANID = "dpanid";
        public static final String COLUMN_NAME_EXTRA = "extra";
        public static final String COLUMN_NAME_ISSUSERID = "issuserid";
        public static final Uri CONTENT_URI = Uri.parse("content://com.huawei.bone/report_status_info");
        public static final String TABLE_NAME = "report_status_info";
    }
}
