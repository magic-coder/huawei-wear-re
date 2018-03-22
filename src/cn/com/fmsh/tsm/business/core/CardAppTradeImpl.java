package cn.com.fmsh.tsm.business.core;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.IMessage;
import cn.com.fmsh.communication.message.IMessageHandler;
import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.ApduHandler.ApduHandlerType;
import cn.com.fmsh.script.bean.ApduReponseList;
import cn.com.fmsh.script.bean.ApduRequest;
import cn.com.fmsh.script.bean.ApduRequestList;
import cn.com.fmsh.script.exception.FMScriptHandleException;
import cn.com.fmsh.script.exception.FMScriptHandleException.ScriptHandleExceptionType;
import cn.com.fmsh.tsm.business.CardAppTrade;
import cn.com.fmsh.tsm.business.LocalDataHandler;
import cn.com.fmsh.tsm.business.bean.Activity;
import cn.com.fmsh.tsm.business.bean.BusinessOrder;
import cn.com.fmsh.tsm.business.bean.CardAppInfo;
import cn.com.fmsh.tsm.business.bean.CardAppRecord;
import cn.com.fmsh.tsm.business.bean.CardBusinessStatus;
import cn.com.fmsh.tsm.business.bean.InvoiceToken;
import cn.com.fmsh.tsm.business.bean.LoginInfo;
import cn.com.fmsh.tsm.business.bean.MainOrder;
import cn.com.fmsh.tsm.business.bean.Notice;
import cn.com.fmsh.tsm.business.bean.PasswordPrompt;
import cn.com.fmsh.tsm.business.bean.PayOrder;
import cn.com.fmsh.tsm.business.bean.PreDepositInfo;
import cn.com.fmsh.tsm.business.bean.Product;
import cn.com.fmsh.tsm.business.bean.StationInfo;
import cn.com.fmsh.tsm.business.bean.TerminalBackInfo;
import cn.com.fmsh.tsm.business.bean.TicketOperateResult;
import cn.com.fmsh.tsm.business.bean.UserInfo;
import cn.com.fmsh.tsm.business.bean.VersionInfo;
import cn.com.fmsh.tsm.business.card.CardManagerFactory;
import cn.com.fmsh.tsm.business.card.base.CardManager;
import cn.com.fmsh.tsm.business.constants.Constants.Command;
import cn.com.fmsh.tsm.business.constants.Constants.RespCodeonse4Platform;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import cn.com.fmsh.tsm.business.enums.EnumAppActivationStatus;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderStatus;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderType;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.enums.EnumCardIoType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import cn.com.fmsh.tsm.business.enums.EnumOrderType;
import cn.com.fmsh.tsm.business.enums.EnumResultsSortType;
import cn.com.fmsh.tsm.business.enums.EnumUserPlatformType;
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
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.crowdtestsdk.constants.SdkConstants;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.datatype.SportType;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.snowballtech.business.constant.BusinessCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.net.SyslogAppender;

public class CardAppTradeImpl implements CardAppTrade {
    private /* synthetic */ String f9735a;
    /* synthetic */ FMLog f9736b = null;
    private final /* synthetic */ String f9737c = CardAppTradeImpl.class.getName();
    private /* synthetic */ CardBusinessBasic f9738d;

    public CardAppTradeImpl(CardBusinessBasic cardBusinessBasic) {
        this.f9738d = cardBusinessBasic;
        this.f9736b = LogFactory.getInstance().getLog();
    }

