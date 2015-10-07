package primitivewritechar;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Primitivewritechar {

	DataInputStream dis;
	DataOutputStream dos;
	String ruta = "C:\\Users\\2homo2care\\Desktop\\texto4.txt";
	char[] frase;
	int tama�oLinea;
	File file = new File(ruta);

	public void escritura(String str, int veces) {
		try {
			if (!file.exists())
				file.createNewFile();

			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(ruta)));
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(ruta)));
			int i = 0;
			while (i != veces) {
				tama�oLinea = str.length();
				dos.writeChars(str);
				dos.flush();
				int tama�o = dis.available();

				frase = new char[str.length()];
				int count = 0;
				while (dis.available() > 0) {
					frase[count] = dis.readChar();
					count++;
				}
				System.out.println("writeChars ha escrito: " + String.copyValueOf(frase));
				System.out.println("writeChars ha escrito: " + tama�o);
				i++;
			}

			System.out.println("writeChars ha escrito en total " + dos.size() + " bytes.");
			System.out.println(tama�oLinea);
			

		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				dis.close();
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void lectura() {

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(ruta)));
			dis = new DataInputStream(new BufferedInputStream(new FileInputStream(ruta)));

			int i = 0;
			frase = new char[tama�oLinea];
			while (i < tama�oLinea) {
				frase[i] = dis.readChar();
				i++;
			}
			
			System.out.println("\nLeemos la primera frase: " + String.copyValueOf(frase));
			System.out.println("Tama�o de bytes leidos: " + frase.length);
			System.out.println("Tama�o por leer: " + dis.available());
			
			i = 0;
			frase = new char[tama�oLinea];
			while (i < tama�oLinea) {
				frase[i] = dis.readChar();
				i++;
			}

			System.out.println("Leemos la segunda l�nea: " + String.copyValueOf(frase));
			System.out.println("Tama�o de bytes: " + frase.length);
			System.out.println("Por leer: " + dis.available() + " bytes.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Primitivewritechar obj = new Primitivewritechar();
		obj.escritura("Esto es una cadena", 2);
		obj.lectura();
	}

}
