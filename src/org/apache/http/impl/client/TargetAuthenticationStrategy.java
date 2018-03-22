package org.apache.http.impl.client;

import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import org.apache.http.annotation.Immutable;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.params.AuthPNames;

@Immutable
public class TargetAuthenticationStrategy extends AuthenticationStrategyImpl {
    public TargetAuthenticationStrategy() {
        super(HttpStatus.SC_UNAUTHORIZED, AUTH.WWW_AUTH, AuthPNames.TARGET_AUTH_PREF);
    }
}
