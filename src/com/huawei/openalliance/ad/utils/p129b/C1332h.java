package com.huawei.openalliance.ad.utils.p129b;

import android.util.Log;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.openalliance.ad.utils.p129b.C1341g.C1340a;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class C1332h {
    private static String f2874b = System.getProperty("line.separator");
    protected C1339f f2875a = C1339f.INFO;
    private int f2876c = 0;
    private String f2877d;
    private long f2878e;
    private final Map<String, C1339f> f2879f = new HashMap();

    public C1332h(String str, long j) {
        this.f2877d = str;
        this.f2878e = j;
    }

    private void m5863a(File file, String str, boolean z, boolean z2, String str2) {
        OutputStreamWriter outputStreamWriter;
        Throwable th;
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, true), GameManager.DEFAULT_CHARSET);
            if (z) {
                Object obj;
                if (z2) {
                    try {
                        obj = LightCloudConstants.RESPONSE_RESULT_SUCCESS;
                    } catch (FileNotFoundException e) {
                        try {
                            Log.e("LoggerBase", "println error, error:FileNotFoundException, file:" + file);
                            if (outputStreamWriter != null) {
                                try {
                                    outputStreamWriter.close();
                                } catch (IOException e2) {
                                    Log.e("LoggerBase", "println, close oswriter error");
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            outputStreamWriter2 = outputStreamWriter;
                            th = th3;
                            if (outputStreamWriter2 != null) {
                                try {
                                    outputStreamWriter2.close();
                                } catch (IOException e3) {
                                    Log.e("LoggerBase", "println, close oswriter error");
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e4) {
                        Log.e("LoggerBase", "println error, error:IOException, file:" + file);
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e5) {
                                Log.e("LoggerBase", "println, close oswriter error");
                                return;
                            }
                        }
                    }
                }
                obj = "failure";
                Object a = C1343k.m5929a();
                a.m5930a("rename to ").m5930a(str2).m5930a(HwAccountConstants.BLANK).m5930a(obj);
                if (this.f2876c > 0) {
                    a.m5931b().m5930a(C1334b.m5880a());
                }
                outputStreamWriter.write(new C1340a(null, C1339f.OUT).m5914a().m5921a(a).toString());
                outputStreamWriter.write(f2874b);
            }
            outputStreamWriter.write(str);
            outputStreamWriter.write(f2874b);
            outputStreamWriter.flush();
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e6) {
                    Log.e("LoggerBase", "println, close oswriter error");
                }
            }
        } catch (FileNotFoundException e7) {
            outputStreamWriter = null;
            Log.e("LoggerBase", "println error, error:FileNotFoundException, file:" + file);
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        } catch (IOException e8) {
            outputStreamWriter = null;
            Log.e("LoggerBase", "println error, error:IOException, file:" + file);
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        } catch (Throwable th4) {
            th = th4;
            if (outputStreamWriter2 != null) {
                outputStreamWriter2.close();
            }
            throw th;
        }
    }

    private boolean m5864a(File file, File file2) {
        if (file2.exists() && !file2.delete() && Log.isLoggable("LoggerBase", 6)) {
            Log.e("LoggerBase", "delete file failed:" + file2);
        }
        return file.renameTo(file2);
    }

    public synchronized C1339f m5865a(String str) {
        C1339f c1339f;
        c1339f = (C1339f) this.f2879f.get(str);
        if (c1339f == null) {
            c1339f = this.f2875a;
        }
        return c1339f;
    }

    public abstract void mo2458a(C1341g c1341g);

    protected void m5867a(String str, C1339f c1339f, String str2) {
        if (m5868a(str, c1339f)) {
            m5872b(str2);
        }
    }

    public boolean m5868a(String str, C1339f c1339f) {
        return c1339f.m5911a() >= m5865a(str).m5911a();
    }

    public long m5869b() {
        return this.f2878e;
    }

    public void m5870b(C1339f c1339f) {
        this.f2875a = c1339f;
        synchronized (this) {
            for (Entry value : this.f2879f.entrySet()) {
                value.setValue(c1339f);
            }
        }
    }

    public abstract void mo2459b(C1341g c1341g);

    protected synchronized void m5872b(String str) {
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            if (this.f2877d != null) {
                String str2 = null;
                long b = m5869b();
                File file = new File(this.f2877d);
                if (!file.exists()) {
                    file.setReadable(true);
                    file.setWritable(true);
                    file.setExecutable(false, false);
                }
                if (b > 0) {
                    File parentFile = file.getParentFile();
                    if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
                        if (file.length() + ((long) str.length()) > b) {
                            str2 = this.f2877d + ".bak";
                            z2 = m5864a(file, new File(str2));
                            m5863a(file, str, z, z2, str2);
                            this.f2876c++;
                        }
                    }
                }
                z = false;
                m5863a(file, str, z, z2, str2);
                this.f2876c++;
            }
        }
    }
}
