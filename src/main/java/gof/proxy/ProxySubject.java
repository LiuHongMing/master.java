package gof.proxy;

import gof.proxy.Subject;

/**
 * Created by liuhongming on 3/21/2016.
 */
public class ProxySubject implements Subject {

    private Subject realSubject;

    public ProxySubject(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void visit() {
        System.out.println("I am 'ProxySubject', I am invoke realSubject method");
        realSubject.visit();
    }
}
