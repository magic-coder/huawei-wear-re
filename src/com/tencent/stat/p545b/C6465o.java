package com.tencent.stat.p545b;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class C6465o implements FileFilter {
    C6465o() {
    }

    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
