package cn.com.fmsh.communication.message.core;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.TLVParse;
import cn.com.fmsh.communication.message.TLVParse.TagEntry;
import cn.com.fmsh.communication.message.enumerate.ETagType;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.communication.message.tagvalue.HandlerFactory;
import cn.com.fmsh.communication.message.tagvalue.StringValueHandler;
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
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.net.SyslogAppender;

public class Tag implements ITag {
    private /* synthetic */ FMLog f9453a = LogFactory.getInstance().getLog();
    private final /* synthetic */ String f9454b = Message.class.getName();
    private /* synthetic */ byte f9455c;
    private /* synthetic */ byte[] f9456d;
    private /* synthetic */ ETagType f9457e;
    private /* synthetic */ List<ITag> f9458f = new ArrayList();
    private /* synthetic */ MessageHandler f9459g;
    private /* synthetic */ boolean f9460h = false;
    private /* synthetic */ C2876b f9461i;

    /* synthetic */ Tag(MessageHandler messageHandler) {
        this.f9459g = messageHandler;
    }

    /* synthetic */ Tag(MessageHandler messageHandler, byte b) {
        this.f9459g = messageHandler;
        this.f9455c = b;
        this.f9461i = this.f9459g.getTagDefine(b);
    }

    public int addValue(int i) throws FMCommunicationMessageException {
        if (this.f9460h) {
            throw new FMCommunicationMessageException(String.format(FM_Utils.regionMatches(3, 97, "纊\u0000TQ\f}AG贐偠旫２论\u0014 e叩访"), new Object[]{Byte.valueOf(this.f9455c)}));
        } else if (this.f9461i == null) {
            throw new FMCommunicationMessageException(String.format(Util4Java.endsWith("纆\u0018X\u0001H%\u0015G贌倨旷ｂ莬厞AC\b籧埂大账", 2, 77), new Object[]{Byte.valueOf(this.f9455c)}));
        } else {
            this.f9457e = this.f9461i.getType();
            if (this.f9457e != ETagType.I) {
                throw new FMCommunicationMessageException(String.format(FM_Int.replace(2, "纎\u000e\u001cGX#QQ资倮旣４伻养UE@倶皉籫垘凬销"), new Object[]{Byte.valueOf(this.f9455c)}));
            }
            this.f9456d = FM_Bytes.intToBytes(i, this.f9461i.getLength());
            return 0;
        }
    }

    public int addValue(ITag iTag) throws FMCommunicationMessageException {
        if (iTag == null) {
            throw new FMCommunicationMessageException(String.format(FM_Exception.insert(5, 102, "绐\u001b\u0014\\Z\"\u0015\u000e赒倣旳ｇ佱兲皙W\b\b丯穡"), new Object[]{Byte.valueOf(this.f9455c)}));
        } else if (this.f9460h) {
            throw new FMCommunicationMessageException(String.format(Util4Java.endsWith("纎\u0006LO\u0018{\u0001I资偶斳，课B0+叭诹", 218, 27), new Object[]{Byte.valueOf(this.f9455c)}));
        } else if (this.f9461i == null) {
            throw new FMCommunicationMessageException(String.format(BCCUtil.getChars("纍S\u001bJ\u001bv^\u0004赇倣斤）華叝J\u0010C簬垁夬赵", 4, 51), new Object[]{Byte.valueOf(this.f9455c)}));
        } else {
            this.f9457e = this.f9461i.getType();
            if (this.f9457e != ETagType.f9477C) {
                throw new FMCommunicationMessageException(String.format(FM_Long.copyValueOf("纑\u0011\u0003\u0018\u0007|\u000e\u000e贛偱於ｋ佤儤JZ_倩皖籴垇凳锟", 352), new Object[]{Byte.valueOf(this.f9455c)}));
            }
            int i;
            for (C2877c tag : this.f9461i.getTagItemDefines()) {
                if (tag.getTag() == iTag.getId()) {
                    i = 1;
                    break;
                }
            }
            i = 0;
            if (i != 0) {
                this.f9458f.add(iTag);
                return 0;
            }
            throw new FMCommunicationMessageException(String.format(CRCUtil.substring(288, "绔L\u0002\t\u0002a\u0017\u0007赎倬旭＊伱兹\u0013\u0013\u001ah桔讘丄吜泊"), new Object[]{Byte.valueOf(iTag.getId())}));
        }
    }

