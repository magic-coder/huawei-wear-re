package cn.com.fmsh.communication.exception.session;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import cn.com.fmsh.util.Util4Java;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import com.huawei.datatype.SportType;

public class OpenSessionException extends FM_Exception {
    private static final /* synthetic */ long serialVersionUID = -638900000836743962L;
    private /* synthetic */ OpenSessionExceptionType f9426a;

    public enum OpenSessionExceptionType {
        SYSTEM_BUSY(Byte.MIN_VALUE, Util4Java.endsWith("糨纆忆ｉ暉倍掲儸李动", 150, 70)),
        INVALID_TERMINAL(TagName.ACTIVITY, FM_CN.equals("斻攄纕窡籤垛", SportType.SPORT_TYPE_TREADMILL)),
        INVALID_KEY_INDEX(TagName.ACTIVITY_NAME, FM_CN.equals("笨剷伧畡寜钮紾弘斾攇", 3)),
        DECRYPT_FAIL(TagName.ACTIVITY_CODE, Util4Java.endsWith("签剬讯氖攠挢覫宂奱赹", 3, ReportInfoUtils.FEEDBACK_FAILED)),
        DATA_FORMAT_ERROR(TagName.ACTIVITY_START, FM_Int.replace(284, "筯判诠汘敭据栿弉锐诣")),
        INVALID_TERMINAL_ID(TagName.ACTIVITY_END, FM_CN.equals("斵攎纟窧缏叽", 2)),
        SECURITY_CODE(TagName.ACTIVITY_TOTAL, FM_Long.copyValueOf("阸伭砅骍讟奪赽", 2)),
        INVALID_TIME(TagName.ACTIVITY_REMAINDER, Util4Java.endsWith("纖竤斮闱弐幧", 1, 45)),
        UNKNOW((byte) -1, FM_Utils.regionMatches(294, 118, "朼矩锛讷"));

        public static OpenSessionExceptionType instance(int i) {
            for (OpenSessionExceptionType openSessionExceptionType : values()) {
                if (openSessionExceptionType.getValue() == i) {
                    return openSessionExceptionType;
                }
            }
            return UNKNOW;
        }

        public String getDescription() {
            return this.f9425b;
        }

        public int getValue() {
            return this.f9424a;
        }
    }

    public OpenSessionException(String str) {
        super(str);
    }

    public OpenSessionExceptionType getExceptionType() {
        return this.f9426a;
    }

    public void setExceptionType(OpenSessionExceptionType openSessionExceptionType) {
        this.f9426a = openSessionExceptionType;
    }
}
