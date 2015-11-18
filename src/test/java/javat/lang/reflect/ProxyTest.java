package javat.lang.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface ProxyService {
    String hello(String name);
}

public class ProxyTest {

    @Test
    public void testDynamicProxy() {
        ProxyService service =  (ProxyService) Proxy.newProxyInstance(ProxyService.class.getClassLoader(), new Class[]{ProxyService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (args.length == 1) {
                    return "Hello! " + args[0];
                }
                return "Defalut";
            }
        });
        System.out.println(service.hello("J.Ming"));
    }

}