    public int addValue(String str) throws FMCommunicationMessageException {
        if (this.f9460h) {
            throw new FMCommunicationMessageException(String.format(FM_Long.copyValueOf("绕]GD[x\u0002\n负偭斸ｇ训\u0011#8厶订", 4), new Object[]{Byte.valueOf(this.f9455c)}));
        } else if (this.f9461i == null) {
            throw new FMCommunicationMessageException(String.format(FM_Bytes.concat("纀\\\u0016\u0001NaK_贚值方２莺厊_\u001b\u000e籣埌大贠", 226, 79), new Object[]{Byte.valueOf(this.f9455c)}));
        } else {
            this.f9457e = this.f9461i.getType();
            StringValueHandler stringValueHandle = HandlerFactory.instance().getStringValueHandle(this.f9457e);
            if (stringValueHandle != null) {
                this.f9456d = stringValueHandle.setTagValue(str);
                return 0;
            }
            throw new FMCommunicationMessageException(String.format(FM_Exception.insert(210, 53, "纏_\u0001\u0012QzL\u0014贕倯斾１菥发H\u0010A簠垛么呒泚"), new Object[]{Byte.valueOf(this.f9455c)}));
        }
    }

    public int addValue(byte[] bArr) throws FMCommunicationMessageException {
        if (this.f9460h) {
            throw new FMCommunicationMessageException(String.format(Util4Java.endsWith("绘@F]\u0016e\u000b[赒倰早～讠\fjy叻访", 4, 19), new Object[]{Byte.valueOf(this.f9455c)}));
        } else if (this.f9461i == null) {
            throw new FMCommunicationMessageException(String.format(FM_Utils.regionMatches(154, 87, "结\u0015YH\u001d8L\u0016贉倥斦ｋ莩厃\u0018B\u001d簪垃奮赳"), new Object[]{Byte.valueOf(this.f9455c)}));
        } else {
            this.f9457e = this.f9461i.getType();
            if (this.f9457e != ETagType.B) {
                throw new FMCommunicationMessageException(String.format(FM_Exception.insert(178, 43, "经\u0015MP\u0019(@\u001e赅倥斲＃伺儠DZ\u0001倭皘簼垙凧镑"), new Object[]{Byte.valueOf(this.f9455c)}));
            } else if (this.f9461i.getLength() == 0 || bArr.length <= this.f9461i.getLength()) {
                this.f9456d = bArr;
                return 0;
            } else {
                throw new FMCommunicationMessageException(String.format(FM_Utils.regionMatches(200, 110, "绁RUE\u000b{\u0014G赃倪旲～你儫HK_债盐锽延专各泏"), new Object[]{Byte.valueOf(this.f9455c)}));
            }
        }
    }

