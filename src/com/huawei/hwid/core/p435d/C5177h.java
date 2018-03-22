package com.huawei.hwid.core.p435d;

import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: HwInvoke */
public class C5177h {
    private static void m25023a(Class cls, Class[] clsArr, Object[] objArr) throws Exception {
        if (cls == null) {
            throw new Exception("class is null in staticFun");
        } else if (clsArr == null) {
            if (objArr != null) {
                throw new Exception("paramsType is null, but params is not null");
            }
        } else if (objArr == null) {
            throw new Exception("paramsType or params should be same");
        } else if (clsArr.length != objArr.length) {
            throw new Exception("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
        }
    }

    public static Object m25021a(Class cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        Object obj = null;
        C5177h.m25023a(cls, clsArr, objArr);
        try {
            try {
                obj = cls.getMethod(str, clsArr).invoke(null, objArr);
            } catch (Throwable e) {
                C5165e.m24913e("HwInvoke", e.getMessage(), e);
            } catch (Throwable e2) {
                C5165e.m24913e("HwInvoke", e2.getMessage(), e2);
            } catch (Throwable e22) {
                C5165e.m24913e("HwInvoke", e22.getMessage(), e22);
            }
        } catch (Throwable e222) {
            C5165e.m24913e("HwInvoke", e222.getMessage(), e222);
        } catch (Throwable e2222) {
            C5165e.m24911d("HwInvoke", e2222.getMessage(), e2222);
        }
        return obj;
    }

    public static Object m25022a(String str, String str2, Class[] clsArr, Object[] objArr) {
        try {
            return C5177h.m25021a(Class.forName(str), str2, clsArr, objArr);
        } catch (Throwable e) {
            C5165e.m24913e("HwInvoke", e.getMessage(), e);
            return null;
        } catch (Throwable e2) {
            C5165e.m24913e("HwInvoke", e2.getMessage(), e2);
            return null;
        } catch (Throwable e22) {
            C5165e.m24913e("HwInvoke", e22.getMessage(), e22);
            return null;
        }
    }

    public static Object m25020a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        C5177h.m25023a(cls, clsArr, objArr);
        try {
            try {
                return cls.getMethod(str, clsArr).invoke(obj, objArr);
            } catch (Throwable e) {
                C5165e.m24913e("HwInvoke", e.getMessage(), e);
                return null;
            } catch (Throwable e2) {
                C5165e.m24913e("HwInvoke", e2.getMessage(), e2);
                return null;
            } catch (Throwable e22) {
                C5165e.m24913e("HwInvoke", e22.getMessage(), e22);
                return null;
            }
        } catch (NoSuchMethodException e3) {
            throw e3;
        } catch (Throwable e222) {
            C5165e.m24911d("HwInvoke", e222.getMessage(), e222);
        }
    }
}
