package model.dao;

import model.Livro;

public class DaoLivro {

	final public static int TAMANHO = 10;
	final public static int CRESCIMENTO = 2;
	private static int numObjeto = 0;
	private static Livro[] lista = new Livro[TAMANHO];

	public boolean adicionar(Livro novo) {
		if (DaoLivro.numObjeto == TAMANHO) {
			return false;
		}

		if (DaoLivro.numObjeto == DaoLivro.lista.length) {
			Livro[] lista2 = new Livro[DaoLivro.lista.length + CRESCIMENTO];
			for (int i = 0; i < DaoLivro.numObjeto; i++) {
				lista2[i] = DaoLivro.lista[i];
			}
			DaoLivro.lista = lista2;

		}

		DaoLivro.lista[DaoLivro.numObjeto] = novo;
		DaoLivro.numObjeto++;
		Serializador.salvarObjetos();
		return true;

	}
	
	public boolean remover(Livro l) {
		for(int i = 0; i < DaoLivro.numObjeto; i++) {
			if(DaoLivro.lista[i] == l) {
				for(int j = i; j < DaoLivro.numObjeto - 1; j++) {
					DaoLivro.lista[j] = DaoLivro.lista[j + 1];
				}
				DaoLivro.lista[DaoLivro.numObjeto - 1] = null;
				DaoLivro.numObjeto--;
				Serializador.salvarObjetos();
				return true;
			}
		}
		return false;
	}

	public Livro obter(int indice) {
		if (indice < 0 || indice >= DaoLivro.numObjeto)
			return null;


		return DaoLivro.lista[indice];
	}

	public int qtdObjeto() {
		return DaoLivro.numObjeto;
	}

	public Livro[] obterLista() {
			Livro[] copia = new Livro[DaoLivro.numObjeto];
			System.arraycopy(DaoLivro.lista, 0, copia, 0, DaoLivro.numObjeto);
			return copia;
		

	}
	
	public void adicionarTodos(Livro[] copia) {
		for(int i = 0; i < copia.length; i++) {
			this.adicionar(copia[i]);
		}
	}

}
