package com.aps;

/* compiled from: Reflect */
public class bl {
    public static Object m17421a(Object obj, String str, Object... objArr) throws Exception {
        Class cls = obj.getClass();
        Class[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return cls.getMethod(str, clsArr).invoke(obj, objArr);
    }

    public static int m17422b(Object obj, String str, Object... objArr) throws Exception {
        Class cls = obj.getClass();
        Class[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return ((Integer) cls.getMethod(str, clsArr).invoke(obj, objArr)).intValue();
    }
}
