package gof.proxy;

public class Client {

    public static void main(String[] args) {
        Subject proxySubject = new ProxySubject(new RealSubject());
        proxySubject.visit();
    }

}
