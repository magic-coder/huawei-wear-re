package cn.com.fmsh.util.algorithm;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import com.huawei.hihealth.HiUserInfo;
import com.huawei.nfc.carrera.ui.NFCBaseActivity;
import java.security.MessageDigest;
import java.util.Random;

public class Digest {
    private static /* synthetic */ FMLog f9855a = LogFactory.getInstance().getLog();

    public static void main(String[] strArr) {
        byte[] bArr = new byte[64];
        new Random().nextBytes(bArr);
        bArr = md5(bArr);
        System.out.println(new StringBuilder(CRCUtil.substring(88, ")55aet=")).append(bArr.length).toString());
        System.out.println(FM_Bytes.bytesToHexString(bArr));
    }

    public static byte[] md5(byte[] bArr) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(FM_Exception.insert(NFCBaseActivity.TO_ADD, 105, "\u000f\u000f!"));
        } catch (Exception e) {
            f9855a.error(Digest.class.getName(), FM_CN.equals("削妃协奻贾＀Pk,# 5&Plqb+=乗敤挝@Z:。", 4));
            f9855a.error(Digest.class.getName(), Util4Java.getExceptionInfo(e));
        }
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static byte[] sha(byte[] bArr) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(FM_Bytes.concat("R\u001b\u0004", HiUserInfo.HEIGHT_DEFAULT, 82));
        } catch (Exception e) {
            f9855a.error(Digest.class.getName(), CRCUtil.substring(320, "剐妓单奿赼（Bvcz!4\u0018.58{g专攦挕L\u0002\u0014あ"));
            f9855a.error(Digest.class.getName(), Util4Java.getExceptionInfo(e));
        }
        messageDigest.update(bArr);
        return messageDigest.digest();
    }
}
