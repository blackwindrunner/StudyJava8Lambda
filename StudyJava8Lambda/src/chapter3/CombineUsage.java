package chapter3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import chapter1.Album;
import chapter1.Track;

public class CombineUsage {
	// ��ö��ר���У���Ŀ����60�����Ŀ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// һ���д��
	public Set<String> findLongTracks(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		for (Album album : albums) {// ��һ��ѭ���ҳ�ר��
			for (Track track : album.getTrackList()) {// �ڶ���ѭ���ҳ���Ŀ
				if (track.getLength() > 60) {// ��������
					String name = track.getName();// �������
					trackNames.add(name);// ����set
				}
			}
		}

		return trackNames;
	}

	// ��д��
	public Set<String> findLongTracksByStream(List<Album> albums) {
		return albums.stream().flatMap(album -> album.getTrackList().stream())// ͨ��flatMap�Ѷ�����ϲ���һ������һ������ѭ��ֱ�Ӹ㶨
				.filter(track -> track.getLength() > 60)// ͨ��filter��������
				.map(track -> track.getName())// ͨ��map�������
				.collect(Collectors.toSet());// ͨ��collect�ռ����ݣ�����set
	}

}
