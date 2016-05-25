package chapter3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import chapter1.Album;
import chapter1.Track;

public class CombineUsage {
	// 获得多个专辑中，曲目大于60秒的曲目名称
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 一般的写法
	public Set<String> findLongTracks(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		for (Album album : albums) {// 第一层循环找出专辑
			for (Track track : album.getTrackList()) {// 第二层循环找出曲目
				if (track.getLength() > 60) {// 过滤条件
					String name = track.getName();// 获得名称
					trackNames.add(name);// 加入set
				}
			}
		}

		return trackNames;
	}

	// 流写法
	public Set<String> findLongTracksByStream(List<Album> albums) {
		return albums.stream().flatMap(album -> album.getTrackList().stream())// 通过flatMap把多个流合并成一个流，一二两层循环直接搞定
				.filter(track -> track.getLength() > 60)// 通过filter过滤条件
				.map(track -> track.getName())// 通过map获得名称
				.collect(Collectors.toSet());// 通过collect收集数据，加入set
	}

}
