package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.FM_Exception;
import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;

public class PromotionMessage {
    private /* synthetic */ String f9657a;
    private /* synthetic */ String f9658b;
    private /* synthetic */ String f9659c;

    public static PromotionMessage fromTag(ITag iTag) throws FMCommunicationMessageException {
        PromotionMessage promotionMessage = null;
        FMLog log = LogFactory.getInstance().getLog();
        if (iTag != null) {
            ITag[] itemTags = iTag.getItemTags();
            if (itemTags != null && itemTags.length >= 1) {
                promotionMessage = new PromotionMessage();
                for (ITag iTag2 : itemTags) {
                    switch (iTag2.getId()) {
                        case (byte) -56:
                            promotionMessage.setCode(iTag2.getStringVal());
                            break;
                        case (byte) 50:
                            promotionMessage.setTitle(iTag2.getStringVal());
                            break;
                        case (byte) 52:
                            promotionMessage.setDescription(iTag2.getStringVal());
                            break;
                        default:
                            break;
                    }
                }
            } else if (log != null) {
                log.warn(BusinessOrder.class.getName(), FM_Bytes.concat("y輧捿\u001b t宼豶刹畳戺侜镑俢怺斱５\u001f|h嬑寪豤乭穳", 2, 82));
            }
        } else if (log != null) {
            log.warn(BusinessOrder.class.getName(), FM_Exception.insert(2, 104, "轪挬\u0002a寷谷當扱俍锖便怩斸：Jg)宯豿丼穴"));
        }
        return promotionMessage;
    }

    public String getCode() {
        return this.f9659c;
    }

    public String getDescription() {
        return this.f9658b;
    }

    public String getTitle() {
        return this.f9657a;
    }

    public void setCode(String str) {
        this.f9659c = str;
    }

    public void setDescription(String str) {
        this.f9658b = str;
    }

    public void setTitle(String str) {
        this.f9657a = str;
    }
}
