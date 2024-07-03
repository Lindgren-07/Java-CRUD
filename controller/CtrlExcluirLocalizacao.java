package controller;

import model.Localizacao;
import model.dao.DaoLocalizacao;
import viewer.JanelaExcluirLocalizacao;

public class CtrlExcluirLocalizacao extends CtrlAbstrato {
	
	private JanelaExcluirLocalizacao janela;
	private Localizacao localizacao;
	
	public CtrlExcluirLocalizacao(CtrlConsultarLocalizacao ctrl,Localizacao l) {
		super(ctrl);
		this.localizacao = l;
		this.janela = new JanelaExcluirLocalizacao(this,l);
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub

	}
	
	public void excluirLocalizacao() {
		DaoLocalizacao dao = new DaoLocalizacao();
		boolean remover = dao.remover(localizacao);
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
		CtrlConsultarLocalizacao ctrl = (CtrlConsultarLocalizacao)getCtrlPai();
		ctrl.informarEncerramentoDeCtrlExcluirLocalizacao();
		

	}

}
