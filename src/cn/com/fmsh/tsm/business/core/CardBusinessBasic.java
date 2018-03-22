package cn.com.fmsh.tsm.business.core;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.CommunicationFactory;
import cn.com.fmsh.communication.CommunicationNotify;
import cn.com.fmsh.communication.TerminalCommunication;
import cn.com.fmsh.communication.TerminalCommunicationList;
import cn.com.fmsh.communication.core.LinkInfo;
import cn.com.fmsh.communication.core.TerminalInfo;
import cn.com.fmsh.communication.exception.SocketException;
import cn.com.fmsh.communication.message.IMessageHandler;
import cn.com.fmsh.communication.message.MessageHandleFactory;
import cn.com.fmsh.exception.InvalidParameterException;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.ScriptHandler;
import cn.com.fmsh.script.ScriptHandlerFactory;
import cn.com.fmsh.tsm.business.LocalDataHandler;
import cn.com.fmsh.tsm.business.SocketExceptionHandler;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.tsm.business.core.Configration.Key;
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
import cn.com.fmsh.util.algorithm.DES;
import cn.com.fmsh.util.algorithm.RSA;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.log4j.net.SyslogAppender;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CardBusinessBasic {
    /* synthetic */ FMLog f9739a = LogFactory.getInstance().getLog();
    private final /* synthetic */ String f9740b = CardBusinessBasic.class.getName();
    private final /* synthetic */ int f9741c = 1000;
    private /* synthetic */ TerminalCommunicationList f9742d = CommunicationFactory.getTerminalCommunicationList();
    private /* synthetic */ CommunicationNotify f9743e;
    private /* synthetic */ ApduHandler f9744f;
    private /* synthetic */ SocketExceptionHandler f9745g;
    private /* synthetic */ IMessageHandler f9746h;
    private /* synthetic */ Configration f9747i = null;
    private /* synthetic */ byte[] f9748j;
    private /* synthetic */ byte[] f9749k;
    private /* synthetic */ byte[] f9750l;
    private /* synthetic */ ScriptHandler f9751m = null;
    private /* synthetic */ LinkInfo f9752n;
    private /* synthetic */ ConfigKeyManager f9753o = new ConfigKeyManager();
    private /* synthetic */ LocalDataHandler f9754p;
    private /* synthetic */ ErrorCodeHandler f9755q;

    final /* synthetic */ boolean m13058a(TerminalCommunication terminalCommunication) {
        return terminalCommunication.isOpenSession();
    }

    final /* synthetic */ boolean m13059a(String str) throws BusinessException {
        TerminalCommunication terminalCommunication = this.f9742d.getTerminalCommunication(str);
        if (terminalCommunication == null) {
            if (this.f9739a != null) {
                this.f9739a.warn(this.f9740b, CRCUtil.substring(6, "筭刮旿８绗窥辋揥剻帥叱夽贲"));
            }
            throw new BusinessException(FM_Utils.regionMatches(5, 68, "笫利斫ｍ铻揬刽帢句奨贸"), ErrorMessage.local_communication_connect_fail);
        }
        if (!terminalCommunication.isConnect()) {
            terminalCommunication = connect(str);
        }
        if (terminalCommunication.isConnect()) {
            TerminalInfo terminalInfo = new TerminalInfo();
            Key[] keys = this.f9747i.getKeys(str);
            if (keys == null || keys.length < 1) {
                if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, BCCUtil.getChars("细章吁幢叢筭判询汔旡４酔罴斜仪丰朴宅三宇铧侢怫ｉ笸剷她赬", 318, 1));
                }
                throw new BusinessException(FM_Utils.regionMatches(4, 53, "纜竦呏幠厸笣刢记汞斧＊酖缾斂京丢杮寃乇宅钽侬恭；笲刱奧贮"), ErrorMessage.local_communication_no_key);
            }
            int nextInt = keys.length > 1 ? new Random().nextInt(keys.length) : 0;
            terminalInfo.setKeyIndex((byte) keys[nextInt].index);
            terminalInfo.setExponent(keys[nextInt].exponent);
            terminalInfo.setModulus(keys[nextInt].modulus);
            terminalInfo.setTerminalType(this.f9747i.getTerminalType());
            terminalInfo.setSecurityCode(this.f9750l);
            if (this.f9747i.getTerminalNumber() != null) {
                nextInt = this.f9747i.getTerminalNumber().length;
            }
            byte[] bArr = this.f9748j;
            if (bArr != null) {
                if (this.f9747i.getSdkVersion() != null && this.f9747i.getSdkVersion().length() > 0) {
                    bArr = FM_Bytes.join(FM_Bytes.join(bArr, new byte[]{(byte) 4, (byte) FM_Bytes.hexStringToBytes(this.f9747i.getSdkVersion()).length}), FM_Bytes.hexStringToBytes(this.f9747i.getSdkVersion()));
                }
                if (this.f9747i.getBusinessVersion() != null && this.f9747i.getBusinessVersion().length() > 0) {
                    bArr = FM_Bytes.join(FM_Bytes.join(bArr, new byte[]{(byte) 5, (byte) FM_Bytes.hexStringToBytes(this.f9747i.getBusinessVersion()).length}), FM_Bytes.hexStringToBytes(this.f9747i.getBusinessVersion()));
                }
            } else {
                if (this.f9747i.getSdkVersion() != null && this.f9747i.getSdkVersion().length() > 0) {
                    bArr = FM_Bytes.join(new byte[]{(byte) 4, (byte) this.f9747i.getSdkVersion().getBytes().length}, this.f9747i.getSdkVersion().getBytes());
                }
                if (this.f9747i.getBusinessVersion() != null && this.f9747i.getBusinessVersion().length() > 0) {
                    bArr = FM_Bytes.join(FM_Bytes.join(bArr, new byte[]{(byte) 5, (byte) FM_Bytes.hexStringToBytes(this.f9747i.getBusinessVersion()).length}), FM_Bytes.hexStringToBytes(this.f9747i.getBusinessVersion()));
                }
            }
            terminalInfo.setAppend(bArr);
            if (this.f9749k != null) {
                terminalInfo.setTerminalNumber(this.f9749k);
            } else {
                terminalInfo.setTerminalNumber(new byte[32]);
            }
            try {
                return terminalCommunication.openSession(terminalInfo, false);
            } catch (Exception e) {
                if (this.f9739a == null) {
                    this.f9739a = LogFactory.getInstance().getLog();
                }
                if (e.getExceptionType() != null) {
                    if (this.f9739a != null) {
                        this.f9739a.warn(this.f9740b, new StringBuilder(FM_Int.replace(3, "纐窴呏干叴筹刺诺汒夗琐夨费３\"")).append(e.getExceptionType().getDescription()).toString());
                    }
                } else if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, new StringBuilder(BCCUtil.getChars("纝窾吜幺厵笿刭议気夕琋奸赠－}", 5, 92)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                throw new BusinessException(FM_Exception.insert(284, 79, "终窠吏幾厬筵剪设汚奃琐头赱"), ErrorMessage.local_communication_sign_in_fail);
            } catch (Exception e2) {
                if (this.f9739a == null) {
                    this.f9739a = LogFactory.getInstance().getLog();
                }
                if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, new StringBuilder(FM_CN.equals("纝窩呆帻叩筴叙敼施攆ｅp", 2)).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                throw new BusinessException(CRCUtil.substring(230, "纛窱吘幧可筴受攰斫攞"), ErrorMessage.local_communication_sign_in_fail);
            } catch (Exception e22) {
                if (this.f9739a == null) {
                    this.f9739a = LogFactory.getInstance().getLog();
                }
                if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, new StringBuilder(Util4Java.endsWith("绊窵呃帹厲笤剢於ｎ罋绎弈帺 2", 5, 120)).append(Util4Java.getExceptionInfo(e22)).toString());
                }
                throw new BusinessException(FM_CN.equals("纐窦呋常召筳刮旹，缀纞彑幼", 5), ErrorMessage.local_communication_connect_fail);
            } catch (Exception e222) {
                if (this.f9739a == null) {
                    this.f9739a = LogFactory.getInstance().getLog();
                }
                if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, new StringBuilder(FM_CN.equals("纟窧呈帹叫筲刭旸ｓ遊侠攢挭弖帽，'", 4)).append(Util4Java.getExceptionInfo(e222)).toString());
                }
                throw new BusinessException(FM_Int.replace(1, "纞窶呍帬史筻券旽＂逋俵敧捴弟常"), ErrorMessage.local_communication_sign_in_fail);
            }
        }
        if (this.f9739a != null) {
            this.f9739a.warn(this.f9740b, FM_Bytes.concat("笵剧斵ｃ纓竨迍掺刻幤厳奾赾", 340, 12));
        }
        throw new BusinessException(CRCUtil.substring(5, "筬刭旾？铠揬剤帬厺奤败"), ErrorMessage.local_communication_connect_fail);
    }

    final /* synthetic */ boolean m13060b(String str) throws BusinessException {
        boolean z = false;
        TerminalCommunication terminalCommunication = this.f9742d.getTerminalCommunication(str);
        if (terminalCommunication != null) {
            try {
                z = terminalCommunication.closeSession(null);
            } catch (Exception e) {
                if (this.f9739a != null) {
                    this.f9739a.error(this.f9740b, new StringBuilder(FM_Utils.regionMatches(3, 3, "纛窹呈帯厯筼逅诿汉夊琗夥贲:")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                throw new BusinessException(FM_Bytes.concat("给竩吊幣叵笤遏讳氛奊瑅天质", 186, 117), ErrorMessage.local_communication_sign_out_fail);
            } catch (Exception e2) {
                if (this.f9739a != null) {
                    this.f9739a.error(this.f9740b, new StringBuilder(FM_Int.replace(200, "绕窯呒帵厹笲遏讥気斮ｗ佾儤盀厅攺断攘s")).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                throw new BusinessException(BCCUtil.getChars("纛竤呒幨厣筵遃讬汑施／佻其盏叁敫斳敃", 3, 56), ErrorMessage.local_communication_sign_out_fail);
            } catch (Exception e22) {
                if (this.f9739a != null) {
                    this.f9739a.error(this.f9740b, new StringBuilder(FM_CN.equals("纝窩呆帻叩筴逛读氟奊瑙斦ｍ罃统凮玵彔广x", 2)).append(Util4Java.getExceptionInfo(e22)).toString());
                }
                throw new BusinessException(FM_Bytes.concat("绗竬吖幸叿筭逗诬汝斵ｋ缚纓冩珧彙幧", SyslogAppender.LOG_LOCAL5, 4), ErrorMessage.local_communication_sign_out_fail);
            } catch (Exception e222) {
                if (this.f9739a != null) {
                    this.f9739a.error(this.f9740b, new StringBuilder(FM_CN.equals("练窳呜席县笾逑诵汑夀瑓新｛遒俸敺捵夈瑛彌幧p", SyslogAppender.LOG_LOCAL3)).append(Util4Java.getExceptionInfo(e222)).toString());
                }
                throw new BusinessException(FM_Long.copyValueOf("绅童吖幷叱笠遛讯気奖瑉斺ｅ遜侢攰挳奞瑑彖幩", 5), ErrorMessage.local_communication_sign_out_fail);
            }
        }
        return z;
    }

    public void businessFinish(boolean z) throws BusinessException {
        if (z && this.f9744f != null) {
            this.f9744f.close();
        }
    }

    public void businessReady(String str, String str2) throws BusinessException {
        TerminalCommunication terminalCommunication = this.f9742d.getTerminalCommunication(str2);
        if (terminalCommunication == null) {
            if (this.f9739a != null) {
                this.f9739a.warn(this.f9740b, new StringBuilder(String.valueOf(str)).append(FM_Bytes.concat("y纇窪辅援剷幮口夸贺", 2, 118)).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(str)).append(FM_Bytes.concat("k绞竮辒掲割幾厨奲贫", 244, 75)).toString(), ErrorMessage.local_communication_connect_fail);
        }
        if (!terminalCommunication.isConnect()) {
            terminalCommunication = connect(str2);
        }
        if (!terminalCommunication.isConnect()) {
            if (this.f9739a != null) {
                this.f9739a.warn(this.f9740b, new StringBuilder(String.valueOf(str)).append(FM_Exception.insert(4, 29, "(绍窭辁揹利幥厣奡质")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(str)).append(Util4Java.endsWith("\"纄竹辞掯剤幭司奣费", 5, 74)).toString(), ErrorMessage.local_communication_connect_fail);
        } else if (!m13058a(terminalCommunication) && !m13059a(str2)) {
            if (this.f9739a != null) {
                this.f9739a.warn(this.f9740b, new StringBuilder(String.valueOf(str)).append(FM_Exception.insert(3, 46, "'绝窬朻筡剽")).toString());
            }
            throw new BusinessException(new StringBuilder(String.valueOf(str)).append(FM_CN.equals("i绒竤筢刽奯赪", 342)).toString(), ErrorMessage.local_communication_sign_in_fail);
        }
    }

    public TerminalCommunication connect(String str) throws BusinessException {
        if (this.f9739a == null) {
            this.f9739a = LogFactory.getInstance().getLog();
        }
        if (this.f9739a != null) {
            this.f9739a.info(this.f9740b, new StringBuilder(Util4Java.endsWith("cpp39xny,x6", 3, 31)).append(str).append(FM_Exception.insert(4, 5, "&#<")).toString());
        }
        if (this.f9747i == null) {
            this.f9747i = getConfigration();
            if (this.f9747i == null) {
                if (this.f9739a == null) {
                    return null;
                }
                this.f9739a.warn(this.f9740b, FM_Int.replace(5, "钤揸到幰叶旿＀劯软庁田酖罰斆仲夶贯"));
                return null;
            }
        }
        LinkInfo linkInfo = this.f9747i.getLinkInfo(str);
        if (linkInfo != null) {
            TerminalCommunication terminalCommunication = this.f9742d.getTerminalCommunication(str);
            if (terminalCommunication != null) {
                terminalCommunication.registerCommunicationNotify(this.f9743e);
                if (terminalCommunication.isConnect()) {
                    return terminalCommunication;
                }
                try {
                    if (terminalCommunication.connect(linkInfo)) {
                        return terminalCommunication;
                    }
                    if (this.f9739a != null) {
                        this.f9739a.warn(this.f9740b, new StringBuilder(BCCUtil.getChars("钭掶剣幠厣H", 3, 64)).append(linkInfo.getAddress()).append(":").append(linkInfo.getPort()).append(FM_Int.replace(1, "\u000b斯ｐ钡控头购")).toString());
                    }
                    throw new BusinessException(FM_Exception.insert(178, 3, "铨掼刬幬厲冿珸彉并"), ErrorMessage.local_communication_connect_fail);
                } catch (InvalidParameterException e) {
                    if (this.f9739a != null) {
                        this.f9739a.warn(this.f9740b, FM_Long.copyValueOf("铳掯刷幷叱斨ｗ佸儰盖厍攼斩攎", 5));
                    }
                    throw new BusinessException(CRCUtil.substring(2, "铱掿刵幣叫新}佼儢厐攭弊師"), ErrorMessage.local_communication_connect_param_error);
                } catch (SocketException e2) {
                    if (this.f9739a != null) {
                        this.f9739a.warn(this.f9740b, new StringBuilder(BCCUtil.getChars("钪揧删席叼\u0001", 4, 78)).append(linkInfo.getAddress()).append(":").append(linkInfo.getPort()).append(FM_Exception.insert(4, 56, "U斶ｔ铮揭失赽")).toString());
                    }
                    throw new BusinessException(FM_Utils.regionMatches(100, 53, "钪掬刮帠司冧玢彅幤"), ErrorMessage.local_communication_connect_fail);
                }
            } else if (this.f9739a == null) {
                return null;
            } else {
                this.f9739a.warn(this.f9740b, CRCUtil.substring(186, "菰厄遇侩寍俕夸贱"));
                return null;
            }
        } else if (this.f9739a == null) {
            return null;
        } else {
            this.f9739a.warn(this.f9740b, BCCUtil.getChars("钭掭刭幡厷斪｝酋罵斗亳乷来实乐诫帰厨侬恭", 3, 21));
            return null;
        }
    }

    public InputStream decryptFile(String str) throws BusinessException {
        InputStream resourceAsStream = getClass().getResourceAsStream(str);
        byte[] bArr = new byte[128];
        byte[] bArr2 = new byte[512];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr3 = new byte[1];
        try {
            resourceAsStream.read(bArr3);
            if (resourceAsStream.read(bArr) < 128) {
                if (this.f9739a == null) {
                    this.f9739a = LogFactory.getInstance().getLog();
                }
                if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, CRCUtil.substring(3, "绘竴酋罿斛亱勲輠斾｟鄓罧斓仩冏宬斠攃ｚ杫讷剧PLK劣寈皝宂旈"));
                }
                throw new BusinessException(FM_Utils.regionMatches(3, 22, "纛竦酒罻旌亷勷轰旵５鄂缫旜仧冂室斳攁"), ErrorMessage.local_app_config_invaild_content);
            }
            while (true) {
                int read = resourceAsStream.read(bArr2);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(Arrays.copyOf(bArr2, read));
            }
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ConfigKey configKey = this.f9753o.getConfigKey(bArr3[0]);
            if (configKey == null) {
                if (this.f9739a == null) {
                    this.f9739a = LogFactory.getInstance().getLog();
                }
                if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, FM_Exception.insert(5, 122, "绁竬鄐缹旖亽勥輢斯｟坥鄊缯斜代寉钬雅吕为朻扵刵鄒缷旔亻伸畩盟宓铪"));
                }
                throw new BusinessException(FM_Long.copyValueOf("绅童酊罪斆亨勻輥斣～来戲剹鄋缭旇享", 5), ErrorMessage.local_app_config_invaild_content);
            }
            bArr = RSA.decrtyByPrivate(configKey.getPublicKey(), configKey.getPrivateKey(), bArr, false);
            if (bArr.length < 36) {
                if (this.f9739a == null) {
                    this.f9739a = LogFactory.getInstance().getLog();
                }
                if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, FM_Bytes.concat("鄔缱旂份敡挹施攋%]\u0006\u001a覢寁吃盗攩捱镺庭斱攟", 2, 102));
                }
                throw new BusinessException(FM_Bytes.concat("绗竭酈罦斌仸励轩旡６朷戾剳鄋缧旋亹", SyslogAppender.LOG_LOCAL5, 3), ErrorMessage.local_app_config_invaild_content);
            }
            Arrays.copyOf(bArr, 20);
            return new ByteArrayInputStream(FM_Bytes.byteRemovePatch4Des(DES.decrypt4des3(Arrays.copyOfRange(bArr, 20, 36), byteArrayOutputStream.toByteArray())));
        } catch (FileNotFoundException e2) {
            if (this.f9739a == null) {
                this.f9739a = LogFactory.getInstance().getLog();
            }
            if (this.f9739a != null) {
                this.f9739a.warn(this.f9740b, Util4Java.endsWith("绉窤酘缱旎以勽轺斧７术戱利鄎罣旐亷", 36, 74));
            }
            throw new BusinessException(FM_CN.equals("纞窨鄕缧斝份劼轰斨ｃ杪戯割酞罪斒仰", 3), ErrorMessage.local_app_load_config_fail);
        } catch (Exception e3) {
            if (this.f9739a == null) {
                this.f9739a = LogFactory.getInstance().getLog();
            }
            if (this.f9739a != null) {
                this.f9739a.warn(this.f9740b, new StringBuilder(Util4Java.endsWith("讶厕鄔缡旂仭凫玷弟師３", 112, 118)).append(Util4Java.getExceptionInfo(e3)).toString());
            }
            throw new BusinessException(FM_Long.copyValueOf("组竦酋罭文享勺輪斢｝杤戵剸鄈缬旘亪", 4), ErrorMessage.local_app_load_config_fail);
        } catch (Throwable th) {
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public void disconnect(String str) throws BusinessException {
        TerminalCommunication terminalCommunication = this.f9742d.getTerminalCommunication(str);
        if (terminalCommunication != null) {
            try {
                terminalCommunication.disconnect();
            } catch (Exception e) {
                if (this.f9739a == null) {
                    this.f9739a = LogFactory.getInstance().getLog();
                }
                if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, new StringBuilder(FM_CN.equals("兮闣纗窿响帡厳皐铻掳函珨彋幢ｑ", 298)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                throw new BusinessException(BCCUtil.getChars("儠閼纇窢哇帺厷盁钽揤冥班彙幡", 3, TransportMediator.KEYCODE_MEDIA_PLAY));
            }
        }
    }

    public void disconnectAll() throws BusinessException {
        try {
            this.f9742d.disConnect();
        } catch (Exception e) {
            if (this.f9739a == null) {
                this.f9739a = LogFactory.getInstance().getLog();
            }
            if (this.f9739a != null) {
                this.f9739a.warn(this.f9740b, new StringBuilder(FM_Utils.regionMatches(2, 117, "儡閪纔窾哊幨叠皁铤措凾珩彌幻ｂ")).append(Util4Java.getExceptionInfo(e)).toString());
            }
            throw new BusinessException(Util4Java.endsWith("優闤绑竦咕帺厩盍钧掬凣玹弛幱", ReportInfoUtils.FEEDBACK_FAILED, 16));
        }
    }

    public ApduHandler getApduHandler() {
        return this.f9744f;
    }

    public Configration getConfigration() {
        boolean z = false;
        if (this.f9747i == null) {
            try {
                InputStream decryptFile = decryptFile(Util4Java.endsWith(".*z%t*n!j.?c9", 4, 71));
                if (decryptFile != null) {
                    z = loadDefine(decryptFile);
                }
                if (!z) {
                    if (this.f9739a == null) {
                        return null;
                    }
                    this.f9739a.warn(this.f9740b, FM_Utils.regionMatches(240, TagName.ELECTRONIC_USE_COUNT, "钾揲剾帶召日＆务轥庛甮鄐缺旌亴奨赵"));
                    return null;
                }
            } catch (BusinessException e) {
                if (this.f9739a == null) {
                    return null;
                }
                this.f9739a.warn(this.f9740b, FM_Long.copyValueOf("脑朤触枒嘷剁妒區斥｜勭輷廓畬鄌缰旜亮奤起", 3));
                return null;
            }
        }
        return this.f9747i;
    }

    public ErrorCodeHandler getErrorCodeHandler() {
        if (this.f9755q == null) {
            InputStream decryptFile;
            this.f9755q = new ErrorCodeHandler();
            try {
                decryptFile = decryptFile(FM_Int.replace(4, "v?0f`&{|~drhiifu"));
            } catch (Exception e) {
                if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, new StringBuilder(FM_Long.copyValueOf("劬轴幵右响廉辝溳嘼冫現彉幰", 4)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                decryptFile = null;
            }
            if (!this.f9755q.init(decryptFile)) {
                this.f9755q = null;
            }
        }
        return this.f9755q;
    }

    public LocalDataHandler getLocalDataHandler() {
        return this.f9754p;
    }

    public IMessageHandler getMessageHandler() {
        boolean z = false;
        if (this.f9746h == null) {
            InputStream decryptFile;
            try {
                decryptFile = decryptFile(FM_CN.equals("y*=:ij{hp7-=", 3));
            } catch (BusinessException e) {
                if (this.f9739a == null) {
                    this.f9739a = LogFactory.getInstance().getLog();
                }
                if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, FM_Exception.insert(5, 30, "莾发淍怬夅琙旫ｗ勹轪涝怼鄜罡斊亽奸财"));
                }
                decryptFile = null;
            }
            if (decryptFile != null) {
                z = messageConfigLoad(decryptFile);
            }
            if (!z) {
                if (this.f9739a == null) {
                    this.f9739a = LogFactory.getInstance().getLog();
                }
                if (this.f9739a == null) {
                    return null;
                }
                this.f9739a.warn(this.f9740b, FM_CN.equals("菤厒涝恩夓琎斯ｆ勻輱涕恡酒罾斆交奲赱", 224));
                return null;
            }
        }
        return this.f9746h;
    }

    public ScriptHandler getScriptHandler() {
        if (this.f9747i == null) {
            this.f9747i = getConfigration();
            if (this.f9747i == null) {
                if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, CRCUtil.substring(4, "铯掹刷幡叭斾｟勾輴廀畷酇罻文份大赤"));
                }
                return null;
            }
        }
        if (this.f9751m == null) {
            this.f9751m = ScriptHandlerFactory.getInstance().getScriptHandler(getApduHandler());
            this.f9751m.setApduFilterDataInit(new ApduFilterDataInitImpl(this.f9747i.getAids()));
        } else {
            this.f9751m.setApduHandler(getApduHandler());
        }
        return this.f9751m;
    }

    public byte[] getSecurityCode() {
        return this.f9750l;
    }

    public String getServer4Business(int i) {
        return getConfigration().getServer4Business(i);
    }

    public SocketExceptionHandler getSocketExceptionHandler() {
        return this.f9745g;
    }

    public TerminalCommunication getTerminalCommunication(String str) {
        return this.f9742d.getTerminalCommunication(str);
    }

    public byte[] getTerminalNumber() {
        return this.f9749k;
    }

    public byte[] interaction(byte[] bArr, String str, boolean z, String str2) throws BusinessException {
        byte[] bArr2 = null;
        TerminalCommunication terminalCommunication = this.f9742d.getTerminalCommunication(str2);
        if (terminalCommunication != null) {
            try {
                bArr2 = terminalCommunication.sendMessage(bArr);
            } catch (Exception e) {
                if (this.f9739a == null) {
                    this.f9739a = LogFactory.getInstance().getLog();
                }
                if (this.f9739a != null) {
                    this.f9739a.error(this.f9740b, new StringBuilder(String.valueOf(str)).append(Util4Java.endsWith("-绝窦同帢叵诮氏旷ｙ友敭当帽c-", 4, 52)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                throwExceptionAndClose(FM_Long.copyValueOf("练竧吔幱厯讫氛斠｟厒攽彈广", 3), ErrorMessage.local_communication_request_param_error, z);
            } catch (Exception e2) {
                if (this.f9739a == null) {
                    this.f9739a = LogFactory.getInstance().getLog();
                }
                if (this.f9739a != null) {
                    this.f9739a.error(this.f9740b, new StringBuilder(String.valueOf(str)).append(BCCUtil.getChars("r绊窽吓幡厲该氀斤．\u0001mq)w6遈俣彐帺(b", 2, 48)).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                throwExceptionAndClose(FM_CN.equals("绁竵吚帯厽让氍斶＝Q|g>##遒俸弈帣", 182), ErrorMessage.local_communication_connect_fail, z);
            } catch (Exception e22) {
                if (this.f9739a != null) {
                    this.f9739a.error(this.f9740b, new StringBuilder(String.valueOf(str)).append(FM_Utils.regionMatches(3, 2, "s纝窸呈帨厭讨汃旵）逝俨敻捣弍帩)5")).append(Util4Java.getExceptionInfo(e22)).toString());
                }
                throwExceptionAndClose(CRCUtil.substring(3, "绘竴吗幢召记氐斫ｄ\u00001jz~透価彉幮"), ErrorMessage.local_communication_connect_fail, z);
            }
            if (bArr2 == null || bArr2.length < 2) {
                if (this.f9739a == null) {
                    this.f9739a = LogFactory.getInstance().getLog();
                }
                if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, FM_CN.equals("師厹奞瑍丆劬诩汍失赴n杹敲別幵叧哅廍攺挵", 5));
                }
                throwExceptionAndClose(FM_Utils.regionMatches(1, 117, "纙窩告帣厵语汍旲５朤攵剨帾厲咚廘攱捸"), ErrorMessage.local_communication_no_response, z);
            }
        } else if (this.f9739a != null) {
            this.f9739a.warn(this.f9740b, new StringBuilder(FM_Long.copyValueOf("丗劫夃琂旷r菬厎带厢違侭宰谧\u0018", 5)).append(str2).append(FM_Int.replace(68, "D夭贺")).toString());
        }
        return bArr2;
    }

    public boolean loadDefine(InputStream inputStream) throws BusinessException {
        this.f9747i = new Configration();
        if (inputStream == null) {
            throw new BusinessException(FM_Utils.regionMatches(5, 1, "纝窹鄚缶旞京勻輡奬赻"));
        }
        try {
            int i;
            int i2;
            NamedNodeMap attributes;
            Node namedItem;
            Node namedItem2;
            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement();
            NodeList elementsByTagName = documentElement.getElementsByTagName(FM_Utils.regionMatches(5, 2, "\u00062+-8-"));
            for (i = 0; i < elementsByTagName.getLength(); i++) {
                String str = null;
                int i3 = -1;
                i2 = 0;
                String str2 = null;
                attributes = elementsByTagName.item(i).getAttributes();
                namedItem = attributes.getNamedItem(FM_CN.equals("o3 ?&.", 280));
                if (namedItem != null) {
                    str = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem(FM_Long.copyValueOf("?,45%oTvyt", 68));
                if (namedItem != null) {
                    str2 = namedItem.getNodeValue();
                }
                namedItem = attributes.getNamedItem(CRCUtil.substring(5, "brzg"));
                if (namedItem != null) {
                    i3 = Util4Java.String2Int(namedItem.getNodeValue(), -1);
                }
                namedItem2 = attributes.getNamedItem(Util4Java.endsWith("t4l(2\u000bz*>`6c", 42, 52));
                if (namedItem2 != null) {
                    i2 = Util4Java.String2Int(namedItem2.getNodeValue(), 0);
                }
                this.f9747i.addServers(str, i3, i2, str2);
            }
            NamedNodeMap attributes2 = documentElement.getElementsByTagName(FM_Exception.insert(HttpStatus.SC_MOVED_TEMPORARILY, 10, "Fy4=3% 4")).item(0).getAttributes();
            Node namedItem3 = attributes2.getNamedItem(CRCUtil.substring(5, "fdxv"));
            if (namedItem3 != null) {
                this.f9747i.setTerminalType(FM_Bytes.hexStringToBytes(namedItem3.getNodeValue()));
            }
            namedItem3 = attributes2.getNamedItem(FM_Exception.insert(192, 46, "&'s'2o+uB'bm%u&"));
            if (namedItem3 != null) {
                this.f9747i.setBusinessVersion(namedItem3.getNodeValue());
            }
            Node namedItem4 = attributes2.getNamedItem(CRCUtil.substring(2, "|~nF~4\"5(<"));
            if (namedItem4 != null) {
                this.f9747i.setSdkVersion(namedItem4.getNodeValue());
            }
            NodeList elementsByTagName2 = documentElement.getElementsByTagName(FM_CN.equals("J$#=;Idi=*", 146));
            if (elementsByTagName2 != null) {
                namedItem4 = elementsByTagName2.item(0);
                if (namedItem4 != null) {
                    namedItem4 = namedItem4.getAttributes().getNamedItem(FM_CN.equals(" &4<", 3));
                    if (namedItem4 != null) {
                        this.f9747i.setOrderSource(Util4Java.String2Byte(namedItem4.getNodeValue(), (byte) 0));
                    } else if (this.f9739a != null) {
                        this.f9739a.warn(this.f9740b, Util4Java.endsWith("酏缧旗仡丳讧匙朶溊丌匍呤说午条溛偮盝攰捩顷", 5, 103));
                    }
                } else if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, FM_CN.equals("鄔缤斜仺丰讬匊朵滑也卆吿敵捸顾", 230));
                }
            } else if (this.f9739a != null) {
                this.f9739a.warn(this.f9740b, FM_CN.equals("鄚缦旞亼朱宖乔讬匊朵滑", 4));
            }
            elementsByTagName2 = documentElement.getElementsByTagName(Util4Java.endsWith("Cbwwu/7\u0018'1g", 3, 13));
            if (elementsByTagName2 != null) {
                namedItem4 = elementsByTagName2.item(0);
                if (namedItem4 != null) {
                    namedItem4 = namedItem4.getAttributes().getNamedItem(FM_Bytes.concat("g/58", 274, 29));
                    if (namedItem4 != null) {
                        this.f9747i.setCompanyCode(namedItem4.getNodeValue());
                    } else if (this.f9739a != null) {
                        this.f9739a.warn(this.f9740b, CRCUtil.substring(76, "鄔缪旈京丈匕吰厄啗缊硆侳怲"));
                    }
                } else if (this.f9739a != null) {
                    this.f9739a.warn(this.f9740b, FM_Int.replace(4, "鄔缲旘仴厇啎缝砏俰恻业匟吶数捭顿"));
                }
            } else if (this.f9739a != null) {
                this.f9739a.warn(this.f9740b, CRCUtil.substring(76, "鄔缪旈京术宊乒厄啗缊硆"));
            }
            elementsByTagName = documentElement.getElementsByTagName(BCCUtil.getChars("\u001fq-", 4, 64));
            String str3 = "";
            for (i = 0; i < elementsByTagName.getLength(); i++) {
                attributes = elementsByTagName.item(i).getAttributes();
                int i4 = -1;
                byte[] bArr = null;
                byte[] bArr2 = null;
                String str4 = "";
                namedItem = attributes.getNamedItem(FM_Long.copyValueOf("ci`d&", 2));
                if (namedItem != null) {
                    i4 = Integer.parseInt(namedItem.getNodeValue());
                }
                namedItem = attributes.getNamedItem(FM_CN.equals("20)%uisz", 4));
                if (namedItem != null) {
                    bArr = FM_Bytes.hexStringToBytes(namedItem.getNodeValue());
                }
                namedItem = attributes.getNamedItem(Util4Java.endsWith("2*/$;(p", 98, 6));
                if (namedItem != null) {
                    bArr2 = FM_Bytes.hexStringToBytes(namedItem.getNodeValue());
                }
                namedItem2 = attributes.getNamedItem(BCCUtil.getChars("&-i8$f\t{`%", 5, 83));
                if (namedItem2 != null) {
                    str4 = namedItem2.getNodeValue();
                }
                if (!(str4 == null && (bArr == null || bArr2 == null || i4 == -1))) {
                    this.f9747i.addKey(str4, i4, bArr, bArr2);
                }
            }
            NodeList elementsByTagName3 = documentElement.getElementsByTagName(FM_Utils.regionMatches(1, 73, "\u0010sg"));
            for (i = 0; i < elementsByTagName3.getLength(); i++) {
                Node namedItem5 = elementsByTagName3.item(i).getAttributes().getNamedItem(Util4Java.endsWith("w(},d", 4, 72));
                if (namedItem5 != null) {
                    this.f9747i.addAid(FM_Bytes.hexStringToBytes(namedItem5.getNodeValue()));
                }
            }
            NodeList elementsByTagName4 = documentElement.getElementsByTagName(FM_Bytes.concat("Ocla0?\u00140#\u0003<p}qo", 150, 9));
            String str5 = null;
            i2 = -1;
            for (i = 0; i < elementsByTagName4.getLength(); i++) {
                NamedNodeMap attributes3 = elementsByTagName4.item(i).getAttributes();
                Node namedItem6 = attributes3.getNamedItem(FM_Bytes.concat("*{q>h Y=l#", 2, 69));
                if (namedItem6 != null) {
                    str5 = namedItem6.getNodeValue();
                }
                Node namedItem7 = attributes3.getNamedItem(BCCUtil.getChars("7-(7oatyCq~s", 5, 3));
                if (namedItem7 != null) {
                    i2 = Util4Java.String2Int(namedItem7.getNodeValue(), -1);
                }
                if (i2 != -1 || str5 != null) {
                    this.f9747i.addBusinessAndServer(i2, str5);
                }
            }
            if (this.f9739a != null) {
                this.f9739a.info(this.f9740b, Util4Java.endsWith("np=}vp?c,n#!-n;p!|", 5, 61));
            }
            return true;
        } catch (Exception e) {
            if (this.f9739a == null) {
                this.f9739a = LogFactory.getInstance().getLog();
            }
            if (this.f9739a != null) {
                this.f9739a.error(this.f9740b, Util4Java.getExceptionInfo(e));
            }
            throw new BusinessException(FM_CN.equals("纜窪鄛缩斟仿劺轶斪ａ杴戱剰酜罬斔仲", 1), ErrorMessage.local_app_config_invaild_content);
        } catch (Exception e2) {
            if (this.f9739a == null) {
                this.f9739a = LogFactory.getInstance().getLog();
            }
            if (this.f9739a != null) {
                this.f9739a.error(this.f9740b, Util4Java.getExceptionInfo(e2));
            }
            throw new BusinessException(CRCUtil.substring(4, "给竳酊罼斚亾勳輣斿ｘ杵扴別配罥斑亷"), ErrorMessage.local_app_config_invaild_content);
        } catch (Exception e22) {
            if (this.f9739a == null) {
                this.f9739a = LogFactory.getInstance().getLog();
            }
            if (this.f9739a != null) {
                this.f9739a.error(this.f9740b, Util4Java.getExceptionInfo(e22));
            }
            throw new BusinessException(CRCUtil.substring(2, "织竵酈罾斜亰勱輡斱～杷扶刣酓罧斓仩"), ErrorMessage.local_app_config_invaild_content);
        }
    }

    public boolean messageConfigLoad(InputStream inputStream) {
        if (this.f9739a == null) {
            this.f9739a = LogFactory.getInstance().getLog();
        }
        this.f9746h = MessageHandleFactory.getMessageHandler();
        try {
            if (this.f9746h.loadDefine(inputStream) == 0) {
                return true;
            }
            if (this.f9739a != null) {
                this.f9739a.warn(this.f9740b, FM_Bytes.concat("丟勱奟琀斧ｐ涏怽覾枘嘻杴助輩鄒罤旒件夺赳", 174, 43));
            }
            this.f9746h = null;
            return false;
        } catch (Exception e) {
            if (this.f9739a == null) {
                return false;
            }
            this.f9739a.error(this.f9740b, new StringBuilder(FM_Bytes.concat("乀勼奄琅旰ｅ淄恠觱柅嘰朱劾轼鄉缩凰玽归幫，", 3, 99)).append(Util4Java.getExceptionInfo(e)).toString());
            return false;
        }
    }

    public void registerCommunicationNotify(CommunicationNotify communicationNotify) {
        this.f9743e = communicationNotify;
    }

    public void registerLocalDataHandler(LocalDataHandler localDataHandler) {
        this.f9754p = localDataHandler;
    }

    public void setApduHandler(ApduHandler apduHandler) {
        this.f9744f = apduHandler;
    }

    public void setLinkInfo(LinkInfo linkInfo) {
        this.f9752n = linkInfo;
    }

    public void setMobileInfo(byte[] bArr) {
        this.f9748j = bArr;
    }

    public void setSecurityCode(byte[] bArr) {
        this.f9750l = bArr;
    }

    public void setSocketExceptionHandle(SocketExceptionHandler socketExceptionHandler) {
        this.f9745g = socketExceptionHandler;
    }

    public void setTerminalNumber(byte[] bArr) {
        this.f9749k = bArr;
    }

    public void throwExceptionAndClose(BusinessException businessException, boolean z, String str) throws BusinessException {
        if (z && this.f9744f != null) {
            this.f9744f.close();
        }
        disconnect(str);
    }

    public void throwExceptionAndClose(String str, ErrorMessage errorMessage, boolean z) throws BusinessException {
        if (z && this.f9744f != null) {
            this.f9744f.close();
        }
        throw new BusinessException(str, errorMessage);
    }
}
