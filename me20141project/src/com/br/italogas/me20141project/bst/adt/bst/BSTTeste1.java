package com.br.italogas.me20141project.bst.adt.bst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BSTTeste1<T> {
	
	@SuppressWarnings("rawtypes")
	BSTImpl bst;
	Integer element;
	Integer element2;
	Integer element3;
	
	@SuppressWarnings("rawtypes")
	@Before
	public void setUp() throws Exception {
		bst = new BSTImpl();
		element = new Integer(5);
		element2 = new Integer(2);
		element3 = new Integer(6);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void insertTest() {
		assertTrue(bst.isEmpty());
		assertTrue(bst.size() == 0);
		bst.insert(element);
		bst.insert(element2);
		bst.insert(element3);
		assertEquals(element, bst.getRoot().getData());
		assertEquals(element2, bst.getRoot().getLeft().getData());
		assertEquals(element3, bst.getRoot().getRight().getData());
		assertTrue(bst.getRoot().getLeft().getLeft().isEmpty());
		assertTrue(bst.getRoot().getLeft().getRight().isEmpty());
		assertTrue(bst.getRoot().getRight().getLeft().isEmpty());
		assertTrue(bst.getRoot().getRight().getRight().isEmpty());
		assertTrue(bst.size() == 3);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void maximumTest(){
		bst.insert(element);
		bst.insert(element2);
		bst.insert(element3);
		assertEquals(element3, bst.maximum().getData());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void minimumTest(){
		bst.insert(element);
		bst.insert(element2);
		bst.insert(element3);
		assertEquals(element2, bst.minimum().getData());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void searchTest(){
		bst.insert(element);
		bst.insert(element2);
		bst.insert(element3);
		assertEquals(element3, bst.search(new Integer(6)).getData());
		assertEquals(element2, bst.search(new Integer(2)).getData());
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void preOrderTest(){
		bst.insert(new Integer(8));
		bst.insert(new Integer(4));
		bst.insert(new Integer(12));
		bst.insert(new Integer(2));
		bst.insert(new Integer(6));
		bst.insert(new Integer(10));
		bst.insert(new Integer(14));
		bst.insert(new Integer(1));
		bst.insert(new Integer(3));
		bst.insert(new Integer(5));
		bst.insert(new Integer(7));
		bst.insert(new Integer(9));
		bst.insert(new Integer(11));
		bst.insert(new Integer(13));
		bst.insert(new Integer(15));
		T[] array = (T[]) bst.preOrder();
		System.out.println("Em pré ordem: \n");
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i].toString());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void sucessorTest(){
		bst.insert(element);
		bst.insert(element2);
		bst.insert(element3);
		bst.insert(new Integer(4));
		assertEquals(element, bst.sucessor(new Integer(4)).getData());
		assertEquals(element3, bst.sucessor(element).getData());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void predecessorTest(){
		bst.insert(element);
		bst.insert(element2);
		bst.insert(element3);
		bst.insert(new Integer(4));
		assertEquals(element2, bst.predecessor(new Integer(4)).getData());
		assertEquals(element, bst.predecessor(element3).getData());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void heightTest(){
		bst.insert(element);
		bst.insert(element2);
		bst.insert(element3);
		assertTrue(bst.height() == 1);
		bst.insert(new Integer(4));
		assertTrue(bst.height() == 2);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void heightTest2(){
		bst.insert(new Integer(8));
		bst.insert(new Integer(4));
		bst.insert(new Integer(12));
		bst.insert(new Integer(2));
		bst.insert(new Integer(6));
		bst.insert(new Integer(10));
		bst.insert(new Integer(14));
		bst.insert(new Integer(1));
		bst.insert(new Integer(3));
		bst.insert(new Integer(5));
		bst.insert(new Integer(7));
		bst.insert(new Integer(9));
		bst.insert(new Integer(11));
		bst.insert(new Integer(13));
		bst.insert(new Integer(15));
		assertTrue(bst.height() == 3);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void removeTest(){
		bst.insert(element);
		bst.insert(element2);
		bst.insert(element3);
		bst.insert(new Integer(4));
		assertTrue(bst.size() == 4);
		bst.remove(new Integer(4));
		assertTrue(bst.size() == 3);
		assertTrue(bst.getRoot().getLeft().getRight().isEmpty());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void removeTest2(){
		bst.insert(element);
		bst.insert(element2);
		bst.insert(element3);
		bst.insert(new Integer(4));
		assertTrue(bst.size() == 4);
		bst.remove(element2);
		assertTrue(bst.size() == 3);
		assertEquals(new Integer(4), bst.getRoot().getLeft().getData());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void removeTest3(){
		bst.insert(element);
		bst.insert(element2);
		bst.insert(element3);
		bst.insert(new Integer(4));
		assertTrue(bst.size() == 4);
		bst.remove(element);
		assertTrue(bst.size() == 3);
		assertEquals(element3, bst.getRoot().getData());
		assertEquals(element2, bst.getRoot().getLeft().getData());
		assertTrue(bst.getRoot().getRight().isEmpty());
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void orderTest(){
		bst.insert(new Integer(8));
		bst.insert(new Integer(4));
		bst.insert(new Integer(12));
		bst.insert(new Integer(2));
		bst.insert(new Integer(6));
		bst.insert(new Integer(10));
		bst.insert(new Integer(14));
		bst.insert(new Integer(1));
		bst.insert(new Integer(3));
		bst.insert(new Integer(5));
		bst.insert(new Integer(7));
		bst.insert(new Integer(9));
		bst.insert(new Integer(11));
		bst.insert(new Integer(13));
		bst.insert(new Integer(15));
		T[] array = (T[]) bst.order();
		System.out.println("Em ordem: \n");
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i].toString());
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	@Test
	public void postOrderTest(){
		bst.insert(new Integer(8));
		bst.insert(new Integer(4));
		bst.insert(new Integer(12));
		bst.insert(new Integer(2));
		bst.insert(new Integer(6));
		bst.insert(new Integer(10));
		bst.insert(new Integer(14));
		bst.insert(new Integer(1));
		bst.insert(new Integer(3));
		bst.insert(new Integer(5));
		bst.insert(new Integer(7));
		bst.insert(new Integer(9));
		bst.insert(new Integer(11));
		bst.insert(new Integer(13));
		bst.insert(new Integer(15));
		T[] array = (T[]) bst.postOrder();
		System.out.println("Em pós ordem: \n");
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i].toString());
		}
	}
}
