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
	
	//public static final String ARQUIVO_FONTE = "listaPalavrasPT.txt";
	
	//public static final String ARQUIVO_CONSULTAS = "consultasEN.txt";

	public static void main(String[] args) throws Exception {
		
		Dicionario dicionario = null;
		String arquivoFonte = null;
		String arquivoConsultas = null;
		
		if(args[0].equals("list")){
			dicionario = new DicionarioListImpl();
		} else if (args[0].equals("hashTable")){
			dicionario = new DicionarioHashTableImpl();
		} else if (args[0].equals("skiplist")){
			dicionario = new DicionarioSkipListImpl();
		} else {
			System.out.println("Estrutura invalida");
			throw new Exception("Estrutura invalida");
		}
		
		if(args[1] == "" || args[1] == null){
			System.out.println("Arquivo fonte invalido");
			throw new Exception("Arquivo fonte invalido");
		} else {
			arquivoFonte = args[1];
		}
		
		if(args[2] == "" || args[2] == null){
			System.out.println("Arquivo de consultas invalido");
			throw new Exception("Arquivo de consultas invalido");
		} else {
			arquivoConsultas = args[2];
			
		}
		
		
		
		/*DicionarioListImpl dicionarioLista = new DicionarioListImpl();
		DicionarioSkipListImpl dicionarioSkipList = new DicionarioSkipListImpl();
		DicionarioBSTImpl dicionarioBst = new DicionarioBSTImpl(); */
		
		LeitorDeArquivo fileHelper1 = new LeitorDeArquivo(arquivoFonte);
		LeitorDeArquivo fileHelper2 = new LeitorDeArquivo(arquivoConsultas);
		
		try {
			fileHelper1.abrirArquivo();
			fileHelper2.abrirArquivo();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//get token list from file
		List<String> listaDeTokens = fileHelper1.lerArquivo();
		System.out.println("\n");
		
		//get token list from file
		List<String> listaConsulta = fileHelper2.lerArquivo();
		System.out.println("\n");
		
		long memoriaLivreInicial = Runtime.getRuntime().freeMemory();
		
		float tempoCargaLista = (float) inserirPalavrasNoDicionario(listaDeTokens, dicionario) / 1000;
		//float tempoCargaLista = inserirPalavrasNoDicionario(listaDeTokens, dicionario) / 10000;
		
		/*
		long memoriaCargaLista = memoriaLivreFinal - memoriaLivreInicial;
		
		long tempoCargaSkipList = inserirPalavrasNoDicionario(listaDeTokens, dicionarioSkipList);
		
		long tempoCargaBST = inserirPalavrasNoDicionario(listaDeTokens, dicionarioBst);
		*/
		
		//long tempoConsulta = consultarPalavrasNoDicionario(listaConsulta, dicionario) / 1000;
		float tempoConsulta = (float) consultarPalavrasNoDicionario(listaConsulta, dicionario) / 1000;
		//float tempoConsulta = consultarPalavrasNoDicionario(listaConsulta, dicionario) / 10000;
		
		long memoriaLivreFinal = Runtime.getRuntime().freeMemory();
		
		System.out.println("\n(...)\n");
		
		//long memoria = (memoriaLivreFinal - memoriaLivreInicial) / 1000000;
		float memoria = (float) (memoriaLivreInicial - memoriaLivreFinal) / 1000000;
		System.out.printf("Tempo de carga: %f s. \n", tempoCargaLista);
		System.out.printf("Tempo de consulta: %f s. \n", tempoConsulta);
		System.out.printf("Consumo de memoria: %f MB (de acordo com o SI). \n", memoria);
		
		try {
			fileHelper1.fecharArquivo();
			fileHelper2.fecharArquivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static long consultarPalavrasNoDicionario(
			List<String> listaConsulta, Dicionario dicionario) {
		// TODO Auto-generated method stub
		long tempoInicialConsulta = System.currentTimeMillis();
		for(String s : listaConsulta){
			if(dicionario.contemChave(s.toUpperCase())){
				System.out.printf("%s: S\n", s);
			} else {
				System.out.printf("%s: N\n", s);
			}
		}
		long tempoFinalConsulta = System.currentTimeMillis();
		return tempoFinalConsulta - tempoInicialConsulta;
		
	}

	private static long inserirPalavrasNoDicionario(List<String> listaDeTokens, Dicionario dicionario) {
		// TODO Auto-generated method stub
		//preenche dicionario com dados do arquivo fonte
		long tempoInicialCarga = System.currentTimeMillis();
		for(String s : listaDeTokens){
			try {
				dicionario.inserir(s.toUpperCase(), "");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// chaves exixtentes ou invalidas, n mostra excessao na saida
				//e.printStackTrace();
			}
		}
		long tempoFinalCarga = System.currentTimeMillis();
				
		return tempoFinalCarga - tempoInicialCarga;
	}

}
