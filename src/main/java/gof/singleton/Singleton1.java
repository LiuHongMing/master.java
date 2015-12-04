package gof.singleton;

/**
 * JVM虚拟机同步机制实现
 * 
 * 内部类
 * 
 * @author liuhongming
 *
 */
public class Singleton1   
{   
    private static class SingletonHolder   
    {   
        public final static Singleton1 instance = new Singleton1();   
    }   
  
    public static Singleton1 getInstance()   
    {   
        return SingletonHolder.instance;   
    }   
} 