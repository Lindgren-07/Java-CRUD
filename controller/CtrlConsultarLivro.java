package controller;

import model.Livro;
import model.dao.DaoLivro;
import viewer.JanelaConsultarLivros;

public class CtrlConsultarLivro extends CtrlAbstrato {
	
	private JanelaConsultarLivros janela;
	private CtrlAdicionarLivro ctrlAdicionarLivro;
	private CtrlExcluirLivro ctrlExcluirLivro;
	private CtrlAlterarLivro ctrlAlterarLivro;
	
	public CtrlConsultarLivro(CtrlPrograma c) {
		super(c);
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		DaoLivro dao = new DaoLivro();
		Livro[] lista = dao.obterLista();
		this.janela = new JanelaConsultarLivros(lista,this);

	}

	@Override
	public void encerrar() {
		// TODO Auto-generated method stub
		this.janela.fechar();
		CtrlPrograma ctrl = (CtrlPrograma)getCtrlPai();
		ctrl.informarEncerramentoDeCtrlConsultarLivro();

	}
	
	public void iniciarCtrlAdicionarLivro() {
		if(this.ctrlAdicionarLivro == null)
			this.ctrlAdicionarLivro = new CtrlAdicionarLivro(this);
	}
	
	public void informarEncerramentoDeCtrlAdicionarLivro() {
		DaoLivro dao = new DaoLivro();
		Livro[] lista = dao.obterLista();
		this.janela.atualizarDados(lista);
		this.ctrlAdicionarLivro = null;
	}
	
	public void iniciarCtrlExcluirLivro(Livro l) {
		if(this.ctrlExcluirLivro == null)
			this.ctrlExcluirLivro = new CtrlExcluirLivro(this,l);
	}
	
	public void informarEncerramentoDeCtrlExcluirLivro() {
		DaoLivro dao = new DaoLivro();
		Livro[] lista = dao.obterLista();
		this.janela.atualizarDados(lista);
		this.ctrlExcluirLivro = null;
	}
	
	public void iniciarCtrlAlterarLivro(Livro l) {
		if(this.ctrlAlterarLivro == null)
			this.ctrlAlterarLivro = new CtrlAlterarLivro(this,l);
	}
	
	public void informarEncerramentoDeCtrlAlterarLivro() {
		DaoLivro dao = new DaoLivro();
		Livro[] lista = dao.obterLista();
		this.janela.atualizarDados(lista);
		this.ctrlAlterarLivro = null;
	}
	

}
