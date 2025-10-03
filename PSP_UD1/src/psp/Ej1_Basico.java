package psp;

import java.util.*;

public class Ej1_Basico {

	public static void main(String[] args) throws Exception {
		Process p = new ProcessBuilder(Utils.sh("echo hola")).start();
		int rc = p.waitFor();
		System.out.println("RC=" + rc);
	}

}
