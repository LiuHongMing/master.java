package gof.singleton;

/**
 * JVM虚拟机同步机制实现
 * 
 * 单例模式-内部类
 * 
 * @author liuhongming
 *
 */
public class InnerClass
{

    private InnerClass() {
    }

    private static class SingletonHolder
    {   
        public final static InnerClass instance = new InnerClass();
    }   
  
    public static InnerClass getInstance()
    {   
        return SingletonHolder.instance;   
    }   
} 