package chapter7;

import chapter1.Album;

public class TestFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadLocal<Album> thisAlbum = 
				ThreadLocal.withInitial(()-> new Album(null, null, null));
	
		
	}

}
