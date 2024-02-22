package com.nagarro.remotelearning.proxy;

import com.nagarro.remotelearning.annotations.Logged;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Class<T> interfaceClass, T target) {
        return (T) Proxy.newProxyInstance(
                interfaceClass.getClassLoader(),
                new Class<?>[]{interfaceClass},
                new CustomInvocationHandler(target)
        );
    }

    private static class CustomInvocationHandler implements InvocationHandler {
        private final Object target;

        public CustomInvocationHandler(Object target) {
            this.target = target;
        }

        private static boolean isAnnotationPresent(Method method) {
            return method.isAnnotationPresent(Logged.class);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (isAnnotationPresent(method) || isAnnotationPresent()) {

                logInfo(method, target, args);
            } else {

                return method.invoke(target, args);
            }
            return null;
        }

        private boolean isAnnotationPresent() {
            return target.getClass().isAnnotationPresent(Logged.class);
        }

        private void logInfo(Method method, Object target, Object[] args) {
            System.out.println("Method: " + method.getName());
            System.out.println("Object: " + target);
            System.out.println("Object Type: " + target.getClass().getName());
            System.out.println("Parameters:");
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    System.out.println("Parameter " + (i + 1) + ": " + args[i]);
                }
            }
        }
    }
}