package org.apache.http.impl.client;

import com.amap.api.location.LocationManagerProxy;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.client.CircularRedirectException;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

@Immutable
public class DefaultRedirectStrategy implements RedirectStrategy {
    public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    private static final String[] REDIRECT_METHODS = new String[]{HttpGet.METHOD_NAME, HttpHead.METHOD_NAME};
    private final Log log = LogFactory.getLog(getClass());

    public boolean isRedirected(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        if (httpRequest == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (httpResponse == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        } else {
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            String method = httpRequest.getRequestLine().getMethod();
            Header firstHeader = httpResponse.getFirstHeader(LocationManagerProxy.KEY_LOCATION_CHANGED);
            switch (statusCode) {
                case 301:
                case 307:
                    return isRedirectable(method);
                case HttpStatus.SC_MOVED_TEMPORARILY /*302*/:
                    if (!isRedirectable(method) || firstHeader == null) {
                        return false;
                    }
                    return true;
                case HttpStatus.SC_SEE_OTHER /*303*/:
                    return true;
                default:
                    return false;
            }
        }
    }

    public URI getLocationURI(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        if (httpRequest == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (httpResponse == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        } else if (httpContext == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        } else {
            Header firstHeader = httpResponse.getFirstHeader(LocationManagerProxy.KEY_LOCATION_CHANGED);
            if (firstHeader == null) {
                throw new ProtocolException("Received redirect response " + httpResponse.getStatusLine() + " but no location header");
            }
            String value = firstHeader.getValue();
            if (this.log.isDebugEnabled()) {
                this.log.debug("Redirect requested to location '" + value + "'");
            }
            URI createLocationURI = createLocationURI(value);
            HttpParams params = httpRequest.getParams();
            try {
                URI rewriteURI = URIUtils.rewriteURI(createLocationURI);
                if (!rewriteURI.isAbsolute()) {
                    if (params.isParameterTrue(ClientPNames.REJECT_RELATIVE_REDIRECT)) {
                        throw new ProtocolException("Relative redirect location '" + rewriteURI + "' not allowed");
                    }
                    HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
                    if (httpHost == null) {
                        throw new IllegalStateException("Target host not available in the HTTP context");
                    }
                    rewriteURI = URIUtils.resolve(URIUtils.rewriteURI(new URI(httpRequest.getRequestLine().getUri()), httpHost, true), rewriteURI);
                }
                RedirectLocations redirectLocations = (RedirectLocations) httpContext.getAttribute(REDIRECT_LOCATIONS);
                if (redirectLocations == null) {
                    redirectLocations = new RedirectLocations();
                    httpContext.setAttribute(REDIRECT_LOCATIONS, redirectLocations);
                }
                if (params.isParameterFalse(ClientPNames.ALLOW_CIRCULAR_REDIRECTS) && redirectLocations.contains(rewriteURI)) {
                    throw new CircularRedirectException("Circular redirect to '" + rewriteURI + "'");
                }
                redirectLocations.add(rewriteURI);
                return rewriteURI;
            } catch (Throwable e) {
                throw new ProtocolException(e.getMessage(), e);
            }
        }
    }

    protected URI createLocationURI(String str) throws ProtocolException {
        try {
            return new URI(str).normalize();
        } catch (Throwable e) {
            throw new ProtocolException("Invalid redirect URI: " + str, e);
        }
    }

    protected boolean isRedirectable(String str) {
        for (String equalsIgnoreCase : REDIRECT_METHODS) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public HttpUriRequest getRedirect(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws ProtocolException {
        URI locationURI = getLocationURI(httpRequest, httpResponse, httpContext);
        String method = httpRequest.getRequestLine().getMethod();
        if (method.equalsIgnoreCase(HttpHead.METHOD_NAME)) {
            return new HttpHead(locationURI);
        }
        if (method.equalsIgnoreCase(HttpGet.METHOD_NAME)) {
            return new HttpGet(locationURI);
        }
        if (httpResponse.getStatusLine().getStatusCode() == 307) {
            if (method.equalsIgnoreCase(HttpPost.METHOD_NAME)) {
                return copyEntity(new HttpPost(locationURI), httpRequest);
            }
            if (method.equalsIgnoreCase(HttpPut.METHOD_NAME)) {
                return copyEntity(new HttpPut(locationURI), httpRequest);
            }
            if (method.equalsIgnoreCase("DELETE")) {
                return new HttpDelete(locationURI);
            }
            if (method.equalsIgnoreCase(HttpTrace.METHOD_NAME)) {
                return new HttpTrace(locationURI);
            }
            if (method.equalsIgnoreCase(HttpOptions.METHOD_NAME)) {
                return new HttpOptions(locationURI);
            }
            if (method.equalsIgnoreCase("PATCH")) {
                return copyEntity(new HttpPatch(locationURI), httpRequest);
            }
        }
        return new HttpGet(locationURI);
    }

    private HttpUriRequest copyEntity(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpRequest httpRequest) {
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            httpEntityEnclosingRequestBase.setEntity(((HttpEntityEnclosingRequest) httpRequest).getEntity());
        }
        return httpEntityEnclosingRequestBase;
    }
}
