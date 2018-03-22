package com.huawei.nfc.carrera.logic.oma;

import android.content.Context;
import com.huawei.nfc.carrera.logic.oma.model.ApduCommand;
import com.huawei.nfc.carrera.logic.oma.model.ChannelID;
import java.util.List;

public final class OmaApduManager implements IOmaService {
    private static final byte[] SYNC_LOCK = new byte[0];
    private static volatile OmaApduManager instance;
    private final Object lock = new Object();
    private OmaService mOmaService;

    private OmaApduManager(Context context) {
        this.mOmaService = new OmaService(context);
    }

    public static OmaApduManager getInstance(Context context) {
        if (instance == null) {
            synchronized (SYNC_LOCK) {
                if (instance == null) {
                    instance = new OmaApduManager(context);
                }
            }
        }
        return instance;
    }

    public TaskResult<ChannelID> excuteApduList(List<ApduCommand> list, ChannelID channelID) {
        TaskResult<ChannelID> excuteApduList;
        synchronized (this.lock) {
            excuteApduList = this.mOmaService.excuteApduList(list, channelID);
        }
        return excuteApduList;
    }

    public TaskResult<ChannelID> excuteApduListEx(List<ApduCommand> list, ChannelID channelID) {
        TaskResult<ChannelID> excuteApduListEx;
        synchronized (this.lock) {
            excuteApduListEx = this.mOmaService.excuteApduListEx(list, channelID);
        }
        return excuteApduListEx;
    }

    public void closeChannel(ChannelID channelID) {
        synchronized (this.lock) {
            this.mOmaService.closeChannel();
        }
    }
}
