package cn.com.fmsh.communication.exception;

import android.support.v4.media.TransportMediator;
import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.FM_Long;
import cn.com.fmsh.util.FM_Utils;
import com.huawei.crowdtestsdk.common.SpecialIssueType;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessSleepType;

public class CommunicationException extends FM_Exception {
    private static final /* synthetic */ long serialVersionUID = -638900000836743962L;
    private /* synthetic */ CommunicationExceptionType f9421a;
    private /* synthetic */ CommandDirection f9422b;

    public enum CommandDirection {
        REQUESR((byte) 0, CRCUtil.substring(294, "绛竱设氖")),
        RESPONSE((byte) 1, FM_Int.replace(310, "幸叾哜庀"));

        public String getDescription() {
            return this.f9417b;
        }

        public int getValue() {
            return this.f9416a;
        }
    }

    public enum CommunicationExceptionType {
        INVALID_VERSION((byte) 1, FM_CN.equals("斡攚匌论牍机", FitnessSleepType.HW_FITNESS_SLEEP)),
        INVALID_FORMAT((byte) 2, FM_Utils.regionMatches(122, 28, "拯斁栾弑斺攞")),
        CHECK_FAILED((byte) 3, FM_Long.copyValueOf("抩斎棆骏失赸", 4)),
        INVALID_CONTROL((byte) 4, FM_Bytes.concat("拼斂掶别孞旵攉", 2, 12)),
        INVALID_SESSION((byte) 5, FM_Utils.regionMatches(3, 87, "佉讗旡攐")),
        INVALID_SESSION_NUMBER((byte) 6, FM_CN.equals("住讛洖汼旹敂", 2)),
        INVALID_DIRECTION((byte) 7, FM_Utils.regionMatches(3, 94, "攣挿斶吜彉幱")),
        NO_REPONSE((byte) 8, CRCUtil.substring(2, "朥攬刵哝序收挿")),
        INVALID_REPONSE((byte) 9, FM_Exception.insert(3, 30, "哊庑攳振乒吕泎")),
        UNKNOW((byte) -1, FM_Bytes.concat("杳瞨镘论", TransportMediator.KEYCODE_MEDIA_RECORD, SpecialIssueType.BUG_TYPE_ID_CHARGE));

        public static CommunicationExceptionType instance(int i) {
            for (CommunicationExceptionType communicationExceptionType : values()) {
                if (communicationExceptionType.getValue() == i) {
                    return communicationExceptionType;
                }
            }
            return UNKNOW;
        }

        public String getDescription() {
            return this.f9420b;
        }

        public int getValue() {
            return this.f9419a;
        }
    }

    public CommunicationException(String str) {
        super(str);
    }

    public CommandDirection getDirection() {
        return this.f9422b;
    }

    public CommunicationExceptionType getExceptionType() {
        return this.f9421a;
    }

    public void setDirection(CommandDirection commandDirection) {
        this.f9422b = commandDirection;
    }

    public void setExceptionType(CommunicationExceptionType communicationExceptionType) {
        this.f9421a = communicationExceptionType;
    }
}
