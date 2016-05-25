package chapter6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import chapter1.Album;
import chapter1.SampleData;
import chapter1.Track;

public class ParallelTest {
	static List<Album> albums;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(parallelInitialize(1));
		
		parallelInitialize(5);
		Set set =new HashSet();
		set.add("a");
		set.add("b");
		set.add("c");
		set.forEach(System.out::println);
	}
	
	public int parallelArraySum(){
		return albums.parallelStream()//这里换成了并行计算，区分了前几张的并行计算方式
				.flatMap(Album::getTracks)
				.mapToInt(Track::getLength)
				.sum();
				
				
	}
	//
	public static double[] parallelInitialize(int size){
		double[] values = new double[size];
		Arrays.parallelSetAll(values, i->i);
		//替代了如下代码
		/*for (int i = 0; i < values.length; i++) {
			values[i]=i;
		}*/
		return values;
	}
}
