package chapter3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import chapter1.Track;

public class TestMaxAndMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Track> tracks = Arrays.asList(
				new Track("Bakai",524),
				new Track("Violets",378),
				new Track("Time Was",451)
				);
		Track shortesTrack = tracks.stream()
				.min(Comparator.comparing(track -> track.getLength()))
				.get();
		System.out.println(shortesTrack.getName());
		
		shortesTrack = tracks.stream()
				.max(Comparator.comparing(track -> track.getLength()))
				.get();
		System.out.println(shortesTrack.getName());
		
	}

}
