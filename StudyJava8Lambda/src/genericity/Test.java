package genericity;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account<Chinese> a = new Account<Chinese>(new Chinese());
		function(a);
	}
	
	public static void function(Account<? super Beijing>  a){
		System.out.println(a);
	}
}
