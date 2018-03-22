package cn.com.fmsh.util;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.FM_Exception;
import org.apache.log4j.net.SyslogAppender;

public class FM_Shorts {
    public short[] data = new short[0];

    public static short[] copyOf(short[] sArr, int i) {
        int i2 = 0;
        if (sArr == null) {
            throw new NullPointerException(FM_Exception.insert(3, 113, "'7;3,ucc \u00100!%lu7a*j59qb"));
        }
        short[] sArr2 = new short[i];
        if (sArr.length < i) {
            while (i2 < sArr.length) {
                sArr2[i2] = sArr[i2];
                i2++;
            }
        } else {
            while (i2 < i) {
                sArr2[i2] = sArr[i2];
                i2++;
            }
        }
        return sArr2;
    }

    public static short[] copyOfRange(short[] sArr, int i, int i2) {
        if (sArr == null) {
            throw new NullPointerException(FM_Utils.regionMatches(3, 16, "slajt*=\"?#Rqa\"*0sj`#}6?/"));
        } else if (i2 - i <= 0) {
            throw new IllegalArgumentException(new StringBuilder(BCCUtil.getChars("rf<3g\u0003", 2, 46)).append(i).append(Util4Java.endsWith("\u0002?wj\\", 2, 2)).append(i2).append("]").toString());
        } else if (sArr.length < i) {
            throw new IllegalArgumentException(new StringBuilder(FM_Exception.insert(3, 104, "' %v`f9>+!{:)(cw\\")).append(sArr.length).append(FM_Bytes.concat("\u0004k!<\n", 2, TransportMediator.KEYCODE_MEDIA_PLAY)).append(i).append("]").toString());
        } else if (sArr.length < i2) {
            throw new IllegalArgumentException(new StringBuilder(Util4Java.endsWith("7 5v0&i>;!k:yh3wL", 282, 88)).append(sArr.length).append(BCCUtil.getChars("]?rfW", SyslogAppender.LOG_LOCAL2, 3)).append(i2).append("]").toString());
        } else {
            int i3 = i2 - i;
            short[] sArr2 = new short[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                sArr2[i4] = sArr[i4 + i];
            }
            return sArr2;
        }
    }

    public static short[] join(short[] sArr, short[] sArr2) {
        int i = 0;
        if (sArr == null) {
            throw new NullPointerException(Util4Java.endsWith("!% u`pa@s3 xra(r!/4mm", 4, 96));
        } else if (sArr2 == null) {
            throw new NullPointerException(FM_CN.equals("v#9={9<L,=!(13mf&9=5&", 3));
        } else {
            int length = sArr.length;
            short[] sArr3 = new short[(sArr.length + sArr2.length)];
            for (int i2 = 0; i2 < length; i2++) {
                sArr3[i2] = sArr[i2];
            }
            while (i < sArr2.length) {
                sArr3[length + i] = sArr2[i];
                i++;
            }
            return sArr3;
        }
    }
}
