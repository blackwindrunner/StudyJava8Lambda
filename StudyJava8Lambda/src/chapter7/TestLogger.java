package chapter7;
import chapter4.Logger;

public class TestLogger {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = new Logger();
		if (logger.isDebugEnabled()) {
		    logger.debug("Look at this: " + expensiveOperation());
		}
		//Lambda���ʽ
		logger.debug(()->"sdf");
		//��ͨ����
		logger.debug("abc");
		
		
		
	}
	private static String expensiveOperation() {
        return "1";
    }
}
