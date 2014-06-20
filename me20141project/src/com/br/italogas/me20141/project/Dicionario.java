package com.br.italogas.me20141.project;

public interface Dicionario {

	/**
	 * Insere nova associação no dicionario.
	 * @param chave
	 * @throws Exception
	 */
	public abstract void inserir(String chave) throws Exception;

	/**
	 * Remove associacao existente do dicionario.
	 * @param chave
	 */
	public abstract void remover(String chave);

	/**
	 * Verifica se chave fornecida existe.
	 * @param chave
	 * @return true se o dicionario contem a chave forncida.
	 */
	public abstract boolean contemChave(String chave);

	/**
	 * Retorna tamanho do dicionario.
	 * @return tamanho do dicionario.
	 */
	public abstract int size();

	/**
	 * Verifica se o dicionario esta vazio.
	 * @return true se o dicionario esta vazio.
	 */
	public abstract boolean isVazio();

}