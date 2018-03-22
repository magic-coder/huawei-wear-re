package cn.com.fmsh.nfcos.client.libs.log;

import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.Level;
import com.huawei.hwid.core.constants.HwAccountConstants;

public class FMLog4Windows implements FMLog {
    private Level level = Level.DEBUG;
    private boolean showLogFlag;

    public void debug(String str, String str2) {
        if (this.level.getId() <= Level.DEBUG.getId()) {
            System.out.println(new StringBuilder(String.valueOf(str)).append(HwAccountConstants.BLANK).append(str2).toString());
        }
    }

    public void error(String str, String str2) {
        if (this.level.getId() <= Level.ERROR.getId()) {
            System.out.println(new StringBuilder(String.valueOf(str)).append(HwAccountConstants.BLANK).append(str2).toString());
        }
    }

    public boolean getShowLogFlag() {
        return this.showLogFlag;
    }

    public void info(String str, String str2) {
        if (this.level.getId() <= Level.INFO.getId()) {
            System.out.println(new StringBuilder(String.valueOf(str)).append(HwAccountConstants.BLANK).append(str2).toString());
        }
    }

    public void setShowLogFlag(boolean z) {
        this.showLogFlag = z;
    }

    public void warn(String str, String str2) {
        if (this.level.getId() <= Level.WARNING.getId()) {
            System.out.println(new StringBuilder(String.valueOf(str)).append(HwAccountConstants.BLANK).append(str2).toString());
        }
    }

    public Level getShowLogLevel() {
        return this.level;
    }

    public void setShowLogLevel(Level level) {
        this.level = level;
    }
}
