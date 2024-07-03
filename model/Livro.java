package model;

import java.io.Serializable;

public class Livro extends Obra implements Serializable{

	private String isbn;
	private String autor;

	public Livro(String t, int a, int m, Localizacao l, String i, String at) throws ModelException {
		super(t, a, m, l);
		this.setIsbn(i);
		this.setAutor(at);
	}

	public String getAutor() {
		return this.autor;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setAutor(String at) throws ModelException {
		validarAutor(at);
		this.autor = at;
	}

	public void setIsbn(String i) throws ModelException {
		validarIsbn(i);
		this.isbn = i;
	}

	public static void validarAutor(String at) throws ModelException {
		if (at == null) {
			throw new ModelException("o nome do autor deve ser preenchido");
		}
		int tamanho = at.length();

		if (tamanho > 40) {
			throw new ModelException("o nome do autor deve conter até 40 caracteres");
		}

		for (int i = 0; i < tamanho; i++) {
			char c = at.charAt(i);

			if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new ModelException("nome do autor deve conter apenas letras");
		}

	}

	public static void validarIsbn(String i) throws ModelException {
		if (i == null)
			throw new ModelException("o isbn deve ser preenchido");

		int tamanho = i.length();

		if (tamanho != 17)
			throw new ModelException("o isbn deve conter 17 caracteres");

		for (int pos = 0; pos < tamanho; pos++) {
			char c = i.charAt(pos);

			switch (pos) {
			case 3:
			case 6:
			case 10:
			case 15:
				if (c != '-')
					throw new ModelException("Caracter em isbn digitado invalido: " + c + ", " + "deve conter '-' ");
				break;
			default:
				if (!Character.isDigit(c))
					throw new ModelException("o isbn deve conter apenas digitos de 0 a 9");
			}
		}
	}

	public String toString() {
		return "Titulo: " + this.getTitulo() + ", " + "Ano de publicação: " + this.getAnoPublicacao() + ", "
				+ "Mês de publicação: " + this.getMesPublicacao() + ", " + "Localização: " + this.getLocalizacao()
				+ ", " + "ISBN: " + this.getIsbn() + ", " + "Autor: " + this.getAutor();
	}

}
