package com.snowballtech.apdu.service;

import com.snowballtech.common.exception.SnowballException;

public class SnowballNfcException extends SnowballException {
    public SnowballNfcException(String str) {
        super(str);
    }

    public SnowballNfcException(String str, int i) {
        super(str, i);
    }

    public SnowballNfcException(String str, Throwable th) {
        super(str, th);
    }

    public SnowballNfcException(Throwable th) {
        super(th);
    }
}
