package com.huawei.appmarket.sdk.foundation.p367e;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class C4286c {
    private static final String f15970a = C4286c.class.getSimpleName();

    public static Field[] m20691a(Class cls) {
        Object obj = null;
        if (cls.getSuperclass() != null) {
            obj = C4286c.m20691a(cls.getSuperclass());
        }
        Object declaredFields = cls.getDeclaredFields();
        if (obj == null || obj.length <= 0) {
            obj = declaredFields;
        } else {
            Object obj2 = new Field[(declaredFields.length + obj.length)];
            System.arraycopy(obj, 0, obj2, 0, obj.length);
            System.arraycopy(declaredFields, 0, obj2, obj.length, declaredFields.length);
            Field[] fieldArr = obj2;
        }
        List arrayList = new ArrayList();
        for (Field field : fieldArr) {
            if (field.getName().indexOf("$") < 0) {
                arrayList.add(field);
            }
        }
        if (arrayList.size() == fieldArr.length) {
            return fieldArr;
        }
        fieldArr = new Field[arrayList.size()];
        arrayList.toArray(fieldArr);
        return fieldArr;
    }
}
