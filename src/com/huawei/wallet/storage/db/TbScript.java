package com.huawei.wallet.storage.db;

public class TbScript {
    public static final String m28127a(String str, Class<?> cls) {
        String[] a = m28128a(1, str);
        if (a == null || a.length <= 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                stringBuilder.append(" ( ");
                stringBuilder.append(a[i]);
                stringBuilder.append(" TEXT NOT NULL PRIMARY KEY ");
            } else {
                stringBuilder.append(a[i]);
                stringBuilder.append(" TEXT NOT NULL ");
            }
            if (i != a.length - 1) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append(" ) ");
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder(512);
        stringBuilder2.append("CREATE TABLE IF NOT EXISTS ");
        stringBuilder2.append(str);
        stringBuilder2.append(stringBuilder.toString());
        return stringBuilder2.toString();
    }

    public static final String m28126a(String str) {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("DROP TABLE ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private static final String[] m28128a(int i, String str) {
        Object obj = null;
        if ("unicard".equals(str)) {
            obj = new String[]{"productID", "name", "description", "type", "extType", "cardNum", "virCardNum", "issuerID", "logoPicLocalPath", "logoPicUrl", "pictureLocalPath", "pictureUrl", "mktDesc", "mktUrl", "timestamp"};
        } else if ("bankapp".equals(str)) {
            obj = new String[]{"productID", "logoPicLocalPath", "logoPicUrl", "appID", "pkgName", "hotLine", "name"};
        }
        if (2 != i) {
            return obj;
        }
        if (obj == null) {
            return null;
        }
        Object obj2 = new String[(obj.length - 1)];
        System.arraycopy(obj, 1, obj2, 0, obj.length - 1);
        return obj2;
    }
}
