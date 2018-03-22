package okhttp3;

import java.util.Collections;
import java.util.List;

public interface CookieJar {
    public static final CookieJar NO_COOKIES = new C27141();

    final class C27141 implements CookieJar {
        C27141() {
        }

        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        }

        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            return Collections.emptyList();
        }
    }

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
