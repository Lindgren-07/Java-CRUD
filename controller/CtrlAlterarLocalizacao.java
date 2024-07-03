package controller;

import model.Localizacao;
import model.ModelException;
import viewer.JanelaLocalizacao;

public class CtrlAlterarLocalizacao extends CtrlAbstrato {
	
	private JanelaLocalizacao janela;
	private Localizacao localizacao;
	
	public CtrlAlterarLocalizacao(CtrlConsultarLocalizacao ctrl, Localizacao l) {
		super(ctrl);
		this.localizacao = l;
		this.janela.preencherDados(l.getNumCorredor(), l.getNumEstante(), l.getNumPrateleira());
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		this.janela = new JanelaLocalizacao(this);

	}
	
	public void alterarLocalizacao(int corredor, int estante, int prateleira) {
		try {
			this.localizacao.setNumCorredor(corredor);
			this.localizacao.setNumEstante(estante);
			this.localizacao.setNumPrateleira(prateleira);
			this.janela.notificar("alterado com sucesso");
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
		CtrlConsultarLocalizacao ctrl = (CtrlConsultarLocalizacao)getCtrlPai();
		ctrl.informarEncerramentoDeCtrlAlterarLocalizacao();
		

	}

}
