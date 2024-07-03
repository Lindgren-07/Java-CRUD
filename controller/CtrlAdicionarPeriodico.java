package controller;

import javax.swing.JOptionPane;

import model.Localizacao;
import model.ModelException;
import model.Periodico;
import model.dao.DaoPeriodico;
import viewer.JanelaPeriodico;

public class CtrlAdicionarPeriodico extends CtrlAbstrato {
	
	private JanelaPeriodico janela;
	
	public CtrlAdicionarPeriodico(CtrlConsultarPeriodico ctrl) {
		super(ctrl);
	}
	
	

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		this.janela = new JanelaPeriodico(this);

	}
	
	public void adicionarPeriodico(String titulo, int ano, int mes,Localizacao localizacao, int numero,String subTitulo,int artigo) {
		try {
			Periodico p = new Periodico(titulo, ano, mes, localizacao, numero, subTitulo, artigo);
			DaoPeriodico dao = new DaoPeriodico();
			dao.adicionar(p);
			this.janela.notificar("Objeto criado: " + p);
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
		CtrlConsultarPeriodico ctrl = (CtrlConsultarPeriodico)getCtrlPai();
		ctrl.informarEncerramentoDeCtrlAdicionarPeriodico();

	}

}
