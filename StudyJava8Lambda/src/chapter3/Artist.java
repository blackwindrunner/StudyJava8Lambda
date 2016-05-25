package chapter3;

public class Artist {
	public Artist(){}
	public Artist(String name){
		this.name=name;
	}
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public boolean isFrom(String name){
		return this.name==name || (this.name != null && this.name.equals(name));
	}
}
