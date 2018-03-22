package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderLoadType;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderType;
import cn.com.fmsh.tsm.business.enums.EnumCardAppType;
import cn.com.fmsh.tsm.business.enums.EnumCardIoType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import java.io.Serializable;

public class BusinessOrder implements Serializable {
    private static final /* synthetic */ long serialVersionUID = 1;
    private /* synthetic */ String f9536a;
    private /* synthetic */ String f9537b;
    private /* synthetic */ byte[] f9538c;
    private /* synthetic */ int f9539d;
    private /* synthetic */ EnumOrderStatus f9540e;
    private /* synthetic */ int f9541f;
    private /* synthetic */ byte[] f9542g;
    private /* synthetic */ byte[] f9543h;
    private /* synthetic */ String f9544i;
    private /* synthetic */ int f9545j;
    private /* synthetic */ int f9546k;
    private /* synthetic */ EnumCardIoType f9547l;
    private /* synthetic */ EnumCardAppType f9548m;
    private /* synthetic */ EnumBusinessOrderType f9549n;
    private /* synthetic */ String f9550o;
    private /* synthetic */ byte[] f9551p;
    private /* synthetic */ String f9552q;
    private /* synthetic */ byte[] f9553r;
    private /* synthetic */ EnumBusinessOrderLoadType f9554s;

    public static BusinessOrder fromTag(ITag iTag) throws FMCommunicationMessageException {
        BusinessOrder businessOrder = null;
        FMLog log = LogFactory.getInstance().getLog();
        if (iTag != null) {
            ITag[] itemTags = iTag.getItemTags();
            if (itemTags != null && itemTags.length >= 1) {
                businessOrder = new BusinessOrder();
                for (ITag iTag2 : itemTags) {
                    switch (iTag2.getId()) {
                        case (byte) -79:
                            businessOrder.setSeid(iTag2.getBytesVal());
                            break;
                        case (byte) -55:
                            businessOrder.setBusinessOrderLoadType(EnumBusinessOrderLoadType.getBusinessOrderLoadType4ID(iTag2.getIntVal()));
                            break;
                        case (byte) 13:
                            businessOrder.setPayChannel(iTag2.getIntVal());
                            break;
                        case (byte) 14:
                            businessOrder.setCardAppType(EnumCardAppType.instance(iTag2.getIntVal()));
                            break;
                        case (byte) 15:
                            businessOrder.setCardNo(FM_Bytes.hexStringToBytes(iTag2.getStringVal()));
                            break;
                        case (byte) 16:
                            businessOrder.setAmount(FM_Bytes.bytesToInt(iTag2.getBytesVal()));
                            break;
                        case (byte) 17:
                            businessOrder.setOrder(iTag2.getBytesVal());
                            break;
                        case (byte) 19:
                            businessOrder.setTradeDate(iTag2.getStringVal());
                            break;
                        case (byte) 20:
                            businessOrder.setTradeTime(iTag2.getStringVal());
                            break;
                        case (byte) 21:
                            businessOrder.setTradeState(EnumOrderStatus.getOrderStatus4ID(iTag2.getIntVal()));
                            break;
                        case (byte) 22:
                            businessOrder.setSerialNo(FM_Bytes.bytesToInt(iTag2.getBytesVal()));
                            break;
                        case (byte) 23:
                            businessOrder.setTerminalNo(FM_Bytes.hexStringToBytes(iTag2.getStringVal()));
                            break;
                        case (byte) 24:
                            businessOrder.setInvoiceStatus(iTag2.getIntVal());
                            break;
                        case (byte) 47:
                            businessOrder.setCardIoType(EnumCardIoType.getCardIoType(iTag2.getIntVal()));
                            break;
                        case (byte) 72:
                            businessOrder.setBusinessOrderType(EnumBusinessOrderType.instance(iTag2.getIntVal()));
                            break;
                        case (byte) 103:
                            businessOrder.setProduct(iTag2.getStringVal());
                            break;
                        case (byte) 104:
                            businessOrder.setDeviceModel(iTag2.getStringVal());
                            break;
                        case (byte) 105:
                            businessOrder.setMainOrder(iTag2.getBytesVal());
                            break;
                        default:
                            break;
                    }
                }
            } else if (log != null) {
                log.warn(BusinessOrder.class.getName(), FM_Long.copyValueOf("Nvs甎戞丑助讧南斩ｐ\r74嬀頴买稽", 274));
            }
        } else if (log != null) {
            log.warn(BusinessOrder.class.getName(), BCCUtil.getChars("Hz=畆戈不勷请十日～\u0005qh宷谬丶穱", 172, 31));
        }
        return businessOrder;
    }

