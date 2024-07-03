package model;

import java.io.Serializable;

public class Periodico extends Obra implements Serializable{

	private int numero;
	private String subTitulo;
	private int numArtigo;

	public Periodico(String t, int a, int m, Localizacao l, int n, String sb, int na) throws ModelException {
		super(t, a, m, l);
		this.setNumero(n);
		this.setSubTitulo(sb);
		this.setNumeroArtigo(na);

	}

	public int getNumeroArtigo() {
		return this.numArtigo;
	}

	public String getSubTitulo() {
		return this.subTitulo;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumeroArtigo(int na) throws ModelException {
		validarNumeroArtigo(na);
		this.numArtigo = na;
	}

	public void setSubTitulo(String sb) throws ModelException {
		validarSubTitulo(sb);
		this.subTitulo = sb;
	}

	public void setNumero(int n) throws ModelException {
		validarNumero(n);
		this.numero = n;
	}

	public static void validarNumeroArtigo(int na) throws ModelException {
		if (na < 1 || na > 10)
			throw new ModelException("o numero de artigo deve ser de 1 a 10");
	}

	public static void validarSubTitulo(String sb) throws ModelException {
		if (sb == null)
			throw new ModelException("o sub-titulo deve ser preenchido");

		int tamanho = sb.length();

		if (tamanho < 1 || tamanho > 50)
			throw new ModelException("o sub-titulo deve conter até 50 caracteres");

		for (int i = 0; i < tamanho; i++) {
			char c = sb.charAt(i);

			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c) && !Character.isDigit(c) && c != ':'
					&& c != '-')
				throw new ModelException("Caracter de sub-titulo invalido: " + c);

		}
	}

	public static void validarNumero(int n) throws ModelException {
		if (n < 1)
			throw new ModelException("o nunmero do periodico deve ser positvo");

	}

	public String toString() {
		return "Titulo: " + this.getTitulo() + ", " + "Ano de publicação: " + this.getAnoPublicacao() + ", "
				+ "Mês de publicação: " + this.getMesPublicacao() + ", " + "Localização: " + this.getLocalizacao()
				+ ", " + "Numero: " + this.getNumero() + ", " + "SubTitulo: " + this.getSubTitulo() + ", "
				+ "Numero de Artigo: " + this.getNumeroArtigo();
	}

}
