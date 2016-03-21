package javat.bytecode.cglib;

public class CglibClient {

    public static void main(String[] args) {
        CglibDynamicProxy cglib = new CglibDynamicProxy();
        CglibRealObject realObject = (CglibRealObject) cglib.getProxyInstance(new CglibRealObject());
        realObject.go();
        System.out.println(realObject.visit());
    }

}
