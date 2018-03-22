package com.cmb.pboc.global;

import com.snowballtech.apdu.bean.SeConstants;

public enum ApduHeader {
    SELECT_FILE(SeConstants.AID_FOR_APDULIST_PREFIX),
    GET_RESPONSE("00C00000"),
    READ_RECORD("00B20000"),
    GET_DATA("80CA0000");
    
    private String f13418e;

    private ApduHeader(String str) {
        this.f13418e = str;
    }

    public final String m17732a() {
        return this.f13418e;
    }
}
