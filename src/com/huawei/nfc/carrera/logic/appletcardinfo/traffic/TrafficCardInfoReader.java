package com.huawei.nfc.carrera.logic.appletcardinfo.traffic;

import com.huawei.nfc.carrera.logic.appletcardinfo.configdata.ConfigData;
import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.ApduCommandInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.CardInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.TransactionRecord;
import com.huawei.nfc.carrera.logic.appletcardinfo.traffic.readers.CardBalanceInfoReader;
import com.huawei.nfc.carrera.logic.appletcardinfo.traffic.readers.CardDateInfoReader;
import com.huawei.nfc.carrera.logic.appletcardinfo.traffic.readers.CardNumInfoReader;
import com.huawei.nfc.carrera.logic.appletcardinfo.traffic.readers.CardRecordInfoReader;
import com.huawei.nfc.carrera.logic.appletcardinfo.traffic.readers.InfoReader;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.nfc.carrera.logic.oma.model.ApduCommand;
import com.huawei.nfc.carrera.logic.oma.model.ChannelID;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;

import java.util.List;

public class TrafficCardInfoReader {
    private static final String TAG = "CardInfoRead";
    private ChannelID channelID;
    private ConfigData configData;
    private IOmaService omaService;

    public TrafficCardInfoReader(IOmaService iOmaService, ConfigData configData) {
        this.omaService = iOmaService;
        this.configData = configData;
    }

    public CardInfo readCardInfo(String str, String str2, int i) throws AppletCardException {
        C2538c.c(TAG, new Object[]{"readCardInfo AID : " + str + " ; productId : " + str2 + " ; dataType : " + i});
        CardInfo cardInfo = new CardInfo();
        this.channelID = new ChannelID();
        this.channelID.setAid(str);
        if ((i & 1) == 1) {
            readCardNum(str2, cardInfo);
        }
        if ((i & 4) == 4) {
            readCardDate(str2, cardInfo);
        }
        if ((i & 2) == 2) {
            readBalance(str2, cardInfo);
        }
        closeChannel();
        return cardInfo;
    }

    public List<TransactionRecord> readTransactionRecords(String str, String str2) throws AppletCardException {
        this.channelID = new ChannelID();
        this.channelID.setAid(str);
        InfoReader cardRecordInfoReader = new CardRecordInfoReader(this.omaService);
        cardRecordInfoReader.setChannelID(this.channelID);
        List<TransactionRecord> list = (List) readCardInfoImpl(str2, 4, cardRecordInfoReader);
        this.channelID = cardRecordInfoReader.getChannelID();
        closeChannel();
        return list;
    }

    private void readCardNum(String str, CardInfo cardInfo) throws AppletCardException {
        InfoReader cardNumInfoReader = new CardNumInfoReader(this.omaService);
        cardNumInfoReader.setChannelID(this.channelID);
        String str2 = (String) readCardInfoImpl(str, 1, cardNumInfoReader);
        C2538c.c(TAG, new Object[]{"readCardNum cardNum : " + str2});
        this.channelID = cardNumInfoReader.getChannelID();
        cardInfo.setCardNum(str2);
    }

    private void readCardDate(String str, CardInfo cardInfo) throws AppletCardException {
        List apudList;
        String rapdu;
        String[] strArr;
        if (this.configData.isSameApduNumAndDate(str)) {
            apudList = this.configData.getApudList(str, 1);
            ApduCommand apduCommand = (ApduCommand) apudList.get(apudList.size() - 1);
            rapdu = apduCommand != null ? apduCommand.getRapdu() : null;
            apudList = this.configData.getApudList(str, 2);
            apduCommand = (ApduCommand) apudList.get(apudList.size() - 1);
            apudList = apduCommand instanceof ApduCommandInfo ? ((ApduCommandInfo) apduCommand).getOperations() : null;
        } else {
            apudList = null;
            rapdu = null;
        }
        InfoReader cardDateInfoReader = new CardDateInfoReader(this.omaService);
        if (StringUtil.isEmpty(rapdu, true) || apudList == null) {
            strArr = null;
        } else {
            strArr = (String[]) cardDateInfoReader.readInfoFromData(rapdu, apudList);
        }
        if (strArr == null) {
            cardDateInfoReader.setChannelID(this.channelID);
            strArr = (String[]) readCardInfoImpl(str, 2, cardDateInfoReader);
            this.channelID = cardDateInfoReader.getChannelID();
        }
        cardInfo.setEnableDate(strArr[0]);
        cardInfo.setExpireDate(strArr[1]);
    }

    private void readBalance(String str, CardInfo cardInfo) throws AppletCardException {
        InfoReader cardBalanceInfoReader = new CardBalanceInfoReader(this.omaService);
        cardBalanceInfoReader.setChannelID(this.channelID);
        Integer[] numArr = (Integer[]) readCardInfoImpl(str, 3, cardBalanceInfoReader);
        this.channelID = cardBalanceInfoReader.getChannelID();
        cardInfo.setOverdraftAmount(numArr[0].intValue());
        cardInfo.setAmount(numArr[1].intValue());
    }

    private <T> T readCardInfoImpl(String str, int i, InfoReader<T> infoReader) throws AppletCardException {
        C2538c.c(TAG, new Object[]{"readCardInfoImpl"});
        List apudList = this.configData.getApudList(str, i);
        if (apudList == null || apudList.size() == 0) {
            C2538c.c(TAG, new Object[]{"readCardInfoImpl apdus is null or size = 0 "});
            return null;
        }
        for (int i2 = 0; i2 < apudList.size(); i2++) {
            C2538c.c(TAG, new Object[]{" APDU " + i2 + " ：" + ((ApduCommand) apudList.get(i2)).getApdu()});
        }
        infoReader.setCommandList(apudList);
        try {
            T readInfo = infoReader.readInfo();
            C2538c.c(TAG, new Object[]{"readCardInfoImpl data : " + readInfo});
            return readInfo;
        } catch (AppletCardException e) {
            this.omaService.closeChannel(infoReader.getChannelID());
            throw new AppletCardException(e.getErrCode(), e.getMessage());
        }
    }

    public void closeChannel() {
        this.omaService.closeChannel(this.channelID);
        this.channelID = null;
    }
}
