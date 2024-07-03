package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Livro;
import model.Localizacao;
import model.Periodico;

public class Serializador {


	public static void salvarObjetos() {
		try {
			FileOutputStream fos = new FileOutputStream("objetos.data"); // definir onde vamos salvar nossos objetos
			ObjectOutputStream oos = new ObjectOutputStream(fos); // le os objetos e grava no arquivo
			
			Livro[] listaLivros = new DaoLivro().obterLista();
			oos.writeObject(listaLivros);// pega os objetos e grava no arquivo indicado
			
			
			Periodico[] listaPeriodicos = new DaoPeriodico().obterLista();
			oos.writeObject(listaPeriodicos);
			
			
			Localizacao[] listaLocalizacoes = new DaoLocalizacao().obterLista();
			oos.writeObject(listaLocalizacoes);
			
			oos.close();
			
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void recuperarObjetos() {
		try {
			FileInputStream fis = new FileInputStream("objetos.data"); // qual arquivo vamos ler
			ObjectInputStream ois = new ObjectInputStream(fis); // a maneirq como vamos ler os objetos
			
			Livro[] listaLivros = (Livro[])ois.readObject();
			Periodico[] listaPeriodico = (Periodico[])ois.readObject();
			Localizacao[] listaLocalizacao = (Localizacao[])ois.readObject();
			
			new DaoLivro().adicionarTodos(listaLivros);
			new DaoPeriodico().adicionarTodos(listaPeriodico);
			new DaoLocalizacao().adicionarTodos(listaLocalizacao);
			
			ois.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

		
}
