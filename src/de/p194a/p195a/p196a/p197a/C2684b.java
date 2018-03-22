package de.p194a.p195a.p196a.p197a;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.helpers.LogLog;

/* compiled from: LogConfigurator */
public class C2684b {
    private Level f9095a = Level.DEBUG;
    private String f9096b = "%d - [%p::%c::%C] - %m%n";
    private String f9097c = "%m%n";
    private String f9098d = "android-log4j.log";
    private int f9099e = 5;
    private long f9100f = 524288;
    private boolean f9101g = true;
    private boolean f9102h = true;
    private boolean f9103i = true;
    private boolean f9104j = true;
    private boolean f9105k = false;

    public void m12809a() {
        Logger rootLogger = Logger.getRootLogger();
        if (m12826k()) {
            LogManager.getLoggerRepository().resetConfiguration();
        }
        LogLog.setInternalDebugging(m12827l());
        if (m12824i()) {
            m12807m();
        }
        if (m12825j()) {
            m12808n();
        }
        rootLogger.setLevel(m12815b());
    }

    public void m12812a(String str, Level level) {
        Logger.getLogger(str).setLevel(level);
    }

    private void m12807m() {
        Logger rootLogger = Logger.getRootLogger();
        try {
            Appender rollingFileAppender = new RollingFileAppender(new PatternLayout(m12818c()), m12820e());
            rollingFileAppender.setMaxBackupIndex(m12821f());
            rollingFileAppender.setMaximumFileSize(m12822g());
            rollingFileAppender.setImmediateFlush(m12823h());
            rootLogger.addAppender(rollingFileAppender);
        } catch (Throwable e) {
            throw new RuntimeException("Exception configuring log system", e);
        }
    }

    private void m12808n() {
        Logger.getRootLogger().addAppender(new C2683a(new PatternLayout(m12819d())));
    }

    public Level m12815b() {
        return this.f9095a;
    }

    public void m12813a(Level level) {
        this.f9095a = level;
    }

    public String m12818c() {
        return this.f9096b;
    }

    public void m12811a(String str) {
        this.f9096b = str;
    }

    public String m12819d() {
        return this.f9097c;
    }

    public String m12820e() {
        return this.f9098d;
    }

    public void m12816b(String str) {
        this.f9098d = str;
    }

    public int m12821f() {
        return this.f9099e;
    }

    public long m12822g() {
        return this.f9100f;
    }

    public void m12810a(long j) {
        this.f9100f = j;
    }

    public boolean m12823h() {
        return this.f9101g;
    }

    public void m12814a(boolean z) {
        this.f9101g = z;
    }

    public boolean m12824i() {
        return this.f9103i;
    }

    public void m12817b(boolean z) {
        this.f9103i = z;
    }

    public boolean m12825j() {
        return this.f9102h;
    }

    public boolean m12826k() {
        return this.f9104j;
    }

    public boolean m12827l() {
        return this.f9105k;
    }
}
