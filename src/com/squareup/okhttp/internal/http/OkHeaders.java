package com.squareup.okhttp.internal.http;

import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.http.auth.AUTH;
import org.apache.http.cookie.SM;

public final class OkHeaders {
    private static final Comparator<String> FIELD_NAME_COMPARATOR = new C26371();
    static final String PREFIX = Platform.get().getPrefix();
    public static final String RECEIVED_MILLIS = (PREFIX + "-Received-Millis");
    public static final String SELECTED_PROTOCOL = (PREFIX + "-Selected-Protocol");
    public static final String SENT_MILLIS = (PREFIX + "-Sent-Millis");

    final class C26371 implements Comparator<String> {
        C26371() {
        }

        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    }

    private OkHeaders() {
    }

    public static long contentLength(Request request) {
        return contentLength(request.headers());
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }

    private static long stringToLong(String str) {
        long j = -1;
        if (str != null) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public static Map<String, List<String>> toMultimap(Headers headers, String str) {
        Map treeMap = new TreeMap(FIELD_NAME_COMPARATOR);
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            List arrayList = new ArrayList();
            List list = (List) treeMap.get(name);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(value);
            treeMap.put(name, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public static void addCookies(Builder builder, Map<String, List<String>> map) {
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (("Cookie".equalsIgnoreCase(str) || SM.COOKIE2.equalsIgnoreCase(str)) && !((List) entry.getValue()).isEmpty()) {
                builder.addHeader(str, buildCookieHeader((List) entry.getValue()));
            }
        }
    }

    private static String buildCookieHeader(List<String> list) {
        if (list.size() == 1) {
            return (String) list.get(0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append("; ");
            }
            stringBuilder.append((String) list.get(i));
        }
        return stringBuilder.toString();
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String str : varyFields(response)) {
            if (!Util.equal(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasVaryAll(Response response) {
        return varyFields(response).contains("*");
    }

    private static Set<String> varyFields(Response response) {
        Set<String> emptySet = Collections.emptySet();
        Headers headers = response.headers();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(headers.name(i))) {
                String value = headers.value(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : value.split(",")) {
                    emptySet.add(trim.trim());
                }
            }
        }
        return emptySet;
    }

    public static Headers varyHeaders(Response response) {
        Set varyFields = varyFields(response);
        if (varyFields.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers headers = response.networkResponse().request().headers();
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            if (varyFields.contains(name)) {
                builder.add(name, headers.value(i));
            }
        }
        return builder.build();
    }

    static boolean isEndToEnd(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || AUTH.PROXY_AUTH.equalsIgnoreCase(str) || AUTH.PROXY_AUTH_RESP.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        List<Challenge> arrayList = new ArrayList();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(headers.name(i))) {
                String value = headers.value(i);
                int i2 = 0;
                while (i2 < value.length()) {
                    int skipUntil = HeaderParser.skipUntil(value, i2, HwAccountConstants.BLANK);
                    String trim = value.substring(i2, skipUntil).trim();
                    skipUntil = HeaderParser.skipWhitespace(value, skipUntil);
                    if (!value.regionMatches(true, skipUntil, "realm=\"", 0, "realm=\"".length())) {
                        break;
                    }
                    i2 = "realm=\"".length() + skipUntil;
                    skipUntil = HeaderParser.skipUntil(value, i2, "\"");
                    String substring = value.substring(i2, skipUntil);
                    i2 = HeaderParser.skipWhitespace(value, HeaderParser.skipUntil(value, skipUntil + 1, ",") + 1);
                    arrayList.add(new Challenge(trim, substring));
                }
            }
        }
        return arrayList;
    }

    public static Request processAuthHeader(Authenticator authenticator, Response response, Proxy proxy) throws IOException {
        if (response.code() == HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED) {
            return authenticator.authenticateProxy(proxy, response);
        }
        return authenticator.authenticate(proxy, response);
    }
}
