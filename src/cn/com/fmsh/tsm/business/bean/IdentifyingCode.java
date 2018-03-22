package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;

public class IdentifyingCode {
    private /* synthetic */ String f9603a;
    private /* synthetic */ byte[] f9604b;

    public static IdentifyingCode fromTag(ITag iTag) throws FMCommunicationMessageException {
        IdentifyingCode identifyingCode = null;
        FMLog log = LogFactory.getInstance().getLog();
        if (iTag != null) {
            ITag[] itemTags = iTag.getItemTags();
            if (itemTags != null && itemTags.length >= 1) {
                identifyingCode = new IdentifyingCode();
                for (ITag iTag2 : itemTags) {
                    switch (iTag2.getId()) {
                        case (byte) 12:
                            identifyingCode.setCode(iTag2.getStringVal());
                            break;
                        case (byte) 64:
                            identifyingCode.setSerial(iTag2.getTagValue());
                            break;
                        default:
                            break;
                    }
                }
            } else if (log != null) {
                log.warn(BusinessOrder.class.getName(), FM_Utils.regionMatches(4, 98, "t輺捺N=9容豣刴髊讉砋寵谯斦＞@7?寣豽乤稺"));
            }
        } else if (log != null) {
            log.warn(BusinessOrder.class.getName(), FM_Bytes.concat("%轠挱\u000e`/家豷刭髈诊砓宠象旱ｂ\u0001}$害豰丢稥", 270, 39));
        }
        return identifyingCode;
    }

    public String getCode() {
        return this.f9603a;
    }

    public byte[] getSerial() {
        return this.f9604b;
    }

    public void setCode(String str) {
        this.f9603a = str;
    }

    public void setSerial(byte[] bArr) {
        this.f9604b = bArr;
    }
}
