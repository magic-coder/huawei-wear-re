package cn.com.fmsh.util.algorithm;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class DSA {
    private static /* synthetic */ FMLog f9854a = LogFactory.getInstance().getLog();

    public static Map<String, byte[]> generateKey(int i) {
        KeyPairGenerator instance;
        Map<String, byte[]> hashMap = new HashMap();
        try {
            instance = KeyPairGenerator.getInstance(FM_Exception.insert(4, 93, "L\u0016\u0003"));
        } catch (Exception e) {
            if (f9854a != null) {
                f9854a.error(RSA.class.getName(), FM_Int.replace(6, "\t\r@亣甘富钨凪玣弔帡"));
                f9854a.error(RSA.class.getName(), Util4Java.getExceptionInfo(e));
            }
            System.out.println(Util4Java.getExceptionInfo(e));
            instance = null;
        }
        if (instance == null) {
            return null;
        }
        instance.initialize(i, new SecureRandom());
        KeyPair generateKeyPair = instance.generateKeyPair();
        hashMap.put(FM_CN.equals("\u000535$piPi$", 2), generateKeyPair.getPublic().getEncoded());
        hashMap.put(Util4Java.endsWith("\u001d=xe4#|P8&", 80, 34), generateKeyPair.getPrivate().getEncoded());
        return hashMap;
    }

    public static void main(String[] strArr) {
        DSA dsa = new DSA();
        generateKey(1024);
    }
}
