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
	
	public static final String ARQUIVO_FONTE = "listaPalavrasPT.txt";
	
	public static final String ARQUIVO_CONSULTAS = "consultasEN.txt";

	public static void main(String[] args) {
		
		DicionarioListImpl dicionarioLista = new DicionarioListImpl();
		DicionarioSkipListImpl dicionarioSkipList = new DicionarioSkipListImpl();
		DicionarioBSTImpl dicionarioBst = new DicionarioBSTImpl();
		
		LeitorDeArquivo fileHelper1 = new LeitorDeArquivo(ARQUIVO_FONTE);
		LeitorDeArquivo fileHelper2 = new LeitorDeArquivo(ARQUIVO_CONSULTAS);
		
		try {
			fileHelper1.abrirArquivo();
			fileHelper2.abrirArquivo();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//lista de tokens obtida na leitura de arquivo
		List<String> listaDeTokens = fileHelper1.lerArquivo();
		System.out.println("\n");
		
		long memoriaLivreInicial = Runtime.getRuntime().freeMemory(); 
		
		int tempoCargaLista = inserirPalavrasNoDicionario(listaDeTokens, dicionarioLista);
		int tempoCargaSkipList = inserirPalavrasNoDicionario(listaDeTokens, dicionarioSkipList);
		int tempoCargaBST = inserirPalavrasNoDicionario(listaDeTokens, dicionarioBst);
		
		//lista de tokens pra consultar no dicionario
		List<String> listaConsulta = fileHelper2.lerArquivo();
		System.out.println("\n");
		long tempoInicialConsulta = System.currentTimeMillis();
		for(String s : listaConsulta){
			if(dicionarioLista.contemChave(s.toUpperCase())){
				System.out.printf("%s: S\n", s);
			} else {
				System.out.printf("%s: N\n", s);
			}
		}
		long tempoFinalConsulta = System.currentTimeMillis();
		long memoriaLivreFinal = Runtime.getRuntime().freeMemory();
		System.out.println("\n(...)\n");
		
		System.out.printf("Tempo de carga: %d ms. \n", tempoCargaLista);
		System.out.printf("Tempo de consulta: %d ms. \n",
				tempoFinalConsulta - tempoInicialConsulta);
		System.out.printf("Consumo de memoria: %d bytes. \n",
				memoriaLivreInicial - memoriaLivreFinal);
		
		try {
			fileHelper1.fecharArquivo();
			fileHelper2.fecharArquivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static int inserirPalavrasNoDicionario(List<String> listaDeTokens, Dicionario dicionario) {
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
				
		return 0;
	}

}
