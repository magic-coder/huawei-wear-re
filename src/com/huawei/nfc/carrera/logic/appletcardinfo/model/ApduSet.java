package com.huawei.nfc.carrera.logic.appletcardinfo.model;

import com.huawei.nfc.carrera.logic.appletcardinfo.constant.Constants;
import com.huawei.nfc.carrera.logic.oma.model.ApduCommand;
import java.util.HashMap;
import java.util.List;

public class ApduSet {
    private HashMap<String, List<ApduCommand>> apduTable = new HashMap();
    private boolean isSameApduNumAndDate;

    public void add(String str, List<ApduCommand> list) {
        this.apduTable.put(str, list);
    }

    public List<ApduCommand> getApduByType(String str) {
        return (List) this.apduTable.get(str);
    }

    public boolean isSameApduNumAndDate() {
        return this.isSameApduNumAndDate;
    }

    public void compareCardNumAndDateApdus() {
        List list = (List) this.apduTable.get(Constants.FIELD_APPLET_CONFIG_NUM);
        List list2 = (List) this.apduTable.get("date");
        if (list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            this.isSameApduNumAndDate = false;
        } else if (list.size() != list2.size()) {
            this.isSameApduNumAndDate = false;
        } else {
            int i = 0;
            while (i < list.size()) {
                if (((ApduCommand) list.get(i)).getApdu().equalsIgnoreCase(((ApduCommand) list2.get(i)).getApdu())) {
                    i++;
                } else {
                    this.isSameApduNumAndDate = false;
                    return;
                }
            }
            this.isSameApduNumAndDate = true;
        }
    }
}
