package com.huawei.hwid.core.p435d.p437b;

import android.util.Log;
import com.huawei.hwid.core.p435d.p437b.C5162c.C5158a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: FileLogger */
public class C5159a implements C5158a, Runnable {
    private final BlockingQueue<String> f18607a = new LinkedBlockingQueue();
    private Thread f18608b;
    private volatile boolean f18609c = true;
    private File f18610d;

    public void mo4636a(String str) {
        if (str != null && this.f18610d != null && !this.f18607a.offer(str)) {
            Log.w("FileLogger", "write offer failed");
        }
    }

    public void m24874a(File file) {
        if (file == null) {
            Log.w("FileLogger", "Invalid argument.");
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            Log.w("FileLogger", "logDir is null");
            return;
        }
        if (!parentFile.mkdirs()) {
            Log.w("FileLogger", "Failed to create the log dir or has created.");
        }
        if (parentFile.isDirectory()) {
            this.f18610d = file;
            this.f18608b = new Thread(this, "hwid-log-thread");
            this.f18608b.start();
            return;
        }
        Log.w("FileLogger", "Failed to create the log dir.");
    }

    public void run() {
        this.f18609c = true;
        if (this.f18610d != null) {
            while (this.f18609c) {
                try {
                    String str = (String) this.f18607a.poll(1, TimeUnit.SECONDS);
                    if (str != null) {
                        m24872b(str);
                        m24873c(str);
                    }
                } catch (InterruptedException e) {
                }
            }
        }
        Log.i("FileLogger", "The log logger is closed.");
    }

    private void m24872b(String str) {
        if (this.f18610d.length() + ((long) str.length()) > 3145728) {
            if (!this.f18610d.renameTo(new File(this.f18610d.getPath() + ".bak"))) {
                Log.w("FileLogger", "Failed to backup the log file.");
            }
        }
    }

    private void m24873c(String str) {
        Closeable fileOutputStream;
        Closeable bufferedOutputStream;
        Closeable outputStreamWriter;
        Throwable th;
        Throwable th2;
        Closeable closeable = null;
        try {
            fileOutputStream = new FileOutputStream(this.f18610d, true);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, GameManager.DEFAULT_CHARSET);
                } catch (FileNotFoundException e) {
                    outputStreamWriter = null;
                    closeable = bufferedOutputStream;
                    bufferedOutputStream = fileOutputStream;
                    try {
                        Log.d("FileLogger", "Exception when writing the log file.");
                        C5159a.m24871a(outputStreamWriter);
                        C5159a.m24871a(closeable);
                        C5159a.m24871a(bufferedOutputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = bufferedOutputStream;
                        bufferedOutputStream = closeable;
                        closeable = outputStreamWriter;
                        th2 = th;
                        C5159a.m24871a(closeable);
                        C5159a.m24871a(bufferedOutputStream);
                        C5159a.m24871a(fileOutputStream);
                        throw th2;
                    }
                } catch (IOException e2) {
                    try {
                        Log.d("FileLogger", "Exception when writing the log file.");
                        C5159a.m24871a(closeable);
                        C5159a.m24871a(bufferedOutputStream);
                        C5159a.m24871a(fileOutputStream);
                    } catch (Throwable th4) {
                        th2 = th4;
                        C5159a.m24871a(closeable);
                        C5159a.m24871a(bufferedOutputStream);
                        C5159a.m24871a(fileOutputStream);
                        throw th2;
                    }
                }
                try {
                    outputStreamWriter.write(str);
                    outputStreamWriter.flush();
                    C5159a.m24871a(outputStreamWriter);
                    C5159a.m24871a(bufferedOutputStream);
                    C5159a.m24871a(fileOutputStream);
                } catch (FileNotFoundException e3) {
                    closeable = bufferedOutputStream;
                    bufferedOutputStream = fileOutputStream;
                    Log.d("FileLogger", "Exception when writing the log file.");
                    C5159a.m24871a(outputStreamWriter);
                    C5159a.m24871a(closeable);
                    C5159a.m24871a(bufferedOutputStream);
                } catch (IOException e4) {
                    closeable = outputStreamWriter;
                    Log.d("FileLogger", "Exception when writing the log file.");
                    C5159a.m24871a(closeable);
                    C5159a.m24871a(bufferedOutputStream);
                    C5159a.m24871a(fileOutputStream);
                } catch (Throwable th5) {
                    th = th5;
                    closeable = outputStreamWriter;
                    th2 = th;
                    C5159a.m24871a(closeable);
                    C5159a.m24871a(bufferedOutputStream);
                    C5159a.m24871a(fileOutputStream);
                    throw th2;
                }
            } catch (FileNotFoundException e5) {
                outputStreamWriter = null;
                bufferedOutputStream = fileOutputStream;
                Log.d("FileLogger", "Exception when writing the log file.");
                C5159a.m24871a(outputStreamWriter);
                C5159a.m24871a(closeable);
                C5159a.m24871a(bufferedOutputStream);
            } catch (IOException e6) {
                bufferedOutputStream = null;
                Log.d("FileLogger", "Exception when writing the log file.");
                C5159a.m24871a(closeable);
                C5159a.m24871a(bufferedOutputStream);
                C5159a.m24871a(fileOutputStream);
            } catch (Throwable th6) {
                th2 = th6;
                bufferedOutputStream = null;
                C5159a.m24871a(closeable);
                C5159a.m24871a(bufferedOutputStream);
                C5159a.m24871a(fileOutputStream);
                throw th2;
            }
        } catch (FileNotFoundException e7) {
            outputStreamWriter = null;
            bufferedOutputStream = null;
            Log.d("FileLogger", "Exception when writing the log file.");
            C5159a.m24871a(outputStreamWriter);
            C5159a.m24871a(closeable);
            C5159a.m24871a(bufferedOutputStream);
        } catch (IOException e8) {
            bufferedOutputStream = null;
            fileOutputStream = null;
            Log.d("FileLogger", "Exception when writing the log file.");
            C5159a.m24871a(closeable);
            C5159a.m24871a(bufferedOutputStream);
            C5159a.m24871a(fileOutputStream);
        } catch (Throwable th7) {
            th2 = th7;
            bufferedOutputStream = null;
            fileOutputStream = null;
            C5159a.m24871a(closeable);
            C5159a.m24871a(bufferedOutputStream);
            C5159a.m24871a(fileOutputStream);
            throw th2;
        }
    }

    private static void m24871a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.d("FileLogger", "Exception when closing the closeable.");
            }
        }
    }
}
