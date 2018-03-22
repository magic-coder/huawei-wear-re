package cn.com.fmsh.tsm.business.core;

import cn.com.fmsh.communication.CommunicationNotify;
import cn.com.fmsh.communication.core.LinkInfo;
import cn.com.fmsh.script.ApduHandler;
import cn.com.fmsh.tsm.business.BusinessExtend;
import cn.com.fmsh.tsm.business.BusinessManager;
import cn.com.fmsh.tsm.business.CardAppInstall;
import cn.com.fmsh.tsm.business.CardAppTrade;
import cn.com.fmsh.tsm.business.LocalDataHandler;
import cn.com.fmsh.tsm.business.SocketExceptionHandler;

public class BusinessManagerImpl implements BusinessManager {
    private /* synthetic */ CardAppInstallImpl f9719a = new CardAppInstallImpl(this.f9722d);
    private /* synthetic */ CardAppTradeImpl f9720b = new CardAppTradeImpl(this.f9722d);
    private /* synthetic */ BusinessExtend f9721c = new BusinessExtendImpl(this.f9722d);
    private /* synthetic */ CardBusinessBasic f9722d = new CardBusinessBasic();

    public BusinessExtend getBusinessExtend() {
        return this.f9721c;
    }

    public CardAppInstall getCardAppInstall() {
        return this.f9719a;
    }

    public CardAppTrade getCardAppTrade() {
        return this.f9720b;
    }

    public CardBusinessBasic getCardBusinessBasic() {
        return this.f9722d;
    }

    public ErrorCodeHandler getErrorCodeHandler() {
        return this.f9722d.getErrorCodeHandler();
    }

    public void registerCommunicationNotify(CommunicationNotify communicationNotify) {
        this.f9722d.registerCommunicationNotify(communicationNotify);
    }

    public void registerLocalDataHandler(LocalDataHandler localDataHandler) {
        this.f9722d.registerLocalDataHandler(localDataHandler);
    }

    public void setApduHandler(ApduHandler apduHandler) {
        this.f9722d.setApduHandler(apduHandler);
    }

    public void setLinkInfo(LinkInfo linkInfo) {
        this.f9722d.setLinkInfo(linkInfo);
    }

    public void setMobileInfo(byte[] bArr) {
        this.f9722d.setMobileInfo(bArr);
    }

    public boolean setSecurityCode(byte[] bArr) {
        if (bArr == null || bArr.length < 1 || bArr[0] != bArr.length - 1) {
            return false;
        }
        this.f9722d.setSecurityCode(bArr);
        return true;
    }

    public void setSocketExceptionHandle(SocketExceptionHandler socketExceptionHandler) {
        this.f9722d.setSocketExceptionHandle(socketExceptionHandler);
    }

    public boolean setTerminalNumber(byte[] bArr) {
        if (bArr == null || bArr.length != 32) {
            return false;
        }
        this.f9722d.setTerminalNumber(bArr);
        return true;
    }
}
