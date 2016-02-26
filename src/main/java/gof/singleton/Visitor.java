package gof.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Element {
    abstract void accept(IVisitor visitor);
    abstract void doSomething();
}

class ConcreteElement1 extends Element {
    public void doSomething() {
        System.out.println("这是元素1");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class ConcreteElement2 extends Element {
    public void doSomething() {
        System.out.println("这是元素2");
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

interface IVisitor {
    void visit(ConcreteElement1 e);
    void visit(ConcreteElement2 e);
}

public class Visitor implements IVisitor {

    @Override
    public void visit(ConcreteElement1 e) {
        e.doSomething();
    }

    @Override
    public void visit(ConcreteElement2 e) {
        e.doSomething();
    }

    public static void main(String[] args) {
        List<Element> list = ObjectStruture.getList();
        for (Element e : list) {
            e.accept(new Visitor());
        }
    }

}

class ObjectStruture {
    public static List<Element> getList() {
        List<Element> list = new ArrayList<Element>();
        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            int a = ran.nextInt(100);
            if (a > 50) {
                list.add(new ConcreteElement1());
            } else {
                list.add(new ConcreteElement2());
            }
        }
        return list;
    }
}