package cn.com.fmsh.communication.log;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.Level;
import com.huawei.hwid.core.constants.HwAccountConstants;

public class SystemPrintlnLog implements FMLog {
    private /* synthetic */ boolean f9428a;
    private /* synthetic */ Level f9429b = Level.DEBUG;

    public void debug(String str, String str2) {
        if (this.f9429b.getId() <= Level.DEBUG.getId()) {
            System.out.println(new StringBuilder(FM_Long.copyValueOf("HLDVGpw", 4)).append(str).append(HwAccountConstants.BLANK).append(str2).toString());
        }
    }

    public void error(String str, String str2) {
        if (this.f9429b.getId() <= Level.ERROR.getId()) {
            System.out.println(new StringBuilder(FM_Exception.insert(5, 14, "LEW\\\u0013bp")).append(str).append(HwAccountConstants.BLANK).append(str2).toString());
        }
    }

    public boolean getShowLogFlag() {
        return this.f9428a;
    }

    public Level getShowLogLevel() {
        return this.f9429b;
    }

    public void info(String str, String str2) {
        if (this.f9429b.getId() <= Level.INFO.getId()) {
            System.out.println(new StringBuilder(FM_Bytes.concat("\u0015X\u0016Ei3", 5, 58)).append(str).append(HwAccountConstants.BLANK).append(str2).toString());
        }
    }

    public void setShowLogFlag(boolean z) {
        this.f9428a = z;
    }

    public void setShowLogLevel(Level level) {
        this.f9429b = level;
    }

    public void warn(String str, String str2) {
        if (this.f9429b.getId() <= Level.WARNING.getId()) {
            System.out.println(new StringBuilder(Util4Java.endsWith("\b\u0005[\u0000>u", 2, 69)).append(str).append(HwAccountConstants.BLANK).append(str2).toString());
        }
    }
}
