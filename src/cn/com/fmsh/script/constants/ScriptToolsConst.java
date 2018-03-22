package cn.com.fmsh.script.constants;

public class ScriptToolsConst {

    public interface A2Response4ApduExceFail {
        public static final byte NO_REPONSE = (byte) 1;
        public static final byte TIMEOUT = (byte) 2;
    }

    public interface TagName {
        public static final byte CommandMultiple = (byte) -92;
        public static final byte CommandSingle = (byte) -96;
        public static final byte ResponseMultiple = (byte) -93;
        public static final byte ResponseSingle = (byte) -94;
        public static final byte ScriptDown = (byte) -95;
        public static final byte TagApdu = (byte) 57;
        public static final byte TagExpectationAndNext = (byte) 60;
        public static final byte TagSerial = (byte) 56;
    }
}
