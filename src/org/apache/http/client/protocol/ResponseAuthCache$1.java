package org.apache.http.client.protocol;

import org.apache.http.auth.AuthProtocolState;

class ResponseAuthCache$1 {
    static final /* synthetic */ int[] $SwitchMap$org$apache$http$auth$AuthProtocolState = new int[AuthProtocolState.values().length];

    static {
        try {
            $SwitchMap$org$apache$http$auth$AuthProtocolState[AuthProtocolState.CHALLENGED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            $SwitchMap$org$apache$http$auth$AuthProtocolState[AuthProtocolState.FAILURE.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
