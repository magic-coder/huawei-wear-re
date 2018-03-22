package com.squareup.leakcanary;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import com.squareup.leakcanary.internal.LeakCanaryInternals;
import com.squareup.leakcanary.internal.RequestStoragePermissionActivity;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DefaultLeakDirectoryProvider implements LeakDirectoryProvider {
    private static final int ANALYSIS_MAX_DURATION_MS = 600000;
    private static final int DEFAULT_MAX_STORED_HEAP_DUMPS = 7;
    private static final String HPROF_SUFFIX = ".hprof";
    private static final String PENDING_HEAPDUMP_SUFFIX = "_pending.hprof";
    private final Context context;
    private final int maxStoredHeapDumps;
    private volatile boolean permissionNotificationDisplayed;
    private volatile boolean writeExternalStorageGranted;

    class C25851 implements FilenameFilter {
        C25851() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(DefaultLeakDirectoryProvider.PENDING_HEAPDUMP_SUFFIX);
        }
    }

    class C25862 implements FilenameFilter {
        C25862() {
        }

        public boolean accept(File file, String str) {
            return !str.endsWith(DefaultLeakDirectoryProvider.PENDING_HEAPDUMP_SUFFIX);
        }
    }

    class C25873 implements FilenameFilter {
        C25873() {
        }

        public boolean accept(File file, String str) {
            return str.endsWith(DefaultLeakDirectoryProvider.HPROF_SUFFIX);
        }
    }

    class C25884 implements Comparator<File> {
        C25884() {
        }

        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    public DefaultLeakDirectoryProvider(Context context) {
        this(context, 7);
    }

    public DefaultLeakDirectoryProvider(Context context, int i) {
        if (i < 1) {
            throw new IllegalArgumentException("maxStoredHeapDumps must be at least 1");
        }
        this.context = context.getApplicationContext();
        this.maxStoredHeapDumps = i;
    }

    public List<File> listFiles(FilenameFilter filenameFilter) {
        if (!hasStoragePermission()) {
            requestWritePermissionNotification();
        }
        List<File> arrayList = new ArrayList();
        File[] listFiles = externalStorageDirectory().listFiles(filenameFilter);
        if (listFiles != null) {
            arrayList.addAll(Arrays.asList(listFiles));
        }
        listFiles = appStorageDirectory().listFiles(filenameFilter);
        if (listFiles != null) {
            arrayList.addAll(Arrays.asList(listFiles));
        }
        return arrayList;
    }

    public File newHeapDumpFile() {
        for (File lastModified : listFiles(new C25851())) {
            if (System.currentTimeMillis() - lastModified.lastModified() < 600000) {
                CanaryLog.m12769d("Could not dump heap, previous analysis still is in progress.", new Object[0]);
                return HeapDumper.RETRY_LATER;
            }
        }
        cleanupOldHeapDumps();
        File lastModified2 = externalStorageDirectory();
        if (!directoryWritableAfterMkdirs(lastModified2)) {
            if (hasStoragePermission()) {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    CanaryLog.m12769d("Could not create heap dump directory in external storage: [%s]", lastModified2.getAbsolutePath());
                } else {
                    CanaryLog.m12769d("External storage not mounted, state: %s", Environment.getExternalStorageState());
                }
            } else {
                CanaryLog.m12769d("WRITE_EXTERNAL_STORAGE permission not granted", new Object[0]);
                requestWritePermissionNotification();
            }
            lastModified2 = appStorageDirectory();
            if (!directoryWritableAfterMkdirs(lastModified2)) {
                CanaryLog.m12769d("Could not create heap dump directory in app storage: [%s]", lastModified2.getAbsolutePath());
                return HeapDumper.RETRY_LATER;
            }
        }
        return new File(lastModified2, UUID.randomUUID().toString() + PENDING_HEAPDUMP_SUFFIX);
    }

    public void clearLeakDirectory() {
        for (File delete : listFiles(new C25862())) {
            if (!delete.delete()) {
                CanaryLog.m12769d("Could not delete file %s", ((File) r1.next()).getPath());
            }
        }
    }

    @TargetApi(23)
    private boolean hasStoragePermission() {
        boolean z = true;
        if (VERSION.SDK_INT < 23 || this.writeExternalStorageGranted) {
            return true;
        }
        if (this.context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            z = false;
        }
        this.writeExternalStorageGranted = z;
        return this.writeExternalStorageGranted;
    }

    private void requestWritePermissionNotification() {
        if (!this.permissionNotificationDisplayed) {
            this.permissionNotificationDisplayed = true;
            PendingIntent createPendingIntent = RequestStoragePermissionActivity.createPendingIntent(this.context);
            CharSequence string = this.context.getString(R$string.leak_canary_permission_notification_title);
            String packageName = this.context.getPackageName();
            LeakCanaryInternals.showNotification(this.context, string, this.context.getString(R$string.leak_canary_permission_notification_text, new Object[]{packageName}), createPendingIntent, -558907665);
        }
    }

    private File externalStorageDirectory() {
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "leakcanary-" + this.context.getPackageName());
    }

    private File appStorageDirectory() {
        return new File(this.context.getFilesDir(), "leakcanary");
    }

    private boolean directoryWritableAfterMkdirs(File file) {
        return (file.mkdirs() || file.exists()) && file.canWrite();
    }

    private void cleanupOldHeapDumps() {
        List listFiles = listFiles(new C25873());
        int size = listFiles.size() - this.maxStoredHeapDumps;
        if (size > 0) {
            CanaryLog.m12769d("Removing %d heap dumps", Integer.valueOf(size));
            Collections.sort(listFiles, new C25884());
            for (int i = 0; i < size; i++) {
                if (!((File) listFiles.get(i)).delete()) {
                    CanaryLog.m12769d("Could not delete old hprof file %s", ((File) listFiles.get(i)).getPath());
                }
            }
        }
    }
}
