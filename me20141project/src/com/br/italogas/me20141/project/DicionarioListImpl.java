package com.br.italogas.me20141.project;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DicionarioListImpl implements Dicionario {

	private List<Associacao<String, String>> dic;

	/**
	 * Implementação de dicionario com lista.
	 */
	public DicionarioListImpl(){
		this.dic = new ArrayList<Associacao<String, String>>();
	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141.project.Dicionario#inserir(java.lang.String)
	 */
	@Override
	public void inserir(String chave) throws Exception {
		// TODO Auto-generated method stub
		if(chave == null || chave == "")
			throw new IllegalArgumentException("Chave invalida. ");
		
		if(contemChave(chave))
			throw new IllegalArgumentException("Chave existente. ");
		
		dic.add(new Associacao<String, String>(chave.toUpperCase(), ""));
	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141.project.Dicionario#remover(java.lang.String)
	 */
	@Override
	public void remover(String chave){
		//not implemented
		return;
	}
	
	/* (non-Javadoc)
	 * @see com.br.italogas.me20141.project.Dicionario#contemChave(java.lang.String)
	 */
	@Override
	public boolean contemChave(String chave) {
		// TODO Auto-generated method stub
		if(chave == null || chave == "")
			throw new IllegalArgumentException("Chave invalida. ");
		
		Iterator<Associacao<String, String>> iterator = dic.iterator();
		while(iterator.hasNext()){
			if(iterator.next().getKey().equals(chave))
				return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141.project.Dicionario#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return dic.size();
	}

	/* (non-Javadoc)
	 * @see com.br.italogas.me20141.project.Dicionario#isVazio()
	 */
	@Override
	public boolean isVazio() {
		// TODO Auto-generated method stub
		return (dic.isEmpty()) ? true : false; 
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dic == null) ? 0 : dic.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DicionarioListImpl other = (DicionarioListImpl) obj;
		if (dic == null) {
			if (other.dic != null)
				return false;
		} else if (!dic.equals(other.dic))
			return false;
		return true;
	}

}
