package com.br.italogas.me20141project.skiplist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SkipListImplTest {
	
	SkipListImpl<Integer> skipList;

	@Before
	public void setUp() throws Exception {
		skipList = new SkipListImpl<Integer>(5);
	}

	@Test
	public void testInitialList() {
		assertEquals(5, skipList.root.height);
		assertEquals(5, skipList.NIL.height);
		for(int i = 0; i < skipList.level; i++){
			assertEquals(skipList.NIL, skipList.root.forward[i]);
		}
		assertArrayEquals(new SkipNode[]{skipList.root, skipList.NIL}, skipList.toArray());
	}
	
	@Test
	public void testInsert() {
		skipList.insert(10, new Integer(10));
		skipList.insert(13, new Integer(13));
		skipList.insert(15, new Integer(15));
		assertEquals(10, skipList.root.forward[0].key);
		assertEquals(13, skipList.root.forward[0].forward[0].key);
		assertEquals(15, skipList.root.forward[0].forward[0].forward[0].key);
	}
	
	@Test
	public void testInsert2() {
		int infinito = Integer.MAX_VALUE; 
		skipList.insert(10, new Integer(10), 1);
		skipList.insert(13, new Integer(13), 5);
		skipList.insert(15, new Integer(15), 3);
		
		assertEquals(5, skipList.root.forward.length);
		assertEquals(10, skipList.root.forward[0].key);
		assertEquals(13, skipList.root.forward[1].key);
		assertEquals(13, skipList.root.forward[2].key);
		assertEquals(13, skipList.root.forward[3].key);
		assertEquals(13, skipList.root.forward[4].key);
		
		assertEquals(1, skipList.root.forward[0].forward.length);
		assertEquals(13, skipList.root.forward[0].forward[0].key);

		assertEquals(5, skipList.root.forward[0].forward[0].forward.length);
		assertEquals(15, skipList.root.forward[0].forward[0].forward[0].key);
		assertEquals(15, skipList.root.forward[0].forward[0].forward[1].key);
		assertEquals(15, skipList.root.forward[0].forward[0].forward[2].key);
		assertEquals(infinito, skipList.root.forward[0].forward[0].forward[3].key);
		assertEquals(infinito, skipList.root.forward[0].forward[0].forward[4].key);
		
		assertEquals(3, skipList.root.forward[0].forward[0].forward[0].forward.length);
		assertEquals(infinito, skipList.root.forward[0].forward[0].forward[0].forward[0].key);
		assertEquals(infinito, skipList.root.forward[0].forward[0].forward[0].forward[1].key);
		assertEquals(infinito, skipList.root.forward[0].forward[0].forward[0].forward[2].key);
		
		assertEquals(5, skipList.root.forward[0].forward[0].forward[0].forward[0].forward.length);
	}

	@Test
	public void testInsert3() {
		skipList.insert(10, new Integer(10));
		skipList.insert(13, new Integer(13));
		skipList.insert(15, new Integer(15));
		assertEquals(10, skipList.root.forward[0].key);
		assertEquals(13, skipList.root.forward[0].forward[0].key);
		assertEquals(15, skipList.root.forward[0].forward[0].forward[0].key);
		
		Integer newValue = new Integer(23); 
		skipList.insert(13, newValue);
		assertEquals(newValue, skipList.root.forward[0].forward[0].satteliteData);
	}
	
	@Test
	public void testRemove(){
		int infinito = Integer.MAX_VALUE; 
		skipList.insert(10, new Integer(10), 1);
		skipList.insert(13, new Integer(13), 5);
		skipList.insert(15, new Integer(15), 3);
		
		skipList.remove(13);
		
		assertEquals(3, skipList.height());
		
		assertEquals(5, skipList.root.forward.length);
		assertEquals(10, skipList.root.forward[0].key);
		assertEquals(15, skipList.root.forward[1].key);
		assertEquals(15, skipList.root.forward[2].key);
		assertEquals(infinito, skipList.root.forward[3].key);
		assertEquals(infinito, skipList.root.forward[4].key);
		
		assertEquals(1, skipList.root.forward[0].forward.length);
		assertEquals(15, skipList.root.forward[0].forward[0].key);
		
		assertEquals(3, skipList.root.forward[0].forward[0].forward.length);
		assertEquals(infinito, skipList.root.forward[0].forward[0].forward[0].key);
		assertEquals(infinito, skipList.root.forward[0].forward[0].forward[1].key);
		assertEquals(infinito, skipList.root.forward[0].forward[0].forward[2].key);
		
		assertEquals(5, skipList.root.forward[0].forward[0].forward[0].forward.length);
	}
	
	@Test
	public void testSearch(){
		skipList.insert(10, new Integer(10));
		skipList.insert(13, new Integer(13));
		skipList.insert(15, new Integer(15));
		assertNotNull(skipList.search(10));
		assertNotNull(skipList.search(13));
		assertNotNull(skipList.search(15));
		
	}
	
	@Test
	public void testSize(){
		skipList.insert(10, new Integer(10));
		assertEquals(1, skipList.size());
		skipList.insert(13, new Integer(13));
		assertEquals(2, skipList.size());
		skipList.insert(15, new Integer(15));
		assertEquals(3, skipList.size());
		
	}
	
	@Test
	public void testToArray(){
		skipList.insert(10, new Integer(10), 1);
		skipList.insert(13, new Integer(13), 5);
		skipList.insert(15, new Integer(15), 3);
		for(SkipNode<Integer> node : skipList.toArray()){
			System.out.println(node.toString());
		}
	}
	
	@Test
	public void testHeight(){
		assertEquals(0, skipList.height());
		skipList.insert(10, new Integer(10), 1);
		assertEquals(1, skipList.height());
		skipList.insert(13, new Integer(13), 5);
		assertEquals(5, skipList.height());
		skipList.insert(15, new Integer(15), 3);
		assertEquals(5, skipList.height());
	}

}
