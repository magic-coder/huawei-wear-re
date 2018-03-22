package cn.com.fmsh.tsm.business.core;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.IMessage;
import cn.com.fmsh.communication.message.IMessageHandler;
import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.tsm.business.BusinessExtend;
import cn.com.fmsh.tsm.business.bean.ElectronicAndActivity;
import cn.com.fmsh.tsm.business.bean.ElectronicTakeUp;
import cn.com.fmsh.tsm.business.bean.IdentifyingCode;
import cn.com.fmsh.tsm.business.bean.MainOrder;
import cn.com.fmsh.tsm.business.bean.PromotionMessage;
import cn.com.fmsh.tsm.business.constants.Constants.RespCodeonse4Platform;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import cn.com.fmsh.tsm.business.enums.EnumCardIoType;
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
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.net.SyslogAppender;

public class BusinessExtendImpl implements BusinessExtend {
    /* synthetic */ FMLog f9716a = null;
    private final /* synthetic */ String f9717b = CardAppTradeImpl.class.getName();
    private /* synthetic */ CardBusinessBasic f9718c;

    public BusinessExtendImpl(CardBusinessBasic cardBusinessBasic) {
        this.f9718c = cardBusinessBasic;
        this.f9716a = LogFactory.getInstance().getLog();
    }

