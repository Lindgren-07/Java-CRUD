package controller;

import model.Localizacao;
import model.ModelException;
import model.Periodico;
import viewer.JanelaPeriodico;

public class CtrlAlterarPeriodico extends CtrlAbstrato {
	
	private JanelaPeriodico janela;
	private Periodico periodico;
	
	public CtrlAlterarPeriodico(CtrlConsultarPeriodico ctrl, Periodico p) {
		super(ctrl);
		this.periodico = p;
		this.janela.preencherDados(p.getTitulo(), p.getAnoPublicacao(), p.getMesPublicacao(), p.getLocalizacao(), p.getNumero(),p.getSubTitulo(),p.getNumeroArtigo());
		
	}

	@Override
	public void iniciar() {
		// TODO Auto-generated method stub
		this.janela = new JanelaPeriodico(this);

	}
	
	public void alterarPeriodico(String titulo, int ano, int mes,Localizacao localizacao, int numero,String subTitulo,int artigo) {
		try {
			this.periodico.setTitulo(titulo);
			this.periodico.setAnoPublicacao(ano);
			this.periodico.setMesPublicacao(mes);
			this.periodico.setLocalizacao(localizacao);
			this.periodico.setNumero(numero);
			this.periodico.setSubTitulo(subTitulo);
			this.periodico.setNumeroArtigo(artigo);
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
		CtrlConsultarPeriodico ctrl = (CtrlConsultarPeriodico)getCtrlPai();
		ctrl.informarEncerramentoDeCtrlAlterarPeriodico();

	}

}
