package model;

import java.io.Serializable;

abstract  public class Obra implements Serializable{

	private String titulo;
	private int anoPublicacao;
	private int mesPublicacao;
	private Localizacao localizacao;

	public Obra(String t, int a, int m, Localizacao l) throws ModelException {
		this.setTitulo(t);
		this.setAnoPublicacao(a);
		this.setMesPublicacao(m);
		this.setLocalizacao(l);
	}

	public Localizacao getLocalizacao() {
		return this.localizacao;
	}

	public int getMesPublicacao() {
		return this.mesPublicacao;
	}

	public int getAnoPublicacao() {
		return this.anoPublicacao;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setLocalizacao(Localizacao l) throws ModelException {
		validarLocalizacao(l);
		this.localizacao = l;
	}

	public void setMesPublicacao(int m) throws ModelException {
		validarMesPublicacao(m);
		this.mesPublicacao = m;
	}

	public void setAnoPublicacao(int a) throws ModelException {
		validarAnoPublicacao(a);
		this.anoPublicacao = a;
	}

	public void setTitulo(String t) throws ModelException {
		validarTitulo(t);
		this.titulo = t;
	}

	public static void validarLocalizacao(Localizacao l) throws ModelException {
		if (l == null)
			throw new ModelException("a localização deve ser selecionada");
	}

	public static void validarMesPublicacao(int m) throws ModelException {
		if (m < 1 || m > 12)
			throw new ModelException("o mes de publicação deve estar entre 1 a 12");
	}

	public static void validarAnoPublicacao(int a) throws ModelException {
		if (a < 1994 || a > 2024) {
			
			throw new ModelException("o ano de publicação deve estar entre 1994 a 2024");
		}
		
	}

	public static void validarTitulo(String t) throws ModelException {
		if (t == null) {
			throw new ModelException("o titulo deve ser preenchido");
		}
		int tamanho = t.length();

		if (tamanho < 1 || tamanho > 50)
			throw new ModelException("o titulo deve conter até 50 caracteres");

		for (int i = 0; i < tamanho; i++) {
			char c = t.charAt(i);

			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c) && !Character.isDigit(c) && c != ':'
					&& c != '-')
				throw new ModelException("Caracter de titulo invalido: " + c);

		}
	}

	public String toString() {
		return "Titulo: " + this.titulo + ", " + "Ano de publicação: " + this.anoPublicacao + ", "
				+ "Mês de publicação: " + this.mesPublicacao + ", " + "Localização: " + this.localizacao;
	}

}
