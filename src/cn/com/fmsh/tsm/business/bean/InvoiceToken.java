package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;

public class InvoiceToken {
    private /* synthetic */ byte[] f9605a;
    private /* synthetic */ String f9606b;

    public static InvoiceToken fromTag(ITag iTag) throws FMCommunicationMessageException {
        InvoiceToken invoiceToken = null;
        FMLog log = LogFactory.getInstance().getLog();
        if (iTag != null) {
            ITag[] itemTags = iTag.getItemTags();
            if (itemTags != null && itemTags.length >= 1) {
                invoiceToken = new InvoiceToken();
                for (ITag iTag2 : itemTags) {
                    switch (iTag2.getId()) {
                        case (byte) 17:
                            invoiceToken.setOrderId(iTag2.getBytesVal());
                            break;
                        case (byte) 66:
                            invoiceToken.setToken(FM_Bytes.bytesToHexString(iTag2.getBytesVal()));
                            break;
                        default:
                            break;
                    }
                }
            } else if (log != null) {
                log.warn(BusinessOrder.class.getName(), FM_Bytes.concat("\u000fab甕戟叅祱题叕凥诌俳恸旪ｍ\u0012*7嬅頣乥稾", 4, 5));
            }
        } else if (log != null) {
            log.warn(BusinessOrder.class.getName(), Util4Java.endsWith("Vea甗戚叝祦颖叄凹诗俹恵旪２Tcc寿豩丰究", 5, 2));
        }
        return invoiceToken;
    }

    public byte[] getOrderId() {
        return this.f9605a;
    }

    public String getToken() {
        return this.f9606b;
    }

    public void setOrderId(byte[] bArr) {
        this.f9605a = bArr;
    }

    public void setToken(String str) {
        this.f9606b = str;
    }
}
