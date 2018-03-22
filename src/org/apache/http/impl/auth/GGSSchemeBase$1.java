package org.apache.http.impl.auth;

class GGSSchemeBase$1 {
    static final /* synthetic */ int[] $SwitchMap$org$apache$http$impl$auth$GGSSchemeBase$State = new int[GGSSchemeBase$State.values().length];

    static {
        try {
            $SwitchMap$org$apache$http$impl$auth$GGSSchemeBase$State[GGSSchemeBase$State.UNINITIATED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            $SwitchMap$org$apache$http$impl$auth$GGSSchemeBase$State[GGSSchemeBase$State.FAILED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            $SwitchMap$org$apache$http$impl$auth$GGSSchemeBase$State[GGSSchemeBase$State.CHALLENGE_RECEIVED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            $SwitchMap$org$apache$http$impl$auth$GGSSchemeBase$State[GGSSchemeBase$State.TOKEN_GENERATED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
