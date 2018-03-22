package com.cmb.pboc.scard;

import com.cmb.pboc.logger.PbocLog;

public class ScardFactory {
    private static final String f13492a = ScardFactory.class.getSimpleName();

    private ScardFactory() {
    }

    public static Scard m17781a(String str) {
        String name = Scard.class.getName();
        PbocLog.m17738a(f13492a, name);
        name = new StringBuilder(String.valueOf(name)).append(str).toString();
        PbocLog.m17738a(f13492a, "the scard name is " + name);
        return (Scard) Class.forName(name).newInstance();
    }
}
