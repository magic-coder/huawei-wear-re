package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.internal.ws.WebSocket.PayloadType;
import java.io.IOException;
import okio.BufferedSource;

public interface WebSocketListener {
    void onClose(int i, String str);

    void onFailure(IOException iOException);

    void onMessage(BufferedSource bufferedSource, PayloadType payloadType) throws IOException;
}
