package genericity;

public class Info<T> {
	private T name;
	private String password;
	Info(String password) {
		this.password = password;
	}
	public T getName(){
		return name;
	}
	
}
