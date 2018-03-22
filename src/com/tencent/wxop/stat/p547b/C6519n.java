package com.tencent.wxop.stat.p547b;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class C6519n implements FileFilter {
    C6519n() {
    }

    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
