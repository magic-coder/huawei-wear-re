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
import com.huawei.datatype.SportType;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
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

public class StpcManager implements CardManager {
    /* synthetic */ FMLog f9707a = LogFactory.getInstance().getLog();
    private final /* synthetic */ String f9708b = StpcManager.class.getName();
    private final /* synthetic */ byte[] f9709c;
    private final /* synthetic */ byte[] f9710d;
    private final /* synthetic */ int f9711e;
    private final /* synthetic */ int f9712f;
    private final /* synthetic */ byte f9713g;
    private /* synthetic */ ApduHandler f9714h;

    public StpcManager() {
        r0 = new byte[9];
        this.f9709c = r0;
        r0 = new byte[2];
        r0[0] = (byte) 32;
        this.f9710d = r0;
        this.f9711e = 10;
        this.f9712f = 23;
        this.f9713g = (byte) 0;
    }

    private final /* bridge */ /* synthetic */ EnumTradeType m13028a(byte b, byte b2) {
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

    private final /* synthetic */ byte[] m13029a(byte[] bArr) throws BusinessException {
        try {
            byte[] transceive = this.f9714h.transceive(bArr);
            if (transceive != null && transceive.length >= 2) {
                return transceive;
            }
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, BCCUtil.getChars("\u0012,a{挐令扮衞终柘乷稬", 3, 9));
            }
            if (this.f9714h != null) {
                this.f9714h.close();
            }
            throw new BusinessException(FM_CN.equals("\u00102wq夑琀嘿奌瑟纙枇旬敕", 94), ErrorMessage.local_business_execute_fail);
        } catch (Exception e) {
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, new StringBuilder(FM_Long.copyValueOf("Jxaw捘亸戾蠚冩珠彏干", 3)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            if (this.f9714h != null) {
                this.f9714h.close();
            }
            throw new BusinessException(FM_Long.copyValueOf("\u0001->\"捓亵戩蠇冲珵彀帧", 344), ErrorMessage.local_business_execute_fail);
        }
    }

    private final /* synthetic */ byte[] m13030b(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        String bytesToHexString = FM_Bytes.bytesToHexString(bArr);
        int indexOf = bytesToHexString.indexOf(FM_Exception.insert(3, 103, ">\be_2O"));
        if (indexOf >= 0) {
            byte[] hexStringToBytes = FM_Bytes.hexStringToBytes(bytesToHexString.substring(indexOf));
            return new byte[]{hexStringToBytes[13], hexStringToBytes[14]};
        } else if (this.f9707a == null) {
            return null;
        } else {
            this.f9707a.error(this.f9708b, FM_Int.replace(134, "h\u001815绔枖莺叆埝帔缏砝央货）哅废绝枍丙匒吱$\u0006s\u0005"));
            return null;
        }
    }

    public byte[] getAid() {
        return this.f9709c;
    }

