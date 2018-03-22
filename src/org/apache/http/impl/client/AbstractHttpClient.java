package org.apache.http.impl.client;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.AuthenticationStrategy;
import org.apache.http.client.BackoffManager;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ConnectionBackoffStrategy;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.AuthPolicy;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.auth.BasicSchemeFactory;
import org.apache.http.impl.auth.DigestSchemeFactory;
import org.apache.http.impl.auth.KerberosSchemeFactory;
import org.apache.http.impl.auth.NTLMSchemeFactory;
import org.apache.http.impl.auth.SPNegoSchemeFactory;
import org.apache.http.impl.conn.BasicClientConnectionManager;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SchemeRegistryFactory;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.impl.cookie.IgnoreSpecFactory;
import org.apache.http.impl.cookie.NetscapeDraftSpecFactory;
import org.apache.http.impl.cookie.RFC2109SpecFactory;
import org.apache.http.impl.cookie.RFC2965SpecFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.DefaultedHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.ImmutableHttpProcessor;
import org.apache.http.util.EntityUtils;

@ThreadSafe
public abstract class AbstractHttpClient implements HttpClient {
    @GuardedBy("this")
    private BackoffManager backoffManager;
    @GuardedBy("this")
    private ClientConnectionManager connManager;
    @GuardedBy("this")
    private ConnectionBackoffStrategy connectionBackoffStrategy;
    @GuardedBy("this")
    private CookieStore cookieStore;
    @GuardedBy("this")
    private CredentialsProvider credsProvider;
    @GuardedBy("this")
    private HttpParams defaultParams;
    @GuardedBy("this")
    private ConnectionKeepAliveStrategy keepAliveStrategy;
    private final Log log = LogFactory.getLog(getClass());
    @GuardedBy("this")
    private BasicHttpProcessor mutableProcessor;
    @GuardedBy("this")
    private ImmutableHttpProcessor protocolProcessor;
    @GuardedBy("this")
    private AuthenticationStrategy proxyAuthStrategy;
    @GuardedBy("this")
    private RedirectStrategy redirectStrategy;
    @GuardedBy("this")
    private HttpRequestExecutor requestExec;
    @GuardedBy("this")
    private HttpRequestRetryHandler retryHandler;
    @GuardedBy("this")
    private ConnectionReuseStrategy reuseStrategy;
    @GuardedBy("this")
    private HttpRoutePlanner routePlanner;
    @GuardedBy("this")
    private AuthSchemeRegistry supportedAuthSchemes;
    @GuardedBy("this")
    private CookieSpecRegistry supportedCookieSpecs;
    @GuardedBy("this")
    private AuthenticationStrategy targetAuthStrategy;
    @GuardedBy("this")
    private UserTokenHandler userTokenHandler;

    protected abstract HttpParams createHttpParams();

    protected abstract BasicHttpProcessor createHttpProcessor();

