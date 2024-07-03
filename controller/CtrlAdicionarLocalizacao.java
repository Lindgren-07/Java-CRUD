package controller;

import javax.swing.JOptionPane;

import model.Localizacao;
import model.ModelException;
import model.dao.DaoLocalizacao;
import viewer.JanelaLocalizacao;

public class CtrlAdicionarLocalizacao extends CtrlAbstrato {
	
	private JanelaLocalizacao janela;
	
	public CtrlAdicionarLocalizacao(CtrlConsultarLocalizacao ctrl) {
		super(ctrl);
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		this.janela = new JanelaLocalizacao(this);

	}
	
	public void adicionarLocalizacao(int corredor, int estante, int prateleira) {
		try {
			Localizacao l = new Localizacao(corredor, estante, prateleira);
			DaoLocalizacao dao = new DaoLocalizacao();
			dao.adicionar(l);
			this.janela.notificar("Objeto criado: " + l);
			this.encerrar();

		} catch (ModelException me) {
			this.janela.notificar(me.getMessage());
			return;
		}
	}

	@Override
	public void encerrar() {
		// TODO Auto-generated method stub
		this.janela.fechar();
		CtrlConsultarLocalizacao ctrl = (CtrlConsultarLocalizacao)getCtrlPai();
		ctrl.informarEncerramentoDeCtrlAdicionarLocalizacao();
		

	}

}
