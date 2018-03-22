package com.squareup.leakcanary;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class ExcludedRefs implements Serializable {
    public final Map<String, Exclusion> classNames;
    public final Map<String, Map<String, Exclusion>> fieldNameByClassName;
    public final Map<String, Map<String, Exclusion>> staticFieldNameByClassName;
    public final Map<String, Exclusion> threadNames;

    public interface Builder {
        ExcludedRefs build();

        BuilderWithParams clazz(String str);

        BuilderWithParams instanceField(String str, String str2);

        BuilderWithParams staticField(String str, String str2);

        BuilderWithParams thread(String str);
    }

    public final class BuilderWithParams implements Builder {
        private final Map<String, ParamsBuilder> classNames = new LinkedHashMap();
        private final Map<String, Map<String, ParamsBuilder>> fieldNameByClassName = new LinkedHashMap();
        private ParamsBuilder lastParams;
        private final Map<String, Map<String, ParamsBuilder>> staticFieldNameByClassName = new LinkedHashMap();
        private final Map<String, ParamsBuilder> threadNames = new LinkedHashMap();

        BuilderWithParams() {
        }

        public BuilderWithParams instanceField(String str, String str2) {
            Preconditions.checkNotNull(str, "className");
            Preconditions.checkNotNull(str2, "fieldName");
            Map map = (Map) this.fieldNameByClassName.get(str);
            if (map == null) {
                map = new LinkedHashMap();
                this.fieldNameByClassName.put(str, map);
            }
            this.lastParams = new ParamsBuilder("field " + str + "#" + str2);
            map.put(str2, this.lastParams);
            return this;
        }

        public BuilderWithParams staticField(String str, String str2) {
            Preconditions.checkNotNull(str, "className");
            Preconditions.checkNotNull(str2, "fieldName");
            Map map = (Map) this.staticFieldNameByClassName.get(str);
            if (map == null) {
                map = new LinkedHashMap();
                this.staticFieldNameByClassName.put(str, map);
            }
            this.lastParams = new ParamsBuilder("static field " + str + "#" + str2);
            map.put(str2, this.lastParams);
            return this;
        }

        public BuilderWithParams thread(String str) {
            Preconditions.checkNotNull(str, "threadName");
            this.lastParams = new ParamsBuilder("any threads named " + str);
            this.threadNames.put(str, this.lastParams);
            return this;
        }

        public BuilderWithParams clazz(String str) {
            Preconditions.checkNotNull(str, "className");
            this.lastParams = new ParamsBuilder("any subclass of " + str);
            this.classNames.put(str, this.lastParams);
            return this;
        }

        public BuilderWithParams named(String str) {
            this.lastParams.name = str;
            return this;
        }

        public BuilderWithParams reason(String str) {
            this.lastParams.reason = str;
            return this;
        }

        public BuilderWithParams alwaysExclude() {
            this.lastParams.alwaysExclude = true;
            return this;
        }

        public ExcludedRefs build() {
            return new ExcludedRefs(this);
        }
    }

    final class ParamsBuilder {
        boolean alwaysExclude;
        final String matching;
        String name;
        String reason;

        ParamsBuilder(String str) {
            this.matching = str;
        }
    }

    public static Builder builder() {
        return new BuilderWithParams();
    }

    ExcludedRefs(BuilderWithParams builderWithParams) {
        this.fieldNameByClassName = unmodifiableRefStringMap(builderWithParams.fieldNameByClassName);
        this.staticFieldNameByClassName = unmodifiableRefStringMap(builderWithParams.staticFieldNameByClassName);
        this.threadNames = unmodifiableRefMap(builderWithParams.threadNames);
        this.classNames = unmodifiableRefMap(builderWithParams.classNames);
    }

    private Map<String, Map<String, Exclusion>> unmodifiableRefStringMap(Map<String, Map<String, ParamsBuilder>> map) {
        Map linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), unmodifiableRefMap((Map) entry.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    private Map<String, Exclusion> unmodifiableRefMap(Map<String, ParamsBuilder> map) {
        Map linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), new Exclusion((ParamsBuilder) entry.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        String str = "";
        for (Entry entry : this.fieldNameByClassName.entrySet()) {
            String str2 = (String) entry.getKey();
            for (Entry entry2 : ((Map) entry2.getValue()).entrySet()) {
                str = str + "| Field: " + str2 + "." + ((String) entry2.getKey()) + (((Exclusion) entry2.getValue()).alwaysExclude ? " (always)" : "") + "\n";
            }
        }
        for (Entry entry22 : this.staticFieldNameByClassName.entrySet()) {
            String str3 = (String) entry22.getKey();
            for (Entry entry222 : ((Map) entry222.getValue()).entrySet()) {
                str = str + "| Static field: " + str3 + "." + ((String) entry222.getKey()) + (((Exclusion) entry222.getValue()).alwaysExclude ? " (always)" : "") + "\n";
            }
        }
        for (Entry entry2222 : this.threadNames.entrySet()) {
            str = str + "| Thread:" + ((String) entry2222.getKey()) + (((Exclusion) entry2222.getValue()).alwaysExclude ? " (always)" : "") + "\n";
        }
        for (Entry entry22222 : this.classNames.entrySet()) {
            str = str + "| Class:" + ((String) entry22222.getKey()) + (((Exclusion) entry22222.getValue()).alwaysExclude ? " (always)" : "") + "\n";
        }
        return str;
    }
}
