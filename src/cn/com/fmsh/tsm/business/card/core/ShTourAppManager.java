package cn.com.fmsh.tsm.business.card.core;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import cn.com.fmsh.tsm.business.bean.CardAppRecord;
import cn.com.fmsh.tsm.business.card.CardTools;
import cn.com.fmsh.tsm.business.card.base.CardManager;
import cn.com.fmsh.tsm.business.constants.Constants;
import cn.com.fmsh.tsm.business.enums.EnumCardAppStatus;
import cn.com.fmsh.tsm.business.enums.EnumTradeType;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import cn.com.fmsh.tsm.business.exception.BusinessException.ErrorMessage;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.log4j.net.SyslogAppender;

public class ShTourAppManager implements CardManager {
    /* synthetic */ FMLog f9700a = LogFactory.getInstance().getLog();
    private final /* synthetic */ String f9701b = ShTourAppManager.class.getName();
    private final /* synthetic */ byte[] f9702c;
    private final /* synthetic */ int f9703d;
    private final /* synthetic */ int f9704e;
    private final /* synthetic */ byte f9705f;
    private /* synthetic */ ApduHandler f9706g;

    public ShTourAppManager() {
        byte[] bArr = new byte[9];
        bArr[0] = TagName.CommandSingle;
        bArr[4] = (byte) 3;
        bArr[5] = Constants.TagName.ACTIVITY_TOTAL;
        bArr[6] = Constants.TagName.PRODUCT_INFO;
        bArr[7] = (byte) 7;
        bArr[8] = (byte) 1;
        this.f9702c = bArr;
        this.f9703d = 10;
        this.f9704e = 23;
        this.f9705f = (byte) 0;
    }

    private final /* bridge */ /* synthetic */ EnumTradeType m13025a(byte b, byte b2) {
        EnumTradeType enumTradeType = null;
        switch (b) {
            case (byte) -125:
                enumTradeType = EnumTradeType.recharge;
                break;
            case (byte) 1:
                enumTradeType = EnumTradeType.subwayConsumption;
                break;
            case (byte) 5:
                enumTradeType = EnumTradeType.subwayConsumption;
                break;
            case (byte) 9:
                enumTradeType = EnumTradeType.bus;
                break;
            case (byte) 17:
                enumTradeType = EnumTradeType.subwayConsumption;
                break;
            case (byte) 20:
                enumTradeType = EnumTradeType.subwayUpdate;
                break;
            case (byte) 32:
                enumTradeType = EnumTradeType.maglev;
                break;
            case (byte) 34:
                enumTradeType = EnumTradeType.recharge;
                break;
            case (byte) 49:
                enumTradeType = EnumTradeType.ferry;
                break;
            case (byte) 65:
                enumTradeType = EnumTradeType.taxi;
                break;
            case (byte) 81:
                enumTradeType = EnumTradeType.expressway;
                break;
            case (byte) 82:
                enumTradeType = EnumTradeType.park;
                break;
            case (byte) 99:
                enumTradeType = EnumTradeType.gasStation;
                break;
        }
        if (enumTradeType != null) {
            return enumTradeType;
        }
        switch (b2) {
            case (byte) 2:
                return EnumTradeType.recharge;
            default:
                return EnumTradeType.elseTrade;
        }
    }

