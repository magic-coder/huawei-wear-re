package cn.com.fmsh.util.algorithm;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import org.apache.log4j.net.SyslogAppender;

public class Diversify {
    private static /* synthetic */ FMLog f9856a = LogFactory.getInstance().getLog();

    public static byte[] doubleLength(byte[] bArr, byte[] bArr2, int i) {
        if (bArr == null) {
            f9856a.warn(Diversify.class.getName(), FM_Long.copyValueOf("刏敥交生宛铿晸ｘ牧守铮乲+730", 1));
            return null;
        } else if (i == 0) {
            return bArr;
        } else {
            if (i > 0) {
                if (bArr2 == null) {
                    f9856a.warn(Diversify.class.getName(), CRCUtil.substring(180, "則支仰畝宋铽旵＂刟敧敿捴乿>.*="));
                    return null;
                }
                int length = bArr2.length;
                if (length % 8 != 0) {
                    f9856a.warn(Diversify.class.getName(), BCCUtil.getChars("剗攢亶畞寗钤斧－剗攢敡振镮座乜吉沄", 1, 80));
                    return null;
                } else if (length / 8 != i) {
                    f9856a.warn(Diversify.class.getName(), FM_Long.copyValueOf("刈敨亯甚寄铺斪ｕ剐攰攠挣锵廡义呉沋", 6));
                    return null;
                }
            }
            byte[] copyOfRange = FM_Bytes.copyOfRange(bArr2, 0, 8);
            bArr = FM_Bytes.join(DES.encrypt4des3(bArr, copyOfRange), DES.encrypt4des3(bArr, FM_Bytes.not(copyOfRange)));
            for (int i2 = 1; i2 < i; i2++) {
                byte[] copyOfRange2 = FM_Bytes.copyOfRange(bArr2, i2 * 8, (i2 + 1) * 8);
                bArr = FM_Bytes.join(DES.encrypt4des3(bArr, copyOfRange2), DES.encrypt4des3(bArr, FM_Bytes.not(copyOfRange2)));
            }
            return bArr;
        }
    }

    public static byte[] singleLength(byte[] bArr, byte[] bArr2, int i) {
        if (bArr == null) {
            f9856a.warn(Diversify.class.getName(), FM_Long.copyValueOf("刊敪亡甜密铸晵｛牢宗铫乱&0.3", 4));
            return null;
        } else if (i == 0) {
            return bArr;
        } else {
            if (i > 0) {
                if (bArr2 == null) {
                    f9856a.warn(Diversify.class.getName(), FM_Exception.insert(SyslogAppender.LOG_LOCAL5, 11, "刊整以畒实铦斸ｕ刂敬敪捫个u3=0"));
                    return null;
                }
                int length = bArr2.length;
                if (length % 8 != 0) {
                    f9856a.warn(Diversify.class.getName(), FM_Utils.regionMatches(1, 51, "剗敧仰甕寛铵旵ｚ刏敿政捬锪庮世呆泔"));
                    return null;
                } else if (length / 8 != i) {
                    f9856a.warn(Diversify.class.getName(), Util4Java.endsWith("剙整仨甘宙钲方＋则攴敿挩镠廱丂呏沊", 2, 56));
                    return null;
                }
            }
            bArr = DES.encrypt4des(bArr, FM_Bytes.copyOfRange(bArr2, 0, 8));
            for (int i2 = 1; i2 < i; i2++) {
                bArr = DES.encrypt4des(bArr, FM_Bytes.copyOfRange(bArr2, i2 * 8, (i2 + 1) * 8));
            }
            return bArr;
        }
    }
}
