package com.snowballtech.apdu.smartdevice_oma.fundation;

import com.snowballtech.apdu.constant.Constant;
import com.snowballtech.apdu.internal.INfcChannel;

public class NfcObject {
    private int channelType;
    private String instance_id;
    private int mediaType;
    private INfcChannel nfcChannel;
    private byte[] response;

    public byte[] getResponse() {
        return this.response;
    }

    public void setResponse(byte[] bArr) {
        this.response = bArr;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public void setChannelType(int i) {
        this.channelType = i;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public void setMediaType(int i) {
        this.mediaType = i;
    }

    public INfcChannel getNfcChannel() {
        return this.nfcChannel;
    }

    public void setNfcChannel(INfcChannel iNfcChannel) {
        this.nfcChannel = iNfcChannel;
    }

    public String getInstance_id() {
        return this.instance_id;
    }

    public void setInstance_id(String str) {
        this.instance_id = str;
    }

    public String toString() {
        String str = "aid:%s,channelType=%s,mediaType=%s";
        Object[] objArr = new Object[3];
        objArr[0] = this.instance_id;
        objArr[1] = this.channelType == 0 ? " basicChannel" : "logicChannel";
        String str2 = this.mediaType == 0 ? "ese" : this.mediaType == 2 ? "UICC" : Constant._SD_TERMINAL;
        objArr[2] = str2;
        return String.format(str, objArr);
    }
}
