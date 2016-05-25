package genericity;

public class Re {
	public static void main(String[] args) {
		Re re= new Re();
		re.write(1, new Integer[5]);
		re.write(1d, new Double[5]);
	}
	/*public void write(Integer i, Integer[] ia){
		System.out.println(i);
		System.out.println(ia);
		
	}
	public void write(Double  d, Double[] da){
		System.out.println(d);
		System.out.println(da);
	}*/
	public<T> void write(T t,T[] ta){
		System.out.println(t);
		System.out.println(ta);
	}
}