    public int getAmount() {
        return this.f9539d;
    }

    public EnumBusinessOrderLoadType getBusinessOrderLoadType() {
        return this.f9554s;
    }

    public EnumBusinessOrderType getBusinessOrderType() {
        return this.f9549n;
    }

    public EnumCardAppType getCardAppType() {
        return this.f9548m;
    }

    public EnumCardIoType getCardIoType() {
        return this.f9547l;
    }

    public byte[] getCardNo() {
        return this.f9542g;
    }

    public String getDeviceModel() {
        return this.f9552q;
    }

    public int getInvoiceStatus() {
        return this.f9545j;
    }

    public byte[] getMainOrder() {
        return this.f9553r;
    }

    public byte[] getOrder() {
        return this.f9538c;
    }

    public int getPayChannel() {
        return this.f9546k;
    }

    public String getProduct() {
        return this.f9550o;
    }

    public byte[] getSeid() {
        return this.f9551p;
    }

    public int getSerialNo() {
        return this.f9541f;
    }

    public String getTac() {
        return this.f9544i;
    }

    public byte[] getTerminalNo() {
        return this.f9543h;
    }

    public String getTradeDate() {
        return this.f9536a;
    }

    public EnumOrderStatus getTradeState() {
        return this.f9540e;
    }

    public String getTradeTime() {
        return this.f9537b;
    }

    public void setAmount(int i) {
        this.f9539d = i;
    }

    public void setBusinessOrderLoadType(EnumBusinessOrderLoadType enumBusinessOrderLoadType) {
        this.f9554s = enumBusinessOrderLoadType;
    }

    public void setBusinessOrderType(EnumBusinessOrderType enumBusinessOrderType) {
        this.f9549n = enumBusinessOrderType;
    }

    public void setCardAppType(EnumCardAppType enumCardAppType) {
        this.f9548m = enumCardAppType;
    }

    public void setCardIoType(EnumCardIoType enumCardIoType) {
        this.f9547l = enumCardIoType;
    }

    public void setCardNo(byte[] bArr) {
        this.f9542g = bArr;
    }

    public void setDeviceModel(String str) {
        this.f9552q = str;
    }

    public void setInvoiceStatus(int i) {
        this.f9545j = i;
    }

    public void setMainOrder(byte[] bArr) {
        this.f9553r = bArr;
    }

    public void setOrder(byte[] bArr) {
        this.f9538c = bArr;
    }

    public void setPayChannel(int i) {
        this.f9546k = i;
    }

    public void setProduct(String str) {
        this.f9550o = str;
    }

    public void setSeid(byte[] bArr) {
        this.f9551p = bArr;
    }

    public void setSerialNo(int i) {
        this.f9541f = i;
    }

    public void setTac(String str) {
        this.f9544i = str;
    }

    public void setTerminalNo(byte[] bArr) {
        this.f9543h = bArr;
    }

    public void setTradeDate(String str) {
        this.f9536a = str;
    }

    public void setTradeState(EnumOrderStatus enumOrderStatus) {
        this.f9540e = enumOrderStatus;
    }

    public void setTradeTime(String str) {
        this.f9537b = str;
    }
}
