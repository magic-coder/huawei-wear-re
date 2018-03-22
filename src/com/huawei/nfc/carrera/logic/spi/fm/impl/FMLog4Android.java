package com.huawei.nfc.carrera.logic.spi.fm.impl;

import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.Level;
import com.huawei.p190v.C2538c;

public class FMLog4Android implements FMLog {
    private final String TAG = "FMServiceImpl";
    private Level level = Level.DEBUG;
    private boolean showLogFlag;

    public void debug(String str, String str2) {
        if (this.level.getId() <= Level.DEBUG.getId()) {
            C2538c.b("FMServiceImpl", new Object[]{str, str2});
        }
    }

    public void error(String str, String str2) {
        if (this.level.getId() <= Level.ERROR.getId()) {
            C2538c.e("FMServiceImpl", new Object[]{str, str2});
        }
    }

    public boolean getShowLogFlag() {
        return this.showLogFlag;
    }

    public void info(String str, String str2) {
        if (this.level.getId() <= Level.INFO.getId()) {
            C2538c.c("FMServiceImpl", new Object[]{str, str2});
        }
    }

    public void setShowLogFlag(boolean z) {
        this.showLogFlag = z;
    }

    public void warn(String str, String str2) {
        if (this.level.getId() <= Level.WARNING.getId()) {
            C2538c.d("FMServiceImpl", new Object[]{str, str2});
        }
    }

    public Level getShowLogLevel() {
        return this.level;
    }

    public void setShowLogLevel(Level level) {
        this.level = level;
    }
}
