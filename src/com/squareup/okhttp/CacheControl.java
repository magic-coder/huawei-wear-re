package com.squareup.okhttp;

import com.squareup.okhttp.internal.http.HeaderParser;
import java.util.concurrent.TimeUnit;
import org.apache.http.cookie.ClientCookie;

public final class CacheControl {
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    public final class Builder {
        int maxAgeSeconds = -1;
        int maxStaleSeconds = -1;
        int minFreshSeconds = -1;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public Builder noCache() {
            this.noCache = true;
            return this;
        }

        public Builder noStore() {
            this.noStore = true;
            return this;
        }

        public Builder maxAge(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxAge < 0: " + i);
            }
            long toSeconds = timeUnit.toSeconds((long) i);
            this.maxAgeSeconds = toSeconds > 2147483647L ? Integer.MAX_VALUE : (int) toSeconds;
            return this;
        }

        public Builder maxStale(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + i);
            }
            long toSeconds = timeUnit.toSeconds((long) i);
            this.maxStaleSeconds = toSeconds > 2147483647L ? Integer.MAX_VALUE : (int) toSeconds;
            return this;
        }

        public Builder minFresh(int i, TimeUnit timeUnit) {
            if (i < 0) {
                throw new IllegalArgumentException("minFresh < 0: " + i);
            }
            long toSeconds = timeUnit.toSeconds((long) i);
            this.minFreshSeconds = toSeconds > 2147483647L ? Integer.MAX_VALUE : (int) toSeconds;
            return this;
        }

        public Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }

        public Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public CacheControl build() {
            return new CacheControl();
        }
    }

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, int i3, int i4, boolean z5, boolean z6) {
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i;
        this.sMaxAgeSeconds = i2;
        this.isPublic = z3;
        this.mustRevalidate = z4;
        this.maxStaleSeconds = i3;
        this.minFreshSeconds = i4;
        this.onlyIfCached = z5;
        this.noTransform = z6;
    }

    private CacheControl(Builder builder) {
        this.noCache = builder.noCache;
        this.noStore = builder.noStore;
        this.maxAgeSeconds = builder.maxAgeSeconds;
        this.sMaxAgeSeconds = -1;
        this.isPublic = false;
        this.mustRevalidate = false;
        this.maxStaleSeconds = builder.maxStaleSeconds;
        this.minFreshSeconds = builder.minFreshSeconds;
        this.onlyIfCached = builder.onlyIfCached;
        this.noTransform = builder.noTransform;
    }

    public boolean noCache() {
        return this.noCache;
    }

    public boolean noStore() {
        return this.noStore;
    }

    public int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public boolean noTransform() {
        return this.noTransform;
    }

    public static CacheControl parse(Headers headers) {
        boolean z = false;
        boolean z2 = false;
        int i = -1;
        int i2 = -1;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = -1;
        int i4 = -1;
        boolean z5 = false;
        boolean z6 = false;
        int size = headers.size();
        int i5 = 0;
        while (i5 < size) {
            if (headers.name(i5).equalsIgnoreCase("Cache-Control") || headers.name(i5).equalsIgnoreCase("Pragma")) {
                String value = headers.value(i5);
                int i6 = 0;
                while (i6 < value.length()) {
                    String str;
                    int skipUntil = HeaderParser.skipUntil(value, i6, "=,;");
                    String trim = value.substring(i6, skipUntil).trim();
                    if (skipUntil == value.length() || value.charAt(skipUntil) == ',' || value.charAt(skipUntil) == ';') {
                        i6 = skipUntil + 1;
                        str = null;
                    } else {
                        i6 = HeaderParser.skipWhitespace(value, skipUntil + 1);
                        String trim2;
                        if (i6 >= value.length() || value.charAt(i6) != '\"') {
                            skipUntil = HeaderParser.skipUntil(value, i6, ",;");
                            trim2 = value.substring(i6, skipUntil).trim();
                            i6 = skipUntil;
                            str = trim2;
                        } else {
                            i6++;
                            skipUntil = HeaderParser.skipUntil(value, i6, "\"");
                            trim2 = value.substring(i6, skipUntil);
                            i6 = skipUntil + 1;
                            str = trim2;
                        }
                    }
                    if ("no-cache".equalsIgnoreCase(trim)) {
                        z = true;
                    } else if ("no-store".equalsIgnoreCase(trim)) {
                        z2 = true;
                    } else if (ClientCookie.MAX_AGE_ATTR.equalsIgnoreCase(trim)) {
                        i = HeaderParser.parseSeconds(str, -1);
                    } else if ("s-maxage".equalsIgnoreCase(trim)) {
                        i2 = HeaderParser.parseSeconds(str, -1);
                    } else if ("public".equalsIgnoreCase(trim)) {
                        z3 = true;
                    } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                        z4 = true;
                    } else if ("max-stale".equalsIgnoreCase(trim)) {
                        i3 = HeaderParser.parseSeconds(str, Integer.MAX_VALUE);
                    } else if ("min-fresh".equalsIgnoreCase(trim)) {
                        i4 = HeaderParser.parseSeconds(str, -1);
                    } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                        z5 = true;
                    } else if ("no-transform".equalsIgnoreCase(trim)) {
                        z6 = true;
                    }
                }
            }
            i5++;
        }
        return new CacheControl(z, z2, i, i2, z3, z4, i3, i4, z5, z6);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.noCache) {
            stringBuilder.append("no-cache, ");
        }
        if (this.noStore) {
            stringBuilder.append("no-store, ");
        }
        if (this.maxAgeSeconds != -1) {
            stringBuilder.append("max-age=").append(this.maxAgeSeconds).append(", ");
        }
        if (this.sMaxAgeSeconds != -1) {
            stringBuilder.append("s-maxage=").append(this.sMaxAgeSeconds).append(", ");
        }
        if (this.isPublic) {
            stringBuilder.append("public, ");
        }
        if (this.mustRevalidate) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.maxStaleSeconds != -1) {
            stringBuilder.append("max-stale=").append(this.maxStaleSeconds).append(", ");
        }
        if (this.minFreshSeconds != -1) {
            stringBuilder.append("min-fresh=").append(this.minFreshSeconds).append(", ");
        }
        if (this.onlyIfCached) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.noTransform) {
            stringBuilder.append("no-transform, ");
        }
        if (stringBuilder.length() == 0) {
            return "";
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }
}
