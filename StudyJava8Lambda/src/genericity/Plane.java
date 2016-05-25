package genericity;

import java.util.function.BinaryOperator;


public class Plane implements Fly<String> {
	public static void main(String[] args){
		Fly<String> fly = new Plane();
		fly.zhendong("aa");
		BinaryOperator<Long> add = (x, y) -> x + y; // <4>
		/*BinaryOperator a=new BinaryOperator<Long>(){
			@Override
			public Long apply(Long t, Long u) {
				// TODO Auto-generated method stub
				return t*u;
			}
			
		};*/
		System.out.println(add.apply(1l, 2l));
	}

	@Override
	public void zhendong(String t) {
		// TODO Auto-generated method stub
		System.out.println(t);
	}
	

}
