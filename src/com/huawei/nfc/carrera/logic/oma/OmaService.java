package com.huawei.nfc.carrera.logic.oma;

import android.content.Context;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.nfc.PluginPay;
import com.huawei.nfc.PluginPayAdapter;
import com.huawei.nfc.carrera.logic.oma.internal.OmaException;
import com.huawei.nfc.carrera.logic.oma.model.ApduCommand;
import com.huawei.nfc.carrera.logic.oma.model.ChannelID;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class OmaService {
    private static final String CHANNELID = "00";
    private static final int CHANNELID_0 = 0;
    private static final String SELECT_COMMANDER = "00A40400";
    private static final String TAG = "OmaService";
    private static PluginPayAdapter pluginPayAdapter;
    private HashMap<ChannelID, String> channels = new HashMap();
    private HashMap<ChannelID, String> channelsEx = new HashMap();

    OmaService(Context context) {
        pluginPayAdapter = (PluginPayAdapter) PluginPay.getInstance(BaseApplication.b()).getAdapter();
    }

    TaskResult<ChannelID> excuteApduList(List<ApduCommand> list, ChannelID channelID) {
        TaskResult<ChannelID> taskResult = new TaskResult();
        String str = "Success";
        if (list == null || list.isEmpty()) {
            return setResult(taskResult, channelID, 1004, "OmaService excuteApduList failed.capdu is empty");
        }
        if (channelID == null) {
            channelID = new ChannelID();
        }
        resetApduCommondStatus(list);
        openChannel(channelID.getAid(), 0);
        str = (String) this.channels.get(channelID);
        for (ApduCommand apduCommand : list) {
            taskResult.setLastExcutedCommand(apduCommand);
            String apdu = apduCommand.getApdu();
            if (StringUtil.isEmpty(apdu, true)) {
                return setResult(taskResult, channelID, 1001, "OmaService apdu of command is null");
            }
            String str2;
            if (apdu.toUpperCase(Locale.getDefault()).startsWith("00A40400")) {
                int length = "00A40400".length();
                length += 2;
                apdu = apdu.substring(length, (Integer.parseInt(apdu.substring(length, length + 2), 16) * 2) + length);
                if (!StringUtil.isEmpty(str, true)) {
                    closeChannel();
                }
                channelID.setAid(apdu);
                C2538c.e("OmaService", new Object[]{"ServerAccessServiceImpl excuteApduListEx aid：" + apdu});
                Map openChannel = openChannel(apdu, channelID.getChannelType());
                PluginPayAdapter pluginPayAdapter = pluginPayAdapter;
                apdu = (String) openChannel.get("apdu");
                PluginPayAdapter pluginPayAdapter2 = pluginPayAdapter;
                str2 = (String) openChannel.get(PluginPayAdapter.KEY_OPEN_CHANNEL_ID);
                C2538c.e("ServerAccessServiceImpl excuteApduListEx selectResp　：" + apdu, new Object[0]);
                apduCommand.parseRapduAndSw(apdu);
                this.channels.put(channelID, str2);
            } else {
                try {
                    str2 = excuteApdu("00", apdu);
                    C2538c.c("OmaService", new Object[]{"excuteApduList requs : " + apdu + " ; resp : " + str2});
                    if (StringUtil.isEmpty(str2, true) || str2.length() < 4) {
                        apduCommand.setRapdu(str2);
                        return setResult(taskResult, channelID, 4001, "excuteApduList excuteApdu failed. rapdu is small. resp : " + str2);
                    }
                    apduCommand.parseRapduAndSw(str2);
                    apdu = apduCommand.getChecker();
                    str2 = apduCommand.getSw().toUpperCase(Locale.getDefault());
                    if ((apdu != null) && !str2.matches(apduCommand.getChecker())) {
                        C2538c.c("OmaService", new Object[]{"excuteApduList 执行结果状态字和预期不符，终止后续指令的执行，返回 "});
                        taskResult.setLastExcutedCommand(apduCommand);
                        return setResult(taskResult, channelID, 4002, "excuteApduList excuteApdu failed. sw is not matched. sw : " + apduCommand.getSw() + " checker : " + apduCommand.getChecker() + " apdu index : " + apduCommand.getIndex());
                    }
                } catch (OmaException e) {
                    return setResult(taskResult, channelID, e.getErrorCode(), "excuteApduList excuteApdu failed. apdu index : " + apduCommand.getIndex() + e.getMessage());
                }
            }
        }
        taskResult.setData(channelID);
        return taskResult;
    }

    public TaskResult<ChannelID> excuteApduListEx(List<ApduCommand> list, ChannelID channelID) {
        TaskResult<ChannelID> taskResult = new TaskResult();
        String str = "Success";
        if (list == null || list.isEmpty()) {
            return setResult(taskResult, channelID, 1004, "OmaService excuteApduListEx failed.capdu is empty");
        }
        if (channelID == null) {
            channelID = new ChannelID();
        }
        C2538c.e("OmaService", new Object[]{"ServerAccessServiceImpl excuteApduList nfcChannel　：" + ((String) this.channelsEx.get(channelID))});
        resetApduCommondStatus(list);
        for (ApduCommand apduCommand : list) {
            taskResult.setLastExcutedCommand(apduCommand);
            String apdu = apduCommand.getApdu();
            if (StringUtil.isEmpty(apdu, true)) {
                return setResult(taskResult, channelID, 1001, "OmaService excuteApduListEx apdu of command is null");
            }
            String str2;
            if (apdu.toUpperCase(Locale.getDefault()).startsWith("00A40400")) {
                int length = "00A40400".length();
                length += 2;
                apdu = apdu.substring(length, (Integer.parseInt(apdu.substring(length, length + 2), 16) * 2) + length);
                if (!StringUtil.isEmpty(str, true)) {
                    closeChannel();
                }
                channelID.setAid(apdu);
                C2538c.e("OmaService", new Object[]{"ServerAccessServiceImpl excuteApduListEx aid：" + apdu});
                Map openChannel = openChannel(apdu, channelID.getChannelType());
                PluginPayAdapter pluginPayAdapter = pluginPayAdapter;
                apdu = (String) openChannel.get("apdu");
                PluginPayAdapter pluginPayAdapter2 = pluginPayAdapter;
                str2 = (String) openChannel.get(PluginPayAdapter.KEY_OPEN_CHANNEL_ID);
                C2538c.e("ServerAccessServiceImpl excuteApduListEx selectResp　：" + apdu, new Object[0]);
                apduCommand.parseRapduAndSw(apdu);
                this.channelsEx.put(channelID, str2);
            } else {
                try {
                    str2 = excuteApdu("00", apdu);
                    C2538c.c("OmaService", new Object[]{"excuteApduListEx requs : " + apdu + " ; resp : " + str2});
                    if (StringUtil.isEmpty(str2, true) || str2.length() < 4) {
                        apduCommand.setRapdu(str2);
                        return setResult(taskResult, channelID, 4001, "excuteApduListEx excuteApdu failed. rapdu is small. resp : " + str2);
                    }
                    apduCommand.parseRapduAndSw(str2);
                    apdu = apduCommand.getChecker();
                    str2 = apduCommand.getSw().toUpperCase(Locale.getDefault());
                    if ((apdu != null) && !str2.matches(apduCommand.getChecker())) {
                        taskResult.setLastExcutedCommand(apduCommand);
                        return setResult(taskResult, channelID, 4002, "excuteApduListEx excuteApdu failed. sw is not matched. sw : " + apduCommand.getSw() + " checker : " + apduCommand.getChecker() + " apdu index : " + apduCommand.getIndex());
                    }
                } catch (OmaException e) {
                    return setResult(taskResult, channelID, e.getErrorCode(), "excuteApduListEx excuteApdu failed. apdu index : " + apduCommand.getIndex() + e.getMessage());
                }
            }
        }
        taskResult.setData(channelID);
        return taskResult;
    }

    private TaskResult<ChannelID> setResult(TaskResult<ChannelID> taskResult, ChannelID channelID, int i, String str) {
        taskResult.setData(channelID);
        taskResult.setResultCode(i);
        taskResult.setMsg(str);
        return taskResult;
    }

    private void resetApduCommondStatus(List<ApduCommand> list) {
        for (ApduCommand apduCommand : list) {
            apduCommand.setRapdu("");
            apduCommand.setSw("");
        }
    }

    private String excuteApdu(String str, String str2) throws OmaException {
        return pluginPayAdapter.sendApdu(str, str2);
    }

    public Map openChannel(String str, int i) {
        C2538c.c("OmaService", new Object[]{" NfcChannel open channel for " + str});
        return pluginPayAdapter.openChannel(str, i);
    }

    public void closeChannel() {
        pluginPayAdapter.closeChannel();
    }
}
