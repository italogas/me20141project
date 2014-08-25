/**
 * 
 */
package com.br.italogas.me20141project.main;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author Ítalo
 *
 */
public class DicionarioSkipListImpl implements Dicionario {
	
	ConcurrentSkipListMap<String, String> dic;
	
	public DicionarioSkipListImpl(){
		dic = new ConcurrentSkipListMap<>();
	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141project.main.Dicionario#inserir(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inserir(String chave, String value) throws Exception {
		// TODO Auto-generated method stub
		if(contemChave(chave))
			throw new IllegalArgumentException("Chave existente. ");
		
		dic.put(chave, value);

	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141project.main.Dicionario#remover(java.lang.Object)
	 */
	@Override
	public void remover(String chave) {
		// TODO Auto-generated method stub
		//not implemented yet

	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141project.main.Dicionario#contemChave(java.lang.Object)
	 */
	@Override
	public boolean contemChave(String chave) {
		// TODO Auto-generated method stub
		//not implemented yet
		if(chave == null || chave == "")
			throw new IllegalArgumentException("Chave invalida. ");
		
		return (dic.containsKey(chave)) ? true : false;
	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141project.main.Dicionario#contemValor(java.lang.Object)
	 */
	@Override
	public boolean contemValor(String chave) {
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
