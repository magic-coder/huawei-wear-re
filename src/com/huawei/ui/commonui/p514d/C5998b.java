package com.huawei.ui.commonui.p514d;

import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;

/* compiled from: RootUtils */
public class C5998b {
    public static boolean m27443a() {
        if ("0".equals(C5998b.m27445b())) {
            return true;
        }
        if (new File(C5998b.m27446c()).exists() && C5998b.m27444a(C5998b.m27446c())) {
            return true;
        }
        if (new File(C5998b.m27447d()).exists() && C5998b.m27444a(C5998b.m27447d())) {
            return true;
        }
        return false;
    }

    private static String m27446c() {
        return "/system/bin/su";
    }

    private static String m27447d() {
        return "/system/xbin/su";
    }

    private static boolean m27444a(String str) {
        Process exec;
        InputStream inputStream;
        IOException e;
        Reader reader;
        InputStream inputStream2;
        Process process;
        Throwable th;
        Reader reader2 = null;
        char[] cArr = new char[10];
        Reader inputStreamReader;
        try {
            exec = Runtime.getRuntime().exec("ls -l " + str);
            try {
                inputStream = exec.getInputStream();
                try {
                    inputStreamReader = new InputStreamReader(inputStream, GameManager.DEFAULT_CHARSET);
                } catch (IOException e2) {
                    e = e2;
                    reader = null;
                    inputStream2 = inputStream;
                    process = exec;
                    try {
                        C2538c.e("IOException", new Object[]{e.getMessage()});
                        C5998b.m27441a(inputStream2);
                        C5998b.m27442a(reader2);
                        C5998b.m27442a(reader);
                        if (process != null) {
                            process.destroy();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        exec = process;
                        inputStream = inputStream2;
                        inputStreamReader = reader2;
                        reader2 = reader;
                        C5998b.m27441a(inputStream);
                        C5998b.m27442a(inputStreamReader);
                        C5998b.m27442a(reader2);
                        if (exec != null) {
                            exec.destroy();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamReader = null;
                    C5998b.m27441a(inputStream);
                    C5998b.m27442a(inputStreamReader);
                    C5998b.m27442a(reader2);
                    if (exec != null) {
                        exec.destroy();
                    }
                    throw th;
                }
                try {
                    reader = new BufferedReader(inputStreamReader);
                } catch (IOException e3) {
                    e = e3;
                    reader = null;
                    reader2 = inputStreamReader;
                    inputStream2 = inputStream;
                    process = exec;
                    C2538c.e("IOException", new Object[]{e.getMessage()});
                    C5998b.m27441a(inputStream2);
                    C5998b.m27442a(reader2);
                    C5998b.m27442a(reader);
                    if (process != null) {
                        process.destroy();
                    }
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    C5998b.m27441a(inputStream);
                    C5998b.m27442a(inputStreamReader);
                    C5998b.m27442a(reader2);
                    if (exec != null) {
                        exec.destroy();
                    }
                    throw th;
                }
                try {
                    if (reader.read(cArr, 0, 5) >= 4) {
                        char c = cArr[3];
                        if (c == 's' || c == 'x') {
                            C5998b.m27441a(inputStream);
                            C5998b.m27442a(inputStreamReader);
                            C5998b.m27442a(reader);
                            if (exec == null) {
                                return true;
                            }
                            exec.destroy();
                            return true;
                        }
                    }
                    C5998b.m27441a(inputStream);
                    C5998b.m27442a(inputStreamReader);
                    C5998b.m27442a(reader);
                    if (exec != null) {
                        exec.destroy();
                    }
                } catch (IOException e4) {
                    e = e4;
                    reader2 = inputStreamReader;
                    inputStream2 = inputStream;
                    process = exec;
                    C2538c.e("IOException", new Object[]{e.getMessage()});
                    C5998b.m27441a(inputStream2);
                    C5998b.m27442a(reader2);
                    C5998b.m27442a(reader);
                    if (process != null) {
                        process.destroy();
                    }
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    reader2 = reader;
                    C5998b.m27441a(inputStream);
                    C5998b.m27442a(inputStreamReader);
                    C5998b.m27442a(reader2);
                    if (exec != null) {
                        exec.destroy();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                reader = null;
                inputStream2 = null;
                process = exec;
                C2538c.e("IOException", new Object[]{e.getMessage()});
                C5998b.m27441a(inputStream2);
                C5998b.m27442a(reader2);
                C5998b.m27442a(reader);
                if (process != null) {
                    process.destroy();
                }
                return false;
            } catch (Throwable th6) {
                th = th6;
                inputStreamReader = null;
                inputStream = null;
                C5998b.m27441a(inputStream);
                C5998b.m27442a(inputStreamReader);
                C5998b.m27442a(reader2);
                if (exec != null) {
                    exec.destroy();
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            reader = null;
            inputStream2 = null;
            process = null;
            C2538c.e("IOException", new Object[]{e.getMessage()});
            C5998b.m27441a(inputStream2);
            C5998b.m27442a(reader2);
            C5998b.m27442a(reader);
            if (process != null) {
                process.destroy();
            }
            return false;
        } catch (Throwable th7) {
            th = th7;
            inputStreamReader = null;
            inputStream = null;
            exec = null;
            C5998b.m27441a(inputStream);
            C5998b.m27442a(inputStreamReader);
            C5998b.m27442a(reader2);
            if (exec != null) {
                exec.destroy();
            }
            throw th;
        }
        return false;
    }

    private static void m27441a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                C2538c.e("closeStream IOException", new Object[]{e.getMessage()});
            }
        }
    }

    private static void m27442a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                C2538c.e("closeReader IOException", new Object[]{Boolean.valueOf(false)});
            }
        }
    }

    public static String m27445b() {
        String str;
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.secure"});
            try {
                C2538c.c("RootUtil", new Object[]{"getRootProperty, Root Property info: " + str});
            } catch (ClassNotFoundException e) {
                C2538c.e("RootUtil", new Object[]{"getProductConfig, ClassNotFoundException."});
                return str;
            } catch (NoSuchMethodException e2) {
                C2538c.e("RootUtil", new Object[]{"getProductConfig NoSuchMethodException."});
                return str;
            } catch (IllegalArgumentException e3) {
                C2538c.e("RootUtil", new Object[]{"getProductConfig IllegalArgumentException."});
                return str;
            } catch (IllegalAccessException e4) {
                C2538c.e("RootUtil", new Object[]{"getProductConfig IllegalAccessException."});
                return str;
            } catch (InvocationTargetException e5) {
                C2538c.e("RootUtil", new Object[]{"getProductConfig InvocationTargetException."});
                return str;
            }
        } catch (ClassNotFoundException e6) {
            str = null;
            C2538c.e("RootUtil", new Object[]{"getProductConfig, ClassNotFoundException."});
            return str;
        } catch (NoSuchMethodException e7) {
            str = null;
            C2538c.e("RootUtil", new Object[]{"getProductConfig NoSuchMethodException."});
            return str;
        } catch (IllegalArgumentException e8) {
            str = null;
            C2538c.e("RootUtil", new Object[]{"getProductConfig IllegalArgumentException."});
            return str;
        } catch (IllegalAccessException e9) {
            str = null;
            C2538c.e("RootUtil", new Object[]{"getProductConfig IllegalAccessException."});
            return str;
        } catch (InvocationTargetException e10) {
            str = null;
            C2538c.e("RootUtil", new Object[]{"getProductConfig InvocationTargetException."});
            return str;
        }
        return str;
    }
}
