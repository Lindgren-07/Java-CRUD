package model;

import java.io.Serializable;

public class Localizacao implements Serializable{

	private int numCorredor;
	private int numEstante;
	private int numPrateleira;

	public Localizacao(int nc, int ne, int np) throws ModelException {
		this.setNumCorredor(nc);
		this.setNumEstante(ne);
		this.setNumPrateleira(np);
	}

	public int getNumPrateleira() {
		return this.numPrateleira;
	}

	public int getNumEstante() {
		return this.numEstante;
	}

	public int getNumCorredor() {
		return this.numCorredor;
	}

	public void setNumPrateleira(int np) throws ModelException {
		validarNumPrateleira(np);
		this.numPrateleira = np;
	}

	public void setNumEstante(int ne) throws ModelException {
		validarNumEstante(ne);
		this.numEstante = ne;
	}

	public void setNumCorredor(int nc) throws ModelException {
		validarNumCorredor(nc);
		this.numCorredor = nc;
	}

	public static void validarNumPrateleira(int np) throws ModelException {
		if (np < 1)
			throw new ModelException("Numero da prateleira deve ser positivo");
	}

	public static void validarNumEstante(int ne) throws ModelException {
		if (ne < 1)
			throw new ModelException("Numero de estantes deve ser positivo");
	}

	public static void validarNumCorredor(int nc) throws ModelException {
		if (nc < 1)
			throw new ModelException("Numero de corredor deve ser positivo");
	}

	public String toString() {
		return "Corredor: " + this.numCorredor + "," + "Estante: " + this.numEstante + "," + "Prateleira: "
				+ this.numPrateleira;
	}

}
