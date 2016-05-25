package chapter4;

public class TestPrentAndChild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new ParentImpl();
		p.welcome();
		System.out.println(p.getLastMessage());
		
		Parent c = new ChildImpl();
		c.welcome();
		System.out.println(c.getLastMessage());
		
		
		OverridingParent o = new OverridingParent();
		o.welcome();
		System.out.println(o.getLastMessage());
		
	}

}
