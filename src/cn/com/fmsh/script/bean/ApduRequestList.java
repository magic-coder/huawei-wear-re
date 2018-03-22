package cn.com.fmsh.script.bean;

import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import cn.com.fmsh.script.exception.FMScriptHandleException;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApduRequestList {
    private /* synthetic */ FMLog f9502a = LogFactory.getInstance().getLog();
    private final /* synthetic */ String f9503b = FM_Long.copyValueOf("MybvR8+\"1\":", 4);
    final /* synthetic */ int f9504c = 1;
    private /* synthetic */ Map<Integer, ApduRequest> f9505d = new HashMap();

    private final /* synthetic */ void m13019a(byte[] bArr, ApduRequest apduRequest) {
        apduRequest.setId(bArr[0]);
        apduRequest.setApdu(Arrays.copyOfRange(bArr, 1, bArr.length - 2));
        byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr.length - 2, bArr.length);
        apduRequest.addExpectationAndNext(new byte[]{copyOfRange[0], copyOfRange[1], (byte) 0});
    }

    private final /* synthetic */ void m13020a(ITag[] iTagArr, ApduRequest apduRequest) throws FMCommunicationMessageException {
        for (ITag iTag : iTagArr) {
            switch (iTag.getId()) {
                case (byte) 56:
                    apduRequest.setId(iTag.getIntVal());
                    break;
                case (byte) 57:
                    apduRequest.setApdu(iTag.getBytesVal());
                    break;
                case (byte) 60:
                    byte[] bytesVal = iTag.getBytesVal();
                    if (bytesVal == null) {
                        break;
                    }
                    apduRequest.addExpectationAndNext(bytesVal);
                    break;
                default:
                    break;
            }
        }
    }

    public boolean add(ApduRequest apduRequest) throws FMScriptHandleException {
        if (apduRequest == null) {
            return false;
        }
        if (this.f9505d.size() >= 1 || 1 == apduRequest.getId()) {
            this.f9505d.put(Integer.valueOf(apduRequest.getId()), apduRequest);
            return true;
        }
        throw new FMScriptHandleException(CRCUtil.substring(2, "徊扽衉皔笷乆朰捛亣盖廒刟古专昦%３奇呝腚杧奒琇夽贲"));
    }

    public void clear() {
        this.f9505d.clear();
    }

    public void fromTag(ITag iTag) throws FMCommunicationMessageException, FMScriptHandleException {
        if (iTag == null) {
            throw new FMCommunicationMessageException(FM_Int.replace(2, "\u0003\u001b\u001a转捡丼挎仨雉吚旣４O_F举穽"));
        }
        byte id = iTag.getId();
        if (!iTag.isValid()) {
            throw new FMCommunicationMessageException(String.format(Util4Java.endsWith("核捭触林巬兼揝侔皕GTPB>EB觢枓诲汅挎仯旻＃ERR旷救", 4, 2), new Object[]{Byte.valueOf(iTag.getId())}));
        } else if (id == TagName.ScriptDown) {
            int itemCount = iTag.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                ITag itemTagVal = iTag.getItemTagVal(i);
                if (itemTagVal != null) {
                    ApduRequest apduRequest = new ApduRequest();
                    byte id2 = itemTagVal.getId();
                    apduRequest.setTag(id2);
                    if (id2 == TagName.CommandMultiple) {
                        m13020a(itemTagVal.getItemTags(), apduRequest);
                    } else if (id2 == TagName.CommandSingle) {
                        m13019a(itemTagVal.getBytesVal(), apduRequest);
                    } else {
                        this.f9505d.clear();
                        throw new FMCommunicationMessageException(String.format(CRCUtil.substring(174, "Zw呟霾厭肯晲I#戈而U+ｆ记\u0014*1Z)O_旭敐"), new Object[]{Byte.valueOf(id2)}));
                    }
                    add(apduRequest);
                }
            }
        } else if (id == TagName.CommandSingle) {
            ApduRequest apduRequest2 = new ApduRequest();
            apduRequest2.setTag(id);
            m13019a(iTag.getBytesVal(), apduRequest2);
            add(apduRequest2);
        } else {
            throw new FMCommunicationMessageException(String.format(FM_Int.replace(64, "T(戍耛\u0000u戊肷輡挲乩九厈腆杳ｎ\u0011\t\f\u0015t\f\n斺攕"), new Object[]{Byte.valueOf(id)}));
        }
    }

    public ApduRequest getApduRequest(int i) {
        return (ApduRequest) this.f9505d.get(Integer.valueOf(i));
    }

    public ApduRequest[] getApduRequests() {
        ApduRequest[] apduRequestArr = new ApduRequest[this.f9505d.size()];
        int i = 0;
        for (Object obj : this.f9505d.keySet()) {
            apduRequestArr[i] = (ApduRequest) this.f9505d.get(obj);
            i++;
        }
        return apduRequestArr;
    }

    public List<byte[]> getApdus() {
        List<byte[]> arrayList = new ArrayList();
        for (Object obj : this.f9505d.keySet()) {
            ApduRequest apduRequest = (ApduRequest) this.f9505d.get(obj);
            if (apduRequest != null) {
                arrayList.add(apduRequest.getApdu());
            }
        }
        return arrayList;
    }

    public ApduRequest getFirstApduRequest() {
        return (ApduRequest) this.f9505d.get(Integer.valueOf(1));
    }

    public int size() {
        return this.f9505d.size();
    }

    public byte[] toBytes() {
        return null;
    }
}
