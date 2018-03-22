package cn.com.fmsh.script.bean;

import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.MessageHandleFactory;
import cn.com.fmsh.communication.message.core.MessageHandler;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.Util4Java;
import java.util.ArrayList;
import java.util.List;

public class ApduReponseList {
    private /* synthetic */ List<ApduResponse> f9493a = new ArrayList();

    public static void main(String[] strArr) {
        byte[] hexStringToBytes = FM_Bytes.hexStringToBytes(Util4Java.endsWith("4'b#", 5, 60));
        ApduResponse apduResponse = new ApduResponse();
        apduResponse.setResult(hexStringToBytes);
        apduResponse.setId(1);
        ApduReponseList apduReponseList = new ApduReponseList();
        apduReponseList.add(apduResponse);
        System.out.println(FM_Bytes.bytesToHexString(apduReponseList.toBytes4A2()));
        System.out.println(FM_Bytes.bytesToHexString(apduReponseList.toBytes4A3()));
    }

    public void add(ApduResponse apduResponse) {
        this.f9493a.add(apduResponse);
    }

    public ApduResponse[] getApduResponse() {
        return (ApduResponse[]) this.f9493a.toArray(new ApduResponse[this.f9493a.size()]);
    }

    public List<byte[]> getApduResponseList() {
        List<byte[]> arrayList = new ArrayList();
        for (ApduResponse apduResponse : this.f9493a) {
            if (apduResponse != null) {
                arrayList.add(apduResponse.getResult());
            }
        }
        return arrayList;
    }

    public ApduResponse[] getApduResponses() {
        return (ApduResponse[]) this.f9493a.toArray(new ApduResponse[0]);
    }

    public int size() {
        return this.f9493a.size();
    }

    public byte[] toBytes4A2() {
        return this.f9493a.size() > 0 ? ((ApduResponse) this.f9493a.get(0)).toBytes() : null;
    }

    public byte[] toBytes4A3() {
        byte[] bArr = new byte[0];
        byte[] bArr2 = bArr;
        for (ApduResponse apduResponse : this.f9493a) {
            if (apduResponse != null) {
                bArr2 = FM_Bytes.join(bArr2, apduResponse.toBytes());
            }
        }
        int length = bArr2.length;
        byte[] bArr3 = new byte[(length + 2)];
        bArr3[0] = TagName.ResponseMultiple;
        bArr3[1] = (byte) length;
        for (int i = 0; i < length; i++) {
            bArr3[i + 2] = bArr2[i];
        }
        return bArr3;
    }

    public ITag toTag4A2() throws FMCommunicationMessageException {
        return this.f9493a.size() > 0 ? MessageHandleFactory.getMessageHandler().createTag(((ApduResponse) this.f9493a.get(0)).toBytes()) : null;
    }

    public ITag toTag4A3() throws FMCommunicationMessageException {
        MessageHandler messageHandler = MessageHandleFactory.getMessageHandler();
        ITag createTag = messageHandler.createTag((byte) TagName.ResponseMultiple);
        for (ApduResponse apduResponse : this.f9493a) {
            if (apduResponse != null) {
                createTag.addValue(messageHandler.createTag(apduResponse.toBytes()));
            }
        }
        return createTag;
    }
}
