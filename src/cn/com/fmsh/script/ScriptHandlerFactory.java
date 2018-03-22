package cn.com.fmsh.script;

import cn.com.fmsh.script.core.ScriptHandlerImpl;

public class ScriptHandlerFactory {
    private static volatile /* synthetic */ ScriptHandlerFactory f9492a;

    private /* synthetic */ ScriptHandlerFactory() {
    }

    public static ScriptHandlerFactory getInstance() {
        if (f9492a == null) {
            scriptHandlerFactoryInit();
        }
        return f9492a;
    }

    public static void scriptHandlerFactoryInit() {
        if (f9492a == null) {
            f9492a = new ScriptHandlerFactory();
        }
    }

    public ScriptHandler getScriptHandler(ApduHandler apduHandler) {
        return new ScriptHandlerImpl(apduHandler);
    }
}
