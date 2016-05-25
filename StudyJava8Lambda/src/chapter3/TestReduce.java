package chapter3;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class TestReduce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = Stream.of(1,2,3)
				.reduce(0,(acc,element)->acc+element);
		System.out.println(count);
		
		//上面的写法等同于下面的写法
		BinaryOperator<Integer> accumulateor = (acc,element)->acc+element;
		int count2 = 
				accumulateor.apply(
						accumulateor.apply(
								accumulateor.apply(0, 1)
								, 2)
				, 3);
		System.out.println(count2);
		
	}

}
