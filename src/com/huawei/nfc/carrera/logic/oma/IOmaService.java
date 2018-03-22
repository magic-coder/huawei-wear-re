package com.huawei.nfc.carrera.logic.oma;

import com.huawei.nfc.carrera.logic.oma.model.ApduCommand;
import com.huawei.nfc.carrera.logic.oma.model.ChannelID;
import java.util.List;

public interface IOmaService {
    public static final int CHANNEL_TYPE_BASIC = 1;
    public static final int CHANNEL_TYPE_LOGIC = 0;
    public static final int MEDIA_TYPE_ESE = 0;
    public static final int MEDIA_TYPE_SD = 2;
    public static final int MEDIA_TYPE_SIM = 1;
    public static final int RESULT_SUCCESS = 0;
    public static final int RETURN_APDU_EXCUTE_CLOSE_CHANNEL_EXCEPTION = 5001;
    public static final int RETURN_APDU_EXCUTE_CLOSE_SESERVICE_EXCEPTION = 5002;
    public static final int RETURN_APDU_EXCUTE_NOT_EXPECTED_SW = 4002;
    public static final int RETURN_APDU_EXCUTE_NO_READER = 1002;
    public static final int RETURN_APDU_EXCUTE_OPENCHANNEL_EXCEPTION = 2008;
    public static final int RETURN_APDU_EXCUTE_OPENCHANNEL_IOEXCEPTION = 2002;
    public static final int RETURN_APDU_EXCUTE_OPENCHANNEL_MISSRESOURCEEXCEPTION = 2007;
    public static final int RETURN_APDU_EXCUTE_OPENCHANNEL_NOAID = 2005;
    public static final int RETURN_APDU_EXCUTE_OPENCHANNEL_NOSUCHELEMENT = 2004;
    public static final int RETURN_APDU_EXCUTE_OPENCHANNEL_NULLPOINTEREXCEPTION = 2006;
    public static final int RETURN_APDU_EXCUTE_OPENCHANNEL_SECURITYEXCEPTION = 2003;
    public static final int RETURN_APDU_EXCUTE_OPENSESSION_FAILED = 2001;
    public static final int RETURN_APDU_EXCUTE_PARAMS_ILLEGAL = 1001;
    public static final int RETURN_APDU_EXCUTE_RAPDU_IS_SMALL = 4001;
    public static final int RETURN_APDU_EXCUTE_SE_READER_NOT_PRESENT = 1003;
    public static final int RETURN_APDU_EXCUTE_TRANSMIT_CHANNEL_IS_NULL = 3001;
    public static final int RETURN_APDU_EXCUTE_TRANSMIT_EXCEPTION = 3007;
    public static final int RETURN_APDU_EXCUTE_TRANSMIT_IOEXCEPTION = 3002;
    public static final int RETURN_APDU_EXCUTE_TRANSMIT_MISSRESOURCEEXCEPTION = 3006;
    public static final int RETURN_APDU_EXCUTE_TRANSMIT_NOSUCHELEMENT = 3004;
    public static final int RETURN_APDU_EXCUTE_TRANSMIT_NULLPOINTEREXCEPTION = 3005;
    public static final int RETURN_APDU_EXCUTE_TRANSMIT_SECURITYEXCEPTION = 3003;
    public static final int RETURN_SMARTCARD_NO_CAPDULIST = 1004;
    public static final String TAG = "OmaService";

    void closeChannel(ChannelID channelID);

    TaskResult<ChannelID> excuteApduList(List<ApduCommand> list, ChannelID channelID);

    TaskResult<ChannelID> excuteApduListEx(List<ApduCommand> list, ChannelID channelID);
}
