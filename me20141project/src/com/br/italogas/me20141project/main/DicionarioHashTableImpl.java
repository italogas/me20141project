package com.br.italogas.me20141project.main;

import java.util.concurrent.ConcurrentHashMap;

public class DicionarioHashTableImpl implements Dicionario {
	
	ConcurrentHashMap<String, String> dic;
	
	public DicionarioHashTableImpl(){
		dic = new ConcurrentHashMap<>();
	}

	@Override
	public void inserir(String chave, String value) throws Exception {
		// TODO Auto-generated method stub
		if(contemChave(chave))
			throw new IllegalArgumentException("Chave existente. ");
		
		dic.put(chave, value);

	}

	@Override
	public void remover(String chave) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contemChave(String chave) {
		// TODO Auto-generated method stub
		if(chave == null || chave == "")
			throw new IllegalArgumentException("Chave invalida. ");
		
		return (dic.containsKey(chave)) ? true : false;
	}

	@Override
	public boolean contemValor(String chave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isVazio() {
		// TODO Auto-generated method stub
		return false;
	}

}
