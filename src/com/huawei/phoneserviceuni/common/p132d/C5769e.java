package com.huawei.phoneserviceuni.common.p132d;

import com.huawei.phoneserviceuni.common.d.c;
import java.lang.reflect.Method;

/* compiled from: SysPropUtils */
public class C5769e {
    public static String m26487a(String str, String str2) {
        Object cls;
        Exception e;
        Method method = null;
        try {
            cls = Class.forName("android.os.SystemProperties");
            try {
                method = cls.getDeclaredMethod("get", new Class[]{String.class, String.class});
            } catch (ClassNotFoundException e2) {
                e = e2;
                C5769e.m26488a(e, "CommonUtils");
                if (method == null) {
                    return str2;
                }
                try {
                    return (String) method.invoke(cls, new Object[]{str, str2});
                } catch (Exception e3) {
                    C5769e.m26488a(e3, "CommonUtils");
                    return str2;
                } catch (Exception e32) {
                    C5769e.m26488a(e32, "CommonUtils");
                    return str2;
                } catch (Exception e322) {
                    C5769e.m26488a(e322, "CommonUtils");
                    return str2;
                }
            } catch (NoSuchMethodException e4) {
                e322 = e4;
                C5769e.m26488a(e322, "CommonUtils");
                if (method == null) {
                    return str2;
                }
                return (String) method.invoke(cls, new Object[]{str, str2});
            }
        } catch (ClassNotFoundException e5) {
            e322 = e5;
            cls = method;
            C5769e.m26488a(e322, "CommonUtils");
            if (method == null) {
                return str2;
            }
            return (String) method.invoke(cls, new Object[]{str, str2});
        } catch (NoSuchMethodException e6) {
            e322 = e6;
            cls = method;
            C5769e.m26488a(e322, "CommonUtils");
            if (method == null) {
                return str2;
            }
            return (String) method.invoke(cls, new Object[]{str, str2});
        }
        if (method == null) {
            return str2;
        }
        return (String) method.invoke(cls, new Object[]{str, str2});
    }

    public static String m26486a(String str) {
        Object cls;
        Method declaredMethod;
        Exception e;
        try {
            cls = Class.forName("android.os.SystemProperties");
            try {
                declaredMethod = cls.getDeclaredMethod("get", new Class[]{String.class});
            } catch (ClassNotFoundException e2) {
                e = e2;
                C5769e.m26488a(e, "CommonUtils");
                declaredMethod = null;
                if (declaredMethod != null) {
                    try {
                        return (String) declaredMethod.invoke(cls, new Object[]{str});
                    } catch (Exception e3) {
                        C5769e.m26488a(e3, "CommonUtils");
                        return null;
                    } catch (Exception e32) {
                        C5769e.m26488a(e32, "CommonUtils");
                        return null;
                    } catch (Exception e322) {
                        C5769e.m26488a(e322, "CommonUtils");
                    }
                }
                return null;
            } catch (NoSuchMethodException e4) {
                e322 = e4;
                C5769e.m26488a(e322, "CommonUtils");
                declaredMethod = null;
                if (declaredMethod != null) {
                    return (String) declaredMethod.invoke(cls, new Object[]{str});
                }
                return null;
            }
        } catch (ClassNotFoundException e5) {
            e322 = e5;
            cls = null;
            C5769e.m26488a(e322, "CommonUtils");
            declaredMethod = null;
            if (declaredMethod != null) {
                return (String) declaredMethod.invoke(cls, new Object[]{str});
            }
            return null;
        } catch (NoSuchMethodException e6) {
            e322 = e6;
            cls = null;
            C5769e.m26488a(e322, "CommonUtils");
            declaredMethod = null;
            if (declaredMethod != null) {
                return (String) declaredMethod.invoke(cls, new Object[]{str});
            }
            return null;
        }
        if (declaredMethod != null) {
            return (String) declaredMethod.invoke(cls, new Object[]{str});
        }
        return null;
    }

    private static void m26488a(Exception exception, String str) {
        if (exception != null && exception.getMessage() != null) {
            c.d(str, exception.getMessage());
        }
    }
}
