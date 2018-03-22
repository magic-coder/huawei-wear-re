package cn.com.fmsh.communication.message.test;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.IMessage;
import cn.com.fmsh.communication.message.IMessageHandler;
import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.MessageHandleFactory;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.tsm.business.constants.Constants.TradeCode;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {
    private /* synthetic */ IMessageHandler f9488a = null;

    public static void main(String[] strArr) {
        new Test().load();
    }

    public void create() {
        FM_Bytes.hexStringToBytes(FM_Utils.regionMatches(4, 67, "l/h,Br6zJ\tT\u0013^\u001d\\\u00004q9|#b%h/nq4{:\f\"d$j\\pBvH\u000e9b&hYn\u00034\u0005Hz d%k/m1w;y=c'e)o\u0002;v?<a&k(m2w4y>\u0012'f)"));
        try {
            IMessage createMessage = this.f9488a.createMessage((int) TradeCode.SUCESS_4_PLATFORM);
            ITag createTag = this.f9488a.createTag((byte) TagName.BUSINESS_HANDLE_RESULT);
            createTag.addValue(new byte[1]);
            createMessage.addTag(createTag);
            System.out.println(FM_Bytes.bytesToHexString(createMessage.toBytes()));
        } catch (FMCommunicationMessageException e) {
            e.printStackTrace();
        }
    }

    public void createMessageTest() {
        System.out.println(FM_Utils.regionMatches(3, 48, "0q6bg&^& p2dv\u0017v0'>n>.~.~n>n>.~.~n>n>.~.~n>n>.~.~n>n>"));
        byte[] bArr = new byte[58];
        bArr[0] = (byte) 16;
        bArr[1] = (byte) 33;
        bArr[2] = (byte) 2;
        bArr[3] = TagName.ORDER_TIME;
        bArr[8] = (byte) 1;
        bArr[13] = (byte) 1;
        bArr[18] = (byte) 1;
        bArr[23] = (byte) 1;
        bArr[24] = (byte) 3;
        bArr[25] = (byte) 32;
        bArr[26] = (byte) 1;
        bArr[27] = (byte) 2;
        bArr[28] = (byte) 3;
        bArr[29] = (byte) 4;
        bArr[30] = (byte) 2;
        bArr[31] = (byte) 2;
        bArr[32] = (byte) 3;
        bArr[33] = (byte) 4;
        bArr[34] = (byte) 1;
        bArr[35] = (byte) 2;
        bArr[36] = (byte) 3;
        bArr[37] = (byte) 4;
        bArr[38] = (byte) 2;
        bArr[39] = (byte) 2;
        bArr[40] = (byte) 3;
        bArr[41] = (byte) 4;
        bArr[42] = (byte) 1;
        bArr[43] = (byte) 2;
        bArr[44] = (byte) 3;
        bArr[45] = (byte) 4;
        bArr[46] = (byte) 2;
        bArr[47] = (byte) 2;
        bArr[48] = (byte) 3;
        bArr[49] = (byte) 4;
        bArr[50] = (byte) 1;
        bArr[51] = (byte) 2;
        bArr[52] = (byte) 3;
        bArr[53] = (byte) 4;
        bArr[54] = (byte) 2;
        bArr[55] = (byte) 2;
        bArr[56] = (byte) 3;
        bArr[57] = (byte) 4;
        IMessage createMessage = this.f9488a.createMessage(1021);
        ITag createTag = this.f9488a.createTag((byte) 2);
        ITag createTag2 = this.f9488a.createTag((byte) 3);
        try {
            createTag.addValue(FM_Exception.insert(6, 67, "~$w6d-u8g7|\"i4f#s:%q"));
            createTag2.addValue(BCCUtil.getChars("&<?>,um`odzq|nkkbmyzxsrhi)$#;}}", 2, 3));
        } catch (FMCommunicationMessageException e) {
            e.printStackTrace();
        }
        System.out.println(new StringBuilder(FM_Long.copyValueOf("6~{)$zc[kkme$", 314)).append(createTag.isValid()).toString());
        System.out.println(new StringBuilder(CRCUtil.substring(2, "{{b (/\"\n&>4l)")).append(createTag2.isValid()).toString());
        try {
            createMessage.addTag(createTag);
            createMessage.addTag(createTag2);
        } catch (FMCommunicationMessageException e2) {
            e2.printStackTrace();
        }
        System.out.println(createMessage.getCode());
        System.out.println(new StringBuilder(FM_Exception.insert(1, 67, "f'~ en")).append(createMessage.getTagCount()).toString());
        try {
            System.out.println(new StringBuilder(FM_Long.copyValueOf("~fcH\u001aa", 2)).append(createMessage.getTag4Index(0).getId()).toString());
        } catch (FMCommunicationMessageException e22) {
            e22.printStackTrace();
        }
        System.out.println(new StringBuilder(BCCUtil.getChars("<:K0)p){", 5, 84)).append(createMessage.isValid()).toString());
        try {
            System.out.println(new StringBuilder(Util4Java.endsWith("m\"=f}d/k", 3, 103)).append(FM_Bytes.bytesToHexString(createMessage.toBytes())).toString());
        } catch (Exception e3) {
            System.out.println(Util4Java.getExceptionInfo(e3));
        }
    }

    public void createMessageTest4Byte() {
        System.out.println(FM_Utils.regionMatches(4, 43, "7m/4t.\u001bd?$c*=W+*prg8mf;la:o`5nc4ib7h=6k<1j?0e>3d92g8"));
        byte[] bArr = new byte[58];
        bArr[0] = (byte) 16;
        bArr[1] = (byte) 33;
        bArr[2] = (byte) 2;
        bArr[3] = TagName.ORDER_TIME;
        bArr[8] = (byte) 1;
        bArr[13] = (byte) 1;
        bArr[18] = (byte) 1;
        bArr[23] = (byte) 1;
        bArr[24] = (byte) 3;
        bArr[25] = (byte) 32;
        bArr[26] = (byte) 1;
        bArr[27] = (byte) 2;
        bArr[28] = (byte) 3;
        bArr[29] = (byte) 4;
        bArr[30] = (byte) 2;
        bArr[31] = (byte) 2;
        bArr[32] = (byte) 3;
        bArr[33] = (byte) 4;
        bArr[34] = (byte) 1;
        bArr[35] = (byte) 2;
        bArr[36] = (byte) 3;
        bArr[37] = (byte) 4;
        bArr[38] = (byte) 2;
        bArr[39] = (byte) 2;
        bArr[40] = (byte) 3;
        bArr[41] = (byte) 4;
        bArr[42] = (byte) 1;
        bArr[43] = (byte) 2;
        bArr[44] = (byte) 3;
        bArr[45] = (byte) 4;
        bArr[46] = (byte) 2;
        bArr[47] = (byte) 2;
        bArr[48] = (byte) 3;
        bArr[49] = (byte) 4;
        bArr[50] = (byte) 1;
        bArr[51] = (byte) 2;
        bArr[52] = (byte) 3;
        bArr[53] = (byte) 4;
        bArr[54] = (byte) 2;
        bArr[55] = (byte) 2;
        bArr[56] = (byte) 3;
        bArr[57] = (byte) 4;
        IMessage iMessage = null;
        try {
            iMessage = this.f9488a.createMessage(bArr);
        } catch (Exception e) {
            System.out.println(Util4Java.getExceptionInfo(e));
        }
        if (iMessage == null) {
            System.out.println(FM_Exception.insert(2, ReportInfoUtils.FEEDBACK_SUCCESS, "es96&(\u0005&-*5(/\u0011%hb1jfkq"));
        }
        System.out.println(iMessage.getCode());
        System.out.println(new StringBuilder(CRCUtil.substring(224, ".7v`m>")).append(iMessage.getTagCount()).toString());
        try {
            System.out.println(new StringBuilder(FM_CN.equals("#)>\u0003_6", 4)).append(iMessage.getTag4Index(0).getId()).toString());
        } catch (FMCommunicationMessageException e2) {
            e2.printStackTrace();
        }
        System.out.println(new StringBuilder(FM_Int.replace(218, "&!\u0003977%~")).append(iMessage.isValid()).toString());
    }

    public void createTagTest() {
        try {
            MessageHandleFactory.getMessageHandler().createTag((byte) 1).addValue(new byte[]{(byte) 2});
        } catch (FMCommunicationMessageException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        this.f9488a = MessageHandleFactory.getMessageHandler();
        try {
            this.f9488a.loadDefine(new FileInputStream(new File(FM_Exception.insert(3, 20, "B! '8(*~bu;l6{o`>(`3\"T~#77f`v?6<iD|4x\r\u0012 5(b霡呆EYP纏窴盋罒丝丑劾揶儢厑敿捭亳挩粤續(*=\u001c#.2c(抛杠旺栟$计讲旀核`酎罹斌仩|*>|pv,:\fttz14.qkjw"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (FMCommunicationMessageException e2) {
            e2.printStackTrace();
        }
    }

    public void test() {
        try {
            IMessage createMessage = this.f9488a.createMessage(FM_Bytes.hexStringToBytes(CRCUtil.substring(3, "(#4 ^vbn\u000e\u0015\u0018ORYHTp}epf1<+2=(w~\u0018v`h6P,F\"\\\nenzd\u001d:W0ITv|`qk1=+7=)wciuc\u001e?\"+; -zglyf38%2N#r}")));
            System.out.println(createMessage.getCode());
            System.out.println(new StringBuilder(FM_Exception.insert(2, 45, "e|5cn}")).append(createMessage.getTagCount()).toString());
            System.out.println(FM_Bytes.bytesToHexString(createMessage.getTag4Id(-79).getBytesVal()));
        } catch (FMCommunicationMessageException e) {
            e.printStackTrace();
        }
    }
}
