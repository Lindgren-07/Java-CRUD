package controller;

import model.Livro;
import model.Localizacao;
import model.ModelException;
import viewer.JanelaLivro;

public class CtrlAlterarLivro extends CtrlAbstrato {
	
	private JanelaLivro janela;
	private Livro livro;
	
	public CtrlAlterarLivro(CtrlConsultarLivro c, Livro l) {
		super(c);
		this.livro = l;
		this.janela.preencherDados(l.getTitulo(),l.getAnoPublicacao(),l.getMesPublicacao(),l.getLocalizacao(),l.getIsbn(),l.getAutor());
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		this.janela = new JanelaLivro(this);

	}
	
	public void alterarLivro(String titulo, int ano, int mes, Localizacao localizacao, String isbn, String autor) {
		try {
			this.livro.setTitulo(titulo);
			this.livro.setAnoPublicacao(ano);
			this.livro.setMesPublicacao(mes);
			this.livro.setLocalizacao(localizacao);
			this.livro.setIsbn(isbn);
			this.livro.setAutor(autor);
			this.janela.notificar("Objeto alterado com sucesso");
			this.encerrar();
		} catch (ModelException me) {
			// TODO Auto-generated catch block
			this.janela.notificar(me.getMessage());
			return;
		}
	}

	@Override
	public void encerrar() {
		// TODO Auto-generated method stub
		this.janela.fechar();
		CtrlConsultarLivro ctrl = (CtrlConsultarLivro)getCtrlPai();
		ctrl.informarEncerramentoDeCtrlAlterarLivro();
		

	}

}