    private final /* synthetic */ int m13034a(IMessageHandler iMessageHandler, String str, LocalDataHandler localDataHandler) throws BusinessException {
        byte[] toBytes;
        String substring = CRCUtil.substring(2, "圿铛竜炩俺怩暥旬");
        String version4StationInfo = localDataHandler.getVersion4StationInfo();
        if (version4StationInfo == null) {
            version4StationInfo = "0";
        }
        IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.STATION_INFO_UPDATE);
        try {
            ITag createTag = iMessageHandler.createTag((byte) TagName.STATION_CONFIG_VERSION);
            createTag.addValue(version4StationInfo);
            createMessage.addTag(createTag);
            toBytes = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(BCCUtil.getChars("～柟遤幾另讨氊攡捴凹玼彗幦}", 2, 105)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_CN.equals("ｚｋ柜適幩叻诫汏攮挡奱赴", 3)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            toBytes = null;
        }
        byte[] interaction = this.f9738d.interaction(toBytes, substring, false, str);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(interaction, 2))) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(190, 90, "＂幻厲哑庂镉讥哉廊硙(,")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Long.copyValueOf("＀幺叶备理奬赿", 4)).toString(), ErrorMessage.local_message_platform_business_handle_fail, true);
        }
        try {
            IMessage createMessage2 = iMessageHandler.createMessage(TradeCode.STATION_INFO_UPDATE, Arrays.copyOfRange(interaction, 2, interaction.length));
            ITag tag4Id = createMessage2.getTag4Id(-68);
            if (tag4Id == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Long.copyValueOf("ｌ帮厪咚廀攡挠泪杁區呩圯铝竀酛罽俱恢牂末", 216)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(5, 43, "y平去咛底攼挹既攅")).toString(), ErrorMessage.local_message_command_data_invaild, false);
            }
            String stringVal = tag4Id.getStringVal();
            ITag tag4Id2 = createMessage2.getTag4Id(-66);
            if (tag4Id2 == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("ｗ并叿哔店敽捹泠杂卐呴坹钒窄俦恾雝名", 4, 10)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Exception.insert(3, 60, "+帰厯哖廃散挡旫攏")).toString(), ErrorMessage.local_message_command_data_invaild, false);
            }
            List arrayList = new ArrayList();
            ITag[] itemTags = tag4Id2.getItemTags();
            if (itemTags != null && itemTags.length > 0) {
                for (ITag iTag : itemTags) {
                    if (iTag != null) {
                        StationInfo fromTag = StationInfo.fromTag(iTag);
                        if (fromTag != null) {
                            arrayList.add(fromTag);
                        }
                    }
                }
            }
            return localDataHandler.updateStationInfo(stringVal, arrayList);
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(SyslogAppender.LOG_LOCAL7, 86, "＄覽柄幹台咛庘敲挶弌帼｀")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("ｇ覽柁幷叧哇庉攠挭奧贬", 84, 19)).toString(), ErrorMessage.local_message_command_data_invaild, false);
            return 0;
        }
    }

    private final /* synthetic */ MainOrder m13035a(int i, int i2, int i3, int i4, byte[] bArr, IMessageHandler iMessageHandler, ApduHandler apduHandler, String str) throws BusinessException {
        String copyValueOf = FM_Long.copyValueOf("议卜电说", 4);
        byte[] bArr2 = null;
        IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.APPLY_ORDER_VER2);
        try {
            ITag createTag = iMessageHandler.createTag((byte) TagName.ORDER_CHANNEL);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.PAY_CHANNEL);
            createTag.addValue(i3);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) 14);
            createTag.addValue(i4);
            createMessage.addTag(createTag);
            if (bArr != null && bArr.length > 0) {
                createTag = iMessageHandler.createTag((byte) 15);
                createTag.addValue(FM_Bytes.bytesToHexString(bArr));
                createMessage.addTag(createTag);
            }
            createTag = iMessageHandler.createTag((byte) 16);
            createTag.addValue(FM_Bytes.intToBytes(i2, 4));
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.CARD_FORM);
            if (ApduHandlerType.NFC == apduHandler.getApduHandlerType()) {
                createTag.addValue(EnumCardIoType.CARD_IO_TYPE_OUT.getId());
            } else if (ApduHandlerType.BLUETOOTH == apduHandler.getApduHandlerType()) {
                createTag.addValue(EnumCardIoType.CARD_IO_TYPE_OUT.getId());
            } else {
                createTag.addValue(EnumCardIoType.CARD_IO_TYPE_IN.getId());
            }
            createMessage.addTag(createTag);
            bArr2 = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(BCCUtil.getChars("斥＋淓恠奇瑑噣冥玣彅幣５", 3, 52)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Utils.regionMatches(2, 48, "斤．淚恭外瑄噺冸珢开幪")).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        Object interaction = this.f9738d.interaction(bArr2, copyValueOf, false, str);
        Object obj = new byte[2];
        System.arraycopy(interaction, 0, obj, 0, obj.length);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(CRCUtil.substring(5, "旤１幻口多瑏奥赺pu")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Long.copyValueOf("旼＋幷叱奚瑝奩走", 2)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
        }
        MainOrder mainOrder = null;
        try {
            ITag tag4Id = iMessageHandler.createMessage(TradeCode.APPLY_ORDER_VER2, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(96);
            if (tag4Id != null) {
                mainOrder = MainOrder.fromTag(tag4Id);
            }
        } catch (Exception e2) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(Util4Java.endsWith("旴ｙ覫柋帽厱哙库几玽异幫|y", 5, 115)).append(Util4Java.getExceptionInfo(e2)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(4, 62, "旾ｊ觧柒平叮咑庎奩贳")).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        return mainOrder;
    }

    private final /* synthetic */ MainOrder m13036a(int i, int i2, byte[] bArr, byte[] bArr2, IMessageHandler iMessageHandler, String str) throws BusinessException {
        String chars = BCCUtil.getChars("浨劶诫匁甬讽", 3, 43);
        byte[] bArr3 = null;
        IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.APPLY_ORDER_EX_VER2);
        try {
            ITag createTag = iMessageHandler.createTag((byte) TagName.ORDER_CHANNEL);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) 14);
            createTag.addValue(i2);
            createMessage.addTag(createTag);
            if (bArr != null && bArr.length > 0) {
                createTag = iMessageHandler.createTag((byte) TagName.ACTIVITY_INFO);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
            }
            createTag = iMessageHandler.createTag((byte) TagName.PATCH_DATA);
            createTag.addValue(bArr2);
            createMessage.addTag(createTag);
            bArr3 = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(FM_Bytes.concat("斪ｃ淊怺奌琝噦击玤弅幢ｗ", 5, 115)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(chars)).append(CRCUtil.substring(5, "旤１涀恼多瑏嘼冥珺彗常")).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        Object interaction = this.f9738d.interaction(bArr3, chars, false, str);
        Object obj = new byte[2];
        System.arraycopy(interaction, 0, obj, 0, obj.length);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(chars)).append(FM_Long.copyValueOf("旲－席厫奜瑓奣赪vi", 252)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(chars)).append(FM_Bytes.concat("斮４師叨奜琞奩贽", 1, 64)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
        }
        MainOrder mainOrder = null;
        try {
            ITag tag4Id = iMessageHandler.createMessage(TradeCode.APPLY_ORDER_VER2, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(96);
            if (tag4Id != null) {
                mainOrder = MainOrder.fromTag(tag4Id);
            }
        } catch (Exception e2) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(chars)).append(BCCUtil.getChars("斣｛觺枋帮厯和店凿珷彋帳7o", 5, 98)).append(Util4Java.getExceptionInfo(e2)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(chars)).append(CRCUtil.substring(5, "旤１觫枃幭厹咙廋奻走")).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        return mainOrder;
    }

    private final /* synthetic */ MainOrder m13037a(byte[] bArr, IMessageHandler iMessageHandler, String str) throws BusinessException {
        byte[] toBytes;
        MainOrder mainOrder = null;
        try {
            IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.QUERY_ORDER_VER2);
            ITag createTag = iMessageHandler.createTag((byte) TagName.MAIN_ORDER_ID);
            createTag.addValue(bArr);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.ORDER_TYPE);
            createTag.addValue(EnumOrderType.MAIN.getId());
            createMessage.addTag(createTag);
            toBytes = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Bytes.concat("乡讯匕俲怩枼诮斩>柁選幸厮详氆攧捤冧玠彁幮３", 3, 51)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(CRCUtil.substring(2, "临许卐俱恴枣枴设斱~柙逨幠叮课汖敯挤冯珰奺赳"), ErrorMessage.local_message_message_handle_exception, false);
            toBytes = mainOrder;
        }
        toBytes = this.f9738d.interaction(toBytes, BCCUtil.getChars("乮诣匘俸恪柴访斿", 5, 108), false, str);
        byte[] copyOf = Arrays.copyOf(toBytes, 2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(FM_Long.copyValueOf("串认卖信怲枿讵斢｝帽去咅廑镛记咑廍硗ip", 1)).append(FM_Bytes.bytesToHexString(toBytes)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Exception.insert(4, 25, "丳讣协侲怣柠诼旡｜帺史够琒奼赣"), ErrorMessage.instance(FM_Bytes.bytesToHexString(copyOf)), true);
        }
        try {
            createTag = iMessageHandler.createMessage(1132, Arrays.copyOfRange(toBytes, 2, toBytes.length)).getTag4Id(96);
            if (createTag != null) {
                mainOrder = MainOrder.fromTag(createTag);
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Long.copyValueOf("串认卖信怲枿讵斢}帽去咅廑攲挱泽材卓呸桗笳\u0011qu\u001c2卨幫句河朆丷讫卓讳录", 1));
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(CRCUtil.substring(298, "丬诠匘侹怬枫讻旲＃觹枕幣叫咋廅攬挩彐幥２")).append(FM_Bytes.bytesToHexString(toBytes)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_CN.equals("乮诤匂侩恶柯诹旺ｑ覭柏帣厱哟店敤捫奧赢", 2), ErrorMessage.local_message_command_data_invaild, false);
        }
        return mainOrder;
    }

    private final /* synthetic */ Product m13038a(String str, IMessageHandler iMessageHandler, String str2) throws BusinessException {
        String insert = FM_Exception.insert(HiUserInfo.HEIGHT_DEFAULT, 29, "亩咊议练俣恰枹讻");
        byte[] bArr = null;
        IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.QUERY_PRODUCT_INFO);
        try {
            ITag createTag = iMessageHandler.createTag((byte) TagName.PRODUCT_ID);
            createTag.addValue(str);
            createMessage.addTag(createTag);
            bArr = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(BCCUtil.getChars("乚劦讬匀论绅枯讳旮３柂逭幧厫诵汋攠挹凤珵彎師 ", 112, 39)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(BCCUtil.getChars("乒勩讪卝议纎柭诪斾ｄ枌逨帻厸诿汊攸挦夹购", 216, 32), ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] interaction = this.f9738d.interaction(bArr, Util4Java.endsWith("丘勯诸匓说绘柯讴斴", 5, 108), false, str2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(interaction, 2))) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(insert)).append(FM_Exception.insert(3, 15, "＋幥叵哙廗镋议咝廋砏',")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(insert)).append(FM_Int.replace(NFCBaseActivity.TO_ADD, "｟帥厩奘瑙女赠")).toString(), ErrorMessage.local_message_platform_business_handle_fail, true);
        }
        Product product = null;
        try {
            createTag = iMessageHandler.createMessage(TradeCode.QUERY_PRODUCT_INFO, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(-104);
            if (createTag == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(CRCUtil.substring(FitnessSleepType.HW_FITNESS_DREAM, "ｕ幷叿哗庑敠捵泧杘卙呬询弈俩恼")).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(insert)).append(FM_Exception.insert(5, 12, "％9干叽哔廑攡挳斩攝")).toString(), ErrorMessage.local_message_command_data_invaild, false);
            }
            product = Product.fromTag(createTag);
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(BCCUtil.getChars("ｘ觪柎幠厸咐庆攷捲当帾！", 4, 53)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(insert)).append(FM_CN.equals("｛覫柉帹叫品庉敾挱奡赤", 4)).toString(), ErrorMessage.local_message_command_data_invaild, false);
        }
        return product;
    }

    private final /* synthetic */ TicketOperateResult m13039a(String str, String str2, String str3, byte[] bArr, IMessageHandler iMessageHandler, String str4) throws BusinessException {
        String substring = CRCUtil.substring(2, "甼退丟励用讱");
        byte[] bArr2 = null;
        IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.TICKET_MANAGER);
        try {
            ITag createTag = iMessageHandler.createTag((byte) 2);
            createTag.addValue(str);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.COMPANY_CODE);
            createTag.addValue(str2);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.BUSINESS_ORDER_OP_TYPE);
            createTag.addValue(94);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.SEID);
            createTag.addValue(bArr);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.DEVICE_MODEL);
            createTag.addValue(str3);
            createMessage.addTag(createTag);
            bArr2 = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Exception.insert(BusinessCode.CURRENCY_CODE_RMB, 68, "时ｈ涀怣夔瑒噰冦珰弆幰６")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Int.replace(1, "斠ｕ淔怰夆球噠凱玾弓帬")).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        Object interaction = this.f9738d.interaction(bArr2, substring, false, str4);
        Object obj = new byte[2];
        System.arraycopy(interaction, 0, obj, 0, obj.length);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Exception.insert(150, 105, "旬／帿厥多琁夡赼xk")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("斩（幺叾夗琞夬货", 2, 5)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
        }
        TicketOperateResult ticketOperateResult = new TicketOperateResult();
        try {
            IMessage createMessage2 = iMessageHandler.createMessage(TradeCode.TICKET_MANAGER, Arrays.copyOfRange(interaction, 2, interaction.length));
            createTag = createMessage2.getTag4Id(21);
            if (createTag != null) {
                ticketOperateResult.setOperateResult(createTag.getIntVal());
            } else {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(TransportMediator.KEYCODE_MEDIA_RECORD, 4, "斤ｚ帩厮哏庒朠匋吹祾栣皚Vgm")).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(3, 27, "斥＂幺厴奛瑜夤贵")).toString(), ErrorMessage.local_message_platform_business_handle_fail, false);
            }
            ITag tag4Id = createMessage2.getTag4Id(17);
            if (tag4Id != null) {
                ticketOperateResult.setTicketStub(tag4Id.getBytesVal());
            } else {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("旵ｋ幸县哞廃朱博吨狱怊盋G6|", 6, 68)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Int.replace(NFCBaseActivity.TO_ADD, "斥ｚ帪厬奛瑄奴赭")).toString(), ErrorMessage.local_message_platform_business_handle_fail, false);
            }
        } catch (Exception e2) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_CN.equals("斣ｊ覴柘幪叺哖庘冧現彝幨{2", 2)).append(Util4Java.getExceptionInfo(e2)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Exception.insert(3, 11, "旱＞觾枘幠叮咄廀奮赯")).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        return ticketOperateResult;
    }

    private final /* synthetic */ TicketOperateResult m13040a(String str, String str2, byte[] bArr, IMessageHandler iMessageHandler, String str3) throws BusinessException {
        String regionMatches = FM_Utils.regionMatches(4, 96, "畧過与劵畧讣");
        byte[] bArr2 = null;
        IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.TICKET_MANAGER);
        try {
            ITag createTag = iMessageHandler.createTag((byte) 2);
            createTag.addValue(str);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.COMPANY_CODE);
            createTag.addValue(str2);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.BUSINESS_ORDER_OP_TYPE);
            createTag.addValue(91);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.ACTIVITY_INFO);
            createTag.addValue(bArr);
            createMessage.addTag(createTag);
            bArr2 = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(Util4Java.endsWith("日，涅恵奃瑒嘩冴珫弊席８", 278, 13)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(regionMatches)).append(FM_Long.copyValueOf("斮ｙ淚怠奈瑏嘮冹珰弟帢", AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED)).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        Object interaction = this.f9738d.interaction(bArr2, regionMatches, false, str3);
        Object obj = new byte[2];
        System.arraycopy(interaction, 0, obj, 0, obj.length);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_Int.replace(3, "斮ｗ席叱夀琁夻质*3")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("斬５師叧奒琓奥贶", 3, 63)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
        }
        TicketOperateResult ticketOperateResult = new TicketOperateResult();
        try {
            ITag tag4Id = iMessageHandler.createMessage(TradeCode.TICKET_MANAGER, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(17);
            if (tag4Id != null) {
                ticketOperateResult.setTicketStub(tag4Id.getBytesVal());
            }
        } catch (Exception e2) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(3, "旦７觥极幯厷咟廉冲珣彜帱.?")).append(Util4Java.getExceptionInfo(e2)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(regionMatches)).append(FM_Long.copyValueOf("旼＋觧枑席厫咕廁奣赪", 2)).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        return ticketOperateResult;
    }

    private final /* synthetic */ List<PayOrder> m13041a(int i, int i2, EnumCardAppType enumCardAppType, IMessageHandler iMessageHandler, String str) throws BusinessException {
        byte[] bArr = null;
        try {
            IMessage createMessage = iMessageHandler.createMessage(1132);
            ITag createTag = iMessageHandler.createTag((byte) TagName.ORDER_TRADE_STATUSES);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.QUERY_RECORD_COUNT);
            createTag.addValue(i2);
            createMessage.addTag(createTag);
            if (enumCardAppType != null) {
                createTag = iMessageHandler.createTag((byte) 14);
                createTag.addValue(enumCardAppType.getId());
                createMessage.addTag(createTag);
            }
            createTag = iMessageHandler.createTag((byte) TagName.ORDER_TYPE);
            createTag.addValue(EnumOrderType.PAY.getId());
            createMessage.addTag(createTag);
            bArr = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Utils.regionMatches(246, 102, "敩五记卍枻讦於<枒遼帱厸诹汖攪挮冼玼弐幠ｄ")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Exception.insert(3, 106, "攨争诹匐柪读旵a染遡幸句讨氋攣捳函玡奪赠"), ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] interaction = this.f9738d.interaction(bArr, FM_Exception.insert(4, 48, "攧什诪卍枭论旾"), false, str);
        bArr = Arrays.copyOf(interaction, 2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, bArr)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(FM_Exception.insert(5, 75, "攦二讽匟柰询施：帲叼咚廖锔讷哎廚砘>o")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(1, 55, "敾仐诽千枨详旭～幺厰夓瑈头费"), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr)), true);
        }
        List<PayOrder> arrayList = new ArrayList();
        try {
            ITag tag4Id = iMessageHandler.createMessage(1132, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(100);
            if (tag4Id != null) {
                ITag[] itemTags = tag4Id.getItemTags();
                if (itemTags != null && itemTags.length >= 1) {
                    for (ITag iTag : itemTags) {
                        if (iTag != null) {
                            PayOrder fromTag = PayOrder.fromTag(iTag);
                            if (fromTag != null) {
                                arrayList.add(fromTag);
                            }
                        }
                    }
                } else if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Int.replace(3, "敷亃诼協柡该旼!幣口哛庍並穥"));
                }
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Int.replace(5, "敵亅订卖柣诫旺#幡句油朒攱仙讦卒论彘"));
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(Util4Java.endsWith("敢仍访匐柨请斫）觮柅帮叵咀廁敭挫彏席＇", 240, 40)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(NFCBaseActivity.TO_ADD, 77, "敡仃诪區柧训旪ｅ觵枓帣叭咇広整挿夯赮"), ErrorMessage.local_message_command_data_invaild, false);
        }
        return arrayList;
    }

    private final /* synthetic */ List<Activity> m13042a(EnumCardAppType enumCardAppType, String str, IMessageHandler iMessageHandler, String str2) throws BusinessException {
        String replace = FM_Int.replace(3, "浣勳便恮柡该");
        byte[] bArr = null;
        try {
            IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.QUERY_ACTIVITIES);
            ITag createTag = iMessageHandler.createTag((byte) 14);
            createTag.addValue(enumCardAppType.getId());
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.COMPANY_CODE);
            createTag.addValue(str);
            createMessage.addTag(createTag);
            bArr = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Bytes.concat("o柈逵幭号讧氛攲捥凮班彄幷＂", FitnessSleepType.HW_FITNESS_DREAM, 105)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(Util4Java.endsWith("s枀逩幽口误江敲捩凶玡大贾", 2, 5)).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] interaction = this.f9738d.interaction(bArr, replace, false, str2);
        bArr = Arrays.copyOf(interaction, 2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, bArr)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Bytes.concat("ｖ幩厪哗廎锃讵哗廎砛`:", 3, 64)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(CRCUtil.substring(3, "＜幨叶夕琚奶起")).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr)), true);
        }
        List<Activity> arrayList = new ArrayList();
        try {
            ITag tag4Id = iMessageHandler.createMessage(1132, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(-128);
            if (tag4Id != null) {
                ITag[] itemTags = tag4Id.getItemTags();
                if (itemTags != null && itemTags.length >= 1) {
                    for (ITag iTag : itemTags) {
                        if (iTag != null) {
                            Activity fromTag = Activity.fromTag(iTag);
                            if (fromTag != null) {
                                arrayList.add(fromTag);
                            }
                        }
                    }
                } else if (this.f9736b != null) {
                    this.f9736b.debug(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Exception.insert(2, 18, "*幫叺哑廚盄浩劬俷恧雜呄乤稪")).toString());
                }
            } else if (this.f9736b != null) {
                this.f9736b.debug(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Long.copyValueOf("&年叴哌廊盟浣勽侳怠隊呁乼稹", 2)).toString());
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(Util4Java.endsWith("！觧柋幡叹咍広敾挫弞師ｐ", SyslogAppender.LOG_LOCAL6, 87)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(FM_Bytes.concat("u觺柉幪厩哔廍敩挷夨赼", 2, 64)).toString(), ErrorMessage.local_message_command_data_invaild, false);
        }
        return arrayList;
    }

    private final /* synthetic */ List<MainOrder> m13043a(EnumOrderStatus enumOrderStatus, int i, EnumCardAppType enumCardAppType, IMessageHandler iMessageHandler, String str) throws BusinessException {
        String regionMatches = FM_Utils.regionMatches(5, 32, "乮讷區侴怺柰请");
        byte[] bArr = null;
        try {
            IMessage createMessage = iMessageHandler.createMessage(1132);
            ITag createTag = iMessageHandler.createTag((byte) TagName.QUERY_RECORD_COUNT);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) 14);
            createTag.addValue(enumCardAppType.getId());
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.ORDER_TYPE);
            createTag.addValue(EnumOrderType.MAIN.getId());
            createMessage.addTag(createTag);
            if (enumOrderStatus != null) {
                createTag = iMessageHandler.createTag((byte) TagName.ORDER_TRADE_STATUS);
                createTag.addValue(enumOrderStatus.getId());
                createMessage.addTag(createTag);
            }
            bArr = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("斳+枍遫帾叿详民攥捹凣珫彟帧｛", 110, 34)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(2, 96, "斤~枖進帡厢该汐攢挼凨玢奣起")).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] interaction = this.f9738d.interaction(bArr, regionMatches, false, str);
        bArr = Arrays.copyOf(interaction, 2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, bArr)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(Util4Java.endsWith("旷｛幾右咔庛锜讴哜库硜))", 4, 86)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(180, 22, "旲６帣厶奘琔夹贻")).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr)), true);
        }
        List<MainOrder> arrayList = new ArrayList();
        try {
            ITag tag4Id = iMessageHandler.createMessage(1132, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(97);
            if (tag4Id != null) {
                ITag[] itemTags = tag4Id.getItemTags();
                if (itemTags != null && itemTags.length >= 1) {
                    for (ITag fromTag : itemTags) {
                        arrayList.add(MainOrder.fromTag(fromTag));
                    }
                } else if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(HttpStatus.SC_NOT_MODIFIED, "旫ｄ帠厮咄廀支捤沴有匎吽框笲\ft}\u0005#Zxc#卩帶厠泺杏诳匉讷彇")).toString());
                }
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("断＝帴叭咞庝敯挻沪杈匒呦栄筧\u00143jLk匮幠厹沾杜丰诣匂讽弖", 4, 54)).toString());
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_Long.copyValueOf("斺ｅ覥染帳叭哗広敤捿弌帳２", 68)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(regionMatches)).append(FM_Exception.insert(172, 64, "旦｜觳柀幣厠哝廄敠挾夡赵")).toString(), ErrorMessage.local_message_command_data_invaild, false);
        }
        return arrayList;
    }

    private final /* synthetic */ List<BusinessOrder> m13044a(EnumOrderStatus enumOrderStatus, int i, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, IMessageHandler iMessageHandler, String str) throws BusinessException {
        byte[] bArr = null;
        try {
            ITag createTag;
            IMessage createMessage = iMessageHandler.createMessage(1132);
            if (enumOrderStatus != null) {
                createTag = iMessageHandler.createTag((byte) TagName.ORDER_TRADE_STATUS);
                createTag.addValue(enumOrderStatus.getId());
                createMessage.addTag(createTag);
            }
            createTag = iMessageHandler.createTag((byte) TagName.QUERY_RECORD_COUNT);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            if (enumCardAppType != null) {
                createTag = iMessageHandler.createTag((byte) 14);
                createTag.addValue(enumCardAppType.getId());
                createMessage.addTag(createTag);
            }
            createTag = iMessageHandler.createTag((byte) TagName.ORDER_TYPE);
            createTag.addValue(EnumOrderType.BUSINESS.getId());
            createMessage.addTag(createTag);
            if (enumBusinessOrderType != null) {
                createTag = iMessageHandler.createTag((byte) TagName.BUSINESS_ORDER_TYPE);
                createTag.addValue(enumBusinessOrderType.getId());
                createMessage.addTag(createTag);
            }
            bArr = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(CRCUtil.substring(132, "下劽讥升柸讪斥r柍遴帬叺询求敻捸冻珼录幺ｗ")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Bytes.concat("乙勪讱华枦诩日w枇逫帠厫说氉攣捵冹珻夢贾", 204, 40), ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] interaction = this.f9738d.interaction(bArr, Util4Java.endsWith("业勬诸匒柱诣旸", 3, 109), false, str);
        bArr = Arrays.copyOf(interaction, 2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, bArr)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(FM_Long.copyValueOf("乘劾设卌柳诱旦！幹号哉底锇说哕庁砓5,", 58)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(Util4Java.endsWith("业勳详匃枭诸旺２幣史奐瑀奩赯", 3, 114), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr)), true);
        }
        List<BusinessOrder> arrayList = new ArrayList();
        try {
            ITag tag4Id = iMessageHandler.createMessage(1132, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(27);
            if (tag4Id != null) {
                ITag[] itemTags = tag4Id.getItemTags();
                if (itemTags != null && itemTags.length >= 1) {
                    for (ITag iTag : itemTags) {
                        if (iTag != null) {
                            BusinessOrder fromTag = BusinessOrder.fromTag(iTag);
                            if (fromTag != null) {
                                arrayList.add(fromTag);
                            }
                        }
                    }
                } else if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(3, 98, "义勴讵卌枾访早-幰厵九动让剽隉吙丩稯"));
                }
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(3, 16, "义劢讱卖柶计斥o帠右沲朊三勢诱化诣彖"));
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(CRCUtil.substring(5, "丈劼讪卆査讫斢ｓ覩柅平叻哛底敼捹彀幵ｂ")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(CRCUtil.substring(1, "且劸讦博柿讧斦ｗ覥柁帯号哟庉數捽夯赬"), ErrorMessage.local_message_command_data_invaild, false);
        }
        return arrayList;
    }

    private final /* synthetic */ List<BusinessOrder> m13045a(EnumOrderStatus enumOrderStatus, int i, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, IMessageHandler iMessageHandler, byte[] bArr, String str) throws BusinessException {
        ITag createTag;
        byte[] bArr2 = null;
        try {
            ITag createTag2;
            IMessage createMessage = iMessageHandler.createMessage(1133);
            if (enumOrderStatus != null) {
                createTag = iMessageHandler.createTag((byte) TagName.ORDER_TRADE_STATUS);
                createTag.addValue(enumOrderStatus.getId());
                createMessage.addTag(createTag);
            } else {
                createTag = iMessageHandler.createTag((byte) TagName.ORDER_TRADE_STATUS);
                createTag.addValue(EnumOrderStatus.unknown.getId());
                createMessage.addTag(createTag);
            }
            createTag = iMessageHandler.createTag((byte) TagName.QUERY_RECORD_COUNT);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            if (enumCardAppType != null) {
                createTag = iMessageHandler.createTag((byte) 14);
                createTag.addValue(enumCardAppType.getId());
                createMessage.addTag(createTag);
            }
            createTag = iMessageHandler.createTag((byte) TagName.ORDER_TYPE);
            createTag.addValue(EnumOrderType.BUSINESS.getId());
            createMessage.addTag(createTag);
            createTag = null;
            if (enumBusinessOrderType != null) {
                createTag2 = iMessageHandler.createTag((byte) TagName.BUSINESS_ORDER_TYPE);
                createTag2.addValue(enumBusinessOrderType.getId());
                createMessage.addTag(createTag2);
                if (bArr != null && bArr.length > 0) {
                    if (enumBusinessOrderType == EnumBusinessOrderType.ORDER_TYPE_ISSUE) {
                        createTag = iMessageHandler.createTag((byte) TagName.SEID);
                        createTag.addValue(bArr);
                    }
                    if (enumBusinessOrderType == EnumBusinessOrderType.ORDER_TYPE_RECHARGE) {
                        createTag = iMessageHandler.createTag((byte) 15);
                        createTag.addValue(bArr);
                    }
                }
            }
            if (createTag != null) {
                createTag2 = iMessageHandler.createTag((byte) TagName.PATCH_DATA);
                createTag2.addValue(createTag);
                createMessage.addTag(createTag2);
            }
            bArr2 = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_CN.equals("乂勨诸匞柹误旨#构遱帱厣讳汗敶捹凲珩彈幣ｖ", 5)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(BCCUtil.getChars("之劳诱十枰说斡4柝逺帨召讪汜支挮击珲夲赡", 1, 65), ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] interaction = this.f9738d.interaction(bArr2, FM_Int.replace(58, "丕劳讷卍柾诼斷"), false, str);
        bArr2 = Arrays.copyOf(interaction, 2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, bArr2)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(FM_Bytes.concat("乀劻许匏枿诸旬ｖ帩只哗廎镃诵哗廎硛 :", 3, 32)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(CRCUtil.substring(4, "下劽讥升柸讪斥ｒ帺厤奛琌夤败"), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr2)), true);
        }
        List<BusinessOrder> arrayList = new ArrayList();
        try {
            createTag = iMessageHandler.createMessage(1132, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(27);
            if (createTag != null) {
                ITag[] itemTags = createTag.getItemTags();
                if (itemTags != null && itemTags.length >= 1) {
                    for (ITag iTag : itemTags) {
                        if (iTag != null) {
                            BusinessOrder fromTag = BusinessOrder.fromTag(iTag);
                            if (fromTag != null) {
                                arrayList.add(fromTag);
                            }
                        }
                    }
                } else if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Int.replace(3, "乂勺诼協柡该旼!幣口丌劸设刯雄名串穱"));
                }
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Exception.insert(4, 70, "丒勯讶匏查认旺~幫厮泥會乊劷课南诸彛"));
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_CN.equals("乂勨诸匞柹误旨＃解柁帱厣咉庁敶捹弊幡ｐ", 5)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(BCCUtil.getChars("乏劾讫匆柸讥旧ｗ覦枟帪右咀広敱挥夤赺", 5, 74), ErrorMessage.local_message_command_data_invaild, false);
        }
        return arrayList;
    }

    private final /* synthetic */ List<Product> m13046a(String str, EnumCardAppType enumCardAppType, byte[] bArr, IMessageHandler iMessageHandler, String str2) throws BusinessException {
        String copyValueOf = FM_Long.copyValueOf("京哉俤恭梟絾", 3);
        byte[] bArr2 = null;
        try {
            ITag createTag;
            IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.QUERY_PRODUCT_LIST);
            if (str != null && str.length() > 0) {
                createTag = iMessageHandler.createTag((byte) TagName.DEVICE_MODEL);
                createTag.addValue(str);
                createMessage.addTag(createTag);
            }
            if (enumCardAppType != null) {
                createTag = iMessageHandler.createTag((byte) 14);
                createTag.addValue(enumCardAppType.getId());
                createMessage.addTag(createTag);
            }
            if (bArr != null && bArr.length > 0) {
                createTag = iMessageHandler.createTag((byte) TagName.PATCH_DATA);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
            }
            bArr2 = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(CRCUtil.substring(1, "\"枝逤幼只讲氒攫挨冫珬弅帪＇")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(copyValueOf)).append(Util4Java.endsWith(",#枚逭幯去训氋攨捩凬玵夥赦", 3, 15)).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] interaction = this.f9738d.interaction(bArr2, copyValueOf, false, str2);
        bArr2 = Arrays.copyOf(interaction, 2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, bArr2)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(FM_CN.equals("ｍ幡右哙庑镏讨咕廝砛1<", 206)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Bytes.concat("ｐ帢厶奟瑖奴贿", 5, 117)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr2)), true);
        }
        List<Product> arrayList = new ArrayList();
        try {
            ITag tag4Id = iMessageHandler.createMessage(TradeCode.QUERY_PRODUCT_LIST, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(-100);
            if (tag4Id != null) {
                ITag[] itemTags = tag4Id.getItemTags();
                if (itemTags != null && itemTags.length >= 1) {
                    for (ITag iTag : itemTags) {
                        if (iTag != null) {
                            Product fromTag = Product.fromTag(iTag);
                            if (fromTag != null) {
                                arrayList.add(fromTag);
                            }
                        }
                    }
                } else if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(BCCUtil.getChars("ｘ幢叾乑勩讧刲雙呔乣穬", 4, 29)).toString());
                }
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(FM_CN.equals("ｓ帣厱泳杊认彐", 268)).toString());
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(Util4Java.endsWith("ｒ触果幠只哌府敿捸弟幼ｑ", 1, 7)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(copyValueOf)).append(BCCUtil.getChars("ｆ覿枞平叢咉廂攸挴夽贻", 250, 18)).toString(), ErrorMessage.local_message_command_data_invaild, false);
        }
        return arrayList;
    }

    private final /* synthetic */ List<MainOrder> m13047a(List<EnumOrderStatus> list, int i, EnumCardAppType enumCardAppType, IMessageHandler iMessageHandler, String str) throws BusinessException {
        byte[] toBytes;
        String concat = FM_Bytes.concat("丮讧區侤怺枠讷", 286, 16);
        try {
            IMessage createMessage = iMessageHandler.createMessage(1134);
            ITag createTag = iMessageHandler.createTag((byte) TagName.QUERY_RECORD_COUNT);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) 14);
            createTag.addValue(enumCardAppType.getId());
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.ORDER_TYPE);
            createTag.addValue(EnumOrderType.MAIN.getId());
            createMessage.addTag(createTag);
            if (list != null && list.size() > 0) {
                byte[] bArr = new byte[list.size()];
                for (int i2 = 0; i2 < list.size(); i2++) {
                    EnumOrderStatus enumOrderStatus = (EnumOrderStatus) list.get(i2);
                    if (enumOrderStatus != null) {
                        bArr[i2] = (byte) enumOrderStatus.getId();
                    }
                }
                createTag = iMessageHandler.createTag((byte) TagName.ORDER_TRADE_STATUSES);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
            }
            toBytes = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("斪9枊遧帳厩该汉攴挳冬玿弊幹｀", 5, 25)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(FM_CN.equals("斮e柞遫幯叽诩汍数挿冸珣奵贰", 5)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            toBytes = null;
        }
        byte[] interaction = this.f9738d.interaction(toBytes, concat, false, str);
        toBytes = Arrays.copyOf(interaction, 2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, toBytes)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("斯9幢厽咄庑锘诲咔廁砐7i", 2, 28)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(Util4Java.endsWith("丢讱単讷彔柾请旹％幰厭奓瑗奺赠", 188, 122), ErrorMessage.instance(FM_Bytes.bytesToHexString(toBytes)), true);
        }
        List<MainOrder> arrayList = new ArrayList();
        try {
            ITag tag4Id = iMessageHandler.createMessage(1132, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(97);
            if (tag4Id != null) {
                ITag[] itemTags = tag4Id.getItemTags();
                if (itemTags != null && itemTags.length >= 1) {
                    for (ITag fromTag : itemTags) {
                        arrayList.add(MainOrder.fromTag(fromTag));
                    }
                } else if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, BCCUtil.getChars("丽询协诤彛枭诠旪z幣厺哉廊敨挼沭杏包吱桓筰\u00134lKp^%94匡广厶没杓讶匛许弗", 310, 58));
                }
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Long.copyValueOf("丫讯卟讷彑柤诼旭4幦叢哂庘敹捨沢有単呱桐笪\nxz\u0015i匱帬厬泸束乨诲匘诺弒", 296));
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Int.replace(1, "乭读匉误彗柠诪旽＂觲构幤只哐应敳捨弋帴５")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(Util4Java.endsWith("为讵単诳弌枪诧旭＝覤柍帠叹哒庁攻振奦质", 4, 22), ErrorMessage.local_message_command_data_invaild, false);
        }
        return arrayList;
    }

    private final /* synthetic */ List<BusinessOrder> m13048a(List<EnumOrderStatus> list, int i, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, IMessageHandler iMessageHandler, byte[] bArr, String str) throws BusinessException {
        byte[] toBytes;
        try {
            ITag createTag;
            IMessage createMessage = iMessageHandler.createMessage(1134);
            if (list != null && list.size() > 0) {
                byte[] bArr2 = new byte[list.size()];
                for (int i2 = 0; i2 < list.size(); i2++) {
                    EnumOrderStatus enumOrderStatus = (EnumOrderStatus) list.get(i2);
                    if (enumOrderStatus != null) {
                        bArr2[i2] = (byte) enumOrderStatus.getId();
                    }
                }
                createTag = iMessageHandler.createTag((byte) TagName.ORDER_TRADE_STATUSES);
                createTag.addValue(bArr2);
                createMessage.addTag(createTag);
            }
            createTag = iMessageHandler.createTag((byte) TagName.QUERY_RECORD_COUNT);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            if (enumCardAppType != null) {
                createTag = iMessageHandler.createTag((byte) 14);
                createTag.addValue(enumCardAppType.getId());
                createMessage.addTag(createTag);
            }
            createTag = iMessageHandler.createTag((byte) TagName.ORDER_TYPE);
            createTag.addValue(EnumOrderType.BUSINESS.getId());
            createMessage.addTag(createTag);
            if (enumBusinessOrderType != null) {
                createTag = iMessageHandler.createTag((byte) TagName.BUSINESS_ORDER_TYPE);
                createTag.addValue(enumBusinessOrderType.getId());
                createMessage.addTag(createTag);
            }
            if (bArr != null && bArr.length > 0) {
                createTag = iMessageHandler.createTag((byte) TagName.PATCH_DATA);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
            }
            toBytes = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(BCCUtil.getChars("义勴讵卌枾访早-枇遥帴叹诼氏政捿凩珥录帡！", 3, 98)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(CRCUtil.substring(172, "七勥语匏枠讲断*枕逼年叢诪氊攣挰决珤奮贯"), ErrorMessage.local_message_message_handle_exception, false);
            toBytes = null;
        }
        byte[] interaction = this.f9738d.interaction(toBytes, Util4Java.endsWith("业勹诲匝枥论斦", 3, 120), false, str);
        toBytes = Arrays.copyOf(interaction, 2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, toBytes)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(FM_Exception.insert(3, 108, "丝勲诽匞柲诡旹ｗ帴厣哒废锎诬咂廏硆)?")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Exception.insert(246, 84, "乀勯讠匃枯诼斤ｊ幩厾奆琐奻贻"), ErrorMessage.instance(FM_Bytes.bytesToHexString(toBytes)), true);
        }
        List<BusinessOrder> arrayList = new ArrayList();
        try {
            ITag tag4Id = iMessageHandler.createMessage(1132, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(27);
            if (tag4Id != null) {
                ITag[] itemTags = tag4Id.getItemTags();
                if (itemTags != null && itemTags.length >= 1) {
                    for (ITag iTag : itemTags) {
                        if (iTag != null) {
                            BusinessOrder fromTag = BusinessOrder.fromTag(iTag);
                            if (fromTag != null) {
                                arrayList.add(fromTag);
                            }
                        }
                    }
                } else if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Exception.insert(112, SpecialIssueType.BUG_TYPE_ID_CHARGE, "乎勩课包枡诺旺,幧司乆勱详剨隊呈丮穲"));
                }
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, CRCUtil.substring(5, "丈劼讪卆査讫斢s帹厥没朂丌加议卂诲弘"));
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Bytes.concat("乃劰诫協枼诳斿－觺柁幺厱哔廅敹振彛帩ｓ", 2, 56)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(282, 71, "丐勰论匊柣讯既ｗ覡枙帣叧咓庑攼捽奫赤"), ErrorMessage.local_message_command_data_invaild, false);
        }
        return arrayList;
    }

    private final /* synthetic */ boolean m13049a(byte[] bArr, byte[] bArr2, IMessageHandler iMessageHandler, String str) throws BusinessException {
        ITag createTag;
        Exception exception;
        Exception exception2;
        ApduReponseList execute;
        IMessage createMessage;
        String equals = FM_CN.equals("匢乞廑甾圏孀", 368);
        ApduHandler apduHandler = this.f9738d.getApduHandler();
        if (apduHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(270, "旭＊PL\u0003\u0007奙瑎嘻乤穳")).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Exception.insert(2, 3, "旰％读兇刕捷卹皟计闯施弈\"B]R9WZ\\k")).toString(), ErrorMessage.local_business_apdu_handler_null, false);
        }
        if (apduHandler.isConnect()) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("斯ｆZ\u001cY[奛琖噩欱忚", 2, 81)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Utils.regionMatches(4, 54, "斢＆\u0001F\bW夜瑈噬欹忉")).toString(), ErrorMessage.local_business_apdu_handler_busying, false);
        } else if (!apduHandler.connect()) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("斡ｄ辇揯卺夽贸", 4)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("斪＜辚掽匭失贱", 5, 52)).toString(), ErrorMessage.local_message_apdu_execute_exception, true);
        }
        IMessage createMessage2 = iMessageHandler.createMessage((int) TradeCode.REMOTE_RECHARGE);
        byte[] bArr3 = null;
        try {
            createTag = iMessageHandler.createTag((byte) 17);
            createTag.addValue(bArr);
            createMessage2.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) 15);
            if (bArr2 == null || bArr2.length < 1) {
                bArr2 = new byte[8];
            }
            createTag.addValue(FM_Bytes.bytesToHexString(bArr2));
            createMessage2.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.CARD_FORM);
            if (ApduHandlerType.NFC == apduHandler.getApduHandlerType()) {
                createTag.addValue(EnumCardIoType.CARD_IO_TYPE_OUT.getId());
            } else if (ApduHandlerType.BLUETOOTH == apduHandler.getApduHandlerType()) {
                createTag.addValue(EnumCardIoType.CARD_IO_TYPE_OUT.getId());
            } else {
                createTag.addValue(EnumCardIoType.CARD_IO_TYPE_IN.getId());
            }
            createMessage2.addTag(createTag);
            bArr3 = createMessage2.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Long.copyValueOf("旼＋枀逡席厫讯気攢挡彎幱｜", 2)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("斣ｊ染遨幪叺诬汎攭挠奮赵", 2)).toString(), ErrorMessage.local_message_message_handle_exception, true);
        }
        byte[] interaction = this.f9738d.interaction(bArr3, equals, true, str);
        byte[] copyOf = Arrays.copyOf(interaction, 2);
        ApduRequestList apduRequestList = null;
        createTag = null;
        ITag iTag = null;
        ITag iTag2 = null;
        while (Arrays.equals(RespCodeonse4Platform.CARD_REQUEST, copyOf)) {
            ITag tag4Id;
            try {
                IMessage createMessage3 = iMessageHandler.createMessage(interaction);
                tag4Id = createMessage3.getTag4Id(-90);
                try {
                    createTag = createMessage3.getTag4Id(-89);
                } catch (Exception e2) {
                    exception = e2;
                    createTag = iTag;
                    exception2 = exception;
                    if (this.f9736b != null) {
                        this.f9736b.error(this.f9737c, new StringBuilder(FM_Long.copyValueOf("卬一库甬圉ｒ覸柈带厢咂廘决珶彁幸gz", 5)).append(Util4Java.getExceptionInfo(exception2)).toString());
                    }
                    this.f9738d.throwExceptionAndClose(FM_Bytes.concat("匹丕庒略圜嬃．親枀帤叮哈廘夢赿", 1, 71), ErrorMessage.local_message_message_handle_exception, true);
                    iTag = createTag;
                    createTag = tag4Id;
                    if (iTag2 == null) {
                        if (this.f9736b != null) {
                            this.f9736b.error(this.f9737c, FM_Bytes.concat("区乜廅畤坏嬚ｑ師厣咃廝攴捱旺扲衜脑未）]&；", 4, ReportInfoUtils.FEEDBACK_SUCCESS));
                        }
                        this.f9738d.throwExceptionAndClose(FM_CN.equals("匶乂廍畢圓孔１幽厯咝廕攢挭旴扢衚脝杴", 4), ErrorMessage.local_message_message_handle_exception, true);
                    }
                    apduRequestList = new ApduRequestList();
                    apduRequestList.fromTag(iTag2);
                    execute = this.f9738d.getScriptHandler().execute(apduRequestList);
                    if (this.f9736b != null) {
                        this.f9736b.error(this.f9737c, FM_CN.equals("匹乃廎畣圔孕２脕本戶蠎纀柘丯穼", 5));
                    }
                    this.f9738d.throwExceptionAndClose(FM_CN.equals("匴乌廃畠圑孒７脖東戩蠓奡赤", 2), ErrorMessage.local_message_apdu_execute_exception, true);
                    createMessage = iMessageHandler.createMessage(9001);
                    createMessage.addTag(createTag);
                    createMessage.addTag(iTag);
                    createMessage.addTag(execute.toTag4A3());
                    bArr3 = createMessage.toBytes();
                    interaction = this.f9738d.interaction(bArr3, FM_CN.equals("卢丞庑畾坏嬀斿", SyslogAppender.LOG_LOCAL6), true, str);
                    copyOf = Arrays.copyOf(interaction, 2);
                }
                try {
                    iTag2 = createMessage3.getTag4Id(-95);
                    iTag = createTag;
                    createTag = tag4Id;
                } catch (FMCommunicationMessageException e3) {
                    exception2 = e3;
                    if (this.f9736b != null) {
                        this.f9736b.error(this.f9737c, new StringBuilder(FM_Long.copyValueOf("卬一库甬圉ｒ覸柈带厢咂廘决珶彁幸gz", 5)).append(Util4Java.getExceptionInfo(exception2)).toString());
                    }
                    this.f9738d.throwExceptionAndClose(FM_Bytes.concat("匹丕庒略圜嬃．親枀帤叮哈廘夢赿", 1, 71), ErrorMessage.local_message_message_handle_exception, true);
                    iTag = createTag;
                    createTag = tag4Id;
                    if (iTag2 == null) {
                        if (this.f9736b != null) {
                            this.f9736b.error(this.f9737c, FM_Bytes.concat("区乜廅畤坏嬚ｑ師厣咃廝攴捱旺扲衜脑未）]&；", 4, ReportInfoUtils.FEEDBACK_SUCCESS));
                        }
                        this.f9738d.throwExceptionAndClose(FM_CN.equals("匶乂廍畢圓孔１幽厯咝廕攢挭旴扢衚脝杴", 4), ErrorMessage.local_message_message_handle_exception, true);
                    }
                    apduRequestList = new ApduRequestList();
                    apduRequestList.fromTag(iTag2);
                    execute = this.f9738d.getScriptHandler().execute(apduRequestList);
                    if (this.f9736b != null) {
                        this.f9736b.error(this.f9737c, FM_CN.equals("匹乃廎畣圔孕２脕本戶蠎纀柘丯穼", 5));
                    }
                    this.f9738d.throwExceptionAndClose(FM_CN.equals("匴乌廃畠圑孒７脖東戩蠓奡赤", 2), ErrorMessage.local_message_apdu_execute_exception, true);
                    createMessage = iMessageHandler.createMessage(9001);
                    createMessage.addTag(createTag);
                    createMessage.addTag(iTag);
                    createMessage.addTag(execute.toTag4A3());
                    bArr3 = createMessage.toBytes();
                    interaction = this.f9738d.interaction(bArr3, FM_CN.equals("卢丞庑畾坏嬀斿", SyslogAppender.LOG_LOCAL6), true, str);
                    copyOf = Arrays.copyOf(interaction, 2);
                }
            } catch (Exception e4) {
                exception = e4;
                tag4Id = createTag;
                createTag = iTag;
                exception2 = exception;
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(FM_Long.copyValueOf("卬一库甬圉ｒ覸柈带厢咂廘决珶彁幸gz", 5)).append(Util4Java.getExceptionInfo(exception2)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_Bytes.concat("匹丕庒略圜嬃．親枀帤叮哈廘夢赿", 1, 71), ErrorMessage.local_message_message_handle_exception, true);
                iTag = createTag;
                createTag = tag4Id;
                if (iTag2 == null) {
                    if (this.f9736b != null) {
                        this.f9736b.error(this.f9737c, FM_Bytes.concat("区乜廅畤坏嬚ｑ師厣咃廝攴捱旺扲衜脑未）]&；", 4, ReportInfoUtils.FEEDBACK_SUCCESS));
                    }
                    this.f9738d.throwExceptionAndClose(FM_CN.equals("匶乂廍畢圓孔１幽厯咝廕攢挭旴扢衚脝杴", 4), ErrorMessage.local_message_message_handle_exception, true);
                }
                apduRequestList = new ApduRequestList();
                apduRequestList.fromTag(iTag2);
                execute = this.f9738d.getScriptHandler().execute(apduRequestList);
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_CN.equals("匹乃廎畣圔孕２脕本戶蠎纀柘丯穼", 5));
                }
                this.f9738d.throwExceptionAndClose(FM_CN.equals("匴乌廃畠圑孒７脖東戩蠓奡赤", 2), ErrorMessage.local_message_apdu_execute_exception, true);
                createMessage = iMessageHandler.createMessage(9001);
                createMessage.addTag(createTag);
                createMessage.addTag(iTag);
                createMessage.addTag(execute.toTag4A3());
                bArr3 = createMessage.toBytes();
                interaction = this.f9738d.interaction(bArr3, FM_CN.equals("卢丞庑畾坏嬀斿", SyslogAppender.LOG_LOCAL6), true, str);
                copyOf = Arrays.copyOf(interaction, 2);
            }
            if (iTag2 == null) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_Bytes.concat("区乜廅畤坏嬚ｑ師厣咃廝攴捱旺扲衜脑未）]&；", 4, ReportInfoUtils.FEEDBACK_SUCCESS));
                }
                this.f9738d.throwExceptionAndClose(FM_CN.equals("匶乂廍畢圓孔１幽厯咝廕攢挭旴扢衚脝杴", 4), ErrorMessage.local_message_message_handle_exception, true);
            }
            apduRequestList = new ApduRequestList();
            try {
                apduRequestList.fromTag(iTag2);
                execute = this.f9738d.getScriptHandler().execute(apduRequestList);
                if (execute == null || execute.size() < 1) {
                    if (this.f9736b != null) {
                        this.f9736b.error(this.f9737c, FM_CN.equals("匹乃廎畣圔孕２脕本戶蠎纀柘丯穼", 5));
                    }
                    this.f9738d.throwExceptionAndClose(FM_CN.equals("匴乌廃畠圑孒７脖東戩蠓奡赤", 2), ErrorMessage.local_message_apdu_execute_exception, true);
                }
                createMessage = iMessageHandler.createMessage(9001);
                createMessage.addTag(createTag);
                createMessage.addTag(iTag);
                createMessage.addTag(execute.toTag4A3());
                bArr3 = createMessage.toBytes();
            } catch (Exception e5) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(FM_Bytes.concat("医乒廂畼坚嬈ｂ帿厺咅廒攴挬覣柎冦珪彚幮nr", 3, TransportMediator.KEYCODE_MEDIA_PLAY)).append(Util4Java.getExceptionInfo(e5)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(1, ReportInfoUtils.FEEDBACK_SUCCESS, "匰乆廓番坕嬀｟帽厹咉庋敪捻觳枛夷贤"), ErrorMessage.local_message_message_handle_exception, true);
            } catch (Exception e52) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(FM_Int.replace(204, "匠乎廓畢坅嬈｟腌杵戻蠓冸珵彊平ｔ")).append(Util4Java.getExceptionInfo(e52)).toString());
                }
                this.f9738d.throwExceptionAndClose(Util4Java.endsWith("占乗廍畽坙嬕ｅ腟杭戺蠕奤赴", 4, ReportInfoUtils.FEEDBACK_FAILED), ErrorMessage.local_message_apdu_execute_exception, true);
            }
            interaction = this.f9738d.interaction(bArr3, FM_CN.equals("卢丞庑畾坏嬀斿", SyslogAppender.LOG_LOCAL6), true, str);
            copyOf = Arrays.copyOf(interaction, 2);
        }
        this.f9738d.businessFinish(true);
        if (Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
            return true;
        }
        if (!Arrays.equals(RespCodeonse4Platform.CARD_REQUEST, copyOf)) {
            if (apduRequestList != null) {
                for (ApduRequest apduRequest : apduRequestList.getApduRequests()) {
                    if (!(apduRequest == null || apduRequest.getApdu() == null || apduRequest.getApdu().length < Command.UPDATE_VALID_DATE.length)) {
                        if (Arrays.equals(Command.UPDATE_VALID_DATE, Arrays.copyOf(apduRequest.getApdu(), Command.UPDATE_VALID_DATE.length))) {
                            return true;
                        }
                    }
                }
            }
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Utils.regionMatches(376, 47, "斾；n坝孜剎姉匇i幼叮咀庈镒讵哄廌砆,e")).append(FM_Bytes.bytesToHexString(copyOf)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(4, "旧０年叢夙瑎奢赻")).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(copyOf)), false);
        }
        return true;
    }

    private final /* synthetic */ byte[] m13050a(IMessageHandler iMessageHandler, String str, int i, byte[] bArr) throws BusinessException {
        ITag createTag;
        String concat = FM_Bytes.concat("瞼禞匰乛劰擌位", 250, 112);
        byte[] bArr2 = null;
        IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.RENT_BUSINESS_HANDLE);
        try {
            createTag = iMessageHandler.createTag((byte) TagName.RENT_HANDLE_TYPE);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            if (bArr != null) {
                createTag = iMessageHandler.createTag((byte) TagName.RENT_HANDLE_DATD);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
            }
            bArr2 = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(1, "ｚ柝遼帬史诲汊敻捠凫玤引帢'")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(FM_Utils.regionMatches(2, 101, "～｛枘逡幵去讧汗敪挱奵赬")).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] interaction = this.f9738d.interaction(bArr2, concat, false, str);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(interaction, 2))) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("｝幵叫哝廑镃讠哉庍砏yx", 1, 21)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("ｙ幽厷处瑟夣赮", 5, 57)).toString(), ErrorMessage.local_message_platform_business_handle_fail, true);
        }
        bArr2 = new byte[1];
        try {
            createTag = iMessageHandler.createMessage(TradeCode.RENT_BUSINESS_HANDLE, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(-61);
            if (createTag != null) {
                bArr2 = createTag.getBytesVal();
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(Util4Java.endsWith("ｓ帾叫咄広日攣捯", 2, 78)).toString());
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Utils.regionMatches(362, 118, "ｖ観柖幯叢哅床敤捤异幮ｖ")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(FM_Exception.insert(4, 94, "＄覥柔幱台咓庈敪挶奧贱")).toString(), ErrorMessage.local_message_command_data_invaild, false);
        }
        return bArr2;
    }

    private final /* synthetic */ BusinessOrder m13051b(byte[] bArr, IMessageHandler iMessageHandler, String str) throws BusinessException {
        byte[] toBytes;
        BusinessOrder businessOrder = null;
        IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.QUERY_ORDER_VER2);
        try {
            ITag createTag = iMessageHandler.createTag((byte) 17);
            createTag.addValue(bArr);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.ORDER_TYPE);
            createTag.addValue(EnumOrderType.BUSINESS.getId());
            createMessage.addTag(createTag);
            toBytes = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(BCCUtil.getChars("乎勭详匉讲纊枡课既＀枀逼幧叼诳氞攤挢冾珬彖年~", 4, 120)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Int.replace(354, "乍勻诿匕讥纀枬议方～柑選帨厮诶汆敷捤夼贵"), ErrorMessage.local_message_message_handle_exception, false);
            toBytes = null;
        }
        toBytes = this.f9738d.interaction(toBytes, FM_Int.replace(118, "乑勯诳匁讱纜枸询旵"), false, str);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(toBytes, 2))) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(FM_CN.equals("丝勹诫匏训绚柨诼旹，帢厲咞廐锌诩哚府硘p{", 148)).append(FM_Bytes.bytesToHexString(toBytes)).toString());
            }
            this.f9738d.throwExceptionAndClose(Util4Java.endsWith("三劢诱卖讵纅柶计日／帠右套瑅夢赦", 310, 80), ErrorMessage.local_message_platform_business_handle_fail, true);
        }
        try {
            createTag = iMessageHandler.createMessage(TradeCode.QUERY_ORDER_VER2, Arrays.copyOfRange(toBytes, 2, toBytes.length)).getTag4Id(26);
            if (createTag == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Exception.insert(284, 114, "单笆讦匃枭许斺2幣史哙庒攨挤泽杇卅吹5W(\u000e-9"));
                }
                this.f9738d.throwExceptionAndClose(FM_Bytes.concat("匌笗误匂柤让斣3帺厣哐廓攡捵斥攇", 2, 42), ErrorMessage.local_message_command_data_invaild, false);
            }
            businessOrder = BusinessOrder.fromTag(createTag);
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Int.replace(5, "匏朼记彖柣诫旺＃觱枅幫叫哓底整捩弈帵＊")).append(FM_Bytes.bytesToHexString(toBytes)).toString());
            }
            this.f9738d.throwExceptionAndClose(CRCUtil.substring(4, "卄杽讷彇柸讪斥ｒ親柄帬叺哘应敻捸奰赩"), ErrorMessage.local_message_command_data_invaild, false);
        }
        return businessOrder;
    }

    private final /* synthetic */ PreDepositInfo m13052b(EnumCardAppType enumCardAppType, String str, IMessageHandler iMessageHandler, String str2) throws BusinessException {
        String equals = FM_CN.equals("飓缦醈侫恴柩诿", 4);
        PreDepositInfo preDepositInfo = new PreDepositInfo();
        byte[] bArr = null;
        try {
            IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.QUERY_PREDEPOSIT);
            ITag createTag = iMessageHandler.createTag((byte) 14);
            createTag.addValue(enumCardAppType.getId());
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.COMPANY_CODE);
            createTag.addValue(str);
            createMessage.addTag(createTag);
            bArr = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Exception.insert(5, 16, "%枝逩幪厹议氋攩捧凣玹弛幱ｃ")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("c枚遭帯叻训汋敨挩凬珵奥账", 248, 47)).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        bArr = this.f9738d.interaction(bArr, equals, false, str2);
        byte[] copyOf = Arrays.copyOf(bArr, 2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(122, "＋幡叭哅庇锇讦咙廋硋o ")).append(FM_Bytes.bytesToHexString(bArr)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(6, "？幭叹夐琙奻走")).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(copyOf)), true);
        }
        try {
            createMessage = iMessageHandler.createMessage(TradeCode.QUERY_PREDEPOSIT, Arrays.copyOfRange(bArr, 2, bArr.length));
            createTag = createMessage.getTag4Id(90);
            if (createTag != null) {
                preDepositInfo.setTotal(FM_Bytes.bytesToInt(createTag.getBytesVal()));
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat(")於ｃ朾匜呵颇罦醜恩颊", 174, 37)).toString());
            }
            ITag tag4Id = createMessage.getTag4Id(91);
            if (tag4Id != null) {
                preDepositInfo.setBlance(FM_Bytes.bytesToInt(tag4Id.getBytesVal()));
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(SyslogAppender.LOG_LOCAL4, "!旮ｏ杤卜呯飋缴釔佉领")).toString());
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith("５觱柛帷叭咛廛數捯彘師６", 60, 89)).append(FM_Bytes.bytesToHexString(bArr)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Long.copyValueOf("!觩林幷叱咓廏攨挻奣赪", 5)).toString(), ErrorMessage.local_message_command_data_invaild, false);
        }
        return preDepositInfo;
    }

    private final /* synthetic */ List<PayOrder> m13053b(EnumOrderStatus enumOrderStatus, int i, EnumCardAppType enumCardAppType, IMessageHandler iMessageHandler, String str) throws BusinessException {
        byte[] bArr = null;
        try {
            ITag createTag;
            IMessage createMessage = iMessageHandler.createMessage(1134);
            if (enumOrderStatus != null) {
                createTag = iMessageHandler.createTag((byte) TagName.ORDER_TRADE_STATUSES);
                createTag.addValue(new byte[]{(byte) enumOrderStatus.getId()});
                createMessage.addTag(createTag);
            }
            createTag = iMessageHandler.createTag((byte) TagName.QUERY_RECORD_COUNT);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            if (enumCardAppType != null) {
                createTag = iMessageHandler.createTag((byte) 14);
                createTag.addValue(enumCardAppType.getId());
                createMessage.addTag(createTag);
            }
            createTag = iMessageHandler.createTag((byte) TagName.ORDER_TYPE);
            createTag.addValue(EnumOrderType.PAY.getId());
            createMessage.addTag(createTag);
            bArr = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Bytes.concat("整介让化枾讱旽/枟遳常右诬汑攻挭冡玣弉幻ａ", 4, 24)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Bytes.concat("敵仏诶卄枫诩斾)柆逿帯叩计汑攠捣冰玷奵贤", 3, 61), ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] interaction = this.f9738d.interaction(bArr, BCCUtil.getChars("敼仄诧匛柲订斿", 3, 41), false, str);
        bArr = Arrays.copyOf(interaction, 2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, bArr)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(FM_Exception.insert(5, 83, "攦亄训南枰诪断ｂ干厤咊庎镔讯哞廒砘6")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(5, 46, "敺仛诳匊柨讹旿；帶口奅瑉夬赮"), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr)), true);
        }
        List<PayOrder> arrayList = new ArrayList();
        try {
            ITag tag4Id = iMessageHandler.createMessage(1132, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(100);
            if (tag4Id != null) {
                ITag[] itemTags = tag4Id.getItemTags();
                if (itemTags != null && itemTags.length >= 1) {
                    for (ITag iTag : itemTags) {
                        if (iTag != null) {
                            PayOrder fromTag = PayOrder.fromTag(iTag);
                            if (fromTag != null) {
                                arrayList.add(fromTag);
                            }
                        }
                    }
                } else if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Bytes.concat("敶亊诩匑枸讴方d帲只哞庘丿穤", 2, 121));
                }
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(5, 40, "敺仅诧匘柰诿斳!幦厭沤朄敺亅讧匘该彈"));
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Bytes.concat("敷亟讴匐柱诡斤－観枏幽厭品廏攺捷彊帯＜", 1, 79)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(Util4Java.endsWith("數五诣千柮询旣＆覼柄帺厮咞廜敭捼夶费", 90, 117), ErrorMessage.local_message_command_data_invaild, false);
        }
        return arrayList;
    }

    private final /* synthetic */ boolean m13054b(String str, String str2, byte[] bArr, IMessageHandler iMessageHandler, String str3) throws BusinessException {
        String concat = FM_Bytes.concat("畩逖逞祸奆瑒", 3, 18);
        byte[] bArr2 = null;
        IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.TICKET_MANAGER);
        try {
            ITag createTag = iMessageHandler.createTag((byte) 2);
            createTag.addValue(str);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.COMPANY_CODE);
            createTag.addValue(str2);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.BUSINESS_ORDER_OP_TYPE);
            createTag.addValue(92);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.ACTIVITY_INFO);
            createTag.addValue(bArr);
            createMessage.addTag(createTag);
            bArr2 = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_CN.equals("斡ｄ淑急够琊噵凴珯归幹ｈ", 4)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(298, "早．涍恧夏琈噹凮玧弘帥")).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        Object interaction = this.f9738d.interaction(bArr2, concat, false, str3);
        Object obj = new byte[2];
        System.arraycopy(interaction, 0, obj, 0, obj.length);
        if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
            return true;
        }
        if (this.f9736b != null) {
            this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(concat)).append(Util4Java.endsWith("旷ｐ幤叢奉瑎夲赻c4", 4, 91)).append(FM_Bytes.bytesToHexString(interaction)).toString());
        }
        return false;
    }

    private final /* synthetic */ PayOrder m13055c(byte[] bArr, IMessageHandler iMessageHandler, String str) throws BusinessException {
        byte[] bArr2 = null;
        IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.QUERY_ORDER_VER2);
        try {
            ITag createTag = iMessageHandler.createTag((byte) TagName.PAY_ORDER_ID);
            createTag.addValue(bArr);
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.ORDER_TYPE);
            createTag.addValue(EnumOrderType.PAY.getId());
            createMessage.addTag(createTag);
            bArr2 = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(CRCUtil.substring(182, "敬亖读匑让纜柠诲旭＊枕逼帴厢讪氊攣挰凳玤弝帲/")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Bytes.concat("敵仄诼匕诤纂柣讪旼｀枊遰幡厤诡氚敪挲夯赥", 3, 66), ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] interaction = this.f9738d.interaction(bArr2, BCCUtil.getChars("敽今诰升讴绔枷诰斤", 2, 64), false, str);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(interaction, 2))) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(CRCUtil.substring(5, "攽仅讪卆诸纏枱讽於ｙ平叻哛底锕诸咏廙硙yn")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(4, 64, "敻仌诶十讲绒枱诶斢８帧古奐琒奥贱"), ErrorMessage.local_message_platform_business_handle_fail, true);
        }
        PayOrder payOrder = null;
        try {
            createTag = iMessageHandler.createMessage(TradeCode.QUERY_ORDER_VER2, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(99);
            if (createTag == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_CN.equals("匂筜读匟柾诮旫\"帬厠和廆攳捺沤期匂味ikHly", 4));
                }
                this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(3, 49, "匆笐请卓柲讪旯f帨叼咐庚敯挾旡攚"), ErrorMessage.local_message_command_data_invaild, false);
            }
            payOrder = PayOrder.fromTag(createTag);
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Exception.insert(6, 108, "卟朷诲弛柿诤旤ｒ覩柆帱叾哗庒攢挰彈帮８")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(2, 32, "匇杳订弇枷诰旤～覱枂幡厢咟庆敢挼奣贷"), ErrorMessage.local_message_command_data_invaild, false);
        }
        return payOrder;
    }

    private final /* synthetic */ List<PreDepositInfo> m13056c(EnumCardAppType enumCardAppType, String str, IMessageHandler iMessageHandler, String str2) throws BusinessException {
        String substring = CRCUtil.substring(4, "颕署釖俳恲枭讱");
        byte[] bArr = null;
        try {
            IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.QUERY_PREDEPOSIT_VER2);
            ITag createTag = iMessageHandler.createTag((byte) 14);
            createTag.addValue(enumCardAppType.getId());
            createMessage.addTag(createTag);
            createTag = iMessageHandler.createTag((byte) TagName.COMPANY_CODE);
            createTag.addValue(str);
            createMessage.addTag(createTag);
            bArr = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("-柚遻師厥讥氍攼挧冼珳彂幥｀", 4, 125)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(CRCUtil.substring(298, ";柆遭師厳讹氛整捡几玵夡贾")).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] interaction = this.f9738d.interaction(bArr, substring, false, str2);
        bArr = Arrays.copyOf(interaction, 2);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, bArr)) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Long.copyValueOf("＀幺叶哎应镄讵咚廀硐tk", 4)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("ｖ帯叮处琄奵赣", 3, 98)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr)), true);
        }
        List<PreDepositInfo> arrayList = new ArrayList();
        try {
            ITag tag4Id = iMessageHandler.createMessage(TradeCode.QUERY_PREDEPOSIT_VER2, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(-105);
            if (tag4Id != null) {
                ITag[] itemTags = tag4Id.getItemTags();
                if (itemTags != null && itemTags.length >= 1) {
                    for (ITag iTag : itemTags) {
                        if (iTag != null) {
                            PreDepositInfo fromTag = PreDepositInfo.fromTag(iTag);
                            if (fromTag != null) {
                                arrayList.add(fromTag);
                            }
                        }
                    }
                } else if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Int.replace(214, "g飓廷侵怸障呕乺稹")).toString());
                }
            } else if (this.f9736b != null) {
                this.f9736b.debug(this.f9737c, new StringBuilder(String.valueOf(substring)).append(BCCUtil.getChars("x泻有寿庘皖颅庸俥恥", 4, 6)).toString());
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(BCCUtil.getChars("ｙ觨柑幤厽哎庍政捫彙帩｝", 5, 54)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(BCCUtil.getChars("y觽柗帣叩咏廟敤捳奷贪", 5, 41)).toString(), ErrorMessage.local_message_command_data_invaild, false);
        }
        return arrayList;
    }

    private final /* synthetic */ BusinessOrder m13057d(byte[] bArr, IMessageHandler iMessageHandler, String str) throws BusinessException {
        BusinessOrder businessOrder;
        byte[] bArr2 = null;
        IMessage createMessage = iMessageHandler.createMessage((int) TradeCode.QUERY_ORDER);
        try {
            ITag createTag = iMessageHandler.createTag((byte) 17);
            createTag.addValue(bArr);
            createMessage.addTag(createTag);
            bArr2 = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_CN.equals("匍筝诸匞柹误旨＃构遱帱厣讳汗敶捹凲珩彈幣v", 5)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Exception.insert(276, 100, "卍筈询匑柭诮斦ｘ果逼平厴访汎敠挺奩费"), ErrorMessage.local_message_message_handle_exception, false);
        }
        byte[] interaction = this.f9738d.interaction(bArr2, FM_Utils.regionMatches(5, 27, "匀笄让匓枤设旡"), false, str);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(interaction, 2))) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(FM_Bytes.concat("匏笞诸卟柿讨旬ｆ帩叺咗庞锃讥哗廞硛0z", 3, 48)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Exception.insert(SportType.SPORT_TYPE_SWIM, 61, "卟筓讦匔枻诹ｔ幦厢夋瑊夸赣"), ErrorMessage.local_message_platform_business_handle_fail, true);
        }
        try {
            ITag tag4Id = iMessageHandler.createMessage(TradeCode.QUERY_ORDER, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(26);
            if (tag4Id == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, BCCUtil.getChars("匀筜诹匛枤诶旱6幾台咞廒攩挢沾望匀吳:\u001fq\u00106-", 5, 115));
                }
                this.f9738d.throwExceptionAndClose(FM_Bytes.concat("匏筛讦匌枫诡斮a幱厧咁底攦挥无攝", 3, 85), ErrorMessage.local_message_command_data_invaild, false);
            }
            ITag[] itemTags = tag4Id.getItemTags();
            if (itemTags == null || itemTags.length < 1) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, Util4Java.endsWith("单筑诨博柱讻斨o幻叽咟廃敬捯GzpA{8斤改捠", 3, 101));
                }
                this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(200, 9, "卍筕诨匆枹讧斸{平叹哟序整捣时敗"), ErrorMessage.local_message_command_data_invaild, false);
            }
            businessOrder = new BusinessOrder();
            for (ITag iTag : itemTags) {
                if (iTag != null) {
                    switch (iTag.getId()) {
                        case (byte) 13:
                            businessOrder.setPayChannel(iTag.getIntVal());
                            break;
                        case (byte) 15:
                            businessOrder.setCardNo(FM_Bytes.hexStringToBytes(iTag.getStringVal()));
                            break;
                        case (byte) 16:
                            businessOrder.setAmount(FM_Bytes.bytesToInt(iTag.getBytesVal()));
                            break;
                        case (byte) 17:
                            businessOrder.setOrder(iTag.getBytesVal());
                            break;
                        case (byte) 19:
                            try {
                                businessOrder.setTradeDate(iTag.getStringVal());
                                break;
                            } catch (FMCommunicationMessageException e2) {
                                break;
                            }
                        case (byte) 20:
                            businessOrder.setTradeTime(iTag.getStringVal());
                            break;
                        case (byte) 21:
                            businessOrder.setTradeState(EnumOrderStatus.getOrderStatus4ID(iTag.getIntVal()));
                            break;
                        case (byte) 22:
                            businessOrder.setSerialNo(FM_Bytes.bytesToInt(iTag.getBytesVal()));
                            break;
                        case (byte) 23:
                            businessOrder.setTerminalNo(FM_Bytes.hexStringToBytes(iTag.getStringVal()));
                            break;
                        case (byte) 24:
                            businessOrder.setInvoiceStatus(iTag.getIntVal());
                            break;
                        case (byte) 47:
                            businessOrder.setCardIoType(EnumCardIoType.getCardIoType(iTag.getIntVal()));
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (FMCommunicationMessageException e3) {
            businessOrder = null;
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(CRCUtil.substring(BusinessCode.CURRENCY_CODE_RMB, "卜杵讯弟枰订施ｚ觢果幤史哀庌攳挠彛幼ｕ")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(SportType.SPORT_TYPE_CLIMB_HILL, 2, "匁朷诨式枹讼时．觧枖幻叺品庚敠捼夥贳"), ErrorMessage.local_message_command_data_invaild, false);
            return businessOrder;
        }
        return businessOrder;
    }

    public MainOrder apply4Pay(int i, int i2, byte[] bArr, EnumCardAppType enumCardAppType) throws BusinessException {
        String equals = FM_CN.equals("诶匐略记", 1);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.debug(this.f9737c, FM_Int.replace(5, "诸匈申说('\""));
        }
        if (i < 0 || i2 < 0 || enumCardAppType == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("斯ｆ佻儩皙双敯弒帹", 6)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("旿ｖ佫儹盉叜敿异帩", 150)).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith("旷＊丑励夑琜實豥丳穴", 4, 5)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Utils.regionMatches(192, 73, "旦ｕ乘努奐琛嘮划妓南夻赶")).toString(), ErrorMessage.local_business_init_fail);
        } else {
            ApduHandler apduHandler = this.f9738d.getApduHandler();
            if (apduHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith("旷，^\u000e\u0019I够瑜嘱丢穭", 4, 31)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("斫＋详兓刂捭卸盇诲閹旸彄}\u0010DR2IWXl", 134, 10)).toString(), ErrorMessage.local_business_apdu_handler_null, false);
            }
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Exception.insert(3, 77, "旱ｘ涉怡够琎嘽丸稵")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("斬（涆恷夆琊噾乺稰", 3, 10)).toString(), ErrorMessage.local_message_load_config_fail);
            }
            int i3 = 0;
            Configration configration = this.f9738d.getConfigration();
            if (configration != null) {
                i3 = configration.getOrderSource();
                if (i3 == 0 && this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Exception.insert(2, 94, "旰ｈ诠单朻滌圲酕缸旓令丽杤寖乃")).toString());
                }
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(BCCUtil.getChars("旸｟朲戣刲鄊罢旖仠", 286, 69)).toString());
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.APPLY_ORDER_VER2);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Exception.insert(3, 30, "旱）菴厗奛琛皟帪厧夤贶")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("斬１获厕夂瑏皈帼叢奤贽", 3, 67)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(equals, server4Business);
            MainOrder a = m13035a(i3, i, i2, enumCardAppType.getId(), bArr, messageHandler, apduHandler, server4Business);
            this.f9738d.businessFinish(false);
            return a;
        }
    }

    public MainOrder applyAct4Pay(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2) throws BusinessException {
        String endsWith = Util4Java.endsWith("浤劫讥卞甼诤", 2, 4);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Utils.regionMatches(282, 39, "洱効诺匊电论z5l"));
        }
        if (bArr == null || bArr.length < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Long.copyValueOf("旼＋朮伡儻浠勰罃硓", 2)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(CRCUtil.substring(3, "旦７伦兴皘厅攢彟幰")).toString(), ErrorMessage.local_business_para_error);
        } else if (bArr2 == null || bArr2.length < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(BCCUtil.getChars("斢＜朦佨儡活労陜勴攠换", 4, 28)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(Util4Java.endsWith("旴ｈ伦儭皎厎敾归帪", 5, 66)).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(6, 74, "斠ｌ丐勵多瑎寫谽乼穪")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(CRCUtil.substring(3, "旦７东劰夘瑁嘺剀妃卅奯贬")).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_CN.equals("斮ｅ淒怤夘琋噶丵空", 5)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(FM_Exception.insert(3, 37, "旱＀淙怹够瑆嘭丰穵")).toString(), ErrorMessage.local_message_load_config_fail);
            }
            Configration configration = this.f9738d.getConfigration();
            if (configration == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(BCCUtil.getChars("斥２鄄缺俾急宬象乱稬", 3, 43)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(3, 54, "斥％鄒罻侪恮寮谬丹稣")).toString(), ErrorMessage.local_message_load_config_fail);
            }
            int orderSource = configration.getOrderSource();
            if (orderSource == (byte) 0 && this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(Util4Java.endsWith("旴ｗ诶匘朣滏坰鄜缤旄仪丸朤宝义", 5, 121)).toString());
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.APPLY_ORDER_EX_VER2);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(Util4Java.endsWith("旷４莸厐奙瑒皏幱叩奡赢", 4, 23)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(42, 1, "旬７莫友多琙的干史夲贡")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(endsWith, server4Business);
            MainOrder a = m13036a(orderSource, enumCardAppType.getId(), bArr, bArr2, messageHandler, server4Business);
            this.f9738d.businessFinish(false);
            return a;
        }
    }

    public TicketOperateResult buyTicket(String str, byte[] bArr) throws BusinessException {
        String regionMatches = FM_Utils.regionMatches(2, 107, "畡遇乒劲甭课");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(282, 104, "$|t")).toString());
        }
        if (str == null || str.length() < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_CN.equals("斻２甧户俰恭乩稾", 90)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(Util4Java.endsWith("旷／佥儢皍叉攽彍帩", 4, 34)).toString(), ErrorMessage.local_business_para_error);
        } else if (bArr == null || bArr.length < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(Util4Java.endsWith("斵ｖ洪勠骓讗敽挪乡穨", 198, 55)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(266, "旡．伭兽盇厌攩彆幷")).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(5, 28, "斣＝丗勨奁琇寤豸乯稫")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(Util4Java.endsWith("斨ｑ丆劺奞瑟噰刊妝千夥贶", 1, 95)).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("斬ｂ涊怹奎琘嘺乼穠", 3, 84)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(BCCUtil.getChars("斥ｎ涙怯夋瑘嘥並稱", 3, 79)).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String str2 = null;
            Configration configration = this.f9738d.getConfigration();
            if (configration != null) {
                str2 = configration.getCompanyCode();
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(Util4Java.endsWith("旵５L*57nza(+<do7乷稹", 6, 22)).toString());
            }
            if (str2 == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(3, 68, "斥；畳戨扃尙啍扸丩稭")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(244, 28, "斲，甴戯戔導啊房乾稺")).toString(), ErrorMessage.local_business_para_error);
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.TICKET_MANAGER);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(5, 65, "斣：菠収奝琜盟幯厭夯赺")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("斪！莩叙奄瑗盆帠叴夤责", 5, 17)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(regionMatches, server4Business);
            TicketOperateResult a = m13040a(str, str2, bArr, messageHandler, server4Business);
            this.f9738d.businessFinish(false);
            return a;
        }
    }

    public int deleteTerminalInfoBack(byte[] bArr) throws BusinessException {
        String replace = FM_Int.replace(4, "剹阸纗竭又馀俪恡");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, replace);
        }
        if (bArr == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Bytes.concat("施i绗窶厞馅俦怮栜诓乵稳", 244, 90)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(CRCUtil.substring(3, "旦７绎竾发駏侳怲桏讕乤穳")).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(BCCUtil.getChars("ｙ乚努奒琇宵豶丸稷", 5, 75)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Int.replace(4, "ｕ乆勾夆球噠刖姅匇夥贲")).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(CRCUtil.substring(228, "｝淔恨外琛噠丩穤")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Bytes.concat("ｗ涍恠夝琅噥中稻", 4, 10)).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.REFUND_VER2);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_CN.equals("旹，莦叔套瑂监帵叧夹贼", 316)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(CRCUtil.substring(TransportMediator.KEYCODE_MEDIA_RECORD, "旹６莲叆够瑀盕帯厷奣赸")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(replace, server4Business);
            byte[] bArr2 = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.DELETE_TERMINAL_BACK);
            try {
                ITag createTag = messageHandler.createTag((byte) 81);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
                bArr2 = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Utils.regionMatches(3, 114, "斥i染適幨叽诨汓敳挻彅幡q")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(FM_CN.equals("u柎遻帿叭诹汝敠捯奣赦", 6)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            bArr2 = this.f9738d.interaction(bArr2, replace, false, server4Business);
            byte[] copyOf = Arrays.copyOf(bArr2, 2);
            this.f9738d.businessFinish(false);
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
                return 0;
            }
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Long.copyValueOf("旦！幹号哉底锇说哕庁砓5,", 296)).append(FM_Bytes.bytesToHexString(bArr2)).toString());
            }
            return FM_CN.bcdBytesToInt(copyOf);
        }
    }

    public int doRefund(byte[] bArr) throws BusinessException {
        String equals = FM_CN.equals("遖歹畫设", 3);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Int.replace(5, "遚正申说('\""));
        }
        if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(310, 21, "逆欥畣讲斬＃丞劸奊瑅审豬丸穭"));
            }
            throw new BusinessException(FM_Int.replace(138, "遟欼甶诿旽＂下劵夓琜噵初姈匐夸贩"), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Exception.insert(286, 37, "适歹畿详无ｗ消恪奎瑉噼丣稤"));
            }
            throw new BusinessException(BCCUtil.getChars("遞歽畻诺旤｛淔怮夂琍嘸乯穠", 270, 101), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.REFUND_VER2);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(BCCUtil.getChars("斣ｗ菶发変瑕盝幬叵夺赴", 5, 102)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Long.copyValueOf("旻＆莰叒夅瑘盟師厥奣赪", 5)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(equals, server4Business);
        byte[] bArr2 = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.REFUND_VER2);
        try {
            ITag createTag = messageHandler.createTag((byte) TagName.MAIN_ORDER_ID);
            createTag.addValue(bArr);
            createMessage.addTag(createTag);
            bArr2 = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(BCCUtil.getChars("遂歬由该旴>柆遲帱厢诵汐敲捼彀幪x", 370, 16)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Bytes.concat("遙欬畸诳斫:柋逨帲厪诤氎敵挰夦赵", 2, 57), ErrorMessage.local_message_message_handle_exception, false);
        }
        bArr2 = this.f9738d.interaction(bArr2, FM_Long.copyValueOf("逋欶甶诵", 3), false, server4Business);
        byte[] copyOf = Arrays.copyOf(bArr2, 2);
        this.f9738d.businessFinish(false);
        if (Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
            return 0;
        }
        if (this.f9736b != null) {
            this.f9736b.error(this.f9737c, new StringBuilder(FM_Int.replace(1, "遖歧畯讨旴）幻叻哃庅锍诸哗庉码9&")).append(FM_Bytes.bytesToHexString(bArr2)).toString());
        }
        return FM_CN.bcdBytesToInt(copyOf);
    }

    public int doUnsolvedOrder(byte[] bArr, byte[] bArr2) throws BusinessException {
        ITag tag4Id;
        IMessage iMessage;
        Exception exception;
        ITag iTag;
        ITag iTag2;
        Object obj;
        IMessage iMessage2;
        if (this.f9736b != null) {
            this.f9736b.warn(this.f9737c, Util4Java.endsWith("e|\u0010y:4a)t'\u001au=noor'de=5cq?", 4, 50));
        }
        String regionMatches = FM_Utils.regionMatches(118, 72, "奂琈杼冭亢晝");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_CN.equals("契瑀杽击亽昙5\"s", 2));
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(5, 80, "契瑃朿凶亱昖斣）乏勤夑瑃寬豤乯穿"));
            }
            throw new BusinessException(Util4Java.endsWith("夅理朵凭仹昏旭ｖ乃効夓瑐嘽刉姘卄奠贵", 4, 31), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, CRCUtil.substring(4, "夕琚札冡亹晛斥ｒ淁总奛琌噽为穱"));
            }
            throw new BusinessException(CRCUtil.substring(TransportMediator.KEYCODE_MEDIA_PLAY, "夏琐末冿亳晑斻ｔ淋怡奝琂噧丠穿"), ErrorMessage.local_message_load_config_fail);
        }
        ApduHandler apduHandler = this.f9738d.getApduHandler();
        if (apduHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Bytes.concat("変琍朣冴亡昐旷３|k}b挒价夕琉噥丱穳", 310, TransportMediator.KEYCODE_MEDIA_PLAY));
            }
            throw new BusinessException(FM_Exception.insert(5, 8, "七浦亽逛卨穫临億偵斧ｕ讶儁剖挻占皍议闷斸弆9V\f\b~\u0017\u0007\nx"), ErrorMessage.local_business_apdu_handler_null);
        }
        if (apduHandler.isConnect()) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, FM_Exception.insert(6, 17, "夎琝朦冮仪晌斦－SSP\u0010奒瑁嘰歪心"));
            }
            this.f9738d.throwExceptionAndClose(Util4Java.endsWith("奍琉朿凨以晔旻？\u0018\u000f\u0001^夕瑑嘵欠忐", 204, 102), ErrorMessage.local_business_apdu_handler_busying, false);
        } else if (!apduHandler.connect()) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, CRCUtil.substring(4, "夕琚札冡亹晛斥ｒ辗揱匾夻贰"));
            }
            this.f9738d.throwExceptionAndClose(Util4Java.endsWith("处琊朲冷亴昏斾ｘ辞揩匹夵贵", 3, 12), ErrorMessage.local_message_apdu_execute_exception, true);
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.DEAL_WITH_DOUBT);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_Int.replace(3, "斮ｗ菩受夀琁皎幾叠夢贳")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_Int.replace(278, "旽＂莦参夓琜皙平右夷贬")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(regionMatches, server4Business);
        byte[] bArr3 = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.DEAL_WITH_DOUBT);
        try {
            ITag createTag = messageHandler.createTag((byte) 17);
            createTag.addValue(bArr);
            createMessage.addTag(createTag);
            bArr3 = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Int.replace(4, "杳凯任昑夁琎'枊週幧叧语江数捭弄帱６")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Bytes.concat("杳冮以晖复琋}柑逹幮厱诲汋攽挿夤贼", 2, 36), ErrorMessage.local_message_message_handle_exception, true);
        }
        byte[] interaction = this.f9738d.interaction(bArr3, FM_Long.copyValueOf("朤冸京昖夆瑙", 6), true, server4Business);
        IMessage iMessage3 = null;
        byte[] copyOf = Arrays.copyOf(interaction, 2);
        ApduReponseList apduReponseList = null;
        Object obj2 = null;
        while (Arrays.equals(RespCodeonse4Platform.CARD_REQUEST, copyOf)) {
            ITag iTag3;
            ApduRequestList apduRequestList = new ApduRequestList();
            ITag iTag4 = null;
            try {
                createMessage = messageHandler.createMessage(interaction);
                iTag4 = createMessage.getTag4Id(-96);
                try {
                    ITag tag4Id2;
                    ITag tag4Id3;
                    tag4Id = createMessage.getTag4Id(-95);
                    try {
                        tag4Id2 = createMessage.getTag4Id(-90);
                        tag4Id3 = createMessage.getTag4Id(-89);
                        createMessage = messageHandler.createMessage(9001);
                    } catch (Exception e2) {
                        iMessage = iMessage3;
                        exception = e2;
                        iTag = tag4Id;
                        tag4Id = iTag4;
                        if (this.f9736b != null) {
                            this.f9736b.warn(Util4Java.endsWith("l()A}d", 3, 103), new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(ReportInfoUtils.FEEDBACK_FAILED, "觪构幬叺哘廔攻挸冻珼录帺7")).append(Util4Java.getExceptionInfo(exception)).toString());
                        }
                        this.f9738d.throwExceptionAndClose(FM_Int.replace(74, "觼柒帶厸咆廚攡挺奦赿"), ErrorMessage.local_message_command_data_invaild, true);
                        iTag3 = iTag;
                        createMessage = iMessage;
                        if (tag4Id != null) {
                            iTag2 = tag4Id;
                            obj = null;
                            createTag = iTag2;
                        } else {
                            obj = obj2;
                            createTag = null;
                        }
                        if (iTag3 != null) {
                            obj2 = 1;
                        } else {
                            iTag3 = createTag;
                            obj2 = obj;
                        }
                        apduRequestList.fromTag(iTag3);
                        apduReponseList = this.f9738d.getScriptHandler().execute(apduRequestList);
                        if (this.f9736b != null) {
                            this.f9736b.warn(this.f9737c, BCCUtil.getChars("义勭奁瑘斡｜咄廖终枈丷穼", 3, 121));
                        }
                        this.f9738d.throwExceptionAndClose(FM_Bytes.concat("杵圲扬衘扺衊夾贽", SportType.SPORT_TYPE_RUN, 9), ErrorMessage.local_message_apdu_execute_exception, true);
                        bArr3 = null;
                        if (obj2 == null) {
                            try {
                                createMessage.addTag(apduReponseList.toTag4A2());
                            } catch (FMCommunicationMessageException e3) {
                                if (this.f9736b != null) {
                                    this.f9736b.warn(this.f9737c, FM_Long.copyValueOf("丐劦夀琇斨ｗ柜遵纚窠咁廝收挭冺班彘幯", 2));
                                }
                                this.f9738d.throwExceptionAndClose(BCCUtil.getChars("柗逶幪厬讨汀攵挦夺贫", 3, 35), ErrorMessage.local_message_message_handle_exception, true);
                            }
                        } else {
                            createMessage.addTag(apduReponseList.toTag4A3());
                        }
                        bArr3 = createMessage.toBytes();
                        if (this.f9736b != null) {
                            this.f9736b.debug(this.f9737c, new StringBuilder(Util4Java.endsWith("戹衄寞扌&\"?t!6g?l", 1, 42)).append(FM_Bytes.bytesToHexString(bArr3)).toString());
                        }
                        if (this.f9736b != null) {
                            this.f9736b.debug(this.f9737c, FM_Bytes.concat("纒窬夈瑓宒扗＜厈遃夏瑒绎柚绖師厱$}2", 3, 73));
                        }
                        interaction = this.f9738d.interaction(bArr3, regionMatches, true, server4Business);
                        iMessage2 = createMessage;
                        copyOf = Arrays.copyOf(interaction, 2);
                        iMessage3 = iMessage2;
                    }
                    try {
                        createMessage.addTag(tag4Id2);
                        createMessage.addTag(tag4Id3);
                        iTag3 = tag4Id;
                        tag4Id = iTag4;
                    } catch (FMCommunicationMessageException e4) {
                        exception = e4;
                        iMessage = createMessage;
                        iTag = tag4Id;
                        tag4Id = iTag4;
                        if (this.f9736b != null) {
                            this.f9736b.warn(Util4Java.endsWith("l()A}d", 3, 103), new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(ReportInfoUtils.FEEDBACK_FAILED, "觪构幬叺哘廔攻挸冻珼录帺7")).append(Util4Java.getExceptionInfo(exception)).toString());
                        }
                        this.f9738d.throwExceptionAndClose(FM_Int.replace(74, "觼柒帶厸咆廚攡挺奦赿"), ErrorMessage.local_message_command_data_invaild, true);
                        iTag3 = iTag;
                        createMessage = iMessage;
                        if (tag4Id != null) {
                            obj = obj2;
                            createTag = null;
                        } else {
                            iTag2 = tag4Id;
                            obj = null;
                            createTag = iTag2;
                        }
                        if (iTag3 != null) {
                            iTag3 = createTag;
                            obj2 = obj;
                        } else {
                            obj2 = 1;
                        }
                        apduRequestList.fromTag(iTag3);
                        apduReponseList = this.f9738d.getScriptHandler().execute(apduRequestList);
                        if (this.f9736b != null) {
                            this.f9736b.warn(this.f9737c, BCCUtil.getChars("义勭奁瑘斡｜咄廖终枈丷穼", 3, 121));
                        }
                        this.f9738d.throwExceptionAndClose(FM_Bytes.concat("杵圲扬衘扺衊夾贽", SportType.SPORT_TYPE_RUN, 9), ErrorMessage.local_message_apdu_execute_exception, true);
                        bArr3 = null;
                        if (obj2 == null) {
                            createMessage.addTag(apduReponseList.toTag4A3());
                        } else {
                            createMessage.addTag(apduReponseList.toTag4A2());
                        }
                        bArr3 = createMessage.toBytes();
                        if (this.f9736b != null) {
                            this.f9736b.debug(this.f9737c, new StringBuilder(Util4Java.endsWith("戹衄寞扌&\"?t!6g?l", 1, 42)).append(FM_Bytes.bytesToHexString(bArr3)).toString());
                        }
                        if (this.f9736b != null) {
                            this.f9736b.debug(this.f9737c, FM_Bytes.concat("纒窬夈瑓宒扗＜厈遃夏瑒绎柚绖師厱$}2", 3, 73));
                        }
                        interaction = this.f9738d.interaction(bArr3, regionMatches, true, server4Business);
                        iMessage2 = createMessage;
                        copyOf = Arrays.copyOf(interaction, 2);
                        iMessage3 = iMessage2;
                    }
                } catch (Exception e22) {
                    tag4Id = iTag4;
                    iMessage = iMessage3;
                    exception = e22;
                    iTag = null;
                    if (this.f9736b != null) {
                        this.f9736b.warn(Util4Java.endsWith("l()A}d", 3, 103), new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(ReportInfoUtils.FEEDBACK_FAILED, "觪构幬叺哘廔攻挸冻珼录帺7")).append(Util4Java.getExceptionInfo(exception)).toString());
                    }
                    this.f9738d.throwExceptionAndClose(FM_Int.replace(74, "觼柒帶厸咆廚攡挺奦赿"), ErrorMessage.local_message_command_data_invaild, true);
                    iTag3 = iTag;
                    createMessage = iMessage;
                    if (tag4Id != null) {
                        iTag2 = tag4Id;
                        obj = null;
                        createTag = iTag2;
                    } else {
                        obj = obj2;
                        createTag = null;
                    }
                    if (iTag3 != null) {
                        obj2 = 1;
                    } else {
                        iTag3 = createTag;
                        obj2 = obj;
                    }
                    apduRequestList.fromTag(iTag3);
                    apduReponseList = this.f9738d.getScriptHandler().execute(apduRequestList);
                    if (this.f9736b != null) {
                        this.f9736b.warn(this.f9737c, BCCUtil.getChars("义勭奁瑘斡｜咄廖终枈丷穼", 3, 121));
                    }
                    this.f9738d.throwExceptionAndClose(FM_Bytes.concat("杵圲扬衘扺衊夾贽", SportType.SPORT_TYPE_RUN, 9), ErrorMessage.local_message_apdu_execute_exception, true);
                    bArr3 = null;
                    if (obj2 == null) {
                        createMessage.addTag(apduReponseList.toTag4A2());
                    } else {
                        createMessage.addTag(apduReponseList.toTag4A3());
                    }
                    bArr3 = createMessage.toBytes();
                    if (this.f9736b != null) {
                        this.f9736b.debug(this.f9737c, new StringBuilder(Util4Java.endsWith("戹衄寞扌&\"?t!6g?l", 1, 42)).append(FM_Bytes.bytesToHexString(bArr3)).toString());
                    }
                    if (this.f9736b != null) {
                        this.f9736b.debug(this.f9737c, FM_Bytes.concat("纒窬夈瑓宒扗＜厈遃夏瑒绎柚绖師厱$}2", 3, 73));
                    }
                    interaction = this.f9738d.interaction(bArr3, regionMatches, true, server4Business);
                    iMessage2 = createMessage;
                    copyOf = Arrays.copyOf(interaction, 2);
                    iMessage3 = iMessage2;
                }
            } catch (Exception e222) {
                tag4Id = iTag4;
                iMessage = iMessage3;
                exception = e222;
                iTag = null;
                if (this.f9736b != null) {
                    this.f9736b.warn(Util4Java.endsWith("l()A}d", 3, 103), new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(ReportInfoUtils.FEEDBACK_FAILED, "觪构幬叺哘廔攻挸冻珼录帺7")).append(Util4Java.getExceptionInfo(exception)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_Int.replace(74, "觼柒帶厸咆廚攡挺奦赿"), ErrorMessage.local_message_command_data_invaild, true);
                iTag3 = iTag;
                createMessage = iMessage;
                if (tag4Id != null) {
                    obj = obj2;
                    createTag = null;
                } else {
                    iTag2 = tag4Id;
                    obj = null;
                    createTag = iTag2;
                }
                if (iTag3 != null) {
                    iTag3 = createTag;
                    obj2 = obj;
                } else {
                    obj2 = 1;
                }
                apduRequestList.fromTag(iTag3);
                apduReponseList = this.f9738d.getScriptHandler().execute(apduRequestList);
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, BCCUtil.getChars("义勭奁瑘斡｜咄廖终枈丷穼", 3, 121));
                }
                this.f9738d.throwExceptionAndClose(FM_Bytes.concat("杵圲扬衘扺衊夾贽", SportType.SPORT_TYPE_RUN, 9), ErrorMessage.local_message_apdu_execute_exception, true);
                bArr3 = null;
                if (obj2 == null) {
                    createMessage.addTag(apduReponseList.toTag4A3());
                } else {
                    createMessage.addTag(apduReponseList.toTag4A2());
                }
                bArr3 = createMessage.toBytes();
                if (this.f9736b != null) {
                    this.f9736b.debug(this.f9737c, new StringBuilder(Util4Java.endsWith("戹衄寞扌&\"?t!6g?l", 1, 42)).append(FM_Bytes.bytesToHexString(bArr3)).toString());
                }
                if (this.f9736b != null) {
                    this.f9736b.debug(this.f9737c, FM_Bytes.concat("纒窬夈瑓宒扗＜厈遃夏瑒绎柚绖師厱$}2", 3, 73));
                }
                interaction = this.f9738d.interaction(bArr3, regionMatches, true, server4Business);
                iMessage2 = createMessage;
                copyOf = Arrays.copyOf(interaction, 2);
                iMessage3 = iMessage2;
            }
            if (tag4Id != null) {
                iTag2 = tag4Id;
                obj = null;
                createTag = iTag2;
            } else {
                obj = obj2;
                createTag = null;
            }
            if (iTag3 != null) {
                obj2 = 1;
            } else {
                iTag3 = createTag;
                obj2 = obj;
            }
            try {
                apduRequestList.fromTag(iTag3);
            } catch (Exception exception2) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(FM_Exception.insert(46, 67, "丈勴夜瑝旨－帷号咇庙盔散挸觺柌弝幺？")).append(Util4Java.getExceptionInfo(exception2)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_Exception.insert(284, 115, "平口哋廍盈支挼覦枈夺贻"), ErrorMessage.local_communication_invalid_response, true);
            } catch (Exception exception22) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(FM_CN.equals("乏勧奓瑎旯＆幨叼咐廚盛攠振觱枓弖帽", 2)).append(Util4Java.getExceptionInfo(exception22)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_Bytes.concat("帯厠咉廌盈攰捺觫枌夡贡", 5, SpecialIssueType.BUG_TYPE_ID_CHARGE), ErrorMessage.local_communication_invalid_response, true);
            }
            try {
                apduReponseList = this.f9738d.getScriptHandler().execute(apduRequestList);
            } catch (FMScriptHandleException e5) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, Util4Java.endsWith("丘勷夎瑘斤＊腀杢扥蠚冰玮彐幾", 5, 84));
                }
                if (e5 == null || ScriptHandleExceptionType.STOPED != e5.getType()) {
                    this.f9738d.throwExceptionAndClose(FM_CN.equals("杴坹戽蠇扻衁夯贪", 5), ErrorMessage.local_message_apdu_execute_exception, true);
                } else {
                    this.f9738d.throwExceptionAndClose(FM_Int.replace(2, "乍勻奙理袨叐涁"), ErrorMessage.local_business_cancel, true);
                }
            }
            if (apduReponseList == null || apduReponseList.size() < 1) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, BCCUtil.getChars("义勭奁瑘斡｜咄廖终枈丷穼", 3, 121));
                }
                this.f9738d.throwExceptionAndClose(FM_Bytes.concat("杵圲扬衘扺衊夾贽", SportType.SPORT_TYPE_RUN, 9), ErrorMessage.local_message_apdu_execute_exception, true);
            }
            bArr3 = null;
            if (obj2 == null) {
                createMessage.addTag(apduReponseList.toTag4A2());
            } else {
                createMessage.addTag(apduReponseList.toTag4A3());
            }
            bArr3 = createMessage.toBytes();
            if (this.f9736b != null) {
                this.f9736b.debug(this.f9737c, new StringBuilder(Util4Java.endsWith("戹衄寞扌&\"?t!6g?l", 1, 42)).append(FM_Bytes.bytesToHexString(bArr3)).toString());
            }
            if (this.f9736b != null) {
                this.f9736b.debug(this.f9737c, FM_Bytes.concat("纒窬夈瑓宒扗＜厈遃夏瑒绎柚绖師厱$}2", 3, 73));
            }
            interaction = this.f9738d.interaction(bArr3, regionMatches, true, server4Business);
            iMessage2 = createMessage;
            copyOf = Arrays.copyOf(interaction, 2);
            iMessage3 = iMessage2;
        }
        this.f9738d.businessFinish(true);
        if (Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
            return 0;
        }
        if (this.f9736b != null) {
            this.f9736b.warn(this.f9737c, new StringBuilder(FM_Exception.insert(250, 96, "杴凭人昍奚瑘２幭厮咓床锇讱咓床砟d~")).append(FM_Bytes.bytesToHexString(interaction)).toString());
        }
        return FM_CN.bcdBytesToInt(copyOf);
    }

    public byte[] getAppNo(EnumCardAppType enumCardAppType) throws BusinessException {
        byte[] bArr = null;
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Utils.regionMatches(5, 22, "菢叝底甿廂剔厮!+5"));
        }
        CardManager cardManager = CardManagerFactory.instance().getCardManager(enumCardAppType);
        if (cardManager != null) {
            ApduHandler apduHandler = this.f9738d.getApduHandler();
            if (apduHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_Long.copyValueOf("莻叟庒甫序削厭斡ｘ\u0010\u001e\u000f\u001d奁瑄嘷书稣", 4));
                }
                this.f9738d.throwExceptionAndClose(CRCUtil.substring(196, "菦厊廓畺廒刟古旨％诣兗前挷匡盏诩闯斵弘*BU\u0002a\u0017\u0002\fs"), ErrorMessage.local_business_apdu_handler_null, false);
            }
            if (apduHandler.isConnect()) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_CN.equals("莰厎廝畲廄刋叺旨＃A\u0001\u0006\u0006奀琓噮歴忑", 276));
                }
                this.f9738d.throwExceptionAndClose(FM_Bytes.concat("菭原庌畯庙划厣旵～\u0000@\u001b[奙瑊噳欩忀", 3, 79), ErrorMessage.local_business_apdu_handler_busying, false);
            } else if (!apduHandler.connect()) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, CRCUtil.substring(356, "菦厊库町庒刟古旨ｅ辊揺匫奤败"));
                }
                this.f9738d.throwExceptionAndClose(CRCUtil.substring(4, "莦及库町庒剟厤斨ｅ辊揺卫夤败"), ErrorMessage.local_message_apdu_execute_exception, true);
            }
            cardManager.setApduHandler(apduHandler);
            try {
                bArr = cardManager.getAppNo();
            } catch (BusinessException e) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_Exception.insert(214, 72, "菭叔廞町廕剕叽斤几珲弈幪"));
                }
                this.f9738d.throwExceptionAndClose(FM_Exception.insert(1, 121, "莲厈廃畸廆剕厬斢冷珶弝帠"), ErrorMessage.local_message_apdu_execute_exception, true);
            } finally {
                apduHandler.close();
            }
        } else if (this.f9736b != null) {
            this.f9736b.warn(this.f9737c, FM_Long.copyValueOf("莻叟庒甫序削厭斡ｘ菦厘捌寒匤簹埔盘奝瑐嘻奡赨", 4));
        }
        return bArr;
    }

    public Integer getBalance(EnumCardAppType enumCardAppType) throws BusinessException {
        Integer num = null;
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, Util4Java.endsWith("获叚仼逞危盘佑颉n\"6", 3, 44));
        }
        String substring = CRCUtil.substring(2, "莸双亡逊卺盂伈飁");
        CardManager cardManager = CardManagerFactory.instance().getCardManager(enumCardAppType);
        if (cardManager != null) {
            ApduHandler apduHandler = this.f9738d.getApduHandler();
            if (apduHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("斬＂\u0003F\u000e\u000b外瑀噲乴穸", 3, 52)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("斩＞讲児剌挼印盀讨閤旤弟kY\u0004\u001d \fS\u000br", 2, 51)).toString(), ErrorMessage.local_business_apdu_handler_null, false);
            }
            if (apduHandler.isConnect()) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Int.replace(344, "斻｜\u0012\u0006\u001d\t奛瑄嘭欫徒")).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(164, 54, "既ｆAF\bW奜琈嘬欹忉")).toString(), ErrorMessage.local_business_apdu_handler_busying, false);
            } else if (!apduHandler.connect()) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_CN.equals("｛辖揼匫太贩", 4)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Long.copyValueOf("斾ｉ辜揺匽奨赳", 224)).toString(), ErrorMessage.local_message_apdu_execute_exception, true);
            }
            cardManager.setApduHandler(apduHandler);
            try {
                num = Integer.valueOf(cardManager.queryBalance());
            } catch (BusinessException e) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Long.copyValueOf("旻凰玷弆帹", 5)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Exception.insert(SyslogAppender.LOG_LOCAL7, 61, "旪冣玦彑帨")).toString(), ErrorMessage.local_message_apdu_execute_exception, true);
            } finally {
                apduHandler.close();
            }
        } else if (this.f9736b != null) {
            this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_CN.equals("ｘ菲厀捀宂卨籡垀盘奉瑘嘧奱贴", 1)).toString());
        }
        return num;
    }

    public CardAppInfo getCardAppInfo(int i, EnumCardAppType enumCardAppType) throws BusinessException {
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Utils.regionMatches(4, 102, "\u0007\u000e\u0010E,19l`*98zm&`z"));
        }
        CardAppInfo cardAppInfo = new CardAppInfo();
        cardAppInfo.setTitle(FM_Int.replace(5, "菭压卡皇佟颔咀享昁讥彍"));
        CardManager cardManager = CardManagerFactory.instance().getCardManager(enumCardAppType);
        if (cardManager == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, Util4Java.endsWith("菰厎卨盞佒颁品人晜记彄斴？菳厃持寍卩籢埁皟奈瑛噦奮贵", 202, 49));
            }
            return cardAppInfo;
        }
        ApduHandler apduHandler = this.f9738d.getApduHandler();
        if (apduHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, Util4Java.endsWith("莶变区皌佌食咃亸晚讦弖｜\\\u001a\u0013Q奕瑘噣乢穿", 4, 45));
            }
            this.f9738d.throwExceptionAndClose(FM_Long.copyValueOf("莻叟卧靡号斫ｖ讠儜剖挬匪盌诺閬旦当q\u0019\u001e\u0011b\u0004\u0001\u0007h", 4), ErrorMessage.local_business_apdu_handler_null, false);
        }
        if (apduHandler.isConnect()) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, CRCUtil.substring(2, "莸双卤皔佂飛哝仸晔询弈旾？_YPJ奎瑓嘨欨徏"));
            }
            this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(4, 3, "菣厁医盙余颞咊亭星访彇旣４ZNEQ夃琌噥歳忊"), ErrorMessage.local_business_apdu_handler_busying, false);
        } else {
            apduHandler.connect();
        }
        cardManager.setApduHandler(apduHandler);
        if ((i & 1) != 0) {
            try {
                cardAppInfo.setFaceId(cardManager.getFaceID());
                cardAppInfo.setCardAppNo(cardManager.getAppNo());
            } catch (BusinessException e) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, Util4Java.endsWith("莴厛匶之俪恺斩决珣弟帿", 6, 106));
                }
                this.f9738d.throwExceptionAndClose(BCCUtil.getChars("菳叒卥乎侥恫旲冾珴弆帼", 244, 32), ErrorMessage.local_message_apdu_execute_exception, true);
            } finally {
                apduHandler.close();
            }
        }
        if ((i & 2) != 0) {
            cardAppInfo.setBalance(Integer.valueOf(cardManager.queryBalance()));
        }
        if ((i & 4) != 0) {
            for (CardAppRecord addRecord : cardManager.readAppRecords()) {
                cardAppInfo.addRecord(addRecord);
            }
        }
        if ((i & 8) != 0) {
            cardAppInfo.setAppClose(cardManager.isLock4Consume());
        }
        if ((i & 16) != 0) {
            cardAppInfo.setMoc(cardManager.getMOC());
        }
        if ((i & 32) != 0) {
            cardAppInfo.setTime4Validity(cardManager.getTime4Validity());
        }
        apduHandler.close();
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Long.copyValueOf("莻叟卧皇余飀哖仳晇诡弛寇托", 4));
        }
        return cardAppInfo;
    }

    public List<CardAppRecord> getCardAppRecords(EnumCardAppType enumCardAppType) throws BusinessException {
        List<CardAppRecord> list = null;
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Utils.regionMatches(212, 5, "菳原匯盗仼晎诲弒bx"));
        }
        String substring = CRCUtil.substring(1, "莹叏卥皋亾晖诠弎");
        CardManager cardManager = CardManagerFactory.instance().getCardManager(enumCardAppType);
        if (cardManager != null) {
            ApduHandler apduHandler = this.f9738d.getApduHandler();
            if (apduHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("斳＇\u0010G\u0019V奍琉嘽両穻", 328, 70)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("时｜请儘則捲匡皔访閾方彟h_\rQ/\u001eF\u0013i", 3, 80)).toString(), ErrorMessage.local_business_apdu_handler_null, false);
            }
            if (apduHandler.isConnect()) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Long.copyValueOf("旼＋EQ\u001a\u000e奜瑓嘺欬徕", 2)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(CRCUtil.substring(2, "旹６D@_\u0013奕瑚嘯欱径")).toString(), ErrorMessage.local_business_apdu_handler_busying, false);
            } else if (!apduHandler.connect()) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(4, 26, "斢＂迖揧匽奧贵")).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(2, 3, "斤ｙ辆揾匿夰贡")).toString(), ErrorMessage.local_message_apdu_execute_exception, true);
            }
            cardManager.setApduHandler(apduHandler);
            try {
                list = cardManager.readAppRecords();
            } catch (BusinessException e) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(substring)).append(CRCUtil.substring(1, "旸凣玴弍帢")).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(2, 68, "斤凬珪弜帺")).toString(), ErrorMessage.local_message_apdu_execute_exception, true);
            } finally {
                apduHandler.close();
            }
        } else if (this.f9736b != null) {
            this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Exception.insert(3, 78, "＋菢叕捖宅卬簠垂盓奁琕嘩夾赸")).toString());
        }
        return list;
    }

    public EnumCardAppType getCardAppType() throws BusinessException {
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, Util4Java.endsWith("莶压匸监簪埆gko", 4, ReportInfoUtils.FEEDBACK_FAILED));
        }
        String replace = FM_Int.replace(244, "菾厚匮盖簮埓断");
        ApduHandler apduHandler = this.f9738d.getApduHandler();
        if (apduHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_CN.equals("１OOTT奖瑅嘼乿穬", 202)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(FM_Bytes.concat("７讻儕刉挽危盅语闭旭弊>\bU\buE\u001aN7", 292, 49)).toString(), ErrorMessage.local_business_apdu_handler_null, false);
        }
        if (apduHandler.isConnect()) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Bytes.concat("７\r\r\n\n夔琇噺欠徍", 196, 17)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(FM_Long.copyValueOf("％GSD\b奞瑑嘼欲得", 1)).toString(), ErrorMessage.local_business_apdu_handler_busying, false);
        } else if (!apduHandler.connect()) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_CN.equals("ａ迀措卡夠货", 90)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(FM_Long.copyValueOf("～辑揩匨奷赦", 106)).toString(), ErrorMessage.local_message_apdu_execute_exception, true);
        }
        CardManagerFactory.instance().setApduHandler(apduHandler);
        EnumCardAppType enumCardAppType = null;
        try {
            enumCardAppType = CardManagerFactory.instance().getCardAppType();
        } catch (BusinessException e) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Utils.regionMatches(2, 90, "冨珼弄常")).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(FM_Long.copyValueOf("凷玺弅帼", 5)).toString(), ErrorMessage.local_message_apdu_execute_exception, true);
        } finally {
            apduHandler.close();
        }
        return enumCardAppType;
    }

    public List<EnumCardAppType> getCardAppTypes() throws BusinessException {
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Long.copyValueOf("莾叐卢的簦埑yz", 1));
        }
        String endsWith = Util4Java.endsWith("获变匽皎籣埍既", 3, 46);
        ApduHandler apduHandler = this.f9738d.getApduHandler();
        if (apduHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Bytes.concat("ｕU_\u000e\u0010处琝噾乫稶", 2, 27)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(endsWith)).append(FM_Int.replace(2, "｛训儕切捡卧皍讳闡斫弚0TS@+ILN9")).toString(), ErrorMessage.local_business_apdu_handler_null, false);
        }
        if (apduHandler.isConnect()) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_CN.equals("ｕ\u000b\u000b\bH夊琙噸止律", 134)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(endsWith)).append(FM_Exception.insert(290, 21, "＊Z\u0000\u0001\u000f夋琂噱欭徚")).toString(), ErrorMessage.local_business_apdu_handler_busying, false);
        } else if (!apduHandler.connect()) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(110, 14, "ｒ辒揿卩大贡")).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(endsWith)).append(FM_Exception.insert(142, 108, "＞辀揯匷女贫")).toString(), ErrorMessage.local_message_apdu_execute_exception, true);
        }
        CardManagerFactory.instance().setApduHandler(apduHandler);
        List<EnumCardAppType> list = null;
        try {
            list = CardManagerFactory.instance().getCardAppTypes();
        } catch (BusinessException e) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Bytes.concat("凵玨弃帲", 280, 9)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(endsWith)).append(FM_Bytes.concat("凭玠彋幺", 192, 89)).toString(), ErrorMessage.local_message_apdu_execute_exception, true);
        } finally {
            apduHandler.close();
        }
        return list;
    }

    public String getFaceID(EnumCardAppType enumCardAppType) throws BusinessException {
        String str = null;
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Exception.insert(4, 43, "莿叅仺逓卵盛卫靷厷%8o"));
        }
        CardManager cardManager = CardManagerFactory.instance().getCardManager(enumCardAppType);
        if (cardManager != null) {
            ApduHandler apduHandler = this.f9738d.getApduHandler();
            if (apduHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_CN.equals("莲叀卦霺厾斬ｇ]]ZZ处瑗嘪乩稾", 306));
                }
                this.f9738d.throwExceptionAndClose(Util4Java.endsWith("莶厂匦霸厺斶？诱兑刋挽匳盁诧閥斧弞,XG\u001c\r\u0010\n5", 4, 115), ErrorMessage.local_business_apdu_handler_null, false);
            }
            if (apduHandler.isConnect()) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_Utils.regionMatches(202, 83, "莭叛匡靱叱斯＀\u001e\u0002A\r奏琘嘹欧忎"));
                }
                this.f9738d.throwExceptionAndClose(CRCUtil.substring(6, "莤又卨靶叨於ｙ\u0001\u001b\u0012T夈琑噪歮忁"), ErrorMessage.local_business_apdu_handler_busying, false);
            } else if (!apduHandler.connect()) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_CN.equals("華原医霩叫旻２近接匰女赶", 5));
                }
                this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(5, 51, "菢叞区靬厶斢＋辄推匡奢责"), ErrorMessage.local_message_apdu_execute_exception, true);
            }
            cardManager.setApduHandler(apduHandler);
            try {
                str = cardManager.getFaceID();
            } catch (BusinessException e) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, Util4Java.endsWith("获厚匹霦叧旪凲珤彂年", 3, 108));
                }
                this.f9738d.throwExceptionAndClose(FM_CN.equals("華原医霩叫旻凤玿异幩", 5), ErrorMessage.local_message_apdu_execute_exception, true);
            } finally {
                apduHandler.close();
            }
        } else if (this.f9736b != null) {
            this.f9736b.warn(this.f9737c, CRCUtil.substring(224, "菺厎卢靬叮旲＃莭厓捗寁匧簪埗皃外琛噠夢贻"));
        }
        return str;
    }

    public String getInvoiceToken(byte[] bArr) throws BusinessException {
        String str = null;
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_CN.equals("菮厜诹匙双祦颙叆凬讓mzk", SportType.SPORT_TYPE_SWIM));
        }
        String insert = FM_Exception.insert(2, 44, "莱叄诼卟叇礪颈双冫诓");
        if (bArr == null || bArr.length < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, BCCUtil.getChars("菣历诮匝厕礨飚厎冹讑｀佨儡盄设卍缂叧丶穲", 4, ReportInfoUtils.FEEDBACK_FAILED));
            }
            throw new BusinessException(FM_Long.copyValueOf("获友许卂叅祹颈叝凥评．使儹盝说匆罆厺买稽", 280), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_CN.equals("菢厐诵匝又祢额叚冰讏ｓ乊勠外琅寭豤乬稽", 2));
            }
            throw new BusinessException(Util4Java.endsWith("菤厎访南取礤飗叀凶证ｉ乐劮夐瑟嘶剞姃匛奣赲", 118, 101), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(2, 85, "菥厑设匄厗祳飖厓凷讎ｈ涑怡奇琞嘥乸穭"));
                }
                throw new BusinessException(FM_Bytes.concat("莺厏诧匄双祡颓受冠讘ｉ涙恲复瑓嘩乷穣", 150, 108), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.GET_INVOICE_VER2);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(FM_Int.replace(272, "旳＄莼变夕琒皓幩叭失账")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(FM_Utils.regionMatches(368, 69, "斶）菽叙奐琟盚帰司奼贷")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            byte[] toBytes;
            this.f9738d.businessReady(insert, server4Business);
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.GET_INVOICE_VER2);
            try {
                ITag createTag = messageHandler.createTag((byte) TagName.MAIN_ORDER_ID);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
                toBytes = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(Util4Java.endsWith("菩反诺區厃祧飊叟冫诂ｌ枙遺幤厤详氌敻挦凿珲彝帤ｃ", 1, 61)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_Long.copyValueOf("莧叛讨卒叕祩题反凵诔＞枋逬幺叶说求攭挴冭珤当并", SyslogAppender.LOG_LOCAL5), ErrorMessage.local_message_message_handle_exception, false);
                toBytes = null;
            }
            Object interaction = this.f9738d.interaction(toBytes, insert, false, server4Business);
            if (interaction == null || interaction.length < 2) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Exception.insert(174, 37, "莥厁课協厗礣颖參冷讞（纁窡掶攮剭既敏盈帢另哖廔敵捤"));
                }
                this.f9738d.throwExceptionAndClose(FM_Long.copyValueOf("莼叞讧南厎礴食厀冾讑ａ纂窨握敷剮斻攐监帡县咁廝收挭", 3), ErrorMessage.local_message_command_data_invaild, false);
            }
            Object obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(BCCUtil.getChars("菹压诮匎叛祱颎叁冫讔h帠史夕理夾贻w", 94, 15)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_Int.replace(NFCBaseActivity.TO_ADD, "菤厀读匉厎礪飃厞冦讏｝帧厧奞瑛失账"), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
            }
            try {
                ITag tag4Id = messageHandler.createMessage(TradeCode.GET_INVOICE_VER2, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(66);
                if (tag4Id != null) {
                    str = FM_Bytes.bytesToHexString(tag4Id.getBytesVal());
                }
            } catch (FMCommunicationMessageException e2) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(FM_CN.equals("菲叀讥卍变礲飍厊冠诟＃解极幱厣咉廁收捹弊帡０", 82)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_Int.replace(2, "菠厌诿单叒祮颏叚凢诓９绐竴掻攷刴旧敂皉幣口哛庍敬捱"), ErrorMessage.local_message_command_data_invaild, false);
            }
            this.f9738d.businessFinish(false);
            return str;
        }
    }

    public List<InvoiceToken> getInvoiceTokenVer3() throws BusinessException {
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, BCCUtil.getChars("菱厜诬匇厇礲飘叔凫诋雈吚840", 118, 4));
        }
        String endsWith = Util4Java.endsWith("菨受计卐取祡颍叛凢诐雕吝", 2, 2);
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, BCCUtil.getChars("菦叓读単厐礽颏压凼讄隟吅ｍ丏勨奙琗宼豸乷穻", 1, 52));
            }
            throw new BusinessException(FM_Utils.regionMatches(4, 84, "菣厞设包厕祰飊厖凹讉雚吘ｈ丂劭奄琒噠剁姛匒奩贩"), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Bytes.concat("菦受讳匔叀礩飗受冼诀雗呉＝淉怾夅瑗噩丫稻", 346, 48));
            }
            throw new BusinessException(FM_Utils.regionMatches(246, 16, "菱厀认千受祾飀厀冫讗雀吞＊涞怩奒瑀嘾丼穬"), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.GET_INVOICE_VER2);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(3, 56, "斥＇菴反套琍盇帨口奺账")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(FM_Bytes.concat("旭ｉ莸叏奇琋皓帲叻夤赺", SdkConstants.REQUEST_CAMERA_VIDEO, 42)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(endsWith, server4Business);
        byte[] bArr = null;
        try {
            bArr = messageHandler.createMessage((int) TradeCode.GET_INVOICE_VER3).toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(5, TransportMediator.KEYCODE_MEDIA_PLAY, "斣｟｝柋遭常厹记氇攳振冥班彙幡ｍ")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(endsWith)).append(CRCUtil.substring(146, "早＆枑遠常厦讶氎攧捬凷玨弁帶")).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        Object interaction = this.f9738d.interaction(bArr, endsWith, false, server4Business);
        if (interaction == null || interaction.length < 2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(BCCUtil.getChars("斢｟绚竾揵敹刾旭攄盏幹叹咅廓敶捫", 4, 95)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(endsWith)).append(FM_Int.replace(1, "斠ｕ纔窰控攳券旫敆皕幧叧哗庉数捭")).toString(), ErrorMessage.local_message_command_data_invaild, false);
        }
        Object obj = new byte[2];
        System.arraycopy(interaction, 0, obj, 0, obj.length);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(4, 65, "斢９帥叧奜琟奫贾f")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(SyslogAppender.LOG_LOCAL7, 106, "旾＞帯厶奔琜夵贫")).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
        }
        List<InvoiceToken> arrayList = new ArrayList();
        try {
            ITag tag4Id = messageHandler.createMessage(TradeCode.GET_INVOICE_VER3, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(-98);
            if (tag4Id != null) {
                ITag[] itemTags = tag4Id.getItemTags();
                if (itemTags != null && itemTags.length >= 1) {
                    for (ITag fromTag : itemTags) {
                        arrayList.add(InvoiceToken.fromTag(fromTag));
                    }
                    this.f9738d.businessFinish(false);
                } else if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Bytes.concat("旣ｗ帲号咀庇攩捱泤朂協吼桚笽RvQ\u0006!\u0013l45匬帶叻泰朞飛叕厘祧侴恴寸谦讽弆", 190, 70)).toString());
                }
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Bytes.concat("斯｀帬叢哈庌攻挰泰服匒吡栚笮\u0018oLA#匱带厸泺朇颇参厖礲侬息寪豧雟呄误弇", 226, 19)).toString());
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(CRCUtil.substring(5, "莥友讪卆叏礡飒厉冧讔，觨枆干叼哚廖攽挶彁并ｃ")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(352, 102, "菧叀设南厙礦颒双凭讇｀绚竷揻敲剺旰敞盘帱厸哃庀攪挮"), ErrorMessage.local_message_command_data_invaild, false);
        }
        return arrayList;
    }

    public String getMOC(EnumCardAppType enumCardAppType) throws BusinessException {
        String str = null;
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_CN.equals("菰収亭退卪伓康邶诫讁砐,=*", 212));
        }
        CardManager cardManager = CardManagerFactory.instance().getCardManager(enumCardAppType);
        if (cardManager != null) {
            ApduHandler apduHandler = this.f9738d.getApduHandler();
            if (apduHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_Int.replace(274, "莰叜佂廪郻讲诘砝早．DXO[夕琒噿丠穧"));
                }
                this.f9738d.throwExceptionAndClose(Util4Java.endsWith("莶厀伄庺邽诮诞砕旿２诤兀剚挰匦盘诮閨斢弟-UBEv\u0000\u0005\u001bd", 4, 117), ErrorMessage.local_business_apdu_handler_null, false);
            }
            if (apduHandler.isConnect()) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_Exception.insert(254, 107, "莵厛众庹郦讽诅硎斬ｉQKB\u0004奘瑁噺歾忑"));
                }
                this.f9738d.throwExceptionAndClose(FM_CN.equals("菡厑众庳郲讯话砌斨ｃ\u0001\u0001\u0006F夀琓噮欴徑", 3), ErrorMessage.local_business_apdu_handler_busying, false);
            } else if (!apduHandler.connect()) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_Exception.insert(NFCBaseActivity.TO_ADD, 121, "菵厍伛康邮讻诙砐旼／迂掰卯夶败"));
                }
                this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(5, 115, "菢厞伔庴邩记识砛旻，辍揣匸好贺"), ErrorMessage.local_message_apdu_execute_exception, true);
            }
            cardManager.setApduHandler(apduHandler);
            try {
                str = cardManager.getMOC();
            } catch (BusinessException e) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_CN.equals("華原伕庱郴让诟砎时斧冸珣彆席", 5));
                }
                this.f9738d.throwExceptionAndClose(BCCUtil.getChars("菤叁伔廥郫诣诊硎日冭玫彝帻", 3, 68), ErrorMessage.local_message_apdu_execute_exception, true);
            } finally {
                apduHandler.close();
            }
        } else if (this.f9736b != null) {
            this.f9736b.warn(this.f9737c, FM_Int.replace(2, "菠厌仹通卢佉廳郤讫诓研旮７莩受挃宝卫籶垛皗夒琟噴央赧"));
        }
        return str;
    }

    public List<Notice> getNotices(int i) throws BusinessException {
        String equals = FM_CN.equals("菢厐帤厸逃矯", 2);
        if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(276, 27, "莳叉幩厥遊矮旰ｍ乆勶外琋宱谢乤穣"));
            }
            throw new BusinessException(FM_Utils.regionMatches(1, 109, "菦厈常叨速矷斩｀乃勧夗理噥則妌卂奰贫"), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Bytes.concat("莢叄帼厼逓矣斵ｌ涕怵奓琒噹乴稱", 190, 93));
            }
            throw new BusinessException(FM_CN.equals("菢厐帤厸逃矯旭＀淕怡奛瑖嘩丨穹", 2), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_NOTICE);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("斮ｅ菭厝夘琋皚幼台奠赧", 5)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith("斳＋菾叝奉琉盕幠厥夦赼", 104, 66)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(equals, server4Business);
        byte[] bArr = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.QUERY_NOTICE);
        try {
            ITag createTag = messageHandler.createTag((byte) TagName.NOTICE_ID);
            createTag.addValue(FM_Bytes.intToBytes(i, 8));
            createMessage.addTag(createTag);
            bArr = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Bytes.concat("菭叛帳口遜瞼旺ｓ枖遥師叻让汓攴挹凰班弒幻ｌ", 3, 51)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Bytes.concat("菬厓帼叩這矨斡ｍ柏逵幬叹认氟攷捿凡玵彍幡", 4, 106), ErrorMessage.local_message_message_handle_exception, false);
        }
        Object interaction = this.f9738d.interaction(bArr, equals, false, server4Business);
        if (interaction == null || interaction.length < 2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_CN.equals("菠厞帪厺送矩旫＂纗窿揤敤剳旴敍皒年厨咄廎攻捲", 4));
            }
            this.f9738d.throwExceptionAndClose(FM_Exception.insert(218, 82, "菩叆幱厤逜瞽於０纆窯掷敲刦旨攒皈席厠哏廀收捶"), ErrorMessage.local_message_command_data_invaild, false);
        }
        Object obj = new byte[2];
        System.arraycopy(interaction, 0, obj, 0, obj.length);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Int.replace(4, "菮厊帬史速短'幽叡夐琑夫贸:")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Long.copyValueOf("菣厇帽去遒瞠ｎ幬召夝琐夢贵", 332), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
        }
        List<Notice> arrayList = new ArrayList();
        ITag tag4Id = messageHandler.createMessage(TradeCode.QUERY_NOTICE, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(-109);
        if (tag4Id != null) {
            ITag[] itemTags = tag4Id.getItemTags();
            if (itemTags != null) {
                for (ITag tag4Id2 : itemTags) {
                    if (tag4Id2 != null) {
                        Notice notice = new Notice();
                        ITag[] itemTags2;
                        int length;
                        int i2;
                        ITag iTag;
                        if (tag4Id2.getId() == TagName.TEXT_NOTICE) {
                            itemTags2 = tag4Id2.getItemTags();
                            notice.setType(Notice.NOTICE_TXT);
                            length = itemTags2.length;
                            i2 = 0;
                            while (i2 < length) {
                                try {
                                    iTag = itemTags2[i2];
                                    switch (iTag.getId()) {
                                        case (byte) 49:
                                            notice.setNo(FM_Bytes.bytesToInt(iTag.getBytesVal()));
                                            break;
                                        case (byte) 50:
                                            notice.setTitle(iTag.getStringVal());
                                            break;
                                        case (byte) 52:
                                            notice.setContent(iTag.getStringVal());
                                            break;
                                        case (byte) 54:
                                            notice.setStartDate(iTag.getStringVal());
                                            break;
                                        case (byte) 55:
                                            notice.setEndDate(iTag.getStringVal());
                                            break;
                                        default:
                                            break;
                                    }
                                    i2++;
                                } catch (FMCommunicationMessageException e2) {
                                    if (this.f9736b != null) {
                                        this.f9736b.warn(this.f9737c, new StringBuilder(FM_Exception.insert(3, 36, "莰叝帼厣逍矾斩／觤柛帼口哚廏支捭彅平５")).append(FM_Bytes.bytesToHexString(interaction)).toString());
                                    }
                                    this.f9738d.throwExceptionAndClose(FM_CN.equals("菢厐帤厸逃矯旭＀纕窡揺敦剱旲敋皐并厦咊廌改捴", 2), ErrorMessage.local_message_command_data_invaild, false);
                                }
                            }
                        } else if (tag4Id2.getId() == TagName.UNSOLVED_NOTICES) {
                            itemTags2 = tag4Id2.getItemTags();
                            notice.setType(Notice.NOTICE_UNSOLVED);
                            for (ITag iTag2 : itemTags2) {
                                if (iTag2 != null) {
                                    switch (iTag2.getId()) {
                                        case (byte) 17:
                                            notice.setOrder(iTag2.getBytesVal());
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                        }
                        arrayList.add(notice);
                    }
                }
            }
        }
        this.f9738d.businessFinish(false);
        return arrayList;
    }

    public String getTime4Validity(EnumCardAppType enumCardAppType) throws BusinessException {
        String str = null;
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Long.copyValueOf("莻叟卧皇有攕杅yz", 4));
        }
        CardManager cardManager = CardManagerFactory.instance().getCardManager(enumCardAppType);
        if (cardManager != null) {
            ApduHandler apduHandler = this.f9738d.getApduHandler();
            if (apduHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_Long.copyValueOf("莻叟卧三应畵杓攟杋斧ｂ\n\u0018\u0001\u0017奛瑚嘱乬稩", 4));
                }
                this.f9738d.throwExceptionAndClose(FM_CN.equals("菡厑匹乃庎産朕故杁方ｌ讦儊刔捦却皂诨閦无彅3CPOp\u001e\u0007\u0011j", 3), ErrorMessage.local_business_apdu_handler_null, false);
            }
            if (apduHandler.isConnect()) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_Int.replace(2, "菠厌匼上店甮最敄朐旤９YKZT夀琁噢歮忉"));
                }
                this.f9738d.throwExceptionAndClose(FM_Int.replace(276, "莾叚卮丘庁田朒敖朞旲＋K]TF夒琟噴歼徛"), ErrorMessage.local_business_apdu_handler_busying, false);
            } else if (!apduHandler.connect()) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_Exception.insert(6, 54, "莽厖匷丆廖田杇敌朅斦＊辂掷匩奯贱"));
                }
                this.f9738d.throwExceptionAndClose(FM_Exception.insert(5, 49, "莾双匪世廙當朆攈朎斴｟迚揰卧夦赭"), ErrorMessage.local_message_apdu_execute_exception, true);
            }
            cardManager.setApduHandler(apduHandler);
            try {
                str = cardManager.getTime4Validity();
            } catch (BusinessException e) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, FM_CN.equals("菠厞匸乀序甤朔敆杀斦冻珢彁帬", 4));
                }
                this.f9738d.throwExceptionAndClose(FM_Bytes.concat("莢叛匤丗庁略杌敕杊斻凿班彗帵", 318, 88), ErrorMessage.local_message_apdu_execute_exception, true);
            } finally {
                apduHandler.close();
            }
        }
        return str;
    }

    public boolean isLock4Consume(EnumCardAppType enumCardAppType) throws BusinessException {
        boolean z = false;
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Exception.insert(104, 78, "菻双京遌卥淚赹劑股春镙寜犢恃>pb"));
        }
        String equals = FM_CN.equals("菡厑仼道卻圃孄劒肣镎寚狧恃", 3);
        CardManager cardManager = CardManagerFactory.instance().getCardManager(enumCardAppType);
        if (cardManager == null) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Int.replace(3, "斮ｗ佾妃皀卦籱垆旰敛")).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Utils.regionMatches(202, 112, "旬＆语兂剝挨医盎讥闤斣弅r\u0005\u0017\u000b5D\\Is")).toString(), ErrorMessage.local_business_no_card_app_type, z);
        }
        ApduHandler apduHandler = this.f9738d.getApduHandler();
        if (apduHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith("旷ａX\u0015U\b奍琓嘩丷稣", 4, 76)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Utils.regionMatches(FitnessSleepType.HW_FITNESS_SLEEP, 21, "斨｟诿兕刕挥匽盕讹闵斩彊r\u0000IX!\r\u001e\u000e+")).toString(), ErrorMessage.local_business_apdu_handler_null, z);
        }
        if (apduHandler.isConnect()) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Exception.insert(5, 33, "旿＆\n\u001cI[奋瑖噹歱徊")).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(2, "旹６D@_\u0013奕瑚嘯欱径")).toString(), ErrorMessage.local_business_apdu_handler_busying, z);
        } else if (!apduHandler.connect()) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(BCCUtil.getChars("斣＝\fY\u0001T奙琟嘽迏揨卨奴贤", 5, 60)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Utils.regionMatches(4, 90, "斢ｂIR\u0018C夔瑌嘬迀揽匳夽责")).toString(), ErrorMessage.local_message_apdu_execute_exception, true);
        }
        cardManager.setApduHandler(apduHandler);
        try {
            z = cardManager.isLock4Consume();
        } catch (BusinessException e) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Long.copyValueOf("旼函玴弃幦", 2)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("斬凭珤弓并", 3, 61)).toString(), ErrorMessage.local_message_apdu_execute_exception, true);
        } finally {
            apduHandler.close();
        }
        return z;
    }

    public boolean isLock4Load(EnumCardAppType enumCardAppType) throws BusinessException {
        boolean z = false;
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, CRCUtil.substring(3, "莧反亢逋卽坏嬊勂肵镒寄犿怕1$;"));
        }
        String concat = FM_Bytes.concat("菴厏享速卺坙嬟勂胮锈宅狣恊", 108, 22);
        CardManager cardManager = CardManagerFactory.instance().getCardManager(enumCardAppType);
        if (cardManager == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(Util4Java.endsWith("斿ｓ併妉皅卶簶埈方敇", 332, 22)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(Util4Java.endsWith("日ｖ讶儀刈捴匼盀说闼斠式o\u0001X],\u0004\u0017[6", 278, 103)).toString(), ErrorMessage.local_business_no_card_app_type, z);
        }
        ApduHandler apduHandler = this.f9738d.getApduHandler();
        if (apduHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("断ｒ@TC_変琖噻丬穣", 4, 3)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(1, "斠ｕ讫儗刅捧卩皏讱闿断弘2RMB)GJL;")).toString(), ErrorMessage.local_business_apdu_handler_null, z);
        }
        if (apduHandler.isConnect()) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("旺％GSD\b奞瑑嘼欲得", 4)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("斥ｌ\fJCA夅瑈嘳欫忌", 3, 109)).toString(), ErrorMessage.local_business_apdu_handler_busying, z);
        } else if (!apduHandler.connect()) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("旿ｑ辏揠匸奼赤", 274, SpecialIssueType.BUG_TYPE_ID_CHARGE)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("斧ｋ迃揶匨央走", 1, 86)).toString(), ErrorMessage.local_message_apdu_execute_exception, true);
        }
        cardManager.setApduHandler(apduHandler);
        try {
            z = cardManager.isLock4Load();
        } catch (BusinessException e) {
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("斤凪玾彎干", 2, 30)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("旺凳玶弁常", 36)).toString(), ErrorMessage.local_message_apdu_execute_exception, true);
        } finally {
            apduHandler.close();
        }
        return z;
    }

    public boolean isRun4plateform() throws BusinessException {
        String concat = FM_Bytes.concat("粡结呱甸狴恕柣论", 3, 50);
        if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(214, "施ｂ之勵奓瑜室谡乹稼")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(4, "斯ｐ久劣夁琎噣刓姚匂夦贿")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Exception.insert(SyslogAppender.LOG_LOCAL2, 75, "既ｓ涂怺奄琍嘾主稶")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(Util4Java.endsWith("旷／涍恨复琍噥丵穫", 4, 2)).toString(), ErrorMessage.local_message_load_config_fail);
        }
        int orderSource;
        Configration configration = this.f9738d.getConfigration();
        if (configration != null) {
            orderSource = configration.getOrderSource();
            if (orderSource == 0 && this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("斠｟诲匘术滗坬鄌罰斜仮丸朸宕久", 206)).toString());
            }
        } else {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Utils.regionMatches(3, 115, "斥ｊ杳戲刯酟罫斟份")).toString());
            }
            orderSource = 0;
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_VERSION);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("斢｛菭压处琅皂幺叼夾贷", 4, 3)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(34, "旡６莪取备琀皍广叿夣贰")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        byte[] toBytes;
        this.f9738d.businessReady(concat, server4Business);
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.CHECK_SERVER);
        try {
            ITag createTag = messageHandler.createTag((byte) TagName.ORDER_CHANNEL);
            createTag.addValue(orderSource);
            createMessage.addTag(createTag);
            toBytes = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_CN.equals("斮ｅ柞遫幯叽诩汍数挿冸珣彆席＜", 5)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(4, "斯ｐ柛逢并司诼汌敡捺凭玪弟常")).toString(), ErrorMessage.local_message_message_handle_exception, false);
            toBytes = null;
        }
        Object interaction = this.f9738d.interaction(toBytes, concat, false, server4Business);
        Object obj = new byte[2];
        System.arraycopy(interaction, 0, obj, 0, obj.length);
        if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
            this.f9738d.businessFinish(false);
            return true;
        } else if (this.f9736b == null) {
            return false;
        } else {
            this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("无？幣叽夎琁夵贤$", 174)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            return false;
        }
    }

    public LoginInfo login(String str, String str2) throws BusinessException {
        String copyValueOf = FM_Long.copyValueOf("産房百彗", 3);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Int.replace(308, "甡戻癴彇;65"));
        }
        if (str == null || "".equals(str) || str2 == null || "".equals(str2)) {
            throw new BusinessException(FM_Long.copyValueOf("産房百彗斩ｐ佹儳盗厒攽彈广", 3), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(2, 65, "畺戤瘯彀斠；乂劸奞琝宥豼乤穥"));
            }
            throw new BusinessException(FM_CN.equals("異找瘡弞旪！丄劮处瑗嘪剎妏匃夷贲", 5), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Int.replace(2, "畿扭瘦录旵＊涁恣夋琔噽丢穡"));
                }
                throw new BusinessException(FM_Long.copyValueOf("甦戼癳彐旴ｓ淔怶奒瑕嘸乷稰", 6), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(1021);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Utils.regionMatches(2, 108, "斤ｒ菽叀夆琈盞帵厢夯贯")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(Util4Java.endsWith("旹ｃ菸叙夋瑉盋幼叿奾赪", 146, 96)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(copyValueOf, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage(1021);
            try {
                ITag createTag = messageHandler.createTag((byte) 2);
                createTag.addValue(str);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 3);
                createTag.addValue(str2);
                createMessage.addTag(createTag);
                bArr = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(Util4Java.endsWith("用扨癥彈斪ｗ枞逹師厧诡汗攤挽凨玡归幷４", 3, 95)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_CN.equals("異找瘡弞旪！枚逯平厡讵民攴捻凼玧弊幡", 5), ErrorMessage.local_message_message_handle_exception, false);
            }
            Object interaction = this.f9738d.interaction(bArr, BCCUtil.getChars("甤扦癭弎", 284, 69), false, server4Business);
            Object obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            LoginInfo loginInfo = new LoginInfo();
            if (interaction.length != 2) {
                try {
                    IMessage createMessage2 = messageHandler.createMessage(1021, Arrays.copyOfRange(interaction, 2, interaction.length));
                    loginInfo.setResult(Util4Java.String2Int(FM_CN.bcdBytesToString(obj), 1001));
                    ITag tag4Id = createMessage2.getTag4Id(36);
                    if (tag4Id != null) {
                        loginInfo.setFailureNum(tag4Id.getIntVal());
                    }
                    ITag tag4Id2 = createMessage2.getTag4Id(43);
                    if (tag4Id2 != null) {
                        loginInfo.setUserLockTime(tag4Id2.getIntVal());
                    }
                } catch (Exception e2) {
                    if (this.f9736b != null) {
                        this.f9736b.warn(this.f9737c, new StringBuilder(FM_Bytes.concat("畴扸瘹开斾７觭枑幧号咗廙攰挽冼玩弎帧(", 5, 115)).append(Util4Java.getExceptionInfo(e2)).toString());
                    }
                }
            } else if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                this.f9735a = str;
                loginInfo.setResult(0);
            } else {
                loginInfo.setResult(FM_CN.bcdBytesToInt(obj));
            }
            this.f9738d.businessFinish(false);
            return loginInfo;
        }
    }

    public LoginInfo loginVer2(String str, String str2) throws BusinessException {
        String endsWith = Util4Java.endsWith("甪戴癿彐", 5, 1);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Exception.insert(5, 85, "甡扩癨彝ｕDb.#／u>+"));
        }
        if (str == null || "".equals(str) || str2 == null || "".equals(str2)) {
            throw new BusinessException(FM_Long.copyValueOf("異扢瘩弚斺ｅ佦儦盄电戭吚戂耔寈砊串穿", AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_CN.equals("畾扰瘣弜旬＇丆劬奚瑉容谰乸穩", 3));
            }
            throw new BusinessException(FM_Long.copyValueOf("畾扤瘫弘於ｋ乞勠奚瑝嘰剈妙卙好赬", FitnessSleepType.HW_FITNESS_SLEEP), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, BCCUtil.getChars("甤扵癣弛旲６淘恩奘琔嘠乤穮", 316, 54));
                }
                throw new BusinessException(FM_Int.replace(5, "畲扪登彖旰％涄恠外琓噰両穤"), ErrorMessage.local_message_load_config_fail);
            }
            String companyCode;
            Configration configration = this.f9738d.getConfigration();
            if (configration != null) {
                companyCode = configration.getCompanyCode();
            } else {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Exception.insert(2, 46, "甮戣瘹彅旨｀Y'8b;g|=~q)zb乪穤"));
                }
                companyCode = null;
            }
            if (companyCode == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(340, 113, "畬戢白彂旾ｕ畢扬戌屃啈戨个穻"));
                }
                throw new BusinessException(FM_Utils.regionMatches(4, 40, "畼戫瘿弙既０畬戻扔専啂戻乮稦"), ErrorMessage.local_business_para_error);
            }
            String server4Business = this.f9738d.getServer4Business(1022);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Int.replace(110, "斵ｊ菾厚奋瑔监師厫奯贤")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(3, 38, "斥５莨厓夏琗盓帮右奸赪")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(endsWith, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage(1022);
            try {
                ITag createTag = messageHandler.createTag((byte) 2);
                createTag.addValue(str);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 3);
                createTag.addValue(str2);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) TagName.COMPANY_CODE);
                createTag.addValue(companyCode);
                createMessage.addTag(createTag);
                bArr = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(FM_CN.equals("異找瘡弞旪！枚逯平厡讵民攴捻凼玧弊幡ｐ", 5)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(BCCUtil.getChars("畾扰瘣弜旬＇枘逭席县讷氓攲捽凾玥弄幯", 6, 113), ErrorMessage.local_message_message_handle_exception, false);
            }
            Object interaction = this.f9738d.interaction(bArr, Util4Java.endsWith("畧戤癬弎", 242, 36), false, server4Business);
            Object obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            LoginInfo loginInfo = new LoginInfo();
            if (interaction.length != 2) {
                try {
                    IMessage createMessage2 = messageHandler.createMessage(1021, Arrays.copyOfRange(interaction, 2, interaction.length));
                    loginInfo.setResult(Util4Java.String2Int(FM_CN.bcdBytesToString(obj), 1001));
                    ITag tag4Id = createMessage2.getTag4Id(36);
                    if (tag4Id != null) {
                        loginInfo.setFailureNum(tag4Id.getIntVal());
                    }
                    ITag tag4Id2 = createMessage2.getTag4Id(43);
                    if (tag4Id2 != null) {
                        loginInfo.setUserLockTime(tag4Id2.getIntVal());
                    }
                } catch (Exception e2) {
                    if (this.f9736b != null) {
                        this.f9736b.warn(this.f9737c, new StringBuilder(FM_Exception.insert(3, 10, "甯戦癠彐旹５覠柝帤厱咆廁支捧凩玭弅帩!")).append(Util4Java.getExceptionInfo(e2)).toString());
                    }
                }
            } else if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                this.f9735a = str;
                loginInfo.setResult(0);
            } else {
                loginInfo.setResult(FM_CN.bcdBytesToInt(obj));
            }
            this.f9738d.businessFinish(false);
            return loginInfo;
        }
    }

    public LoginInfo loginVer3(String str, String str2, EnumUserPlatformType enumUserPlatformType, String str3) throws BusinessException {
        byte[] toBytes;
        Exception e;
        Object interaction;
        Object obj;
        LoginInfo loginInfo;
        IMessage createMessage;
        String endsWith = Util4Java.endsWith("用扱瘷彇", 3, 102);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Bytes.concat("畳戩発彑ｏ\u001chb`｟72q", 228, 99));
        }
        if (str == null || "".equals(str) || str2 == null || "".equals(str2)) {
            throw new BusinessException(FM_CN.equals("畧扷瘪弗日（伵兣盓畠扮呇戍耉寛砏乥稪", 252), ErrorMessage.local_business_para_error);
        } else if (enumUserPlatformType == null) {
            throw new BusinessException(FM_Exception.insert(3, 41, "甯戧瘢彗旽ｘ佽兣盋異戶戊對幯厵簵垜乺稳"), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, Util4Java.endsWith("畷扻癢弓日，乗劻奃琒寸谯両稲", 2, 77));
            }
            throw new BusinessException(FM_Exception.insert(4, 1, "甠戾癱彞旺！且劮夔琗噺刎姟匃大贲"), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, CRCUtil.substring(6, "画戩癲彁早ｆ淝怯奏瑐噩丶穭"));
                }
                throw new BusinessException(FM_CN.equals("甹戵瘨弑斣ｊ涟恧夝琌嘳乶稧", 286), ErrorMessage.local_message_load_config_fail);
            }
            String str4 = null;
            Configration configration = this.f9738d.getConfigration();
            if (configration != null) {
                str4 = configration.getCompanyCode();
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Long.copyValueOf("田戢癩彚旺％Eln;30&0:\"'+b乥稦", 272));
            }
            if (str4 == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, Util4Java.endsWith("用扼癭弔旺｛番戺战屝唈戮举稵", 3, 75));
                }
                throw new BusinessException(FM_Utils.regionMatches(3, 41, "畻戫瘾弛旡ｌ畡戥扛尚啋戡乥穲"), ErrorMessage.local_business_para_error);
            }
            String server4Business = this.f9738d.getServer4Business(1023);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(242, 76, "斴＂菭厐外瑘皎帥厲夿赿")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(CRCUtil.substring(364, "斯（莸双夁琖皟帵厡奭赢")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            ITag createTag;
            ITag tag4Id;
            this.f9738d.businessReady(endsWith, server4Business);
            IMessage createMessage2 = messageHandler.createMessage(1023);
            try {
                ITag createTag2 = messageHandler.createTag((byte) 2);
                createTag2.addValue(str);
                createMessage2.addTag(createTag2);
                createTag2 = messageHandler.createTag((byte) 3);
                createTag2.addValue(str2);
                createMessage2.addTag(createTag2);
                createTag2 = messageHandler.createTag((byte) TagName.COMPANY_CODE);
                createTag2.addValue(str4);
                createMessage2.addTag(createTag2);
                createTag = messageHandler.createTag((byte) TagName.USER_PLATFORM_TYPE);
                createTag.addValue(enumUserPlatformType.getId());
                createMessage2.addTag(createTag);
                createTag = messageHandler.createTag((byte) TagName.USER_PLATFORM_ID);
                createTag.addValue(str3);
                createMessage2.addTag(createTag);
                toBytes = createMessage2.toBytes();
                try {
                    System.out.println(new StringBuilder(FM_Utils.regionMatches(96, 97, "\"tc&1fbm")).append(FM_Bytes.bytesToHexString(toBytes)).toString());
                } catch (FMCommunicationMessageException e2) {
                    e = e2;
                    if (this.f9736b != null) {
                        this.f9736b.warn(this.f9737c, new StringBuilder(FM_Utils.regionMatches(6, 56, "畾戹瘽彋斠＂柂遾幥厾诱氜敦挠凼玮彔帶｜")).append(Util4Java.getExceptionInfo(e)).toString());
                    }
                    this.f9738d.throwExceptionAndClose(FM_Bytes.concat("畳戹瘺彁斱ｖ枉遠幠厶议汎支捼冿珨弉幦", 4, 51), ErrorMessage.local_message_message_handle_exception, false);
                    interaction = this.f9738d.interaction(toBytes, BCCUtil.getChars("甾扤癫弘", 166, 61), false, server4Business);
                    obj = new byte[2];
                    System.arraycopy(interaction, 0, obj, 0, obj.length);
                    loginInfo = new LoginInfo();
                    if (interaction.length == 2) {
                        try {
                            createMessage = messageHandler.createMessage(1021, Arrays.copyOfRange(interaction, 2, interaction.length));
                            if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                                loginInfo.setResult(0);
                            } else {
                                loginInfo.setResult(Util4Java.String2Int(FM_CN.bcdBytesToString(obj), 1001));
                            }
                            tag4Id = createMessage.getTag4Id(36);
                            if (tag4Id != null) {
                                loginInfo.setFailureNum(tag4Id.getIntVal());
                            }
                            tag4Id = createMessage.getTag4Id(43);
                            if (tag4Id != null) {
                                loginInfo.setUserLockTime(tag4Id.getIntVal());
                            }
                            createTag = createMessage.getTag4Id(-76);
                            if (createTag != null) {
                                loginInfo.setPatchData(createTag.getBytesVal());
                            }
                        } catch (Exception e3) {
                            if (this.f9736b != null) {
                                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Exception.insert(42, 96, "甦戹瘵弛旸＂覭柞幽叾咃廚敾捠冴現弌帶t")).append(Util4Java.getExceptionInfo(e3)).toString());
                            }
                        }
                    } else if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                        this.f9735a = str;
                        loginInfo.setResult(0);
                    } else {
                        loginInfo.setResult(FM_CN.bcdBytesToInt(obj));
                    }
                    this.f9738d.businessFinish(false);
                    return loginInfo;
                }
            } catch (Exception e32) {
                Exception exception = e32;
                toBytes = null;
                e = exception;
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(FM_Utils.regionMatches(6, 56, "畾戹瘽彋斠＂柂遾幥厾诱氜敦挠凼玮彔帶｜")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_Bytes.concat("畳戹瘺彁斱ｖ枉遠幠厶议汎支捼冿珨弉幦", 4, 51), ErrorMessage.local_message_message_handle_exception, false);
                interaction = this.f9738d.interaction(toBytes, BCCUtil.getChars("甾扤癫弘", 166, 61), false, server4Business);
                obj = new byte[2];
                System.arraycopy(interaction, 0, obj, 0, obj.length);
                loginInfo = new LoginInfo();
                if (interaction.length == 2) {
                    createMessage = messageHandler.createMessage(1021, Arrays.copyOfRange(interaction, 2, interaction.length));
                    if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                        loginInfo.setResult(Util4Java.String2Int(FM_CN.bcdBytesToString(obj), 1001));
                    } else {
                        loginInfo.setResult(0);
                    }
                    tag4Id = createMessage.getTag4Id(36);
                    if (tag4Id != null) {
                        loginInfo.setFailureNum(tag4Id.getIntVal());
                    }
                    tag4Id = createMessage.getTag4Id(43);
                    if (tag4Id != null) {
                        loginInfo.setUserLockTime(tag4Id.getIntVal());
                    }
                    createTag = createMessage.getTag4Id(-76);
                    if (createTag != null) {
                        loginInfo.setPatchData(createTag.getBytesVal());
                    }
                } else if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                    loginInfo.setResult(FM_CN.bcdBytesToInt(obj));
                } else {
                    this.f9735a = str;
                    loginInfo.setResult(0);
                }
                this.f9738d.businessFinish(false);
                return loginInfo;
            }
            interaction = this.f9738d.interaction(toBytes, BCCUtil.getChars("甾扤癫弘", 166, 61), false, server4Business);
            obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            loginInfo = new LoginInfo();
            if (interaction.length == 2) {
                createMessage = messageHandler.createMessage(1021, Arrays.copyOfRange(interaction, 2, interaction.length));
                if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                    loginInfo.setResult(0);
                } else {
                    loginInfo.setResult(Util4Java.String2Int(FM_CN.bcdBytesToString(obj), 1001));
                }
                tag4Id = createMessage.getTag4Id(36);
                if (tag4Id != null) {
                    loginInfo.setFailureNum(tag4Id.getIntVal());
                }
                tag4Id = createMessage.getTag4Id(43);
                if (tag4Id != null) {
                    loginInfo.setUserLockTime(tag4Id.getIntVal());
                }
                createTag = createMessage.getTag4Id(-76);
                if (createTag != null) {
                    loginInfo.setPatchData(createTag.getBytesVal());
                }
            } else if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                this.f9735a = str;
                loginInfo.setResult(0);
            } else {
                loginInfo.setResult(FM_CN.bcdBytesToInt(obj));
            }
            this.f9738d.businessFinish(false);
            return loginInfo;
        }
    }

    public int logout() throws BusinessException {
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Long.copyValueOf("畢扰瘿冻puv", 98));
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, CRCUtil.substring(SyslogAppender.LOG_LOCAL3, "甭戧逛冼斧ｐ九勳奙琎寪豿丳穮"));
            }
            throw new BusinessException(FM_Int.replace(4, "畱扫遟凸旳＄丑劯夕琒噿切姖化夲责"), ErrorMessage.local_business_init_fail);
        }
        if (this.f9738d.getApduHandler() != null) {
            this.f9738d.getApduHandler().close();
        }
        String server4Business = this.f9738d.getServer4Business(1022);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, CRCUtil.substring(4, "甹戫逇凨旫ｄ菤厈帺厤侾恥夤败"));
            }
            throw new BusinessException(Util4Java.endsWith("甩戠遍凹斯＃菲厍幢厷俼怼夸贺", 4, 54), ErrorMessage.local_app_query_server_fail);
        } else if (this.f9738d.m13060b(server4Business)) {
            return 0;
        } else {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Exception.insert(3, 95, "甯扱遅凾旵奆瑇失赺"));
            }
            this.f9738d.disconnect(server4Business);
            return -1;
        }
    }

    public int modifyPassword(String str, String str2) throws BusinessException {
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Long.copyValueOf("産房寃砃侱敥wx}", 3));
        }
        String insert = FM_Exception.insert(232, 35, "畤戸寔硔侶攢");
        if (str == null || str.length() < 1 || str2 == null || str2.length() < 1) {
            throw new BusinessException(FM_Exception.insert(5, 115, "甡扫安硃侻敱旭＂伡共皃厘攽彂幫"), ErrorMessage.local_business_para_error);
        } else if (str.length() > 32) {
            throw new BusinessException(Util4Java.endsWith("甩扵宅砅俫敿斱＄旮完硊镳庫律頴尟亟aa", 4, 97), ErrorMessage.local_business_para_error);
        } else if (str2.length() > 32) {
            throw new BusinessException(FM_Utils.regionMatches(TransportMediator.KEYCODE_MEDIA_PLAY, 80, "畦戩寈硟俠敧斸２旾寘砏锡庨徛頵少什-<"), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Int.replace(4, "畱扫宙砃俫攱旽＂下劵夓琜寤象丹穼"));
            }
            throw new BusinessException(CRCUtil.substring(4, "甹戫寁砓俳敱斥ｒ乓勵奛琌噽初姀匀奰赩"), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Exception.insert(2, 66, "甮承富硍俠敩旤ｘ涞怷夞瑚噶乺穸"));
                }
                throw new BusinessException(CRCUtil.substring(SportType.SPORT_TYPE_SWIM, "画戩寏砕俱敳斣ｌ淃怹夅琊噿丸穷"), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(1031);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(FM_Exception.insert(2, 3, "旰％莻叙外琓皜幨叮夰贡")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(Util4Java.endsWith("旴５莧厑奚瑓皈幰只奠赭", 5, 23)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(insert, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage(1031);
            try {
                ITag createTag = messageHandler.createTag((byte) 2);
                createTag.addValue(this.f9735a);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 9);
                ITag createTag2 = messageHandler.createTag((byte) 3);
                createTag2.addValue(str);
                createTag.addValue(createTag2);
                ITag createTag3 = messageHandler.createTag((byte) 3);
                createTag3.addValue(str2);
                createTag.addValue(createTag3);
                createMessage.addTag(createTag);
                bArr = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(FM_CN.equals("畾扰实硈俴攲旪！柚遯帳厡讵汑整捻凼珧彊幡ｐ", 3)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(CRCUtil.substring(3, "甸戬寀砐俲敾斤ｑ柌遳席叹诣汝敺捻冺珻彔幹"), ErrorMessage.local_message_message_handle_exception, false);
            }
            Object interaction = this.f9738d.interaction(bArr, FM_Long.copyValueOf("畠扲宄砞俲攠", 64), false, server4Business);
            Object obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            this.f9738d.businessFinish(false);
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                return 0;
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Long.copyValueOf("產戰寂砀侰敢t带厢奋瑊奸赣ｏz", 2)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            return FM_CN.bcdBytesToInt(obj);
        }
    }

    public int modifyUserInfo(UserInfo userInfo) throws BusinessException {
        String insert = FM_Exception.insert(5, 56, "甡扶侸恾侧攸");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Exception.insert(3, 80, "甯扠俦怸侩攮i9)"));
        }
        if (userInfo == null) {
            throw new BusinessException(BCCUtil.getChars("畻扭侠恧信敯斫ｈ伫具盝厂攷弌席", 3, 103), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Long.copyValueOf("甤戾俧恬修敤斬｛乎勰奊瑍宱谤乸稥", 4));
            }
            throw new BusinessException(FM_Long.copyValueOf("甤戾俧恬修敤斬｛乎勰奊瑍嘠剘妉卉奭赼", 4), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Long.copyValueOf("甥戽俦恫俯敧断ｔ淝怽奋瑊嘡乼稹", 5));
                }
                throw new BusinessException(FM_Bytes.concat("畡戧侶恱侫攵斥６涉性夋瑐噵乾穱", 210, 71), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(1011);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(CRCUtil.substring(240, "斫＄莤又复琒皛帹厥奱赮")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(FM_CN.equals("斢ｉ菡厑夜琏皞幸厬奼赻", 1)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(insert, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage(1011);
            try {
                ITag createTag = messageHandler.createTag((byte) 1);
                createTag.addValue((byte) userInfo.getUserType());
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 2);
                createTag.addValue(userInfo.getUserName());
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 3);
                createTag.addValue(userInfo.getPassword());
                createMessage.addTag(createTag);
                if (userInfo.getMail() != null && userInfo.getMail().length() > 1) {
                    createTag = messageHandler.createTag((byte) 4);
                    createTag.addValue(userInfo.getMail());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getPhone() != null && userInfo.getPhone().length() > 1) {
                    createTag = messageHandler.createTag((byte) 5);
                    createTag.addValue(userInfo.getPhone());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getRealName() != null && userInfo.getRealName().length() > 1) {
                    createTag = messageHandler.createTag((byte) 6);
                    createTag.addValue(userInfo.getRealName());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getCertType() != -1) {
                    createTag = messageHandler.createTag((byte) 7);
                    createTag.addValue(userInfo.getCertType());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getCertNo() != null && userInfo.getCertNo().length() > 1) {
                    ITag createTag2 = messageHandler.createTag((byte) 8);
                    createTag2.addValue(userInfo.getCertNo());
                    createMessage.addTag(createTag2);
                }
                bArr = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(FM_CN.equals("異找侻怤俲攴旨＃构遱帱厣讳汗敶捹凲珩彈幣ｖ", 5)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(BCCUtil.getChars("畻扤俲恼侽敪日？柗遳幠口认民散捽冩珣弑師", 3, 96), ErrorMessage.local_message_message_handle_exception, false);
            }
            Object interaction = this.f9738d.interaction(bArr, insert, false, server4Business);
            Object obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                return 0;
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_CN.equals("畽扱侶性俷攳!", 2)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            return FM_CN.bcdBytesToInt(obj);
        }
    }

    public int modifyUserInfoVer2(UserInfo userInfo) throws BusinessException {
        String copyValueOf = FM_Long.copyValueOf("甥戽俦恫俯敧", 5);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, BCCUtil.getChars("畹扨俬恴俧攮k}o", 1, 14));
        }
        if (userInfo == null) {
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(2, 114, "旰ｔ佪儹益厂敢弆帮")).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(314, 65, "旨ｓ乚加奆琅宽豤乼穽")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(204, 125, "斦ａ乐勦奀瑇噶分姓匃夣贪")).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Utils.regionMatches(SyslogAppender.LOG_LOCAL2, 84, "时ｘ涀怳奔琂嘰乶空")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(3, 105, "旱｜淑怭夏琒嘵乼稵")).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(1011);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(FM_CN.equals("斱ｔ菾双夏琚皉席县奱赴", 244)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(Util4Java.endsWith("时＋菹厃夘瑅盎幢叨奮责", 3, 39)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(copyValueOf, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage(1012);
            try {
                ITag createTag = messageHandler.createTag((byte) 1);
                createTag.addValue((byte) userInfo.getUserType());
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 2);
                createTag.addValue(userInfo.getUserName());
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 3);
                createTag.addValue(userInfo.getPassword());
                createMessage.addTag(createTag);
                if (userInfo.getMail() != null && userInfo.getMail().length() > 1) {
                    createTag = messageHandler.createTag((byte) 4);
                    createTag.addValue(userInfo.getMail());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getPhone() != null && userInfo.getPhone().length() > 1) {
                    createTag = messageHandler.createTag((byte) 5);
                    createTag.addValue(userInfo.getPhone());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getRealName() != null && userInfo.getRealName().length() > 1) {
                    createTag = messageHandler.createTag((byte) 6);
                    createTag.addValue(userInfo.getRealName());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getCertType() != -1) {
                    createTag = messageHandler.createTag((byte) 7);
                    createTag.addValue(userInfo.getCertType());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getCertNo() != null && userInfo.getCertNo().length() > 1) {
                    ITag createTag2 = messageHandler.createTag((byte) 8);
                    createTag2.addValue(userInfo.getCertNo());
                    createMessage.addTag(createTag2);
                }
                bArr = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(CRCUtil.substring(2, "旹６极逰幨厶讦氞攷挼冧玸弑带３")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Long.copyValueOf("斴３枘逹幥口诧汏敺捩凾玱弜帣", 58)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            Object interaction = this.f9738d.interaction(bArr, copyValueOf, false, server4Business);
            Object obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                return 0;
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(":").append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            return FM_CN.bcdBytesToInt(obj);
        }
    }

    public List<Activity> queryActivities(EnumCardAppType enumCardAppType) throws BusinessException {
        String substring = CRCUtil.substring(5, "洩劵俩恼査讫");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, Util4Java.endsWith("洺劥俸恪柴诿g{o", 4, 12));
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(BCCUtil.getChars("ｘ且勩夆瑚寯谱丰稾", 4, 58)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("－上劾夊琛嘤剆妁协夹贲", 4, 15)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(BCCUtil.getChars("～淍恷奏琘噹乾穭", SportType.SPORT_TYPE_RUN, 83)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(2, 50, "～涌怹夌琜嘤两稪")).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (enumCardAppType == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("．没杗佼儿匹乜廀畺盔簵埇", 5, TransportMediator.KEYCODE_MEDIA_PLAY)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(FM_Long.copyValueOf("２沺朑伵具卮丆庝甮皇类垖", 182)).toString(), ErrorMessage.local_message_load_config_fail);
        } else {
            String str = null;
            Configration configration = this.f9738d.getConfigration();
            if (configration != null) {
                str = configration.getCompanyCode();
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("－\u0000j)o\"j=p'|8w{丧稥", 4, 66)).toString());
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_ACTIVITIES);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(192, 25, "旦ｅ菵厍夐琋盂帬厨夠贯")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("斮８莧厚奌琂的幯厨奥贵", 1, 28)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(substring, server4Business);
            List<Activity> a = m13042a(enumCardAppType, str, messageHandler, server4Business);
            this.f9738d.businessFinish(false);
            return a;
        }
    }

    public BusinessOrder queryBusinessOrder(byte[] bArr) throws BusinessException {
        String replace = FM_Int.replace(3, "乂勺诼協询绁柯误旦");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, new StringBuilder(CRCUtil.substring(3, "上劺认卄G")).append(FM_Bytes.bytesToHexString(bArr)).append(BCCUtil.getChars("\u000e诨经侥怰枿请>eh", 3, 27)).toString());
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, Util4Java.endsWith("丘勽讴卅讬纂査论斤＀东勡夞琒宷谩丸稦", 5, 90));
            }
            throw new BusinessException(FM_CN.equals("乂勨诸匞诺绋査语时｝乘勲奀琓噮刊姃协奻赾", 5), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Int.replace(4, "乃勽诽南诣绎柮诬旧８涟恵夙理噫丼穳"));
            }
            throw new BusinessException(BCCUtil.getChars("乏勿讥卅柼诠旽８涕怩奋瑞嘩买稩", 5, 9), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_ORDER_VER2);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Int.replace(2, "斡ｖ菪取备琀皍广叿夣贰")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Exception.insert(298, 4, "旸＞莡双多瑄盂帹厾奣赳")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(replace, server4Business);
        BusinessOrder b = m13051b(bArr, messageHandler, server4Business);
        this.f9738d.businessFinish(false);
        return b;
    }

    public List<BusinessOrder> queryBusinessOrders(int i, int i2, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, EnumOrderStatus enumOrderStatus) throws BusinessException {
        String regionMatches = FM_Utils.regionMatches(4, 6, "乎勻订卓柩诰");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_CN.equals("乍勩读匟柾诮3 q", 4));
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Int.replace(270, "丙劧讫卙柪诰９丂劺多琇寽豦丰穷"));
            }
            throw new BusinessException(Util4Java.endsWith("丘勮设匜柳诡｜万勫夓琂嘹刃妀匎头起", 5, 77), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Exception.insert(6, 59, "丐勤订华枳诳｀涏怭夙瑞噻乴穳"));
            }
            throw new BusinessException(FM_Int.replace(2, "乍勻诿单柦诤％涄恠外琓噰両穤"), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(1132);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_Long.copyValueOf("旬；莣叇夊琍皌并史央费", 178)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(BCCUtil.getChars("旺）莩厁奔琏皆幨厤奼责", BusinessCode.CURRENCY_CODE_RMB, 25)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(regionMatches, server4Business);
        List<BusinessOrder> a = m13044a(enumOrderStatus, i + i2, enumCardAppType, enumBusinessOrderType, messageHandler, server4Business);
        this.f9738d.businessFinish(false);
        return a;
    }

    public List<BusinessOrder> queryBusinessOrdersVer3(int i, int i2, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, EnumOrderStatus enumOrderStatus, byte[] bArr) throws BusinessException {
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_CN.equals("丗勿语匕枴讠;Rptdawd5", 282));
        }
        String substring = CRCUtil.substring(164, "下劽该匇枸讪");
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Int.replace(1, "乌勸课匊柧诧＄丑劯夕琒寮豻丧空"));
            }
            throw new BusinessException(FM_Int.replace(3, "乂勺诼協柡该＆丗励夗琐噱刁委匔头购"), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Bytes.concat("丁勶讱匚柮讥／涗怴夓瑕噧乱穽", 292, 60));
            }
            throw new BusinessException(BCCUtil.getChars("乆勩讶匕柩论ｈ涘怳夌瑒嘨丶稢", 140, 76), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(1133);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Long.copyValueOf("斬｛菣厇奊瑍盌帶厲奮赹", 242)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(FM_Exception.insert(1, 20, "旳５莺厗契瑏盙幢叵夨赨")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(substring, server4Business);
        List<BusinessOrder> a = m13045a(enumOrderStatus, i + i2, enumCardAppType, enumBusinessOrderType, messageHandler, bArr, server4Business);
        this.f9738d.businessFinish(false);
        return a;
    }

    public List<BusinessOrder> queryBusinessOrdersVer4(int i, int i2, EnumCardAppType enumCardAppType, EnumBusinessOrderType enumBusinessOrderType, List<EnumOrderStatus> list, byte[] bArr) throws BusinessException {
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Bytes.concat("乀劤讲华柣诳4\u00117/|zp':", 3, 11));
        }
        String replace = FM_Int.replace(4, "乃勽诽南柠诪");
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, CRCUtil.substring(92, "乓勵诽卟柰询＇丌勠奈瑑宻谬乢穹"));
            }
            throw new BusinessException(Util4Java.endsWith("丛勿讹卍枰记＃世勨奂琅器剀姑匁奥赴", 4, 93), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, Util4Java.endsWith("业劬诸卒柱讣＂涓性夑瑄嘧並稳", 3, 45));
            }
            throw new BusinessException(FM_Int.replace(SportType.SPORT_TYPE_SWIM, "乁勿讣卑柢诨！涘恼夒琟噴严穸"), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(1134);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(CRCUtil.substring(4, "旧０莰叄夙瑎盗席厹奥赺")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Int.replace(2, "斡ｖ菪取备琀皍广叿夣贰")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(replace, server4Business);
        List<BusinessOrder> a = m13048a((List) list, i + i2, enumCardAppType, enumBusinessOrderType, messageHandler, bArr, server4Business);
        this.f9738d.businessFinish(false);
        return a;
    }

    public CardBusinessStatus queryCardBusinessStatus(String str) throws BusinessException {
        String substring = CRCUtil.substring(4, "莦及卦丘庉畠盗狨恈");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Long.copyValueOf("莺叜卦与底當盟狮恔|ab", 5));
        }
        if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(BCCUtil.getChars("～乘勳奆琔寻豳丸稨", 2, 112)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("ｓ乏努夅瑑噥刞妒匙头赾", 2, 86)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(BCCUtil.getChars("ｘ涆恧奆瑚嘾个穰", 4, 26)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("．涏恣夕琐噳为穿", 5, 5)).toString(), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_BUSINESS_ORDER_STATUS);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("斥－莸压夏琟盃幦厳奠贺", 348, 46)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(FM_Exception.insert(3, 99, "旱ｆ菺叆夗瑐盝幯可夳赠")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(substring, server4Business);
        byte[] bArr = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.QUERY_BUSINESS_ORDER_STATUS);
        try {
            ITag createTag = messageHandler.createTag((byte) 15);
            createTag.addValue(str);
            createMessage.addTag(createTag);
            bArr = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(5, 77, "ｙ柆逯帯叹计氁敠挳凰珧彆帩ｄ")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("＋枚遵帿右语汓攸挱冬玽弆帣", HttpStatus.SC_NOT_MODIFIED, 23)).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        Object interaction = this.f9738d.interaction(bArr, substring, false, server4Business);
        Object obj = new byte[2];
        System.arraycopy(interaction, 0, obj, 0, obj.length);
        CardBusinessStatus cardBusinessStatus = new CardBusinessStatus();
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Exception.insert(3, 42, "+幢厫夁琉奨账7")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("＇帤右奋琝夶赶", 148, 76)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
        }
        try {
            createMessage = messageHandler.createMessage(TradeCode.QUERY_BUSINESS_ORDER_STATUS, Arrays.copyOfRange(interaction, 2, interaction.length));
            ITag tag4Id = createMessage.getTag4Id(62);
            if (tag4Id != null) {
                EnumBusinessOrderStatus businessOrderStatus4ID = EnumBusinessOrderStatus.getBusinessOrderStatus4ID(tag4Id.getBytesVal()[0]);
                if (businessOrderStatus4ID != null) {
                    cardBusinessStatus.setBusinessOrderStatus(businessOrderStatus4ID);
                }
            }
            ITag tag4Id2 = createMessage.getTag4Id(63);
            if (tag4Id2 != null) {
                EnumAppActivationStatus activationStatus4ID = EnumAppActivationStatus.getActivationStatus4ID(tag4Id2.getBytesVal()[0]);
                if (activationStatus4ID != null) {
                    cardBusinessStatus.setActivationStatus(activationStatus4ID);
                }
            }
        } catch (FMCommunicationMessageException e2) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_CN.equals("莤叒朕斶寵承窶爂朷俭恲＂覼柀帲厢咎庀敵捸弅幠ｓ", 192)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(FM_Exception.insert(SyslogAppender.LOG_LOCAL3, 58, "莫厀朐旺宦戩窷牚杠俧怯６纜竡揭攴刬斶敘盎幷厮哕廆敼挨"), ErrorMessage.local_message_command_data_invaild, false);
        }
        this.f9738d.businessFinish(false);
        return cardBusinessStatus;
    }

    public List<BusinessOrder> queryConfirmDoubtOrder(EnumCardAppType enumCardAppType) throws BusinessException {
        String copyValueOf = FM_Long.copyValueOf("4硿讪古疙讧南枺设", 140);
        if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, BCCUtil.getChars("砠诱右痒诨卄柽讽＊丗勵奟琄宰谱中穤", NFCBaseActivity.TO_ADD, 39));
            }
            throw new BusinessException(FM_CN.equals("砥许叢疏训单枴讠｟乞労夂琑噠剄妁卍好贸", 88), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, Util4Java.endsWith("砱诵召痄该卌枮诿＃淉恼夁瑑噡乡稷", 2, 82));
            }
            throw new BusinessException(FM_Int.replace(174, "硭订另疝训升柰诺７涖怮奀瑁嘢乷稪"), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(1132);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(FM_CN.equals("斡ｄ菮厜够琊皙幽厯奡赤", 4)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Bytes.concat("斯ｒ莴叞変琔皓幯叱夷贮", 2, 5)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(copyValueOf, server4Business);
        List<BusinessOrder> a = m13044a(EnumOrderStatus.dubious, 10, enumCardAppType, EnumBusinessOrderType.ORDER_TYPE_RECHARGE, messageHandler, server4Business);
        this.f9738d.businessFinish(false);
        return a;
    }

    public TicketOperateResult queryLastOperate(String str, String str2, byte[] bArr) throws BusinessException {
        String concat = FM_Bytes.concat("畫遊乒勡畫讧", 1, 120);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Utils.regionMatches(5, 82, "{i7")).toString());
        }
        if (str == null || str.length() < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("斬ｃ畬扮侯怬丢穷", 3, 117)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("断ｋ佳兺皏叕敳彍幣", 4, 108)).toString(), ErrorMessage.local_business_para_error);
        } else if (str2 == null || str2.length() < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("施３绛窨垐司覇栫丱稥", SpecialIssueType.BUG_TYPE_ID_CHARGE, 84)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("旽＄伥內盛厞攩彔幫", 3)).toString(), ErrorMessage.local_business_para_error);
        } else if (bArr == null || bArr.length < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("断５r\u0006\u0016栖诉乷稱", 4, 30)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("斣？伱優盉叉敹彅幽", 5, 30)).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(4, "斯ｐ久劣夁琎寲豯丫穮")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Utils.regionMatches(3, 86, "斥ｅ丅勴奏琇嘿剐姈协奾贠")).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Exception.insert(4, 104, "旾｜淐怯夌琖嘰乺稲")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("斬，淎怣外琞嘶举穰", 3, 38)).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String str3 = null;
            Configration configration = this.f9738d.getConfigration();
            if (configration != null) {
                str3 = configration.getCompanyCode();
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("斢ｏ\u0011.~yg:>:>pgy&乯稾", 4, 111)).toString());
            }
            if (str3 == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Exception.insert(4, 33, "旾％畢扼扌屓唈扸个穫")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("斤９田扬戞屟唂扰丰穷", 2, 35)).toString(), ErrorMessage.local_business_para_error);
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.TICKET_MANAGER);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Exception.insert(186, 52, "旨～莱厌夊瑄盒幹厮夣赣")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("旻＆莰叒夅瑘盟師厥奣赪", 5)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(concat, server4Business);
            TicketOperateResult a = m13039a(str, str3, str2, bArr, messageHandler, server4Business);
            this.f9738d.businessFinish(false);
            return a;
        }
    }

    public MainOrder queryMainOrder(byte[] bArr) throws BusinessException {
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Int.replace(3, "乣诹匋诧绂柢诨#>="));
        }
        String copyValueOf = FM_Long.copyValueOf("串认卖信怲枿讵", 1);
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(BCCUtil.getChars("～乒势夐琌对豷丶穸", 226, 118)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(BCCUtil.getChars("｝乔努夌瑃嘪刂妗协大贶", 1, 93)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(4, 17, "＄涑恥够瑊嘵乴稥")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(CRCUtil.substring(242, "ｓ涂恺处琍噾乻稶")).toString(), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_ORDER_VER2);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(BCCUtil.getChars("旾＜莯取夌琖皜帳厸奡赽", SyslogAppender.LOG_LOCAL3, 8)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Int.replace(2, "斡ｖ菪取备琀皍广叿夣贰")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(copyValueOf, server4Business);
        MainOrder a = m13037a(bArr, messageHandler, server4Business);
        this.f9738d.businessFinish(false);
        return a;
    }

    public List<MainOrder> queryMainOrders(int i, int i2, EnumOrderStatus enumOrderStatus, EnumCardAppType enumCardAppType) throws BusinessException {
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Exception.insert(286, 94, "丹订匋俽恵枽讴:<~"));
        }
        EnumOrderStatus enumOrderStatus2 = enumOrderStatus == null ? EnumOrderStatus.unknown : enumOrderStatus;
        String equals = FM_CN.equals("乯诧匃侦恷柬诸", 1);
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("ｔ乓勻奏琚寴豿丵空", 5)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Long.copyValueOf("＇丒劤夆瑙嘴剄妝卅奡赨", 3)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(3, "＜涓恩夕琚嘯乨稧")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Long.copyValueOf("！涂恨夀琇嘶乡稢", 5)).toString(), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(1132);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("旯＆菬厚奙瑈皛幣叱夣账", 294)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Int.replace(SyslogAppender.LOG_LOCAL4, "旣４莬又夅琂皃幹叽夡贶")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(equals, server4Business);
        List<MainOrder> a = m13043a(enumOrderStatus2, i2 + i, enumCardAppType, messageHandler, server4Business);
        this.f9738d.businessFinish(false);
        return a;
    }

    public List<MainOrder> queryMainOrdersVer4(int i, int i2, List<EnumOrderStatus> list, EnumCardAppType enumCardAppType) throws BusinessException {
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Long.copyValueOf("丱讥卑俠怱枾论}\u0004*>}omns", 2));
        }
        String chars = BCCUtil.getChars("丹诨匇俻恭柯记", 146, 104);
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(BCCUtil.getChars("ｙ义勰奋瑋宲谨乽稿", 5, TransportMediator.KEYCODE_MEDIA_PLAY)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Bytes.concat("ｕ乀勺奘瑛嘶剂始北夳账", 2, 1)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(FM_Utils.regionMatches(4, 14, "ｘ涊恿多琊噲乲稬")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Exception.insert(3, 43, "＋涚怲夌琕嘶丳穮")).toString(), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(1134);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(FM_Bytes.concat("斪ｆ華厐夐琄皔席厼奫赭", 5, 110)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Exception.insert(190, 24, "斴ｖ菥叜夆琜盖帹史夫贷")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(chars, server4Business);
        List<MainOrder> a = m13047a((List) list, i2 + i, enumCardAppType, messageHandler, server4Business);
        this.f9738d.businessFinish(false);
        return a;
    }

    public BusinessOrder queryOrder(byte[] bArr) throws BusinessException {
        String equals = FM_CN.equals("匀筒诵匝柼诨", TransportMediator.KEYCODE_MEDIA_RECORD);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.debug(this.f9737c, FM_Utils.regionMatches(2, 3, "么勴诺匎许织俥恨柯误>=8"));
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, CRCUtil.substring(5, "升笉讪卆査讫斢ｓ乐勴处琍寯豠丶穭"));
            }
            throw new BusinessException(FM_Int.replace(4, "匌筈诽南柠诪旽＂下劵夓琜噵初姈匐夸贩"), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(3, 11, "匆筊讫十柺诨旣ｌ淃怹奅瑊嘿丸穷"));
            }
            throw new BusinessException(FM_Long.copyValueOf("単笞讥卑柤讼断ｔ淝怽奋瑊嘡乼稹", 5), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_ORDER);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Exception.insert(266, 63, "旸ａ莻厝夎瑏皌帴叶奴贡")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("斮ｅ菭厝夘琋皚幼台奠赧", 5)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(equals, server4Business);
        BusinessOrder d = m13057d(bArr, messageHandler, server4Business);
        this.f9738d.businessFinish(false);
        return d;
    }

    public PayOrder queryPayOrder(byte[] bArr) throws BusinessException {
        String endsWith = Util4Java.endsWith("数仚诧匝语终枴讶旡", 2, 35);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, new StringBuilder(FM_CN.equals("敨什讫协P", 212)).append(FM_Bytes.bytesToHexString(bArr)).append(FM_Int.replace(6, "\u0006许织俥恨柯误>=8")).toString());
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(2, 110, "敽亘诬卉诬绞柣讶斴｜丄劭夞琎宯谥乨稺"));
            }
            throw new BusinessException(BCCUtil.getChars("敽仜说卝诼纊査讲旴８乜効奎瑚噦剝姙卒奧购", 2, 50), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, Util4Java.endsWith("支仙诠化询练枣讥旾％淂怤夈琋嘦乵穪", 3, 33));
            }
            throw new BusinessException(FM_CN.equals("攲他诽包枤记斵８涍恹夃瑞嘡习稱", 298), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_ORDER_VER2);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Long.copyValueOf("旺％莱叕处瑛盞帤厤奠赫", 4)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(BCCUtil.getChars("旾｛菱厃奀琕皆幢台奾赻", SyslogAppender.LOG_LOCAL3, 111)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(endsWith, server4Business);
        PayOrder c = m13055c(bArr, messageHandler, server4Business);
        this.f9738d.businessFinish(false);
        return c;
    }

    public List<PayOrder> queryPayOrders(int i, int i2, EnumCardAppType enumCardAppType) throws BusinessException {
        String chars = BCCUtil.getChars("敽仚记南柷讠", 2, 16);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.debug(this.f9737c, FM_Long.copyValueOf("攣仑认卖查访tyz", 4));
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, BCCUtil.getChars("敻互订匃枩诠ｔ乔劥奞瑖寿谽乨穲", 4, 86));
            }
            throw new BusinessException(FM_Int.replace(94, "敼于读匉枺讠ｉ乒勪奊瑗嘼削妑卋失账"), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_CN.equals("敬仌讧千柢论ｅ淒怤夘琋噶丵空", 80));
            }
            throw new BusinessException(FM_CN.equals("整五访卛柺诲－淚怬奐瑃噾丽穢", 232), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(1132);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(FM_CN.equals("斠ｋ華原夞琍皘幾厮奾赥", 3)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Utils.regionMatches(5, 40, "斣１菲厛夑琛盁幾句奬贠")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(chars, server4Business);
        List<PayOrder> a = m13041a(EnumOrderStatus.unknown.getId(), i + i2, enumCardAppType, messageHandler, server4Business);
        this.f9738d.businessFinish(false);
        return a;
    }

    public List<PayOrder> queryPayOrdersVer4(int i, int i2, EnumCardAppType enumCardAppType) throws BusinessException {
        String substring = CRCUtil.substring(3, "政仃认卄柹讥");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, Util4Java.endsWith("攭仑讲卂査诧\"=4", 5, 7));
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Exception.insert(2, 58, "攩亘诸十枫诪ｎ丆勷夔瑌寽豿乢穨"));
            }
            throw new BusinessException(FM_Exception.insert(334, 27, "敽井讪卖査讻ｘ丕劫奁瑆嘳刋姚博奶货"), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, BCCUtil.getChars("敻从诺协枹诼，淊恫奂琎嘢丶稴", 4, 66));
            }
            throw new BusinessException(CRCUtil.substring(4, "放仄讥升柸讪｟淖怦奐瑙噢丯空"), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(1134);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("断）莸叏备琋皓帲去奤赺", 4, 10)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(CRCUtil.substring(3, "旦７莱叇夘瑁盖帮厸奢赻")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(substring, server4Business);
        List<PayOrder> b = m13053b(null, i + i2, enumCardAppType, messageHandler, server4Business);
        this.f9738d.businessFinish(false);
        return b;
    }

    public PreDepositInfo queryPreDeposit(EnumCardAppType enumCardAppType) throws BusinessException {
        String concat = FM_Bytes.concat("飗缰醘俵恰柯讷", 252, 107);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, CRCUtil.substring(ReportInfoUtils.FEEDBACK_FAILED, "颍罺野俫恺枥让xob"));
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_CN.equals("ｚ九勹奍琜寲豽丷稤", 3)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(CRCUtil.substring(2, "＃一劤夔琝嘮剌妗卑奣赸")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Utils.regionMatches(2, TagName.ELECTRONIC_USE_COUNT, "～淁怯奓瑈嘭並穩")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("＆涏恫夅瑘嘳乢稯", 2)).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (enumCardAppType == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("ｗ沿杈伤儢卫乇庄畻皒簢垗", 228, 67)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(BusinessCode.CURRENCY_CODE_RMB, "＝沵朞伺典卡三庒甡皈籴垙")).toString(), ErrorMessage.local_message_load_config_fail);
        } else {
            String str = null;
            Configration configration = this.f9738d.getConfigration();
            if (configration != null) {
                str = configration.getCompanyCode();
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(Util4Java.endsWith("．\u0019=$$358#n{el:丨穰", 5, 120)).toString());
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_PREDEPOSIT);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_Exception.insert(300, 28, "旦｀菿叒处琚盜帧叠夽赭")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("旿＊莴取奙瑜盓帧厡奿赮", 1)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(concat, server4Business);
            PreDepositInfo b = m13052b(enumCardAppType, str, messageHandler, server4Business);
            this.f9738d.businessFinish(false);
            return b;
        }
    }

    public List<PreDepositInfo> queryPreDepositVer2(EnumCardAppType enumCardAppType) throws BusinessException {
        String copyValueOf = FM_Long.copyValueOf("颞罹釅俰恡柮诪", 306);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Int.replace(5, "飞缳金俢恩柬诮!<;"));
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(BCCUtil.getChars("｝世勦夆瑛寡谲临稳", 1, 59)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(BCCUtil.getChars("ｒ东劯奒瑘噮剓妝匈奷赫", FitnessSleepType.HW_FITNESS_SLEEP, 40)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(5, 80, "％淑恦奝瑏噱乳穣")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Utils.regionMatches(270, 57, "ｒ涟怿复瑄噳乮穷")).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (enumCardAppType == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Int.replace(5, "ｖ泼有伣兣卨丆庛町皑籣垐")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Utils.regionMatches(80, 83, "ｌ沲杏伹兩匾丘庑異皏簥埚")).toString(), ErrorMessage.local_message_load_config_fail);
        } else {
            String str = null;
            Configration configration = this.f9738d.getConfigration();
            if (configration != null) {
                str = configration.getCompanyCode();
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(2, 94, "＊\u0007-n85}j7 { l丰穲")).toString());
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_PREDEPOSIT_VER2);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Utils.regionMatches(242, 104, "斴ｆ莥双夆瑌盖幩史夻起")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(3, 96, "旱ｋ菰发夃瑁盃年号奶赢")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(copyValueOf, server4Business);
            List<PreDepositInfo> c = m13056c(enumCardAppType, str, messageHandler, server4Business);
            this.f9738d.businessFinish(false);
            return c;
        }
    }

    public Product queryProduct(String str) throws BusinessException {
        String regionMatches = FM_Utils.regionMatches(3, 114, "仴咄讱纏俺恢柺诳");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (str == null || str.length() < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(5, "＞人哉栔诘乳種")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_Long.copyValueOf("！涂恨夀琇嘶乡稢", 5)).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(5, "＞万助夗琘宰谵乥稰")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(4, 92, "ｘ乊劭夌瑂嘨刁妓卂夡贩")).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(Util4Java.endsWith("，涋怩奍琊噧乨稯", 3, 35)).toString());
                }
                throw new BusinessException(FM_Bytes.concat("丅勯诿卙枾诨旯ｄ涟怩契琂嘻丸穫", 40, 47), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_ORDER_VER2);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_Int.replace(5, "斬ｑ获叕夂琏皈幼叢夤贽")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_Exception.insert(5, 59, "旿ｈ菨双契琖盏幵厱夭赲")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(regionMatches, server4Business);
            Product a = m13038a(str, messageHandler, server4Business);
            this.f9738d.businessFinish(false);
            return a;
        }
    }

    public List<Product> queryProducts(String str, EnumCardAppType enumCardAppType, byte[] bArr) throws BusinessException {
        String regionMatches = FM_Utils.regionMatches(172, 79, "亻咊俻恦梘紥");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Int.replace(5, "份咜信恬棆紫\"!<"));
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_Int.replace(FitnessSleepType.HW_FITNESS_SLEEP, "ｏ乜勨奈瑉宫谴乢稡")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(132, 120, "ｘ乖勥奘瑒嘤剙姗匂夽贡")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(FM_CN.equals("ｔ淁怵奏琚噥两穵", 5)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(SportType.SPORT_TYPE_TREADMILL, "９消恤夒瑇嘤乭稸")).toString(), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(1132);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(regionMatches)).append(BCCUtil.getChars("无ｘ菥叆夊瑊盎幻叶奵赧", 198, 30)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_CN.equals("斮ｅ菭厝夘琋皚幼台奠赧", 5)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(regionMatches, server4Business);
        List<Product> a = m13046a(str, enumCardAppType, bArr, messageHandler, server4Business);
        this.f9738d.businessFinish(false);
        return a;
    }

    public List<TerminalBackInfo> queryTerminalInfoBack(byte[] bArr, byte[] bArr2, int i, EnumResultsSortType enumResultsSortType) throws BusinessException {
        String insert = FM_Exception.insert(4, 2, "叅馂俭恡柵诰");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, insert);
        }
        if (i < 0) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(Util4Java.endsWith("斿＄柢认朤整叁攲乌合沊", 332, 95)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(FM_Int.replace(4, "斯ｐ枺诠杤數叉敾东吜泂")).toString(), ErrorMessage.local_business_para_error);
        } else if (enumResultsSortType == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(FM_Int.replace(4, "斯ｐ枺诠绖枔掙庁斨弛中穠")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(FM_Bytes.concat("斫ｓ枤诡绖柛換庄斴彀乫穩", 6, 98)).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(FM_Exception.insert(5, 57, "％乘勺夐瑋寿谾丢稫")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(Util4Java.endsWith("９丄勦奔瑟嘪剖妟卋夷贪", SyslogAppender.LOG_LOCAL7, 9)).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(FM_Int.replace(4, "ｕ淔怰夆球噠丱穴")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(FM_Utils.regionMatches(4, 110, "ｘ淊怿多琊噲串稬")).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(4001);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(FM_Utils.regionMatches(2, 97, "斤｟莣參奒瑑皜幪厪奪费")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(FM_CN.equals("斯ｆ菬厚夙琈皛幣叱奣赦", 6)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            ITag createTag;
            this.f9738d.businessReady(insert, server4Business);
            byte[] bArr3 = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.QUERY_TERMINAL_BACK);
            if (bArr != null) {
                try {
                    createTag = messageHandler.createTag((byte) 81);
                    createTag.addValue(bArr);
                    createMessage.addTag(createTag);
                } catch (Exception e) {
                    if (this.f9736b != null) {
                        this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(BCCUtil.getChars("柎逡師县诱氟攤捥开幡*", 3, 87)).append(Util4Java.getExceptionInfo(e)).toString());
                    }
                    this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(insert)).append(Util4Java.endsWith("q柑遭帶叭询汏敵捳夤质", 224, 120)).toString(), ErrorMessage.local_message_message_handle_exception, false);
                }
            }
            if (bArr2 != null) {
                createTag = messageHandler.createTag((byte) TagName.TERMINAL_BACK_CHILDREN_ID);
                createTag.addValue(bArr2);
                createMessage.addTag(createTag);
            }
            createTag = messageHandler.createTag((byte) TagName.QUERY_RECORD_COUNT);
            createTag.addValue(i);
            createMessage.addTag(createTag);
            createTag = messageHandler.createTag((byte) TagName.QUERY_DATA_SORT_TYPE);
            createTag.addValue(new byte[]{(byte) enumResultsSortType.getId()});
            createMessage.addTag(createTag);
            bArr3 = createMessage.toBytes();
            byte[] interaction = this.f9738d.interaction(bArr3, insert, false, server4Business);
            this.f9738d.businessFinish(false);
            List<TerminalBackInfo> arrayList = new ArrayList();
            try {
                ITag tag4Id = messageHandler.createMessage(TradeCode.QUERY_TERMINAL_BACK, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(84);
                if (tag4Id != null) {
                    ITag[] itemTags = tag4Id.getItemTags();
                    if (itemTags != null && itemTags.length >= 1) {
                        for (ITag iTag : itemTags) {
                            if (iTag != null) {
                                TerminalBackInfo fromTag = TerminalBackInfo.fromTag(iTag);
                                if (fromTag != null) {
                                    arrayList.add(fromTag);
                                }
                            }
                        }
                    } else if (this.f9736b != null) {
                        this.f9736b.debug(this.f9737c, new StringBuilder(String.valueOf(insert)).append(Util4Java.endsWith(")帿口咗底盌洴勾俼恫隍吚乣空", SportType.SPORT_TYPE_TREADMILL, 71)).toString());
                    }
                } else if (this.f9736b != null) {
                    this.f9736b.debug(this.f9737c, new StringBuilder(String.valueOf(insert)).append(FM_Utils.regionMatches(4, 88, "x帿叴咑廀皈洿勴俵恣隂吔丮稶")).toString());
                }
            } catch (FMCommunicationMessageException e2) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(FM_CN.equals("ａ觽枟平叡哏廇攴挻彄帯２", 218)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(insert)).append(FM_Exception.insert(4, 18, "$觹果幭厠咏廀敶捶夻费")).toString(), ErrorMessage.local_message_command_data_invaild, false);
            }
            return arrayList;
        }
    }

    public List<BusinessOrder> queryUnsolvedOrder(EnumCardAppType enumCardAppType) throws BusinessException {
        String substring = CRCUtil.substring(132, "1朶冴亶明枭讱");
        if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, Util4Java.endsWith("未冽仸昙柽认既ｎ乊势奈瑜寱谷举穨", 3, 46));
            }
            throw new BusinessException(FM_Int.replace(1, "杼凪仸晌柧诧旾＇且劰夐琑噲刀始匕夷贬"), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_CN.equals("杲出仾晘柹误旨＃消怾奆瑕嘬丯穼", 5));
            }
            throw new BusinessException(FM_Utils.regionMatches(3, 60, "杹冼仯昔枦诽断；淛恠奏琁嘫乥穡"), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(1132);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(FM_Int.replace(200, "旫ｌ菴厐奍瑊盋帡厥奩赾")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(306, 62, "旴ｌ莩厊夞瑞皒帧叢奡贫")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(substring, server4Business);
        List<BusinessOrder> a = m13044a(EnumOrderStatus.unsettled, 10, enumCardAppType, EnumBusinessOrderType.ORDER_TYPE_RECHARGE, messageHandler, server4Business);
        List<BusinessOrder> a2 = m13044a(EnumOrderStatus.hasPaid, 10, enumCardAppType, EnumBusinessOrderType.ORDER_TYPE_RECHARGE, messageHandler, server4Business);
        List<BusinessOrder> a3 = m13044a(EnumOrderStatus.failure, 10, enumCardAppType, EnumBusinessOrderType.ORDER_TYPE_RECHARGE, messageHandler, server4Business);
        for (BusinessOrder add : a2) {
            a.add(add);
        }
        for (BusinessOrder add2 : a3) {
            a.add(add2);
        }
        this.f9738d.businessFinish(false);
        return a;
    }

    public UserInfo queryUserInfo(String str) throws BusinessException {
        String chars = BCCUtil.getChars("畬扷侽恷柱讲", 84, 28);
        if (str == null || "".equals(str)) {
            throw new BusinessException(Util4Java.endsWith("畷找俲怲柢讳旭）佯兼盇叏攧彃帳", 2, 74), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(5, 122, "畽扸侨怬枸讵斧ｇ也劾夝琕寴豦主穡"));
            }
            throw new BusinessException(FM_Exception.insert(120, 52, "畴戧侥恷枩询既ｄ丆勱夀琞嘤初妟匞夭赵"), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Bytes.concat("略批侮怿枴记斥ｘ淝怹奓瑞嘱习稡", 374, 1));
                }
                throw new BusinessException(FM_CN.equals("畼扲侷怨柽诫旬＇淔怢奚瑉嘨丫穸", 1), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_USER_INFO);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(FM_Long.copyValueOf("旼＋莳受奚瑝盜带厢奾赩", 2)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Exception.insert(4, 106, "旾～菫厐夔琜皀帽厨女贩")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(chars, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.QUERY_USER_INFO);
            try {
                ITag createTag = messageHandler.createTag((byte) 2);
                createTag.addValue(str);
                createMessage.addTag(createTag);
                bArr = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(Util4Java.endsWith("甫扽侰恷柺诤斻ｘ枟逢幺厠讠汜敵换冩珪彃帰５", 6, 103)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(BCCUtil.getChars("甲戸俥怶枫计斮斻ｎ枓逬干另诼求攥挤冥珤彋带", HiUserInfo.HEIGHT_DEFAULT, 117), ErrorMessage.local_message_message_handle_exception, false);
            }
            Object interaction = this.f9738d.interaction(bArr, chars, false, server4Business);
            Object obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(Util4Java.endsWith("畭批俶息柬记断ｈ幾另奛瑎奠贿９", 232, 105)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9738d.throwExceptionAndClose(BCCUtil.getChars("甠扬俯恮枱该斬ａ平厣奂琟好贺", 280, 83), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
            }
            UserInfo userInfo = new UserInfo();
            try {
                IMessage createMessage2 = messageHandler.createMessage(TradeCode.QUERY_USER_INFO, Arrays.copyOfRange(interaction, 2, interaction.length));
                ITag tag4Id = createMessage2.getTag4Id(1);
                if (tag4Id != null) {
                    userInfo.setUserType(tag4Id.getIntVal());
                }
                tag4Id = createMessage2.getTag4Id(4);
                if (tag4Id != null) {
                    userInfo.setMail(tag4Id.getStringVal());
                }
                tag4Id = createMessage2.getTag4Id(5);
                if (tag4Id != null) {
                    userInfo.setPhone(tag4Id.getStringVal());
                }
                tag4Id = createMessage2.getTag4Id(6);
                if (tag4Id != null) {
                    userInfo.setRealName(tag4Id.getStringVal());
                }
                tag4Id = createMessage2.getTag4Id(7);
                if (tag4Id != null) {
                    userInfo.setCertType(tag4Id.getIntVal());
                }
                ITag tag4Id2 = createMessage2.getTag4Id(8);
                if (tag4Id2 != null) {
                    userInfo.setCertNo(tag4Id2.getStringVal());
                }
            } catch (Exception e2) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(BCCUtil.getChars("畺戨侭怶柣讱时！覹林幧厱哃序攸捻彀幷＆", 2, 45)).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                this.f9738d.throwExceptionAndClose(CRCUtil.substring(HiUserInfo.HEIGHT_DEFAULT, "甿扵侬怷枦讬斯（织竵掠攦别斦攙盘帴厢咐府散捰"), ErrorMessage.local_message_message_handle_exception, false);
            }
            this.f9738d.businessFinish(false);
            return userInfo;
        }
    }

    public UserInfo queryUserInfoVer2(String str) throws BusinessException {
        String endsWith = Util4Java.endsWith("畷戭侴恿枮诤", 2, 59);
        if (str == null || "".equals(str)) {
            throw new BusinessException(FM_Utils.regionMatches(1, 14, "畹扨俬恴柬诵斳｟佡優盙叉敩弅席"), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Bytes.concat("畲扣侯性枧设斠｜乐勥多琞寫豭丼空", 3, 122));
            }
            throw new BusinessException(Util4Java.endsWith("畩扵俢恫枠认旱＄乓勫夏琊嘥剓姄匆奠起", 196, 33), ErrorMessage.local_business_init_fail);
        } else {
            String companyCode;
            Configration configration = this.f9738d.getConfigration();
            if (configration != null) {
                companyCode = configration.getCompanyCode();
            } else {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Int.replace(5, "畲扪注冏旰％O`|sq|l`pnec0丩穬"));
                }
                companyCode = null;
            }
            if (companyCode == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_CN.equals("異找沲凇旪！酓罡文产乯杹十吾厄啑缞硘", 5));
                }
                throw new BusinessException(FM_Bytes.concat("畴扩注冎旲＊甠戽扌屐啖戥丮穬", 5, 2), ErrorMessage.local_business_para_error);
            }
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Bytes.concat("畳戩侠怫柢诨斻｜涛恹奝瑚噷乸稿", 4, 35));
                }
                throw new BusinessException(FM_Exception.insert(4, 22, "甠戩俵急枥讴旺．涐怡奀瑜噸丼穦"), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_USER_INFO_VER2);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(BCCUtil.getChars("斥０菲厘夓瑆盍幡叫奵质", 3, 41)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(78, 18, "旨｜菵厂夂琞皎幯厾奱起")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(endsWith, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.QUERY_USER_INFO_VER2);
            try {
                ITag createTag = messageHandler.createTag((byte) 2);
                createTag.addValue(str);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) TagName.COMPANY_CODE);
                createTag.addValue(companyCode);
                createMessage.addTag(createTag);
                bArr = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(FM_Bytes.concat("異扼俿怾枡诵於１枔遣幥叹讫汍敲挻凲珫彌帹ｎ", 1, 83)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_CN.equals("甫戣俤怹枢论斿旬＇枘逭席县讷氓攲捽凾玥弄幯", SyslogAppender.LOG_LOCAL6), ErrorMessage.local_message_message_handle_exception, false);
            }
            Object interaction = this.f9738d.interaction(bArr, endsWith, false, server4Business);
            Object obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(FM_Bytes.concat("畱扸侤怴枴讥旫？幺可夑琍夰赲ｗ", 2, 118)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9738d.throwExceptionAndClose(CRCUtil.substring(2, "甧戭俤恿柾认斧ｐ帴厢奙琎夢贻"), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
            }
            UserInfo userInfo = new UserInfo();
            try {
                IMessage createMessage2 = messageHandler.createMessage(TradeCode.QUERY_USER_INFO, Arrays.copyOfRange(interaction, 2, interaction.length));
                ITag tag4Id = createMessage2.getTag4Id(1);
                if (tag4Id != null) {
                    userInfo.setUserType(tag4Id.getIntVal());
                }
                tag4Id = createMessage2.getTag4Id(4);
                if (tag4Id != null) {
                    userInfo.setMail(tag4Id.getStringVal());
                }
                tag4Id = createMessage2.getTag4Id(5);
                if (tag4Id != null) {
                    userInfo.setPhone(tag4Id.getStringVal());
                }
                tag4Id = createMessage2.getTag4Id(6);
                if (tag4Id != null) {
                    userInfo.setRealName(tag4Id.getStringVal());
                }
                tag4Id = createMessage2.getTag4Id(7);
                if (tag4Id != null) {
                    userInfo.setCertType(tag4Id.getIntVal());
                }
                ITag tag4Id2 = createMessage2.getTag4Id(8);
                if (tag4Id2 != null) {
                    userInfo.setCertNo(tag4Id2.getStringVal());
                }
            } catch (Exception e2) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(FM_Exception.insert(5, 118, "甡扨侴怤枤讵斻ｏ觺枟并叫哜库攭挽彋幧ｏ")).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_CN.equals("电戹侾怿枤记斵８绍竹探敮剹斺攃皘幾叮哂应攡挬", 298), ErrorMessage.local_message_message_handle_exception, false);
            }
            this.f9738d.businessFinish(false);
            return userInfo;
        }
    }

    public VersionInfo queryVersion() throws BusinessException {
        String chars = BCCUtil.getChars("莹叛杌旻宨戾窧爏未俤怫", 286, 31);
        if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_CN.equals("菡厑杘旹宸戼竳牅杲侮怯｝乘劲夀琓寿谶乲稣", 3));
            }
            throw new BusinessException(FM_Long.copyValueOf("莽发朄斱导扬窷爝松侮怣斿ｊ乙勡奙瑜嘿剉妚単奺赭", 2), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Int.replace(332, "菶厒杇旺寯执窼爞杵侽怰ｎ淍性奏瑈嘹乮稭"));
            }
            throw new BusinessException(FM_Long.copyValueOf("菥厙杌旹寤扴窯牕朶俶恻＝涆恤夌球噪严穦", 202), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_VERSION);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(FM_Utils.regionMatches(5, 8, "斣ｑ莲叛夑琛皁幾句夬赠")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Utils.regionMatches(2, 93, "斤ｃ莻叟奂瑅的帮厪夦贱")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(chars, server4Business);
        byte[] bArr = null;
        try {
            bArr = messageHandler.createMessage((int) TradeCode.QUERY_VERSION).toBytes();
        } catch (Exception e) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(CRCUtil.substring(2, "莸双朅斠容扱窾爔杫侳怲＄林逾幺古诨氈攥挮冱珦弃帴－")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9738d.throwExceptionAndClose(BCCUtil.getChars("莭厕杌日导扰窿爑朮俪恻１枂逯幫厱讽民攬挫冴珧异帱", 202, 9), ErrorMessage.local_message_message_handle_exception, false);
        }
        Object interaction = this.f9738d.interaction(bArr, chars, false, server4Business);
        Object obj = new byte[2];
        System.arraycopy(interaction, 0, obj, 0, obj.length);
        VersionInfo versionInfo = new VersionInfo();
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(FM_Exception.insert(4, 2, "莿叜朌斾宲戥竻牞朴俻恳2平史夀琀夹贯6")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9738d.throwExceptionAndClose(Util4Java.endsWith("菠叉杇斿寵戨竨爇朻侾恨ｃ幤厯奃琉奦贺", 218, 72), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
        }
        for (ITag iTag : messageHandler.createMessage(TradeCode.QUERY_VERSION, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(-112).getItemTags()) {
            if (iTag != null) {
                switch (iTag.getId()) {
                    case (byte) 28:
                        versionInfo.setUrl(iTag.getStringVal());
                        break;
                    case (byte) 44:
                        try {
                            versionInfo.setViersion(iTag.getStringVal());
                            break;
                        } catch (FMCommunicationMessageException e2) {
                            if (this.f9736b != null) {
                                this.f9736b.warn(this.f9737c, new StringBuilder(CRCUtil.substring(1, "莹叏朄斿宸扲窿爓杪侰怳＋觱枍幻口哓廝攤挱彈幭：")).append(FM_Bytes.bytesToHexString(interaction)).toString());
                            }
                            this.f9738d.throwExceptionAndClose(FM_Bytes.concat("菭厎杖旤寰执窡爄杦侩怩ｈ纊窯揻敪剪斸攞盐帡厠咃廘攺挦", 3, TransportMediator.KEYCODE_MEDIA_PLAY), ErrorMessage.local_message_command_data_invaild, false);
                            break;
                        }
                    case (byte) 45:
                        versionInfo.setUpdate(iTag.getIntVal() == 1);
                        break;
                    default:
                        break;
                }
            }
        }
        this.f9738d.businessFinish(false);
        return versionInfo;
    }

    public int register(UserInfo userInfo) throws BusinessException {
        String insert = FM_Exception.insert(174, 95, "町戦沸凃");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Long.copyValueOf("産房泭冎qrw", 3));
        }
        if (userInfo == null) {
            throw new BusinessException(FM_Bytes.concat("畻扬沫凇斥ｗ伣兮皗申戴俪恼両稹", 220, 8), ErrorMessage.local_business_para_error);
        } else if (userInfo.getUserName() == null || userInfo.getUserName().length() < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Exception.insert(3, 61, "甯扳泩冒断４併具盋甤找贠厴为稧"));
            }
            throw new BusinessException(FM_Utils.regionMatches(216, 114, "畠戭泤冒旦．佴儣盜畢戫质号丨穾"), ErrorMessage.local_business_para_error);
        } else if (userInfo.getPassword() == null || userInfo.getPassword().length() < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Exception.insert(SyslogAppender.LOG_LOCAL7, 47, "甴扼泲凅斮＋佶兠皐畫戥宇硑严稴"));
            }
            throw new BusinessException(CRCUtil.substring(244, "甩戻泿冎旻４佣儫盝畬扸宜砄个穡"), ErrorMessage.local_business_para_error);
        } else if (userInfo.getPassword().length() > 32) {
            throw new BusinessException(FM_Int.replace(2, "畿扭沵册旵＊甡戻寉钷镪庾忞顥導亊48"), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Bytes.concat("甩扣泯凖斻，义勧夝瑊實豳乿穢", 138, 83));
            }
            throw new BusinessException(Util4Java.endsWith("當戯泺净新，一劵奊瑎噪刁姝卆奻贡", 1, 26), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(1, 42, "畹戬沭凃旯ｏ淅恸奅瑍噽严稳"));
                }
                throw new BusinessException(FM_Exception.insert(326, 13, "奎瑑杮凢仺昘旮）涚恰奈瑟嘮乩空"), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(1001);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(FM_Int.replace(180, "旿＀莸叄夑琞皟幭厱奵赢")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(FM_CN.equals("斡ｄ菮厜够琊皙幽厯奡赤", 4)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(insert, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage(1001);
            try {
                ITag createTag = messageHandler.createTag((byte) 1);
                createTag.addValue(userInfo.getUserType());
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 2);
                createTag.addValue(userInfo.getUserName());
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 3);
                createTag.addValue(userInfo.getPassword());
                createMessage.addTag(createTag);
                if (userInfo.getMail() != null && userInfo.getMail().length() > 1) {
                    createTag = messageHandler.createTag((byte) 4);
                    createTag.addValue(userInfo.getMail());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getPhone() != null && userInfo.getPhone().length() > 1) {
                    createTag = messageHandler.createTag((byte) 5);
                    createTag.addValue(userInfo.getPhone());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getRealName() != null && userInfo.getRealName().length() > 1) {
                    createTag = messageHandler.createTag((byte) 6);
                    createTag.addValue(userInfo.getRealName());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getCertType() != -1) {
                    createTag = messageHandler.createTag((byte) 7);
                    createTag.addValue(userInfo.getCertType());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getCertNo() != null && userInfo.getCertNo().length() > 1) {
                    ITag createTag2 = messageHandler.createTag((byte) 8);
                    createTag2.addValue(userInfo.getCertNo());
                    createMessage.addTag(createTag2);
                }
                bArr = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(FM_Long.copyValueOf("甥戽泯冈-柚遻師厥讥氍攼挧彄幻z", 5)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_Bytes.concat("畳扺沷凝o枑逧幪叻讪氍攱挽奴贲", 4, 114), ErrorMessage.local_message_message_handle_exception, false);
            }
            bArr = this.f9738d.interaction(bArr, CRCUtil.substring(2, "甧戭泭农"), false, server4Business);
            byte[] copyOf = Arrays.copyOf(bArr, 2);
            this.f9738d.businessFinish(false);
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
                return 0;
            }
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(FM_Bytes.concat("畭扭沧凈５幽右哕庙锛许咁廕硗q`", 110, 117)).append(FM_Bytes.bytesToHexString(bArr)).toString());
            }
            return FM_CN.bcdBytesToInt(copyOf);
        }
    }

    public int registerVer2(UserInfo userInfo) throws BusinessException {
        String chars = BCCUtil.getChars("畻扱沱净", 3, 115);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_CN.equals("畽扱沿凄１\\~~oｇq~o", 2));
        }
        if (userInfo == null) {
            throw new BusinessException(FM_Int.replace(5, "畲扪注冏旰％伬兪皖甽戯俺恱主穾"), ErrorMessage.local_business_para_error);
        } else if (userInfo.getUserName() == null || userInfo.getUserName().length() < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(4, 92, "畼执泤冄斲ｌ似儽盐甸戻赮厳为稦"));
            }
            throw new BusinessException(FM_CN.equals("畼扲沾凋旮％伺兮盘略扩赩厷丫穸", 1), ErrorMessage.local_business_para_error);
        } else if (userInfo.getPassword() == null || userInfo.getPassword().length() < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, Util4Java.endsWith("甩戡沣册斣＆伿儱皍當戤宎硜丨稽", 4, 53));
            }
            throw new BusinessException(FM_Utils.regionMatches(272, ReportInfoUtils.FEEDBACK_SUCCESS, "用扬沾凝斺ｋ佢儸盜畻批宏硅严穠"), ErrorMessage.local_business_para_error);
        } else if (userInfo.getPassword().length() > 32) {
            throw new BusinessException(FM_Int.replace(334, "畫扱没净方～畽扯宝铻锾廢徂頱层仞`d"), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(5, 105, "畽扩沯农旯．乑勵夙琀寶谹乻稰"));
            }
            throw new BusinessException(FM_Exception.insert(68, 25, "畠扶沲冟旺ｉ乄勶夔琏嘪剆妟匛夷贺"), ErrorMessage.local_business_init_fail);
        } else {
            String companyCode;
            Configration configration = this.f9738d.getConfigration();
            if (configration != null) {
                companyCode = configration.getCompanyCode();
            } else {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, Util4Java.endsWith("畷扼沿减旹７D<1-~d}:3:pe7丹稵", 2, 108));
                }
                companyCode = null;
            }
            if (companyCode == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Int.replace(172, "甩戳泯円旻＜酞罸斞仪串杨區呣叉唈罇硕"));
                }
                throw new BusinessException(CRCUtil.substring(3, "甸戬泮冝旪ｋ畺扪戈對唘戾丮穥"), ErrorMessage.local_business_para_error);
            }
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, CRCUtil.substring(278, "甫戹泱凈方ｖ淍怿奟琀噹並穽"));
                }
                throw new BusinessException(FM_Utils.regionMatches(6, 81, "畾扰泰凅旬＇淔恢奚瑉器乫稸"), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(1002);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(FM_CN.equals("旫＂菨历奅瑔盇幧叵大财", 298)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Exception.insert(194, 17, "新｛菿厏夎琝皈幮厾奮赵")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(chars, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage(1002);
            try {
                ITag createTag = messageHandler.createTag((byte) 1);
                createTag.addValue(userInfo.getUserType());
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 2);
                createTag.addValue(userInfo.getUserName());
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 3);
                createTag.addValue(userInfo.getPassword());
                createMessage.addTag(createTag);
                if (userInfo.getMail() != null && userInfo.getMail().length() > 1) {
                    createTag = messageHandler.createTag((byte) 4);
                    createTag.addValue(userInfo.getMail());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getPhone() != null && userInfo.getPhone().length() > 1) {
                    createTag = messageHandler.createTag((byte) 5);
                    createTag.addValue(userInfo.getPhone());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getRealName() != null && userInfo.getRealName().length() > 1) {
                    createTag = messageHandler.createTag((byte) 6);
                    createTag.addValue(userInfo.getRealName());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getCertType() != -1) {
                    createTag = messageHandler.createTag((byte) 7);
                    createTag.addValue(userInfo.getCertType());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getCertNo() != null && userInfo.getCertNo().length() > 1) {
                    createTag = messageHandler.createTag((byte) 8);
                    createTag.addValue(userInfo.getCertNo());
                    createMessage.addTag(createTag);
                }
                ITag createTag2 = messageHandler.createTag((byte) TagName.COMPANY_CODE);
                createTag2.addValue(companyCode);
                createMessage.addTag(createTag2);
                bArr = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(FM_Int.replace(3, "異扬沶再(枃逪幾叠诤汔敩捲弝帺?")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_Bytes.concat("畴扠沺凁d柇遾帪厤许氈攵挮太贳", 5, ReportInfoUtils.FEEDBACK_SUCCESS), ErrorMessage.local_message_message_handle_exception, false);
            }
            bArr = this.f9738d.interaction(bArr, FM_Bytes.concat("畻扵泹册", 92, 111), false, server4Business);
            byte[] copyOf = Arrays.copyOf(bArr, 2);
            this.f9738d.businessFinish(false);
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
                return 0;
            }
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(CRCUtil.substring(3, "甸戬泮冝０帴厢咐廜镊讱哄庀砞05")).append(FM_Bytes.bytesToHexString(bArr)).toString());
            }
            return FM_CN.bcdBytesToInt(copyOf);
        }
    }

    public int registerVer3(UserInfo userInfo) throws BusinessException {
        String endsWith = Util4Java.endsWith("畭截泽冁", 200, 120);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, BCCUtil.getChars("畮扣泪凜ｖZ?z%ｍ<n`", 214, 46));
        }
        if (userInfo == null) {
            throw new BusinessException(BCCUtil.getChars("畻扽泩凔方＊佽儱皏甪扮俱恨乤穯", 3, 87), ErrorMessage.local_business_para_error);
        } else if (userInfo.getUserName() == null || userInfo.getUserName().length() < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Exception.insert(5, 52, "甡截油冉斯！佡儰皍畵戦赣厮丷稻"));
            }
            throw new BusinessException(CRCUtil.substring(1, "甦戮泬冃旬ｉ佰儾盂畹扫贡句丧穲"), ErrorMessage.local_business_para_error);
        } else if (userInfo.getPassword() == null || userInfo.getPassword().length() < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Exception.insert(212, 27, "異扤泦内斲ｓ佺兰皔畣扱寇砝中稨"));
            }
            throw new BusinessException(FM_Bytes.concat("畫扺沿凍施ｙ使公皗电戰寗砚乿稵", 332, 10), ErrorMessage.local_business_para_error);
        } else if (userInfo.getPassword().length() > 32) {
            throw new BusinessException(FM_Exception.insert(6, 19, "產截泸减斠ｅ畴戸寄钰锷廽律顺尛争)"), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Exception.insert(5, 85, "甡扩泻冄斫＞丝勽夕琀客豱丿稠"));
            }
            throw new BusinessException(Util4Java.endsWith("甩戼沽凓旿｟乇劦奕瑝噭剒妒匕奼赲", 4, 42), ErrorMessage.local_business_init_fail);
        } else {
            String companyCode;
            Configration configration = this.f9738d.getConfigration();
            if (configration != null) {
                companyCode = configration.getCompanyCode();
            } else {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Int.replace(4, "畱扫沷冎旳＄Har~}oawofb/丨穯"));
                }
                companyCode = null;
            }
            if (companyCode == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Long.copyValueOf("甴戮泾冟旦！酇罩斃价丳朱匝吾厐啉缚砈", 52));
                }
                throw new BusinessException(Util4Java.endsWith("甩扬沽凃斿ｏ畵扠我尕唃戨丣穩", 4, 122), ErrorMessage.local_business_para_error);
            }
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Bytes.concat("畵戸沩冟斳｛涁怴変琙嘹丹稯", 6, 50));
                }
                throw new BusinessException(FM_CN.equals("畿承沱准旭＀涕恡奛瑖嘩乨稹", 4), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(1002);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Long.copyValueOf("旰／获友夞琑皐幢叾夺购", 158)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(CRCUtil.substring(240, "斫＄莤又复琒皛帹厥奱赮")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(endsWith, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage(1003);
            try {
                ITag createTag = messageHandler.createTag((byte) 1);
                createTag.addValue(userInfo.getUserType());
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 2);
                createTag.addValue(userInfo.getUserName());
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 3);
                createTag.addValue(userInfo.getPassword());
                createMessage.addTag(createTag);
                if (userInfo.getMail() != null && userInfo.getMail().length() > 1) {
                    createTag = messageHandler.createTag((byte) 4);
                    createTag.addValue(userInfo.getMail());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getPhone() != null && userInfo.getPhone().length() > 1) {
                    createTag = messageHandler.createTag((byte) 5);
                    createTag.addValue(userInfo.getPhone());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getRealName() != null && userInfo.getRealName().length() > 1) {
                    createTag = messageHandler.createTag((byte) 6);
                    createTag.addValue(userInfo.getRealName());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getCertType() != -1) {
                    createTag = messageHandler.createTag((byte) 7);
                    createTag.addValue(userInfo.getCertType());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getCertNo() != null && userInfo.getCertNo().length() > 1) {
                    createTag = messageHandler.createTag((byte) 8);
                    createTag.addValue(userInfo.getCertNo());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getVerificationCodeNo() != null && userInfo.getVerificationCodeNo().length > 1) {
                    createTag = messageHandler.createTag((byte) 64);
                    createTag.addValue(userInfo.getVerificationCodeNo());
                    createMessage.addTag(createTag);
                }
                if (userInfo.getVerificationCode() != null && userInfo.getVerificationCode().length() > 1) {
                    createTag = messageHandler.createTag((byte) TagName.IDENTIFYING_CODE);
                    createTag.addValue(userInfo.getVerificationCode());
                    createMessage.addTag(createTag);
                }
                ITag createTag2 = messageHandler.createTag((byte) TagName.COMPANY_CODE);
                createTag2.addValue(companyCode);
                createMessage.addTag(createTag2);
                bArr = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(BCCUtil.getChars("畾戢沼冟~枕遰幼厾诺氎敻挤弋幰=", 6, 63)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_Utils.regionMatches(134, 11, "畾戶泤军.枉逸帰厾议氆政挴头贵"), ErrorMessage.local_message_message_handle_exception, false);
            }
            bArr = this.f9738d.interaction(bArr, FM_CN.equals("畾扰沰凅", 3), false, server4Business);
            byte[] copyOf = Arrays.copyOf(bArr, 2);
            this.f9738d.businessFinish(false);
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
                return 0;
            }
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(FM_Exception.insert(5, 87, "甡扷泿冂ｉ幯口咇廕锁讠咋庉硕q\"")).append(FM_Bytes.bytesToHexString(bArr)).toString());
            }
            return FM_CN.bcdBytesToInt(copyOf);
        }
    }

    public boolean remoteRecharge(byte[] bArr, byte[] bArr2) throws BusinessException {
        String insert = FM_Exception.insert(1, 9, "卤丄広用圁孊");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Utils.regionMatches(6, 45, "匷三廄畵圂嬏*?p"));
        }
        if (bArr == null || bArr.length < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(FM_CN.equals("斠ｋ佸儬皞让卉缛厩乵稺", 3)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(FM_CN.equals("旱４伩儿盏课匘缈司为穫", 180)).toString(), ErrorMessage.local_business_para_error);
        } else if (bArr2 == null || bArr2.length < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(FM_Int.replace(3, "斮ｗ佾兤皀卦庞甥废刄叡丣穦")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(FM_Exception.insert(4, 65, "旾ｅ伪儮皈匬庚畧废剆句乩穮")).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(FM_Exception.insert(210, 49, "斠＋丂勨夞瑍宥豬乤穵")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(Util4Java.endsWith("时ｂ丆勫夜琀嘼刟妛匈夽赿", 3, 78)).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(Util4Java.endsWith("时１淒恸奐琗嘦丱稲", 3, 61)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(FM_Exception.insert(2, 91, "旰ｍ涔恸奖瑋噠丹稤")).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.REMOTE_RECHARGE);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(insert)).append(Util4Java.endsWith("旣４莬又夅琂皃幹叽夡贶", SyslogAppender.LOG_LOCAL3, 3)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(FM_Int.replace(2, "斡ｖ菪取备琀皍广叿夣贰")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(insert, server4Business);
            return m13049a(bArr, bArr2, messageHandler, server4Business);
        }
    }

    public byte[] rentBusinessHandle(int i, byte[] bArr) throws BusinessException {
        String chars = BCCUtil.getChars("瞳租匣丞勧擅伖", FitnessSleepType.HW_FITNESS_SLEEP, 66);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(CRCUtil.substring(1, "＂七劥夋琜宼谱乡稼")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Utils.regionMatches(3, 22, "｟专劾夑瑍嘩削姆匕夨赪")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(BCCUtil.getChars("＆淛怳夁瑈嘿为稳", 314, 41)).toString());
            }
            throw new BusinessException(FM_Long.copyValueOf("丞加讼华柽请旤＃涄恦夂琅器乧稠", BusinessCode.CURRENCY_CODE_RMB), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_ORDER_VER2);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(FM_CN.equals("早＜莶叄备瑒盁帥厷天贬", 332)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Int.replace(140, "旷（莰叜変琖皗幥叩夭贺")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        byte[] a = m13050a(messageHandler, server4Business, i, bArr);
        this.f9738d.businessReady(chars, server4Business);
        this.f9738d.businessFinish(false);
        return a;
    }

    public PasswordPrompt retrievePassword(String str) throws BusinessException {
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, CRCUtil.substring(2, "甧戭寃砑扥嚘ri"));
        }
        String replace = FM_Int.replace(3, "異扬官砀扺囙");
        if (str == null || str.length() < 1) {
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Utils.regionMatches(340, 54, "斲ｖ估儣皘厐數弜幬")).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_CN.equals("斠ｋ乂勨夞琍寥豬乤稵", 3)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(BCCUtil.getChars("斥１丝勰够瑃噧剄妈匛奦贤", 3, 74)).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(CRCUtil.substring(4, "旧０涏恽夙瑎嘻乤稳")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Int.replace(4, "斯ｐ淗恭夁琎噣临穫")).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.RETRIVE_PWD);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(BCCUtil.getChars("斣５菪厗夁瑏皉帢句奨贸", 5, 68)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Exception.insert(6, 86, "旼ｌ莡叚奆琞皊帷只夡赣")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(replace, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.RETRIVE_PWD);
            try {
                ITag createTag = messageHandler.createTag((byte) 2);
                createTag.addValue(str);
                createMessage.addTag(createTag);
                bArr = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(BCCUtil.getChars("旪ｕ枒遳幣厽诽氅整振凤珫弚幭（", 204, 61)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(Util4Java.endsWith("时＇枒逡广叧讵氏攨挭冴珩弆帷", 3, 11)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            Object interaction = this.f9738d.interaction(bArr, replace, false, server4Business);
            Object obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            PasswordPrompt passwordPrompt = null;
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                try {
                    ITag tag4Id = messageHandler.createMessage(TradeCode.RETRIVE_PWD, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(10);
                    if (tag4Id != null) {
                        passwordPrompt = PasswordPrompt.fromTag(tag4Id);
                    }
                } catch (Exception e2) {
                    if (this.f9736b != null) {
                        this.f9736b.warn(this.f9737c, new StringBuilder(FM_Exception.insert(120, 38, "畴戵瘳弛既６覣枖广厢咕床攴挤凪玦彞帺2")).append(Util4Java.getExceptionInfo(e2)).toString());
                    }
                }
            } else {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_CN.equals("斢ｉ奒瑁天贬＀", 1)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(FM_Int.replace(68, "旯０夛瑄奴赭ｇ帽厡咙廃纉柁zcmi\n\u0002\r\u0017!/;r*esyu`BvTzzV|ygs?hx33)'?*{")).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            this.f9738d.businessFinish(false);
            return passwordPrompt;
        }
    }

    public PasswordPrompt retrievePasswordVer2(String str, byte[] bArr, String str2) throws BusinessException {
        PasswordPrompt passwordPrompt = null;
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, CRCUtil.substring(64, "略扯宅硏戧囚!4+"));
        }
        String endsWith = Util4Java.endsWith("畯戲宅砀扡嚃", 202, 62);
        if (str == null || str.length() < 1) {
            throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(FM_Exception.insert(226, 45, "新？你儨皞厅攤弃并")).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(Util4Java.endsWith("旴９丒劺奊瑇宭豦丠穷", 5, 19)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(CRCUtil.substring(214, "斵ｂ乃劥夋琜噭刍姐卐奠赹")).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(Util4Java.endsWith("斨＂涖恡多瑈嘶乴稤", 1, 16)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(CRCUtil.substring(6, "日２涁恻夛瑌嘽乺稱")).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.RETRIVE_PWD);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Long.copyValueOf("旺％莱叕处瑛盞帤厤奠赫", 4)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(endsWith)).append(FM_CN.equals("斠ｋ華原夞琍皘幾厮奾赥", 3)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            String companyCode;
            Configration configration = this.f9738d.getConfigration();
            if (configration != null) {
                companyCode = configration.getCompanyCode();
            } else {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Int.replace(1, "畾扮戢嚁寄砄旾＇M~zqszrbr`ca2丯穢"));
                }
                companyCode = null;
            }
            if (companyCode == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, FM_Int.replace(4, "畱扫戡囜寃砉旽＂甹戣扗屄啛户丹穼"));
                }
                throw new BusinessException(CRCUtil.substring(224, "略扯癸彛旯（甧戭戅導唝扱乫稦"), ErrorMessage.local_business_para_error);
            }
            ITag createTag;
            byte[] toBytes;
            this.f9738d.businessReady(endsWith, server4Business);
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.RETRIVE_PWD_VER3);
            try {
                ITag createTag2 = messageHandler.createTag((byte) 2);
                createTag2.addValue(str);
                createMessage.addTag(createTag2);
                createTag2 = messageHandler.createTag((byte) TagName.COMPANY_CODE);
                createTag2.addValue(companyCode);
                createMessage.addTag(createTag2);
                if (str2 != null && str2.length() > 0) {
                    createTag = messageHandler.createTag((byte) TagName.IDENTIFYING_CODE);
                    createTag.addValue(str2);
                    createMessage.addTag(createTag);
                }
                if (bArr != null && bArr.length > 0) {
                    createTag = messageHandler.createTag((byte) 64);
                    createTag.addValue(bArr);
                    createMessage.addTag(createTag);
                }
                toBytes = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(FM_Int.replace(2, "斡ｖ柙造幰叶课汎敿捼凯玨弙带；")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(4, 55, "斢＇柆逹帣号诩気敼挭几珡弊帧")).toString(), ErrorMessage.local_message_message_handle_exception, false);
                toBytes = null;
            }
            Object interaction = this.f9738d.interaction(toBytes, endsWith, false, server4Business);
            Object obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                try {
                    createTag = messageHandler.createMessage(TradeCode.RETRIVE_PWD, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(10);
                    if (createTag != null) {
                        passwordPrompt = PasswordPrompt.fromTag(createTag);
                    }
                } catch (Exception e2) {
                    if (this.f9736b != null) {
                        this.f9736b.warn(this.f9737c, new StringBuilder(FM_Long.copyValueOf("產戰癿彔斨ｗ覻柅帡县咁廝收挭冺班彘幯n", 2)).append(Util4Java.getExceptionInfo(e2)).toString());
                    }
                }
            } else {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(endsWith)).append(CRCUtil.substring(266, "旡．変琞奲赫ｃ")).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(endsWith)).append(FM_Utils.regionMatches(5, 58, "斣＃帺右奙琑奠贮")).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
            }
            this.f9738d.businessFinish(false);
            return passwordPrompt;
        }
    }

    public boolean returnBusiness(String str, byte[] bArr) throws BusinessException {
        String replace = FM_Int.replace(158, "甠逌這祴夛琄");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, new StringBuilder(String.valueOf(replace)).append(Util4Java.endsWith("}#)", 214, 90)).toString());
        }
        if (str == null || str.length() < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_CN.equals("斡ｄ畱扽俺恣丧穴", 4)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(CRCUtil.substring(1, "旸５伤兪皞厇攠彙幾")).toString(), ErrorMessage.local_business_para_error);
        } else if (bArr == null || bArr.length < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Long.copyValueOf("旿＊洸动髑讛攧挺乫稴", 1)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Utils.regionMatches(SyslogAppender.LOG_LOCAL3, 125, "旾）伢儺盘厛攦彑幨")).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Int.replace(3, "斮ｗ乄加夀琁寳豬个穩")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Exception.insert(3, 81, "旱ｔ专勻奏琚嘥刃姄卖夠货")).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Long.copyValueOf("旺％涎恬处瑛嘲乭種", 4)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Exception.insert(5, SpecialIssueType.BUG_TYPE_ID_CHARGE, "旿ｑ淙怪奝瑋嘩丯穳")).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String str2 = null;
            Configration configration = this.f9738d.getConfigration();
            if (configration != null) {
                str2 = configration.getCompanyCode();
            } else if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Bytes.concat("斯＃Ft?!4t{~!\"ny-乹稣", 2, 22)).toString());
            }
            if (str2 == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(BCCUtil.getChars("斣ｂ甯户戙屌啍扳丧穬", 5, 89)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Long.copyValueOf("旺％甮戴所尃唜扠乮稫", 4)).toString(), ErrorMessage.local_business_para_error);
            }
            String server4Business = this.f9738d.getServer4Business(TradeCode.TICKET_MANAGER);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(replace)).append(FM_Exception.insert(56, 103, "旪／莽厇奜琙皂幾厤奪赧")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Utils.regionMatches(64, SpecialIssueType.BUG_TYPE_ID_CHARGE, "旦（莯叚处瑒盌帯厠奵贽")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(replace, server4Business);
            boolean b = m13054b(str, str2, bArr, messageHandler, server4Business);
            this.f9738d.businessFinish(false);
            return b;
        }
    }

    public int setOrderStatus(byte[] bArr, EnumOrderType enumOrderType, byte[] bArr2, EnumOrderStatus enumOrderStatus) throws BusinessException {
        String substring = CRCUtil.substring(NFCBaseActivity.TO_ADD, "诩匃犷怍让罬");
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Utils.regionMatches(2, 26, "诰卙犰恁诤缺 &l"));
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, FM_Utils.regionMatches(2, 80, "诰北犤恃讬罬斤．么勣外瑄寫豣乨穸"));
            }
            throw new BusinessException(FM_Long.copyValueOf("讨卒犲怀诠缵斮ｙ么勮奈瑏嘮剞妋卋奫赲", 2), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, Util4Java.endsWith("讣卆狳怖请缵旻ｓ涙怬契琁嘱丱穧", 4, 50));
            }
            throw new BusinessException(FM_Int.replace(5, "诸匈状怂许罧旺＃涚恺夜琝噶主穾"), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.SET_ORDER_STATUS);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(substring)).append(BCCUtil.getChars("斸４菵叚奒瑆皎帧叮她贷", 94, 74)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(CRCUtil.substring(3, "旦７莱叇夘瑁盖帮厸奢赻")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9738d.businessReady(substring, server4Business);
        byte[] bArr3 = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.SET_ORDER_STATUS);
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    ITag createTag = messageHandler.createTag((byte) TagName.ACTIVITY_INFO);
                    createTag.addValue(bArr);
                    createMessage.addTag(createTag);
                }
            } catch (Exception e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(FM_Utils.regionMatches(FitnessSleepType.HW_FITNESS_SLEEP, 11, "诼匜狢恞讴罻时'枒遡帿厧讵氏攨捭弌帡>")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(FM_Exception.insert(346, 53, "诼卆狾恜讬缩旪}枂逻帣叵训汍攴挷夿赦"), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        if (enumOrderType != null) {
            createTag = messageHandler.createTag((byte) TagName.ORDER_TYPE);
            createTag.addValue(enumOrderType.getId());
            createMessage.addTag(createTag);
            if (bArr2 != null && bArr2.length > 0) {
                if (EnumOrderType.MAIN == enumOrderType) {
                    createTag = messageHandler.createTag((byte) TagName.MAIN_ORDER_ID);
                }
                if (EnumOrderType.BUSINESS == enumOrderType) {
                    createTag = messageHandler.createTag((byte) 17);
                }
                if (EnumOrderType.PAY == enumOrderType) {
                    createTag = messageHandler.createTag((byte) TagName.PAY_ORDER_ID);
                }
                createTag.addValue(bArr2);
                createMessage.addTag(createTag);
            }
            if (enumOrderStatus != null) {
                createTag = messageHandler.createTag((byte) TagName.ORDER_TRADE_STATUS);
                createTag.addValue(enumOrderStatus.getId());
                createMessage.addTag(createTag);
            }
        }
        bArr3 = createMessage.toBytes();
        bArr3 = this.f9738d.interaction(bArr3, FM_Exception.insert(2, 97, "认匒狾怈讴缥"), false, server4Business);
        byte[] copyOf = Arrays.copyOf(bArr3, 2);
        this.f9738d.businessFinish(false);
        if (Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
            return 0;
        }
        if (this.f9736b != null) {
            this.f9736b.error(this.f9737c, new StringBuilder(FM_Bytes.concat("读协犭恝诣罰早ｌ干史咎廐锜诩咊廜砈0k", 2, 33)).append(FM_Bytes.bytesToHexString(bArr3)).toString());
        }
        return FM_CN.bcdBytesToInt(copyOf);
    }

    public int terminalInfoBack(TerminalBackInfo terminalBackInfo) throws BusinessException {
        String concat = FM_Bytes.concat("纓窺侮怦厎駕", 4, 122);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Long.copyValueOf("绂竨俥恮厓駓v{|", 2));
        }
        if (terminalBackInfo == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("｟伧儾皋厁攧弉幧", 3, 52)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Exception.insert(4, 15, "＄伷兣皑历攣彀幩")).toString(), ErrorMessage.local_business_para_error);
        } else if (terminalBackInfo.getTitle() == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(Util4Java.endsWith("－伢儦盀叇敶彅幰", 4, 33)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("ｌ伴六盘叒整彚帴", 112, 84)).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(CRCUtil.substring(1, "＂七劥夋琜宼谱乡稼")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_CN.equals("ｔ乓勻奏琚噥刃姄化奠赧", 5)).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(FM_CN.equals("！涖恠处瑗嘪乩稾", 314)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_CN.equals("ｚ淏怷奍琜噣並穷", 3)).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(4001);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(CRCUtil.substring(4, "旧０莰叄夙瑎盗席厹奥赺")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_CN.equals("斣ｊ菠厞夝琌皟广厭奿赺", 2)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(concat, server4Business);
            byte[] bArr = null;
            IMessage createMessage = messageHandler.createMessage(4001);
            try {
                ITag createTag = messageHandler.createTag((byte) TagName.TERMINAL_BACK_CONTENT);
                createTag.addValue(terminalBackInfo.getTitle());
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) TagName.TERMINAL_BACK_INFO_TYPE);
                createTag.addValue(terminalBackInfo.getInfoType().getId());
                createMessage.addTag(createTag);
                if (terminalBackInfo.getOsVersion() != null && terminalBackInfo.getOsVersion().length() > 0) {
                    createTag = messageHandler.createTag((byte) TagName.TERMINAL_OS_VERSION);
                    createTag.addValue(terminalBackInfo.getOsVersion());
                    createMessage.addTag(createTag);
                }
                if (terminalBackInfo.getModelNumber() != null && terminalBackInfo.getModelNumber().length() > 1) {
                    createTag = messageHandler.createTag((byte) TagName.TERMINAL_MODEL_NUMBER);
                    createTag.addValue(terminalBackInfo.getModelNumber());
                    createMessage.addTag(createTag);
                }
                if (terminalBackInfo.getBasebandVersion() != null && terminalBackInfo.getBasebandVersion().length() > 1) {
                    createTag = messageHandler.createTag((byte) TagName.TERMINAL_BASEBAND_VERSION);
                    createTag.addValue(terminalBackInfo.getBasebandVersion());
                    createMessage.addTag(createTag);
                }
                if (terminalBackInfo.getAppVersion() != null && terminalBackInfo.getAppVersion().length() > 1) {
                    createTag = messageHandler.createTag((byte) TagName.SYSTEM_NEW_VERSION);
                    createTag.addValue(terminalBackInfo.getAppVersion());
                    createMessage.addTag(createTag);
                }
                if (terminalBackInfo.getId() != null && terminalBackInfo.getId().length > 1) {
                    ITag createTag2 = messageHandler.createTag((byte) 81);
                    createTag2.addValue(terminalBackInfo.getId());
                    createMessage.addTag(createTag2);
                }
                bArr = createMessage.toBytes();
            } catch (FMCommunicationMessageException e) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(concat)).append(CRCUtil.substring(274, "3枎逵帳去计氃攼挹开帵")).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(Util4Java.endsWith("r柁逬帠只讶汊政捸奬赡", 1, 71)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            bArr = this.f9738d.interaction(bArr, concat, false, server4Business);
            byte[] copyOf = Arrays.copyOf(bArr, 2);
            this.f9738d.businessFinish(false);
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
                return 0;
            }
            if (this.f9736b != null) {
                this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(concat)).append(CRCUtil.substring(2, "#６并叠哖廒镈讳咊廆硜23")).append(FM_Bytes.bytesToHexString(bArr)).toString());
            }
            return FM_CN.bcdBytesToInt(copyOf);
        }
    }

    public byte[] terminalInfoReport(int i, byte[] bArr) throws BusinessException {
        byte[] toBytes;
        Exception e;
        byte[] interaction;
        ITag tag4Id;
        String equals = FM_CN.equals("绅竱修息乛拧", 186);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9736b != null) {
            this.f9736b.info(this.f9737c, FM_Bytes.concat("纁窯俶恡丏抹=$/", 82, TagName.ELECTRONIC_USE_COUNT));
        }
        if (i <= 0) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Int.replace(6, "ｗ佾兤皀叅敺式帨")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Utils.regionMatches(4, 113, "ｘ佥儳盃叚敹弘帳")).toString(), ErrorMessage.local_business_para_error);
        } else if (bArr == null || bArr.length < 1) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith("ｓ伤公皊发敨弟帺", 2, 5)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Exception.insert(4, 120, "＄传儽盔厊攰彚幨")).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9738d == null) {
            if (this.f9736b == null) {
                this.f9736b = LogFactory.getInstance().getLog();
            }
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(BCCUtil.getChars("｟业勬奞琁宭豠临稡", 3, 45)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(BCCUtil.getChars("ｘ乖劥奘瑒噤则妗匂夽赡", 4, 88)).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9738d.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_Int.replace(SyslogAppender.LOG_LOCAL2, "）涀恤夊琗噼中穠")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("３淈怮夆琅嘬乿穼", 296, 33)).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String server4Business = this.f9738d.getServer4Business(4001);
            if (server4Business == null) {
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(5, "旤１莿叅多瑏盐帬厺奤败")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("斬ｃ菳厏奊瑅皜幾史夦贩", 3, 117)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9738d.businessReady(equals, server4Business);
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.TERMINAL_INFO_REPORT);
            try {
                ITag createTag = messageHandler.createTag((byte) TagName.TERMINAL_INFO_TYPE);
                createTag.addValue(i);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) TagName.PATCH_DATA);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
                toBytes = createMessage.toBytes();
                try {
                    System.out.println(new StringBuilder(FM_Bytes.concat("+;2}h!#&", 2, 101)).append(FM_Bytes.bytesToHexString(toBytes)).toString());
                } catch (FMCommunicationMessageException e2) {
                    e = e2;
                    if (this.f9736b != null) {
                        this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith("g柞適幫号诡汇攤挭彐幹*", FitnessSleepType.HW_FITNESS_SLEEP, 111)).append(Util4Java.getExceptionInfo(e)).toString());
                    }
                    this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith(",枘逸帧厠读汊攴挮奭贽", 3, 28)).toString(), ErrorMessage.local_message_message_handle_exception, false);
                    interaction = this.f9738d.interaction(toBytes, equals, false, server4Business);
                    if (!Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(interaction, 2))) {
                        if (this.f9736b != null) {
                            this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("｛帻厩咇序锕诲哃廋硑{r", 4)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                        }
                        this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("ｗ幻句夆琉夭赬", 4, 13)).toString(), ErrorMessage.local_message_platform_business_handle_fail, true);
                    }
                    toBytes = new byte[1];
                    if (interaction.length > 2) {
                        try {
                            tag4Id = messageHandler.createMessage(TradeCode.TERMINAL_INFO_REPORT, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(-76);
                            if (tag4Id != null) {
                                toBytes = tag4Id.getBytesVal();
                            }
                        } catch (FMCommunicationMessageException e3) {
                            if (this.f9736b != null) {
                                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(2, "＃觹枕幣叫咋廅攬挩彐幥２")).append(FM_Bytes.bytesToHexString(interaction)).toString());
                            }
                            this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Utils.regionMatches(4, 108, "ｘ覣柜幫叴哝廈攸挺奱贩")).toString(), ErrorMessage.local_message_command_data_invaild, false);
                        }
                    }
                    return toBytes;
                }
            } catch (Exception e4) {
                Exception exception = e4;
                toBytes = null;
                e = exception;
                if (this.f9736b != null) {
                    this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith("g柞適幫号诡汇攤挭彐幹*", FitnessSleepType.HW_FITNESS_SLEEP, 111)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith(",枘逸帧厠读汊攴挮奭贽", 3, 28)).toString(), ErrorMessage.local_message_message_handle_exception, false);
                interaction = this.f9738d.interaction(toBytes, equals, false, server4Business);
                if (Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(interaction, 2))) {
                    if (this.f9736b != null) {
                        this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("｛帻厩咇序锕诲哃廋硑{r", 4)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                    }
                    this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("ｗ幻句夆琉夭赬", 4, 13)).toString(), ErrorMessage.local_message_platform_business_handle_fail, true);
                }
                toBytes = new byte[1];
                if (interaction.length > 2) {
                    tag4Id = messageHandler.createMessage(TradeCode.TERMINAL_INFO_REPORT, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(-76);
                    if (tag4Id != null) {
                        toBytes = tag4Id.getBytesVal();
                    }
                }
                return toBytes;
            }
            interaction = this.f9738d.interaction(toBytes, equals, false, server4Business);
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(interaction, 2))) {
                if (this.f9736b != null) {
                    this.f9736b.error(this.f9737c, new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("｛帻厩咇序锕诲哃廋硑{r", 4)).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9738d.throwExceptionAndClose(new StringBuilder(String.valueOf(equals)).append(FM_Bytes.concat("ｗ幻句夆琉夭赬", 4, 13)).toString(), ErrorMessage.local_message_platform_business_handle_fail, true);
            }
            toBytes = new byte[1];
            if (interaction.length > 2) {
                tag4Id = messageHandler.createMessage(TradeCode.TERMINAL_INFO_REPORT, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(-76);
                if (tag4Id != null) {
                    toBytes = tag4Id.getBytesVal();
                }
            }
            return toBytes;
        }
    }

    public int updateStationInfo() throws BusinessException {
        String chars = BCCUtil.getChars("坲钍窏烹侫总暪斸", 210, 10);
        if (this.f9736b == null) {
            this.f9736b = LogFactory.getInstance().getLog();
        }
        if (this.f9738d == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(FM_Int.replace(4, "ｕ乆勾夆球寱豪临穫")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(Util4Java.endsWith("．乆劷夔瑌嘬刃妓卄夽责", 5, 90)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9738d.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(Util4Java.endsWith("．涛恫夑瑀嘿乲稣", 5, 17)).toString());
            }
            throw new BusinessException(FM_Bytes.concat("万劣讥匙枴说旭，淍急夋琒嘱乤稹", 70, 101), ErrorMessage.local_message_load_config_fail);
        }
        LocalDataHandler localDataHandler = this.f9738d.getLocalDataHandler();
        if (localDataHandler == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(FM_Bytes.concat("３朹坻攱挹変琅噱乵稿", 296, 22)).toString());
            }
            throw new BusinessException(Util4Java.endsWith("专勪讯匚柴讱旣｛朵坫敭挱夅瑅噭乽穳", 140, 66), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9738d.getServer4Business(TradeCode.QUERY_ORDER_VER2);
        if (server4Business == null) {
            if (this.f9736b != null) {
                this.f9736b.warn(this.f9737c, new StringBuilder(String.valueOf(chars)).append(FM_Long.copyValueOf("旽＄莲叔奛瑚盝帥厣奡赨", 3)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Exception.insert(2, 57, "旰３華叇奎琅盘幦厾夶赥")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        int a = m13034a(messageHandler, server4Business, localDataHandler);
        this.f9738d.businessReady(chars, server4Business);
        this.f9738d.businessFinish(false);
        return a;
    }
}
