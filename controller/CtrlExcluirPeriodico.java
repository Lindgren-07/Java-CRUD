package controller;

import model.Periodico;
import model.dao.DaoPeriodico;
import viewer.JanelaExcluirPeriodico;

public class CtrlExcluirPeriodico extends CtrlAbstrato {
	
	private JanelaExcluirPeriodico janela;
	private Periodico periodico;
	
	public CtrlExcluirPeriodico(CtrlConsultarPeriodico ctrl, Periodico p) {
		super(ctrl);
		this.periodico = p;
		this.janela = new JanelaExcluirPeriodico(this,p);
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub

	}
	
	public void excluirPeriodico() {
		DaoPeriodico dao = new DaoPeriodico();
		boolean remover = dao.remover(periodico);
		if(!remover) {
			this.janela.notificar("erro ao remover objeto");
			return;
		}
		this.janela.notificar("objeto removido");
		this.encerrar();
	}

	@Override
	public void encerrar() {
		// TODO Auto-generated method stub
		this.janela.fechar();
		CtrlConsultarPeriodico ctrl = (CtrlConsultarPeriodico)getCtrlPai();
		ctrl.informarEncerramentoDeCtrlExcluirPeriodico();

	}

}
