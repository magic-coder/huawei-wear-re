package cn.com.fmsh.script;

import cn.com.fmsh.script.exception.FMScriptHandleException;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.Util4Java;

public interface ApduHandler {

    public enum ApduHandlerType {
        OPEN_MOBILE(1, FM_Int.replace(5, "5-emKfnf~p")),
        NFC(2, FM_Int.replace(2, "\u0019\u001c\u001e")),
        FM8301(3, Util4Java.endsWith("94k~wp", 2, 122)),
        BLUETOOTH(4, FM_Int.replace(5, "81ufRfc{z"));

        public String getDescription() {
            return this.f9491b;
        }

        public int getValue() {
            return this.f9490a;
        }
    }

    void close();

    boolean connect();

    ApduHandlerType getApduHandlerType();

    boolean isConnect();

    boolean open(byte[] bArr);

    byte[] transceive(byte[] bArr) throws FMScriptHandleException;
}
