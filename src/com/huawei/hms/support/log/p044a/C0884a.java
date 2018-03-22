package com.huawei.hms.support.log.p044a;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.support.log.C0882c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: FileLogNode */
public class C0884a implements C0882c {
    private File f1412a;

    /* compiled from: FileLogNode */
    public class C0883a implements C0882c {
        private final C0882c f1409a;
        private C0882c f1410b;
        private final Executor f1411c = Executors.newSingleThreadExecutor();

        public C0883a(C0882c c0882c) {
            this.f1409a = c0882c;
        }

        public void mo2262a(Context context, String str) {
            this.f1411c.execute(new C0885b(this, context, str));
            if (this.f1410b != null) {
                this.f1410b.mo2262a(context, str);
            }
        }

        public void mo2263a(String str, int i, String str2, String str3) {
            this.f1411c.execute(new C0886c(this, str, i, str2, str3));
            if (this.f1410b != null) {
                this.f1410b.mo2263a(str, i, str2, str3);
            }
        }
    }

    public void mo2262a(Context context, String str) {
        if (context == null || str == null || str.isEmpty()) {
            Log.e("FileLogNode", "Failed to initialize the file logger, parameter error.");
            return;
        }
        if (this.f1412a == null) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                File file = new File(externalFilesDir, "Log");
                if (file.isDirectory() || file.mkdirs()) {
                    this.f1412a = new File(file, str + ".log");
                    this.f1412a.setReadable(true);
                    this.f1412a.setWritable(true);
                    this.f1412a.setExecutable(false, false);
                    return;
                }
            }
        }
        Log.e("FileLogNode", "Failed to initialize the file logger.");
    }

    public void mo2263a(String str, int i, String str2, String str3) {
        if (this.f1412a != null && str != null) {
            String str4 = str + '\n';
            if (m3086a(str4)) {
                m3087b(str4);
            }
        }
    }

    private boolean m3086a(String str) {
        if (this.f1412a.length() + ((long) str.length()) > 524288) {
            if (!this.f1412a.renameTo(new File(this.f1412a.getPath() + ".bak"))) {
                Log.w("FileLogNode", "Failed to backup the log file.");
                return false;
            }
        }
        return true;
    }

    private void m3087b(String str) {
        Closeable fileOutputStream;
        Closeable bufferedOutputStream;
        Closeable outputStreamWriter;
        Throwable th;
        Throwable th2;
        Closeable closeable = null;
        try {
            fileOutputStream = new FileOutputStream(this.f1412a, true);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, GameManager.DEFAULT_CHARSET);
                } catch (FileNotFoundException e) {
                    outputStreamWriter = null;
                    closeable = bufferedOutputStream;
                    bufferedOutputStream = fileOutputStream;
                    try {
                        Log.w("FileLogNode", "Exception when writing the log file.");
                        C0884a.m3085a(outputStreamWriter);
                        C0884a.m3085a(closeable);
                        C0884a.m3085a(bufferedOutputStream);
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = bufferedOutputStream;
                        bufferedOutputStream = closeable;
                        closeable = outputStreamWriter;
                        th2 = th;
                        C0884a.m3085a(closeable);
                        C0884a.m3085a(bufferedOutputStream);
                        C0884a.m3085a(fileOutputStream);
                        throw th2;
                    }
                } catch (IOException e2) {
                    try {
                        Log.w("FileLogNode", "Exception when writing the log file.");
                        C0884a.m3085a(closeable);
                        C0884a.m3085a(bufferedOutputStream);
                        C0884a.m3085a(fileOutputStream);
                    } catch (Throwable th4) {
                        th2 = th4;
                        C0884a.m3085a(closeable);
                        C0884a.m3085a(bufferedOutputStream);
                        C0884a.m3085a(fileOutputStream);
                        throw th2;
                    }
                }
                try {
                    outputStreamWriter.write(str);
                    outputStreamWriter.flush();
                    C0884a.m3085a(outputStreamWriter);
                    C0884a.m3085a(bufferedOutputStream);
                    C0884a.m3085a(fileOutputStream);
                } catch (FileNotFoundException e3) {
                    closeable = bufferedOutputStream;
                    bufferedOutputStream = fileOutputStream;
                    Log.w("FileLogNode", "Exception when writing the log file.");
                    C0884a.m3085a(outputStreamWriter);
                    C0884a.m3085a(closeable);
                    C0884a.m3085a(bufferedOutputStream);
                } catch (IOException e4) {
                    closeable = outputStreamWriter;
                    Log.w("FileLogNode", "Exception when writing the log file.");
                    C0884a.m3085a(closeable);
                    C0884a.m3085a(bufferedOutputStream);
                    C0884a.m3085a(fileOutputStream);
                } catch (Throwable th5) {
                    th = th5;
                    closeable = outputStreamWriter;
                    th2 = th;
                    C0884a.m3085a(closeable);
                    C0884a.m3085a(bufferedOutputStream);
                    C0884a.m3085a(fileOutputStream);
                    throw th2;
                }
            } catch (FileNotFoundException e5) {
                outputStreamWriter = null;
                bufferedOutputStream = fileOutputStream;
                Log.w("FileLogNode", "Exception when writing the log file.");
                C0884a.m3085a(outputStreamWriter);
                C0884a.m3085a(closeable);
                C0884a.m3085a(bufferedOutputStream);
            } catch (IOException e6) {
                bufferedOutputStream = null;
                Log.w("FileLogNode", "Exception when writing the log file.");
                C0884a.m3085a(closeable);
                C0884a.m3085a(bufferedOutputStream);
                C0884a.m3085a(fileOutputStream);
            } catch (Throwable th6) {
                th2 = th6;
                bufferedOutputStream = null;
                C0884a.m3085a(closeable);
                C0884a.m3085a(bufferedOutputStream);
                C0884a.m3085a(fileOutputStream);
                throw th2;
            }
        } catch (FileNotFoundException e7) {
            outputStreamWriter = null;
            bufferedOutputStream = null;
            Log.w("FileLogNode", "Exception when writing the log file.");
            C0884a.m3085a(outputStreamWriter);
            C0884a.m3085a(closeable);
            C0884a.m3085a(bufferedOutputStream);
        } catch (IOException e8) {
            bufferedOutputStream = null;
            fileOutputStream = null;
            Log.w("FileLogNode", "Exception when writing the log file.");
            C0884a.m3085a(closeable);
            C0884a.m3085a(bufferedOutputStream);
            C0884a.m3085a(fileOutputStream);
        } catch (Throwable th7) {
            th2 = th7;
            bufferedOutputStream = null;
            fileOutputStream = null;
            C0884a.m3085a(closeable);
            C0884a.m3085a(bufferedOutputStream);
            C0884a.m3085a(fileOutputStream);
            throw th2;
        }
    }

    private static void m3085a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.w("FileLogNode", "Exception when closing the closeable.");
            }
        }
    }
}
