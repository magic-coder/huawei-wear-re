package cn.com.fmsh.tsm.business.bean;

import cn.com.fmsh.communication.message.ITag;
import cn.com.fmsh.communication.message.exception.FMCommunicationMessageException;
import cn.com.fmsh.util.FM_Bytes;
import cn.com.fmsh.util.FM_Int;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;

public class PasswordPrompt {
    private /* synthetic */ String f9637a;
    private /* synthetic */ int f9638b;

    public static PasswordPrompt fromTag(ITag iTag) throws FMCommunicationMessageException {
        PasswordPrompt passwordPrompt = null;
        FMLog log = LogFactory.getInstance().getLog();
        if (iTag != null) {
            ITag[] itemTags = iTag.getItemTags();
            if (itemTags != null && itemTags.length >= 1) {
                passwordPrompt = new PasswordPrompt();
                for (ITag iTag2 : itemTags) {
                    switch (iTag2.getId()) {
                        case (byte) 4:
                            passwordPrompt.setEmail(iTag2.getStringVal());
                            break;
                        case (byte) 36:
                            passwordPrompt.setCount(iTag2.getIntVal());
                            break;
                        default:
                            break;
                    }
                }
            } else if (log != null) {
                log.warn(BusinessOrder.class.getName(), FM_Bytes.concat("-輫捣\u000ft(寰谢剭寑硐換祿俾怶寪谬旱ｍ\u000ft(寰谢丧稭", 182, 58));
            }
        } else if (log != null) {
            log.warn(BusinessOrder.class.getName(), FM_Int.replace(1, "v輵挾\u000bcb寱豪刾寗砕揇礠俼息寺豧旿＀[sr寡豺两稻"));
        }
        return passwordPrompt;
    }

    public int getCount() {
        return this.f9638b;
    }

    public String getEmail() {
        return this.f9637a;
    }

    public void setCount(int i) {
        this.f9638b = i;
    }

    public void setEmail(String str) {
        this.f9637a = str;
    }
}