    private final /* synthetic */ byte[] m13026a(byte[] bArr) throws BusinessException {
        try {
            byte[] transceive = this.f9706g.transceive(bArr);
            if (transceive != null && transceive.length >= 2) {
                return transceive;
            }
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, FM_Long.copyValueOf("Kw`t捙亿房蠙纁染乶稳", 2));
            }
            if (this.f9706g != null) {
                this.f9706g.close();
            }
            throw new BusinessException(FM_Int.replace(6, "\u001a.eq夃琌噥夔琕绅枅旼敗"), ErrorMessage.local_business_execute_fail);
        } catch (Exception e) {
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, new StringBuilder(FM_Bytes.concat("\u001bz~挝亮戽蠆冠玺弘帲", 3, 16)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            if (this.f9706g != null) {
                this.f9706g.close();
            }
            throw new BusinessException(FM_CN.equals("\u00199>>挛仩批衃出珡彀幫", 5), ErrorMessage.local_business_execute_fail);
        }
    }

    public byte[] getAid() {
        return this.f9702c;
    }

    public byte[] getAppNo() throws BusinessException {
        Object obj = new byte[8];
        if (this.f9700a != null) {
            this.f9700a.info(this.f9701b, FM_Exception.insert(4, 62, "莿厐与洵旅渦匽庎異庙剃句p b$"));
        }
        String replace = FM_Int.replace(174, "莴叐七浻旊渪却庌申庑剖厳g");
        if (this.f9706g == null) {
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, new StringBuilder(String.valueOf(replace)).append(FM_CN.equals("／Uu22奜瑏噲丱穦", HttpStatus.SC_NOT_MODIFIED)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_CN.equals("３Qq66奐瑃噾丽穢", 300)).toString(), ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] bArr = new byte[7];
        bArr[1] = TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[5] = Constants.TagName.CARD_APP_ACTIVATION_STATUS;
        bArr[6] = (byte) 1;
        Object a = m13026a(bArr);
        if (!FM_Bytes.isEnd9000(a)) {
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, new StringBuilder(String.valueOf(replace)).append(FM_Utils.regionMatches(216, 7, "ｄ遆抿\u001c\u0000\r戵蠕异帿4")).append(FM_Bytes.bytesToHexString(a)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Bytes.concat("ｍ逑抦\u0007Y\u0012戬衎彛幨", SdkConstants.REQUEST_PHOTOS, 87)).toString(), ErrorMessage.local_message_apdu_execute_exception);
        } else if (a.length >= 42) {
            System.arraycopy(a, 34, obj, 0, obj.length);
            return obj;
        } else {
            bArr = new byte[5];
            bArr[1] = (byte) -80;
            bArr[2] = Constants.TagName.PREDEPOSIT_TYPE;
            a = m13026a(bArr);
            if (!FM_Bytes.isEnd9000(a)) {
                if (this.f9700a != null) {
                    this.f9700a.warn(this.f9701b, new StringBuilder(String.valueOf(replace)).append(BCCUtil.getChars("｝逑拶w8斓亭哏庝归幯$", 1, 39)).append(FM_Bytes.bytesToHexString(a)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(Util4Java.endsWith("？達拮 n斂仹咔店式幯", 182, 42)).toString(), ErrorMessage.local_message_apdu_execute_exception);
            } else if (a.length < 20) {
                return null;
            } else {
                System.arraycopy(a, 12, obj, 0, obj.length);
                return obj;
            }
        }
    }

    public CardAppRecord getAppRecord4bytes(byte[] bArr, Map<String, EnumTradeType> map) {
        CardAppRecord cardAppRecord = new CardAppRecord();
        cardAppRecord.setTradeNo(FM_Bytes.bytesToInt(new byte[]{bArr[0], bArr[1]}));
        byte[] bArr2 = new byte[]{bArr[16], bArr[17], bArr[18], bArr[19]};
        cardAppRecord.setTradeDate(FM_Bytes.bytesToHexString(bArr2));
        byte[] bArr3 = new byte[]{bArr[20], bArr[21], bArr[22]};
        cardAppRecord.setTradeTime(FM_Bytes.bytesToHexString(bArr3));
        EnumTradeType enumTradeType = (EnumTradeType) map.get(FM_Bytes.bytesToHexString(bArr2) + FM_Bytes.bytesToHexString(bArr3));
        cardAppRecord.setAmount(Integer.parseInt(FM_Bytes.bytesToHexString(new byte[]{bArr[5], bArr[6], bArr[7], bArr[8]}), 16));
        cardAppRecord.setBalance(FM_Bytes.bytesToInt(new byte[]{bArr[2], bArr[3], bArr[4]}));
        cardAppRecord.setOriTradeType(bArr[12]);
        cardAppRecord.setOriTradeType(bArr[9]);
        if (enumTradeType != null) {
            cardAppRecord.setTradeType(enumTradeType);
        } else {
            cardAppRecord.setTradeType(m13025a(bArr[12], bArr[9]));
        }
        cardAppRecord.setTradeDevice(FM_Bytes.bytesToHexString(new byte[]{bArr[10], bArr[11], bArr[12], bArr[13], bArr[14], bArr[15]}));
        return cardAppRecord;
    }

    public String getDateTime4File07(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int bytesToInt = FM_Bytes.bytesToInt(new byte[]{bArr[0], bArr[1]}) >> 4;
        stringBuffer.append(String.valueOf(bytesToInt));
        System.out.println(new StringBuilder(FM_Bytes.concat("j,~'] ;x&#", 188, 54)).append(bytesToInt).toString());
        String valueOf = String.valueOf(bArr[1] & 15);
        if (valueOf.length() == 1) {
            valueOf = "0" + valueOf;
        }
        stringBuffer.append(valueOf);
        valueOf = String.valueOf((bArr[2] & 248) >> 3);
        if (valueOf.length() == 1) {
            valueOf = "0" + valueOf;
        }
        stringBuffer.append(valueOf);
        valueOf = String.valueOf(FM_Bytes.bytesToInt(new byte[]{(byte) (bArr[2] & 7), (byte) (bArr[3] & 192)}) >> 6);
        if (valueOf.length() == 1) {
            valueOf = "0" + valueOf;
        }
        stringBuffer.append(valueOf);
        valueOf = String.valueOf((byte) (bArr[3] & 63));
        if (valueOf.length() == 1) {
            valueOf = "0" + valueOf;
        }
        stringBuffer.append(valueOf);
        valueOf = String.valueOf((bArr[4] & 252) >> 2);
        if (valueOf.length() == 1) {
            valueOf = "0" + valueOf;
        }
        stringBuffer.append(valueOf);
        return stringBuffer.toString();
    }

    public String getFaceID() throws BusinessException {
        if (this.f9700a == null) {
            this.f9700a = LogFactory.getInstance().getLog();
        }
        if (this.f9700a != null) {
            this.f9700a.info(this.f9701b, Util4Java.endsWith("获厈世浭斝湮卵即露厹,$fh", 3, 94));
        }
        String copyValueOf = FM_Long.copyValueOf("莡叅业浺族渿卥占霼厬", 142);
        if (this.f9706g != null) {
            return CardTools.getFaceID4UID(Arrays.copyOfRange(getAppNo(), 4, 8));
        }
        if (this.f9700a != null) {
            this.f9700a.warn(this.f9701b, new StringBuilder(String.valueOf(copyValueOf)).append(Util4Java.endsWith("斩ｅ\u0012mcd奟瑃嘧丣穹", 2, 106)).toString());
        }
        throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(FitnessSleepType.HW_FITNESS_DREAM, 37, "斦９[/`|奊瑕噰丧稸")).toString(), ErrorMessage.local_business_apdu_handler_null);
    }

    public String getMOC() throws BusinessException {
        byte[] bArr = new byte[5];
        bArr[0] = Byte.MIN_VALUE;
        bArr[1] = (byte) -54;
        bArr[4] = (byte) 9;
        bArr = m13026a(bArr);
        if (FM_Bytes.isEnd9000(bArr)) {
            return FM_Bytes.bytesToHexString(Arrays.copyOf(bArr, bArr.length - 2));
        }
        if (this.f9700a != null) {
            this.f9700a.warn(this.f9701b, new StringBuilder(FM_Exception.insert(82, 20, "菡厜休廨郮设讏硃斠＆_B\u0002\u000f捉仦迂囔绍柎奷赿＂ps:1<u４")).append(FM_Bytes.bytesToHexString(bArr)).toString());
        }
        throw new BusinessException(FM_Exception.insert(290, 42, "莱历坒孜勑肥锃寖狠态於ｘ_\u0018\u0016I捁亴夞瑂奿贽"), ErrorMessage.local_business_execute_fail);
    }

    public EnumCardAppStatus getStatus() throws BusinessException {
        EnumCardAppStatus enumCardAppStatus = EnumCardAppStatus.STATUS_INSTALL;
        if (this.f9700a != null) {
            this.f9700a.info(this.f9701b, FM_Utils.regionMatches(4, 23, "菣叝丈浮斕湿匿彆剁盇独恐&18"));
        }
        String insert = FM_Exception.insert(5, 27, "莾叒丕洭斐渨卪引刌盘犡怓");
        if (this.f9706g == null) {
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, new StringBuilder(String.valueOf(insert)).append(FM_Exception.insert(86, 55, "斬＝\t/r8夀瑝噺乳空")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(FM_Utils.regionMatches(2, 1, "斤｟\u0015%2\"奜瑟嘲乡稦")).toString(), ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] bArr = new byte[5];
        bArr[1] = (byte) -80;
        bArr[2] = Constants.TagName.PREDEPOSIT_TYPE;
        try {
            byte[] transceive = this.f9706g.transceive(bArr);
            if (!FM_Bytes.isEnd9000(transceive)) {
                return enumCardAppStatus;
            }
            bArr = new byte[32];
            bArr[30] = Constants.TagName.SYSTEM_VERSION;
            if (Arrays.equals(bArr, transceive)) {
                return enumCardAppStatus;
            }
            enumCardAppStatus = EnumCardAppStatus.STATUS_PERSONALIZED;
            byte[] bArr2 = new byte[8];
            new Random().nextBytes(bArr2);
            bArr = new byte[5];
            bArr[1] = (byte) 10;
            bArr[2] = Constants.TagName.ACTIVITY_CODE;
            bArr[3] = (byte) 4;
            bArr[4] = (byte) 8;
            bArr2 = FM_Bytes.join(bArr, bArr2);
            Object obj = null;
            try {
                transceive = this.f9706g.transceive(bArr2);
            } catch (Exception e) {
                if (this.f9700a != null) {
                    this.f9700a.error(this.f9701b, new StringBuilder(String.valueOf(insert)).append(FM_Long.copyValueOf("旻＆弅帼;", 5)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                obj = 1;
            }
            if (obj != null) {
                obj = 1;
            } else if (!FM_Bytes.isEnd9000(transceive)) {
                obj = 1;
            } else if (transceive.length < 5) {
                obj = 1;
            } else {
                String bytesToHexString = FM_Bytes.bytesToHexString(Arrays.copyOfRange(transceive, 1, 5));
                long currentTimeMillis = System.currentTimeMillis();
                Date date = null;
                try {
                    date = new SimpleDateFormat(FM_Utils.regionMatches(SyslogAppender.LOG_LOCAL1, 39, "!f?4YV&m")).parse(bytesToHexString);
                } catch (ParseException e2) {
                    if (this.f9700a != null) {
                        this.f9700a.warn(this.f9701b, new StringBuilder(String.valueOf(insert)).append(FM_Long.copyValueOf("旻＆莰叒皅斻杄桤彚彐幷v", 5)).append(bytesToHexString).toString());
                    }
                }
                if (date == null) {
                    obj = 1;
                } else if (transceive[0] != (byte) 0 && date.getTime() >= currentTimeMillis) {
                    return EnumCardAppStatus.STATUS_ACTIVATE;
                } else {
                    obj = null;
                }
            }
            if (obj == null) {
                return enumCardAppStatus;
            }
            bArr = new byte[16];
            bArr[0] = Byte.MIN_VALUE;
            bArr[1] = Constants.TagName.ORDER_BRIEF_INFO_LIST;
            bArr[3] = (byte) 2;
            bArr[4] = Constants.TagName.IDENTIFYING_TYPE;
            bArr[5] = (byte) 1;
            bArr[8] = (byte) 7;
            bArr[9] = (byte) -48;
            try {
                if (!FM_Bytes.isEnd9000(this.f9706g.transceive(bArr))) {
                    return enumCardAppStatus;
                }
                try {
                    bArr = this.f9706g.transceive(FM_Bytes.hexStringToBytes(FM_Utils.regionMatches(2, 87, "jy5e~5lc:Cj?7i$<p!!r/ w#c\u000e&n|Fi")));
                    return FM_Bytes.isEnd(bArr, new byte[]{Constants.TagName.PLATFORM_NOTICES, (byte) 2}) ? EnumCardAppStatus.STATUS_ACTIVATE : FM_Bytes.isEnd9000(bArr) ? EnumCardAppStatus.STATUS_ACTIVATE : enumCardAppStatus;
                } catch (Exception e3) {
                    if (this.f9700a == null) {
                        return enumCardAppStatus;
                    }
                    this.f9700a.error(this.f9701b, new StringBuilder(String.valueOf(insert)).append(FM_Bytes.concat("早ｎ坍子刖妅升夥贲`", SyslogAppender.LOG_LOCAL5, 35)).append(Util4Java.getExceptionInfo(e3)).toString());
                    return enumCardAppStatus;
                }
            } catch (Exception e32) {
                if (this.f9700a == null) {
                    return enumCardAppStatus;
                }
                this.f9700a.error(this.f9701b, new StringBuilder(String.valueOf(insert)).append(FM_Utils.regionMatches(5, 65, "斣：坟孀剄姑卍夭赸$")).append(Util4Java.getExceptionInfo(e32)).toString());
                return enumCardAppStatus;
            }
        } catch (Exception e322) {
            if (this.f9700a == null) {
                return enumCardAppStatus;
            }
            this.f9700a.error(this.f9701b, new StringBuilder(String.valueOf(insert)).append(Util4Java.endsWith("时ｒ诧双hf%'旗亸夽贯r", 3, 94)).append(Util4Java.getExceptionInfo(e322)).toString());
            return enumCardAppStatus;
        }
    }

    public String getTime4Validity() throws BusinessException {
        byte[] bArr = new byte[7];
        bArr[1] = TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[5] = Constants.TagName.CARD_APP_ACTIVATION_STATUS;
        bArr[6] = (byte) 1;
        bArr = m13026a(bArr);
        if (FM_Bytes.isEnd9000(bArr)) {
            bArr = new byte[5];
            bArr[1] = (byte) -80;
            bArr[2] = Constants.TagName.PREDEPOSIT_TYPE;
            bArr = m13026a(bArr);
            if (!FM_Bytes.isEnd9000(bArr)) {
                if (this.f9700a != null) {
                    this.f9700a.error(this.f9701b, new StringBuilder(BCCUtil.getChars("菣厁卻丗应畫杏敁朓方～诮収jk旆仲夶赯ｗ", 4, 99)).append(FM_Bytes.bytesToHexString(bArr)).toString());
                }
                throw new BusinessException(FM_Utils.regionMatches(178, 97, "莵叕匥乏庒甯杁攁朕旽｀讶变>e旖令夢赱"), ErrorMessage.local_business_execute_fail);
            } else if (bArr.length < 29) {
                if (this.f9700a != null) {
                    this.f9700a.error(this.f9701b, new StringBuilder(BCCUtil.getChars("菥厑匽乛廒申朙敍朅旹（订厘rm旊亴夦贩；", 2, 117)).append(FM_Bytes.bytesToHexString(bArr)).toString());
                }
                throw new BusinessException(FM_Long.copyValueOf("莾叐卢上廉畲杞攜李斸ｇ讳厓sj旛亯奧赶", 1), ErrorMessage.local_business_execute_fail);
            } else {
                return FM_Bytes.bytesToHexString(new byte[]{bArr[24], bArr[25], bArr[26], bArr[27]});
            }
        }
        if (this.f9700a != null) {
            this.f9700a.error(this.f9701b, new StringBuilder(CRCUtil.substring(266, "莠叔卬丒廗畦材攌材斬）這拲庒甹盲弒奣赸ｒ")).append(FM_Bytes.bytesToHexString(bArr)).toString());
        }
        throw new BusinessException(BCCUtil.getChars("莭厅卭乏床畿朙攁朝旭ｘ逄抯庋異盿弟挄仸契琈奶败", 74, 57), ErrorMessage.local_business_execute_fail);
    }

    public boolean isLock4Consume() throws BusinessException {
        if (this.f9700a == null) {
            this.f9700a = LogFactory.getInstance().getLog();
        }
        if (this.f9706g == null) {
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, BCCUtil.getChars("菢受圅孁劚胬锜寓狣恀斻ｕDay|夑瑇嘥乣稿", 5, 12));
            }
            throw new BusinessException(FM_Utils.regionMatches(3, 7, "菤厌下浿旊渮卼佝颖旤５\u00017* 奘瑅嘢乫稢"), ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] bArr = new byte[8];
        new Random().nextBytes(bArr);
        byte[] bArr2 = new byte[5];
        bArr2[1] = (byte) 10;
        bArr2[2] = Constants.TagName.TERMINAL_BACK_INFO_TYPE;
        bArr2[3] = (byte) 4;
        bArr2[4] = (byte) 8;
        bArr2 = m13026a(FM_Bytes.join(bArr2, bArr));
        if (!FM_Bytes.isEnd9000(bArr2)) {
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, FM_Bytes.concat("菦叐淓贩勚肧锎寞犯恏旵４\fR\u0013Y捆亲迟嚞细柖奮贱", 250, 53));
            }
            throw new BusinessException(FM_Exception.insert(244, ReportInfoUtils.FEEDBACK_SUCCESS, "華厅坆嬑勛肢镛寏狦恊新ｍ]GVX挏仧多琟夥贪"), ErrorMessage.local_business_execute_fail);
        } else if (bArr2.length < 5) {
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, FM_Int.replace(4, "菮厊淗贻劚胵锊宔犧怕旡６\\PGS挎仨夋琔夤贽"));
            }
            throw new BusinessException(FM_Bytes.concat("菬厖圍嬒劐肩锘寄犵恉旻～V\f\u0005S捌仴契琜奮贡", 4, 69), ErrorMessage.local_business_execute_fail);
        } else {
            String bytesToHexString = FM_Bytes.bytesToHexString(Arrays.copyOfRange(bArr2, 1, 5));
            try {
                return bArr2[0] == (byte) 0 || new SimpleDateFormat(FM_Int.replace(3, "!\"'xIJni")).parse(bytesToHexString).getTime() < System.currentTimeMillis();
            } catch (ParseException e) {
                if (this.f9700a != null) {
                    this.f9700a.warn(this.f9701b, new StringBuilder(FM_Utils.regionMatches(300, 81, "莫厛涖贶募胬锃寉犲恔新；菿叏皎斾朓桡彁弝幨{")).append(bytesToHexString).toString());
                }
                throw new BusinessException(FM_Exception.insert(6, 76, "莽厀圊嬖劅胻镓宄狼怗旴ｂ[\u0016V\u000b捍仲奆琈奫赣"), ErrorMessage.local_business_execute_fail);
            }
        }
    }

    public boolean isLock4Load() throws BusinessException {
        if (this.f9700a == null) {
            this.f9700a = LogFactory.getInstance().getLog();
        }
        if (this.f9706g == null) {
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, BCCUtil.getChars("菢厜块嬌勖胣锒宒犫怓旱ｐ\u00106?%奁琜噧举穣", 5, 117));
            }
            throw new BusinessException(FM_Int.replace(274, "莰叜万浧旖渮卸佅颂旴）I{jd夐琑噲丧稺"), ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] bArr = new byte[8];
        new Random().nextBytes(bArr);
        byte[] bArr2 = new byte[5];
        bArr2[1] = (byte) 10;
        bArr2[2] = Constants.TagName.ACTIVITY_CODE;
        bArr2[3] = (byte) 4;
        bArr2[4] = (byte) 8;
        bArr2 = m13026a(FM_Bytes.join(bArr2, bArr));
        if (!FM_Bytes.isEnd9000(bArr2)) {
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, FM_CN.equals("菦厔圛孜劊胻镖寒狯恋旭＀\\^\u001b\u0005捆亶辗囊绖枊夶赽", NFCBaseActivity.TO_ADD));
            }
            throw new BusinessException(FM_Bytes.concat("菴叜坙孀勀肻锌寎犭恃旿｜V\u000e\u0001Y捔仾奅琎奾贳", 108, 71), ErrorMessage.local_business_execute_fail);
        } else if (bArr2.length < 5) {
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, FM_Bytes.concat("菭发圜孙劑胦镉寏狴恎斪％WSTH捍亳奀瑗奯贮", 3, 13));
            }
            throw new BusinessException(BCCUtil.getChars("菣叉圂嬍功肶锗宛狺怖斴！\u0019\u0013J\f挃享夞球奡贾", 4, 75), ErrorMessage.local_business_execute_fail);
        } else {
            String bytesToHexString = FM_Bytes.bytesToHexString(Arrays.copyOfRange(bArr2, 1, 5));
            try {
                return bArr2[0] == (byte) 0 || new SimpleDateFormat(CRCUtil.substring(248, "|ib\\Q#6")).parse(bytesToHexString).getTime() < System.currentTimeMillis();
            } catch (ParseException e) {
                if (this.f9700a != null) {
                    this.f9700a.warn(this.f9701b, new StringBuilder(Util4Java.endsWith("菨叙淗贶劀育锞寕狩怎斩＃莨厙皛斪杀栳彐弍帧u", 2, 48)).append(bytesToHexString).toString());
                }
                throw new BusinessException(FM_Bytes.concat("菫厖坌子劓肭镕宂犪态斲ｄM@\u0010\r挛令夀瑎好贵", 5, 100), ErrorMessage.local_business_execute_fail);
            }
        }
    }

    public int queryBalance() throws BusinessException {
        if (this.f9700a == null) {
            this.f9700a = LogFactory.getInstance().getLog();
        }
        if (this.f9700a != null) {
            this.f9700a.info(this.f9701b, FM_Int.replace(268, "莶叒不浽旈渨卲住预<1,+"));
        }
        if (this.f9706g == null) {
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, BCCUtil.getChars("莧厚乂浳旅湤卹位飍｀It$i夜瑒嘸丶穲", SyslogAppender.LOG_LOCAL4, 92));
            }
            throw new BusinessException(FM_Long.copyValueOf("莺叜不浳旄湦区企飈斤ｃ\r9\"6奄瑛嘲乭種", 5), ErrorMessage.local_business_apdu_handler_null);
        }
        r0 = new byte[7];
        m13026a(r0);
        r0 = new byte[17];
        r0[0] = Byte.MIN_VALUE;
        r0[1] = Constants.TagName.ORDER_BRIEF_INFO_LIST;
        r0[2] = (byte) 3;
        r0[3] = (byte) 2;
        r0[4] = Constants.TagName.IDENTIFYING_TYPE;
        r0[5] = (byte) 1;
        r0[16] = (byte) 15;
        r0 = m13026a(r0);
        if (r0.length < 9) {
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, BCCUtil.getChars("菤厖万洭旂湬匠佗飆旾ｙ\u0003_\u0018\\咛廗皔攭捤斷攌", 3, 77));
            }
            throw new BusinessException(BCCUtil.getChars("菤叝义浬斖渳匢伂颎施／咖庇攻捭旻攛", 3, 56), ErrorMessage.local_get_app_info_fail);
        }
        return FM_Bytes.bytesToInt(Arrays.copyOf(r0, 4)) - FM_Bytes.bytesToInt(new byte[]{r0[6], r0[7], r0[8]});
    }

    public List<CardAppRecord> readAppRecords() throws BusinessException {
        List arrayList = new ArrayList();
        if (this.f9700a != null) {
            this.f9700a.info(this.f9701b, BCCUtil.getChars("菦厑乗洤斌渧却亯昒讧彘#wak", 1, 118));
        }
        String concat = FM_Bytes.concat("菴叁乁浨旖湿卺享晐讧彞", 204, 84);
        if (this.f9706g == null) {
            if (this.f9700a != null) {
                this.f9700a.warn(this.f9701b, new StringBuilder(String.valueOf(concat)).append(FM_Exception.insert(210, 92, "斠＞O:\"w奚瑜噾丨稴")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(CRCUtil.substring(4, "旧０Fby=套瑘嘡乮稥")).toString(), ErrorMessage.local_business_apdu_handler_null);
        }
        int i;
        byte[] bArr = new byte[7];
        bArr[1] = TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[5] = Constants.TagName.CARD_APP_ACTIVATION_STATUS;
        bArr[6] = (byte) 1;
        m13026a(bArr);
        Map hashMap = new HashMap();
        bArr = new byte[7];
        bArr[1] = TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[6] = (byte) 7;
        m13026a(bArr);
        bArr = new byte[5];
        for (i = 1; i <= 10; i++) {
            byte[] bArr2 = new byte[5];
            bArr2[1] = Constants.TagName.APP_TYPE;
            bArr2[2] = (byte) i;
            bArr2[3] = (byte) 4;
            bArr2 = m13026a(bArr2);
            if (Arrays.equals(new byte[]{Constants.TagName.PAY_ORDER_ID, Constants.TagName.ACTIVITY_CODE}, Arrays.copyOfRange(bArr2, bArr2.length - 2, bArr2.length))) {
                break;
            }
            if (bArr2.length >= 16) {
                String dateTime4File07 = getDateTime4File07(Arrays.copyOfRange(bArr2, 10, 15));
                EnumTradeType a = m13024a(bArr2[0]);
                if (!(dateTime4File07 == null || a == null)) {
                    hashMap.put(dateTime4File07, a);
                }
            }
        }
        bArr = new byte[7];
        bArr[1] = TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[6] = Constants.TagName.ORDER_INVOICE_STATUS;
        m13026a(bArr);
        for (i = 1; i <= 10; i++) {
            bArr2 = new byte[5];
            bArr2[1] = Constants.TagName.APP_TYPE;
            bArr2[2] = (byte) i;
            bArr2[3] = (byte) 4;
            bArr2 = m13026a(bArr2);
            if (Arrays.equals(new byte[]{Constants.TagName.PAY_ORDER_ID, Constants.TagName.ACTIVITY_CODE}, Arrays.copyOfRange(bArr2, bArr2.length - 2, bArr2.length))) {
                break;
            }
            if (bArr2.length >= 23) {
                arrayList.add(getAppRecord4bytes(bArr2, hashMap));
            }
        }
        return arrayList;
    }

    public void setApduHandler(ApduHandler apduHandler) {
        this.f9706g = apduHandler;
    }
}
