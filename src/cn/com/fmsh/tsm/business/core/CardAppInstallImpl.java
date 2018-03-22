package cn.com.fmsh.tsm.business.core;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.IMessage;
import cn.com.fmsh.communication.message.IMessageHandler;
import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.TLVParse;
import cn.com.fmsh.communication.message.TLVParse.TagEntry;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.ScriptHandler;
import cn.com.fmsh.script.bean.ApduReponseList;
import cn.com.fmsh.script.bean.ApduRequestList;
import cn.com.fmsh.script.exception.FMScriptHandleException.ScriptHandleExceptionType;
import cn.com.fmsh.tsm.business.CardAppInstall;
import cn.com.fmsh.tsm.business.IssuerProcessHandler;
import cn.com.fmsh.tsm.business.bean.CardAppInfo;
import cn.com.fmsh.tsm.business.bean.IssuerPrepareResult;
import cn.com.fmsh.tsm.business.card.CardManagerFactory;
import cn.com.fmsh.tsm.business.card.base.CardManager;
import cn.com.fmsh.tsm.business.constants.Constants.RespCodeonse4Platform;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import cn.com.fmsh.tsm.business.enums.EnumAppManageOperateType;
import cn.com.fmsh.tsm.business.enums.EnumCardAppStatus;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.enums.EnumCardBusinessOpType;
import cn.com.fmsh.tsm.business.enums.EnumIssueProcess;
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
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.datatype.SportType;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import com.snowballtech.business.constant.BusinessCode;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.net.SyslogAppender;

public class CardAppInstallImpl implements CardAppInstall {
    private /* synthetic */ byte[] f9723a;
    private final /* synthetic */ int f9724b = 0;
    private final /* synthetic */ int f9725c = 1;
    private final /* synthetic */ int f9726d = 2;
    private final /* synthetic */ int f9727e = 3;
    private final /* synthetic */ byte[] f9728f;
    private /* synthetic */ int f9729g;
    private /* synthetic */ FMLog f9730h;
    private final /* synthetic */ String f9731i;
    private /* synthetic */ CardBusinessBasic f9732j;
    private /* synthetic */ boolean f9733k;
    private /* synthetic */ IssuerProcessHandler f9734l;

    public CardAppInstallImpl(CardBusinessBasic cardBusinessBasic) {
        byte[] bArr = new byte[32];
        bArr[30] = TagName.SYSTEM_VERSION;
        this.f9728f = bArr;
        this.f9729g = 0;
        this.f9730h = null;
        this.f9731i = CardAppInstallImpl.class.getName();
        this.f9732j = cardBusinessBasic;
        this.f9730h = LogFactory.getInstance().getLog();
    }

