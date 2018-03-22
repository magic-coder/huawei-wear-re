package com.huawei.pluginkidwatch.common.entity.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class GetVoiceModel extends BaseEntityModel implements Externalizable {
    private static final long serialVersionUID = 9077384547756030938L;
    public VoiceContent chatMessage = new VoiceContent();
    public int deviceCode = 0;

    public String toString() {
        return "GetVoiceModel{deviceCode=" + this.deviceCode + ", chatMessage=" + this.chatMessage.toString() + '}';
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
    }
}
