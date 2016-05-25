package chapter5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import chapter1.Album;
import chapter1.Artist;
import chapter1.SampleData;

public class CollectorExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CollectorExamples c = new CollectorExamples();
		Map<Boolean, List<Artist>> m = c.bandsAndSolo(SampleData.getThreeArtists().stream());
		System.out.println(m.get(true));
		System.out.println(m.get(false));
		System.out.println(c.testJoining(SampleData.getThreeArtists()));
	}

	public void toCollectionTreeset() {
		Stream<Integer> stream = Stream.of(1, 2, 3);
		// BEGIN TO_COLLECTION_TREESET
		stream.collect(Collectors.toCollection(TreeSet::new));
		// 同上
		stream.collect(Collectors.toCollection(() -> new TreeSet()));
		// 通过toCollection来转换成其他指定的集合
		TreeSet ts = stream.collect(Collectors.toCollection(() -> new TreeSet()));
		// END TO_COLLECTION_TREESET
	}

	public Optional<Artist> biggestGroup(Stream<Artist> artists) {
		Function<Artist, Long> getCount = artist -> artist.getMembers().count();
		return artists.collect(Collectors.maxBy(Comparator.comparing(getCount)));
	}

	// BEGIN averagingTracks
	public double averageNumberOfTracks(List<Album> albums) {
		return albums.stream().collect(Collectors.averagingInt(album -> album.getTrackList().size()));
	}
	// END averagingTracks

	// BEGIN BANDS_AND_SOLO
	// 将流一次性分开成两部分
	public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
		return artists.collect(Collectors.partitioningBy(artist -> artist.isSolo()));
	}

	// END BANDS_AND_SOLO
	// BEGIN BANDS_AND_SOLO_REF
	public Map<Boolean, List<Artist>> bandsAndSoloRef(Stream<Artist> artists) {
		return artists.collect(Collectors.partitioningBy(Artist::isSolo));
	}
	// END BANDS_AND_SOLO_REF

	// BEGIN ALBUMS_BY_ARTIST
	public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
		return albums.collect(Collectors.groupingBy(album -> album.getMainMusician()));
	}
	// END ALBUMS_BY_ARTIST

	public String testJoining(List<Artist> artists) {
		String result = artists.stream().map(Artist::getName).collect(Collectors.joining(",", "[", "]"));
		return result;
	}

	public Map<Artist, Integer> numberOfAlbumsDumb(Stream<Album> albums) {
		// BEGIN NUMBER_OF_ALBUMS_DUMB
		Map<Artist, List<Album>> albumsByArtist = albums.collect(Collectors.groupingBy(album -> album.getMainMusician()));

		Map<Artist, Integer> numberOfAlbums = new HashMap<>();
		for (Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
			numberOfAlbums.put(entry.getKey(), entry.getValue().size());
		}
		// END NUMBER_OF_ALBUMS_DUMB
		return numberOfAlbums;
	}
	public Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
	    return albums.collect(Collectors.groupingBy(album -> album.getMainMusician(),
	    		Collectors.counting()));
	}
}
