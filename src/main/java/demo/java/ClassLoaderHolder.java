package demo.java;

import gof.visitor.Visitor;

public class ClassLoaderHolder extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        ClassLoaderHolder myClassLoader = new ClassLoaderHolder();
        Visitor visitor = (Visitor) myClassLoader.loadClass("Visitor.class").newInstance();
    }

}
