package chapter4;

// BEGIN body
public interface Parent {

    public void message(String body);

    public default  void welcome() {
        message("Parent: Hi!");
        System.out.println("Parent default welcome method");
    }

    public String getLastMessage();

}
// END body
