package org.apache.http.client.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Stack;
import org.apache.http.HttpHost;
import org.apache.http.annotation.Immutable;
import org.apache.log4j.spi.LocationInfo;

@Immutable
public class URIUtils {
    @Deprecated
    public static URI createURI(String str, String str2, int i, String str3, String str4, String str5) throws URISyntaxException {
        StringBuilder stringBuilder = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                stringBuilder.append(str);
                stringBuilder.append("://");
            }
            stringBuilder.append(str2);
            if (i > 0) {
                stringBuilder.append(':');
                stringBuilder.append(i);
            }
        }
        if (str3 == null || !str3.startsWith("/")) {
            stringBuilder.append('/');
        }
        if (str3 != null) {
            stringBuilder.append(str3);
        }
        if (str4 != null) {
            stringBuilder.append('?');
            stringBuilder.append(str4);
        }
        if (str5 != null) {
            stringBuilder.append('#');
            stringBuilder.append(str5);
        }
        return new URI(stringBuilder.toString());
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost, boolean z) throws URISyntaxException {
        if (uri == null) {
            throw new IllegalArgumentException("URI may not be null");
        }
        URIBuilder uRIBuilder = new URIBuilder(uri);
        if (httpHost != null) {
            uRIBuilder.setScheme(httpHost.getSchemeName());
            uRIBuilder.setHost(httpHost.getHostName());
            uRIBuilder.setPort(httpHost.getPort());
        } else {
            uRIBuilder.setScheme(null);
            uRIBuilder.setHost(null);
            uRIBuilder.setPort(-1);
        }
        if (z) {
            uRIBuilder.setFragment(null);
        }
        return uRIBuilder.build();
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost) throws URISyntaxException {
        return rewriteURI(uri, httpHost, false);
    }

    public static URI rewriteURI(URI uri) throws URISyntaxException {
        if (uri == null) {
            throw new IllegalArgumentException("URI may not be null");
        } else if (uri.getFragment() == null && uri.getUserInfo() == null) {
            return uri;
        } else {
            return new URIBuilder(uri).setFragment(null).setUserInfo(null).build();
        }
    }

    public static URI resolve(URI uri, String str) {
        return resolve(uri, URI.create(str));
    }

    public static URI resolve(URI uri, URI uri2) {
        if (uri == null) {
            throw new IllegalArgumentException("Base URI may nor be null");
        } else if (uri2 == null) {
            throw new IllegalArgumentException("Reference URI may nor be null");
        } else {
            String uri3 = uri2.toString();
            if (uri3.startsWith(LocationInfo.NA)) {
                return resolveReferenceStartingWithQueryString(uri, uri2);
            }
            int i = uri3.length() == 0 ? 1 : 0;
            if (i != 0) {
                uri2 = URI.create("#");
            }
            URI resolve = uri.resolve(uri2);
            if (i != 0) {
                uri3 = resolve.toString();
                resolve = URI.create(uri3.substring(0, uri3.indexOf(35)));
            }
            return removeDotSegments(resolve);
        }
    }

    private static URI resolveReferenceStartingWithQueryString(URI uri, URI uri2) {
        String uri3 = uri.toString();
        if (uri3.indexOf(63) > -1) {
            uri3 = uri3.substring(0, uri3.indexOf(63));
        }
        return URI.create(uri3 + uri2.toString());
    }

    private static URI removeDotSegments(URI uri) {
        String path = uri.getPath();
        if (path == null || path.indexOf("/.") == -1) {
            return uri;
        }
        String[] split = path.split("/");
        Stack stack = new Stack();
        int i = 0;
        while (i < split.length) {
            if (!(split[i].length() == 0 || ".".equals(split[i]))) {
                if (!"..".equals(split[i])) {
                    stack.push(split[i]);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            stringBuilder.append('/').append((String) it.next());
        }
        try {
            return new URI(uri.getScheme(), uri.getAuthority(), stringBuilder.toString(), uri.getQuery(), uri.getFragment());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static HttpHost extractHost(URI uri) {
        if (uri == null) {
            return null;
        }
        HttpHost httpHost;
        if (uri.isAbsolute()) {
            int port = uri.getPort();
            String host = uri.getHost();
            if (host == null) {
                host = uri.getAuthority();
                if (host != null) {
                    String str;
                    int indexOf = host.indexOf(64);
                    if (indexOf < 0) {
                        str = host;
                    } else if (host.length() > indexOf + 1) {
                        str = host.substring(indexOf + 1);
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        int indexOf2 = str.indexOf(58);
                        if (indexOf2 >= 0) {
                            indexOf = indexOf2 + 1;
                            int i = indexOf;
                            int i2 = 0;
                            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                                i2++;
                                i++;
                            }
                            if (i2 > 0) {
                                try {
                                    i = Integer.parseInt(str.substring(indexOf, indexOf + i2));
                                } catch (NumberFormatException e) {
                                    i = port;
                                }
                            } else {
                                i = port;
                            }
                            port = i;
                            host = str.substring(0, indexOf2);
                        }
                    }
                    host = str;
                }
            }
            String scheme = uri.getScheme();
            if (host != null) {
                httpHost = new HttpHost(host, port, scheme);
                return httpHost;
            }
        }
        httpHost = null;
        return httpHost;
    }

    private URIUtils() {
    }
}
