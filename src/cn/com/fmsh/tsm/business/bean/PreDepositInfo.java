package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;

public class PreDepositInfo {
    private /* synthetic */ int f9648a;
    private /* synthetic */ int f9649b;
    private /* synthetic */ int f9650c;
    private /* synthetic */ int f9651d;

    public static PreDepositInfo fromTag(ITag iTag) throws FMCommunicationMessageException {
        PreDepositInfo preDepositInfo = null;
        FMLog log = LogFactory.getInstance().getLog();
        if (iTag != null) {
            ITag[] itemTags = iTag.getItemTags();
            if (itemTags != null && itemTags.length >= 1) {
                preDepositInfo = new PreDepositInfo();
                for (ITag iTag2 : itemTags) {
                    switch (iTag2.getId()) {
                        case (byte) -116:
                            preDepositInfo.setStatus(iTag2.getIntVal());
                            break;
                        case (byte) -107:
                            preDepositInfo.setType(iTag2.getIntVal());
                            break;
                        case (byte) 90:
                            preDepositInfo.setTotal(iTag2.getIntVal());
                            break;
                        case (byte) 91:
                            preDepositInfo.setBlance(iTag2.getIntVal());
                            break;
                        default:
                            break;
                    }
                }
            } else if (log != null) {
                log.warn(BusinessOrder.class.getName(), FM_CN.equals("\u0003)>畕戋频庻俯怰斦ｍ\u0006\"s孕顯丽稢", 4));
            }
        } else if (log != null) {
            log.warn(PreDepositInfo.class.getName(), FM_Int.replace(344, "\u001914畉扉飁廹侣怪斾ｇ\u001a03宮谻乧空"));
        }
        return preDepositInfo;
    }

    public int getBlance() {
        return this.f9649b;
    }

    public int getStatus() {
        return this.f9650c;
    }

    public int getTotal() {
        return this.f9648a;
    }

    public int getType() {
        return this.f9651d;
    }

    public void setBlance(int i) {
        this.f9649b = i;
    }

    public void setStatus(int i) {
        this.f9650c = i;
    }

    public void setTotal(int i) {
        this.f9648a = i;
    }

    public void setType(int i) {
        this.f9651d = i;
    }
}
