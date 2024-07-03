package model.dao;

import model.Livro;
import model.Localizacao;

public class DaoLocalizacao {

	final public static int TAMANHO = 10;
	final public static int CRESCIMENTO = 2;
	private static int numObjeto = 0;
	private static Localizacao[] lista = new Localizacao[TAMANHO];

	public boolean adicionar(Localizacao novo) {
		if (DaoLocalizacao.numObjeto == TAMANHO) {
			return false;
		}

		if (DaoLocalizacao.numObjeto == DaoLocalizacao.lista.length) {
			Localizacao[] lista2 = new Localizacao[DaoLocalizacao.lista.length + CRESCIMENTO];
			for (int i = 0; i < DaoLocalizacao.numObjeto; i++) {
				lista2[i] = DaoLocalizacao.lista[i];
			}
			DaoLocalizacao.lista = lista2;

		}

		DaoLocalizacao.lista[DaoLocalizacao.numObjeto] = novo;
		DaoLocalizacao.numObjeto++;
		Serializador.salvarObjetos();
		return true;

	}
	
	public boolean remover(Localizacao l) {
		for(int i = 0; i < DaoLocalizacao.numObjeto; i++) {
			if(DaoLocalizacao.lista[i] == l) {
				for(int j = i; j < DaoLocalizacao.numObjeto - 1; j++) {
					DaoLocalizacao.lista[j] = DaoLocalizacao.lista[j + 1];
				}
				DaoLocalizacao.lista[DaoLocalizacao.numObjeto - 1] = null;
				DaoLocalizacao.numObjeto--;
				Serializador.salvarObjetos();
				return true;
			}
		}
		return false;
	}

	public Localizacao obter(int indice) {
		if (indice < 0 || indice >= DaoLocalizacao.numObjeto)
			return null;


		return DaoLocalizacao.lista[indice];
	}

	public int qtdObjeto() {
		return DaoLocalizacao.numObjeto;
	}

	public Localizacao[] obterLista() {
			Localizacao[] copia = new Localizacao[DaoLocalizacao.numObjeto];
			System.arraycopy(DaoLocalizacao.lista, 0, copia, 0, DaoLocalizacao.numObjeto);
			return copia;
		

	}
	
	
	public void adicionarTodos(Localizacao[] copia) {
		for(int i = 0; i < copia.length; i++) {
			this.adicionar(copia[i]);
		}
	}

}
