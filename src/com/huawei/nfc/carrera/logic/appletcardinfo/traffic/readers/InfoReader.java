package com.huawei.nfc.carrera.logic.appletcardinfo.traffic.readers;

import com.huawei.nfc.carrera.logic.appletcardinfo.exception.AppletCardException;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.ApduCommandInfo;
import com.huawei.nfc.carrera.logic.appletcardinfo.operation.Operation;
import com.huawei.nfc.carrera.logic.appletcardinfo.result.AppletCardResult;
import com.huawei.nfc.carrera.logic.oma.IOmaService;
import com.huawei.nfc.carrera.logic.oma.TaskResult;
import com.huawei.nfc.carrera.logic.oma.model.ApduCommand;
import com.huawei.nfc.carrera.logic.oma.model.ChannelID;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public abstract class InfoReader<T> {
    private ChannelID channelID;
    private List<ApduCommand> commandList;
    private IOmaService omaService;

    protected abstract T handleResult(List<List<String>> list) throws AppletCardException;

    protected InfoReader(IOmaService iOmaService) {
        this.omaService = iOmaService;
    }

    public T readInfo() throws AppletCardException {
        if (this.commandList == null) {
            throw new AppletCardException(1, "readInfo commandList is null");
        }
        List arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List list = arrayList2;
        for (ApduCommand apduCommand : this.commandList) {
            if (apduCommand instanceof ApduCommandInfo) {
                ApduCommandInfo apduCommandInfo;
                apduCommandInfo = (ApduCommandInfo) apduCommand;
                list.add(apduCommandInfo);
                if (apduCommandInfo.getOperations() != null) {
                    arrayList.add(list);
                    arrayList2 = new ArrayList();
                } else {
                    List list2 = list;
                }
                list = arrayList2;
            }
        }
        List arrayList3 = new ArrayList();
        int size = arrayList.size();
        if (size <= 0) {
            throw new AppletCardException(2, "readInfo no operation exists in any APDU command.");
        }
        int i = 0;
        while (i < size) {
            list2 = (List) arrayList.get(i);
            TaskResult excuteApduList = this.omaService.excuteApduList(list2, this.channelID);
            this.channelID = (ChannelID) excuteApduList.getData();
            int resultCode;
            if (excuteApduList.getResultCode() != 0) {
                String msg = excuteApduList.getMsg();
                resultCode = excuteApduList.getResultCode();
                if (resultCode == IOmaService.RETURN_APDU_EXCUTE_OPENCHANNEL_NOAID) {
                    resultCode = 3;
                } else if (resultCode == 4002) {
                    resultCode = checkVerifyPinSW(excuteApduList.getLastExcutedCommand().getApdu(), excuteApduList.getLastExcutedCommand().getSw());
                } else if (resultCode == 4001) {
                    resultCode = 9;
                } else {
                    resultCode = 6;
                }
                throw new AppletCardException(resultCode, "readInfo excuteApduList failed. " + msg);
            }
            apduCommandInfo = (ApduCommandInfo) list2.get(list2.size() - 1);
            Object obj = null;
            try {
                obj = handlerRespData(apduCommandInfo.getRapdu(), apduCommandInfo.getOperations());
            } catch (AppletCardException e) {
                LogX.i("readInfo step " + i + "/" + size + " failed. msg : " + e.getMessage() + " apdu info " + apduCommandInfo.toString());
            }
            resultCode = getNextStep(apduCommandInfo, i, size);
            arrayList3.add(obj);
            i = resultCode;
        }
        return handleResult(arrayList3);
    }

    protected int getNextStep(ApduCommandInfo apduCommandInfo, int i, int i2) {
        return i + 1;
    }

    private int checkVerifyPinSW(String str, String str2) {
        if (!str.startsWith("00200000")) {
            return 9;
        }
        if (str2.startsWith("63C")) {
            return 207;
        }
        if ("6983".equals(str2)) {
            return AppletCardResult.RESULT_FAILED_TRAFFIC_CARD_INFO_PIN_LOCKED;
        }
        return 9;
    }

    public T readInfoFromData(String str, List<Operation> list) throws AppletCardException {
        if (StringUtil.isEmpty(str, true) || list == null || list.isEmpty()) {
            throw new AppletCardException(1, "readInfoFromData param is illegal");
        }
        List handlerRespData = handlerRespData(str, list);
        List arrayList = new ArrayList();
        arrayList.add(handlerRespData);
        return handleResult(arrayList);
    }

    private List<String> handlerRespData(String str, List<Operation> list) throws AppletCardException {
        if (list == null) {
            throw new AppletCardException(1, "handlerRespData param is illegal");
        }
        List<String> arrayList = new ArrayList(list.size() + 1);
        arrayList.add(str);
        for (int i = 0; i < list.size(); i++) {
            Operation operation = (Operation) list.get(i);
            if (operation.isNeedChangeParamWithData()) {
                operation.changeParamWithData(arrayList);
            }
            arrayList.add(operation.checkAndHandleData(arrayList));
        }
        return arrayList;
    }

    protected void checkData(String str, List<String> list) throws AppletCardException {
        if (list == null || list.isEmpty()) {
            throw new AppletCardException(999, str + " the data is empty");
        }
    }

    public ChannelID getChannelID() {
        return this.channelID;
    }

    public void setChannelID(ChannelID channelID) {
        this.channelID = channelID;
    }

    public void setCommandList(List<ApduCommand> list) {
        this.commandList = list;
    }
}
