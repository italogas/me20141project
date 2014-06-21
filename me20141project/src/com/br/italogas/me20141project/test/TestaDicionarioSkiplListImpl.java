package com.br.italogas.me20141project.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.br.italogas.me20141project.main.DicionarioSkipListImpl;

public class TestaDicionarioSkiplListImpl {

private DicionarioSkipListImpl<String, String> dic;
	
	@Before
	public void setUp() throws Exception {
		dic = new DicionarioSkipListImpl<String, String>();
		dic.inserir("ABACO", "");
		dic.inserir("ABC", "");
		dic.inserir("JEBAS", "");
	}

	@Test
	public void testaInicializacao(){
		DicionarioSkipListImpl<String, String> dic2 = new DicionarioSkipListImpl<String, String>();
		assertEquals(0, dic2.size());
	}
	
	@Test
	public void testaInsercao(){
		String token = "HOLANDA";
		try {
			dic.inserir(token, "");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertTrue(dic.contemChave(token));
		try {
			dic.inserir(token, "");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			assertEquals("Mensagem invalida. ", "Chave existente. ", e1.getMessage());
		}
		try{
			dic.inserir("", "");
		} catch (Exception e){
			assertEquals("Mensagem invalida. ", "Chave invalida. ", e.getMessage());
		}
		try{
			dic.inserir(null, "");
		} catch (Exception e){
			assertEquals("Mensagem invalida. ", "Chave invalida. ", e.getMessage());
		}
	}
	
	@Test
	public void testaConsulta(){
		String token = "ABACO";
		String tokenInexistente = "BLEH";
		String tokenInvalido = "**";
		assertTrue(dic.contemChave(token));
		assertFalse(dic.contemChave(tokenInexistente));
		try{
			dic.contemChave(tokenInvalido);
		} catch (Exception e){
			assertEquals("Mensagem invalida. ", "Chave invalida. ", e.getMessage());
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testaContemChave0(){
		dic.contemChave(null);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testaContemChave1(){
		dic.contemChave("");
	}


}
