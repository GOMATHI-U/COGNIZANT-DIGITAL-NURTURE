public class SingletonTest{
	public static void main(String args[]){
		
		Logger l1 = Logger.getLoggerInstance();
		l1.log("This is Logger1");
		
		Logger l2 = Logger.getLoggerInstance();
		l2.log("This is Logger2");
		
		
		if(l1 == l2){
			System.out.println("Singleton succesful");
		} else{
			System.out.println("Singleton not Successful");
		}
	}
}
