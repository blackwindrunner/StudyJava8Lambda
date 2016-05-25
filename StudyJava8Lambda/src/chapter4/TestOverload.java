package chapter4;

import java.util.function.BinaryOperator;

public class TestOverload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestOverload t = new TestOverload();
		t.overloadedMethod((x,y)-> x+y);
	}

	private interface IntegerBiFunction extends BinaryOperator<Integer>{
		
	}
	
	private void overloadedMethod(BinaryOperator<Integer> Lambda){
		System.out.println("BinaryOperator");
	}
	//������������û�����������Ǹ�
	private void overloadedMethod(IntegerBiFunction Lambda){
		System.out.println("IntegerBiFunction");
	}
	
	
}