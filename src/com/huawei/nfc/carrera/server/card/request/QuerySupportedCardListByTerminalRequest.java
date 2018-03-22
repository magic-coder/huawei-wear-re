package com.huawei.nfc.carrera.server.card.request;

public class QuerySupportedCardListByTerminalRequest extends CardServerBaseRequest {
    private String romVersion;
    private String terminal;
    private long timeStamp;
    private String walletVersion;

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public String getTerminal() {
        return this.terminal;
    }

    public void setTerminal(String str) {
        this.terminal = str;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public void setRomVersion(String str) {
        this.romVersion = str;
    }

    public String getWalletVersion() {
        return this.walletVersion;
    }

    public void setWalletVersion(String str) {
        this.walletVersion = str;
    }
}
