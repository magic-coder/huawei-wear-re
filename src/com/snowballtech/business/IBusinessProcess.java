package com.snowballtech.business;

import android.content.Context;
import com.snowballtech.business.user.task.IWalletServiceTask;

public interface IBusinessProcess {
    String process(IWalletServiceTask iWalletServiceTask, Context context, String str, String str2);

    String processSynchronized(IWalletServiceTask iWalletServiceTask, Context context, String str, String str2);
}
