package com.amap.api.services.core;

import android.content.Context;
import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* compiled from: Utils */
public class ae {
    public static String m16619a(String str) {
        if (str == null) {
            return null;
        }
        try {
            String[] split = str.split(SNBConstant.FILTER);
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : split) {
                stringBuffer.append(append);
                stringBuffer.append(SNBConstant.FILTER);
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.length() > 1) {
                return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            ay.m16709a(th, "Utils", "sortParams");
        }
        return str;
    }

    public static byte[] m16621a(byte[] bArr) {
        try {
            return m16626f(bArr);
        } catch (Throwable e) {
            ay.m16709a(e, "Utils", "gZip");
            e.printStackTrace();
            return new byte[0];
        } catch (Throwable e2) {
            ay.m16709a(e2, "Utils", "gZip");
            e2.printStackTrace();
            return new byte[0];
        }
    }

    static PublicKey m16620a(Context context) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        InputStream byteArrayInputStream;
        KeyFactory instance;
        Throwable th;
        Certificate certificate;
        Throwable th2;
        try {
            CertificateFactory instance2;
            byteArrayInputStream = new ByteArrayInputStream(new byte[]{TagName.APK_SIZE, TagName.ACTIVITY_NAME, (byte) 2, TagName.INVOICE_TOKEN_OBJECT_LIST, TagName.APK_SIZE, TagName.ACTIVITY_NAME, (byte) 2, (byte) 7, ScriptToolsConst.TagName.CommandSingle, (byte) 3, (byte) 2, (byte) 1, (byte) 2, (byte) 2, (byte) 9, (byte) 0, TagName.INVOICE_TOKEN_OBJECT, (byte) 15, (byte) 119, TagName.BUSINESS_ORDER_OP_TYPE, TagName.SYSTEM_NEW_VERSION, (byte) -19, TagName.PREDEPOSIT_LIST, (byte) -40, TagName.APK_SIZE, TagName.PAY_CHANNEL, (byte) 6, (byte) 9, (byte) 42, TagName.ACTIVITY_TOTAL, TagName.BUSINESS_ORDER_TYPE, TagName.ACTIVITY_TOTAL, (byte) -9, TagName.PAY_CHANNEL, (byte) 1, (byte) 1, (byte) 5, (byte) 5, (byte) 0, TagName.APK_SIZE, TagName.DEVICE_MODEL, TagName.NOTICE_ID, TagName.IDENTIFYING_TYPE, TagName.APK_SIZE, (byte) 9, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 6, TagName.ORDER_DATE, (byte) 2, TagName.TERMINAL_BACK_INFO_TYPE, (byte) 78, TagName.NOTICE_ID, TagName.ORDER_DATE, TagName.APK_SIZE, (byte) 17, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 8, TagName.IDENTIFYING_CODE, (byte) 10, TagName.TERMINAL_BACK_INFO, TagName.ELECTRONIC_END_TIME, TagName.PUBLISH_END_TIME, TagName.ORDER_TYPE, TagName.APK_UPDATE_FLAG, TagName.TERMINAL_BACK_INFO, TagName.ELECTRONIC_USE_TYPE, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_USE_TYPE, TagName.ORDER_TYPE, TagName.NOTICE_ID, (byte) 16, TagName.APK_SIZE, (byte) 14, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 7, TagName.IDENTIFYING_CODE, (byte) 7, TagName.INVOICE_TOKEN, TagName.ORDER_TYPE, TagName.MAIN_ORDER_ID, TagName.PAY_ORDER_ID, TagName.MAIN_ORDER_ID, TagName.ELECTRONIC_STARTTIME, TagName.PRODUCT_ID, TagName.NOTICE_ID, (byte) 17, TagName.APK_SIZE, (byte) 15, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 10, TagName.IDENTIFYING_CODE, (byte) 8, TagName.TERMINAL_BACK_CONTENT, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_FROZEN_FLAG, TagName.MAIN_ORDER_ID, TagName.NOTICE_ID, TagName.TRADE_STATUS, TagName.APK_SIZE, (byte) 29, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 3, TagName.IDENTIFYING_CODE, TagName.ORDER_TRADE_NO, TagName.PAY_ORDER, TagName.ELECTRONIC_END_TIME, TagName.PUBLISH_END_TIME, TagName.SIM_SEID, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_FROZEN_FLAG, TagName.MAIN_ORDER_ID, TagName.SIM_SEID, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_ID, TagName.MAIN_ORDER_ID, TagName.ELECTRONIC_TYPE, TagName.ORDER_TYPE, TagName.ELECTRONIC_NUMBER, TagName.ELECTRONIC_FROZEN_FLAG, TagName.ORDER_TYPE, TagName.ELECTRONIC_NUMBER, TagName.APK_SIZE, TagName.ORDER_CHANNEL, TagName.ORDER_TERMINAL, TagName.PAY_CHANNEL, TagName.NOTICE_ID, TagName.ACTIVITY_CODE_LIST, TagName.APK_SIZE, ScriptToolsConst.TagName.TagSerial, TagName.NOTICE_ID, (byte) 53, TagName.APK_SIZE, TagName.NOTICE_END_TIME, (byte) 53, TagName.NOTICE_START_TIME, (byte) 53, (byte) 53, TagName.PREDEPOSIT_TOTAL, TagName.ORDER_TERMINAL, TagName.PAY_CHANNEL, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.APK_SIZE, ScriptToolsConst.TagName.TagSerial, TagName.NOTICE_ID, TagName.ACTIVITY_CODE_LIST, TagName.APK_SIZE, TagName.NOTICE_END_TIME, (byte) 53, TagName.NOTICE_START_TIME, (byte) 53, (byte) 53, TagName.PREDEPOSIT_TOTAL, TagName.APK_SIZE, TagName.DEVICE_MODEL, TagName.NOTICE_ID, TagName.IDENTIFYING_TYPE, TagName.APK_SIZE, (byte) 9, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 6, TagName.ORDER_DATE, (byte) 2, TagName.TERMINAL_BACK_INFO_TYPE, (byte) 78, TagName.NOTICE_ID, TagName.ORDER_DATE, TagName.APK_SIZE, (byte) 17, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 8, TagName.IDENTIFYING_CODE, (byte) 10, TagName.TERMINAL_BACK_INFO, TagName.ELECTRONIC_END_TIME, TagName.PUBLISH_END_TIME, TagName.ORDER_TYPE, TagName.APK_UPDATE_FLAG, TagName.TERMINAL_BACK_INFO, TagName.ELECTRONIC_USE_TYPE, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_USE_TYPE, TagName.ORDER_TYPE, TagName.NOTICE_ID, (byte) 16, TagName.APK_SIZE, (byte) 14, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 7, TagName.IDENTIFYING_CODE, (byte) 7, TagName.INVOICE_TOKEN, TagName.ORDER_TYPE, TagName.MAIN_ORDER_ID, TagName.PAY_ORDER_ID, TagName.MAIN_ORDER_ID, TagName.ELECTRONIC_STARTTIME, TagName.PRODUCT_ID, TagName.NOTICE_ID, (byte) 17, TagName.APK_SIZE, (byte) 15, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 10, TagName.IDENTIFYING_CODE, (byte) 8, TagName.TERMINAL_BACK_CONTENT, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_FROZEN_FLAG, TagName.MAIN_ORDER_ID, TagName.NOTICE_ID, TagName.TRADE_STATUS, TagName.APK_SIZE, (byte) 29, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 4, (byte) 3, TagName.IDENTIFYING_CODE, TagName.ORDER_TRADE_NO, TagName.PAY_ORDER, TagName.ELECTRONIC_END_TIME, TagName.PUBLISH_END_TIME, TagName.SIM_SEID, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_TRANSFER_FLAG, TagName.ELECTRONIC_USE_TYPE, TagName.ELECTRONIC_END_TIME, TagName.ELECTRONIC_STARTTIME, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_FROZEN_FLAG, TagName.MAIN_ORDER_ID, TagName.SIM_SEID, TagName.MAIN_ORDER_LIST, TagName.ELECTRONIC_ID, TagName.MAIN_ORDER_ID, TagName.ELECTRONIC_TYPE, TagName.ORDER_TYPE, TagName.ELECTRONIC_NUMBER, TagName.ELECTRONIC_FROZEN_FLAG, TagName.ORDER_TYPE, TagName.ELECTRONIC_NUMBER, TagName.APK_SIZE, TagName.ACTIVITY, (byte) -97, TagName.APK_SIZE, TagName.PAY_CHANNEL, (byte) 6, (byte) 9, (byte) 42, TagName.ACTIVITY_TOTAL, TagName.BUSINESS_ORDER_TYPE, TagName.ACTIVITY_TOTAL, (byte) -9, TagName.PAY_CHANNEL, (byte) 1, (byte) 1, (byte) 1, (byte) 5, (byte) 0, (byte) 3, TagName.ACTIVITY, TagName.ACTIVITY_STATUS, (byte) 0, TagName.APK_SIZE, TagName.ACTIVITY, TagName.COMPANY_CODE, (byte) 2, TagName.ACTIVITY, TagName.ACTIVITY, (byte) 0, (byte) -15, (byte) -27, Byte.MIN_VALUE, TagName.PROMOTION_MESSAGE_DATA, TagName.ELECTRONIC_FROZEN_FLAG, TagName.USER_PLATFORM_ID, TagName.CARD_BUSINESS_ORDER_STATUS, TagName.ACTIVITY, TagName.CP_NO, TagName.ELECTRONIC_PRICE_FAVOURABLE, (byte) -36, TagName.ELECTRONIC_STATE, (byte) 0, TagName.CARD_APP_ACTIVATION_STATUS, TagName.ACTIVITY_CODE, (byte) -30, TagName.ELECTRONIC_FROZEN_FLAG, (byte) 5, (byte) -85, TagName.ACTIVITY_REMAINDER, TagName.PREDEPOSIT_BLANCE, (byte) 39, TagName.PREDEPOSIT_TOTAL, TagName.ELECTRONIC_USE_TIME, TagName.BUSINESS_ORDER_TYPE, TagName.ACTIVITY_NAME, (byte) -83, (byte) -41, (byte) -45, TagName.APP_AID, (byte) -42, TagName.ACTIVITY_DEFINITION, (byte) -81, TagName.ORDER_TERMINAL, (byte) -2, TagName.ACTIVITY_REMAINDER, (byte) -29, TagName.ELECTRONIC_USE_TIME, (byte) -7, TagName.ORDER_TRADE_NO, TagName.URL_TYPE, (byte) -20, (byte) -25, (byte) 74, TagName.TERMINAL_BACK_INFO_TYPE, (byte) -43, TagName.TERMINAL_BACK_CONTENT, TagName.PRICE, (byte) -7, TagName.IDENTIFYING_TYPE, TagName.EUID, TagName.QUERY_RECORD_COUNT, TagName.ACTIVITY_END, (byte) 16, TagName.PROMOTION_MESSAGE, TagName.ORDER_BRIEF_INFO_LIST, (byte) 32, TagName.BUSINESS_ORDER_OP_TYPE, (byte) -33, (byte) 14, TagName.IDENTIFYING_TYPE, TagName.USER_LOGIN_FAIL_COUNT, ScriptToolsConst.TagName.TagExpectationAndNext, TagName.PAY_CHANNEL, TagName.ACTIVITY_REMAINDER, TagName.PAY_ORDER_LIST, TagName.MAIN_ORDER_ID, (byte) -32, TagName.ELECTRONIC_USE_TIME, (byte) -31, TagName.ELECTRONIC_NUMBER, TagName.CITY_CODE, (byte) -41, TagName.IDENTIFYING_CODE, TagName.PAY_ORDER_LIST, (byte) 33, TagName.ACTIVITY_DEFINITION, TagName.CARD_APP_ACTIVATION_STATUS, TagName.ELECTRONIC_OUT_SERIAL, TagName.ACTIVITY_END, TagName.APK_SIZE, TagName.NOTICE_END_TIME, TagName.ORDER_BRIEF_INFO_LIST, TagName.PREDEPOSIT_STATUS, TagName.APK_DOWNLOAD_URL, (byte) -10, TagName.ELECTRONIC_PRICE_FAVOURABLE, TagName.CARD_APP_RAMDOM, (byte) -41, ScriptToolsConst.TagName.ScriptDown, TagName.ACTIVITY_NAME, TagName.ELECTRONIC_FROZEN_FLAG, TagName.IMEI, TagName.USER_LOCK_TIME, TagName.ACTIVITY, (byte) 9, TagName.TERMINAL_INFO_TYPE, TagName.PRODUCT_LIST, (byte) 81, (byte) -19, TagName.URL_TYPE, (byte) -41, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.PRODUCT_CODE, (byte) -37, TagName.PREDEPOSIT_STATUS, TagName.ELECTRONIC_FROZEN_FLAG, TagName.BUSINESS_ORDER_TYPE, TagName.QUERY_DATA_SORT_TYPE, TagName.ELECTRONIC_PRICE_FAVOURABLE, (byte) -43, ScriptToolsConst.TagName.CommandMultiple, (byte) -11, TagName.CARD_APP_ACTIVATION_STATUS, TagName.TERMINAL_MODEL_NUMBER, (byte) -38, (byte) -10, TagName.STATION_ID, TagName.ELECTRONIC_OUT_SERIAL, (byte) -53, TagName.ACTIVITY_STATUS, ScriptToolsConst.TagName.TagExpectationAndNext, TagName.CARD_BUSINESS_ORDER_STATUS, (byte) -86, (byte) -80, (byte) 1, (byte) 39, TagName.ORDER_DATE, (byte) 2, (byte) 3, (byte) 1, (byte) 0, (byte) 1, ScriptToolsConst.TagName.ResponseMultiple, TagName.ORDER_BRIEF_INFO_LIST, TagName.APK_SIZE, (byte) 78, TagName.APK_SIZE, (byte) 29, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 29, (byte) 14, (byte) 4, TagName.ORDER_TRADE_NO, (byte) 4, TagName.ORDER_TIME, (byte) -29, TagName.CARD_APP_ACTIVATION_STATUS, TagName.APK_SIZE, TagName.SEID, TagName.URL_LIST, (byte) -13, TagName.BUSINESS_ORDER, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.ORDER_TRADE_NO, (byte) -27, TagName.TERMINAL_INFO_TYPE, (byte) -5, TagName.ELECTRONIC_OUT_STATE, TagName.PRODUCT_CODE, TagName.PLATFORM_NOTICES, (byte) 14, (byte) -18, (byte) 6, (byte) -13, TagName.PLATFORM_NOTICES, TagName.APK_SIZE, TagName.TRADE_STATUS, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 29, (byte) 35, (byte) 4, TagName.ORDER_INVOICE_STATUS, TagName.APK_SIZE, TagName.ORDER_TRADE_NO, Byte.MIN_VALUE, TagName.ORDER_TIME, (byte) -29, TagName.CARD_APP_ACTIVATION_STATUS, TagName.APK_SIZE, TagName.SEID, TagName.URL_LIST, (byte) -13, TagName.BUSINESS_ORDER, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.ORDER_TRADE_NO, (byte) -27, TagName.TERMINAL_INFO_TYPE, (byte) -5, TagName.ELECTRONIC_OUT_STATE, TagName.PRODUCT_CODE, TagName.PLATFORM_NOTICES, (byte) 14, (byte) -18, (byte) 6, (byte) -13, TagName.PLATFORM_NOTICES, TagName.APK_SIZE, TagName.IDENTIFYING_CODE, (byte) 6, (byte) 3, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) 29, TagName.ORDER_DATE, (byte) 4, (byte) 5, TagName.APK_SIZE, (byte) 3, (byte) 1, (byte) 1, (byte) -1, TagName.APK_SIZE, TagName.PAY_CHANNEL, (byte) 6, (byte) 9, (byte) 42, TagName.ACTIVITY_TOTAL, TagName.BUSINESS_ORDER_TYPE, TagName.ACTIVITY_TOTAL, (byte) -9, TagName.PAY_CHANNEL, (byte) 1, (byte) 1, (byte) 5, (byte) 5, (byte) 0, (byte) 3, TagName.ACTIVITY, TagName.ACTIVITY, (byte) 0, (byte) -32, TagName.CPLC, TagName.NOTICE_END_TIME, TagName.ACTIVITY_CODE, TagName.PROMOTION_MESSAGE, Byte.MIN_VALUE, (byte) 15, TagName.RENT_HANDLE_TYPE, TagName.PAY_ORDER_LIST, TagName.USER_PLATFORM_TYPE, (byte) 3, (byte) -86, (byte) 81, TagName.ELECTRONIC_ID, TagName.RENT_HANDLE_DATD, TagName.PROMOTION_MESSAGE_DATA, TagName.APP_MANAGE_OPEATE_TYPE, TagName.ACTIVITY_NAME, (byte) 8, TagName.PAY_ORDER, TagName.PRODUCT_LIST, (byte) -38, TagName.UNSOLVED_NOTICES, TagName.PROMOTION_MESSAGE_DATA, TagName.ACTIVITY_TOTAL, TagName.ELECTRONIC_PRICE_FAVOURABLE, TagName.ORDER_DATE, TagName.STATION_ENAME, TagName.RENT_HANDLE_DATD, TagName.PREDEPOSIT_TOTAL, TagName.TERMINAL_BACK_CHILDREN_ID, (byte) -47, (byte) -8, TagName.ACTIVITY_END, TagName.PRODUCT_CODE, TagName.MAIN_ORDER_ID, (byte) 77, (byte) -32, TagName.STATION_ID, TagName.RENT_HANDLE_TYPE, (byte) -28, TagName.TERMINAL_BACK_INFO_TYPE, (byte) -28, TagName.APP_TYPE, TagName.ELECTRONIC_USE_TYPE, (byte) -49, TagName.ELECTRONIC_APP_TYPE, (byte) -2, (byte) 33, TagName.PAY_CHANNEL, TagName.CARD_FORM, TagName.SIM_SEID, (byte) -5, TagName.SYSTEM_VERSION, (byte) 3, TagName.CITY_CODE, TagName.ACTIVITY_CODE, TagName.ACTIVITY_STATUS, TagName.ORDER_TRADE_STATUSES, TagName.ACTIVITY_START, TagName.BUSINESS_ORDER_OP_TYPE, TagName.ORDER_BRIEF_INFO_LIST, TagName.ELECTRONIC, TagName.STATION_INFO, TagName.TERMINAL_BACK_QUESTION_FLAG, (byte) 6, TagName.STATION_NAME, (byte) 39, TagName.OPERATION_ID, (byte) -1, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.PROMOTION_MESSAGE, TagName.TERMINAL_BACK_QUESTION_FLAG, TagName.ACTIVITY_STATUS, (byte) 119, TagName.PAY_CHANNEL, (byte) -4, (byte) -32, (byte) 0, TagName.INVOICE_TOKEN_OBJECT_LIST, TagName.PAY_ORDER_LIST, (byte) -41, (byte) 94, TagName.BUSINESS_HANDLE_RESULT, (byte) 75, TagName.PRODUCT_CODE, TagName.ELECTRONIC_OUT_SERIAL, (byte) -80, TagName.TERMINAL_BACK_CHILDREN_ID, TagName.CARD_APP_BLANCE, (byte) -27, ScriptToolsConst.TagName.TagExpectationAndNext, TagName.MAIN_ORDER_ID, TagName.APK_DOWNLOAD_URL, (byte) -27, (byte) -21, (byte) -15, TagName.INVOICE_TOKEN_OBJECT_LIST, TagName.PRODUCT_ID, (byte) -88, TagName.PLATFORM_NOTICES, (byte) 35, TagName.COMPANY_CODE, (byte) -27, (byte) -26, TagName.ACTIVITY_TOTAL, TagName.ELECTRONIC_TYPE_ID, TagName.CARD_APP_ACTIVATION_STATUS, (byte) 35, (byte) -33, TagName.TERMINAL_BASEBAND_VERSION, TagName.ORDER_TERMINAL, (byte) 33, (byte) -23, TagName.INVOICE_TOKEN, TagName.ELECTRONIC_LIST, ScriptToolsConst.TagName.TagSerial, TagName.ELECTRONIC_ID, TagName.SIM_SEID, (byte) -85, TagName.ACTIVITY_END, TagName.ACTIVITY_END, (byte) 33, TagName.ELECTRONIC_FROZEN_FLAG, TagName.BUSINESS_ORDER_LIST, TagName.MAIN_ORDER, (byte) -7, TagName.PRODUCT_CODE});
            try {
                instance2 = CertificateFactory.getInstance("X.509");
                instance = KeyFactory.getInstance("RSA");
            } catch (Throwable th3) {
                th = th3;
                instance = null;
                try {
                    th.printStackTrace();
                    if (byteArrayInputStream != null) {
                        certificate = null;
                    } else {
                        byteArrayInputStream.close();
                        certificate = null;
                    }
                    return certificate == null ? null : null;
                } catch (Throwable th4) {
                    th2 = th4;
                    if (byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                    throw th2;
                }
            }
            try {
                certificate = instance2.generateCertificate(byteArrayInputStream);
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
            } catch (Throwable th5) {
                th = th5;
                th.printStackTrace();
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                    certificate = null;
                } else {
                    certificate = null;
                }
                if (certificate == null) {
                }
            }
        } catch (Throwable th6) {
            byteArrayInputStream = null;
            th2 = th6;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th2;
        }
        if (certificate == null && instance != null) {
            return instance.generatePublic(new X509EncodedKeySpec(certificate.getPublicKey().getEncoded()));
        }
    }

    public static byte[] m16622b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ZipOutputStream zipOutputStream;
        Throwable th;
        ay b;
        ay b2;
        Throwable th2;
        byte[] bArr2 = null;
        if (!(bArr == null || bArr.length == 0)) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                } catch (Throwable th3) {
                    zipOutputStream = bArr2;
                    th2 = th3;
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th2;
                }
                try {
                    zipOutputStream.putNextEntry(new ZipEntry("log"));
                    zipOutputStream.write(bArr);
                    zipOutputStream.closeEntry();
                    zipOutputStream.finish();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (Throwable th32) {
                            b = ay.m16710b();
                            if (b != null) {
                                b.m16712b(th32, "Utils", "zip1");
                            }
                            th32.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th4) {
                            th32 = th4;
                            b2 = ay.m16710b();
                            if (b2 != null) {
                                b2.m16712b(th32, "Utils", "zip2");
                            }
                            th32.printStackTrace();
                            return bArr2;
                        }
                    }
                } catch (Throwable th5) {
                    th32 = th5;
                    th32.printStackTrace();
                    ay.m16709a(th32, "Utils", "zip");
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    return bArr2;
                }
            } catch (Throwable th322) {
                byteArrayOutputStream = bArr2;
                zipOutputStream = bArr2;
                th2 = th322;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th2;
            }
        }
        return bArr2;
    }

    static String m16623c(byte[] bArr) {
        try {
            return m16625e(bArr);
        } catch (Throwable th) {
            ay.m16709a(th, "Utils", "HexString");
            th.printStackTrace();
            return null;
        }
    }

    static String m16624d(byte[] bArr) {
        try {
            return m16625e(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String m16625e(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = '0' + toHexString;
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    private static byte[] m16626f(byte[] bArr) throws IOException, Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        IOException e;
        Throwable th;
        Throwable th2;
        byte[] bArr2 = null;
        if (bArr != null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.finish();
                        bArr2 = byteArrayOutputStream.toByteArray();
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            throw e;
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                } catch (IOException e3) {
                    IOException iOException = e3;
                    gZIPOutputStream = null;
                    e = iOException;
                    throw e;
                } catch (Throwable th5) {
                    th2 = th5;
                    gZIPOutputStream = null;
                    th = th2;
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e32) {
                byteArrayOutputStream = null;
                e = e32;
                gZIPOutputStream = null;
                throw e;
            } catch (Throwable th52) {
                byteArrayOutputStream = null;
                th = th52;
                gZIPOutputStream = null;
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
        return bArr2;
    }
}
