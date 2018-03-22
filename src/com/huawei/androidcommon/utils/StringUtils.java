package com.huawei.androidcommon.utils;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.androidcommon.constants.AC;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class StringUtils {
    public static final String VIPARA = "1122334455667788";

    public static boolean isEmpty(String str) {
        if (str == null || str.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNull(String str) {
        if (str == null || "null".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(String str) {
        if (str == null || "null".equalsIgnoreCase(str) || str.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isUnknownOrEmpty(String str) {
        if (str == null || "unknown".equalsIgnoreCase(str) || str.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static String convertEmptyStr(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String trim(String str) {
        return convertEmptyStr(str).trim();
    }

    public static String getHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & 255)}));
        }
        return stringBuffer.toString();
    }

    public static byte[] getHexBytes(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        String toLowerCase = str.toLowerCase();
        for (int i = 0; i < toLowerCase.length(); i += 2) {
            char charAt = toLowerCase.charAt(i);
            byte b = (byte) (charAt >= 'a' ? (charAt - 97) + 10 : charAt - 48);
            charAt = toLowerCase.charAt(i + 1);
            bArr[i / 2] = (byte) (((byte) (charAt >= 'a' ? (charAt - 97) + 10 : charAt - 48)) + (b << 4));
        }
        return bArr;
    }

    public static int count(String str, String str2) {
        Object convertEmptyStr = convertEmptyStr(str);
        if (TextUtils.isEmpty(convertEmptyStr) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String[] split = convertEmptyStr.split(str2);
        if (split == null || split.length <= 1) {
            return 0;
        }
        return split.length - 1;
    }

    public static String[] explode(String str, String str2) {
        String convertEmptyStr = convertEmptyStr(str2);
        List arrayList = new ArrayList();
        if (str != null) {
            for (String str3 : str.split(convertEmptyStr)) {
                if (!isEmpty(str3)) {
                    arrayList.add(str3);
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static List<String[]> explode(String str, String str2, String str3) {
        List<String[]> arrayList = new ArrayList();
        String convertEmptyStr = convertEmptyStr(str2);
        if (convertEmptyStr.isEmpty()) {
            convertEmptyStr = "\n";
        }
        for (String str4 : convertEmptyStr(str).split(r0)) {
            if (!str4.isEmpty()) {
                arrayList.add(explode(str4, str3));
            }
        }
        return arrayList;
    }

    public static String implode(String[] strArr, String str) {
        int i = 0;
        if (strArr == null) {
            return "";
        }
        if (str == null) {
            str = "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : strArr) {
            stringBuilder.append(new StringBuilder(String.valueOf(str)).append(append).toString());
        }
        int length = str.length();
        if (stringBuilder.length() >= length) {
            i = length;
        }
        return stringBuilder.substring(i);
    }

    public static String trimPhoneNum(String str) {
        String convertEmptyStr = convertEmptyStr(str);
        if (convertEmptyStr.matches("^(\\+?86|\\+)\\d{11}")) {
            return convertEmptyStr.replaceAll("^(\\+?86|\\+)", "");
        }
        return convertEmptyStr;
    }

    public static boolean validPhoneNum(String str) {
        String convertEmptyStr = convertEmptyStr(str);
        if (convertEmptyStr.matches("^\\d+$") && convertEmptyStr.length() == 11 && convertEmptyStr.startsWith("1")) {
            return true;
        }
        return false;
    }

    public static List<String> getPhoneList(String str) {
        String convertEmptyStr = convertEmptyStr(str);
        List<String> arrayList = new ArrayList();
        for (String trimPhoneNum : convertEmptyStr.split("[^\\d]+")) {
            String trimPhoneNum2 = trimPhoneNum(trimPhoneNum2);
            if (validPhoneNum(trimPhoneNum2)) {
                arrayList.add(trimPhoneNum2);
            }
        }
        return arrayList;
    }

    public static Set<String> getPhoneSet(String str) {
        Collection phoneList = getPhoneList(str);
        Set<String> hashSet = new HashSet();
        hashSet.addAll(phoneList);
        return hashSet;
    }

    public static String encryptString(String str, String str2) {
        return getHexString(encrypt(str, str2));
    }

    public static String encryptForAndroid(String str, String str2) {
        String str3 = "";
        try {
            AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(VIPARA.getBytes());
            Key secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, ivParameterSpec);
            str3 = getHexString(instance.doFinal(str.getBytes("utf-8")));
        } catch (Throwable e) {
            Log.e(AC.TAG, "encryptForAndroid Error!", e);
        }
        return str3;
    }

    public static String decryptForAndroid(String str, String str2) {
        try {
            byte[] hexBytes = getHexBytes(str);
            AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(VIPARA.getBytes());
            Key secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            if (hexBytes == null) {
                Log.w(AC.TAG, "[StringUtils.decryptForAndroid]byteMi is null");
                return "";
            }
            byte[] doFinal = instance.doFinal(hexBytes);
            if (doFinal != null) {
                return new String(doFinal, "utf-8");
            }
            Log.w(AC.TAG, "[StringUtils.decryptForAndroid]byteMi is null");
            return "";
        } catch (Throwable e) {
            Log.e(AC.TAG, "[StringUtils.decryptForAndroid]error!", e);
            return "";
        }
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG", Security.getProviders()[0]);
            instance2.setSeed(str2.getBytes());
            instance.init(128, instance2);
            Key secretKeySpec = new SecretKeySpec(instance.generateKey().getEncoded(), "AES");
            Cipher instance3 = Cipher.getInstance("AES");
            byte[] bytes = str.getBytes("utf-8");
            instance3.init(1, secretKeySpec);
            return instance3.doFinal(bytes);
        } catch (Throwable e) {
            Log.e(AC.TAG, "[StringUtils.encrypt]error!", e);
            return null;
        }
    }

    public static String decryptString(String str, String str2) {
        return decrypt(getHexBytes(str), str2);
    }

    public static String decrypt(byte[] bArr, String str) {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            SecureRandom instance2 = SecureRandom.getInstance("SHA1PRNG", Security.getProviders()[0]);
            instance2.setSeed(str.getBytes());
            instance.init(128, instance2);
            Key secretKeySpec = new SecretKeySpec(instance.generateKey().getEncoded(), "AES");
            Cipher instance3 = Cipher.getInstance("AES");
            instance3.init(2, secretKeySpec);
            return new String(instance3.doFinal(bArr), "utf-8");
        } catch (Throwable e) {
            Log.e(AC.TAG, "[StringUtils.encrypt]error!", e);
            return null;
        }
    }

    public static String convertEmptyToNull(String str) {
        if (isEmpty(str)) {
            return null;
        }
        return str;
    }

    public static String utf8Encode(String str) {
        if (!(isEmpty(str) || str.getBytes().length == str.length())) {
            try {
                str = URLEncoder.encode(str, GameManager.DEFAULT_CHARSET);
            } catch (Throwable e) {
                throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
            }
        }
        return str;
    }

    public static String utf8Encode(String str, String str2) {
        if (isEmpty(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return URLEncoder.encode(str, GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            return str2;
        }
    }

    public static String listToString(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = null;
        for (String str : list) {
            if (obj != null) {
                stringBuilder.append(",");
            } else {
                obj = 1;
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static BigInteger getNumberFromVersion(String str) {
        Matcher matcher = Pattern.compile(HwAccountConstants.DIGITAL_REGX).matcher(str);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(matcher.group());
        }
        return new BigInteger(stringBuilder.toString());
    }
}
