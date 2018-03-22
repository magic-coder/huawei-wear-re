package com.p252d.p253a.p254a;

import com.amap.api.location.LocationManagerProxy;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.impl.client.RedirectLocations;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/* compiled from: MyRedirectHandler */
class C3556m extends DefaultRedirectHandler {
    private final boolean f13563a;

    public C3556m(boolean z) {
        this.f13563a = z;
    }

    public boolean isRedirectRequested(HttpResponse httpResponse, HttpContext httpContext) {
        if (!this.f13563a) {
            return false;
        }
        if (httpResponse == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        switch (httpResponse.getStatusLine().getStatusCode()) {
            case 301:
            case HttpStatus.SC_MOVED_TEMPORARILY /*302*/:
            case HttpStatus.SC_SEE_OTHER /*303*/:
            case 307:
                return true;
            default:
                return false;
        }
    }

    public URI getLocationURI(HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        if (httpResponse == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        Header firstHeader = httpResponse.getFirstHeader(LocationManagerProxy.KEY_LOCATION_CHANGED);
        if (firstHeader == null) {
            throw new ProtocolException("Received redirect response " + httpResponse.getStatusLine() + " but no location header");
        }
        String replaceAll = firstHeader.getValue().replaceAll(HwAccountConstants.BLANK, "%20");
        try {
            URI uri;
            URI uri2 = new URI(replaceAll);
            HttpParams params = httpResponse.getParams();
            if (uri2.isAbsolute()) {
                uri = uri2;
            } else if (params.isParameterTrue(ClientPNames.REJECT_RELATIVE_REDIRECT)) {
                throw new ProtocolException("Relative redirect location '" + uri2 + "' not allowed");
            } else {
                HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
                if (httpHost == null) {
                    throw new IllegalStateException("Target host not available in the HTTP context");
                }
                try {
                    uri = URIUtils.resolve(URIUtils.rewriteURI(new URI(((HttpRequest) httpContext.getAttribute("http.request")).getRequestLine().getUri()), httpHost, true), uri2);
                } catch (Throwable e) {
                    throw new ProtocolException(e.getMessage(), e);
                }
            }
            if (params.isParameterFalse(ClientPNames.ALLOW_CIRCULAR_REDIRECTS)) {
                RedirectLocations redirectLocations = (RedirectLocations) httpContext.getAttribute(DefaultRedirectStrategy.REDIRECT_LOCATIONS);
                if (redirectLocations == null) {
                    redirectLocations = new RedirectLocations();
                    httpContext.setAttribute(DefaultRedirectStrategy.REDIRECT_LOCATIONS, redirectLocations);
                }
                if (uri.getFragment() != null) {
                    try {
                        uri2 = URIUtils.rewriteURI(uri, new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme()), true);
                    } catch (Throwable e2) {
                        throw new ProtocolException(e2.getMessage(), e2);
                    }
                }
                uri2 = uri;
                if (redirectLocations.contains(uri2)) {
                    throw new CircularRedirectException("Circular redirect to '" + uri2 + "'");
                }
                redirectLocations.add(uri2);
            }
            return uri;
        } catch (Throwable e22) {
            throw new ProtocolException("Invalid redirect URI: " + replaceAll, e22);
        }
    }
}
