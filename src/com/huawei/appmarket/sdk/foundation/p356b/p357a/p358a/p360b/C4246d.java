package com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p360b;

import android.util.Log;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p359a.C4240b;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p362c.C4264c;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Map.Entry;

public abstract class C4246d {
    static int f15920a = 0;
    private static C4242a f15921e = C4242a.INFO;
    private static C4242a f15922f = C4242a.ERROR;
    private static String f15923g = System.getProperty("line.separator");
    private String f15924b;
    private long f15925c;
    private final Map<String, C4242a> f15926d;

    private void m20566a(File file, String str, boolean z, boolean z2, String str2) {
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
                            Log.e("LoggerBase", "println error, error:FileNotFoundException");
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
                        Log.e("LoggerBase", "println error, error:IOException");
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
                Object a = C4240b.m20525a();
                a.m20526a("rename to ").m20526a(str2).m20526a(HwAccountConstants.BLANK).m20526a(obj);
                if (f15920a > 0) {
                    a.m20527b().m20526a(C4243b.m20536a(false));
                }
                outputStreamWriter.write(C4243b.m20543c().m20548a(a).toString());
                outputStreamWriter.write(f15923g);
            }
            outputStreamWriter.write(str);
            outputStreamWriter.write(f15923g);
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
            Log.e("LoggerBase", "println error, error:FileNotFoundException");
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        } catch (IOException e8) {
            outputStreamWriter = null;
            Log.e("LoggerBase", "println error, error:IOException");
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

    public long m20567a() {
        return this.f15925c;
    }

    public synchronized C4242a m20568a(String str) {
        C4242a c4242a;
        c4242a = (C4242a) this.f15926d.get(str);
        if (c4242a == null) {
            c4242a = f15921e;
        }
        return c4242a;
    }

    public abstract void mo4391a(C4243b c4243b);

    public boolean m20570a(String str, C4242a c4242a) {
        return c4242a.m20533a() >= m20568a(str).m20533a();
    }

    public String mo4392b() {
        return null;
    }

    protected synchronized void m20572b(String str) {
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            if (this.f15924b != null) {
                String str2 = null;
                long a = m20567a();
                File file = new File(this.f15924b);
                if (!file.exists()) {
                    file.setReadable(true);
                    file.setWritable(true);
                    file.setExecutable(false, false);
                }
                if (a > 0) {
                    File parentFile = file.getParentFile();
                    if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
                        if (file.length() + ((long) str.length()) > a) {
                            str2 = this.f15924b + ".bak";
                            parentFile = new File(str2);
                            if (parentFile.exists()) {
                                parentFile.delete();
                            }
                            z2 = file.renameTo(parentFile);
                            m20566a(file, str, z, z2, str2);
                            f15920a++;
                        }
                    }
                }
                z = false;
                m20566a(file, str, z, z2, str2);
                f15920a++;
            }
        }
    }

    public abstract boolean mo4393b(String str, C4242a c4242a);

    public synchronized String toString() {
        C4264c c4264c;
        c4264c = new C4264c();
        c4264c.m20634a("default", f15921e);
        for (Entry entry : this.f15926d.entrySet()) {
            c4264c.m20634a((String) entry.getKey(), entry.getValue());
        }
        return c4264c.m20635b();
    }
}
