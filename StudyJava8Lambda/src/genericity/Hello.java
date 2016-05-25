package genericity;

public class Hello<T, V> {
	private T name;
	private V age;

	Hello(T name, V age) {
		this.age = age;
		this.name = name;
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	public V getAge() {
		return age;
	}

	public void setAge(V age) {
		this.age = age;
	}

	public static void main(String[] args) {
		Hello<String, Integer> he = new Hello<String, Integer>("1", 1);
		// he.setAge(10);
		// he.setName("Rollen Holt");
		System.out.println(he.getName() + "   " + he.getAge());
		Info<Integer> demo = new Info<Integer>("abc");
		function(demo);
	}

	public static void function(Info temp) {
		System.out.println("ÄÚÈÝ£º " + temp.getName());
	}
}
