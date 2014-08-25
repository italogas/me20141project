package com.br.italogas.me20141project.main;

/**
 * It defines services that must be implemented by an concrete class
 * It uses String as Key/Value
 * @author Ítalo
 *
 */
public interface Dicionario {

	/**
	 * Insere nova associação no dicionario.
	 * @param chave
	 * @throws Exception
	 */
	public void inserir(String chave, String value) throws Exception;

	/**
	 * Remove associacao existente do dicionario.
	 * @param chave
	 */
	public void remover(String chave);

	/**
	 * Verifica se chave fornecida existe.
	 * @param chave
	 * @return true se o dicionario contem a chave forncida.
	 */
	public boolean contemChave(String chave);
	
	/**
	 * Verifica se valor fornecido existe.
	 * @param valor
	 * @return
	 */
	public boolean contemValor(String chave);

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