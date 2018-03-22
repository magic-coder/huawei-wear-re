package cn.com.fmsh.script.exception;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;

public class FMScriptHandleException extends FM_Exception {
    private static final /* synthetic */ long serialVersionUID = 1872758501585762351L;
    private /* synthetic */ ScriptHandleExceptionType f9521a;

    public enum ScriptHandleExceptionType {
        STOPED((byte) 1, FM_Long.copyValueOf("彘剅擈佞裴倀欻", 3)),
        INVALID_FIRST_ID((byte) 2, BCCUtil.getChars("笢专朹捚仦斧攄", 286, 37)),
        INVALID_NEXT((byte) 3, FM_Int.replace(6, "乐朿挆仠庈叽太亞彀剛庖叫")),
        OPENMOBILE_TRANSMIT_EXCEPTION((byte) 4, FM_CN.equals("<4ph7e6(2 x.亻亂弃幪", 96)),
        UNKNOW((byte) -1, BCCUtil.getChars("杹矾镚认", 3, 40));

        public String getDescription() {
            return this.f9520b;
        }

        public int getValue() {
            return this.f9519a;
        }
    }

    public FMScriptHandleException(String str) {
        super(str);
    }

    public ScriptHandleExceptionType getType() {
        return this.f9521a;
    }

    public void setType(ScriptHandleExceptionType scriptHandleExceptionType) {
        this.f9521a = scriptHandleExceptionType;
    }
}
