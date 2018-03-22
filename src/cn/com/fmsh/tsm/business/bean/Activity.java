package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;

public class Activity {
    private /* synthetic */ String f9526a;
    private /* synthetic */ String f9527b;
    private /* synthetic */ String f9528c;
    private /* synthetic */ String f9529d;
    private /* synthetic */ int f9530e;
    private /* synthetic */ int f9531f;
    private /* synthetic */ String f9532g;
    private /* synthetic */ String f9533h;
    private /* synthetic */ int f9534i;
    private /* synthetic */ int f9535j;

    public static Activity fromTag(ITag iTag) throws FMCommunicationMessageException {
        Activity activity = null;
        FMLog log = LogFactory.getInstance().getLog();
        if (iTag != null) {
            ITag[] itemTags = iTag.getItemTags();
            if (itemTags != null && itemTags.length >= 1) {
                activity = new Activity();
                for (ITag iTag2 : itemTags) {
                    switch (iTag2.getId()) {
                        case (byte) -126:
                            activity.setName(iTag2.getStringVal());
                            break;
                        case (byte) -125:
                            activity.setCode(iTag2.getStringVal());
                            break;
                        case (byte) -124:
                            activity.setStart(iTag2.getStringVal());
                            break;
                        case (byte) -123:
                            activity.setEnd(iTag2.getStringVal());
                            break;
                        case (byte) -122:
                            activity.setTotal(iTag2.getIntVal());
                            break;
                        case (byte) -121:
                            activity.setRemainder(iTag2.getIntVal());
                            break;
                        case (byte) -120:
                            activity.setDefinition(iTag2.getStringVal());
                            break;
                        case (byte) -118:
                            activity.setPayChannel(iTag2.getStringVal());
                            break;
                        case (byte) -117:
                            activity.setPayMin(iTag2.getIntVal());
                            break;
                        case (byte) -115:
                            activity.setStatus(iTag2.getBytesVal()[0]);
                            break;
                        default:
                            break;
                    }
                }
            } else if (log != null) {
                log.warn(BusinessOrder.class.getName(), FM_Exception.insert(4, 47, "(轻挤A%4寻谰到洴勶俬恳施６\u001d9`宯豤丮稹"));
            }
        } else if (log != null) {
            log.warn(BusinessOrder.class.getName(), FM_Int.replace(92, "q輸挵\u000e<'宺谧剹海勧侳怺斮ｗ\n`c対豫丷穪"));
        }
        return activity;
    }

    public String getCode() {
        return this.f9527b;
    }

    public String getDefinition() {
        return this.f9532g;
    }

    public String getEnd() {
        return this.f9529d;
    }

    public String getName() {
        return this.f9526a;
    }

    public String getPayChannel() {
        return this.f9533h;
    }

    public int getPayMin() {
        return this.f9534i;
    }

    public int getRemainder() {
        return this.f9531f;
    }

    public String getStart() {
        return this.f9528c;
    }

    public int getStatus() {
        return this.f9535j;
    }

    public int getTotal() {
        return this.f9530e;
    }

    public void setCode(String str) {
        this.f9527b = str;
    }

    public void setDefinition(String str) {
        this.f9532g = str;
    }

    public void setEnd(String str) {
        this.f9529d = str;
    }

    public void setName(String str) {
        this.f9526a = str;
    }

    public void setPayChannel(String str) {
        this.f9533h = str;
    }

    public void setPayMin(int i) {
        this.f9534i = i;
    }

    public void setRemainder(int i) {
        this.f9531f = i;
    }

    public void setStart(String str) {
        this.f9528c = str;
    }

    public void setStatus(int i) {
        this.f9535j = i;
    }

    public void setTotal(int i) {
        this.f9530e = i;
    }
}
