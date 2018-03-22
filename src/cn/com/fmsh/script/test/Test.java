package cn.com.fmsh.script.test;

import cn.com.fmsh.communication.message.IMessageHandler;
import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.MessageHandleFactory;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.script.ApduFilterDataInit;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.script.ApduHandler.ApduHandlerType;
import cn.com.fmsh.script.ScriptHandler;
import cn.com.fmsh.script.ScriptHandlerFactory;
import cn.com.fmsh.script.bean.ApduReponseList;
import cn.com.fmsh.script.bean.ApduRequestList;
import cn.com.fmsh.script.bean.ApduResponse;
import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.script.core.FilterPolicy;
import cn.com.fmsh.script.exception.FMScriptHandleException;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private /* synthetic */ IMessageHandler f9524a = MessageHandleFactory.getMessageHandler();

    class C2896a implements ApduHandler {
        final /* synthetic */ Test f9522a;

        private /* synthetic */ C2896a(Test test) {
            this.f9522a = test;
        }

        public void close() {
        }

        public boolean connect() {
            return true;
        }

        public ApduHandlerType getApduHandlerType() {
            return ApduHandlerType.OPEN_MOBILE;
        }

        public boolean isConnect() {
            return false;
        }

        public boolean open(byte[] bArr) {
            System.out.println(new StringBuilder(FM_CN.equals(":62&9krhg", 2)).append(FM_Bytes.bytesToHexString(bArr)).toString());
            return true;
        }

        public byte[] transceive(byte[] bArr) throws FMScriptHandleException {
            byte[] bArr2 = new byte[2];
            bArr2[0] = TagName.SYSTEM_VERSION;
            return bArr2;
        }
    }

    class C2897b implements ApduFilterDataInit {
        final /* synthetic */ Test f9523a;

        private /* synthetic */ C2897b(Test test) {
            this.f9523a = test;
        }

        public List<FilterPolicy> getFilterPolicies() {
            List<FilterPolicy> arrayList = new ArrayList();
            FilterPolicy filterPolicy = new FilterPolicy();
            filterPolicy.setCla((byte) 0);
            filterPolicy.setIns(ScriptToolsConst.TagName.CommandMultiple);
            filterPolicy.addFilterData(new byte[0]);
            arrayList.add(filterPolicy);
            return arrayList;
        }
    }

    public static void main(String[] strArr) {
        Test test = new Test();
        test.load();
        test.testM();
    }

    public void load() {
        this.f9524a = MessageHandleFactory.getMessageHandler();
        try {
            try {
                this.f9524a.loadDefine(new FileInputStream(new File(FM_CN.equals("\u0015}w=fl\"3*3\"#ta8r6/w2v`", 3))));
            } catch (FMCommunicationMessageException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public void testM() {
        ScriptHandler scriptHandler = ScriptHandlerFactory.getInstance().getScriptHandler(new C2896a());
        scriptHandler.setApduFilterDataInit(new C2897b());
        ApduRequestList apduRequestList = new ApduRequestList();
        System.out.println(FM_Utils.regionMatches(162, 85, "/z!,{&-x'2y$3~%0*1|+6}ao,`4c.5`/:a,;f-8g29d3>e0?j1<k6=h7bi4cn5`o:al;fm8g"));
        ITag createTag = this.f9524a.createTag((byte) ScriptToolsConst.TagName.ScriptDown);
        ITag createTag2 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.CommandSingle);
        ITag createTag3 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.CommandMultiple);
        ITag createTag4 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.CommandMultiple);
        ITag createTag5 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.CommandMultiple);
        try {
            byte[] bArr = new byte[8];
            bArr[0] = (byte) 1;
            bArr[2] = ScriptToolsConst.TagName.CommandMultiple;
            bArr[6] = (byte) -1;
            bArr[7] = (byte) -1;
            createTag2.addValue(bArr);
            createTag.addValue(createTag2);
            createTag2 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.TagSerial);
            createTag2.addValue(2);
            createTag3.addValue(createTag2);
            createTag2 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.TagApdu);
            bArr = new byte[5];
            bArr[1] = ScriptToolsConst.TagName.CommandMultiple;
            createTag2.addValue(bArr);
            createTag3.addValue(createTag2);
            createTag2 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.TagExpectationAndNext);
            bArr = new byte[3];
            bArr[0] = TagName.SYSTEM_VERSION;
            createTag2.addValue(bArr);
            createTag3.addValue(createTag2);
            createTag2 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.TagExpectationAndNext);
            bArr = new byte[3];
            bArr[0] = TagName.MAIN_ORDER_ID;
            bArr[2] = (byte) -1;
            createTag2.addValue(bArr);
            createTag3.addValue(createTag2);
            createTag.addValue(createTag3);
            createTag2 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.TagSerial);
            createTag2.addValue(3);
            createTag4.addValue(createTag2);
            createTag2 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.TagApdu);
            byte[] bArr2 = new byte[5];
            bArr2[1] = ScriptToolsConst.TagName.CommandMultiple;
            createTag2.addValue(bArr2);
            createTag4.addValue(createTag2);
            createTag2 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.TagExpectationAndNext);
            bArr2 = new byte[3];
            bArr2[0] = TagName.SYSTEM_VERSION;
            bArr2[2] = (byte) 4;
            createTag2.addValue(bArr2);
            createTag4.addValue(createTag2);
            createTag2 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.TagExpectationAndNext);
            bArr2 = new byte[3];
            bArr2[0] = TagName.MAIN_ORDER_ID;
            bArr2[2] = (byte) -1;
            createTag2.addValue(bArr2);
            createTag4.addValue(createTag2);
            createTag.addValue(createTag4);
            createTag2 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.TagSerial);
            createTag2.addValue(4);
            createTag5.addValue(createTag2);
            createTag2 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.TagApdu);
            bArr2 = new byte[5];
            bArr2[1] = ScriptToolsConst.TagName.CommandMultiple;
            createTag2.addValue(bArr2);
            createTag5.addValue(createTag2);
            createTag2 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.TagExpectationAndNext);
            bArr2 = new byte[3];
            bArr2[0] = TagName.SYSTEM_VERSION;
            bArr2[2] = (byte) -1;
            createTag2.addValue(bArr2);
            createTag5.addValue(createTag2);
            createTag2 = this.f9524a.createTag((byte) ScriptToolsConst.TagName.TagExpectationAndNext);
            bArr2 = new byte[3];
            bArr2[0] = TagName.MAIN_ORDER_ID;
            bArr2[2] = (byte) -1;
            createTag2.addValue(bArr2);
            createTag5.addValue(createTag2);
            createTag.addValue(createTag5);
        } catch (Exception e) {
            System.out.println(Util4Java.getExceptionInfo(e));
        }
        try {
            apduRequestList.fromTag(createTag);
        } catch (Exception e2) {
            System.out.println(Util4Java.getExceptionInfo(e2));
        } catch (Exception e22) {
            System.out.println(Util4Java.getExceptionInfo(e22));
        }
        ApduReponseList apduReponseList = null;
        try {
            apduReponseList = scriptHandler.execute(apduRequestList);
        } catch (FMScriptHandleException e3) {
            e3.printStackTrace();
        }
        ApduResponse[] apduResponse = apduReponseList.getApduResponse();
        System.out.println(new StringBuilder(FM_Utils.regionMatches(284, 98, "m>4gF3(ur-%1*j-$kz8h")).append(apduResponse.length).toString());
        for (ApduResponse apduResponse2 : apduResponse) {
            System.out.println(new StringBuilder(FM_CN.equals(">,c", 4)).append(apduResponse2.getId()).append(Util4Java.endsWith(")r)a=9q;4Y,(p$", 300, 41)).append(FM_Bytes.bytesToHexString(apduResponse2.getResult())).toString());
        }
    }

    public void testSingle() {
        ApduReponseList apduReponseList = null;
        ScriptHandler scriptHandler = ScriptHandlerFactory.getInstance().getScriptHandler(new C2896a());
        scriptHandler.setApduFilterDataInit(new C2897b());
        ApduRequestList apduRequestList = new ApduRequestList();
        System.out.println(FM_CN.equals("~ix+:%4gvap#2=,?nyh{*5$~>?)s\"-</>ixkz%4'6apcr},?.9h{ju$7&1`sbm|/>)8kzet'6", 240));
        ITag createTag = this.f9524a.createTag((byte) ScriptToolsConst.TagName.CommandSingle);
        try {
            byte[] bArr = new byte[9];
            bArr[0] = (byte) 1;
            bArr[1] = (byte) 5;
            bArr[3] = ScriptToolsConst.TagName.CommandMultiple;
            bArr[7] = TagName.SYSTEM_VERSION;
            createTag.addValue(bArr);
        } catch (FMCommunicationMessageException e) {
            e.printStackTrace();
        }
        try {
            apduRequestList.fromTag(createTag);
        } catch (Exception e2) {
            System.out.println(Util4Java.getExceptionInfo(e2));
        } catch (Exception e22) {
            System.out.println(Util4Java.getExceptionInfo(e22));
        }
        try {
            apduReponseList = scriptHandler.execute(apduRequestList);
        } catch (FMScriptHandleException e3) {
            e3.printStackTrace();
        }
        ApduResponse[] apduResponse = apduReponseList.getApduResponse();
        System.out.println(new StringBuilder(CRCUtil.substring(4, "plcgO-#1'':y;lnx&8?x")).append(apduResponse.length).toString());
        for (ApduResponse result : apduResponse) {
            System.out.println(FM_Bytes.bytesToHexString(result.getResult()));
        }
    }
}
