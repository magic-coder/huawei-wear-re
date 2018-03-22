package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.tsm.business.enums.EnumBusinessOrderLoadType;
import cn.com.fmsh.tsm.business.enums.EnumOrderStatus;
import cn.com.fmsh.util.FM_Bytes;
import java.util.ArrayList;
import java.util.List;

public class MainOrder {
    private /* synthetic */ EnumOrderStatus f9613a;
    private /* synthetic */ byte[] f9614b;
    private /* synthetic */ String f9615c;
    private /* synthetic */ String f9616d;
    private /* synthetic */ int f9617e;
    private /* synthetic */ EnumBusinessOrderLoadType f9618f;
    private /* synthetic */ List<BusinessOrder> f9619g = new ArrayList();
    private /* synthetic */ List<PayOrder> f9620h = new ArrayList();

    public static MainOrder fromTag(ITag iTag) throws FMCommunicationMessageException {
        MainOrder mainOrder = null;
        if (iTag != null) {
            ITag[] itemTags = iTag.getItemTags();
            if (itemTags != null && itemTags.length >= 1) {
                mainOrder = new MainOrder();
                for (ITag iTag2 : itemTags) {
                    ITag[] itemTags2;
                    switch (iTag2.getId()) {
                        case (byte) -55:
                            mainOrder.setBusinessOrderLoadType(EnumBusinessOrderLoadType.getBusinessOrderLoadType4ID(iTag2.getIntVal()));
                            break;
                        case (byte) 16:
                            mainOrder.setAmount(FM_Bytes.bytesToInt(iTag2.getBytesVal()));
                            break;
                        case (byte) 19:
                            mainOrder.setDate(iTag2.getStringVal());
                            break;
                        case (byte) 20:
                            mainOrder.setTime(iTag2.getStringVal());
                            break;
                        case (byte) 21:
                            mainOrder.setState(EnumOrderStatus.getOrderStatus4ID(iTag2.getIntVal()));
                            break;
                        case (byte) 27:
                            itemTags2 = iTag2.getItemTags();
                            if (itemTags2 != null && itemTags2.length > 0) {
                                for (ITag fromTag : itemTags2) {
                                    BusinessOrder fromTag2 = BusinessOrder.fromTag(fromTag);
                                    if (fromTag2 != null) {
                                        mainOrder.addBusinessOrders(fromTag2);
                                    }
                                }
                                break;
                            }
                        case (byte) 100:
                            itemTags2 = iTag2.getItemTags();
                            if (itemTags2 != null && itemTags2.length > 0) {
                                for (ITag fromTag3 : itemTags2) {
                                    PayOrder fromTag4 = PayOrder.fromTag(fromTag3);
                                    if (fromTag4 != null) {
                                        mainOrder.addPayOrders(fromTag4);
                                    }
                                }
                                break;
                            }
                        case (byte) 105:
                            mainOrder.setId(iTag2.getBytesVal());
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return mainOrder;
    }

    public void addBusinessOrders(BusinessOrder businessOrder) {
        if (businessOrder != null) {
            this.f9619g.add(businessOrder);
        }
    }

    public void addPayOrders(PayOrder payOrder) {
        if (payOrder != null) {
            this.f9620h.add(payOrder);
        }
    }

    public int getAmount() {
        return this.f9617e;
    }

    public EnumBusinessOrderLoadType getBusinessOrderLoadType() {
        return this.f9618f;
    }

    public BusinessOrder[] getBusinessOrders() {
        return (BusinessOrder[]) this.f9619g.toArray(new BusinessOrder[0]);
    }

    public String getDate() {
        return this.f9615c;
    }

    public byte[] getId() {
        return this.f9614b;
    }

    public PayOrder[] getPayOrders() {
        return (PayOrder[]) this.f9620h.toArray(new PayOrder[0]);
    }

    public EnumOrderStatus getState() {
        return this.f9613a;
    }

    public String getTime() {
        return this.f9616d;
    }

    public void setAmount(int i) {
        this.f9617e = i;
    }

    public void setBusinessOrderLoadType(EnumBusinessOrderLoadType enumBusinessOrderLoadType) {
        this.f9618f = enumBusinessOrderLoadType;
    }

    public void setDate(String str) {
        this.f9615c = str;
    }

    public void setId(byte[] bArr) {
        this.f9614b = bArr;
    }

    public void setState(EnumOrderStatus enumOrderStatus) {
        this.f9613a = enumOrderStatus;
    }

    public void setTime(String str) {
        this.f9616d = str;
    }
}
