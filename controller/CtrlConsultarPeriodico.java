package controller;

import model.Periodico;
import model.dao.DaoPeriodico;
import viewer.JanelaConsultarPeriodicos;

public class CtrlConsultarPeriodico extends CtrlAbstrato {

	private JanelaConsultarPeriodicos janela;
	private CtrlAdicionarPeriodico ctrlAdicionarPeriodico;
	private CtrlExcluirPeriodico ctrlExcluirPeriodico;
	private CtrlAlterarPeriodico ctrlAlterarPeriodico;

	public CtrlConsultarPeriodico(CtrlPrograma ctrl) {
		super(ctrl);
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		DaoPeriodico dao = new DaoPeriodico();
		Periodico[] lista = dao.obterLista();
		this.janela = new JanelaConsultarPeriodicos(lista, this);

	}

	@Override
	public void encerrar() {
		// TODO Auto-generated method stub
		this.janela.fechar();
		CtrlPrograma ctrl = (CtrlPrograma) getCtrlPai();
		ctrl.informarEncerramentoDeCtrlConsultarPeriodico();

	}

	public void iniciarCtrlAdicionarPeriodico() {
		if (this.ctrlAdicionarPeriodico == null)
			this.ctrlAdicionarPeriodico = new CtrlAdicionarPeriodico(this);

	}

	public void informarEncerramentoDeCtrlAdicionarPeriodico() {
		DaoPeriodico dao = new DaoPeriodico();
		Periodico[] lista = dao.obterLista();
		this.janela.atualizarDados(lista);
		this.ctrlAdicionarPeriodico = null;

	}

	public void iniciarCtrlExcluirPeriodico(Periodico p) {
		if (this.ctrlExcluirPeriodico == null)
			this.ctrlExcluirPeriodico = new CtrlExcluirPeriodico(this,p);

	}
	
	public void informarEncerramentoDeCtrlExcluirPeriodico() {
		DaoPeriodico dao = new DaoPeriodico();
		Periodico[] lista = dao.obterLista();
		this.janela.atualizarDados(lista);
		this.ctrlExcluirPeriodico = null;

	}
	
	public void iniciarCtrlAlterarPeriodico(Periodico p) {
		if (this.ctrlAlterarPeriodico == null)
			this.ctrlAlterarPeriodico = new CtrlAlterarPeriodico(this,p);

	}
	
	public void informarEncerramentoDeCtrlAlterarPeriodico() {
		DaoPeriodico dao = new DaoPeriodico();
		Periodico[] lista = dao.obterLista();
		this.janela.atualizarDados(lista);
		this.ctrlAlterarPeriodico = null;

	}

}
