package org.apache.http.impl.client;

import java.security.Principal;
import javax.net.ssl.SSLSession;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.HttpRoutedConnection;
import org.apache.http.protocol.HttpContext;

@Immutable
public class DefaultUserTokenHandler implements UserTokenHandler {
    public Object getUserToken(HttpContext httpContext) {
        Principal principal = null;
        AuthState authState = (AuthState) httpContext.getAttribute(ClientContext.TARGET_AUTH_STATE);
        if (authState != null) {
            principal = getAuthPrincipal(authState);
            if (principal == null) {
                principal = getAuthPrincipal((AuthState) httpContext.getAttribute(ClientContext.PROXY_AUTH_STATE));
            }
        }
        if (principal == null) {
            HttpRoutedConnection httpRoutedConnection = (HttpRoutedConnection) httpContext.getAttribute("http.connection");
            if (httpRoutedConnection.isOpen()) {
                SSLSession sSLSession = httpRoutedConnection.getSSLSession();
                if (sSLSession != null) {
                    return sSLSession.getLocalPrincipal();
                }
            }
        }
        return principal;
    }

    private static Principal getAuthPrincipal(AuthState authState) {
        AuthScheme authScheme = authState.getAuthScheme();
        if (authScheme != null && authScheme.isComplete() && authScheme.isConnectionBased()) {
            Credentials credentials = authState.getCredentials();
            if (credentials != null) {
                return credentials.getUserPrincipal();
            }
        }
        return null;
    }
}
