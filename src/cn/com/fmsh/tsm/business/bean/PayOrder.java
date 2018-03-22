package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;

public class PayOrder {
    private /* synthetic */ byte[] f9639a;
    private /* synthetic */ String f9640b;
    private /* synthetic */ String f9641c;
    private /* synthetic */ String f9642d;
    private /* synthetic */ int f9643e;
    private /* synthetic */ EnumOrderStatus f9644f;
    private /* synthetic */ String f9645g;
    private /* synthetic */ int f9646h;
    private /* synthetic */ byte[] f9647i;

    public static PayOrder fromTag(ITag iTag) throws FMCommunicationMessageException {
        PayOrder payOrder = null;
        FMLog log = LogFactory.getInstance().getLog();
        if (iTag != null) {
            ITag[] itemTags = iTag.getItemTags();
            if (itemTags != null && itemTags.length >= 1) {
                payOrder = new PayOrder();
                for (ITag iTag2 : itemTags) {
                    switch (iTag2.getId()) {
                        case (byte) 2:
                            payOrder.setPayUser(iTag2.getStringVal());
                            break;
                        case (byte) 13:
                            payOrder.setChannel(iTag2.getIntVal());
                            break;
                        case (byte) 16:
                            payOrder.setAmount(FM_Bytes.bytesToInt(iTag2.getBytesVal()));
                            break;
                        case (byte) 18:
                            payOrder.setThirdPayInfo(iTag2.getStringVal());
                            break;
                        case (byte) 19:
                            payOrder.setDate(iTag2.getStringVal());
                            break;
                        case (byte) 20:
                            payOrder.setTime(iTag2.getStringVal());
                            break;
                        case (byte) 21:
                            payOrder.setState(EnumOrderStatus.getOrderStatus4ID(iTag2.getIntVal()));
                            break;
                        case (byte) 105:
                            payOrder.setMainOrder(iTag2.getBytesVal());
                            break;
                        case (byte) 106:
                            payOrder.setId(iTag2.getBytesVal());
                            break;
                        default:
                            break;
                    }
                }
            } else if (log != null) {
                log.warn(BusinessOrder.class.getName(), FM_Long.copyValueOf("Yk`甛我敱亃诺匀斤ｃ\u0018(!嬓頹乧稠", 5));
            }
        } else if (log != null) {
            log.warn(BusinessOrder.class.getName(), BCCUtil.getChars("\u0007=\"甑戇支云诰华旲！\u0002>/寨豻丹稶", 3, 105));
        }
        return payOrder;
    }

    public int getAmount() {
        return this.f9643e;
    }

    public int getChannel() {
        return this.f9646h;
    }

    public String getDate() {
        return this.f9641c;
    }

    public byte[] getId() {
        return this.f9639a;
    }

    public byte[] getMainOrder() {
        return this.f9647i;
    }

    public String getPayUser() {
        return this.f9645g;
    }

    public EnumOrderStatus getState() {
        return this.f9644f;
    }

    public String getThirdPayInfo() {
        return this.f9640b;
    }

    public String getTime() {
        return this.f9642d;
    }

    public void setAmount(int i) {
        this.f9643e = i;
    }

    public void setChannel(int i) {
        this.f9646h = i;
    }

    public void setDate(String str) {
        this.f9641c = str;
    }

    public void setId(byte[] bArr) {
        this.f9639a = bArr;
    }

    public void setMainOrder(byte[] bArr) {
        this.f9647i = bArr;
    }

    public void setPayUser(String str) {
        this.f9645g = str;
    }

    public void setState(EnumOrderStatus enumOrderStatus) {
        this.f9644f = enumOrderStatus;
    }

    public void setThirdPayInfo(String str) {
        this.f9640b = str;
    }

    public void setTime(String str) {
        this.f9642d = str;
    }
}
