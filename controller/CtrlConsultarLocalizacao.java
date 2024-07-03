package controller;

import model.Localizacao;
import model.dao.DaoLocalizacao;
import viewer.JanelaConsultarLocalizacoes;

public class CtrlConsultarLocalizacao extends CtrlAbstrato {
	
	private JanelaConsultarLocalizacoes janela;
	private CtrlAdicionarLocalizacao ctrlAdicionarLocalizacao;
	private CtrlExcluirLocalizacao ctrlExcluirLocalizacao;
	private CtrlAlterarLocalizacao ctrlAlterarLocalizacao;
	
	public CtrlConsultarLocalizacao(CtrlPrograma ctrl) {
		super(ctrl);
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		DaoLocalizacao dao = new DaoLocalizacao();
		Localizacao[] lista = dao.obterLista();
		this.janela = new JanelaConsultarLocalizacoes(lista,this);

	}

	@Override
	public void encerrar() {
		// TODO Auto-generated method stub
		this.janela.fechar();
		CtrlPrograma ctrl = (CtrlPrograma)getCtrlPai();

	}
	
	public void iniciarCtrlAdicionarLocalizacao() {
		if(this.ctrlAdicionarLocalizacao == null)
			this.ctrlAdicionarLocalizacao = new CtrlAdicionarLocalizacao(this);
	}
	
	public void informarEncerramentoDeCtrlAdicionarLocalizacao() {
		DaoLocalizacao dao = new DaoLocalizacao();
		Localizacao[] lista = dao.obterLista();
		this.janela.atualizarDados(lista);
		this.ctrlAdicionarLocalizacao = null;
		
	}
	
	public void iniciarCtrlExcluirLocalizacao(Localizacao l) {
		if(this.ctrlExcluirLocalizacao == null)
			this.ctrlExcluirLocalizacao = new CtrlExcluirLocalizacao(this,l);
	}
	
	public void informarEncerramentoDeCtrlExcluirLocalizacao() {
		DaoLocalizacao dao = new DaoLocalizacao();
		Localizacao[] lista = dao.obterLista();
		this.janela.atualizarDados(lista);
		this.ctrlExcluirLocalizacao = null;
		
	}
	
	public void iniciarCtrlAlterarLocalizacao(Localizacao l) {
		if(this.ctrlAlterarLocalizacao == null)
			this.ctrlAlterarLocalizacao = new CtrlAlterarLocalizacao(this,l);
	}
	
	public void informarEncerramentoDeCtrlAlterarLocalizacao() {
		DaoLocalizacao dao = new DaoLocalizacao();
		Localizacao[] lista = dao.obterLista();
		this.janela.atualizarDados(lista);
		this.ctrlAlterarLocalizacao = null;
		
	}
	

}
