package com.br.italogas.me20141project.test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.br.italogas.me20141project.helper.LeitorDeArquivo;

public class TestaLeitorDeArquivo {
	
	public static final String FILE = "arquivoTeste.txt";
	public static final String INVALID_FILE = "arquivoInvalido.txt";
	List<String> listaDeTokens;
	LeitorDeArquivo lda;
	LeitorDeArquivo l;

	@Before
	public void setUp() throws Exception {
		lda = new LeitorDeArquivo(FILE);
		listaDeTokens = new ArrayList<String>();
		listaDeTokens.add("ABC");
		listaDeTokens.add("ABACO");
		listaDeTokens.add("JEBAS");
	}

	@Test (expected = FileNotFoundException.class)
	public void testAbrirArquivo() throws FileNotFoundException {
		l = new LeitorDeArquivo(INVALID_FILE);
		l.abrirArquivo();
	}
	
	@Test (expected = IOException.class)
	public void testFecharArquivo() throws IOException{
		lda.fecharArquivo();
	}

	@Test
	public void testLerArquivo() {
		try {
			lda.abrirArquivo();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> resultado = lda.lerArquivo();
		assertEquals("Resultado da leitura invalido ", listaDeTokens, resultado);
		try {
			lda.fecharArquivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
