package com.snowballtech.apdu.bean;

import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import com.huawei.nfc.carrera.constant.Constant;
import java.util.ArrayList;

public class SeConstants {
    public static byte[] AID_BYTE_65O = new byte[]{TagName.CommandSingle, (byte) 0, (byte) 0, (byte) 0, (byte) 3, (byte) 0, (byte) 0, (byte) 0};
    public static byte[] AID_BYTE_65T = new byte[]{TagName.CommandSingle, (byte) 0, (byte) 0, (byte) 1, (byte) 81, (byte) 0, (byte) 0, (byte) 0};
    public static final String AID_CPLC = "cplc";
    public static final String AID_FOR_APDULIST_PREFIX = "00A40400";
    public static final String AID_HEAD = "80F24000";
    public static final String AID_MEDIA = "5C";
    public static final String AID_TAIL = "4F9F70";
    public static String ALI_HTC_MF_AID = "A0000053424D344D5F48544300000000";
    public static String ALI_HTC_MF_AID1 = "A0000053424D344D5F48544300000001";
    public static String ALI_HTC_MF_AID2 = "A0000053424D344D5F48544300000002";
    public static String ALI_HTC_MF_AID3 = "A0000053424D344D5F48544300000003";
    public static String ALI_HTC_MF_AID4 = "A0000053424D344D5F48544300000004";
    public static String ALL_ACTIVE_CARD_INSTANCE_ID = "A00000015143525300";
    public static String ALL_ACTIVE_CARD_INSTANCE_ID_BUS = "A0000003335342540000000D";
    public static String BJ_AID = Constant.BJ_CARD_AID;
    public static final String CARD_CMB_INSTANCE_ID = "A0000003330101060003080000030801";
    public static final String CARD_CMB_INSTANCE_ID_STATUS = "A0000003330101060003080000030801";
    public static final String CARD_CMB_INSTANCE_ID_STATUS_APDU = "00a4040010A0000003330101060003080000030801";
    public static String CARD_EXITS_PERSO_FAIL = "01019000";
    public static String CARD_EXITS_RESULT_INSTALL = "01009000";
    public static String CARD_EXITS_RESULT_PERSO = "02009000";
    public static String CARD_EXITS_SEND = "8042020010A00000033301010600030800005A5954";
    public static String CARD_EXITS_SEND_BEGIN = "80420200";
    public static final String CARD_INSTANCE_ID = "A00000033301010600030800005A5954";
    public static final String CARD_INSTANCE_ID_ZGYH = "A0000003330101060101040000010000";
    public static String CMB_DJ_PSE_AID = "A0000003330101020003080000030801";
    public static String CMB_DZ_PSE_AID = "A0000003330101060003080000030801";
    public static String CMB_JJ_PSE_AID = "A0000003330101010003080000030801";
    public static final String COMMAND_CPLC = "80CA9F7F00";
    public static final String COMMAND_UID = "FFFFFFFFFF";
    public static String CQ_PSE_AID = "4351515041592E5359533331";
    public static String CS_AID = "A00000000386980700";
    public static String DEFAULT_WALLET_SNOWBALL = "636F6D2E736E6F7762616C6C746563682E77616C6C657473657276696365";
    public static String DF01_AID = Constant.SH_CARD_AID;
    public static String GREE_MF_AID = "A0000053424D344D5F47524545000000";
    public static String GREE_MF_AID1 = "A0000053424D344D5F47524545000001";
    public static String GREE_MF_AID2 = "A0000053424D344D5F47524545000002";
    public static String GREE_MF_AID3 = "A0000053424D344D5F47524545000003";
    public static String GREE_MF_AID4 = "A0000053424D344D5F47524545000004";
    public static String GX_AID = "A00000063201010553004755414E4758";
    public static String HB_AID = "325041592e5359532e44444630314842";
    public static String JL_AID = "325041592E5359532E44444630314A4C";
    public static String LNT_AID = Constant.LNT_CARD_AID;
    public static String MF_AID = "A00000534256434D2043580000000000";
    public static String MF_AID1 = "A00000534256434D2043580000000001";
    public static String MF_AID2 = "A00000534256434D2043580000000002";
    public static String MF_AID3 = "A00000534256434D2043580000000003";
    public static String MF_AID4 = "A00000534256434D2043580000000004";
    public static String MIFARE_VCM_INSTANCE_ID = "A0000003964D344D114D45495A554D46";
    public static String MIFARE_VSM_INSTANCE_ID = "A0000003964D344D214D45495A554D46";
    public static String PPSE_ID = "325041592e5359532e44444630313031";
    public static String PPSE_ID_STANDARD = "325041592e5359532e4444463031";
    public static String PSE_AID = "315041592E5359532E4444463031";
    public static String SERVICEAPKNAME = "TSM2Service_2.1.5.apk";
    public static String SESTATUS_AID = "A00000033353425400000009";
    public static String SETUID = "setuid";
    public static final int SE_CONNECTION_TIME_OUT = 300;
    public static final String SP_ID = "123456";
    public static String SZN_AID = Constant.SZT_CARD_AID;
    public static String SZT_DMSD_AID = "F0000000000191452F02230000000081";
    public static String SZT_INSTANCE_AID = Constant.SZT_CARD_AID;
    public static String SZT_INSTANCE_AID_OLD = "535A542E57414C4C45542E444D5344";
    public static String SZ_AID = Constant.SZ_CARD_AID;
    public static String TF_AID = "D156000015CCECB8AECDA8BFA8";
    public static String WALLET_INSTANCE_ID = "A0000003334E585000000003";
    public static String WH_AID = Constant.WHT_CARD_AID;
    public static String WH_PSE_AID = "A00000033565646570";
    public static String WH_SUBWAY_AID = "A00000534257484454";
    public static String WZ_TENCENT_AID_DJ = "A00000033301010250424F4301575A00";
    public static String WZ_TENCENT_AID_DZXJ = "A00000033301010650424F4301575A00";
    public static String WZ_TENCENT_AID_JJ = "A00000033301010150424F4301575A00";
    public static String XJ_AID = "325041592E5359532E4444463031584A";
    public static String appletStatusisInstanceAID = "A00000033353425400000009";
    public static ArrayList<String> noNeedShowAids = new ArrayList();

    static {
        noNeedShowAids.add("A0000003B0414D53442053425400");
        noNeedShowAids.add("A00000000353504200012601");
        noNeedShowAids.add("A0000003965344015A47594800");
        noNeedShowAids.add("A0000003965344015A595400");
        noNeedShowAids.add("A000000396534401545A00");
        noNeedShowAids.add("A000000396534401435100");
        noNeedShowAids.add("A000000396534401474400");
        noNeedShowAids.add("A000000003535043");
        noNeedShowAids.add("A0000053425344015748544B00");
        noNeedShowAids.add("A00000534253440153555A5400");
        noNeedShowAids.add("A000000396534401434D4200");
        noNeedShowAids.add("A00000033301010650424F4301474400");
        noNeedShowAids.add("A00000015141434C0201");
        noNeedShowAids.add("A00000015141434C19");
        noNeedShowAids.add("A00000033353425400000009");
        noNeedShowAids.add("A0000003335342540000000D");
    }
}