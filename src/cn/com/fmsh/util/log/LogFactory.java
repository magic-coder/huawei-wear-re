package cn.com.fmsh.util.log;

public class LogFactory {
    private static /* synthetic */ LogFactory f9862a;
    private /* synthetic */ FMLog f9863b = null;

    private /* synthetic */ LogFactory() {
    }

    public static LogFactory getInstance() {
        if (f9862a == null) {
            f9862a = new LogFactory();
        }
        return f9862a;
    }

    public FMLog getLog() {
        return this.f9863b;
    }

    public void setLog(FMLog fMLog) {
        this.f9863b = fMLog;
    }
}
