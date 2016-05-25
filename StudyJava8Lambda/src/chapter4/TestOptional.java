package chapter4;

import java.util.Optional;

public class TestOptional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Optional<String> a  = Optional.of("a");
		System.out.println(a.get());
		Optional emptyOptional = Optional.empty();
		System.out.println(emptyOptional);
		System.out.println(emptyOptional.isPresent());
		System.out.println(a.isPresent());
		System.out.println(emptyOptional.orElse("b"));
		System.out.println(emptyOptional.orElseGet(()->"c"));
	}

}