    public int clear() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Tag)) {
            return false;
        }
        return this.f9455c == ((Tag) obj).f9455c;
    }

    public int fromPackageBody(byte b, byte[] bArr) throws FMCommunicationMessageException {
        this.f9455c = b;
        this.f9460h = true;
        this.f9461i = this.f9459g.getTagDefine(b);
        if (this.f9461i != null) {
            this.f9457e = this.f9461i.getType();
            int length = bArr.length;
            if (this.f9461i.getLength() == 0 || length <= this.f9461i.getLength()) {
                this.f9456d = bArr;
                if (ETagType.f9477C == this.f9457e) {
                    for (TagEntry tagEntry : TLVParse.intance().parse(this.f9456d, 1)) {
                        Tag tag = new Tag(this.f9459g);
                        tag.fromPackageBody(tagEntry.getTag()[0], tagEntry.getData());
                        if (tag.isValid()) {
                            this.f9458f.add(tag);
                        }
                    }
                }
                return 0;
            } else if (this.f9453a == null) {
                return -2;
            } else {
                this.f9453a.warn(this.f9454b, String.format(FM_Long.copyValueOf("_IBYz\u0004\u0004富业盔锲廬哋攴振纇盟锧廳也乏膸", 3), new Object[]{Byte.valueOf(b)}));
                return -2;
            }
        } else if (this.f9453a == null) {
            return -2;
        } else {
            this.f9453a.warn(this.f9454b, String.format(BCCUtil.getChars("坹鄝罡斉亻乡朡宐一\u001cFA\u001ea[_", 1, 95), new Object[]{Byte.valueOf(b)}));
            return -2;
        }
    }

    public int fromPackageBody(byte[] bArr) {
        this.f9460h = true;
        if (bArr == null || bArr.length < 2) {
            return -1;
        }
        this.f9455c = bArr[0];
        this.f9461i = this.f9459g.getTagDefine(this.f9455c);
        if (this.f9461i == null) {
            return -2;
        }
        int i;
        this.f9457e = this.f9461i.getType();
        int i2 = bArr[1] & 255;
        byte[] bArr2 = new byte[2];
        if (i2 == 255) {
            i = 4;
            bArr2[0] = bArr[2];
            bArr2[1] = bArr[3];
            i2 = FM_Bytes.bytesToInt(bArr2);
        } else {
            i = 2;
        }
        if (bArr.length < i + i2) {
            return -1;
        }
        if (this.f9461i.getLength() != 0 && i2 > this.f9461i.getLength()) {
            return -2;
        }
        if (i + i2 > bArr.length) {
            if (this.f9453a != null) {
                this.f9453a.warn(this.f9454b, new StringBuilder(FM_Long.copyValueOf("敾捥長庣Y", 6)).append(bArr.length).append(FM_Bytes.concat("\u0006损寏屝仁攼挧捁寙锿廻\u0001", 4, 125)).append(String.format(FM_Utils.regionMatches(2, ReportInfoUtils.FEEDBACK_SUCCESS, "w\u0015"), new Object[]{Integer.valueOf(i2)})).append(CRCUtil.substring(2, "R:咉敠捵锹廷嬋苅廝削皌镬庸R")).append(bArr.length).append(FM_Exception.insert(188, 11, "\u001d哇")).toString());
            }
            return -3;
        }
        this.f9456d = Arrays.copyOfRange(bArr, i, i2 + i);
        return -1;
    }

    public byte[] getBytesVal() throws FMCommunicationMessageException {
        return ETagType.B == this.f9457e ? this.f9456d : null;
    }

    public byte getId() {
        return this.f9455c;
    }

    public int getIntVal() throws FMCommunicationMessageException {
        return ETagType.I == this.f9457e ? FM_Bytes.bytesToInt(this.f9456d) : -1;
    }

    public byte[] getItemBytesVal(int i) throws FMCommunicationMessageException {
        if (i >= 0 && i <= this.f9458f.size()) {
            return ((ITag) this.f9458f.get(i)).getBytesVal();
        }
        throw new FMCommunicationMessageException(String.format(FM_Utils.regionMatches(216, 11, "菿厅奓朋\u0000>mN%SK盅卉呼\u0016,?皇倲旯（伯兿盁乛桜跌甝"), new Object[]{Byte.valueOf(this.f9455c)}));
    }

    public int getItemCount() throws FMCommunicationMessageException {
        return this.f9458f.size();
    }

    public int getItemIntVal(int i) throws FMCommunicationMessageException {
        if (i >= 0 && i <= this.f9458f.size()) {
            return ((ITag) this.f9458f.get(i)).getIntVal();
        }
        throw new FMCommunicationMessageException(String.format(FM_CN.equals("莤叒夘杄\u0003)>\u0011>T@皊博呻\u00153$皐倹无＋佸儬盞乀栛趇畒", 192), new Object[]{Byte.valueOf(this.f9455c)}));
    }

    public String getItemStringVal(int i) throws FMCommunicationMessageException {
        if (i >= 0 && i <= this.f9458f.size()) {
            return ((ITag) this.f9458f.get(i)).getStringVal();
        }
        throw new FMCommunicationMessageException(String.format(BCCUtil.getChars("菤历夀杈\u0013%f\u0005~@H盖半吧]'$的偡斬；伴儴益一栏跏甎", 3, 93), new Object[]{Byte.valueOf(this.f9455c)}));
    }

    public int getItemTagID(int i) throws FMCommunicationMessageException {
        if (i >= 0 && i <= this.f9458f.size()) {
            return ((ITag) this.f9458f.get(i)).getId();
        }
        throw new FMCommunicationMessageException(String.format(FM_Bytes.concat("莠厐夘杆\u0007c6\u001b*\u0006P盘华吱\u001dy`盒栂讒斵＞佡兵盛久栚跆畗", 32, 79), new Object[]{Byte.valueOf(this.f9455c)}));
    }

    public ITag getItemTagVal(int i) throws FMCommunicationMessageException {
        if (i >= 0 && i <= this.f9458f.size()) {
            return (ITag) this.f9458f.get(i);
        }
        throw new FMCommunicationMessageException(String.format(Util4Java.endsWith("莵厍奙朏\u0012>?\no\u001bA皑匋听Txu皏倸斫ｚ佯儭盅乑桔跆甉", 5, 121), new Object[]{Byte.valueOf(this.f9455c)}));
    }

    public ITag[] getItemTags() throws FMCommunicationMessageException {
        return (ITag[]) this.f9458f.toArray(new ITag[0]);
    }

    public ETagType getItemType(int i) throws FMCommunicationMessageException {
        if (i >= 0 && i <= this.f9458f.size()) {
            return ((ITag) this.f9458f.get(i)).getType();
        }
        throw new FMCommunicationMessageException(String.format(Util4Java.endsWith("莶叅奈杕\u001d:j\u00044\u001b\b皃卜吠I.f盗籾垜斿７佭儺皕么栒跍甕", 4, 50), new Object[]{Byte.valueOf(this.f9455c)}));
    }

    public String getStringVal() throws FMCommunicationMessageException {
        StringValueHandler stringValueHandle = HandlerFactory.instance().getStringValueHandle(this.f9457e);
        return stringValueHandle != null ? stringValueHandle.getTagvalue(this.f9456d) : null;
    }

    public byte[] getTagValue() {
        return this.f9456d;
    }

    public ETagType getType() {
        return this.f9457e;
    }

    public boolean isValid() {
        if (this.f9461i != null) {
            if (this.f9461i.getLength() != 0) {
                if (this.f9456d == null || this.f9456d.length < 1) {
                    if (this.f9453a == null) {
                        return false;
                    }
                    this.f9453a.warn(this.f9454b, String.format(CRCUtil.substring(1, "ZXCT?\u001d\r髗讇斧ｐSSZ皌倯两稳"), new Object[]{Byte.valueOf(this.f9455c)}));
                    return false;
                } else if (this.f9456d.length > this.f9461i.getLength()) {
                    if (this.f9453a == null) {
                        return false;
                    }
                    this.f9453a.warn(this.f9454b, String.format(FM_Int.replace(FitnessSleepType.HW_FITNESS_WAKE, "\u000b\u0003\u0002\u0013n\u0016\f攤挹锥廻和酎罨斎仺宕乛皑敨捵镡座三笡"), new Object[]{Byte.valueOf(this.f9455c)}));
                    return false;
                }
            }
            return true;
        } else if (this.f9453a == null) {
            return false;
        } else {
            this.f9453a.warn(this.f9454b, String.format(BCCUtil.getChars("T\u0016\t^y\u000bW骍讙旹＊菪参酆缬斞仦寝乗夤赩", SyslogAppender.LOG_LOCAL6, 87), new Object[]{Byte.valueOf(this.f9455c)}));
            return false;
        }
    }

    public int setValue(Tag tag, int i) throws FMCommunicationMessageException {
        return 0;
    }

    public byte[] toBytes() throws FMCommunicationMessageException {
        if (isValid()) {
            if (ETagType.f9477C == this.f9457e) {
                this.f9456d = new byte[0];
                for (ITag toBytes : this.f9458f) {
                    this.f9456d = FM_Bytes.join(this.f9456d, toBytes.toBytes());
                }
            }
            if (this.f9456d == null) {
                if (this.f9453a != null) {
                    this.f9453a.warn(this.f9454b, String.format(FM_Long.copyValueOf("XHAX%\u0005\u0007輻挶扁嬙苉廇剒斴s\b\u0018\u0011攣挾乷稰", 4), new Object[]{Byte.valueOf(this.f9455c)}));
                }
                throw new FMCommunicationMessageException(String.format(FM_Long.copyValueOf("YK@_$\u0006\u0006輴挷扂嬘苎廆剑斵l\t\u001b\u0010攤挿乴稱", 5), new Object[]{Byte.valueOf(this.f9455c)}));
            }
            int i;
            int i2;
            int length = this.f9456d.length;
            byte[] bArr = new byte[4];
            bArr[0] = this.f9455c;
            if (length >= 255) {
                bArr[1] = (byte) -1;
                byte[] intToBytes = FM_Bytes.intToBytes(length, 2);
                bArr[2] = intToBytes[0];
                bArr[3] = intToBytes[1];
                i = 4;
            } else {
                bArr[1] = (byte) length;
                i = 2;
            }
            byte[] bArr2 = new byte[(i + length)];
            for (i2 = 0; i2 < i; i2++) {
                bArr2[i2] = bArr[i2];
            }
            for (i2 = 0; i2 < length; i2++) {
                bArr2[i + i2] = this.f9456d[i2];
            }
            return bArr2;
        }
        if (this.f9453a != null) {
            this.f9453a.warn(this.f9454b, String.format(Util4Java.endsWith("T\u000bS\u0005-\nA轪挲戊嬓芌廗剕旺ｚ有攂怳梞枭丟辛", 3, 74), new Object[]{Byte.valueOf(this.f9455c)}));
        }
        throw new FMCommunicationMessageException(String.format(FM_Int.replace(4, "\r\u001d\u0018Y PV轢捳戄孀芘庒列旵＊]MH敢捻旸敓"), new Object[]{Byte.valueOf(this.f9455c)}));
    }
}
