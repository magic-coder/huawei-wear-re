package cn.com.fmsh.communication.contants;

public interface Contants {
    public static final int MAC_LENGTH = 4;
    public static final byte VERSION = (byte) 17;

    public interface Message {
        public static final int MESSAGE_HEAD_LENGTH = 12;
        public static final int MESSAGE_LENGTH_BIT_COUNT = 4;
        public static final String PACKET_CODE_DEFAULT = "9000";
        public static final byte PROTOCOL_VERSION = Byte.MIN_VALUE;
        public static final int RESPONSE_CODE_LENGTH = 2;
        public static final int SECURITY_LEVEL_BYTE_COUNT = 2;

        public interface ReponseCode {
            public static final byte BUSINESS_DEFINE = (byte) 14;
            public static final byte SUCESS = (byte) 0;
        }

        public interface RtResponseCmdType {
            public static final int CMD_FIELD_ON = 2;
        }

        public interface SecurityLevel {
            public static final int DATA_CHECK_CRC = 2;
            public static final int DATA_CHECK_MAC = 1;
            public static final int DATA_ENCRYPT_3DES = 1;
            public static final int DATA_NO_CHECK = 0;
            public static final int DATA_NO_ENCRYPT = 0;
        }

        public interface TerminalType {
            public static final byte FM_MSG_HEAD_TTYPE_LTP = (byte) 64;
            public static final byte FM_MSG_HEAD_TTYPE_READER_1915 = (byte) 32;
            public static final byte FM_MSG_HEAD_TTYPE_READER_1920 = (byte) 64;
            public static final byte FM_MSG_HEAD_TTYPE_USB_CARD = (byte) 16;
        }
    }
}
