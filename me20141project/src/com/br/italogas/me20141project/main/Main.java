package com.br.italogas.me20141project.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.br.italogas.me20141project.helper.LeitorDeArquivo;

/**
 * Main
 * @author Ítalo
 *
 */
public class Main {
	
//	public static final String ARQUIVO_FONTE = "arquivoTeste.txt";
//	public static final String ARQUIVO_CONSULTAS = "consultasArquivoTeste.txt";
	public static final String ARQUIVO_FONTE = "listaPalavrasPT.txt";
	public static final String ARQUIVO_CONSULTAS = "consultasEN.txt";

	public static void main(String[] args) {
		DicionarioListImpl<String, String> dicionario = new DicionarioListImpl<String, String>();
		LeitorDeArquivo fileHelper1 = new LeitorDeArquivo(ARQUIVO_FONTE);
		LeitorDeArquivo fileHelper2 = new LeitorDeArquivo(ARQUIVO_CONSULTAS);
		
		try {
			fileHelper1.abrirArquivo();
			fileHelper2.abrirArquivo();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Execuntado leitura de arquivo fonte: \n");
		//lista de tokens obtida na leitura de arquivo
		List<String> listaDeTokens = fileHelper1.lerArquivo();
		System.out.println("\n");
		//preenche dicionario com dados do arquivo fonte
		for(String s : listaDeTokens){
			try {
				dicionario.inserir(s.toUpperCase(), "");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Execuntado leitura de arquivo com consultas: \n");
		//lista de tokens pra consultar no dicionario
		List<String> listaConsulta = fileHelper2.lerArquivo();
		System.out.println("\n");
		for(String s : listaConsulta){
			if(dicionario.contemChave(s.toUpperCase())){
				System.out.printf("Dicionario contem: %s\n", s);
			} else {
				System.out.printf("Dicionario nao contem: %s\n", s);
			}
		}
		
		try {
			fileHelper1.fecharArquivo();
			fileHelper2.fecharArquivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
