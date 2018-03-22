package cn.com.fmsh.tsm.business.core;

import cn.com.fmsh.util.BCCUtil;
import cn.com.fmsh.util.CRCUtil;
import cn.com.fmsh.util.FM_CN;
import cn.com.fmsh.util.Util4Java;
import cn.com.fmsh.util.log.FMLog;
import cn.com.fmsh.util.log.LogFactory;
import java.io.InputStream;
import java.util.Properties;

public class ErrorCodeHandler {
    private /* synthetic */ FMLog f9778a = LogFactory.getInstance().getLog();
    private final /* synthetic */ String f9779b = ErrorCodeHandler.class.getName();
    private /* synthetic */ Properties f9780c = new Properties();

    public int getCode(String str) {
        String property = this.f9780c.getProperty(str);
        if (property != null && property.length() >= 1) {
            return Integer.parseInt(property.trim());
        }
        if (this.f9778a != null) {
            this.f9778a.debug(this.f9779b, new StringBuilder(FM_CN.equals("菮厜\u0000", 6)).append(str).append(BCCUtil.getChars("E盇咃庍硅奾贿", 296, 43)).toString());
        }
        return 99;
    }

    public boolean init(InputStream inputStream) {
        if (inputStream != null) {
            try {
                this.f9780c.load(inputStream);
                return true;
            } catch (Exception e) {
                if (this.f9778a == null) {
                    return false;
                }
                this.f9778a.warn(this.f9779b, new StringBuilder(Util4Java.endsWith("咓庖硇剗姅匄奧赿$", 1, 36)).append(Util4Java.getExceptionInfo(e)).toString());
                return false;
            }
        } else if (this.f9778a == null) {
            return false;
        } else {
            this.f9778a.warn(this.f9779b, CRCUtil.substring(5, "哟庉砉刎姕卟奥赺於ｙ传兮皒酌罢斐亴乷稢"));
            return false;
        }
    }
}