    public int applyForElectronicTakeUp(byte[] bArr, byte[] bArr2) throws BusinessException {
        String substring = CRCUtil.substring(5, "甧孍到甠题");
        if (this.f9716a == null) {
            this.f9716a = LogFactory.getInstance().getLog();
        }
        if (this.f9716a != null) {
            this.f9716a.info(this.f9717b, Util4Java.endsWith("番嬓刿畸颉}9u", 2, 68));
        }
        if (this.f9718c == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(substring)).append(CRCUtil.substring(206, "ｗ乜勰奘琁寫豼串穩")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(FM_Exception.insert(212, 51, "ｔ丑势奕琂嘿列姖卆夲赳")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9718c.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(substring)).append(BCCUtil.getChars("～淄恩处瑜噼临稲", 2, 90)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("ｋ淛恰奏瑑噫乵稡", 202, 44)).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (bArr == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(substring)).append(FM_CN.equals("｛泩材佪兾甹孍制桘讖", 4)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(BCCUtil.getChars("｟泥杜佦兲甽孉刲桜變", 3, 113)).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (bArr2 == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(substring)).append(FM_CN.equals("ｔ注杓佫兹甸孎刷类埚", 5)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(BCCUtil.getChars("ｊ波有佽儿產孄剩簵垀", 246, 93)).toString(), ErrorMessage.local_message_load_config_fail);
        } else {
            String server4Business = this.f9718c.getServer4Business(TradeCode.APPLY_FOR_ELECTRONIC_TAKEUP);
            if (server4Business == null) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("斩ｘ莾厈套琎盙帡号奭赴", 2, 85)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("斥＝菸叛奏琏盃并厳夰贺", 92, 62)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9718c.businessReady(substring, server4Business);
            byte[] bArr3 = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.APPLY_FOR_ELECTRONIC_TAKEUP);
            try {
                ITag createTag = messageHandler.createTag((byte) TagName.ELECTRONIC_ID);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
                ITag createTag2 = messageHandler.createTag((byte) TagName.ELECTRONIC_TYPE_ID);
                createTag2.addValue(bArr2);
                createMessage.addTag(createTag2);
                bArr3 = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(substring)).append(FM_CN.equals("斠ｋ柜適幩叻诫汏攮挡冺珡彀師＞", 3)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(BCCUtil.getChars("旨＋柔遹帱叻诣氟收挡凢玱弈幫", 46, 105)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            Object interaction = this.f9718c.interaction(bArr3, substring, false, server4Business);
            Object obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                return 0;
            }
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(FM_Int.replace(1, "畾扮侽怰俬攼2")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            return FM_CN.bcdBytesToInt(obj);
        }
    }

    public MainOrder applyPromotion(byte[] bArr) throws BusinessException {
        String equals = FM_CN.equals("異找侙镋洧讯卋甼请", 5);
        if (this.f9716a == null) {
            this.f9716a = LogFactory.getInstance().getLog();
        }
        if (this.f9716a != null) {
            this.f9716a.info(this.f9717b, FM_Int.replace(5, "畲扪促锃洽讫卙甼该;65"));
        }
        if (bArr == null || bArr.length < 1) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(equals)).append(FM_Exception.insert(78, 47, "斤－机使八筣呁敫挤")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Long.copyValueOf("旸＇伨兠皆厝攬彛幮", 6)).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9718c == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith("－乛加奅琇宸豠乻穻", 4, 64)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Int.replace(2, "｛乀勼处琅噮刔姇匙夣贰")).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9718c.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("ｙ淎怸奌琟噢両究", 2)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith("－涉怮奅琇噩乻稻", 4, 32)).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9718c.getServer4Business(TradeCode.QUERY_ELECTRONIC_TAKEUP_LIST);
            if (server4Business == null) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("旡？莸叝夃琅盛帨厧奢赪", 288, ReportInfoUtils.FEEDBACK_FAILED)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(3, "旦７莱叇夘瑁盖帮厸奢赻")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9718c.businessReady(equals, server4Business);
            byte[] bArr2 = null;
            IMessage createMessage = messageHandler.createMessage(1201);
            try {
                ITag createTag = messageHandler.createTag((byte) TagName.ACTIVITY_INFO);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
                bArr2 = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(equals)).append(BCCUtil.getChars("斥ｗ枇逫幠叫说汉散捵冹珻彑幣ｙ", 3, 8)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(BCCUtil.getChars("斥：柝逼帬厲诲氊敻挠凫珤引幢", 3, 67)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            Object interaction = this.f9718c.interaction(bArr2, equals, false, server4Business);
            Object obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                if (this.f9716a != null) {
                    this.f9716a.error(this.f9717b, new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("斠ｋ師厹夞琍夭质do", 3)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Int.replace(3, "斮ｗ席叱夀琁夻质")).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
            }
            MainOrder mainOrder = null;
            try {
                ITag tag4Id = messageHandler.createMessage(1201, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(96);
                if (tag4Id != null) {
                    mainOrder = MainOrder.fromTag(tag4Id);
                }
            } catch (Exception e2) {
                if (this.f9716a != null) {
                    this.f9716a.error(this.f9717b, new StringBuilder(String.valueOf(equals)).append(FM_Exception.insert(1, 101, "旳ｆ覬构幪厮咎廜凷玢录幤{&")).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Utils.regionMatches(340, 45, "斲｝觽柛師叵咟廋夽赼")).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            return mainOrder;
        }
    }

    public IdentifyingCode obtainIdentifyingCode(int i, String str) throws BusinessException {
        String endsWith = Util4Java.endsWith("菨叕髋變砎俲怸", TransportMediator.KEYCODE_MEDIA_RECORD, 36);
        if (this.f9716a == null) {
            this.f9716a = LogFactory.getInstance().getLog();
        }
        if (this.f9716a != null) {
            this.f9716a.info(this.f9717b, BCCUtil.getChars("莻叏髊诒硁侬恵iz/", 284, 45));
        }
        if (i < 0) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(endsWith)).append(FM_CN.equals("ｔ注杓还兹莺又骃证硐盆簨埏", 5)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(FM_CN.equals("ｙ泧杞进兼莽反骀讜硏盛簫埊", 2)).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (this.f9718c == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(4, 120, "ｘ乖勥奘瑒宵谥並穮")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(FM_Int.replace(2, "｛乀勼处琅噮刔姇匙夣贰")).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9718c.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(endsWith)).append(FM_Exception.insert(2, 120, "＊淖怹奊瑀嘶乬稴")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(BCCUtil.getChars("～涙恿奋瑈噥丶稱", 2, 31)).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9718c.getServer4Business(1061);
            if (server4Business == null) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(endsWith)).append(FM_Exception.insert(1, 72, "旳ａ莢压夁瑋皑帮厵夼走")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(FM_Int.replace(SyslogAppender.LOG_LOCAL4, "旣４莬又夅琂皃幹叽夡贶")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            ITag createTag;
            this.f9718c.businessReady(endsWith, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage(1061);
            if (str != null) {
                try {
                    createTag = messageHandler.createTag((byte) 5);
                    createTag.addValue(str);
                    createMessage.addTag(createTag);
                } catch (Exception e) {
                    if (this.f9716a != null) {
                        this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(endsWith)).append(FM_Exception.insert(5, 76, "旿ｙ枅遭幪叵讦江改捻击珽弛幽＋")).append(Util4Java.getExceptionInfo(e)).toString());
                    }
                    this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(endsWith)).append(FM_CN.equals("斠ｋ柜適幩叻诫汏攮挡冺珡彀師", 3)).toString(), ErrorMessage.local_message_message_handle_exception, false);
                }
            }
            createTag = messageHandler.createTag((byte) TagName.IDENTIFYING_TYPE);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            bArr = createMessage.toBytes();
            bArr = this.f9718c.interaction(bArr, endsWith, false, server4Business);
            if (!Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(bArr, 2))) {
                if (this.f9716a != null) {
                    this.f9716a.error(this.f9717b, new StringBuilder(String.valueOf(endsWith)).append(FM_Bytes.concat("斯ｆ帨厼哐庚锆诿哌廆硂ne", 2, 113)).append(FM_Bytes.bytesToHexString(bArr)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(endsWith)).append(CRCUtil.substring(2, "旹６并叠够瑀奠赹")).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(Arrays.copyOf(bArr, 2))), true);
            }
            IdentifyingCode identifyingCode = new IdentifyingCode();
            try {
                IMessage createMessage2 = messageHandler.createMessage(1061, Arrays.copyOfRange(bArr, 2, bArr.length));
                ITag tag4Id = createMessage2.getTag4Id(12);
                if (tag4Id != null) {
                    identifyingCode.setCode(tag4Id.getStringVal());
                }
                ITag tag4Id2 = createMessage2.getTag4Id(64);
                if (tag4Id2 != null) {
                    identifyingCode.setSerial(tag4Id2.getTagValue());
                }
            } catch (FMCommunicationMessageException e2) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(endsWith)).append(FM_CN.equals("斢i覵柗幫叹哗废攬挣彜幷ｚ", 1)).append(FM_Bytes.bytesToHexString(bArr)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(endsWith)).append(FM_Exception.insert(4, 6, "旾\"觷枊平叶品庆敨捰奵赯")).toString(), ErrorMessage.local_message_command_data_invaild, false);
            }
            return identifyingCode;
        }
    }

    public ElectronicAndActivity queryActivity(int i, int i2) throws BusinessException {
        String replace = FM_Int.replace(242, "浼勢ｅ略嬃剮ｐ侽怰柧诧");
        if (this.f9716a == null) {
            this.f9716a = LogFactory.getInstance().getLog();
        }
        if (this.f9716a != null) {
            this.f9716a.info(this.f9717b, FM_Long.copyValueOf("甸孚刿刓衩便怴枽讷|ab", 5));
        }
        if (this.f9718c == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(replace)).append(FM_CN.equals("ｘ也勷奃琞寰豻丱稦", 1)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Exception.insert(3, 36, "＋丑勮套琑噳剂姈匑奺赪")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9718c.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(replace)).append(FM_Bytes.concat("ｉ淗怶套瑋嘯乻穡", 110, 122)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Exception.insert(2, 54, "＊涔怽夌瑘噼买空")).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (i < 0) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(replace)).append(FM_Exception.insert(266, 85, "＂佣兽皉撏佋籷埊丛吃沕")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Long.copyValueOf("％伦兦的撐伆簬域乜呆沞", 1)).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (i2 < 0) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(replace)).append(FM_Utils.regionMatches(3, 103, "｟佺儤皌擂伊斫廋丆吚沌")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(CRCUtil.substring(246, "／伮兼皀擂但斳廟乖呎沄")).toString(), ErrorMessage.local_message_load_config_fail);
        } else {
            String server4Business = this.f9718c.getServer4Business(TradeCode.QUERY_ELECTRONIC_ACTIVITY);
            if (server4Business == null) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(replace)).append(Util4Java.endsWith("旷ａ菮厓夕琛皍带厱奼贼", 4, 108)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Exception.insert(60, 37, "斶ｉ莽叙奐瑟皚帰厸夼贷")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9718c.businessReady(replace, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.QUERY_ELECTRONIC_ACTIVITY);
            try {
                ITag createTag = messageHandler.createTag((byte) TagName.BUSINESS_ORDER_OP_TYPE);
                createTag.addValue(i);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) TagName.OPERATE_TIMING);
                createTag.addValue(i2);
                createMessage.addTag(createTag);
                bArr = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(replace)).append(BCCUtil.getChars("斣；柝逻帮可诶氁敵挩凳珻式幷＋", 5, 66)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(FM_CN.equals("斡ｄ柝遪幨叼诪汌支挾冻珢彁帬", 4)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            byte[] interaction = this.f9718c.interaction(bArr, replace, false, server4Business);
            bArr = Arrays.copyOf(interaction, 2);
            if (!Arrays.equals(RespCodeonse4Platform.SUCESS, bArr)) {
                if (this.f9716a != null) {
                    this.f9716a.error(this.f9717b, new StringBuilder(String.valueOf(replace)).append(Util4Java.endsWith("旷＀幤史哀庌镚计咔廐硎`%", 4, 11)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(FM_Exception.insert(4, 76, "旾ｘ平厼夜琂奡费")).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr)), true);
            }
            ElectronicAndActivity electronicAndActivity = new ElectronicAndActivity();
            try {
                byte[] bArr2;
                byte[] bArr3;
                IMessage createMessage2 = messageHandler.createMessage(TradeCode.QUERY_ELECTRONIC_ACTIVITY, Arrays.copyOfRange(interaction, 2, interaction.length));
                ITag tag4Id = createMessage2.getTag4Id(-113);
                if (tag4Id != null) {
                    for (ITag tag4Id2 : tag4Id2.getItemTags()) {
                        if (tag4Id2 != null) {
                            bArr2 = null;
                            bArr3 = null;
                            for (ITag iTag : tag4Id2.getItemTags()) {
                                switch (iTag.getId()) {
                                    case (byte) -114:
                                        bArr2 = iTag.getBytesVal();
                                        break;
                                    case (byte) 28:
                                        bArr3 = iTag.getBytesVal();
                                        break;
                                    default:
                                        break;
                                }
                                electronicAndActivity.addUrl(bArr3, bArr2);
                            }
                        }
                    }
                }
                tag4Id2 = createMessage2.getTag4Id(51);
                if (tag4Id2 != null) {
                    for (ITag tag4Id22 : tag4Id22.getItemTags()) {
                        if (tag4Id22 != null) {
                            bArr2 = null;
                            bArr3 = null;
                            for (ITag iTag2 : tag4Id22.getItemTags()) {
                                switch (iTag2.getId()) {
                                    case (byte) 71:
                                        bArr3 = iTag2.getBytesVal();
                                        break;
                                    case (byte) 113:
                                        bArr2 = iTag2.getBytesVal();
                                        break;
                                    default:
                                        break;
                                }
                                electronicAndActivity.addActivity(bArr2, bArr3);
                            }
                        }
                    }
                }
            } catch (FMCommunicationMessageException e2) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(replace)).append(FM_Exception.insert(3, 108, "旱覼柛幤右哂廏攷挽弝帳－")).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(FM_Exception.insert(3, 81, "旱t觪柊常召咀床敿挮夠货")).toString(), ErrorMessage.local_message_command_data_invaild, false);
            }
            return electronicAndActivity;
        }
    }

    public ElectronicTakeUp queryElectronicTakeUp(byte[] bArr, byte[] bArr2) throws BusinessException {
        String equals = FM_CN.equals("畭嬙剢训绚俬恱柪询", 5);
        if (this.f9716a == null) {
            this.f9716a = LogFactory.getInstance().getLog();
        }
        if (this.f9716a != null) {
            this.f9716a.info(this.f9717b, FM_Utils.regionMatches(224, 12, "略嬌剰讲细俭恷柡诲2fz"));
        }
        if (this.f9718c == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(equals)).append(FM_Exception.insert(50, 17, "：九勹奍瑜寲豽丷穤")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("ｕ之勨奅瑟嘹剔妊匏夠贬", 2, 120)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9718c.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("ｔ淁怵奏琚噥两穵", 5)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(BCCUtil.getChars("｝涉怾夅琗嘩丫稻", 1, 48)).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (bArr == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(172, "５泥杆佺儠略嬋刾栖诚")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("ｔ沢杇佹兡畺嬊刽桗讝", 1, 43)).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (bArr2 == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(equals)).append(FM_Int.replace(1, "ｚ泸杕使內田存刳籵垚")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("ｗ泠朎佭其畬孏剽籰埚", 4, 70)).toString(), ErrorMessage.local_message_load_config_fail);
        } else {
            String server4Business = this.f9718c.getServer4Business(TradeCode.QUERY_ELECTRONIC_TAKEUP);
            if (server4Business == null) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(HttpStatus.SC_MOVED_TEMPORARILY, "旭ｊ菦厊奃瑔盙幻口夯贬")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Exception.insert(1, 30, "旳／菶厉奙琝皝帤厥夢贴")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9718c.businessReady(equals, server4Business);
            byte[] bArr3 = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.QUERY_ELECTRONIC_TAKEUP);
            try {
                ITag createTag = messageHandler.createTag((byte) TagName.ELECTRONIC_ID);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) TagName.ELECTRONIC_TYPE_ID);
                createTag.addValue(bArr2);
                createMessage.addTag(createTag);
                bArr3 = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(5, "旤１枌逳幭厹讣氝攺挻出玻弔帹６")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith("旵２枝逴幼叺诲求攫挸冫珼彅幺", 294, ReportInfoUtils.FEEDBACK_SUCCESS)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            byte[] interaction = this.f9718c.interaction(bArr3, equals, false, server4Business);
            if (!Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(interaction, 2))) {
                if (this.f9716a != null) {
                    this.f9716a.error(this.f9717b, new StringBuilder(String.valueOf(equals)).append(FM_Long.copyValueOf("旸＇幻叵哏庋锅诶哛庇砑7*", 166)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("斳ｒ幤叠奍瑄奪贱", 366, 25)).toString(), ErrorMessage.local_message_platform_business_handle_fail, true);
            }
            ElectronicTakeUp electronicTakeUp = null;
            try {
                ITag tag4Id = messageHandler.createMessage(TradeCode.QUERY_ELECTRONIC_TAKEUP, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(107);
                if (tag4Id == null) {
                    if (this.f9716a != null) {
                        this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(equals)).append(FM_Long.copyValueOf("斲m幭叫哕庁敢捡沭最匃吨电孍刢俶恻", 316)).toString());
                    }
                    this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("斮e帩去哑庙敮捡没杘升呸畱孅刾俶恧", 5)).toString(), ErrorMessage.local_message_command_data_invaild, false);
                }
                electronicTakeUp = ElectronicTakeUp.fromTag(tag4Id);
            } catch (FMCommunicationMessageException e2) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("斯}觪枑帪叡哄廕敩捿彋幹＃", 2, 88)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Int.replace(3, "斮w覽枑幷号哇庙敠捽大贼")).toString(), ErrorMessage.local_message_command_data_invaild, false);
            }
            return electronicTakeUp;
        }
    }

    public List<ElectronicTakeUp> queryElectronicTakeUps(byte[] bArr, byte b, int i) throws BusinessException {
        String concat = FM_Bytes.concat("畩孙剮刔衸侼恥柲讦", 5, 45);
        if (this.f9716a == null) {
            this.f9716a = LogFactory.getInstance().getLog();
        }
        if (this.f9716a != null) {
            this.f9716a.info(this.f9717b, FM_Bytes.concat("畾孜創则蠧俱怾柷讱:{8", 340, 65));
        }
        if (this.f9718c == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(concat)).append(FM_Utils.regionMatches(6, 105, "ｚ久勩夕琜寺谭乯穤")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(5, "ｖ乇务备琀噡刑姄匄夤贽")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9718c.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("ｔ淝怽奋瑊嘡乼稹", AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("｝淕恦夑琇噥丣稿", 1, 12)).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (i < 0) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("９伨儾皊甴嬄刿枿讯条攣之向沙", 190, 83)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("～佶儿盚男孖刲柫诰杷敪专吊泓", 2, 4)).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (b < (byte) 0) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(concat)).append(Util4Java.endsWith("－佼儲盖畸嬘剻狨恘乙呇沟", 4, ReportInfoUtils.FEEDBACK_SUCCESS)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(360, "ｑ你儦盂畼嬜剷狤恔乕呓沋")).toString(), ErrorMessage.local_message_load_config_fail);
        } else {
            String server4Business = this.f9718c.getServer4Business(TradeCode.QUERY_ELECTRONIC_TAKEUP_LIST);
            if (server4Business == null) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(concat)).append(Util4Java.endsWith("斩｀菮厐夗理皉帩厷奥赤", 2, 109)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Exception.insert(190, 80, "斴＞菵叄夆瑔皆帡厲夣赧")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            ITag createTag;
            this.f9718c.businessReady(concat, server4Business);
            byte[] bArr2 = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.QUERY_ELECTRONIC_TAKEUP_LIST);
            if (bArr != null) {
                try {
                    if (bArr.length > 0) {
                        createTag = messageHandler.createTag((byte) TagName.ELECTRONIC_TYPE_ID);
                        createTag.addValue(bArr);
                        createMessage.addTag(createTag);
                    }
                } catch (Exception e) {
                    if (this.f9716a != null) {
                        this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(concat)).append(CRCUtil.substring(5, "旤１枌逳幭厹讣氝攺挻出玻弔帹６")).append(Util4Java.getExceptionInfo(e)).toString());
                    }
                    this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("旺％枂連平厭训氕攤挿冴珻彊幽", 4)).toString(), ErrorMessage.local_message_message_handle_exception, false);
                }
            }
            createTag = messageHandler.createTag((byte) TagName.ELECTRONIC_STATE);
            createTag.addValue((int) b);
            createMessage.addTag(createTag);
            createTag = messageHandler.createTag((byte) TagName.QUERY_RECORD_COUNT);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            bArr2 = createMessage.toBytes();
            byte[] interaction = this.f9718c.interaction(bArr2, concat, false, server4Business);
            bArr2 = Arrays.copyOf(interaction, 2);
            if (!Arrays.equals(RespCodeonse4Platform.SUCESS, bArr2)) {
                if (this.f9716a != null) {
                    this.f9716a.error(this.f9717b, new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("斢ｕ幭厳咅庙锋许咑底硇q0", 228, 37)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("旺％幵右处瑛奫赲", 4)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr2)), true);
            }
            List<ElectronicTakeUp> arrayList = new ArrayList();
            try {
                ITag tag4Id = messageHandler.createMessage(TradeCode.QUERY_ELECTRONIC_TAKEUP_LIST, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(108);
                if (tag4Id != null) {
                    ITag[] itemTags = tag4Id.getItemTags();
                    if (itemTags != null && itemTags.length >= 1) {
                        for (ITag iTag : itemTags) {
                            if (iTag != null) {
                                ElectronicTakeUp fromTag = ElectronicTakeUp.fromTag(iTag);
                                if (fromTag != null) {
                                    arrayList.add(fromTag);
                                }
                            }
                        }
                    } else if (this.f9716a != null) {
                        this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("斯p帬史沤朁甾孞利俵恸雜吕信恬丼穳", 2, 3)).toString());
                    }
                } else if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(concat)).append(FM_CN.equals("旳ｚ帴厨注朓甾孌刵便怠", 274)).toString());
                }
            } catch (FMCommunicationMessageException e2) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("斾3覵枝帷厫哟廝数挹弌幽ｆ", 120, 55)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("旺%觥枓平厭咗廃攤挿奿赮", 132)).toString(), ErrorMessage.local_message_command_data_invaild, false);
            }
            return arrayList;
        }
    }

    public List<ElectronicTakeUp> queryElectronicTakeUpsVer2(byte[] bArr, byte[] bArr2, int i, int i2) throws BusinessException {
        String regionMatches = FM_Utils.regionMatches(272, 89, "电嬉刪刜蠬俼恹枪讪");
        if (this.f9716a == null) {
            this.f9716a = LogFactory.getInstance().getLog();
        }
        if (this.f9716a != null) {
            this.f9716a.info(this.f9717b, FM_Int.replace(2, "畢嬊剥列衫俧恦柩语<;6"));
        }
        if (this.f9718c == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(regionMatches)).append(FM_Exception.insert(218, 74, "ｒ丒勳夘琀宩豻乾穴")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("ｖ丌勳夊瑌噮剟姕卌大起", 3, 60)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9718c.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("ｍ淎怤奔瑓嘲乥穾", 106, 5)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(Util4Java.endsWith("．涎急奊琔噾习稤", 5, 36)).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (i2 < 0) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(5, "＞伽六皗甫嬙剬枺讨朴数丆吞泔")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_Exception.insert(228, 19, "ｄ佻八皅甡嬗剢枨询杲敶且呄沊")).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (i < 0) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(regionMatches)).append(BCCUtil.getChars("ｙ併兰皑畠嬅刭犣恔乘吝泀", 5, 96)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(2, "＃伺兠皔甮嬖剩狪恆也呕泝")).toString(), ErrorMessage.local_message_load_config_fail);
        } else {
            String server4Business = this.f9718c.getServer4Business(TradeCode.QUERY_ELECTRONIC_TAKEUP_LIST_VER2);
            if (server4Business == null) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("斬＋莣受夊琝盌带厲奾赹", 3, 13)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(2, "旹６莲叆够瑀盕帯厷奣赸")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            ITag createTag;
            this.f9718c.businessReady(regionMatches, server4Business);
            byte[] bArr3 = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.QUERY_ELECTRONIC_TAKEUP_LIST_VER2);
            if (bArr2 != null) {
                try {
                    if (bArr2.length > 0) {
                        createTag = messageHandler.createTag((byte) TagName.ELECTRONIC_TYPE_ID);
                        createTag.addValue(bArr2);
                        createMessage.addTag(createTag);
                    }
                } catch (Exception e) {
                    if (this.f9716a != null) {
                        this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(regionMatches)).append(FM_Long.copyValueOf("旺％枂連平厭训氕攤挿冴珻彊幽ｘ", 4)).append(Util4Java.getExceptionInfo(e)).toString());
                    }
                    this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(regionMatches)).append(FM_CN.equals("斯ｆ柟遬幮叾诨汒敱挼冹珤彇帮", 134)).toString(), ErrorMessage.local_message_message_handle_exception, false);
                }
            }
            if (bArr != null && bArr.length > 0) {
                createTag = messageHandler.createTag((byte) TagName.ACTIVITY_INFO);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
            }
            createTag = messageHandler.createTag((byte) TagName.ELECTRONIC_STATE);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            createTag = messageHandler.createTag((byte) TagName.QUERY_RECORD_COUNT);
            createTag.addValue(i2);
            createMessage.addTag(createTag);
            bArr3 = createMessage.toBytes();
            byte[] interaction = this.f9718c.interaction(bArr3, regionMatches, false, server4Business);
            bArr3 = Arrays.copyOf(interaction, 2);
            if (!Arrays.equals(RespCodeonse4Platform.SUCESS, bArr3)) {
                if (this.f9716a != null) {
                    this.f9716a.error(this.f9717b, new StringBuilder(String.valueOf(regionMatches)).append(FM_CN.equals("斠ｋ師厹哗废锅询咓廛硁kb", 3)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(regionMatches)).append(FM_Long.copyValueOf("旺％幵右处瑛奫赲", 4)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr3)), true);
            }
            List<ElectronicTakeUp> arrayList = new ArrayList();
            try {
                ITag tag4Id = messageHandler.createMessage(TradeCode.QUERY_ELECTRONIC_TAKEUP_LIST_VER2, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(108);
                if (tag4Id != null) {
                    ITag[] itemTags = tag4Id.getItemTags();
                    if (itemTags != null && itemTags.length >= 1) {
                        for (ITag iTag : itemTags) {
                            if (iTag != null) {
                                ElectronicTakeUp fromTag = ElectronicTakeUp.fromTag(iTag);
                                if (fromTag != null) {
                                    arrayList.add(fromTag);
                                }
                            }
                        }
                    } else if (this.f9716a != null) {
                        this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(regionMatches)).append(FM_Int.replace(2, "斡v帮台沢朏甼孜刷俳恺雞吓俿恮举穽")).toString());
                    }
                } else if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(regionMatches)).append(Util4Java.endsWith("斥９帤叩泺朔番嬑刻侤恨", 246, 66)).toString());
                }
            } catch (FMCommunicationMessageException e2) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(regionMatches)).append(FM_CN.equals("斣j覴柘幪叺哖庘攭挠彝幨｛", 2)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("断,覦柚幼古咔廊敳挦奼贷", 4, 37)).toString(), ErrorMessage.local_message_command_data_invaild, false);
            }
            return arrayList;
        }
    }

    public List<PromotionMessage> queryPromotionMessage() throws BusinessException {
        String copyValueOf = FM_Long.copyValueOf("甦戼俋锅洹勷侽怶枳讱", 6);
        if (this.f9716a == null) {
            this.f9716a = LogFactory.getInstance().getLog();
        }
        if (this.f9716a != null) {
            this.f9716a.info(this.f9717b, FM_Bytes.concat("畲扼俟镍津劧価恾柧讱*{h", 3, 81));
        }
        if (this.f9718c == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(copyValueOf)).append(Util4Java.endsWith("ｓ丐労处琍寯谠乶稭", 2, 11)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Utils.regionMatches(2, 117, "～九勽奕瑀噳刍姎匌夾贡")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9718c.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Bytes.concat("ｖ淏恻奅琈嘳乲穯", 3, 77)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Bytes.concat("ｐ淐恻夔瑊嘠举空", 5, 92)).toString(), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9718c.getServer4Business(TradeCode.QUERY_ELECTRONIC_TAKEUP_LIST);
        if (server4Business == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(3, 14, "旱９莴叇夛瑋盟帺厧头贶")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(Util4Java.endsWith("旷ｗ莢叙奍瑅皙帤厡夺贠", 132, 90)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9718c.businessReady(copyValueOf, server4Business);
        byte[] bArr = null;
        try {
            bArr = messageHandler.createMessage((int) TradeCode.QUERY_PROMOTION_MESSAGE_LIST).toBytes();
        } catch (Exception e) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(copyValueOf)).append(CRCUtil.substring(5, "旤１枌逳幭厹讣氝攺挻出玻弔帹６")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(copyValueOf)).append(Util4Java.endsWith("斩ｗ枓逳帼去诰汁支捵凭珣彍帳", 2, 92)).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] interaction = this.f9718c.interaction(bArr, copyValueOf, false, server4Business);
        bArr = Arrays.copyOf(interaction, 2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, bArr)) {
            if (this.f9716a != null) {
                this.f9716a.error(this.f9717b, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(244, 122, "斮～帿厶咍廎镍计咅廖砝,0")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Long.copyValueOf("斴３幯叩夒琕夡质", 314)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr)), true);
        }
        List<PromotionMessage> arrayList = new ArrayList();
        try {
            ITag tag4Id = messageHandler.createMessage(TradeCode.QUERY_PROMOTION_MESSAGE_LIST, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(-57);
            if (tag4Id != null) {
                ITag[] itemTags = tag4Id.getItemTags();
                if (itemTags != null && itemTags.length >= 1) {
                    for (ITag iTag : itemTags) {
                        if (iTag != null) {
                            PromotionMessage fromTag = PromotionMessage.fromTag(iTag);
                            if (fromTag != null) {
                                arrayList.add(fromTag);
                            }
                        }
                    }
                } else if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(copyValueOf)).append(BCCUtil.getChars("斣a并厭泴朄田嬍刭俬怪雛吝侬怪丧稯", 5, 88)).toString());
                }
            } else if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(254, 52, "旴：帹叮泳朏甲批俁镖俫恱")).toString());
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Long.copyValueOf("无?觳枝幹号哉底敮捵弚席（", HttpStatus.SC_MOVED_TEMPORARILY)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(4, 15, "旾;觥枅帷厣咏廅数捡夯质")).toString(), ErrorMessage.local_message_command_data_invaild, false);
        }
        return arrayList;
    }

    public MainOrder useElectronicTakeUp(byte[] bArr, byte[] bArr2, byte[] bArr3, EnumCardIoType enumCardIoType) throws BusinessException {
        String chars = BCCUtil.getChars("畡孄刬伫畼", 4, 32);
        if (this.f9716a == null) {
            this.f9716a = LogFactory.getInstance().getLog();
        }
        if (this.f9716a != null) {
            this.f9716a.info(this.f9717b, FM_Bytes.concat("畮嬏剻伸畣a}y", 100, 4));
        }
        if (this.f9718c == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(chars)).append(FM_Int.replace(4, "ｕ乆勾夆球寱豪临穫")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Utils.regionMatches(180, 83, "（乍勫夙瑖嘫刋如匊夾赧")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9718c.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(chars)).append(CRCUtil.substring(4, "＝涔恨外琛嘠乩稤")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(CRCUtil.substring(6, "？涖恦夐琙嘢乯稺")).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (bArr == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(chars)).append(FM_Int.replace(3, "ｔ泺杗伡兡甲孚刵栗试")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(BCCUtil.getChars("ｎ沫望佺內甿嬂剢栅讌", 242, 40)).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (bArr2 == null) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(chars)).append(Util4Java.endsWith("．泭期你兯畡孎到簩垗", 5, 74)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Utils.regionMatches(SyslogAppender.LOG_LOCAL2, 111, "，泮杗佭兹甾孊刱簣埌")).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (bArr3 == null || bArr3.length < 1) {
            if (this.f9716a != null) {
                this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(chars)).append(CRCUtil.substring(3, "＜伻兣皕卽厰斲攕")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Utils.regionMatches(212, 99, "ｈ伧兯盉匱古时攑")).toString(), ErrorMessage.local_message_load_config_fail);
        } else {
            String server4Business = this.f9718c.getServer4Business(TradeCode.USE_ELECTRONIC_TAKEUP);
            if (server4Business == null) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(chars)).append(FM_Exception.insert(172, 95, "旦＃菹厛夈琍盎帺司夶赣")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Utils.regionMatches(4, 37, "斢５莩厕夌琋盖帤召奰赣")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9718c.businessReady(chars, server4Business);
            byte[] bArr4 = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.USE_ELECTRONIC_TAKEUP);
            try {
                ITag createTag = messageHandler.createTag((byte) TagName.ELECTRONIC_ID);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) TagName.ELECTRONIC_TYPE_ID);
                createTag.addValue(bArr2);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 15);
                createTag.addValue(FM_Bytes.bytesToHexString(bArr3));
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) TagName.CARD_FORM);
                createTag.addValue(enumCardIoType.getId());
                createMessage.addTag(createTag);
                bArr4 = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9716a != null) {
                    this.f9716a.warn(this.f9717b, new StringBuilder(String.valueOf(chars)).append(FM_Int.replace(296, "旫，枇逦幺叼诸汐敥捶凡玮彃幼｝")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(chars)).append(FM_Long.copyValueOf("旼＋枀逡席厫讯気攢挡冶珹彄幻", 2)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            Object interaction = this.f9718c.interaction(bArr4, chars, false, server4Business);
            Object obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                if (this.f9716a != null) {
                    this.f9716a.error(this.f9717b, new StringBuilder(String.valueOf(chars)).append(BCCUtil.getChars("斧＜幼厾奉琊夺赯s(", 1, 31)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(chars)).append(FM_CN.equals("斠ｋ師厹夞琍夭质", 3)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
            }
            MainOrder mainOrder = null;
            try {
                ITag tag4Id = messageHandler.createMessage(TradeCode.USE_ELECTRONIC_TAKEUP, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(96);
                if (tag4Id != null) {
                    mainOrder = MainOrder.fromTag(tag4Id);
                }
            } catch (Exception e2) {
                if (this.f9716a != null) {
                    this.f9716a.error(this.f9717b, new StringBuilder(String.valueOf(chars)).append(FM_Long.copyValueOf("无？觳枝幹号哉底凤玫弚席(/", 174)).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                this.f9718c.throwExceptionAndClose(new StringBuilder(String.valueOf(chars)).append(FM_Bytes.concat("斪３覡柕幻叻咃廅夥贲", 5, 35)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            return mainOrder;
        }
    }
}
