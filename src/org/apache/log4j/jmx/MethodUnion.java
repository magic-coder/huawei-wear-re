package org.apache.log4j.jmx;

import java.lang.reflect.Method;

class MethodUnion {
    Method readMethod;
    Method writeMethod;

    MethodUnion(Method method, Method method2) {
        this.readMethod = method;
        this.writeMethod = method2;
    }
}
