package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;

public class StationInfo {
    private /* synthetic */ String f9660a;
    private /* synthetic */ String f9661b;
    private /* synthetic */ String f9662c;

    public static StationInfo fromTag(ITag iTag) throws FMCommunicationMessageException {
        StationInfo stationInfo = null;
        FMLog log = LogFactory.getInstance().getLog();
        if (iTag != null) {
            ITag[] itemTags = iTag.getItemTags();
            if (itemTags != null && itemTags.length >= 1) {
                stationInfo = new StationInfo();
                for (ITag iTag2 : itemTags) {
                    switch (iTag2.getId()) {
                        case (byte) -65:
                            stationInfo.setId(iTag2.getStringVal());
                            break;
                        case (byte) -64:
                            stationInfo.setEname(iTag2.getStringVal());
                            break;
                        case (byte) -63:
                            stationInfo.setName(iTag2.getStringVal());
                            break;
                        default:
                            break;
                    }
                }
            } else if (log != null) {
                log.warn(BusinessOrder.class.getName(), FM_CN.equals("v輫挺\u001d{l寥豬剮厂駈侰怭日（Ag0宱谸买穡", 3));
            }
        } else if (log != null) {
            log.warn(BusinessOrder.class.getName(), BCCUtil.getChars("u輺挵\f8=客谽剭坮钞站俠恭寺豥旳＊Sin寳豪丶穷", 5, 1));
        }
        return stationInfo;
    }

    public String getEname() {
        return this.f9662c;
    }

    public String getId() {
        return this.f9660a;
    }

    public String getName() {
        return this.f9661b;
    }

    public void setEname(String str) {
        this.f9662c = str;
    }

    public void setId(String str) {
        this.f9660a = str;
    }

    public void setName(String str) {
        this.f9661b = str;
    }
}
