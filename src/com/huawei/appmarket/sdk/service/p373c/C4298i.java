package com.huawei.appmarket.sdk.service.p373c;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.params.AuthPolicy;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.protocol.RequestAddCookies;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.apache.http.client.protocol.RequestProxyAuthentication;
import org.apache.http.client.protocol.RequestTargetAuthentication;
import org.apache.http.client.protocol.ResponseProcessCookies;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.auth.BasicSchemeFactory;
import org.apache.http.impl.auth.DigestSchemeFactory;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.DefaultProxyAuthenticationHandler;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.impl.client.DefaultTargetAuthenticationHandler;
import org.apache.http.impl.client.DefaultUserTokenHandler;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.impl.cookie.NetscapeDraftSpecFactory;
import org.apache.http.impl.cookie.RFC2109SpecFactory;
import org.apache.http.impl.cookie.RFC2965SpecFactory;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.RequestConnControl;
import org.apache.http.protocol.RequestContent;
import org.apache.http.protocol.RequestExpectContinue;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.protocol.RequestUserAgent;
import org.apache.http.util.VersionInfo;

public class C4298i extends C4293a {
    public C4298i(ClientConnectionManager clientConnectionManager, HttpParams httpParams, ThreadLocal<C4294b> threadLocal) {
        super(clientConnectionManager, httpParams, threadLocal);
    }

    protected AuthSchemeRegistry createAuthSchemeRegistry() {
        AuthSchemeRegistry authSchemeRegistry = new AuthSchemeRegistry();
        authSchemeRegistry.register(AuthPolicy.BASIC, new BasicSchemeFactory());
        authSchemeRegistry.register(AuthPolicy.DIGEST, new DigestSchemeFactory());
        return authSchemeRegistry;
    }

    protected ClientConnectionManager createClientConnectionManager() {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        HttpParams params = getParams();
        ClientConnectionManagerFactory clientConnectionManagerFactory = (ClientConnectionManagerFactory) params.getParameter("http.connection-manager.factory-object");
        if (clientConnectionManagerFactory == null) {
            String str = (String) params.getParameter(ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME);
            if (str != null) {
                try {
                    clientConnectionManagerFactory = (ClientConnectionManagerFactory) Class.forName(str).newInstance();
                } catch (ClassNotFoundException e) {
                    throw new IllegalStateException("Invalid class name: " + str);
                } catch (IllegalAccessException e2) {
                    throw new IllegalAccessError(e2.getMessage());
                } catch (InstantiationException e3) {
                    throw new InstantiationError(e3.getMessage());
                }
            }
        }
        return clientConnectionManagerFactory != null ? clientConnectionManagerFactory.newInstance(params, schemeRegistry) : new SingleClientConnManager(getParams(), schemeRegistry);
    }

    protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return new DefaultConnectionKeepAliveStrategy();
    }

    protected ConnectionReuseStrategy createConnectionReuseStrategy() {
        return new DefaultConnectionReuseStrategy();
    }

    protected CookieSpecRegistry createCookieSpecRegistry() {
        CookieSpecRegistry cookieSpecRegistry = new CookieSpecRegistry();
        cookieSpecRegistry.register(CookiePolicy.BEST_MATCH, new BestMatchSpecFactory());
        cookieSpecRegistry.register(CookiePolicy.BROWSER_COMPATIBILITY, new BrowserCompatSpecFactory());
        cookieSpecRegistry.register(CookiePolicy.NETSCAPE, new NetscapeDraftSpecFactory());
        cookieSpecRegistry.register(CookiePolicy.RFC_2109, new RFC2109SpecFactory());
        cookieSpecRegistry.register(CookiePolicy.RFC_2965, new RFC2965SpecFactory());
        return cookieSpecRegistry;
    }

    protected CookieStore createCookieStore() {
        return new BasicCookieStore();
    }

    protected CredentialsProvider createCredentialsProvider() {
        return new BasicCredentialsProvider();
    }

    protected HttpContext createHttpContext() {
        HttpContext basicHttpContext = new BasicHttpContext();
        basicHttpContext.setAttribute(ClientContext.AUTHSCHEME_REGISTRY, getAuthSchemes());
        basicHttpContext.setAttribute(ClientContext.COOKIESPEC_REGISTRY, getCookieSpecs());
        basicHttpContext.setAttribute(ClientContext.COOKIE_STORE, getCookieStore());
        basicHttpContext.setAttribute(ClientContext.CREDS_PROVIDER, getCredentialsProvider());
        return basicHttpContext;
    }

    protected HttpParams createHttpParams() {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "ISO-8859-1");
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
        VersionInfo loadVersionInfo = VersionInfo.loadVersionInfo("org.apache.http.client", getClass().getClassLoader());
        HttpProtocolParams.setUserAgent(basicHttpParams, "Apache-HttpClient/" + (loadVersionInfo != null ? loadVersionInfo.getRelease() : "UNAVAILABLE") + " (java 1.4)");
        return basicHttpParams;
    }

    protected BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor basicHttpProcessor = new BasicHttpProcessor();
        basicHttpProcessor.addInterceptor(new RequestDefaultHeaders());
        basicHttpProcessor.addInterceptor(new RequestContent());
        basicHttpProcessor.addInterceptor(new RequestTargetHost());
        basicHttpProcessor.addInterceptor(new RequestConnControl());
        basicHttpProcessor.addInterceptor(new RequestUserAgent());
        basicHttpProcessor.addInterceptor(new RequestExpectContinue());
        basicHttpProcessor.addInterceptor(new RequestAddCookies());
        basicHttpProcessor.addInterceptor(new ResponseProcessCookies());
        basicHttpProcessor.addInterceptor(new RequestTargetAuthentication());
        basicHttpProcessor.addInterceptor(new RequestProxyAuthentication());
        return basicHttpProcessor;
    }

    protected HttpRequestRetryHandler createHttpRequestRetryHandler() {
        return new DefaultHttpRequestRetryHandler();
    }

    protected HttpRoutePlanner createHttpRoutePlanner() {
        return new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), null);
    }

    protected AuthenticationHandler createProxyAuthenticationHandler() {
        return new DefaultProxyAuthenticationHandler();
    }

    protected RedirectHandler createRedirectHandler() {
        return new DefaultRedirectHandler();
    }

    protected HttpRequestExecutor createRequestExecutor() {
        return new HttpRequestExecutor();
    }

    protected AuthenticationHandler createTargetAuthenticationHandler() {
        return new DefaultTargetAuthenticationHandler();
    }

    protected UserTokenHandler createUserTokenHandler() {
        return new DefaultUserTokenHandler();
    }
}
