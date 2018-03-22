package cn.com.fmsh.nfcos.client.libs;

import cn.com.fmsh.nfcos.client.libs.core.NfcosClientManagerImpl;

public class NfcosClientManagerFactory {
    private static NfcosClientManagerImpl nfcosClientManager;

    private NfcosClientManagerFactory() {
    }

    public static NfcosClientManager getNfcosClientManager() {
        if (nfcosClientManager == null) {
            nfcosClientManager = new NfcosClientManagerImpl();
            nfcosClientManager.init();
        }
        return nfcosClientManager;
    }
}
