package com.huawei.wallet.utils;

import com.huawei.wallet.utils.log.LogC;
import java.lang.reflect.InvocationTargetException;

public class ProductConfigUtil {
    public static String[] m28469a() {
        try {
            String[] strArr;
            Class cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.product.wallet.nfc"});
            LogC.m28530b("getProductConfig, product config info: " + str, false);
            if (StringUtil.m28479a(str, true)) {
                strArr = null;
            } else {
                strArr = str.split("\\|");
            }
            return strArr;
        } catch (ClassNotFoundException e) {
            LogC.m28534d("getProductConfig, ClassNotFoundException.", false);
            return null;
        } catch (NoSuchMethodException e2) {
            LogC.m28534d("getProductConfig NoSuchMethodException.", false);
            return null;
        } catch (IllegalAccessException e3) {
            LogC.m28534d("getProductConfig IllegalAccessException.", false);
            return null;
        } catch (IllegalArgumentException e4) {
            LogC.m28534d("getProductConfig IllegalArgumentException.", false);
            return null;
        } catch (InvocationTargetException e5) {
            LogC.m28534d("getProductConfig InvocationTargetException.", false);
            return null;
        }
    }
}
