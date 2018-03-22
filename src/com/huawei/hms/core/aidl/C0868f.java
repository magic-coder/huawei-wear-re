package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.huawei.hms.core.aidl.p040a.C0860a;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessageCodec */
public class C0868f {
    public IMessageEntity m3051a(Bundle bundle, IMessageEntity iMessageEntity) {
        if (bundle != null) {
            for (Class cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isAnnotationPresent(C0860a.class)) {
                        try {
                            m3047a(iMessageEntity, field, bundle);
                        } catch (IllegalAccessException e) {
                        } catch (IllegalArgumentException e2) {
                        }
                    }
                }
            }
        }
        return iMessageEntity;
        Log.e("MessageCodec", "decode, set value of the field exception, field name:" + field.getName());
    }

    private void m3047a(IMessageEntity iMessageEntity, Field field, Bundle bundle) throws IllegalAccessException {
        Object a = m3046a(field, bundle);
        if (a != null) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            field.set(iMessageEntity, a);
            field.setAccessible(isAccessible);
        }
    }

    private Object m3046a(Field field, Bundle bundle) {
        String name = field.getName();
        Object obj = bundle.get(name);
        if (!(obj instanceof Bundle)) {
            return obj;
        }
        try {
            Bundle bundle2 = (Bundle) obj;
            int i = bundle2.getInt("_val_type_", -1);
            if (i == 1) {
                return mo2246a(field.getGenericType(), bundle2);
            }
            if (i != 0) {
                return obj;
            }
            return m3051a((Bundle) obj, (IMessageEntity) field.getType().newInstance());
        } catch (Exception e) {
            Log.e("MessageCodec", "decode, read value of the field exception, field name: " + name);
            return null;
        }
    }

    protected List<Object> mo2246a(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        List<Object> arrayList = new ArrayList();
        for (Bundle bundle2 = bundle.getBundle("_next_item_"); bundle2 != null; bundle2 = bundle2.getBundle("_next_item_")) {
            Object obj = bundle2.get("_value_");
            if (obj.getClass().isPrimitive() || (obj instanceof String) || (obj instanceof Serializable)) {
                arrayList.add(obj);
            } else if (obj instanceof Bundle) {
                Bundle bundle3 = (Bundle) obj;
                int i = bundle3.getInt("_val_type_", -1);
                if (i == 1) {
                    throw new InstantiationException("Nested List can not be supported");
                } else if (i == 0) {
                    arrayList.add(m3051a(bundle3, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                } else {
                    throw new InstantiationException("Unknown type can not be supported");
                }
            } else {
                continue;
            }
        }
        return arrayList;
    }

    public Bundle m3050a(IMessageEntity iMessageEntity, Bundle bundle) {
        for (Class cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(C0860a.class)) {
                    try {
                        m3048b(iMessageEntity, field, bundle);
                    } catch (IllegalAccessException e) {
                    } catch (IllegalArgumentException e2) {
                    }
                }
            }
        }
        return bundle;
        Log.e("MessageCodec", "encode, get value of the field exception, field name: " + field.getName());
    }

    private void m3048b(IMessageEntity iMessageEntity, Field field, Bundle bundle) throws IllegalAccessException {
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        m3053a(field.getName(), field.get(iMessageEntity), bundle);
        field.setAccessible(isAccessible);
    }

    protected void m3053a(String str, Object obj, Bundle bundle) {
        if (obj != null && !m3049b(str, obj, bundle)) {
            if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof List) {
                mo2247a(str, (List) obj, bundle);
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (obj instanceof IMessageEntity) {
                Bundle a = m3050a((IMessageEntity) obj, new Bundle());
                a.putInt("_val_type_", 0);
                bundle.putBundle(str, a);
            } else {
                Log.e("MessageCodec", "cannot support type, " + str);
            }
        }
    }

    protected void mo2247a(String str, List list, Bundle bundle) {
        Bundle bundle2 = null;
        for (Object next : list) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(str, bundle2);
                bundle2.putInt("_val_type_", 1);
            }
            bundle2 = m3045a("_value_", bundle2, next);
        }
    }

    private Bundle m3045a(String str, Bundle bundle, Object obj) {
        Bundle bundle2 = new Bundle();
        m3053a(str, obj, bundle2);
        bundle.putBundle("_next_item_", bundle2);
        return bundle2;
    }

    private boolean m3049b(String str, Object obj, Bundle bundle) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            bundle.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (!(obj instanceof Boolean)) {
            return false;
        } else {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        }
        return true;
    }
}
