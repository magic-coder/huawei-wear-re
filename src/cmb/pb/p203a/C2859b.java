package cmb.pb.p203a;

import com.sina.weibo.sdk.component.GameManager;
import java.security.Key;
import javax.crypto.Cipher;

public final class C2859b {
    public static String m12952a(String str, Key key) {
        try {
            Cipher instance = Cipher.getInstance("AES");
            instance.init(1, key);
            return C2858a.m12948a(instance.doFinal(str.getBytes(GameManager.DEFAULT_CHARSET)));
        } catch (Exception e) {
            return null;
        }
    }

    public static String m12953b(String str, Key key) {
        String str2;
        try {
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, key);
            byte[] doFinal = instance.doFinal(C2858a.m12949a(str));
            if (doFinal == null) {
                return null;
            }
            str2 = new String(doFinal, GameManager.DEFAULT_CHARSET);
            return str2;
        } catch (Exception e) {
            str2 = null;
        }
    }
}