    private final /* synthetic */ boolean m13031a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws BusinessException {
        Exception e;
        ApduReponseList apduReponseList;
        byte[] interaction;
        Object obj;
        byte[] copyOf;
        byte[] copyOfRange;
        IMessage iMessage;
        ITag iTag;
        IMessage createMessage;
        Exception exception;
        Exception exception2;
        EnumIssueProcess instance;
        IMessage iMessage2;
        this.f9733k = false;
        int i2 = 0;
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(str)).append(FM_Long.copyValueOf("＇丒劤夆瑙宥谸乬稩", 3)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(str)).append(BCCUtil.getChars("｝乂勾夂琋噼分姉匟夡贲", 1, 7)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(str)).append(FM_CN.equals("ａ淖怠奄琗噪丩穾ｙ淎怸鄅罷斍仭劬輠奿赺", 122)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(str)).append(Util4Java.endsWith("．勸轳P\u001bW宜丕酟罦旙仢夻赥", 5, 86)).toString(), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9732j.getServer4Business(TradeCode.APP_ISSUER);
        if (server4Business == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(str)).append(Util4Java.endsWith("断｝菰压套瑏皛幦叻夰贲", 254, 118)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(str)).append(FM_Long.copyValueOf("於ｋ菳厗奚瑝盜带厢奾赩", 354)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        ITag createTag;
        ApduRequestList apduRequestList;
        ITag tag4Id;
        ITag tag4Id2;
        ITag tag4Id3;
        this.f9732j.businessReady(str, server4Business);
        ApduHandler apduHandler = this.f9732j.getApduHandler();
        if (apduHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.error(this.f9731i, FM_Long.copyValueOf("丄浼京速卣稥乱厈匷斥｜\f\u001a\u0003\u0011奅瑘嘳乢稯", 134));
            }
            this.f9732j.throwExceptionAndClose(FM_Int.replace(2, "九洭仹通卢穼两叝卮旤９误兓则捣卥皃讵闣斩弜>VQ^m\u000b\u000e\bg"), ErrorMessage.local_business_apdu_handler_null, false);
        }
        if (apduHandler.isConnect()) {
            if (this.f9730h != null) {
                this.f9730h.error(this.f9731i, FM_Exception.insert(3, 118, "不洪价道匾稯书厐卶旻／X_A\u000e奕瑁嘵欰徐"));
            }
            this.f9732j.throwExceptionAndClose(FM_Long.copyValueOf("万浽亣逞占稤乶厉匴斤ｃ\r\u0019\u0002\u0016奄瑛嘲欴徍", 5), ErrorMessage.local_business_apdu_handler_busying, false);
        } else {
            apduHandler.connect();
        }
        if (bArr2 == null || bArr2.length < 1) {
            bArr2 = new byte[0];
        }
        byte[] bArr4 = new byte[0];
        bArr4 = new byte[0];
        IMessage createMessage2 = messageHandler.createMessage((int) TradeCode.APP_ISSUER);
        try {
            ITag createTag2 = messageHandler.createTag((byte) TagName.SEID);
            createTag2.addValue(bArr2);
            createMessage2.addTag(createTag2);
            createTag2 = messageHandler.createTag((byte) TagName.APP_TYPE);
            createTag2.addValue(i);
            createMessage2.addTag(createTag2);
            createTag2 = messageHandler.createTag((byte) TagName.APP_AID);
            createTag2.addValue(bArr4);
            createMessage2.addTag(createTag2);
            createTag = messageHandler.createTag((byte) 17);
            createTag.addValue(bArr);
            createMessage2.addTag(createTag);
            if (bArr3 != null && bArr3.length > 0) {
                createTag = messageHandler.createTag((byte) TagName.PATCH_DATA);
                createTag.addValue(bArr);
                createMessage2.addTag(createTag);
            }
            bArr4 = createMessage2.toBytes();
            try {
                System.out.println(FM_Bytes.bytesToHexString(bArr4));
            } catch (FMCommunicationMessageException e2) {
                e = e2;
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Utils.regionMatches(240, 24, "乊洯亴递匡稢乽叙卡旮｜淀息夜琖嘠冺珨弒帰ｚ")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(FM_Long.copyValueOf("七浱产通匼稠乺厅匰斸ｇ淀怪奆瑙嘴冣珦彑幨", 1), ErrorMessage.local_message_message_handle_exception, true);
                apduReponseList = null;
                interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, FM_Bytes.concat("帪厮备琎丗劳诠汞夰责", 2, 5));
                }
                this.f9732j.throwExceptionAndClose(BCCUtil.getChars("乔勩夆琚无｜杠攲刮幫厢咁庒数捴", 350, 26), ErrorMessage.local_communication_no_response, true);
                obj = null;
                copyOf = Arrays.copyOf(interaction, 2);
                copyOfRange = Arrays.copyOfRange(interaction, 2, interaction.length);
                iMessage = null;
                while (Arrays.equals(RespCodeonse4Platform.CARD_REQUEST, copyOf)) {
                    if (this.f9733k) {
                        if (this.f9730h != null) {
                            this.f9730h.debug(this.f9731i, FM_Exception.insert(134, 67, "丐勬夔瑕无ｕ掹敩刲厓涀撆佒"));
                        }
                        this.f9732j.throwExceptionAndClose(FM_Bytes.concat("丕勧夙琒施ｎ掼敦剷又淝撁佟", SyslogAppender.LOG_LOCAL3, 87), ErrorMessage.local_business_cancel, true);
                    }
                    apduRequestList = new ApduRequestList();
                    iTag = null;
                    try {
                        createMessage = messageHandler.createMessage(interaction);
                        tag4Id = createMessage.getTag4Id(-96);
                        try {
                            iTag = createMessage.getTag4Id(-95);
                            try {
                                tag4Id2 = createMessage.getTag4Id(-90);
                                tag4Id3 = createMessage.getTag4Id(-89);
                                if (tag4Id3 != null) {
                                    i2 = tag4Id3.getBytesVal()[0] & 255;
                                }
                                createMessage = messageHandler.createMessage(9001);
                            } catch (Exception e3) {
                                exception = e3;
                                r2 = iTag;
                                iTag = tag4Id;
                                r5 = iMessage;
                                exception2 = exception;
                                if (this.f9730h != null) {
                                    this.f9730h.warn(FM_Long.copyValueOf("ggbV>;", 3), new StringBuilder(String.valueOf(str)).append(BCCUtil.getChars("覿柆帣厺咉床敨捼凶玶异帢.", 108, 122)).append(Util4Java.getExceptionInfo(exception2)).toString());
                                }
                                this.f9732j.throwExceptionAndClose(FM_Exception.insert(SpecialIssueType.BUG_TYPE_ID_CHARGE, 85, "覻柝幱厧咁底攦挥失走"), ErrorMessage.local_message_command_data_invaild, true);
                                createTag = r2;
                                createMessage = r5;
                                if (iTag != null) {
                                    obj = null;
                                } else {
                                    iTag = null;
                                }
                                if (createTag != null) {
                                    obj = 1;
                                } else {
                                    createTag = iTag;
                                }
                                apduRequestList.fromTag(createTag);
                                apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                                if (this.f9730h != null) {
                                    this.f9730h.warn(this.f9731i, FM_Exception.insert(5, 57, "专勣奟琒斻＊咒庌纂枖乹稦"));
                                }
                                this.f9732j.throwExceptionAndClose(Util4Java.endsWith("本坮戻蠖房蠚奥起", 3, TransportMediator.KEYCODE_MEDIA_PLAY), ErrorMessage.local_message_apdu_execute_exception, true);
                                if (this.f9729g == 0) {
                                    instance = EnumIssueProcess.instance(i2);
                                    if (this.f9730h != null) {
                                        this.f9730h.debug(this.f9731i, new StringBuilder(FM_Utils.regionMatches(2, 75, "辉庻递瞶2欬骰ｅ")).append(i2).toString());
                                    }
                                    this.f9734l.handle(instance);
                                }
                                bArr4 = null;
                                if (obj == null) {
                                    try {
                                        createMessage.addTag(apduReponseList.toTag4A2());
                                    } catch (Exception e4) {
                                        if (this.f9730h != null) {
                                            this.f9730h.warn(this.f9731i, new StringBuilder(CRCUtil.substring(2, "丕劻夁琖旭ｊ柕遼纏窽咐府散捰凳玤弝干o")).append(Util4Java.getExceptionInfo(e4)).toString());
                                        }
                                        this.f9732j.throwExceptionAndClose(FM_CN.equals("染遨帪厺诬汎敭捠奮赵", 4), ErrorMessage.local_message_message_handle_exception, true);
                                    }
                                } else {
                                    createMessage.addTag(apduReponseList.toTag4A3());
                                }
                                bArr4 = createMessage.toBytes();
                                if (this.f9730h != null) {
                                    this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("扤蠐寙戞'2|b$*x%u", 294, 89)).append(FM_Bytes.bytesToHexString(bArr4)).toString());
                                }
                                if (this.f9730h == null) {
                                    this.f9730h.debug(this.f9731i, FM_Utils.regionMatches(146, TagName.ELECTRONIC_USE_COUNT, "绊窶奔瑁寒扅｀厒逛夕琎绌枊绔幷厫|gn"));
                                }
                                interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
                                copyOf = Arrays.copyOf(interaction, 2);
                                iMessage2 = createMessage;
                                copyOfRange = Arrays.copyOfRange(interaction, 2, interaction.length);
                                iMessage = iMessage2;
                            }
                            try {
                                createMessage.addTag(tag4Id2);
                                createMessage.addTag(tag4Id3);
                                createTag = iTag;
                                iTag = tag4Id;
                            } catch (FMCommunicationMessageException e5) {
                                exception2 = e5;
                                ITag iTag2 = iTag;
                                iTag = tag4Id;
                                r5 = createMessage;
                                r2 = iTag2;
                                if (this.f9730h != null) {
                                    this.f9730h.warn(FM_Long.copyValueOf("ggbV>;", 3), new StringBuilder(String.valueOf(str)).append(BCCUtil.getChars("覿柆帣厺咉床敨捼凶玶异帢.", 108, 122)).append(Util4Java.getExceptionInfo(exception2)).toString());
                                }
                                this.f9732j.throwExceptionAndClose(FM_Exception.insert(SpecialIssueType.BUG_TYPE_ID_CHARGE, 85, "覻柝幱厧咁底攦挥失走"), ErrorMessage.local_message_command_data_invaild, true);
                                createTag = r2;
                                createMessage = r5;
                                if (iTag != null) {
                                    obj = null;
                                } else {
                                    iTag = null;
                                }
                                if (createTag != null) {
                                    obj = 1;
                                } else {
                                    createTag = iTag;
                                }
                                apduRequestList.fromTag(createTag);
                                apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                                if (this.f9730h != null) {
                                    this.f9730h.warn(this.f9731i, FM_Exception.insert(5, 57, "专勣奟琒斻＊咒庌纂枖乹稦"));
                                }
                                this.f9732j.throwExceptionAndClose(Util4Java.endsWith("本坮戻蠖房蠚奥起", 3, TransportMediator.KEYCODE_MEDIA_PLAY), ErrorMessage.local_message_apdu_execute_exception, true);
                                if (this.f9729g == 0) {
                                    instance = EnumIssueProcess.instance(i2);
                                    if (this.f9730h != null) {
                                        this.f9730h.debug(this.f9731i, new StringBuilder(FM_Utils.regionMatches(2, 75, "辉庻递瞶2欬骰ｅ")).append(i2).toString());
                                    }
                                    this.f9734l.handle(instance);
                                }
                                bArr4 = null;
                                if (obj == null) {
                                    createMessage.addTag(apduReponseList.toTag4A2());
                                } else {
                                    createMessage.addTag(apduReponseList.toTag4A3());
                                }
                                bArr4 = createMessage.toBytes();
                                if (this.f9730h != null) {
                                    this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("扤蠐寙戞'2|b$*x%u", 294, 89)).append(FM_Bytes.bytesToHexString(bArr4)).toString());
                                }
                                if (this.f9730h == null) {
                                    this.f9730h.debug(this.f9731i, FM_Utils.regionMatches(146, TagName.ELECTRONIC_USE_COUNT, "绊窶奔瑁寒扅｀厒逛夕琎绌枊绔幷厫|gn"));
                                }
                                interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
                                copyOf = Arrays.copyOf(interaction, 2);
                                iMessage2 = createMessage;
                                copyOfRange = Arrays.copyOfRange(interaction, 2, interaction.length);
                                iMessage = iMessage2;
                            }
                        } catch (Exception e32) {
                            exception = e32;
                            r2 = iTag;
                            iTag = tag4Id;
                            r5 = iMessage;
                            exception2 = exception;
                            if (this.f9730h != null) {
                                this.f9730h.warn(FM_Long.copyValueOf("ggbV>;", 3), new StringBuilder(String.valueOf(str)).append(BCCUtil.getChars("覿柆帣厺咉床敨捼凶玶异帢.", 108, 122)).append(Util4Java.getExceptionInfo(exception2)).toString());
                            }
                            this.f9732j.throwExceptionAndClose(FM_Exception.insert(SpecialIssueType.BUG_TYPE_ID_CHARGE, 85, "覻柝幱厧咁底攦挥失走"), ErrorMessage.local_message_command_data_invaild, true);
                            createTag = r2;
                            createMessage = r5;
                            if (iTag != null) {
                                obj = null;
                            } else {
                                iTag = null;
                            }
                            if (createTag != null) {
                                obj = 1;
                            } else {
                                createTag = iTag;
                            }
                            apduRequestList.fromTag(createTag);
                            apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                            if (this.f9730h != null) {
                                this.f9730h.warn(this.f9731i, FM_Exception.insert(5, 57, "专勣奟琒斻＊咒庌纂枖乹稦"));
                            }
                            this.f9732j.throwExceptionAndClose(Util4Java.endsWith("本坮戻蠖房蠚奥起", 3, TransportMediator.KEYCODE_MEDIA_PLAY), ErrorMessage.local_message_apdu_execute_exception, true);
                            if (this.f9729g == 0) {
                                instance = EnumIssueProcess.instance(i2);
                                if (this.f9730h != null) {
                                    this.f9730h.debug(this.f9731i, new StringBuilder(FM_Utils.regionMatches(2, 75, "辉庻递瞶2欬骰ｅ")).append(i2).toString());
                                }
                                this.f9734l.handle(instance);
                            }
                            bArr4 = null;
                            if (obj == null) {
                                createMessage.addTag(apduReponseList.toTag4A2());
                            } else {
                                createMessage.addTag(apduReponseList.toTag4A3());
                            }
                            bArr4 = createMessage.toBytes();
                            if (this.f9730h != null) {
                                this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("扤蠐寙戞'2|b$*x%u", 294, 89)).append(FM_Bytes.bytesToHexString(bArr4)).toString());
                            }
                            if (this.f9730h == null) {
                                this.f9730h.debug(this.f9731i, FM_Utils.regionMatches(146, TagName.ELECTRONIC_USE_COUNT, "绊窶奔瑁寒扅｀厒逛夕琎绌枊绔幷厫|gn"));
                            }
                            interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
                            copyOf = Arrays.copyOf(interaction, 2);
                            iMessage2 = createMessage;
                            copyOfRange = Arrays.copyOfRange(interaction, 2, interaction.length);
                            iMessage = iMessage2;
                        }
                    } catch (Exception e322) {
                        ITag iTag3;
                        IMessage iMessage3;
                        iMessage3 = iMessage;
                        exception2 = e322;
                        iTag3 = iTag;
                        iTag = null;
                        if (this.f9730h != null) {
                            this.f9730h.warn(FM_Long.copyValueOf("ggbV>;", 3), new StringBuilder(String.valueOf(str)).append(BCCUtil.getChars("覿柆帣厺咉床敨捼凶玶异帢.", 108, 122)).append(Util4Java.getExceptionInfo(exception2)).toString());
                        }
                        this.f9732j.throwExceptionAndClose(FM_Exception.insert(SpecialIssueType.BUG_TYPE_ID_CHARGE, 85, "覻柝幱厧咁底攦挥失走"), ErrorMessage.local_message_command_data_invaild, true);
                        createTag = iTag3;
                        createMessage = iMessage3;
                        if (iTag != null) {
                            iTag = null;
                        } else {
                            obj = null;
                        }
                        if (createTag != null) {
                            createTag = iTag;
                        } else {
                            obj = 1;
                        }
                        apduRequestList.fromTag(createTag);
                        apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                        if (this.f9730h != null) {
                            this.f9730h.warn(this.f9731i, FM_Exception.insert(5, 57, "专勣奟琒斻＊咒庌纂枖乹稦"));
                        }
                        this.f9732j.throwExceptionAndClose(Util4Java.endsWith("本坮戻蠖房蠚奥起", 3, TransportMediator.KEYCODE_MEDIA_PLAY), ErrorMessage.local_message_apdu_execute_exception, true);
                        if (this.f9729g == 0) {
                            instance = EnumIssueProcess.instance(i2);
                            if (this.f9730h != null) {
                                this.f9730h.debug(this.f9731i, new StringBuilder(FM_Utils.regionMatches(2, 75, "辉庻递瞶2欬骰ｅ")).append(i2).toString());
                            }
                            this.f9734l.handle(instance);
                        }
                        bArr4 = null;
                        if (obj == null) {
                            createMessage.addTag(apduReponseList.toTag4A3());
                        } else {
                            createMessage.addTag(apduReponseList.toTag4A2());
                        }
                        bArr4 = createMessage.toBytes();
                        if (this.f9730h != null) {
                            this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("扤蠐寙戞'2|b$*x%u", 294, 89)).append(FM_Bytes.bytesToHexString(bArr4)).toString());
                        }
                        if (this.f9730h == null) {
                            this.f9730h.debug(this.f9731i, FM_Utils.regionMatches(146, TagName.ELECTRONIC_USE_COUNT, "绊窶奔瑁寒扅｀厒逛夕琎绌枊绔幷厫|gn"));
                        }
                        interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
                        copyOf = Arrays.copyOf(interaction, 2);
                        iMessage2 = createMessage;
                        copyOfRange = Arrays.copyOfRange(interaction, 2, interaction.length);
                        iMessage = iMessage2;
                    }
                    if (iTag != null) {
                        iTag = null;
                    } else {
                        obj = null;
                    }
                    if (createTag != null) {
                        createTag = iTag;
                    } else {
                        obj = 1;
                    }
                    try {
                        apduRequestList.fromTag(createTag);
                    } catch (Exception exception22) {
                        if (this.f9730h != null) {
                            this.f9730h.warn(this.f9731i, new StringBuilder(FM_Bytes.concat("乃勴奕瑋斿ｉ帲厭咔廁盕攽挧覦柑弟帡／", 2, ReportInfoUtils.FEEDBACK_FAILED)).append(Util4Java.getExceptionInfo(exception22)).toString());
                        }
                        this.f9732j.throwExceptionAndClose(CRCUtil.substring(2, "幼只哈庄皟收挿覿柗奣赸"), ErrorMessage.local_communication_invalid_response, true);
                    } catch (Exception exception222) {
                        if (this.f9730h != null) {
                            this.f9730h.warn(this.f9731i, new StringBuilder(FM_Int.replace(360, "乇勡奇瑀斿｀帼厢咘廌盟攮捯觧林弈帵")).append(Util4Java.getExceptionInfo(exception222)).toString());
                        }
                        this.f9732j.throwExceptionAndClose(FM_Utils.regionMatches(2, 30, "帡叠哃廘盎數捨覧柒失贻"), ErrorMessage.local_communication_invalid_response, true);
                    }
                    try {
                        apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                    } catch (Exception exception2222) {
                        if (this.f9730h != null) {
                            this.f9730h.warn(this.f9731i, new StringBuilder(BCCUtil.getChars("乏勿夃琖旯．脑朸扺蠊况珨彃干i", 5, 9)).append(Util4Java.getExceptionInfo(exception2222)).toString());
                        }
                        if (exception2222 == null || ScriptHandleExceptionType.STOPED != exception2222.getType()) {
                            this.f9732j.throwExceptionAndClose(FM_Int.replace(5, "杶坭执衏扡衅夽贪"), ErrorMessage.local_message_apdu_execute_exception, true);
                        } else {
                            this.f9732j.throwExceptionAndClose(FM_Exception.insert(1, 53, "丟劻奋琂裲变淋"), ErrorMessage.local_business_cancel, true);
                        }
                    }
                    if (this.f9730h != null) {
                        this.f9730h.warn(this.f9731i, FM_Exception.insert(5, 57, "专勣奟琒斻＊咒庌纂枖乹稦"));
                    }
                    this.f9732j.throwExceptionAndClose(Util4Java.endsWith("本坮戻蠖房蠚奥起", 3, TransportMediator.KEYCODE_MEDIA_PLAY), ErrorMessage.local_message_apdu_execute_exception, true);
                    if (this.f9729g == 0) {
                        instance = EnumIssueProcess.instance(i2);
                        if (this.f9730h != null) {
                            this.f9730h.debug(this.f9731i, new StringBuilder(FM_Utils.regionMatches(2, 75, "辉庻递瞶2欬骰ｅ")).append(i2).toString());
                        }
                        this.f9734l.handle(instance);
                    }
                    bArr4 = null;
                    if (obj == null) {
                        createMessage.addTag(apduReponseList.toTag4A3());
                    } else {
                        createMessage.addTag(apduReponseList.toTag4A2());
                    }
                    bArr4 = createMessage.toBytes();
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("扤蠐寙戞'2|b$*x%u", 294, 89)).append(FM_Bytes.bytesToHexString(bArr4)).toString());
                    }
                    if (this.f9730h == null) {
                        this.f9730h.debug(this.f9731i, FM_Utils.regionMatches(146, TagName.ELECTRONIC_USE_COUNT, "绊窶奔瑁寒扅｀厒逛夕琎绌枊绔幷厫|gn"));
                    }
                    interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
                    copyOf = Arrays.copyOf(interaction, 2);
                    iMessage2 = createMessage;
                    copyOfRange = Arrays.copyOfRange(interaction, 2, interaction.length);
                    iMessage = iMessage2;
                }
                this.f9723a = interaction;
                this.f9732j.businessFinish(true);
                if (Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
                    if (this.f9730h != null) {
                        this.f9730h.warn(this.f9731i, new StringBuilder(FM_Bytes.concat("乁劦夗琙夺贲ｏ咂廏攷挽ｅ", 4, 12)).append(FM_Bytes.bytesToHexString(copyOf)).toString());
                    }
                    return false;
                } else if (copyOfRange.length >= 3) {
                    return true;
                } else {
                    if (TagName.BUSINESS_HANDLE_RESULT == copyOfRange[0]) {
                        if (this.f9730h != null) {
                            this.f9730h.warn(this.f9731i, FM_Exception.insert(5, 69, "专勯夗瑞宑扒＋杦扯剦够理纖枖盋@\u0018Y"));
                        }
                        return false;
                    } else if (copyOfRange[2] != (byte) 0) {
                        return true;
                    } else {
                        if (this.f9730h != null) {
                            this.f9730h.warn(this.f9731i, String.format(FM_Int.replace(106, "久勣奁瑎寇扞｝奐瑑纉柁失账],TR"), new Object[]{Byte.valueOf(copyOfRange[2])}));
                        }
                        return false;
                    }
                }
            }
        } catch (Exception exception22222) {
            exception = exception22222;
            bArr4 = null;
            e322 = exception;
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(FM_Utils.regionMatches(240, 24, "乊洯亴递匡稢乽叙卡旮｜淀息夜琖嘠冺珨弒帰ｚ")).append(Util4Java.getExceptionInfo(e322)).toString());
            }
            this.f9732j.throwExceptionAndClose(FM_Long.copyValueOf("七浱产通匼稠乺厅匰斸ｇ淀怪奆瑙嘴冣珦彑幨", 1), ErrorMessage.local_message_message_handle_exception, true);
            apduReponseList = null;
            interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Bytes.concat("帪厮备琎丗劳诠汞夰责", 2, 5));
            }
            this.f9732j.throwExceptionAndClose(BCCUtil.getChars("乔勩夆琚无｜杠攲刮幫厢咁庒数捴", 350, 26), ErrorMessage.local_communication_no_response, true);
            obj = null;
            copyOf = Arrays.copyOf(interaction, 2);
            copyOfRange = Arrays.copyOfRange(interaction, 2, interaction.length);
            iMessage = null;
            while (Arrays.equals(RespCodeonse4Platform.CARD_REQUEST, copyOf)) {
                if (this.f9733k) {
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, FM_Exception.insert(134, 67, "丐勬夔瑕无ｕ掹敩刲厓涀撆佒"));
                    }
                    this.f9732j.throwExceptionAndClose(FM_Bytes.concat("丕勧夙琒施ｎ掼敦剷又淝撁佟", SyslogAppender.LOG_LOCAL3, 87), ErrorMessage.local_business_cancel, true);
                }
                apduRequestList = new ApduRequestList();
                iTag = null;
                createMessage = messageHandler.createMessage(interaction);
                tag4Id = createMessage.getTag4Id(-96);
                iTag = createMessage.getTag4Id(-95);
                tag4Id2 = createMessage.getTag4Id(-90);
                tag4Id3 = createMessage.getTag4Id(-89);
                if (tag4Id3 != null) {
                    i2 = tag4Id3.getBytesVal()[0] & 255;
                }
                createMessage = messageHandler.createMessage(9001);
                createMessage.addTag(tag4Id2);
                createMessage.addTag(tag4Id3);
                createTag = iTag;
                iTag = tag4Id;
                if (iTag != null) {
                    iTag = null;
                } else {
                    obj = null;
                }
                if (createTag != null) {
                    createTag = iTag;
                } else {
                    obj = 1;
                }
                apduRequestList.fromTag(createTag);
                apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, FM_Exception.insert(5, 57, "专勣奟琒斻＊咒庌纂枖乹稦"));
                }
                this.f9732j.throwExceptionAndClose(Util4Java.endsWith("本坮戻蠖房蠚奥起", 3, TransportMediator.KEYCODE_MEDIA_PLAY), ErrorMessage.local_message_apdu_execute_exception, true);
                if (this.f9729g == 0) {
                    instance = EnumIssueProcess.instance(i2);
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, new StringBuilder(FM_Utils.regionMatches(2, 75, "辉庻递瞶2欬骰ｅ")).append(i2).toString());
                    }
                    this.f9734l.handle(instance);
                }
                bArr4 = null;
                if (obj == null) {
                    createMessage.addTag(apduReponseList.toTag4A3());
                } else {
                    createMessage.addTag(apduReponseList.toTag4A2());
                }
                bArr4 = createMessage.toBytes();
                if (this.f9730h != null) {
                    this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("扤蠐寙戞'2|b$*x%u", 294, 89)).append(FM_Bytes.bytesToHexString(bArr4)).toString());
                }
                if (this.f9730h == null) {
                    this.f9730h.debug(this.f9731i, FM_Utils.regionMatches(146, TagName.ELECTRONIC_USE_COUNT, "绊窶奔瑁寒扅｀厒逛夕琎绌枊绔幷厫|gn"));
                }
                interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
                copyOf = Arrays.copyOf(interaction, 2);
                iMessage2 = createMessage;
                copyOfRange = Arrays.copyOfRange(interaction, 2, interaction.length);
                iMessage = iMessage2;
            }
            this.f9723a = interaction;
            this.f9732j.businessFinish(true);
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Bytes.concat("乁劦夗琙夺贲ｏ咂廏攷挽ｅ", 4, 12)).append(FM_Bytes.bytesToHexString(copyOf)).toString());
                }
                return false;
            } else if (copyOfRange.length >= 3) {
                return true;
            } else {
                if (TagName.BUSINESS_HANDLE_RESULT == copyOfRange[0]) {
                    if (this.f9730h != null) {
                        this.f9730h.warn(this.f9731i, FM_Exception.insert(5, 69, "专勯夗瑞宑扒＋杦扯剦够理纖枖盋@\u0018Y"));
                    }
                    return false;
                } else if (copyOfRange[2] != (byte) 0) {
                    return true;
                } else {
                    if (this.f9730h != null) {
                        this.f9730h.warn(this.f9731i, String.format(FM_Int.replace(106, "久勣奁瑎寇扞｝奐瑑纉柁失账],TR"), new Object[]{Byte.valueOf(copyOfRange[2])}));
                    }
                    return false;
                }
            }
        }
        apduReponseList = null;
        interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
        if (interaction == null || interaction.length < 1) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Bytes.concat("帪厮备琎丗劳诠汞夰责", 2, 5));
            }
            this.f9732j.throwExceptionAndClose(BCCUtil.getChars("乔勩夆琚无｜杠攲刮幫厢咁庒数捴", 350, 26), ErrorMessage.local_communication_no_response, true);
        }
        obj = null;
        copyOf = Arrays.copyOf(interaction, 2);
        copyOfRange = Arrays.copyOfRange(interaction, 2, interaction.length);
        iMessage = null;
        while (Arrays.equals(RespCodeonse4Platform.CARD_REQUEST, copyOf)) {
            if (this.f9733k) {
                if (this.f9730h != null) {
                    this.f9730h.debug(this.f9731i, FM_Exception.insert(134, 67, "丐勬夔瑕无ｕ掹敩刲厓涀撆佒"));
                }
                this.f9732j.throwExceptionAndClose(FM_Bytes.concat("丕勧夙琒施ｎ掼敦剷又淝撁佟", SyslogAppender.LOG_LOCAL3, 87), ErrorMessage.local_business_cancel, true);
            }
            apduRequestList = new ApduRequestList();
            iTag = null;
            createMessage = messageHandler.createMessage(interaction);
            tag4Id = createMessage.getTag4Id(-96);
            iTag = createMessage.getTag4Id(-95);
            tag4Id2 = createMessage.getTag4Id(-90);
            tag4Id3 = createMessage.getTag4Id(-89);
            if (tag4Id3 != null) {
                i2 = tag4Id3.getBytesVal()[0] & 255;
            }
            createMessage = messageHandler.createMessage(9001);
            createMessage.addTag(tag4Id2);
            createMessage.addTag(tag4Id3);
            createTag = iTag;
            iTag = tag4Id;
            if (iTag != null) {
                obj = null;
            } else {
                iTag = null;
            }
            if (createTag != null) {
                obj = 1;
            } else {
                createTag = iTag;
            }
            apduRequestList.fromTag(createTag);
            apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
            if (apduReponseList == null || apduReponseList.size() < 1) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, FM_Exception.insert(5, 57, "专勣奟琒斻＊咒庌纂枖乹稦"));
                }
                this.f9732j.throwExceptionAndClose(Util4Java.endsWith("本坮戻蠖房蠚奥起", 3, TransportMediator.KEYCODE_MEDIA_PLAY), ErrorMessage.local_message_apdu_execute_exception, true);
            }
            if (this.f9729g == 0) {
                instance = EnumIssueProcess.instance(i2);
                if (!(this.f9734l == null || instance == null)) {
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, new StringBuilder(FM_Utils.regionMatches(2, 75, "辉庻递瞶2欬骰ｅ")).append(i2).toString());
                    }
                    this.f9734l.handle(instance);
                }
            }
            bArr4 = null;
            if (obj == null) {
                createMessage.addTag(apduReponseList.toTag4A2());
            } else {
                createMessage.addTag(apduReponseList.toTag4A3());
            }
            bArr4 = createMessage.toBytes();
            if (this.f9730h != null) {
                this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("扤蠐寙戞'2|b$*x%u", 294, 89)).append(FM_Bytes.bytesToHexString(bArr4)).toString());
            }
            if (this.f9730h == null) {
                this.f9730h.debug(this.f9731i, FM_Utils.regionMatches(146, TagName.ELECTRONIC_USE_COUNT, "绊窶奔瑁寒扅｀厒逛夕琎绌枊绔幷厫|gn"));
            }
            interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
            copyOf = Arrays.copyOf(interaction, 2);
            iMessage2 = createMessage;
            copyOfRange = Arrays.copyOfRange(interaction, 2, interaction.length);
            iMessage = iMessage2;
        }
        this.f9723a = interaction;
        this.f9732j.businessFinish(true);
        if (Arrays.equals(RespCodeonse4Platform.SUCESS, copyOf)) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(FM_Bytes.concat("乁劦夗琙夺贲ｏ咂廏攷挽ｅ", 4, 12)).append(FM_Bytes.bytesToHexString(copyOf)).toString());
            }
            return false;
        } else if (copyOfRange.length >= 3) {
            return true;
        } else {
            if (TagName.BUSINESS_HANDLE_RESULT == copyOfRange[0]) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, FM_Exception.insert(5, 69, "专勯夗瑞宑扒＋杦扯剦够理纖枖盋@\u0018Y"));
                }
                return false;
            } else if (copyOfRange[2] != (byte) 0) {
                return true;
            } else {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, String.format(FM_Int.replace(106, "久勣奁瑎寇扞｝奐瑑纉柁失账],TR"), new Object[]{Byte.valueOf(copyOfRange[2])}));
                }
                return false;
            }
        }
    }

    private final /* synthetic */ byte[] m13032a(byte[] bArr, String str, IMessageHandler iMessageHandler, String str2) throws BusinessException {
        IMessage createMessage;
        ITag tag4Id;
        int i;
        IMessage iMessage;
        Exception exception;
        ITag iTag;
        ITag iTag2;
        ITag iTag3;
        Object obj;
        ITag iTag4;
        EnumIssueProcess instance;
        byte[] bArr2;
        IMessage iMessage2;
        this.f9733k = false;
        int i2 = 0;
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(str)).append(CRCUtil.substring(1, "＂七劥夋琜宼谱乡稼")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(str)).append(FM_CN.equals("ｙ乜勶奌琟噢分姇卋奿赺", 2)).toString(), ErrorMessage.local_business_init_fail);
        }
        this.f9732j.businessReady(str, str2);
        ApduHandler apduHandler = this.f9732j.getApduHandler();
        if (apduHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.error(this.f9731i, FM_Exception.insert(6, 86, "丐勡夒琊斴４O\u0014^E奂琚噺乲穤"));
            }
            this.f9732j.throwExceptionAndClose(CRCUtil.substring(3, "业浬亢逋卽稽乿厌匩斥ｒ课兜刘捨却盄说閸旸彃M@Y,@_\u0007f"), ErrorMessage.local_business_apdu_handler_null, false);
        }
        if (apduHandler.isConnect()) {
            if (this.f9730h != null) {
                this.f9730h.error(this.f9731i, FM_CN.equals("乍勩奝瑌旭＀\\^\u001b\u0005奅瑔嘫歷応", 4));
            }
            this.f9732j.throwExceptionAndClose(FM_Long.copyValueOf("丆浾亢這卡稧乷历匵斧ｂ\n\u0018\u0001\u0017奛瑚嘱欵徊", 4), ErrorMessage.local_business_apdu_handler_busying, false);
        } else {
            apduHandler.connect();
        }
        ApduReponseList apduReponseList = null;
        byte[] interaction = this.f9732j.interaction(bArr, str, true, str2);
        if (interaction == null || interaction.length < 1) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, CRCUtil.substring(252, "幺古夛琌丏勡讼气奰赩"));
            }
            this.f9732j.throwExceptionAndClose(FM_CN.equals("乎勤奒瑁旮％朰攽剬帾厮咂廔敡捬", 1), ErrorMessage.local_communication_no_response, true);
        }
        Object obj2 = null;
        byte[] copyOf = Arrays.copyOf(interaction, 2);
        IMessage iMessage3 = null;
        while (Arrays.equals(RespCodeonse4Platform.CARD_REQUEST, copyOf)) {
            if (this.f9733k) {
                this.f9732j.throwExceptionAndClose(Util4Java.endsWith("丙务夙瑜斡８掴數剻叞涍撏伃", 6, 29), ErrorMessage.local_business_cancel, true);
            }
            ApduRequestList apduRequestList = new ApduRequestList();
            ITag iTag5 = null;
            try {
                ITag tag4Id2;
                ITag tag4Id3;
                createMessage = iMessageHandler.createMessage(interaction);
                iTag5 = createMessage.getTag4Id(-96);
                try {
                    tag4Id = createMessage.getTag4Id(-95);
                    try {
                        tag4Id2 = createMessage.getTag4Id(-90);
                        tag4Id3 = createMessage.getTag4Id(-89);
                        if (tag4Id3 != null) {
                            i2 = FM_CN.bcdBytesToInt(new byte[]{tag4Id3.getBytesVal()[0]});
                        }
                        createMessage = iMessageHandler.createMessage(9001);
                    } catch (Exception e) {
                        i = i2;
                        iMessage = iMessage3;
                        exception = e;
                        iTag = tag4Id;
                        tag4Id = iTag5;
                        if (this.f9730h != null) {
                            this.f9730h.warn(FM_CN.equals("4&=\u001f}j", 5), new StringBuilder(String.valueOf(str)).append(FM_Utils.regionMatches(5, 117, "覶柚帬厤咄床散捦凧玢弅幤k")).append(Util4Java.getExceptionInfo(exception)).toString());
                        }
                        this.f9732j.throwExceptionAndClose(Util4Java.endsWith("覼柇幼号咒広敿挩央贲", 2, 88), ErrorMessage.local_message_command_data_invaild, true);
                        iTag2 = iTag;
                        createMessage = iMessage;
                        i2 = i;
                        if (tag4Id != null) {
                            iTag3 = tag4Id;
                            obj = null;
                            iTag4 = iTag3;
                        } else {
                            obj = obj2;
                            iTag4 = null;
                        }
                        if (iTag2 != null) {
                            obj2 = 1;
                        } else {
                            iTag2 = iTag4;
                            obj2 = obj;
                        }
                        apduRequestList.fromTag(iTag2);
                        apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                        if (this.f9730h != null) {
                            this.f9730h.warn(this.f9731i, FM_Exception.insert(4, 98, "丒勫奈琈旦～咙庂绋柆书穤"));
                        }
                        this.f9732j.throwExceptionAndClose(FM_Int.replace(4, "杵坬戸衎扢衄夺贫"), ErrorMessage.local_message_apdu_execute_exception, true);
                        if (this.f9729g == 0) {
                            instance = EnumIssueProcess.instance(i2);
                            if (this.f9730h != null) {
                                this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("迚庨送短9欧髫ｆ", 4, 13)).append(i2).toString());
                            }
                            this.f9734l.handle(instance);
                        }
                        bArr2 = null;
                        if (obj2 == null) {
                            try {
                                createMessage.addTag(apduReponseList.toTag4A2());
                            } catch (FMCommunicationMessageException e2) {
                                if (this.f9730h != null) {
                                    this.f9730h.warn(this.f9731i, FM_Exception.insert(252, 47, "业劮奚琋旪ｇ枞適纐竨咛庑敤挭凨珱归帧"));
                                }
                                this.f9732j.throwExceptionAndClose(FM_Long.copyValueOf("枌逥幱可诫汛敦捽夡质", SyslogAppender.LOG_LOCAL4), ErrorMessage.local_message_message_handle_exception, true);
                            }
                        } else {
                            createMessage.addTag(apduReponseList.toTag4A3());
                        }
                        bArr2 = createMessage.toBytes();
                        if (this.f9730h != null) {
                            this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("戢蠊寋托i8.<\" *#k", 104, 1)).append(FM_Bytes.bytesToHexString(bArr2)).toString());
                        }
                        if (this.f9730h != null) {
                            this.f9730h.debug(this.f9731i, FM_CN.equals("绗竿夅瑔寏扄ｉ叇逆夜琏纉柗纅帾叮!.?", 300));
                        }
                        interaction = this.f9732j.interaction(bArr2, str, true, str2);
                        iMessage2 = createMessage;
                        copyOf = Arrays.copyOf(interaction, 2);
                        iMessage3 = iMessage2;
                    }
                } catch (Exception e3) {
                    tag4Id = iTag5;
                    i = i2;
                    iMessage = iMessage3;
                    exception = e3;
                    iTag = null;
                    if (this.f9730h != null) {
                        this.f9730h.warn(FM_CN.equals("4&=\u001f}j", 5), new StringBuilder(String.valueOf(str)).append(FM_Utils.regionMatches(5, 117, "覶柚帬厤咄床散捦凧玢弅幤k")).append(Util4Java.getExceptionInfo(exception)).toString());
                    }
                    this.f9732j.throwExceptionAndClose(Util4Java.endsWith("覼柇幼号咒広敿挩央贲", 2, 88), ErrorMessage.local_message_command_data_invaild, true);
                    iTag2 = iTag;
                    createMessage = iMessage;
                    i2 = i;
                    if (tag4Id != null) {
                        obj = obj2;
                        iTag4 = null;
                    } else {
                        iTag3 = tag4Id;
                        obj = null;
                        iTag4 = iTag3;
                    }
                    if (iTag2 != null) {
                        iTag2 = iTag4;
                        obj2 = obj;
                    } else {
                        obj2 = 1;
                    }
                    apduRequestList.fromTag(iTag2);
                    apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                    if (this.f9730h != null) {
                        this.f9730h.warn(this.f9731i, FM_Exception.insert(4, 98, "丒勫奈琈旦～咙庂绋柆书穤"));
                    }
                    this.f9732j.throwExceptionAndClose(FM_Int.replace(4, "杵坬戸衎扢衄夺贫"), ErrorMessage.local_message_apdu_execute_exception, true);
                    if (this.f9729g == 0) {
                        instance = EnumIssueProcess.instance(i2);
                        if (this.f9730h != null) {
                            this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("迚庨送短9欧髫ｆ", 4, 13)).append(i2).toString());
                        }
                        this.f9734l.handle(instance);
                    }
                    bArr2 = null;
                    if (obj2 == null) {
                        createMessage.addTag(apduReponseList.toTag4A3());
                    } else {
                        createMessage.addTag(apduReponseList.toTag4A2());
                    }
                    bArr2 = createMessage.toBytes();
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("戢蠊寋托i8.<\" *#k", 104, 1)).append(FM_Bytes.bytesToHexString(bArr2)).toString());
                    }
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, FM_CN.equals("绗竿夅瑔寏扄ｉ叇逆夜琏纉柗纅帾叮!.?", 300));
                    }
                    interaction = this.f9732j.interaction(bArr2, str, true, str2);
                    iMessage2 = createMessage;
                    copyOf = Arrays.copyOf(interaction, 2);
                    iMessage3 = iMessage2;
                }
                try {
                    createMessage.addTag(tag4Id2);
                    createMessage.addTag(tag4Id3);
                    iTag2 = tag4Id;
                    tag4Id = iTag5;
                } catch (FMCommunicationMessageException e4) {
                    exception = e4;
                    i = i2;
                    iMessage = createMessage;
                    iTag = tag4Id;
                    tag4Id = iTag5;
                    if (this.f9730h != null) {
                        this.f9730h.warn(FM_CN.equals("4&=\u001f}j", 5), new StringBuilder(String.valueOf(str)).append(FM_Utils.regionMatches(5, 117, "覶柚帬厤咄床散捦凧玢弅幤k")).append(Util4Java.getExceptionInfo(exception)).toString());
                    }
                    this.f9732j.throwExceptionAndClose(Util4Java.endsWith("覼柇幼号咒広敿挩央贲", 2, 88), ErrorMessage.local_message_command_data_invaild, true);
                    iTag2 = iTag;
                    createMessage = iMessage;
                    i2 = i;
                    if (tag4Id != null) {
                        iTag3 = tag4Id;
                        obj = null;
                        iTag4 = iTag3;
                    } else {
                        obj = obj2;
                        iTag4 = null;
                    }
                    if (iTag2 != null) {
                        obj2 = 1;
                    } else {
                        iTag2 = iTag4;
                        obj2 = obj;
                    }
                    apduRequestList.fromTag(iTag2);
                    apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                    if (this.f9730h != null) {
                        this.f9730h.warn(this.f9731i, FM_Exception.insert(4, 98, "丒勫奈琈旦～咙庂绋柆书穤"));
                    }
                    this.f9732j.throwExceptionAndClose(FM_Int.replace(4, "杵坬戸衎扢衄夺贫"), ErrorMessage.local_message_apdu_execute_exception, true);
                    if (this.f9729g == 0) {
                        instance = EnumIssueProcess.instance(i2);
                        if (this.f9730h != null) {
                            this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("迚庨送短9欧髫ｆ", 4, 13)).append(i2).toString());
                        }
                        this.f9734l.handle(instance);
                    }
                    bArr2 = null;
                    if (obj2 == null) {
                        createMessage.addTag(apduReponseList.toTag4A2());
                    } else {
                        createMessage.addTag(apduReponseList.toTag4A3());
                    }
                    bArr2 = createMessage.toBytes();
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("戢蠊寋托i8.<\" *#k", 104, 1)).append(FM_Bytes.bytesToHexString(bArr2)).toString());
                    }
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, FM_CN.equals("绗竿夅瑔寏扄ｉ叇逆夜琏纉柗纅帾叮!.?", 300));
                    }
                    interaction = this.f9732j.interaction(bArr2, str, true, str2);
                    iMessage2 = createMessage;
                    copyOf = Arrays.copyOf(interaction, 2);
                    iMessage3 = iMessage2;
                }
            } catch (Exception e32) {
                tag4Id = iTag5;
                i = i2;
                iMessage = iMessage3;
                exception = e32;
                iTag = null;
                if (this.f9730h != null) {
                    this.f9730h.warn(FM_CN.equals("4&=\u001f}j", 5), new StringBuilder(String.valueOf(str)).append(FM_Utils.regionMatches(5, 117, "覶柚帬厤咄床散捦凧玢弅幤k")).append(Util4Java.getExceptionInfo(exception)).toString());
                }
                this.f9732j.throwExceptionAndClose(Util4Java.endsWith("覼柇幼号咒広敿挩央贲", 2, 88), ErrorMessage.local_message_command_data_invaild, true);
                iTag2 = iTag;
                createMessage = iMessage;
                i2 = i;
                if (tag4Id != null) {
                    obj = obj2;
                    iTag4 = null;
                } else {
                    iTag3 = tag4Id;
                    obj = null;
                    iTag4 = iTag3;
                }
                if (iTag2 != null) {
                    iTag2 = iTag4;
                    obj2 = obj;
                } else {
                    obj2 = 1;
                }
                apduRequestList.fromTag(iTag2);
                apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, FM_Exception.insert(4, 98, "丒勫奈琈旦～咙庂绋柆书穤"));
                }
                this.f9732j.throwExceptionAndClose(FM_Int.replace(4, "杵坬戸衎扢衄夺贫"), ErrorMessage.local_message_apdu_execute_exception, true);
                if (this.f9729g == 0) {
                    instance = EnumIssueProcess.instance(i2);
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("迚庨送短9欧髫ｆ", 4, 13)).append(i2).toString());
                    }
                    this.f9734l.handle(instance);
                }
                bArr2 = null;
                if (obj2 == null) {
                    createMessage.addTag(apduReponseList.toTag4A3());
                } else {
                    createMessage.addTag(apduReponseList.toTag4A2());
                }
                bArr2 = createMessage.toBytes();
                if (this.f9730h != null) {
                    this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("戢蠊寋托i8.<\" *#k", 104, 1)).append(FM_Bytes.bytesToHexString(bArr2)).toString());
                }
                if (this.f9730h != null) {
                    this.f9730h.debug(this.f9731i, FM_CN.equals("绗竿夅瑔寏扄ｉ叇逆夜琏纉柗纅帾叮!.?", 300));
                }
                interaction = this.f9732j.interaction(bArr2, str, true, str2);
                iMessage2 = createMessage;
                copyOf = Arrays.copyOf(interaction, 2);
                iMessage3 = iMessage2;
            }
            if (tag4Id != null) {
                iTag3 = tag4Id;
                obj = null;
                iTag4 = iTag3;
            } else {
                obj = obj2;
                iTag4 = null;
            }
            if (iTag2 != null) {
                obj2 = 1;
            } else {
                iTag2 = iTag4;
                obj2 = obj;
            }
            try {
                apduRequestList.fromTag(iTag2);
            } catch (Exception exception2) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Long.copyValueOf("乖勨奂瑅斶１幩叧哙庅皊敻捦触枒弝帤＃", 196)).append(Util4Java.getExceptionInfo(exception2)).toString());
                }
                this.f9732j.throwExceptionAndClose(CRCUtil.substring(274, "幬叺哘廔盏攦振覯柇夳质"), ErrorMessage.local_communication_invalid_response, true);
            } catch (Exception exception22) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Exception.insert(2, 22, "东劽外瑎斨ｘ幹台哛廘盆攨捠觧枊归幾")).append(Util4Java.getExceptionInfo(exception22)).toString());
                }
                this.f9732j.throwExceptionAndClose(FM_Bytes.concat("帨只咔庌盓敦挻觷柃夣赴", 4, 63), ErrorMessage.local_communication_invalid_response, true);
            }
            try {
                apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
            } catch (Exception exception222) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Exception.insert(5, 21, "专势夗瑎斫～脝朰扶蠊冡珠弇帢5")).append(Util4Java.getExceptionInfo(exception222)).toString());
                }
                if (exception222 == null || ScriptHandleExceptionType.STOPED != exception222.getType()) {
                    this.f9732j.throwExceptionAndClose(FM_Long.copyValueOf("朡场扠衈扦蠒奪赽", 5), ErrorMessage.local_message_apdu_execute_exception, true);
                } else {
                    this.f9732j.throwExceptionAndClose(FM_Utils.regionMatches(5, 102, "乏勺奅琁袦厅淑"), ErrorMessage.local_business_cancel, true);
                }
            }
            if (apduReponseList == null || apduReponseList.size() < 1) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, FM_Exception.insert(4, 98, "丒勫奈琈旦～咙庂绋柆书穤"));
                }
                this.f9732j.throwExceptionAndClose(FM_Int.replace(4, "杵坬戸衎扢衄夺贫"), ErrorMessage.local_message_apdu_execute_exception, true);
            }
            if (this.f9729g == 0) {
                instance = EnumIssueProcess.instance(i2);
                if (!(this.f9734l == null || instance == null)) {
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("迚庨送短9欧髫ｆ", 4, 13)).append(i2).toString());
                    }
                    this.f9734l.handle(instance);
                }
            }
            bArr2 = null;
            if (obj2 == null) {
                createMessage.addTag(apduReponseList.toTag4A2());
            } else {
                createMessage.addTag(apduReponseList.toTag4A3());
            }
            bArr2 = createMessage.toBytes();
            if (this.f9730h != null) {
                this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("戢蠊寋托i8.<\" *#k", 104, 1)).append(FM_Bytes.bytesToHexString(bArr2)).toString());
            }
            if (this.f9730h != null) {
                this.f9730h.debug(this.f9731i, FM_CN.equals("绗竿夅瑔寏扄ｉ叇逆夜琏纉柗纅帾叮!.?", 300));
            }
            interaction = this.f9732j.interaction(bArr2, str, true, str2);
            iMessage2 = createMessage;
            copyOf = Arrays.copyOf(interaction, 2);
            iMessage3 = iMessage2;
        }
        this.f9732j.businessFinish(true);
        return interaction;
    }

    private final /* synthetic */ boolean m13033b(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, String str) throws BusinessException {
        IMessage createMessage;
        int i2;
        IMessage iMessage;
        Exception exception;
        Object obj;
        ITag iTag;
        ITag iTag2;
        EnumIssueProcess instance;
        IMessage iMessage2;
        this.f9733k = false;
        int i3 = 0;
        byte[] bArr4 = null;
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(str)).append(FM_Int.replace(162, "；一劼处琅寿豨丶穵")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(str)).append(BCCUtil.getChars("ｙ久动夗琛噯刌姐卓奾赼", 5, 10)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(str)).append(FM_Exception.insert(154, 41, "２淏怿夝瑄嘣丮穧ｊ涇恷鄌罤斔亪劥轳奦败")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(str)).append(FM_Long.copyValueOf("＆劧轹U_\\宂乜酟罡斋仿夷账", 162)).toString(), ErrorMessage.local_message_load_config_fail);
        }
        String server4Business = this.f9732j.getServer4Business(TradeCode.APP_ISSUER_VER2);
        if (server4Business == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(str)).append(FM_Utils.regionMatches(5, 113, "斣ｊ菠厞夝琌皟广厭奿赺")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(str)).append(BCCUtil.getChars("无ｈ菥厖奊瑚皎幫叶夥赧", 198, 14)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        ITag createTag;
        this.f9732j.businessReady(str, server4Business);
        ApduHandler apduHandler = this.f9732j.getApduHandler();
        if (apduHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.error(this.f9731i, FM_CN.equals("也洱仳遒卸穰丶叝匼斸ｓ\u0011\u0011VV夐球嘾乽稢", 2));
            }
            this.f9732j.throwExceptionAndClose(FM_Utils.regionMatches(5, 70, "也浬亥遝卬稩临厎卤施＝讠兕刄挫卮监认閯斾彂;\u0016RDd_\u0011^j"), ErrorMessage.local_business_apdu_handler_null, false);
        }
        if (apduHandler.isConnect()) {
            if (this.f9730h != null) {
                this.f9730h.error(this.f9731i, BCCUtil.getChars("乞浧仨递匥空乱叉匵旦｀I\u0014DI奜琒嘸歯徑", 4, 60));
            }
            this.f9732j.throwExceptionAndClose(FM_Long.copyValueOf("丁浿亡逘匾稦乴厇匲斦ａ\u000b\u0017\u0000\u0014奚瑝嘰欶律", 3), ErrorMessage.local_business_apdu_handler_busying, false);
        } else {
            apduHandler.connect();
        }
        if (bArr2 == null || bArr2.length < 1) {
            bArr2 = new byte[0];
        }
        byte[] bArr5 = new byte[0];
        bArr5 = new byte[0];
        IMessage createMessage2 = messageHandler.createMessage((int) TradeCode.APP_ISSUER_VER2);
        try {
            ITag createTag2 = messageHandler.createTag((byte) TagName.SEID);
            createTag2.addValue(bArr2);
            createMessage2.addTag(createTag2);
            createTag2 = messageHandler.createTag((byte) TagName.APP_TYPE);
            createTag2.addValue(i);
            createMessage2.addTag(createTag2);
            createTag2 = messageHandler.createTag((byte) TagName.APP_AID);
            createTag2.addValue(bArr5);
            createMessage2.addTag(createTag2);
            createTag = messageHandler.createTag((byte) 17);
            createTag.addValue(bArr);
            createMessage2.addTag(createTag);
            if (bArr3 != null && bArr3.length > 0) {
                createTag = messageHandler.createTag((byte) TagName.PATCH_DATA);
                createTag.addValue(bArr);
                createMessage2.addTag(createTag);
            }
            bArr4 = createMessage2.toBytes();
        } catch (Exception e) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(CRCUtil.substring(3, "业浬亢逋卽稽乿厌匩斥ｒ涁恻夛琌噽冺珻彔幹ｖ")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9732j.throwExceptionAndClose(FM_Int.replace(3, "乒洬仺逛卥穽丧叜危日：涑恳夛琄噭凲玻弌帩"), ErrorMessage.local_message_message_handle_exception, true);
        }
        ApduReponseList apduReponseList = null;
        byte[] interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
        if (interaction == null || interaction.length < 1) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Bytes.concat("帪司夓琀丏勥认氀奠败", 2, 15));
            }
            this.f9732j.throwExceptionAndClose(BCCUtil.getChars("乎劢外琇旦３杤敫剼帨叺哔府敧挨", 4, 15), ErrorMessage.local_communication_no_response, true);
        }
        Object obj2 = null;
        bArr5 = Arrays.copyOf(interaction, 2);
        IMessage iMessage3 = null;
        while (Arrays.equals(RespCodeonse4Platform.CARD_REQUEST, bArr5)) {
            ITag iTag3;
            if (this.f9733k) {
                if (this.f9730h != null) {
                    this.f9730h.debug(this.f9731i, CRCUtil.substring(5, "丈劼夌琕旨ｅ揱敩剺厃消擆佊"));
                }
                this.f9732j.throwExceptionAndClose(FM_Long.copyValueOf("丑助夁琄斩ｐ揼敠剣历淅撇伛", 3), ErrorMessage.local_business_cancel, true);
            }
            ApduRequestList apduRequestList = new ApduRequestList();
            ITag iTag4 = null;
            try {
                createMessage = messageHandler.createMessage(interaction);
                iTag4 = createMessage.getTag4Id(-96);
                try {
                    createTag2 = createMessage.getTag4Id(-95);
                } catch (Exception e2) {
                    createTag2 = iTag4;
                    i2 = i3;
                    iMessage = iMessage3;
                    exception = e2;
                    createTag = null;
                    if (this.f9730h != null) {
                        this.f9730h.warn(Util4Java.endsWith("2uq\u0006/m", 1, 28), new StringBuilder(String.valueOf(str)).append(FM_CN.equals("覶柖帤厸哔庞敫换冧現彝幨{", 2)).append(Util4Java.getExceptionInfo(exception)).toString());
                    }
                    this.f9732j.throwExceptionAndClose(FM_Utils.regionMatches(5, 75, "覶某幸厦哌廘敧捬奼贽"), ErrorMessage.local_message_command_data_invaild, true);
                    iTag3 = createTag;
                    createMessage = iMessage;
                    i3 = i2;
                    if (createTag2 != null) {
                        obj = obj2;
                        iTag = null;
                    } else {
                        iTag2 = createTag2;
                        obj = null;
                        iTag = iTag2;
                    }
                    if (iTag3 != null) {
                        iTag3 = iTag;
                        obj2 = obj;
                    } else {
                        obj2 = 1;
                    }
                    apduRequestList.fromTag(iTag3);
                    apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                    if (this.f9730h != null) {
                        this.f9730h.warn(this.f9731i, CRCUtil.substring(3, "上劺夂琗旪ｋ咟廉纛柏乤穳"));
                    }
                    this.f9732j.throwExceptionAndClose(FM_Int.replace(SpecialIssueType.BUG_TYPE_ID_CHARGE, "来坼戨蠞戲蠔奪赻"), ErrorMessage.local_message_apdu_execute_exception, true);
                    if (this.f9729g == 0) {
                        instance = EnumIssueProcess.instance(i3);
                        if (this.f9730h != null) {
                            this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("还廴逛矵s歫骹ｖ", 166, 47)).append(i3).toString());
                        }
                        this.f9734l.handle(instance);
                    }
                    bArr4 = null;
                    if (obj2 == null) {
                        createMessage.addTag(apduReponseList.toTag4A3());
                    } else {
                        try {
                            createMessage.addTag(apduReponseList.toTag4A2());
                        } catch (Exception e3) {
                            if (this.f9730h != null) {
                                this.f9730h.warn(this.f9731i, new StringBuilder(FM_Bytes.concat("乃劸夝瑟斯５枝遹纑競哔廍攩捷凣珩彛帡#", 2, 32)).append(Util4Java.getExceptionInfo(e3)).toString());
                            }
                            this.f9732j.throwExceptionAndClose(FM_Int.replace(5, "柞遽平右诱汋敼捡夣贰"), ErrorMessage.local_message_message_handle_exception, true);
                        }
                    }
                    bArr4 = createMessage.toBytes();
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, new StringBuilder(FM_Int.replace(SyslogAppender.LOG_LOCAL6, "扢衄宇戞1frjr.&5s")).append(FM_Bytes.bytesToHexString(bArr4)).toString());
                    }
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, FM_Bytes.concat("纙窣奃瑄寑扈｟原遈奀琙绉枉绉幸叶/29", 122, ReportInfoUtils.FEEDBACK_SUCCESS));
                    }
                    interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
                    iMessage2 = createMessage;
                    bArr5 = Arrays.copyOf(interaction, 2);
                    iMessage3 = iMessage2;
                }
                try {
                    ITag tag4Id = createMessage.getTag4Id(-90);
                    ITag tag4Id2 = createMessage.getTag4Id(-89);
                    if (tag4Id2 != null) {
                        i3 = tag4Id2.getBytesVal()[0] & 255;
                    }
                    createMessage = messageHandler.createMessage(9001);
                    try {
                        createMessage.addTag(tag4Id);
                        createMessage.addTag(tag4Id2);
                        iTag3 = createTag2;
                        createTag2 = iTag4;
                    } catch (FMCommunicationMessageException e4) {
                        exception = e4;
                        i2 = i3;
                        iMessage = createMessage;
                        createTag = createTag2;
                        createTag2 = iTag4;
                        if (this.f9730h != null) {
                            this.f9730h.warn(Util4Java.endsWith("2uq\u0006/m", 1, 28), new StringBuilder(String.valueOf(str)).append(FM_CN.equals("覶柖帤厸哔庞敫换冧現彝幨{", 2)).append(Util4Java.getExceptionInfo(exception)).toString());
                        }
                        this.f9732j.throwExceptionAndClose(FM_Utils.regionMatches(5, 75, "覶某幸厦哌廘敧捬奼贽"), ErrorMessage.local_message_command_data_invaild, true);
                        iTag3 = createTag;
                        createMessage = iMessage;
                        i3 = i2;
                        if (createTag2 != null) {
                            iTag2 = createTag2;
                            obj = null;
                            iTag = iTag2;
                        } else {
                            obj = obj2;
                            iTag = null;
                        }
                        if (iTag3 != null) {
                            obj2 = 1;
                        } else {
                            iTag3 = iTag;
                            obj2 = obj;
                        }
                        apduRequestList.fromTag(iTag3);
                        apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                        if (this.f9730h != null) {
                            this.f9730h.warn(this.f9731i, CRCUtil.substring(3, "上劺夂琗旪ｋ咟廉纛柏乤穳"));
                        }
                        this.f9732j.throwExceptionAndClose(FM_Int.replace(SpecialIssueType.BUG_TYPE_ID_CHARGE, "来坼戨蠞戲蠔奪赻"), ErrorMessage.local_message_apdu_execute_exception, true);
                        if (this.f9729g == 0) {
                            instance = EnumIssueProcess.instance(i3);
                            if (this.f9730h != null) {
                                this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("还廴逛矵s歫骹ｖ", 166, 47)).append(i3).toString());
                            }
                            this.f9734l.handle(instance);
                        }
                        bArr4 = null;
                        if (obj2 == null) {
                            createMessage.addTag(apduReponseList.toTag4A2());
                        } else {
                            createMessage.addTag(apduReponseList.toTag4A3());
                        }
                        bArr4 = createMessage.toBytes();
                        if (this.f9730h != null) {
                            this.f9730h.debug(this.f9731i, new StringBuilder(FM_Int.replace(SyslogAppender.LOG_LOCAL6, "扢衄宇戞1frjr.&5s")).append(FM_Bytes.bytesToHexString(bArr4)).toString());
                        }
                        if (this.f9730h != null) {
                            this.f9730h.debug(this.f9731i, FM_Bytes.concat("纙窣奃瑄寑扈｟原遈奀琙绉枉绉幸叶/29", 122, ReportInfoUtils.FEEDBACK_SUCCESS));
                        }
                        interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
                        iMessage2 = createMessage;
                        bArr5 = Arrays.copyOf(interaction, 2);
                        iMessage3 = iMessage2;
                    }
                } catch (Exception e22) {
                    i2 = i3;
                    iMessage = iMessage3;
                    exception = e22;
                    createTag = createTag2;
                    createTag2 = iTag4;
                    if (this.f9730h != null) {
                        this.f9730h.warn(Util4Java.endsWith("2uq\u0006/m", 1, 28), new StringBuilder(String.valueOf(str)).append(FM_CN.equals("覶柖帤厸哔庞敫换冧現彝幨{", 2)).append(Util4Java.getExceptionInfo(exception)).toString());
                    }
                    this.f9732j.throwExceptionAndClose(FM_Utils.regionMatches(5, 75, "覶某幸厦哌廘敧捬奼贽"), ErrorMessage.local_message_command_data_invaild, true);
                    iTag3 = createTag;
                    createMessage = iMessage;
                    i3 = i2;
                    if (createTag2 != null) {
                        obj = obj2;
                        iTag = null;
                    } else {
                        iTag2 = createTag2;
                        obj = null;
                        iTag = iTag2;
                    }
                    if (iTag3 != null) {
                        iTag3 = iTag;
                        obj2 = obj;
                    } else {
                        obj2 = 1;
                    }
                    apduRequestList.fromTag(iTag3);
                    apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                    if (this.f9730h != null) {
                        this.f9730h.warn(this.f9731i, CRCUtil.substring(3, "上劺夂琗旪ｋ咟廉纛柏乤穳"));
                    }
                    this.f9732j.throwExceptionAndClose(FM_Int.replace(SpecialIssueType.BUG_TYPE_ID_CHARGE, "来坼戨蠞戲蠔奪赻"), ErrorMessage.local_message_apdu_execute_exception, true);
                    if (this.f9729g == 0) {
                        instance = EnumIssueProcess.instance(i3);
                        if (this.f9730h != null) {
                            this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("还廴逛矵s歫骹ｖ", 166, 47)).append(i3).toString());
                        }
                        this.f9734l.handle(instance);
                    }
                    bArr4 = null;
                    if (obj2 == null) {
                        createMessage.addTag(apduReponseList.toTag4A3());
                    } else {
                        createMessage.addTag(apduReponseList.toTag4A2());
                    }
                    bArr4 = createMessage.toBytes();
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, new StringBuilder(FM_Int.replace(SyslogAppender.LOG_LOCAL6, "扢衄宇戞1frjr.&5s")).append(FM_Bytes.bytesToHexString(bArr4)).toString());
                    }
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, FM_Bytes.concat("纙窣奃瑄寑扈｟原遈奀琙绉枉绉幸叶/29", 122, ReportInfoUtils.FEEDBACK_SUCCESS));
                    }
                    interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
                    iMessage2 = createMessage;
                    bArr5 = Arrays.copyOf(interaction, 2);
                    iMessage3 = iMessage2;
                }
            } catch (Exception e222) {
                createTag2 = iTag4;
                i2 = i3;
                iMessage = iMessage3;
                exception = e222;
                createTag = null;
                if (this.f9730h != null) {
                    this.f9730h.warn(Util4Java.endsWith("2uq\u0006/m", 1, 28), new StringBuilder(String.valueOf(str)).append(FM_CN.equals("覶柖帤厸哔庞敫换冧現彝幨{", 2)).append(Util4Java.getExceptionInfo(exception)).toString());
                }
                this.f9732j.throwExceptionAndClose(FM_Utils.regionMatches(5, 75, "覶某幸厦哌廘敧捬奼贽"), ErrorMessage.local_message_command_data_invaild, true);
                iTag3 = createTag;
                createMessage = iMessage;
                i3 = i2;
                if (createTag2 != null) {
                    iTag2 = createTag2;
                    obj = null;
                    iTag = iTag2;
                } else {
                    obj = obj2;
                    iTag = null;
                }
                if (iTag3 != null) {
                    obj2 = 1;
                } else {
                    iTag3 = iTag;
                    obj2 = obj;
                }
                apduRequestList.fromTag(iTag3);
                apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, CRCUtil.substring(3, "上劺夂琗旪ｋ咟廉纛柏乤穳"));
                }
                this.f9732j.throwExceptionAndClose(FM_Int.replace(SpecialIssueType.BUG_TYPE_ID_CHARGE, "来坼戨蠞戲蠔奪赻"), ErrorMessage.local_message_apdu_execute_exception, true);
                if (this.f9729g == 0) {
                    instance = EnumIssueProcess.instance(i3);
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("还廴逛矵s歫骹ｖ", 166, 47)).append(i3).toString());
                    }
                    this.f9734l.handle(instance);
                }
                bArr4 = null;
                if (obj2 == null) {
                    createMessage.addTag(apduReponseList.toTag4A2());
                } else {
                    createMessage.addTag(apduReponseList.toTag4A3());
                }
                bArr4 = createMessage.toBytes();
                if (this.f9730h != null) {
                    this.f9730h.debug(this.f9731i, new StringBuilder(FM_Int.replace(SyslogAppender.LOG_LOCAL6, "扢衄宇戞1frjr.&5s")).append(FM_Bytes.bytesToHexString(bArr4)).toString());
                }
                if (this.f9730h != null) {
                    this.f9730h.debug(this.f9731i, FM_Bytes.concat("纙窣奃瑄寑扈｟原遈奀琙绉枉绉幸叶/29", 122, ReportInfoUtils.FEEDBACK_SUCCESS));
                }
                interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
                iMessage2 = createMessage;
                bArr5 = Arrays.copyOf(interaction, 2);
                iMessage3 = iMessage2;
            }
            if (createTag2 != null) {
                iTag2 = createTag2;
                obj = null;
                iTag = iTag2;
            } else {
                obj = obj2;
                iTag = null;
            }
            if (iTag3 != null) {
                obj2 = 1;
            } else {
                iTag3 = iTag;
                obj2 = obj;
            }
            try {
                apduRequestList.fromTag(iTag3);
            } catch (Exception exception2) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(Util4Java.endsWith("丙勯奝瑂旹６并厠咖廒皕敬捩覱柍彊師＄", 6, 107)).append(Util4Java.getExceptionInfo(exception2)).toString());
                }
                this.f9732j.throwExceptionAndClose(FM_CN.equals("带厶咚廜皝敺捵觯柍奿赺", 2), ErrorMessage.local_communication_invalid_response, true);
            } catch (Exception exception22) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Utils.regionMatches(2, 17, "么劢夐球无ｋ師厹咗废皘敽捰覬某当帺")).append(Util4Java.getExceptionInfo(exception22)).toString());
                }
                this.f9732j.throwExceptionAndClose(FM_Utils.regionMatches(1, 80, "帢厱哜廕皕敱挿觢柁奰贴"), ErrorMessage.local_communication_invalid_response, true);
            }
            try {
                apduReponseList = this.f9732j.getScriptHandler().execute(apduRequestList);
            } catch (Exception exception222) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Utils.regionMatches(4, 33, "乎労夒瑑斮５脀杷戻衑凤珯异帹x")).append(Util4Java.getExceptionInfo(exception222)).toString());
                }
                if (exception222 == null || ScriptHandleExceptionType.STOPED != exception222.getType()) {
                    this.f9732j.throwExceptionAndClose(BCCUtil.getChars("朲圲扡蠆戩衞大赿", 206, 100), ErrorMessage.local_message_apdu_execute_exception, true);
                } else {
                    this.f9732j.throwExceptionAndClose(FM_Utils.regionMatches(4, 107, "乎勾奎琓被叝淞"), ErrorMessage.local_business_cancel, true);
                }
            }
            if (apduReponseList == null || apduReponseList.size() < 1) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, CRCUtil.substring(3, "上劺夂琗旪ｋ咟廉纛柏乤穳"));
                }
                this.f9732j.throwExceptionAndClose(FM_Int.replace(SpecialIssueType.BUG_TYPE_ID_CHARGE, "来坼戨蠞戲蠔奪赻"), ErrorMessage.local_message_apdu_execute_exception, true);
            }
            if (this.f9729g == 0) {
                instance = EnumIssueProcess.instance(i3);
                if (!(this.f9734l == null || instance == null)) {
                    if (this.f9730h != null) {
                        this.f9730h.debug(this.f9731i, new StringBuilder(Util4Java.endsWith("还廴逛矵s歫骹ｖ", 166, 47)).append(i3).toString());
                    }
                    this.f9734l.handle(instance);
                }
            }
            bArr4 = null;
            if (obj2 == null) {
                createMessage.addTag(apduReponseList.toTag4A2());
            } else {
                createMessage.addTag(apduReponseList.toTag4A3());
            }
            bArr4 = createMessage.toBytes();
            if (this.f9730h != null) {
                this.f9730h.debug(this.f9731i, new StringBuilder(FM_Int.replace(SyslogAppender.LOG_LOCAL6, "扢衄宇戞1frjr.&5s")).append(FM_Bytes.bytesToHexString(bArr4)).toString());
            }
            if (this.f9730h != null) {
                this.f9730h.debug(this.f9731i, FM_Bytes.concat("纙窣奃瑄寑扈｟原遈奀琙绉枉绉幸叶/29", 122, ReportInfoUtils.FEEDBACK_SUCCESS));
            }
            interaction = this.f9732j.interaction(bArr4, str, true, server4Business);
            iMessage2 = createMessage;
            bArr5 = Arrays.copyOf(interaction, 2);
            iMessage3 = iMessage2;
        }
        this.f9723a = interaction;
        this.f9732j.businessFinish(true);
        if (Arrays.equals(RespCodeonse4Platform.SUCESS, bArr5)) {
            return true;
        }
        if (interaction.length <= 2) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(str)).append(FM_Long.copyValueOf("＀穳丫叒卡帮厪奓瑒奠赫ｇ帻厵咏廋ｆ", 4)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(str)).append(BCCUtil.getChars("ｘ稩丿叀匱奾贫", 4, 95)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(interaction)), false);
        } else {
            try {
                iTag3 = messageHandler.createMessage(TradeCode.APP_ISSUER_VER2, Arrays.copyOfRange(interaction, 2, interaction.length)).getTag4Id(-76);
                if (iTag3 != null) {
                    this.f9723a = iTag3.getBytesVal();
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(str)).append(FM_CN.equals("厉匨奫赮０笡丗斶平厡彀幫h", 5)).append(new String(this.f9723a)).toString());
                }
            } catch (Exception exception2222) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(str)).append(CRCUtil.substring(3, "＜涓恩夕琚嘯冨班彊幫ｄ")).append(Util4Java.getExceptionInfo(exception2222)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(str)).append(FM_Long.copyValueOf("＇涀恪夆瑙嘴冣珦彑幨", 3)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        return false;
    }

    public boolean appletDownload(EnumCardAppType enumCardAppType, byte[] bArr, String str) throws BusinessException {
        String regionMatches = FM_Utils.regionMatches(3, 85, "廇畠宔袗卂丗輬");
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("ｗ乌劰夈瑁宻豼乢稩", 4, 91)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(104, TransportMediator.KEYCODE_MEDIA_PLAY, "ｔ乌勵奖瑖嘦剑妁卞奷赡")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(FM_Int.replace(5, "ｖ淕息备琀噡丶穵＞涝恷酖罰斆仲劧轷夼贵")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_CN.equals("ｙ勦輪\u001cXM宁久鄐缠旘亦奰贷", 2)).toString(), ErrorMessage.local_message_load_config_fail);
        }
        byte[] bArr2 = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.APPLET_DOWNLOAD);
        if (enumCardAppType != null) {
            try {
                ITag createTag = messageHandler.createTag((byte) 14);
                createTag.addValue(enumCardAppType.getId());
                createMessage.addTag(createTag);
            } catch (Exception e) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("ｕ涘恨多瑓嘤凹玪弓幰ｅ", 2, 23)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(regionMatches)).append(Util4Java.endsWith("ｏ淂怾奜瑙嘮冷珤彙帺", 198, 7)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        if (str != null && str.length() > 0) {
            createTag = messageHandler.createTag((byte) TagName.DEVICE_MODEL);
            createTag.addValue(str);
            createMessage.addTag(createTag);
        }
        if (bArr != null && bArr.length > 0) {
            createTag = messageHandler.createTag((byte) TagName.SEID);
            createTag.addValue(bArr);
            createMessage.addTag(createTag);
        }
        bArr2 = createMessage.toBytes();
        String server4Business = this.f9732j.getServer4Business(TradeCode.APPLET_DOWNLOAD);
        if (server4Business == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(FM_Long.copyValueOf("旼＋莳受奚瑝盜带厢奾赩", 2)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_CN.equals("斡ｄ菮厜够琊皙幽厯奡赤", SportType.SPORT_TYPE_CLIMB_HILL)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        bArr2 = m13032a(bArr2, regionMatches, messageHandler, server4Business);
        if (FM_Bytes.isEnd9000(bArr2)) {
            if (this.f9730h != null) {
                this.f9730h.debug(this.f9731i, FM_Utils.regionMatches(2, 44, "廆甶寃袓匇奊瑜宊扂"));
            }
            return true;
        }
        if (bArr2.length <= 2) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(FM_Int.replace(40, "１空丮受卨广叿外琓天贾２帲厴咊廞ｗ")).append(FM_Bytes.bytesToHexString(bArr2)).toString());
            }
            this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(regionMatches)).append(FM_Int.replace(4, "ｕ稦乲叓卤夹贮")).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr2)), false);
        } else {
            try {
                ITag tag4Id = messageHandler.createMessage(TradeCode.APP_ISSUER_VER2, Arrays.copyOfRange(bArr2, 2, bArr2.length)).getTag4Id(-76);
                if (tag4Id != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(BCCUtil.getChars("厂匽奴贫；第乀旫幨叴式幮s", 3, 105)).append(tag4Id.getStringVal()).toString());
                }
            } catch (Exception e2) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(BCCUtil.getChars("～帣叾夈瑌她责（覡某笲乕旣弚帮攤挼弒帶ｖ", 2, 94)).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(regionMatches)).append(FM_CN.equals("ｔ帺厪奏琚夼贻＃解柁筮乚旽弗帾敧捦彛干", 5)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        return false;
    }

    public boolean applyBusiness(String str, byte[] bArr, String str2, byte[] bArr2) throws BusinessException {
        String concat = FM_Bytes.concat("廓畹宒裀匊乒輾", 112, 106);
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(FM_Utils.regionMatches(24, 114, "＄乀勭奚瑖宻豵丼穢")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(5, "ｖ乇务备琀噡刑姄匄夤贽")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(FM_Utils.regionMatches(3, 20, "｟涏恴夋瑅嘿乱稥？涏恴鄂缭旐份势轮奶赾")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(232, "ｑ勠輾\u0012\b\u000b寕丛鄘缶旜亨夰贡")).toString(), ErrorMessage.local_message_load_config_fail);
        }
        String companyCode;
        Configration configration = this.f9732j.getConfigration();
        if (configration != null) {
            companyCode = configration.getCompanyCode();
        } else {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(2, "斡ｖ\u001eom``k}saqtp!举穽")).toString());
            }
            companyCode = null;
        }
        if (companyCode == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("旸＜啔戣缀可丠穦", 286, 2)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Utils.regionMatches(2, 107, "斤ｑ唎戤缈叾乮稥")).toString(), ErrorMessage.local_business_para_error);
        }
        byte[] bArr3 = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.APPLET_DOWNLOAD_VER2);
        try {
            ITag createTag;
            ITag createTag2 = messageHandler.createTag((byte) TagName.COMPANY_CODE);
            createTag2.addValue(companyCode);
            createMessage.addTag(createTag2);
            if (str != null) {
                createTag = messageHandler.createTag((byte) TagName.CP_NO);
                createTag.addValue(str);
                createMessage.addTag(createTag);
            }
            if (str2 != null && str2.length() > 0) {
                createTag = messageHandler.createTag((byte) TagName.DEVICE_MODEL);
                createTag.addValue(str2);
                createMessage.addTag(createTag);
            }
            if (bArr != null && bArr.length > 0) {
                createTag = messageHandler.createTag((byte) TagName.SEID);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
            }
            if (bArr2 != null && bArr2.length > 0) {
                createTag = messageHandler.createTag((byte) TagName.ACTIVITY_INFO);
                createTag.addValue(bArr2);
                createMessage.addTag(createTag);
            }
            bArr3 = createMessage.toBytes();
        } catch (Exception e) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(FM_Exception.insert(6, 42, "＆涜怱夌琔嘴凼玠彘帼４")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("！涂恨夀琇嘶冡珨彗幪", 5)).toString(), ErrorMessage.local_message_message_handle_exception, false);
        }
        companyCode = this.f9732j.getServer4Business(TradeCode.APPLET_DOWNLOAD_VER2);
        if (companyCode == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(4, "斯ｐ菨叔夁琎皏幽叡夥贲")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("斪ｏ菽叇夜瑙盂帾古太货", 5, 103)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        bArr3 = m13032a(bArr3, concat, messageHandler, companyCode);
        if (FM_Bytes.isEnd9000(bArr3)) {
            if (this.f9730h != null) {
                this.f9730h.debug(this.f9731i, FM_CN.equals("廁畮寞袍匜夎琝宀才", 2));
            }
            return true;
        }
        if (bArr3.length <= 2) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(FM_CN.equals("ｙ稼乺厙卸幹叫夈瑛奿赺｜帲叢哎庀？", 2)).append(FM_Bytes.bytesToHexString(bArr3)).toString());
            }
            this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("ｘ穱丯又匱奶赻", 4, 23)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr3)), false);
        } else {
            try {
                ITag tag4Id = messageHandler.createMessage(TradeCode.APP_ISSUER_VER2, Arrays.copyOfRange(bArr3, 2, bArr3.length)).getTag4Id(-76);
                if (tag4Id != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(FM_Exception.insert(3, 11, "取即夬购？笲乀旭帬厺彗常'")).append(tag4Id.getStringVal()).toString());
                }
            } catch (Exception e2) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("ｐ帹厨奂琒夳贵ｒ覯柊筤丟施弐常放挲彈帠＜", 268, 110)).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(4, "ｕ帯厯夆球夹贮＂觲构笻专斤异帻敶捧弎帷")).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        return false;
    }

    public void cancel() {
        this.f9733k = true;
        if (this.f9732j != null) {
            ScriptHandler scriptHandler = this.f9732j.getScriptHandler();
            if (scriptHandler != null) {
                scriptHandler.cancel();
            }
        } else if (this.f9730h != null) {
            this.f9730h.warn(this.f9731i, Util4Java.endsWith("久勢厑涃旹｟乍劺夛琅宾谪丵穩", 2, 100));
        }
    }

    public CardAppInfo deleteApp(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException {
        String substring = CRCUtil.substring(5, "即丗府画刾阭");
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        if (this.f9730h != null) {
            this.f9730h.info(this.f9731i, FM_CN.equals("匶乂廍畢刻陨3 q", 4));
        }
        CardAppInfo cardAppInfo = new CardAppInfo();
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(CRCUtil.substring(3, "＜丁劧夕琚宾谳乧稲")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("．乐勳夞琄噢剏妑協夻贷", 5, 104)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("ｋ涎恪奀瑅噪主稺３涖怲鄑罵斝亯勸轪大走", AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED, 95)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(FM_Exception.insert(3, 85, "＋勼转R\u001aW実专酂罪旞仸夲赽")).toString(), ErrorMessage.local_message_load_config_fail);
        }
        ITag createTag;
        byte[] bArr3 = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.APP_MANAGER_VER2);
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    createTag = messageHandler.createTag((byte) TagName.ACTIVITY_INFO);
                    createTag.addValue(bArr);
                    createMessage.addTag(createTag);
                }
            } catch (Exception e) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("ｐ淌恣奐琚嘬凶珤弞帼ｖ", 5, 72)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(CRCUtil.substring(1, "＂涑恫夋琜嘭冪珫彄幩")).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        if (enumCardAppType != null) {
            createTag = messageHandler.createTag((byte) 14);
            createTag.addValue(enumCardAppType.getId());
            createMessage.addTag(createTag);
        }
        if (str != null && str.length() > 0) {
            createTag = messageHandler.createTag((byte) TagName.DEVICE_MODEL);
            createTag.addValue(str);
            createMessage.addTag(createTag);
        }
        if (bArr2 != null && bArr2.length > 0) {
            createTag = messageHandler.createTag((byte) TagName.SEID);
            createTag.addValue(bArr2);
            createMessage.addTag(createTag);
        }
        createTag = messageHandler.createTag((byte) TagName.APP_MANAGE_OPEATE_TYPE);
        createTag.addValue(EnumAppManageOperateType.APP_DELETE.getId());
        createMessage.addTag(createTag);
        bArr3 = createMessage.toBytes();
        String server4Business = this.f9732j.getServer4Business(TradeCode.APP_MANAGER_VER2);
        if (server4Business == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_CN.equals("匴乌廃畠刹陮旭旺ｑ菹厉奔瑇皖幰古头赳", 2));
            }
            throw new BusinessException(FM_CN.equals("卶丂廍畢剻阨旫旸３莧受奖瑅盐帶另夶贽", 164), ErrorMessage.local_app_query_server_fail);
        }
        bArr3 = m13032a(bArr3, substring, messageHandler, server4Business);
        ITag tag4Id;
        if (!FM_Bytes.isEnd9000(bArr3)) {
            if (bArr3.length <= 2) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(FM_Long.copyValueOf("！穰个叕占席厫奜瑓奣赪｀帺厶咎廔ｇ", 5)).append(FM_Bytes.bytesToHexString(bArr3)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(1, 12, "｝稧两叄占夼贼")).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr3)), false);
            } else {
                try {
                    tag4Id = messageHandler.createMessage(TradeCode.APP_ISSUER_VER2, Arrays.copyOfRange(bArr3, 2, bArr3.length)).getTag4Id(-76);
                    if (tag4Id != null) {
                        this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(CRCUtil.substring(3, "叁卺夷贴０筫乛旤帻厣彜帱8")).append(tag4Id.getStringVal()).toString());
                    }
                } catch (Exception e2) {
                    if (this.f9730h != null) {
                        this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(FM_Exception.insert(3, 120, "＋帬厧奋瑁奮赲ｃ覤枏笻丆斾弝帯敿捩彝幯ｕ")).append(Util4Java.getExceptionInfo(e2)).toString());
                    }
                    this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(CRCUtil.substring(276, "－广叧奆瑋奩赦ｂ覺枔笣专於弒帣收挿彞广")).toString(), ErrorMessage.local_message_message_handle_exception, false);
                }
            }
            if (this.f9730h != null) {
                this.f9730h.info(this.f9731i, BCCUtil.getChars("匵丞廀甼剴陰寘戄", 4, 64));
            }
            return cardAppInfo;
        } else if (bArr3.length == 2) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, CRCUtil.substring(4, "印世库町刽阬察扎e帧厯沫朜返囕制阥盈廃番垷杴俢恡"));
            }
            return cardAppInfo;
        } else {
            try {
                tag4Id = messageHandler.createMessage(bArr3).getTag4Id(-76);
                if (!(tag4Id == null || tag4Id.getBytesVal() == null || tag4Id.getBytesVal().length <= 0)) {
                    List<TagEntry> parse = TLVParse.intance().parse(tag4Id.getBytesVal(), 1);
                    if (parse != null && parse.size() > 0) {
                        for (TagEntry tagEntry : parse) {
                            if (tagEntry != null) {
                                if ((byte) 15 == tagEntry.getTag()[0]) {
                                    cardAppInfo.setCardAppNo(tagEntry.getData());
                                }
                                if (TagName.CARD_APP_BLANCE == tagEntry.getTag()[0]) {
                                    cardAppInfo.setBalance(Integer.valueOf(FM_Bytes.bytesToInt(tagEntry.getData())));
                                }
                                if (TagName.MOC == tagEntry.getTag()[0]) {
                                    cardAppInfo.setMoc(FM_Bytes.bytesToHexString(tagEntry.getData()));
                                }
                            }
                        }
                    }
                }
                return cardAppInfo;
            } catch (Exception e22) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(FM_Long.copyValueOf("ｄ覦柒幬召哔庂散捾皉陎劧整捯埁凡玨弗帪５", 192)).append(Util4Java.getExceptionInfo(e22)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("ｑ觳枓幥厹咑廛敲捻皌陟勮攱挺埘几玽彂幫", 6, 19)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
    }

    public byte[] deleteAppVer1(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException {
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Utils.regionMatches(4, 51, "匵不廎甥剠阷旰ｕ世劾奖球审豪两稫"));
            }
            throw new BusinessException(FM_Long.copyValueOf("匣乕廈畱剶阷斦ａ乐勦奀瑇噶分姓匃夣贪", 90), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Int.replace(146, "卦一庙甸刳陲旯０涗恭夁琎噣临穫８涟恵酐缮旄亰勩輱奾起"));
            }
            throw new BusinessException(FM_Int.replace(200, "卼乊廗畮剩阨方～勵輥\u000f\u001f\u0006寞与鄇缣旗亥奧赼"), ErrorMessage.local_message_load_config_fail);
        }
        ITag createTag;
        byte[] bArr3 = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.APP_MANAGER);
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    createTag = messageHandler.createTag((byte) TagName.ACTIVITY_INFO);
                    createTag.addValue(bArr);
                    createMessage.addTag(createTag);
                }
            } catch (Exception e) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Exception.insert(3, 29, "卦与廕當剻陼旣～淇恣复瑀嘫出玭弘幯ｎ")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(CRCUtil.substring(5, "即丗府画刾阭斢ｓ淂怺处琍噾击玼引幺"), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        if (enumCardAppType != null) {
            createTag = messageHandler.createTag((byte) 14);
            createTag.addValue(enumCardAppType.getId());
            createMessage.addTag(createTag);
        }
        if (str != null && str.length() > 0) {
            createTag = messageHandler.createTag((byte) TagName.DEVICE_MODEL);
            createTag.addValue(str);
            createMessage.addTag(createTag);
        }
        if (bArr2 != null && bArr2.length > 0) {
            createTag = messageHandler.createTag((byte) TagName.SEID);
            createTag.addValue(bArr2);
            createMessage.addTag(createTag);
        }
        createTag = messageHandler.createTag((byte) TagName.APP_MANAGE_OPEATE_TYPE);
        createTag.addValue(EnumAppManageOperateType.APP_DELETE.getId());
        createMessage.addTag(createTag);
        bArr3 = createMessage.toBytes();
        String server4Business = this.f9732j.getServer4Business(TradeCode.APP_MANAGER);
        if (server4Business == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, CRCUtil.substring(6, "卲且庝甼刿阮斣斶ｇ菡受夈琑皆幾叨奲赫"));
            }
            throw new BusinessException(FM_Int.replace(5, "医乗应甫刦陭旺旹＞莢収够琘皅幷号夻质"), ErrorMessage.local_app_query_server_fail);
        }
        bArr3 = m13032a(bArr3, FM_Int.replace(4, "匸乖廋甪別陬旽"), messageHandler, server4Business);
        if (Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(bArr3, 2))) {
            try {
                ITag tag4Id = messageHandler.createMessage(bArr3).getTag4Id(-76);
                if (tag4Id != null) {
                    return tag4Id.getBytesVal();
                }
            } catch (Exception e2) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(BCCUtil.getChars("医乞庚甠剢陸无｜覩枔席厨哟庘收挮皞阐勮數捬垃凬玠彈幼＄", 138, 90)).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                this.f9732j.throwExceptionAndClose(FM_CN.equals("匴乌廃畠刹陮旭＀覾柞帬厠和庆敳捺皁阒勧攨挧埅凱玬式幦", 2), ErrorMessage.local_message_message_handle_exception, false);
            }
        } else if (bArr3.length <= 2) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(Util4Java.endsWith("匤乂廟畦剱阰斡ｖ稧中叒卧幺叼夋琔夤贽７幭叱哉库０", 360, 3)).append(FM_Bytes.bytesToHexString(bArr3)).toString());
            }
            this.f9732j.throwExceptionAndClose(FM_Long.copyValueOf("卭七庒甫删阹斬｛種乼原匪她赠", 4), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr3)), false);
        }
        return null;
    }

    public EnumCardAppStatus getAppIssuerStatus(EnumCardAppType enumCardAppType) throws BusinessException {
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        if (this.f9730h == null) {
            this.f9730h.debug(this.f9731i, FM_Long.copyValueOf("莽发卥皅乄勺洙穞狤恎bgh", 2));
        }
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Bytes.concat("華厕匯皝丞劮洛穎狦怚＊下勽奃瑔寤豩丩稤", 1, 107));
            }
            throw new BusinessException(FM_Exception.insert(3, 53, "莰及匰皂乁励洄穑犹恅５乔劢夜瑋噪削姇南奧贮"), ErrorMessage.local_business_init_fail);
        }
        ApduHandler apduHandler = this.f9732j.getApduHandler();
        if (apduHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Utils.regionMatches(242, 102, "菵厞卯皐乀勡洇稇犤恙斨hK@\u0012\t奆琎噦乮稠"));
            }
            throw new BusinessException(FM_CN.equals("菪厘卾皔丛劳浂穟狳恗斱4HJO\t奉瑘嘧乺穫", FitnessSleepType.HW_FITNESS_WAKE), ErrorMessage.local_business_apdu_handler_null);
        }
        EnumCardAppStatus enumCardAppStatus = EnumCardAppStatus.STATUS_UNKNOW;
        if (this.f9730h == null) {
            this.f9730h.debug(this.f9731i, CRCUtil.substring(2, "别斷铻掵昴呠伮畴i|s"));
        }
        if (apduHandler.isConnect()) {
            if (this.f9730h != null) {
                this.f9730h.error(this.f9731i, FM_Exception.insert(5, 10, "莾叅卼皃下劺洄穄狯恂斻｛@[QJ复琕噵欤很"));
            }
            this.f9732j.throwExceptionAndClose(FM_Exception.insert(4, 79, "莿厁卧监乞劲洃稚状恎旨ａ][\u001e\\奜瑁噾欦忍"), ErrorMessage.local_business_apdu_handler_busying, false);
        } else {
            apduHandler.connect();
        }
        CardManager cardManager = CardManagerFactory.instance().getCardManager(enumCardAppType);
        if (cardManager != null) {
            if (apduHandler.open(cardManager.getAid())) {
                enumCardAppStatus = EnumCardAppStatus.STATUS_INSTALL;
                cardManager.setApduHandler(apduHandler);
                try {
                    enumCardAppStatus = cardManager.getStatus();
                } catch (Exception e) {
                    if (this.f9730h != null) {
                        this.f9730h.error(this.f9731i, new StringBuilder(Util4Java.endsWith("莶厓卨乇庅畽彊刐犷恄旿冷玡彗帡g", 4, 68)).append(Util4Java.getExceptionInfo(e)).toString());
                    }
                    this.f9732j.throwExceptionAndClose(BCCUtil.getChars("菣厏匿三府甥彁剚犪怀夷贮", 4, 5), ErrorMessage.local_business_apdu_handler_null, true);
                }
            } else {
                enumCardAppStatus = EnumCardAppStatus.STATUS_NO_APP;
            }
            if (this.f9730h == null) {
                this.f9730h.debug(this.f9731i, CRCUtil.substring(1, "oi`zR$>?*4.)qqg`{a}qd{"));
            }
            apduHandler.close();
        } else if (this.f9730h != null) {
            this.f9730h.error(this.f9731i, FM_CN.equals("華原医乁庈甥彍剂状恐斴｟佤兰皂卶丂廍畢簠埇旽敆", 5));
        }
        return enumCardAppStatus;
    }

    public EnumCardAppStatus getAppIssuerStatus4Platform(EnumCardAppType enumCardAppType, String str, byte[] bArr) throws BusinessException {
        this.f9729g = 1;
        String insert = FM_Exception.insert(2, 64, "仈帵叶菱叐引剋盂穼厗犰恇");
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        if (this.f9730h != null) {
            this.f9730h.info(this.f9731i, FM_Exception.insert(TransportMediator.KEYCODE_MEDIA_PLAY, 22, "仌幫叾菳厌弃剋皘穨厙狨恕$.8"));
        }
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(insert)).append(FM_Exception.insert(5, 85, "旿ｒ三助奙琔対谽丫穼")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(CRCUtil.substring(4, "旧０丝劳夙瑎嘻剃如卂奮贯")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(insert)).append(FM_Utils.regionMatches(4, 63, "斢？淚恾奔琉嘦丷稶＇淂恦鄅罩旁仳勤轾女贤")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(Util4Java.endsWith("旡ｑ劣輴[\u0014\\宛与酀缽斞亩头赮", 154, 70)).toString(), ErrorMessage.local_message_load_config_fail);
        }
        byte[] bArr2 = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.APP_MANAGER);
        if (enumCardAppType != null) {
            try {
                ITag createTag = messageHandler.createTag((byte) 14);
                createTag.addValue(enumCardAppType.getId());
                createMessage.addTag(createTag);
            } catch (Exception e) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(insert)).append(FM_Exception.insert(1, 6, "旳＇涙恸夙琅噡凵玥弙幹｝")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(insert)).append(FM_Int.replace(154, "旹＞涝恷够琘噩凾玷弈帵")).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        if (str != null && str.length() > 0) {
            createTag = messageHandler.createTag((byte) TagName.DEVICE_MODEL);
            createTag.addValue(str);
            createMessage.addTag(createTag);
        }
        if (bArr != null && bArr.length > 0) {
            createTag = messageHandler.createTag((byte) TagName.SEID);
            createTag.addValue(bArr);
            createMessage.addTag(createTag);
        }
        bArr2 = createMessage.toBytes();
        String server4Business = this.f9732j.getServer4Business(TradeCode.APP_MANAGER);
        if (server4Business == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(insert)).append(CRCUtil.substring(2, "旹６莲叆够瑀盕帯厷奣赸")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(insert)).append(FM_Long.copyValueOf("斠｟菧厛奎瑁盀帲叮太贽", 78)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        bArr2 = m13032a(bArr2, BCCUtil.getChars("匿也廘畫压蠝狾怞柳误", 142, TagName.ELECTRONIC_USE_COUNT), messageHandler, server4Business);
        if (Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(bArr2, 2))) {
            try {
                ITag tag4Id = messageHandler.createMessage(this.f9723a).getTag4Id(-76);
                if (tag4Id != null) {
                    return EnumCardAppStatus.instance(FM_Bytes.bytesToInt(tag4Id.getBytesVal()));
                }
            } catch (Exception e2) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(insert)).append(BCCUtil.getChars("｟覻枍幱号咁廅敦捵的阁勪敿捺垆冤珳弊帵ｈ", 3, 101)).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(insert)).append(BCCUtil.getChars("ｙ觱枟帿厹哋店攰挳盞陓労攡挠埔凲珵彀幧", 5, 29)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
        } else if (bArr2.length <= 2) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(insert)).append(FM_Exception.insert(3, 82, "＋稣並厌匮干厣奁琑奸贾！帬叡哎廁＝")).append(FM_Bytes.bytesToHexString(bArr2)).toString());
            }
            this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(insert)).append(CRCUtil.substring(178, "３稰乸厑匪奧贤")).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr2)), false);
        }
        return null;
    }

    public boolean issuePrepare(byte[] bArr, String str, byte[] bArr2, byte[] bArr3, String str2, String str3, byte[] bArr4, IssuerPrepareResult issuerPrepareResult) throws BusinessException {
        String copyValueOf = FM_Long.copyValueOf("废甠叔衎写奛", 3);
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        if (this.f9730h != null) {
            this.f9730h.info(this.f9731i, FM_Long.copyValueOf("庞甯叕衍冘奜v{|", 2));
        }
        this.f9729g = 1;
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Exception.insert(1, 99, "旳ｄ乑劯夕瑒宮豻丧空")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(FM_CN.equals("斢ｉ乌勦夜琏噲刖妗卛奯赪", 1)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(copyValueOf)).append(FM_Utils.regionMatches(172, 107, "旪＋淚怲奌琕噶丳種ｓ淂恺配罥旑亷勬轪夳质")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(Util4Java.endsWith("旴８劦轥\u001e\u001d\t定乛酉罸族京好赻", 5, 18)).toString(), ErrorMessage.local_message_load_config_fail);
        }
        byte[] bArr5 = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.APP_ISSUER_PREPARE);
        if (bArr != null) {
            try {
                if (bArr.length > 1) {
                    ITag createTag = messageHandler.createTag((byte) TagName.SEID);
                    createTag.addValue(bArr);
                    createMessage.addTag(createTag);
                }
            } catch (Exception e) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Exception.insert(5, 86, "庝畷叄衇冇夐旻ｏ涑恠奁琝噹冽玭弑幱％")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(BCCUtil.getChars("廂畱厍蠓凄夂旾＇涆恾夐琑噲凧现弁帾", SportType.SPORT_TYPE_SWIM, 3), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        if (str != null && str.length() > 0) {
            createTag = messageHandler.createTag((byte) TagName.IMEI);
            createTag.addValue(str);
            createMessage.addTag(createTag);
        }
        if (bArr2 != null && bArr2.length > 1) {
            createTag = messageHandler.createTag((byte) TagName.APP_AID);
            createTag.addValue(bArr2);
            createMessage.addTag(createTag);
        }
        if (bArr3 != null && bArr3.length > 1) {
            createTag = messageHandler.createTag((byte) TagName.CPLC);
            createTag.addValue(bArr3);
            createMessage.addTag(createTag);
        }
        if (str2 != null && str2.length() > 1) {
            createTag = messageHandler.createTag((byte) TagName.DEVICE_MODEL);
            createTag.addValue(str2);
            createMessage.addTag(createTag);
        }
        if (str3 != null && str3.length() > 1) {
            createTag = messageHandler.createTag((byte) TagName.EUID);
            createTag.addValue(str3);
            createMessage.addTag(createTag);
        }
        if (bArr4 != null && bArr4.length > 1) {
            createTag = messageHandler.createTag((byte) TagName.PATCH_DATA);
            createTag.addValue(bArr4);
            createMessage.addTag(createTag);
        }
        bArr5 = createMessage.toBytes();
        String server4Business = this.f9732j.getServer4Business(TradeCode.APP_ISSUER_PREPARE);
        if (server4Business == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(copyValueOf)).append(CRCUtil.substring(NFCBaseActivity.TO_ADD, "施ｚ莶叚夓琄皉幫厳奿赼")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(copyValueOf)).append(FM_Int.replace(2, "斡ｖ菪取备琀皍广叿夣贰")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9732j.businessReady(copyValueOf, server4Business);
        Object interaction = this.f9732j.interaction(bArr5, copyValueOf, false, server4Business);
        if (interaction == null || interaction.length < 1) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Exception.insert(162, 106, "幵叠奞瑂乔効诵汎奧赥"));
            }
            this.f9732j.throwExceptionAndClose(CRCUtil.substring(254, "丑劷夅琊旡ｎ杧敮剳帽厩哉庛敪捫"), ErrorMessage.local_communication_no_response, false);
        }
        Object obj = new byte[2];
        System.arraycopy(interaction, 0, obj, 0, obj.length);
        if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
            if (this.f9730h != null) {
                this.f9730h.error(this.f9731i, new StringBuilder(Util4Java.endsWith("序畴双蠒凙奇－帱右奀球奷财r)", 158, 65)).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9732j.throwExceptionAndClose(FM_Exception.insert(TransportMediator.KEYCODE_MEDIA_PLAY, 36, "庖甮厛蠂凔夑ｖ席史奂瑌夿贷"), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
        }
        try {
            IMessage createMessage2 = messageHandler.createMessage(TradeCode.APP_ISSUER_PREPARE, Arrays.copyOfRange(interaction, 2, interaction.length));
            ITag tag4Id = createMessage2.getTag4Id(-75);
            if (tag4Id != null) {
                ITag tag4Id2;
                if (tag4Id.getBytesVal()[0] == (byte) 0) {
                    tag4Id2 = createMessage2.getTag4Id(-71);
                    if (tag4Id2 != null) {
                        issuerPrepareResult.setSir(tag4Id2.getBytesVal());
                    }
                    return true;
                }
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, String.format(BCCUtil.getChars("丄勲夌瑛实扗ｐ夕瑀终柌头贿\u0014!\u0001S", 206, 53), new Object[]{Byte.valueOf(r2[0])}));
                }
                tag4Id2 = createMessage2.getTag4Id(-76);
                if (tag4Id2 != null) {
                    issuerPrepareResult.setFailDesc(tag4Id2.getBytesVal());
                }
                return false;
            }
        } catch (Exception e2) {
            if (this.f9730h != null) {
                this.f9730h.error(this.f9731i, new StringBuilder(CRCUtil.substring(5, "丘浪京选卿稳乹儚偶斣，觨枆干叼哚廖冷珨彁并c$")).append(Util4Java.getExceptionInfo(e2)).toString());
            }
            this.f9732j.throwExceptionAndClose(FM_Int.replace(3, "乒洬仺逛卥穽丧先倬日：觺枌幬史哈府夺贫"), ErrorMessage.local_message_message_handle_exception, false);
        }
        return false;
    }

    public boolean issuePrepareResultSearch(byte[] bArr, IssuerPrepareResult issuerPrepareResult) throws BusinessException {
        Exception e;
        String server4Business;
        Object interaction;
        Object obj;
        ITag tag4Id;
        ITag tag4Id2;
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        if (this.f9730h != null) {
            this.f9730h.info(this.f9731i, CRCUtil.substring(2, "庛甲叔衜凝奁纂柀枢记s&="));
        }
        this.f9729g = 1;
        String chars = BCCUtil.getChars("廔畫受衅冊奈绁枉枽讹", 240, 99);
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(FM_Bytes.concat("斬ｓ丞动夊琕寡豼丸穽", 3, 5)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(CRCUtil.substring(142, "旭＊下劽奃瑔嘵剕妘午夸贱")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(Util4Java.endsWith("旵７涛怤奇瑝噻丱稹ｗ淛恤酎罵旔亽劣车夢赮", 6, 24)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_CN.equals("旡＄勹輷\u000f\rZ宔乖酝罯旕亵奥赠", 164)).toString(), ErrorMessage.local_message_load_config_fail);
        }
        byte[] toBytes;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.APP_ISSUER_PREPARE_RESULT);
        try {
            ITag createTag = messageHandler.createTag((byte) TagName.SIR);
            createTag.addValue(bArr);
            createMessage.addTag(createTag);
            toBytes = createMessage.toBytes();
            try {
                System.out.println(FM_Bytes.bytesToHexString(toBytes));
            } catch (FMCommunicationMessageException e2) {
                e = e2;
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(FM_Int.replace(5, "斬ｑ消恬夂琏噤凵玢弗帠！")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(chars)).append(CRCUtil.substring(286, "旽：淉怣奓瑄嘥冢玳弌帡")).toString(), ErrorMessage.local_message_message_handle_exception, false);
                server4Business = this.f9732j.getServer4Business(TradeCode.APP_ISSUER_PREPARE_RESULT);
                if (server4Business == null) {
                    this.f9732j.businessReady(chars, server4Business);
                    interaction = this.f9732j.interaction(toBytes, chars, false, server4Business);
                    if (this.f9730h != null) {
                        this.f9730h.warn(this.f9731i, FM_Long.copyValueOf("幺叶备理乇勻讠氖奠赫", 1));
                    }
                    this.f9732j.throwExceptionAndClose(Util4Java.endsWith("丘动夔琑旨）朦攥刪帲厸咂廂攭挪", 5, 7), ErrorMessage.local_communication_no_response, false);
                    obj = new byte[2];
                    System.arraycopy(interaction, 0, obj, 0, obj.length);
                    if (!Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                        if (this.f9730h != null) {
                            this.f9730h.error(this.f9731i, new StringBuilder(FM_Exception.insert(2, 5, "庒産叁衙凜夘绗枕柫诱旮１帱厷奈瑗奧赾ze")).append(FM_Bytes.bytesToHexString(interaction)).toString());
                        }
                        this.f9732j.throwExceptionAndClose(FM_Int.replace(3, "廌畳厏衍凂夀给枑柵诱无５幯可夆球夹贮"), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
                    }
                    try {
                        createMessage = messageHandler.createMessage(TradeCode.APP_ISSUER_PREPARE_RESULT, Arrays.copyOfRange(interaction, 2, interaction.length));
                        tag4Id = createMessage.getTag4Id(-75);
                        if (tag4Id != null) {
                            if (tag4Id.getBytesVal()[0] != (byte) 0) {
                                return true;
                            }
                            if (this.f9730h != null) {
                                this.f9730h.warn(this.f9731i, String.format(FM_Exception.insert(TransportMediator.KEYCODE_MEDIA_RECORD, 55, "东劼奐琍寎戉｜夃琘纆析奲贿\n-G\u000b"), new Object[]{Byte.valueOf(r1[0])}));
                            }
                            tag4Id2 = createMessage.getTag4Id(-76);
                            if (tag4Id2 != null) {
                                issuerPrepareResult.setFailDesc(tag4Id2.getBytesVal());
                            }
                            return false;
                        }
                    } catch (Exception e3) {
                        if (this.f9730h != null) {
                            this.f9730h.error(this.f9731i, new StringBuilder(Util4Java.endsWith("庖畬受蠄凌奋绝柌柷讶无ｔ觹柌幭厰哏廐凼珸弈年4p", 5, 66)).append(Util4Java.getExceptionInfo(e3)).toString());
                        }
                        this.f9732j.throwExceptionAndClose(FM_Bytes.concat("店申厂蠇凅夜绀柗枦讹日＇覠柋帠叻哎序奢赮", 300, 24), ErrorMessage.local_message_message_handle_exception, false);
                    }
                    return false;
                }
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(FM_Long.copyValueOf("旸＇莿叓夆瑙盘帪厦奢赵", 6)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(Util4Java.endsWith("旻ｅ莲厗奙琟监幢厽夸赠", SyslogAppender.LOG_LOCAL2, 60)).toString(), ErrorMessage.local_app_query_server_fail);
            }
        } catch (Exception e32) {
            Exception exception = e32;
            toBytes = null;
            e = exception;
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(FM_Int.replace(5, "斬ｑ消恬夂琏噤凵玢弗帠！")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(chars)).append(CRCUtil.substring(286, "旽：淉怣奓瑄嘥冢玳弌帡")).toString(), ErrorMessage.local_message_message_handle_exception, false);
            server4Business = this.f9732j.getServer4Business(TradeCode.APP_ISSUER_PREPARE_RESULT);
            if (server4Business == null) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(FM_Long.copyValueOf("旸＇莿叓夆瑙盘帪厦奢赵", 6)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(Util4Java.endsWith("旻ｅ莲厗奙琟监幢厽夸赠", SyslogAppender.LOG_LOCAL2, 60)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9732j.businessReady(chars, server4Business);
            interaction = this.f9732j.interaction(toBytes, chars, false, server4Business);
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Long.copyValueOf("幺叶备理乇勻讠氖奠赫", 1));
            }
            this.f9732j.throwExceptionAndClose(Util4Java.endsWith("丘动夔琑旨）朦攥刪帲厸咂廂攭挪", 5, 7), ErrorMessage.local_communication_no_response, false);
            obj = new byte[2];
            System.arraycopy(interaction, 0, obj, 0, obj.length);
            if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
                if (this.f9730h != null) {
                    this.f9730h.error(this.f9731i, new StringBuilder(FM_Exception.insert(2, 5, "庒産叁衙凜夘绗枕柫诱旮１帱厷奈瑗奧赾ze")).append(FM_Bytes.bytesToHexString(interaction)).toString());
                }
                this.f9732j.throwExceptionAndClose(FM_Int.replace(3, "廌畳厏衍凂夀给枑柵诱无５幯可夆球夹贮"), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
            }
            createMessage = messageHandler.createMessage(TradeCode.APP_ISSUER_PREPARE_RESULT, Arrays.copyOfRange(interaction, 2, interaction.length));
            tag4Id = createMessage.getTag4Id(-75);
            if (tag4Id != null) {
                if (tag4Id.getBytesVal()[0] != (byte) 0) {
                    return true;
                }
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, String.format(FM_Exception.insert(TransportMediator.KEYCODE_MEDIA_RECORD, 55, "东劼奐琍寎戉｜夃琘纆析奲贿\n-G\u000b"), new Object[]{Byte.valueOf(r1[0])}));
                }
                tag4Id2 = createMessage.getTag4Id(-76);
                if (tag4Id2 != null) {
                    issuerPrepareResult.setFailDesc(tag4Id2.getBytesVal());
                }
                return false;
            }
            return false;
        }
        server4Business = this.f9732j.getServer4Business(TradeCode.APP_ISSUER_PREPARE_RESULT);
        if (server4Business == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(FM_Long.copyValueOf("旸＇莿叓夆瑙盘帪厦奢赵", 6)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(Util4Java.endsWith("旻ｅ莲厗奙琟监幢厽夸赠", SyslogAppender.LOG_LOCAL2, 60)).toString(), ErrorMessage.local_app_query_server_fail);
        }
        this.f9732j.businessReady(chars, server4Business);
        interaction = this.f9732j.interaction(toBytes, chars, false, server4Business);
        if (interaction == null || interaction.length < 1) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Long.copyValueOf("幺叶备理乇勻讠氖奠赫", 1));
            }
            this.f9732j.throwExceptionAndClose(Util4Java.endsWith("丘动夔琑旨）朦攥刪帲厸咂廂攭挪", 5, 7), ErrorMessage.local_communication_no_response, false);
        }
        obj = new byte[2];
        System.arraycopy(interaction, 0, obj, 0, obj.length);
        if (Arrays.equals(RespCodeonse4Platform.SUCESS, obj)) {
            if (this.f9730h != null) {
                this.f9730h.error(this.f9731i, new StringBuilder(FM_Exception.insert(2, 5, "庒産叁衙凜夘绗枕柫诱旮１帱厷奈瑗奧赾ze")).append(FM_Bytes.bytesToHexString(interaction)).toString());
            }
            this.f9732j.throwExceptionAndClose(FM_Int.replace(3, "廌畳厏衍凂夀给枑柵诱无５幯可夆球夹贮"), ErrorMessage.instance(FM_Bytes.bytesToHexString(obj)), false);
        }
        createMessage = messageHandler.createMessage(TradeCode.APP_ISSUER_PREPARE_RESULT, Arrays.copyOfRange(interaction, 2, interaction.length));
        tag4Id = createMessage.getTag4Id(-75);
        if (tag4Id != null) {
            if (tag4Id.getBytesVal()[0] != (byte) 0) {
                return true;
            }
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, String.format(FM_Exception.insert(TransportMediator.KEYCODE_MEDIA_RECORD, 55, "东劼奐琍寎戉｜夃琘纆析奲贿\n-G\u000b"), new Object[]{Byte.valueOf(r1[0])}));
            }
            tag4Id2 = createMessage.getTag4Id(-76);
            if (tag4Id2 != null) {
                issuerPrepareResult.setFailDesc(tag4Id2.getBytesVal());
            }
            return false;
        }
        return false;
    }

    public boolean issuer(String str, byte b, byte[] bArr, byte[] bArr2, byte[] bArr3) throws BusinessException {
        Exception e;
        String server4Business;
        this.f9729g = 1;
        String equals = FM_CN.equals("廌畡压蠇", 5);
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith("斨ｗ乂勴奖瑉宵谨乼稹", 1, 125)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(1, "旸５丞劮夞瑃嘸剆妍升奭财")).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(equals)).append(Util4Java.endsWith("时＀淐恫夔瑚噠丮稺＀涐怫酝署族仢勠輱天赡", 3, 44)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_CN.equals("斠ｋ勸輴NJ[宗丗鄂缮旖亴夢贡", 3)).toString(), ErrorMessage.local_message_load_config_fail);
        }
        byte[] toBytes;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.APP_ISSUER);
        try {
            ITag createTag = messageHandler.createTag((byte) TagName.APP_TYPE);
            createTag.addValue(new byte[]{b});
            createMessage.addTag(createTag);
            if (bArr2 != null && bArr2.length > 0) {
                createTag = messageHandler.createTag((byte) TagName.SEID);
                createTag.addValue(bArr2);
                createMessage.addTag(createTag);
            }
            if (bArr != null && bArr.length > 0) {
                createTag = messageHandler.createTag((byte) TagName.APP_AID);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
            }
            if (str != null && str.length() > 0) {
                createTag = messageHandler.createTag((byte) TagName.DEVICE_MODEL);
                createTag.addValue(str);
                createMessage.addTag(createTag);
            }
            if (bArr3 != null && bArr3.length > 0) {
                createTag = messageHandler.createTag((byte) TagName.PATCH_DATA);
                createTag.addValue(bArr3);
                createMessage.addTag(createTag);
            }
            toBytes = createMessage.toBytes();
            try {
                System.out.println(new StringBuilder(FM_Int.replace(3, ":.-hjby~Bvglylv?")).append(FM_Bytes.bytesToHexString(toBytes)).toString());
            } catch (FMCommunicationMessageException e2) {
                e = e2;
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Bytes.concat("乐浢亴遑匧叐卽旡～淅恧备琘嘱冮玿弈幽ｚ", 3, 27)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(FM_Exception.insert(4, 60, "丂洳交逆匹叅匱旺ｄ涌怯夘瑞噼冪玼彊帼"), ErrorMessage.local_message_message_handle_exception, false);
                server4Business = this.f9732j.getServer4Business(TradeCode.APP_ISSUER);
                if (server4Business == null) {
                    return FM_Bytes.isEnd9000(m13032a(toBytes, FM_Utils.regionMatches(334, 44, "且洽亲遘匯友匧"), messageHandler, server4Business));
                } else {
                    if (this.f9730h != null) {
                        this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(3, "旦７莱叇夘瑁盖帮厸奢赻")).toString());
                    }
                    throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Long.copyValueOf("旼＋莳受奚瑝盜带厢奾赩", 2)).toString(), ErrorMessage.local_app_query_server_fail);
                }
            }
        } catch (Exception e3) {
            Exception exception = e3;
            toBytes = null;
            e = exception;
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(FM_Bytes.concat("乐浢亴遑匧叐卽旡～淅恧备琘嘱冮玿弈幽ｚ", 3, 27)).append(Util4Java.getExceptionInfo(e)).toString());
            }
            this.f9732j.throwExceptionAndClose(FM_Exception.insert(4, 60, "丂洳交逆匹叅匱旺ｄ涌怯夘瑞噼冪玼彊帼"), ErrorMessage.local_message_message_handle_exception, false);
            server4Business = this.f9732j.getServer4Business(TradeCode.APP_ISSUER);
            if (server4Business == null) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(3, "旦７莱叇夘瑁盖帮厸奢赻")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Long.copyValueOf("旼＋莳受奚瑝盜带厢奾赩", 2)).toString(), ErrorMessage.local_app_query_server_fail);
            } else if (FM_Bytes.isEnd9000(m13032a(toBytes, FM_Utils.regionMatches(334, 44, "且洽亲遘匯友匧"), messageHandler, server4Business))) {
            }
        }
        server4Business = this.f9732j.getServer4Business(TradeCode.APP_ISSUER);
        if (server4Business == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(equals)).append(CRCUtil.substring(3, "旦７莱叇夘瑁盖帮厸奢赻")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(equals)).append(FM_Long.copyValueOf("旼＋莳受奚瑝盜带厢奾赩", 2)).toString(), ErrorMessage.local_app_query_server_fail);
        } else if (FM_Bytes.isEnd9000(m13032a(toBytes, FM_Utils.regionMatches(334, 44, "且洽亲遘匯友匧"), messageHandler, server4Business))) {
        }
    }

    public boolean issuer(byte[] bArr, int i, byte[] bArr2, byte[] bArr3) throws BusinessException {
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        this.f9729g = 0;
        return m13031a(i, bArr, bArr2, bArr3, Util4Java.endsWith("丝浹仡逆卲廞畩叉幌", 186, 87));
    }

    public boolean issuerVer2(byte[] bArr, int i, byte[] bArr2, byte[] bArr3) throws BusinessException {
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        this.f9729g = 0;
        return m13033b(i, bArr, bArr2, bArr3, BCCUtil.getChars("也浿仿途匠廀甯压帎", 5, 51));
    }

    public byte[] moveApp(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str) throws BusinessException {
        String chars = BCCUtil.getChars("匴专廉畩迄决", 5, 68);
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        if (this.f9730h != null) {
            this.f9730h.info(this.f9731i, CRCUtil.substring(4, "印世库町远冲}pg"));
        }
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(Util4Java.endsWith("－乎劦奞瑋对谲乼穣", 4, 83)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(Util4Java.endsWith("－乚勾多瑛噴剆姑协天赲", 4, 63)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(FM_CN.equals("１涆恰夔琇嘺乹種ｉ涞恨酕罧旝亽勼輰夯贪", 74)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_CN.equals("ｑ勮輢\u0004\u0000U宙九酈缸旀亮奸贿", 138)).toString(), ErrorMessage.local_message_load_config_fail);
        }
        ITag createTag;
        byte[] bArr3 = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.APP_MANAGER_VER2);
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    createTag = messageHandler.createTag((byte) TagName.ACTIVITY_INFO);
                    createTag.addValue(bArr);
                    createMessage.addTag(createTag);
                }
            } catch (Exception e) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(FM_CN.equals("ｕ淂恴夈琛噦冥珠彃幪ｙ", 230)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(chars)).append(CRCUtil.substring(3, "＜涓恩夕琚嘯冨班彊幫")).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        if (enumCardAppType != null) {
            createTag = messageHandler.createTag((byte) 14);
            createTag.addValue(enumCardAppType.getId());
            createMessage.addTag(createTag);
        }
        if (str != null && str.length() > 0) {
            createTag = messageHandler.createTag((byte) TagName.DEVICE_MODEL);
            createTag.addValue(str);
            createMessage.addTag(createTag);
        }
        if (bArr2 != null && bArr2.length > 0) {
            createTag = messageHandler.createTag((byte) TagName.SEID);
            createTag.addValue(bArr2);
            createMessage.addTag(createTag);
        }
        createTag = messageHandler.createTag((byte) TagName.APP_MANAGE_OPEATE_TYPE);
        createTag.addValue(EnumAppManageOperateType.APP_MOVE.getId());
        createMessage.addTag(createTag);
        bArr3 = createMessage.toBytes();
        String server4Business = this.f9732j.getServer4Business(TradeCode.APP_MANAGER_VER2);
        if (server4Business == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(CRCUtil.substring(4, "旧０莰叄夙瑎盗席厹奥赺")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(chars)).append(FM_Utils.regionMatches(5, 62, "斣？菦叙奉琍盍年厵夲赤")).toString(), ErrorMessage.local_app_query_server_fail);
        }
        bArr3 = m13032a(bArr3, chars, messageHandler, server4Business);
        ITag tag4Id;
        if (Arrays.equals(RespCodeonse4Platform.SUCESS, Arrays.copyOf(bArr3, 2))) {
            if (bArr3.length == 2) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, CRCUtil.substring(3, "庄申过秪幯厷奖瑛寄扃ｒ朣迀囁迋秮诤變硗"));
                }
                return null;
            }
            try {
                tag4Id = messageHandler.createMessage(TradeCode.APP_MANAGER_VER2, Arrays.copyOfRange(bArr3, 2, bArr3.length)).getTag4Id(-76);
                if (tag4Id != null) {
                    return tag4Id.getBytesVal();
                }
            } catch (Exception e2) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(Util4Java.endsWith("，觸枆帢厼哊庖敭挶盗陊助攴挱垅凯玠彉幾；", 3, 27)).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(chars)).append(FM_Int.replace(4, "ｕ覿柏幱叵哅废敾捿皐陓劺敭据埜凼玹弎帷")).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
        } else if (bArr3.length <= 2) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(FM_Bytes.concat("＋穲两叛卪广叽夊琉夡贴＞幠古哘庂－", 272, 1)).append(FM_Bytes.bytesToHexString(bArr3)).toString());
            }
            this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(chars)).append(FM_CN.equals("｛稲乴厛卺夽贸", 4)).toString(), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr3)), false);
        } else {
            try {
                tag4Id = messageHandler.createMessage(TradeCode.APP_MANAGER_VER2, Arrays.copyOfRange(bArr3, 2, bArr3.length)).getTag4Id(-76);
                if (tag4Id != null) {
                    this.f9723a = tag4Id.getBytesVal();
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(BCCUtil.getChars("參匶夭贤ｊ笧乙斬帩可彆帱b", 66, 69)).append(new String(this.f9723a)).toString());
                }
            } catch (Exception e22) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(chars)).append(FM_CN.equals("！席县奄瑗女贶（觶枖筻乁无彈帣敼捳弌幧ｊ", 154)).append(Util4Java.getExceptionInfo(e22)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(chars)).append(FM_Utils.regionMatches(4, 93, "ｘ帢叾夏瑎奴货ｓ覿枉笺乚早式帲攷挪弃幦")).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        return null;
    }

    public int orderExce(byte[] bArr, byte[] bArr2) throws BusinessException {
        String replace = FM_Int.replace(250, "乴诰匀房蠗");
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        if (this.f9730h != null) {
            this.f9730h.info(this.f9731i, CRCUtil.substring(244, "为议卂扥衁6m`"));
        }
        if (bArr == null || bArr.length < 1) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(replace)).append(FM_Bytes.concat("斫５丮诳匘缟史乻稧", 6, 28)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(BCCUtil.getChars("斣）併兠皑厇敥彇幭", 5, 48)).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(replace)).append(FM_Int.replace(SyslogAppender.LOG_LOCAL1, "ｑ业劢夂琏寵豮丨穯")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Long.copyValueOf("ｒ乁勹契瑔嘧剑如卐奲赥", 214)).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9732j.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(replace)).append(FM_Utils.regionMatches(3, 6, "｟淑怰夁琍噹中穧／涁恠酘罵旆亱勭輮奨赺")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Long.copyValueOf("＆劧轹U\u001f\u001c寂东鄟缡旋亿奷赦", 2)).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String str = null;
            Configration configration = this.f9732j.getConfigration();
            if (configration != null) {
                str = configration.getCompanyCode();
            } else if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(replace)).append(CRCUtil.substring(6, "日２J{q,<'97uexl-丢稹")).toString());
            }
            if (str == null) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(replace)).append(BCCUtil.getChars("旴３甴戮扖屍啖戺丰穽", 306, 125)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Utils.regionMatches(4, 86, "斢ｆ用扡戌屜唞批举稠")).toString(), ErrorMessage.local_business_para_error);
            }
            byte[] bArr3 = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.MAIN_ORDER_EXEC);
            try {
                ITag createTag = messageHandler.createTag((byte) TagName.MAIN_ORDER_ID);
                createTag.addValue(bArr);
                createMessage.addTag(createTag);
                if (bArr2 != null && bArr2.length > 0) {
                    createTag = messageHandler.createTag((byte) TagName.PATCH_DATA);
                    createTag.addValue(bArr2);
                    createMessage.addTag(createTag);
                }
                bArr3 = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(replace)).append(FM_CN.equals("｛淀怶奎琝噤凧玾彝幨｛", 4)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(FM_Int.replace(3, "ｔ淓怱夅琂噯凰玽弒師")).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            String server4Business = this.f9732j.getServer4Business(TradeCode.MAIN_ORDER_EXEC);
            if (server4Business == null) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(replace)).append(CRCUtil.substring(4, "旧０莰叄夙瑎盗席厹奥赺")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Utils.regionMatches(280, 9, "旾＝莭叕夈琓皚帴厠奨赧")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            bArr3 = m13032a(bArr3, replace, messageHandler, server4Business);
            if (FM_Bytes.isEnd9000(bArr3)) {
                if (this.f9730h != null) {
                    this.f9730h.info(this.f9731i, new StringBuilder(String.valueOf(replace)).append(CRCUtil.substring(4, "旧０夃琔宑托")).toString());
                }
                return 0;
            }
            if (this.f9730h != null) {
                this.f9730h.info(this.f9731i, new StringBuilder(String.valueOf(replace)).append(FM_Utils.regionMatches(3, 64, "斥？套琕奢贶扴蠟绀柏")).append(FM_Bytes.bytesToHexString(bArr3)).toString());
            }
            return -1;
        }
    }

    public boolean personlization(String str) throws BusinessException {
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        if (this.f9730h != null) {
            this.f9730h.info(this.f9731i, FM_CN.equals("匵乏廂畯串亳匌＃辌葨唘ｆn?,", 1));
        }
        String replace = FM_Int.replace(2, "匶乐廉用丩亼匟＄迟萷啓１");
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(replace)).append(BCCUtil.getChars("斤＀东勡奞瑒寷豩乸稦", 2, 26)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(Util4Java.endsWith("旷～乙勵奁琐噯刅姂卌奺赹", 4, 113)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(replace)).append(BCCUtil.getChars("斾＊涌怭奄瑘噴丠稢ｚ涜恽鄝缠斋仼勨輻夵货", 248, 30)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Int.replace(3, "斮ｗ勾轼PFM宗乙酞罸斞仪央货")).toString(), ErrorMessage.local_message_load_config_fail);
        }
        byte[] bArr = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.PERSONLIZATION);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    ITag createTag = messageHandler.createTag((byte) TagName.SIM_SEID);
                    createTag.addValue(str);
                    createMessage.addTag(createTag);
                }
            } catch (Exception e) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(replace)).append(FM_Int.replace(2, "斡ｖ淕息备琀噡凶玿弐席＂")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(replace)).append(FM_Long.copyValueOf("新ｏ淈怲奞瑑嘼冫現彉幰", NFCBaseActivity.TO_ADD)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        bArr = createMessage.toBytes();
        String server4Business = this.f9732j.getServer4Business(TradeCode.APP_MANAGER);
        if (server4Business != null) {
            return FM_Bytes.isEnd9000(m13032a(bArr, replace, messageHandler, server4Business));
        } else {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(replace)).append(FM_Utils.regionMatches(248, 64, "斾＄菿叞奌琎盌幻厸夹赭")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(replace)).append(FM_Long.copyValueOf("旻＆莰叒夅瑘盟師厥奣赪", 5)).toString(), ErrorMessage.local_app_query_server_fail);
        }
    }

    public void registerIssuerProcessHandler(IssuerProcessHandler issuerProcessHandler) {
        this.f9734l = issuerProcessHandler;
    }

    public boolean setApp(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str, EnumAppManageOperateType enumAppManageOperateType) throws BusinessException {
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        if (this.f9730h != null) {
            this.f9730h.info(this.f9731i, FM_Exception.insert(3, 69, "卦乆庅畾犭恁讻缤'\"|,r!c<y"));
        }
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Int.replace(3, "匹乑廊甩犲怆讴罣旦？丌劸夘琙寻豤串穱"));
            }
            throw new BusinessException(FM_Utils.regionMatches(120, 121, "匩之廎畻狺恄讠罹旦％丘劺夐琋噮剂妓升奻赦"), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Int.replace(1, "匷乓廈畷犴怄讶罥旸＝涜恸夞琛器丹穼％涄恠酟罻斟仭劾輼奵赢"));
            }
            throw new BusinessException(BCCUtil.getChars("匣不庘畹狠怚课缫旼＃勴輤J\u0002\u000f宗乛鄚缲斆亰奺贵", 114, 37), ErrorMessage.local_message_load_config_fail);
        }
        byte[] bArr3 = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.APP_MANAGER);
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    ITag createTag = messageHandler.createTag((byte) TagName.ACTIVITY_INFO);
                    createTag.addValue(bArr);
                    createMessage.addTag(createTag);
                }
            } catch (Exception e) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Bytes.concat("诤缹匵乛廚畣狾恄斴ｓ淔怶奒瑕嘸冷珺彅幼｛", 3, 125)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(FM_Exception.insert(4, 84, "讶缲危与廌甤状恕旾ｐ淘恫奜瑊器冮珸弞幨"), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        if (enumCardAppType != null) {
            createTag = messageHandler.createTag((byte) 14);
            createTag.addValue(enumCardAppType.getId());
            createMessage.addTag(createTag);
        }
        if (str != null && str.length() > 0) {
            createTag = messageHandler.createTag((byte) TagName.DEVICE_MODEL);
            createTag.addValue(str);
            createMessage.addTag(createTag);
        }
        if (bArr2 != null && bArr2.length > 0) {
            createTag = messageHandler.createTag((byte) TagName.SEID);
            createTag.addValue(bArr2);
            createMessage.addTag(createTag);
        }
        if (enumAppManageOperateType == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, BCCUtil.getChars("语缡卪不廗男犭恖斥＃沪李佣兺忞诩罽皋狽恆", 3, 92));
            }
            throw new BusinessException(FM_Exception.insert(3, 59, "讹缬匼丒廇甦狿怅斩６泴朙佫兣忄询罹盖犻恉"), ErrorMessage.local_business_para_error);
        }
        createTag = messageHandler.createTag((byte) TagName.APP_MANAGE_OPEATE_TYPE);
        createTag.addValue(enumAppManageOperateType.getId());
        createMessage.addTag(createTag);
        bArr3 = createMessage.toBytes();
        String server4Business = this.f9732j.getServer4Business(TradeCode.APP_MANAGER);
        if (server4Business == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Int.replace(2, "匶乐廉用刣院旿旺＃莥參夜琝皚干叴夶贯"));
            }
            throw new BusinessException(CRCUtil.substring(4, "印世库町刽阬斥斨ｅ菣厉夎琓的幸另奰赩"), ErrorMessage.local_app_query_server_fail);
        }
        bArr3 = m13032a(bArr3, FM_Long.copyValueOf("讵罦卤丈廋畴狯恗斥", 3), messageHandler, server4Business);
        if (FM_Bytes.isEnd9000(bArr3)) {
            return true;
        }
        if (bArr3.length <= 2) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(FM_Utils.regionMatches(5, 46, "诫罭匰乕庙畳犿怖斳？稻乢双匪帪号契琅夠赺！幨厹哚廑ｉ")).append(FM_Bytes.bytesToHexString(bArr3)).toString());
            }
            this.f9732j.throwExceptionAndClose(FM_Exception.insert(3, 120, "讹缱匶久廓畷狡恎斱３穭丢取卾夦贪"), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr3)), false);
        } else {
            try {
                if (messageHandler.createMessage(TradeCode.APP_ISSUER_VER2, Arrays.copyOfRange(bArr3, 2, bArr3.length)).getTag4Id(-76) != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Int.replace(2, "诩缴匼上店甮犿怍旹＞叄卹太贻－笨与斳幾叠弑帮5")).append(new String(this.f9723a)).toString());
                }
            } catch (Exception e2) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Int.replace(5, "诤缳卡三庒甡犺怎旤９４幨叮夅琂夶贯！觳枃笺丐斥弝幺攵挦彉并ｋ")).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                this.f9732j.throwExceptionAndClose(FM_Long.copyValueOf("讲罧卧三应畵独恖斢｝ｂ常厸奁瑄奮赹ｕ覵柃筼乄旳彅幼攱捰弙帠", 4), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        return false;
    }

    public boolean setAppVer2(byte[] bArr, EnumCardAppType enumCardAppType, byte[] bArr2, String str, EnumAppManageOperateType enumAppManageOperateType) throws BusinessException {
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        if (this.f9730h != null) {
            this.f9730h.info(this.f9731i, FM_Long.copyValueOf("匹也廆畧狺恈诸缭hke&8 %&", AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED));
        }
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_CN.equals("匷乍廌畡犬怊订罣斨ｃ乚勰奆琕寽豴丼稭", 3));
            }
            throw new BusinessException(CRCUtil.substring(148, "占丆広番狻恙诽缠斯（丕劻夁琖噳剛妚半奶起"), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Long.copyValueOf("卫不庐甩狨恚详缻斤ｃ淄怦奂瑅嘨乧稠｛淜怾鄃缥族亳勢轢夭贼", 2));
            }
            throw new BusinessException(FM_Exception.insert(90, 59, "匿专廀甧狼怄课缵无｝劬輺V\u001c_寉乇鄄罪斘京夤赵"), ErrorMessage.local_message_load_config_fail);
        }
        byte[] bArr3 = null;
        IMessage createMessage = messageHandler.createMessage((int) TradeCode.APP_MANAGER_VER2);
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    ITag createTag = messageHandler.createTag((byte) TagName.ACTIVITY_INFO);
                    createTag.addValue(bArr);
                    createMessage.addTag(createTag);
                }
            } catch (Exception e) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Bytes.concat("诤缱匥七庚畻狮怜旴＋淄怾夒琝器冿珺弍帬ｃ", 3, 101)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(FM_Utils.regionMatches(3, 32, "语罽卲乙廇画犥恒斥？涛怼套琕噻冩珣弑師"), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        if (enumCardAppType != null) {
            createTag = messageHandler.createTag((byte) 14);
            createTag.addValue(enumCardAppType.getId());
            createMessage.addTag(createTag);
        }
        if (str != null && str.length() > 0) {
            createTag = messageHandler.createTag((byte) TagName.DEVICE_MODEL);
            createTag.addValue(str);
            createMessage.addTag(createTag);
        }
        if (bArr2 != null && bArr2.length > 0) {
            createTag = messageHandler.createTag((byte) TagName.SEID);
            createTag.addValue(bArr2);
            createMessage.addTag(createTag);
        }
        if (enumAppManageOperateType == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, Util4Java.endsWith("访缺卦乐廙用狥恇旯｀沾望佥兽徎诠罿皀狡怋", 4, 83));
            }
            throw new BusinessException(FM_Int.replace(196, "讧署卾么廑畠狽恏斧ｘ泶杓佽儥忆诸缧盈狹恓"), ErrorMessage.local_business_para_error);
        }
        createTag = messageHandler.createTag((byte) TagName.APP_MANAGE_OPEATE_TYPE);
        createTag.addValue(enumAppManageOperateType.getId());
        createMessage.addTag(createTag);
        bArr3 = createMessage.toBytes();
        String server4Business = this.f9732j.getServer4Business(TradeCode.APP_MANAGER_VER2);
        if (server4Business == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, FM_Utils.regionMatches(1, 19, "匰与広產刽阴斵斠％莫叙奆瑓盌帨叾夰贱"));
            }
            throw new BusinessException(BCCUtil.getChars("匵丈庄甶刬陾斾斠ｈ菥取夊琚皎幫厶奥赧", 4, 14), ErrorMessage.local_app_query_server_fail);
        }
        bArr3 = m13032a(bArr3, FM_Long.copyValueOf("讵罦卤丈廋畴狯恗斥", 3), messageHandler, server4Business);
        if (FM_Bytes.isEnd9000(bArr3)) {
            return true;
        }
        if (bArr3.length <= 2) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(FM_Bytes.concat("诤缪卯乒庖畤犠态於８稤严厃卽幵厠夞瑂夿赽ｎ广厦响廞．", 3, 74)).append(FM_Bytes.bytesToHexString(bArr3)).toString());
            }
            this.f9732j.throwExceptionAndClose(FM_Utils.regionMatches(SyslogAppender.LOG_LOCAL7, 93, "讶罫匣丕庈畱狠怒旦ａ稰个叕匠夯贾"), ErrorMessage.instance(FM_Bytes.bytesToHexString(bArr3)), false);
        } else {
            try {
                if (messageHandler.createMessage(TradeCode.APP_ISSUER_VER2, Arrays.copyOfRange(bArr3, 2, bArr3.length)).getTag4Id(-76) != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Exception.insert(3, 12, "讹罽卾丁広畫狹恚斱｟厎卪夦账＃笷乎旪帬去录帻#")).append(new String(this.f9723a)).toString());
                }
            } catch (Exception e2) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Int.replace(BusinessCode.CURRENCY_CODE_RMB, "讯罺卶丐庉用犵怇旿＀＃幡句夜琝夯赤ｈ覤柚筡乙旪彔幡攬挱彀幽ｒ")).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                this.f9732j.throwExceptionAndClose(CRCUtil.substring(4, "讯署卦丘庉畠狥恟斿ｘｓ幹句处琍大赤｀覴柒筡乑斺弌帡整捡弘幽"), ErrorMessage.local_message_message_handle_exception, false);
            }
        }
        return false;
    }

    public int setCardBusinessStatus(EnumCardBusinessOpType enumCardBusinessOpType, String str, String str2, int i, byte[] bArr, byte[] bArr2, String str3) throws BusinessException {
        String concat = FM_Bytes.concat("七勩诵赫z逄讱", 194, 15);
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        if (this.f9730h != null) {
            this.f9730h.info(this.f9731i, FM_Utils.regionMatches(122, 55, "乐加诺财i遝讶e,w"));
        }
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("ｐ万势奛理寸谣乹穾", 5, 33)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_CN.equals("ｘ也勷奃琞噡切姀半奼赻", 1)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(FM_Utils.regionMatches(112, 35, "ｌ涋恩奍瑊噧丨稯")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(CRCUtil.substring(2, "＃涒恪夔琝嘮乫稦")).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (enumCardBusinessOpType == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(CRCUtil.substring(2, "＃伺兠皔擖会簪埗斧攚")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("＊伣入皙擗佋籯垚旮敃", 286)).toString(), ErrorMessage.local_business_para_error);
        } else if (str == null || str.length() < 1) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(CRCUtil.substring(4, "＝似兢皖扖杲厤硟斩攜")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(CRCUtil.substring(6, "？伾公皐扔杰厢硁斫攞")).toString(), ErrorMessage.local_business_para_error);
        } else if (str2 == null || str2.length() < 1) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("ｐ伹关盗匱万庞畯廋刖厩斻敐", 108, 93)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Int.replace(3, "ｔ佻儻皅卥不庞甥废刄叡旹敔")).toString(), ErrorMessage.local_business_para_error);
        } else {
            String server4Business = this.f9732j.getServer4Business(TradeCode.BUSINESS_ORDER_SETTING);
            if (server4Business == null) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(FM_Bytes.concat("斯１菶厓复琋盕带叩夬赤", 2, 36)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(concat)).append(FM_Exception.insert(2, 106, "旰｜菭厒夊琞皆帿厦奱贯")).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9732j.businessReady(concat, server4Business);
            byte[] bArr3 = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.BUSINESS_ORDER_SETTING);
            try {
                ITag createTag = messageHandler.createTag((byte) TagName.BUSINESS_ORDER_OP_TYPE);
                createTag.addValue((byte) enumCardBusinessOpType.getId());
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 5);
                createTag.addValue(str);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 15);
                createTag.addValue(str2);
                createMessage.addTag(createTag);
                if (i > 0) {
                    createTag = messageHandler.createTag((byte) TagName.CARD_APP_BLANCE);
                    createTag.addValue(i);
                    createMessage.addTag(createTag);
                }
                if (bArr != null && bArr.length > 1) {
                    createTag = messageHandler.createTag((byte) TagName.ORDER_TRADE_NO);
                    createTag.addValue(bArr);
                    createMessage.addTag(createTag);
                }
                if (bArr2 != null && bArr2.length > 1) {
                    createTag = messageHandler.createTag((byte) TagName.CARD_APP_VERSION);
                    createTag.addValue(bArr2);
                    createMessage.addTag(createTag);
                }
                if (str3 != null && str3.length() > 1) {
                    createTag = messageHandler.createTag((byte) TagName.CARD_BUSINESS_OP_RECOMMENED);
                    createTag.addValue(str3);
                    createMessage.addTag(createTag);
                }
                bArr3 = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(BCCUtil.getChars("~枘逦帣只讳汌攨挬弎幮/$", 2, 74)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(concat)).append(FM_Long.copyValueOf("%枂連平厭训氕攤挿奿赮", 1)).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            bArr3 = m13032a(bArr3, concat, messageHandler, server4Business);
            this.f9732j.businessFinish(true);
            if (FM_Bytes.isEnd9000(bArr3)) {
                return 0;
            }
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(concat)).append(FM_Utils.regionMatches(5, 79, "契瑂夢赧＝平县哓廙＆")).append(FM_Bytes.bytesToHexString(bArr3)).toString());
            }
            return FM_Bytes.bytesToInt(bArr3);
        }
    }

    public int setCardBusinessStatusVer2(EnumCardBusinessOpType enumCardBusinessOpType, String str, String str2, int i, byte[] bArr, byte[] bArr2, String str3, byte[] bArr3) throws BusinessException {
        String substring = CRCUtil.substring(3, "上劺认贼3遇诰");
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        if (this.f9730h != null) {
            this.f9730h.info(this.f9731i, FM_Exception.insert(5, 32, "专动诫赤&选诫g''"));
        }
        if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("．么勣奖瑄寫豣丨穸", 5, 112)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("ｑ丅勠备瑃噯剔姀卛夾赴", 224, 66)).toString(), ErrorMessage.local_business_init_fail);
        }
        IMessageHandler messageHandler = this.f9732j.getMessageHandler();
        if (messageHandler == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("％淀恨奂球嘬丹稸", 172, 63)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("５涖怬奌瑋嘺乭稦", 188, 5)).toString(), ErrorMessage.local_message_load_config_fail);
        } else if (enumCardBusinessOpType == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(FM_Exception.insert(190, 52, "ｎ佶兯盚擟会簡垅斢敞")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(FM_CN.equals("ｙ佦儲盌擔佖籠垇施攆", 2)).toString(), ErrorMessage.local_business_para_error);
        } else if (str == null || str.length() < 1) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(Util4Java.endsWith("＃伬公皂扈机厪硛斷攜", 274, 125)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(FM_Utils.regionMatches(3, 85, "｟佨典盖戌朦厦硇旻攘")).toString(), ErrorMessage.local_business_para_error);
        } else if (str2 == null || str2.length() < 1) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("ｕ伤兪皞卤业序畮廞剋厰斲攕", 2, 11)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(FM_Bytes.concat("ｔ佻儻皅卥不庞甥废刄叡旹敔", 1, 3)).toString(), ErrorMessage.local_business_para_error);
        } else {
            String server4Business = this.f9732j.getServer4Business(TradeCode.BUSINESS_ORDER_SETTING);
            if (server4Business == null) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(FM_Long.copyValueOf("旼＋莳受奚瑝盜带厢奾赩", 2)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(substring)).append(FM_Long.copyValueOf("旺％莱叕处瑛盞帤厤奠赫", 4)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            this.f9732j.businessReady(substring, server4Business);
            byte[] bArr4 = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.BUSINESS_ORDER_SETTING_VER2);
            try {
                ITag createTag = messageHandler.createTag((byte) TagName.BUSINESS_ORDER_OP_TYPE);
                createTag.addValue((byte) enumCardBusinessOpType.getId());
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 5);
                createTag.addValue(str);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 15);
                createTag.addValue(str2);
                createMessage.addTag(createTag);
                if (i > 0) {
                    createTag = messageHandler.createTag((byte) TagName.CARD_APP_BLANCE);
                    createTag.addValue(i);
                    createMessage.addTag(createTag);
                }
                if (bArr != null && bArr.length > 1) {
                    createTag = messageHandler.createTag((byte) TagName.ORDER_TRADE_NO);
                    createTag.addValue(bArr);
                    createMessage.addTag(createTag);
                }
                if (bArr2 != null && bArr2.length > 1) {
                    createTag = messageHandler.createTag((byte) TagName.CARD_APP_VERSION);
                    createTag.addValue(bArr2);
                    createMessage.addTag(createTag);
                }
                if (str3 != null && str3.length() > 1) {
                    createTag = messageHandler.createTag((byte) TagName.CARD_BUSINESS_OP_RECOMMENED);
                    createTag.addValue(str3);
                    createMessage.addTag(createTag);
                }
                if (bArr3 != null && bArr3.length > 0) {
                    createTag = messageHandler.createTag((byte) TagName.ACTIVITY_INFO);
                    createTag.addValue(bArr3);
                    createMessage.addTag(createTag);
                }
                bArr4 = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(FM_Bytes.concat("畲戰沼再\"柟逨幦厲诸汞改捸彁幨2$", 3, 45)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(substring)).append(FM_Int.replace(154, "#枖逵幫叫诩汃整捩夻质")).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            bArr4 = m13032a(bArr4, substring, messageHandler, server4Business);
            this.f9732j.businessFinish(true);
            if (FM_Bytes.isEnd9000(bArr4)) {
                return 0;
            }
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(substring)).append(CRCUtil.substring(4, "夕琚夶贷１帻厣咓廝ｎ")).append(FM_Bytes.bytesToHexString(bArr4)).toString());
            }
            return FM_Bytes.bytesToInt(bArr4);
        }
    }

    public boolean writeTicket(String str, byte[] bArr) throws BusinessException {
        String regionMatches = FM_Utils.regionMatches(5, TagName.ELECTRONIC_USE_COUNT, "畦遖凚礲");
        if (this.f9730h == null) {
            this.f9730h = LogFactory.getInstance().getLog();
        }
        if (this.f9730h != null) {
            this.f9730h.info(this.f9731i, FM_CN.equals("畫道凃礣2#0", 5));
        }
        if (str == null || str.length() < 1) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(2, 118, "斤ｄ當扣侫怯丬究")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(SportType.SPORT_TYPE_SWIM, "日２伩共皛厈攥彂平")).toString(), ErrorMessage.local_business_para_error);
        } else if (bArr == null || bArr.length < 1) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(FM_Exception.insert(362, 61, "斸＇礠格侣恰书穣")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(192, 13, "旦１佪儲盀厓攮弉帠")).toString(), ErrorMessage.local_business_para_error);
        } else if (this.f9732j == null) {
            if (this.f9730h != null) {
                this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(4, 36, "ｘ丂劽奄琂寱谭乪穮")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_Int.replace(1, "ｚ乃勽奛琄噭刕姀匘夠贱")).toString(), ErrorMessage.local_business_init_fail);
        } else {
            IMessageHandler messageHandler = this.f9732j.getMessageHandler();
            if (messageHandler == null) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(180, "ｍ淄怸奆瑋嘰丹穴５涌恠酗缫旗亭勦輬奭财")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_CN.equals("７劬輠\u001a\u001e\u0017寛乛酎罺斂亠奶赽", SyslogAppender.LOG_LOCAL5)).toString(), ErrorMessage.local_message_load_config_fail);
            }
            String companyCode;
            Configration configration = this.f9732j.getConfigration();
            if (configration != null) {
                companyCode = configration.getCompanyCode();
            } else {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(CRCUtil.substring(186, "斱～\u001e'=8`smka)$8a乶稭")).toString());
                }
                companyCode = null;
            }
            if (companyCode == null) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(BCCUtil.getChars("斣？畹戸戍展唏戰乿穹", 5, 62)).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("斳ｒ甿执扉尜啝扣丷稼", 206, 57)).toString(), ErrorMessage.local_business_para_error);
            }
            byte[] bArr2 = null;
            IMessage createMessage = messageHandler.createMessage((int) TradeCode.TICKET_MANAGER);
            try {
                ITag createTag = messageHandler.createTag((byte) TagName.BUSINESS_ORDER_OP_TYPE);
                createTag.addValue(93);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) 2);
                createTag.addValue(str);
                createMessage.addTag(createTag);
                createTag = messageHandler.createTag((byte) TagName.COMPANY_CODE);
                createTag.addValue(companyCode);
                createMessage.addTag(createTag);
                ITag createTag2 = messageHandler.createTag((byte) 17);
                createTag2.addValue(bArr);
                createMessage.addTag(createTag2);
                bArr2 = createMessage.toBytes();
            } catch (Exception e) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("ｐ涝怡夃瑆噱冨玻彆幥，", 5, 57)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9732j.throwExceptionAndClose(new StringBuilder(String.valueOf(regionMatches)).append(FM_Utils.regionMatches(2, 120, "～淂怭奞瑔嘢冸玪弐帲")).toString(), ErrorMessage.local_message_message_handle_exception, false);
            }
            companyCode = this.f9732j.getServer4Business(TradeCode.TICKET_MANAGER);
            if (companyCode == null) {
                if (this.f9730h != null) {
                    this.f9730h.warn(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(FM_Int.replace(4, "斯ｐ菨叔夁琎皏幽叡夥贲")).toString());
                }
                throw new BusinessException(new StringBuilder(String.valueOf(regionMatches)).append(FM_CN.equals("斣ｊ菠厞夝琌皟广厭奿赺", 2)).toString(), ErrorMessage.local_app_query_server_fail);
            }
            bArr2 = m13032a(bArr2, regionMatches, messageHandler, companyCode);
            if (FM_Bytes.isEnd9000(bArr2)) {
                if (this.f9730h != null) {
                    this.f9730h.info(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(FM_Int.replace(178, "旱＆変琖実戆")).toString());
                }
                return true;
            }
            if (this.f9730h != null) {
                this.f9730h.info(this.f9731i, new StringBuilder(String.valueOf(regionMatches)).append(FM_Bytes.concat("斮ｏ奊琟夵贪v戢蠜终枚", 1, 107)).append(FM_Bytes.bytesToHexString(bArr2)).toString());
            }
            return false;
        }
    }
}
