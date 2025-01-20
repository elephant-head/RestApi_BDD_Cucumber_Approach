package restAssuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtil {
	
	public static String getFirstName() {
		String generateString=RandomStringUtils.randomAlphabetic(1);
		return("John"+generateString);
	}
	
	public static String getLastName() {
		String generateString=RandomStringUtils.randomAlphabetic(1);
		return("Kenedy"+generateString);
	}
	
	public static String getUserName() {
		String generateString=RandomStringUtils.randomAlphabetic(1);
		return("John"+generateString);
	}
	
	public static String getPassword() {
		String generateString=RandomStringUtils.randomAlphabetic(3);
		return("John"+generateString);
	}
	
	public static String getEmail() {
		String generateString=RandomStringUtils.randomAlphabetic(3);
		return(generateString+"gmail.com");
	}
	
	public static String getempName() {
		String generateString=RandomStringUtils.randomAlphabetic(3);
		return("John"+generateString);
	}
	
	public static String getempSal() {
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return(generateString);
	}
	
	public static String getempAge() {
		String generateString=RandomStringUtils.randomAlphabetic(2);
		return(generateString);
	}

}
