package com.huawei.pluginkidwatch.plugin.setting.p167b;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: SettingUtil */
public class C1943h {
    public static int m10167a(int i, int i2) {
        if (i < 0) {
            i = 0;
        }
        if (!(1 == i2 || 2 == i2)) {
            i2 = 1;
        }
        if (2 == i2) {
            return C1943h.m10168b(i);
        }
        return C1943h.m10166a(i);
    }

    private static int m10166a(int i) {
        switch (i) {
            case 0:
                return 55;
            case 1:
                return 75;
            case 2:
                return 85;
            case 3:
                return 94;
            case 4:
                return 99;
            case 5:
                return 109;
            case 6:
                return 114;
            case 7:
                return TagName.ELECTRONIC_USE_COUNT;
            case 8:
                return 125;
            case 9:
                return 131;
            case 10:
                return SyslogAppender.LOG_LOCAL1;
            case 11:
                return 141;
            case 12:
                return 146;
            case 13:
                return SyslogAppender.LOG_LOCAL3;
            default:
                return 150;
        }
    }

    private static int m10168b(int i) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 74;
            case 2:
                return 84;
            case 3:
                return 95;
            case 4:
                return 100;
            case 5:
                return 110;
            case 6:
                return 115;
            case 7:
                return 120;
            case 8:
                return 125;
            case 9:
                return TransportMediator.KEYCODE_MEDIA_RECORD;
            case 10:
                return 135;
            case 11:
                return 140;
            case 12:
                return 145;
            default:
                return 150;
        }
    }

    public static int m10169b(int i, int i2) {
        if (i < 0) {
            i = 0;
        }
        if (!(1 == i2 || 2 == i2)) {
            i2 = 1;
        }
        if (2 == i2) {
            return C1943h.m10171d(i);
        }
        return C1943h.m10170c(i);
    }

    private static int m10170c(int i) {
        switch (i) {
            case 0:
                return 3;
            case 1:
                return 10;
            case 2:
                return 11;
            case 3:
                return 12;
            case 4:
                return 14;
            case 5:
                return 18;
            case 6:
                return 20;
            case 7:
                return 22;
            case 8:
                return 24;
            case 9:
                return 27;
            case 10:
                return 29;
            case 11:
                return 32;
            case 12:
                return 33;
            default:
                return 35;
        }
    }

    private static int m10171d(int i) {
        switch (i) {
            case 0:
                return 3;
            case 1:
                return 10;
            case 2:
                return 12;
            case 3:
                return 14;
            case 4:
                return 16;
            case 5:
                return 19;
            case 6:
                return 21;
            case 7:
                return 23;
            case 8:
                return 26;
            case 9:
                return 29;
            case 10:
                return 32;
            case 11:
                return 34;
            case 12:
                return 36;
            default:
                return 37;
        }
    }
}
