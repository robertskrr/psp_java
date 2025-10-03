package psp;

import java.io.*;
import java.util.*;

public class Ej2_LeerSalida {

	public static void main(String[] args) {
		// Para convertir bytes en texto:
		// - InputStreamReader -> convierte bytes a caracteres.
		// - BufferedReader -> permite leer líneas completas y cerrar el recurso.

		try {
			BufferedReader br;

			// ==== PRIMER PROCESO: echo hola ====
			Process p1 = new ProcessBuilder(Utils.sh("echo hola")).start();
			br = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			System.out.println("STDOUT: " + br.readLine());
			br.close();
			p1.waitFor();

			// ==== SEGUNDO PROCESO: java -version (va a STDERR) ====
			Process p2 = new ProcessBuilder(Utils.sh("java -version")).start();
			br = new BufferedReader(new InputStreamReader(p2.getErrorStream()));

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			br.close();
			p2.waitFor();

		} catch (IOException e) {
			// Error de entrada/salida: no se pudo leer la salida del proceso
			System.err.println("Error de E/S: " + e.getMessage());
		} catch (InterruptedException e) {
			// Otro hilo interrumpió la espera del proceso
			System.err.println("El proceso fue interrumpido");
		}
	}

}
