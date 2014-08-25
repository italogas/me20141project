/**
 * 
 */
package com.br.italogas.me20141project.main;

import com.br.italogas.me20141project.bst.adt.bst.BSTImpl;
import com.br.italogas.me20141project.bst.adt.bst.BSTNode;

/**
 * @author Ítalo
 *
 */
public class DicionarioBSTImpl implements Dicionario {
	
	BSTImpl<Associacao<String, String>> dic;
	
	public DicionarioBSTImpl() {
		// TODO Auto-generated constructor stub
		dic = new BSTImpl<Associacao<String, String>>();
	}
	
	@Override
	public void inserir(String chave, String valor) throws Exception {
		// TODO Auto-generated method stub
		if(chave == null || chave == ""){
			throw new IllegalArgumentException("Chave invalida");
		}
		
		if(contemChave(chave)){
			throw new IllegalArgumentException("Chave Existente");
		}
		
		dic.insert(new Associacao<String, String>(chave, valor));
		
	}

	@Override
	public void remover(String chave) {
		// TODO Auto-generated method stub
		//not implemented
	}

	@Override
	public boolean contemChave(String chave) {
		// TODO Auto-generated method stub
		if(chave == null || chave == ""){
			throw new IllegalArgumentException("Chave invalida");
		}
		
		Associacao<String, String> element = new Associacao<String, String>(chave, null);
		BSTNode<Associacao<String, String>> search = dic.search(element);
		if(search != null){
			return true;
		}
		return false;
	}

	@Override
	public boolean contemValor(String chave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return dic.size();
	}

	@Override
	public boolean isVazio() {
		// TODO Auto-generated method stub
		return dic.isEmpty();
	}

}
