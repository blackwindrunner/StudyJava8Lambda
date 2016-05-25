package chapter7;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import org.junit.Test;
import static java.util.Collections.emptyList;

import chapter1.Album;
import chapter1.Track;

public class Count {
	private List<Album> albums;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//统计所有曲目长度之和，古老的方式
	public long  countRunningTime(){
		long count = 0;
		for (Album album : albums) {
			for (Track track : album.getTrackList()) {
				count += track.getLength();
			}
		}
		return count;
	}
	//lambda方式
	public long countRunningTimeByLambda(){
		return albums.stream().mapToLong(album->album.getTracks()
				.mapToLong(track -> track.getLength())
				.sum()).sum();
	}
	
	
	
	//另外的方式，需要一个领域方法
	public long countFeature(ToLongFunction<Album> function){
		return albums.stream()
				.mapToLong(function)
				.sum();
	}
	public long countTracks(){
		return countFeature(album->album.getTracks().count());
	}
	public long countRunningTimeByFunction(){
		return countFeature(album ->album.getTracks()
				.mapToLong(track -> track.getLength())
				.sum());
	}
	@Test
	public void canCountFeatures(){
		OrderDomain order = new OrderDomain(Arrays.asList(
                newAlbum("Exile on Main St."),
                newAlbum("Beggars Banquet"),
                newAlbum("Aftermath"),
                newAlbum("Let it Bleed")));

        assertEquals(8, order.countFeature(album -> 2));
	}
	 private Album newAlbum(String name) {
	        return new Album(name, emptyList(), emptyList());
	    }
}
