package com.br.italogas.me20141project.main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.br.italogas.me20141project.bst.adt.bst.BSTImpl;

public class DicionarioBSTImplTest {
	
	BSTImpl<Associacao<String, String>> bst;
	DicionarioBSTImpl dic;

	@Before
	public void setUp() throws Exception {
		bst = new BSTImpl<Associacao<String, String>>();
		dic = new DicionarioBSTImpl();
		bst.insert(new Associacao<String, String>("CASA", "valor de CASA"));
		bst.insert(new Associacao<String, String>("CARRO", "valor de CARRO"));
		bst.insert(new Associacao<String, String>("LIVRO", ""));
		dic.inserir("LIVRO", "");
	}

	@Test
	public void test() {
		System.out.println(bst.search(new Associacao<String, String>("CASA", "valor de CASA")).getData().getKey());
		System.out.println(bst.search(new Associacao<String, String>("LIVRO", "")).getData().getKey());
	}
	
	@Test (expected= NullPointerException.class)
	public void test1() {
		System.out.println(bst.search(new Associacao<String, String>("CASA", "")).getData().getKey());
		
	}
	
	@Test
	public void test3() {
		assertTrue(dic.contemChave("LIVRO"));
	}

}
