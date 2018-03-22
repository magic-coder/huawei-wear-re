package com.p230a.p231b.p237c;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class C3129b {
    public static JsonObject m13932a(String str) {
        return new JsonParser().parse(str).getAsJsonObject();
    }

    public static List m13933a(JsonArray jsonArray) {
        List arrayList = new ArrayList();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonElement jsonElement = jsonArray.get(i);
            if (jsonElement instanceof JsonArray) {
                arrayList.add(C3129b.m13933a((JsonArray) jsonElement));
            } else if (jsonElement instanceof JsonObject) {
                arrayList.add(C3129b.m13934a((JsonObject) jsonElement));
            } else {
                arrayList.add(jsonElement);
            }
        }
        return arrayList;
    }

    public static Map m13934a(JsonObject jsonObject) {
        Map hashMap = new HashMap();
        for (Entry entry : jsonObject.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof JsonArray) {
                hashMap.put(str, C3129b.m13933a((JsonArray) value));
            } else if (value instanceof JsonObject) {
                hashMap.put(str, C3129b.m13934a((JsonObject) value));
            } else if (value instanceof JsonNull) {
                hashMap.put(str, "");
            } else {
                hashMap.put(str, ((JsonElement) entry.getValue()).getAsString());
            }
        }
        return hashMap;
    }

    public static Map m13935b(String str) {
        return C3129b.m13934a(C3129b.m13932a(str));
    }
}
