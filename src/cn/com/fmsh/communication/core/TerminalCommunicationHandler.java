package cn.com.fmsh.communication.core;

import android.support.v4.internal.view.SupportMenu;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.CommunicationNotify;
import cn.com.fmsh.communication.TerminalCommunication;
import cn.com.fmsh.communication.core.ControlWord.CommandType;
import cn.com.fmsh.communication.core.ControlWord.Direction;
import cn.com.fmsh.communication.core.ControlWord.MessageType;
import cn.com.fmsh.communication.core.MessageHead.CheckType;
import cn.com.fmsh.communication.core.MessageHead.SecurityLevel;
import cn.com.fmsh.communication.exception.CommunicationException;
import cn.com.fmsh.communication.exception.CommunicationException.CommandDirection;
import cn.com.fmsh.communication.exception.CommunicationException.CommunicationExceptionType;
import cn.com.fmsh.communication.exception.SocketException;
import cn.com.fmsh.communication.exception.session.CloseSessionException;
import cn.com.fmsh.communication.exception.session.OpenSessionException;
import cn.com.fmsh.communication.exception.session.OpenSessionException.OpenSessionExceptionType;
import cn.com.fmsh.exception.InvalidParameterException;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.algorithm.DES;
import cn.com.fmsh.util.algorithm.MAC;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import cn.com.fmsh.util.socket.DataLengthHandle;
import cn.com.fmsh.util.socket.ReceiveHandler;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TerminalCommunicationHandler implements TerminalCommunication {
    private /* synthetic */ String f9365_;
    private /* synthetic */ int f9366a;
    private /* synthetic */ ReceiveHandler aa;
    private volatile /* synthetic */ long ab;
    private volatile /* synthetic */ long ac;
    private /* synthetic */ Lock ad;
    private /* synthetic */ int f9367b;
    private final /* synthetic */ int f9368c;
    private /* synthetic */ Socket f9369d;
    private /* synthetic */ DataInputStream f9370e;
    private /* synthetic */ DataOutputStream f9371f;
    private /* synthetic */ CommunicationNotify f9372g;
    private /* synthetic */ byte[] f9373h;
    private /* synthetic */ byte[] f9374i;
    private /* synthetic */ byte[] f9375j;
    private /* synthetic */ int f9376k;
    private /* synthetic */ int f9377l;
    private volatile /* synthetic */ long f9378m;
    private /* synthetic */ byte[] f9379n;
    private volatile /* synthetic */ long f9380o;
    private /* synthetic */ DataLengthHandle f9381p;
    /* synthetic */ byte[] f9382q;
    private volatile /* synthetic */ LinkedList<byte[]> f9383r;
    private volatile /* synthetic */ boolean f9384s;
    private volatile /* synthetic */ boolean f9385t;
    private volatile /* synthetic */ boolean f9386u;
    private volatile /* synthetic */ boolean f9387v;
    private /* synthetic */ boolean f9388w;
    private volatile /* synthetic */ boolean f9389x;
    private /* synthetic */ int f9390y;
    private /* synthetic */ FMLog f9391z;

    public TerminalCommunicationHandler() {
        this.f9366a = 3;
        this.f9367b = 1000;
        this.f9368c = 5000;
        this.f9369d = null;
        this.f9376k = 4;
        this.f9377l = 12;
        this.f9385t = false;
        this.f9386u = false;
        this.f9387v = false;
        this.f9390y = 5000;
        this.f9391z = null;
        this.f9365_ = TerminalCommunicationHandler.class.getName();
        this.ab = 0;
        this.ac = 0;
        this.f9381p = new NFCosDataLengthHandler();
        this.f9391z = LogFactory.getInstance().getLog();
        this.f9375j = new byte[16];
        this.f9379n = new byte[4];
        this.f9383r = new LinkedList();
        this.ad = new ReentrantLock();
    }

    private final /* bridge */ /* synthetic */ void m13011a() {
        if (this.f9378m >= MessageHead.SERIAL_MAK) {
            this.f9380o = 0;
        } else {
            this.f9380o = this.f9378m + 1;
        }
    }

    private final /* synthetic */ byte[] m13012a(byte[] bArr, boolean z) throws CommunicationException, SocketException {
        FM_Exception communicationException;
        if (bArr == null || bArr.length < 1) {
            if (this.f9391z != null) {
                this.f9391z.warn(this.f9365_, FM_Long.copyValueOf("幸司丟劣奛瑚咔廂攣挾乷稰ｋ乞勠奚瑝奩走", 3));
            }
            communicationException = new CommunicationException(CRCUtil.substring(1, "幽叩丞劮夞瑃咝廏收挿书穽＞万助夗琘奸赱"));
            communicationException.setExceptionType(CommunicationExceptionType.NO_REPONSE);
            if (z) {
                this.f9372g.exceptionNotify(communicationException, communicationException.getClass());
                return null;
            }
            throw communicationException;
        } else if (bArr.length < 12) {
            if (this.f9391z != null) {
                this.f9391z.error(this.f9365_, FM_Exception.insert(2, 29, "幵右乚勼奞琑既｝數刻哅廑攲挱栠弖镏讼＜丗勫奃琂夰贻"));
            }
            communicationException = new CommunicationException(FM_CN.equals("帮厾丅励夅琔旵ｘ敳剦咊庌敹捴样当镔讱ｃ乚劰夆琕夵走", 362));
            communicationException.setExceptionType(CommunicationExceptionType.INVALID_REPONSE);
            communicationException.setDirection(CommandDirection.RESPONSE);
            if (z) {
                this.f9372g.exceptionNotify(communicationException, communicationException.getClass());
                return null;
            }
            throw communicationException;
        } else {
            MessageHead messageHead = new MessageHead();
            messageHead.fromBytes(Arrays.copyOf(bArr, 12));
            ControlWord controlWord = messageHead.getControlWord();
            if (controlWord.getDirection() != Direction.RESPONSE) {
                if (this.f9391z != null) {
                    this.f9391z.warn(this.f9365_, FM_Exception.insert(3, 99, "年厺乗励夗瑐斯０攩刲么晧哆庚攡挺；一勼奄瑅夷贬"));
                }
                communicationException = new CommunicationException(BCCUtil.getChars("幥号丂勨奞瑍斪！攨刿乍晾咏廇整捻＊不勩奝瑌奪贩", 166, 17));
                communicationException.setExceptionType(CommunicationExceptionType.INVALID_DIRECTION);
                communicationException.setDirection(CommandDirection.RESPONSE);
                if (z) {
                    this.f9372g.exceptionNotify(communicationException, communicationException.getClass());
                    return null;
                }
                throw communicationException;
            }
            FM_Exception communicationException2;
            if (!Arrays.equals(this.f9379n, messageHead.getSessionNumber())) {
                if (this.f9391z != null) {
                    this.f9391z.warn(this.f9365_, BCCUtil.getChars("帳司乊効奄琎斦４收剸旰攐会讕缆厯ｌ丒勱夜瑆夹赵", 336, 72));
                }
                this.f9387v = false;
                communicationException2 = new CommunicationException(FM_Utils.regionMatches(6, 44, "帥史乔勻夂瑔斨＆敠刲旮攒伜诏罈叽：乘劯夞瑀夣贻"));
                communicationException2.setExceptionType(CommunicationExceptionType.INVALID_SESSION);
                communicationException2.setDirection(CommandDirection.RESPONSE);
                if (z) {
                    this.f9372g.exceptionNotify(communicationException2, communicationException2.getClass());
                } else {
                    throw communicationException2;
                }
            }
            if (this.f9380o != messageHead.getSerialNumber()) {
                if (this.f9391z != null) {
                    this.f9391z.warn(this.f9365_, FM_Exception.insert(2, 19, "幵叩世劾奖瑃斮＇攨刡斤攟佐讀浑氷：乓勽奋琄夤购"));
                }
                this.f9387v = false;
                communicationException2 = new CommunicationException(FM_Long.copyValueOf("師厥么勮奈瑏新ｏ敶剭斺攟低讌洏汿ｄ也勣夛琚夨贳", 112));
                communicationException2.setExceptionType(CommunicationExceptionType.INVALID_SESSION_NUMBER);
                communicationException2.setDirection(CommandDirection.RESPONSE);
                if (z) {
                    this.f9372g.exceptionNotify(communicationException2, communicationException2.getClass());
                } else {
                    throw communicationException2;
                }
            }
            this.f9378m = this.f9380o;
            if (controlWord.getReponseCode() == (byte) 0 || controlWord.getReponseCode() == (byte) 14) {
                byte[] securityLevel = messageHead.getSecurityLevel();
                if (!(securityLevel[0] == SecurityLevel.CIPHER.getValue() || securityLevel[1] == CheckType.MAC.getValue())) {
                    if (this.f9391z != null) {
                        this.f9391z.warn(this.f9365_, FM_Utils.regionMatches(178, 84, "幱厦乐势奖瑀旬ｂ整刦斪敖抷旁宓兦绥刽＆乄劳夂瑜夿货"));
                    }
                    communicationException = new CommunicationException(FM_Exception.insert(4, 36, "幻叼乊勵夜琚斶（放剼新敜抽旛安公绯剧＜与勹奘理奵赭"));
                    communicationException.setExceptionType(CommunicationExceptionType.CHECK_FAILED);
                    communicationException.setDirection(CommandDirection.RESPONSE);
                    if (z) {
                        this.f9372g.exceptionNotify(communicationException, communicationException.getClass());
                    } else {
                        throw communicationException;
                    }
                }
                securityLevel = Arrays.copyOfRange(bArr, bArr.length - 4, bArr.length);
                byte[] calculateMAC4DES = MAC.calculateMAC4DES(Arrays.copyOfRange(this.f9375j, this.f9376k, this.f9377l), new byte[8], Arrays.copyOf(bArr, bArr.length - 4));
                if (!Arrays.equals(securityLevel, Arrays.copyOf(calculateMAC4DES, 4))) {
                    if (this.f9391z != null) {
                        this.f9391z.warn(this.f9365_, new StringBuilder(FM_Exception.insert(3, 54, "年叭义动奛琓施－Z\f@髕诎奴赾＝帴叭\u001eH\\\u000e")).append(FM_Bytes.bytesToHexString(securityLevel)).append(FM_CN.equals("\u000bk纐窦讻箜QL\u001d\u0014", 3)).append(FM_Bytes.bytesToHexString(calculateMAC4DES)).append("]").toString());
                    }
                    communicationException = new CommunicationException(Util4Java.endsWith("幱厭丂劲奊瑏旲ｓ\u0017TS髇讇夰赹｛丈劬奌瑅夯赼", 5, 91));
                    communicationException.setExceptionType(CommunicationExceptionType.CHECK_FAILED);
                    communicationException.setDirection(CommandDirection.RESPONSE);
                    if (z) {
                        this.f9372g.exceptionNotify(communicationException, communicationException.getClass());
                    } else {
                        throw communicationException;
                    }
                }
                securityLevel = Arrays.copyOfRange(bArr, 12, bArr.length - 4);
                if (securityLevel.length < 1 || bArr.length % 8 != 0) {
                    communicationException2 = new CommunicationException(FM_Bytes.concat("帪口乗劦奅琝斣＃括斄敭挹东晤A\u001aJ勳寋呉皅敫挻＃乓劢奙琑奠贮", 2, 58));
                    communicationException2.setExceptionType(CommunicationExceptionType.UNKNOW);
                    communicationException2.setDirection(CommandDirection.RESPONSE);
                    if (z) {
                        this.f9372g.exceptionNotify(communicationException2, communicationException2.getClass());
                    } else {
                        throw communicationException2;
                    }
                }
                securityLevel = DES.decrypt4des3(this.f9375j, securityLevel);
                if (!FM_Bytes.isPatch4Des(securityLevel)) {
                    if (this.f9391z != null) {
                        this.f9391z.warn(this.f9365_, FM_CN.equals("帥厷咕廝皞丑劽敽挰来蠥伜", 3));
                    }
                    communicationException2 = new CommunicationException(Util4Java.endsWith("幱只哟廞盆乀劳敺挬杰蠷佇", 5, 24));
                    communicationException2.setExceptionType(CommunicationExceptionType.UNKNOW);
                    communicationException2.setDirection(CommandDirection.RESPONSE);
                    if (z) {
                        this.f9372g.exceptionNotify(communicationException2, communicationException2.getClass());
                    } else {
                        throw communicationException2;
                    }
                }
                securityLevel = FM_Bytes.byteRemovePatch4Des(securityLevel);
                if (z) {
                    this.f9372g.reponseMessageNotify(securityLevel);
                }
                if (this.f9391z != null) {
                    this.f9391z.debug(this.f9365_, new StringBuilder(CRCUtil.substring(344, "也勱奟琀宝戌+x; ?.1e")).append(FM_Bytes.bytesToHexString(securityLevel)).toString());
                }
                if (!controlWord.isHaveNews()) {
                    return securityLevel;
                }
                this.f9372g.newsNotify();
                return securityLevel;
            }
            CommunicationExceptionType instance = CommunicationExceptionType.instance(controlWord.getReponseCode());
            if (CommunicationExceptionType.INVALID_SESSION == instance || CommunicationExceptionType.INVALID_SESSION_NUMBER == instance) {
                this.f9387v = false;
            }
            CommunicationException communicationException3 = new CommunicationException(new StringBuilder(FM_Int.replace(2, "乍勻奙理夲责3")).append(instance.getDescription()).toString());
            communicationException3.setExceptionType(instance);
            communicationException3.setDirection(CommandDirection.RESPONSE);
            throw communicationException3;
        }
    }

    private final /* synthetic */ byte[] m13013a(byte[] bArr, byte[] bArr2) throws IOException {
        if (this.f9370e == null) {
            if (this.f9391z != null) {
                this.f9391z.warn(getClass().getName(), FM_Bytes.concat("\u00176ml+f`7upw'n|gvys*4#*7", 4, 4));
            }
            throw new IOException(FM_CN.equals("\u0005(;\"敬捣厏過斶}钼掶朮廯竍", 3));
        } else if (this.f9371f == null) {
            if (this.f9391z != null) {
                this.f9391z.warn(getClass().getName(), FM_Exception.insert(3, 81, "K1g1ku>>a/e\"6w!'u$py3i9"));
            }
            throw new IOException(FM_Bytes.concat("\u000fcgy8攬挢厍逍旪 铢揩杶庶窗", 5, 16));
        } else {
            this.ad.lock();
            try {
                byte[] join = FM_Bytes.join(bArr, bArr2);
                this.f9371f.write(join);
                if (this.f9391z != null) {
                    this.f9391z.debug(getClass().getName(), new StringBuilder(FM_Long.copyValueOf("lhg 9;#5k", 4)).append(FM_Bytes.bytesToHexString(join)).toString());
                }
                this.f9371f.flush();
                this.aa = ReceiveHandler.instance();
                join = this.aa.receive(this.f9381p, this.f9390y, this.f9370e);
                this.ad.unlock();
                if (this.f9391z != null) {
                    this.f9391z.debug(getClass().getName(), new StringBuilder(CRCUtil.substring(164, "cy$;8>6~mukk/")).append(FM_Bytes.bytesToHexString(join)).toString());
                }
                return join;
            } catch (Exception e) {
                if (this.f9391z != null) {
                    this.f9391z.warn(getClass().getName(), FM_Int.replace(332, "2+$!($s%<2;b!)?/q1/98pwofb"));
                }
                if (this.f9391z != null) {
                    this.f9391z.error(getClass().getName(), Util4Java.getExceptionInfo(e));
                    this.f9391z.debug(getClass().getName(), FM_Bytes.concat("彘幹抓况8s*e<", 3, 71));
                }
                throw new IOException(new StringBuilder(FM_Long.copyValueOf("Yhgj;/攨挻厃過斺e冼珳彂幥", 2)).append(Util4Java.getExceptionInfo(e)).toString());
            } catch (Throwable th) {
                this.ad.unlock();
            }
        }
    }

    final /* bridge */ /* synthetic */ void m13014a(boolean z) {
        this.f9384s = z;
    }

    public void cancel() {
        this.f9382q = null;
        if (this.aa != null) {
            this.aa.cancel();
        }
        this.f9389x = true;
    }

    public boolean closeSession(CloseSessionRequest closeSessionRequest) throws InvalidParameterException, SocketException, CommunicationException, CloseSessionException {
        if (this.f9391z == null) {
            this.f9391z = LogFactory.getInstance().getLog();
        }
        if (this.f9391z != null) {
            this.f9391z.debug(this.f9365_, BCCUtil.getChars("io-3qw5e(-s;\u000fk%=}~`b$&", 4, 94));
        }
        this.f9382q = null;
        this.f9387v = false;
        ControlWord controlWord = new ControlWord();
        controlWord.setDirection(Direction.REQUEST);
        controlWord.setType(MessageType.CONTROL);
        controlWord.setCommandType(CommandType.CLOSESESSION);
        m13011a();
        MessageHead messageHead = new MessageHead();
        messageHead.setProtocolVersion((byte) 17);
        messageHead.setSessionNumber(this.f9379n);
        messageHead.setSerialNumber(this.f9380o);
        messageHead.setSecurityLevel(new byte[]{(byte) SecurityLevel.PLAIN.getValue(), (byte) CheckType.MAC.getValue()});
        messageHead.setControlWord(controlWord);
        if (closeSessionRequest == null) {
            closeSessionRequest = new CloseSessionRequest();
        }
        byte[] join = FM_Bytes.join(messageHead.toBytes(), closeSessionRequest.toBytes());
        join = FM_Bytes.join(join, Arrays.copyOf(MAC.calculateMAC4DES(Arrays.copyOfRange(this.f9375j, this.f9376k, this.f9377l), new byte[8], join), 4));
        if (this.f9391z != null) {
            this.f9391z.debug(this.f9365_, new StringBuilder(FM_Exception.insert(5, 62, "j+j0d?.~*d<|?/?n:r p5%")).append(FM_Bytes.bytesToHexString(join)).toString());
        }
        try {
            join = m13013a(this.f9381p.initDataSize(join.length), join);
            if (join == null) {
                if (this.f9391z != null) {
                    this.f9391z.error(this.f9365_, FM_CN.equals("纍竹筹逘旿ｖ常厬咀床敿据丫穸｟笺違奷贲", 82));
                }
                throw new CommunicationException(FM_Long.copyValueOf("绅童筹逄旷ｒ帨厨咘廆政挢乳稼ｏ笾遝奫赲", 5));
            }
            if (this.f9391z != null) {
                this.f9391z.debug(this.f9365_, new StringBuilder(FM_Int.replace(4, "笧遜咒庖？")).append(FM_Bytes.bytesToHexString(join)).toString());
            }
            CommunicationException communicationException;
            if (join.length < 12) {
                if (this.f9391z != null) {
                    this.f9391z.error(this.f9365_, FM_Bytes.concat("给窺筧遝旷ｉ政剽哜廁敩挳桽弊镐询｝筫遙夬赤", 154, 68));
                }
                communicationException = new CommunicationException(BCCUtil.getChars("纝窦筣遑斳５敻剱哘廝敭捿桹弖锔议９筷遝夠贠", 5, 84));
                communicationException.setExceptionType(CommunicationExceptionType.INVALID_FORMAT);
                communicationException.setDirection(CommandDirection.RESPONSE);
                throw communicationException;
            }
            messageHead.fromBytes(Arrays.copyOf(join, 12));
            controlWord = messageHead.getControlWord();
            if (controlWord.getDirection() != Direction.RESPONSE) {
                communicationException = new CommunicationException(CRCUtil.substring(270, "结竩筯逜斱～敫剸盗席叹敤捱万昺咍廟攦振｀笩适夼贽"));
                communicationException.setExceptionType(CommunicationExceptionType.INVALID_DIRECTION);
                communicationException.setDirection(CommandDirection.RESPONSE);
                throw communicationException;
            } else if (controlWord.getReponseCode() != (byte) 0) {
                CommunicationExceptionType instance = CommunicationExceptionType.instance(controlWord.getReponseCode());
                CommunicationException communicationException2 = new CommunicationException(new StringBuilder(BCCUtil.getChars("筲逄夭贱6", 316, 120)).append(instance.getDescription()).toString());
                communicationException2.setExceptionType(instance);
                communicationException2.setDirection(CommandDirection.RESPONSE);
                throw communicationException2;
            } else if (controlWord.getCommandType() == CommandType.CLOSESESSION) {
                return true;
            } else {
                throw new CommunicationException(Util4Java.endsWith("纃窡笯達讠氘斫ｌ敵剶盍帿县攢挻乕晴笠送庐筓", 206, 3));
            }
        } catch (Exception e) {
            this.f9386u = false;
            throw new SocketException(Util4Java.getExceptionInfo(e));
        } catch (Exception e2) {
            this.f9386u = false;
            throw new SocketException(Util4Java.getExceptionInfo(e2));
        }
    }

    public boolean connect(LinkInfo linkInfo) throws InvalidParameterException, SocketException {
        if (this.f9391z == null) {
            this.f9391z = LogFactory.getInstance().getLog();
        }
        if (!isConnect()) {
            if (linkInfo == null) {
                if (this.f9391z != null) {
                    this.f9391z.warn(this.f9365_, BCCUtil.getChars("钭掶剣幠厣日｟伳儶皗钭掶攣捽乩穩", 3, 64));
                }
                throw new InvalidParameterException(CRCUtil.substring(310, "钽揫剩帷县斬）估兾皂铯掹攷挼乧稲"));
            } else if (linkInfo.getPort() < 1 || linkInfo.getPort() >= SupportMenu.USER_MASK) {
                if (this.f9391z != null) {
                    this.f9391z.error(this.f9365_, FM_Utils.regionMatches(4, 63, "钪掶剢幢厠旹ｂ伭儩皏窥只县上呎泐"));
                }
                throw new InvalidParameterException(FM_Bytes.concat("钦揤剺幠召旳ｂ佷儥皍竽厸厳乀吞泊", 1, 105));
            } else if (linkInfo.getAddress() == null || linkInfo.getAddress().length() < 1) {
                if (this.f9391z != null) {
                    this.f9391z.error(this.f9365_, CRCUtil.substring(2, "铱掿刵幣叫新｝佼儢盖帮司圣坞丳穮"));
                }
                throw new InvalidParameterException(CRCUtil.substring(5, "铬掸券幠叮斿ｘ使儯监平叻圦坁丶穭"));
            } else {
                if (linkInfo.getTimeout() != -1) {
                    this.f9390y = linkInfo.getTimeout();
                }
                this.ad.lock();
                try {
                    this.f9369d = new Socket(linkInfo.getAddress(), linkInfo.getPort());
                    if (this.f9369d.getSoTimeout() == 0) {
                        this.f9369d.setSoTimeout(this.f9390y);
                    }
                    this.f9370e = new DataInputStream(this.f9369d.getInputStream());
                    this.f9371f = new DataOutputStream(this.f9369d.getOutputStream());
                    this.ad.unlock();
                    this.f9386u = true;
                    this.ab = System.currentTimeMillis();
                } catch (Exception e) {
                    if (this.f9391z != null) {
                        this.f9391z.debug(this.f9365_, new StringBuilder(FM_Int.replace(2, "\u00076<tei{a/")).append(linkInfo.getAddress()).append(":").append(linkInfo.getPort()).toString());
                        this.f9391z.error(this.f9365_, Util4Java.getExceptionInfo(e));
                    }
                    throw new SocketException(Util4Java.getExceptionInfo(e));
                } catch (Exception e2) {
                    if (this.f9391z != null) {
                        this.f9391z.debug(this.f9365_, new StringBuilder(FM_Exception.insert(3, 118, "W12=9:9,7")).append(linkInfo.getAddress()).append(":").append(linkInfo.getPort()).toString());
                        this.f9391z.error(this.f9365_, Util4Java.getExceptionInfo(e2));
                    }
                    throw new SocketException(Util4Java.getExceptionInfo(e2));
                } catch (Throwable th) {
                    this.ad.unlock();
                }
            }
        }
        return true;
    }

    public boolean disconnect() throws SocketException {
        if (this.f9391z != null) {
            this.f9391z.debug(this.f9365_, Util4Java.endsWith("eylmr\"5/:|9(;j", 4, 15));
        }
        this.f9386u = false;
        try {
            if (this.f9371f != null) {
                this.f9371f.close();
            }
        } catch (Exception e) {
            if (this.f9391z != null) {
                this.f9391z.error(this.f9365_, Util4Java.getExceptionInfo(e));
            }
        }
        this.f9371f = null;
        try {
            if (this.f9370e != null) {
                this.f9370e.close();
            }
        } catch (Exception e2) {
            if (this.f9391z != null) {
                this.f9391z.error(this.f9365_, Util4Java.getExceptionInfo(e2));
            }
        }
        this.f9370e = null;
        try {
            if (this.f9369d != null) {
                this.f9369d.close();
            }
        } catch (Exception e22) {
            if (this.f9391z != null) {
                this.f9391z.error(this.f9365_, Util4Java.getExceptionInfo(e22));
            }
        }
        this.f9369d = null;
        return true;
    }

    public long getLastCalledTime() {
        return this.ac;
    }

    public Date getLastHeartBeat() {
        return null;
    }

    public byte[] getSessionNumber() {
        return this.f9379n;
    }

    public long getSessionSerialNumber() {
        return this.f9378m;
    }

    public boolean isConnect() {
        if (this.f9386u && System.currentTimeMillis() - this.ab >= 540000) {
            if (this.f9391z != null) {
                this.f9391z.debug(getClass().getName(), FM_Exception.insert(5, 45, "zs1fx87(8p xq;2i6sga"));
            }
            this.f9386u = false;
        }
        return this.f9386u;
    }

    public boolean isOpenSession() {
        if (this.f9387v && System.currentTimeMillis() - this.ac >= 540000) {
            if (this.f9391z != null) {
                this.f9391z.debug(getClass().getName(), FM_Long.copyValueOf("ltue/z;=?%k<,/:3,\"r", 4));
            }
            this.f9387v = false;
        }
        return this.f9387v;
    }

    public boolean lastRequestDataIsNull() {
        return this.f9382q == null;
    }

    public boolean openSession(TerminalInfo terminalInfo, boolean z) throws InvalidParameterException, SocketException, CommunicationException, OpenSessionException {
        if (this.f9391z == null) {
            this.f9391z = LogFactory.getInstance().getLog();
        }
        if (!this.f9387v) {
            if (terminalInfo == null) {
                throw new InvalidParameterException(FM_Long.copyValueOf("绁竩筽到斫ｖ讠氖攡挠宲谩乿稸ｓ笢剩奧赶", 1));
            }
            this.f9388w = z;
            ControlWord controlWord = new ControlWord();
            controlWord.setDirection(Direction.REQUEST);
            controlWord.setType(MessageType.CONTROL);
            controlWord.setCommandType(CommandType.OPENSESSION);
            MessageHead messageHead = new MessageHead();
            messageHead.setProtocolVersion((byte) 17);
            messageHead.setSecurityLevel(new byte[]{(byte) SecurityLevel.PLAIN.getValue(), (byte) CheckType.CRC16.getValue()});
            messageHead.setControlWord(controlWord);
            byte[] toBytes = messageHead.toBytes();
            C2874a c2874a = new C2874a();
            c2874a.setTerminalType(terminalInfo.getTerminalType());
            c2874a.setAppend(terminalInfo.getAppend());
            c2874a.setKeyIndex(terminalInfo.getKeyIndex());
            c2874a.setExponent(terminalInfo.getExponent());
            c2874a.setModulus(terminalInfo.getModulus());
            c2874a.setSecurityCode(terminalInfo.getSecurityCode());
            c2874a.setTerminalNumber(terminalInfo.getTerminalNumber());
            Random random = new Random();
            this.f9374i = new byte[8];
            random.nextBytes(this.f9374i);
            c2874a.setTerminalRandom(this.f9374i);
            this.f9373h = new byte[16];
            random.nextBytes(this.f9373h);
            c2874a.setTempKey(this.f9373h);
            byte[] toBytes2 = c2874a.toBytes();
            if (toBytes2 == null) {
                throw new OpenSessionException(FM_Exception.insert(5, 109, "绁窹笽剠旫＆诠汆攡挰)wak乥稶ｕ笸刣失质"));
            }
            toBytes = FM_Bytes.join(toBytes, toBytes2);
            toBytes = FM_Bytes.join(toBytes, CRCUtil.calculateCRC16(toBytes));
            try {
                toBytes = m13013a(this.f9381p.initDataSize(toBytes.length), toBytes);
                if (toBytes == null) {
                    if (this.f9391z != null) {
                        this.f9391z.error(this.f9365_, FM_CN.equals("纜窪笨剷误汋旬＇帯厽咓廛攰捿丸穩（笫剶奦赭", 1));
                    }
                    throw new CommunicationException(FM_Utils.regionMatches(328, 20, "绐窣笾剤诿汞旦ｈ師厼响庀數捲乪稾ｔ筲到夥赭"));
                } else if (toBytes.length < 12) {
                    r0 = new CommunicationException(FM_Int.replace(3, "纐窴笠刱诳汅旼！攦刣幥叩哑庋敲捫長庭七吙況；筤刭奱赦"));
                    r0.setExceptionType(CommunicationExceptionType.INVALID_FORMAT);
                    r0.setDirection(CommandDirection.RESPONSE);
                    throw r0;
                } else {
                    messageHead.fromBytes(Arrays.copyOf(toBytes, 12));
                    ControlWord controlWord2 = messageHead.getControlWord();
                    if (controlWord2.getDirection() != Direction.RESPONSE) {
                        r0 = new CommunicationException(FM_Bytes.concat("纒竳笠剰诵氆旰ｄ攼剼皊帣叢攤捸乕昵咑床攰捬ｈ筸剸夻赩", 3, 66));
                        r0.setExceptionType(CommunicationExceptionType.INVALID_DIRECTION);
                        r0.setDirection(CommandDirection.RESPONSE);
                        throw r0;
                    }
                    byte[] securityLevel = messageHead.getSecurityLevel();
                    if (securityLevel[0] != SecurityLevel.PLAIN.getValue() || securityLevel[1] != CheckType.CRC16.getValue()) {
                        if (this.f9391z != null) {
                            this.f9391z.warn(this.f9365_, FM_Int.replace(1, "纞窶笢副诵汇旾＇攸刡哙広抿斚的宊兮纮刧旯敚"));
                        }
                        throw new OpenSessionException(Util4Java.endsWith("纁窼笣刷详汙旳＃支剳咀廃拤旌监寖兡纴制旧教", 108, 10));
                    } else if (Arrays.equals(CRCUtil.calculateCRC16(Arrays.copyOf(toBytes, toBytes.length - 2)), Arrays.copyOfRange(toBytes, toBytes.length - 2, toBytes.length))) {
                        toBytes = Arrays.copyOfRange(toBytes, 12, toBytes.length - 2);
                        if (controlWord2.getReponseCode() != (byte) 0 && controlWord2.getReponseCode() != (byte) 14) {
                            CommunicationExceptionType instance = CommunicationExceptionType.instance(controlWord2.getReponseCode());
                            CommunicationException communicationException = new CommunicationException(new StringBuilder(FM_Exception.insert(4, 30, "筶制奵赧:")).append(instance.getDescription()).toString());
                            communicationException.setExceptionType(instance);
                            communicationException.setDirection(CommandDirection.RESPONSE);
                            throw communicationException;
                        } else if (toBytes.length < 1) {
                            throw new CommunicationException(BCCUtil.getChars("帠叼也势奓琖ｅ哏序攤捣千佌乢穫ｆ丙劽契琈奶败", 3, 57));
                        } else if (controlWord2.getReponseCode() == (byte) 14) {
                            OpenSessionExceptionType instance2 = OpenSessionExceptionType.instance(toBytes[0]);
                            OpenSessionException openSessionException = new OpenSessionException(instance2.getDescription());
                            openSessionException.setExceptionType(instance2);
                            throw openSessionException;
                        } else {
                            toBytes = DES.decrypt4des3(this.f9373h, toBytes);
                            if (FM_Bytes.isPatch4Des(toBytes)) {
                                toBytes = FM_Bytes.byteRemovePatch4Des(toBytes);
                                OpenSessionResponse openSessionResponse = new OpenSessionResponse();
                                openSessionResponse.fromBytes(toBytes);
                                if (Arrays.equals(openSessionResponse.getTerminalRandom(), this.f9374i)) {
                                    this.f9375j = openSessionResponse.getSessionKey();
                                    if (this.f9375j != null) {
                                        int length = this.f9375j.length;
                                        openSessionResponse.getClass();
                                        if (length == 16) {
                                            this.f9378m = FM_Bytes.bytesToLong(FM_Bytes.join(new byte[1], openSessionResponse.getSerialNumber())) - 1;
                                            this.f9379n = openSessionResponse.getSessionNumber();
                                            this.f9387v = true;
                                            this.ac = System.currentTimeMillis();
                                            this.ab = System.currentTimeMillis();
                                            this.f9382q = null;
                                        }
                                    }
                                    throw new OpenSessionException(Util4Java.endsWith("筿剠早ｂ幮叼咖庞盝佒诊宀钰旤攛", 4, 79));
                                }
                                throw new OpenSessionException(Util4Java.endsWith("签剾斪ｆ幫叶哙庖盔雑杶敪丅昹绌窽厑冴皘隅朢敶", 3, 110));
                            }
                            if (this.f9391z != null) {
                                this.f9391z.warn(this.f9365_, FM_Utils.regionMatches(1, 56, "帢叹和庍攡捧r\u001dt:觢実吟ｅ末衼伜"));
                            }
                            throw new OpenSessionException(Util4Java.endsWith("帰厯哖廃散挡8\u0003f,觸宑吝ｃ朡蠢低", 70, 60));
                        }
                    } else {
                        if (this.f9391z != null) {
                            this.f9391z.warn(this.f9365_, FM_Bytes.concat("给窲筷別讶汏旯ｉ筯刭咄庁攱挣Z\u0017\u0012骑讈奤贤", 186, 44));
                        }
                        throw new OpenSessionException(FM_Utils.regionMatches(5, 28, "纝竾筳剹讲汃旫５笫剡哀庝攵振\u001eKV髝讌夸贠"));
                    }
                }
            } catch (Exception e) {
                this.f9386u = false;
                if (this.f9391z != null) {
                    this.f9391z.error(this.f9365_, new StringBuilder(CRCUtil.substring(96, "笳剨昬＂罈绘凵玪彇幨ａ")).append(Util4Java.getExceptionInfo(e)).toString());
                }
                throw new SocketException(Util4Java.getExceptionInfo(e));
            } catch (Exception e2) {
                this.f9386u = false;
                throw new SocketException(Util4Java.getExceptionInfo(e2));
            }
        }
        return true;
    }

    public void registerCommunicationNotify(CommunicationNotify communicationNotify) {
        this.f9372g = communicationNotify;
    }

    public byte[] repeat() throws SocketException, CommunicationException {
        if (this.f9391z == null) {
            this.f9391z = LogFactory.getInstance().getLog();
        }
        m13014a(true);
        if (this.f9382q != null) {
            try {
                byte[] a = m13013a(this.f9381p.initDataSize(this.f9382q.length), this.f9382q);
                this.f9382q = null;
                this.ac = System.currentTimeMillis();
                this.ab = System.currentTimeMillis();
                m13014a(false);
                return m13012a(a, false);
            } catch (Exception e) {
                if (this.f9391z != null) {
                    this.f9391z.error(this.f9365_, new StringBuilder(Util4Java.endsWith("丛劶奉琅斯＃厔遚凫珷弟幫", 4, 54)).append(Util4Java.getExceptionInfo(e)).toString());
                }
                this.f9386u = false;
                throw new SocketException(Util4Java.getExceptionInfo(e));
            } catch (Exception e2) {
                this.f9386u = false;
                if (this.f9391z != null) {
                    this.f9391z.warn(this.f9365_, new StringBuilder(FM_Long.copyValueOf("丐劦夀琇斨ｗ彚欰厃過冶珹彄幻", 2)).append(Util4Java.getExceptionInfo(e2)).toString());
                }
                throw new SocketException(Util4Java.getExceptionInfo(e2));
            }
        }
        throw new CommunicationException(FM_Long.copyValueOf("泯杂靈规醏厎盘攩挸", 102));
    }

    public int repeatAsynchronous() throws InvalidParameterException {
        this.f9385t = true;
        return 0;
    }

    public byte[] sendMessage(byte[] bArr) throws InvalidParameterException, SocketException, CommunicationException {
        if (this.f9391z == null) {
            this.f9391z = LogFactory.getInstance().getLog();
        }
        if (this.f9391z != null) {
            this.f9391z.debug(this.f9365_, new StringBuilder(BCCUtil.getChars("弆姛一劥诹汚奆瑊z-/'-iuy<", 278, 10)).append(FM_Bytes.bytesToHexString(bArr)).toString());
        }
        if (bArr == null || bArr.length < 1) {
            if (this.f9391z != null) {
                this.f9391z.warn(this.f9365_, FM_Int.replace(3, "乂勺让汃旲＋丐劬诧汑敦捷並穥．丟助夏琈夠贱"));
            }
            throw new InvalidParameterException(Util4Java.endsWith("义勺说氉斥７乙勪诤汙攳捥丩稡／丑勲奟琅奺赶", 86, 40));
        }
        ControlWord controlWord = new ControlWord();
        controlWord.setDirection(Direction.REQUEST);
        controlWord.setType(MessageType.BUSINESS);
        MessageHead messageHead = new MessageHead();
        messageHead.setProtocolVersion((byte) 17);
        messageHead.setSecurityLevel(new byte[]{(byte) SecurityLevel.CIPHER.getValue(), (byte) CheckType.MAC.getValue()});
        messageHead.setControlWord(controlWord);
        m13011a();
        messageHead.setSerialNumber(this.f9380o);
        messageHead.setSessionNumber(this.f9379n);
        byte[] join = FM_Bytes.join(messageHead.toBytes(), DES.encrypt4des3(this.f9375j, FM_Bytes.bytePatch4Des(bArr)));
        join = FM_Bytes.join(join, Arrays.copyOf(MAC.calculateMAC4DES(Arrays.copyOfRange(this.f9375j, this.f9376k, this.f9377l), new byte[8], join), 4));
        this.f9382q = join;
        m13014a(true);
        try {
            join = m13013a(this.f9381p.initDataSize(join.length), join);
            this.ac = System.currentTimeMillis();
            this.ab = System.currentTimeMillis();
            m13014a(false);
            return m13012a(join, false);
        } catch (Exception e) {
            if (this.f9391z != null) {
                this.f9391z.warn(this.f9365_, FM_Bytes.concat("哖帥厢放挤仢挠彜幢ｚ醟旾仮挤攲捰48< ", 3, ReportInfoUtils.FEEDBACK_FAILED));
            }
            this.f9386u = false;
            throw new SocketException(Util4Java.getExceptionInfo(e));
        } catch (Throwable th) {
            this.ac = System.currentTimeMillis();
            this.ab = System.currentTimeMillis();
            m13014a(false);
        }
    }

    public int sendMessageAsynchronous(byte[] bArr) throws InvalidParameterException {
        this.f9383r.addFirst(bArr);
        this.f9385t = true;
        return 0;
    }

    public void setExceptionTryCount(int i) {
        if (i > 0) {
            this.f9366a = i;
        }
    }

    public void setInterval4Heartbeat(int i) {
        if (i > 0) {
            this.f9367b = i;
        }
    }

    public void setTimeout(int i) {
        if (i > 0) {
            this.f9390y = i;
        }
    }
}
