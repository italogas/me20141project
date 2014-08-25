package com.br.italogas.me20141project.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeradorDeDicionario {
	
	static int TAMANHO1 = 10000;
	static int TAMANHO2 = 100000;
	static int TAMANHO3 = 1000000;
	
	static String ARQUIVO1 = "arquivo1.txt";
	static String ARQUIVO2 = "arquivo2.txt";
	static String ARQUIVO3 = "arquivo3.txt";
	
	static int TAMANHO_PALAVRA = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] letrasMaiusculas = {"A", "B", "C", "D","E", "F", "G", "H", "I", "J", "K",
						"L", "M",  "N", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "Z"};
		

		String[] letrasMinusculas = {"a", "b", "c", "d","e", "f", "g", "h", "i", "j", "k",
						"l", "m",  "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "z"};
		
		FileWriter fw = null;
		try {
			 fw = new FileWriter(new File(ARQUIVO1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random r = new Random();
		String s = "";
		for(int i = 0; i < TAMANHO1; i++){
			int n = r.nextInt(TAMANHO_PALAVRA);
			//memory heap, it needs a better way
			for(int k = 0; k < n; k++){
				for(int j = 0; j < letrasMaiusculas.length; j++){
					s = s + letrasMaiusculas[k];
				}
				
				try {
					fw.write(s);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
