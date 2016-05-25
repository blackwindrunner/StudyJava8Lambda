package lambda;

public class Test {

	public static void main(String[] args) {
		//带参数的接口
		//一种对fly接口唯一方法add的实现
		Sum sum = (x, y) -> x + y;
		System.out.println("sum:"+sum.add(11, 22));
		//另一种接口的实现
		Sum sum2 = (x, y) -> x+1-y;
		System.out.println("sum2:"+sum2.add(11, 22));
		//显示指明返回值
		Sum sum3 = (int x, int y) -> {
			System.out.println("x="+x);
			return x+1-y;
			};
		System.out.println("sum3:"+sum3.add(11, 22));
		
		
		//无返回值的接口
		Print p = (x)->System.out.println("x="+x);
		p.print("12");
		
		//不带参数的接口
		Max m = ()-> "abc";
		System.out.println(m.maxNumber());
		
	}
	
	
	
}
