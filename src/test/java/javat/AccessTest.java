package javat;

/**
 * Java访问权限修饰词：public、protected、包访问权限(默认访问权限，有时也称friendly)和private。
 * 包访问权限：当前包中的所有其他类对那个成员具有访问权限，但对于这个包之外的所有类，这个成员却是private。
 * protected：继承访问权限。有时基类的创建者会希望有某个特定成员，把对它的访问权限赋予派生类而不是所有类。
 * 这就需要protected来完成这一工作。protected也提供包访问权限，也就是说，相同包内的其他类都可以访问protected元素。
 * protected指明“就类用户而言，这是private的，但对于任何继承于此类的导出类或其他任何位于同一个包内的类来说，它却是可以访问的”。
 */
public class AccessTest {

    public AccessTest() {
        System.out.println("Cookie construction");
    }

    void access() { // 包控制访问权限，其它包即使是子类也不能访问它
        System.out.println("bite");
    }

}
