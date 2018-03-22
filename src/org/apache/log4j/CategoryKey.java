package org.apache.log4j;

class CategoryKey {
    static Class class$org$apache$log4j$CategoryKey;
    int hashCache;
    String name;

    CategoryKey(String str) {
        this.name = str;
        this.hashCache = str.hashCode();
    }

    public final int hashCode() {
        return this.hashCache;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            Class class$;
            if (class$org$apache$log4j$CategoryKey == null) {
                class$ = class$("org.apache.log4j.CategoryKey");
                class$org$apache$log4j$CategoryKey = class$;
            } else {
                class$ = class$org$apache$log4j$CategoryKey;
            }
            if (class$ == obj.getClass()) {
                return this.name.equals(((CategoryKey) obj).name);
            }
        }
        return false;
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
