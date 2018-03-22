package com.squareup.leakcanary;

import com.squareup.leakcanary.HeapDump.Listener;

public class RefWatcherBuilder<T extends RefWatcherBuilder<T>> {
    private DebuggerControl debuggerControl;
    private ExcludedRefs excludedRefs;
    private GcTrigger gcTrigger;
    private Listener heapDumpListener;
    private HeapDumper heapDumper;
    private WatchExecutor watchExecutor;

    public final T heapDumpListener(Listener listener) {
        this.heapDumpListener = listener;
        return self();
    }

    public final T excludedRefs(ExcludedRefs excludedRefs) {
        this.excludedRefs = excludedRefs;
        return self();
    }

    public final T heapDumper(HeapDumper heapDumper) {
        this.heapDumper = heapDumper;
        return self();
    }

    public final T debuggerControl(DebuggerControl debuggerControl) {
        this.debuggerControl = debuggerControl;
        return self();
    }

    public final T watchExecutor(WatchExecutor watchExecutor) {
        this.watchExecutor = watchExecutor;
        return self();
    }

    public final T gcTrigger(GcTrigger gcTrigger) {
        this.gcTrigger = gcTrigger;
        return self();
    }

    public final RefWatcher build() {
        if (isDisabled()) {
            return RefWatcher.DISABLED;
        }
        ExcludedRefs excludedRefs = this.excludedRefs;
        if (excludedRefs == null) {
            excludedRefs = defaultExcludedRefs();
        }
        Listener listener = this.heapDumpListener;
        if (listener == null) {
            listener = defaultHeapDumpListener();
        }
        DebuggerControl debuggerControl = this.debuggerControl;
        if (debuggerControl == null) {
            debuggerControl = defaultDebuggerControl();
        }
        HeapDumper heapDumper = this.heapDumper;
        if (heapDumper == null) {
            heapDumper = defaultHeapDumper();
        }
        WatchExecutor watchExecutor = this.watchExecutor;
        if (watchExecutor == null) {
            watchExecutor = defaultWatchExecutor();
        }
        GcTrigger gcTrigger = this.gcTrigger;
        if (gcTrigger == null) {
            gcTrigger = defaultGcTrigger();
        }
        return new RefWatcher(watchExecutor, debuggerControl, gcTrigger, heapDumper, listener, excludedRefs);
    }

    protected boolean isDisabled() {
        return false;
    }

    protected GcTrigger defaultGcTrigger() {
        return GcTrigger.DEFAULT;
    }

    protected DebuggerControl defaultDebuggerControl() {
        return DebuggerControl.NONE;
    }

    protected ExcludedRefs defaultExcludedRefs() {
        return ExcludedRefs.builder().build();
    }

    protected HeapDumper defaultHeapDumper() {
        return HeapDumper.NONE;
    }

    protected Listener defaultHeapDumpListener() {
        return Listener.NONE;
    }

    protected WatchExecutor defaultWatchExecutor() {
        return WatchExecutor.NONE;
    }

    protected final T self() {
        return this;
    }
}
