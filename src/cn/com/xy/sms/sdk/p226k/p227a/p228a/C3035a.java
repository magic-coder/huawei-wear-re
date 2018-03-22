package cn.com.xy.sms.sdk.p226k.p227a.p228a;

import cn.com.xy.sms.sdk.p215g.C2982a;
import cn.com.xy.sms.sdk.p229l.C3046k;
import com.sina.weibo.sdk.component.GameManager;
import java.nio.charset.Charset;

public class C3035a {
    private static int f10255a = -1;
    private static int f10256b = -1;
    private static final Charset f10257c = Charset.forName(GameManager.DEFAULT_CHARSET);

    public static int m13581a() {
        if (f10256b == -1) {
            try {
                C3046k.m13626a();
            } catch (Throwable th) {
                C2982a.m13415a("XIAOYUAN", "getChannelType: " + th.getMessage(), th);
            }
            if ("NQIDAQABCOOL".equals(C3046k.f10294a)) {
                f10256b = 1;
            } else if ("1w36SBLwVNEW_ZTE".equals(C3046k.f10294a)) {
                f10256b = 2;
            } else if ("GwIDAQABZTE".equals(C3046k.f10294a)) {
                f10256b = 4;
            } else if ("VMhlWdEwVNEW_LENOVO".equals(C3046k.f10294a)) {
                f10256b = 3;
            } else if ("Oq3iD6UlMAGIC".equals(C3046k.f10294a)) {
                f10256b = 5;
            } else if ("1i1BDH2wONE+".equals(C3046k.f10294a) || "1i1BDH2wONE+CARD".equals(C3046k.f10294a)) {
                f10256b = 6;
            } else if ("3GdfMSKwHUAWEI".equals(C3046k.f10294a)) {
                f10256b = 7;
            } else if ("rq7Fyxl5DUOQU".equals(C3046k.f10294a)) {
                f10256b = 8;
            } else if ("j3FIT5mwLETV".equals(C3046k.f10294a)) {
                f10256b = 9;
            } else if ("0GCSqGSITOS".equals(C3046k.f10294a)) {
                f10256b = 10;
            } else if ("D6mKXM8MEIZU".equals(C3046k.f10294a)) {
                f10256b = 11;
            } else if ("XRyvMvZwSMARTISAN".equals(C3046k.f10294a)) {
                f10256b = 2;
            } else if ("dToXA5JQDAKELE".equals(C3046k.f10294a)) {
                f10256b = 2;
            } else if ("p5O4wKmwGIONEE".equals(C3046k.f10294a)) {
                f10256b = 10;
            } else if ("z5N7W51wKINGSUN".equals(C3046k.f10294a)) {
                f10256b = 1;
            } else if ("Cko59T6wSUGAR".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("oWIH+3ZQLEIDIANOS".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("al30zFgQTEST_T".equals(C3046k.f10294a)) {
                f10256b = 10;
            } else if ("gsjHPHwIKOOBEE".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("AjAFrJSQWENTAI".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("JqyMtaHQNUBIA".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("15Du354QGIONEECARD".equals(C3046k.f10294a)) {
                f10256b = 13;
            } else if ("rahtBH7wTCL".equals(C3046k.f10294a)) {
                f10256b = 14;
            } else if ("xU6UT6pwTOS2".equals(C3046k.f10294a)) {
                f10256b = 15;
            } else if ("5Gx84kmwYULONG_COOLPAD".equals(C3046k.f10294a)) {
                f10256b = 16;
            } else if ("tnjdWFeQKTOUCH".equals(C3046k.f10294a)) {
                f10256b = 19;
            } else if ("Uj2pznXQHCT".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("XkXZJmwIPPTV".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("dGxSiEbwTOSCARD".equals(C3046k.f10294a)) {
                f10256b = 17;
            } else if ("PzqP0ONQTOSWATCH".equals(C3046k.f10294a)) {
                f10256b = 18;
            } else if ("VCTyBOSwSmartisan".equals(C3046k.f10294a)) {
                f10256b = 18;
            } else if ("5rLWVKgQMEITU_PHONE".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("zcK2P6yQINNOS".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("RbWRsTYQdroi".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("J2kSrxdQGigaset".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("5zZZdrFQIUNI".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("nZpg6u3wDOOV".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("i3GPvZLwASUS".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("NsJCCyFwPHILIPS".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("cNNrw5WQEBEN".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("UdcqV6aQLANMO".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("PunKwZfwHISENSE".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("gO0o2CXwVIVO".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("K8wgPuIwFREEMEOS".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("DAS9exiQQIKUBOX".equals(C3046k.f10294a)) {
                f10256b = 20;
            } else if ("d7tjnrkwCNSAMSUNG".equals(C3046k.f10294a)) {
                f10256b = 22;
            } else if ("uDM3hYtwGIGASET".equals(C3046k.f10294a)) {
                f10256b = 12;
            } else if ("OmwdltCwONEPLUS2".equals(C3046k.f10294a)) {
                f10256b = 23;
            } else if ("BywgBsYQZTE2".equals(C3046k.f10294a)) {
                f10256b = 24;
            } else if ("ZkhM4GyQ360OS".equals(C3046k.f10294a)) {
                f10256b = 25;
            } else if ("7N4EhHawHUAWEI2".equals(C3046k.f10294a)) {
                f10256b = 26;
            } else {
                f10256b = 0;
            }
        }
        return f10256b;
    }

    public static String m13582a(int i) {
        return i == 1 ? "3F3DCX" : "363OFT";
    }
}
