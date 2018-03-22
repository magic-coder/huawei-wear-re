package cn.com.xy.sms.sdk.p229l;

import java.io.File;
import java.io.FileFilter;

public final class ac implements FileFilter {
    private String f10259a = "";
    private String f10260b = "";

    public ac(String str, String str2) {
        this.f10259a = str;
        this.f10260b = str2;
    }

    public final boolean accept(File file) {
        String name = file.getName();
        return name.startsWith(this.f10259a) && name.endsWith(this.f10260b);
    }
}
