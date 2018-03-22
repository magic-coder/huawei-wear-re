package com.huawei.hms.api;

import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.Collections;
import java.util.List;

public class Api<O extends ApiOptions> {
    private final String f1296a;
    private final Options<O> f1297b;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public final class NoOptions implements NotRequiredOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public abstract class Options<O> {
        public List<Scope> getScopeList(O o) {
            return Collections.emptyList();
        }

        public List<PermissionInfo> getPermissionInfoList(O o) {
            return Collections.emptyList();
        }
    }

    public Api(String str) {
        this.f1296a = str;
        this.f1297b = null;
    }

    public Api(String str, Options<O> options) {
        this.f1296a = str;
        this.f1297b = options;
    }

    public String getApiName() {
        return this.f1296a;
    }

    public Options<O> getOptions() {
        return this.f1297b;
    }
}
