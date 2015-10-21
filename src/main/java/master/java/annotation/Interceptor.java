package master.java.annotation;

public interface Interceptor<T> {

	public Class<T> getAnnotationClass();

}
