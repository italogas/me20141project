package com.br.italogas.me20141project.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GeradorDeChaves {
	
	static String[] letrasMaiusculas = {"A", "B", "C", "D","E", "F", "G", "H", "I", "J", "K",
			"L", "M",  "N", "O", "P", "Q", "R", "S", "T", "U", "V", "X", "Z"};


    static String[] letrasMinusculas = {"a", "b", "c", "d","e", "f", "g", "h", "i", "j", "k",
			"l", "m",  "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "z"};
    
    static int TAMANHO_PALAVRA = 10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int tamanho1 = 1000;
		int tamanho2 = 10000;
		int tamanho3 = 50000;
		
		int tamanhoConsulta1 = 500;
		int tamanhoConsulta2 = 5000;
		int tamanhoConsulta3 = 25000;
		
		String arquivo1 = "arquivo1.txt";
		String arquivo2 = "arquivo2.txt";
		String arquivo3 = "arquivo3.txt";
		
		String arquivoConsulta1 = "arquivoConsulta1.txt";
		String arquivoConsulta2 = "arquivoConsulta2.txt";
		String arquivoConsulta3 = "arquivoConsulta3.txt";

		System.out.println("Arquivo1 e arquivoDeconsulta1: \n");
		gerarChaves(tamanho1, arquivo1);
		gerarChaves(tamanhoConsulta1, arquivoConsulta1);
		
		System.out.println("Arquivo2 e arquivoDeconsulta2: \n");
		gerarChaves(tamanho2, arquivo2);
		gerarChaves(tamanhoConsulta2, arquivoConsulta2);
		
		System.out.println("Arquivo3 e arquivoDeconsulta3: \n");
		gerarChaves(tamanho3, arquivo3);
		gerarChaves(tamanhoConsulta3, arquivoConsulta3);

	}

	private static void gerarChaves(int tamanho, String arquivo) {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		PrintWriter pw = null;
		try {
			 fw = new FileWriter(new File(arquivo));
			 pw = new PrintWriter(fw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random r = new Random();
		for(int i = 0; i < tamanho; i++){
			String s = "";
			int n = r.nextInt(TAMANHO_PALAVRA);
			//memory heap, it needs a better way
			for(int k = 0; k < n; k++){
				Random r1 = new Random();
				int indice = r1.nextInt(letrasMaiusculas.length);
				String letra = letrasMinusculas[indice];
				s = s + letra;
			}
			
			pw.println(s);

		}
		
		try {
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
