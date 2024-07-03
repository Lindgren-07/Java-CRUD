package controller;

import model.Livro;
import model.dao.DaoLivro;
import viewer.JanelaExcluirLivro;

public class CtrlExcluirLivro extends CtrlAbstrato {
	
	private JanelaExcluirLivro janela;
	private Livro livro;
	
	public CtrlExcluirLivro(CtrlConsultarLivro c, Livro l) {
		super(c);
		this.livro = l;
		this.janela = new JanelaExcluirLivro(this,l);
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub

	}
	
	public void excluirLivro() {
		DaoLivro dao = new DaoLivro();
		boolean remover = dao.remover(livro);
		if(!remover) {
			this.janela.notificar("erro ao tentar excluir livro");
			return;
		}
		this.janela.notificar("livro excluido");
		this.encerrar();
	}

	@Override
	public void encerrar() {
		// TODO Auto-generated method stub
		this.janela.fechar();
		CtrlConsultarLivro ctrl = (CtrlConsultarLivro)getCtrlPai();
		ctrl.informarEncerramentoDeCtrlExcluirLivro();
		

	}

}
