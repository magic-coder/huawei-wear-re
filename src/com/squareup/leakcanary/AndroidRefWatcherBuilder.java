package com.squareup.leakcanary;

import android.app.Application;
import android.content.Context;
import com.squareup.leakcanary.HeapDump.Listener;
import java.util.concurrent.TimeUnit;

public final class AndroidRefWatcherBuilder extends RefWatcherBuilder<AndroidRefWatcherBuilder> {
    private static final long DEFAULT_WATCH_DELAY_MILLIS = TimeUnit.SECONDS.toMillis(5);
    private final Context context;

    AndroidRefWatcherBuilder(Context context) {
        this.context = context.getApplicationContext();
    }

    public AndroidRefWatcherBuilder listenerServiceClass(Class<? extends AbstractAnalysisResultService> cls) {
        return (AndroidRefWatcherBuilder) heapDumpListener(new ServiceHeapDumpListener(this.context, cls));
    }

    public AndroidRefWatcherBuilder watchDelay(long j, TimeUnit timeUnit) {
        return (AndroidRefWatcherBuilder) watchExecutor(new AndroidWatchExecutor(timeUnit.toMillis(j)));
    }

    public AndroidRefWatcherBuilder maxStoredHeapDumps(int i) {
        LeakDirectoryProvider defaultLeakDirectoryProvider = new DefaultLeakDirectoryProvider(this.context, i);
        LeakCanary.setDisplayLeakActivityDirectoryProvider(defaultLeakDirectoryProvider);
        return (AndroidRefWatcherBuilder) heapDumper(new AndroidHeapDumper(this.context, defaultLeakDirectoryProvider));
    }

    public RefWatcher buildAndInstall() {
        RefWatcher build = build();
        if (build != RefWatcher.DISABLED) {
            LeakCanary.enableDisplayLeakActivity(this.context);
            ActivityRefWatcher.install((Application) this.context, build);
        }
        return build;
    }

    protected boolean isDisabled() {
        return LeakCanary.isInAnalyzerProcess(this.context);
    }

    protected HeapDumper defaultHeapDumper() {
        return new AndroidHeapDumper(this.context, new DefaultLeakDirectoryProvider(this.context));
    }

    protected DebuggerControl defaultDebuggerControl() {
        return new AndroidDebuggerControl();
    }

    protected Listener defaultHeapDumpListener() {
        return new ServiceHeapDumpListener(this.context, DisplayLeakService.class);
    }

    protected ExcludedRefs defaultExcludedRefs() {
        return AndroidExcludedRefs.createAppDefaults().build();
    }

    protected WatchExecutor defaultWatchExecutor() {
        return new AndroidWatchExecutor(DEFAULT_WATCH_DELAY_MILLIS);
    }
}
