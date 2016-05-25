package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestFlatMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> together = Stream.of(Arrays.asList(1,2),Arrays.asList(3,4))
				.flatMap(numbers -> numbers.stream())
				.collect(Collectors.toList());
		System.out.println(together);
	}

}
