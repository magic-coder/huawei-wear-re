package com.squareup.leakcanary;

import com.squareup.leakcanary.HeapDump.Listener;
import com.squareup.leakcanary.Retryable.Result;
import java.io.File;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

public final class RefWatcher {
    public static final RefWatcher DISABLED = new RefWatcherBuilder().build();
    private final DebuggerControl debuggerControl;
    private final ExcludedRefs excludedRefs;
    private final GcTrigger gcTrigger;
    private final HeapDumper heapDumper;
    private final Listener heapdumpListener;
    private final ReferenceQueue<Object> queue = new ReferenceQueue();
    private final Set<String> retainedKeys = new CopyOnWriteArraySet();
    private final WatchExecutor watchExecutor;

    RefWatcher(WatchExecutor watchExecutor, DebuggerControl debuggerControl, GcTrigger gcTrigger, HeapDumper heapDumper, Listener listener, ExcludedRefs excludedRefs) {
        this.watchExecutor = (WatchExecutor) Preconditions.checkNotNull(watchExecutor, "watchExecutor");
        this.debuggerControl = (DebuggerControl) Preconditions.checkNotNull(debuggerControl, "debuggerControl");
        this.gcTrigger = (GcTrigger) Preconditions.checkNotNull(gcTrigger, "gcTrigger");
        this.heapDumper = (HeapDumper) Preconditions.checkNotNull(heapDumper, "heapDumper");
        this.heapdumpListener = (Listener) Preconditions.checkNotNull(listener, "heapdumpListener");
        this.excludedRefs = (ExcludedRefs) Preconditions.checkNotNull(excludedRefs, "excludedRefs");
    }

    public void watch(Object obj) {
        watch(obj, "");
    }

    public void watch(Object obj, String str) {
        if (this != DISABLED) {
            Preconditions.checkNotNull(obj, "watchedReference");
            Preconditions.checkNotNull(str, "referenceName");
            long nanoTime = System.nanoTime();
            String uuid = UUID.randomUUID().toString();
            this.retainedKeys.add(uuid);
            ensureGoneAsync(nanoTime, new KeyedWeakReference(obj, uuid, str, this.queue));
        }
    }

    private void ensureGoneAsync(final long j, final KeyedWeakReference keyedWeakReference) {
        this.watchExecutor.execute(new Retryable() {
            public Result run() {
                return RefWatcher.this.ensureGone(keyedWeakReference, j);
            }
        });
    }

    Result ensureGone(KeyedWeakReference keyedWeakReference, long j) {
        long nanoTime = System.nanoTime();
        long toMillis = TimeUnit.NANOSECONDS.toMillis(nanoTime - j);
        removeWeaklyReachableReferences();
        if (this.debuggerControl.isDebuggerAttached()) {
            return Result.RETRY;
        }
        if (gone(keyedWeakReference)) {
            return Result.DONE;
        }
        this.gcTrigger.runGc();
        removeWeaklyReachableReferences();
        if (!gone(keyedWeakReference)) {
            long nanoTime2 = System.nanoTime();
            long toMillis2 = TimeUnit.NANOSECONDS.toMillis(nanoTime2 - nanoTime);
            File dumpHeap = this.heapDumper.dumpHeap();
            if (dumpHeap == HeapDumper.RETRY_LATER) {
                return Result.RETRY;
            }
            this.heapdumpListener.analyze(new HeapDump(dumpHeap, keyedWeakReference.key, keyedWeakReference.name, this.excludedRefs, toMillis, toMillis2, TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime2)));
        }
        return Result.DONE;
    }

    private boolean gone(KeyedWeakReference keyedWeakReference) {
        return !this.retainedKeys.contains(keyedWeakReference.key);
    }

    private void removeWeaklyReachableReferences() {
        while (true) {
            KeyedWeakReference keyedWeakReference = (KeyedWeakReference) this.queue.poll();
            if (keyedWeakReference != null) {
                this.retainedKeys.remove(keyedWeakReference.key);
            } else {
                return;
            }
        }
    }
}
