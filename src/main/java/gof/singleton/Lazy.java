package gof.singleton;

/**
 * 单例模式-懶汉式
 * 
 * @author liuhongming
 *
 */
public class Lazy
{   
	private static Lazy instance = null;
 
	private Lazy() {}
	
    public static Lazy getInstance()
    {   
    	if (instance == null) {
    		instance = new Lazy();
    	}
        return instance;   
    }   
} 