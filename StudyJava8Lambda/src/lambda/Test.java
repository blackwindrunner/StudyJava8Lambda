package lambda;

public class Test {

	public static void main(String[] args) {
		//�������Ľӿ�
		//һ�ֶ�fly�ӿ�Ψһ����add��ʵ��
		Sum sum = (x, y) -> x + y;
		System.out.println("sum:"+sum.add(11, 22));
		//��һ�ֽӿڵ�ʵ��
		Sum sum2 = (x, y) -> x+1-y;
		System.out.println("sum2:"+sum2.add(11, 22));
		//��ʾָ������ֵ
		Sum sum3 = (int x, int y) -> {
			System.out.println("x="+x);
			return x+1-y;
			};
		System.out.println("sum3:"+sum3.add(11, 22));
		
		
		//�޷���ֵ�Ľӿ�
		Print p = (x)->System.out.println("x="+x);
		p.print("12");
		
		//���������Ľӿ�
		Max m = ()-> "abc";
		System.out.println(m.maxNumber());
		
	}
	
	
	
}
