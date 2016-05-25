package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Test {

	public static void main(String[] args) {
		List<Artist> allArtists = new ArrayList();
		allArtists.add(new Artist("abc"));
		allArtists.add(new Artist("456"));
		long count = 0;
		//传统方式
		count=allArtists.stream().filter(new Predicate<Artist>(){
			@Override
			public boolean test(Artist t) {
				// TODO Auto-generated method stub
				return t.isFrom("abc");
			}
		}).count();
		System.out.println(count);
		//Lambda方式
		count= allArtists.stream().filter(artist -> artist.isFrom("abc"))
				.count();
		System.out.println(count);
		
		//研究steam
		allArtists.stream().filter(artist -> {
			System.out.println(artist.getName());
			return artist.isFrom("abc");
		}).count();
	}

}
