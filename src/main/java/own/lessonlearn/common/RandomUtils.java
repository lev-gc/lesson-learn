package own.lessonlearn.common;

import java.util.Date;

public class RandomUtils {

	/**
	 * Generate a random String (a TimeStamp with some random number).
	 * 
	 * @param length length of random number without TimeStamp.
	 * @return a random string.
	 */
	public static String generateRandomString(int length) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int number = (int) (Math.random() * 10);
			s.append(number);
		}
		return (new Date()).getTime() + s.toString();
	}

}
