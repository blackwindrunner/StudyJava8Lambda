package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestBeginning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> beginningWithNumbers=new ArrayList<>();
		for (String value : Arrays.asList("a","1abc","abc1")) {
			System.out.println(value);
			if(Character.isDigit(value.charAt(0))){
				beginningWithNumbers.add(value);
			}
		}
		System.out.println(beginningWithNumbers);
		beginningWithNumbers=Stream.of("a","1abc","abc1","2bdd")
				.filter(value ->Character.isDigit(value.charAt(0)))
//				.filter(value -> '2'==(value.charAt(0)))
				.collect(Collectors.toList());
		System.out.println(beginningWithNumbers);
				
		
	}

}
