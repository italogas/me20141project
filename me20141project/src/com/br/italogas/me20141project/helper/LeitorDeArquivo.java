package com.br.italogas.me20141project.helper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorDeArquivo {
	
	private String file;
	private Scanner sc; 
	
	public LeitorDeArquivo(String file){
		this.file = file;
	}
	
	public void abrirArquivo() throws FileNotFoundException {
		sc = new Scanner(new FileReader(file));
	}
	
	public void fecharArquivo() throws IOException{
		if(sc != null){
			sc.close();
			return;
		}	
		throw new IOException();
	}

	public List<String> lerArquivo(){
		List<String> listaDeTokens = new ArrayList<String>();
		while(sc.hasNext()){
			String s = sc.next();
			System.out.println(s);
			try {
				listaDeTokens.add(s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listaDeTokens;
	}

}
