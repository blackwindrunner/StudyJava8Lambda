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
		return albums.parallelStream()//���ﻻ���˲��м��㣬������ǰ���ŵĲ��м��㷽ʽ
				.flatMap(Album::getTracks)
				.mapToInt(Track::getLength)
				.sum();
				
				
	}
	//
	public static double[] parallelInitialize(int size){
		double[] values = new double[size];
		Arrays.parallelSetAll(values, i->i);
		//��������´���
		/*for (int i = 0; i < values.length; i++) {
			values[i]=i;
		}*/
		return values;
	}
}
