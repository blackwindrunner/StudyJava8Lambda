package chapter7;


public class TestLog {
	public static void main(String[] args) {
		Logger log = new Logger();
		/*log.setDebugEnable(true);
		if(log.isDebugEnable()){
			log.debug("debug");
		}*/
	}
}

class Logger{
	private boolean isDebugEnable;

	public boolean isDebugEnable() {
		return isDebugEnable;
	}

	public void setDebugEnable(boolean isDebugEnable) {
		this.isDebugEnable = isDebugEnable;
	}
	public void debug(String str){
		System.out.println(str);
	}
	
}
