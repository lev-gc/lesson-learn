package own.lessonlearn.common;

import java.util.Date;

public class RandomUtils {

	public static String generateRandomString(int length) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int number = (int) (Math.random() * 10);
			s.append(number);
		}
		return (new Date()).getTime() + s.toString();
	}

}