    public byte[] getAppNo() throws BusinessException {
        Object obj = new byte[8];
        if (this.f9707a != null) {
            this.f9707a.info(this.f9708b, Util4Java.endsWith("Q[@^&NH\u0011j\u001d\u0013e`y.", 5, 9));
        }
        if (this.f9714h == null) {
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, FM_Utils.regionMatches(5, 33, "也浡亳遂匸皞序畴廒刉叨ｌ@r'1夁琀嘯乲穳"));
            }
            throw new BusinessException(FM_Int.replace(158, "丙浡亽逆卾皆庑甠庄则另８Vjy5奇瑀嘡乶稵"), ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] bArr = new byte[7];
        bArr[1] = TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[5] = Constants.TagName.CARD_APP_ACTIVATION_STATUS;
        bArr[6] = (byte) 1;
        Object a = m13029a(bArr);
        byte[] b = m13030b(a);
        if (b == null || !Arrays.equals(b, this.f9710d)) {
            throw new BusinessException(FM_CN.equals("菡厑乒派其亯卽皉匿厸斶｝忇夗琂皑卧乚晧乓洽亿逖卼", 3), ErrorMessage.local_get_app_info_no_sptcc);
        } else if (!FM_Bytes.isEnd9000(a)) {
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, new StringBuilder(FM_CN.equals("菠厞乓洽具亨卼皊匾厧斷～遊拽DRA房蠅彘平&", 4)).append(FM_Bytes.bytesToHexString(a)).toString());
            }
            throw new BusinessException(FM_Long.copyValueOf("莻叟丌浴公仹医盓匵厦斸ｇ遁抬\u0003\u001b\u001a戾蠚彑幨", 4), ErrorMessage.local_message_apdu_execute_exception);
        } else if (a.length >= 42) {
            System.arraycopy(a, 34, obj, 0, obj.length);
            return obj;
        } else {
            bArr = new byte[5];
            bArr[1] = (byte) -80;
            bArr[2] = Constants.TagName.PREDEPOSIT_TYPE;
            a = m13029a(bArr);
            if (!FM_Bytes.isEnd9000(a)) {
                if (this.f9707a != null) {
                    this.f9707a.warn(this.f9708b, new StringBuilder(FM_Utils.regionMatches(4, 74, "菣又丂津兰仢危盞匥叹斮．遅拿1斓亨哅廆弞帾j")).append(FM_Bytes.bytesToHexString(a)).toString());
                }
                throw new BusinessException(FM_Bytes.concat("菮參丛洺儥亡占皙匸厢旧！遀抬0(斞亣咜庙弋幽", 2, 28), ErrorMessage.local_message_apdu_execute_exception);
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
        cardAppRecord.setAmount(Integer.parseInt(FM_Bytes.bytesToHexString(new byte[]{bArr[5], bArr[6], bArr[7], bArr[8]}), 16));
        cardAppRecord.setBalance(FM_Bytes.bytesToInt(new byte[]{bArr[2], bArr[3], bArr[4]}));
        cardAppRecord.setOriTradeType(bArr[12]);
        cardAppRecord.setOriTradeType(bArr[9]);
        EnumTradeType enumTradeType = (EnumTradeType) map.get(FM_Bytes.bytesToHexString(bArr2) + FM_Bytes.bytesToHexString(bArr3));
        EnumTradeType a = m13028a(bArr[12], bArr[9]);
        if (a != null) {
            cardAppRecord.setTradeType(a);
        } else {
            cardAppRecord.setTradeType(enumTradeType);
        }
        cardAppRecord.setTradeDevice(FM_Bytes.bytesToHexString(new byte[]{bArr[10], bArr[11], bArr[12], bArr[13], bArr[14], bArr[15]}));
        return cardAppRecord;
    }

    public String getDateTime4File07(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(FM_Bytes.bytesToInt(new byte[]{bArr[0], bArr[1]}) >> 4));
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
        if (this.f9707a == null) {
            this.f9707a = LogFactory.getInstance().getLog();
        }
        if (this.f9707a != null) {
            this.f9707a.info(this.f9708b, Util4Java.endsWith("R\u000fIXy1tp4ocdii+-", 4, 94));
        }
        if (this.f9714h != null) {
            return CardTools.getFaceID4UID(Arrays.copyOfRange(getAppNo(), 4, 8));
        }
        if (this.f9707a != null) {
            this.f9707a.warn(this.f9708b, FM_Int.replace(3, "華厍匿靣右旱＆L`wc夝琚噷丸穿"));
        }
        throw new BusinessException(FM_Bytes.concat("菭反卽霿厩早ｌ\u0000rg1奁琀噯乲稳", 3, 33), ErrorMessage.local_business_apdu_handler_null);
    }

    public String getMOC() throws BusinessException {
        byte[] bArr = new byte[5];
        bArr[0] = Byte.MIN_VALUE;
        bArr[1] = (byte) -54;
        bArr[4] = (byte) 9;
        bArr = m13029a(bArr);
        if (FM_Bytes.isEnd9000(bArr)) {
            return FM_Bytes.bytesToHexString(Arrays.copyOf(bArr, bArr.length - 2));
        }
        if (this.f9707a != null) {
            this.f9707a.warn(this.f9708b, new StringBuilder(FM_Long.copyValueOf("菹厝伇庿邪读讝硘斠｟\u0011\u001d\u000e\u0012捃亥迊囅绋枉夣贪＀{csosir．", 230)).append(FM_Bytes.bytesToHexString(bArr)).toString());
        }
        throw new BusinessException(FM_Exception.insert(6, 97, "莽厝坄孕劑育镑宋犤恒斢９W\u0007\u001cL挝亿奘琛夯赺"), ErrorMessage.local_business_execute_fail);
    }

    public EnumCardAppStatus getStatus() throws BusinessException {
        EnumCardAppStatus enumCardAppStatus = EnumCardAppStatus.STATUS_INSTALL;
        if (this.f9707a != null) {
            this.f9707a.info(this.f9708b, BCCUtil.getChars("菤厝弐刖厂蠇狵怚=%-", 3, 120));
        }
        if (this.f9714h == null) {
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, Util4Java.endsWith("菨厕匦丁庛畻弄剖犩怂斱ｇNc3.夛琅噯乱稵", 2, 100));
            }
            throw new BusinessException(FM_Long.copyValueOf("莼叞卤丈廋畴弊创狥恑斻ｆ\u00064%+奟瑞嘽乨稵", 3), ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] bArr = new byte[5];
        bArr[1] = (byte) -80;
        bArr[2] = Constants.TagName.PREDEPOSIT_TYPE;
        try {
            byte[] transceive = this.f9714h.transceive(bArr);
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
                transceive = this.f9714h.transceive(bArr2);
            } catch (Exception e) {
                if (this.f9707a != null) {
                    this.f9707a.error(this.f9708b, new StringBuilder(FM_CN.equals("剼旤晵呭圔孕锟宕时｝彀幫~", 5)).append(Util4Java.getExceptionInfo(e)).toString());
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
                    date = new SimpleDateFormat(FM_CN.equals("/>!0WFxi", 3)).parse(bytesToHexString);
                } catch (ParseException e2) {
                    if (this.f9707a != null) {
                        this.f9707a.warn(this.f9708b, new StringBuilder(BCCUtil.getChars("菤叜淉贡勐胻锜寎犽恃旯｜莰又监早杜栦彞弊帧l", 3, 55)).append(bytesToHexString).toString());
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
                if (!FM_Bytes.isEnd9000(this.f9714h.transceive(bArr))) {
                    return enumCardAppStatus;
                }
                try {
                    bArr = this.f9714h.transceive(FM_Bytes.hexStringToBytes(FM_Bytes.concat(";{f)3;cksI!kr#,1sb.2>`oz9Ub{zQ)", 140, 104)));
                    return FM_Bytes.isEnd(bArr, new byte[]{Constants.TagName.PLATFORM_NOTICES, (byte) 2}) ? EnumCardAppStatus.STATUS_ACTIVATE : FM_Bytes.isEnd9000(bArr) ? EnumCardAppStatus.STATUS_ACTIVATE : enumCardAppStatus;
                } catch (Exception e3) {
                    if (this.f9707a == null) {
                        return enumCardAppStatus;
                    }
                    this.f9707a.error(this.f9708b, new StringBuilder(BCCUtil.getChars("剷旯匰景吩弞逗斪ｇ坒嬑刅姌匀头赱y", 3, 111)).append(Util4Java.getExceptionInfo(e3)).toString());
                    return enumCardAppStatus;
                }
            } catch (Exception e32) {
                if (this.f9707a == null) {
                    return enumCardAppStatus;
                }
                this.f9707a.error(this.f9708b, new StringBuilder(FM_Int.replace(2, "剳旷匼是吥弆逓旺＃圚孍刅姐匈夰贡=")).append(Util4Java.getExceptionInfo(e32)).toString());
                return enumCardAppStatus;
            }
        } catch (Exception e322) {
            if (this.f9707a == null) {
                return enumCardAppStatus;
            }
            this.f9707a.error(this.f9708b, new StringBuilder(Util4Java.endsWith("莦叐卺乚廑畲彜剉犯恏斵ｔ诶叔'|pc斌件夤赯e", 276, 21)).append(Util4Java.getExceptionInfo(e322)).toString());
            return enumCardAppStatus;
        }
    }

    public String getTime4Validity() throws BusinessException {
        byte[] bArr = new byte[7];
        bArr[1] = TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[5] = Constants.TagName.CARD_APP_ACTIVATION_STATUS;
        bArr[6] = (byte) 1;
        bArr = m13029a(bArr);
        if (FM_Bytes.isEnd9000(bArr)) {
            bArr = m13030b(bArr);
            if (bArr == null || !Arrays.equals(bArr, this.f9710d)) {
                throw new BusinessException(FM_Utils.regionMatches(192, 2, "莧叄亰逌卹佃颁旨ｌ忇奀瑀盌匫乁晡乚津仰遌匹"), ErrorMessage.local_get_app_info_no_sptcc);
            }
            bArr = new byte[5];
            bArr[1] = (byte) -80;
            bArr[2] = Constants.TagName.PREDEPOSIT_TYPE;
            bArr = m13029a(bArr);
            if (!FM_Bytes.isEnd9000(bArr)) {
                if (this.f9707a != null) {
                    this.f9707a.error(this.f9708b, new StringBuilder(Util4Java.endsWith("莶叏匰七廕由杘敁杞斯＝讲受h$旎价夨赴３", 4, 56)).append(FM_Bytes.bytesToHexString(bArr)).toString());
                }
                throw new BusinessException(BCCUtil.getChars("菢叞卺丄廕畼李攒朒时？讽厏}j斕仳天赮", 5, 19), ErrorMessage.local_business_execute_fail);
            } else if (bArr.length < 29) {
                if (this.f9707a != null) {
                    this.f9707a.error(this.f9708b, new StringBuilder(FM_Long.copyValueOf("莼叞卤丈廋畴材攞杌斦ａ讱厑ut旙亭奩走ｈ", 3)).append(FM_Bytes.bytesToHexString(bArr)).toString());
                }
                throw new BusinessException(BCCUtil.getChars("菥厒卷乂庎甤杗敘朝斢＊讣厜-{旇令奵贳", 2, 82), ErrorMessage.local_business_execute_fail);
            } else {
                return FM_Bytes.bytesToHexString(new byte[]{bArr[24], bArr[25], bArr[26], bArr[27]});
            }
        }
        if (this.f9707a != null) {
            this.f9707a.error(this.f9708b, new StringBuilder(FM_Exception.insert(4, 41, "莿叇医三庘畽杗敏杏斯．遂抽庉畮皡彍奰赯）")).append(FM_Bytes.bytesToHexString(bArr)).toString());
        }
        throw new BusinessException(CRCUtil.substring(2, "莸双卤业序畮杘攔杘斤ｑ送拺床甡盺彊捍亱奄瑍奧贤"), ErrorMessage.local_business_execute_fail);
    }

    public boolean isLock4Consume() throws BusinessException {
        if (this.f9707a == null) {
            this.f9707a = LogFactory.getInstance().getLog();
        }
        if (this.f9714h == null) {
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, FM_Utils.regionMatches(4, 9, "菣压圎字劇胼锋安犪恄斸｛\u000196.夀琋噾严穲"));
            }
            throw new BusinessException(FM_Int.replace(3, "華厍仺逛卥佞颗旻＜Rf}i夛琄噭串穱"), ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] bArr = new byte[8];
        new Random().nextBytes(bArr);
        byte[] bArr2 = new byte[5];
        bArr2[1] = (byte) 10;
        bArr2[2] = Constants.TagName.TERMINAL_BACK_INFO_TYPE;
        bArr2[3] = (byte) 4;
        bArr2[4] = (byte) 8;
        bArr2 = m13029a(FM_Bytes.join(bArr2, bArr));
        if (!FM_Bytes.isEnd9000(bArr2)) {
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, FM_Long.copyValueOf("菹厝淀赼勝胢锝它犠怒旦！KW@T挙仿迌囋绁枓夽贬", 198));
            }
            throw new BusinessException(FM_Utils.regionMatches(5, 50, "菢发坑孓劂育销寉犳怖斿７\f\u000fU\u0016挒亣奝琍奬贪"), ErrorMessage.local_business_execute_fail);
        } else if (bArr2.length < 5) {
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, BCCUtil.getChars("莳叄淈起勃肷镙宜犢怃旦２\r\n\f\u0003挃件处琈夭赯", 180, 14));
            }
            throw new BusinessException(FM_Int.replace(SportType.SPORT_TYPE_CLIMB_HILL, "菮厊块孚劚胵锊宔犧怕旡６\\PGS挎仨夋琔夤贽"), ErrorMessage.local_business_execute_fail);
        } else {
            String bytesToHexString = FM_Bytes.bytesToHexString(Arrays.copyOfRange(bArr2, 1, 5));
            try {
                return bArr2[0] == (byte) 0 || new SimpleDateFormat(CRCUtil.substring(232, ",yroLAs&")).parse(bytesToHexString).getTime() < System.currentTimeMillis();
            } catch (ParseException e) {
                if (this.f9707a != null) {
                    this.f9707a.warn(this.f9708b, new StringBuilder(Util4Java.endsWith("莪又涗费办胿锂实犳怇旱＄莾叜皏早朒栲开弒帩(", 288, 1)).append(bytesToHexString).toString());
                }
                throw new BusinessException(FM_Exception.insert(4, 23, "莿叉圞嬕勛肦锓宓狶恖斸）]C\u000e\u0014损仫夂琛奥赮"), ErrorMessage.local_business_execute_fail);
            }
        }
    }

    public boolean isLock4Load() throws BusinessException {
        if (this.f9707a == null) {
            this.f9707a = LogFactory.getInstance().getLog();
        }
        if (this.f9714h == null) {
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, FM_Long.copyValueOf("莵叉圔孁劉胮锑宗犼怆旲－\u001f+< 奖瑉嘤乳稼", 282));
            }
            throw new BusinessException(FM_Long.copyValueOf("莺叜亣逞占伇飆斮ｙ\u0013?(<奂瑅嘨乧稠", 5), ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] bArr = new byte[8];
        new Random().nextBytes(bArr);
        byte[] bArr2 = new byte[5];
        bArr2[1] = (byte) 10;
        bArr2[2] = Constants.TagName.ACTIVITY_CODE;
        bArr2[3] = (byte) 4;
        bArr2[4] = (byte) 8;
        bArr2 = m13029a(FM_Bytes.join(bArr2, bArr));
        if (!FM_Bytes.isEnd9000(bArr2)) {
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, FM_Bytes.concat("華取址嬈劇肽镉宊犮恁旾＜\u0019PL\u0005损令辜嚎绋柜她贵", 1, 40));
            }
            throw new BusinessException(FM_Int.replace(94, "菤厀坑嬄勀肿镄寒狽恏斧ｘ\u0016\n\u0019U挄仢复琊夾贷"), ErrorMessage.local_business_execute_fail);
        } else if (bArr2.length < 5) {
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, FM_Bytes.concat("莸參坓嬙勘胰锒寃狩恄旽＝\u0016\r\u0007\\挈亱奟瑇夶质", SyslogAppender.LOG_LOCAL7, 102));
            }
            throw new BusinessException(FM_CN.equals("莢叐土子勆肷镚寖犫怏早＜@\u0002\u0007\u0001捂仲夃琞夸赿", 194), ErrorMessage.local_business_execute_fail);
        } else {
            String bytesToHexString = FM_Bytes.bytesToHexString(Arrays.copyOfRange(bArr2, 1, 5));
            try {
                return bArr2[0] == (byte) 0 || new SimpleDateFormat(FM_Bytes.concat("\":2jVN/7", 4, 104)).parse(bytesToHexString).getTime() < System.currentTimeMillis();
            } catch (ParseException e) {
                if (this.f9707a != null) {
                    this.f9707a.warn(this.f9708b, new StringBuilder(FM_Utils.regionMatches(4, 72, "菣及涌赵劋股锅寖犢恝斲＀菣及盀早杋栠弋彎帬f")).append(bytesToHexString).toString());
                }
                throw new BusinessException(FM_Long.copyValueOf("莾叐國存勂肧镖寎狧恏施ｄ\u0004\u0012\u001b\t捞亲套瑖奼赯", 1), ErrorMessage.local_business_execute_fail);
            }
        }
    }

    public int queryBalance() throws BusinessException {
        if (this.f9707a == null) {
            this.f9707a = LogFactory.getInstance().getLog();
        }
        if (this.f9707a != null) {
            this.f9707a.info(this.f9708b, FM_Int.replace(48, "VX_M1v{{s#&fgba"));
        }
        if (this.f9714h == null) {
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, BCCUtil.getChars("菢叅亵違匬佒颔斱ｉBq{(奟琟噿乯稩", 5, 30));
            }
            throw new BusinessException(FM_Exception.insert(316, 114, "菷叄亠逌卩伃飑斨｜\u0003dbm夎瑚嘦乺稨"), ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] bArr = new byte[7];
        bArr[1] = TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[5] = Constants.TagName.CARD_APP_ACTIVATION_STATUS;
        bArr[6] = (byte) 1;
        bArr = m13030b(m13029a(bArr));
        if (bArr == null || !Arrays.equals(bArr, this.f9710d)) {
            throw new BusinessException(FM_Exception.insert(3, 125, "莰叒亥遄区企飈斤ｃ忉奍瑀盇匡乐晵九洣仵達匪"), ErrorMessage.local_get_app_info_no_sptcc);
        }
        bArr = new byte[17];
        bArr[0] = Byte.MIN_VALUE;
        bArr[1] = Constants.TagName.ORDER_BRIEF_INFO_LIST;
        bArr[2] = (byte) 3;
        bArr[3] = (byte) 2;
        bArr[4] = Constants.TagName.IDENTIFYING_TYPE;
        bArr[5] = (byte) 1;
        bArr[16] = (byte) 15;
        bArr = m13029a(bArr);
        if (bArr.length < 9) {
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, FM_CN.equals("莸取亵逘匲伝飈新；IIN\u000e咁廉益敯捾旡敚", 188));
            }
            throw new BusinessException(Util4Java.endsWith("菸厊仭逌卢佉飀於｛咉庅敮捥斸攍", 242, 109), ErrorMessage.local_get_app_info_fail);
        }
        return FM_Bytes.bytesToInt(Arrays.copyOf(bArr, 4)) - FM_Bytes.bytesToInt(new byte[]{bArr[6], bArr[7], bArr[8]});
    }

    public List<CardAppRecord> readAppRecords() throws BusinessException {
        List arrayList = new ArrayList();
        if (this.f9707a != null) {
            this.f9707a.info(this.f9708b, BCCUtil.getChars("\u0013I\u0006\b$<&(3p#7z$p',u", AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED, 89));
        }
        if (this.f9714h == null) {
            if (this.f9707a != null) {
                this.f9707a.warn(this.f9708b, FM_Exception.insert(3, 105, "莰历份晑讻彁斫ｊ\u000ehe套瑚嘭临穭"));
            }
            throw new BusinessException(BCCUtil.getChars("菦厘亯昛诵弗早ｐ\u0018fw%奉琌噯乾稻", 1, 93), ErrorMessage.local_business_apdu_handler_null);
        }
        byte[] bArr = new byte[7];
        bArr[1] = TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[5] = Constants.TagName.CARD_APP_ACTIVATION_STATUS;
        bArr[6] = (byte) 1;
        bArr = m13030b(m13029a(bArr));
        if (bArr == null || !Arrays.equals(bArr, this.f9710d)) {
            throw new BusinessException(FM_Long.copyValueOf("莼叞丏浵儳仸匸盒价晃诽弟斱ｈ忄奚瑝盜匴也晠乆派仢遙匡", 3), ErrorMessage.local_get_app_info_no_sptcc);
        }
        int i;
        Map hashMap = new HashMap();
        bArr = new byte[7];
        bArr[1] = TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[6] = (byte) 7;
        m13029a(bArr);
        bArr = new byte[5];
        for (i = 1; i <= 10; i++) {
            byte[] bArr2 = new byte[5];
            bArr2[1] = Constants.TagName.APP_TYPE;
            bArr2[2] = (byte) i;
            bArr2[3] = (byte) 4;
            bArr2 = m13029a(bArr2);
            if (Arrays.equals(new byte[]{Constants.TagName.PAY_ORDER_ID, Constants.TagName.ACTIVITY_CODE}, Arrays.copyOfRange(bArr2, bArr2.length - 2, bArr2.length))) {
                break;
            }
            if (bArr2.length >= 16) {
                String dateTime4File07 = getDateTime4File07(Arrays.copyOfRange(bArr2, 10, 15));
                EnumTradeType a = m13027a(bArr2[0]);
                if (!(dateTime4File07 == null || a == null)) {
                    hashMap.put(dateTime4File07, a);
                }
            }
        }
        bArr = new byte[7];
        bArr[1] = TagName.CommandMultiple;
        bArr[4] = (byte) 2;
        bArr[6] = Constants.TagName.ORDER_INVOICE_STATUS;
        m13029a(bArr);
        for (i = 1; i <= 10; i++) {
            bArr2 = new byte[5];
            bArr2[1] = Constants.TagName.APP_TYPE;
            bArr2[2] = (byte) i;
            bArr2[3] = (byte) 4;
            bArr2 = m13029a(bArr2);
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
        this.f9714h = apduHandler;
    }
}
