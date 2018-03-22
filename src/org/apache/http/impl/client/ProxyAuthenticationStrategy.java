package org.apache.http.impl.client;

import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.params.AuthPNames;

@Immutable
public class ProxyAuthenticationStrategy extends AuthenticationStrategyImpl {
    public ProxyAuthenticationStrategy() {
        super(HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED, AUTH.PROXY_AUTH, AuthPNames.PROXY_AUTH_PREF);
    }
}
