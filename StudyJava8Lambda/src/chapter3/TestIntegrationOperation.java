package chapter3;

import java.util.Set;
import chapter1.Album;
import chapter1.Artist;
import chapter1.SampleData;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
public class TestIntegrationOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleData sa= new SampleData();
		Set<String> origins = sa.manyTrackAlbum.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getNationality())
                .collect(toSet());
		System.out.println(origins);
	}

}