    protected AbstractHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.defaultParams = httpParams;
        this.connManager = clientConnectionManager;
    }

    protected HttpContext createHttpContext() {
        HttpContext basicHttpContext = new BasicHttpContext();
        basicHttpContext.setAttribute(ClientContext.SCHEME_REGISTRY, getConnectionManager().getSchemeRegistry());
        basicHttpContext.setAttribute(ClientContext.AUTHSCHEME_REGISTRY, getAuthSchemes());
        basicHttpContext.setAttribute(ClientContext.COOKIESPEC_REGISTRY, getCookieSpecs());
        basicHttpContext.setAttribute(ClientContext.COOKIE_STORE, getCookieStore());
        basicHttpContext.setAttribute(ClientContext.CREDS_PROVIDER, getCredentialsProvider());
        return basicHttpContext;
    }

    protected ClientConnectionManager createClientConnectionManager() {
        SchemeRegistry createDefault = SchemeRegistryFactory.createDefault();
        HttpParams params = getParams();
        String str = (String) params.getParameter(ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME);
        if (str != null) {
            try {
                ClientConnectionManagerFactory clientConnectionManagerFactory = (ClientConnectionManagerFactory) Class.forName(str).newInstance();
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Invalid class name: " + str);
            } catch (IllegalAccessException e2) {
                throw new IllegalAccessError(e2.getMessage());
            } catch (InstantiationException e3) {
                throw new InstantiationError(e3.getMessage());
            }
        }
        clientConnectionManagerFactory = null;
        if (clientConnectionManagerFactory != null) {
            return clientConnectionManagerFactory.newInstance(params, createDefault);
        }
        return new BasicClientConnectionManager(createDefault);
    }

    protected AuthSchemeRegistry createAuthSchemeRegistry() {
        AuthSchemeRegistry authSchemeRegistry = new AuthSchemeRegistry();
        authSchemeRegistry.register(AuthPolicy.BASIC, new BasicSchemeFactory());
        authSchemeRegistry.register(AuthPolicy.DIGEST, new DigestSchemeFactory());
        authSchemeRegistry.register(AuthPolicy.NTLM, new NTLMSchemeFactory());
        authSchemeRegistry.register(AuthPolicy.SPNEGO, new SPNegoSchemeFactory());
        authSchemeRegistry.register(AuthPolicy.KERBEROS, new KerberosSchemeFactory());
        return authSchemeRegistry;
    }

    protected CookieSpecRegistry createCookieSpecRegistry() {
        CookieSpecRegistry cookieSpecRegistry = new CookieSpecRegistry();
        cookieSpecRegistry.register(CookiePolicy.BEST_MATCH, new BestMatchSpecFactory());
        cookieSpecRegistry.register(CookiePolicy.BROWSER_COMPATIBILITY, new BrowserCompatSpecFactory());
        cookieSpecRegistry.register(CookiePolicy.NETSCAPE, new NetscapeDraftSpecFactory());
        cookieSpecRegistry.register(CookiePolicy.RFC_2109, new RFC2109SpecFactory());
        cookieSpecRegistry.register(CookiePolicy.RFC_2965, new RFC2965SpecFactory());
        cookieSpecRegistry.register(CookiePolicy.IGNORE_COOKIES, new IgnoreSpecFactory());
        return cookieSpecRegistry;
    }

    protected HttpRequestExecutor createRequestExecutor() {
        return new HttpRequestExecutor();
    }

    protected ConnectionReuseStrategy createConnectionReuseStrategy() {
        return new DefaultConnectionReuseStrategy();
    }

    protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return new DefaultConnectionKeepAliveStrategy();
    }

    protected HttpRequestRetryHandler createHttpRequestRetryHandler() {
        return new DefaultHttpRequestRetryHandler();
    }

    @Deprecated
    protected RedirectHandler createRedirectHandler() {
        return new DefaultRedirectHandler();
    }

    protected AuthenticationStrategy createTargetAuthenticationStrategy() {
        return new TargetAuthenticationStrategy();
    }

    @Deprecated
    protected AuthenticationHandler createTargetAuthenticationHandler() {
        return new DefaultTargetAuthenticationHandler();
    }

    protected AuthenticationStrategy createProxyAuthenticationStrategy() {
        return new ProxyAuthenticationStrategy();
    }

    @Deprecated
    protected AuthenticationHandler createProxyAuthenticationHandler() {
        return new DefaultProxyAuthenticationHandler();
    }

    protected CookieStore createCookieStore() {
        return new BasicCookieStore();
    }

    protected CredentialsProvider createCredentialsProvider() {
        return new BasicCredentialsProvider();
    }

    protected HttpRoutePlanner createHttpRoutePlanner() {
        return new DefaultHttpRoutePlanner(getConnectionManager().getSchemeRegistry());
    }

    protected UserTokenHandler createUserTokenHandler() {
        return new DefaultUserTokenHandler();
    }

    public final synchronized HttpParams getParams() {
        if (this.defaultParams == null) {
            this.defaultParams = createHttpParams();
        }
        return this.defaultParams;
    }

    public synchronized void setParams(HttpParams httpParams) {
        this.defaultParams = httpParams;
    }

    public final synchronized ClientConnectionManager getConnectionManager() {
        if (this.connManager == null) {
            this.connManager = createClientConnectionManager();
        }
        return this.connManager;
    }

    public final synchronized HttpRequestExecutor getRequestExecutor() {
        if (this.requestExec == null) {
            this.requestExec = createRequestExecutor();
        }
        return this.requestExec;
    }

    public final synchronized AuthSchemeRegistry getAuthSchemes() {
        if (this.supportedAuthSchemes == null) {
            this.supportedAuthSchemes = createAuthSchemeRegistry();
        }
        return this.supportedAuthSchemes;
    }

    public synchronized void setAuthSchemes(AuthSchemeRegistry authSchemeRegistry) {
        this.supportedAuthSchemes = authSchemeRegistry;
    }

    public final synchronized ConnectionBackoffStrategy getConnectionBackoffStrategy() {
        return this.connectionBackoffStrategy;
    }

    public synchronized void setConnectionBackoffStrategy(ConnectionBackoffStrategy connectionBackoffStrategy) {
        this.connectionBackoffStrategy = connectionBackoffStrategy;
    }

    public final synchronized CookieSpecRegistry getCookieSpecs() {
        if (this.supportedCookieSpecs == null) {
            this.supportedCookieSpecs = createCookieSpecRegistry();
        }
        return this.supportedCookieSpecs;
    }

    public final synchronized BackoffManager getBackoffManager() {
        return this.backoffManager;
    }

    public synchronized void setBackoffManager(BackoffManager backoffManager) {
        this.backoffManager = backoffManager;
    }

    public synchronized void setCookieSpecs(CookieSpecRegistry cookieSpecRegistry) {
        this.supportedCookieSpecs = cookieSpecRegistry;
    }

    public final synchronized ConnectionReuseStrategy getConnectionReuseStrategy() {
        if (this.reuseStrategy == null) {
            this.reuseStrategy = createConnectionReuseStrategy();
        }
        return this.reuseStrategy;
    }

    public synchronized void setReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        this.reuseStrategy = connectionReuseStrategy;
    }

    public final synchronized ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy() {
        if (this.keepAliveStrategy == null) {
            this.keepAliveStrategy = createConnectionKeepAliveStrategy();
        }
        return this.keepAliveStrategy;
    }

    public synchronized void setKeepAliveStrategy(ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
        this.keepAliveStrategy = connectionKeepAliveStrategy;
    }

    public final synchronized HttpRequestRetryHandler getHttpRequestRetryHandler() {
        if (this.retryHandler == null) {
            this.retryHandler = createHttpRequestRetryHandler();
        }
        return this.retryHandler;
    }

    public synchronized void setHttpRequestRetryHandler(HttpRequestRetryHandler httpRequestRetryHandler) {
        this.retryHandler = httpRequestRetryHandler;
    }

    @Deprecated
    public final synchronized RedirectHandler getRedirectHandler() {
        return createRedirectHandler();
    }

    @Deprecated
    public synchronized void setRedirectHandler(RedirectHandler redirectHandler) {
        this.redirectStrategy = new DefaultRedirectStrategyAdaptor(redirectHandler);
    }

    public final synchronized RedirectStrategy getRedirectStrategy() {
        if (this.redirectStrategy == null) {
            this.redirectStrategy = new DefaultRedirectStrategy();
        }
        return this.redirectStrategy;
    }

    public synchronized void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    @Deprecated
    public final synchronized AuthenticationHandler getTargetAuthenticationHandler() {
        return createTargetAuthenticationHandler();
    }

    @Deprecated
    public synchronized void setTargetAuthenticationHandler(AuthenticationHandler authenticationHandler) {
        this.targetAuthStrategy = new AuthenticationStrategyAdaptor(authenticationHandler);
    }

    public final synchronized AuthenticationStrategy getTargetAuthenticationStrategy() {
        if (this.targetAuthStrategy == null) {
            this.targetAuthStrategy = createTargetAuthenticationStrategy();
        }
        return this.targetAuthStrategy;
    }

    public synchronized void setTargetAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        this.targetAuthStrategy = authenticationStrategy;
    }

    @Deprecated
    public final synchronized AuthenticationHandler getProxyAuthenticationHandler() {
        return createProxyAuthenticationHandler();
    }

    @Deprecated
    public synchronized void setProxyAuthenticationHandler(AuthenticationHandler authenticationHandler) {
        this.proxyAuthStrategy = new AuthenticationStrategyAdaptor(authenticationHandler);
    }

    public final synchronized AuthenticationStrategy getProxyAuthenticationStrategy() {
        if (this.proxyAuthStrategy == null) {
            this.proxyAuthStrategy = createProxyAuthenticationStrategy();
        }
        return this.proxyAuthStrategy;
    }

    public synchronized void setProxyAuthenticationStrategy(AuthenticationStrategy authenticationStrategy) {
        this.proxyAuthStrategy = authenticationStrategy;
    }

    public final synchronized CookieStore getCookieStore() {
        if (this.cookieStore == null) {
            this.cookieStore = createCookieStore();
        }
        return this.cookieStore;
    }

    public synchronized void setCookieStore(CookieStore cookieStore) {
        this.cookieStore = cookieStore;
    }

    public final synchronized CredentialsProvider getCredentialsProvider() {
        if (this.credsProvider == null) {
            this.credsProvider = createCredentialsProvider();
        }
        return this.credsProvider;
    }

    public synchronized void setCredentialsProvider(CredentialsProvider credentialsProvider) {
        this.credsProvider = credentialsProvider;
    }

    public final synchronized HttpRoutePlanner getRoutePlanner() {
        if (this.routePlanner == null) {
            this.routePlanner = createHttpRoutePlanner();
        }
        return this.routePlanner;
    }

    public synchronized void setRoutePlanner(HttpRoutePlanner httpRoutePlanner) {
        this.routePlanner = httpRoutePlanner;
    }

    public final synchronized UserTokenHandler getUserTokenHandler() {
        if (this.userTokenHandler == null) {
            this.userTokenHandler = createUserTokenHandler();
        }
        return this.userTokenHandler;
    }

    public synchronized void setUserTokenHandler(UserTokenHandler userTokenHandler) {
        this.userTokenHandler = userTokenHandler;
    }

    protected final synchronized BasicHttpProcessor getHttpProcessor() {
        if (this.mutableProcessor == null) {
            this.mutableProcessor = createHttpProcessor();
        }
        return this.mutableProcessor;
    }

    private final synchronized HttpProcessor getProtocolProcessor() {
        ImmutableHttpProcessor immutableHttpProcessor;
        int i = 0;
        synchronized (this) {
            if (this.protocolProcessor == null) {
                int i2;
                BasicHttpProcessor httpProcessor = getHttpProcessor();
                int requestInterceptorCount = httpProcessor.getRequestInterceptorCount();
                HttpRequestInterceptor[] httpRequestInterceptorArr = new HttpRequestInterceptor[requestInterceptorCount];
                for (i2 = 0; i2 < requestInterceptorCount; i2++) {
                    httpRequestInterceptorArr[i2] = httpProcessor.getRequestInterceptor(i2);
                }
                i2 = httpProcessor.getResponseInterceptorCount();
                HttpResponseInterceptor[] httpResponseInterceptorArr = new HttpResponseInterceptor[i2];
                while (i < i2) {
                    httpResponseInterceptorArr[i] = httpProcessor.getResponseInterceptor(i);
                    i++;
                }
                this.protocolProcessor = new ImmutableHttpProcessor(httpRequestInterceptorArr, httpResponseInterceptorArr);
            }
            immutableHttpProcessor = this.protocolProcessor;
        }
        return immutableHttpProcessor;
    }

    public synchronized int getResponseInterceptorCount() {
        return getHttpProcessor().getResponseInterceptorCount();
    }

    public synchronized HttpResponseInterceptor getResponseInterceptor(int i) {
        return getHttpProcessor().getResponseInterceptor(i);
    }

    public synchronized HttpRequestInterceptor getRequestInterceptor(int i) {
        return getHttpProcessor().getRequestInterceptor(i);
    }

    public synchronized int getRequestInterceptorCount() {
        return getHttpProcessor().getRequestInterceptorCount();
    }

    public synchronized void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        getHttpProcessor().addInterceptor(httpResponseInterceptor);
        this.protocolProcessor = null;
    }

    public synchronized void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i) {
        getHttpProcessor().addInterceptor(httpResponseInterceptor, i);
        this.protocolProcessor = null;
    }

    public synchronized void clearResponseInterceptors() {
        getHttpProcessor().clearResponseInterceptors();
        this.protocolProcessor = null;
    }

    public synchronized void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> cls) {
        getHttpProcessor().removeResponseInterceptorByClass(cls);
        this.protocolProcessor = null;
    }

    public synchronized void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor) {
        getHttpProcessor().addInterceptor(httpRequestInterceptor);
        this.protocolProcessor = null;
    }

    public synchronized void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i) {
        getHttpProcessor().addInterceptor(httpRequestInterceptor, i);
        this.protocolProcessor = null;
    }

    public synchronized void clearRequestInterceptors() {
        getHttpProcessor().clearRequestInterceptors();
        this.protocolProcessor = null;
    }

    public synchronized void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> cls) {
        getHttpProcessor().removeRequestInterceptorByClass(cls);
        this.protocolProcessor = null;
    }

    public final HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException, ClientProtocolException {
        return execute(httpUriRequest, (HttpContext) null);
    }

    public final HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        if (httpUriRequest != null) {
            return execute(determineTarget(httpUriRequest), (HttpRequest) httpUriRequest, httpContext);
        }
        throw new IllegalArgumentException("Request must not be null.");
    }

    private static HttpHost determineTarget(HttpUriRequest httpUriRequest) throws ClientProtocolException {
        HttpHost httpHost = null;
        URI uri = httpUriRequest.getURI();
        if (uri.isAbsolute()) {
            httpHost = URIUtils.extractHost(uri);
            if (httpHost == null) {
                throw new ClientProtocolException("URI does not specify a valid host name: " + uri);
            }
        }
        return httpHost;
    }

    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException, ClientProtocolException {
        return execute(httpHost, httpRequest, (HttpContext) null);
    }

    public final HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException, ClientProtocolException {
        HttpRoute determineRoute;
        if (httpRequest == null) {
            throw new IllegalArgumentException("Request must not be null.");
        }
        HttpResponse execute;
        synchronized (this) {
            HttpContext createHttpContext = createHttpContext();
            if (httpContext == null) {
                HttpContext httpContext2 = createHttpContext;
            } else {
                Object defaultedHttpContext = new DefaultedHttpContext(httpContext, createHttpContext);
            }
            RequestDirector createClientRequestDirector = createClientRequestDirector(getRequestExecutor(), getConnectionManager(), getConnectionReuseStrategy(), getConnectionKeepAliveStrategy(), getRoutePlanner(), getProtocolProcessor(), getHttpRequestRetryHandler(), getRedirectStrategy(), getTargetAuthenticationStrategy(), getProxyAuthenticationStrategy(), getUserTokenHandler(), determineParams(httpRequest));
            HttpRoutePlanner routePlanner = getRoutePlanner();
            ConnectionBackoffStrategy connectionBackoffStrategy = getConnectionBackoffStrategy();
            BackoffManager backoffManager = getBackoffManager();
        }
        if (connectionBackoffStrategy == null || backoffManager == null) {
            execute = createClientRequestDirector.execute(httpHost, httpRequest, httpContext2);
        } else {
            try {
                determineRoute = routePlanner.determineRoute(httpHost != null ? httpHost : (HttpHost) determineParams(httpRequest).getParameter(ClientPNames.DEFAULT_HOST), httpRequest, httpContext2);
                execute = createClientRequestDirector.execute(httpHost, httpRequest, httpContext2);
                if (connectionBackoffStrategy.shouldBackoff(execute)) {
                    backoffManager.backOff(determineRoute);
                } else {
                    backoffManager.probe(determineRoute);
                }
            } catch (Throwable e) {
                if (connectionBackoffStrategy.shouldBackoff(e)) {
                    backoffManager.backOff(determineRoute);
                }
                throw e;
            } catch (Throwable e2) {
                if (connectionBackoffStrategy.shouldBackoff(e2)) {
                    backoffManager.backOff(determineRoute);
                }
                if (e2 instanceof HttpException) {
                    throw ((HttpException) e2);
                } else if (e2 instanceof IOException) {
                    throw ((IOException) e2);
                } else {
                    throw new UndeclaredThrowableException(e2);
                }
            } catch (Throwable e22) {
                throw new ClientProtocolException(e22);
            }
        }
        return execute;
    }

    @Deprecated
    protected RequestDirector createClientRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectHandler redirectHandler, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
        return new DefaultRequestDirector(httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectHandler, authenticationHandler, authenticationHandler2, userTokenHandler, httpParams);
    }

    @Deprecated
    protected RequestDirector createClientRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectStrategy redirectStrategy, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
        return new DefaultRequestDirector(this.log, httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectStrategy, authenticationHandler, authenticationHandler2, userTokenHandler, httpParams);
    }

    protected RequestDirector createClientRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectStrategy redirectStrategy, AuthenticationStrategy authenticationStrategy, AuthenticationStrategy authenticationStrategy2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
        return new DefaultRequestDirector(this.log, httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectStrategy, authenticationStrategy, authenticationStrategy2, userTokenHandler, httpParams);
    }

    protected HttpParams determineParams(HttpRequest httpRequest) {
        return new ClientParamsStack(null, getParams(), httpRequest.getParams(), null);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return execute(httpUriRequest, (ResponseHandler) responseHandler, null);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return execute(determineTarget(httpUriRequest), httpUriRequest, responseHandler, httpContext);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return execute(httpHost, httpRequest, responseHandler, null);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        if (responseHandler == null) {
            throw new IllegalArgumentException("Response handler must not be null.");
        }
        HttpResponse execute = execute(httpHost, httpRequest, httpContext);
        try {
            T handleResponse = responseHandler.handleResponse(execute);
            EntityUtils.consume(execute.getEntity());
            return handleResponse;
        } catch (Throwable e) {
            try {
                EntityUtils.consume(execute.getEntity());
            } catch (Throwable e2) {
                this.log.warn("Error consuming content after an exception.", e2);
            }
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            } else if (e instanceof IOException) {
                throw ((IOException) e);
            } else {
                throw new UndeclaredThrowableException(e);
            }
        }
    }
}
