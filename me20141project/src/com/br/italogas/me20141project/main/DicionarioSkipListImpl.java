/**
 * 
 */
package com.br.italogas.me20141project.main;

import com.br.italogas.me20141project.skiplist.SkipListImpl;

/**
 * @author Ítalo
 *
 */
public class DicionarioSkipListImpl<K, V> implements Dicionario<K, V> {
	
	SkipListImpl<Associacao<K, V>> dic;
	
	public DicionarioSkipListImpl(){
		dic = new SkipListImpl<Associacao<K, V>>(Integer.MAX_VALUE);
	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141project.main.Dicionario#inserir(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inserir(K chave, V value) throws Exception {
		// TODO Auto-generated method stub
		if(chave == null || chave == "")
			throw new IllegalArgumentException("Chave invalida. ");
		
		if(contemChave(chave))
			throw new IllegalArgumentException("Chave existente. ");
		
		dic.insert(0, new Associacao<K, V>(chave, value));

	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141project.main.Dicionario#remover(java.lang.Object)
	 */
	@Override
	public void remover(K chave) {
		// TODO Auto-generated method stub
		//not implemented yet

	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141project.main.Dicionario#contemChave(java.lang.Object)
	 */
	@Override
	public boolean contemChave(K chave) {
		// TODO Auto-generated method stub
		//not implemented yet
		return false;
	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141project.main.Dicionario#contemValor(java.lang.Object)
	 */
	@Override
	public boolean contemValor(V chave) {
		// TODO Auto-generated method stub
		//not implemented yet
		return false;
	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141project.main.Dicionario#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		//not implemented yet
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141project.main.Dicionario#isVazio()
	 */
	@Override
	public boolean isVazio() {
		// TODO Auto-generated method stub
		return false;
	}

}
