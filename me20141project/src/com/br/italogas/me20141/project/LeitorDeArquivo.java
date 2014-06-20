package com.br.italogas.me20141.project;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

	public DicionarioListImpl lerArquivo(){
		DicionarioListImpl dic = new DicionarioListImpl();
		while(sc.hasNext()){
			String s = sc.next();
			System.out.println(s);
			try {
				dic.inserir(s);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dic;
	}

}
