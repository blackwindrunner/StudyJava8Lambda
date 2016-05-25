package genericity;

public class Account<T> {
	private T c;
	
	public Account(T c){
		this.c=c;
	}
	
	public String toString() {
		return "Account [c=" + c + ", toString()=" + super.toString() + "]";
	}
	
}
