package chapter4;

// BEGIN body
public interface Child extends Parent {

    @Override
    public default void welcome() {
        message("Child: Hi!");
        System.out.println("Child default welcome method");
    }

}
// END body
