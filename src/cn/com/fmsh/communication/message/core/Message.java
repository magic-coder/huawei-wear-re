package cn.com.fmsh.communication.message.core;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.IMessage;
import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.TLVParse;
import cn.com.fmsh.communication.message.TLVParse.TagEntry;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Message implements IMessage {
    /* synthetic */ FMLog f9435a = LogFactory.getInstance().getLog();
    /* synthetic */ String f9436b = Message.class.getName();
    private /* synthetic */ C2875a f9437c;
    private /* synthetic */ MessageHandler f9438d;
    private /* synthetic */ int f9439e;
    private /* synthetic */ byte[] f9440f;
    private /* synthetic */ boolean f9441g = false;
    private /* synthetic */ List<ITag> f9442h = new ArrayList();

    /* synthetic */ Message(MessageHandler messageHandler) {
        this.f9438d = messageHandler;
    }

    /* synthetic */ Message(MessageHandler messageHandler, int i) {
        this.f9438d = messageHandler;
        this.f9439e = i;
    }

    private final /* synthetic */ void m13017a(byte[] bArr) throws FMCommunicationMessageException {
        for (TagEntry tagEntry : TLVParse.intance().parse(bArr, 1)) {
            ITag createTag = this.f9438d.createTag(tagEntry.getTag()[0], tagEntry.getData());
            if (createTag.isValid()) {
                this.f9442h.add(createTag);
            } else {
                this.f9442h.clear();
                if (this.f9435a != null) {
                    this.f9435a.warn(Message.class.getName(), FM_Exception.insert(5, 5, "亅迕別店刊枆逧Ateh!\"/方ｘ\r?$桏讋也呟沉"));
                }
                throw new FMCommunicationMessageException(FM_Int.replace(4, "桠挲仓这刳庇刜枊週Yrinadc旿＀觬枂莢収别皚\u0015\u0005\u0000髆讌奡赶"));
            }
        }
    }

    public int addTag(ITag iTag) throws FMCommunicationMessageException {
        if (this.f9441g) {
            return -1;
        }
        if (iTag == null) {
            return -2;
        }
        this.f9442h.add(iTag);
        return 0;
    }

    public int clear() {
        this.f9442h.clear();
        return 0;
    }

    public int fromPackageBody(int i, byte[] bArr) throws FMCommunicationMessageException {
        this.f9441g = true;
        this.f9439e = i;
        this.f9437c = this.f9438d.getMessageDefine(this.f9439e);
        if (this.f9437c == null) {
            throw new FMCommunicationMessageException(FM_Bytes.concat("档挻亜运剰廎刋染遲@m0mx3*旼）覣枋莡厇剼皃涊怲缎砒乃呁泑", 3, 91));
        }
        m13017a(bArr);
        return 0;
    }

    public int fromPackageBody(byte[] bArr) throws FMCommunicationMessageException {
        this.f9441g = true;
        if (bArr == null || bArr.length < 2) {
            throw new InvalidParameterException(FM_Exception.insert(180, 99, "校捵嬉苃廋刐枎遭淘恼无ｕ佼兺皆孒苊廄则镮廲乚吒泈"));
        }
        this.f9439e = Util4Java.String2Int(FM_CN.bcdBytesToString(Arrays.copyOf(bArr, 2)), -1);
        if (this.f9439e == -1) {
            this.f9442h.clear();
            throw new InvalidParameterException(Util4Java.endsWith("栨捡嬚苉庆刐柁遣涉怰斫７觺柇菢叅刡盋罛砊丄呏沐", 180, 94));
        }
        this.f9437c = this.f9438d.getMessageDefine(this.f9439e);
        if (this.f9437c == null) {
            throw new FMCommunicationMessageException(FM_CN.equals("桼捸事迃刿廕剜柘遭Sjsbc4!斣ｊ觴枘莮叜剫盈淕怡缉砑丌吚泖", 210));
        }
        m13017a(Arrays.copyOfRange(bArr, 2, bArr.length));
        return 0;
    }

    public int fromPackageBodyAndRetCode(int i, byte[] bArr) throws FMCommunicationMessageException {
        this.f9441g = true;
        this.f9439e = i;
        if (bArr == null || bArr.length < 2) {
            throw new InvalidParameterException(FM_CN.equals("桡挧嬍苉库刚枚逯消怾斴｟佤兰皂孀芊廖剝锤廪丐吆泊", 5));
        }
        this.f9440f = Arrays.copyOfRange(bArr, 2, 2);
        this.f9437c = this.f9438d.getMessageRetDefine(this.f9439e);
        if (this.f9437c == null) {
            throw new FMCommunicationMessageException(CRCUtil.substring(138, "栮捬亁迃創廁剎柀遯\u0017`chgvy斱～覾柘菤厈刹皐涗恥缃硁乆呞沔"));
        }
        m13017a(Arrays.copyOfRange(bArr, 2, bArr.length));
        return 0;
    }

    public int fromPackageBodyAndRetCode(byte[] bArr) throws FMCommunicationMessageException {
        this.f9441g = true;
        if (bArr == null || bArr.length < 4) {
            throw new InvalidParameterException(FM_Exception.insert(2, 89, "栿挱孏芓廅剔枘遵淆恨时ｕ伲兮盀孊芔廀剟镾廼乞各泐"));
        }
        this.f9439e = Util4Java.String2Int(FM_CN.bcdBytesToString(Arrays.copyOf(bArr, 2)), -1);
        this.f9440f = Arrays.copyOfRange(bArr, 2, 4);
        this.f9437c = this.f9438d.getMessageRetDefine(this.f9439e);
        if (this.f9437c == null) {
            throw new FMCommunicationMessageException(FM_Utils.regionMatches(3, 110, "桪振仃迆刽庖刐柑遣\u001cz~hh0 斥ｍ觬枍莼厏剷监淋恾缉砌乖呁沂"));
        }
        m13017a(Arrays.copyOfRange(bArr, 4, bArr.length));
        return 0;
    }

    public int getCode() {
        return this.f9439e;
    }

    public byte[] getRetCode() {
        return this.f9440f;
    }

    public ITag getTag4Id(int i) throws FMCommunicationMessageException {
        for (ITag iTag : this.f9442h) {
            if (iTag != null && i == iTag.getId()) {
                return iTag;
            }
        }
        return null;
    }

    public ITag getTag4Id(int i, int i2) throws FMCommunicationMessageException {
        List arrayList = new ArrayList();
        for (ITag iTag : this.f9442h) {
            if (iTag != null && i == iTag.getId()) {
                arrayList.add(iTag);
            }
        }
        if (i2 >= 0 && i2 <= arrayList.size()) {
            return (ITag) arrayList.get(i2);
        }
        throw new FMCommunicationMessageException(FM_Utils.regionMatches(5, 122, "桬挡\u001d\":桐讗哇廊刈叮莤叛s`|旣＃庆刔厪距甝"));
    }

    public ITag getTag4Index(int i) throws FMCommunicationMessageException {
        if (i < 0 || i > this.f9442h.size()) {
            throw new FMCommunicationMessageException(FM_Exception.insert(1, 74, "格挡庖剔叺菠厗4x斿？廒剐另跑畉"));
        }
        ITag iTag = (ITag) this.f9442h.get(i);
        return iTag != null ? iTag : null;
    }

    public int getTagCount() {
        return this.f9442h.size();
    }

    public int getTagCount4Id(int i) {
        return 0;
    }

    public boolean isValid() {
        if (this.f9437c == null) {
            if (this.f9440f == null) {
                this.f9437c = this.f9438d.getMessageDefine(this.f9439e);
            } else {
                this.f9437c = this.f9438d.getMessageRetDefine(this.f9439e);
            }
        }
        if (this.f9437c != null) {
            boolean z;
            MessageTagDefine[] messageTagDefines = this.f9437c.getMessageTagDefines();
            for (MessageTagDefine messageTagDefine : messageTagDefines) {
                if (messageTagDefine.getExist() == 1) {
                    z = false;
                    for (ITag id : this.f9442h) {
                        if (id.getId() == messageTagDefine.getTag()) {
                            z = true;
                        }
                    }
                    if (!z) {
                        if (this.f9435a == null) {
                            return false;
                        }
                        this.f9435a.warn(this.f9436b, String.format(new StringBuilder(FM_Int.replace(2, "鄚缴旚件宙乏Di|at~E")).append(this.f9439e).append(FM_Bytes.concat("\u0001徂頩孅圠皗\n(3D/M]ｇ乛嬙圤；诧淅怷乎吆泌", 5, 107)).toString(), new Object[]{Byte.valueOf(messageTagDefine.getTag())}));
                        return false;
                    }
                }
            }
            for (ITag id2 : this.f9442h) {
                z = false;
                for (MessageTagDefine tag : messageTagDefines) {
                    if (id2.getId() == tag.getTag()) {
                        z = true;
                    }
                }
                if (!z) {
                    if (this.f9435a == null) {
                        return false;
                    }
                    this.f9435a.warn(this.f9436b, String.format(FM_Bytes.concat("淑恭书嶦绒杏盋L\u0000\rH9\u001dS;坨酄罼旜仲丠杼寅乁", 2, 41), new Object[]{Byte.valueOf(id2.getId())}));
                    return false;
                }
            }
            return true;
        } else if (this.f9435a == null) {
            return false;
        } else {
            this.f9435a.warn(this.f9436b, Util4Java.endsWith("涊性吆沁怽梀柣斺＞華又涌急宊丟俽怭夹赫", 5, 70));
            return false;
        }
    }

    public void setRetCode(byte[] bArr) {
        this.f9440f = bArr;
    }

    public int setVal(ITag iTag, int i) throws FMCommunicationMessageException {
        return -1;
    }

    public byte[] toBytes() throws FMCommunicationMessageException {
        if (isValid()) {
            byte[] intToBcdBytes = FM_CN.intToBcdBytes(this.f9439e, 2);
            byte[] bArr = new byte[0];
            bArr = intToBcdBytes;
            for (ITag toBytes : this.f9442h) {
                intToBcdBytes = toBytes.toBytes();
                if (intToBcdBytes != null) {
                    bArr = FM_Bytes.join(bArr, intToBcdBytes);
                }
            }
            return bArr;
        }
        throw new FMCommunicationMessageException(FM_Exception.insert(204, 9, "淘怶宻谪輸挿或存芚庎初？涔怪宷谶斠攁"));
    }
}
