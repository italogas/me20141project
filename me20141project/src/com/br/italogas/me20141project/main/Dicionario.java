package com.br.italogas.me20141project.main;

public interface Dicionario<K, V> {

	/**
	 * Insere nova associação no dicionario.
	 * @param chave
	 * @throws Exception
	 */
	public void inserir(K chave, V value) throws Exception;

	/**
	 * Remove associacao existente do dicionario.
	 * @param chave
	 */
	public void remover(K chave);

	/**
	 * Verifica se chave fornecida existe.
	 * @param chave
	 * @return true se o dicionario contem a chave forncida.
	 */
	public boolean contemChave(K chave);
	
	/**
	 * Verifica se valor fornecido existe.
	 * @param valor
	 * @return
	 */
	public boolean contemValor(V chave);

	/**
	 * Retorna tamanho do dicionario.
	 * @return tamanho do dicionario.
	 */
	public int size();

	/**
	 * Verifica se o dicionario esta vazio.
	 * @return true se o dicionario esta vazio.
	 */
	public boolean isVazio();

}