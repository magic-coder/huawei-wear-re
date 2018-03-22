package com.snowballtech.apdu.internal;

import com.snowballtech.apdu.service.SnowballNfcException;

public interface INfcChannel {
    void closeChannel() throws SnowballNfcException;

    byte[] openChannel() throws SnowballNfcException;

    byte[] transmit(byte[] bArr) throws SnowballNfcException;
}
