package cn.com.fmsh.communication.log;

import android.util.Log;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.Level;

public class CommunicationLog implements FMLog {
    private /* synthetic */ Level f9427a;
    public boolean showLogFlag = true;

    public void debug(String str, String str2) {
        Log.d(str, str2);
    }

    public void error(String str, String str2) {
        Log.e(str, str2);
    }

    public boolean getShowLogFlag() {
        return this.showLogFlag;
    }

    public Level getShowLogLevel() {
        return this.f9427a;
    }

    public void info(String str, String str2) {
        Log.i(str, str2);
    }

    public void setShowLogFlag(boolean z) {
        this.showLogFlag = z;
    }

    public void setShowLogLevel(Level level) {
        this.f9427a = level;
    }

    public void warn(String str, String str2) {
        Log.w(str, str2);
    }
}
