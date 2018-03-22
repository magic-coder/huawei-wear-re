package cn.com.fmsh.util.algorithm;

import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Util4Certificate {
    private static /* synthetic */ FMLog f9859a = LogFactory.getInstance().getLog();

    public static Certificate decodeCertificate(byte[] bArr) {
        try {
            return (X509Certificate) CertificateFactory.getInstance(FM_Int.replace(138, "\u0007,082")).generateCertificate(new ByteArrayInputStream(bArr));
        } catch (Exception e) {
            f9859a.error(DES.class.getName(), Util4Java.getExceptionInfo(e));
            return null;
        }
    }

    public static Certificate getCertificate(InputStream inputStream) throws Exception {
        return CertificateFactory.getInstance(Util4Java.endsWith("Y65>", 4, 2)).generateCertificate(inputStream);
    }
}
