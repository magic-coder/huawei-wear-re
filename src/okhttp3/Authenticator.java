package okhttp3;

import java.io.IOException;

public interface Authenticator {
    public static final Authenticator NONE = new C27041();

    final class C27041 implements Authenticator {
        C27041() {
        }

        public Request authenticate(Route route, Response response) {
            return null;
        }
    }

    Request authenticate(Route route, Response response) throws IOException;
}
