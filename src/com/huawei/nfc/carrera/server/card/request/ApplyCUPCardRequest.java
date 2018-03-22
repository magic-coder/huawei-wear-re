package com.huawei.nfc.carrera.server.card.request;

import com.huawei.nfc.carrera.server.card.model.CipheredCardInfo;
import com.huawei.nfc.carrera.server.card.model.RiskInfo;

public class ApplyCUPCardRequest extends CardServerBaseRequest {
    private CipheredCardInfo cardInfor;
    private String cplc;
    private RiskInfo riskInfo;
    private String tncStatus = "ACCEPTED";

    public interface ApplyCUPCardRequestSai10 {
    }

    public interface ApplyCUPCardRequestSai1 {
    }

    public interface ApplyCUPCardRequestSai2 {
    }

    public interface ApplyCUPCardRequestSai3 {
    }

    public interface ApplyCUPCardRequestSai4 {
    }

    public interface ApplyCUPCardRequestSai5 {
    }

    public interface ApplyCUPCardRequestSai6 {
    }

    public interface ApplyCUPCardRequestSai7 {
    }

    public interface ApplyCUPCardRequestSai8 {
    }

    public interface ApplyCUPCardRequestSai9 {
    }

    public ApplyCUPCardRequest(RiskInfo riskInfo) {
        this.riskInfo = riskInfo;
    }

    public String getCplc() {
        return this.cplc;
    }

    public CipheredCardInfo getCardInfor() {
        return this.cardInfor;
    }

    public String getTncStatus() {
        return this.tncStatus;
    }

    public RiskInfo getRiskInfo() {
        return this.riskInfo;
    }

    public void setCplc(String str) {
        this.cplc = str;
    }

    public void setCardInfor(CipheredCardInfo cipheredCardInfo) {
        this.cardInfor = cipheredCardInfo;
    }

    public void setTncStatus(String str) {
        this.tncStatus = str;
    }

    public void setRiskInfo(RiskInfo riskInfo) {
        this.riskInfo = riskInfo;
    }
}
