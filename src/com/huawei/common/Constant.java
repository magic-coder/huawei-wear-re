package com.huawei.common;

public class Constant {
    public static final String ADL2 = "MUt20CRGk05dZv1nM4LgV0Frl_MJpoomckQyPnkoW10";
    public static final String APP_ST_CONS = "0CD/aXaw8c1YOvL9DTeOV67VTI63JIGkWj5";
    public static final String CLIENT_ID_key2 = "AF2DBDE2BD2mKhgT4YSVHf+dC";
    public static final String EncrAPPID1 = "7UqaHcC64bjOiA68VDQH98aa";
    public static final String EncrCLIENTID1 = "CelB0CKBY+GkPGRJA6jtPdK";
    public static final String EncrHEALTHCLIENTID1 = "ECD4B0852lX30N6yMgMtFmSWp60ACozxz3T9gmks0";
    public static final String EncrHEALTHCLIENTID1TEST = "8F6E09487C4KwEVRFTFcTFEsRB/";
    public static final String HTTP_CLIENT_KEY_PART1 = "5fRwqJzIO3HNtMqwXLkYUWKMlq3Q8/";
    public static final String HTTP_CLIENT_SECRET_PART1 = "/RbGdNtmdQsjc3odR6y85+i4CVo/";
    public static final String HWAPPIDACCOUNT2 = "401AFAFB7A145+St7Toa";
    public static final String WECHAT_APPID_PART1 = "vIYSjdIS1Xqn0Y7mebJsqS5/ra7";
    public static final String WECHAT_SECRET_PART1 = "ee0c33Vh2tylrx9mYJ1MM/PXUgn";
    public static final String mNUllValue_1440;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1440; i++) {
            stringBuilder.append(",-1");
        }
        mNUllValue_1440 = stringBuilder.toString().substring(1);
    }
}
