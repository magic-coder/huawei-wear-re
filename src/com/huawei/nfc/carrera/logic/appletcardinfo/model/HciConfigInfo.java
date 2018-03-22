package com.huawei.nfc.carrera.logic.appletcardinfo.model;

import com.huawei.nfc.carrera.logic.appletcardinfo.operation.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HciConfigInfo {
    public static final String HCI_DATA_TYPE_AFTER_TERMINAL_ID = "terminal";
    public static final String HCI_DATA_TYPE_AFTER_TRANSCTION_BALANCE = "balance";
    public static final String HCI_DATA_TYPE_TRANSCTION_AMOUNT = "amt";
    public static final String HCI_DATA_TYPE_TRANSCTION_DATE = "date";
    public static final String HCI_DATA_TYPE_TRANSCTION_TIME = "time";
    public static final String HCI_DATA_TYPE_TRANSCTION_TYPE = "trans_type";
    public static final String HCI_DATA_TYPE_VERSION = "version";
    private Map<String, List<Operation>> operations = new HashMap();
    private String version;

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void addOperations(String str, List<Operation> list) {
        this.operations.put(str, list);
    }

    public List<Operation> getOperationsByType(String str) {
        return (List) this.operations.get(str);
    }
}
