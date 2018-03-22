package com.huawei.p190v;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: LogUtil */
class C2537b extends Handler {
    private int f9032a = 3145728;
    private String f9033b = null;
    private C2536a f9034c = new C2545j(new C2544i());
    private String f9035d = null;

    public C2537b(Looper looper) {
        super(looper);
        sendEmptyMessageDelayed(1001, 6000);
        sendEmptyMessageDelayed(2001, 6000);
        this.f9032a = 3145728;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1000:
                removeMessages(1001);
                sendEmptyMessageDelayed(1001, 6000);
                m12647a((String) message.obj);
                return;
            case 1001:
                removeMessages(1001);
                sendEmptyMessageDelayed(1001, 6000);
                C2538c.m12671b();
                C2538c.m12678d();
                return;
            case 1002:
                this.f9032a = 3145728;
                return;
            case 1003:
                this.f9032a = 5242880;
                return;
            case 2000:
                removeMessages(2001);
                sendEmptyMessageDelayed(2001, 6000);
                m12649b((String) message.obj);
                return;
            case 2001:
                removeMessages(2001);
                sendEmptyMessageDelayed(2001, 6000);
                C2538c.m12678d();
                return;
            default:
                return;
        }
    }

    private void m12647a(String str) {
        File d = m12652d();
        if (str == null) {
            this.f9034c.mo2671a(d, true);
        } else if (d == null) {
            Log.w("LogUtil", "get log file failed.");
        } else if (!this.f9034c.mo2672a(d, str, true)) {
            Log.w("LogUtil", "writer.write() in Handler failed");
        }
    }

    private void m12649b(String str) {
        File e = m12653e();
        if (str == null) {
            this.f9034c.mo2671a(e, true);
        } else if (e == null) {
            Log.w("LogUtil", "get log file failed.");
        } else if (!this.f9034c.mo2672a(e, str, true)) {
            Log.w("LogUtil", "writer.write() in Handler failed");
        }
    }

    private File m12652d() {
        if (this.f9035d == null) {
            String c = C2537b.m12650c();
            if (c == null) {
                c = "health";
            } else {
                c = c.replaceAll(":", HwAccountConstants.SPLIIT_UNDERLINE);
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(C2537b.m12646a());
                stringBuilder.append(C2537b.m12651c(c));
                stringBuilder.append("_temp");
                stringBuilder.append("/");
                stringBuilder.append(c);
                stringBuilder.append("/");
                this.f9035d = stringBuilder.toString();
            } catch (Exception e) {
                this.f9035d = "/sdcard/huaweisystem/com.huawei.bone_temp/" + c + "/";
                Log.w("LogUtil", "cant get sdcard path");
            }
        }
        File file = new File(this.f9035d);
        if (!(file == null || file.exists() || file.mkdirs())) {
            Log.w("LogUtil", "create log directory failed");
        }
        file = new File(this.f9035d + "log.0");
        if (!file.exists() || file.length() <= ((long) this.f9032a)) {
            return file;
        }
        File file2 = new File(this.f9035d + "log." + 4);
        if (!file2.exists() || file2.delete()) {
            int i = 3;
            while (i >= 0) {
                File file3 = new File(this.f9035d + "log." + i);
                if (!file3.exists() || file3.renameTo(new File(this.f9035d + "log." + (i + 1)))) {
                    i--;
                } else {
                    Log.w("LogUtil", "rename log file failed");
                    return null;
                }
            }
            return file;
        }
        Log.w("LogUtil", "delete log file failed");
        return null;
    }

    public static String m12646a() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            if ("release".equals(C2538c.m12655a()) || "beta".equals(C2538c.m12655a())) {
                stringBuilder.append(BaseApplication.m2632b().getFilesDir().getAbsolutePath());
                stringBuilder.append("/");
                stringBuilder.append("log");
            } else {
                stringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
                stringBuilder.append("/");
                stringBuilder.append("huaweisystem");
            }
            stringBuilder.append("/");
            return stringBuilder.toString();
        } catch (Exception e) {
            Log.w("LogUtil", "cant get log path");
            return null;
        }
    }

    public static String m12648b() {
        String c = C2537b.m12650c();
        if (c == null) {
            c = "health";
        } else {
            c = c.replaceAll(":", HwAccountConstants.SPLIIT_UNDERLINE);
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(C2537b.m12646a());
            stringBuilder.append(C2537b.m12651c(c));
            stringBuilder.append("/");
            stringBuilder.append(c);
            stringBuilder.append("/");
            return stringBuilder.toString();
        } catch (Exception e) {
            Log.w("LogUtil", "cant get sdcard path");
            return null;
        }
    }

    private File m12653e() {
        if (this.f9033b == null) {
            String c = C2537b.m12650c();
            if (c == null) {
                c = "health";
            } else {
                c = c.replaceAll(":", HwAccountConstants.SPLIIT_UNDERLINE);
            }
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(C2537b.m12646a());
                stringBuilder.append(C2537b.m12651c(c));
                stringBuilder.append("/");
                stringBuilder.append(c);
                stringBuilder.append("/");
                this.f9033b = stringBuilder.toString();
            } catch (Exception e) {
                this.f9033b = "/sdcard/huaweisystem/com.huawei.bone/" + c + "/";
                Log.w("LogUtil", "cant get sdcard path");
            }
        }
        File file = new File(this.f9033b);
        if (!(file == null || file.exists() || file.mkdirs())) {
            Log.w("LogUtil", "create log directory failed");
        }
        file = new File(this.f9033b + "log.0");
        if (!file.exists() || file.length() <= ((long) this.f9032a)) {
            return file;
        }
        File file2 = new File(this.f9033b + "log." + 4);
        if (!file2.exists() || file2.delete()) {
            int i = 3;
            while (i >= 0) {
                File file3 = new File(this.f9033b + "log." + i);
                if (!file3.exists() || file3.renameTo(new File(this.f9033b + "log." + (i + 1)))) {
                    i--;
                } else {
                    Log.w("LogUtil", "rename log file failed");
                    return null;
                }
            }
            return file;
        }
        Log.w("LogUtil", "delete log file failed");
        return null;
    }

    private static String m12651c(String str) {
        int indexOf = str.indexOf(HwAccountConstants.SPLIIT_UNDERLINE);
        return -1 == indexOf ? str : str.substring(0, indexOf);
    }

    public static String m12650c() {
        String f = C2537b.m12654f();
        return f == null ? f : f;
    }

    private static String m12654f() {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Throwable th;
        Object obj;
        Throwable th2;
        Object obj2;
        String str = null;
        InputStreamReader inputStreamReader;
        try {
            fileInputStream = new FileInputStream("/proc/" + Process.myPid() + "/cmdline");
            try {
                inputStreamReader = new InputStreamReader(fileInputStream, "iso-8859-1");
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        while (true) {
                            int read = bufferedReader.read();
                            if (read <= 0) {
                                break;
                            }
                            stringBuilder.append((char) read);
                        }
                        str = stringBuilder.toString();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e) {
                                Log.w("LogUtil", "byteReader close failed");
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e2) {
                                Log.w("LogUtil", "byteReader close failed");
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                Log.w("LogUtil", "byteReader close failed");
                            }
                        }
                    } catch (IOException e4) {
                        try {
                            Log.d("LogUtil", "get process name (proc) failed");
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e5) {
                                    Log.w("LogUtil", "byteReader close failed");
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e6) {
                                    Log.w("LogUtil", "byteReader close failed");
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e7) {
                                    Log.w("LogUtil", "byteReader close failed");
                                }
                            }
                            return str;
                        } catch (Throwable th3) {
                            th = th3;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e8) {
                                    Log.w("LogUtil", "byteReader close failed");
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e9) {
                                    Log.w("LogUtil", "byteReader close failed");
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e10) {
                                    Log.w("LogUtil", "byteReader close failed");
                                }
                            }
                            throw th;
                        }
                    }
                } catch (IOException e11) {
                    obj = str;
                    Log.d("LogUtil", "get process name (proc) failed");
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return str;
                } catch (Throwable th4) {
                    th2 = th4;
                    obj = str;
                    th = th2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e12) {
                obj2 = str;
                obj = str;
                Log.d("LogUtil", "get process name (proc) failed");
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str;
            } catch (Throwable th5) {
                obj = str;
                String str2 = str;
                th = th5;
                obj2 = str2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (IOException e13) {
            obj2 = str;
            Object obj3 = str;
            obj = str;
            Log.d("LogUtil", "get process name (proc) failed");
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str;
        } catch (Throwable th52) {
            fileInputStream = str;
            bufferedReader = str;
            th2 = th52;
            inputStreamReader = str;
            th = th2;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return str;
    }
}
