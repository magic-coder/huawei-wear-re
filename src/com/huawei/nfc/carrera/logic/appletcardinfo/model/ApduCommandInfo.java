package com.huawei.nfc.carrera.logic.appletcardinfo.model;

import com.huawei.nfc.carrera.logic.appletcardinfo.operation.Operation;
import com.huawei.nfc.carrera.logic.oma.model.ApduCommand;
import java.util.List;

public class ApduCommandInfo extends ApduCommand {
    private List<Operation> operations;
    private String type;

    public ApduCommandInfo(int i, String str, String str2, String str3, List<Operation> list) {
        super(i, str, str2);
        this.type = str3;
        this.operations = list;
    }

    public List<Operation> getOperations() {
        return this.operations;
    }

    public void setOperations(List<Operation> list) {
        this.operations = list;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
