package cn.com.fmsh.tsm.business.enums;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import org.apache.log4j.net.SyslogAppender;

public enum EnumIssueProcess {
    APPLIED(0, FM_Exception.insert(6, 12, "敺捸巰甽语")),
    SSD_KEY_UPDATED(10, FM_Utils.regionMatches(5, 59, "\u0006C\u000f寀铤差暣斢")),
    APP_LOAD(20, CRCUtil.substring(4, "庅甴巵劲轠")),
    APP_INSTALL(30, FM_Long.copyValueOf("廞畯嶶寈袛", 98)),
    APP_PERSONAL(40, Util4Java.endsWith("废畱嶵乿仹匇", 142, 110)),
    APP_ACTIVATION(50, BCCUtil.getChars("廇畣嶱澛浨", 3, 120)),
    APP_LOCK(60, FM_Utils.regionMatches(294, 58, "庂畸巸镅寄")),
    APP_REMOVE(70, FM_Exception.insert(SyslogAppender.LOG_LOCAL7, 24, "庈畼嶾判陸"));

    public static EnumIssueProcess instance(int i) {
        for (EnumIssueProcess enumIssueProcess : values()) {
            if (enumIssueProcess.getId() == i) {
                return enumIssueProcess;
            }
        }
        return null;
    }

    public String getDesc() {
        return this.f9813b;
    }

    public int getId() {
        return this.f9812a;
    }
}
