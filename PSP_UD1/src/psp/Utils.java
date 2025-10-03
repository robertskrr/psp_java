package psp;

import java.util.*;

public class Utils {
	
	public static boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().contains("win");
	}

	public static List<String> sh(String cmd) {
		return isWindows() ? 
				Arrays.asList("cmd", "/c", cmd) 
				: Arrays.asList("sh", "-c", cmd);
	}
}
