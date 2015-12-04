package gof.singleton;

/**
 * 单例模式-饿汉式
 * 
 * @author J.Ming
 *
 */
public class Hungry
{   
	private static final Hungry instance = new Hungry();
 
	private Hungry() {}
	
    public static Hungry getInstance()
    {   
        return instance;   
    }   
} 