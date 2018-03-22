package cn.com.fmsh.tsm.business.card.core;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.bean.CardAppRecord;
import cn.com.fmsh.tsm.business.card.base.CardManager;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.tsm.business.enums.EnumCardAppStatus;
import cn.com.fmsh.tsm.business.exception.BusinessException;
import cn.com.fmsh.tsm.business.exception.BusinessException.ErrorMessage;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LntAppManager implements CardManager {
    /* synthetic */ FMLog f9693a = LogFactory.getInstance().getLog();
    private final /* synthetic */ String f9694b = LntAppManager.class.getName();
    private final /* synthetic */ int f9695c = 10;
    private final /* synthetic */ byte[] f9696d = new byte[]{(byte) 89, TagName.TERMINAL_BACK_INFO_TYPE, TagName.TERMINAL_BACK_INFO_LIST, TagName.SIM_SEID, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.TERMINAL_BACK_INFO, TagName.TERMINAL_MODEL_NUMBER, TagName.TERMINAL_BACK_QUESTION_FLAG};
    private final /* synthetic */ int f9697e = 23;
    private final /* synthetic */ byte f9698f = (byte) 2;
    private /* synthetic */ ApduHandler f9699g;

    private final /* synthetic */ byte[] m13023a(byte[] bArr) throws BusinessException {
        try {
            byte[] transceive = this.f9699g.transceive(bArr);
            if (transceive != null && transceive.length >= 2) {
                return transceive;
            }
            if (this.f9693a != null) {
                this.f9693a.warn(this.f9694b, FM_Long.copyValueOf("Kw`t捙亿房蠙纁染乶稳", TransportMediator.KEYCODE_MEDIA_RECORD));
            }
            if (this.f9699g != null) {
                this.f9699g.close();
            }
            throw new BusinessException(FM_Int.replace(TransportMediator.KEYCODE_MEDIA_PLAY, "\u0012&=)奛琄噭夌琍绝枍旴敟"), ErrorMessage.local_business_execute_fail);
        } catch (Exception e) {
            if (this.f9693a != null) {
                this.f9693a.warn(this.f9694b, new StringBuilder(FM_Exception.insert(3, 86, "F-w|捘仱扬蠍凭玽彁帡")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            if (this.f9699g != null) {
                this.f9699g.close();
            }
            throw new BusinessException(FM_Utils.regionMatches(4, 35, "\u0015g~(指仧戡蠅凶玿彐幭"), ErrorMessage.local_business_execute_fail);
        }
    }

    public byte[] getAid() {
        return this.f9696d;
    }

    public byte[] getAppNo() throws BusinessException {
        if (this.f9693a == null) {
            this.f9693a = LogFactory.getInstance().getLog();
        }
        if (this.f9693a != null) {
            this.f9693a.debug(this.f9694b, FM_Utils.regionMatches(5, 81, "\u0019\bCh~o/M->Q?o<m"));
        }
        if (this.f9699g == null) {
            if (this.f9693a != null) {
                this.f9693a.warn(this.f9694b, FM_Int.replace(202, "丕洵仡遒匪益廅畼廘前厪ｌ\u00026-9奋瑔嘽乢稡"));
            }
            throw new BusinessException(FM_CN.equals("乕洧以逈卢皐庑畾廈剏厾６Jli+奋瑆嘹乸穩", FitnessSleepType.HW_FITNESS_DREAM), ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] bArr = new byte[5];
        bArr[0] = TagName.USER_PLATFORM_TYPE;
        bArr[1] = (byte) -2;
        bArr = m13023a(bArr);
        return FM_Bytes.isEnd9000(bArr) ? Arrays.copyOfRange(bArr, 0, 8) : null;
    }

    public CardAppRecord getAppRecord4bytes(byte[] bArr) {
        CardAppRecord cardAppRecord = new CardAppRecord();
        cardAppRecord.setTradeNo(FM_Bytes.bytesToInt(new byte[]{bArr[0], bArr[1]}));
        cardAppRecord.setAmount(Integer.parseInt(FM_Bytes.bytesToHexString(new byte[]{bArr[5], bArr[6], bArr[7], bArr[8]}), 16));
        cardAppRecord.setTradeType(m13022a(bArr[9]));
        cardAppRecord.setTradeDevice(FM_Bytes.bytesToHexString(new byte[]{bArr[10], bArr[11], bArr[12], bArr[13], bArr[14], bArr[15]}));
        cardAppRecord.setTradeDate(FM_Bytes.bytesToHexString(new byte[]{bArr[18], bArr[19]}));
        cardAppRecord.setTradeTime(FM_Bytes.bytesToHexString(new byte[]{bArr[20], bArr[21], bArr[22]}));
        return cardAppRecord;
    }

    public String getFaceID() throws BusinessException {
        return FM_Bytes.bytesToHexString(getAppNo());
    }

    public String getMOC() throws BusinessException {
        return null;
    }

    public EnumCardAppStatus getStatus() throws BusinessException {
        EnumCardAppStatus enumCardAppStatus = EnumCardAppStatus.STATUS_INSTALL;
        if (this.f9699g == null) {
            if (this.f9693a != null) {
                this.f9693a.warn(this.f9694b, CRCUtil.substring(312, "菲历区乌廅畴彔剟犫怉日２\b$;?契理噣丬穻"));
            }
            throw new BusinessException(FM_Bytes.concat("華厍卿下庐畯弙剀犦恒斠５]/&0夌琍嘦乫穮", 1, 99), ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] bArr = new byte[7];
        bArr[1] = ScriptToolsConst.TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[5] = (byte) -35;
        bArr[6] = (byte) -15;
        try {
            if (!FM_Bytes.isEnd9000(this.f9699g.transceive(bArr))) {
                return enumCardAppStatus;
            }
            bArr = new byte[7];
            bArr[1] = ScriptToolsConst.TagName.CommandMultiple;
            bArr[4] = (byte) 2;
            bArr[5] = (byte) -83;
            bArr[6] = (byte) -13;
            try {
                if (!FM_Bytes.isEnd9000(this.f9699g.transceive(bArr))) {
                    return enumCardAppStatus;
                }
                bArr = new byte[5];
                bArr[1] = (byte) 10;
                try {
                    bArr = this.f9699g.transceive(bArr);
                    if (!FM_Bytes.isEnd9000(bArr)) {
                        return enumCardAppStatus;
                    }
                    if (bArr.length < 5) {
                        if (this.f9693a == null) {
                            return enumCardAppStatus;
                        }
                        this.f9693a.error(this.f9694b, FM_Bytes.concat("菮収匶东廁甼开剟狧怑方＂乧亶卝给柕挏亣哋廑旤攋", 2, 63));
                        return enumCardAppStatus;
                    } else if ((byte) 2 != bArr[2]) {
                        return enumCardAppStatus;
                    } else {
                        enumCardAppStatus = EnumCardAppStatus.STATUS_PERSONALIZED;
                        bArr = new byte[16];
                        bArr[0] = Byte.MIN_VALUE;
                        bArr[1] = TagName.ORDER_BRIEF_INFO_LIST;
                        bArr[2] = (byte) 1;
                        bArr[3] = (byte) 2;
                        bArr[4] = TagName.IDENTIFYING_TYPE;
                        bArr[5] = (byte) 2;
                        try {
                            return FM_Bytes.isEnd9000(this.f9699g.transceive(bArr)) ? EnumCardAppStatus.STATUS_ACTIVATE : enumCardAppStatus;
                        } catch (Exception e) {
                            if (this.f9693a == null) {
                                return enumCardAppStatus;
                            }
                            this.f9693a.error(this.f9694b, new StringBuilder(FM_CN.equals("副旱匬昱吩开逋旴｟坌嬍剛姜匞夨贯a", 120)).append(Util4Java.getExceptionInfo(e)).toString());
                            return enumCardAppStatus;
                        }
                    }
                } catch (Exception e2) {
                    if (this.f9693a == null) {
                        return enumCardAppStatus;
                    }
                    this.f9693a.error(this.f9694b, new StringBuilder(Util4Java.endsWith("获叁卯乏廈畻彙剌犮恎新ｑ误叝ria2料代好赦`", 3, 23)).append(Util4Java.getExceptionInfo(e2)).toString());
                    return enumCardAppStatus;
                }
            } catch (Exception e22) {
                if (this.f9693a == null) {
                    return enumCardAppStatus;
                }
                this.f9693a.error(this.f9694b, new StringBuilder(FM_Exception.insert(5, 24, "莾受卸乛廝甩彊剜狿恀斯＝)遈抰\u0010MG*奠赬;")).append(Util4Java.getExceptionInfo(e22)).toString());
                return enumCardAppStatus;
            }
        } catch (Exception e222) {
            if (this.f9693a == null) {
                return enumCardAppStatus;
            }
            this.f9693a.error(this.f9694b, new StringBuilder(CRCUtil.substring(5, "莥友卩丙床畡弇划狼恔时＇6逈拥S\u0006\u000bi奲赫c")).append(Util4Java.getExceptionInfo(e222)).toString());
            return enumCardAppStatus;
        }
    }

    public String getTime4Validity() throws BusinessException {
        byte[] bArr = new byte[7];
        bArr[1] = ScriptToolsConst.TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[5] = (byte) -35;
        bArr[6] = (byte) -15;
        bArr = m13023a(bArr);
        if (FM_Bytes.isEnd9000(bArr)) {
            bArr = new byte[5];
            bArr[1] = (byte) -80;
            bArr[2] = TagName.PREDEPOSIT_TYPE;
            bArr = m13023a(bArr);
            if (!FM_Bytes.isEnd9000(bArr)) {
                if (this.f9693a != null) {
                    this.f9693a.error(this.f9694b, new StringBuilder(CRCUtil.substring(5, "莥友卩丙床畡杝攗杕斣，诰叀09斐亴奼赽ｙ")).append(FM_Bytes.bytesToHexString(bArr)).toString());
                }
                throw new BusinessException(FM_CN.equals("菢厐匶乂庍產朒敄杂斸ｓ讫厗#6斓仳奧赢", 2), ErrorMessage.local_business_execute_fail);
            } else if (bArr.length < 31) {
                if (this.f9693a != null) {
                    this.f9693a.error(this.f9694b, new StringBuilder(FM_Exception.insert(1, 48, "莲參匤丟廑畽朌攝朚旣ｉ诮厓d0旒仳夤赠／")).append(FM_Bytes.bytesToHexString(bArr)).toString());
                }
                throw new BusinessException(CRCUtil.substring(2, "莸双卤业序畮杘攔杘斤ｑ诳叅/<斓仩奻走"), ErrorMessage.local_business_execute_fail);
            } else {
                return FM_Bytes.bytesToHexString(new byte[]{bArr[27], bArr[28], bArr[29], bArr[30]});
            }
        }
        if (this.f9693a != null) {
            this.f9693a.error(this.f9694b, new StringBuilder(FM_Exception.insert(3, 19, "莰双卬乊廇畮材敄最旤ｉ遑抢廊甹盪彂奻赸ｊ")).append(FM_Bytes.bytesToHexString(bArr)).toString());
        }
        throw new BusinessException(FM_CN.equals("菠厞匸乀序甤朔敆杀斦ｍ遛抪庀甭相归损亭奞瑍夭质", 4), ErrorMessage.local_business_execute_fail);
    }

    public boolean isLock4Consume() throws BusinessException {
        return false;
    }

    public boolean isLock4Load() throws BusinessException {
        return false;
    }

    public int queryBalance() throws BusinessException {
        if (this.f9693a == null) {
            this.f9693a = LogFactory.getInstance().getLog();
        }
        if (this.f9693a != null) {
            this.f9693a.debug(this.f9694b, FM_Utils.regionMatches(AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED, 8, "\f\u0006\u0004x1=5*yJqtafs}nf~"));
        }
        if (this.f9699g == null) {
            if (this.f9693a != null) {
                this.f9693a.warn(this.f9694b, FM_Exception.insert(154, 86, "莩厂仮通匷伕颟斮ｂE*4s奘瑔噠乤種"));
            }
            throw new BusinessException(FM_Bytes.concat("莴又份過卮体飘斶ｗWa(2夆琛噰乩稴", 172, 27), ErrorMessage.local_business_apdu_handler_null);
        }
        r0 = new byte[7];
        m13023a(r0);
        r0 = new byte[7];
        m13023a(r0);
        r0 = new byte[17];
        r0[0] = Byte.MIN_VALUE;
        r0[1] = TagName.ORDER_BRIEF_INFO_LIST;
        r0[2] = (byte) 3;
        r0[3] = (byte) 2;
        r0[4] = TagName.IDENTIFYING_TYPE;
        r0[5] = (byte) 1;
        r0[16] = (byte) 15;
        r0 = m13023a(r0);
        if (r0.length < 9) {
            if (this.f9693a != null) {
                this.f9693a.warn(this.f9694b, FM_Bytes.concat("菠厁亳逍匶伎颊旡｛\u0016GS\u0002咚広皓攧挹旷敟", 224, 32));
            }
            throw new BusinessException(FM_Long.copyValueOf("莺叜亣逞占伇飆斮ｙ咟廛攼挧斦攋", 5), ErrorMessage.local_get_app_info_fail);
        }
        return FM_Bytes.bytesToInt(Arrays.copyOf(r0, 4)) - FM_Bytes.bytesToInt(new byte[]{r0[6], r0[7], r0[8]});
    }

    public List<CardAppRecord> readAppRecords() throws BusinessException {
        if (this.f9693a == null) {
            this.f9693a = LogFactory.getInstance().getLog();
        }
        List arrayList = new ArrayList();
        if (this.f9693a != null) {
            this.f9693a.debug(this.f9694b, FM_Utils.regionMatches(5, 5, "\u0019\u0014\u000b${kr|\\rw^tut2!9azw"));
        }
        if (this.f9699g == null) {
            if (this.f9693a != null) {
                this.f9693a.warn(this.f9694b, Util4Java.endsWith("菨叒亭昝讣彍旫．F|uc够瑆嘭买稵", 2, 5));
            }
            throw new BusinessException(FM_Int.replace(5, "菭压交昐讶彜旺＃Se|n多琇噬丽穰"), ErrorMessage.local_business_apdu_handler_null);
        }
        r0 = new byte[7];
        m13023a(r0);
        r0 = new byte[7];
        m13023a(r0);
        r0 = new byte[7];
        r0[1] = ScriptToolsConst.TagName.CommandMultiple;
        r0[4] = (byte) 2;
        r0[6] = TagName.ORDER_INVOICE_STATUS;
        m13023a(r0);
        for (int i = 1; i <= 10; i++) {
            byte[] bArr = new byte[5];
            bArr[1] = TagName.APP_TYPE;
            bArr[2] = (byte) i;
            bArr[3] = (byte) 4;
            bArr = m13023a(bArr);
            if (Arrays.equals(new byte[]{TagName.PAY_ORDER_ID, TagName.ACTIVITY_CODE}, Arrays.copyOfRange(bArr, bArr.length - 2, bArr.length))) {
                break;
            }
            if (bArr.length >= 23) {
                arrayList.add(getAppRecord4bytes(bArr));
            }
        }
        return arrayList;
    }

    public void setApduHandler(ApduHandler apduHandler) {
        this.f9699g = apduHandler;
    }
}
