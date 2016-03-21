package gof.proxy;

public class RealSubject implements Subject {

    @Override
    public void visit() {
        System.out.println("I am 'RealSubject', I am execute method");
    }

}
