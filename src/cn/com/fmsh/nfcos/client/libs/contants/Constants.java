package cn.com.fmsh.nfcos.client.libs.contants;

public interface Constants {
    public static final int FAIL_CODE = 99;
    public static final int SUCESS_CODE = 0;

    public interface ApduHandlerType {
        public static final int NFC = 1;
        public static final int OMA = 0;
    }

    public interface ErrorCode {
        public static final int BUSINESS_HANDLE_FAIL = 99;
    }

    public interface TagName4Attach {
        public static final byte AMOUNT_NAME = (byte) 1;
        public static final byte APP_NO_NAME = (byte) 3;
        public static final byte CHANNEL_NAME = (byte) 2;
        public static final byte CIN_NAME = (byte) 4;
        public static final byte CITY_CURRENT = (byte) 2;
        public static final byte CITY_SIM = (byte) 1;
        public static final byte MODULE_NAME = (byte) 5;
        public static final byte PRODUCT_NAME = (byte) 1;
        public static final byte SEID_NAME = (byte) 3;
    }
}
