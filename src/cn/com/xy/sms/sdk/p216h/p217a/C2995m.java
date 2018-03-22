package cn.com.xy.sms.sdk.p216h.p217a;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.xy.sms.sdk.p207c.C2917a;
import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3046k;
import cn.com.xy.sms.sdk.p229l.C3049n;
import cn.com.xy.sms.sdk.p229l.C3055t;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class C2995m {
    private static HashMap<String, Boolean> f10127a = new HashMap();
    private static HashMap<String, Integer> f10128b = new HashMap();

    public static Boolean m13475a(String str) {
        if (!C3055t.m13704a(str)) {
            return Boolean.valueOf(false);
        }
        Boolean bool = (Boolean) f10127a.get(str);
        if (bool != null) {
            return bool;
        }
        C2917a.m13105a();
        String b = C2995m.m13480b(str);
        bool = (C3049n.m13653e(b) || b.indexOf("95ad98c4ba9a0ec12a7dca2af77f312bef6fd02580c23fc082b28f1cab03d9d5b7694bd5dd9693a8b6786c9480dfbcc462373bd1b9f5bed66151be80a370465d6516f89e66d6d70ba52a3d063acbe4544a585d62896d953b3269efd345ff888e5ed7f7f7b60c862ca5a27f20ccdba704113a9861fcd91cf3f0fd7115987568d04f444224b3c2436b833ed0439b4fa8c92e938827f360b6a4a070fed4608a46c8a52023fabfd2561bcd4205052254caaffe9a55aa73254537a1a2c0efbcd76254bef3e01902ffee20b0a45b6c8e6beb496c9c3494d263dedf0fff4702ebbfee0cb568da4940b8f5f8c89aa96b2c21e2ff9596e30e26b18e1b563353843ee95787") == -1) ? Boolean.valueOf(false) : Boolean.valueOf(true);
        f10127a.put(str, bool);
        return bool;
    }

    public static String m13476a(String str, String str2) {
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(new StringBuilder(String.valueOf(str)).append(str2).toString())));
            try {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        String trim = stringBuffer.toString().trim();
                        try {
                            bufferedReader.close();
                            return trim;
                        } catch (Throwable e) {
                            C2982a.m13415a("XIAOYUAN", "getVerifyCode: " + e.getMessage(), e);
                            return trim;
                        }
                    }
                    stringBuffer.append(readLine);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable e2) {
            Throwable th3 = e2;
            bufferedReader = null;
            th = th3;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable e22) {
                    C2982a.m13415a("XIAOYUAN", "getVerifyCode: " + e22.getMessage(), e22);
                }
            }
            throw th;
        }
    }

    public static boolean m13477a() {
        C3046k.m13626a();
        return true;
    }

    public static boolean m13478a(byte b) {
        try {
            C3046k.m13626a();
        } catch (Throwable th) {
            C2982a.m13415a("XIAOYUAN", "checkChannelFuncPower " + th.getMessage(), th);
        }
        return C3049n.m13653e(C3046k.f10294a) ? false : "XwIDAQABYUN".equals(C3046k.f10294a) ? b == (byte) 2 || b == (byte) 4 : "NQIDAQABCOOL".equals(C3046k.f10294a) ? b != (byte) 1 ? b == TagName.IDENTIFYING_CODE ? true : true : false : "6QIDAQABSTARRYSKY".equals(C3046k.f10294a) ? b != (byte) 1 : "vwIDAQABLIANLUOOS".equals(C3046k.f10294a) ? b != (byte) 1 : "FEhNrwHTXL".equals(C3046k.f10294a) ? b == (byte) 1 : "1i1BDH2wONE+".equals(C3046k.f10294a) ? b != (byte) 1 : "Oq1QGcwIYUNOS".equals(C3046k.f10294a) ? (b == (byte) 1 || b == (byte) 2) ? false : true : "j3FIT5mwLETV".equals(C3046k.f10294a) ? b != (byte) 1 : "D6mKXM8MEIZU".equals(C3046k.f10294a) ? b != (byte) 1 : "3GdfMSKwHUAWEI".equals(C3046k.f10294a) ? b != (byte) 1 : "0GCSqGSITOS".equals(C3046k.f10294a) ? b != (byte) 1 : "wupzCqnwGUAIWU".equals(C3046k.f10294a) ? b != (byte) 1 : "XRyvMvZwSMARTISAN".equals(C3046k.f10294a) ? b != (byte) 1 : "dToXA5JQDAKELE".equals(C3046k.f10294a) ? b != (byte) 1 : "p5O4wKmwGIONEE".equals(C3046k.f10294a) ? b != (byte) 1 : "z5N7W51wKINGSUN".equals(C3046k.f10294a) ? b != (byte) 1 : "Cko59T6wSUGAR".equals(C3046k.f10294a) ? b != (byte) 1 : "oWIH+3ZQLEIDIANOS".equals(C3046k.f10294a) ? b != (byte) 1 : "al30zFgQTEST_T".equals(C3046k.f10294a) ? b != (byte) 1 : "gsjHPHwIKOOBEE".equals(C3046k.f10294a) ? b != (byte) 1 : "AjAFrJSQWENTAI".equals(C3046k.f10294a) ? b != (byte) 1 : "JqyMtaHQNUBIA".equals(C3046k.f10294a) ? b != (byte) 1 : "15Du354QGIONEECARD".equals(C3046k.f10294a) ? b != (byte) 1 : "rahtBH7wTCL".equals(C3046k.f10294a) ? b != (byte) 1 : "xU6UT6pwTOS2".equals(C3046k.f10294a) ? b != (byte) 1 : "5Gx84kmwYULONG_COOLPAD".equals(C3046k.f10294a) ? b != (byte) 1 : "tnjdWFeQKTOUCH".equals(C3046k.f10294a) ? b != (byte) 1 : "Uj2pznXQHCT".equals(C3046k.f10294a) ? b != (byte) 1 : "XkXZJmwIPPTV".equals(C3046k.f10294a) ? b != (byte) 1 : "PzqP0ONQTOSWATCH".equals(C3046k.f10294a) ? b != (byte) 1 : "VCTyBOSwSmartisan".equals(C3046k.f10294a) ? b != (byte) 1 : "HUAWEITMW".equals(C3046k.f10294a) ? b != (byte) 1 : "HUAWEIAND".equals(C3046k.f10294a) ? b != (byte) 1 : "5rLWVKgQMEITU_PHONE".equals(C3046k.f10294a) ? b != (byte) 1 : "zcK2P6yQINNOS".equals(C3046k.f10294a) ? b != (byte) 1 : "J2kSrxdQGigaset".equals(C3046k.f10294a) ? b != (byte) 1 : "RbWRsTYQdroi".equals(C3046k.f10294a) ? b != (byte) 1 : "5zZZdrFQIUNI".equals(C3046k.f10294a) ? b != (byte) 1 : "nZpg6u3wDOOV".equals(C3046k.f10294a) ? b != (byte) 1 : "RQIDAQABONEPLUSCARDNEW".equals(C3046k.f10294a) ? b != (byte) 1 : "i3GPvZLwASUS".equals(C3046k.f10294a) ? b != (byte) 1 : "cNNrw5WQEBEN".equals(C3046k.f10294a) ? b != (byte) 1 : "cNNrw5WQEBEN".equals(C3046k.f10294a) ? b != (byte) 1 : "UdcqV6aQLANMO".equals(C3046k.f10294a) ? b != (byte) 1 : "PunKwZfwHISENSE".equals(C3046k.f10294a) ? b != (byte) 1 : "gO0o2CXwVIVO".equals(C3046k.f10294a) ? b != (byte) 1 : "kpGIJXywSAMSUNGFLOW".equals(C3046k.f10294a) ? b != (byte) 1 : "DEaerxdwASUSCARD".equals(C3046k.f10294a) ? b != (byte) 1 : "d7tjnrkwCNSAMSUNG".equals(C3046k.f10294a) ? b != (byte) 1 : "NVbQx3QQMEIZUCENTER".equals(C3046k.f10294a) ? b != (byte) 1 : "K8wgPuIwFREEMEOS".equals(C3046k.f10294a) ? b != (byte) 1 : "uDM3hYtwGIGASET".equals(C3046k.f10294a) ? b != (byte) 1 : "OmwdltCwONEPLUS2".equals(C3046k.f10294a) ? b != (byte) 1 : "eOXJhLyQLINGHIT".equals(C3046k.f10294a) ? b != (byte) 1 : "BywgBsYQZTE2".equals(C3046k.f10294a) ? b != (byte) 1 : "ZkhM4GyQ360OS".equals(C3046k.f10294a) ? b != (byte) 1 : "7N4EhHawHUAWEI2".equals(C3046k.f10294a) ? b != (byte) 1 : true;
    }

    private static Certificate[] m13479a(JarFile jarFile, JarEntry jarEntry) {
        Throwable e;
        Throwable th;
        Certificate[] certificateArr = null;
        InputStream inputStream;
        try {
            byte[] bArr = new byte[1024];
            inputStream = jarFile.getInputStream(jarEntry);
            do {
                try {
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    e = th2;
                }
            } while (inputStream.read(bArr, 0, 1024) != -1);
            if (jarEntry != null) {
                certificateArr = jarEntry.getCertificates();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th3) {
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            try {
                C2982a.m13415a("XIAOYUAN", "loadCertificates: " + e.getMessage(), e);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th4) {
                    }
                }
                return certificateArr;
            } catch (Throwable th5) {
                th = th5;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th6) {
                    }
                }
                throw th;
            }
        } catch (Throwable e4) {
            inputStream = null;
            th = e4;
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
        return certificateArr;
    }

    private static String m13480b(String str) {
        Throwable th;
        JarFile jarFile;
        try {
            jarFile = new JarFile(str);
            try {
                Certificate[] a = C2995m.m13479a(jarFile, jarFile.getJarEntry("classes.dex"));
                if (a == null || a.length <= 0 || a.length <= 0) {
                    jarFile.close();
                    try {
                        jarFile.close();
                    } catch (Throwable th2) {
                    }
                    return "";
                }
                String obj = a[0].getPublicKey().toString();
                try {
                    jarFile.close();
                    return obj;
                } catch (Throwable th3) {
                    return obj;
                }
            } catch (Throwable th4) {
                th = th4;
                try {
                    C2982a.m13415a("XIAOYUAN", "getSignature: " + th.getMessage(), th);
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Throwable th5) {
                        }
                    }
                    return "";
                } catch (Throwable th6) {
                    th = th6;
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Throwable th7) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th8) {
            th = th8;
            jarFile = null;
            if (jarFile != null) {
                jarFile.close();
            }
            throw th;
        }
    }
}
