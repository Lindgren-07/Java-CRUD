package model.dao;

import model.Livro;
import model.Periodico;

public class DaoPeriodico {

	final public static int TAMANHO = 10;
	final public static int CRESCIMENTO = 2;
	private static int numObjeto = 0;
	private static Periodico[] lista = new Periodico[TAMANHO];

	public boolean adicionar(Periodico novo) {
		if (DaoPeriodico.numObjeto == TAMANHO) {
			return false;
		}

		if (DaoPeriodico.numObjeto == DaoPeriodico.lista.length) {
			Periodico[] lista2 = new Periodico[DaoPeriodico.lista.length + CRESCIMENTO];
			for (int i = 0; i < DaoPeriodico.numObjeto; i++) {
				lista2[i] = DaoPeriodico.lista[i];
			}
			DaoPeriodico.lista = lista2;

		}

		DaoPeriodico.lista[DaoPeriodico.numObjeto] = novo;
		DaoPeriodico.numObjeto++;
		Serializador.salvarObjetos();
		return true;

	}
	
	public boolean remover(Periodico l) {
		for(int i = 0; i < DaoPeriodico.numObjeto; i++) {
			if(DaoPeriodico.lista[i] == l) {
				for(int j = i; j < DaoPeriodico.numObjeto - 1; j++) {
					DaoPeriodico.lista[j] = DaoPeriodico.lista[j + 1];
				}
				DaoPeriodico.lista[DaoPeriodico.numObjeto - 1] = null;
				DaoPeriodico.numObjeto--;
				Serializador.salvarObjetos();
				return true;
			}
		}
		return false;
	}

	public Periodico obter(int indice) {
		if (indice < 0 || indice >= DaoPeriodico.numObjeto)
			return null;


		return DaoPeriodico.lista[indice];
	}

	public int qtdObjeto() {
		return DaoPeriodico.numObjeto;
	}

	public Periodico[] obterLista() {
			Periodico[] copia = new Periodico[DaoPeriodico.numObjeto];
			System.arraycopy(DaoPeriodico.lista, 0, copia, 0, DaoPeriodico.numObjeto);
			return copia;
		

	}
	
	public void adicionarTodos(Periodico[] copia) {
		for(int i = 0; i < copia.length; i++) {
			this.adicionar(copia[i]);
		}
	}

}
