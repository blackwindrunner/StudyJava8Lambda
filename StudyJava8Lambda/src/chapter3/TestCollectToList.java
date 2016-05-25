package chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class TestCollectToList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*List<Artist> allArtists = new ArrayList();
		allArtists.add(new Artist("abc"));
		allArtists.add(new Artist("456"));*/
		List<String> collected = Stream.of("a","b","c")
				.collect(Collectors.toList());
		System.out.println(collected);
		System.out.println(Arrays.asList("a","b","c"));
		assertEquals(Arrays.asList("a","b","c"),collected);
	}

}
