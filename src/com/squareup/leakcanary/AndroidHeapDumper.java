package com.squareup.leakcanary;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.LayoutInflater;
import android.widget.Toast;
import com.squareup.leakcanary.internal.FutureResult;
import java.io.File;
import java.util.concurrent.TimeUnit;

public final class AndroidHeapDumper implements HeapDumper {
    final Context context;
    private final LeakDirectoryProvider leakDirectoryProvider;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public AndroidHeapDumper(Context context, LeakDirectoryProvider leakDirectoryProvider) {
        this.leakDirectoryProvider = leakDirectoryProvider;
        this.context = context.getApplicationContext();
    }

    public File dumpHeap() {
        File newHeapDumpFile = this.leakDirectoryProvider.newHeapDumpFile();
        if (newHeapDumpFile == RETRY_LATER) {
            return RETRY_LATER;
        }
        FutureResult futureResult = new FutureResult();
        showToast(futureResult);
        if (futureResult.wait(5, TimeUnit.SECONDS)) {
            Toast toast = (Toast) futureResult.get();
            try {
                Debug.dumpHprofData(newHeapDumpFile.getAbsolutePath());
                cancelToast(toast);
                return newHeapDumpFile;
            } catch (Throwable e) {
                CanaryLog.m12770d(e, "Could not dump heap", new Object[0]);
                return RETRY_LATER;
            }
        }
        CanaryLog.m12769d("Did not dump heap, too much time waiting for Toast.", new Object[0]);
        return RETRY_LATER;
    }

    private void showToast(final FutureResult<Toast> futureResult) {
        this.mainHandler.post(new Runnable() {
            public void run() {
                final Toast toast = new Toast(AndroidHeapDumper.this.context);
                toast.setGravity(16, 0, 0);
                toast.setDuration(1);
                toast.setView(LayoutInflater.from(AndroidHeapDumper.this.context).inflate(R.layout.leak_canary_heap_dump_toast, null));
                toast.show();
                Looper.myQueue().addIdleHandler(new IdleHandler() {
                    public boolean queueIdle() {
                        futureResult.set(toast);
                        return false;
                    }
                });
            }
        });
    }

    private void cancelToast(final Toast toast) {
        this.mainHandler.post(new Runnable() {
            public void run() {
                toast.cancel();
            }
        });
    }
}
