package chapter4;

import java.util.IntSummaryStatistics;

import chapter1.Album;
import chapter1.SampleData;

public class TestPrimitives {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPrimitives t =new TestPrimitives();
		t.printTrackLengthStatistics(new SampleData().manyTrackAlbum);
	}
	public static void printTrackLengthStatistics(Album album){
		IntSummaryStatistics trackLengthStats;
		trackLengthStats= album.getTracks()
				.mapToInt(track -> track.getLength())
				.summaryStatistics();
		 System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                 trackLengthStats.getMax(),
                 trackLengthStats.getMin(),
                 trackLengthStats.getAverage(),
                 trackLengthStats.getSum());
	}
}
