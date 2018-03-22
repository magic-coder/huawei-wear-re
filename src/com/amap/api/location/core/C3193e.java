package com.amap.api.location.core;

import android.content.Context;
import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.sina.weibo.sdk.component.GameManager;
import com.unionpay.tsmservice.data.Constant;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Encrypt */
public class C3193e {
    private static final char[] f10708a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final byte[] f10709b = new byte[]{(byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 3, (byte) 5, (byte) 8, TagName.PAY_CHANNEL, (byte) 8, (byte) 7, (byte) 6, (byte) 5, (byte) 4, (byte) 3, (byte) 2, (byte) 1};
    private static final IvParameterSpec f10710c = new IvParameterSpec(f10709b);

    public static byte[] m14152a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        try {
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(1, secretKeySpec);
            bArr3 = instance.doFinal(bArr2);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return bArr3;
    }

    public static byte[] m14151a(byte[] bArr, Key key) throws Exception {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    static PublicKey m14149a(Context context) throws Exception {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(new byte[]{TagName.APK_SIZE, TagName.ACTIVITY_NAME, (byte) 2, TagName.INVOICE_TOKEN_OBJECT_LIST, TagName.APK_SIZE, TagName.ACTIVITY_NAME, (byte) 2, (byte) 7, ScriptToolsConst.TagName.CommandSingle, (byte) 3, (byte) 2, (byte) 1, (byte) 2, (byte) 2, (byte) 9, (byte) 0, TagName.INVOICE_TOKEN_OBJECT, (byte) 15, (byte) 119, TagName.BUSINESS_ORDER_OP_TYPE, TagName.SYSTEM_NEW_VERSION, (byte) -19, TagName.PREDEPOSIT_LIST, (byte) -40, TagName.APK_SIZE, TagName.PAY_CHANNEL, (byte) 6, (byte) 9, (byte) 42, TagName.ACTIVITY_TOTAL, TagName.BUSINESS_ORDER_TYPE, TagName.ACTIVITY_TOTAL, (byte) -9, TagName.PAY_CHANNEL, (byte) 1, (byte) 1, (byte) 5, (byte) 5, (byte) 0, TagName.APK_SIZE, TagName.DEVICE_MODEL, TagName.NOTICE_ID, TagName.IDENTIFYING_TYPE, TagName.APK_SIZE, (byte) 9, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 6, TagName.ORDER_DATE, (byte) 2, TagName.TERMINAL_BACK_INFO_TYPE, (byte) 78, TagName.NOTICE_ID, TagName.ORDER_DATE, TagName.APK_SIZE, (byte) 17, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 8, TagName.IDENTIFYING_CODE, (byte) 10, TagName.TERMINAL_BACK_INFO, TagName.ELECTRONIC_END_TIME, TagName.PUBLISH_END_TIME, TagName.ORDER_TYPE, TagName.APK_UPDATE_FLAG, TagName.TERMINAL_BACK_INFO, TagName.ELECTRONIC_USE_TYPE, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_USE_TYPE, TagName.ORDER_TYPE, TagName.NOTICE_ID, (byte) 16, TagName.APK_SIZE, (byte) 14, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 7, TagName.IDENTIFYING_CODE, (byte) 7, TagName.INVOICE_TOKEN, TagName.ORDER_TYPE, TagName.MAIN_ORDER_ID, TagName.PAY_ORDER_ID, TagName.MAIN_ORDER_ID, TagName.ELECTRONIC_STARTTIME, TagName.PRODUCT_ID, TagName.NOTICE_ID, (byte) 17, TagName.APK_SIZE, (byte) 15, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 10, TagName.IDENTIFYING_CODE, (byte) 8, TagName.TERMINAL_BACK_CONTENT, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_FROZEN_FLAG, TagName.MAIN_ORDER_ID, TagName.NOTICE_ID, TagName.TRADE_STATUS, TagName.APK_SIZE, (byte) 29, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 3, TagName.IDENTIFYING_CODE, TagName.ORDER_TRADE_NO, TagName.PAY_ORDER, TagName.ELECTRONIC_END_TIME, TagName.PUBLISH_END_TIME, TagName.SIM_SEID, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_FROZEN_FLAG, TagName.MAIN_ORDER_ID, TagName.SIM_SEID, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_ID, TagName.MAIN_ORDER_ID, TagName.ELECTRONIC_TYPE, TagName.ORDER_TYPE, TagName.ELECTRONIC_NUMBER, TagName.ELECTRONIC_FROZEN_FLAG, TagName.ORDER_TYPE, TagName.ELECTRONIC_NUMBER, TagName.APK_SIZE, TagName.ORDER_CHANNEL, TagName.ORDER_TERMINAL, TagName.PAY_CHANNEL, TagName.NOTICE_ID, TagName.ACTIVITY_CODE_LIST, TagName.APK_SIZE, ScriptToolsConst.TagName.TagSerial, TagName.NOTICE_ID, (byte) 53, TagName.APK_SIZE, TagName.NOTICE_END_TIME, (byte) 53, TagName.NOTICE_START_TIME, (byte) 53, (byte) 53, TagName.PREDEPOSIT_TOTAL, TagName.ORDER_TERMINAL, TagName.PAY_CHANNEL, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.APK_SIZE, ScriptToolsConst.TagName.TagSerial, TagName.NOTICE_ID, TagName.ACTIVITY_CODE_LIST, TagName.APK_SIZE, TagName.NOTICE_END_TIME, (byte) 53, TagName.NOTICE_START_TIME, (byte) 53, (byte) 53, TagName.PREDEPOSIT_TOTAL, TagName.APK_SIZE, TagName.DEVICE_MODEL, TagName.NOTICE_ID, TagName.IDENTIFYING_TYPE, TagName.APK_SIZE, (byte) 9, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 6, TagName.ORDER_DATE, (byte) 2, TagName.TERMINAL_BACK_INFO_TYPE, (byte) 78, TagName.NOTICE_ID, TagName.ORDER_DATE, TagName.APK_SIZE, (byte) 17, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 8, TagName.IDENTIFYING_CODE, (byte) 10, TagName.TERMINAL_BACK_INFO, TagName.ELECTRONIC_END_TIME, TagName.PUBLISH_END_TIME, TagName.ORDER_TYPE, TagName.APK_UPDATE_FLAG, TagName.TERMINAL_BACK_INFO, TagName.ELECTRONIC_USE_TYPE, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_USE_TYPE, TagName.ORDER_TYPE, TagName.NOTICE_ID, (byte) 16, TagName.APK_SIZE, (byte) 14, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 7, TagName.IDENTIFYING_CODE, (byte) 7, TagName.INVOICE_TOKEN, TagName.ORDER_TYPE, TagName.MAIN_ORDER_ID, TagName.PAY_ORDER_ID, TagName.MAIN_ORDER_ID, TagName.ELECTRONIC_STARTTIME, TagName.PRODUCT_ID, TagName.NOTICE_ID, (byte) 17, TagName.APK_SIZE, (byte) 15, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 10, TagName.IDENTIFYING_CODE, (byte) 8, TagName.TERMINAL_BACK_CONTENT, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_FROZEN_FLAG, TagName.MAIN_ORDER_ID, TagName.NOTICE_ID, TagName.TRADE_STATUS, TagName.APK_SIZE, (byte) 29, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 3, TagName.IDENTIFYING_CODE, TagName.ORDER_TRADE_NO, TagName.PAY_ORDER, TagName.ELECTRONIC_END_TIME, TagName.PUBLISH_END_TIME, TagName.SIM_SEID, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_FROZEN_FLAG, TagName.MAIN_ORDER_ID, TagName.SIM_SEID, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_ID, TagName.MAIN_ORDER_ID, TagName.ELECTRONIC_TYPE, TagName.ORDER_TYPE, TagName.ELECTRONIC_NUMBER, TagName.ELECTRONIC_FROZEN_FLAG, TagName.ORDER_TYPE, TagName.ELECTRONIC_NUMBER, TagName.APK_SIZE, TagName.ACTIVITY, (byte) -97, TagName.APK_SIZE, TagName.PAY_CHANNEL, (byte) 6, (byte) 9, (byte) 42, TagName.ACTIVITY_TOTAL, TagName.BUSINESS_ORDER_TYPE, TagName.ACTIVITY_TOTAL, (byte) -9, TagName.PAY_CHANNEL, (byte) 1, (byte) 1, (byte) 1, (byte) 5, (byte) 0, (byte) 3, TagName.ACTIVITY, TagName.ACTIVITY_STATUS, (byte) 0, TagName.APK_SIZE, TagName.ACTIVITY, TagName.COMPANY_CODE, (byte) 2, TagName.ACTIVITY, TagName.ACTIVITY, (byte) 0, (byte) -15, (byte) -27, Byte.MIN_VALUE, TagName.PROMOTION_MESSAGE_DATA, TagName.ELECTRONIC_FROZEN_FLAG, TagName.USER_PLATFORM_ID, TagName.CARD_BUSINESS_ORDER_STATUS, TagName.ACTIVITY, TagName.CP_NO, TagName.ELECTRONIC_PRICE_FAVOURABLE, (byte) -36, TagName.ELECTRONIC_STATE, (byte) 0, TagName.CARD_APP_ACTIVATION_STATUS, TagName.ACTIVITY_CODE, (byte) -30, TagName.ELECTRONIC_FROZEN_FLAG, (byte) 5, (byte) -85, TagName.ACTIVITY_REMAINDER, TagName.PREDEPOSIT_BLANCE, (byte) 39, TagName.PREDEPOSIT_TOTAL, TagName.ELECTRONIC_USE_TIME, TagName.BUSINESS_ORDER_TYPE, TagName.ACTIVITY_NAME, (byte) -83, (byte) -41, (byte) -45, TagName.APP_AID, (byte) -42, TagName.ACTIVITY_DEFINITION, (byte) -81, TagName.ORDER_TERMINAL, (byte) -2, TagName.ACTIVITY_REMAINDER, (byte) -29, TagName.ELECTRONIC_USE_TIME, (byte) -7, TagName.ORDER_TRADE_NO, TagName.URL_TYPE, (byte) -20, (byte) -25, (byte) 74, TagName.TERMINAL_BACK_INFO_TYPE, (byte) -43, TagName.TERMINAL_BACK_CONTENT, TagName.PRICE, (byte) -7, TagName.IDENTIFYING_TYPE, TagName.EUID, TagName.QUERY_RECORD_COUNT, TagName.ACTIVITY_END, (byte) 16, TagName.PROMOTION_MESSAGE, TagName.ORDER_BRIEF_INFO_LIST, (byte) 32, TagName.BUSINESS_ORDER_OP_TYPE, (byte) -33, (byte) 14, TagName.IDENTIFYING_TYPE, TagName.USER_LOGIN_FAIL_COUNT, ScriptToolsConst.TagName.TagExpectationAndNext, TagName.PAY_CHANNEL, TagName.ACTIVITY_REMAINDER, TagName.PAY_ORDER_LIST, TagName.MAIN_ORDER_ID, (byte) -32, TagName.ELECTRONIC_USE_TIME, (byte) -31, TagName.ELECTRONIC_NUMBER, TagName.CITY_CODE, (byte) -41, TagName.IDENTIFYING_CODE, TagName.PAY_ORDER_LIST, (byte) 33, TagName.ACTIVITY_DEFINITION, TagName.CARD_APP_ACTIVATION_STATUS, TagName.ELECTRONIC_OUT_SERIAL, TagName.ACTIVITY_END, TagName.APK_SIZE, TagName.NOTICE_END_TIME, TagName.ORDER_BRIEF_INFO_LIST, TagName.PREDEPOSIT_STATUS, TagName.APK_DOWNLOAD_URL, (byte) -10, TagName.ELECTRONIC_PRICE_FAVOURABLE, TagName.CARD_APP_RAMDOM, (byte) -41, ScriptToolsConst.TagName.ScriptDown, TagName.ACTIVITY_NAME, TagName.ELECTRONIC_FROZEN_FLAG, TagName.IMEI, TagName.USER_LOCK_TIME, TagName.ACTIVITY, (byte) 9, TagName.TERMINAL_INFO_TYPE, TagName.PRODUCT_LIST, (byte) 81, (byte) -19, TagName.URL_TYPE, (byte) -41, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.PRODUCT_CODE, (byte) -37, TagName.PREDEPOSIT_STATUS, TagName.ELECTRONIC_FROZEN_FLAG, TagName.BUSINESS_ORDER_TYPE, TagName.QUERY_DATA_SORT_TYPE, TagName.ELECTRONIC_PRICE_FAVOURABLE, (byte) -43, ScriptToolsConst.TagName.CommandMultiple, (byte) -11, TagName.CARD_APP_ACTIVATION_STATUS, TagName.TERMINAL_MODEL_NUMBER, (byte) -38, (byte) -10, TagName.STATION_ID, TagName.ELECTRONIC_OUT_SERIAL, (byte) -53, TagName.ACTIVITY_STATUS, ScriptToolsConst.TagName.TagExpectationAndNext, TagName.CARD_BUSINESS_ORDER_STATUS, (byte) -86, (byte) -80, (byte) 1, (byte) 39, TagName.ORDER_DATE, (byte) 2, (byte) 3, (byte) 1, (byte) 0, (byte) 1, ScriptToolsConst.TagName.ResponseMultiple, TagName.ORDER_BRIEF_INFO_LIST, TagName.APK_SIZE, (byte) 78, TagName.APK_SIZE, (byte) 29, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 29, (byte) 14, (byte) 4, TagName.ORDER_TRADE_NO, (byte) 4, TagName.ORDER_TIME, (byte) -29, TagName.CARD_APP_ACTIVATION_STATUS, TagName.APK_SIZE, TagName.SEID, TagName.URL_LIST, (byte) -13, TagName.BUSINESS_ORDER, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.ORDER_TRADE_NO, (byte) -27, TagName.TERMINAL_INFO_TYPE, (byte) -5, TagName.ELECTRONIC_OUT_STATE, TagName.PRODUCT_CODE, TagName.PLATFORM_NOTICES, (byte) 14, (byte) -18, (byte) 6, (byte) -13, TagName.PLATFORM_NOTICES, TagName.APK_SIZE, TagName.TRADE_STATUS, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 29, (byte) 35, (byte) 4, TagName.ORDER_INVOICE_STATUS, TagName.APK_SIZE, TagName.ORDER_TRADE_NO, Byte.MIN_VALUE, TagName.ORDER_TIME, (byte) -29, TagName.CARD_APP_ACTIVATION_STATUS, TagName.APK_SIZE, TagName.SEID, TagName.URL_LIST, (byte) -13, TagName.BUSINESS_ORDER, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.ORDER_TRADE_NO, (byte) -27, TagName.TERMINAL_INFO_TYPE, (byte) -5, TagName.ELECTRONIC_OUT_STATE, TagName.PRODUCT_CODE, TagName.PLATFORM_NOTICES, (byte) 14, (byte) -18, (byte) 6, (byte) -13, TagName.PLATFORM_NOTICES, TagName.APK_SIZE, TagName.IDENTIFYING_CODE, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 29, TagName.ORDER_DATE, (byte) 4, (byte) 5, TagName.APK_SIZE, (byte) 3, (byte) 1, (byte) 1, (byte) -1, TagName.APK_SIZE, TagName.PAY_CHANNEL, (byte) 6, (byte) 9, (byte) 42, TagName.ACTIVITY_TOTAL, TagName.BUSINESS_ORDER_TYPE, TagName.ACTIVITY_TOTAL, (byte) -9, TagName.PAY_CHANNEL, (byte) 1, (byte) 1, (byte) 5, (byte) 5, (byte) 0, (byte) 3, TagName.ACTIVITY, TagName.ACTIVITY, (byte) 0, (byte) -32, TagName.CPLC, TagName.NOTICE_END_TIME, TagName.ACTIVITY_CODE, TagName.PROMOTION_MESSAGE, Byte.MIN_VALUE, (byte) 15, TagName.RENT_HANDLE_TYPE, TagName.PAY_ORDER_LIST, TagName.USER_PLATFORM_TYPE, (byte) 3, (byte) -86, (byte) 81, TagName.ELECTRONIC_ID, TagName.RENT_HANDLE_DATD, TagName.PROMOTION_MESSAGE_DATA, TagName.APP_MANAGE_OPEATE_TYPE, TagName.ACTIVITY_NAME, (byte) 8, TagName.PAY_ORDER, TagName.PRODUCT_LIST, (byte) -38, TagName.UNSOLVED_NOTICES, TagName.PROMOTION_MESSAGE_DATA, TagName.ACTIVITY_TOTAL, TagName.ELECTRONIC_PRICE_FAVOURABLE, TagName.ORDER_DATE, TagName.STATION_ENAME, TagName.RENT_HANDLE_DATD, TagName.PREDEPOSIT_TOTAL, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) -47, (byte) -8, TagName.ACTIVITY_END, TagName.PRODUCT_CODE, TagName.MAIN_ORDER_ID, (byte) 77, (byte) -32, TagName.STATION_ID, TagName.RENT_HANDLE_TYPE, (byte) -28, TagName.TERMINAL_BACK_INFO_TYPE, (byte) -28, TagName.APP_TYPE, TagName.ELECTRONIC_USE_TYPE, (byte) -49, TagName.ELECTRONIC_APP_TYPE, (byte) -2, (byte) 33, TagName.PAY_CHANNEL, TagName.CARD_FORM, TagName.SIM_SEID, (byte) -5, TagName.SYSTEM_VERSION, (byte) 3, TagName.CITY_CODE, TagName.ACTIVITY_CODE, TagName.ACTIVITY_STATUS, TagName.ORDER_TRADE_STATUSES, TagName.ACTIVITY_START, TagName.BUSINESS_ORDER_OP_TYPE, TagName.ORDER_BRIEF_INFO_LIST, TagName.ELECTRONIC, TagName.STATION_INFO, TagName.TERMINAL_BACK_QUESTION_FLAG, (byte) 6, TagName.STATION_NAME, (byte) 39, TagName.OPERATION_ID, (byte) -1, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.PROMOTION_MESSAGE, TagName.TERMINAL_BACK_QUESTION_FLAG, TagName.ACTIVITY_STATUS, (byte) 119, TagName.PAY_CHANNEL, (byte) -4, (byte) -32, (byte) 0, TagName.INVOICE_TOKEN_OBJECT_LIST, TagName.PAY_ORDER_LIST, (byte) -41, (byte) 94, TagName.BUSINESS_HANDLE_RESULT, (byte) 75, TagName.PRODUCT_CODE, TagName.ELECTRONIC_OUT_SERIAL, (byte) -80, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.CARD_APP_BLANCE, (byte) -27, ScriptToolsConst.TagName.TagExpectationAndNext, TagName.MAIN_ORDER_ID, TagName.APK_DOWNLOAD_URL, (byte) -27, (byte) -21, (byte) -15, TagName.INVOICE_TOKEN_OBJECT_LIST, TagName.PRODUCT_ID, (byte) -88, TagName.PLATFORM_NOTICES, (byte) 35, TagName.COMPANY_CODE, (byte) -27, (byte) -26, TagName.ACTIVITY_TOTAL, TagName.ELECTRONIC_TYPE_ID, TagName.CARD_APP_ACTIVATION_STATUS, (byte) 35, (byte) -33, TagName.TERMINAL_BASEBAND_VERSION, TagName.ORDER_TERMINAL, (byte) 33, (byte) -23, TagName.INVOICE_TOKEN, TagName.ELECTRONIC_LIST, ScriptToolsConst.TagName.TagSerial, TagName.ELECTRONIC_ID, TagName.SIM_SEID, (byte) -85, TagName.ACTIVITY_END, TagName.ACTIVITY_END, (byte) 33, TagName.ELECTRONIC_FROZEN_FLAG, TagName.BUSINESS_ORDER_LIST, TagName.MAIN_ORDER, (byte) -7, TagName.PRODUCT_CODE});
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            KeyFactory instance2 = KeyFactory.getInstance("RSA");
            Certificate generateCertificate = instance.generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
            return instance2.generatePublic(new X509EncodedKeySpec(generateCertificate.getPublicKey().getEncoded()));
        } catch (IOException e) {
            return null;
        } catch (CertificateException e2) {
            return null;
        } catch (NoSuchAlgorithmException e3) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e4) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e5) {
            throw new Exception("公钥数据为空");
        }
    }

    static String m14146a(String str) {
        String str2 = null;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    str2 = C3193e.m14147a("MD5", C3193e.m14147a("SHA1", str) + str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return str2;
    }

    public static String m14147a(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(str2.getBytes("utf-8"));
            return C3193e.m14154b(instance.digest());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static String m14154b(byte[] bArr) {
        int length = bArr.length;
        StringBuilder stringBuilder = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(f10708a[(bArr[i] >> 4) & 15]);
            stringBuilder.append(f10708a[bArr[i] & 15]);
        }
        return stringBuilder.toString();
    }

    public static String m14153b(String str, String str2) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        byte[] b;
        try {
            b = C3193e.m14155b(str);
        } catch (Exception e) {
            e.printStackTrace();
            b = null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
        byte[] a = C3193e.m14150a(b, str2);
        if (a == null) {
            return null;
        }
        String str3;
        try {
            str3 = new String(a, GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            str3 = null;
        }
        return str3;
    }

    private static byte[] m14155b(String str) {
        int i = 0;
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        String toLowerCase = str.toLowerCase();
        int length = toLowerCase.length() / 2;
        byte[] bArr = new byte[length];
        while (i < length) {
            bArr[i] = (byte) (Integer.parseInt(toLowerCase.substring(i * 2, (i * 2) + 2), 16) & 255);
            i++;
        }
        return bArr;
    }

    public static byte[] m14150a(byte[] bArr, String str) {
        try {
            Key c = C3193e.m14158c(str);
            Cipher instance = Cipher.getInstance("AES/ECB/ZeroBytePadding");
            instance.init(2, c);
            return instance.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static SecretKeySpec m14158c(String str) {
        byte[] bArr = null;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        stringBuffer.append(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes(GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new SecretKeySpec(bArr, "AES");
    }

    public static synchronized byte[] m14156b(byte[] bArr, String str) throws Exception {
        byte[] doFinal;
        int i = 0;
        synchronized (C3193e.class) {
            Key generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C3190b.m14118a(str)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 0;
            while (length - i > 0) {
                if (length - i > Constant.PLAIN_TEXT_MAX_LENGTH) {
                    doFinal = instance.doFinal(bArr, i, Constant.PLAIN_TEXT_MAX_LENGTH);
                } else {
                    doFinal = instance.doFinal(bArr, i, length - i);
                }
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i = i2 + 1;
                int i3 = i;
                i *= Constant.PLAIN_TEXT_MAX_LENGTH;
                i2 = i3;
            }
            doFinal = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        }
        return doFinal;
    }

    public static synchronized byte[] m14159c(byte[] bArr, String str) throws Exception {
        byte[] doFinal;
        int i = 0;
        synchronized (C3193e.class) {
            Key generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C3190b.m14118a(str)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, generatePrivate);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i2 = 0;
            while (length - i > 0) {
                if (length - i > 256) {
                    doFinal = instance.doFinal(bArr, i, 256);
                } else {
                    doFinal = instance.doFinal(bArr, i, length - i);
                }
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i = i2 + 1;
                int i3 = i;
                i *= 256;
                i2 = i3;
            }
            doFinal = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        }
        return doFinal;
    }

    public static byte[] m14157b(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, new SecretKeySpec(bArr, "AES"), f10710c);
        return instance.doFinal(bArr2);
    }

    public static String m14160d(byte[] bArr, String str) {
        String str2 = null;
        try {
            Key c = C3193e.m14158c(str);
            Cipher instance = Cipher.getInstance("AES/ECB/ZeroBytePadding");
            instance.init(1, c);
            byte[] doFinal = instance.doFinal(bArr);
            if (doFinal != null) {
                str2 = C3193e.m14148a(doFinal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    public static String m14148a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        String str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(toHexString);
        }
        return stringBuffer.toString().toUpperCase();
    }
}
