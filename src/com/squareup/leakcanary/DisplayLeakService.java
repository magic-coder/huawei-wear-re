package com.squareup.leakcanary;

import android.app.PendingIntent;
import android.os.SystemClock;
import android.text.format.Formatter;
import com.squareup.leakcanary.internal.DisplayLeakActivity;
import com.squareup.leakcanary.internal.LeakCanaryInternals;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DisplayLeakService extends AbstractAnalysisResultService {
    protected final void onHeapAnalyzed(HeapDump heapDump, AnalysisResult analysisResult) {
        boolean saveResult;
        CharSequence string;
        CharSequence string2;
        PendingIntent pendingIntent = null;
        CanaryLog.m12769d("%s", LeakCanary.leakInfo(this, heapDump, analysisResult, true));
        int i = (analysisResult.leakFound || analysisResult.failure != null) ? true : 0;
        if (i != 0) {
            heapDump = renameHeapdump(heapDump);
            saveResult = saveResult(heapDump, analysisResult);
        } else {
            saveResult = false;
        }
        if (i == 0) {
            string = getString(R$string.leak_canary_no_leak_title);
            string2 = getString(R$string.leak_canary_no_leak_text);
        } else if (saveResult) {
            String formatShortFileSize;
            pendingIntent = DisplayLeakActivity.createPendingIntent(this, heapDump.referenceKey);
            if (analysisResult.failure == null) {
                formatShortFileSize = Formatter.formatShortFileSize(this, analysisResult.retainedHeapSize);
                String classSimpleName = LeakCanaryInternals.classSimpleName(analysisResult.className);
                if (analysisResult.excludedLeak) {
                    formatShortFileSize = getString(R$string.leak_canary_leak_excluded, new Object[]{classSimpleName, formatShortFileSize});
                } else {
                    formatShortFileSize = getString(R$string.leak_canary_class_has_leaked, new Object[]{classSimpleName, formatShortFileSize});
                }
            } else {
                formatShortFileSize = getString(R$string.leak_canary_analysis_failed);
            }
            Object obj = formatShortFileSize;
            Object string3 = getString(R$string.leak_canary_notification_message);
        } else {
            string = getString(R$string.leak_canary_could_not_save_title);
            string2 = getString(R$string.leak_canary_could_not_save_text);
        }
        LeakCanaryInternals.showNotification(this, string, string2, pendingIntent, (int) (SystemClock.uptimeMillis() / 1000));
        afterDefaultHandling(heapDump, analysisResult, r5);
    }

    private boolean saveResult(HeapDump heapDump, AnalysisResult analysisResult) {
        FileOutputStream fileOutputStream;
        Throwable e;
        Throwable th;
        boolean z = false;
        try {
            fileOutputStream = new FileOutputStream(new File(heapDump.heapDumpFile.getParentFile(), heapDump.heapDumpFile.getName() + ".result"));
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(heapDump);
                objectOutputStream.writeObject(analysisResult);
                z = true;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    CanaryLog.m12770d(e, "Could not save leak analysis result to disk.", new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            fileOutputStream = null;
            CanaryLog.m12770d(e, "Could not save leak analysis result to disk.", new Object[0]);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        return z;
    }

    private HeapDump renameHeapdump(HeapDump heapDump) {
        File file = new File(heapDump.heapDumpFile.getParent(), new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS'.hprof'", Locale.US).format(new Date()));
        if (!heapDump.heapDumpFile.renameTo(file)) {
            CanaryLog.m12769d("Could not rename heap dump file %s to %s", heapDump.heapDumpFile.getPath(), file.getPath());
        }
        return new HeapDump(file, heapDump.referenceKey, heapDump.referenceName, heapDump.excludedRefs, heapDump.watchDurationMs, heapDump.gcDurationMs, heapDump.heapDumpDurationMs);
    }

    protected void afterDefaultHandling(HeapDump heapDump, AnalysisResult analysisResult, String str) {
    }
}
