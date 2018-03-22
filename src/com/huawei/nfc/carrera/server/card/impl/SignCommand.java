package com.huawei.nfc.carrera.server.card.impl;

import java.util.HashMap;

public class SignCommand {
    static final String CITIC_SIGN_CONTENT_ACTIVATE_CARD = "ACTIVATEACTION";
    static final String CITIC_SIGN_CONTENT_APPLY_AID_ACTION = "APPLYIDCARDACTION";
    static final String CITIC_SIGN_CONTENT_APPLY_CARD_ACTION = "APPLYCARDACTION";
    static final String CITIC_SIGN_CONTENT_BILLLIST = "BILLLISTACTION";
    static final String CITIC_SIGN_CONTENT_NULLIFY = "NULLIFYACTION";
    static final String CITIC_SIGN_CONTENT_PERSONALIZE = "PERSONALIZEACTION";
    static final String CITIC_SIGN_CONTENT_QUERY_CASHLIMIT = "CASHLIMITSEARCHACTION";
    static final String CITIC_SIGN_CONTENT_SET_CASHLIMIT = "CASHLIMITACTION";
    static final String SIGN_CONTENT_CREATE_SSD = "CREATESSDACTION";
    static final String SIGN_CONTENT_DELETE_SSD = "DELETESSDACTION";
    static final HashMap<String, String> sCommands = new HashMap();

    static {
        sCommands.put("nfc.get.install.APP", CITIC_SIGN_CONTENT_APPLY_AID_ACTION);
        sCommands.put("nfc.get.del.APP", CITIC_SIGN_CONTENT_NULLIFY);
        sCommands.put("nfc.get.create.SSD", SIGN_CONTENT_CREATE_SSD);
        sCommands.put("nfc.get.del.SSD", SIGN_CONTENT_DELETE_SSD);
    }

    public static String getSignCommand(String str) {
        return (String) sCommands.get(str);
    }
}
