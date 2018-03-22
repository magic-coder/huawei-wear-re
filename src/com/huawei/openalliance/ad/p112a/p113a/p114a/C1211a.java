package com.huawei.openalliance.ad.p112a.p113a.p114a;

import com.huawei.openalliance.ad.utils.C1362f;
import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class C1211a {
    private static final char COMMA = ',';
    public static final String END_FLAG = "__";
    private static final String TAG = "JsonBean";

    private String arrayToJson(Object obj) throws IllegalAccessException, IllegalArgumentException {
        int length = Array.getLength(obj);
        if (length <= 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < length; i++) {
            String valueToJson = valueToJson(Array.get(obj, i));
            if (valueToJson != null) {
                stringBuilder.append(valueToJson).append(COMMA);
            }
        }
        formatJsonStr(stringBuilder);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private void formatJsonStr(StringBuilder stringBuilder) {
        int length = stringBuilder.length();
        if (length > 0 && stringBuilder.charAt(length - 1) == COMMA) {
            stringBuilder.delete(length - 1, length);
        }
    }

    private Object jsonBeanFromJson(Class cls, Object obj) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, JSONException {
        C1211a c1211a = (C1211a) cls.newInstance();
        c1211a.fromJson((JSONObject) obj);
        return c1211a;
    }

    private String mapToJson(Map map) throws IllegalAccessException, IllegalArgumentException {
        if (map.size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        Set<Entry> entrySet = map.entrySet();
        int size = entrySet.size();
        int i = 0;
        for (Entry entry : entrySet) {
            int i2 = i + 1;
            String str = (String) entry.getKey();
            String valueToJson = valueToJson(entry.getValue());
            if (valueToJson != null) {
                stringBuilder.append("\"").append(str).append("\":");
                stringBuilder.append(valueToJson);
            }
            if (i2 < size && valueToJson != null) {
                stringBuilder.append(COMMA);
            }
            i = i2;
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void processValueError(Field field, Object obj) {
        if (obj != null && (obj instanceof String)) {
            try {
                Class type = field.getType();
                if (type.isPrimitive()) {
                    String name = type.getName();
                    if ("int".equals(name)) {
                        field.set(this, Integer.valueOf(Integer.parseInt((String) obj)));
                    } else if ("float".equals(name)) {
                        field.set(this, Float.valueOf(Float.parseFloat((String) obj)));
                    } else if ("long".equals(name)) {
                        field.set(this, Long.valueOf(Long.parseLong((String) obj)));
                    } else if ("boolean".equals(name)) {
                        field.set(this, Boolean.valueOf(Boolean.parseBoolean((String) obj)));
                    } else if ("double".equals(name)) {
                        field.set(this, Double.valueOf(Double.parseDouble((String) obj)));
                    } else if ("short".equals(name)) {
                        field.set(this, Short.valueOf(Short.parseShort((String) obj)));
                    } else if ("byte".equals(name)) {
                        field.set(this, Byte.valueOf(Byte.parseByte((String) obj)));
                    } else if ("char".equals(name)) {
                        field.set(this, Character.valueOf(((String) obj).charAt(0)));
                    }
                }
            } catch (Throwable th) {
                C1336d.m5890d(TAG, "processValueError");
            }
        }
    }

    private Object valueFromJson(Class cls, Class cls2, Object obj) throws IllegalAccessException, IllegalArgumentException, InstantiationException, ClassNotFoundException, JSONException {
        if (cls.isPrimitive() || cls.isAssignableFrom(String.class)) {
            return ("float".equals(cls.getName()) && (obj instanceof Double)) ? Float.valueOf(((Double) obj).floatValue()) : obj;
        } else {
            if (List.class.isAssignableFrom(cls)) {
                return listFromJson(cls2, obj);
            }
            if (C1211a.class.isAssignableFrom(cls)) {
                if (!cls.isAssignableFrom(C1211a.class)) {
                    return jsonBeanFromJson(cls, obj);
                }
                throw new IllegalArgumentException("error type, type:" + cls);
            } else if (Map.class.isAssignableFrom(cls)) {
                return mapFromJson(cls2, obj);
            } else {
                throw new IllegalArgumentException("unsupport type, Type:" + cls);
            }
        }
    }

    private String valueToJson(Object obj) throws IllegalAccessException, IllegalArgumentException {
        return obj == null ? null : obj instanceof String ? "\"" + obj.toString() + "\"" : ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Short)) ? String.valueOf(obj) : obj instanceof C1211a ? ((C1211a) obj).toJson() : obj instanceof List ? listToJson((List) obj) : obj instanceof Map ? mapToJson((Map) obj) : obj.getClass().isArray() ? arrayToJson(obj) : null;
    }

    public void fromJson(JSONObject jSONObject) throws IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException, JSONException {
        Field[] a = C1362f.m6071a(getClass());
        Object obj = null;
        for (int i = 0; i < a.length; i++) {
            a[i].setAccessible(true);
            String name = a[i].getName();
            if (name.endsWith(END_FLAG)) {
                String substring = name.substring(0, name.length() - END_FLAG.length());
                if (jSONObject.has(substring)) {
                    Object obj2 = jSONObject.get(substring);
                    if (JSONObject.NULL.equals(obj2)) {
                        continue;
                    } else {
                        try {
                            obj = valueFromJson(a[i].getType(), C1362f.m6069a(a[i]), obj2);
                            a[i].set(this, obj);
                        } catch (RuntimeException e) {
                            throw e;
                        } catch (Throwable e2) {
                            C1336d.m5883a(TAG, getClass().getName() + ".fromJson error, fieldName:" + substring + ", field:" + a[i], e2);
                            processValueError(a[i], obj);
                        }
                    }
                } else {
                    continue;
                }
            }
        }
    }

    protected Object listFromJson(Class cls, Object obj) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, JSONException {
        if (cls == null) {
            throw new IllegalArgumentException("generic type is null");
        } else if (obj instanceof JSONArray) {
            List arrayList = new ArrayList();
            JSONArray jSONArray = (JSONArray) obj;
            for (int i = 0; i < jSONArray.length(); i++) {
                Object valueFromJson = valueFromJson(cls, null, jSONArray.get(i));
                if (valueFromJson != null) {
                    if (cls.isAssignableFrom(valueFromJson.getClass())) {
                        arrayList.add(valueFromJson);
                    } else {
                        C1336d.m5890d(TAG, "listFromJson error, memberClass:" + cls + ", valueClass:" + valueFromJson.getClass());
                    }
                }
            }
            return arrayList;
        } else {
            throw new IllegalArgumentException("jsonobject is not JSONArray");
        }
    }

    protected String listToJson(List list) throws IllegalAccessException, IllegalArgumentException {
        if (list.size() <= 0) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < list.size(); i++) {
            String valueToJson = valueToJson(list.get(i));
            if (valueToJson != null) {
                stringBuilder.append(valueToJson).append(COMMA);
            }
        }
        formatJsonStr(stringBuilder);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected Object mapFromJson(Class cls, Object obj) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, JSONException {
        if (cls == null) {
            throw new IllegalArgumentException("generic type is null");
        } else if (obj instanceof JSONObject) {
            Map linkedHashMap = new LinkedHashMap();
            JSONObject jSONObject = (JSONObject) obj;
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                Object valueFromJson = valueFromJson(cls, null, jSONObject.get(str));
                if (valueFromJson != null) {
                    if (cls.isAssignableFrom(valueFromJson.getClass())) {
                        linkedHashMap.put(str, valueFromJson);
                    } else {
                        C1336d.m5890d(TAG, "mapFromJson error, memberClass:" + cls + ", valueClass:" + valueFromJson.getClass());
                    }
                }
            }
            return linkedHashMap;
        } else {
            throw new IllegalArgumentException("jsonobject is not JSONObject");
        }
    }

    public String toJson() throws IllegalAccessException, IllegalArgumentException {
        Field[] a = C1362f.m6071a(getClass());
        if (a.length <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i < a.length; i++) {
            a[i].setAccessible(true);
            String name = a[i].getName();
            if (name != null && name.endsWith(END_FLAG)) {
                name = name.substring(0, name.length() - END_FLAG.length());
                String valueToJson = valueToJson(a[i].get(this));
                if (valueToJson != null) {
                    stringBuilder.append("\"").append(name).append("\":").append(valueToJson).append(COMMA);
                }
            }
        }
        formatJsonStr(stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
