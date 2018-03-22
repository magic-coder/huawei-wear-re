package com.huawei.nfc.carrera.logic.spi.tsm.request;

public class CommandRequest {
    public String cplc;
    public String funcallID;
    public String serverID;

    public static CommandRequest build(String str, String str2, String str3) {
        CommandRequest commandRequest = new CommandRequest();
        commandRequest.cplc = str;
        commandRequest.funcallID = str2;
        commandRequest.serverID = str3;
        return commandRequest;
    }

    public String toString() {
        return "CommandRequest{cplc='" + this.cplc + '\'' + ", funcallID='" + this.funcallID + '\'' + ", serverID='" + this.serverID + '\'' + '}';
    }
}
