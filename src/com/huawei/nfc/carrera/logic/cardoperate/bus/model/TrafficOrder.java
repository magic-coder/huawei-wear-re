package com.huawei.nfc.carrera.logic.cardoperate.bus.model;

import cn.com.fmsh.nfcos.client.service.huawei.NfcosBusinessOrder;
import cn.com.fmsh.nfcos.client.service.huawei.NfcosMainOrder;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.ApplyOrder;
import com.huawei.nfc.carrera.logic.spi.serveraccess.model.QueryOrder;
import com.huawei.nfc.carrera.logic.wxpay.WXPayInfo;
import com.huawei.nfc.util.GodClassUtil;
import java.util.List;

public class TrafficOrder {
    private List<ApplyOrder> applyOrders;
    private boolean hasUnusedIssueOrder;
    private boolean isDuplicateApply;
    private boolean isNewPayVersion = false;
    private NfcosBusinessOrder nfcosBusinessOrder;
    private NfcosMainOrder nfcosMainOrder;
    private PayInfo payInfo = null;
    private int payType;
    private String phoneNum;
    private List<QueryOrder> queryOrders;
    private String spId;
    private WXPayInfo wxPayInfo;

    public NfcosMainOrder getNfcosMainOrder() {
        return this.nfcosMainOrder;
    }

    public void setNfcosMainOrder(NfcosMainOrder nfcosMainOrder) {
        this.nfcosMainOrder = nfcosMainOrder;
    }

    public NfcosBusinessOrder getNfcosBusinessOrder() {
        return this.nfcosBusinessOrder;
    }

    public void setNfcosBusinessOrder(NfcosBusinessOrder nfcosBusinessOrder) {
        this.nfcosBusinessOrder = nfcosBusinessOrder;
    }

    public PayInfo getPayInfo() {
        return (PayInfo) GodClassUtil.commonFunc(this.payInfo);
    }

    public void setPayInfo(PayInfo payInfo) {
        this.payInfo = payInfo;
    }

    public int getPayType() {
        return this.payType;
    }

    public void setPayType(int i) {
        this.payType = i;
    }

    public WXPayInfo getWxPayInfo() {
        return this.wxPayInfo;
    }

    public void setWXPayInfo(WXPayInfo wXPayInfo) {
        this.wxPayInfo = wXPayInfo;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String str) {
        this.phoneNum = str;
    }

    public boolean getHasUnusedIssueOrder() {
        return this.hasUnusedIssueOrder;
    }

    public void setHasUnusedIssueOrder(boolean z) {
        this.hasUnusedIssueOrder = z;
    }

    public String getSpId() {
        return this.spId;
    }

    public void setSpId(String str) {
        this.spId = str;
    }

    public boolean isDuplicateApply() {
        return this.isDuplicateApply;
    }

    public void setDuplicateApply(boolean z) {
        this.isDuplicateApply = z;
    }

    public List<ApplyOrder> getApplyOrders() {
        return this.applyOrders;
    }

    public void setApplyOrders(List<ApplyOrder> list) {
        this.applyOrders = list;
    }

    public List<QueryOrder> getQueryOrders() {
        return this.queryOrders;
    }

    public void setQueryOrders(List<QueryOrder> list) {
        this.queryOrders = list;
    }

    public boolean isNewPayVersion() {
        return this.isNewPayVersion;
    }

    public void setNewPayVersion(boolean z) {
        this.isNewPayVersion = z;
    }

    public NfcosBusinessOrder getNfcosOrder(int i) {
        if (this.nfcosMainOrder != null && this.nfcosMainOrder.businessOrders != null) {
            for (NfcosBusinessOrder nfcosBusinessOrder : this.nfcosMainOrder.businessOrders) {
                if (nfcosBusinessOrder.businessOrderType == i) {
                    break;
                }
            }
            NfcosBusinessOrder nfcosBusinessOrder2 = null;
            return nfcosBusinessOrder2;
        } else if (this.nfcosBusinessOrder == null || this.nfcosBusinessOrder.businessOrderType != i) {
            return null;
        } else {
            return this.nfcosBusinessOrder;
        }
    }
}
