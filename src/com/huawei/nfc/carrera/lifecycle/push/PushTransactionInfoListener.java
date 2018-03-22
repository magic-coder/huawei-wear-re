package com.huawei.nfc.carrera.lifecycle.push;

import com.huawei.nfc.carrera.lifecycle.push.data.PushConsumeMessage;

public interface PushTransactionInfoListener {
    void transactionResult(PushConsumeMessage pushConsumeMessage);
}
